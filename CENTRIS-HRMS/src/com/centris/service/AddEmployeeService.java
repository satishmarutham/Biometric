package com.centris.service;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.centris.VO.RemoveEmployeeVo;
import com.centris.form.AddEmployeeForm;

/**
 * @author seshuma
 *
 */
public interface AddEmployeeService {
	
	public String addEmployee(AddEmployeeForm addEmployee,String username  );
	public boolean checkEmail(String email);
	public boolean checkEmpId(String empid);
	public ArrayList<RemoveEmployeeVo> getAllEmployeesServiceImpl(String searchemp,String maxrows,String groupcode);
	public String removeEmployee(String empid,String modifiedby,Timestamp modifieddate);

}
