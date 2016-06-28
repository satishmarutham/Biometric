package com.centris.service;

import java.util.ArrayList;

import com.centris.VO.AttendanceDetailaViewInEmployeeVo;
import com.centris.form.AttendanceDetailaViewInEmployeeForm;

public interface AttendanceDetailaViewInEmployeeService {
	
	public ArrayList<AttendanceDetailaViewInEmployeeVo> getMoreAttendanceDetailsService(AttendanceDetailaViewInEmployeeForm attform,String userId);

}
