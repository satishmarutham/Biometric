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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.centris.DAO.DBService;
import com.centris.POJO.EmployeeLeaveStatusPojo;
import com.centris.POJO.ManagerLeaveConfirmationPojo;
import com.centris.action.EmployeeLeaveStatusAction;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AttendenceDetails;
import com.centris.util.SQLUtils.EmployeeLeaveRequest;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.SQLUtils.ManagerLeaveConfirmation;
import com.centris.util.constants.MessageConstants;

/**
 * @author sathish
 *
 */
public class EmployeeLeaveStatusDaoImpl extends DBService {
	private static Logger logger = Logger.getLogger(EmployeeLeaveStatusDaoImpl.class);
	public List<EmployeeLeaveStatusPojo> getLeaveStatus(String employeeCode) {
		
	
		PreparedStatement psgetLeaves = null;
		ResultSet rsgetLeaves = null;
		Connection connection=null;	
	List<EmployeeLeaveStatusPojo> list=new ArrayList<EmployeeLeaveStatusPojo>();
		try{
			connection=getConnection();
			psgetLeaves = connection.prepareStatement(EmployeeLeaveRequest.GET_EMPLOYEE_LEAVE_STATUS);
			psgetLeaves.setString(1,employeeCode);
		rsgetLeaves=psgetLeaves.executeQuery();
			
			while(rsgetLeaves.next()){
				
			EmployeeLeaveStatusPojo leaveStatusPojo=new EmployeeLeaveStatusPojo();
			leaveStatusPojo.setSno(Integer.parseInt(rsgetLeaves.getString("SNO")));
	
			leaveStatusPojo.setNoofLeaves(rsgetLeaves.getDouble("NoofLeaves"));
			leaveStatusPojo.setReasonforLeave(rsgetLeaves.getString("ReasonForLeave"));
			leaveStatusPojo.setStartDate(HelperClass.convertDatabaseToUI(rsgetLeaves.getString("StartDate")));
			leaveStatusPojo.setEndDate(HelperClass.convertDatabaseToUI(rsgetLeaves.getString("EndDate")));
			leaveStatusPojo.setRequestedDate(HelperClass.convertDatabaseToUI(rsgetLeaves.getString("RequestedDate")));
			leaveStatusPojo.setApprovedStatus(rsgetLeaves.getString("LeaveStatus"));
			leaveStatusPojo.setLeavetype(rsgetLeaves.getString("LeaveType"));
			
		
			list.add(leaveStatusPojo);
			
			}
			JSONObject jsonObject=new JSONObject();
			jsonObject.accumulate("list", list);
		
		}
		catch(Exception exception){
			exception.printStackTrace();
		
		}
		finally {
			try {

				if (psgetLeaves != null && (!psgetLeaves.isClosed())) {
					psgetLeaves.getConnection().close();
				}

			} catch (SQLException sqle) {
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
				+ " Control in 	EmployeeLeaveStatusDaoImpl:getLeaveStatus Ending");
		return list;
		
	}
public List<EmployeeLeaveStatusPojo> employeeLeaveStatusBySno(int sno,HashMap<String, String> map) {
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveStatusDaoImpl:employeeLeaveStatusBySno  Starting");
		PreparedStatement psById = null;
		ResultSet rsbyId = null;
		Connection connection=null;	
		int count=0;
		String approvedStatus=null;
	List<EmployeeLeaveStatusPojo> detailsListById=new ArrayList<EmployeeLeaveStatusPojo>();
		try{
			connection=getConnection();
		if(map.get(MessageConstants.MANAGER).equalsIgnoreCase("Y")){
			psById = connection.prepareStatement(EmployeeLeaveRequest.EMPLOYEE_LEAVE_STATUS_BY_SNO_FOR_MGR);
		}else{
			
			psById = connection.prepareStatement(EmployeeLeaveRequest.EMPLOYEE_LEAVE_STATUS_BY_SNO);
		}
			psById.setInt(1,sno);
		rsbyId=psById.executeQuery();
		System.out.println("psById:::::"+psById);
			while(rsbyId.next()){
				EmployeeLeaveStatusPojo employeeLeaveStatusPojo=new EmployeeLeaveStatusPojo();
				employeeLeaveStatusPojo.setStartDate(HelperClass.convertDatabaseToUI(rsbyId.getString("StartDate")));
				employeeLeaveStatusPojo.setEndDate(HelperClass.convertDatabaseToUI(rsbyId.getString("EndDate")));
				employeeLeaveStatusPojo.setRequestedBy(rsbyId.getString("FirstName"));
				employeeLeaveStatusPojo.setRequestedDate(HelperClass.convertDatabaseToUI(rsbyId.getString("RequestedDate")));
				employeeLeaveStatusPojo.setFilepaath(rsbyId.getString("filepath"));
				employeeLeaveStatusPojo.setReasonforLeave(rsbyId.getString("ReasonForLeave"));
				employeeLeaveStatusPojo.setNoofLeaves(rsbyId.getDouble("NoofLeaves"));
				employeeLeaveStatusPojo.setSno(rsbyId.getInt("SNO"));
				employeeLeaveStatusPojo.setManagerCode(rsbyId.getString("ManagerCode"));
				employeeLeaveStatusPojo.setLeavetype(rsbyId.getString("LeaveType"));
				
				approvedStatus=rsbyId.getString("ApprovedBy");
				
				if(approvedStatus==null){
					employeeLeaveStatusPojo.setApprovedStatus("Not Approved");	
				}
				else
				{
					employeeLeaveStatusPojo.setApprovedStatus("Approved");	
				}
				
				String approvedStartDate=rsbyId.getString("ApprovedStartDate");
				String approvedEndDate=rsbyId.getString("ApprovedEndDate");
				
				if(approvedStartDate!=null){
					employeeLeaveStatusPojo.setApprovedStartDate(HelperClass.convertDatabaseToUI(approvedStartDate));
					employeeLeaveStatusPojo.setApprovedEndDate(HelperClass.convertDatabaseToUI(approvedEndDate));
					
					
				}
				employeeLeaveStatusPojo.setFilepaath(rsbyId.getString("filepath"));
				employeeLeaveStatusPojo.setApprovedDate(rsbyId.getTimestamp("RequestedDate"));
				employeeLeaveStatusPojo.setTotalleavesApproved(rsbyId.getDouble("TotalDaysAproved"));
				employeeLeaveStatusPojo.setComments(rsbyId.getString("commennts"));
				detailsListById.add(employeeLeaveStatusPojo);
				
			}
			
			
		}
		catch(Exception exception){
			exception.printStackTrace();
			logger.error(exception.getMessage(),exception);
			
		}
		finally {
			try {

				if (psById != null && (!psById.isClosed())) {
					psById.getConnection().close();
				}

			} catch (SQLException sqle) {
				
				
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				logger.error(e1.getMessage(),e1);
			
			}
		
	}
		
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in 	EmployeeLeaveStatusDaoImpl:employeeLeaveStatusBySno Ending");
		return detailsListById;
	}
public String updateEmployeeLeaveRequest(EmployeeLeaveStatusPojo employeeLeaveStatusPojo,HashMap<String, String> map) {
	
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmployeeLeaveStatusDaoImpl:updateEmployeeLeaveRequest  Starting");
	PreparedStatement psUpdateLeaveRequest = null;
	PreparedStatement psUpdateLeaveRequestWithFile = null;
	
	Connection connection=null;	
String successMessage=null;

int count=0;

	try{
		if(employeeLeaveStatusPojo.getFilepaath()==null){
		connection=getConnection();
		psUpdateLeaveRequest = connection.prepareStatement(EmployeeLeaveRequest.UPDATE_EMPLOYEE_LEAVE_REQUEST_WITH_OUT_FILE_PATH);
		psUpdateLeaveRequest.setDouble(1,employeeLeaveStatusPojo.getNoofLeaves());
		psUpdateLeaveRequest.setString(2,employeeLeaveStatusPojo.getReasonforLeave());
		psUpdateLeaveRequest.setString(3,HelperClass.convertUIToDatabase(employeeLeaveStatusPojo.getStartDate()));
		psUpdateLeaveRequest.setString(4,HelperClass.convertUIToDatabase(employeeLeaveStatusPojo.getEndDate()));
		psUpdateLeaveRequest.setString(5,employeeLeaveStatusPojo.getRequestedBy());
		psUpdateLeaveRequest.setString(6,employeeLeaveStatusPojo.getRequestedTo());
		psUpdateLeaveRequest.setTimestamp(7,HelperClass.getCurrentTimestamp());
		
		psUpdateLeaveRequest.setString(8,employeeLeaveStatusPojo.getLeavetype());

		psUpdateLeaveRequest.setInt(9,employeeLeaveStatusPojo.getSno());
		
		count=psUpdateLeaveRequest.executeUpdate();
		
	}
	else
	{
		connection=getConnection();
		psUpdateLeaveRequestWithFile = connection.prepareStatement(EmployeeLeaveRequest.UPDATE_EMPLOYEE_LEAVE_REQUEST_WITH_FILE_PATH);
		psUpdateLeaveRequestWithFile.setDouble(1,employeeLeaveStatusPojo.getNoofLeaves());
		psUpdateLeaveRequestWithFile.setString(2,employeeLeaveStatusPojo.getReasonforLeave());
		psUpdateLeaveRequestWithFile.setString(3,HelperClass.convertUIToDatabase(employeeLeaveStatusPojo.getStartDate()));
		psUpdateLeaveRequestWithFile.setString(4,HelperClass.convertUIToDatabase(employeeLeaveStatusPojo.getEndDate()));
		psUpdateLeaveRequestWithFile.setString(5,employeeLeaveStatusPojo.getRequestedBy());
		psUpdateLeaveRequestWithFile.setString(6,employeeLeaveStatusPojo.getRequestedTo());
		psUpdateLeaveRequestWithFile.setTimestamp(7,HelperClass.getCurrentTimestamp());
		psUpdateLeaveRequestWithFile.setString(8,employeeLeaveStatusPojo.getFilepaath());
		psUpdateLeaveRequestWithFile.setString(9,employeeLeaveStatusPojo.getLeavetype());
		psUpdateLeaveRequestWithFile.setInt(10,employeeLeaveStatusPojo.getSno());
		
		count=psUpdateLeaveRequestWithFile.executeUpdate();
	}
		
		
	
		System.out.println("psUpdateLeaveRequest::::::"+psUpdateLeaveRequest);
		if(count>0){
			
		String status=sendConfirmationEmailToManager(employeeLeaveStatusPojo.getRequestedTo(),employeeLeaveStatusPojo.getRequestedBy(),employeeLeaveStatusPojo.getStartDate()+" to "+employeeLeaveStatusPojo.getEndDate(),connection,map);
		
		
			if(MessageConstants.TRUE.equalsIgnoreCase(status)){
			
				successMessage=MessageConstants.TRUE;
				
			}else{
				
				successMessage=MessageConstants.MAIL_NOT_SENT;
			
			}
			
	        
		
		
		}else{
			
			successMessage=MessageConstants.FALSE;
		}
		
		
		
		
	
	}
	catch(Exception exception){
		exception.printStackTrace();
	
	}
	finally {
		try {

			if (psUpdateLeaveRequest != null && (!psUpdateLeaveRequest.isClosed())) {
				psUpdateLeaveRequest.getConnection().close();
			}

		} catch (SQLException sqle) {
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
			+ " Control in 	EmployeeLeaveStatusDaoImpl:getLeaveStatus Ending");
	return successMessage;
	
}
public boolean validateUpdateDuplicateLeaveDao(String requestedby,String startdate,String enddate,int sno) {
	
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmployeeLeaveStatusDaoImpl : validateUpdateDuplicateLeaveDao Starting");
	
	PreparedStatement ps_leaverequest_count=null;
	ResultSet rs_leaverequest_count=null;
	
	Connection connection=null;
	int count=0;
	boolean status=false;
	    
	try{
		connection=getConnection();
		ps_leaverequest_count=connection.prepareStatement(EmployeeLeaveRequest.CHECK_LEAVE_COUNT_UPDATE);
				
		ps_leaverequest_count.setString(1, requestedby);
		ps_leaverequest_count.setString(2,HelperClass.convertUIToDatabase(startdate));
		ps_leaverequest_count.setString(3,HelperClass.convertUIToDatabase(enddate));
		ps_leaverequest_count.setString(4,HelperClass.convertUIToDatabase(startdate));
		ps_leaverequest_count.setString(5,HelperClass.convertUIToDatabase(enddate));
		ps_leaverequest_count.setInt(6,sno);
		
		rs_leaverequest_count = ps_leaverequest_count.executeQuery();
		
		while(rs_leaverequest_count.next()){
		
			count=rs_leaverequest_count.getInt(1);
		};
		
		
		if(count>0){
			
			status=true;
		}else{
			
			status=false;
		}
		
		
		
	}catch(SQLException sqle){
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	}catch(Exception e){
		e.printStackTrace();
		logger.error(e.getMessage(),e);
	}finally{
		
		try{
			
			if(rs_leaverequest_count!=null && !rs_leaverequest_count.isClosed()){
				rs_leaverequest_count.close();
			}
			if(ps_leaverequest_count!=null && !ps_leaverequest_count.isClosed()){
				ps_leaverequest_count.close();
			}
			if(connection!=null && !connection.isClosed()){
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
			+ "Control in EmployeeLeaveStatusDaoImpl : validateUpdateDuplicateLeaveDao  Ending");

	
	return status;
}

public String sendConfirmationEmailToManager(String managerId,String empId,String date,Connection connection,HashMap<String, String> map) {
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmployeeLeaveStatusDaoImpl : sendConfirmationEmailToManager Starting");
	
	String status=null;
	
	try{
		
		Map<String,String> empMap= getEmployeeDetailsById(empId,connection);
		String url = new  EmployeeDAOImpl().getServerUrlFromBD(connection);
		EmailContent em = new EmailContent();
		String emailId=null;
		String managName=null;
		
		String empName=empMap.get("First_Name");
		
		System.out.println(managerId);
		System.out.println(map.get(MessageConstants.MANAGER));
		
		if(map.get(MessageConstants.MANAGER).equalsIgnoreCase("Y")){
			
			Map<String,String> directorMap= getDirectorDetails(managerId, connection);
			emailId=directorMap.get("email");
			managName=directorMap.get("FirstName");
			
		
		}else{
			
			Map<String,String> managerMap= getManagerDetailsById(managerId,connection);
			emailId=managerMap.get("email");
			managName=managerMap.get("FirstName");
		}
	
		String[] mails={emailId};
		String datetext=date;
		em.setMailids(mails);
		em.setSubject("Employee LeaveRequest Update");
		
		em.setMessage("Dear "+managName+", \n"
				+ "Greetings from TeleIndia. \n\n"
				+ "Employee "+empName+" Requested Updated for Leave Date from "+datetext+"  \n\n"
				+ "For more Details Login URL : " + url + "\n"
				+ "Approve the Leave Details \n\n"
				+ "Have a nice day \n\n"
				+ "E-ATTENDANCE PRO  \n"
				+ "-------------------------------------------------------------- \n"
				+ "This is system generated mail,Please do not reply");
		
		
		
			
		 status=new SendMailWithMultipleAttachment().sendReportToMail(em);
	}
	catch(Exception e){
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	
	 
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveStatusDaoImpl : sendConfirmationEmailToManager Ending");
	
	
	return status;
}





public  Map<String,String> getManagerDetailsById(String managerId,Connection connection) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeLeaveStatusDaoImpl: getManagerDetailsById : Starting");
	
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Map<String,String> managerMap= new HashMap<String, String>();
	try {
		
		ps = connection.prepareStatement(AttendenceDetails.GET_SINGLE_MANAGER);
		ps.setString(1, managerId.trim());
		
		rs = ps.executeQuery();

			while(rs.next()){
				managerMap.put("FirstName", rs.getString("FirstName").trim());
				managerMap.put("LastName", rs.getString("LastName"));
				managerMap.put("email", rs.getString("email").trim());
				managerMap.put("phoneno", rs.getString("phoneno").trim());
				managerMap.put("Username", rs.getString("Username").trim());
				managerMap.put("Password", rs.getString("password").trim());
				
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
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeLeaveStatusDaoImpl: getManagerDetailsById : Ending");
	
	return managerMap;
}

public Map<String,String> getEmployeeDetailsById(String empid,Connection connection) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeLeaveStatusDaoImpl: getEmployeeDetailsById : Starting");
	
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
			+ " Control in EmployeeLeaveStatusDaoImpl: getEmployeeDetailsById : Ending");
	
	return empMap;

}

public  Map<String,String> getDirectorDetails(String managerId,Connection connection) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeLeaveRequesDaoImpl: getDirectorDetails : Starting");
	
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Map<String,String> directormap= new HashMap<String, String>();
	try {
		
		ps = connection.prepareStatement(EmployeeLeaveRequest.GET_SINGLE_DIRECTORS);
		ps.setString(1, managerId);
		
		rs = ps.executeQuery();

			while(rs.next()){
				directormap.put("FirstName", rs.getString("First_Name"));
				directormap.put("empcode", rs.getString("EMPID"));
				directormap.put("email", rs.getString("Username"));
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
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeLeaveRequesDaoImpl: getDirectorDetails : Ending");
	
	return directormap;
}	
	
}

