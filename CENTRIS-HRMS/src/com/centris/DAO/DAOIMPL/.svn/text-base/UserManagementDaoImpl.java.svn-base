package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.DAO.UserManagementDao;
import com.centris.VO.UsermanagementEmployeeVo;
import com.centris.form.UserManagementForm;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.SQLUtils.Usermanagement;
import com.centris.util.constants.MessageConstants;

public class UserManagementDaoImpl extends DBService implements UserManagementDao{

	private static Logger logger = Logger.getLogger(UserManagementDaoImpl.class);
	
	
	
	@Override
	public ArrayList<UsermanagementEmployeeVo> getEmpIdNameBySerachTerm(String startwith,String designation){
		
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in EmployeeDAOImpl: getEmpIdNameBySerachTerm Starting");

			PreparedStatement pstmt = null;
			Connection connection = null;
			ResultSet rs = null;
			ArrayList<UsermanagementEmployeeVo> employVOList = new ArrayList<UsermanagementEmployeeVo>();
			try {
				connection = getConnection();
				pstmt = connection.prepareStatement(Usermanagement.GETEMPLOYEE_DETAILS);
				pstmt.setString(1, startwith + "%");
				pstmt.setString(2,"%"+ designation +"%");
				
				rs = pstmt.executeQuery();

				while (rs.next()) {
					
					UsermanagementEmployeeVo uservo = new UsermanagementEmployeeVo();

					uservo.setEmpid(rs.getString("EMPID"));
					uservo.setEmpname(rs.getString("First_Name"));
					uservo.setBioid(rs.getString("bioid"));
					uservo.setDesignation(rs.getString("designationName"));
					
					employVOList.add(uservo);
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			} finally {
				try {

					if (pstmt != null && !pstmt.isClosed()) {
						pstmt.close();
					}

					if (connection != null && (!connection.isClosed())) {
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
					+ " Control in EmployeeDAOImpl: getEmpIdNameBySerachTerm Ending");

			return employVOList;
		}
	
	
	public ArrayList<String> getUserMangementRoles(String empId){
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: getUserMangementRoles Starting");

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Connection connection = null;
		
		ArrayList<String> rolesList=new ArrayList<String>();
		String officialMailId=null;
		
		try {
			connection = getConnection();
			
			rolesList.add("employee");
			
			pstmt = connection.prepareStatement(Usermanagement.GET_OFFICIAL_MAILID);
			pstmt.setString(1, empId);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				officialMailId=rs.getString("Official_Email_ID");
			}
			
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}

			pstmt = connection.prepareStatement(Usermanagement.CHECK_DIRECTOR);
			pstmt.setString(1, officialMailId);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				rolesList.add("director");
			}
			
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			
			pstmt = connection.prepareStatement(Usermanagement.CHECK_MANAGER);
			pstmt.setString(1, officialMailId);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				rolesList.add("manager");
			}
			
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			
			pstmt = connection.prepareStatement(Usermanagement.CHECK_USER);
			pstmt.setString(1, empId);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				rolesList.add(rs.getString("UserOption"));
			}
			
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
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
				+ " Control in EmployeeDAOImpl: getUserMangementRoles Ending");

		return rolesList;
	}


	@Override
	public String saveEmployeeRole(UserManagementForm form, String currentuser) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: saveEmployeeRole Starting");

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Connection connection = null;
		
		String status=null;
		UsermanagementEmployeeVo employeeVo=new UsermanagementEmployeeVo();
		
		IDGenerator id=new IDGenerator();
		
		int count=0;
		
		UserManagementDaoImpl userDaoImpl=new UserManagementDaoImpl();
		
		String manager=null;
		String director=null;
		String dobirth=null;
		String user=null;
		int count1=0;
		int count2=0;
		int count3=0;
		String MgrPassword=null;
		String directorPwd=null;
		String adminPwd=null;
		
		
		try {
			connection = getConnection();
			
			pstmt = connection.prepareStatement(Usermanagement.GET_EMPLOYEE_DETAILS);
			pstmt.setString(1, form.getSelectEmployee());
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				
				employeeVo.setEmpname(rs.getString("First_Name"));
				employeeVo.setDob(rs.getString("DOB"));
				employeeVo.setMobilenumber(rs.getString("Mobile_Number"));
				employeeVo.setOfficialmailId(rs.getString("Official_Email_ID"));
				employeeVo.setEmpid(rs.getString("EMPID"));
				employeeVo.setBioid(rs.getString("bioid"));
				
			}
			
			 MgrPassword=HelperClass.genaratePasswordForManager(employeeVo);
			 directorPwd=HelperClass.genaratePasswordForManager(employeeVo);
			 adminPwd=HelperClass.genaratePasswordForManager(employeeVo);
			 
			
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			
			 dobirth = HelperClass.convertDatabaseToUI(employeeVo.getDob()).replaceAll("-", "");
			
			if(form.getManager()!=null){
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_MANAGER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_MANAGER, employeeVo.getOfficialmailId(), "",MgrPassword);
					
					if(count>0){
						
						manager="1";
					}
				}else{
				
				pstmt = connection.prepareStatement(Usermanagement.INSERT_MANAGER_DETAILS);
				pstmt.setString(1, id.getPrimaryKeyID("hrms_manager").trim());
				pstmt.setString(2, employeeVo.getEmpname().trim());
				pstmt.setString(3, employeeVo.getMobilenumber().trim());
				pstmt.setString(4, MgrPassword.trim());
				pstmt.setString(5, employeeVo.getOfficialmailId().trim());
				pstmt.setString(6, employeeVo.getOfficialmailId().trim());
				pstmt.setString(7, currentuser.trim());
				pstmt.setTimestamp(8, HelperClass.getCurrentTimestamp());
				pstmt.setString(9, "Y");
				pstmt.setString(10, form.getSelectEmployee().trim());
				
				count=pstmt.executeUpdate();
			
				if(count>0){
					
					manager="1";
				}
				
				}
				
			}else{
				
				count3=userDaoImpl.updateUser("N",Usermanagement.UPDATE_MANAGER, employeeVo.getOfficialmailId(), "",MgrPassword);
				
				if(count3>0){
					
					manager="2";
				}else{
					
					manager="3";
				}
			}
		
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}

			if(form.getDirector()!=null){
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_DIRECTORCOUNT_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_DIRECTOR, employeeVo.getOfficialmailId(), "",directorPwd);
				
					if(count>0){
						
						director="1";
					}
					
				}else{
				
			pstmt = connection.prepareStatement(Usermanagement.INSERT_DIRECTOR_DETAILS);
			
			pstmt.setString(1, employeeVo.getOfficialmailId().trim());
			pstmt.setString(2, directorPwd.trim());
			pstmt.setString(3, form.getSelectEmployee().trim());
			pstmt.setString(4, "Y");
			pstmt.setString(5, currentuser.trim());
			pstmt.setTimestamp(6, HelperClass.getCurrentTimestamp());
			pstmt.setString(7, id.getPrimaryKeyID("hrms_director").trim());
			pstmt.setString(8, Director.DIRECTOR_ROLE);
			
			count=pstmt.executeUpdate();
			if(count>0){
				
				director="1";
			}
			}
			}else{
				
				count1=userDaoImpl.updateUser("N",Usermanagement.UPDATE_DIRECTOR, employeeVo.getOfficialmailId(), "",directorPwd);
				
				if(count1>0){
					
					director="2";
				}else{
					
					director="3";
				}
				
			}
			
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			
				
			if(form.getHr()!=null && form.getClerk()!=null && form.getAccounts()!=null && form.getAdmin()!=null){
				
				String[] userOptins={MessageConstants.ADMIN,MessageConstants.HR,MessageConstants.CLERK,MessageConstants.ACCOUNTS};
				
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),"ROL11",adminPwd);
					
				}else{
				
				count=userDaoImpl.insertUser(employeeVo, currentuser, "ROL11",adminPwd);
				}
				
			}else if(form.getAdmin()!=null && form.getClerk()!=null && form.getHr()!=null){

				
				String[] userOptins={MessageConstants.ADMIN,MessageConstants.HR,MessageConstants.CLERK};
				
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),"ROL12",adminPwd);
					
				}else{
					
				count=userDaoImpl.insertUser(employeeVo, currentuser, "ROL12",adminPwd);
				}
				
			
				
				
			}else if(form.getAdmin()!=null && form.getAccounts()!=null && form.getHr()!=null){
				
				
				String[] userOptins={MessageConstants.ADMIN,MessageConstants.HR,MessageConstants.ACCOUNTS};
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),"ROL14",adminPwd);
					
				}else{
				
				count=userDaoImpl.insertUser(employeeVo, currentuser, "ROL14",adminPwd);
				}
			
				
				
			}else if(form.getAdmin()!=null && form.getAccounts()!=null && form.getClerk()!=null){
				
				
				String[] userOptins={MessageConstants.ADMIN,MessageConstants.CLERK,MessageConstants.ACCOUNTS};
				
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){

					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),"ROL13",adminPwd);
					
				}else{
					
				count=userDaoImpl.insertUser(employeeVo, currentuser, "ROL13",adminPwd);
				}
			
			
				
			}else if(form.getHr()!=null && form.getClerk()!=null && form.getAccounts()!=null){
				
				String[] userOptins={MessageConstants.HR,MessageConstants.CLERK,MessageConstants.ACCOUNTS};
				
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),"ROL8",adminPwd);
					
				}else{
				
					count=userDaoImpl.insertUser(employeeVo, currentuser, "ROL8",adminPwd);
				}
			
				
			}else if(form.getAdmin()!=null && form.getHr()!=null){

				
				String[] userOptins={MessageConstants.HR,MessageConstants.ADMIN};
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),"ROL9",adminPwd);
					
				}else{
					
				count=userDaoImpl.insertUser(employeeVo, currentuser, "ROL9",adminPwd);
				}
			
				
			}else if(form.getAdmin()!=null && form.getAccounts()!=null){
				
				String[] userOptins={MessageConstants.ACCOUNTS,MessageConstants.ADMIN};
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),"ROL15",adminPwd);
					
				}else{
					
				count=userDaoImpl.insertUser(employeeVo, currentuser, "ROL15",adminPwd);
				}
			
				
				
			}else if(form.getAdmin()!=null && form.getClerk()!=null){
				
				String[] userOptins={MessageConstants.CLERK,MessageConstants.ADMIN};
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),"ROL10",adminPwd);
					
				}else{
					
				count=userDaoImpl.insertUser(employeeVo, currentuser, "ROL10",adminPwd);
				
				}
				
				
			}else if(form.getHr()!=null && form.getAccounts()!=null){
				
				String[] userOptins={MessageConstants.HR,MessageConstants.ACCOUNTS};
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),"ROL6",adminPwd);
					
				}else{
					
				count=userDaoImpl.insertUser(employeeVo, currentuser, "ROL6",adminPwd);
				
				}
			
				
			}else if(form.getClerk()!=null && form.getAccounts()!=null){
				
				String[] userOptins={MessageConstants.CLERK,MessageConstants.ACCOUNTS};
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),"ROL7",adminPwd);
					
				}else{
					
					count=userDaoImpl.insertUser(employeeVo, currentuser, "ROL7",adminPwd);
				}
				
				
			}else if(form.getHr()!=null && form.getClerk()!=null){
				
				String[] userOptins={MessageConstants.CLERK,MessageConstants.HR};
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),"ROL5",adminPwd);
					
				}else{
					
					count=userDaoImpl.insertUser(employeeVo, currentuser, "ROL5",adminPwd);
				
				}
			
				
			}else if(form.getAdmin()!=null && form.getCustomrole()!=null){
				
				String[] userOptins={MessageConstants.ADMIN,form.getRole()};
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),form.getRole(),adminPwd);
					
				}else{
					
					count=userDaoImpl.insertUser(employeeVo, currentuser, form.getRole(),adminPwd);
				
				}
			
				
			}else if(form.getAdmin()!=null){
				
				String[] userOptins={MessageConstants.ADMIN};
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),"ROL1",adminPwd);
					
				}else{
					
				count=userDaoImpl.insertUser(employeeVo, currentuser, "ROL1",adminPwd);
				
				}
			
			}else if(form.getHr()!=null){
				
				String[] userOptins={MessageConstants.HR};
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),"ROL2",adminPwd);
					
				}else{
					
				count=userDaoImpl.insertUser(employeeVo, currentuser, "ROL2",adminPwd);
				
				}
			
				
			}else if(form.getClerk()!=null){
				
				String[] userOptins={MessageConstants.CLERK};
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),"ROL3",adminPwd);
					
				}else{
				
					count=userDaoImpl.insertUser(employeeVo, currentuser, "ROL3",adminPwd);
				
				}
			
			}else if(form.getAccounts()!=null){
				
				String[] userOptins={MessageConstants.ACCOUNTS};
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				
				if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
					count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),"ROL4",adminPwd);
					
				}else{
				
					count=userDaoImpl.insertUser(employeeVo, currentuser, "ROL4",adminPwd);
				}
			
			}else if(form.getCustomrole()!=null){
			
				String[] userOptins={form.getRole()};
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
	            if(userDaoImpl.checkUser(Usermanagement.CHECK_USER_COUNT, employeeVo.getOfficialmailId())==1){
					
	            	count=userDaoImpl.updateUser("Y",Usermanagement.UPDATE_USER, employeeVo.getOfficialmailId(),form.getRole(),adminPwd);
					
				}else{
				
					count=userDaoImpl.insertUser(employeeVo, currentuser, form.getRole(),adminPwd);
				}
				
			}else{
				
				String[] userOptins={};
				user=userDaoImpl.insertUserOptions(form.getSelectEmployee(), userOptins,currentuser);
				count2=userDaoImpl.updateUser("N",Usermanagement.INACTIVE_USER, employeeVo.getOfficialmailId(),"",adminPwd);
				
			}
			
			
			
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			
			if(count>0 || count1>0 || count2>0 || count3>0){
				
				status="true";
				
				String url = getServerUrlFromBD(connection);
				
				String mailStatus = sendEmailToEmployee(
						employeeVo.getOfficialmailId(),employeeVo.getEmpname(), url,manager,director,user,MgrPassword,directorPwd,adminPwd);
				
				if(mailStatus.equalsIgnoreCase("true")){
					
					status="mailSent";
				}
				
			}else{
				
				status="false";
			}
		

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
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
				+ " Control in EmployeeDAOImpl: saveEmployeeRole Ending");

		return status;
	}
	
	
