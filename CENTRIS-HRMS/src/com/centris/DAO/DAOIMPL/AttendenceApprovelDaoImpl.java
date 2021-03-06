package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.AttendenceApprovelDao;
import com.centris.DAO.DBService;
import com.centris.POJO.AttendenceApprovelPojo;
import com.centris.VO.AttendenceApprovelVo;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AttendenceDetails;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class AttendenceApprovelDaoImpl extends DBService implements AttendenceApprovelDao{
	
	private static Logger logger = Logger.getLogger(AttendenceApprovelDaoImpl.class);
	
	public  ArrayList<AttendenceApprovelVo> getEmployees(String managerid,String userType) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelDaoImpl: getEmployees : Starting");
		
		PreparedStatement ps_att_aprl = null;
		ResultSet rs_att_aprl = null;
		Connection connection = null;
		ArrayList<AttendenceApprovelVo> emp_list=new ArrayList<AttendenceApprovelVo>();

		try {
			connection = getConnection();
			
			if(userType.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)){
			ps_att_aprl = connection.prepareStatement(AttendenceDetails.GET_EMP_BASEDON_MGR);
			}else{
				
			ps_att_aprl = connection.prepareStatement(AttendenceDetails.GET_EMP_BASEDON_DIR);
			
			}
			ps_att_aprl.setString(1, managerid);
			
			rs_att_aprl = ps_att_aprl.executeQuery();

				while(rs_att_aprl.next()){
					
					AttendenceApprovelVo attvo=new AttendenceApprovelVo();
					
					attvo.setEmpid(rs_att_aprl.getString("EMPID"));
					attvo.setEmpname(rs_att_aprl.getString("First_Name"));
					
					emp_list.add(attvo);
					
					
					
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (rs_att_aprl != null && (!rs_att_aprl.isClosed())) {

					rs_att_aprl.close();
				}
				if (ps_att_aprl != null && (!ps_att_aprl.isClosed())) {

					ps_att_aprl.close();
				}
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelDaoImpl: getEmployees : Ending");
		
		return emp_list;

	}
	
	
	public  ArrayList<AttendenceApprovelVo> getEmployeeAttendance(AttendenceApprovelPojo att_pojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelDaoImpl: getEmployeeAttendance : Starting");
		
		PreparedStatement ps_att_aprl = null;
		ResultSet rs_att_aprl = null;
		Connection connection = null;
		ArrayList<AttendenceApprovelVo> attendence_list=new ArrayList<AttendenceApprovelVo>();
		int count=0;

		try {
			connection = getConnection();
			
			ps_att_aprl = connection.prepareStatement(AttendenceDetails.GET_EMP_ATTENDENCE_BY_MONTH);
			ps_att_aprl.setString(1, att_pojo.getEmployeeid());
			ps_att_aprl.setString(2, att_pojo.getStartdate());
			ps_att_aprl.setString(3, att_pojo.getEnddate());
			
			
			rs_att_aprl = ps_att_aprl.executeQuery();

				while(rs_att_aprl.next()){
					
					AttendenceApprovelVo attvo=new AttendenceApprovelVo();
					count++;
					attvo.setEmpid(rs_att_aprl.getString("EMPID"));
					attvo.setEmpname(rs_att_aprl.getString("First_Name"));
					attvo.setAttendencedate(HelperClass.convertDatabaseToUI(rs_att_aprl.getString("Attendence_Date")));
					attvo.setAttendancestatus(rs_att_aprl.getString("Attedence_Status"));
					attvo.setIntime(rs_att_aprl.getString("intime"));
					attvo.setOuttime(rs_att_aprl.getString("outtime"));
					attvo.setTotaltime(rs_att_aprl.getString("totaltime"));
					/*attvo.setLocation(rs_att_aprl.getString("Location"));*/
					attvo.setAttendencetypecode(rs_att_aprl.getString("ASTCode"));
					if(rs_att_aprl.getString("StatusType")!=null && "".equalsIgnoreCase(rs_att_aprl.getString("StatusType"))){
						attvo.setAttendancetype(rs_att_aprl.getString("StatusType")+"-"+rs_att_aprl.getString("ShortName"));
						}else{
							attvo.setAttendancetype(""+"-"+"");
						}
					
					attvo.setProjectcode(rs_att_aprl.getString("ProjectCode"));
					attvo.setProjectname(rs_att_aprl.getString("ProjectRefCode"));
					attvo.setSno(count);
					if("Y".equalsIgnoreCase(rs_att_aprl.getString("isAproved"))){
						
						attvo.setApprovedstatus("Approved");
						
						
					}else{
						
						attvo.setApprovedstatus("Approve");
						
					}
					attendence_list.add(attvo);
					
					
				}
				
				JSONArray arra=new JSONArray();
				arra.put(attendence_list);
				

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (rs_att_aprl != null && (!rs_att_aprl.isClosed())) {

					rs_att_aprl.close();
				}
				if (ps_att_aprl != null && (!ps_att_aprl.isClosed())) {

					ps_att_aprl.close();
				}
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelDaoImpl: getEmployeeAttendance : Ending");
		
		return attendence_list;

	}
	
	public  ArrayList<AttendenceApprovelVo> getEmployeeSpecificAttendence(AttendenceApprovelPojo att_pojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelDaoImpl: getEmployeeSpecificAttendence : Starting");
		
		PreparedStatement ps_att_aprl = null;
		ResultSet rs_att_aprl = null;
		Connection connection = null;
		ArrayList<AttendenceApprovelVo> attendence_list=new ArrayList<AttendenceApprovelVo>();
		int count=0;

		try {
			connection = getConnection();
			
			ps_att_aprl = connection.prepareStatement(AttendenceDetails.GET_EMP_SPECIFIC_ATTENDENCE_BY_MONTH);
			ps_att_aprl.setString(1, att_pojo.getEmployeeid());
			ps_att_aprl.setString(2, att_pojo.getStartdate());
			ps_att_aprl.setString(3, att_pojo.getEnddate());
			ps_att_aprl.setString(4, att_pojo.getAttendancestatus());
			
			rs_att_aprl = ps_att_aprl.executeQuery();

				while(rs_att_aprl.next()){
					
					AttendenceApprovelVo attvo=new AttendenceApprovelVo();
					count++;
					attvo.setEmpid(rs_att_aprl.getString("EMPID"));
					attvo.setEmpname(rs_att_aprl.getString("First_Name"));
					attvo.setAttendencedate(HelperClass.convertDatabaseToUI(rs_att_aprl.getString("Attendence_Date")));
					attvo.setAttendancestatus(rs_att_aprl.getString("Attedence_Status"));
					attvo.setIntime(rs_att_aprl.getString("intime"));
					attvo.setOuttime(rs_att_aprl.getString("outtime"));
					attvo.setTotaltime(rs_att_aprl.getString("totaltime"));
					/*attvo.setLocation(rs_att_aprl.getString("Location"));*/
					attvo.setAttendencetypecode(rs_att_aprl.getString("ASTCode"));
					if(rs_att_aprl.getString("StatusType")!=null && "".equalsIgnoreCase(rs_att_aprl.getString("StatusType"))){
						attvo.setAttendancetype(rs_att_aprl.getString("StatusType")+"-"+rs_att_aprl.getString("ShortName"));
					}else{
							attvo.setAttendancetype(""+"-"+"");
					}
					attvo.setProjectcode(rs_att_aprl.getString("ProjectCode"));
					attvo.setProjectname(rs_att_aprl.getString("ProjectRefCode"));
					attvo.setSno(count);
					if("Y".equalsIgnoreCase(rs_att_aprl.getString("isAproved"))){
						
						attvo.setApprovedstatus("Approved");
						
					}else{
						
						attvo.setApprovedstatus("Approve");
						
					}
					
					attendence_list.add(attvo);
					
					
				}
				
				

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (rs_att_aprl != null && (!rs_att_aprl.isClosed())) {

					rs_att_aprl.close();
				}
				if (ps_att_aprl != null && (!ps_att_aprl.isClosed())) {

					ps_att_aprl.close();
				}
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendenceApprovelDaoImpl: getEmployeeSpecificAttendence : Ending");
		
		return attendence_list;

	}
	
	
	
	
public  ArrayList<AttendenceApprovelVo> getAttendanceStatusTypeDao() {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AttendenceApprovelDaoImpl: getAttendanceStatusTypeBD : Starting");
	
	PreparedStatement ps_att_status_type = null;
	ResultSet rs_att_status_type = null;
	Connection connection = null;
	ArrayList<AttendenceApprovelVo> attendence_status_typ_list=new ArrayList<AttendenceApprovelVo>();

	try {
		connection = getConnection();
		
		ps_att_status_type = connection.prepareStatement(AttendenceDetails.GET_ATT_STATUS_TYPE);
		
		
		rs_att_status_type = ps_att_status_type.executeQuery();

			while(rs_att_status_type.next()){
				
				AttendenceApprovelVo attvo=new AttendenceApprovelVo();
				
				attvo.setAttendencetypecode(rs_att_status_type.getString("ASTCode"));
				attvo.setAttendancetype(rs_att_status_type.getString("StatusType")+"-"+rs_att_status_type.getString("ShortName"));
				
				attendence_status_typ_list.add(attvo);
				
				
			}
			
			JSONArray arra=new JSONArray();
			arra.put(attendence_status_typ_list);
			

	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			if (rs_att_status_type != null && (!rs_att_status_type.isClosed())) {

				rs_att_status_type.close();
			}
			if (ps_att_status_type != null && (!ps_att_status_type.isClosed())) {

				ps_att_status_type.close();
			}
			if (connection != null && (!connection.isClosed())) {

				connection.close();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AttendenceApprovelDaoImpl: getAttendanceStatusTypeBD : Ending");
	
	return attendence_status_typ_list;

}


public  ArrayList<AttendenceApprovelVo> getAttendanceStatus() {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AttendenceApprovelDaoImpl: getAttendanceStatus : Starting");
	
	PreparedStatement ps_att_status = null;
	ResultSet rs_att_status = null;
	Connection connection = null;
	ArrayList<AttendenceApprovelVo> attendence_status_list=new ArrayList<AttendenceApprovelVo>();

	try {
		connection = getConnection();
		
		ps_att_status = connection.prepareStatement(AttendenceDetails.GET_ATT_STATUS);
		
		
		rs_att_status = ps_att_status.executeQuery();

			while(rs_att_status.next()){
				
				AttendenceApprovelVo attvo=new AttendenceApprovelVo();
				attvo.setAttendancestatus(rs_att_status.getString("type"));
				
				attendence_status_list.add(attvo);
			}
			
			JSONArray arra=new JSONArray();
			arra.put(attendence_status_list);
			

	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			if (rs_att_status != null && (!rs_att_status.isClosed())) {

				rs_att_status.close();
			}
			if (ps_att_status != null && (!ps_att_status.isClosed())) {

				ps_att_status.close();
			}
			if (connection != null && (!connection.isClosed())) {

				connection.close();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AttendenceApprovelDaoImpl: getAttendanceStatus : Ending");
	
	return attendence_status_list;

}
	

public  String updateEmpAttendance(AttendenceApprovelPojo att_pojo) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AttendenceApprovelDaoImpl: updateEmpAttendance : Starting");
	
	PreparedStatement ps_att_status = null;
	Connection connection = null;
	String status=null;
	int count=0;
	
	try {
		connection = getConnection();
		
		
		
		if(att_pojo.getUsername().equalsIgnoreCase("manager")){
		
		ps_att_status = connection.prepareStatement(AttendenceDetails.UPDATE_EMP_ATTENDANCE);
		
		ps_att_status.setString(1, att_pojo.getAttendancestatus());
		ps_att_status.setString(2, att_pojo.getIntime());
		ps_att_status.setString(3, att_pojo.getOuttime());
		ps_att_status.setString(4, att_pojo.getTotaltime());
		ps_att_status.setString(5, att_pojo.getLocation());
		ps_att_status.setString(6, "Y");
		ps_att_status.setTimestamp(7, HelperClass.getCurrentTimestamp());
		ps_att_status.setString(8, att_pojo.getUsername());
		ps_att_status.setString(9, att_pojo.getAttendancetype());
		ps_att_status.setString(10, att_pojo.getProjectname());
		ps_att_status.setString(11, att_pojo.getUsercode());
		ps_att_status.setString(12, att_pojo.getAttendencedate());
		ps_att_status.setString(13, att_pojo.getEmployeeid());
		
		
		count=ps_att_status.executeUpdate();
		
		
		}else{
			
			ps_att_status = connection.prepareStatement(AttendenceDetails.UPDATE_EMP_ATT_BY_HR);
			
			ps_att_status.setString(1, att_pojo.getAttendancestatus());
			ps_att_status.setString(2, att_pojo.getIntime());
			ps_att_status.setString(3, att_pojo.getOuttime());
			ps_att_status.setString(4, att_pojo.getTotaltime());
			ps_att_status.setString(5, att_pojo.getLocation());
			ps_att_status.setString(6, "Y");
			ps_att_status.setTimestamp(7, HelperClass.getCurrentTimestamp());
			ps_att_status.setString(8, att_pojo.getUsername());
			ps_att_status.setString(9, att_pojo.getAttendancetype());
			ps_att_status.setString(10, att_pojo.getProjectname());
			ps_att_status.setString(11, att_pojo.getUsercode());
			ps_att_status.setString(12, att_pojo.getAttendencedate());
			ps_att_status.setString(13, att_pojo.getEmployeeid());
			
			count=ps_att_status.executeUpdate();
			
			
		}
		
		if(count>0){
			String success=sendConfirmationEmailToEmployee(att_pojo.getUsercode(),att_pojo.getEmployeeid(),att_pojo.getAttendencedate(),connection);
			if(success.equalsIgnoreCase("true")){
				status="attendence updated success fully";
				}else{
					
					status="attendence updated success fully,Mail not sent";
				}
		}else{
			
			status="attendence not approved success fully";
		}
		

			
			

	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			
			if (ps_att_status != null && (!ps_att_status.isClosed())) {

				ps_att_status.close();
			}
			if (connection != null && (!connection.isClosed())) {

				connection.close();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AttendenceApprovelDaoImpl: updateEmpAttendance : Ending");
	
	return status;

}

public  String updateAllEmpAttendance(AttendenceApprovelPojo att_pojo) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AttendenceApprovelDaoImpl: updateEmpAttendance : Starting");
	
	PreparedStatement ps_att_status = null;
	Connection connection = null;
	String status=null;
	int count=0;
	
	try {
		connection = getConnection();
		
	String[] date=att_pojo.getAttendencedate().split(",");
	String[] intime=att_pojo.getIntime().split(",");
	String[] outtime=att_pojo.getOuttime().split(",");
	String[] attendancestatus=att_pojo.getAttendancestatus().split(",");
	String[] statustype=att_pojo.getAttendancetype().split(",");
	String[] project=att_pojo.getProjectname().split(",");
	String[] location=att_pojo.getLocation().split(",");
		
		if(att_pojo.getUsername().equalsIgnoreCase("manager")){
			
			for(int i=0;i<date.length; i++){
		
		ps_att_status = connection.prepareStatement(AttendenceDetails.UPDATE_EMP_ATTENDANCE);
	
		ps_att_status.setString(1, attendancestatus[i]);
		ps_att_status.setString(2, intime[i]);
		ps_att_status.setString(3, outtime[i]);
		ps_att_status.setString(4, HelperClass.getTimeDifferenceinTimeFormat(intime[i],outtime[i]));
		ps_att_status.setString(5, location[i]);
		ps_att_status.setString(6, "Y");
		ps_att_status.setTimestamp(7, HelperClass.getCurrentTimestamp());
		ps_att_status.setString(8, att_pojo.getUsername());
		ps_att_status.setString(9, statustype[i]);
		ps_att_status.setString(10, project[i]);
		ps_att_status.setString(11, att_pojo.getUsercode());
		ps_att_status.setString(12, HelperClass.convertUIToDatabase(date[i]));
		ps_att_status.setString(13, att_pojo.getEmployeeid());
		
		
		count=ps_att_status.executeUpdate();
		}
		
		}else{
			
			ps_att_status = connection.prepareStatement(AttendenceDetails.UPDATE_ALL_EMP_ATT_BY_HR);
			
			for(int i=0;i<date.length; i++){
			ps_att_status = connection.prepareStatement(AttendenceDetails.UPDATE_EMP_ATT_BY_HR);
			
			ps_att_status.setString(1, attendancestatus[i]);
			ps_att_status.setString(2, intime[i]);
			ps_att_status.setString(3, outtime[i]);
			ps_att_status.setString(4, HelperClass.getTimeDifferenceinTimeFormat(intime[i],outtime[i]));
			ps_att_status.setString(5, location[i]);
			ps_att_status.setString(6, "Y");
			ps_att_status.setTimestamp(7, HelperClass.getCurrentTimestamp());
			ps_att_status.setString(8, att_pojo.getUsername());
			ps_att_status.setString(9, statustype[i]);
			ps_att_status.setString(10, project[i]);
			ps_att_status.setString(11, att_pojo.getUsercode());
			ps_att_status.setString(12, HelperClass.convertUIToDatabase(date[i]));
			ps_att_status.setString(13, att_pojo.getEmployeeid());
			
			count=ps_att_status.executeUpdate();
			
			}
			
		
			
			
		}
		
		if(count>0){
			int datelength=att_pojo.getAttendencedate().split(",").length-1;
			String success=sendConfirmationEmailToEmployee(att_pojo.getUsercode(),att_pojo.getEmployeeid(),HelperClass.convertDatabaseToTitle(HelperClass.convertUIToDatabase(date[0]))+" to "+HelperClass.convertDatabaseToTitle(HelperClass.convertUIToDatabase(date[datelength])),connection);
			if(success.equalsIgnoreCase("true")){
			status="attendence updated success fully";
			}else{
				
				status="attendence updated success fully,Mail not sent";
			}
		}else{
			
			status="attendence not updated success fully";
		}
		

			
			

	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			
			if (ps_att_status != null && (!ps_att_status.isClosed())) {

				ps_att_status.close();
			}
			if (connection != null && (!connection.isClosed())) {

				connection.close();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AttendenceApprovelDaoImpl: updateEmpAttendance : Ending");
	
	return status;

}


public String getSingleEmployee(String empid) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AttendenceApprovelDaoImpl: getSingleEmployee : Starting");
	
	PreparedStatement ps_att_aprl = null;
	ResultSet rs_att_aprl = null;
	Connection connection = null;
	String empname=null;
	try {
		connection = getConnection();
		
		ps_att_aprl = connection.prepareStatement(AttendenceDetails.GET_SINGLE_EMPLOYEE);
		ps_att_aprl.setString(1, empid);
		
		rs_att_aprl = ps_att_aprl.executeQuery();

			while(rs_att_aprl.next()){
				
				empname=rs_att_aprl.getString("First_Name");
				
				
				
			}


	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			if (rs_att_aprl != null && (!rs_att_aprl.isClosed())) {

				rs_att_aprl.close();
			}
			if (ps_att_aprl != null && (!ps_att_aprl.isClosed())) {

				ps_att_aprl.close();
			}
			if (connection != null && (!connection.isClosed())) {

				connection.close();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AttendenceApprovelDaoImpl: getSingleEmployee : Ending");
	
	return empname;

}





public String sendConfirmationEmailToEmployee(String managerId,String empId,String date,Connection connection) {
	
	String mailStatus=null;
	try{
		Map<String,String> managerMap= getManagerDetailsById(managerId,connection);
		Map<String,String> empMap= getEmployeeDetailsById(empId,connection);
		
		EmailContent em = new EmailContent();
		String emailId=empMap.get("Official_Email_ID");
		String managerEmailId=managerMap.get("email");
		String[] mails={emailId};
		String managerName=managerMap.get("FirstName");
		String datetext=date;
		em.setMailids(mails);
		em.setSubject("Attendance Posting Approved");
		
		em.setMessage("Dear "+empMap.get("First_Name")+","+"\n"
				+"Greetings from TeleIndia. \n\n" 
				+"Your Attendance for date "
				+datetext+" is approved, \n"
				+"Approved By "
				+managerName+" . \n\n"
				+ "Have a nice day \n\n"
				+ "E-ATTENDANCE PRO  \n"
				+ "----------------------------------------------------------\n"
				+ "This is system generated mail,Please do not reply");
		
		//em.setMessage("Greetings from TeleIndia. \n" +" Your Attendance for date "+datetext+" is approved by "+managerName+" . \n" );
		mailStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
	}
	catch(Exception e){
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	return mailStatus;
}


public  Map<String,String> getManagerDetailsById(String managerId,Connection connection) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in AttendenceApprovelDaoImpl: getManagerDetailsById : Starting");
	
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Map<String,String> managerMap= new HashMap<String, String>();
	try {
		
		ps = connection.prepareStatement(AttendenceDetails.GET_SINGLE_MANAGER);
		ps.setString(1, managerId);
		
		rs = ps.executeQuery();

			while(rs.next()){
				managerMap.put("FirstName", rs.getString("FirstName"));
				managerMap.put("LastName", rs.getString("LastName"));
				managerMap.put("email", rs.getString("email"));
				managerMap.put("phoneno", rs.getString("phoneno"));
			}


	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			if (rs != null && (!rs.isClosed())) {

				rs.close();
			}
			if (ps != null && (!ps.isClosed())) {

				ps.close();
			}
			

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in AttendenceApprovelDaoImpl: getManagerDetailsById : Ending");
	
	return managerMap;
}



public Map<String,String> getEmployeeDetailsById(String empid,Connection connection) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in AttendenceApprovelDaoImpl: getEmployeeDetailsById : Starting");
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Map<String,String> empMap= new HashMap<String, String>();
	try {
		
		ps = connection.prepareStatement(AttendenceDetails.GET_SINGLE_EMPLOYEE);
		ps.setString(1, empid);
		
		rs = ps.executeQuery();

			while(rs.next()){
				empMap.put("First_Name", rs.getString("First_Name"));
				empMap.put("Mobile_Number", rs.getString("Mobile_Number"));
				empMap.put("Official_Email_ID", rs.getString("Official_Email_ID"));
				}


	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			if (rs != null && (!rs.isClosed())) {

				rs.close();
			}
			if (ps != null && (!ps.isClosed())) {

				ps.close();
			}
		

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AttendenceApprovelDaoImpl: getEmployeeDetailsById : Ending");
	
	return empMap;

}






}


