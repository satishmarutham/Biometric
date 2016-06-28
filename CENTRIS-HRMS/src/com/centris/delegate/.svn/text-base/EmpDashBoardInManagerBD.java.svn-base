package com.centris.delegate;

import java.util.ArrayList;

import com.centris.VO.AdvanceSalByMgrInEmpDashBoardVo;
import com.centris.VO.ClaimesByManagerInEmpDashBoardVo;
import com.centris.VO.EmpDashBoardInManagerVO;
import com.centris.VO.EmpVO;
import com.centris.VO.EmployeeDashboardVO;
import com.centris.VO.TravelBookedDetailsVo;
import com.centris.service.EmpDashBoardInManagerService;
import com.centris.service.serviceImpl.EmpDashBoardInManagerServiceImpl;

public class EmpDashBoardInManagerBD {
	
	
	EmpDashBoardInManagerService employeeDashboardService=new EmpDashBoardInManagerServiceImpl();
	
	public EmpDashBoardInManagerVO getPersonalDetails(String empId) {

		return employeeDashboardService.getPersonalDetails(empId);
	}
	
	public EmpDashBoardInManagerVO getAttendanceDetails(String empId) {

		return employeeDashboardService.getAttendanceDetails(empId);
	}
	
	public ArrayList<EmpDashBoardInManagerVO> getLeaveDetails(String empId, String currentuser) {

		return employeeDashboardService.getLeaveDetails(empId,currentuser);
	}

	public EmpDashBoardInManagerVO getNotAprrovedAttendance(String empId) {

		return employeeDashboardService.getNotAprrovedAttendance(empId);
	}
	
	public ArrayList<EmpVO> getSearchEmployee(String currentuser, String searchTerm) {
		
		return employeeDashboardService.getSearchEmployee(currentuser,searchTerm);
	}
	
	public ArrayList<EmpVO> getAllEmployeesUnderManager(String currentuser) {
		
		return employeeDashboardService.getAllEmployeesUnderManager(currentuser);
	}

	public ArrayList<EmployeeDashboardVO> getManagerDailyAllowances(String empId, String currentuser) {
		
		return employeeDashboardService.getManagerDailyAllowances(empId,currentuser);
	}
	
	public ClaimesByManagerInEmpDashBoardVo getClaimsByManagerBD(String empId){
		
		return employeeDashboardService.getClaimsByManagerService(empId);
	}

	public  ArrayList<AdvanceSalByMgrInEmpDashBoardVo> getAdvanceSalDetailsBD(String empId){
		
		return employeeDashboardService.getAdvanceSalDetailsSerivce(empId);
		
	}
	
	public  ArrayList<AdvanceSalByMgrInEmpDashBoardVo> getAdvanceSalCompleteDetailsBD(String empId,String month,String year){
	
		return employeeDashboardService.getAdvanceSalCompleteDetailsService(empId, month, year);
	}

	public ArrayList<TravelBookedDetailsVo> getTravelAllowanceBD(String empId, String userCode) {
		
		
		return employeeDashboardService.getTravelAllowanceService(empId,userCode);
	}

	public ArrayList<TravelBookedDetailsVo> getMoreTravelAllowanceBD(String employeeId,String currentuser, String startdate, String enddate) {
	
		return employeeDashboardService.getMoreTravelAllowanceBD(employeeId,currentuser,startdate,enddate);
	}

	public ArrayList<ClaimesByManagerInEmpDashBoardVo> moreExpensesDeatailsHomeBD(
			String empid, String month, String year, String currentuser) {

		return employeeDashboardService.moreExpensesDeatailsHomeBD(empid,month,year,currentuser);
	}

	
}
