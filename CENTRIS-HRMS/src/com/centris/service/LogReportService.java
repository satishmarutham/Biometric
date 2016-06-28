package com.centris.service;

import java.util.List;

import com.centris.VO.EmployeeVO;
import com.centris.VO.LogReportVO;
import com.centris.form.LogReportForm;

public interface LogReportService {
	public List<EmployeeVO> getEmployeeByDesignation(String designationId);
	public List<LogReportVO> getLogReport(LogReportForm logReportForm);
	public List<EmployeeVO> getMangerInfo();
	public List<EmployeeVO> getEmpDetailsByLocation(LogReportForm logReportForm);
}
