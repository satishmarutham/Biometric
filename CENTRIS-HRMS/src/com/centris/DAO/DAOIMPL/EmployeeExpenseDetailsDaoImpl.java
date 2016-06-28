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
import com.centris.DAO.EmployeeExpenseDetailsDao;
import com.centris.POJO.EmployeeExpenseDetailsPojo;
import com.centris.VO.EmployeeExpenseDetailsVo;
import com.centris.VO.LocalConveyanceExpensesVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.MiscellaneousExpensesVo;
import com.centris.VO.MonthlyExpenseDisplayVO;
import com.centris.VO.OtherWorkExpensesVo;
import com.centris.VO.PurchaseExpensesVO;
import com.centris.VO.StaffExpensesVO;
import com.centris.VO.TelephoneExpensesVO;
import com.centris.VO.TravelExpensesVO;
import com.centris.form.EmployeeExpenseDetailsForm;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.SQLUtils.Manager;
import com.centris.util.constants.MessageConstants;

public class EmployeeExpenseDetailsDaoImpl extends DBService implements
		EmployeeExpenseDetailsDao {
	private static Logger logger = Logger
			.getLogger(EmployeeExpenseDetailsDaoImpl.class);

	@Override
	public List<EmployeeExpenseDetailsVo> getEmployeeDetails(
			EmployeeExpenseDetailsPojo obj) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getEmployeeDetails Starting");
		List<EmployeeExpenseDetailsVo> emp_Details = new ArrayList<EmployeeExpenseDetailsVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = getConnection();
			pstmt = con
					.prepareStatement(Employee.GET_EMPLOYEE_DETAILS_FOREXPENSE);
			pstmt.setString(1, obj.getUserName());
			pstmt.setString(2, obj.getUserCode());
			rs = pstmt.executeQuery();
			
					while (rs.next()) {
				EmployeeExpenseDetailsVo voOj = new EmployeeExpenseDetailsVo();
				voOj.setEmp_ID(rs.getString("EMPID"));
				voOj.setEmp_Name(rs.getString("First_Name"));
				voOj.setEmp_ContactNumber(rs.getString("Mobile_Number"));
				voOj.setEmp_Designation(rs.getString("designationName"));
				voOj.setEmp_MailId(rs.getString("Official_Email_ID"));
				
				if(rs.getString("ManagerName")!=null){
				voOj.setEmp_ProjectManagerName(rs.getString("ManagerName"));
				}else{
					voOj.setEmp_ProjectManagerName("-");
				}
				
				
				voOj.setEmp_BioId(rs.getString("bioid"));
				if(rs.getString("ManagerCode")!=null){
				voOj.setEmp_ManagerId(rs.getString("ManagerCode"));
				}else{
					voOj.setEmp_ManagerId("-");
				}
				emp_Details.add(voOj);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getEmployeeDetails Ending");
		return emp_Details;
	}

	@Override
	public String saveEmployeeTotalExpenseDetails(
			EmployeeExpenseDetailsForm formObj, String Id) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : saveEmployeeTotalExpenseDetails Starting");

		PreparedStatement pstmt = null;
		Connection con = null;
		int status = 0;
		int uploadStatus = 0;

		String message = null;
		try {

			con = getConnection();
			con.setAutoCommit(false);
	     	int count = checkExpenseCode(Id,con);
			if(count==0){
			   pstmt = con.prepareStatement(Employee.INSERT_EMPLOYEE_TOTALEXPENSE);
				
			   pstmt.setString(1, Id);
				pstmt.setString(2, formObj.getEmployeeId().trim());
			 	pstmt.setString(3, formObj.getExpense_Year().trim());
				pstmt.setString(4, formObj.getExpense_month().trim());
				pstmt.setString(5, formObj.getEmployeeMangId().trim());

				pstmt.setString(6, formObj.getTotallocalAmount().trim());
				pstmt.setString(7, formObj.getTotaltravelAmount().trim());
				pstmt.setString(8, formObj.getTotalstaffAmount().trim());
				pstmt.setString(9, formObj.getTotaltelephoneAmount().trim());
				pstmt.setString(10, formObj.getTotalpurchaseAmount().trim());
				pstmt.setString(11, formObj.getTotalotherAmount().trim());
				pstmt.setString(12, formObj.getTotalmiscellaneousAmount().trim());
				pstmt.setString(13, formObj.getTotalfinal().trim());
				pstmt.setString(14, HelperClass.getCurrentSqlDate().toString()
						+ " " + HelperClass.getCurrentTime().toString());
				pstmt.setString(15, formObj.getEmployeeId().trim());
						
				if(formObj.getLoginUserMangPrevId()!=""){
					
					pstmt.setString(16, MessageConstants.YES);
					pstmt.setDate(17, HelperClass.getCurrentSqlDate());
					pstmt.setString(18, formObj.getTotalfinal());
				}else{
					pstmt.setString(16, MessageConstants.NO);
					pstmt.setDate(17, null);
					pstmt.setDate(18, null);
				}

			}else{
			   pstmt = con.prepareStatement(Employee.UPDATE_EMPLOYEE_TOTALEXPENSE);
				
			   pstmt.setString(1, formObj.getEmployeeId().trim());
				pstmt.setString(2, formObj.getExpense_Year().trim());
				pstmt.setString(3, formObj.getExpense_month().trim());
				pstmt.setString(4, formObj.getEmployeeMangId().trim());

				pstmt.setString(5, formObj.getTotallocalAmount().trim());
				pstmt.setString(6, formObj.getTotaltravelAmount().trim());
				pstmt.setString(7, formObj.getTotalstaffAmount().trim());
				pstmt.setString(8, formObj.getTotaltelephoneAmount().trim());
				pstmt.setString(9, formObj.getTotalpurchaseAmount().trim());

				pstmt.setString(10, formObj.getTotalotherAmount().trim());
				pstmt.setString(11, formObj.getTotalmiscellaneousAmount().trim());
				pstmt.setString(12, formObj.getTotalfinal().trim());
				pstmt.setString(13, HelperClass.getCurrentSqlDate().toString()
						+ " " + HelperClass.getCurrentTime().toString());
				pstmt.setString(14, formObj.getEmployeeId().trim());
                 
				if(formObj.getLoginUserMangPrevId()!=""){
					
					pstmt.setString(15, MessageConstants.YES);
					pstmt.setString(16, formObj.getTotalfinal());
					pstmt.setDate(17, HelperClass.getCurrentSqlDate());
				
				}else{
					pstmt.setString(15, MessageConstants.NO);
					pstmt.setString(16, null);
					pstmt.setDate(17, null);
				}
				pstmt.setString(18, Id);
			

			}
			

			status = pstmt.executeUpdate();
				
			if (status > 0) {

				if ((formObj.getAllowanceDate() != null)
						&& (formObj.getAllowanceDate().length > 0)) {
					uploadStatus = saveLocalExpenseDetails(formObj, Id, con);
				}
				if ((formObj.getTravelDate() != null)
						&& (formObj.getTravelDate().length > 0)) {
					uploadStatus = saveTravelExpenseDetails(formObj, Id, con);
				}
				if ((formObj.getStaffFromDate() != null)
						&& (formObj.getStaffFromDate().length > 0)) {
					uploadStatus = saveStaffExpenseDetails(formObj, Id, con);
				}
				if ((formObj.getTelephoneDate() != null)
						&& (formObj.getTelephoneDate().length > 0)) {
					uploadStatus = saveTelephoneExpenseDetails(formObj, Id, con);
				}
				if ((formObj.getPurchaseDate() != null)
						&& (formObj.getPurchaseDate().length > 0)) {
					uploadStatus = savePurchaseExpenseDetails(formObj, Id, con);
				}
				if ((formObj.getOtherDate() != null)
						&& (formObj.getOtherDate().length > 0)) {
					uploadStatus = saveOtherExpenseDetails(formObj, Id, con);
				}
				if ((formObj.getMiscellaneousDate() != null)
						&& (formObj.getMiscellaneousDate().length > 0)) {
					uploadStatus = saveMiscellaneousExpenseDetails(formObj, Id,
							con);
				}
				if ((uploadStatus > 0)) {
					con.commit();
					message = "success";
				
					String result="";
				
					if(formObj.getLoginUserMangPrevId()!=""){
						   result= sendExpensesClaimEmailToDirector(formObj,con);
							result=sendEmailToEmployeeStatus(formObj, con);
					}else{
						result=sendExpensesClaimEmailToManager(formObj,con);
						result=sendEmailToEmployeeStatus(formObj, con);
					}
					
					if(result=="false"){
						message=MessageConstants.MAIL_NOT_SENT;
					}
					
					
				} else {
					try {
						con.rollback();
					} catch (SQLException e1) {
						logger.error(e1.getMessage(), e1);
						e1.printStackTrace();
					}
					message = "fail";
				}
			} else {
				message = "fail";
				try {
					con.rollback();
				} catch (SQLException e1) {
					logger.error(e1.getMessage(), e1);
					e1.printStackTrace();
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			try {
				con.rollback();
				message = "fail";
			} catch (SQLException e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : saveEmployeeTotalExpenseDetails Ending");
		return message;
	}

	public  String sendExpensesClaimEmailToDirector(
			EmployeeExpenseDetailsForm formObj, Connection con) {
		
		String status = null;
		
		try{
		Map<String,String> diremap= geDirectorDetails(formObj.getLoginUserMangPrevId(),con);
		Map<String,String> empmap=geEmpDetails(formObj.getEmployeeId(),con);
		
		String url = new  EmployeeDAOImpl().getServerUrlFromBD(con);
		
		String direName=diremap.get("direName");
		String direEmailid=diremap.get("direEmail");
		String empName=empmap.get("EmpFirstName");
		String monthName=HelperClass.getMonthName(formObj.getExpense_month());
		String year = formObj.getExpense_Year();
		String[] mails={direEmailid};
		
		EmailContent em = new EmailContent();
		
		em.setMailids(mails);
		em.setSubject("Employee Expenses");
		
		em.setMessage("Dear "+direName+", \n"
				+ "Greetings from TeleIndia. \n\n"
				+ "Employee "+empName+" Claimed Expenses month of "+monthName+" - "+year+ "\n\n"
				+ "For more Details Login URL : " + url + "\n"
				+ "Approve the  Expenses \n\n"
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
      	
      	return status;
	}

	public String sendExpensesClaimEmailToManager(
			EmployeeExpenseDetailsForm formObj, Connection con) {

         String status=null;
		
		try{
			Map<String,String> managermap=geManagerDetails(formObj.getEmployeeMangId(),con);
			Map<String,String> empmap=geEmpDetails(formObj.getEmployeeId(),con);
			
			String url = new  EmployeeDAOImpl().getServerUrlFromBD(con);
		
			EmailContent em = new EmailContent();
			String managerName=managermap.get("FirstName");
			String mangEmailid=managermap.get("email");
			String empName=empmap.get("EmpFirstName");
			String monthName=HelperClass.getMonthName(formObj.getExpense_month());
			String year=formObj.getExpense_Year();
			
			String[] mails={mangEmailid};
			
				em.setMailids(mails);
				em.setSubject("Employee Expenses");
				
				em.setMessage("Dear "+managerName+", \n"
						+ "Greetings from TeleIndia. \n\n"
						+ "Employee "+empName+" Claimed Expenses month of "+monthName+" - "+year+ "\n\n"
						+ "For more Details Login URL : " + url + "\n"
						+ "Approve the  Expenses \n\n"
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
		
		
	return status;
	}

	public Map<String, String> geEmpDetails(String employeeId, Connection con) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : geEmpDetails Starting");
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,String> empMap= new HashMap<String, String>();
		try {
			
			ps = con.prepareStatement(Employee.GET_EMPLOYEE);
			ps.setString(1, employeeId);
			
			
			rs = ps.executeQuery();

			while(rs.next()){
				
				empMap.put("EmpFirstName", rs.getString("First_Name").trim());
				empMap.put("EmpemailId", rs.getString("Official_Email_ID").trim());
				
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
				+ " Control in EmployeeExpenseDetailsDaoImpl : geEmpDetails Ending");
		return empMap;
	}

	public Map<String, String> geManagerDetails(String employeeMangId, Connection con) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : geManagerDetails Starting");
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,String> managerMap= new HashMap<String, String>();
		try {
			
			ps = con.prepareStatement(Employee.GET_MANAGER);
			ps.setString(1, employeeMangId);
			
			rs = ps.executeQuery();

			while(rs.next()){
				
					managerMap.put("FirstName", rs.getString("FirstName").trim());
					managerMap.put("email", rs.getString("email").trim());
				
					
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
				+ " Control in EmployeeExpenseDetailsDaoImpl : geManagerDetails Ending");
		return managerMap;
	}

	public int saveLocalExpenseDetails(EmployeeExpenseDetailsForm formObj,
			String Id, Connection conn) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : saveLocalExpenseDetails Starting");

		PreparedStatement pstmt = null;
		Connection con = null;
		int status = 0;
		try {
			con = conn;
			 int count = checkLocalExpense(Id,con); 
			 
			 
			 if(count>0){	
				   pstmt = con.prepareStatement(Employee.DELETE_LOCAL_EXPENSE);
					pstmt.setString(1, Id);
					count=pstmt.executeUpdate();
					if (pstmt != null && (!pstmt.isClosed())) {

						  pstmt.close();
					  }
				
					
				 for (int i = 0; i < formObj.getAllowanceDate().length; i++) {
						
						  pstmt = con.prepareStatement(Employee.INSERT_LOCAL_EXPENSE);
						    pstmt.setString(1, Id);
							pstmt.setString(2, HelperClass.convertUIToDatabase(formObj
									.getAllowanceDate()[i]));
							pstmt.setString(3, formObj.getAllowancelocation()[i]);
							pstmt.setString(4, formObj.getAllowancefrom()[i]);
							pstmt.setString(5, formObj.getAllowanceto()[i]);
							pstmt.setString(6, formObj.getAllowanceremarks()[i]);

							pstmt.setString(7, formObj.getAllowancemode()[i]);
							pstmt.setString(8, formObj.getAllowanceamount()[i]);
							pstmt.setString(9, formObj.getEmployeeId().trim());
							pstmt.setString(10, formObj.getEmployeeId().trim());
					
							status = pstmt.executeUpdate();
						}		
			}else{
				for (int i = 0; i < formObj.getAllowanceDate().length; i++) {
					
				  pstmt = con.prepareStatement(Employee.INSERT_LOCAL_EXPENSE);
				    pstmt.setString(1, Id);
					pstmt.setString(2, HelperClass.convertUIToDatabase(formObj
							.getAllowanceDate()[i]));
					pstmt.setString(3, formObj.getAllowancelocation()[i]);
					pstmt.setString(4, formObj.getAllowancefrom()[i]);
					pstmt.setString(5, formObj.getAllowanceto()[i]);
					pstmt.setString(6, formObj.getAllowanceremarks()[i]);

					pstmt.setString(7, formObj.getAllowancemode()[i]);
					pstmt.setString(8, formObj.getAllowanceamount()[i]);
					pstmt.setString(9, formObj.getEmployeeId().trim());
				    pstmt.setString(10, formObj.getEmployeeId().trim());
			
					status = pstmt.executeUpdate();
				}
				
			}
		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try {
				if (pstmt != null && (!pstmt.isClosed())) {

					  pstmt.close();
				  }
			}catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
			
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : saveLocalExpenseDetails Ending");
		return status;
	}

	

	public int saveTravelExpenseDetails(EmployeeExpenseDetailsForm formObj,
			String Id, Connection conn) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : saveTravelExpenseDetails Starting");

		PreparedStatement pstmt = null;
		Connection con = null;
		int status = 0;
		try {
			con = conn;
			
			int count = checkTravelExpense(Id,con);
			if(count>0){
				pstmt = con.prepareStatement(Employee.DELETE_TRAVEL_EXPENSE);
				pstmt.setString(1, Id);
			
		        count =pstmt.executeUpdate();
				if (pstmt != null && (!pstmt.isClosed())) {

					  pstmt.close();
				  }
              for (int i = 0; i < formObj.getTravelDate().length; i++) {
					
					pstmt = con.prepareStatement(Employee.INSERT_TRAVEL_EXPENSE);
					pstmt.setString(1, Id);
					pstmt.setString(2, HelperClass.convertUIToDatabase(formObj
							.getTravelDate()[i]));
					pstmt.setString(3, formObj.getTravellocation()[i]);
					pstmt.setString(4, formObj.getTravelfrom()[i]);
					pstmt.setString(5, formObj.getTravelto()[i]);
					pstmt.setString(6, formObj.getTravelremarks()[i]);

					pstmt.setString(7, formObj.getTravelmode()[i]);
					pstmt.setString(8, formObj.getTravelamount()[i]);
					pstmt.setString(9, formObj.getEmployeeId().trim());
				    pstmt.setString(10, formObj.getEmployeeId().trim());
					status = pstmt.executeUpdate();
              }
			}else{
				for (int i = 0; i < formObj.getTravelDate().length; i++) {
					
					pstmt = con.prepareStatement(Employee.INSERT_TRAVEL_EXPENSE);
					pstmt.setString(1, Id);
					pstmt.setString(2, HelperClass.convertUIToDatabase(formObj
							.getTravelDate()[i]));
					pstmt.setString(3, formObj.getTravellocation()[i]);
					pstmt.setString(4, formObj.getTravelfrom()[i]);
					pstmt.setString(5, formObj.getTravelto()[i]);
					pstmt.setString(6, formObj.getTravelremarks()[i]);

					pstmt.setString(7, formObj.getTravelmode()[i]);
					pstmt.setString(8, formObj.getTravelamount()[i]);
					pstmt.setString(9, formObj.getEmployeeId().trim());
				   pstmt.setString(10, formObj.getEmployeeId().trim());
					status = pstmt.executeUpdate();
				}
				
			}				
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try {
				if (pstmt != null && (!pstmt.isClosed())) {

					  pstmt.close();
				  }
			}catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
			
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : saveTravelExpenseDetails Ending");
		return status;
	}



	public int saveStaffExpenseDetails(EmployeeExpenseDetailsForm formObj,
			String Id, Connection conn) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : saveStaffExpenseDetails Starting");

		PreparedStatement pstmt = null;
		Connection con = null;
		int status = 0;
		try {
			con = conn;
			int count = checkStaffWelfare(Id,con);
			if(count > 0){
				pstmt = con.prepareStatement(Employee.DELETE_STAFFWELFARE_EXPENSE);
				pstmt.setString(1, Id);
			    count =pstmt.executeUpdate();
    		   if (pstmt != null && (!pstmt.isClosed())) {
						  pstmt.close();
					 }
    		   for (int i = 0; i < formObj.getStafflocation().length; i++) {
    			pstmt = con
						.prepareStatement(Employee.INSERT_STAFFWELFARE_EXPENSE);
				pstmt.setString(1, Id);
				pstmt.setString(2, formObj.getStafflocation()[i]);
				pstmt.setString(3, HelperClass.convertUIToDatabase(formObj
						.getStaffFromDate()[i]));
				pstmt.setString(4, HelperClass.convertUIToDatabase(formObj
						.getStaffToDate()[i]));
				pstmt.setString(5, formObj.getStaffnoOfDays()[i]);
				pstmt.setString(6, formObj.getStaffsingleOrTeam()[i]);

				pstmt.setString(7, formObj.getStaffallowance()[i]);
				pstmt.setString(8, formObj.getStaffamount()[i]);
				pstmt.setString(9, formObj.getEmployeeId().trim());
				pstmt.setString(10, formObj.getEmployeeId().trim());
				
				status = pstmt.executeUpdate();
    		   }
			}else{
				
				   for (int i = 0; i < formObj.getStafflocation().length; i++) {
		    			pstmt = con
								.prepareStatement(Employee.INSERT_STAFFWELFARE_EXPENSE);
						pstmt.setString(1, Id);
						pstmt.setString(2, formObj.getStafflocation()[i]);
						pstmt.setString(3, HelperClass.convertUIToDatabase(formObj
								.getStaffFromDate()[i]));
						pstmt.setString(4, HelperClass.convertUIToDatabase(formObj
								.getStaffToDate()[i]));
						pstmt.setString(5, formObj.getStaffnoOfDays()[i]);
						pstmt.setString(6, formObj.getStaffsingleOrTeam()[i]);

						pstmt.setString(7, formObj.getStaffallowance()[i]);
						pstmt.setString(8, formObj.getStaffamount()[i]);
						pstmt.setString(9, formObj.getEmployeeId().trim());
						pstmt.setString(10, formObj.getEmployeeId().trim());
						
						status = pstmt.executeUpdate();
				   }
				
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try {
				if (pstmt != null && (!pstmt.isClosed())) {

					  pstmt.close();
				  }
			}catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
			
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : saveStaffExpenseDetails Ending");
		return status;
	}



	public int saveTelephoneExpenseDetails(EmployeeExpenseDetailsForm formObj,
			String Id, Connection conn) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : saveTelephoneExpenseDetails Starting");

		PreparedStatement pstmt = null;
		Connection con = null;
		int status = 0;
		try {
			con = conn;
			int count = checkTelephoneExpenses(Id,con);
			if(count>0){
				
				pstmt = con.prepareStatement(Employee.DELETE_TELEPHONE_EXPENSE);
				pstmt.setString(1, Id);
			    count =pstmt.executeUpdate();
    		    if (pstmt != null && (!pstmt.isClosed())) {
						  pstmt.close();
				 }
    			for (int i = 0; i < formObj.getTelephoneDate().length; i++) {
    				
    			pstmt = con.prepareStatement(Employee.INSERT_TELEPHONE_EXPENSE);
				pstmt.setString(1, Id);
				pstmt.setString(2, HelperClass.convertUIToDatabase(formObj
						.getTelephoneDate()[i]));
				pstmt.setString(3, formObj.getTelephonePhoneNo()[i]);
				pstmt.setString(4, formObj.getTelephoneLocation()[i]);

				pstmt.setString(5, formObj.getTelephoneamount()[i]);
				pstmt.setString(6, formObj.getEmployeeId().trim());
				pstmt.setString(7, formObj.getEmployeeId().trim());
				status = pstmt.executeUpdate();
    			}
			}else{
				for (int i = 0; i < formObj.getTelephoneDate().length; i++) {
				
					pstmt = con.prepareStatement(Employee.INSERT_TELEPHONE_EXPENSE);
					pstmt.setString(1, Id);
					pstmt.setString(2, HelperClass.convertUIToDatabase(formObj
							.getTelephoneDate()[i]));
					pstmt.setString(3, formObj.getTelephonePhoneNo()[i]);
					pstmt.setString(4, formObj.getTelephoneLocation()[i]);

					pstmt.setString(5, formObj.getTelephoneamount()[i]);
					pstmt.setString(6, formObj.getEmployeeId().trim());
					pstmt.setString(7, formObj.getEmployeeId().trim());
					status = pstmt.executeUpdate();
				}
				
			}
			
			
				
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try {
				if (pstmt != null && (!pstmt.isClosed())) {

					  pstmt.close();
				  }
			}catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
			
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : saveTelephoneExpenseDetails Ending");
		return status;
	}

	public int savePurchaseExpenseDetails(EmployeeExpenseDetailsForm formObj,
			String Id, Connection conn) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : savePurchaseExpenseDetails Starting");

		PreparedStatement pstmt = null;
		Connection con = null;
		int status = 0;
		try {
			con = conn;
			int count = checkPurchaseExpense(Id,con);
			if(count >0){
				pstmt = con.prepareStatement(Employee.DELETE_PURCHASE_EXPENSE);	
				pstmt.setString(1, Id);
				count = pstmt.executeUpdate();
				for (int i = 0; i < formObj.getPurchaseDate().length; i++) {
					pstmt = con.prepareStatement(Employee.INSERT_PURCHASE_EXPENSE);
					pstmt.setString(1, Id);
					pstmt.setString(2, HelperClass.convertUIToDatabase(formObj
							.getPurchaseDate()[i]));
					pstmt.setString(3, formObj.getPurchasebillNo()[i]);
					pstmt.setString(4, formObj.getPurchaseParticular()[i]);

					pstmt.setString(5, formObj.getPurchaseamount()[i]);
					pstmt.setString(6, formObj.getEmployeeId().trim());
					pstmt.setString(7, formObj.getEmployeeId().trim());
					
					status = pstmt.executeUpdate();
				}
			
			}else{
				
				for (int i = 0; i < formObj.getPurchaseDate().length; i++) {
					pstmt = con.prepareStatement(Employee.INSERT_PURCHASE_EXPENSE);
					pstmt.setString(1, Id);
					pstmt.setString(2, HelperClass.convertUIToDatabase(formObj
							.getPurchaseDate()[i]));
					pstmt.setString(3, formObj.getPurchasebillNo()[i]);
					pstmt.setString(4, formObj.getPurchaseParticular()[i]);

					pstmt.setString(5, formObj.getPurchaseamount()[i]);
					pstmt.setString(6, formObj.getEmployeeId().trim());
					pstmt.setString(7, formObj.getEmployeeId().trim());
					
					status = pstmt.executeUpdate();
				}
			
				
				
			}
			
	
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try {
				if (pstmt != null && (!pstmt.isClosed())) {

					  pstmt.close();
				  }
			}catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
			
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : savePurchaseExpenseDetails Ending");
		return status;
	}

	

	public int saveOtherExpenseDetails(EmployeeExpenseDetailsForm formObj,
			String Id, Connection conn) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : saveOtherExpenseDetails Starting");

		PreparedStatement pstmt = null;
		Connection con = null;
		int status = 0;
		try {
			con = conn;
			int count = checkOtherExpense(Id,con);
			if(count >0){
				pstmt = con.prepareStatement(Employee.DELETE_OTHER_EXPENSE);
				pstmt.setString(1, Id);
				count=pstmt.executeUpdate();
				  if (pstmt != null && (!pstmt.isClosed())) {
						  pstmt.close();
				 }
				  for (int i = 0; i < formObj.getOtherDate().length; i++) {
					  pstmt = con.prepareStatement(Employee.INSERT_OTHER_EXPENSE);
						pstmt.setString(1, Id);
						pstmt.setString(2, HelperClass.convertUIToDatabase(formObj
								.getOtherDate()[i]));
						pstmt.setString(3, formObj.getOtherDescription()[i]);

						pstmt.setString(4, formObj.getOtheramount()[i]);
						pstmt.setString(5, formObj.getEmployeeId().trim());
						pstmt.setString(6, formObj.getEmployeeId().trim()); 
						status = pstmt.executeUpdate();
				  }
			}else{
				for (int i = 0; i < formObj.getOtherDate().length; i++) {
					  pstmt = con.prepareStatement(Employee.INSERT_OTHER_EXPENSE);
						pstmt.setString(1, Id);
						pstmt.setString(2, HelperClass.convertUIToDatabase(formObj
								.getOtherDate()[i]));
						pstmt.setString(3, formObj.getOtherDescription()[i]);

						pstmt.setString(4, formObj.getOtheramount()[i]);
						pstmt.setString(5, formObj.getEmployeeId().trim());
						pstmt.setString(6, formObj.getEmployeeId().trim()); 
						status = pstmt.executeUpdate();
				  }
				
			}
			
		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try {
				if (pstmt != null && (!pstmt.isClosed())) {

					  pstmt.close();
				  }
			}catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
			
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : saveOtherExpenseDetails Ending");
		return status;
	}

	public int saveMiscellaneousExpenseDetails(
			EmployeeExpenseDetailsForm formObj, String Id, Connection conn) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : saveMiscellaneousExpenseDetails Starting");

		PreparedStatement pstmt = null;
		Connection con = null;
		int status = 0;
		try {
			con = conn;
			int count = checkMiscellaneousExpense(Id,con);
			if(count >0){
				pstmt = con	.prepareStatement(Employee.DELETE_MISCELLANEOUS_EXPENSE);
				pstmt.setString(1, Id);
				count=pstmt.executeUpdate();
				
				if (pstmt != null && (!pstmt.isClosed())) {

					  pstmt.close();
				  }
				for (int i = 0; i < formObj.getMiscellaneousDate().length; i++) {
					
					pstmt = con	.prepareStatement(Employee.INSERT_MISCELLANEOUS_EXPENSE);
					
					pstmt.setString(1, Id);
					pstmt.setString(2, HelperClass.convertUIToDatabase(formObj
							.getMiscellaneousDate()[i]));
					pstmt.setString(3, formObj.getMiscellaneousDescription()[i]);

					pstmt.setString(4, formObj.getMiscellaneousamount()[i]);
					pstmt.setString(5, formObj.getEmployeeId().trim());
					pstmt.setString(6, formObj.getEmployeeId().trim());
					
					status = pstmt.executeUpdate();
				}
				
			}else{
				
	            for (int i = 0; i < formObj.getMiscellaneousDate().length; i++) {
					
					pstmt = con	.prepareStatement(Employee.INSERT_MISCELLANEOUS_EXPENSE);
					
					pstmt.setString(1, Id);
					pstmt.setString(2, HelperClass.convertUIToDatabase(formObj
							.getMiscellaneousDate()[i]));
					pstmt.setString(3, formObj.getMiscellaneousDescription()[i]);

					pstmt.setString(4, formObj.getMiscellaneousamount()[i]);
					pstmt.setString(5, formObj.getEmployeeId().trim());
					pstmt.setString(6, formObj.getEmployeeId().trim());
					
					status = pstmt.executeUpdate();
				}
				
			}
			
			
			
		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try {
				if (pstmt != null && (!pstmt.isClosed())) {

					  pstmt.close();
				  }
			}catch (SQLException e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
			
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : saveMiscellaneousExpenseDetails Ending");
		return status;
	}


	@Override
	public String checkEmployeeExpenseDetails(String userId, String year,
			String month, String userprevstatus) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkEmployeeExpenseDetails Starting");
		PreparedStatement pstmt = null;
		Connection con = null;
		String status = null;
		ResultSet rst = null;
		int count = 0;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Employee.GET_EXPENSE_POSTEDCOUNT);
			pstmt.setInt(1, Integer.parseInt(year.trim()));
			pstmt.setInt(2, Integer.parseInt(month.trim()));
			pstmt.setString(3, userId.trim());
			rst = pstmt.executeQuery();
			while (rst.next()) {
				count = rst.getInt(1);
			}
			if( rst!=null  &&  !(rst.isClosed()) ){
				
				rst.close();
			}
            if( pstmt!=null  &&  !(pstmt.isClosed()) ){
				
            	pstmt.close();
			}
			
			if (count!=0) {
				if(MessageConstants.YES.equalsIgnoreCase(userprevstatus)){
					pstmt = con.prepareStatement(Employee.GET_MANAGER_EXPENSE_CODE);
				}else{
				   pstmt = con.prepareStatement(Employee.GET_EXPENSE_CODE);
				}
				
				pstmt.setInt(1, Integer.parseInt(year.trim()));
				pstmt.setInt(2, Integer.parseInt(month.trim()));
				pstmt.setString(3, userId.trim());
				rst = pstmt.executeQuery();
				
				
				while (rst.next()) {
					status = rst.getString("MEXP_CODE");
				}
			} else {
				status = "fail";
			}
		}catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
            try {
				if( rst!=null  &&  !(rst.isClosed()) ){
					
					rst.close();
				}
				 if( pstmt!=null  &&  !(pstmt.isClosed()) ){
						
		            	pstmt.close();
			   }
				 if( con!=null  &&  !(con.isClosed()) ){
						
					 con.close();
			   }
			}catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
           
		}
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkEmployeeExpenseDetails Ending");
		return status;
	}

	@Override
	public List<EmployeeExpenseDetailsVo> getEmployeeProjectDetails(
			String managerId) {
		List<EmployeeExpenseDetailsVo> emp_Details = new ArrayList<EmployeeExpenseDetailsVo>();
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getEmployeeProjectDetails Starting");
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rst = null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(Employee.GET_PROJECTNAME_AND_CODE);
			pstmt.setString(1, managerId.trim());

			rst = pstmt.executeQuery();
			
			
			while (rst.next()) {
				EmployeeExpenseDetailsVo prjDetails = new EmployeeExpenseDetailsVo();

				prjDetails.setEmp_ProjectId(rst.getString("ProjectCode"));
				prjDetails.setEmp_ProjectName(rst.getString("Project_Name"));
				emp_Details.add(prjDetails);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getEmployeeProjectDetails Ending");
		return emp_Details;
	}

	@Override
	public String getProjectRefCodeDao(String projectId) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getProjectRefCodeDao Starting");
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rst = null;
		String projectRefCode=null;

		try {
			con = getConnection();
			pstmt = con.prepareStatement(Employee.GET_PJT_REF_CODE);
			pstmt.setString(1, projectId.trim());

			rst = pstmt.executeQuery();
			while (rst.next()) {
				projectRefCode=rst.getString("ProjectRefCode");
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getProjectRefCodeDao Ending");
		return projectRefCode;
	}

	public String sendEmailToEmployeeStatus(EmployeeExpenseDetailsForm formObj, Connection con) {
		
		String mailStatus=null;
		try {
			
			Map<String,String> empmap=geEmpDetails(formObj.getEmployeeId(),con);
			
			String url = new  EmployeeDAOImpl().getServerUrlFromBD(con);
		
			EmailContent em = new EmailContent();
			String EmpemailId=empmap.get("EmpemailId");
			String empName=empmap.get("EmpFirstName");
			String monthName=HelperClass.getMonthName(formObj.getExpense_month());
			String year=formObj.getExpense_Year();
			
			String[] mails={EmpemailId};
			
				em.setMailids(mails);
				em.setSubject("Employee Expenses");
	            em.setMessage("Dear "+empName+ ", \n"
					+"Greetings From Teleindia. \n"
					+" \n"
		            +"Your Expense Details Submitted Successfully For the month of "+monthName+" - "+year+ ". \n"
					+"For more details please login to our portal. \n\n"
		            +"URL	: " + url + "\n"
					+" \n"
					+ "Have a nice day \n\n"
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


	public ArrayList<LocalConveyanceExpensesVO> getlocalconveyanceExpense(
			String expensecode) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getlocalconveyanceExpense Starting");
		PreparedStatement ps_localexp = null;
		Connection connection = null;
		ResultSet rs_localexp = null;
		ArrayList<LocalConveyanceExpensesVO> localexpenses=new ArrayList<LocalConveyanceExpensesVO>();
		try {
			connection = getConnection();
			ps_localexp = connection.prepareStatement(Employee.GET_LOCAL_EXPENSES);
			ps_localexp.setString(1, expensecode);
		
			rs_localexp = ps_localexp.executeQuery();
		
			while (rs_localexp.next()) {
			
			LocalConveyanceExpensesVO localConveyanceExpensesVO = new LocalConveyanceExpensesVO();
			   
			     localConveyanceExpensesVO.setLcsno( rs_localexp.getInt("sno"));
			     localConveyanceExpensesVO.setLcdate(HelperClass.convertDatabaseToUI(rs_localexp.getString("LC_DATE")));
			     localConveyanceExpensesVO.setLc_from(rs_localexp.getString("LC_From"));
			     localConveyanceExpensesVO.setLc_to(rs_localexp.getString("LC_To"));
			     localConveyanceExpensesVO.setLc_location(rs_localexp.getString("Location"));
			     localConveyanceExpensesVO.setLc_mode(rs_localexp.getString("LC_MODE"));
			     localConveyanceExpensesVO.setLc_ramrks(rs_localexp.getString("Remarks"));
			     localConveyanceExpensesVO.setLc_amount(rs_localexp.getDouble("AMOUNT"));
			     localConveyanceExpensesVO.setLcexpensecode(expensecode);
			     
			    localexpenses.add(localConveyanceExpensesVO);
		}

		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try{
			if(rs_localexp!=null  && !(rs_localexp.isClosed())){
					rs_localexp.close();
			}
			if(ps_localexp!=null  && !(ps_localexp.isClosed())){
				ps_localexp.close();
		     }
			if(connection!=null  && !(connection.isClosed())){
				connection.close();
				
			}
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getlocalconveyanceExpense Ending");
				
		
		return localexpenses;
	}

	
	public ArrayList<StaffExpensesVO> getStaffExpenses(String expensecode) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getStaffExpenses Starting");
		PreparedStatement ps_staffexp = null;
		Connection connection = null;
		ResultSet rs_staffexp = null;
		ArrayList<StaffExpensesVO> staffexpenses=new ArrayList<StaffExpensesVO>();
		try {
			connection = getConnection();
			ps_staffexp = connection.prepareStatement(Employee.GET_STAFF_EXPENSES);
			ps_staffexp.setString(1, expensecode);
		
			rs_staffexp = ps_staffexp.executeQuery();
		
			while (rs_staffexp.next()) {
			
				StaffExpensesVO staffExpensesVO = new StaffExpensesVO();
			   
				staffExpensesVO.setStaff_sno( rs_staffexp.getInt("sno"));
				staffExpensesVO.setStaff_location(rs_staffexp.getString("Location"));
				staffExpensesVO.setStaff_datefrom(HelperClass.convertDatabaseToUI(rs_staffexp.getString("Date_From")));
				staffExpensesVO.setStaff_dateto(HelperClass.convertDatabaseToUI(rs_staffexp.getString("Date_to")));
				staffExpensesVO.setStaff_noofdays(rs_staffexp.getInt("No_Of_Days"));
				staffExpensesVO.setStaff_assingleteam(rs_staffexp.getString("AsSingle_Team"));
				staffExpensesVO.setStaff_allowance(rs_staffexp.getString("Allowance"));
			     staffExpensesVO.setStaff_amount(rs_staffexp.getDouble("amount"));
			     staffExpensesVO.setStaff_expensecode(expensecode);
			     
			     staffexpenses.add(staffExpensesVO);
		}

		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try{
			if(rs_staffexp!=null  && !(rs_staffexp.isClosed())){
				rs_staffexp.close();
			}
			if(ps_staffexp!=null  && !(ps_staffexp.isClosed())){
				ps_staffexp.close();
		     }
			if(connection!=null  && !(connection.isClosed())){
				connection.close();
				
			}
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getStaffExpenses Ending");
				
		
		return staffexpenses;
	}


	public ArrayList<TravelExpensesVO> getTravelExpenses(String expensecode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getTravelExpenses Starting");
		PreparedStatement ps_travelexp = null;
		Connection connection = null;
		ResultSet rs_travelexp = null;
		ArrayList<TravelExpensesVO> travelexpenses=new ArrayList<TravelExpensesVO>();
		try {
			connection = getConnection();
			ps_travelexp = connection.prepareStatement(Employee.GET_TRAVEL_EXPENSES);
			ps_travelexp.setString(1, expensecode);
		
			rs_travelexp = ps_travelexp.executeQuery();
		
			while (rs_travelexp.next()) {
			
				TravelExpensesVO travelExpensesVO = new TravelExpensesVO();
					   
				travelExpensesVO.setTravexp_sno(rs_travelexp.getInt("sno"));
				travelExpensesVO.setTravexp_date(HelperClass.convertDatabaseToUI(rs_travelexp.getString("TE_DATE")));
				travelExpensesVO.setTravexp_location(rs_travelexp.getString("Location"));
				travelExpensesVO.setTravexp_from(rs_travelexp.getString("TE_From"));
				travelExpensesVO.setTravexp_to(rs_travelexp.getString("TE_To"));
				travelExpensesVO.setTravexp_ramrks(rs_travelexp.getString("Remarks"));
				travelExpensesVO.setTravexp_mode(rs_travelexp.getString("TE_Mode"));
				travelExpensesVO.setTravexp_amount(rs_travelexp.getDouble("AMOUNT"));
				travelExpensesVO.setTravexpcode(expensecode);
			     
			     travelexpenses.add(travelExpensesVO);
		}

		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try{
			if(rs_travelexp!=null  && !(rs_travelexp.isClosed())){
				rs_travelexp.close();
			}
			if(ps_travelexp!=null  && !(ps_travelexp.isClosed())){
				ps_travelexp.close();
		     }
			if(connection!=null  && !(connection.isClosed())){
				connection.close();
				
			}
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getTravelExpenses Ending");
		
		return travelexpenses;
	}


	public ArrayList<TelephoneExpensesVO> getTelephoneExpenses(	String expensecode) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getTelephoneExpenses Starting");
		PreparedStatement ps_telephoneexp = null;
		Connection connection = null;
		ResultSet rs_telephoneexp = null;
		ArrayList<TelephoneExpensesVO> telephoneexpenses=new ArrayList<TelephoneExpensesVO>();
		try {
			connection = getConnection();
			ps_telephoneexp = connection.prepareStatement(Employee.GET_TELEPHONE_EXPENSES);
			ps_telephoneexp.setString(1, expensecode);
		
			rs_telephoneexp = ps_telephoneexp.executeQuery();
		
			while (rs_telephoneexp.next()) {
			
				TelephoneExpensesVO telephoneExpensesVO = new TelephoneExpensesVO();
					   
				telephoneExpensesVO.setTeleexp_sno(rs_telephoneexp.getInt("sno"));
				telephoneExpensesVO.setTeleexp_date(HelperClass.convertDatabaseToUI(rs_telephoneexp.getString("MT_DATE")));
				telephoneExpensesVO.setTeleexp_mobileno(rs_telephoneexp.getString("Telephone_no"));
				telephoneExpensesVO.setTeleexp_location(rs_telephoneexp.getString("Location"));
				telephoneExpensesVO.setTeleexp_amount(rs_telephoneexp.getDouble("AMOUNT"));
				telephoneExpensesVO.setTeleexpcode(expensecode);
			     
				telephoneexpenses.add(telephoneExpensesVO);
		}

		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try{
			if(rs_telephoneexp!=null  && !(rs_telephoneexp.isClosed())){
				rs_telephoneexp.close();
			}
			if(ps_telephoneexp!=null  && !(ps_telephoneexp.isClosed())){
				ps_telephoneexp.close();
		     }
			if(connection!=null  && !(connection.isClosed())){
				connection.close();
				
			}
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getTelephoneExpenses Ending");
		
		return telephoneexpenses;
	}

	
	public ArrayList<PurchaseExpensesVO> getPurchaseExpenses(String expensecode) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getPurchaseExpenses Starting");
		PreparedStatement ps_purchaseexp = null;
		Connection connection = null;
		ResultSet rs_purchaseexp = null;
		ArrayList<PurchaseExpensesVO> purchaseexpenses=new ArrayList<PurchaseExpensesVO>();
		try {
			connection = getConnection();
			ps_purchaseexp = connection.prepareStatement(Employee.GET_PURCHASE_EXPENSES);
			ps_purchaseexp.setString(1, expensecode);
		
			rs_purchaseexp = ps_purchaseexp.executeQuery();
		
			while (rs_purchaseexp.next()) {
			
				PurchaseExpensesVO purchaseExpensesVO = new PurchaseExpensesVO();
					   
				purchaseExpensesVO.setPurchaseexp_sno(rs_purchaseexp.getInt("sno"));
				purchaseExpensesVO.setPurchaseexp_date(HelperClass.convertDatabaseToUI(rs_purchaseexp.getString("MP_DATE")));
				purchaseExpensesVO.setPurchaseexp_billno(rs_purchaseexp.getString("Bill_No"));
				purchaseExpensesVO.setPurchaseexp_particulars(rs_purchaseexp.getString("Particulars"));
				purchaseExpensesVO.setPurchaseexp_amount(rs_purchaseexp.getDouble("AMOUNT"));
				purchaseExpensesVO.setPurchase_expensecode(expensecode);
			     
				purchaseexpenses.add(purchaseExpensesVO);
		}

		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try{
			if(rs_purchaseexp!=null  && !(rs_purchaseexp.isClosed())){
				rs_purchaseexp.close();
			}
			if(ps_purchaseexp!=null  && !(ps_purchaseexp.isClosed())){
				ps_purchaseexp.close();
		     }
			if(connection!=null  && !(connection.isClosed())){
				connection.close();
				
			}
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getPurchaseExpenses Ending");
		
		return purchaseexpenses;
	}


	public ArrayList<OtherWorkExpensesVo> getOtherWorkExpenses(
			String expensecode) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getOtherWorkExpenses Starting");
		PreparedStatement ps_otherworkexp = null;
		Connection connection = null;
		ResultSet rs_otherworkexp = null;
		ArrayList<OtherWorkExpensesVo> otherworkexpenses=new ArrayList<OtherWorkExpensesVo>();
		try {
			connection = getConnection();
			ps_otherworkexp = connection.prepareStatement(Employee.GET_OTHERWORK_EXPENSES);
			ps_otherworkexp.setString(1, expensecode);
		
			rs_otherworkexp = ps_otherworkexp.executeQuery();
		
			while (rs_otherworkexp.next()) {
			
				OtherWorkExpensesVo otherWorkExpensesVo = new OtherWorkExpensesVo();
					   
				otherWorkExpensesVo.setSno(rs_otherworkexp.getInt("sno"));
				otherWorkExpensesVo.setDate(HelperClass.convertDatabaseToUI(rs_otherworkexp.getString("MO_DATE")));
				otherWorkExpensesVo.setDescription(rs_otherworkexp.getString("Description"));
				otherWorkExpensesVo.setAmount(rs_otherworkexp.getDouble("AMOUNT"));
				otherWorkExpensesVo.setOther_expensecode(expensecode);
			     
				otherworkexpenses.add(otherWorkExpensesVo);
		}

		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try{
			if(rs_otherworkexp!=null  && !(rs_otherworkexp.isClosed())){
				rs_otherworkexp.close();
			}
			if(ps_otherworkexp!=null  && !(ps_otherworkexp.isClosed())){
				ps_otherworkexp.close();
		     }
			if(connection!=null  && !(connection.isClosed())){
				connection.close();
				
			}
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getOtherWorkExpenses Ending");
		
		return otherworkexpenses;
	}


	public ArrayList<MiscellaneousExpensesVo> getMiscellaneousExpenses(
			String expensecode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getMiscellaneousExpenses Starting");
	
		PreparedStatement ps_miscellaneousexp = null;
		Connection connection = null;
		ResultSet rs_miscellaneousexp = null;
		ArrayList<MiscellaneousExpensesVo> miscellaneousexpenses=new ArrayList<MiscellaneousExpensesVo>();
		try {
			connection = getConnection();
			ps_miscellaneousexp = connection.prepareStatement(Employee.GET_MISCELLANEOUS_EXPENSES);
			ps_miscellaneousexp.setString(1, expensecode);
		
			rs_miscellaneousexp = ps_miscellaneousexp.executeQuery();
		
			while (rs_miscellaneousexp.next()) {
			
				MiscellaneousExpensesVo miscellaneousExpensesVo = new MiscellaneousExpensesVo();
					   
				miscellaneousExpensesVo.setSno(rs_miscellaneousexp.getInt("sno"));
				miscellaneousExpensesVo.setDate(HelperClass.convertDatabaseToUI(rs_miscellaneousexp.getString("MM_DATE")));
				miscellaneousExpensesVo.setDescription(rs_miscellaneousexp.getString("Description"));
				miscellaneousExpensesVo.setAmount(rs_miscellaneousexp.getDouble("AMOUNT"));
				miscellaneousExpensesVo.setMiscellaneous_expensecode(expensecode);
			     
				miscellaneousexpenses.add(miscellaneousExpensesVo);
		}

		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try{
			if(rs_miscellaneousexp!=null  && !(rs_miscellaneousexp.isClosed())){
				rs_miscellaneousexp.close();
			}
			if(ps_miscellaneousexp!=null  && !(ps_miscellaneousexp.isClosed())){
				ps_miscellaneousexp.close();
		     }
			if(connection!=null  && !(connection.isClosed())){
				connection.close();
				
			}
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getMiscellaneousExpenses Ending");
		
		return miscellaneousexpenses;
	}


	public MonthlyExpenseDisplayVO getMonthlyExpenses(String expensecode) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getMiscellaneousExpenses Starting");
	
		PreparedStatement ps_miscellaneousexp = null;
		Connection connection = null;
		ResultSet rs_miscellaneousexp = null;
		MonthlyExpenseDisplayVO monthlyexpensevo=new MonthlyExpenseDisplayVO();
		try {
			connection = getConnection();
			ps_miscellaneousexp = connection.prepareStatement(Employee.GET_MONTHLY_EXPENSES);
			ps_miscellaneousexp.setString(1, expensecode);
		
			rs_miscellaneousexp = ps_miscellaneousexp.executeQuery();
		
			while (rs_miscellaneousexp.next()) {
			
				monthlyexpensevo.setLocalconveyance(rs_miscellaneousexp.getDouble("Local_conveyance"));
				monthlyexpensevo.setTravelexpenses(rs_miscellaneousexp.getDouble("Travel_expenses"));
				monthlyexpensevo.setStaffexpenses(rs_miscellaneousexp.getDouble("Staff_welfare"));
				monthlyexpensevo.setTelephoneexpense(rs_miscellaneousexp.getDouble("Telephone_expenses"));
				monthlyexpensevo.setPurchaseexpense(rs_miscellaneousexp.getDouble("Purchases"));
				monthlyexpensevo.setOtherworkexpenses(rs_miscellaneousexp.getDouble("other_work_expenses"));
				monthlyexpensevo.setMiscellaneousexpenses(rs_miscellaneousexp.getDouble("Miscellaneous"));
				monthlyexpensevo.setTotalamount(rs_miscellaneousexp.getDouble("Total_amount_claimed"));
		}

		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try{
			if(rs_miscellaneousexp!=null  && !(rs_miscellaneousexp.isClosed())){
				rs_miscellaneousexp.close();
			}
			if(ps_miscellaneousexp!=null  && !(ps_miscellaneousexp.isClosed())){
				ps_miscellaneousexp.close();
		     }
			if(connection!=null  && !(connection.isClosed())){
				connection.close();
				
			}
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getMiscellaneousExpenses Ending");
		
		return monthlyexpensevo;
	}

	
	
	public  int checkExpenseCode(String id, Connection con) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkExpenseCode Starting");
	
		PreparedStatement ps_expenses = null;
		ResultSet rs_expenses  = null;
	    int count=0;
		try {
		
			ps_expenses = con.prepareStatement(Employee.GET_EXPENSECODE_COUNT);
			ps_expenses.setString(1, id);
		
			rs_expenses = ps_expenses.executeQuery();
		
			while (rs_expenses.next()) {
			
				count =rs_expenses.getInt(1);
			
		}

		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try{
			if(rs_expenses!=null  && !(rs_expenses.isClosed())){
				rs_expenses.close();
			}
			if(ps_expenses!=null  && !(ps_expenses.isClosed())){
				ps_expenses.close();
		     }
			
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		
         logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkExpenseCode Ending");
			
		return count;
	}

	public  int checkLocalExpense(String id, Connection con) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkLocalExpense Starting");
	
		PreparedStatement ps_localexpenses = null;
		ResultSet rs_localexpenses  = null;
	    int count=0;
		try {
			ps_localexpenses = con.prepareStatement(Employee.CHECK_LOCAL_EXPENSE);
			ps_localexpenses.setString(1, id);
			rs_localexpenses = ps_localexpenses.executeQuery();
			
			while (rs_localexpenses.next()) {
			count =rs_localexpenses.getInt(1);
		}
		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{			
			try{
			if(rs_localexpenses!=null  && !(rs_localexpenses.isClosed())){
				rs_localexpenses.close();
			}
			if(ps_localexpenses!=null  && !(ps_localexpenses.isClosed())){
				ps_localexpenses.close();
		     }
			
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
         logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkLocalExpense Ending");
		return count;
	}
	
	
	public int checkTravelExpense(String id, Connection con) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkTravelExpense Starting");
	
		PreparedStatement ps_travelexpenses = null;
		ResultSet rs_travelexpenses  = null;
	    int count=0;
		try {
			ps_travelexpenses = con.prepareStatement(Employee.CHECK_TRAVEL_EXPENSE);
			ps_travelexpenses.setString(1, id);
			rs_travelexpenses = ps_travelexpenses.executeQuery();
			while (rs_travelexpenses.next()) {
			count =rs_travelexpenses.getInt(1);
		}
		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{			
			try{
			if(rs_travelexpenses!=null  && !(rs_travelexpenses.isClosed())){
				rs_travelexpenses.close();
			}
			if(ps_travelexpenses!=null  && !(ps_travelexpenses.isClosed())){
				ps_travelexpenses.close();
		     }
			
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
         logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkTravelExpense Ending");
		return count;
	}
	
	public int checkStaffWelfare(String id, Connection con) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkStaffWelfare Starting");
		PreparedStatement ps_staffexpenses = null;
		ResultSet rs_staffexpenses  = null;
	    int count=0;
		try {
			ps_staffexpenses = con.prepareStatement(Employee.CHECK_STAFF_EXPENSE);
			ps_staffexpenses.setString(1, id);
			rs_staffexpenses = ps_staffexpenses.executeQuery();
			while (rs_staffexpenses.next()) {
			count =rs_staffexpenses.getInt(1);
		}
		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{			
			try{
			if(rs_staffexpenses!=null  && !(rs_staffexpenses.isClosed())){
				rs_staffexpenses.close();
			}
			if(ps_staffexpenses!=null  && !(ps_staffexpenses.isClosed())){
				ps_staffexpenses.close();
		     }
			
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
         logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkStaffWelfare Ending");
		return count;
	}



	public int checkTelephoneExpenses( String id,
			Connection con) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkTelephoneExpenses Starting");
		PreparedStatement ps_telephoneexpenses = null;
		ResultSet rs_telephoneexpenses  = null;
	    int count=0;
		try {
			ps_telephoneexpenses = con.prepareStatement(Employee.CHECK_TELEPHONE_EXPENSE);
			ps_telephoneexpenses.setString(1, id);
			rs_telephoneexpenses = ps_telephoneexpenses.executeQuery();
			while (rs_telephoneexpenses.next()) {
			count =rs_telephoneexpenses.getInt(1);
		}
		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{			
			try{
			if(rs_telephoneexpenses!=null  && !(rs_telephoneexpenses.isClosed())){
				rs_telephoneexpenses.close();
			}
			if(ps_telephoneexpenses!=null  && !(ps_telephoneexpenses.isClosed())){
				ps_telephoneexpenses.close();
		     }
			
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
         logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkTelephoneExpenses Ending");
		return count;
	}

	
	public int checkPurchaseExpense(String id,
			Connection con) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkPurchaseExpense Starting");
		PreparedStatement ps_purchaseexpenses = null;
		ResultSet rs_purchaseexpenses  = null;
	    int count=0;
		try {
			ps_purchaseexpenses = con.prepareStatement(Employee.CHECK_PURCHASE_EXPENSE);
			ps_purchaseexpenses.setString(1, id);
			rs_purchaseexpenses = ps_purchaseexpenses.executeQuery();
			while (rs_purchaseexpenses.next()) {
			count =rs_purchaseexpenses.getInt(1);
		}
		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{			
			try{
			if(rs_purchaseexpenses!=null  && !(rs_purchaseexpenses.isClosed())){
				rs_purchaseexpenses.close();
			}
			if(ps_purchaseexpenses!=null  && !(ps_purchaseexpenses.isClosed())){
				ps_purchaseexpenses.close();
		     }
			
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
         logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkPurchaseExpense Ending");
		return count;
	}


	public int checkOtherExpense( String id, Connection con) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkOtherExpense Starting");
		PreparedStatement ps_otherexpenses = null;
		ResultSet rs_otherexpenses  = null;
	    int count=0;
		try {
			ps_otherexpenses = con.prepareStatement(Employee.CHECK_OTHER_EXPENSE);
			ps_otherexpenses.setString(1, id);
			rs_otherexpenses = ps_otherexpenses.executeQuery();
			while (rs_otherexpenses.next()) {
			count =rs_otherexpenses.getInt(1);
		}
		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{			
			try{
			if(rs_otherexpenses!=null  && !(rs_otherexpenses.isClosed())){
				rs_otherexpenses.close();
			}
			if(ps_otherexpenses!=null  && !(ps_otherexpenses.isClosed())){
				ps_otherexpenses.close();
		     }
			
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
         logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkOtherExpense Ending");
		return count;
	}

	
	private int checkMiscellaneousExpense(String id,
			Connection con) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkMiscellaneousExpense Starting");
		PreparedStatement ps_miscellaneousexpenses = null;
		ResultSet rs_miscellaneousexpenses  = null;
	    int count=0;
		try {
			ps_miscellaneousexpenses = con.prepareStatement(Employee.CHECK_MISCELLANEOUS_EXPENSE);
	    	ps_miscellaneousexpenses.setString(1, id);
			rs_miscellaneousexpenses = ps_miscellaneousexpenses.executeQuery();
			while (rs_miscellaneousexpenses.next()) {
			count =rs_miscellaneousexpenses.getInt(1);
		}
		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{			
			try{
			if(rs_miscellaneousexpenses!=null  && !(rs_miscellaneousexpenses.isClosed())){
				rs_miscellaneousexpenses.close();
			}
			if(ps_miscellaneousexpenses!=null  && !(ps_miscellaneousexpenses.isClosed())){
				ps_miscellaneousexpenses.close();
		     }
			
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
         logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : checkMiscellaneousExpense Ending");
		return count;
	}


	public Map<String, String> getManagerDireDetails(String empId) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getManagerDireDetails Starting");
		PreparedStatement ps_managerdirector= null;
		Connection connection = null;
		ResultSet rs_managerdirector = null;
		String managerCode=null;

		Map<String,String> managerdirectormap =new HashMap<String, String>();
		try {
			connection = getConnection();
				
			ps_managerdirector = connection.prepareStatement(Employee.GET_MANAGER_CODE);
			ps_managerdirector.setString(1, empId);
			rs_managerdirector = ps_managerdirector.executeQuery();
       		while (rs_managerdirector.next()) {
					managerCode = rs_managerdirector.getString("ManagerCode");	
				   managerdirectormap.put("MangCode", managerCode);
		   }
			
			if(rs_managerdirector!=null  && !(rs_managerdirector.isClosed())){
				rs_managerdirector.close();
			}
			if(ps_managerdirector!=null  && !(ps_managerdirector.isClosed())){
				ps_managerdirector.close();
		     }
		
		if(managerCode!=null){			
		
			ps_managerdirector = connection.prepareStatement(Employee.GET_DIRECTOR_DETAILS);
			ps_managerdirector.setString(1, managerCode);
		
			rs_managerdirector = ps_managerdirector.executeQuery();
			while (rs_managerdirector.next()) {
			
				managerdirectormap.put("DireCode", rs_managerdirector.getString("DirectorCode"));
				managerdirectormap.put("DireName", rs_managerdirector.getString("First_Name"));
			
			}
			
			}

		} catch (SQLException se) {
			logger.error(se.getMessage(), se);
			se.printStackTrace();
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}finally{
			
			try{
			if(rs_managerdirector!=null  && !(rs_managerdirector.isClosed())){
				rs_managerdirector.close();
			}
			if(ps_managerdirector!=null  && !(ps_managerdirector.isClosed())){
				ps_managerdirector.close();
		     }
			if(connection!=null  && !(connection.isClosed())){
				connection.close();
				
			}
		} catch (SQLException se) {
				logger.error(se.getMessage(), se);
				se.printStackTrace();
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
				e.printStackTrace();
			}
		}
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getManagerDireDetails Ending");
		
			
		return managerdirectormap;
	}
	
	private Map<String, String> geDirectorDetails(String emp_mangCode,
			Connection con) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : geDirectorDetails Starting");
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,String> direMap= new HashMap<String, String>();
		try {
						
			ps = con.prepareStatement(Manager.GET_DIRECTOR_DETAILS);
			ps.setString(1, emp_mangCode);
			
			rs = ps.executeQuery();

			while(rs.next()){
				
				direMap.put("direName", rs.getString("First_Name").trim());
				direMap.put("direEmail", rs.getString("Official_Email_ID").trim());
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
				+ " Control in EmployeeExpenseDetailsDaoImpl : geDirectorDetails Ending");
		return direMap;
	}
}

