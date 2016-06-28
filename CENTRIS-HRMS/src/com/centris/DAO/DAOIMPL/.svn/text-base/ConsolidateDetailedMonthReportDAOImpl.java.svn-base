package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.ConsolidateDetailedMonthReportDAO;
import com.centris.DAO.DBService;
import com.centris.VO.ConsolidateDetailedDayReportVO;
import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.VO.DetailedMonthVo_Report;
import com.centris.form.ConsolidateDetailedMonthReportForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class ConsolidateDetailedMonthReportDAOImpl extends DBService implements
		ConsolidateDetailedMonthReportDAO {
	private static Logger logger = Logger
			.getLogger(ConsolidateDetailedMonthReportDAOImpl.class);

	public synchronized List<ConsolidateDetailedMonthReportVO> getEmpDetailsByShift(
			String shift, String group, String location) {
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
			pstmt = conn.prepareStatement(SQLutilConstants.GET_EMP_BY_SHIFT);
			pstmt.setString(1, shift);
			pstmt.setString(2, location);
			pstmt.setString(3, group);

			rsshiftnames = pstmt.executeQuery();
			ConsolidateDetailedMonthReportVO consolidateDetailedMonthReportVo = null;
			while (rsshiftnames.next()) {
				consolidateDetailedMonthReportVo = new ConsolidateDetailedMonthReportVO();
				consolidateDetailedMonthReportVo.setEmpid(rsshiftnames
						.getString("EMPID").trim());
				consolidateDetailedMonthReportVo.setEmpname(rsshiftnames
						.getString("EMPNAME").trim());
				empList.add(consolidateDetailedMonthReportVo);

			}
		} catch (SQLException se) {
			logger.error(se);
			logger.error(se.getMessage(), se);
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
				+ " Control in ConsolidateDetailedMonthReportDAOImpl:getEmpDetailsByShift Ending");

		return empList;
	}

	@Override
	public synchronized List<ConsolidateDetailedMonthReportVO> getConsolidatedMonthReport(
			ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportDAOImpl:getConsolidatedMonthReport Starting");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsshiftnames = null;
		List<ConsolidateDetailedMonthReportVO> empList = new ArrayList<ConsolidateDetailedMonthReportVO>();
		try {
			conn = getConnection();
			String temp_location = "'"
					+ consolidateDetailedMonthReportForm.getLocation()
							.replaceAll(",", "','") + "'";
			pstmt = conn
					.prepareStatement("select distinct bt.EMP_ID,ed.EMPNAME,el.Location,edes.designationName,group_concat(bt.TOTAL_WORKING_HOURS) totalWorkingHours,group_concat(bt.LATE_TIME) totalLateTime,group_concat(bt.EARLY_TIME) totalEarlyTime,sum(case when ea.status='present' then 1 else 0 end) totalPresent   from ai_bio_timesheet bt,ai_emp_details ed,ai_emp_location el,ai_emp_designation edes,ai_emp_attendance ea,onsite_groupmapping gm where gm.LocationCode=ed.Location and ea.empid=ed.EMPID and  bt.EMP_ID=ed.EMPID and ed.EMPDESIGNATION=edes.designationId and ed.Location=el.LocationCode  and bt.ATTENDANCE_DATE=ea.DATE  and gm.Groupid=? and ed.Location in ("
							+ temp_location
							+ ") and ed.EMPDESIGNATION like ?  and bt.EMP_ID like ?  and bt.EMP_ID in (select EMPID from ai_emp_details where Location in ("
							+ temp_location
							+ ")) and bt.ATTENDANCE_DATE like ?  and ed.isActive='Y' and  ea.status='present' group by EMP_ID,EMPNAME,Location,designationName order by Location,EMP_ID");
			pstmt.setString(1, consolidateDetailedMonthReportForm.getGroup());
			pstmt.setString(2,
					consolidateDetailedMonthReportForm.getDesignation());
			pstmt.setString(3, consolidateDetailedMonthReportForm.getEmployee());
			pstmt.setString(4, consolidateDetailedMonthReportForm.getYear()
					+ "-" + consolidateDetailedMonthReportForm.getMonth() + "%");

			rsshiftnames = pstmt.executeQuery();
			ConsolidateDetailedMonthReportVO consolidateDetailedMonthReportVo = null;

			while (rsshiftnames.next()) {
				consolidateDetailedMonthReportVo = new ConsolidateDetailedMonthReportVO();
				consolidateDetailedMonthReportVo.setEmpid(rsshiftnames
						.getString("EMP_ID").trim());
				consolidateDetailedMonthReportVo.setEmpname(rsshiftnames
						.getString("EMPNAME").trim());
				consolidateDetailedMonthReportVo.setLocationName(rsshiftnames
						.getString("Location").trim());
				consolidateDetailedMonthReportVo
						.setDesignationName(rsshiftnames.getString(
								"designationName").trim());
				consolidateDetailedMonthReportVo.setTotalPresent(rsshiftnames
						.getString("totalPresent"));
				String totalLatetime = "00:00:00";
				if (rsshiftnames.getString("totalLateTime") != null) {
					totalLatetime = HelperClass.addTimeArray(rsshiftnames
							.getString("totalLateTime").split(","));
				}
				consolidateDetailedMonthReportVo.setLateTime(totalLatetime);
				String totalEarlyTime = "00:00:00";
				if (rsshiftnames.getString("totalEarlyTime") != null) {
					totalEarlyTime = HelperClass.addTimeArray(rsshiftnames
							.getString("totalEarlyTime").split(","));
				}
				consolidateDetailedMonthReportVo.setEarlyTime(totalEarlyTime);
				String totalWorkingHours = "00:00:00";
				if (rsshiftnames.getString("totalWorkingHours") != null) {
					totalWorkingHours = HelperClass.addTimeArray(rsshiftnames
							.getString("totalWorkingHours").split(","));
				}
				consolidateDetailedMonthReportVo
						.setTotalWorkingHours(totalWorkingHours);

				empList.add(consolidateDetailedMonthReportVo);
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
				+ " Control in ConsolidateDetailedMonthReportDAOImpl:getConsolidatedMonthReport Ending");

		return empList;
	}

	@Override
	public synchronized List<ConsolidateDetailedMonthReportVO> getDetailedMonthReport(
			ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportDAOImpl:getDetailedMonthReport Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsshiftnames = null;
		List<ConsolidateDetailedMonthReportVO> detailedMonthReportList = new ArrayList<ConsolidateDetailedMonthReportVO>();
		try {
			conn = getConnection();
			String temp_location = "'"
					+ consolidateDetailedMonthReportForm.getLocation()
							.replaceAll(",", "','") + "'";
			pstmt = conn
					.prepareStatement("select distinct bt.EMP_ID,ed.EMPNAME,el.Location,edes.designationName,bt.ATTENDANCE_DATE,case when bt.IN_TIME='00:00:00' then '-' else bt.IN_TIME end IN_TIME,case when bt.OUT_TIME='00:00:00' then '-' else bt.OUT_TIME end OUT_TIME,case when bt.TOTAL_HOURS='00:00:00' then '-' else bt.TOTAL_HOURS end TOTAL_HOURS,case when bt.TOTAL_WORKING_HOURS='00:00:00' then '-' else bt.TOTAL_WORKING_HOURS end TOTAL_WORKING_HOURS,case when bt.LATE_TIME='00:00:00' then '-' else bt.LATE_TIME end LATE_TIME,case when bt.EARLY_TIME='00:00:00' then '-' else bt.EARLY_TIME end EARLY_TIME,case when ea.status ='present' then 'Present' else 'Absent' end status from ai_bio_timesheet bt,ai_emp_details ed,ai_emp_location el,ai_emp_designation edes,ai_emp_attendance ea,onsite_groupmapping gm where gm.LocationCode=ed.Location and ea.empid=ed.EMPID and bt.EMP_ID=ed.EMPID  and ed.EMPDESIGNATION=edes.designationId and ed.Location=el.LocationCode  and bt.ATTENDANCE_DATE=ea.DATE  and gm.Groupid=? and  ed.Location in ("
							+ temp_location
							+ ") and ed.EMPDESIGNATION like ?  and bt.EMP_ID like ? and bt.EMP_ID in (select EMPID from ai_emp_details where Location in ("
							+ temp_location
							+ ")) and bt.ATTENDANCE_DATE like ?  and ed.isActive='Y'  order by Location,ATTENDANCE_DATE,EMP_ID");
			pstmt.setString(1, consolidateDetailedMonthReportForm.getGroup());
			pstmt.setString(2,
					consolidateDetailedMonthReportForm.getDesignation());
			pstmt.setString(3, consolidateDetailedMonthReportForm.getEmployee());
			pstmt.setString(4, consolidateDetailedMonthReportForm.getYear()
					+ "-" + consolidateDetailedMonthReportForm.getMonth() + "%");

			rsshiftnames = pstmt.executeQuery();
			ConsolidateDetailedMonthReportVO consolidateDetailedMonthReportVo = null;
			while (rsshiftnames.next()) {

				consolidateDetailedMonthReportVo = new ConsolidateDetailedMonthReportVO();

				consolidateDetailedMonthReportVo.setEmpid(rsshiftnames
						.getString("EMP_ID").trim());
				consolidateDetailedMonthReportVo.setEmpname(rsshiftnames
						.getString("EMPNAME").trim());
				consolidateDetailedMonthReportVo.setLocationName(rsshiftnames
						.getString("Location").trim());
				consolidateDetailedMonthReportVo
						.setDesignationName(rsshiftnames.getString(
								"designationName").trim());
				consolidateDetailedMonthReportVo.setDate(HelperClass
						.convertDatabaseToUI(
								rsshiftnames.getString("ATTENDANCE_DATE"))
						.trim());
				consolidateDetailedMonthReportVo
						.setAttendenceStatus(rsshiftnames.getString("status"));
				consolidateDetailedMonthReportVo.setInTime(rsshiftnames
						.getString("IN_TIME").trim());
				consolidateDetailedMonthReportVo.setOutTime(rsshiftnames
						.getString("OUT_TIME").trim());
				consolidateDetailedMonthReportVo.setLateTime(rsshiftnames
						.getString("LATE_TIME").trim());
				consolidateDetailedMonthReportVo.setEarlyTime(rsshiftnames
						.getString("EARLY_TIME").trim());
				consolidateDetailedMonthReportVo.setTotalHours(rsshiftnames
						.getString("TOTAL_HOURS").trim());
				consolidateDetailedMonthReportVo
						.setTotalWorkingHours(rsshiftnames.getString(
								"TOTAL_WORKING_HOURS").trim());

				detailedMonthReportList.add(consolidateDetailedMonthReportVo);
			}
		} catch (SQLException se) {
			logger.error(se);
			se.printStackTrace();
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
				+ " Control in ConsolidateDetailedMonthReportDAOImpl:getDetailedMonthReport Ending");

		return detailedMonthReportList;
	}

	public synchronized List<ConsolidateDetailedMonthReportVO> getConsolidatedMonthReportN(
			ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm,
			String selectedDate, Connection dbconn) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportDAOImpl:getConsolidatedMonthReport Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsshiftnames = null;
		List<ConsolidateDetailedMonthReportVO> empList = new ArrayList<ConsolidateDetailedMonthReportVO>();
		try {
			conn = dbconn;
			String temp_location = "'"
					+ consolidateDetailedMonthReportForm.getLocation()
							.replaceAll(",", "','") + "'";
			pstmt = conn
					.prepareStatement("select ed.EMPID,ed.EMPNAME,edes.designationName,dd.DEPT_NAME,bt.ATTENDANCE_DATE,el.Location,case when att.status='present' then 'Present' else 'Absent' end status, case when bt.TOTAL_WORKING_HOURS ='00:00:00' then '-' else bt.TOTAL_WORKING_HOURS end totalWorkingHours,case when bt.LATE_TIME ='00:00:00' then '-' else bt.LATE_TIME end totalLateTime,case when bt.EARLY_TIME ='00:00:00' then '-' else bt.EARLY_TIME end totalEarlyTime,case when att.status='present' then 'Present' else 'Absent' end totalPresent from ai_emp_details ed join ai_emp_designation edes on ed.EMPDESIGNATION=edes.designationId join ai_bio_department dd on dd.DEPT_ID=ed.DEPARTMENT join ai_emp_attendance att on att.empid=ed.EMPID join ai_bio_timesheet bt on bt.EMP_ID = ed.EMPID and bt.ATTENDANCE_DATE=att.DATE join ai_emp_location el on el.LocationCode=ed.Location join onsite_groupmapping gm on gm.LocationCode=ed.Location where  gm.Groupid=? and  el.LocationCode in ("
							+ temp_location
							+ ") and ed.EMPDESIGNATION like ?  and bt.EMP_ID like ? and bt.EMP_ID in (select EMPID from ai_emp_details where Location in ("
							+ temp_location
							+ ")) and bt.ATTENDANCE_DATE = ? and ed.isActive='Y'  order by Location,ATTENDANCE_DATE,EMPID ");
			pstmt.setString(1, consolidateDetailedMonthReportForm.getGroup());
			pstmt.setString(2,
					consolidateDetailedMonthReportForm.getDesignation());
			pstmt.setString(3, consolidateDetailedMonthReportForm.getEmployee());
			pstmt.setString(4, selectedDate);
			rsshiftnames = pstmt.executeQuery();
			ConsolidateDetailedMonthReportVO consolidateDetailedMonthReportVo = null;

			while (rsshiftnames.next()) {
				consolidateDetailedMonthReportVo = new ConsolidateDetailedMonthReportVO();
				consolidateDetailedMonthReportVo.setDate(rsshiftnames
						.getString("ATTENDANCE_DATE").trim());
				consolidateDetailedMonthReportVo.setEmpid(rsshiftnames
						.getString("EMPID").trim());
				consolidateDetailedMonthReportVo.setEmpname(rsshiftnames
						.getString("EMPNAME").trim());
				consolidateDetailedMonthReportVo.setLocationName(rsshiftnames
						.getString("Location").trim());
				consolidateDetailedMonthReportVo
						.setDesignationName(rsshiftnames.getString(
								"designationName").trim());
				consolidateDetailedMonthReportVo.setTotalPresent(rsshiftnames
						.getString("status").trim());
				consolidateDetailedMonthReportVo.setLateTime(rsshiftnames
						.getString("totalLateTime").trim());
				consolidateDetailedMonthReportVo.setEarlyTime(rsshiftnames
						.getString("totalEarlyTime").trim());
				consolidateDetailedMonthReportVo
						.setTotalWorkingHours(rsshiftnames.getString(
								"totalWorkingHours").trim());
				empList.add(consolidateDetailedMonthReportVo);
			}
			pstmt.close();
		} catch (SQLException se) {
			logger.error(se);
			se.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
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
				+ " Control in ConsolidateDetailedMonthReportDAOImpl:getConsolidatedMonthReport Ending");
		return empList;
	}

	public synchronized List<ConsolidateDetailedDayReportVO> consolidatedMonthReport_forDay(
			ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportDAOImpl : consolidatedMonthReport_forDay Starting");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet day_Consilidated = null;
		List<ConsolidateDetailedDayReportVO> empList = new ArrayList<ConsolidateDetailedDayReportVO>();
		try {
			conn = getConnection();
			String temp_location = "'"
					+ consolidateDetailedMonthReportForm.getLocation()
							.replaceAll(",", "','") + "'";
			pstmt = conn
					.prepareStatement("select ed.EMPID,ed.EMPNAME,edes.designationName,dd.DEPT_NAME,case when att.status ='present' then 'Present' else 'Absent' end status,bt.ATTENDANCE_DATE,el.Location,case when bt.TOTAL_WORKING_HOURS ='00:00:00' then '-' else bt.TOTAL_WORKING_HOURS end totalWorkingHours,case when bt.LATE_TIME ='00:00:00' then '-' else bt.LATE_TIME end totalLateTime,case when bt.EARLY_TIME ='00:00:00' then '-' else bt.EARLY_TIME end totalEarlyTime,case when att.status='present' then 'Present' else 'Absent' end totalPresent from ai_emp_details ed join ai_emp_designation edes on ed.EMPDESIGNATION=edes.designationId join ai_bio_department dd on dd.DEPT_ID=ed.DEPARTMENT join ai_emp_attendance att on att.empid=ed.EMPID join ai_bio_timesheet bt on bt.EMP_ID = ed.EMPID and bt.ATTENDANCE_DATE=att.DATE join ai_emp_location el on el.LocationCode=ed.Location join onsite_groupmapping gm on gm.LocationCode=ed.Location where  gm.Groupid=? and  el.LocationCode in ("
							+ temp_location
							+ ") and ed.EMPDESIGNATION like ?  and bt.EMP_ID like ? and bt.EMP_ID in (select EMPID from ai_emp_details where Location in ("
							+ temp_location
							+ ")) and bt.ATTENDANCE_DATE = ? and ed.isActive='Y'  order by Location,ATTENDANCE_DATE,EMPID");
			pstmt.setString(1, consolidateDetailedMonthReportForm.getGroup()
					.trim());
			pstmt.setString(2, consolidateDetailedMonthReportForm
					.getDesignation().trim());
			pstmt.setString(3, consolidateDetailedMonthReportForm.getEmployee()
					.trim());
			pstmt.setString(4, HelperClass
					.convertUIToDatabase(consolidateDetailedMonthReportForm
							.getYear().trim()));

			day_Consilidated = pstmt.executeQuery();
			ConsolidateDetailedDayReportVO consolidateDetailedMonthReportVo = null;

			while (day_Consilidated.next()) {
				consolidateDetailedMonthReportVo = new ConsolidateDetailedDayReportVO();
				consolidateDetailedMonthReportVo.setDate(day_Consilidated
						.getString("ATTENDANCE_DATE").trim());
				consolidateDetailedMonthReportVo.setEmpid(day_Consilidated
						.getString("EMPID").trim());
				consolidateDetailedMonthReportVo.setEmpname(day_Consilidated
						.getString("EMPNAME").trim());
				consolidateDetailedMonthReportVo
						.setLocationName(day_Consilidated.getString("Location")
								.trim());
				consolidateDetailedMonthReportVo
						.setDesignationName(day_Consilidated.getString(
								"designationName").trim());
				consolidateDetailedMonthReportVo
						.setTotalPresent(day_Consilidated.getString("status")
								.trim());
				consolidateDetailedMonthReportVo.setLateTime(day_Consilidated
						.getString("totalLateTime").trim());
				consolidateDetailedMonthReportVo.setEarlyTime(day_Consilidated
						.getString("totalEarlyTime").trim());
				consolidateDetailedMonthReportVo
						.setTotalWorkingHours(day_Consilidated.getString(
								"totalWorkingHours").trim());
				empList.add(consolidateDetailedMonthReportVo);
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
				+ " Control in ConsolidateDetailedMonthReportDAOImpl : consolidatedMonthReport_forDay Ending");

		return empList;
	}

	@Override
	public synchronized List<ConsolidateDetailedMonthReportVO> getEmpDetailsByDesiWithMultipleLocation(
			String designation, String group, String location) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportDAOImpl:getEmpDetailsByDesiWithMultipleLocation Starting");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsshiftnames = null;

		List<ConsolidateDetailedMonthReportVO> empList = new ArrayList<ConsolidateDetailedMonthReportVO>();
		try {
			conn = getConnection();
			String temp_location = "'" + location.replaceAll(",", "','") + "'";
			pstmt = conn
					.prepareStatement("select distinct EMPID,EMPNAME from ai_emp_details  where EMPDESIGNATION like ? and  isActive='Y' and iSinMultiLocations='N' and  Location in ("
							+ temp_location
							+ ") and Location in (select LocationCode from onsite_groupmapping where Groupid=? ) order by EMPNAME");
			pstmt.setString(1, designation);
			pstmt.setString(2, group);
			System.out.println("Emp Details:::::::" + pstmt);
			rsshiftnames = pstmt.executeQuery();
			ConsolidateDetailedMonthReportVO consolidateDetailedMonthReportVo = null;
			while (rsshiftnames.next()) {
				consolidateDetailedMonthReportVo = new ConsolidateDetailedMonthReportVO();
				consolidateDetailedMonthReportVo.setEmpid(rsshiftnames
						.getString("EMPID").trim());
				consolidateDetailedMonthReportVo.setEmpname(rsshiftnames
						.getString("EMPNAME").trim());
				empList.add(consolidateDetailedMonthReportVo);

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
				+ " Control in ConsolidateDetailedMonthReportDAOImpl:getEmpDetailsByDesiWithMultipleLocation Ending");

		return empList;
	}

	public List<DetailedMonthVo_Report> getDetailedReport(
			ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm) {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportDAOImpl:getDetailedReport Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsshiftnames = null;
		List<DetailedMonthVo_Report> detailedReportList = new ArrayList<DetailedMonthVo_Report>();
		try {
			conn = getConnection();
			String temp_location = "'"
					+ consolidateDetailedMonthReportForm.getLocation()
							.replaceAll(",", "','") + "'";
			pstmt = conn
					.prepareStatement("select distinct bt.EMP_ID,ed.EMPNAME,el.Location,edes.designationName,bt.ATTENDANCE_DATE,case when bt.IN_TIME='00:00:00' then '-' else bt.IN_TIME end IN_TIME,case when bt.OUT_TIME='00:00:00' then '-' else bt.OUT_TIME end OUT_TIME,case when bt.TOTAL_HOURS='00:00:00' then '-' else bt.TOTAL_HOURS end TOTAL_HOURS,case when bt.TOTAL_WORKING_HOURS='00:00:00' then '-' else bt.TOTAL_WORKING_HOURS end TOTAL_WORKING_HOURS,case when bt.LATE_TIME='00:00:00' then '-' else bt.LATE_TIME end LATE_TIME,case when bt.EARLY_TIME='00:00:00' then '-' else bt.EARLY_TIME end EARLY_TIME,case when ea.status ='present' then 'Present' else 'Absent' end status from ai_bio_timesheet bt,ai_emp_details ed,ai_emp_location el,ai_emp_designation edes,ai_emp_attendance ea,onsite_groupmapping gm where gm.LocationCode=ed.Location and ea.empid=ed.EMPID and bt.EMP_ID=ed.EMPID  and ed.EMPDESIGNATION=edes.designationId and ed.Location=el.LocationCode  and bt.ATTENDANCE_DATE=ea.DATE  and gm.Groupid=? and  ed.Location in ("
							+ temp_location
							+ ") and ed.SHIFT_ID like ?  and bt.EMP_ID like ? and bt.EMP_ID in (select EMPID from ai_emp_details where Location in ("
							+ temp_location
							+ ")) and bt.ATTENDANCE_DATE like ?  and ed.isActive='Y'  order by Location,ATTENDANCE_DATE,EMP_ID");
			pstmt.setString(1, consolidateDetailedMonthReportForm.getGroup());
			pstmt.setString(2,
					consolidateDetailedMonthReportForm.getDesignation());
			pstmt.setString(3, consolidateDetailedMonthReportForm.getEmployee());
			pstmt.setString(4, consolidateDetailedMonthReportForm.getYear()
					+ "-" + consolidateDetailedMonthReportForm.getMonth() + "%");

			rsshiftnames = pstmt.executeQuery();
			DetailedMonthVo_Report consolidateDetailedMonthReportVo = null;
			while (rsshiftnames.next()) {

				consolidateDetailedMonthReportVo = new DetailedMonthVo_Report();

				consolidateDetailedMonthReportVo.setEmpid(rsshiftnames
						.getString("EMP_ID").trim());
				consolidateDetailedMonthReportVo.setEmpname(rsshiftnames
						.getString("EMPNAME").trim());
				consolidateDetailedMonthReportVo.setLocationName(rsshiftnames
						.getString("Location").trim());
				consolidateDetailedMonthReportVo
						.setDesignationName(rsshiftnames.getString(
								"designationName").trim());
				consolidateDetailedMonthReportVo.setDate(HelperClass
						.convertDatabaseToUI(
								rsshiftnames.getString("ATTENDANCE_DATE"))
						.trim());
				consolidateDetailedMonthReportVo
						.setAttendenceStatus(rsshiftnames.getString("status"));
				consolidateDetailedMonthReportVo.setInTime(rsshiftnames
						.getString("IN_TIME").trim());
				consolidateDetailedMonthReportVo.setOutTime(rsshiftnames
						.getString("OUT_TIME").trim());
				consolidateDetailedMonthReportVo.setLateTime(rsshiftnames
						.getString("LATE_TIME").trim());
				consolidateDetailedMonthReportVo.setEarlyTime(rsshiftnames
						.getString("EARLY_TIME").trim());
				consolidateDetailedMonthReportVo.setTotalHours(rsshiftnames
						.getString("TOTAL_HOURS").trim());
				consolidateDetailedMonthReportVo
						.setTotalWorkingHours(rsshiftnames.getString(
								"TOTAL_WORKING_HOURS").trim());

				detailedReportList.add(consolidateDetailedMonthReportVo);
			}
		} catch (SQLException se) {
			logger.error(se);
			se.printStackTrace();
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
				+ " Control in ConsolidateDetailedMonthReportDAOImpl:getDetailedReport Ending");

		return detailedReportList;
	}

	public synchronized List<ConsolidateDetailedMonthReportVO> getEmpDetailsByDesignation(
			String designation, String group, String location) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportDAOImpl: getEmpDetailsByDesignation Starting");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsshiftnames = null;

		List<ConsolidateDetailedMonthReportVO> empList = new ArrayList<ConsolidateDetailedMonthReportVO>();
		try {
			String temp_location = "'" + location.replaceAll(",", "','") + "'";
			conn = getConnection();
			pstmt = conn
					.prepareStatement("select distinct EMPID,EMPNAME from ai_emp_details  where EMPDESIGNATION like ? and  isActive='Y' and iSinMultiLocations='N' and Location in (select LocationCode from onsite_groupmapping where Groupid=? and LocationCode in("
							+ temp_location + ")) order by EMPNAME");
			pstmt.setString(1, designation.trim());
			pstmt.setString(2, group.trim());
			rsshiftnames = pstmt.executeQuery();
			ConsolidateDetailedMonthReportVO consolidateDetailedMonthReportVo = null;
			while (rsshiftnames.next()) {
				consolidateDetailedMonthReportVo = new ConsolidateDetailedMonthReportVO();
				consolidateDetailedMonthReportVo.setEmpid(rsshiftnames
						.getString("EMPID").trim());
				consolidateDetailedMonthReportVo.setEmpname(rsshiftnames
						.getString("EMPNAME").trim());
				empList.add(consolidateDetailedMonthReportVo);
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
				+ " Control in ConsolidateDetailedMonthReportDAOImpl: getEmpDetailsByDesignation Ending");

		return empList;
	}
}