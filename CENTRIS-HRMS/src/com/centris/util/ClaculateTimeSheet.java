package com.centris.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import com.centris.DAO.DBService;
import com.centris.VO.EmployeeMinInfo;
import com.centris.VO.ShiftDetails;
import com.centris.util.SQLUtils.ETL_AttendanceProcessing;

public class ClaculateTimeSheet extends DBService {

	Connection connect = null;

	public ClaculateTimeSheet() {
		// TODO Auto-generated constructor stub
	}

	public void claculateTimeSheetLocationAndShiftWise(
			ArrayList<java.sql.Date> allDates, String ETL_CODE) {

		Connection datbaseConnection = null;

		Savepoint ETL_SAVEPOINT = null;

		try {

			datbaseConnection = getConnection();

			datbaseConnection.setAutoCommit(false);
			ETL_SAVEPOINT = datbaseConnection.setSavepoint("ETL");

			for (Iterator date_iterator = allDates.iterator(); date_iterator
					.hasNext();) {

			
				java.sql.Date date = (java.sql.Date) date_iterator.next();
				System.out.println(" DATE : --************* "+date);

				Thread.sleep(3000);

				checkOlderdaysTimesheet(date, ETL_CODE, datbaseConnection);

				boolean isConti = checkForPartiCularDay(date, ETL_CODE,
						datbaseConnection);

				if (isConti) {
					boolean isValid = prerequisitesForCalculations(date,
							ETL_CODE, datbaseConnection);

					if (isValid) {

						calculateTimeSheet(date, ETL_CODE, datbaseConnection);
						updatingTimeSheetAudit(date, "COMPLETED", "COMPLETED",
								"Y", ETL_CODE, datbaseConnection);

					} else {

						updatingTimeSheetAudit(date, "NOT COMPLETED",
								"NOT COMPLETED", "N", ETL_CODE,
								datbaseConnection);
					}// else

				}// if(isValid)

			}

			datbaseConnection.commit();
			datbaseConnection.close();
		} catch (Exception e) {
			try {
				datbaseConnection.rollback(ETL_SAVEPOINT);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public void calculateTimeSheet(java.sql.Date date, String ETL_CODE,
			Connection datbaseConnection) {

		try {

			ArrayList<EmployeeMinInfo> allEmployees = getTheAllEmployees(datbaseConnection);

			// normal employees -----------
			for (EmployeeMinInfo employeeMinInfo : allEmployees) {

				ArrayList<Time> allLogs = new ArrayList<Time>();
                System.out.println(employeeMinInfo.getBioid());
				allLogs.clear();
				allLogs = getTheAllLogsFromParticularDay(
						employeeMinInfo.getBioid(), date, datbaseConnection);

				updateTheAttedenceAndTimeSheet(allLogs, date, employeeMinInfo,
						ETL_CODE, datbaseConnection);

			}
			// normal employees -----------
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<EmployeeMinInfo> getTheAllEmployees(
			Connection datbaseConnection) {

		Connection con;
		PreparedStatement statement = null;
		ArrayList<EmployeeMinInfo> allEmployees = new ArrayList<EmployeeMinInfo>();
		try {
			con = datbaseConnection;

			allEmployees.clear();

			statement = con
					.prepareStatement(ETL_AttendanceProcessing.GET_ALL_EMPLOYEES);
			statement.setString(1, "Present");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				EmployeeMinInfo emp = new EmployeeMinInfo();

				emp.setEmpid(rs.getString("EMPID"));
				emp.setEname(rs.getString("EMPNAME"));
				emp.setProjectCode(rs.getString("ProjectCode"));
				emp.setManagerCode(rs.getString("ManagerCode"));
				emp.setBioid(rs.getString("bioid"));

				allEmployees.add(emp);
			}
			statement.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
		}
		return allEmployees;
	}

	public ArrayList<Time> getTheAllLogsFromParticularDay(String empid,
			java.sql.Date date, Connection datbaseConnection) {

		Connection con;
		PreparedStatement statement = null;
		ArrayList<Time> allLogs = new ArrayList<Time>();

		try {
			con = datbaseConnection;

			allLogs.clear();

			statement = con
					.prepareStatement(ETL_AttendanceProcessing.GET_PUCNCH_TIME);
			statement.setString(1, empid);
			statement.setDate(2, date);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				allLogs.add(rs.getTime("AI_EMP_TIME"));
			}
			statement.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
		}
		return allLogs;
	}

	public void updateTheAttedenceAndTimeSheet(ArrayList<Time> allLogs,
			java.sql.Date date, EmployeeMinInfo employeeMinInfo,
			String ETL_CODE, Connection datbaseConnection) {

		Connection con;
		PreparedStatement attedence_statement = null;
		PreparedStatement check_statement = null;
		int count = 0;
		int dateCount = 0;
		System.out.println(employeeMinInfo.getBioid()+" ---- "+date);
		try {
			con = datbaseConnection;
			check_statement = con
					.prepareStatement(ETL_AttendanceProcessing.CHECK_POSTED_OR_NOT);
			check_statement.setDate(1, date);

			ResultSet rst = check_statement.executeQuery();
			while (rst.next()) {
				dateCount = rst.getInt(1);
			}
			if (dateCount == 0) {
				CallableStatement cst = datbaseConnection
						.prepareCall("{call attedencePosting(?)}");
				cst.setDate(1, date);
				cst.executeUpdate();
			}

			attedence_statement = con
					.prepareStatement(ETL_AttendanceProcessing.UPDATE_ATTENDANCE);

			/*if (allLogs == null || allLogs.size() == 0) {
				String status = checkForHolidayOrWeeklyOff(date,
						employeeMinInfo.getEmpid(),
						employeeMinInfo.getDeptid(), datbaseConnection);
				attedence_statement.setString(1, status);
				attedence_statement.setString(2, "00:00:00");
				attedence_statement.setString(3, "00:00:00");
				attedence_statement.setString(4, "00:00:00");
			} */
			
			if (allLogs != null && allLogs.size() != 0) {
				HashMap<String, String> timings = getALLTimings(allLogs,
						datbaseConnection);
				String isProper = timings.get("ISPROPER");
				if (isProper.equalsIgnoreCase("NO")) {
					updateIncorrectPunchedEmployees(employeeMinInfo.getEmpid(),
							date, timings.get("REASON"), ETL_CODE,
							datbaseConnection);
				}
				attedence_statement.setString(1, "present");
				attedence_statement.setString(2, allLogs.get(0).toString());
				attedence_statement.setString(3, allLogs
						.get(allLogs.size() - 1).toString());
				attedence_statement.setString(4, timings.get("TOT"));
				attedence_statement.setString(5, "Office");
				attedence_statement.setString(6, "Y");
				attedence_statement.setString(7, "Y");
				attedence_statement.setString(8, HelperClass.getCurrentSqlDate()
						+ " " + HelperClass.getCurrentTime());
				attedence_statement.setString(9, HelperClass.getCurrentSqlDate()
						+ " " + HelperClass.getCurrentTime());
				attedence_statement.setString(10, ETL_CODE);
				attedence_statement.setString(11, employeeMinInfo.getProjectCode());
				attedence_statement.setString(12, employeeMinInfo.getManagerCode());
				attedence_statement.setString(13, "AST1");
				attedence_statement.setString(14, employeeMinInfo.getEmpid());
				attedence_statement.setDate(15, date);
				
				System.out.println("updating attendance table :::: "+attedence_statement.toString());

				count = attedence_statement.executeUpdate();
				attedence_statement.close();
			}

			
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
		}
	}

	public HashMap<String, String> getALLTimings(ArrayList<Time> allLogs,
			Connection datbaseConnection) throws Exception {

		HashMap<String, String> timings = new HashMap<String, String>();
		timings.clear();
		Time first_punch = allLogs.get(0);
		Time last_punch = allLogs.get(allLogs.size() - 1);

		if (allLogs.size() == 1) {
			timings.put("OT_BS", "00:00:00");
			timings.put("LATE", "00:00:00");
			timings.put("EARLY", "00:00:00");
			timings.put("ISEARLY", "0");
			timings.put("ISLATE", "0");
			timings.put("OT_AS", "00:00:00");
			timings.put("TOTOT", "00:00:00");
			timings.put("TOT", "00:00:00");
			timings.put("WORKED", "00:00:00");
			timings.put("OT_ASP", "NO");
			timings.put("ISPROPER", "NO");
			timings.put("REASON", " Single Punch");
			return timings;
		}
		String total = HelperClass.getTimeDifferenceinTimeFormat(
				first_punch.toString(), last_punch.toString());
		timings.put("TOT", total);

		if (allLogs.size() % 2 == 1) {
			timings.put("ISPROPER", "NO");
			timings.put("REASON", " ODD Punches");
			timings.put("OT_ASP", "NO");
		} else {
			timings.put("ISPROPER", "YES");
		}
		String worked = calculateWorkedHours(allLogs);
		timings.put("WORKED", worked);

		return timings;
	}

	public HashMap<String, String> getTota(ShiftDetails shiftDetails,
			ArrayList<Time> allLogs) {

		HashMap<String, String> timings1 = new HashMap<String, String>();

		timings1.clear();
		Time shift_end = shiftDetails.getAI_SHIFT_ETOG();

		Time shift_end1 = shiftDetails.getAI_SHIFT_END_TIME();
		Time last_punch = allLogs.get(allLogs.size() - 1);

		if (shift_end1.compareTo(last_punch) < 0) {
			String OT_AS = HelperClass.getTimeDifferenceinTimeFormat(
					shift_end1.toString(), last_punch.toString());
			timings1.put("OT_AS", OT_AS);
			timings1.put("EARLY", "00:00:00");
		}
		if (shift_end.compareTo(last_punch) > 0) {
			String early = HelperClass.getTimeDifferenceinTimeFormat(
					last_punch.toString(), shift_end.toString());

			timings1.put("OT_AS", "00:00:00");
			timings1.put("EARLY", early);
		}
		return timings1;
	}

	public String calculateWorkedHours(ArrayList<Time> allLogs) {

		String[] total = new String[allLogs.size() / 2];
		for (int i = 0, j = 0; i < allLogs.size() / 2; i++) {
			String first = allLogs.get(j++).toString();
			String second = allLogs.get(j++).toString();
			total[i] = HelperClass.getTimeDifferenceinTimeFormat(first, second);
		}
		String worked = HelperClass.addTimeArray(total);
		return worked;
	}

	public void updatingTimeSheetAudit(java.sql.Date date, String status,
			String reason, String isCompleted, String ETL_CODE,
			Connection datbaseConnection) {

		Connection con;
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		int count = 0;

		try {
			con = datbaseConnection;

			statement = con
					.prepareStatement(ETL_AttendanceProcessing.CHECK_TIMESHEET_AUDIT);
			statement.setDate(1, date);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			statement.close();
			if (count == 0) {
				statement2 = con
						.prepareStatement(ETL_AttendanceProcessing.INSERT_TIMESHEET_AUDIT);
				statement2.setDate(1, date);
				statement2.setString(2, status);
				statement2.setString(3, reason);
				statement2.setString(4, isCompleted);
				statement2.setString(5, ETL_CODE);
			} else {
				statement2 = con
						.prepareStatement(ETL_AttendanceProcessing.UPDATE_TIMESHEET_AUDIT);
				statement2.setString(1, status);
				statement2.setString(2, reason);
				statement2.setString(3, isCompleted);
				statement2.setString(4, ETL_CODE);
				statement2.setDate(5, date);
			}
			count = statement2.executeUpdate();
			statement2.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
		}
	}

	public boolean prerequisitesForCalculations(java.sql.Date date,
			String ETL_CODE, Connection datbaseConnection) {

		ArrayList<String> result = new ArrayList<String>();
		result.clear();
		Connection con;
		con = datbaseConnection;
		int cnt = 0;
		int cnt2 = 0;
		try {

			PreparedStatement psmt2 = con
					.prepareStatement(ETL_AttendanceProcessing.LOG_DETAILS_COUNT);

			psmt2.setString(1, ETL_CODE);
			psmt2.setDate(2, date);

			ResultSet rs2 = psmt2.executeQuery();
			while (rs2.next()) {
				cnt = rs2.getInt("cnt");
			}
			psmt2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (cnt == 0) {
			try {

				PreparedStatement psmt3 = con
						.prepareStatement(ETL_AttendanceProcessing.LOG_DETAILS_COUNT_DATE);
				psmt3.setString(1, ETL_CODE);
				psmt3.setDate(2, date);
				ResultSet rs3 = psmt3.executeQuery();
				while (rs3.next()) {
					cnt2 = rs3.getInt("cnt");
				}
				psmt3.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (cnt2 == 0) {
				return false;
			} else {
				return true;
			}
		} else
			return true;
	}

	public boolean checkForPartiCularDay(java.sql.Date date, String ETL_CODE,
			Connection datbaseConnection) {

		Connection con = null;
		String isCompleted = null;

		try {
			con = datbaseConnection;
			PreparedStatement psmt2 = con
					.prepareStatement(ETL_AttendanceProcessing.ATT_PROCESSOD_OR_NOT);
			psmt2.setDate(1, date);
			ResultSet rs2 = psmt2.executeQuery();
			while (rs2.next()) {
				isCompleted = rs2.getString(1);
			}
			psmt2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (isCompleted == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkForYesterday(java.sql.Date date,
			Connection datbaseConnection) {

		Connection con = null;
		String isCompleted = null;

		try {
			con = datbaseConnection;
			PreparedStatement psmt2 = con
					.prepareStatement(ETL_AttendanceProcessing.CHECK_TIMESHEET_COMPLETED);
			psmt2.setDate(1, date);
			ResultSet rs2 = psmt2.executeQuery();
			while (rs2.next()) {
				isCompleted = rs2.getString(1);
			}

			psmt2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (isCompleted == null) {
			return true;
		}
		if (isCompleted.equalsIgnoreCase("N")) {
			return false;
		}
		return true;
	}

	public void checkOlderdaysTimesheet(java.sql.Date date, String ETL_CODE,
			Connection datbaseConnection) {

		boolean chk = checkForYesterday(HelperClass.getYesterDayDate(date),
				datbaseConnection);

		if (!chk) {

			java.sql.Date ydate = HelperClass.getYesterDayDate(date);
			checkOlderdaysTimesheet(ydate, ETL_CODE, datbaseConnection);
			boolean isValid = prerequisitesForCalculations(date, ETL_CODE,
					datbaseConnection);
			if (isValid) {

				calculateTimeSheet(ydate, ETL_CODE, datbaseConnection);
				updatingTimeSheetAudit(ydate, "COMPLETED", "COMPLETED", "Y",
						ETL_CODE, datbaseConnection);
			}
		}
		if (chk) {
			return;
		}
	}

	public String checkisShiftisDayOrNight(ShiftDetails shiftDetails) {

		Time start = shiftDetails.getAI_SHIFT_START_TIME();
		Time end = shiftDetails.getAI_SHIFT_END_TIME();
		String result = "";
		try {
			if (start.compareTo(end) > 0) {
				result = "night";
			} else {
				result = "day";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void updateIncorrectPunchedEmployees(String empid,
			java.sql.Date date, String reason, String ETL_CODE,
			Connection datbaseConnection) {
		try {

			Connection con;
			PreparedStatement statement = null;
			con = datbaseConnection;

			statement = con
					.prepareStatement(ETL_AttendanceProcessing.INCORRECT_PUNCH);

			statement.setDate(1, date);
			statement.setString(2, empid);
			statement.setString(3, reason);
			statement.setString(4, ETL_CODE);
			int co = statement.executeUpdate();
			statement.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}

	public String checkForHolidayOrWeeklyOff(java.sql.Date date, String empid,
			String deptid, Connection datbaseConnection) {

		Connection con = null;

		String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH)
				.format(date);

		try {
			con = datbaseConnection;
			PreparedStatement psmt2 = con
					.prepareStatement("select count(*) from hrms_weekoffmaster where "
							+ dayOfWeek + "='1' and EMPID=?");
			psmt2.setString(1, empid + "");
			ResultSet rs2 = psmt2.executeQuery();
			while (rs2.next()) {

				int k = rs2.getInt(1);

				if (k == 1) {
					return "weeklyoff";
				} else {
					PreparedStatement psmt3 = con
							.prepareStatement(ETL_AttendanceProcessing.CHECK_FOR_HOLIDAY);
					psmt3.setString(1, date.toString().trim());
					psmt3.setString(2, deptid);
					psmt3.setString(3, date.toString().substring(0, 4));
					ResultSet rs3 = psmt3.executeQuery();
					while (rs3.next()) {
						int k2 = rs3.getInt(1);
						if (k2 == 1) {
							return "holiday";
						} else {
							int LeaveStatus = checkForLeave(empid,
									datbaseConnection, date);
							if (LeaveStatus == 1) {
								return "leave";
							} else {
								return "absent";
							}
						}
					}
					psmt3.close();
				}
			}
			psmt2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "absent";
	}

	public static int checkForLeave(String empid, Connection datbaseConnection,
			java.sql.Date date) {
		int status = 0;
		Connection con = null;
		List<String> allDates = new ArrayList<String>();

		try {
			con = datbaseConnection;
			PreparedStatement psmt2 = con
					.prepareStatement(ETL_AttendanceProcessing.CHECK_FOR_LEAVE);
			psmt2.setString(1, empid);
			ResultSet rs2 = psmt2.executeQuery();

			while (rs2.next()) {
				allDates.addAll(HelperClass.getDateListBetweenDates(
						rs2.getString("ApprovedStartDate"),
						rs2.getString("ApprovedEndDate")));
			}
			if (allDates.contains(date.toString().trim())) {
				status = 1;
			} else {
				status = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}
}