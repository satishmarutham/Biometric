package com.centris.service;

import java.util.ArrayList;

import com.centris.VO.ClaimesByManagerInEmpDashBoardVo;
import com.centris.VO.EmpVO;
import com.centris.VO.EmployeeDashboardVO;
import com.centris.VO.LeaveViewDetailsVo;
import com.centris.VO.TravelBookedDetailsVo;

public interface EmployeeDashboardService {


	ArrayList<EmployeeDashboardVO> getDailyAllowances(String empcode);
	public ArrayList<EmployeeDashboardVO> getLeaveDetails(String empcode);

	EmployeeDashboardVO getPersonalDetails(String empId);

	ArrayList<EmployeeDashboardVO> getAttendanceDetails(String userCode);

	ArrayList<EmployeeDashboardVO> getmoreAllowanceDeatailsService(
			String startdate, String enddate, String userid);

	ArrayList<EmployeeDashboardVO> getmoreAllowanceDeatailsByManagerService(
			String startdate, String enddate, String employeeId,
			String currentuser);
	public ArrayList<ClaimesByManagerInEmpDashBoardVo> moreExpensesDeatailsHomeService(String empId,String month,String year);
	public EmployeeDashboardVO getPendingAttendanceDetails(String userCode);
	
	public ArrayList<TravelBookedDetailsVo> getTravelAllowanceService(String userCode);
	public ArrayList<TravelBookedDetailsVo> getMoreTravelAllowanceService(String userCode, String startdate, String enddate);
	public ArrayList<LeaveViewDetailsVo> getviewLeaveDetails(String userCode);
}
