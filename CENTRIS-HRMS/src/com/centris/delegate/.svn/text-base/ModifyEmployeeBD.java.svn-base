package com.centris.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.DAO.DAOIMPL.ModifyEmployeeDaoImpl;
import com.centris.VO.EmpVO;
import com.centris.form.AddEmployeeForm;
import com.centris.service.serviceImpl.ModifyEmployeeServiceImpl;

public class ModifyEmployeeBD {
	
	public ArrayList<EmpVO> getModifyEmployeeList(String empname){
		
		
		return new ModifyEmployeeServiceImpl().getModifyEmployeeList(empname);
		
	}
	
	public String ModifyEmployee(AddEmployeeForm modifyEmpForm,String username){
		
		return new ModifyEmployeeServiceImpl().ModifyEmployee(modifyEmpForm,username);
	}
	
	public boolean checkEmail(String email,String empid){
		
		return new ModifyEmployeeServiceImpl().checkEmail(email,empid);
	}
public boolean checkEmpregNo(String empregno,String empid){
		
		return new ModifyEmployeeServiceImpl().checkEmpregNo(empregno,empid);
	}
	
	
	public List<EmpVO> getModifyEmpDetailsForAllEmp(String empid) {
		
		return new ModifyEmployeeServiceImpl().getModifyEmpDetailsForAllEmp(empid);
	}
	
	public ArrayList<EmpVO> getSearchEmployees(String searchname,String maxlimit,String groupid){
		
		return new ModifyEmployeeServiceImpl().getSearchEmployees(searchname, maxlimit,groupid);
	}
	

}
