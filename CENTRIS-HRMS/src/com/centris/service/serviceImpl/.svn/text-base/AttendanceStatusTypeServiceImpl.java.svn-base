package com.centris.service.serviceImpl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.AttendanceStatusTypeDao;
import com.centris.DAO.DAOIMPL.AttendanceStatusTypeDaoImpl;
import com.centris.DAO.DAOIMPL.IDGenerator;
import com.centris.POJO.AttendanceStatusTypePojo;
import com.centris.VO.AttendanceStatusTypeVO;
import com.centris.form.AttendanceStatusTypeForm;
import com.centris.service.AttendanceStatusTypeService;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class AttendanceStatusTypeServiceImpl implements
		AttendanceStatusTypeService {
	private static Logger logger = Logger
			.getLogger(AttendanceStatusTypeServiceImpl.class);

	AttendanceStatusTypeDao daoObj = new AttendanceStatusTypeDaoImpl();

	public String AddDetails(AttendanceStatusTypeForm attendanceStatusTypeForm,
			String usercode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeServicesImpl : AddDetails Starting");

		AttendanceStatusTypePojo attendanceStatusTypePojo = new AttendanceStatusTypePojo();
		try {
			
			IDGenerator idGenerator = new IDGenerator();
			String ASTCode = idGenerator
					.getPrimaryKeyID("hrms_attendence_status_type");
			
		
			
			
			attendanceStatusTypePojo.setStatustypename(attendanceStatusTypeForm
					.getStatustypename());
			attendanceStatusTypePojo.setShortname(attendanceStatusTypeForm
					.getShortname());
			attendanceStatusTypePojo.setDescription(attendanceStatusTypeForm
					.getDescription());
			attendanceStatusTypePojo.setCreatedby(usercode);
			attendanceStatusTypePojo.setStatustypecode(ASTCode);
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeServicesImpl : AddDetails Ending");

		return daoObj.AddDetails(attendanceStatusTypePojo);
	}

	public List<AttendanceStatusTypeVO> getAttendanceStatusDetails() {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeServicesImpl : getAttendanceStatusDetails Starting");

		List<AttendanceStatusTypeVO> obj = null;
		try {
			obj = daoObj.getAttendanceStatusDetails();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeServicesImpl : getAttendanceStatusDetails Ending");
		return obj;
	}

	public boolean deleteAttendanceStatus(String[] attendancestatuscode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeServicesImpl : deleteAttendanceStatus Starting");
		boolean obj = false;
		try {
			obj = daoObj.deleteAttendanceStatus(attendancestatuscode);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeServicesImpl : deleteAttendanceStatus Ending");

		return obj;
	}

	public List<AttendanceStatusTypeVO> editAttendanceStatus(
			String attendancecode) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeServicesImpl : editAttendanceStatus Starting");

		List<AttendanceStatusTypeVO> obj = null;
		try {
			obj = daoObj.editAttendanceStatus(attendancecode);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeServicesImpl : editAttendanceStatus Ending");
		
		return obj;
		
		
		
	}

	public boolean UpdateAttendanceStatus(
			AttendanceStatusTypePojo attendanceStatusTypePojo) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeServicesImpl : UpdateAttendanceStatus Starting");
		boolean obj = false;
		try {
			obj = daoObj.UpdateAttendanceStatus(attendanceStatusTypePojo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeServicesImpl : UpdateAttendanceStatus Ending");

		return obj;
	
	}

	public boolean validationStatusType(String statustypename) {
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeServicesImpl : validationStatusType Starting");
		boolean obj = false;
		try {
			obj = daoObj.validationStatusType(statustypename);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeServicesImpl : validationStatusType Ending");

		return obj;
		
		}

	public boolean validationshortname(String shortname) {
		
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeServicesImpl : validationshortname Starting");
		boolean obj = false;
		try {
			obj = daoObj.validationshortname(shortname);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeServicesImpl : validationshortname Ending");

		return obj;
		
	}
}
