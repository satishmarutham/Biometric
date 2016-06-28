/**
 * 
 */
package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.DAO.LateCommersReportDao;
import com.centris.POJO.DayReportPojo;
import com.centris.POJO.LateCommersReportPojo;
import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

/**
 * @author sathish
 * 
 */
public class LateCommersReportDaoImpl extends DBService implements
		LateCommersReportDao {
	private static Logger logger = Logger
			.getLogger(LateCommersReportDaoImpl.class);

	@Override
	public synchronized List<LateCommersReportPojo> getLateCommersReport(
			LateCommersReportPojo lateCommersReportPojo) throws Exception {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LateCommersReportDaoImpl:getDayReportDetails Starting");

		List<LateCommersReportPojo> getlateCommerstReportList = new ArrayList<LateCommersReportPojo>();
		Connection connection = null;
		PreparedStatement psgetempReport = null;
		ResultSet rsgetempReport = null;
		try {
			connection = getConnection();
			psgetempReport = connection
					.prepareStatement(SQLutilConstants.GET_LATE_COMMERS_REPORT);
			psgetempReport.setString(1, lateCommersReportPojo.getEmployeeId());
			psgetempReport.setString(2, HelperClass
					.convertUIToDatabase(lateCommersReportPojo.getStartDate()));
			psgetempReport.setString(3, HelperClass
					.convertUIToDatabase(lateCommersReportPojo.getEndDate()));

			rsgetempReport = psgetempReport.executeQuery();

			while (rsgetempReport.next()) {
				LateCommersReportPojo lateCommersDetails = new LateCommersReportPojo();
				lateCommersDetails.setEmployeeId(rsgetempReport
						.getString("EMPID"));
				lateCommersDetails.setEmployeeName(rsgetempReport
						.getString("EMPNAME"));
				lateCommersDetails.setLocationName(rsgetempReport
						.getString("Location"));
				lateCommersDetails.setShiftName(rsgetempReport
						.getString("AI_SHIFT_NAME"));
				lateCommersDetails.setInTime(rsgetempReport
						.getString("IN_TIME"));
				lateCommersDetails.setOutTime(rsgetempReport
						.getString("OUT_TIME"));
				lateCommersDetails.setLateTime(rsgetempReport
						.getString("LATE_TIME"));
				lateCommersDetails.setAttendenceDate(HelperClass
						.convertDatabaseToUI(rsgetempReport
								.getString("ATTENDANCE_DATE")));

				getlateCommerstReportList.add(lateCommersDetails);

			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (psgetempReport !=null && (!psgetempReport.isClosed())){
					psgetempReport.getConnection().close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LateCommersReportDaoImpl Ending");

		// TODO Auto-generated method stub
		return getlateCommerstReportList;

		// TODO Auto-generated method stub

	}

	@Override
	public synchronized List<LateCommersReportPojo> getEarlyTimeReport(
			LateCommersReportPojo lateCommersReportPojo) throws Exception {
		// TODO Auto-generated method stub
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LateCommersReportDaoImpl:getDayReportDetails Starting");
		List<LateCommersReportPojo> getEarlyTimeReportList = new ArrayList<LateCommersReportPojo>();
		Connection connection = null;
		PreparedStatement psgetearlyTimeReport = null;
		ResultSet rsgetempReport = null;
		try {
			connection = getConnection();
			psgetearlyTimeReport = connection
					.prepareStatement(SQLutilConstants.GET_EARLY_TIME_REPORT);
			psgetearlyTimeReport.setString(1,
					lateCommersReportPojo.getEmployeeId());
			psgetearlyTimeReport.setString(2, HelperClass
					.convertUIToDatabase(lateCommersReportPojo.getStartDate()));
			psgetearlyTimeReport.setString(3, HelperClass
					.convertUIToDatabase(lateCommersReportPojo.getEndDate()));

			rsgetempReport = psgetearlyTimeReport.executeQuery();

			while (rsgetempReport.next()) {
				LateCommersReportPojo lateCommersDetails = new LateCommersReportPojo();
				lateCommersDetails.setEmployeeId(rsgetempReport
						.getString("EMPID"));
				lateCommersDetails.setEmployeeName(rsgetempReport
						.getString("EMPNAME"));
				lateCommersDetails.setLocationName(rsgetempReport
						.getString("Location"));
				lateCommersDetails.setShiftName(rsgetempReport
						.getString("AI_SHIFT_NAME"));
				lateCommersDetails.setInTime(rsgetempReport
						.getString("IN_TIME"));
				lateCommersDetails.setOutTime(rsgetempReport
						.getString("OUT_TIME"));
				lateCommersDetails.setEarlyTime(rsgetempReport
						.getString("EARLY_TIME"));
				lateCommersDetails.setAttendenceDate(HelperClass
						.convertDatabaseToUI(rsgetempReport
								.getString("ATTENDANCE_DATE")));

				getEarlyTimeReportList.add(lateCommersDetails);

			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		} finally {
			try {

				if (psgetearlyTimeReport !=null &&(!psgetearlyTimeReport.isClosed())) {
					psgetearlyTimeReport.getConnection().close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LateCommersReportDaoImpl Ending");

		// TODO Auto-generated method stub
		return getEarlyTimeReportList;
	}

	@Override
	public synchronized List<ConsolidateDetailedMonthReportVO> getEmpDetailsByShift(
			String shift, String group, String location) throws Exception {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportDAOImpl:getEmpDetailsByShift Starting");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsshiftnames = null;

		List<ConsolidateDetailedMonthReportVO> empList = new ArrayList<ConsolidateDetailedMonthReportVO>();
		try {
			conn = getConnection();
			pstmt = conn
					.prepareStatement(SQLutilConstants.GET_EMPDETAILS_BY_LATECOMMERS);
			pstmt.setString(1, shift);
			pstmt.setString(2, location);
			pstmt.setString(3, group);

			rsshiftnames = pstmt.executeQuery();
			ConsolidateDetailedMonthReportVO consolidateDetailedMonthReportVo = null;
			while (rsshiftnames.next()) {
				consolidateDetailedMonthReportVo = new ConsolidateDetailedMonthReportVO();
				consolidateDetailedMonthReportVo.setEmpid(rsshiftnames
						.getString("EMPID"));
				consolidateDetailedMonthReportVo.setEmpname(rsshiftnames
						.getString("EMPNAME"));
				empList.add(consolidateDetailedMonthReportVo);

			}
		} catch (SQLException se) {
			logger.error(se);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			try {

				if (pstmt !=null && (!pstmt.isClosed())) {
					pstmt.getConnection().close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportDAOImpl:getEmpDetailsByShift Ending");

		return empList;
	}
}
