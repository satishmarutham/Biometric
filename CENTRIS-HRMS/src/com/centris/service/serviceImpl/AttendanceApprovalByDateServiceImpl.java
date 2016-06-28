package com.centris.service.serviceImpl;

import java.util.ArrayList;

import com.centris.DAO.DAOIMPL.AttendanceApprovalByDateDaoImpl;
import com.centris.POJO.AttendenceApprovelPojo;
import com.centris.VO.AttendenceApprovelVo;
import com.centris.form.AttendanceApprovalByDateForm;
import com.centris.util.HelperClass;

public class AttendanceApprovalByDateServiceImpl {
	
	public  ArrayList<AttendenceApprovelVo> getEmployees(String managerid){
		
		return new AttendanceApprovalByDateDaoImpl().getEmployees(managerid);
	}
	
	public  ArrayList<AttendenceApprovelVo> getEmployeeAttendance(AttendanceApprovalByDateForm attform,String userId) {
		
		AttendenceApprovelPojo att_pojo=new AttendenceApprovelPojo();
		
	/*	int totalDaysInMonth = HelperClass.getDaysByMonthAndYear(Integer.parseInt(attform.getMonth()), Integer.parseInt(attform.getYear()));
		
		att_pojo.setEmployeeid(attform.getEmplyeeid());
		att_pojo.setStartdate(attform.getYear()+"-"+attform.getMonth()+"-"+"01");
		att_pojo.setEnddate(attform.getYear()+"-"+attform.getMonth()+"-"+totalDaysInMonth);*/
		
		att_pojo.setEmployeeid(attform.getEmployeename());
		att_pojo.setStartdate(HelperClass.convertUIToDatabase(attform.getStartdate()));
		att_pojo.setEnddate(HelperClass.convertUIToDatabase(attform.getEnddate()));
		att_pojo.setUsercode(userId);
		
		
		
		return new AttendanceApprovalByDateDaoImpl().getEmployeeAttendance(att_pojo);
	}
	
	public  ArrayList<AttendenceApprovelVo> getEmployeeSpecificAttendence(AttendenceApprovelPojo att_pojo) {
		
		return new AttendanceApprovalByDateDaoImpl().getEmployeeSpecificAttendence(att_pojo);
	}
	
	
	
	public  ArrayList<AttendenceApprovelVo> getAttendanceStatusTypeService() {
		
		
		return new AttendanceApprovalByDateDaoImpl().getAttendanceStatusTypeDao();
	}
	
	public  ArrayList<AttendenceApprovelVo> getAttendanceStatus() {
		
		
		return new AttendanceApprovalByDateDaoImpl().getAttendanceStatus();
	}
	
	public  String updateEmpAttendance(AttendenceApprovelPojo att_pojo) {
		
		
		String total_time=HelperClass.getTimeDifferenceinTimeFormatForAttendance(att_pojo.getIntime(),att_pojo.getOuttime());
		
		att_pojo.setTotaltime(total_time);
		
		return new AttendanceApprovalByDateDaoImpl().updateEmpAttendance(att_pojo);
	}
	
public  String updateAllEmpAttendance(AttendenceApprovelPojo att_pojo) {
		
		
		return new AttendanceApprovalByDateDaoImpl().updateAllEmpAttendance(att_pojo);
	}
	
	
	public  String getSingleEmployee(String empid) {
		
		return new AttendanceApprovalByDateDaoImpl().getSingleEmployee(empid);
	}

}
