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

import com.centris.DAO.DBService;
import com.centris.DAO.ManagerLeaveConfirmationDao;
import com.centris.POJO.ManagerLeaveConfirmationPojo;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AttendenceDetails;
import com.centris.util.SQLUtils.EmployeeLeaveRequest;
import com.centris.util.SQLUtils.ManagerLeaveConfirmation;
import com.centris.util.constants.MessageConstants;

/**
 * @author sathish
 *
 */
public class ManagerLeaveConfirmationDaoImpl extends DBService implements ManagerLeaveConfirmationDao {
	private static 	Logger logger = Logger.getLogger(ManagerLeaveConfirmationDaoImpl.class);
	
	@Override
	public List<ManagerLeaveConfirmationPojo> getLeavestoApproved(
			String managerCode, String employeecode) {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerLeaveConfirmationDaoImpl:getLeavestoApproved Starting");
		List<ManagerLeaveConfirmationPojo> confirmationPojos=new ArrayList<ManagerLeaveConfirmationPojo>();
		PreparedStatement psgetLeaves = null;
		ResultSet rsgetLeaves = null;
		Connection connection=null;	
		
		try{
			connection=getConnection();
			psgetLeaves = connection.prepareStatement(ManagerLeaveConfirmation.GET_LEAVES_TO_APPROVED);
			psgetLeaves.setString(1,managerCode);
			psgetLeaves.setString(2,employeecode);
			
			rsgetLeaves=psgetLeaves.executeQuery();
			while(rsgetLeaves.next()){
				
				ManagerLeaveConfirmationPojo confirmationPojo=new ManagerLeaveConfirmationPojo();
				confirmationPojo.setRequestedBy(rsgetLeaves.getString("First_Name"));
				confirmationPojo.setNoofLeaves(rsgetLeaves.getDouble("NoofLeaves"));
				confirmationPojo.setReasonforLeave(rsgetLeaves.getString("ReasonForLeave"));
				confirmationPojo.setStartDate(HelperClass.convertDatabaseToUI(rsgetLeaves.getString("StartDate")));
				confirmationPojo.setEndDate(HelperClass.convertDatabaseToUI(rsgetLeaves.getString("EndDate")));
				confirmationPojo.setRequestedDate(HelperClass.convertDatabaseToUI(rsgetLeaves.getString("RequestedDate")));
				
				confirmationPojo.setSno(rsgetLeaves.getInt("SNO"));
				confirmationPojo.setApprovedStatus(rsgetLeaves.getString("LeaveStatus"));
				confirmationPojo.setLeavetype(rsgetLeaves.getString("LeaveType"));
			
			
				confirmationPojos.add(confirmationPojo);
			}
		}
		catch(Exception exception){
		logger.error(exception.getMessage(),exception);
		}
		finally {
			try {

				if (psgetLeaves != null && (!psgetLeaves.isClosed())) {
					psgetLeaves.getConnection().close();
				}

			} catch (SQLException sqle) {
			
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
			
				logger.error(e1.getMessage(),e1);
			}
		
	}
		
	
	
	// TODO Auto-generated method stub
		
		
		
		// TODO Auto-generated method stub
		return confirmationPojos;
	}

	@Override
	public String confirm(ManagerLeaveConfirmationPojo confirmationPojo) {
		
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ManagerLeaveConfirmationDaoImpl:getMachineStatusReport Starting");
			PreparedStatement psConfirm = null;
			ResultSet rsConfirm = null;
			Connection connection=null;	
			String success=null;
			int count=0;
			try{
				connection=getConnection();
				psConfirm = connection.prepareStatement(ManagerLeaveConfirmation.CONFIRM_LEAVE_REQUEST);
				psConfirm.setString(1,confirmationPojo.getApprovedStatus());
				psConfirm.setString(2,confirmationPojo.getApprovedBy());
				psConfirm.setTimestamp(3,confirmationPojo.getApprovedDate());
				psConfirm.setDouble(4,confirmationPojo.getTotalleavesApproved());
				psConfirm.setString(5,confirmationPojo.getComments());
				psConfirm.setString(6,HelperClass.convertUIToDatabase(confirmationPojo.getApprovedStartDate()));
				psConfirm.setString(7,HelperClass.convertUIToDatabase(confirmationPojo.getApprovedEndDate()));
				psConfirm.setInt(8,confirmationPojo.getSno());
				
				count=psConfirm.executeUpdate();
				
			
				if(count>0)
				{
					Map<String,String> empMamager= getEmployeeManagerId(confirmationPojo.getSno()+"",connection);
				
					String success1 =sendConfirmationEmailToEmployee(empMamager.get("ManagerId"),empMamager.get("EmpId"),confirmationPojo.getApprovedStartDate()+" to "+confirmationPojo.getApprovedEndDate(),connection);
				
					if(MessageConstants.TRUE.equalsIgnoreCase(success1)){
						
						success=MessageConstants.TRUE;
					
					}else{
						
						success=MessageConstants.MAIL_NOT_SENT;
					}
					
			
				
				}
				else
				{
					success=MessageConstants.FALSE;
				}
			}
			catch(Exception exception){
				success="failure";
			logger.error(exception.getMessage(),exception);
			exception.printStackTrace();
			}
			finally {
				try {

					if (psConfirm != null && (!psConfirm.isClosed())) {
						psConfirm.getConnection().close();
					}

				} catch (SQLException sqle) {
					
					logger.error(sqle.getMessage(),sqle);
					sqle.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
					logger.error(e1);
				}
			
		}
			
		
		
		// TODO Auto-generated method stub
		return success;
	}

