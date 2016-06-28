package com.centris.delegate;

import java.util.ArrayList;

import com.centris.VO.AttendanceTimeSheetReportVo;
import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.service.TimesheetReportService;
import com.centris.service.serviceImpl.AttendanceTimeSheetReportServiceImpl;
import com.centris.service.serviceImpl.TimeSheetReportServiceImpl;

public class TimeSheetReportBD {
	
	public  ArrayList<String> getAccYear(){
			
			return new TimeSheetReportServiceImpl().getAccYear();
		}
	public ArrayList<ManagerFilterVO> getManagersByDept(String depts,String userId,String userType) {
		
		TimesheetReportService timesheetReportservice =new TimeSheetReportServiceImpl();
	
		return timesheetReportservice.getManagersByDept(depts,userId,userType);
	}
	
	public ArrayList<EmployeeFilterVO> getEmployeesByMang(String manager) {
		
		TimesheetReportService timesheetReportservice =new TimeSheetReportServiceImpl();
	
		return timesheetReportservice.getEmployeesByMang(manager);
	}

	public  ArrayList<AttendanceTimeSheetReportVo> getTimesheetReport(String[] empArray,String month,String year) {
		
		return new AttendanceTimeSheetReportServiceImpl().getTimesheetReport(empArray,month,year);
	}
}
