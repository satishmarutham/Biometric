package com.centris.service.serviceImpl;

import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.EmployeeAttendancePostingDao;
import com.centris.DAO.DAOIMPL.EmployeeAttendancePostingDaoImpl;
import com.centris.VO.EmployeeAttendancePostingVo;
import com.centris.form.EmployeeAttendancePostingForm;
import com.centris.service.EmployeeAttendancePostingService;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class EmployeeAttendancePostingServiceImpl implements
		EmployeeAttendancePostingService {
	private static Logger logger = Logger
			.getLogger(EmployeeAttendancePostingServiceImpl.class);

	public synchronized EmployeeAttendancePostingVo getEmployeeAttendance(String userCode, String userName,HashMap<String,String> privilegesMap) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingServiceImpl : getEmployeeAttendance Starting");
		EmployeeAttendancePostingVo getAttendance = new EmployeeAttendancePostingVo();
		EmployeeAttendancePostingDao daoObj = new EmployeeAttendancePostingDaoImpl();

		try {
			String currentDate = HelperClass.getCurrentSqlDate().toString();
			getAttendance = daoObj.getEmployeeAttendance(userCode, userName,HelperClass.getLastThirtyDateFromNow(currentDate).toString(), currentDate,privilegesMap);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingServiceImpl : getEmployeeAttendance Ending");
		return getAttendance;
	}
	
	public EmployeeAttendancePostingVo updateAttendanceDetails(EmployeeAttendancePostingForm employeeAttendancePostingForm,HashMap<String,String> privilegesMap) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingServiceImpl : updateAttendanceDetails Starting");
		EmployeeAttendancePostingDao daoObj = new EmployeeAttendancePostingDaoImpl();
		EmployeeAttendancePostingVo attendance= new EmployeeAttendancePostingVo();
		String status=daoObj.updateAttendanceDetails(employeeAttendancePostingForm,privilegesMap);
		attendance.setResponse(status);
		
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingServiceImpl : updateAttendanceDetails Ending");

		return attendance;
	}
}
