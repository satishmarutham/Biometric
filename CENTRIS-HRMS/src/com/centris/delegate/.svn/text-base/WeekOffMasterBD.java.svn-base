package com.centris.delegate;

import java.util.ArrayList;
import com.centris.VO.EmpLocationVO;
import com.centris.VO.EmployeeVO;
import com.centris.VO.WeekOffVO;
import com.centris.service.serviceImpl.WeekOffServiceImpl;

public class WeekOffMasterBD {
	 public ArrayList<EmployeeVO>  getAllEmployeesDetails(EmpLocationVO empLocationVO) throws Exception
		{
		 
		 return new WeekOffServiceImpl().getAllEmployeesServiceImpl(empLocationVO); 
		}
	 
	 
	 public String  updateEmployeeWeekOffs(EmployeeVO vo) throws Exception
		{
		 
		 return new WeekOffServiceImpl().updateEmployeeWeekOffs(vo);
		}
	 
	 
	  public WeekOffVO  getEmployeeWeekOffsDetails(String empid) throws Exception
		{
		 
		 return new WeekOffServiceImpl().getEmployeeWeekOffsServiceImpl(empid); 
		}
}
