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
import com.centris.DAO.DayReportDao;
import com.centris.POJO.DayReportPojo;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

/**
 * @author sathish
 * 
 * 
 */
public class DayReportDaoImpl extends DBService implements DayReportDao {
	private static Logger logger = Logger.getLogger(DayReportDaoImpl.class);

	@Override
	/**
	 * <p>
	 * This  method is responsible for getting the DayReportDetails.
	 * </p>
	 * 
	 * @param DayReportPojo Object
	 
	 * @return List of the DayReport in the form of Object.
	 * @throws Exception
	 */
	public synchronized List<DayReportPojo> getDayReportDetails(
			DayReportPojo dayReportPojo) throws Exception {
		// TODO Auto-generated method stub

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DayReportDaoImpl:getDayReportDetails Starting");

		Connection connection = null;
		PreparedStatement psgetempReport = null;
		ResultSet rsgetempReport = null;
		List<DayReportPojo> getemployeetReportList = new ArrayList<DayReportPojo>();
		try {
			connection = getConnection();
			String temp_location = "'"
					+ dayReportPojo.getLocationCode().replaceAll(",", "','")
					+ "'";

			/*
			 * psgetempReport=connection.prepareStatement(
			 * "select distinct ed.EMPID,ed.EMPNAME,el.Location,sd.AI_SHIFT_NAME,ea.status,case when bt.IN_TIME='00:00:00' then '-' else bt.IN_TIME end IN_TIME,case when bt.OUT_TIME='00:00:00' then '-' else bt.OUT_TIME end OUT_TIME,case when bt.LATE_TIME='00:00:00' then '-' else bt.LATE_TIME end LATE_TIME,case when bt.EARLY_TIME='00:00:00' then '-' else bt.EARLY_TIME end EARLY_TIME,bt.ATTENDANCE_DATE  from ai_bio_timesheet bt,ai_emp_details ed,ai_emp_location el,ai_shift_deatails sd,ai_emp_attendance ea,onsite_groupmapping gm where gm.LocationCode=ed.Location and ea.empid=ed.EMPID and bt.EMP_ID=ed.EMPID  and ed.SHIFT_ID=sd.AI_SHIFT_ID and ed.Location=el.LocationCode and sd.Location=el.LocationCode and bt.ATTENDANCE_DATE=ea.DATE  and gm.Groupid=? and  ed.Location in ("
			 * + temp_location +
			 * ") and ed.SHIFT_ID like ?  and bt.EMP_ID like ? and bt.EMP_ID in (select EMPID from ai_emp_details where Location in ("
			 * +temp_location+
			 * ")) and ea.DATE between ? and ? order by Location,EMPNAME,ATTENDANCE_DATE,EMPID asc"
			 * );
			 */
			psgetempReport = connection
					.prepareStatement("select distinct ed.EMPID,ed.EMPNAME,el.Location,de.designationName ,ea.status,case when bt.IN_TIME='00:00:00' then '-' else bt.IN_TIME end IN_TIME,case when bt.OUT_TIME='00:00:00' then '-' else bt.OUT_TIME end OUT_TIME,case when bt.LATE_TIME='00:00:00' then '-' else bt.LATE_TIME end LATE_TIME,case when bt.EARLY_TIME='00:00:00' then '-' else bt.EARLY_TIME end EARLY_TIME,bt.ATTENDANCE_DATE  from ai_bio_timesheet bt,ai_emp_details ed,ai_emp_location el,ai_emp_designation de,ai_emp_attendance ea,onsite_groupmapping gm where gm.LocationCode=ed.Location and ea.empid=ed.EMPID and bt.EMP_ID=ed.EMPID  and ed.EMPDESIGNATION=de.designationId and ed.Location=el.LocationCode and bt.ATTENDANCE_DATE=ea.DATE  and gm.Groupid=? and ed.Location in ("
							+ temp_location
							+ ") and de.designationId like ? and bt.EMP_ID like ? and bt.EMP_ID in (select EMPID from ai_emp_details where Location in ("
							+ temp_location
							+ ")) and ea.DATE between ? and ? order by Location,ATTENDANCE_DATE,EMPID asc");
			psgetempReport.setString(1, dayReportPojo.getGroupCode());
			psgetempReport.setString(2, dayReportPojo.getDesignation());
			psgetempReport.setString(3, dayReportPojo.getEmployeeId());
			psgetempReport.setString(4, HelperClass
					.convertUIToDatabase(dayReportPojo.getStartDate()));
			psgetempReport
					.setString(5, HelperClass.convertUIToDatabase(dayReportPojo
							.getEndDate()));
			rsgetempReport = psgetempReport.executeQuery();
		
			DayReportPojo dayReportDetails = null;
			String status = null;

			while (rsgetempReport.next()) {
				dayReportDetails = new DayReportPojo();
				dayReportDetails.setEmployeeId(rsgetempReport
						.getString("EMPID").trim());
				dayReportDetails.setEmployeeName(rsgetempReport.getString(
						"EMPNAME").trim());
				dayReportDetails.setLocationName(rsgetempReport.getString(
						"Location").trim());
				status = rsgetempReport.getString("status");
				dayReportDetails.setDesignation(rsgetempReport.getString(
						"designationName").trim());
				dayReportDetails.setInTime(rsgetempReport.getString("IN_TIME"));
				dayReportDetails.setOutTime(rsgetempReport
						.getString("OUT_TIME"));
				dayReportDetails.setLateTime(rsgetempReport
						.getString("LATE_TIME"));
				dayReportDetails.setEarlyTime(rsgetempReport
						.getString("EARLY_TIME"));
				dayReportDetails.setAttendenceDate(HelperClass
						.convertDatabaseToUI(rsgetempReport
								.getString("ATTENDANCE_DATE")));
				if (status.equalsIgnoreCase("present")) {
					status = "Present";

				} else {
					status = "Absent";

				}
				dayReportDetails.setAttendenceStatus(status);
				getemployeetReportList.add(dayReportDetails);
			}
		} catch (SQLException se) {
			logger.error(se);
		} catch (Exception e) {
			logger.error(e);
		} finally {
			try {
				if (psgetempReport != null && (!psgetempReport.isClosed())) {
					psgetempReport.getConnection().close();
				}
			} catch (Exception exception) {
				exception.printStackTrace();
				logger.error(exception);
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DayReportDaoImpl:getDayReportDetails Ending");

		return getemployeetReportList;

	}

}