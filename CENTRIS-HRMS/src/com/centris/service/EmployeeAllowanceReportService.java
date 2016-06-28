package com.centris.service;

import java.util.ArrayList;
import java.util.Map;

import com.centris.POJO.EmployeeAllowanceReportPojo;
import com.centris.VO.EmployeeAllowanceReportVO;

public interface EmployeeAllowanceReportService {

	Map<String, ArrayList<EmployeeAllowanceReportVO>> getAllowances(
			EmployeeAllowanceReportPojo employeeAllowanceReportPojo);

	ArrayList<EmployeeAllowanceReportVO> getAllowancesfordownload(EmployeeAllowanceReportPojo employeeAllowanceReportPojo);

}
