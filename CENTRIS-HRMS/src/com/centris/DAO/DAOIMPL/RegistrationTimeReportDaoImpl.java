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
import com.centris.DAO.RegistrationTimeReportDao;
import com.centris.VO.RegistrationTimeReportVo;
import com.centris.form.RegistrationTimeReportForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class RegistrationTimeReportDaoImpl extends DBService implements
		RegistrationTimeReportDao {
	private static Logger logger = Logger
			.getLogger(RegistrationTimeReportDaoImpl.class);

	public synchronized List<RegistrationTimeReportVo> getRegistrationDetails(
			RegistrationTimeReportForm formObj) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RegistrationTimeReportDaoImpl : getRegistrationDetails Starting");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsEmp = null;
		int i = 0;
		List<RegistrationTimeReportVo> regDetails = new ArrayList<RegistrationTimeReportVo>();
		regDetails.clear();
		try {
			String allLocations = "'"
					+ formObj.getLocation().trim().replaceAll(",", "','") + "'";
			String monthYear = formObj.getYear().trim() + "-"
					+ formObj.getMonth().trim() + "%";

			conn = getConnection();
			pstmt = conn
					.prepareStatement("select emp.EMPID,emp.EMPNAME,emp.PHONE,des.designationName,loc.Location,grp.GroupName,emp.createdate,usr.username from ai_emp_details emp join ai_emp_designation des on emp.EMPDESIGNATION=des.designationId join ai_emp_location loc on loc.LocationCode=emp.Location join onsite_groupmapping ogm on ogm.LocationCode=emp.Location join onsite_group grp on grp.Gorupid=ogm.Groupid join ai_user usr on usr.userCode=emp.CREATEUSER where ogm.Groupid=? and emp.Location in ("
							+ allLocations
							+ ") and emp.createdate like ? and emp.isActive='Y' order by emp.CREATEDATE asc ");

			pstmt.setString(1, formObj.getGroup().trim());
			pstmt.setString(2, monthYear.trim());
			rsEmp = pstmt.executeQuery();
			RegistrationTimeReportVo regTimeVO = null;
			while (rsEmp.next()) {
				i = ++i;
				regTimeVO = new RegistrationTimeReportVo();
				regTimeVO.setEmployeeId(rsEmp.getString("EMPID"));
				regTimeVO.setEmployeeName(rsEmp.getString("EMPNAME"));
				regTimeVO.setEmployeePhone(rsEmp.getString("PHONE"));
				regTimeVO.setEmployeeDesignation(rsEmp
						.getString("designationName"));
				regTimeVO.setEmployeeLocation(rsEmp.getString("Location"));

				String reg1 = rsEmp.getString("createdate").substring(0, 11);
				String reg2 = rsEmp.getString("createdate").substring(11, 19);

				regTimeVO.setEmployeeCreatedDate(HelperClass
						.convertDatabaseToUI(reg1) + " " + reg2);
				regTimeVO.setCreatedBy(rsEmp.getString("username"));
				regTimeVO.setSno(String.valueOf(i));
				regDetails.add(regTimeVO);
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
				if (conn != null && (!conn.isClosed())) {
					conn.close();
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
				+ " Control in RegistrationTimeReportDaoImpl : getRegistrationDetails Ending");

		return regDetails;
	}
}