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
import com.centris.DAO.ManagerExpenseDetailsDao;
import com.centris.VO.ManagerExpenseDetailsVo;
import com.centris.form.ManagerExpenseDetailsForm;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.ApproveTravelBookingSqlUtil;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.SQLUtils.Manager;
import com.centris.util.constants.MessageConstants;

public class ManagerExpenseDetailsDaoImpl extends DBService implements
		ManagerExpenseDetailsDao {
	private static Logger logger = Logger
			.getLogger(ManagerExpenseDetailsDaoImpl.class);

	@Override
	public ArrayList<ManagerExpenseDetailsVo> getexpenseDetails(
			ManagerExpenseDetailsForm formObj,String userType) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : getexpenseDetails Starting");

		ArrayList<ManagerExpenseDetailsVo> expenseDetails = new ArrayList<ManagerExpenseDetailsVo>();

		PreparedStatement pstmt = null;
		ResultSet rst = null;
		
		PreparedStatement pstmt1 = null;
		ResultSet rst1 = null;
		
		Connection con = null;
		int slno = 1;
		try {
			con = getConnection();
			
		if(userType.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)){
				
			pstmt = con.prepareStatement(Manager.EMPLOYEE_EXPENSE_DETAILS_CONSOLIDATED);
			pstmt.setInt(1, Integer.parseInt(formObj.getYear()));
			pstmt.setInt(2, Integer.parseInt(formObj.getMonth()));
			pstmt.setString(3, formObj.getManager());
			
			rst = pstmt.executeQuery();
			
			while (rst.next()) {
				ManagerExpenseDetailsVo obj = new ManagerExpenseDetailsVo();
				obj.setEmp_slno(String.valueOf(slno));
				obj.setEmp_Id(rst.getString("EMPID"));
				obj.setEmp_Name(rst.getString("First_Name"));
				obj.setEmp_mangCode(rst.getString("ManagerCode"));
				obj.setEmp_designation(rst.getString("designationName"));
				obj.setEmp_contact(rst.getString("Mobile_Number"));
				obj.setEmp_local(rst.getString("Local_conveyance"));
				obj.setEmp_travel(rst.getString("Travel_expenses"));
				obj.setEmp_telephone(rst.getString("Telephone_expenses"));
				obj.setEmp_staff(rst.getString("Staff_welfare"));
				obj.setEmp_purchase(rst.getString("Purchases"));
				obj.setEmp_other(rst.getString("other_work_expenses"));
				obj.setEmp_miscellaneous(rst.getString("Miscellaneous"));
				obj.setEmp_total(rst.getString("Total_amount_claimed"));
				obj.setEmp_expCode(rst.getString("MEXP_CODE"));
				obj.setBioid(rst.getString("bioid"));
				obj.setEmp_advpaid("-");
				obj.setEmp_balance("-");
				
				expenseDetails.add(obj);
				slno++;
			}
			}else if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				
				pstmt = con.prepareStatement(Manager.EMPLOYEE_EXPENSE_DETAILS_CONSOLIDATED_IN_DIRECTOR);
				pstmt.setInt(1, Integer.parseInt(formObj.getYear()));
				pstmt.setInt(2, Integer.parseInt(formObj.getMonth()));
				pstmt.setString(3, formObj.getManager());
				rst = pstmt.executeQuery();
				while (rst.next()) {
					ManagerExpenseDetailsVo obj = new ManagerExpenseDetailsVo();
					obj.setEmp_slno(String.valueOf(slno));
					obj.setEmp_Id(rst.getString("EMPID"));
					obj.setEmp_Name(rst.getString("First_Name"));
					obj.setEmp_mangCode(rst.getString("ManagerCode"));
					obj.setEmp_mangName(rst.getString("ManagerName"));
					obj.setEmp_expCode(rst.getString("MEXP_CODE"));
					obj.setEmp_designation(rst.getString("designationName"));
					obj.setEmp_contact(rst.getString("Mobile_Number"));
					obj.setEmp_local(rst.getString("Local_conveyance"));
					obj.setEmp_travel(rst.getString("Travel_expenses"));
					obj.setEmp_telephone(rst.getString("Telephone_expenses"));
					obj.setEmp_staff(rst.getString("Staff_welfare"));
					obj.setEmp_purchase(rst.getString("Purchases"));
					obj.setEmp_other(rst.getString("other_work_expenses"));
					obj.setEmp_miscellaneous(rst.getString("Miscellaneous"));
					obj.setEmp_total(rst.getString("Total_amount_claimed"));
					obj.setEmp_totapproved(rst.getString("Approved_Amt"));
					obj.setEmp_advpaid(rst.getString("AdvancePaid"));
					obj.setEmp_balance(rst.getString("balance"));
					obj.setBioid(rst.getString("bioid"));
					expenseDetails.add(obj);
					slno++;
				}
				
				
			}else{
				
				pstmt = con.prepareStatement(Manager.EMPLOYEE_EXPENSE_DETAILS_CONSOLIDATED_IN_ACCOUNT);
				pstmt.setInt(1, Integer.parseInt(formObj.getYear()));
				pstmt.setInt(2, Integer.parseInt(formObj.getMonth()));
				
				rst = pstmt.executeQuery();
				while (rst.next()) {
					ManagerExpenseDetailsVo obj = new ManagerExpenseDetailsVo();
					obj.setEmp_slno(String.valueOf(slno));
					obj.setEmp_Id(rst.getString("EMPID"));
					obj.setEmp_Name(rst.getString("First_Name"));
					obj.setEmp_mangCode(rst.getString("ManagerCode"));
					obj.setEmp_mangName(rst.getString("ManagerName"));
					obj.setEmp_expCode(rst.getString("MEXP_CODE"));
					obj.setEmp_designation(rst.getString("designationName"));
					obj.setEmp_contact(rst.getString("Mobile_Number"));
					obj.setEmp_local(rst.getString("Local_conveyance"));
					obj.setEmp_travel(rst.getString("Travel_expenses"));
					obj.setEmp_telephone(rst.getString("Telephone_expenses"));
					obj.setEmp_staff(rst.getString("Staff_welfare"));
					obj.setEmp_purchase(rst.getString("Purchases"));
					obj.setEmp_other(rst.getString("other_work_expenses"));
					obj.setEmp_miscellaneous(rst.getString("Miscellaneous"));
					obj.setEmp_total(rst.getString("Total_amount_claimed"));
					obj.setEmp_totapproved(rst.getString("Approved_Amt"));
					obj.setEmp_advpaid(rst.getString("AdvancePaid"));
					obj.setEmp_balance(rst.getString("balance"));
					obj.setDirectorCode(rst.getString("DirectorCode"));
					obj.setBioid(rst.getString("bioid"));
					
					pstmt1 = con.prepareStatement(Manager.GET_DIRECTOR);
					pstmt1.setString(1, rst.getString("DirectorCode"));
					
					rst1 = pstmt1.executeQuery();
					
					while(rst1.next()){
						
						obj.setDirectorName(rst1.getString("First_Name"));
					}
					
					expenseDetails.add(obj);
					slno++;
				}
				
				
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : getexpenseDetails Ending");
		return expenseDetails;
	}

	
	@Override
	public String approveExpenseDetails(ManagerExpenseDetailsVo vo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : approveExpenseDetails Starting");
		String result = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Connection con = null;
		int statusCount = 0;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			String cr_time = null;
			pstmt = con.prepareStatement(Manager.GET_ALLOWANCE_CREATED_TIME);
			
			pstmt.setString(1, vo.getEmp_year().trim());
			pstmt.setString(2, vo.getEmp_month().trim());
			pstmt.setString(3, vo.getEmp_mangCode().trim());
			pstmt.setString(4, vo.getEmp_Id().trim());
			
			rst = pstmt.executeQuery();
			while (rst.next()) {
				cr_time = rst.getString("createtime");
			}
	
			String empId=getEmplId(vo.getEmp_Id());
			
			vo.setBioid(empId);
			
			if(vo.getUser_Type().equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)){
				
			pstmt = con.prepareStatement(Manager.UPDATE_EMPLOYEE_ALLOWANCE_BYMANAGER);
			
			pstmt.setString(1, vo.getEmp_totapproved().trim());
			pstmt.setString(2, vo.getEmp_advpaid().trim());
			pstmt.setString(3, vo.getEmp_balance().trim());

			pstmt.setString(4, "Y");
			pstmt.setString(5, HelperClass.getCurrentSqlDate().toString());
			pstmt.setString(6, cr_time);
			pstmt.setString(7, vo.getEmp_year().trim());

			pstmt.setString(8, vo.getEmp_month().trim());
			pstmt.setString(9, vo.getEmp_mangCode().trim());
			pstmt.setString(10, empId);
			
			}else if(vo.getUser_Type().equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				

				
				pstmt = con
						.prepareStatement(Manager.UPDATE_EMPLOYEE_ALLOWANCE_BY_DIRECTOR);

				pstmt.setString(1, vo.getEmp_totapproved().trim());
				pstmt.setString(2, vo.getEmp_balance().trim());
				
				pstmt.setString(3, "Y");
				pstmt.setString(4, HelperClass.getCurrentSqlDate().toString());
				pstmt.setString(5, cr_time);
				pstmt.setString(6, vo.getEmp_year().trim());
				pstmt.setString(7, vo.getEmp_month().trim());
				pstmt.setString(8, vo.getEmp_mangCode().trim());
				pstmt.setString(9, empId);
				
			}else{
				
				
				pstmt = con
						.prepareStatement(Manager.UPDATE_EMPLOYEE_ALLOWANCE_BY_ADMIN);

				pstmt.setString(1, vo.getEmp_totapproved().trim());
				pstmt.setString(2, vo.getEmp_balance().trim());
				
				pstmt.setString(3,vo.getAcc_code());
				pstmt.setString(4, "Y");
				pstmt.setString(5, HelperClass.getCurrentSqlDate().toString());
				pstmt.setString(6, cr_time);
				pstmt.setString(7, vo.getEmp_year().trim());

				pstmt.setString(8, vo.getEmp_month().trim());
				pstmt.setString(9, vo.getEmp_mangCode().trim());
				pstmt.setString(10, empId);
				
			}

			
			statusCount = pstmt.executeUpdate();
			con.commit();
			if (statusCount > 0) {
				
				result = "success";
				if(LoginDetails.MANAGER_ID_TYPE.equals(vo.getUser_Type())){
					
					String status=sendExpenseApprovedByMangEmailToDirectorandEmp(vo,con,"Approve",empId);
					
					if(status=="false"){
						
            					result = MessageConstants.MAIL_NOT_SENT;
					}
					
			    }
				
				
				if(LoginDetails.DIRECTOR_ID_TYPE.equals(vo.getUser_Type())){
					
                     String status=sendExpenseApprovedByDireEmailToAccountEmp(vo,con,empId,"Approve");
					
					if(status=="false"){
						
            					result = MessageConstants.MAIL_NOT_SENT;
					}
					
					
					
				}
				
				
				if(LoginDetails.ADMIN_ID_TYPE.equals(vo.getUser_Type())){
					
					  String status=sendExpenseApprovedByAdminEmailToDirectorMgrEmp(vo,con,empId,"Approve");
					
					  if(status=="false"){
						
    					result = MessageConstants.MAIL_NOT_SENT;
			
					}
					
				}
				
				
				
				
			}

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			}
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : approveExpenseDetails Ending");

		return result;
	}
	
	
	public String sendExpenseApprovedByAdminEmailToDirectorMgrEmp(ManagerExpenseDetailsVo vo, Connection con,String empId,String approveStatus) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : sendExpenseApprovedByAdminEmailToDirector  Starting");
		
            String status=null;
		
		try{
			Map<String,String> adminmap=geAdminDetails(vo.getAcc_code(),con);
			Map<String,String> diremap=geDirectorDetails(vo.getEmp_mangCode(),con);
			Map<String,String> empmap= new EmployeeExpenseDetailsDaoImpl().geEmpDetails(empId,con);
			Map<String,String> managerMap=geManagerDetails(vo.getEmp_mangCode(), con);
			String url = new  EmployeeDAOImpl().getServerUrlFromBD(con);
			
			String directorStatus=null;
			String managerStatus=null;
			String employeeStatus=null;
		
			EmailContent em = new EmailContent();
			
			String adminName=adminmap.get("adminName");
			
			String direName=diremap.get("direName");
			String direEmailid=diremap.get("direEmail");
			
			String empName=empmap.get("EmpFirstName");
			String empMailId=empmap.get("EmpemailId");
			
			String managername=managerMap.get("FirstName");
			String managerMail=managerMap.get("email");
		
			String monthName=HelperClass.getMonthName(vo.getEmp_month());
			String year=vo.getEmp_year();
			
			String[] mail={direEmailid};
				
				em.setMailids(mail);
				em.setSubject("Employee Expenses");
				
				if(approveStatus.equalsIgnoreCase("Approve")){
				em.setMessage("Dear "+direName+", \n"
						+ "Greetings from TeleIndia. \n\n"
						+ "Accountant "+adminName+" Approved Employee "+empName+" Expenses month of "+monthName+" - "+year+ "\n\n"
						+ "For more Details Login URL : " + url + "\n"
						+ "Verify the  Expenses Report \n\n"
						+ "Have a nice day \n\n"
						+ "E-ATTENDANCE PRO  \n"
						+ "-------------------------------------------------------------- \n"
						+ "This is system generated mail,Please do not reply");
				}else{
					
					em.setMessage("Dear "+direName+", \n"
							+ "Greetings from TeleIndia. \n\n"
							+ "Accountant "+adminName+" Rejected Employee "+empName+" Expenses month of "+monthName+" - "+year+ "\n\n"
							+ "For more Details Login URL : " + url + "\n"
							+ "Verify the  Expenses Report \n\n"
							+ "Have a nice day \n\n"
							+ "E-ATTENDANCE PRO  \n"
							+ "-------------------------------------------------------------- \n"
							+ "This is system generated mail,Please do not reply");
					
				}
													
				directorStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
				
				String[] managerMails={managerMail};
				
				em.setMailids(managerMails);
				em.setSubject("Employee Expenses");
				
				if(approveStatus.equalsIgnoreCase("Approve")){
				em.setMessage("Dear "+managername+", \n"
						+ "Greetings from TeleIndia. \n\n"
						+ "Accountant "+adminName+" Approved Employee "+empName+" Expenses month of "+monthName+" - "+year+ "\n\n"
						+ "For more Details Login URL : " + url + "\n"
						+ "Verify the  Expenses Report \n\n"
						+ "Have a nice day \n\n"
						+ "E-ATTENDANCE PRO  \n"
						+ "-------------------------------------------------------------- \n"
						+ "This is system generated mail,Please do not reply");
				}else{
					
					em.setMessage("Dear "+managername+", \n"
							+ "Greetings from TeleIndia. \n\n"
							+ "Accountant "+adminName+" Rejected Employee "+empName+" Expenses month of "+monthName+" - "+year+ "\n\n"
							+ "For more Details Login URL : " + url + "\n"
							+ "Verify the  Expenses Report \n\n"
							+ "Have a nice day \n\n"
							+ "E-ATTENDANCE PRO  \n"
							+ "-------------------------------------------------------------- \n"
							+ "This is system generated mail,Please do not reply");
					
					
				}
													
				managerStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
				
				
				String[] empMails={empMailId};
				
				em.setMailids(empMails);
				em.setSubject("Employee Expenses");
				
				em.setMessage("Dear "+empName+", \n"
						+ "Greetings from TeleIndia. \n\n"
						+ "Accountant "+adminName+" Approved your Expenses month of "+monthName+" - "+year+ "\n\n"
						+ "For more Details Login URL : " + url + "\n"
						+ "Verify the  Expenses Report \n\n"
						+ "Have a nice day \n\n"
						+ "E-ATTENDANCE PRO  \n"
						+ "-------------------------------------------------------------- \n"
						+ "This is system generated mail,Please do not reply");
													
				employeeStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
				
				
				if(employeeStatus.equalsIgnoreCase("false") || managerStatus.equalsIgnoreCase("false") || directorStatus.equalsIgnoreCase("false")){
					
					status="false";
				}else{
					
					status="true";
				}
			
		}
		catch(Exception e){
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : sendExpenseApprovedByAdminEmailToDirector Ending");
	
		return status;
  }

	
	public String sendExpenseApprovedByDireEmailToAccountEmp(ManagerExpenseDetailsVo vo,
			Connection con,String empId,String approveStatus) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : sendExpenseApprovedByDireEmailToAccountEmp  Starting");
		
            String status=null;
            String empstatus=null;
            String accountStatus=null;
		
		try{
			
			
			Map<String,String> diremap=geDirectorDetails(vo.getEmp_mangCode(),con);
			Map<String,String> empmap= new EmployeeExpenseDetailsDaoImpl().geEmpDetails(empId,con);
			
			
			String url = new  EmployeeDAOImpl().getServerUrlFromBD(con);
		
			EmailContent em = new EmailContent();
			
			String direName=diremap.get("direName");
			String empName=empmap.get("EmpFirstName");
			String empMailId=empmap.get("EmpemailId");
			String monthName=HelperClass.getMonthName(vo.getEmp_month());
			String year=vo.getEmp_year();
			
			
			String[] mail={empMailId};
			
				em.setMailids(mail);
				em.setSubject("Employee Expenses");
				
				if(approveStatus.equalsIgnoreCase("Approve")){
				em.setMessage("Dear "+empName+", \n"
						+ "Greetings from TeleIndia. \n\n"
						+ "Director "+direName+" Approved your Expenses month of "+monthName+" - "+year+ "\n\n"
						+ "For more Details Login URL : " + url + "\n"
						+ "Have a nice day \n\n"
						+ "E-ATTENDANCE PRO  \n"
						+ "-------------------------------------------------------------- \n"
						+ "This is system generated mail,Please do not reply");
				}else{
					em.setMessage("Dear "+empName+", \n"
							+ "Greetings from TeleIndia. \n\n"
							+ "Director "+direName+" Rejected your Expenses month of "+monthName+" - "+year+ "\n\n"
							+ "For more Details Login URL : " + url + "\n"
							+ "Have a nice day \n\n"
							+ "E-ATTENDANCE PRO  \n"
							+ "-------------------------------------------------------------- \n"
							+ "This is system generated mail,Please do not reply");
					
				}
				empstatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
				
				ArrayList<String> mailList=geAdminMailDetails();
				
				String[] empmail =new String[mailList.size()];
				
				for(int i=0;i<mailList.size();i++){
					
					if(mailList.get(i)!=null){
						
					if(!(mailList.get(i).equalsIgnoreCase(empMailId))){
					
						empmail[i]=mailList.get(i);
					}
					
					}
				}
				
				
					em.setMailids(empmail);
					em.setSubject("Employee Expenses");
					if(approveStatus.equalsIgnoreCase("Approve")){
					em.setMessage("Greetings from TeleIndia. \n\n"
							+ "Director "+direName+" Approved Expenses month of "+monthName+" - "+year+  "\n\n"
							+ "For more Details Login URL : " + url + "\n"
							+ "Approve the  Expenses \n\n"
							+ "Have a nice day \n\n"
							+ "E-ATTENDANCE PRO  \n"
							+ "-------------------------------------------------------------- \n"
							+ "This is system generated mail,Please do not reply");
					}else{
						
						em.setMessage("Greetings from TeleIndia. \n\n"
								+ "Director "+direName+" Rejected Expenses month of "+monthName+" - "+year+  "\n\n"
								+ "For more Details Login URL : " + url + "\n"
								+ "Approve the  Expenses \n\n"
								+ "Have a nice day \n\n"
								+ "E-ATTENDANCE PRO  \n"
								+ "-------------------------------------------------------------- \n"
								+ "This is system generated mail,Please do not reply");
					}
														
					accountStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
					
					if(accountStatus.equalsIgnoreCase("false") ||  empstatus.equalsIgnoreCase("false")){
						
						status ="false";
					}else{
						
						status= "true";
					}
				
			
			
		}
		catch(Exception e){
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : sendExpenseApprovedByDireEmailToAccountEmp Ending");
	return status;
	}

	
	public  String sendExpenseApprovedByMangEmailToDirectorandEmp(ManagerExpenseDetailsVo vo, Connection con,String approvestatus,String empId) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : sendExpenseApprovedByMangEmailToDirectorandEmp Starting");
		
        String direstatus=null;
        String empstatus=null;
        String status=null;
		
		try{
			Map<String,String> managermap=geManagerDetails(vo.getEmp_mangCode(),con);
			Map<String,String> diremap=geDirectorDetails(vo.getEmp_mangCode(),con);
			Map<String,String> empmap= new EmployeeExpenseDetailsDaoImpl().geEmpDetails(empId,con);
			
			
			String url = new  EmployeeDAOImpl().getServerUrlFromBD(con);
		
			EmailContent em = new EmailContent();
			
			String mangName=managermap.get("FirstName");
			String direName=diremap.get("direName");
			String direEmailid=diremap.get("direEmail");
			String empName=empmap.get("EmpFirstName");
			String empEmailId=empmap.get("EmpemailId");
			String approvedamount=vo.getEmp_totapproved();
			String monthName=HelperClass.getMonthName(vo.getEmp_month());
			String year=vo.getEmp_year();
			
			
			String[] diremail={direEmailid};
				
				em.setMailids(diremail);
				em.setSubject("Employee Expenses");
				
				if(approvestatus.equalsIgnoreCase("Approve")){
				em.setMessage("Dear "+direName+", \n"
						+ "Greetings from TeleIndia. \n\n"
						+ "Manager "+mangName+" Approved Employee "+empName+" Expenses month of "+monthName+" - "+year+ "\n\n"
						+ "For more Details Login URL : " + url + "\n"
						+ "Approve the  Expenses \n\n"
						+ "Have a nice day \n\n"
						+ "E-ATTENDANCE PRO  \n"
						+ "-------------------------------------------------------------- \n"
						+ "This is system generated mail,Please do not reply");
				}else{
					
					em.setMessage("Dear "+direName+", \n"
							+ "Greetings from TeleIndia. \n\n"
							+ "Manager "+mangName+" Rejected Employee "+empName+" Expenses month of "+monthName+" - "+year+ "\n\n"
							+ "For more Details Login URL : " + url + "\n"
							+ "Have a nice day \n\n"
							+ "E-ATTENDANCE PRO  \n"
							+ "-------------------------------------------------------------- \n"
							+ "This is system generated mail,Please do not reply");
					
				}
				
				direstatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
				
				
				
			if(!(empEmailId.equalsIgnoreCase(direEmailid))){
				
				
	           String[] empmail={empEmailId};
				
				em.setMailids(empmail);
				em.setSubject("Employee Expenses");
				
				if(approvestatus.equalsIgnoreCase("Approve")){
				em.setMessage("Dear "+empName+", \n"
						+ "Greetings from TeleIndia. \n\n"
						+ "Manager "+mangName+" Approved Expenses month of "+monthName+" - "+year+ " with amount of " +approvedamount+ "\n\n"
						+ "For more Details Login URL : " + url + "\n"
						+ "Verify the Claims \n\n"
						+ "Have a nice day \n\n"
						+ "E-ATTENDANCE PRO  \n"
						+ "-------------------------------------------------------------- \n"
						+ "This is system generated mail,Please do not reply");
				}else{
					
					em.setMessage("Dear "+empName+", \n"
							+ "Greetings from TeleIndia. \n\n"
							+ "Manager "+mangName+" Rejected Expenses month of "+monthName+" - "+year+ " with amount of " +approvedamount+ "\n\n"
							+ "For more Details Login URL : " + url + "\n"
							+ "Verify the Claims \n\n"
							+ "Have a nice day \n\n"
							+ "E-ATTENDANCE PRO  \n"
							+ "-------------------------------------------------------------- \n"
							+ "This is system generated mail,Please do not reply");
				}
				empstatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
			}
				if(direstatus.equalsIgnoreCase("false")){
					
					status ="false";
				}else{
					
					status= "true";
				}
				
				
				
		}
		catch(Exception e){
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : sendExpenseApprovedByMangEmailToDirectorandEmp Ending");
	return status;
	}

	
	private Map<String, String> geDirectorDetails(String emp_mangCode,
			Connection con) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : geDirectorDetails Starting");
		
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
				+ " Control in ManagerExpenseDetailsDaoImpl : geDirectorDetails Ending");
		return direMap;
	}
	
	
    public Map<String, String> geManagerDetails(String employeeMangId, Connection con) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : geManagerDetails Starting");
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,String> managerMap= new HashMap<String, String>();
		try {
			
			ps = con.prepareStatement(Manager.GET_MANAGER);
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
				+ " Control in ManagerExpenseDetailsDaoImpl : geManagerDetails Ending");
		return managerMap;
	}
 
    
    public  Map<String, String> geAdminDetails(String acc_code, Connection con) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : geAdminDetails Starting");
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,String> adminMap= new HashMap<String, String>();
		try {
						
			ps = con.prepareStatement(Manager.GET_ADMIN_DETAILS);
			ps.setString(1, acc_code);
			
			rs = ps.executeQuery();

			while(rs.next()){
				
				adminMap.put("adminName", rs.getString("First_Name").trim());
				adminMap.put("adminEmail", rs.getString("Official_Email_ID").trim());
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
				+ " Control in ManagerExpenseDetailsDaoImpl : geAdminDetails Ending");
		return adminMap;
	}
    
    
    public ArrayList<String> geAdminMailDetails() {
    	

    	logger.setLevel(Level.DEBUG);
    	JLogger.log(0, JDate.getTimeString(new Date())
    			+ MessageConstants.START_POINT);
    	logger.info(JDate.getTimeString(new Date())
    			+ " Control in ManagerExpenseDetailsDaoImpl : geAdminMailDetails : Starting");

    	PreparedStatement approveTktPstmt = null;
    	Connection connection=null;
    	ResultSet rs=null;
    	ArrayList<String> mailId=new ArrayList<String>();
    	try {
    		
    		connection=getConnection();
    		approveTktPstmt = connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_ADMIN_MAIL_DETAILS);
    		
    		rs=approveTktPstmt.executeQuery();
    		
    		while(rs.next()){
    			
    			mailId.add(rs.getString("AccMailId"));
    			
    		}
    		
    	} catch (SQLException sqle) {

    		logger.error(sqle.getMessage(),sqle);
    		sqle.printStackTrace();

    	} catch (Exception e) {
    		logger.error(e.getMessage(),e);
    		e.printStackTrace();
    		
    	} finally {

    		try {
    			
    			
    			if(approveTktPstmt != null && (!approveTktPstmt.isClosed())){
    				
    				approveTktPstmt.close();
    			}
    			if(connection != null && (!connection.isClosed())){

    				connection.close();
    			}
    			
    		} catch (SQLException e) {

    			logger.error(e.getMessage(),e);
    		} catch (Exception e) {
    			logger.error(e.getMessage(),e);
    		}
    	}

    	JLogger.log(0, JDate.getTimeString(new Date())
    			+ MessageConstants.END_POINT);
    	logger.info(JDate.getTimeString(new Date())
    			+ " Control in ManagerExpenseDetailsDaoImpl : geAdminMailDetails : Ending");

    	
    	return mailId;
    	
}
    
    
    
	@Override
	public String approveAllExpenseDetailsDao(ManagerExpenseDetailsVo vo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : approveAllExpenseDetailsDao Starting");
		String result = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rst1 = null;
		
		Connection con = null;
		int statusCount = 0;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			
			String[] expenseCode=vo.getEmp_expCode().split(",");
			
			if(vo.getUser_Type().equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)){
				
				String[] tot_approved=vo.getEmp_totapproved().split(",");
				String[] advancePaid=vo.getEmp_advpaid().split(",");
				String[] balance=vo.getEmp_balance().split(",");
				
			pstmt = con.prepareStatement(Manager.APPROVE_ALL_EXPENSES_BY_MANAGER);
			
			for(int i=0;i<expenseCode.length;i++){
				
				
				String cr_time = null;
				pstmt1 = con.prepareStatement(Manager.GET_EXPENSE_CREATED_TIME);
				
				pstmt1.setString(1, expenseCode[i]);
			
				
				rst1 = pstmt1.executeQuery();
				while (rst1.next()) {
					cr_time = rst1.getString("createtime");
				}
		
				
			pstmt.setString(1, tot_approved[i]);
			pstmt.setString(2, advancePaid[i]);
			pstmt.setString(3, balance[i]);
			pstmt.setString(4, "Y");
			pstmt.setString(5, HelperClass.getCurrentSqlDate().toString());
			pstmt.setString(6, cr_time);
			pstmt.setString(7, expenseCode[i]);

			statusCount = pstmt.executeUpdate();
			
			}
			
			con.commit();
			
			if (statusCount > 0) {
				
				result = "true";
				
				String mailStatus=sendExpenseApprovedByMangEmailToDirectorandAllEmp(vo, con);
				
				if(mailStatus.equalsIgnoreCase("true")){
					
					result=MessageConstants.MAIL_SENT;
				}
				
			}
			
			}else if(vo.getUser_Type().equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				
				String[] tot_approved=vo.getEmp_totapproved().split(",");
				String[] balance=vo.getEmp_balance().split(",");

				
				pstmt = con
						.prepareStatement(Manager.APPROVE_ALL_EXPENSES_BY_DIRECTOR);
				
				for(int i=0;i<expenseCode.length;i++){
					
					String cr_time = null;
					pstmt1 = con.prepareStatement(Manager.GET_EXPENSE_CREATED_TIME);
					
					pstmt1.setString(1, expenseCode[i]);
				
					
					rst1 = pstmt1.executeQuery();
					while (rst1.next()) {
						cr_time = rst1.getString("createtime");
					}

				pstmt.setString(1, "Y");
				pstmt.setString(2, HelperClass.getCurrentSqlDate().toString());
				pstmt.setString(3, cr_time);
				pstmt.setString(4, tot_approved[i]);
				pstmt.setString(5, balance[i]);
				pstmt.setString(6, expenseCode[i]);

				statusCount = pstmt.executeUpdate();
				
				}
				con.commit();

				if (statusCount > 0) {
					
					result = "true";
					
					String mailStatus=sendExpenseApprovedByDireEmailToAccAllEmp(vo, con);
					
					if(mailStatus.equalsIgnoreCase("true")){
						
						result=MessageConstants.MAIL_SENT;
					}
					
				}
				
				
			}else{
				
				
				pstmt = con.prepareStatement(Manager.APPROVE_ALL_EXPENSES_BY_ADMIN);
				
				String[] tot_approved=vo.getEmp_totapproved().split(",");
				String[] balance=vo.getEmp_balance().split(",");


				for(int i=0;i<expenseCode.length;i++){
					
					String cr_time = null;
					pstmt1 = con.prepareStatement(Manager.GET_EXPENSE_CREATED_TIME);
					
					pstmt1.setString(1, expenseCode[i]);
				
					
					rst1 = pstmt1.executeQuery();
					while (rst1.next()) {
						cr_time = rst1.getString("createtime");
					}
					
				pstmt.setString(1,vo.getAcc_code());
				pstmt.setString(2, "Y");
				pstmt.setString(3, HelperClass.getCurrentSqlDate().toString());
				pstmt.setString(4, cr_time);
				pstmt.setString(5, tot_approved[i]);
				pstmt.setString(6, balance[i]);
				pstmt.setString(7, expenseCode[i]);
				
				statusCount = pstmt.executeUpdate();
				
				
				}
				
				con.commit();
				if (statusCount > 0) {
					
					result = "true";
					
					String mailStatus=sendExpenseApprovedByAccEmailToAll(vo, con);
					
					if(mailStatus.equalsIgnoreCase("true")){
						
						result=MessageConstants.MAIL_SENT;
					}
				
				}
				
				
			}

			

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			}
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : approveAllExpenseDetailsDao Ending");

		return result;
	}
	
	
    public  String sendExpenseApprovedByMangEmailToDirectorandAllEmp(ManagerExpenseDetailsVo vo, Connection con) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : sendExpenseApprovedByMangEmailToDirectorandAllEmp Starting");
		
        String direstatus=null;
        String empstatus=null;
        String status=null;
		
		try{
			
			Map<String,String> diremap=geDirectorDetails(vo.getUsercode(),con);
			
			String url = new  EmployeeDAOImpl().getServerUrlFromBD(con);
		
			EmailContent em = new EmailContent();
			
			String direName=diremap.get("direName");
			String direEmailid=diremap.get("direEmail");
			String monthName=HelperClass.getMonthName(vo.getEmp_month());
			String year=vo.getEmp_year();
			
			
			
			String[] diremail={direEmailid};
				
				em.setMailids(diremail);
				em.setSubject("Employee Expenses");
				
				em.setMessage("Dear "+direName+", \n"
						+ "Greetings from TeleIndia. \n\n"
						+ "Manager "+vo.getUsername()+" Approved Expenses month of "+monthName+" - "+year+ "\n\n"
						+ "For more Details Login URL : " + url + "\n"
						+ "Approve the  Expenses \n\n"
						+ "Have a nice day \n\n"
						+ "E-ATTENDANCE PRO  \n"
						+ "-------------------------------------------------------------- \n"
						+ "This is system generated mail,Please do not reply");
				
				direstatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
				
				ArrayList<String> mailList=getAllEmpDetails(vo.getEmp_expCode(),con);
				
				String[] empmail =new String[mailList.size()];
				
				for(int i=0;i<mailList.size();i++){
					
					if(!(direEmailid.equalsIgnoreCase(mailList.get(i)))){
					empmail[i]=mailList.get(i);
					}
				}
				
				em.setMailids(empmail);
				em.setSubject("Employee Expenses");
				
				em.setMessage("Greetings from TeleIndia. \n\n"
						+ "Manager "+vo.getUsername()+" Approved Expenses month of "+monthName+" - "+year+ " \n\n"
						+ "For more Details Login URL : " + url + "\n"
						+ "Verify the Claims \n\n"
						+ "Have a nice day \n\n"
						+ "E-ATTENDANCE PRO  \n"
						+ "-------------------------------------------------------------- \n"
						+ "This is system generated mail,Please do not reply");
													
				empstatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
				
				if(direstatus.equalsIgnoreCase("false")){
					
					status ="false";
				}else{
					
					status= "true";
				}
				
				
				
		}
		catch(Exception e){
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : sendExpenseApprovedByMangEmailToDirectorandAllEmp Ending");
	return status;
	}


    public String sendExpenseApprovedByDireEmailToAccAllEmp(ManagerExpenseDetailsVo vo,
			Connection con) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : sendExpenseApprovedByDireEmailToAccAllEmp  Starting");
		
            String status=null;
            String empstatus=null;
            String accountStatus=null;
		
		try{
			
			
			String url = new  EmployeeDAOImpl().getServerUrlFromBD(con);
		
			EmailContent em = new EmailContent();
			
			String monthName=HelperClass.getMonthName(vo.getEmp_month());
			String year=vo.getEmp_year();
			
			
			ArrayList<String> empMailList=getAllEmpDetails(vo.getEmp_expCode(), con);
			
			String[] empmail =new String[empMailList.size()];
			
			for(int i=0;i<empMailList.size();i++){
				
				empmail[i]=empMailList.get(i);
			}
			
				em.setMailids(empmail);
				em.setSubject("Employee Expenses");
				
				em.setMessage("Greetings from TeleIndia. \n\n"
						+ "Director "+vo.getUsername()+" Approved your Expenses month of "+monthName+" - "+year+ "\n\n"
						+ "For more Details Login URL : " + url + "\n"
						+ "Have a nice day \n\n"
						+ "E-ATTENDANCE PRO  \n"
						+ "-------------------------------------------------------------- \n"
						+ "This is system generated mail,Please do not reply");
													
			empstatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
				
				ArrayList<String> mailList=geAdminMailDetails();
				
				String[] accMail =new String[mailList.size()];
				
				for(int i=0;i<mailList.size();i++){
					
					accMail[i]=mailList.get(i);
				}
				
					
					em.setMailids(accMail);
					em.setSubject("Employee Expenses");
					
					em.setMessage("Greetings from TeleIndia. \n\n"
							+ "Director "+vo.getUsername()+" Approved Expenses month of "+monthName+" - "+year+  "\n\n"
							+ "For more Details Login URL : " + url + "\n"
							+ "Approve the  Expenses \n\n"
							+ "Have a nice day \n\n"
							+ "E-ATTENDANCE PRO  \n"
							+ "-------------------------------------------------------------- \n"
							+ "This is system generated mail,Please do not reply");
														
					accountStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
					
					if(accountStatus.equalsIgnoreCase("false") ||  empstatus.equalsIgnoreCase("false")){
						
						status ="false";
					}else{
						
						status= "true";
					}
				
			
			
		}
		catch(Exception e){
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : sendExpenseApprovedByDireEmailToAccAllEmp Ending");
	return status;
	}
    
    
    public String sendExpenseApprovedByAccEmailToAll(ManagerExpenseDetailsVo vo,
			Connection con) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : sendExpenseApprovedByAccEmailToAll  Starting");
		
            String status=null;
		
		try{
			
			
			String url = new  EmployeeDAOImpl().getServerUrlFromBD(con);
		
			EmailContent em = new EmailContent();
			
			String monthName=HelperClass.getMonthName(vo.getEmp_month());
			String year=vo.getEmp_year();
			
			
			ArrayList<String> empMailList=getAllMailIds(vo.getEmp_expCode());
			
			String[] empmail =new String[empMailList.size()];
			
			for(int i=0;i<empMailList.size();i++){
				
				empmail[i]=empMailList.get(i);
			}
			
				
				em.setMailids(empmail);
				em.setSubject("Employee Expenses");
				
				em.setMessage("Greetings from TeleIndia. \n\n"
						+ "Accountant "+vo.getUsername()+" Approved all Expenses month of "+monthName+" - "+year+ "\n\n"
						+ "For more Details Login URL : " + url + "\n"
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
				+ " Control in ManagerExpenseDetailsDaoImpl : sendExpenseApprovedByAccEmailToAll Ending");
	return status;
	
    }
    
    
	public ArrayList<String> getAllEmpDetails(String employeeId, Connection con) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getAllEmpDetails Starting");
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<String> empList= new ArrayList<String>();
		
		String[] employeeArray=employeeId.split(",");
		
		try {
			
			ps = con.prepareStatement(Employee.GET_ALL_EMP_EXPENSE_MAILID);
			
			for(int i=0;i<employeeArray.length;i++){
				
				ps.setString(1, employeeArray[i]);
				rs = ps.executeQuery();
	
			while(rs.next()){
				
				if(empList.size()!=0){
					
					empList.add(rs.getString("Username"));
					
				}else{
					
					if(!(empList.contains(rs.getString("Username")))){
						
						empList.add(rs.getString("Username"));
						
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
				+ " Control in EmployeeExpenseDetailsDaoImpl : getAllEmpDetails Ending");
		
		return empList;
	}

	
	public ArrayList<String> getAllMailIds(String expenseCode){
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getAllMailIds : Starting");

		PreparedStatement approveTktPstmt = null;
		Connection connection=null;
		ResultSet rs=null;
		ArrayList<String> mailId=new ArrayList<String>();
		try {
			
			connection=getConnection();
			approveTktPstmt = connection.prepareStatement(Employee.GET_ALL_EXPENSEmAILID);
			if(expenseCode!=null){
				String[] codeArray=expenseCode.split((","));
				
			for(int i=0;i<codeArray.length;i++){
				
			approveTktPstmt.setString(1, codeArray[i]);
			
			rs=approveTktPstmt.executeQuery();
			
			while(rs.next()){
				
				if(mailId.size()!=0){
					
					if(!(mailId.contains(rs.getString("Username")))){
						
						mailId.add(rs.getString("Username"));
						
					}
					
					if(!(mailId.contains(rs.getString("email")))){
						
						mailId.add(rs.getString("email"));
						
					}
					
					if(!(mailId.contains(rs.getString("empMail")))){
						
						mailId.add(rs.getString("empMail"));
						
					}
					
					
				}else{
					
						mailId.add(rs.getString("empMail"));
						mailId.add(rs.getString("Username"));
						mailId.add(rs.getString("email"));
						
					
				}
			}
			
			}
			}

		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);
			sqle.printStackTrace();

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
			
		} finally {

			try {
				
				
				if(approveTktPstmt != null && (!approveTktPstmt.isClosed())){
					
					approveTktPstmt.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
				}
				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsDaoImpl : getAllMailIds : Ending");

		
		return mailId;
		
	}


	@Override
	public String rejectExpenseDetails(ManagerExpenseDetailsVo vo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : approveExpenseDetails Starting");
		String result = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Connection con = null;
		int statusCount = 0;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			String cr_time = null;
			pstmt = con.prepareStatement(Manager.GET_ALLOWANCE_CREATED_TIME);
			
			pstmt.setString(1, vo.getEmp_year().trim());
			pstmt.setString(2, vo.getEmp_month().trim());
			pstmt.setString(3, vo.getEmp_mangCode().trim());
			pstmt.setString(4, vo.getEmp_Id().trim());
			
			rst = pstmt.executeQuery();
			while (rst.next()) {
				cr_time = rst.getString("createtime");
			}
	
			String empId=getEmplId(vo.getEmp_Id());
			
			if(vo.getUser_Type().equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)){
				
			pstmt = con.prepareStatement(Manager.UPDATE_EMPLOYEE_ALLOWANCE_BYMANAGER);
			pstmt.setString(1, vo.getEmp_totapproved().trim());
			pstmt.setString(2, vo.getEmp_advpaid().trim());
			pstmt.setString(3, vo.getEmp_balance().trim());
			pstmt.setString(4, "R");
			pstmt.setString(5, HelperClass.getCurrentSqlDate().toString());
			pstmt.setString(6, cr_time);
			pstmt.setString(7, vo.getEmp_year().trim());

			pstmt.setString(8, vo.getEmp_month().trim());
			pstmt.setString(9, vo.getEmp_mangCode().trim());
			pstmt.setString(10, empId);
			
			}else if(vo.getUser_Type().equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				

				
				pstmt = con
						.prepareStatement(Manager.UPDATE_EMPLOYEE_ALLOWANCE_BY_DIRECTOR);

				pstmt.setString(1, vo.getEmp_totapproved().trim());
				pstmt.setString(2, vo.getEmp_balance().trim());
				
				pstmt.setString(3, "R");
				pstmt.setString(4, HelperClass.getCurrentSqlDate().toString());
				pstmt.setString(5, cr_time);
				pstmt.setString(6, vo.getEmp_year().trim());
				pstmt.setString(7, vo.getEmp_month().trim());
				pstmt.setString(8, vo.getEmp_mangCode().trim());
				pstmt.setString(9, empId);
				
			}else{
				
				
				pstmt = con
						.prepareStatement(Manager.UPDATE_EMPLOYEE_ALLOWANCE_BY_ADMIN);

				pstmt.setString(1, vo.getEmp_totapproved().trim());
				pstmt.setString(2, vo.getEmp_balance().trim());
				
				pstmt.setString(3,vo.getAcc_code());
				pstmt.setString(4, "R");
				pstmt.setString(5, HelperClass.getCurrentSqlDate().toString());
				pstmt.setString(6, cr_time);
				pstmt.setString(7, vo.getEmp_year().trim());

				pstmt.setString(8, vo.getEmp_month().trim());
				pstmt.setString(9, vo.getEmp_mangCode().trim());
				pstmt.setString(10, empId);
				
			}

			statusCount = pstmt.executeUpdate();
			con.commit();
			if (statusCount > 0) {
				
				result = "success";
				if(LoginDetails.MANAGER_ID_TYPE.equals(vo.getUser_Type())){
					
					String status=sendExpenseApprovedByMangEmailToDirectorandEmp(vo,con,"Reject",empId);
					
					if(status=="false"){
						
            					result = MessageConstants.MAIL_NOT_SENT;
					}
					
			    }
				
				if(LoginDetails.DIRECTOR_ID_TYPE.equals(vo.getUser_Type())){
					
                     String status=sendExpenseApprovedByDireEmailToAccountEmp(vo,con,empId,"Reject");
					
					if(status=="false"){
						
            					result = MessageConstants.MAIL_NOT_SENT;
					}
					
				}
				
				
				if(LoginDetails.ADMIN_ID_TYPE.equals(vo.getUser_Type())){
					
					  String status=sendExpenseApprovedByAdminEmailToDirectorMgrEmp(vo,con,empId,"Reject");
					
					  if(status=="false"){
						
    					result = MessageConstants.MAIL_NOT_SENT;
			
					}
					
				}
			}

		} catch (Exception e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			}
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : approveExpenseDetails Ending");

		return result;
	}
	
	public String getEmplId(String bioid) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : getEmplId Starting");
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		Connection con = null;
		String empId = null;
		try {
			
			con = getConnection();
			
			pstmt = con.prepareStatement(Manager.GET_EMPLOYEEID);
			pstmt.setString(1, bioid);
			
			rst = pstmt.executeQuery();
			while (rst.next()) {
				
				empId = rst.getString("EMPID");
			}

		} catch (Exception e) {
			
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsDaoImpl : approveExpenseDetails Ending");

		return empId;
	}
	
}