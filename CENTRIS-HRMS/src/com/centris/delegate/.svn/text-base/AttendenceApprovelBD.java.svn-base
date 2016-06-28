package com.centris.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.AttendenceApprovelPojo;
import com.centris.VO.AttendenceApprovelVo;
import com.centris.VO.ClientVO;
import com.centris.form.AttendenceApprovelForm;
import com.centris.service.serviceImpl.AttendenceApprovelServiceImpl;

public class AttendenceApprovelBD {
	
public  ArrayList<AttendenceApprovelVo> getEmployees(String managerid,String usertype){
		
		return new AttendenceApprovelServiceImpl().getEmployees(managerid,usertype);
	}

public  ArrayList<AttendenceApprovelVo> getEmployeeAttendance(AttendenceApprovelForm attform) {
	
	
	return new AttendenceApprovelServiceImpl().getEmployeeAttendance(attform);
}

public  ArrayList<AttendenceApprovelVo> getAttendanceStatusTypeBD() {
	
	return new AttendenceApprovelServiceImpl().getAttendanceStatusTypeService();
}

public  ArrayList<AttendenceApprovelVo> getAttendanceStatus() {
	
	return new AttendenceApprovelServiceImpl().getAttendanceStatus();
}


public  String updateEmpAttendance(AttendenceApprovelPojo att_pojo) {
	
	return new AttendenceApprovelServiceImpl().updateEmpAttendance(att_pojo);
}

public  String updateAllEmpAttendance(AttendenceApprovelPojo att_pojo) {
	
	return new AttendenceApprovelServiceImpl().updateAllEmpAttendance(att_pojo);
}


public  String getSingleEmployee(String empid) {
	
	return new AttendenceApprovelServiceImpl().getSingleEmployee(empid);
}

public  ArrayList<AttendenceApprovelVo> getEmployeeSpecificAttendence(AttendenceApprovelPojo att_pojo) {
	
	
	return new AttendenceApprovelServiceImpl().getEmployeeSpecificAttendence(att_pojo);
}

public  List<ClientVO> getAllClients() {
	
	
	return new AttendenceApprovelServiceImpl().getAllClients();
}


}
