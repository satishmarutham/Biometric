package com.centris.DAO;

import java.util.ArrayList;

import com.centris.VO.AdvanceSalByMgrInEmpDashBoardVo;
import com.centris.VO.ClaimesByManagerInEmpDashBoardVo;
import com.centris.VO.EmpVO;
import com.centris.VO.EmployeeDashboardVO;
import com.centris.VO.LeaveViewDetailsVo;
import com.centris.VO.TravelBookedDetailsVo;

public interface EmployeeDashboardDao {

	

	ArrayList<EmployeeDashboardVO> getDailyAllowances(String empcode);

	EmployeeDashboardVO getPersonalDetails(String empId);

	ArrayList<EmployeeDashboardVO> getLeaveStatus(String userCode);

	ArrayList<EmployeeDashboardVO> getAttendanceDetails(String userCode);

	ArrayList<EmployeeDashboardVO> getmoreAllowanceDeatailsDao(
			String startdate, String enddate, String userid);

	ArrayList<EmployeeDashboardVO> getmoreAllowanceDeatailsByManagerDao(
			String startdate, String enddate, String employeeId,
			String currentuser);
	public ArrayList<ClaimesByManagerInEmpDashBoardVo> moreExpensesDeatailsHomeDao(String empId,String month,String year); 

	public EmployeeDashboardVO getPendingAttendanceDetails(String userCode);
	
	public ArrayList<TravelBookedDetailsVo> getTravelAllowanceDao(String userCode);

	ArrayList<TravelBookedDetailsVo> getMoreTravelAllowanceDao(String userCode,	String startdate, String enddate);
	
	public ArrayList<EmployeeDashboardVO> getLeaveDetails(String empcode);
	public ArrayList<LeaveViewDetailsVo> getviewLeaveDetails(String userCode);
}
