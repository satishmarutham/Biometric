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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.AdvanceSalaryRequestDao;
import com.centris.DAO.DBService;
import com.centris.VO.AdvanceSalaryConsolidateReportVo;
import com.centris.VO.AdvanceSalaryRequestVo;
import com.centris.VO.EmployeeAllowanceReportVO;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AdvancedSalaryRequest;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.constants.MessageConstants;

/**
 * @author satish
 *
 */
public class AdvanceSalaryRequestDaoImpl extends DBService implements AdvanceSalaryRequestDao {
private static Logger logger = Logger.getLogger(AdvanceSalaryRequestDaoImpl.class);
	
	public  ArrayList<AdvanceSalaryRequestVo> getEmployeeDetailsById(String employeeId,String managerCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestDaoImpl: getEmployeeDetailsById : Starting");
		
		PreparedStatement ps_att_aprl = null;
		ResultSet rs_att_aprl = null;
		Connection connection = null;
		ArrayList<AdvanceSalaryRequestVo> emp_list=new ArrayList<AdvanceSalaryRequestVo>();

		try {
			connection = getConnection();
			
			ps_att_aprl = connection.prepareStatement(AdvancedSalaryRequest.GET_EMPLOYEEDETAILS_BYID);
			ps_att_aprl.setString(1,employeeId);
			ps_att_aprl.setString(2,managerCode);
			
			
			rs_att_aprl = ps_att_aprl.executeQuery();
			
		
		

				while(rs_att_aprl.next()){
					
					AdvanceSalaryRequestVo advanceSalaryRequestVo=new AdvanceSalaryRequestVo();
					advanceSalaryRequestVo.setEmployeeCode(rs_att_aprl.getString("EMPID"));
					advanceSalaryRequestVo.setEmployeeName(rs_att_aprl.getString("First_Name"));
					advanceSalaryRequestVo.setProjectCode(rs_att_aprl.getString("ProjectCode"));
					advanceSalaryRequestVo.setProjectReferenceCode(rs_att_aprl.getString("ProjectRefCode"));
					advanceSalaryRequestVo.setBioId(rs_att_aprl.getString("bioId"));
					emp_list.add(advanceSalaryRequestVo);
					
					
					
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
				+ " Control in AdvanceSalaryRequestDaoImpl: getEmployeeDetailsById : Ending");
		
		return emp_list;

	}
	
	public  String saveAdvancedSalaryRequest(List<AdvanceSalaryRequestVo> saveRequestSalary ) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestDaoImpl: saveAdvancedSalaryRequest : Starting");
		
		PreparedStatement preparedStatement = null;
		
		Connection connection = null;
		String status=null;
		IDGenerator generator=new IDGenerator();
		int count=0;
		String mailCreatedBy=null;
		String mailStatus=null;
		try {
			connection = getConnection();
			String acedamicYear=HelperClass.getCurrentYear();
			String monthName=HelperClass.getCurrentMonth();
			String acedamicYearCode="";
			
			preparedStatement = connection.prepareStatement(AdvancedSalaryRequest.GET_ACCERYEAR_CODE);
			preparedStatement.setString(1,acedamicYear);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				acedamicYearCode=resultSet.getString("AccyearCode");
			}
			
			preparedStatement=connection.prepareStatement(AdvancedSalaryRequest.SAVE_ADVANCED_SALARY_REQUEST);
			String createdBy=null;
			for(int i=0;i<saveRequestSalary.size();i++){
				createdBy=saveRequestSalary.get(i).getCreatedBy();
				preparedStatement.setString(1,generator.getPrimaryKeyID("hrms_employee_advance_salary"));
				preparedStatement.setString(2,acedamicYearCode);
				preparedStatement.setString(3,monthName);
				preparedStatement.setString(4,saveRequestSalary.get(i).getEmployeeCode());
				preparedStatement.setString(5,saveRequestSalary.get(i).getProjectCode());
				preparedStatement.setString(6, saveRequestSalary.get(i).getSalary());
				preparedStatement.setString(7,saveRequestSalary.get(i).getComments().trim());
				preparedStatement.setString(8, saveRequestSalary.get(i).getCreatedBy());
				preparedStatement.setTimestamp(9, HelperClass.getCurrentTimestamp());
				count=preparedStatement.executeUpdate();
				mailCreatedBy= saveRequestSalary.get(i).getCreatedBy();
				
			}
			
			if(count>0){
				
				status=MessageConstants.TRUE;
				
				String mailId=null;
				String mailName=null;
				String managerName=null;
				String url = getServerUrlFromBD(connection);
				preparedStatement=connection.prepareStatement(AdvancedSalaryRequest.ADVANCE_SALARY_REQUEST_STATUS_EMAIL_SEND);
				
				preparedStatement.setString(1,createdBy);
			ResultSet resultSet2=preparedStatement.executeQuery();
			
			while(resultSet2.next()){
			
				mailId=resultSet2.getString("Official_Email_ID");
				managerName=resultSet2.getString("First_Name");
				mailName=resultSet2.getString("First_Name");
		
			}
			
			 mailStatus = sendEmailToManagerStatus(mailId,mailName,url);
			
			preparedStatement=connection.prepareStatement(AdvancedSalaryRequest.ADVANCE_SALARY_REQUEST_EMAIL_SEND);

			preparedStatement.setString(1,createdBy);
			ResultSet resultSetMail=preparedStatement.executeQuery();
			
			while(resultSetMail.next()){
			
				mailId=resultSetMail.getString("Official_Email_ID");
				mailName=resultSetMail.getString("First_Name");
		
				
			}
			
			 mailStatus = sendEmailToAdmin(mailId,mailName,managerName,url);
			
			 if(mailStatus.equalsIgnoreCase(MessageConstants.TRUE)){
				 
				 status=MessageConstants.MAIL_SENT;
			 }
			
			
			}
			else
			{
				status=MessageConstants.FALSE;
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				
				if (preparedStatement != null && (!preparedStatement.isClosed())) {

					preparedStatement.close();
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
				+ " Control in AdvanceSalaryRequestDaoImpl: saveAdvancedSalaryRequest : Ending");
		
		return status;

	}

	@Override
	public List<AdvanceSalaryRequestVo> getAdvanceSalaryRequest() {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestDaoImpl: getAdvanceSalaryRequest : Starting");
		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		ArrayList<AdvanceSalaryRequestVo> getAdvanceSalaryRequest=new ArrayList<AdvanceSalaryRequestVo>();

		try {
			connection = getConnection();
			
			preparedStatement = connection.prepareStatement(AdvancedSalaryRequest.GET_ADVANCED_SALARY_REQUEST);
		
			
			resultSet = preparedStatement.executeQuery();

				while(resultSet.next()){
					
					AdvanceSalaryRequestVo advanceSalaryRequestVo=new AdvanceSalaryRequestVo();
					advanceSalaryRequestVo.setEmployeeCode(resultSet.getString("EMPID"));
					advanceSalaryRequestVo.setEmployeeName(resultSet.getString("First_Name"));
					advanceSalaryRequestVo.setProjectCode(resultSet.getString("ProjectCode"));
					advanceSalaryRequestVo.setProjectReferenceCode(resultSet.getString("ProjectRefCode"));
					advanceSalaryRequestVo.setSalary(resultSet.getString("salary_amount"));
					advanceSalaryRequestVo.setRequestedByName(resultSet.getString("FirstName"));
					advanceSalaryRequestVo.setComments(resultSet.getString("Comments").trim());
					
				advanceSalaryRequestVo.setAdvanceSalaryCode(resultSet.getString("AdvSalCode"));
				advanceSalaryRequestVo.setRequestedByCode(resultSet.getString("RequestedBy"));
				advanceSalaryRequestVo.setBioId(resultSet.getString("bioid"));
				advanceSalaryRequestVo.setRequestedDate(HelperClass.ConvertDBTimestamptoUITimestamp(resultSet.getString("requestedDate")));
				
					getAdvanceSalaryRequest.add(advanceSalaryRequestVo);
					
					
					
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (resultSet != null && (!resultSet.isClosed())) {

					resultSet.close();
				}
				if (preparedStatement != null && (!preparedStatement.isClosed())) {

					preparedStatement.close();
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
				+ " Control in AdvanceSalaryRequestDaoImpl: getAdvanceSalaryRequest : Ending");
		
		return getAdvanceSalaryRequest;

	}

	@Override
	public int approveAdvanceSalary(AdvanceSalaryRequestVo advanceSalaryRequestVo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestDaoImpl: approveAdvanceSalary : Starting");
		
		PreparedStatement preparedStatement = null;
		ResultSet rs_att_aprl = null;
		Connection connection = null;
		
		int count=0;

		try {
			connection = getConnection();
			
			preparedStatement = connection.prepareStatement(AdvancedSalaryRequest.APPROVE_ADVANCE_SALARY_STATUS);
			preparedStatement.setString(1,MessageConstants.ADAVANCE_SALARY_APPROVAL);
			preparedStatement.setTimestamp(2,HelperClass.getCurrentTimestamp());
			preparedStatement.setString(3,advanceSalaryRequestVo.getCreatedBy());
			preparedStatement.setString(4,advanceSalaryRequestVo.getSalary());
			preparedStatement.setString(5,advanceSalaryRequestVo.getAdvanceSalaryCode());
			
			count=preparedStatement.executeUpdate();
			
		
			if(count>0){
				
				count=1;
				String managerMailId=null;
			
				String managerName=null;
				String url = getServerUrlFromBD(connection);
				preparedStatement=connection.prepareStatement(AdvancedSalaryRequest.APPROVE_ADVANCE_SALARY_EMAIL_SEND);
				
				preparedStatement.setString(1,advanceSalaryRequestVo.getAdvanceSalaryCode());
			ResultSet resultSet2=preparedStatement.executeQuery();
		
			while(resultSet2.next()){
				managerMailId=resultSet2.getString("Official_Email_ID");
				managerName=resultSet2.getString("First_Name");
				
				String mailStatus = sendEmailToManager(managerName,managerMailId,url);
		
				if(mailStatus.equalsIgnoreCase(MessageConstants.TRUE)){
					
					count=2;
				}
			}
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
				if (preparedStatement != null && (!preparedStatement.isClosed())) {

					preparedStatement.close();
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
				+ " Control in AdvanceSalaryRequestDaoImpl: approveAdvanceSalary : Ending");
		
		return count;
	}

	@Override
	public int rejectAdvanceSalary(AdvanceSalaryRequestVo advanceSalaryRequestVo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestDaoImpl: rejectAdvanceSalary : Starting");
		
		PreparedStatement preparedStatement = null;
		ResultSet rs_att_aprl = null;
		Connection connection = null;
		int count=0;

		try {
			connection = getConnection();
			
			preparedStatement = connection.prepareStatement(AdvancedSalaryRequest.APPROVE_ADVANCE_SALARY_STATUS);
			preparedStatement.setString(1,MessageConstants.ADAVANCE_SALARY_REJECT);
			preparedStatement.setTimestamp(2,HelperClass.getCurrentTimestamp());
			preparedStatement.setString(3,advanceSalaryRequestVo.getCreatedBy());
			
			if(advanceSalaryRequestVo.getSalary()==""){
				preparedStatement.setDouble(4,0);
			}else{
				preparedStatement.setDouble(4,Double.parseDouble(advanceSalaryRequestVo.getSalary()));
			}
			
			preparedStatement.setString(5,advanceSalaryRequestVo.getAdvanceSalaryCode());
			
			
			count=preparedStatement.executeUpdate();
			
			
			if(count>0){
				count=1;
				String managerMailId=null;
			
				String managerName=null;
				String url = getServerUrlFromBD(connection);
				preparedStatement=connection.prepareStatement(AdvancedSalaryRequest.APPROVE_ADVANCE_SALARY_EMAIL_SEND);
				
				preparedStatement.setString(1,advanceSalaryRequestVo.getAdvanceSalaryCode());
			ResultSet resultSet2=preparedStatement.executeQuery();
		
			while(resultSet2.next()){
				managerMailId=resultSet2.getString("Official_Email_ID");
				managerName=resultSet2.getString("First_Name");
				
				String mailStatus = sendEmailToManagerRejectSalary(managerName,managerMailId,url);
		
				if(mailStatus.equalsIgnoreCase(MessageConstants.TRUE)){
					
					count=2;
				}
			}
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
				if (preparedStatement != null && (!preparedStatement.isClosed())) {

					preparedStatement.close();
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
				+ " Control in AdvanceSalaryRequestDaoImpl: rejectAdvanceSalary : Ending");
		
		return count;
	}

	@Override
	public int holdAdvanceSalary(AdvanceSalaryRequestVo advanceSalaryRequestVo) {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestDaoImpl: holdAdvanceSalary : Starting");
		
		PreparedStatement preparedStatement = null;
		ResultSet rs_att_aprl = null;
		Connection connection = null;
		int count=0;

		try {
			connection = getConnection();
			
			preparedStatement = connection.prepareStatement(AdvancedSalaryRequest.APPROVE_ADVANCE_SALARY_STATUS);
			preparedStatement.setString(1,MessageConstants.ADAVANCE_SALARY_HOLD);
			preparedStatement.setTimestamp(2,HelperClass.getCurrentTimestamp());
			preparedStatement.setString(3,advanceSalaryRequestVo.getCreatedBy());
			preparedStatement.setString(4,advanceSalaryRequestVo.getSalary());
			preparedStatement.setString(5,advanceSalaryRequestVo.getAdvanceSalaryCode());
			count=preparedStatement.executeUpdate();
			

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
				if (preparedStatement != null && (!preparedStatement.isClosed())) {

					preparedStatement.close();
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
				+ " Control in AdvanceSalaryRequestDaoImpl: holdAdvanceSalary : Ending");
		
		return count;
	}
	
	
	public String getServerUrlFromBD(Connection connection) {
		String url = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(Employee.GET_SERVER_URL);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				url = rs.getString("URL");
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return url;
	}
	
	public String sendEmailToAdmin(String adminMailId,String senderName,String managerName,String url) {
		
		String mailStatus=null;
		try {
			EmailContent em = new EmailContent();
			String[] mails = {adminMailId};

			em.setMailids(mails);
			em.setSubject("Advanced Salary Request");
em.setMessage("Dear "+senderName+ ", \n"
					+"Greetings From Teleindia . \n"
					+" \n"
					+"Manager "+managerName+" Claimed Advance Salary .\n\n"
					+"For more details please login to our portal. \n\n"
		            +"URL	: " + url + "\n"
					+" \n"
				    +"Regards .\n"
				    +" \n"
			        +"E-ATTENDANCE PRO .\n"
					+"--------------------------------------------------------\n"
					+"This is System generated mails, Please do not reply   .\n\n");
mailStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return mailStatus;
	}
	

public String sendEmailToManager(String managerName,String managerEmail,String url) {
	
	String mailStatus=null;
	try {
		EmailContent em = new EmailContent();
		String[] mails = {managerEmail};

		em.setMailids(mails);
		em.setSubject("Advanced Salary Approval");

		em.setMessage("Dear "+managerName+ ", \n"
				+"Greetings From Teleindia . \n"
				+" \n"
				+"Your Advance Salary Request is approved. \n"
				+"For more details please login to our portal.\n"
				+"URL	: " + url + "\n"
				+" \n"
				+"Regards .\n"
				+" \n"
				+"E-ATTENDANCE PRO .\n"
				+"--------------------------------------------------------\n"
				+"This is System generated mails, Please do not reply   .\n\n");
		mailStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	return mailStatus;
}

@Override
public List<AdvanceSalaryRequestVo> getProjectCodeRefernceByManager(
		String managerCode) {
	// TODO Auto-generated method stub
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AdvanceSalaryRequestDaoImpl: holdAdvanceSalary : Starting");
	
	PreparedStatement preparedStatement = null;
	ResultSet rs_att_aprl = null;
	Connection connection = null;
	List<AdvanceSalaryRequestVo> projectCodeReferenceList=new ArrayList<AdvanceSalaryRequestVo>();

	try {
		connection = getConnection();
		
		preparedStatement = connection.prepareStatement(AdvancedSalaryRequest.GET_PROJECT_CODEREFERENCE_BY_MANAGER_CODE);
		preparedStatement.setString(1,managerCode);
	
		rs_att_aprl=preparedStatement.executeQuery();
		while(rs_att_aprl.next()){
			AdvanceSalaryRequestVo advanceSalaryRequestVo=new AdvanceSalaryRequestVo(); 
			advanceSalaryRequestVo.setProjectReferenceCode(rs_att_aprl.getString("ProjectRefCode"));
			projectCodeReferenceList.add(advanceSalaryRequestVo);
			
			
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
			if (preparedStatement != null && (!preparedStatement.isClosed())) {

				preparedStatement.close();
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
			+ " Control in AdvanceSalaryRequestDaoImpl: holdAdvanceSalary : Ending");
	
	return projectCodeReferenceList;
}

@Override
public List<AdvanceSalaryRequestVo> getAdvanceSalaryRequestByDirector(
		String userCode) {
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AdvanceSalaryRequestDaoImpl: getAdvanceSalaryRequestByDirector : Starting");
	
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Connection connection = null;
	ArrayList<AdvanceSalaryRequestVo> getAdvanceSalaryRequest=new ArrayList<AdvanceSalaryRequestVo>();

	try {
		connection = getConnection();
		
		preparedStatement = connection.prepareStatement(AdvancedSalaryRequest.GET_ADVANCED_SALARY_REQUEST_BY_DIRECTOR);
		preparedStatement.setString(1,userCode);
		preparedStatement.setString(2,userCode);
resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next()){
				
				AdvanceSalaryRequestVo advanceSalaryRequestVo=new AdvanceSalaryRequestVo();
				advanceSalaryRequestVo.setEmployeeCode(resultSet.getString("EMPID"));
				advanceSalaryRequestVo.setEmployeeName(resultSet.getString("First_Name"));
				advanceSalaryRequestVo.setProjectCode(resultSet.getString("ProjectCode"));
				advanceSalaryRequestVo.setProjectReferenceCode(resultSet.getString("ProjectRefCode"));
				advanceSalaryRequestVo.setSalary(resultSet.getString("salary_amount"));
				advanceSalaryRequestVo.setRequestedByName(resultSet.getString("FirstName"));
				advanceSalaryRequestVo.setComments(resultSet.getString("Comments").trim());
				
			advanceSalaryRequestVo.setAdvanceSalaryCode(resultSet.getString("AdvSalCode"));
			advanceSalaryRequestVo.setRequestedByCode(resultSet.getString("RequestedBy"));
			advanceSalaryRequestVo.setBioId(resultSet.getString("bioid"));
			advanceSalaryRequestVo.setRequestedDate(HelperClass.ConvertDBTimestamptoUITimestamp(resultSet.getString("requestedDate")));
			
				getAdvanceSalaryRequest.add(advanceSalaryRequestVo);
				
				
				
			}


	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			if (resultSet != null && (!resultSet.isClosed())) {

				resultSet.close();
			}
			if (preparedStatement != null && (!preparedStatement.isClosed())) {

				preparedStatement.close();
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
			+ " Control in AdvanceSalaryRequestDaoImpl: getAdvanceSalaryRequest : Ending");
	
	return getAdvanceSalaryRequest;

}

@Override
public int approveAdvanceSalaryByAdmin(AdvanceSalaryRequestVo advanceSalaryRequestVo) {
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AdvanceSalaryRequestDaoImpl: approveAdvanceSalaryByAdmin : Starting");
	
	PreparedStatement preparedStatement = null;
	ResultSet rs_att_aprl = null;
	Connection connection = null;
	
	int count=0;

	try {
		connection = getConnection();
		
		preparedStatement = connection.prepareStatement(AdvancedSalaryRequest.APPROVE_ADVANCE_SALARY_STATUS_ADMIN);
		preparedStatement.setString(1,"Y");
		preparedStatement.setTimestamp(2,HelperClass.getCurrentTimestamp());
		preparedStatement.setString(3,advanceSalaryRequestVo.getCreatedBy());
		preparedStatement.setString(4,advanceSalaryRequestVo.getSalary());
		preparedStatement.setString(5,advanceSalaryRequestVo.getAdvanceSalaryCode());
		count=preparedStatement.executeUpdate();
		if(count>0){
			count=1;
			String managerCode=null;
			String directorMailName=null;
			String directorCode=null;
			String directorName=null;
			String managerName=null;
			String managerEmail=null;
			String url = getServerUrlFromBD(connection);
			preparedStatement=connection.prepareStatement(AdvancedSalaryRequest.ADVANCE_SALARY_ADMIN_APPROVED);
			
			preparedStatement.setString(1,advanceSalaryRequestVo.getAdvanceSalaryCode());
		ResultSet resultSet2=preparedStatement.executeQuery();
	
		while(resultSet2.next()){
			managerCode=resultSet2.getString("RequestedBy");
			directorCode=resultSet2.getString("DirecotorCode");
			
		}
		PreparedStatement	 directorMail=connection.prepareStatement(AdvancedSalaryRequest.GET_DIRECTOR_MAIL_DETAILS);
		
		directorMail.setString(1,directorCode);
		
		
		ResultSet directMailDetails=directorMail.executeQuery();
	
		while(directMailDetails.next()){
			 directorMailName=directMailDetails.getString("Username");
			directorName=directMailDetails.getString("First_Name");
			String mailStatus = sendEmailToDirectorByAdmin(directorMailName,directorName,url);
			
			if(mailStatus.equalsIgnoreCase(MessageConstants.TRUE)){
				
				count=2;
			
		}
PreparedStatement rMail=connection.prepareStatement(AdvancedSalaryRequest.GET_MANAGER_MAIL_DETAILS);
		
		
		
rMail.setString(1,managerCode);
		ResultSet managerMailDetails=rMail.executeQuery();
	
		while(managerMailDetails.next()){
			managerEmail=managerMailDetails.getString("Username");
			 managerName=managerMailDetails.getString("FirstName");
			
			String mailStatusAdmin = sendEmailToManagerByAdmin(managerEmail,managerName,url);
	
			if(mailStatusAdmin.equalsIgnoreCase(MessageConstants.TRUE)){
				
				count=2;
			}
		}
		
		
		
		
		
		
		}
		
		
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
			if (preparedStatement != null && (!preparedStatement.isClosed())) {

				preparedStatement.close();
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
			+ " Control in AdvanceSalaryRequestDaoImpl: approveAdvanceSalary : Ending");
	
	return count;
}


public String sendEmailToManagerStatus(String adminMailId,String senderName,String url) {
	
	String mailStatus=null;
	try {
		EmailContent em = new EmailContent();
		String[] mails = {adminMailId};

		em.setMailids(mails);
		em.setSubject("Advanced Salary Request");
em.setMessage("Dear "+senderName+ ", \n"
				+"Greetings From Teleindia. \n"
				+" \n"
	+"Your Advance Salary Request is Submitted Successfully. \n"
				+"For more details please login to our portal. \n\n"
	            +"URL	: " + url + "\n"
				+" \n"
			    +"Regards .\n"
			    +" \n"
		        +"E-ATTENDANCE PRO .\n"
				+"--------------------------------------------------------\n"
				+"This is System generated mails, Please do not reply   .\n\n");
mailStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	return mailStatus;
}

public Map<String,List<AdvanceSalaryConsolidateReportVo>> advanceSalaryConsolidateReport(
		AdvanceSalaryConsolidateReportVo advanceSalaryReport) {
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingDaoImpl: advanceSalaryConsolidateReport Starting");
	
Map<String, List<AdvanceSalaryConsolidateReportVo>> advancedSalaryConsolidateMap=new LinkedHashMap<String, List<AdvanceSalaryConsolidateReportVo>>();
	ArrayList<AdvanceSalaryConsolidateReportVo> advancedSalaryConsolidateList=new ArrayList<AdvanceSalaryConsolidateReportVo>();
	
	Connection connection = null;
	PreparedStatement psAdvanceSalary = null;
    ResultSet rsAdvanceSalary=null;
    int count=0;
    String directorStatus=null;
    String adminStatus=null;
   String managerName=null;
String approvedByName=advanceSalaryReport.getApprovedByName();
    try{
		connection= getConnection();
		psAdvanceSalary=connection.prepareStatement(AdvancedSalaryRequest.ADVANCE_SALARY_CONSOLIDATED_REPORT_MANAGER);
		psAdvanceSalary.setString(1,advanceSalaryReport.getDirectorCode());
		psAdvanceSalary.setString(2,advanceSalaryReport.getDirectorCode());
		psAdvanceSalary.setString(3,advanceSalaryReport.getStatus());
		psAdvanceSalary.setString(4,HelperClass.convertUIToDatabase(advanceSalaryReport.getStartDate()));
		psAdvanceSalary.setString(5,HelperClass.convertUIToDatabase(advanceSalaryReport.getEndDate()));
		rsAdvanceSalary=psAdvanceSalary.executeQuery();
	
		
		
		while(rsAdvanceSalary.next()){
		
			  if(advancedSalaryConsolidateList.size()!=0){
					
					if(!(advancedSalaryConsolidateList.get(advancedSalaryConsolidateList.size()-1).getManagerName().equalsIgnoreCase(rsAdvanceSalary.getString("requestedbyname")))){
						
						advancedSalaryConsolidateMap.put(advancedSalaryConsolidateList.get(advancedSalaryConsolidateList.size()-1).getManagerName(), advancedSalaryConsolidateList);
						
						count=0;
						advancedSalaryConsolidateList=new ArrayList<AdvanceSalaryConsolidateReportVo>();
					}
						
					}
			AdvanceSalaryConsolidateReportVo advanceSalaryConsolidateReportVo=new AdvanceSalaryConsolidateReportVo();
			advanceSalaryConsolidateReportVo.setEmployeeName(rsAdvanceSalary.getString("employeename"));
		
			
			
			
			count++;
			
			advanceSalaryConsolidateReportVo.setEmployeeBioId(rsAdvanceSalary.getString("bioid"));
			advanceSalaryConsolidateReportVo.setClaimedAmount(rsAdvanceSalary.getString("salary_amount"));
			String approvedAmount=rsAdvanceSalary.getString("ApprovedAmount");
			
		
			if(approvedAmount==null){
				advanceSalaryConsolidateReportVo.setApprovedAmount("-");
			}
			else
			{
				advanceSalaryConsolidateReportVo.setApprovedAmount(rsAdvanceSalary.getString("ApprovedAmount"));		
			}
				
				advanceSalaryConsolidateReportVo.setClaimedDate(HelperClass.convertDatabaseToUI(rsAdvanceSalary.getString("requestedDate")));
				String approveDate=rsAdvanceSalary.getString("approveddate");
			if(("-").equals(approveDate)){
				advanceSalaryConsolidateReportVo.setApprovedDate("-");
			}
			else
			{
				advanceSalaryConsolidateReportVo.setApprovedDate(HelperClass.convertDatabaseToUI(approveDate));
			}
			directorStatus=rsAdvanceSalary.getString("dirctorStatus");
		
			if(directorStatus.equalsIgnoreCase("Y")){
				advanceSalaryConsolidateReportVo.setDirectorStatus("Approved");
			}
			else if(directorStatus.equalsIgnoreCase("N")){
				advanceSalaryConsolidateReportVo.setDirectorStatus("Not Approved");
			}
			else
			{
				advanceSalaryConsolidateReportVo.setDirectorStatus("Rejected");
			}
			adminStatus=rsAdvanceSalary.getString("adminStatus");
			if(adminStatus.equalsIgnoreCase("Y")){
				advanceSalaryConsolidateReportVo.setAdminStatus("Approved");
			}
			else if(adminStatus.equalsIgnoreCase("N")){
				advanceSalaryConsolidateReportVo.setAdminStatus("Not Approved");
			}
			else
			{
				advanceSalaryConsolidateReportVo.setAdminStatus("Rejected");
			}
			
	
				advanceSalaryConsolidateReportVo.setProjectReferenceCode(rsAdvanceSalary.getString("ProjectRefCode"));
				managerName=rsAdvanceSalary.getString("requestedbyname");
				advanceSalaryConsolidateReportVo.setManagerName(managerName);
				advanceSalaryConsolidateReportVo.setSno(count);
			advanceSalaryConsolidateReportVo.setClaimedByName(managerName);
			advanceSalaryConsolidateReportVo.setAccountentApproved(rsAdvanceSalary.getString("accountname"));
			advanceSalaryConsolidateReportVo.setApprovedByName(approvedByName);
				advancedSalaryConsolidateList.add(advanceSalaryConsolidateReportVo);

			}
		if(advancedSalaryConsolidateList.size()!=0){
			advancedSalaryConsolidateMap.put(advancedSalaryConsolidateList.get(advancedSalaryConsolidateList.size()-1).getManagerName(), advancedSalaryConsolidateList);
		}
	
		
	
	// TODO Auto-generated method stub
	
}
    catch(Exception exception){
    	exception.printStackTrace();
    	
    }
    
    

	JSONArray array=new JSONArray();
	array.put(advancedSalaryConsolidateMap);
   System.out.println("array"+array);
    
    
	return advancedSalaryConsolidateMap;

}


public Map<String,List<AdvanceSalaryConsolidateReportVo>> advanceSalaryConsolidateReportByProject(
		AdvanceSalaryConsolidateReportVo advanceSalaryReport) {
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingDaoImpl: advanceSalaryConsolidateReportByProject Starting");
	
Map<String, List<AdvanceSalaryConsolidateReportVo>> advancedSalaryConsolidateMap=new LinkedHashMap<String, List<AdvanceSalaryConsolidateReportVo>>();
	ArrayList<AdvanceSalaryConsolidateReportVo> advancedSalaryConsolidateList=new ArrayList<AdvanceSalaryConsolidateReportVo>();
	
	Connection connection = null;
	PreparedStatement psAdvanceSalary = null;
    ResultSet rsAdvanceSalary=null;
    int count=0;
    String directorStatus=null;
    String adminStatus=null;
   String projectReferenceCode=null;
String approvedByName=advanceSalaryReport.getApprovedByName();
    try{
		connection= getConnection();
		psAdvanceSalary=connection.prepareStatement(AdvancedSalaryRequest.ADVANCE_SALARY_CONSOLIDATED_REPORT_BY_PROJECT);
		psAdvanceSalary.setString(1,advanceSalaryReport.getDirectorCode());
		psAdvanceSalary.setString(2,advanceSalaryReport.getDirectorCode());
		psAdvanceSalary.setString(3,advanceSalaryReport.getStatus());
		psAdvanceSalary.setString(4,HelperClass.convertUIToDatabase(advanceSalaryReport.getStartDate()));
		psAdvanceSalary.setString(5,HelperClass.convertUIToDatabase(advanceSalaryReport.getEndDate()));
		rsAdvanceSalary=psAdvanceSalary.executeQuery();
		
		while(rsAdvanceSalary.next()){
			AdvanceSalaryConsolidateReportVo advanceSalaryConsolidateReportVo=new AdvanceSalaryConsolidateReportVo();
			

			  if(advancedSalaryConsolidateList.size()!=0){
					
					if(!(advancedSalaryConsolidateList.get(advancedSalaryConsolidateList.size()-1).getProjectReferenceCode().equalsIgnoreCase(rsAdvanceSalary.getString("ProjectRefCode")))){
						
						advancedSalaryConsolidateMap.put(advancedSalaryConsolidateList.get(advancedSalaryConsolidateList.size()-1).getProjectReferenceCode(), advancedSalaryConsolidateList);
						
						count=0;
						advancedSalaryConsolidateList=new ArrayList<AdvanceSalaryConsolidateReportVo>();
					}
						
					}
			
			advanceSalaryConsolidateReportVo.setEmployeeName(rsAdvanceSalary.getString("employeename"));
			count++;
			
			advanceSalaryConsolidateReportVo.setEmployeeBioId(rsAdvanceSalary.getString("bioid"));
			advanceSalaryConsolidateReportVo.setClaimedAmount(rsAdvanceSalary.getString("salary_amount"));
			String approvedAmount=rsAdvanceSalary.getString("ApprovedAmount");
			if(approvedAmount==null){
				advanceSalaryConsolidateReportVo.setApprovedAmount("-");
			}
			else
			{
				advanceSalaryConsolidateReportVo.setApprovedAmount(rsAdvanceSalary.getString("ApprovedAmount"));	
			}
		
				
				advanceSalaryConsolidateReportVo.setClaimedDate(HelperClass.convertDatabaseToUI(rsAdvanceSalary.getString("requestedDate")));
				String approveDate=rsAdvanceSalary.getString("approveddate");
			
				if(("-").equals(approveDate)){
					
					advanceSalaryConsolidateReportVo.setApprovedDate("-");
				}
				else
				{
					
					advanceSalaryConsolidateReportVo.setApprovedDate(HelperClass.convertDatabaseToUI(approveDate));
				}
				
				projectReferenceCode=rsAdvanceSalary.getString("ProjectRefCode");
				
				advanceSalaryConsolidateReportVo.setProjectReferenceCode(projectReferenceCode);
				advanceSalaryConsolidateReportVo.setSno(count);
				directorStatus=rsAdvanceSalary.getString("dirctorStatus");
				if(directorStatus.equalsIgnoreCase("Y")){
					advanceSalaryConsolidateReportVo.setDirectorStatus("Approved");
				}
				else if(directorStatus.equalsIgnoreCase("N")){
					advanceSalaryConsolidateReportVo.setDirectorStatus("Not Approved");
				}
				else
				{
					advanceSalaryConsolidateReportVo.setDirectorStatus("Rejected");
				}
				adminStatus=rsAdvanceSalary.getString("adminStatus");
				if(adminStatus.equalsIgnoreCase("Y")){
					advanceSalaryConsolidateReportVo.setAdminStatus("Approved");
				}
				else if(adminStatus.equalsIgnoreCase("N")){
					advanceSalaryConsolidateReportVo.setAdminStatus("Not Approved");
				}
				else
				{
					advanceSalaryConsolidateReportVo.setAdminStatus("Rejected");
				}
				/*advanceSalaryConsolidateReportVo.setAdminStatus(rsAdvanceSalary.getString("adminStatus"));
				advanceSalaryConsolidateReportVo.setDirectorStatus(rsAdvanceSalary.getString("dirctorStatus"));*/
			advanceSalaryConsolidateReportVo.setClaimedByName(rsAdvanceSalary.getString("requestedbyname"));
			advanceSalaryConsolidateReportVo.setAccountentApproved(rsAdvanceSalary.getString("accountname"));
			
			
				advanceSalaryConsolidateReportVo.setApprovedByName(approvedByName);
				advancedSalaryConsolidateList.add(advanceSalaryConsolidateReportVo);

			}
			
			
		if(advancedSalaryConsolidateList.size()!=0){
			advancedSalaryConsolidateMap.put(advancedSalaryConsolidateList.get(advancedSalaryConsolidateList.size()-1).getProjectReferenceCode(), advancedSalaryConsolidateList);
		}	
			
		

		

	
	// TODO Auto-generated method stub
	
}
    catch(Exception exception){
    	exception.printStackTrace();
    	
    }
	return advancedSalaryConsolidateMap;

}


public String sendEmailToManagerRejectSalary(String managerName,String managerEmail,String url) {
	
	String mailStatus=null;
	try {
		EmailContent em = new EmailContent();
		String[] mails = {managerEmail};

		em.setMailids(mails);
		em.setSubject("Advanced Salary Request Rejected");

		em.setMessage("Dear "+managerName+ ", \n"
				+"Greetings From Teleindia . \n"
				+" \n"
				+"Your Advance Salary Request is Rejected. \n"
				+"For more details please login to our portal.\n"
				+"URL	: " + url + "\n"
				+" \n"
				+"Regards .\n"
				+" \n"
				+"E-ATTENDANCE PRO .\n"
				+"--------------------------------------------------------\n"
				+"This is System generated mails, Please do not reply   .\n\n");
		mailStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	return mailStatus;
}
public String sendEmailToDirectorByAdmin(String directorMailId,String directorName,String url) {
	
	String mailStatus=null;
	try {
		EmailContent em = new EmailContent();
		String[] mails = {directorMailId};

		em.setMailids(mails);
		em.setSubject("Advanced Salary Approved");

		em.setMessage("Dear "+directorName+ ", \n"
				+"Greetings From Teleindia . \n"
				+" \n"
				+"Your Advance Salary is Approved. \n"
				+"For more details please login to our portal.\n"
				+"URL	: " + url + "\n"
				+" \n"
				+"Regards .\n"
				+" \n"
				+"E-ATTENDANCE PRO .\n"
				+"--------------------------------------------------------\n"
				+"This is System generated mails, Please do not reply   .\n\n");
mailStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	return mailStatus;
}

public String sendEmailToManagerByAdmin(String managerMail,String managerName,String url) {
	
	String mailStatus=null;
	try {
		EmailContent em = new EmailContent();
		String[] mails = {managerMail};

		em.setMailids(mails);
		em.setSubject("Advanced Salary Approved");

		em.setMessage("Dear "+managerName+ ", \n"
				+"Greetings From Teleindia . \n"
				+" \n"
				+"Your Advance Salary is Approved. \n"
				+"For more details please login to our portal.\n"
				+"URL	: " + url + "\n"
				+" \n"
				+"Regards .\n"
				+" \n"
				+"E-ATTENDANCE PRO .\n"
				+"--------------------------------------------------------\n"
				+"This is System generated mails, Please do not reply   .\n\n");
mailStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	return mailStatus;
}
}