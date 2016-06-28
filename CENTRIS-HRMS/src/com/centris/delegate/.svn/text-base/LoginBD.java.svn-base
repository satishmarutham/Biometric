package com.centris.delegate;

import java.util.HashMap;

import com.centris.VO.UserDetailVO;
import com.centris.service.LoginService;
import com.centris.service.serviceImpl.LoginServiceIMPL;

/**
 * @author Ratna
 * 
 */
public class LoginBD {

	public String isValidUser(String user, String pwd, String type)
			throws Exception {
		LoginService loginservice = new LoginServiceIMPL();
		String result = loginservice.isValidUser(user, pwd, type);
		return result;
	}

	public String userValidCase(String user, String pwd, String type)
			throws Exception {
		LoginService loginservice = new LoginServiceIMPL();
		String result = loginservice.userValidCase(user, pwd, type);
		return result;
	}

	public UserDetailVO getUserAdminDetails(String userName, String password) throws Exception {
		LoginService loginservice = new LoginServiceIMPL();
		UserDetailVO user_details = null;
		user_details = loginservice.getUserAdminDetails(userName, password);
		return user_details;
	}

	public UserDetailVO getUserManagerDetails(String userName, String password,
			String userType) throws Exception {
		LoginService loginservice = new LoginServiceIMPL();
		UserDetailVO user_details = null;
		user_details = loginservice.getUserManagerDetails(userName, password,
				userType);
		return user_details;
	}

	public UserDetailVO getUserEmployeeDetails(String userName,
			String password, String userType) throws Exception {
		LoginService loginservice = new LoginServiceIMPL();
		UserDetailVO user_details = null;
		user_details = loginservice.getUserEmployeeDetails(userName, password,
				userType);
		return user_details;
	}
	
	public UserDetailVO getUserDirectorDetails(String userName, String password,
			String userType) throws Exception {
		LoginService loginservice = new LoginServiceIMPL();
		UserDetailVO user_details = null;
		user_details = loginservice.getUserDirectorDetails(userName, password,
				userType);
		return user_details;
	}
	
	
	public HashMap<String,String> getLoginEmployeePrivilegesBD(String employeeId){
		
		LoginService loginservice = new LoginServiceIMPL();
		HashMap<String,String> privilegesMap=new HashMap<String, String>();

		try {
			
			privilegesMap=loginservice.getLoginEmployeePrivilegesService(employeeId);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return privilegesMap;
	}
}