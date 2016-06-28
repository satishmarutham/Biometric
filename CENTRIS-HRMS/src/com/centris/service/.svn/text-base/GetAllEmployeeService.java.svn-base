package com.centris.service;

import java.util.ArrayList;
import java.util.List;

import com.centris.VO.AllEmployeeReportVO;
import com.centris.VO.AllEmployeesViewDialogVo;
import com.centris.VO.EmployVO;
import com.centris.VO.GetAllEmployeeVO;

public interface GetAllEmployeeService {
	public ArrayList<GetAllEmployeeVO> getDetails();
	public ArrayList<GetAllEmployeeVO> autosearchemployee(String term);
	public ArrayList<GetAllEmployeeVO> searchemployee(String searchterm);
	public ArrayList<EmployVO> modifyemployee(String empid);
	public List<AllEmployeeReportVO> getallEmployeeDetails(String[] empids);
	public ArrayList<AllEmployeesViewDialogVo> getEmpDetailsForViewService(String empid);
	public ArrayList<GetAllEmployeeVO> getDeactiveEmployeeDetails();
	public int activateEmployee(String empid);
}
