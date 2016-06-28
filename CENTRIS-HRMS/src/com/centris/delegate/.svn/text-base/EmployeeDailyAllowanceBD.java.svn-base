package com.centris.delegate;

import java.util.List;
import java.util.Map;

import com.centris.VO.DailyEmployeeAllowanceVO;
import com.centris.form.EmployeeDailyAllowanceForm;
import com.centris.service.serviceImpl.EmployeeDailyAllowanceServiceImpl;

public class EmployeeDailyAllowanceBD {

	public List<DailyEmployeeAllowanceVO> viewEmployeeDailyAllowance(EmployeeDailyAllowanceForm employeeDailyAllowanceform){
		return new EmployeeDailyAllowanceServiceImpl().viewEmployeeDailyAllowance(employeeDailyAllowanceform);
	}
	
	public Map<String, List<DailyEmployeeAllowanceVO>> viewEmployeeDailyAllowanceByManger(EmployeeDailyAllowanceForm employeeDailyAllowanceform){
		return new EmployeeDailyAllowanceServiceImpl().viewEmployeeDailyAllowanceByManger(employeeDailyAllowanceform);
	}
	
	public boolean chcekRecords(String date){
		return new EmployeeDailyAllowanceServiceImpl().chcekRecords(date);
	}
	
	
	
}
