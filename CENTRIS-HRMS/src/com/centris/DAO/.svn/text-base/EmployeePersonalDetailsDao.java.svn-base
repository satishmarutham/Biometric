package com.centris.DAO;

import java.util.List;
import java.util.Map;

import com.centris.POJO.EmployeePersonalDetailsPojo;
import com.centris.VO.EmployeePersonalDetailsVo;
import com.centris.form.EmployeePersonalDetailsForm;

public interface EmployeePersonalDetailsDao {
	public Map<String, List<EmployeePersonalDetailsVo>> getEmployeePersonalDetails(
			EmployeePersonalDetailsPojo employeeDetails) throws Exception;
	
	public String checkDuplicatePersonalEmailId(String emailId,String empId);
	public String UpdateEmployeeDetails(EmployeePersonalDetailsForm formObj);
}
