package com.centris.service;

import java.util.List;

import com.centris.POJO.AttendanceStatusTypePojo;
import com.centris.VO.AttendanceStatusTypeVO;
import com.centris.form.AttendanceStatusTypeForm;

public interface AttendanceStatusTypeService {
	public String AddDetails(AttendanceStatusTypeForm attendanceStatusTypeForm,
			String usercode);

	public List<AttendanceStatusTypeVO> getAttendanceStatusDetails();

	public boolean deleteAttendanceStatus(String[] attendancestatuscode);

	public List<AttendanceStatusTypeVO> editAttendanceStatus(
			String attendancecode);

	public boolean UpdateAttendanceStatus(
			AttendanceStatusTypePojo attendanceStatusTypePojo);

	public boolean validationStatusType(String statustypename);

	public boolean validationshortname(String shortname);
}
