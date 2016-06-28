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

import com.centris.DAO.DBService;
import com.centris.DAO.EmployeeLeaveRequestDao;
import com.centris.VO.LeaveViewDetailsVo;
import com.centris.VO.ManagerMasterVO;
import com.centris.form.EmployeeLeaveRequestForm;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AttendenceDetails;
import com.centris.util.SQLUtils.EmployeeLeaveRequest;
import com.centris.util.constants.MessageConstants;


public class EmployeeLeaveRequesDaoImpl extends DBService implements EmployeeLeaveRequestDao{
	private static 	Logger logger = Logger.getLogger(EmployeeLeaveRequesDaoImpl.class);
	
	public ArrayList<ManagerMasterVO> getManagersDao(String usercode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveRequesDaoImpl : getAllManagersDao Starting");
		
		PreparedStatement ps_managers_get=null;
		ResultSet rs_managers_get=null;
	    Connection connection=null;
		
	    ArrayList<ManagerMasterVO>  managerlist=new ArrayList<ManagerMasterVO>(); 
	    
		try{
			connection=getConnection();
			ps_managers_get=connection.prepareStatement(EmployeeLeaveRequest.GET_SINGLE_MANAGER);
			ps_managers_get.setString(1, usercode);
			
			rs_managers_get=ps_managers_get.executeQuery();
			
			
			while(rs_managers_get.next()){
			
				ManagerMasterVO managervo=new ManagerMasterVO();
				managervo.setManagerid(rs_managers_get.getString("ManagerCode").trim());
				managervo.setFirstname(rs_managers_get.getString("FirstName").trim());
				managerlist.add(managervo);
				
			}
			
			
			
		
		
		}catch(SQLException sqle){
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}finally{
			
			try{
				
				if(rs_managers_get!=null && !rs_managers_get.isClosed()){
					rs_managers_get.close();
				}
				if(ps_managers_get!=null && !ps_managers_get.isClosed()){
					ps_managers_get.close();
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
				+ " Control in EmployeeLeaveRequesDaoImpl : getAllManagersDao Ending");
		return managerlist;
	}

	public String AddLeaveRequestDao(EmployeeLeaveRequestForm leavereqestForm,HashMap<String,String> mapPrevileges) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveRequesDaoImpl : AddLeaveRequestServiceDao Starting");
		
		PreparedStatement ps_leaverequest_add=null;
	    Connection connection=null;
		int count=0;
		String status=null;
		    
		try{
			connection=getConnection();
			ps_leaverequest_add=connection.prepareStatement(EmployeeLeaveRequest.INSERT_LEAVE_REQUEST);
								
			ps_leaverequest_add.setDouble(1, Double.parseDouble(leavereqestForm.getNoofleaves().trim()));
			ps_leaverequest_add.setString(2, leavereqestForm.getReasonforleaves().trim());
			ps_leaverequest_add.setString(3,HelperClass.convertUIToDatabase(leavereqestForm.getStartdate().trim()));
			ps_leaverequest_add.setString(4,HelperClass.convertUIToDatabase(leavereqestForm.getEnddate().trim()));
			ps_leaverequest_add.setString(5, leavereqestForm.getUsercode().trim());
			ps_leaverequest_add.setString(6, leavereqestForm.getLeaverequestto().trim());
			ps_leaverequest_add.setString(7, leavereqestForm.getFilepath());
			ps_leaverequest_add.setString(8, MessageConstants.LEAVE_STATUS.trim());
			ps_leaverequest_add.setString(9, leavereqestForm.getLeavetype());
			count = ps_leaverequest_add.executeUpdate();
		
			if(count>0){
			
				String success=sendConfirmationEmailToManager(leavereqestForm.getLeaverequestto(),leavereqestForm.getUsercode(),leavereqestForm.getStartdate()+" to "+leavereqestForm.getEnddate(),connection,mapPrevileges);
			
			
				if(MessageConstants.TRUE.equalsIgnoreCase(success)){
				
					status=MessageConstants.TRUE;
					
				}else{
					
					status=MessageConstants.MAIL_NOT_SENT;
				
				}
				
		        
			
			
			}else{
				
				status=MessageConstants.FALSE;
			}
			
			
			
		}catch(SQLException sqle){
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}finally{
			
			try{
				
			
				if(ps_leaverequest_add!=null && !ps_leaverequest_add.isClosed()){
					ps_leaverequest_add.close();
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
				+ " Control in EmployeeLeaveRequesDaoImpl : AddLeaveRequestServiceDao Ending");

		
		return status;
	}

	public boolean validateDuplicateLeaveDao(String requestedby,String startdate, String enddate) {
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveRequesDaoImpl : AddLeaveRequestServiceDao Starting");
		
		PreparedStatement ps_leaverequest_count=null;
		ResultSet rs_leaverequest_count=null;
		
		Connection connection=null;
		int count=0;
		boolean status=false;
		    
		try{
			connection=getConnection();
			ps_leaverequest_count=connection.prepareStatement(EmployeeLeaveRequest.CHECK_LEAVE_COUNT);
					
			ps_leaverequest_count.setString(1, requestedby);
			ps_leaverequest_count.setString(2,HelperClass.convertUIToDatabase(startdate));
			ps_leaverequest_count.setString(3,HelperClass.convertUIToDatabase(enddate));
			
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
				+ " Control in EmployeeLeaveRequesDaoImpl : AddLeaveRequestServiceDao Ending");

		
		return status;
	}

	public String sendConfirmationEmailToManager(String managerId,String empId,String date,Connection connection,HashMap<String, String> mapPrevileges) {
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmployeeLeaveRequesDaoImpl : sendConfirmationEmailToManager Starting");
	
	String status=null;
	
	try{
		
		Map<String,String> empMap= getEmployeeDetailsById(empId,connection);
		
		EmailContent em = new EmailContent();
		String emailId=null;
		String managName=null;
		
		
		if(mapPrevileges.get(MessageConstants.MANAGER).equalsIgnoreCase("Y")){
			
			Map<String,String> directorMap= getDirectorDetails(managerId, connection);
			emailId=directorMap.get("email");
			managName=directorMap.get("FirstName");
			
		
		}else{
			
			Map<String,String> managerMap= getManagerDetailsById(managerId,connection);
			emailId=managerMap.get("email");
			managName=managerMap.get("FirstName");
		}
		
		String url = new  EmployeeDAOImpl().getServerUrlFromBD(connection);
		
		ArrayList<String> hrmailIds=new ManagerLeaveConfirmationDaoImpl().getHrMailDetails();
		
		String[] mails=new String[hrmailIds.size()+1];
		
		mails[0]=emailId;
		
		for(int i=1;i<=hrmailIds.size();i++){
			
			mails[i]=hrmailIds.get(i-1);
		}
		
		
		String empName=empMap.get("First_Name");
		String datetext=date;
		em.setMailids(mails);
		em.setSubject("Employee Leave Requested");
		
		em.setMessage("Dear "+managName+", \n"
				+ "Greetings from TeleIndia. \n\n"
				+ "Employee "+empName+" Requested for Leave Date from "+datetext+"  \n\n"
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
				+ " Control in EmployeeLeaveRequesDaoImpl : sendConfirmationEmailToManager Ending");
	
	
	return status;
}

    public  Map<String,String> getManagerDetailsById(String managerId,Connection connection) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeLeaveRequesDaoImpl: getManagerDetailsById : Starting");
	
	
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
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeLeaveRequesDaoImpl: getManagerDetailsById : Ending");
	
	return managerMap;
}

    public Map<String,String> getEmployeeDetailsById(String empid,Connection connection) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeLeaveRequesDaoImpl: getEmployeeDetailsById : Starting");
	
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
			+ " Control in EmployeeLeaveRequesDaoImpl: getEmployeeDetailsById : Ending");
	
	return empMap;

}

    public ArrayList<LeaveViewDetailsVo> getviewLeaveDetails(String userCode) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeLeaveRequesDaoImpl: getviewLeaveDetails : Starting");
	
	PreparedStatement ps_leavebank = null;
	ResultSet rs_leavebank = null;
	
	PreparedStatement ps_attendance = null;
	ResultSet rs_attendance= null;
	
	PreparedStatement ps_getemp = null;
	ResultSet rs_getemp= null;
	
	PreparedStatement ps_getcl = null;
	ResultSet rs_getcl= null;
	

	Connection connection=null;
	
	ArrayList<LeaveViewDetailsVo> leaveviewlist = new ArrayList<LeaveViewDetailsVo>();
	
	try{
	
		boolean flag=true;
		connection=getConnection();
		
		ps_getemp=connection.prepareStatement(EmployeeLeaveRequest.GET_EMP_DOJ_YEAR);
		ps_getemp.setString(1,userCode);
		
		int currentYear=Integer.parseInt(HelperClass.getCurrentYear());
		
		ArrayList<String> yearCode=new ArrayList<String>();
		
		rs_getemp = ps_getemp.executeQuery();
		
		/*while (rs_getemp.next()) {
			
			if((rs_getemp.getInt("AccadamicYear")<=currentYear) && ( rs_getemp.getInt("AccadamicYear")>=(currentYear-3))){
				
				yearCode.add(rs_getemp.getString("AccyearCode"));
			}
		}*/
		
	
		
		
		while (rs_getemp.next()) {
			
			
			
			String 	empyear= rs_getemp.getString("AccadamicYear");
			String  empyearcode = rs_getemp.getString("AccyearCode");
			String month=rs_getemp.getString("month");
			
			
			ps_leavebank=connection.prepareStatement(EmployeeLeaveRequest.GET_SL_LEAVES);
			ps_leavebank.setString(1, empyearcode);
			ps_leavebank.setString(2, userCode);
			
			rs_leavebank=ps_leavebank.executeQuery();
			
	  	while (rs_leavebank.next()) {
			
	  		LeaveViewDetailsVo leaveViewDetailsVo=new LeaveViewDetailsVo();
			
	  		leaveViewDetailsVo.setAccyear(empyear);
	  		leaveViewDetailsVo.setLeavetype(MessageConstants.LEAVE_TYPE_SL);
	  		
	  		double totopenings=rs_leavebank.getDouble("slopenbal");
	  		double monthopeningd=totopenings/12;
	  		
	  		if(flag){
	  			
	  			double afetrdojopenings=monthopeningd *(12-Integer.parseInt(month));
	  			leaveViewDetailsVo.setOpeningbal(afetrdojopenings);
	  			leaveViewDetailsVo.setClosingbal(afetrdojopenings-rs_leavebank.getDouble("slconsumebal"));
	  			
	  		}else{
	  			
	  			leaveViewDetailsVo.setOpeningbal(rs_leavebank.getDouble("slopenbal"));
	  			leaveViewDetailsVo.setClosingbal(rs_leavebank.getDouble("slopenbal")-rs_leavebank.getDouble("slconsumebal"));
	  		}
	  		
	  		leaveViewDetailsVo.setConsumebal(rs_leavebank.getDouble("slconsumebal"));
	  		
	  		
	  		leaveviewlist.add(leaveViewDetailsVo);
	  		
		}
			
	  	ps_attendance=connection.prepareStatement(EmployeeLeaveRequest.GET_PL_LEAVES);
		ps_attendance.setString(1,empyearcode);
		ps_attendance.setString(2,userCode);

		rs_attendance=ps_attendance.executeQuery();
	
       while (rs_attendance.next()) {
        
    		LeaveViewDetailsVo leaveViewDetailsVo=new LeaveViewDetailsVo();
    		
    		leaveViewDetailsVo.setAccyear("");
    		leaveViewDetailsVo.setLeavetype(MessageConstants.LEAVE_TYPE_PL);
    
    		double totopenings=rs_attendance.getDouble("plopenbal");
	  		double monthopenings=totopenings/12;
	  		
	  		if(flag){

	  			double afetrdojopenings=monthopenings *(12-Integer.parseInt(month));
	  			leaveViewDetailsVo.setOpeningbal(afetrdojopenings);
	  			leaveViewDetailsVo.setClosingbal(afetrdojopenings-rs_attendance.getDouble("plconsumebal"));
	  			
	  		}else{
	  			
	  			leaveViewDetailsVo.setOpeningbal(rs_attendance.getDouble("plopenbal"));
	  			leaveViewDetailsVo.setClosingbal(rs_attendance.getDouble("plopenbal")-rs_attendance.getDouble("plconsumebal"));
	  		}
    	
	  		leaveViewDetailsVo.setConsumebal(rs_attendance.getDouble("plconsumebal"));
		
	  		leaveviewlist.add(leaveViewDetailsVo);
		
		}
       
       
   	ps_getcl=connection.prepareStatement(EmployeeLeaveRequest.GET_CL_LEAVES);
   	ps_getcl.setString(1,empyearcode);
   	ps_getcl.setString(2,userCode);

	rs_getcl=ps_getcl.executeQuery();

   while (rs_getcl.next()) {
    
		LeaveViewDetailsVo leaveViewDetailsVo=new LeaveViewDetailsVo();
		
		leaveViewDetailsVo.setAccyear("");
		leaveViewDetailsVo.setLeavetype(MessageConstants.LEAVE_TYPE_CL);

		double totopenings=rs_getcl.getDouble("clopenbal");
  		double monthopenings=totopenings/12;
  		
  		if(flag){

  			double afetrdojopenings=monthopenings *(12-Integer.parseInt(month));
  			leaveViewDetailsVo.setOpeningbal(afetrdojopenings);
  			leaveViewDetailsVo.setClosingbal(afetrdojopenings-rs_getcl.getDouble("clconsumebal"));
  			
  		}else{
  			
  			leaveViewDetailsVo.setOpeningbal(rs_getcl.getDouble("clopenbal"));
  			leaveViewDetailsVo.setClosingbal(rs_getcl.getDouble("clopenbal")-rs_getcl.getDouble("clconsumebal"));
  		}
	
  		leaveViewDetailsVo.setConsumebal(rs_getcl.getDouble("clconsumebal"));
	
  		leaveviewlist.add(leaveViewDetailsVo);
	
	}
	
       flag=false;
		
	}
   } catch (SQLException sqle) {
	       sqle.printStackTrace();
	        logger.error(sqle.getMessage(),sqle);
           } catch (Exception e1) {
	        e1.printStackTrace();
	         logger.error(e1.getMessage(),e1);
           } finally {
	    try {
 
	    	
	    	
	    	
	    if (rs_attendance != null && (!rs_attendance.isClosed())) {

				rs_attendance.close();
		}
		if (rs_leavebank != null && (!rs_leavebank.isClosed())) {

			rs_leavebank.close();
		}
		if (rs_getemp != null && (!rs_getemp.isClosed())) {

			rs_getemp.close();
		}
	
		if (ps_attendance != null && (!ps_attendance.isClosed())) {

			ps_attendance.close();
		}
		if (ps_leavebank != null && (!ps_leavebank.isClosed())) {

			ps_leavebank.close();
		}
		if (ps_getemp != null && (!ps_getemp.isClosed())) {

			ps_getemp.close();
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
		+ " Control in EmployeeLeaveRequesDaoImpl: getviewLeaveDetails : Ending");

	return leaveviewlist;
}

    private int getAcadamicYear(String currentYear, Connection connection) {
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeLeaveRequesDaoImpl: getAcadamicYear : Starting");
	
	PreparedStatement ps_acadamicyear = null;
	ResultSet rs_acadamicyear = null;
	
	int acadamicYearId=0;

	try{
		
		ps_acadamicyear=connection.prepareStatement(EmployeeLeaveRequest.GET_ACADAMICYEAR_ID);
	
		ps_acadamicyear.setString(1, currentYear);
	
		rs_acadamicyear=ps_acadamicyear.executeQuery();
	
	  while (rs_acadamicyear.next()) {
	
		acadamicYearId=Integer.parseInt(rs_acadamicyear.getString("AccyearCode"));
		
		
	}
	 
	} catch (SQLException sqle) {
         sqle.printStackTrace();
    	logger.error(sqle.getMessage(),sqle);
    	} catch (Exception e1) {
       	e1.printStackTrace();
        logger.error(e1.getMessage(),e1);
   }finally {
	    try {
	    	 
	    if (rs_acadamicyear != null && (!rs_acadamicyear.isClosed())) {

	    	rs_acadamicyear.close();
		}
		if (ps_acadamicyear != null && (!ps_acadamicyear.isClosed())) {

			ps_acadamicyear.close();
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
			+ " Control in EmployeeLeaveRequesDaoImpl: getAcadamicYear : Ending");
	return acadamicYearId;
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
	
	public static void main(String[] args){
		
	 new EmployeeLeaveRequesDaoImpl().getviewLeaveDetails("EMP2");
		
		
	}
	
	
	
}
