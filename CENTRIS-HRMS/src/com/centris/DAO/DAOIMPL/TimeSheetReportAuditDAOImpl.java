package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.VO.AuditReportEmpVO;
import com.centris.VO.DepartmentMasterVO;
import com.centris.VO.ShiftVO;
import com.centris.VO.TimeSheetReportVO;
import com.centris.form.TimeSheetReportForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class TimeSheetReportAuditDAOImpl extends DBService {

	private static Logger logger = Logger
			.getLogger(TimeSheetReportAuditDAOImpl.class);
	DBService db = new DBService();

	Connection con = null;
	Statement shiftStatement = null;

	List<TimeSheetReportVO> employeeAttendancelist;
	List<ShiftVO> shiftlist;
	List<DepartmentMasterVO> departmentlist;

	public synchronized List<ShiftVO> getShiftDeatails() throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new java.util.Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new java.util.Date())
				+ " Control in TimeSheetReportAuditDAOImpl : getShiftDeatails Starting");

		PreparedStatement psmt = null;
		shiftlist = new ArrayList<ShiftVO>();
		try {
			con = getConnection();
			psmt = con
					.prepareStatement(SQLutilConstants.GET_SHIFT_NAMES_DETAILS);
			ResultSet resultset = psmt.executeQuery();
			while (resultset.next()) {
				ShiftVO shiftvo = new ShiftVO();
				shiftvo.setShiftId(resultset.getString("AI_SHIFT_ID"));
				shiftvo.setShiftName(resultset.getString("AI_SHIFT_NAME"));

				shiftlist.add(shiftvo);
			}
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {
			try {
				if(psmt !=null && (!psmt.isClosed())){
					psmt.getConnection().close();
				}
			} catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new java.util.Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new java.util.Date())
				+ " Control in TimeSheetReportAuditDAOImpl : getShiftDeatails Ending");
		return shiftlist;
	}

	public synchronized List<DepartmentMasterVO> getDepartmentDetails()
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new java.util.Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new java.util.Date())
				+ " Control in TimeSheetReportAuditDAOImpl : getDepartmentDetails Starting");

		PreparedStatement psmt = null;
		departmentlist = new ArrayList<DepartmentMasterVO>();
		try {
			con = getConnection();
			psmt = con.prepareStatement(SQLutilConstants.GET_DEPARTMENT);
			ResultSet resultset = psmt.executeQuery();
			while (resultset.next()) {
				DepartmentMasterVO DepartmentMasterVO = new DepartmentMasterVO();
				DepartmentMasterVO.setDepId(resultset.getString("DEPT_ID"));
				DepartmentMasterVO.setDepName(resultset.getString("DEPT_NAME"));
				departmentlist.add(DepartmentMasterVO);
			}
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {
			try {
				if(psmt !=null && (!psmt.isClosed())){
					psmt.getConnection().close();
				}
			} catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new java.util.Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new java.util.Date())
				+ " Control in TimeSheetReportAuditDAOImpl : getDepartmentDetails Ending");
		return departmentlist;
	}

	public synchronized List<TimeSheetReportVO> getEmployeeAttendanceInfo(
			TimeSheetReportForm timeSheetReportForm) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new java.util.Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new java.util.Date())
				+ " Control in TimeSheetReportAuditDAOImpl : getEmployeeAttendanceInfo Starting");
		employeeAttendancelist = new ArrayList<TimeSheetReportVO>();
		PreparedStatement psmt = null;
		try {
			con = getConnection();
			if (timeSheetReportForm.getEmpname().equals("all")) {
				employeeAttendancelist.clear();
				psmt = con
						.prepareStatement(SQLutilConstants.GET_EMP_ATTENDANCE_ALL1);
				psmt.setString(1, HelperClass
						.convertUIToDatabase(timeSheetReportForm.getFromdate()));
				psmt.setString(2, HelperClass
						.convertUIToDatabase(timeSheetReportForm.getTodate()));
				ResultSet resultset = psmt.executeQuery();
				while (resultset.next()) {

					TimeSheetReportVO timeSheetReportVO = new TimeSheetReportVO();
					timeSheetReportVO.setEmpid(resultset.getString("EMP_ID"));
					timeSheetReportVO
							.setEmpname(resultset.getString("EMPNAME"));
					timeSheetReportVO.setAttendancedate(HelperClass
							.convertDatabaseToUI(resultset
									.getString("ATTEDANCE_DATE")));
					timeSheetReportVO.setModifiedby(resultset
							.getString("UPDATED_BY"));

					String timestamp = resultset.getString("UPDATED_TIME")
							.toString();
					String date = timestamp.substring(0, 10);
					String time = timestamp.substring(11, 19);

					String date2 = HelperClass
							.getDateFromSQLDateinDDMMYYYYFormat(Date
									.valueOf(date));
					timeSheetReportVO.setModifieddate(date2.concat(" " + time));
					employeeAttendancelist.add(timeSheetReportVO);
				}
			} else {
				employeeAttendancelist.clear();
				psmt = con
						.prepareStatement(SQLutilConstants.GET_EMP_ATTENDANCE_ONE1);
				psmt.setString(1, timeSheetReportForm.getEmpname());
				psmt.setString(2, HelperClass
						.convertUIToDatabase(timeSheetReportForm.getFromdate()));
				psmt.setString(3, HelperClass
						.convertUIToDatabase(timeSheetReportForm.getTodate()));
				ResultSet resultset = psmt.executeQuery();
				while (resultset.next()) {

					TimeSheetReportVO timeSheetReportVO = new TimeSheetReportVO();
					timeSheetReportVO.setEmpid(resultset.getString("EMP_ID"));
					timeSheetReportVO
							.setEmpname(resultset.getString("EMPNAME"));
					timeSheetReportVO.setAttendancedate(HelperClass
							.convertDatabaseToUI(resultset
									.getString("ATTEDANCE_DATE")));
					timeSheetReportVO.setModifiedby(resultset
							.getString("UPDATED_BY"));

					String timestamp = resultset.getString("UPDATED_TIME")
							.toString();
					String date = timestamp.substring(0, 10);
					String time = timestamp.substring(11, 19);

					String date2 = HelperClass
							.getDateFromSQLDateinDDMMYYYYFormat(Date
									.valueOf(date));
					timeSheetReportVO.setModifieddate(date2.concat(" " + time));
					employeeAttendancelist.add(timeSheetReportVO);
				}
			}
		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (Exception e1) {
			logger.error(e1);
			e1.printStackTrace();
		} finally {
			try {
				if(psmt !=null && (!psmt.isClosed())){
					psmt.getConnection().close();
				}
			} catch (Exception e1) {
				logger.error(e1);
				e1.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new java.util.Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new java.util.Date())
				+ " Control in TimeSheetReportAuditDAOImpl : getEmployeeAttendanceInfo Ending");
		return employeeAttendancelist;

	}

	public synchronized List<TimeSheetReportVO> getEmpTimeSheet(String empid,
			String adate, String uptime) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new java.util.Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new java.util.Date())
				+ " Control in TimeSheetReportAuditDAOImpl : getEmpTimeSheet Starting");
		String attedancedate = HelperClass.convertUIToDatabase(adate);

		String date1 = HelperClass.convertUIToDatabase(uptime);
		String time = uptime.substring(11, 19);
		String updatetime = date1.concat(" " + time);

		PreparedStatement psmt = null;
		employeeAttendancelist = new ArrayList<TimeSheetReportVO>();
		try {
			employeeAttendancelist.clear();
			con = getConnection();
			psmt = con.prepareStatement(SQLutilConstants.GET_EMP_TIMESHEET);
			psmt.setString(1, empid);
			psmt.setString(2, attedancedate);
			psmt.setString(3, updatetime);

			ResultSet resultset = psmt.executeQuery();

			while (resultset.next()) {
				TimeSheetReportVO timeSheetReportVO = new TimeSheetReportVO();
				timeSheetReportVO.setPrevintime(resultset
						.getString("PREVIOUS_INTIME"));
				timeSheetReportVO.setPrev_outtime(resultset
						.getString("PREVIOUS_OUTTIME"));
				timeSheetReportVO.setPrev_totalhours(resultset
						.getString("PREVIOUS_TOTALHOURS"));
				timeSheetReportVO.setPrev_workinghours(resultset
						.getString("PREVIOUS_WORKING_HOURS"));
				timeSheetReportVO.setPrev_mor_late(resultset
						.getString("PREVIOUS_MOR_LATE"));
				timeSheetReportVO.setPrev_eve_early(resultset
						.getString("PREVIOUS_EVE_EARLY"));
				timeSheetReportVO.setPrev_latetime(resultset
						.getString("PREVIOUS_LATETIME"));
				timeSheetReportVO.setPrev_earlytime(resultset
						.getString("PREVIOUS_EARLYTIME"));

				timeSheetReportVO.setCurr_intime(resultset
						.getString("CURRENT_INTIME"));
				timeSheetReportVO.setCurr_outtime(resultset
						.getString("CURRENT_OUTTIME"));
				timeSheetReportVO.setCurr_totalhours(resultset
						.getString("CURRENT_TOTALHOURS"));
				timeSheetReportVO.setCurr_workinghours(resultset
						.getString("CURRENT_WORKING_HOURS"));
				timeSheetReportVO.setCurr_mor_late(resultset
						.getString("CURRENT_MOR_LATE"));
				timeSheetReportVO.setCurr_eve_early(resultset
						.getString("CURRENT_EVE_EARLY"));
				timeSheetReportVO.setCurr_latetime(resultset
						.getString("CURRENT_LATETIME"));
				timeSheetReportVO.setCurr_earlytime(resultset
						.getString("CURRENT_EARLYTIME"));

				timeSheetReportVO.setModifiedby(resultset
						.getString("UPDATED_BY"));
				String timestamp = resultset.getString("UPDATED_TIME")
						.toString();

				String[] date = timestamp.split(" ");

				timeSheetReportVO.setModifieddate(HelperClass
						.getDateFromSQLDateinDDMMYYYYFormat(Date
								.valueOf(date[0])));

				employeeAttendancelist.add(timeSheetReportVO);
			}

		} catch (SQLException e) {
			logger.error(e);
			e.printStackTrace();
		} catch (Exception e1) {
			logger.error(e1);
			e1.printStackTrace();
		} finally {
			try {
				if(psmt !=null && (!psmt.isClosed())){
					psmt.getConnection().close();
				}
			} catch (Exception e1) {
				logger.error(e1);
				e1.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new java.util.Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new java.util.Date())
				+ " Control in TimeSheetReportAuditDAOImpl : getEmpTimeSheet Ending");
		return employeeAttendancelist;
	}

	/* chiru */

	public synchronized ArrayList<AuditReportEmpVO> getEmpDetails(
			String shiftid, String deptid) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new java.util.Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new java.util.Date())
				+ " Control in TimeSheetReportAuditDAOImpl : getEmpDetails Starting");
		ResultSet rs = null;

		ArrayList<AuditReportEmpVO> emp_list = new ArrayList<AuditReportEmpVO>();
		PreparedStatement pstmt = null;
		try {

			if ((!(shiftid.equals("all"))) && !(deptid.equals("all"))) {

				pstmt = db
						.getPreparedStatement(SQLutilConstants.GET_EMPLOYEES_WITH_SHIFTID_DEPTID1);

				pstmt.setString(1, shiftid);
				pstmt.setString(2, deptid);

			}

			if ((!(shiftid.equals("all"))) && (deptid.equals("all"))) {

				pstmt = db
						.getPreparedStatement(SQLutilConstants.GET_EMPLOYEES_WITH_SHIFTID1);

				pstmt.setString(1, shiftid);

			}

			if ((shiftid.equals("all")) && (!(deptid.equals("all")))) {

				pstmt = db
						.getPreparedStatement(SQLutilConstants.GET_EMPLOYEES_WITH_DEPTID1);

				pstmt.setString(1, deptid);

			}

			if ((shiftid.equals("all") && (deptid.equals("all")))) {

				pstmt = db
						.getPreparedStatement(SQLutilConstants.GET_ALL_EMPLOYEES1);

			}

			rs = pstmt.executeQuery();

			while (rs.next()) {

				AuditReportEmpVO emp_vo = new AuditReportEmpVO();

				emp_vo.setEmpId(rs.getString("EMPID"));
				emp_vo.setEmpName(rs.getString("EMPNAME"));
				emp_list.add(emp_vo);

			}

		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		} finally {
			try {
				if(pstmt !=null && (!pstmt.isClosed())){
					pstmt.getConnection().close();
				}
			} catch (Exception e1) {
				logger.error(e1);
				e1.printStackTrace();
			}
		}
		JLogger.log(0, JDate.getTimeString(new java.util.Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new java.util.Date())
				+ " Control in TimeSheetReportAuditDAOImpl : getEmpDetails Ending");
		return emp_list;
	}
	/* chiru */

}
