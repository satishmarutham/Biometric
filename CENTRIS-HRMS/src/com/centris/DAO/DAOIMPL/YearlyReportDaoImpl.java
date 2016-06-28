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
import com.centris.DAO.YearlyReportDao;
import com.centris.POJO.YearlyReportPojo;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

/**
 * @author sathish
 * 
 */
public class YearlyReportDaoImpl extends DBService implements YearlyReportDao {
	private static Logger logger = Logger.getLogger(YearlyReportDaoImpl.class);

	@Override
	public synchronized List<YearlyReportPojo> getYearlyReportDetails(
			YearlyReportPojo reportPojo) {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in YearlyReportDaoImpl:getYearlyReportDetails Starting");

		Connection connection = null;
		PreparedStatement psgetyearlyReport = null;
		ResultSet rsgetempReport = null;
		PreparedStatement pstmt = null;
		List<YearlyReportPojo> getYearlyReportList = new ArrayList<YearlyReportPojo>();
		int totalLeaves = 0;
		int totalPresent = 0;
		int totalAbsent = 0;
		int totalCasual = 0;
		int totalotherLeaves = 0;
		int totalWeekoff = 0;
		String month = null;
		int totalHoliday = 0;
		int holidayPayable = 0;
		int totalSickLeaves = 0;
		int weekoffPayble = 0;
		int payableLeaves = 0;
		String employeeId = null;
		String employeeIdForm = reportPojo.getEmployeeId();
		String employeeName = null;

		try {
			connection = getConnection();
			for (int i = Integer.parseInt(reportPojo.getStartmonth()); i <= Integer
					.parseInt(reportPojo.getEndmonth()); i++) {

				psgetyearlyReport = connection
						.prepareStatement(SQLutilConstants.GET_YEARLY_REPORT_DETAILS);
				psgetyearlyReport.setString(1, reportPojo.getEmployeeId());
				psgetyearlyReport.setString(2, reportPojo.getYear() + "-"
						+ (i < 10 ? "0" + i : i + "") + "%");
				String monthName = HelperClass.getMonthFullName(String
						.valueOf(i));
				psgetyearlyReport.setString(3, reportPojo.getGroupCode());

				rsgetempReport = psgetyearlyReport.executeQuery();
				boolean flag = false;
				while (rsgetempReport.next()) {
					flag = true;
					YearlyReportPojo reportPojo2 = new YearlyReportPojo();
					reportPojo2.setMonthName(monthName);

					employeeId = rsgetempReport.getString("EMPID");

					reportPojo2.setEmployeeId(employeeId);
					employeeName = rsgetempReport.getString("EMPNAME");

					reportPojo2.setEmployeeName(employeeName);
					reportPojo2.setLocationName(rsgetempReport
							.getString("Location"));
					reportPojo2.setPresents(rsgetempReport
							.getString("totalPresent"));
					reportPojo2.setAbsents(rsgetempReport
							.getString("totalAbsent"));

					reportPojo2.setCasualLeaves(rsgetempReport
							.getString("totalCasual"));

					reportPojo2.setOtherLeaves(rsgetempReport
							.getString("totalotherLeaves"));
					reportPojo2.setWeekOffs(rsgetempReport
							.getString("totalWeekoff"));
					reportPojo2.setHolidays(rsgetempReport
							.getString("totalHoliday"));
					reportPojo2.setHolidayPayable(rsgetempReport
							.getString("holidayPayable"));
					reportPojo2.setSickLeaves(rsgetempReport
							.getString("totalSickLeaves"));
					reportPojo2.setWeekoffPayable(rsgetempReport
							.getString("weekoffPayble"));
					reportPojo2.setPayableLeaves(rsgetempReport
							.getString("payableLeaves"));
					totalAbsent = Integer.parseInt(rsgetempReport
							.getString("totalAbsent"));
					totalCasual = Integer.parseInt(rsgetempReport
							.getString("totalCasual"));
					totalotherLeaves = Integer.parseInt(rsgetempReport
							.getString("totalotherLeaves"));
					totalWeekoff = Integer.parseInt(rsgetempReport
							.getString("totalWeekoff"));

					totalHoliday = Integer.parseInt(rsgetempReport
							.getString("totalHoliday"));
					holidayPayable = Integer.parseInt(rsgetempReport
							.getString("holidayPayable"));
					totalSickLeaves = Integer.parseInt(rsgetempReport
							.getString("totalSickLeaves"));
					weekoffPayble = Integer.parseInt(rsgetempReport
							.getString("weekoffPayble"));
					payableLeaves = Integer.parseInt(rsgetempReport
							.getString("payableLeaves"));
					totalLeaves = totalAbsent + totalCasual + totalotherLeaves
							+ totalWeekoff + totalHoliday + holidayPayable
							+ totalSickLeaves + weekoffPayble + payableLeaves;

					reportPojo2.setTotalLeaves(String.valueOf(totalLeaves));
					getYearlyReportList.add(reportPojo2);
				}
				if (!flag) {
					Connection conn = null;

					ResultSet empNames = null;
					YearlyReportPojo pojo = new YearlyReportPojo();
					conn = getConnection();

					String names = null;
					String locations = null;
					pstmt = conn
							.prepareStatement(SQLutilConstants.GET_YEARLY_REPORT_DETAILS_EMPLOYEES);
					pstmt.setString(1, employeeIdForm);
					empNames = pstmt.executeQuery();

					while (empNames.next()) {
						names = empNames.getString("EMPNAME");
						locations = empNames.getString("Location");
					}
					month = HelperClass.getMonthFullName(String.valueOf(i));
					pojo.setLocationName(locations);
					pojo.setEmployeeName(names);
					pojo.setPresents("0");
					pojo.setAbsents("0");
					pojo.setCasualLeaves("0");
					pojo.setHolidayPayable("0");
					pojo.setHolidays("0");
					pojo.setMonthName(month);
					pojo.setOtherLeaves("0");
					pojo.setPayableLeaves("0");
					pojo.setWeekOffs("0");
					pojo.setWeekoffPayable("0");
					pojo.setTotalLeaves("0");
					pojo.setSickLeaves("N/A");
					pojo.setTotalLeaves("0");

					getYearlyReportList.add(pojo);

					empNames.close();
					pstmt.close();
				}
			}
		} catch (SQLException se) {
			logger.error(se);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			try {
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.getConnection().close();
				}
				if (psgetyearlyReport != null
						&& (!psgetyearlyReport.isClosed())) {
					psgetyearlyReport.getConnection().close();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  Control in YearlyReportDaoImpl:getYearlyReportDetails Ending");

		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		return getYearlyReportList;
	}

	public synchronized List<String> getEmpDetailsByShift(String shift,
			String group, String location) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in YearlyReportDaoImpl:getEmpDetailsByShift Starting");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsshiftnames = null;

		List<String> empList = new ArrayList<String>();
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQLutilConstants.GET_EMP_BY_SHIFT);
			pstmt.setString(1, shift);
			pstmt.setString(2, location);
			pstmt.setString(3, group);

			rsshiftnames = pstmt.executeQuery();
			String empId = null;
			while (rsshiftnames.next()) {
				empId = rsshiftnames.getString("EMPID").trim();
				empList.add(empId);

			}
		} catch (SQLException se) {
			logger.error(se);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			try {

				if (pstmt != null && (!pstmt.isClosed())) {
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
				+ " Control in YearlyReportDaoImpl:getEmpDetailsByShift Ending");

		return empList;
	}
}