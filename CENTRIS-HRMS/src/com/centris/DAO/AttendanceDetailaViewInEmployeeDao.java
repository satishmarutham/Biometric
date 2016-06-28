package com.centris.DAO;

import java.util.ArrayList;

import com.centris.VO.AttendanceDetailaViewInEmployeeVo;
import com.centris.form.AttendanceDetailaViewInEmployeeForm;

public interface AttendanceDetailaViewInEmployeeDao {
	
	public ArrayList<AttendanceDetailaViewInEmployeeVo> getMoreAttendanceDetailsDao(AttendanceDetailaViewInEmployeeForm attform,String userId);

}
