package com.centris.delegate;

import java.util.ArrayList;

import com.centris.VO.AttendanceDetailaViewInEmployeeVo;
import com.centris.form.AttendanceDetailaViewInEmployeeForm;
import com.centris.service.AttendanceDetailaViewInEmployeeService;
import com.centris.service.serviceImpl.AttendanceDetailaViewInEmployeeServiceImpl;

public class AttendanceDetailaViewInEmployeeBd {
	
	
	public ArrayList<AttendanceDetailaViewInEmployeeVo> getMoreAttendanceDetailsBd(AttendanceDetailaViewInEmployeeForm attform,String userId){
		
		AttendanceDetailaViewInEmployeeService attservice=new AttendanceDetailaViewInEmployeeServiceImpl();
		
		return attservice.getMoreAttendanceDetailsService(attform,userId);
	}

}
