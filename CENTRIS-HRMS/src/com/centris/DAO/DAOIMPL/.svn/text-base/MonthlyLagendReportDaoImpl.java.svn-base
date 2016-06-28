package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.DBService;

import com.centris.VO.MonthlyLagendReportVo;
import com.centris.form.MonthlyLagendReportForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class MonthlyLagendReportDaoImpl extends DBService {

	private static Logger logger = Logger
			.getLogger(MonthlyLagendReportDaoImpl.class);

	public synchronized ArrayList<MonthlyLagendReportVo> getLocationbyGroup(
			String groupid) {

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportDaoImpl:getLocationbyGroup Starting");
		Connection conn = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<MonthlyLagendReportVo> shiftlist = new ArrayList<MonthlyLagendReportVo>();

		try {
			conn = getConnection();

			if (groupid.equalsIgnoreCase("all")) {

				pstmt = conn
						.prepareStatement(SQLutilConstants.GET_ALL_LOCATIONS_FOR_MONTHLYREPORT);

			} else {

				pstmt = conn
						.prepareStatement(SQLutilConstants.GET_LOCATION_FOR_MONTHLYREPORT);
				pstmt.setString(1, groupid);

			}

			rs = pstmt.executeQuery();

			while (rs.next()) {

				MonthlyLagendReportVo shiftvo = new MonthlyLagendReportVo();

				shiftvo.setLocationid(rs.getString("LocationCode"));
				shiftvo.setLocationname(rs.getString("Location"));

				shiftlist.add(shiftvo);
			}

		} catch (SQLException sqle) {

			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e);
		} finally {

			try {

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}

			} catch (SQLException sqle) {

				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e) {

				e.printStackTrace();
				logger.error(e);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportDaoImpl:getLocationbyGroup Ending");
		return shiftlist;

	}

	public synchronized ArrayList<MonthlyLagendReportVo> getShiftBasedLocation(
			String locId, String groupid) {

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportDaoImpl:getShiftBasedLocation Starting");
		ArrayList<MonthlyLagendReportVo> shiftlist = new ArrayList<MonthlyLagendReportVo>();
		Connection conn = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();

			if (locId.equalsIgnoreCase("all")) {

				pstmt = conn
						.prepareStatement(SQLutilConstants.GET_ALL_SHIFT_FOR_MONTHLYREPORT);
				pstmt.setString(1, groupid);

			} else {
				pstmt = conn
						.prepareStatement(SQLutilConstants.GET_SHIFT_FOR_MONTHLYREPORT);
				pstmt.setString(1, locId);
			}
			rs = pstmt.executeQuery();

			while (rs.next()) {

				MonthlyLagendReportVo shiftvo = new MonthlyLagendReportVo();

				shiftvo.setShiftid(rs.getString("AI_SHIFT_ID"));
				shiftvo.setShiftname(rs.getString("AI_SHIFT_NAME"));

				shiftlist.add(shiftvo);
			}

		} catch (SQLException sqle) {

			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e);
		} finally {

			try {

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}

			} catch (SQLException e) {

				e.printStackTrace();
				logger.error(e);
			} catch (Exception e) {

				e.printStackTrace();
				logger.error(e);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportDaoImpl:getShiftBasedLocation Ending");
		return shiftlist;

	}

	public synchronized ArrayList<MonthlyLagendReportVo> getDeptBasedLocation() {

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportDaoImpl:getDeptBasedLocation Starting");
		ArrayList<MonthlyLagendReportVo> deptlist = new ArrayList<MonthlyLagendReportVo>();
		Connection conn = null;

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();

			pstmt = conn
					.prepareStatement(SQLutilConstants.GET_ALL_DEPT_FOR_MONTHLYREPORT);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				MonthlyLagendReportVo deptvo = new MonthlyLagendReportVo();

				deptvo.setDeptid(rs.getString("DEPT_ID"));
				deptvo.setDeptname(rs.getString("DEPT_NAME"));

				deptlist.add(deptvo);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			logger.error(e);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e);
		} finally {

			try {

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {

					pstmt.close();
				}

				if (conn != null && (!conn.isClosed())) {
					conn.close();
				}

			} catch (SQLException e) {

				e.printStackTrace();
				logger.error(e);
			} catch (Exception e) {

				e.printStackTrace();
				logger.error(e);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportDaoImpl:getDeptBasedLocation Ending");

		return deptlist;

	}

	public synchronized ArrayList<MonthlyLagendReportVo> internalMonthlyLagendReport(
			MonthlyLagendReportVo monthlyLagendReportVo2, Connection connection) {

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportDaoImpl:internalMonthlyLagendReport Starting");
		

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<MonthlyLagendReportVo> monthlyreportlist = new ArrayList<MonthlyLagendReportVo>();
		int presentcnt = 0;
		int absentcnt = 0;
		int weekoffcnt = 0;

		String date = null;
		ArrayList<MonthlyLagendReportVo> empids = monthlyLagendReportVo2.getEmplist();

		ArrayList<String> empstatus = null;

		try {
			
			pstmt = connection
					.prepareStatement(SQLutilConstants.GET_EMPLOYEE_MONTH_REPORT);
			for (int i = 0; i < empids.size(); i++) {

				empstatus = new ArrayList<String>();

				String empid = empids.get(i).getEmpid();
				String empname = empids.get(i).getEmpname();
				String designation=empids.get(i).getDesignation();

				MonthlyLagendReportVo monthlyLagendReportVo = null;

				for (int j = 1; j <= monthlyLagendReportVo2.getMonthdays(); j++) {

					String day = null;

					if (j == 1 || j < 10) {

						day = "0" + Integer.toString(j);

					} else {
						day = Integer.toString(j);
					}

					date = monthlyLagendReportVo2.getYear() + "-" + monthlyLagendReportVo2.getMonth() + "-"
							+ day;

					pstmt.setString(1, date);
					pstmt.setString(2, empid);
					rs = pstmt.executeQuery();

					

					if (rs.next()) {

						String status = rs.getString("status");

						if (status.equalsIgnoreCase(MessageConstants.ABSENT)) {
							empstatus.add("A");
							absentcnt++;
						}// if it is absent
						else if (status
								.equalsIgnoreCase(MessageConstants.PRESENT)) {
							empstatus.add("P");
							presentcnt++;
						}// if it is present
						else if (status
								.equalsIgnoreCase(MessageConstants.WEEK_OFF)) {
							empstatus.add("W");
							weekoffcnt++;
						}// IF it is weekoff
						else if (status
								.equalsIgnoreCase(MessageConstants.HOLIDAY)) {
							empstatus.add("H");
						}// IF it is holiday
						else {
							empstatus.add("N");
						}

					} else { // close brase for data checking
						empstatus.add("N");
					}// else for no data

				}// For Loop For according days JSONArray array=new
					// JSONArray(monthlyLagendReportVo);

				monthlyLagendReportVo = new MonthlyLagendReportVo();
				monthlyLagendReportVo.setEmpid(empid);
				monthlyLagendReportVo.setEmpname(empname);
				monthlyLagendReportVo.setDesignation(designation);
				monthlyLagendReportVo.setErrormsg(MessageConstants.MONTHLY_LEGEND_ATTENDANCE__EXIST_MSG.toString());
				monthlyLagendReportVo.setStatus(empstatus);
				monthlyLagendReportVo.setTotalpresent(Integer
						.toString(presentcnt));
				monthlyLagendReportVo.setTotalabsent(Integer
						.toString(absentcnt));
				monthlyLagendReportVo.setTotalweekoff(Integer
						.toString(weekoffcnt));

				/*
				 * if (absentcnt == 0) { if (presentcnt != 0) { int paybleday =
				 * mform1.getDays() - absentcnt;
				 * 
				 * } }else{ int paybleday = mform1.getDays() - absentcnt;
				 * 
				 * 
				 * }
				 */
				weekoffcnt = 0;
				presentcnt = 0;
				absentcnt = 0;

				monthlyreportlist.add(monthlyLagendReportVo);

			}
		} catch (SQLException e) {

			e.printStackTrace();
			logger.error(e);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e);
		} finally {

			try {

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				

			} catch (SQLException e) {

				e.printStackTrace();
				logger.error(e);
			} catch (Exception e) {

				e.printStackTrace();
				logger.error(e);
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportDaoImpl:internalMonthlyLagendReport Ending");

		return monthlyreportlist;

	}

	public synchronized ArrayList<MonthlyLagendReportVo> externalMonthlyLagendReport(
			MonthlyLagendReportForm mform1) {

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportDaoImpl:externalMonthlyLagendReport Starting");
		Connection conn = null;
		// DBService db=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<MonthlyLagendReportVo> monthlyreportlist = new ArrayList<MonthlyLagendReportVo>();

		int presentcnt = 0;
		int absentcnt = 0;
		int weekoffcnt = 0;

		String date = null;
		ArrayList<MonthlyLagendReportVo> empids = mform1.getEmpid();

		ArrayList<String> empstatus = null;

		try {
			conn = getConnection();
			// db=new DBService();
			for (int i = 0; i < empids.size(); i++) {

				empstatus = new ArrayList<String>();

				String empid = empids.get(i).getEmpid();
				String empname = empids.get(i).getEmpname();

				MonthlyLagendReportVo monthlyLagendReportVo = null;

				pstmt = conn
						.prepareStatement(SQLutilConstants.GET_EMPLOYEE_MONTH_REPORT);
				for (int j = 1; j <= mform1.getDays(); j++) {

					String day = null;

					if (j == 1 || j < 10) {
						day = "0" + Integer.toString(j);
					} else {
						day = Integer.toString(j);
					}

					date = mform1.getYear() + "-" + mform1.getMonth() + "-"
							+ day;

					pstmt.setString(1, date);
					pstmt.setString(2, empid);
					rs = pstmt.executeQuery();

					System.out.println("month report checking ===" + pstmt);

					if (rs.next()) {

						String status = rs.getString("status");

						if (status.equalsIgnoreCase(MessageConstants.ABSENT)) {
							empstatus.add("A");
							absentcnt++;
						}// if it is absent
						else if (status
								.equalsIgnoreCase(MessageConstants.PRESENT)) {
							empstatus.add("P");
							presentcnt++;
							System.out.println("empstatus" + empstatus);
						}// if it is present
						else if (status
								.equalsIgnoreCase(MessageConstants.WEEK_OFF)) {
							empstatus.add("W");
							weekoffcnt++;
						}// IF it is weekoff
						else if (status
								.equalsIgnoreCase(MessageConstants.HOLIDAY)) {
							empstatus.add("H");
						}// IF it is holiday
						else {
							empstatus.add("N");
						}

					} else { // close brase for data checking
						empstatus.add("N");
					}// else for no data

				}// For Loop For according days JSONArray array=new
					// JSONArray(monthlyLagendReportVo);

				monthlyLagendReportVo = new MonthlyLagendReportVo();
				monthlyLagendReportVo.setEmpid(empid);
				monthlyLagendReportVo.setEmpname(empname);
				monthlyLagendReportVo.setStatus(empstatus);
				monthlyLagendReportVo.setTotalpresent(Integer
						.toString(presentcnt));
				monthlyLagendReportVo.setTotalabsent(Integer
						.toString(absentcnt));
				monthlyLagendReportVo.setTotalweekoff(Integer
						.toString(weekoffcnt));

				if (absentcnt == 0) {
					if (presentcnt != 0) {
						int paybleday = mform1.getDays() - absentcnt;
						// monthlyLagendReportVo.setPaybledays(Integer.toString(paybleday));
					} else {
						// monthlyLagendReportVo.setPaybledays("0");
					}
				} else {
					int paybleday = mform1.getDays() - absentcnt;
					// monthlyLagendReportVo.setPaybledays(Integer.toString(paybleday));

				}
				weekoffcnt = 0;
				presentcnt = 0;
				absentcnt = 0;

				monthlyreportlist.add(monthlyLagendReportVo);

				JSONArray array = new JSONArray(monthlyreportlist);
				System.out.println(" **** month list **** " + array);
			}

		} catch (SQLException e) {

			e.printStackTrace();
			logger.error(e);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e);
		} finally {

			try {

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (conn != null && (!conn.isClosed())) {
					conn.close();

				}

			} catch (SQLException e) {

				e.printStackTrace();
				logger.error(e);
			} catch (Exception e) {

				e.printStackTrace();
				logger.error(e);
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportDaoImpl:externalMonthlyLagendReport Ending");
		return monthlyreportlist;

	}

	public ArrayList<MonthlyLagendReportVo> getEmpIds(
			MonthlyLagendReportForm mform,Connection connection) {

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportDaoImpl:getEmpIds Starting");

		String year = mform.getYear();
		String month = mform.getMonth();
		int count = 0;

		ArrayList<MonthlyLagendReportVo> empidlist = new ArrayList<MonthlyLagendReportVo>();

		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rscount = null;
		ResultSet rsempids = null;

		try {
			
			pstmt = connection
					.prepareStatement(SQLutilConstants.GET_ATTENDANCE_COUNT);
			pstmt.setString(1, '%' + year + '-' + month + '-' + '%');

			rscount = pstmt.executeQuery();
			while (rscount.next())
				count = rscount.getInt(1);

			if (count != 0) {

				if (mform.getDesignation().equalsIgnoreCase("all")) {

					pstmt1 = connection
							.prepareStatement(SQLutilConstants.GET_EMPID_BY_LOCATION);
					pstmt1.setString(1, mform.getEmpLocation());

				} else {

					pstmt1 = connection
							.prepareStatement(SQLutilConstants.GET_EMPID_BY_LOCATION_AND_DESIGNATION);
					pstmt1.setString(1, mform.getEmpLocation());
					pstmt1.setString(2, mform.getDesignation());

				}
				rsempids = pstmt1.executeQuery();
				while (rsempids.next()) {

					MonthlyLagendReportVo monthlyLagendReportVo = new MonthlyLagendReportVo();
					monthlyLagendReportVo.setEmpid(rsempids.getString("EMPID"));
					monthlyLagendReportVo.setEmpname(rsempids
							.getString("EMPNAME"));
					monthlyLagendReportVo.setDesignation(rsempids.getString("designationName"));
					monthlyLagendReportVo.setErrormsg(MessageConstants.MONTHLY_LEGEND_ATTENDANCE__EXIST_MSG.toString());
					empidlist.add(monthlyLagendReportVo);

				}

				
				return empidlist;
			}else{
				
				
				
				MonthlyLagendReportVo monthlyLagendReportVoforerror = new MonthlyLagendReportVo();
				monthlyLagendReportVoforerror.setErrormsg(MessageConstants.MONTHLY_LEGEND_ATTENDANCE_NOT_EXIST_MSG.toString());
				empidlist.add(monthlyLagendReportVoforerror);
				  return empidlist;
				
			}
			
			
		} catch (SQLException e) {

			e.printStackTrace();
			logger.error(e);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e);
		} finally {

			try {

				if (rsempids != null && !rsempids.isClosed()) {
					rsempids.close();
				}

				if (pstmt1 != null && !pstmt1.isClosed()) {
					pstmt1.close();
				}
				if (rscount != null && !rscount.isClosed()) {
					rscount.close();
				}

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				

			} catch (SQLException e) {

				e.printStackTrace();
				logger.error(e);
			} catch (Exception e) {

				e.printStackTrace();
				logger.error(e);
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportDaoImpl:getEmpIds Ending");

		return null;
	}

}
