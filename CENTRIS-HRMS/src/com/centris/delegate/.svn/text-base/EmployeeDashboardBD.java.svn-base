package com.centris.delegate;

import java.util.ArrayList;

import com.centris.DAO.EmployeeDashboardDao;
import com.centris.DAO.DAOIMPL.EmployeeDashboardDaoImpl;
import com.centris.VO.ClaimesByManagerInEmpDashBoardVo;
import com.centris.VO.EmpVO;
import com.centris.VO.EmployeeDashboardVO;
import com.centris.VO.LeaveViewDetailsVo;
import com.centris.VO.TravelBookedDetailsVo;
import com.centris.service.EmployeeDashboardService;
import com.centris.service.serviceImpl.EmployeeDashboardServiceImpl;

public class EmployeeDashboardBD {


	public ArrayList<EmployeeDashboardVO> getDailyAllowances(String empcode) {

		EmployeeDashboardService employeeDashboardService=new EmployeeDashboardServiceImpl();
		
		return employeeDashboardService.getDailyAllowances(empcode);
	}
	
	public ArrayList<EmployeeDashboardVO> getLeaveDetails(String empcode) {

		EmployeeDashboardService employeeDashboardService=new EmployeeDashboardServiceImpl();
		
		return employeeDashboardService.getLeaveDetails(empcode);
	}

	public EmployeeDashboardVO getPersonalDetails(String empId) {

		EmployeeDashboardService employeeDashboardService=new EmployeeDashboardServiceImpl();
		
		return employeeDashboardService.getPersonalDetails(empId);
	}
	

	public  ArrayList<EmployeeDashboardVO> getAttendanceDetails(String userCode) {
	
		  EmployeeDashboardService employeeDashboardService=new EmployeeDashboardServiceImpl();
			
		return employeeDashboardService.getAttendanceDetails(userCode);
	}
	
	public EmployeeDashboardVO getPendingAttendanceDetails(String userCode){
		
		EmployeeDashboardService employeeDashboardService=new EmployeeDashboardServiceImpl();
		
		return employeeDashboardService.getPendingAttendanceDetails(userCode);
	}

	public ArrayList<EmployeeDashboardVO> getmoreAllowanceDeatailsBD(String startdate, String enddate, String userid) {
	
		EmployeeDashboardService employeeDashboardService=new EmployeeDashboardServiceImpl();
		
		return employeeDashboardService.getmoreAllowanceDeatailsService(startdate,enddate,userid);
	}



	public ArrayList<EmployeeDashboardVO> getmoreAllowanceDeatailsByManagerBD(
			String startdate, String enddate, String employeeId,
			String currentuser) {

		EmployeeDashboardService employeeDashboardService=new EmployeeDashboardServiceImpl();
		
		return employeeDashboardService.getmoreAllowanceDeatailsByManagerService(startdate,enddate,employeeId,currentuser);
	}

	
public ArrayList<ClaimesByManagerInEmpDashBoardVo> moreExpensesDeatailsHomeBD(String empId,String month,String year) {
		
	EmployeeDashboardService employeeDashboardService=new EmployeeDashboardServiceImpl();
		
		 return employeeDashboardService.moreExpensesDeatailsHomeService(empId, month, year);

	}


 public ArrayList<TravelBookedDetailsVo> getTravelAllowanceBD(String userCode) {
	
	EmployeeDashboardService employeeDashboardService=new EmployeeDashboardServiceImpl();
	
	return employeeDashboardService.getTravelAllowanceService(userCode);
}

 public ArrayList<TravelBookedDetailsVo> getMoreTravelAllowanceBD(String userCode, String startdate,String enddate) {
	
	EmployeeDashboardService employeeDashboardService=new EmployeeDashboardServiceImpl();
	
	return employeeDashboardService.getMoreTravelAllowanceService(userCode,startdate,enddate);
}
 
 
 public ArrayList<LeaveViewDetailsVo> getviewLeaveDetails(String userCode) {
		
	EmployeeDashboardService employeeDashboardService=new EmployeeDashboardServiceImpl();
	
	return employeeDashboardService.getviewLeaveDetails(userCode);
}

	
}
