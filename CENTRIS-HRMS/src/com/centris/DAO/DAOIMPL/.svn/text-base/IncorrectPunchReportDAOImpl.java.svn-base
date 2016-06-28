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
import com.centris.DAO.IncorrectPunchReportDAO;
import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.VO.IncorrectPunchReportVO;
import com.centris.form.IncorrectPunchReportForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class IncorrectPunchReportDAOImpl extends DBService implements
		IncorrectPunchReportDAO {
	private static Logger logger = Logger
			.getLogger(IncorrectPunchReportDAOImpl.class);


	@Override
	public synchronized List<IncorrectPunchReportVO> getIncorrectPunchReport(
			IncorrectPunchReportForm incorrectPunchReportForm) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in IncorrectPunchReportDAOImpl:getIncorrectPunchReport Starting");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<IncorrectPunchReportVO> detailedMonthReportList = new ArrayList<IncorrectPunchReportVO>();
		try {
			conn = getConnection();
			String temp_location="'"+incorrectPunchReportForm.getLocation().replaceAll(",","','")+"'";
			pstmt = conn.prepareStatement("select ipe.ATTEDANCE_DATE,el.Location ,ipe.EMP_ID,ed.EMPNAME,ipe.REASON from ai_bio_incorrect_punched_employees ipe,ai_emp_details ed,ai_emp_location el where ed.EMPID=ipe.EMP_ID and ed.Location=el.LocationCode and ed.EMPDESIGNATION like ? and ipe.EMP_ID like ? and ipe.EMP_ID in (select EMPID from ai_emp_details where Location in ("+temp_location+")) and ed.Location in (select LocationCode from onsite_groupmapping where Groupid=?) and ipe.ATTEDANCE_DATE between ? and ?  and ed.isActive='Y'  order by Location,ATTEDANCE_DATE,EMP_ID");
			pstmt.setString(1, incorrectPunchReportForm.getDesignation());
			pstmt.setString(2, incorrectPunchReportForm.getEmployee());
			pstmt.setString(3, incorrectPunchReportForm.getGroup());
			pstmt.setString(4, HelperClass.convertUIToDatabase(incorrectPunchReportForm.getStartDate()));
			pstmt.setString(5, HelperClass.convertUIToDatabase(incorrectPunchReportForm.getEndDate()));
			rs = pstmt.executeQuery();
			IncorrectPunchReportVO incorrectPunchReportVo = null;
			while (rs.next()) {
				incorrectPunchReportVo = new IncorrectPunchReportVO();
				incorrectPunchReportVo.setDate(HelperClass.convertDatabaseToUI(rs.getString("ATTEDANCE_DATE").trim()));
				incorrectPunchReportVo.setLocationName(rs.getString("Location").trim());
				incorrectPunchReportVo.setEmpId(rs.getString("EMP_ID").trim());
				incorrectPunchReportVo.setEmpName(rs.getString("EMPNAME").trim());
				incorrectPunchReportVo.setReason(rs.getString("REASON").trim());
				
				detailedMonthReportList.add(incorrectPunchReportVo);
			}
		} catch (SQLException se) {
			logger.error(se);
			se.printStackTrace();
		} catch (Exception e) {
			logger.error(e);
		} finally {
			try {

				if (pstmt!=null && (!pstmt.isClosed())) {
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
				+ " Control in IncorrectPunchReportDAOImpl:getIncorrectPunchReport Ending");

		return detailedMonthReportList;
	}

	
	@Override
	public synchronized List<ConsolidateDetailedMonthReportVO> getEmpDetailsByShiftWithMultipleLocation(
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
			String temp_location="'"+location.replaceAll(",","','")+"'";
			pstmt = conn.prepareStatement("select distinct EMPID,EMPNAME from ai_emp_details  where SHIFT_ID like ? and  isActive='Y' and iSinMultiLocations='N' and SHIFT_ID in (select distinct AI_SHIFT_ID from ai_shift_deatails where  Location in("+temp_location+") and Location in (select LocationCode from onsite_groupmapping where Groupid=? )) order by EMPNAME");
			pstmt.setString(1, shift);
			pstmt.setString(2, group);
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

				if (pstmt!=null && (!pstmt.isClosed())) 
				{
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