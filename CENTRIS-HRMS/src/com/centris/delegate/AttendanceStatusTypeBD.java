package com.centris.delegate;

import java.util.List;
import com.centris.POJO.AttendanceStatusTypePojo;
import com.centris.VO.AttendanceStatusTypeVO;
import com.centris.form.AttendanceStatusTypeForm;
import com.centris.service.AttendanceStatusTypeService;
import com.centris.service.serviceImpl.AttendanceStatusTypeServiceImpl;

public class AttendanceStatusTypeBD {

	AttendanceStatusTypeService serviceObj = new AttendanceStatusTypeServiceImpl();

	public String AddDetails(AttendanceStatusTypeForm attendanceStatusTypeForm,
			String usercode) throws Exception {
		return serviceObj.AddDetails(attendanceStatusTypeForm, usercode);
	}

	public List<AttendanceStatusTypeVO> getAttendanceStatusDetails()
			throws Exception {
		return serviceObj.getAttendanceStatusDetails();
	}

	public boolean deleteAttendanceStatus(String[] attendancestatuscode)
			throws Exception {
		return serviceObj.deleteAttendanceStatus(attendancestatuscode);
	}

	public List<AttendanceStatusTypeVO> editAttendanceStatus(
			String attendancecode) throws Exception {
		return serviceObj.editAttendanceStatus(attendancecode);
	}

	public boolean UpdateAttendanceStatus(AttendanceStatusTypePojo attendanceStatusTypePojo) throws Exception {
		return serviceObj.UpdateAttendanceStatus(attendanceStatusTypePojo);
	}

	public boolean validationStatusType(String statustypename) throws Exception {
		return serviceObj.validationStatusType(statustypename);
	}

	public boolean validationshortname(String shortname) throws Exception {
		return serviceObj.validationshortname(shortname);
	}
}
