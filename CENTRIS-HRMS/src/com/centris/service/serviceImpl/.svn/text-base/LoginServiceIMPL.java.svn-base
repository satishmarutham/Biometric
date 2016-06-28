package com.centris.service.serviceImpl;

import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.LoginDAO;
import com.centris.DAO.DAOIMPL.LoginDAOIMPL;
import com.centris.VO.UserDetailVO;
import com.centris.exception.AITrackerException;
import com.centris.service.LoginService;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class LoginServiceIMPL implements LoginService {
	private static Logger logger = Logger.getLogger(LoginServiceIMPL.class);

	@Override
	public String isValidUser(String user, String pwd, String type)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginServiceIMPL : isValidUser Starting");

		LoginDAO loginDAO = new LoginDAOIMPL();
		String status = null;
		try {

			String result = loginDAO.userValid(user, pwd, type);

			if (result != null && result.equals(StringUtils.LOGIN_TRUE)) {
				status = StringUtils.LOGIN_TRUE;
			} else {
				status = StringUtils.LOGIN_FALSE;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginDAOIMPL : isValidUser Ending");
		return status;
	}

	public String userValidCase(String user, String pwd, String type)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginServiceIMPL : userValidCase Starting");

		LoginDAO loginDAO = new LoginDAOIMPL();
		String status = null;
		try {

			String result = loginDAO.userValidCase(user, pwd, type);

			if (result != null && result.equals(StringUtils.LOGIN_TRUE)) {

				status = StringUtils.LOGIN_TRUE;

			} else {
				status = StringUtils.LOGIN_FALSE;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginServiceIMPL : userValidCase Ending");
		return status;
	}

	public UserDetailVO getUserAdminDetails(String userName, String password) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginServiceIMPL : getUserAdminDetails Starting");

		LoginDAO obj = new LoginDAOIMPL();
		UserDetailVO user_details = null;
		try {

			user_details = obj
					.getUserAdminDetails(userName, password);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginServiceIMPL: getUserAdminDetails Ending");
		return user_details;
	}

	public UserDetailVO getUserManagerDetails(String userName, String password,
			String userType) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginServiceIMPL : getUserManagerDetails Starting");

		LoginDAO obj = new LoginDAOIMPL();
		UserDetailVO user_details = null;
		try {

			user_details = obj.getUserManagerDetails(userName, password,
					userType);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginServiceIMPL: getUserManagerDetails Ending");
		return user_details;
	}

	public UserDetailVO getUserEmployeeDetails(String userName,
			String password, String userType) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginServiceIMPL : getUserEmployeeDetails Starting");

		LoginDAO obj = new LoginDAOIMPL();
		UserDetailVO user_details = null;
		try {

			user_details = obj.getUserEmployeeDetails(userName, password,
					userType);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginServiceIMPL: getUserEmployeeDetails Ending");
		return user_details;
	}

	public UserDetailVO getUserDirectorDetails(String userName,
			String password, String userType) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginServiceIMPL : getUserDirectorDetails Starting");

		LoginDAO obj = new LoginDAOIMPL();
		UserDetailVO user_details = null;
		try {

			user_details = obj.getUserDirectorDetails(userName, password,
					userType);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginServiceIMPL: getUserDirectorDetails Ending");
		return user_details;
	}
	
public HashMap<String,String> getLoginEmployeePrivilegesService(String employeeId){
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in LoginServiceIMPL : getLoginEmployeePrivilegesBD Starting");
		
		LoginDAO obj = new LoginDAOIMPL();
		HashMap<String,String> privilegesMap=new HashMap<String, String>();

		try {
			
			privilegesMap=obj.getLoginEmployeePrivilegesDao(employeeId);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginServiceIMPL: getLoginEmployeePrivilegesBD Ending");
		
		return privilegesMap;
	}
	
}