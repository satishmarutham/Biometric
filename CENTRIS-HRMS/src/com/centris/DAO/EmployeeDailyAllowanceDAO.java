package com.centris.DAO;

import java.util.List;

import com.centris.VO.DailyEmployeeAllowanceVO;
import com.centris.form.EmployeeDailyAllowanceForm;

public interface EmployeeDailyAllowanceDAO {
	public List<DailyEmployeeAllowanceVO> viewEmployeeDailyAllowance(EmployeeDailyAllowanceForm employeeDailyAllowanceform);
}
