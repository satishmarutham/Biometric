package com.centris.service;

import java.util.HashMap;

import com.centris.VO.UserDetailVO;

public interface LoginService {

	public String isValidUser(String user, String pwd, String type)
			throws Exception;

	public String userValidCase(String user, String pwd, String type)
			throws Exception;

	public UserDetailVO getUserAdminDetails(String userName, String password) throws Exception;

	public UserDetailVO getUserManagerDetails(String userName, String password,
			String userType) throws Exception;

	public UserDetailVO getUserEmployeeDetails(String userName,
			String password, String userType) throws Exception;

	public UserDetailVO getUserDirectorDetails(String userName,
			String password, String userType) throws Exception;
	
	public HashMap<String,String> getLoginEmployeePrivilegesService(String employeeId)throws Exception;
}