	@Override
	public String reject(ManagerLeaveConfirmationPojo confirmationPojo) {
		// TODO Auto-generated method stub
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerLeaveConfirmationDaoImpl:reject Starting");
		PreparedStatement psConfirm = null;
		Connection connection=null;	
		int count=0;
		String success=null;
		try{
			connection=getConnection();
			psConfirm = connection.prepareStatement(ManagerLeaveConfirmation.REJECT_LEAVE_REQUEST);
			psConfirm.setString(1,confirmationPojo.getApprovedStatus());
			psConfirm.setString(2,confirmationPojo.getComments());
			psConfirm.setInt(3,confirmationPojo.getSno());
			count=psConfirm.executeUpdate();
		if(count>0)
		{
			success="REJECT";
		}
		else
		{
			success="NOTREJECT";
		}
		}
	catch (Exception e) {
		logger.error(e.getMessage(),e);
	}
return success;
	}

	@Override
	public String hold(ManagerLeaveConfirmationPojo confirmationPojo) {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerLeaveConfirmationDaoImpl:getLeavestoApproved Starting");
	
		PreparedStatement psgetLeaves = null;
	
		Connection connection=null;	
		int count=0;
		String successMessage=null;
		
		try{
			connection=getConnection();
		
			psgetLeaves = connection.prepareStatement(ManagerLeaveConfirmation.HOLD_LEAVE_REQUEST);
			psgetLeaves.setString(1,confirmationPojo.getApprovedStatus());
			psgetLeaves.setString(2,confirmationPojo.getComments());
			psgetLeaves.setString(3,HelperClass.convertUIToDatabase(confirmationPojo.getStartDate()));
			psgetLeaves.setString(4,HelperClass.convertUIToDatabase(confirmationPojo.getEndDate()));
		
			psgetLeaves.setString(5,HelperClass.convertDatabaseToUI(confirmationPojo.getRequestedDate()));
			psgetLeaves.setDouble(6,confirmationPojo.getNoofLeaves());
			psgetLeaves.setInt(7,confirmationPojo.getSno());
			count=psgetLeaves.executeUpdate();
		
		count=psgetLeaves.executeUpdate();
			if(count>0)
			{
				successMessage="HOLD";
			}
			else
			{
				successMessage="NOTHOLD";
			}
			}
		catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		finally {
			
			try {

				if (psgetLeaves != null && (!psgetLeaves.isClosed())) {
					psgetLeaves.getConnection().close();
				}

			} catch (SQLException sqle) {
				
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				
				logger.error(e1.getMessage(),e1);
			}
		
		// TODO Auto-generated method stub
		
	}
		return successMessage;
	}

	@Override
	public List<ManagerLeaveConfirmationPojo> getLeaveDetailsBySno(int sno) {
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerLeaveConfirmationDaoImpl :reject Starting");
		PreparedStatement psById = null;
		ResultSet rsbyId = null;
		Connection connection=null;	
		int count=0;
	List<ManagerLeaveConfirmationPojo> detailsListById=new ArrayList<ManagerLeaveConfirmationPojo>();
		try{
			connection=getConnection();
			psById = connection.prepareStatement(ManagerLeaveConfirmation.GET_LEAVEDETAILS_BY_SNO);
			psById.setInt(1,sno);
		
	
			rsbyId=psById.executeQuery();
			while(rsbyId.next()){
				ManagerLeaveConfirmationPojo confirmationPojo=new ManagerLeaveConfirmationPojo();
				confirmationPojo.setStartDate(HelperClass.convertDatabaseToUI(rsbyId.getString("StartDate")));
				confirmationPojo.setEndDate(HelperClass.convertDatabaseToUI(rsbyId.getString("EndDate")));
				confirmationPojo.setRequestedBy(rsbyId.getString("First_Name"));
				confirmationPojo.setRequestedDate(HelperClass.convertDatabaseToUI(rsbyId.getString("RequestedDate")));
			confirmationPojo.setFilepaath(rsbyId.getString("filepath"));
			confirmationPojo.setReasonforLeave(rsbyId.getString("ReasonForLeave"));
				confirmationPojo.setNoofLeaves(rsbyId.getDouble("NoofLeaves"));
				detailsListById.add(confirmationPojo);
				
			}
			
			
		}
		catch(Exception exception){
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
				logger.error(e1);
			}
		
	}
		
		
		// TODO Auto-generated method stub
		return detailsListById;
	}