public int insertUser(UsermanagementEmployeeVo employeeVo,String currentUser,String role,String pwd){
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: insertUser Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		int count=0;
		IDGenerator id=new IDGenerator();
		
		String dobirth = HelperClass.convertDatabaseToUI(employeeVo.getDob()).replaceAll("-", "");
		
		try {
			connection = getConnection();
			
			pstmt = connection.prepareStatement(Usermanagement.INSERT_USER_DETAILS);
			pstmt.setString(1, id.getPrimaryKeyID("hrms_user").trim());
			pstmt.setString(2, employeeVo.getOfficialmailId().trim());
			pstmt.setString(3, pwd.trim());
			pstmt.setString(4, currentUser.trim());
			pstmt.setTimestamp(5, HelperClass.getCurrentTimestamp());
			pstmt.setString(6, role.trim());
			pstmt.setString(7, employeeVo.getMobilenumber().trim());
			pstmt.setString(8, employeeVo.getOfficialmailId().trim());
			pstmt.setString(9, employeeVo.getEmpid().trim());
			
			
			count=pstmt.executeUpdate();

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (connection != null && (!connection.isClosed())) {
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
				+ " Control in EmployeeDAOImpl: insertUser Ending");

		return count;
	}


public int checkUser(String query,String username){
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmployeeDAOImpl: checkUser Starting");

	PreparedStatement pstmt = null;
	ResultSet rs=null;
	Connection connection = null;
	int count=0;
	
	try {
		connection = getConnection();
		
		pstmt = connection.prepareStatement(query);
		pstmt.setString(1, username);
		
		
		rs=pstmt.executeQuery();
		
		while(rs.next()){
			
			count=rs.getInt(1);
		}
				
				

	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(), sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(), e1);
	} finally {
		try {

			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}

			if (connection != null && (!connection.isClosed())) {
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
			+ " Control in EmployeeDAOImpl: checkUser Ending");

	return count;
}

public int updateUser(String status,String query,String username,String role,String password){
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmployeeDAOImpl: updateUser Starting");

	PreparedStatement pstmt = null;
	Connection connection = null;
	int count=0;
	
	try {
		connection = getConnection();
		
		pstmt = connection.prepareStatement(query);
		
		if(("").equalsIgnoreCase(role) || null==role){
			
			pstmt.setString(1, status);
			pstmt.setString(2, password.trim());
			pstmt.setString(3, username.trim());
		
		}else{
			
			pstmt.setString(1, status);
			pstmt.setString(2, role);
			pstmt.setString(3, password.trim());
			pstmt.setString(4, username.trim());
			
		}
		count=pstmt.executeUpdate();

	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(), sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(), e1);
	} finally {
		try {

			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}

			if (connection != null && (!connection.isClosed())) {
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
			+ " Control in EmployeeDAOImpl: updateUser Ending");

	return count;
}

public String insertUserOptions(String empId,String[] useroptins,String currentUser){
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmployeeDAOImpl: insertUserOptions Starting");

	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	Connection connection = null;
	int count=0;
	int deletecount=0;
	String userOptinsStr="";
	
	try {
		connection = getConnection();
		
		pstmt1 = connection.prepareStatement(Usermanagement.DELETR_USEROPTIONS);
		
		pstmt1.setString(1, empId);
		deletecount=pstmt1.executeUpdate();
		
		pstmt = connection.prepareStatement(Usermanagement.INSERT_USEROPTIONS);
		
		for(int i=0;i<useroptins.length;i++){
		pstmt.setString(1, empId);
		pstmt.setString(2, useroptins[i]);
		pstmt.setString(3, currentUser);
		
		count=pstmt.executeUpdate();
		
		if(!(userOptinsStr.equalsIgnoreCase(""))){
			
			userOptinsStr=userOptinsStr+","+useroptins[i];
		}else{
		
			userOptinsStr=useroptins[i];
		}
		
		}
		
	if(useroptins.length==0){
		if(deletecount>0){
			
			userOptinsStr="2";
		}else{
			
			userOptinsStr="3";
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

			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}

			if (connection != null && (!connection.isClosed())) {
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
			+ " Control in EmployeeDAOImpl: insertUserOptions Ending");

	return userOptinsStr;
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

public String sendEmailToEmployee(String emailId, String empName,
		String url,String manager,String director,String user,String mgrPwd,String directorPwd,String adminPwd) {
	
	String mailStatus=null;
	
	try {
		
		String managerCnt=null;
		String directorCnt=null;
		String userCnt=null;
		
		if("1".equalsIgnoreCase(manager)){
			
			managerCnt="Manager Details \n\n"
					+"Username : "+ emailId+ " "
					+"\n Password : "+ mgrPwd+ ""
					+"\n URL : "+ url+ " "
					+"\n Login type : Manager "
					+"\n Account Status : Active";
			
			
		}else if("2".equalsIgnoreCase(manager)){
			
			managerCnt="Manager Details \n\n"
					/*+"Username : "+ emailId+ " \n"
					+"Password : "+ mgrPwd+ " \n"*/
					+"URL : "+ url+ " \n"
					+"Login type : Manager \n"
					+"Account Status : Deactivate";
		}else{
			
			managerCnt="";
		}
		
		
		if("1".equalsIgnoreCase(director)){
			
			directorCnt="Director Details \n\n"
						+"Username : "+ emailId+ " \n"
						+"Password : "+ directorPwd+ " \n"
						+"URL : "+ url+ " \n"
						+"Login type : Director \n"
						+"Account Status : Active";
									
			
		}else if("2".equalsIgnoreCase(director)){
			
			directorCnt="Director Details \n\n"
					/*+"Username : "+ emailId+ " \n"
					+"Password : "+ directorPwd+ " \n"*/
					+"URL : "+ url+ " \n"
					+"Login type : Director \n"
					+"Account Status : Deactivate";
		}else{
			
			directorCnt="";
		}
		
		
		 if("2".equalsIgnoreCase(user)){
			
			 userCnt="Admin Details \n\n"
						/*+"Username : "+ emailId+ " \n"
						+"Password : "+ adminPwd+ " \n"*/
						+"URL : "+ url+ " \n"
						+"Login type : Admin \n"
						+"Account Status : Deactivate";
			 
		}else if("3".equalsIgnoreCase(user)){
			
			userCnt="";
			
		}else if(user!=null){
			
			
			 userCnt=	"Admin Details \n\n"
						+"Username : "+ emailId+ " \n"
						+"Password : "+ adminPwd+ " \n"
						+"URL : "+ url+ " \n"
						+"Login type : Admin \n"
						+"Account Status : Active";
			
		}else{
			
			userCnt="";
		}
		
		
		
		EmailContent em = new EmailContent();
		String[] mails = { emailId };

		em.setMailids(mails);
		em.setSubject("Registration Details");
		

		em.setMessage("Dear "+empName +",\n"
					+ "Greetings from TeleIndia \n\n"
					+ "Your account permissions are changed,please find below  \n"
					+ "details, \n"
					+ "\n"+directorCnt+". \n"
					+ "\n"+managerCnt+". \n"
					+ "\n"+userCnt+". \n\n"
					+ "Have a nice day.\n"
					+ "e-AttendancePro "  
					+"\n ----------------------------------------------------------------"
					+"\n This is System generated mail, Please do not reply"
	                );
		
		mailStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	return mailStatus;
}


public static void main(String[] args) {
	
	UserManagementDaoImpl userDao=new UserManagementDaoImpl();
	
	
	UserManagementForm form=new UserManagementForm();
	
	form.setDesignation("%%");
	form.setSelectEmployee("EMP5");
	form.setEmployee("employee");
	form.setManager("manager");
	//form.setDirector("director");
	/*form.setAdmin("ROL1");*/

	
	String status=userDao.saveEmployeeRole(form, "USR1");
	
	
}

}
