package com.centris.service;

import java.util.ArrayList;

import com.centris.VO.AdvanceSalByMgrInEmpDashBoardVo;
import com.centris.VO.ClaimesByManagerInEmpDashBoardVo;
import com.centris.VO.EmpDashBoardInManagerVO;
import com.centris.VO.EmpVO;
import com.centris.VO.EmployeeDashboardVO;
import com.centris.VO.TravelBookedDetailsVo;

public interface EmpDashBoardInManagerService {
	
	public EmpDashBoardInManagerVO getPersonalDetails(String empId);
	public EmpDashBoardInManagerVO getAttendanceDetails(String empId);
	public ArrayList<EmpDashBoardInManagerVO> getLeaveDetails(String empId, String currentuser);
	public EmpDashBoardInManagerVO getNotAprrovedAttendance(String empId);
	public ArrayList<EmpVO> getSearchEmployee(String currentuser, String searchTerm);
	public ArrayList<EmpVO> getAllEmployeesUnderManager(String currentuser);
	public ArrayList<EmployeeDashboardVO> getManagerDailyAllowances(String empId, String currentuser);
	public ClaimesByManagerInEmpDashBoardVo getClaimsByManagerService(String empId);
	public  ArrayList<AdvanceSalByMgrInEmpDashBoardVo> getAdvanceSalDetailsSerivce(String empId);
	public  ArrayList<AdvanceSalByMgrInEmpDashBoardVo> getAdvanceSalCompleteDetailsService(String empId,String month,String year);
	public ArrayList<TravelBookedDetailsVo> getTravelAllowanceService(String empId, String userCode);
	public ArrayList<TravelBookedDetailsVo> getMoreTravelAllowanceBD(String employeeId,String currentuser, String startdate, String enddate);
	public ArrayList<ClaimesByManagerInEmpDashBoardVo> moreExpensesDeatailsHomeBD(
			String empid, String month, String year, String currentuser);
	
}
