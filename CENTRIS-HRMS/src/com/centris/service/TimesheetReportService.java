package com.centris.service;

import java.util.ArrayList;

import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.ManagerFilterVO;

public interface TimesheetReportService {
	
	public ArrayList<ManagerFilterVO> getManagersByDept(String depts,String userId,String userType);
	public ArrayList<EmployeeFilterVO> getEmployeesByMang(String manager);

}
