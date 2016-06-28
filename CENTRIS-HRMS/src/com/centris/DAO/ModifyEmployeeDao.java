package com.centris.DAO;

import java.util.ArrayList;
import java.util.List;
import com.centris.POJO.AddEmployeePojo;
import com.centris.VO.EmpVO;


/**
 * @author seshuma
 *
 */

public interface ModifyEmployeeDao {
	
	public ArrayList<EmpVO> getModifyEmployeeList(String empname);
	public String updateEmployee(AddEmployeePojo emppojo);
	public boolean checkEmail(String email,String empid);
	public List<EmpVO> getModifyEmpDetailsForAllEmp(String empid);
	
	

}
