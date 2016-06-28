package com.centris.service.serviceImpl;

import java.util.ArrayList;

import com.centris.DAO.EmployeeDashboardDao;
import com.centris.DAO.DAOIMPL.EmployeeDashboardDaoImpl;
import com.centris.VO.ClaimesByManagerInEmpDashBoardVo;
import com.centris.VO.EmployeeDashboardVO;
import com.centris.VO.LeaveViewDetailsVo;
import com.centris.VO.TravelBookedDetailsVo;
import com.centris.service.EmployeeDashboardService;



public class EmployeeDashboardServiceImpl implements EmployeeDashboardService {

	public ArrayList<EmployeeDashboardVO> getDailyAllowances(String empcode) {
		
	 EmployeeDashboardDao employeeDashboardDao=new EmployeeDashboardDaoImpl();
		
		return employeeDashboardDao.getDailyAllowances(empcode);
	}


	public EmployeeDashboardVO getPersonalDetails(String empId) {
	
		EmployeeDashboardDao employeeDashboardDao=new EmployeeDashboardDaoImpl();
			
			return employeeDashboardDao.getPersonalDetails(empId);
	}


	
	public ArrayList<EmployeeDashboardVO> getAttendanceDetails(String userCode) {
	
		EmployeeDashboardDao employeeDashboardDao=new EmployeeDashboardDaoImpl();
		
		 return employeeDashboardDao.getAttendanceDetails(userCode);
	
	}
	
	public EmployeeDashboardVO getPendingAttendanceDetails(String userCode) {
		
		EmployeeDashboardDao employeeDashboardDao=new EmployeeDashboardDaoImpl();
		
		 return employeeDashboardDao.getPendingAttendanceDetails(userCode);
	
	}
	
	
	


	public ArrayList<EmployeeDashboardVO> getmoreAllowanceDeatailsService(
			String startdate, String enddate, String userid) {

		EmployeeDashboardDao employeeDashboardDao=new EmployeeDashboardDaoImpl();
		
		 return employeeDashboardDao.getmoreAllowanceDeatailsDao(startdate,enddate,userid);
	}


	@Override
	public ArrayList<EmployeeDashboardVO> getmoreAllowanceDeatailsByManagerService(
			String startdate, String enddate, String employeeId,
			String currentuser) {
		
		EmployeeDashboardDao employeeDashboardDao=new EmployeeDashboardDaoImpl();
		
		 return employeeDashboardDao.getmoreAllowanceDeatailsByManagerDao(startdate,enddate,employeeId,currentuser);
	}
	
	public ArrayList<ClaimesByManagerInEmpDashBoardVo> moreExpensesDeatailsHomeService(String empId,String month,String year) {
		
		EmployeeDashboardDao employeeDashboardDao=new EmployeeDashboardDaoImpl();
		
		 return employeeDashboardDao.moreExpensesDeatailsHomeDao(empId,month,year);

	}
	
  public ArrayList<TravelBookedDetailsVo> getTravelAllowanceService(String userCode) {
	
	EmployeeDashboardDao employeeDashboardDao=new EmployeeDashboardDaoImpl();
		
		return employeeDashboardDao.getTravelAllowanceDao(userCode);
	}

	
	public ArrayList<TravelBookedDetailsVo> getMoreTravelAllowanceService(String userCode, String startdate, String enddate) {
	
		EmployeeDashboardDao employeeDashboardDao=new EmployeeDashboardDaoImpl();
		
		return employeeDashboardDao.getMoreTravelAllowanceDao(userCode,startdate,enddate);
	}


	@Override
	public ArrayList<EmployeeDashboardVO> getLeaveDetails(String empcode) {
		// TODO Auto-generated method stub
		EmployeeDashboardDao employeeDashboardDao=new EmployeeDashboardDaoImpl();
		
		return employeeDashboardDao.getLeaveDetails(empcode);
	}


	@Override
	public ArrayList<LeaveViewDetailsVo> getviewLeaveDetails(String userCode) {
		// TODO Auto-generated method stub
		
		EmployeeDashboardDao employeeDashboardDao=new EmployeeDashboardDaoImpl();
		
		return employeeDashboardDao.getviewLeaveDetails(userCode);
	}
	

}
