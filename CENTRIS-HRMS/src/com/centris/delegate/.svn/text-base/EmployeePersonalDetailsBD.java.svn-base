package com.centris.delegate;

import java.util.List;
import java.util.Map;

import com.centris.POJO.EmployeePersonalDetailsPojo;
import com.centris.VO.EmployeePersonalDetailsVo;
import com.centris.form.EmployeePersonalDetailsForm;
import com.centris.service.EmployeePersonalDetailsService;
import com.centris.service.serviceImpl.EmployeePersonalDetailsServiceImpl;

public class EmployeePersonalDetailsBD {

	public Map<String, List<EmployeePersonalDetailsVo>> getEmployeePersonalDetails(
			EmployeePersonalDetailsPojo employeeDetails) {
		EmployeePersonalDetailsService obj = new EmployeePersonalDetailsServiceImpl();

		Map<String, List<EmployeePersonalDetailsVo>> details = obj
				.getEmployeePersonalDetails(employeeDetails);
		return details;
	}

	public String checkDuplicatePersonalEmailId(String emailId, String empId) {
		EmployeePersonalDetailsService obj = new EmployeePersonalDetailsServiceImpl();
		return obj.checkDuplicatePersonalEmailId(emailId, empId);
	}

	public String UpdateEmployeeDetails(EmployeePersonalDetailsForm formObj) {
		EmployeePersonalDetailsService obj = new EmployeePersonalDetailsServiceImpl();
		return obj.UpdateEmployeeDetails(formObj);
	}
}
