package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.AttendanceDetailaViewInEmployeeDao;
import com.centris.DAO.DBService;
import com.centris.VO.AttendanceDetailaViewInEmployeeVo;
import com.centris.VO.EmployeeDashboardVO;
import com.centris.form.AttendanceDetailaViewInEmployeeForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.EmployeeDashboard;
import com.centris.util.constants.MessageConstants;

public class AttendanceDetailaViewInEmployeeDaoImpl extends DBService implements AttendanceDetailaViewInEmployeeDao{
	
	
	private static Logger logger = Logger.getLogger(AttendanceDetailaViewInEmployeeDaoImpl.class);
	
	public ArrayList<AttendanceDetailaViewInEmployeeVo> getMoreAttendanceDetailsDao(AttendanceDetailaViewInEmployeeForm attform,String userId){
	
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceDetailaViewInEmployeeDaoImpl: getMoreAttendanceDetailsDao Starting");
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		ArrayList<AttendanceDetailaViewInEmployeeVo> employeeAttendance=new ArrayList<AttendanceDetailaViewInEmployeeVo>();
		int sno=0;
		
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(EmployeeDashboard.GET_EMPLOYEE_ATTENDANCE);
			pstmt.setString(1, userId);
			pstmt.setString(2, HelperClass.convertUIToDatabase(attform.getStartdate()));
			pstmt.setString(3, HelperClass.convertUIToDatabase(attform.getEnddate()));
			
			
			System.out.println("pstmt ::: "+pstmt.toString());
			
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AttendanceDetailaViewInEmployeeVo empAttVo=new AttendanceDetailaViewInEmployeeVo();
				sno++;
				
				empAttVo.setSno(sno);
				empAttVo.setAttendanceDate(HelperClass.convertDatabaseToUI(rs.getString("Attendence_Date")));
				empAttVo.setIntime(rs.getString("intime"));
				empAttVo.setOuttime(rs.getString("outtime")); 
				empAttVo.setTotaltime(rs.getString("totaltime")); 
				if("".equalsIgnoreCase(rs.getString("ClientName")) || rs.getString("ClientName")==null){
				empAttVo.setProjectname("-"); 
				}else{
					
					empAttVo.setProjectname(rs.getString("ClientName")); 
				}
				
				empAttVo.setReportingto(getReportingPerson(rs.getString("ManagerCode"))); 
				if("".equalsIgnoreCase(rs.getString("StatusType")) || rs.getString("StatusType")==null){
				empAttVo.setAttendancestatustype("-"); 
				}else{
					
					empAttVo.setAttendancestatustype(rs.getString("StatusType")); 
				}
				empAttVo.setAttendancestatus(rs.getString("Attedence_Status"));
				if("".equalsIgnoreCase(rs.getString("Location")) || rs.getString("Location")==null){
					
					empAttVo.setLocation("-");
				}else{
				
					empAttVo.setLocation(rs.getString("Location"));
				}
				
				if(rs.getString("isAproved").equalsIgnoreCase("Y")){
					
					empAttVo.setApprovedstatus("Approved");
				}else{
					
					empAttVo.setApprovedstatus("Not Approved");
				}
				
				if(rs.getString("isPosted").equalsIgnoreCase("Y")){
					
					empAttVo.setPostedstatus("Posted");
				}else{
					
					empAttVo.setPostedstatus("Not Posted");
				}
				
				
				employeeAttendance.add(empAttVo);
				
				
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {
				
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			}
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceDetailaViewInEmployeeDaoImpl: getMoreAttendanceDetailsDao Ending");
		
		
		return employeeAttendance;
	}
	
	public static void main(String[] args) {
		
		AttendanceDetailaViewInEmployeeForm form=new AttendanceDetailaViewInEmployeeForm();
		form.setStartdate("01-07-2015");
		form.setEnddate("30-07-2015");
		
		new AttendanceDetailaViewInEmployeeDaoImpl().getMoreAttendanceDetailsDao(form, "EMP1");
	}
	
	
	
	public String getReportingPerson(String userId){
	
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceDetailaViewInEmployeeDaoImpl: getReportingPerson Starting");
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String ReportingPersonName="-";
		
		try {
			connection = getConnection();
			
			System.out.println("userId ::: "+userId);
			
			if(!("".equalsIgnoreCase(userId)) && userId!=null){
				
				System.out.println(userId.substring(0, 2));
			
			if(userId.substring(0, 3).equalsIgnoreCase("MAN")){
				
				
				
			pstmt = connection.prepareStatement(EmployeeDashboard.GET_MANAGER);
			
			}else{
				
				pstmt = connection.prepareStatement(EmployeeDashboard.GET_DIRECTOR);
			}
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
				
				
				ReportingPersonName=rs.getString("name");
			}
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {
				
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			}
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceDetailaViewInEmployeeDaoImpl: getReportingPerson Ending");
		
		
		return ReportingPersonName;
	}


}