public  Map<String,String> getManagerDetailsById(String managerId,Connection connection) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingDaoImpl: getManagerDetailsById : Starting");
	
	
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
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingDaoImpl: getManagerDetailsById : Ending");
	
	return managerMap;
}


public String sendConfirmationEmailToEmployee(String managerId,String empId,String date,Connection connection) {
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingDaoImpl: sendConfirmationEmailToEmployee : Starting");
	
	String status=null;
	
	try{
		
		Map<String,String> empMap= getEmployeeDetailsById(empId,connection);
		
		String managerName=null;
		
		if(managerId.toString().trim().substring(0, 3).equalsIgnoreCase("MAN")){
			
			Map<String,String> managerMap= getManagerDetailsById(managerId,connection);
			managerName=managerMap.get("FirstName");
		
		}else{
			
			Map<String,String> directorMap= getDirectorDetails(managerId, connection);
			managerName=directorMap.get("FirstName");
			
		}
		
		String url = new  EmployeeDAOImpl().getServerUrlFromBD(connection);
		EmailContent em = new EmailContent();
		String empUsername=empMap.get("Username");
		String empName=empMap.get("First_Name");
		
		ArrayList<String> hrmailIds=getHrMailDetails();
	
		String[] mails=new String[hrmailIds.size()+1];
		mails[0]=empUsername;
		
		for(int i=1;i<=hrmailIds.size();i++){
			
			mails[i]=hrmailIds.get(i-1);
		}
		
		
		String datetext=date;
		em.setMailids(mails);
		em.setSubject("Leave Request Confirmation");
	   		
		em.setMessage("Dear "+empName+", \n"
				+ "Greetings from TeleIndia. \n\n"
				+ "Your Leave Request for date from "+datetext+" is  approved by "+managerName+"  \n\n"
				+ "For more Details Login URL : " + url + "\n"
				+ "Go to the Leave Status \n\n"
				+ "Have a nice day \n\n"
				+ "E-ATTENDANCE PRO  \n"
				+ "-------------------------------------------------------------- \n"
				+ "This is system generated mail,Please do not reply");
		
		status = new SendMailWithMultipleAttachment().sendReportToMail(em);
	}catch(Exception e){
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingDaoImpl: sendConfirmationEmailToEmployee : Ending");
	
	
	return status;
}


public Map<String,String> getEmployeeDetailsById(String empid,Connection connection) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingDaoImpl: getEmployeeDetailsById : Starting");
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Map<String,String> empMap= new HashMap<String, String>();
	try {
		
		ps = connection.prepareStatement(ManagerLeaveConfirmation.GET_EMPLOYEE_USERNAME_PASSWORD);
		ps.setString(1, empid);
		
		rs = ps.executeQuery();

			while(rs.next()){
				empMap.put("Username", rs.getString("Username"));
				empMap.put("First_Name", rs.getString("First_Name"));
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
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingDaoImpl: getEmployeeDetailsById : Ending");
	
	return empMap;

}


public Map<String,String> getEmployeeManagerId(String sno,Connection connection) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingDaoImpl: getEmployeeManagerId : Starting");
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Map<String,String> empMap= new HashMap<String, String>();
	try {
		
		ps = connection.prepareStatement(ManagerLeaveConfirmation.GET_MANAGER_AND_EMPLOYEE_ID_BY_SNO);
		ps.setString(1, sno);
		
		rs = ps.executeQuery();

			while(rs.next()){
				empMap.put("EmpId", rs.getString("RequestedBy"));
				empMap.put("ManagerId", rs.getString("RequestedTo"));
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
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingDaoImpl: getEmployeeManagerId : Ending");
	
	return empMap;

}

public ArrayList<String> getHrMailDetails() {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingDaoImpl: getHrMailDetails : Starting");
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	ArrayList<String> mailId=new ArrayList<String>();
	Connection connection=null;
	try {
		connection=getConnection();
		ps = connection.prepareStatement(ManagerLeaveConfirmation.GET_HR_MAIL_DETAILS);
		
		rs = ps.executeQuery();

	while(rs.next()){
			
		mailId.add(rs.getString("HrMailId"));
		
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
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingDaoImpl: getHrMailDetails : Ending");
	
	return mailId;

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
