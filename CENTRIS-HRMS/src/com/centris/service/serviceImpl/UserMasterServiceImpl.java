package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.ChangePasswordDao;
import com.centris.DAO.UserMasterDao;
import com.centris.DAO.DAOIMPL.ChangePasswordDaoImpl;
import com.centris.DAO.DAOIMPL.UserMasterDaoImpl;
import com.centris.POJO.UserMasterPojo;
import com.centris.service.UserMasterService;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;


/**
 * @author seshuma
 *
 */
public class UserMasterServiceImpl implements UserMasterService{
	private static Logger logger = Logger
			.getLogger(UserMasterServiceImpl.class);
	@Override
	public List<UserMasterPojo> getUserDetails() throws Exception {
		// TODO Auto-generated method stub
		return new UserMasterDaoImpl().getUserDetails();
	}

	@Override
	public String addUser(UserMasterPojo userMasterPojo) throws Exception {
		// TODO Auto-generated method stub
		return new UserMasterDaoImpl().addUser(userMasterPojo);
	}

	@Override
	public String editUser(UserMasterPojo userMasterPojo)
			throws Exception {
		// TODO Auto-generated method stub
		return new UserMasterDaoImpl().editUser(userMasterPojo);
	}
	public String deleteUser(UserMasterPojo userMasterPojo) throws Exception {
		// TODO Auto-generated method stub
		return new UserMasterDaoImpl().deleteUser(userMasterPojo);
	}

	@Override
	public ArrayList<UserMasterPojo> getGroupDetails() throws Exception {
		// TODO Auto-generated method stub
		return new UserMasterDaoImpl().getGroupDetails();
	}
	
	public boolean CurrentUserNameCkeck(String username) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterServiceImpl : CurrentUserNameCkeck Starting");
		
		UserMasterDao obj = null;
		boolean status = false;
		try {
			obj = new UserMasterDaoImpl();

			status = obj.CurrentUserNameCkeck(username);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterServiceImpl : CurrentUserNameCkeck Ending");
		return status;
	}
	
}
