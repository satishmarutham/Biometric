package com.centris.service.serviceImpl;

import java.util.ArrayList;

import com.centris.DAO.TimesheetReportDao;
import com.centris.DAO.DAOIMPL.TimeSheetReportDaoImpl;
import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.service.TimesheetReportService;

public class TimeSheetReportServiceImpl implements TimesheetReportService{
	
	public  ArrayList<String> getAccYear(){
		
		return new TimeSheetReportDaoImpl().getAccYear();
	}
	
public ArrayList<ManagerFilterVO> getManagersByDept(String depts,String userId,String userType) {
		
		TimesheetReportDao timesheetReportDAO =new TimeSheetReportDaoImpl();
	
		return timesheetReportDAO.getManagersByDept(depts,userId,userType);
	}

	
	public ArrayList<EmployeeFilterVO> getEmployeesByMang(String manager) {
		
		TimesheetReportDao timesheetReportDAO =new TimeSheetReportDaoImpl();
		
		return timesheetReportDAO.getEmployeesByMang(manager);
	}

}
