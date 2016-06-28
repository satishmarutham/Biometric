package com.centris.service;

import java.util.List;

import com.centris.VO.DailyEmployeeAllowanceVO;
import com.centris.form.EmployeeDailyAllowanceForm;

public interface EmployeeDailyAllowanceservice {
	public List<DailyEmployeeAllowanceVO> viewEmployeeDailyAllowance(EmployeeDailyAllowanceForm employeeDailyAllowanceform);
}
