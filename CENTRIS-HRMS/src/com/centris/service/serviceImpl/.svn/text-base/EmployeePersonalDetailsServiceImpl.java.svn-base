package com.centris.service.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.EmployeePersonalDetailsDao;
import com.centris.DAO.DAOIMPL.EmployeePersonalDetailsDaoImpl;
import com.centris.POJO.EmployeePersonalDetailsPojo;
import com.centris.VO.EmployeePersonalDetailsVo;
import com.centris.form.EmployeePersonalDetailsForm;
import com.centris.service.EmployeePersonalDetailsService;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class EmployeePersonalDetailsServiceImpl implements
		EmployeePersonalDetailsService {
	private static Logger logger = Logger
			.getLogger(EmployeePersonalDetailsServiceImpl.class);

	@Override
	public synchronized Map<String, List<EmployeePersonalDetailsVo>> getEmployeePersonalDetails(
			EmployeePersonalDetailsPojo employeeDetails) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsServiceImpl : getEmployeePersonalDetails Starting");
		EmployeePersonalDetailsDao obj = new EmployeePersonalDetailsDaoImpl();
		Map<String, List<EmployeePersonalDetailsVo>> details = null;
		try {
			details = obj.getEmployeePersonalDetails(employeeDetails);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsServiceImpl : getEmployeePersonalDetails Ending");
		return details;
	}

	public synchronized String checkDuplicatePersonalEmailId(String emailId,
			String empId) {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsServiceImpl : checkDuplicatePersonalEmailId Starting");
		EmployeePersonalDetailsDao obj = new EmployeePersonalDetailsDaoImpl();
		String status = null;
		try {
			status = obj.checkDuplicatePersonalEmailId(emailId, empId);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsServiceImpl : checkDuplicatePersonalEmailId Ending");
		return status;
	}

	@Override
	public synchronized String UpdateEmployeeDetails(
			EmployeePersonalDetailsForm formObj) {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsServiceImpl : UpdateEmployeeDetails Starting");
		EmployeePersonalDetailsDao obj = new EmployeePersonalDetailsDaoImpl();
		String status = null;
		try {
			status = obj.UpdateEmployeeDetails(formObj);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsServiceImpl : UpdateEmployeeDetails Ending");
		return status;
	}
}