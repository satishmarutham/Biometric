package com.centris.delegate;

import java.util.ArrayList;
import java.util.Map;

import com.centris.POJO.EmployeeAllowanceReportPojo;
import com.centris.VO.EmployeeAllowanceReportVO;
import com.centris.service.EmployeeAllowanceReportService;
import com.centris.service.serviceImpl.EmployeeAllowanceReportServiceImpl;

public class EmployeeAllowanceReportBD {

	public Map<String, ArrayList<EmployeeAllowanceReportVO>> getAllowances(
			EmployeeAllowanceReportPojo employeeAllowanceReportPojo) {

 		EmployeeAllowanceReportService employeeAllowanceReportService=new EmployeeAllowanceReportServiceImpl();
		 
		return employeeAllowanceReportService.getAllowances(employeeAllowanceReportPojo);
	}

	public ArrayList<EmployeeAllowanceReportVO> getAllowancesfordownload(EmployeeAllowanceReportPojo employeeAllowanceReportPojo) {


		EmployeeAllowanceReportService employeeAllowanceReportService=new EmployeeAllowanceReportServiceImpl();
		 
		return employeeAllowanceReportService.getAllowancesfordownload(employeeAllowanceReportPojo);
	}

}
