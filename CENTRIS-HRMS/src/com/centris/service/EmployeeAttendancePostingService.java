package com.centris.service;

import java.util.HashMap;

import com.centris.VO.EmployeeAttendancePostingVo;
import com.centris.form.EmployeeAttendancePostingForm;

public interface EmployeeAttendancePostingService {

	public EmployeeAttendancePostingVo getEmployeeAttendance(String userCode,String userName,HashMap<String,String> privilegesMap);
	public EmployeeAttendancePostingVo updateAttendanceDetails(EmployeeAttendancePostingForm employeeAttendancePostingForm,HashMap<String,String> privilegesMap);
}
