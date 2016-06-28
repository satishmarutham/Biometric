package com.centris.service.serviceImpl;

import java.util.Date;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import com.centris.DAO.ChangePasswordDao;
import com.centris.DAO.DAOIMPL.ChangePasswordDaoImpl;
import com.centris.VO.ChangePasswordVo;
import com.centris.form.ChangePasswordForm;
import com.centris.service.ChangePasswordService;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class ChangePasswordServiceImpl implements ChangePasswordService {
	private static Logger logger = Logger
			.getLogger(ChangePasswordServiceImpl.class);

	public boolean checkManagerCurrentPassword(String username, String password) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordServiceImpl : getCurrentPassword Starting");

		ChangePasswordDao obj = null;
		boolean status = false;
		try {
			obj = new ChangePasswordDaoImpl();

			status = obj.checkManagerCurrentPassword(username, password);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordServiceImpl : getCurrentPassword Ending");
		return status;
	}

	@Override
	public String updateManagerPassword(ChangePasswordForm form) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordServiceImpl : updatePassword Starting");
		ChangePasswordVo changePasswordVo = new ChangePasswordVo();
		changePasswordVo.setNew_Password(form.getManager_Newpassword());
		changePasswordVo.setCurrent_Password(form.getManager_Oldpassword());
		changePasswordVo.setConfirmnew_Password(form
				.getManager_Confirmpassword());
		changePasswordVo.setUserName(form.getUserName());
		changePasswordVo.setEmial(form.getManager_EmailID());
		return new ChangePasswordDaoImpl()
				.updateManagerPassword(changePasswordVo);

	}

	@Override
	public boolean checkAdminCurrentPassword(String username, String password,
			String Type) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordServiceImpl : checkAdminCurrentPassword Starting");

		ChangePasswordDao obj = null;
		boolean status = false;
		try {
			obj = new ChangePasswordDaoImpl();

			status = obj.checkAdminCurrentPassword(username, password, Type);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordServiceImpl : checkAdminCurrentPassword Ending");
		return status;

		// TODO Auto-generated method stub
		/*
		 * return new
		 * ChangePasswordServiceImpl().checkAdminCurrentPassword(username,
		 * password);
		 */
	}

	@Override
	public String updateAdminPassword(ChangePasswordForm obj) {
		// TODO Auto-generated method stub
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordServiceImpl : updatePassword Starting");
		ChangePasswordVo changePasswordVo = new ChangePasswordVo();
		changePasswordVo.setNew_Password(obj.getAdmin__Newpassword());
		changePasswordVo.setCurrent_Password(obj.getAdmin_Oldpassword());
		changePasswordVo
				.setConfirmnew_Password(obj.getAdmin__Confirmpassword());
		changePasswordVo.setUserName(obj.getUserName());
		changePasswordVo.setCurrentUserId(obj.getCurrentUserId());
		return new ChangePasswordDaoImpl()
				.updateAdminPassword(changePasswordVo);
	}

	@Override
	public String updateEmployeePassword(ChangePasswordForm obj) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordServiceImpl : updatePassword Starting");
		ChangePasswordVo changePasswordVo = new ChangePasswordVo();
		changePasswordVo.setNew_Password(obj.getEmployee__Newpassword());
		changePasswordVo.setCurrent_Password(obj.getEmployee_Oldpassword());
		changePasswordVo.setConfirmnew_Password(obj
				.getEmployee__Confirmpassword());
		changePasswordVo.setUserName(obj.getUserName());
		changePasswordVo.setEmial(obj.getEmployee_EmailID());
		return new ChangePasswordDaoImpl()
				.updateEmployeePassword(changePasswordVo);
	}
}