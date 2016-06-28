package com.centris.service.serviceImpl;

import java.util.ArrayList;

import com.centris.DAO.DAOIMPL.WeekOffDaoImpl;
import com.centris.VO.EmpLocationVO;
import com.centris.VO.EmployeeVO;
import com.centris.VO.WeekOffVO;

public class WeekOffServiceImpl {

	public WeekOffServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	 public ArrayList<EmployeeVO>  getAllEmployeesServiceImpl(EmpLocationVO empLocationVO) throws Exception
		{
		 
		 return new WeekOffDaoImpl().getAllEmployee(empLocationVO); 
		}
	 
	 
	 public String  updateEmployeeWeekOffs(EmployeeVO vo) throws Exception
		{
		 
		 return new WeekOffDaoImpl().updateDaoImpl(vo);
		}
	 
	 
	  public WeekOffVO  getEmployeeWeekOffsServiceImpl(String empid) throws Exception
		{
		 
		 return new WeekOffDaoImpl().getEmployeeWeekOffsDaoImpl(empid); 
		}
}
