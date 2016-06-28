package com.centris.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.VO.CheckEmployeeDeletionVO;
import com.centris.VO.EmployVO;
import com.centris.VO.EmployeeDeleteAuditVo;
import com.centris.form.EmployeeForm;
import com.centris.service.EmployeeService;
import com.centris.service.serviceImpl.EmployeeServiceImpl;

public class EmployeeBD {
	public String registerEmployee(EmployeeForm employeeForm) {
		return new EmployeeServiceImpl().registerEmployee(employeeForm);
	}
	public String amendEmployee(EmployeeForm employeeForm) {
		return new EmployeeServiceImpl().amendEmployee(employeeForm);
	}
	public List<EmployVO>  searchEmployee(String empId) {
		return new EmployeeServiceImpl().searchEmployee(empId);
	}
	public List<EmployVO> getEmpIdNameBySerachTerm(String maxRows,String name) {
		return new EmployeeServiceImpl().getEmpIdNameBySerachTerm(maxRows,name);
	}
	public String checkDuplicateEmailId(String emailId,String empId) {
		return new EmployeeServiceImpl().checkDuplicateEmailId(emailId,empId);
	}
	
	public String checkPassportNoUnique(String passportNo, String empId) {
		return new EmployeeServiceImpl().checkPassportNoUnique(passportNo,empId);
	}
	public String checkAccountNoUnique(String accountNo, String empId) {
		return new EmployeeServiceImpl().checkAccountNoUnique(accountNo,empId);
	}
	
	
	public String checkVoterIdUnique(String voterId, String empId) {
		return new EmployeeServiceImpl().checkVoterIdUnique(voterId,empId);
	}
	public String checkPanCardUnique(String panCardNo, String empId) {
		return new EmployeeServiceImpl().checkPanCardUnique(panCardNo,empId);
	}
	public String checkAddharCardUnique(String addharCardNo, String empId) {
		return new EmployeeServiceImpl().checkAddharCardUnique(addharCardNo,empId);
	}
	public String checkDLNoUnique(String dlNo, String empId) {
		return new EmployeeServiceImpl().checkDLNoUnique(dlNo,empId);
	}
	
	public String checkDuplicateBiometricId(String bioId,String empId) {
		return new EmployeeServiceImpl().checkDuplicateBiometricId(bioId,empId);
	}
	

	public String deleteEmployee(String empId, String usercode){
		
		return new EmployeeServiceImpl().deleteEmployee(empId,usercode);
	}
	public CheckEmployeeDeletionVO checkEmployeeMap(String empCode) {
	
		return new EmployeeServiceImpl().checkEmployeeMap(empCode);
	}
	public List<EmployeeDeleteAuditVo> getDeleteEmployeeAudit(String userCode){
		return new EmployeeServiceImpl().getDeleteEmployeeAudit(userCode);
	}
	
	public ArrayList<String> getEmployeePermissionsBD(String userCode){
		
		EmployeeService empService=new EmployeeServiceImpl();
		
		return empService.getEmployeePermissionsService(userCode);
	}
	
	public String blockUserDetailsBD(String userCode,String role){
		
		EmployeeService empService=new EmployeeServiceImpl();
		
		return empService.blockUserDetailsService(userCode,role);
	}
	
	public String getBioIdBD(){
		
		EmployeeService empService=new EmployeeServiceImpl();
		
		return empService.getBioIdService();
	}
	
	
}
