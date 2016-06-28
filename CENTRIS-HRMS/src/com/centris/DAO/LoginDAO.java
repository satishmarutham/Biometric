package com.centris.DAO;

import java.util.HashMap;

import com.centris.VO.UserDetailVO;

public interface LoginDAO {
	public String userValid(String username, String password, String type)
			throws Exception;

	public String userValidCase(String username, String password, String type)
			throws Exception;

	public UserDetailVO getUserAdminDetails(String userName, String password) throws Exception;

	public UserDetailVO getUserManagerDetails(String userName, String password,
			String userType) throws Exception;

	public UserDetailVO getUserEmployeeDetails(String userName,
			String password, String userType) throws Exception;
	
	public UserDetailVO getUserDirectorDetails(String userName,
			String password, String userType) throws Exception;
	
	public HashMap<String,String> getLoginEmployeePrivilegesDao(String employeeId) throws Exception;
	
}
