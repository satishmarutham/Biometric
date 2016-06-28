package com.centris.service.serviceImpl;

import java.util.List;
import java.util.Map;

import com.centris.DAO.DAOIMPL.EmployeeDailyAllowanceDAOImpl;
import com.centris.VO.DailyEmployeeAllowanceVO;
import com.centris.form.EmployeeDailyAllowanceForm;
import com.centris.service.EmployeeDailyAllowanceservice;

public class EmployeeDailyAllowanceServiceImpl implements EmployeeDailyAllowanceservice{
	public List<DailyEmployeeAllowanceVO> viewEmployeeDailyAllowance(EmployeeDailyAllowanceForm employeeDailyAllowanceform){
		return new EmployeeDailyAllowanceDAOImpl().viewEmployeeDailyAllowance(employeeDailyAllowanceform);
	}
	
	public Map<String, List<DailyEmployeeAllowanceVO>> viewEmployeeDailyAllowanceByManger(EmployeeDailyAllowanceForm employeeDailyAllowanceform){
		return new EmployeeDailyAllowanceDAOImpl().viewEmployeeDailyAllowanceByManger(employeeDailyAllowanceform);
	}
	
	public boolean chcekRecords(String date){
		return new EmployeeDailyAllowanceDAOImpl().chcekRecords(date);
	}
	
	
}
