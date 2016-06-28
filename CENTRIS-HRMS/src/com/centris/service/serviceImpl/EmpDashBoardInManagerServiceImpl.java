package com.centris.service.serviceImpl;

import java.util.ArrayList;

import com.centris.DAO.EmpDashBoardInManagerDao;
import com.centris.DAO.EmployeeDashboardDao;
import com.centris.DAO.DAOIMPL.EmpDashBoardInManagerDaoImpl;
import com.centris.DAO.DAOIMPL.EmployeeDashboardDaoImpl;
import com.centris.VO.AdvanceSalByMgrInEmpDashBoardVo;
import com.centris.VO.ClaimesByManagerInEmpDashBoardVo;
import com.centris.VO.EmpDashBoardInManagerVO;
import com.centris.VO.EmpVO;
import com.centris.VO.EmployeeDashboardVO;
import com.centris.VO.TravelBookedDetailsVo;
import com.centris.service.EmpDashBoardInManagerService;

public class EmpDashBoardInManagerServiceImpl implements EmpDashBoardInManagerService{
	
	EmpDashBoardInManagerDao employeeDashboardDao=new EmpDashBoardInManagerDaoImpl();
	
	public EmpDashBoardInManagerVO getPersonalDetails(String empId) {
		
			return employeeDashboardDao.getPersonalDetails(empId);
	}

	@Override
	public EmpDashBoardInManagerVO getAttendanceDetails(String empId) {
		// TODO Auto-generated method stub
		 return employeeDashboardDao.getAttendanceDetails(empId);
	}

	@Override
	public ArrayList<EmpDashBoardInManagerVO> getLeaveDetails(String empId,String currentuser) {
		// TODO Auto-generated method stub
		return employeeDashboardDao.getLeaveDetails(empId, currentuser);
	}

	@Override
	public EmpDashBoardInManagerVO getNotAprrovedAttendance(String empId) {
		// TODO Auto-generated method stub
		return employeeDashboardDao.getNotAprrovedAttendance(empId);
	}

	@Override
	public ArrayList<EmpVO> getSearchEmployee(String currentuser, String searchTerm) {
		
		return employeeDashboardDao.getSearchEmployee(currentuser,searchTerm);
	}
	

	public ArrayList<EmpVO> getAllEmployeesUnderManager(String currentuser) {

		return employeeDashboardDao.getAllEmployeesUnderManager(currentuser);
	}

	
	public ArrayList<EmployeeDashboardVO> getManagerDailyAllowances(String empId, String currentuser) {
		
		
		return employeeDashboardDao.getManagerDailyAllowances(empId,currentuser);
	}
	
	public ClaimesByManagerInEmpDashBoardVo getClaimsByManagerService(String empId){
		
		return employeeDashboardDao.getClaimsByManagerDao(empId);
	}
	
	public  ArrayList<AdvanceSalByMgrInEmpDashBoardVo> getAdvanceSalDetailsSerivce(String empId){
		
		return employeeDashboardDao.getAdvanceSalDetailsDao(empId);
	}
	
	public  ArrayList<AdvanceSalByMgrInEmpDashBoardVo> getAdvanceSalCompleteDetailsService(String empId,String month,String year){
		
		return employeeDashboardDao.getAdvanceSalCompleteDetailsDao(empId, month, year);
	}

	
	public ArrayList<TravelBookedDetailsVo> getTravelAllowanceService(String empId,String userCode) {
	
		
		return employeeDashboardDao.getTravelAllowanceDao(empId,userCode);
	}


	public ArrayList<TravelBookedDetailsVo> getMoreTravelAllowanceBD(String employeeId, String currentuser, String startdate,String enddate) {
	
		return employeeDashboardDao.getMoreTravelAllowanceBD(employeeId,currentuser,startdate,enddate);
	}


	public ArrayList<ClaimesByManagerInEmpDashBoardVo> moreExpensesDeatailsHomeBD(
			String empid, String month, String year, String currentuser) {
	
		
		return employeeDashboardDao.moreExpensesDeatailsHomeBD(empid,month,year,currentuser);
	}


	
}
