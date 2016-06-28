package com.centris.DAO;

import java.util.ArrayList;
import java.util.Map;

import com.centris.POJO.EmployeeAllowanceReportPojo;
import com.centris.VO.EmployeeAllowanceReportVO;

public interface EmployeeAllowanceReportDao {

	Map<String, ArrayList<EmployeeAllowanceReportVO>> getAllowancesByManagerDao(
			EmployeeAllowanceReportPojo employeeAllowanceReportPojo);

	Map<String, ArrayList<EmployeeAllowanceReportVO>> getAllowancesByProjectDao(
			EmployeeAllowanceReportPojo employeeAllowanceReportPojo);

	ArrayList<EmployeeAllowanceReportVO> getAllowancesfordownload(EmployeeAllowanceReportPojo employeeAllowanceReportPojo);

}
