package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import com.centris.DAO.DBService;
import com.centris.DAO.ManualAttendanceDao;
import com.centris.VO.ManualAttendanceVO;
import com.centris.form.ManualAttendanceForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class ManualAttendanceDaoImpl extends DBService implements
		ManualAttendanceDao {
	private static Logger logger = Logger
			.getLogger(ManualAttendanceDaoImpl.class);

	@Override
	public synchronized ArrayList<ManualAttendanceVO> getAttendanceDetails(
			ManualAttendanceForm formObj) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManualAttendanceDaoImpl : getAttendanceDetails Starting");
		ArrayList<ManualAttendanceVO> attendanceDetails = new ArrayList<ManualAttendanceVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		ManualAttendanceVO voObj = null;
		int i = 0;
		try {
			conn = getConnection();
			pstmt = conn
					.prepareStatement(SQLutilConstants.GET_EMPLOYEE_ATTENDANCEDETAILS);
			pstmt.setString(1, formObj.getGroup().trim());
			pstmt.setString(2, formObj.getLocation().trim());
			pstmt.setString(3, formObj.getEmployee().trim());
			pstmt.setString(4, HelperClass.convertUIToDatabase(formObj
					.getReportDate().trim()));
			rst = pstmt.executeQuery();

			while (rst.next()) {
				voObj = new ManualAttendanceVO();
				i = ++i;
				voObj.setEmployeeId(rst.getString("EMPID").trim());
				voObj.setEmployeeName(rst.getString("EMPNAME").trim());
				voObj.setEmployeeLocation(rst.getString("Location").trim());
				voObj.setEmployeeDesignation(rst.getString("designationName")
						.trim());
				voObj.setAttDate(HelperClass.convertDatabaseToUI(rst.getString(
						"DATE").trim()));
				voObj.setAttStatus(rst.getString("status").trim());
				voObj.setSno(String.valueOf(i));
				attendanceDetails.add(voObj);
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		} finally {
			try {
				if (conn != null && !(conn.isClosed())) {
					conn.close();
				}
				if (pstmt != null && !(pstmt.isClosed())) {
					pstmt.close();
				}
			} catch (SQLException e) {
				logger.error(e);
				e.printStackTrace();
			} catch (Exception e) {
				logger.error(e);
				e.printStackTrace();
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManualAttendanceDaoImpl : getAttendanceDetails Ending");
		return attendanceDetails;
	}

	@Override
	public synchronized int updateAttendanceDetails(ManualAttendanceForm formObj) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManualAttendanceDaoImpl : updateAttendanceDetails Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rst = null;
		int result = 0;
		try {
			conn = getConnection();
			String createdDate = null;
			String shiftId = null;
			String startTime = null;
			String endTime = null;
			// now()
			for (int i = 0; i < formObj.getEmployeeId().length; i++) {

				if (formObj.getReportStatus()[i].equalsIgnoreCase("present"))

				{
					// Getting createdtime from Attendance Table
					pstmt = conn
							.prepareStatement(SQLutilConstants.GET_AttendanceCreatedTime);

					pstmt.setString(1, formObj.getEmployeeId()[i]);
					pstmt.setString(2, HelperClass.convertUIToDatabase(formObj
							.getReportDate()));
					pstmt.setString(3, formObj.getLocation());
					rst = pstmt.executeQuery();

					while (rst.next()) {
						createdDate = rst.getString("createdate");
					}
					pstmt.close();

					// Updating Attendance Table
					pstmt1 = conn
							.prepareStatement(SQLutilConstants.UpdateAttendance);

					pstmt1.setString(1, formObj.getReportStatus()[i]);
					pstmt1.setString(2, formObj.getUpdatedUser());
					pstmt1.setString(3, createdDate);
					pstmt1.setString(4, formObj.getEmployeeId()[i]);
					pstmt1.setString(5, HelperClass.convertUIToDatabase(formObj
							.getReportDate()));
					pstmt1.setString(6, formObj.getLocation());
					result = pstmt1.executeUpdate();
					pstmt1.close();

					// Getting createdtime and ShiftTime from TimeSheet Table
					pstmt = conn
							.prepareStatement(SQLutilConstants.GET_TimeSheetCreatedTime);

					pstmt.setString(1, formObj.getEmployeeId()[i]);
					pstmt.setString(2, HelperClass.convertUIToDatabase(formObj
							.getReportDate()));
					pstmt.setString(3, formObj.getLocation());
					rst = pstmt.executeQuery();

					while (rst.next()) {
						createdDate = rst.getString("createtime");
						shiftId = rst.getString("SHIFT_ID");
					}
					pstmt.close();

					// Getting Intime and OutTime from Shift Table
					pstmt1 = conn
							.prepareStatement(SQLutilConstants.GET_ShiftTimings);

					pstmt1.setString(1, shiftId);
					pstmt1.setString(2, formObj.getLocation());
					rst = pstmt1.executeQuery();

					while (rst.next()) {
						startTime = rst.getString("AI_SHIFT_START_TIME");
						endTime = rst.getString("AI_SHIFT_END_TIME");
					}
					pstmt1.close();

					// Updating TimeSheet Table
					pstmt = conn
							.prepareStatement(SQLutilConstants.UpdateTimeSheet);

					pstmt.setString(1, startTime);
					pstmt.setString(2, endTime);
					pstmt.setString(3, HelperClass
							.getTimeDifferenceinTimeFormat(startTime, endTime));
					pstmt.setString(4, HelperClass
							.getTimeDifferenceinTimeFormat(startTime, endTime));
					pstmt.setString(5, createdDate);
					pstmt.setString(6, formObj.getUpdatedUser());
					pstmt.setString(7, formObj.getEmployeeId()[i]);
					pstmt.setString(8, HelperClass.convertUIToDatabase(formObj
							.getReportDate()));
					pstmt.setString(9, formObj.getLocation());
					result = pstmt.executeUpdate();
					pstmt.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (pstmt1 != null && !pstmt1.isClosed()) {
					pstmt1.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e);
			}
			 catch (Exception e) {
					e.printStackTrace();
					logger.error(e);
				}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManualAttendanceDaoImpl : updateAttendanceDetails Ending");
		return result;
	}
}