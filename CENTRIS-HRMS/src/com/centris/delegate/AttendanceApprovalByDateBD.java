package com.centris.delegate;

import java.util.ArrayList;
import com.centris.POJO.AttendenceApprovelPojo;
import com.centris.VO.AttendenceApprovelVo;
import com.centris.form.AttendanceApprovalByDateForm;
import com.centris.service.serviceImpl.AttendanceApprovalByDateServiceImpl;

public class AttendanceApprovalByDateBD {
	

	
public  ArrayList<AttendenceApprovelVo> getEmployees(String managerid){
		
		return new AttendanceApprovalByDateServiceImpl().getEmployees(managerid);
	}

public  ArrayList<AttendenceApprovelVo> getEmployeeAttendance(AttendanceApprovalByDateForm attform,String userId) {
	
	
	return new AttendanceApprovalByDateServiceImpl().getEmployeeAttendance(attform,userId);
}

public  ArrayList<AttendenceApprovelVo> getAttendanceStatusTypeBD() {
	
	return new AttendanceApprovalByDateServiceImpl().getAttendanceStatusTypeService();
}

public  ArrayList<AttendenceApprovelVo> getAttendanceStatus() {
	
	return new AttendanceApprovalByDateServiceImpl().getAttendanceStatus();
}


public  String updateEmpAttendance(AttendenceApprovelPojo att_pojo) {
	
	return new AttendanceApprovalByDateServiceImpl().updateEmpAttendance(att_pojo);
}

public  String updateAllEmpAttendance(AttendenceApprovelPojo att_pojo) {
	
	return new AttendanceApprovalByDateServiceImpl().updateAllEmpAttendance(att_pojo);
}


public  String getSingleEmployee(String empid) {
	
	return new AttendanceApprovalByDateServiceImpl().getSingleEmployee(empid);
}

public  ArrayList<AttendenceApprovelVo> getEmployeeSpecificAttendence(AttendenceApprovelPojo att_pojo) {
	
	
	return new AttendanceApprovalByDateServiceImpl().getEmployeeSpecificAttendence(att_pojo);
}






}
