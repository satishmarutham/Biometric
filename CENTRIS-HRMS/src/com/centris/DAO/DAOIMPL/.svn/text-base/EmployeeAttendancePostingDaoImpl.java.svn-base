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
import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.DAO.EmployeeAttendancePostingDao;
import com.centris.VO.ClientVO;
import com.centris.VO.EmployeeAttendancePostingVo;
import com.centris.form.EmployeeAttendancePostingForm;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AttendenceDetails;
import com.centris.util.constants.MessageConstants;

public class EmployeeAttendancePostingDaoImpl extends DBService implements
		EmployeeAttendancePostingDao {
	private static Logger logger = Logger
			.getLogger(EmployeeAttendancePostingDaoImpl.class);

	@Override
	public synchronized EmployeeAttendancePostingVo getEmployeeAttendance(
			String userCode, String userName, String lastDate,
			String currentDate,HashMap<String,String> privilegesMap) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAttendancePostingDaoImpl : getEmployeeAttendance Starting");

		List<EmployeeAttendancePostingVo> getAttendance = new ArrayList<EmployeeAttendancePostingVo>();
		EmployeeAttendancePostingVo listDatas = new EmployeeAttendancePostingVo();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Connection con = null;
		int sno = 1;
		try {

			con = getConnection();
			pstmt = con
					.prepareStatement(AttendenceDetails.GET_EMPLOYEEATTENDANCE);
			pstmt.setString(1, userCode);
			pstmt.setString(2, userName);
			pstmt.setString(3, lastDate);
			pstmt.setString(4, currentDate);
			
			rst = pstmt.executeQuery();
			List<EmployeeAttendancePostingVo> typeDetails = new EmployeeAttendancePostingDaoImpl().getAttendanceStatusTypeDetails(con);
			List<ClientVO> clientList=new EmployeeAttendancePostingDaoImpl().getAllClients(con);
			List<EmployeeAttendancePostingVo> managerDetails =null;
			
			
			if(privilegesMap.get(MessageConstants.MANAGER).equalsIgnoreCase("Y")){
				
				managerDetails=new EmployeeAttendancePostingDaoImpl().getDirectDeltails(con);
				
			}else{
				
				managerDetails=new EmployeeAttendancePostingDaoImpl().getProjectManagerDetails(userCode, userName, con);
				
			}
					List<String> attendanceStatusList = new EmployeeAttendancePostingDaoImpl().getAttendanceStatusDetails(con);

			
			while (rst.next()) {
				EmployeeAttendancePostingVo voObj = new EmployeeAttendancePostingVo();
				voObj.setGet_Sno(String.valueOf(sno));
				voObj.setGet_attDate(HelperClass.convertDatabaseToUI(rst
						.getString("Attendence_Date")));
				voObj.setGet_inTime(rst.getString("intime"));
				voObj.setGet_outTime(rst.getString("outtime"));
				voObj.setGet_totalTime(rst.getString("totaltime"));
				voObj.setGet_EmployeeId(rst.getString("EMPID"));
				voObj.setGet_EmployeeName(rst.getString("First_Name"));
				voObj.setGet_attStatus(rst.getString("Attedence_Status"));
				voObj.setGet_Location(rst.getString("Location"));
				voObj.setGet_Description(rst.getString("Description"));
				voObj.setClientlist(clientList);
				
				voObj.setGet_statusTypeList(typeDetails);
				voObj.setGet_Project_ManagerList(managerDetails);
				
				voObj.setAttendanceStatusList(attendanceStatusList);
				getAttendance.add(voObj);
				sno = ++sno;
			}
			listDatas.setGet_AttendanceDetails(getAttendance);
			
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		} finally {
			try {
				if (rst != null && (!rst.isClosed())) {
					rst.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (con != null && (!con.isClosed())) {
					con.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				logger.error(e);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAttendancePostingDaoImpl : getEmployeeAttendance Ending");
		return listDatas;
	}

	
	
	public synchronized List<String> getAttendanceStatusDetails( Connection con) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingDaoImpl : getAttendanceStatusDetails Starting");

		List<String> attendanceStatusDetails = new ArrayList<String>();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			pstmt = con.prepareStatement(AttendenceDetails.GET_ATTENDANCE_STATUS);
		
			rst = pstmt.executeQuery();

			while (rst.next()) {
				
				attendanceStatusDetails.add(rst.getString("type"));
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		} finally {
			try {
				if (rst != null && (!rst.isClosed())) {
					rst.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				logger.error(e);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())	+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingDaoImpl : getAttendanceStatusDetails Ending");
		return attendanceStatusDetails;
	}
	
	
	
	public synchronized List<EmployeeAttendancePostingVo> getProjectManagerDetails(
			String userCode, String userName, Connection con) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAttendancePostingDaoImpl : getProjectManagerDetails Starting");

		List<EmployeeAttendancePostingVo> managerDetails = new ArrayList<EmployeeAttendancePostingVo>();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			pstmt = con
					.prepareStatement(AttendenceDetails.GET_PROJECTMANAGERDETAILS);
			pstmt.setString(1,userName);
		
			rst = pstmt.executeQuery();

			while (rst.next()) {
				EmployeeAttendancePostingVo voObj = new EmployeeAttendancePostingVo();
				voObj.setGet_ManagerCode(rst.getString("ManagerCode"));
				voObj.setGet_ManagerName(rst.getString("ManagerName"));
				managerDetails.add(voObj);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		} finally {
			try {
				if (rst != null && (!rst.isClosed())) {
					rst.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				logger.error(e);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAttendancePostingDaoImpl : getProjectManagerDetails Ending");
		return managerDetails;
	}

	public synchronized List<EmployeeAttendancePostingVo> getAttendanceStatusTypeDetails(
			Connection con) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAttendancePostingDaoImpl : getAttendanceStatusTypeDetails Starting");
		List<EmployeeAttendancePostingVo> statusTypeDetails = new ArrayList<EmployeeAttendancePostingVo>();
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			pstmt = con.prepareStatement(AttendenceDetails.GET_ATTENDANCETYPEDETAILS);
			rst = pstmt.executeQuery();

			while (rst.next()) {
				EmployeeAttendancePostingVo voObj = new EmployeeAttendancePostingVo();
				voObj.setGet_statusTypeCode(rst.getString("ASTCode"));
				voObj.setGet_statusTypeName(rst.getString("StatusType"));
				statusTypeDetails.add(voObj);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		} finally {
			try {
				if (rst != null && (!rst.isClosed())) {
					rst.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				logger.error(e);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAttendancePostingDaoImpl : getAttendanceStatusTypeDetails Ending");
		return statusTypeDetails;
	}

	@Override
	public String updateAttendanceDetails(EmployeeAttendancePostingForm employeeAttendancePostingForm,HashMap<String,String> privilegesMap) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingDaoImpl : updateAttendanceDetails Starting");

		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Connection con = null;
		int count = 0;
		String status="Not Saved";
		try {

			con = getConnection();
			pstmt = con.prepareStatement(AttendenceDetails.UPDATE_ATTENDANCE_DETAILS);
			for(int i=0;i<employeeAttendancePostingForm.getAttendanceDate().length;i++){
				pstmt.setString(1, employeeAttendancePostingForm.getInTime()[i]);
				pstmt.setString(2, employeeAttendancePostingForm.getOutTime()[i]);
				pstmt.setString(3, employeeAttendancePostingForm.getTotalTime()[i]);
				/*pstmt.setString(4, employeeAttendancePostingForm.getLocation()[i]);*/
				pstmt.setString(4, employeeAttendancePostingForm.getDescription()[i]);
				pstmt.setString(5, employeeAttendancePostingForm.getManagerCode()[i]);
				pstmt.setString(6, employeeAttendancePostingForm.getProjectCode()[i]);
				pstmt.setString(7, employeeAttendancePostingForm.getAttendanceStatus()[i]);
				pstmt.setString(8, employeeAttendancePostingForm.getAttendanceType()[i]);
				pstmt.setString(9, employeeAttendancePostingForm.getEmpId());
				pstmt.setString(10, HelperClass.convertUIToDatabase(employeeAttendancePostingForm.getAttendanceDate()[i]));
			
		
				
				count = pstmt.executeUpdate();
				if(count>0){
					
					status="Saved";
				}
			}
			
			if(count>0){
				
				int length=employeeAttendancePostingForm.getAttendanceDate().length;
				String success =sendConfirmationEmailToManager(employeeAttendancePostingForm.getManagerCode()[0],employeeAttendancePostingForm.getEmpId(),employeeAttendancePostingForm.getAttendanceDate()[0]+" - "+employeeAttendancePostingForm.getAttendanceDate()[length-1],con,privilegesMap);
			
			      if(success.equals("false")){
			    	  
			    	  status=MessageConstants.MAIL_NOT_SENT;
			      }
			
			}
		
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		} finally {
			try {
				if (rst != null && (!rst.isClosed())) {
					rst.close();
				}
				if (pstmt != null && (!pstmt.isClosed())) {
					pstmt.close();
				}
				if (con != null && (!con.isClosed())) {
					con.close();
				}
			} catch (SQLException e) {
				logger.error(e.getMessage(), e);
				logger.error(e);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAttendancePostingDaoImpl : updateAttendanceDetails Ending");
		return status;
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


public String sendConfirmationEmailToManager(String managerId,String empId,String date,Connection connection,HashMap<String, String> privilegesMap) {
	
	
	String status=null;
	try{
		
		Map<String,String> empMap= getEmployeeDetailsById(empId,connection);
		String url = new  EmployeeDAOImpl().getServerUrlFromBD(connection);
		EmailContent em = new EmailContent();
		String emailId=null;
		String name=null;
		
		
		System.out.println("privileges :: "+privilegesMap.get(MessageConstants.MANAGER));
		System.out.println("userID :: "+managerId);
		
		if(privilegesMap.get(MessageConstants.MANAGER).equalsIgnoreCase("Y")){
			
			Map<String,String> directorMap= getDirectorDetails(managerId,connection);
			emailId=directorMap.get("Username");
			name= directorMap.get("FirstName");
		}else{
			
			Map<String,String> managerMap= getManagerDetailsById(managerId,connection);
			 emailId=managerMap.get("email");
			 name=managerMap.get("FirstName");
		}
		
		
		String empEmailId=empMap.get("Official_Email_ID");
		String[] mails={emailId};
		String empName=empMap.get("First_Name");
		String datetext=date;
		em.setMailids(mails);
		em.setSubject("Attendance Posting");
		
		em.setMessage("Dear "+name+", \n"
				+ "Greetings from TeleIndia. \n\n"
				+ "Employee "+empName+" Posted Attendance for  Date "+datetext+"  \n\n"
				+ "For more Details Login URL : " + url + "\n"
				+ "Approve the Attendance Details \n\n"
				+ "Have a nice day \n\n"
				+ "E-ATTENDANCE PRO  \n"
				+ "-------------------------------------------------------------- \n"
				+ "This is system generated mail,Please do not reply");
			
		  status =	new SendMailWithMultipleAttachment().sendReportToMail(em);
			
		if(!(emailId.equalsIgnoreCase(empEmailId)) ){
			
			String[] empmails={empEmailId};
			em.setMailids(empmails);
			em.setSubject("Attendance Posting ");
			em.setMessage("Dear "+empName+", \n"
					+ "Greetings from TeleIndia. \n\n"
					+ "Your attendance details are posted successfully for Date "+datetext+"  \n\n"
					+ "For more Details Login URL : " + url + "\n\n"
					+ "Have a nice day \n\n"
					+ "E-ATTENDANCE PRO  \n"
					+ "-------------------------------------------------------------- \n"
					+ "This is system generated mail,Please do not reply");
			
			status =new SendMailWithMultipleAttachment().sendReportToMail(em);
			
			}
	}
	catch(Exception e){
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	
	
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
			+ " Control in EmployeeAttendancePostingDaoImpl: getEmployeeDetailsById : Ending");
	
	return empMap;

}




public synchronized List<EmployeeAttendancePostingVo> getDirectDeltails(
		Connection con) {
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmployeeAttendancePostingDaoImpl : getDirectDeltails Starting");
	List<EmployeeAttendancePostingVo> directorDetails = new ArrayList<EmployeeAttendancePostingVo>();
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try {
		pstmt = con.prepareStatement(AttendenceDetails.GET_ALL_DIRECTORS);
		
		rst = pstmt.executeQuery();
		
		while (rst.next()) {
			EmployeeAttendancePostingVo voObj = new EmployeeAttendancePostingVo();
			voObj.setGet_ManagerCode(rst.getString("DirectorCode"));
			voObj.setGet_ManagerName(rst.getString("First_Name"));
			directorDetails.add(voObj);
		}
	} catch (SQLException e) {
		logger.error(e.getMessage(), e);
		logger.error(e);
		e.printStackTrace();
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();

	} finally {
		try {
			if (rst != null && (!rst.isClosed())) {
				rst.close();
			}
			if (pstmt != null && (!pstmt.isClosed())) {
				pstmt.close();
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmployeeAttendancePostingDaoImpl : getDirectDeltails Ending");
	return directorDetails;
}


public  Map<String,String> getDirectorDetails(String managerId,Connection connection) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateDaoImpl: getDirectorDetails : Starting");
	
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Map<String,String> directormap= new HashMap<String, String>();
	try {
		
		ps = connection.prepareStatement(AttendenceDetails.GET_SINGLE_DIRECTORS);
		ps.setString(1, managerId);
		
		rs = ps.executeQuery();

			while(rs.next()){
				directormap.put("FirstName", rs.getString("First_Name"));
				directormap.put("empcode", rs.getString("EMPID"));
				directormap.put("Username", rs.getString("Username"));
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
	logger.info(JDate.getTimeString(new Date())+ " Control in AttendanceApprovalByDateDaoImpl: getDirectorDetails : Ending");
	
	return directormap;
}


public synchronized List<ClientVO> getAllClients(
		Connection con) {
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmployeeAttendancePostingDaoImpl : getAllClients Starting");
	List<ClientVO> ClientVOlist = new ArrayList<ClientVO>();
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try {
		pstmt = con.prepareStatement(AttendenceDetails.GET_ALL_CLIENTS);
		rst = pstmt.executeQuery();

		while (rst.next()) {
			ClientVO vo=new ClientVO();
			vo.setClientcode(rst.getString("ClientCode"));
			vo.setClientname(rst.getString("ClientName"));
			ClientVOlist.add(vo);
		}
	} catch (SQLException e) {
		logger.error(e.getMessage(), e);
		logger.error(e);
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();

	} finally {
		try {
			if (rst != null && (!rst.isClosed())) {
				rst.close();
			}
			if (pstmt != null && (!pstmt.isClosed())) {
				pstmt.close();
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			logger.error(e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmployeeAttendancePostingDaoImpl : getAllClients Ending");
	return ClientVOlist;
}



}