package com.centris.delegate;

import java.util.HashMap;

import com.centris.VO.EmployeeAttendancePostingVo;
import com.centris.form.EmployeeAttendancePostingForm;
import com.centris.service.EmployeeAttendancePostingService;
import com.centris.service.serviceImpl.EmployeeAttendancePostingServiceImpl;

public class EmployeeAttendancePostingBD {

	public EmployeeAttendancePostingVo getEmployeeAttendance(String userCode,String userName,HashMap<String,String> privilegesMap) {
		EmployeeAttendancePostingVo getAttendance = new EmployeeAttendancePostingVo();
		EmployeeAttendancePostingService serviceObj = new EmployeeAttendancePostingServiceImpl();
		getAttendance = serviceObj.getEmployeeAttendance(userCode,userName,privilegesMap);
		return getAttendance;
	}
	public EmployeeAttendancePostingVo updateAttendanceDetails(EmployeeAttendancePostingForm employeeAttendancePostingForm,HashMap<String,String> privilegesMap) {
		EmployeeAttendancePostingService serviceObj = new EmployeeAttendancePostingServiceImpl();
		return serviceObj.updateAttendanceDetails(employeeAttendancePostingForm,privilegesMap);
	}
}
