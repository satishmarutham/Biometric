package com.centris.service;

import java.util.ArrayList;
import java.util.List;

import com.centris.VO.EmployVO;
import com.centris.VO.EmployeeDeleteAuditVo;
import com.centris.form.EmployeeForm;

public interface EmployeeService {
	public String registerEmployee(EmployeeForm employeeForm);
	public String amendEmployee(EmployeeForm employeeForm);
	public List<EmployVO>  searchEmployee(String empId);
	public List<EmployVO> getEmpIdNameBySerachTerm(String maxRows,String name) ;
	public String checkDuplicateEmailId(String emailId,String empId);
	public String checkPassportNoUnique(String passportNo,String empId);
	public String checkAccountNoUnique(String passportNo,String empId);
	public String checkVoterIdUnique(String voterId,String empId);
	public String checkPanCardUnique(String panCardNo,String empId);
	public String checkAddharCardUnique(String addharCardNo,String empId);
	public String checkDLNoUnique(String dlNo, String empId) ;
	public List<EmployeeDeleteAuditVo> getDeleteEmployeeAudit(String userCode);
	public  ArrayList<String>  getEmployeePermissionsService(String userCode);
	public String blockUserDetailsService(String userCode,String role);
	public String getBioIdService();
}
