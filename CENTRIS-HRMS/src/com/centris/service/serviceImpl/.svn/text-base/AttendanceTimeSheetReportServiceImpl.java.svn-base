package com.centris.service.serviceImpl;

import java.sql.Connection;
import java.util.ArrayList;
import org.json.JSONArray;
import com.centris.DAO.DBService;
import com.centris.DAO.DAOIMPL.TimeSheetReportDaoImpl;
import com.centris.POJO.EmployeeReportPojo;
import com.centris.VO.AttendanceTimeSheetReportVo;

public class AttendanceTimeSheetReportServiceImpl extends DBService{
	
	
	
	
public  ArrayList<AttendanceTimeSheetReportVo> getTimesheetReport(String[] empArray,String month,String year) {
		
		
	Connection connection=null;
	ArrayList<AttendanceTimeSheetReportVo> timesheet_list=null;
	
	try {
		connection=getConnection();
		ArrayList<EmployeeReportPojo> emp_list=new TimeSheetReportDaoImpl().getEmployees(empArray,connection);
		
		 timesheet_list=new  TimeSheetReportDaoImpl().getTimesheetReport(emp_list, month, year, connection);
		
		JSONArray array=new JSONArray();
		array.put(emp_list);
		
		System.out.println("employee list -- "+array);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
		
		return timesheet_list;
	}
}
