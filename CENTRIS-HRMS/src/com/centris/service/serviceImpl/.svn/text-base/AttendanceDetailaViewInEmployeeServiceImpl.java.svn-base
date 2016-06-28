package com.centris.service.serviceImpl;

import java.util.ArrayList;

import com.centris.DAO.AttendanceDetailaViewInEmployeeDao;
import com.centris.DAO.DAOIMPL.AttendanceDetailaViewInEmployeeDaoImpl;
import com.centris.VO.AttendanceDetailaViewInEmployeeVo;
import com.centris.form.AttendanceDetailaViewInEmployeeForm;
import com.centris.service.AttendanceDetailaViewInEmployeeService;

public class AttendanceDetailaViewInEmployeeServiceImpl implements AttendanceDetailaViewInEmployeeService{

	
	public ArrayList<AttendanceDetailaViewInEmployeeVo> getMoreAttendanceDetailsService(AttendanceDetailaViewInEmployeeForm attform,String userId){
		
		AttendanceDetailaViewInEmployeeDao attservice=new AttendanceDetailaViewInEmployeeDaoImpl();
		
		return attservice.getMoreAttendanceDetailsDao(attform,userId);
	}
	
	
}
