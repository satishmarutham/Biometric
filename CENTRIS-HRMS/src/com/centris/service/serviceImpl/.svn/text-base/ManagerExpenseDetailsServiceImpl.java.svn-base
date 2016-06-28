package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.ManagerExpenseDetailsDao;
import com.centris.DAO.DAOIMPL.ManagerExpenseDetailsDaoImpl;
import com.centris.VO.ManagerExpenseDetailsVo;
import com.centris.form.ManagerExpenseDetailsForm;
import com.centris.service.ManagerExpenseDetailsService;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class ManagerExpenseDetailsServiceImpl implements
		ManagerExpenseDetailsService {
	private static Logger logger = Logger
			.getLogger(ManagerExpenseDetailsServiceImpl.class);

	@Override
	public ArrayList<ManagerExpenseDetailsVo> getexpenseDetails(
			ManagerExpenseDetailsForm formObj,String userType) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsServiceImpl : getexpenseDetails Starting");
		ManagerExpenseDetailsDao obj = new ManagerExpenseDetailsDaoImpl();
		ArrayList<ManagerExpenseDetailsVo> expenseDetails = new ArrayList<ManagerExpenseDetailsVo>();
		try {
			expenseDetails = obj.getexpenseDetails(formObj,userType);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsServiceImpl : getexpenseDetails Ending");
		return expenseDetails;
	}

	@Override
	public String approveExpenseDetails(ManagerExpenseDetailsVo vo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsServiceImpl : approveExpenseDetails Starting");
		ManagerExpenseDetailsDao obj = new ManagerExpenseDetailsDaoImpl();
		String result = null;
		try {
			result = obj.approveExpenseDetails(vo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsServiceImpl : approveExpenseDetails Ending");
		return result;
	}

	@Override
	public String approveAllExpenseDetailsService(ManagerExpenseDetailsVo vo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsServiceImpl : approveAllExpenseDetailsService Starting");
		ManagerExpenseDetailsDao obj = new ManagerExpenseDetailsDaoImpl();
		String result = null;
		try {
			result = obj.approveAllExpenseDetailsDao(vo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsServiceImpl : approveAllExpenseDetailsService Ending");
		return result;
	}

	@Override
	public String rejectExpenseDetails(ManagerExpenseDetailsVo vo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsServiceImpl : rejectExpenseDetails Starting");
		ManagerExpenseDetailsDao obj = new ManagerExpenseDetailsDaoImpl();
		String result = null;
		try {
			result = obj.rejectExpenseDetails(vo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsServiceImpl : rejectExpenseDetails Ending");
		return result;
	}
}