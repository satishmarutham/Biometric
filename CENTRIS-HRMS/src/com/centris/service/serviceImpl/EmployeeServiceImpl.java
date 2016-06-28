package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.centris.DAO.EmployeeDAO;
import com.centris.DAO.DAOIMPL.EmployeeDAOImpl;
import com.centris.VO.CheckEmployeeDeletionVO;
import com.centris.VO.EmployVO;
import com.centris.VO.EmployeeDeleteAuditVo;
import com.centris.form.EmployeeForm;
import com.centris.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public String registerEmployee(EmployeeForm employeeForm) {
		return new EmployeeDAOImpl().registerEmployee(employeeForm);
	}
	public String amendEmployee(EmployeeForm employeeForm) {
		return new EmployeeDAOImpl().amendEmployee(employeeForm);
	}

	public List<EmployVO>  searchEmployee(String empId) {
		return new EmployeeDAOImpl().searchEmployee(empId);
	}
	public List<EmployVO> getEmpIdNameBySerachTerm(String maxRows,String name) {
		return new EmployeeDAOImpl().getEmpIdNameBySerachTerm(maxRows,name);
	}
	public String checkDuplicateEmailId(String emailId,String empId) {
		return new EmployeeDAOImpl().checkDuplicateEmailId(emailId,empId);
	}

	@Override
	public String checkPassportNoUnique(String passportNo, String empId) {
		return new EmployeeDAOImpl().checkPassportNoUnique(passportNo,empId);
	}
	
	@Override
	public String checkAccountNoUnique(String accountNo, String empId) {
		return new EmployeeDAOImpl().checkAccountNoUnique(accountNo,empId);
	}
	
	
	
	@Override
	public String checkVoterIdUnique(String voterId, String empId) {
		return new EmployeeDAOImpl().checkVoterIdUnique(voterId,empId);
	}
	@Override
	public String checkPanCardUnique(String panCardNo, String empId) {
		return new EmployeeDAOImpl().checkPanCardUnique(panCardNo,empId);
	}
	@Override
	public String checkAddharCardUnique(String addharCardNo, String empId) {
		return new EmployeeDAOImpl().checkAddharCardUnique(addharCardNo,empId);
	}
	@Override
	public String checkDLNoUnique(String dlNo, String empId) {
		return new EmployeeDAOImpl().checkDLNoUnique(dlNo,empId);
	}
	public String checkDuplicateBiometricId(String bioId,String empId) {
		return new EmployeeDAOImpl().checkDuplicateBiometricId(bioId,empId);
	}
	
 public String deleteEmployee(String empId,  String usercode){
		
		return new EmployeeDAOImpl().deleteEmployee(empId,usercode);
	}
	public CheckEmployeeDeletionVO checkEmployeeMap(String empCode) {
	
		return new EmployeeDAOImpl().checkEmployeeMap(empCode);
	}
	@Override
	public List<EmployeeDeleteAuditVo> getDeleteEmployeeAudit(String userCode) {
		// TODO Auto-generated method stub
		return new EmployeeDAOImpl().getDeleteEmployeeAudit(userCode);
	}
	@Override
	public ArrayList<String> getEmployeePermissionsService(
			String userCode) {
		// TODO Auto-generated method stub
		
		EmployeeDAO empdao=new EmployeeDAOImpl();
		return empdao.getEmployeePermissionsDao(userCode);
	}
	@Override
	public String blockUserDetailsService(String userCode, String role) {
		// TODO Auto-generated method stub
		EmployeeDAO empdao=new EmployeeDAOImpl();
		return empdao.blockUserDetailsDao(userCode,role);
	}
	@Override
	public String getBioIdService() {
		// TODO Auto-generated method stub
		
		EmployeeDAO empdao=new EmployeeDAOImpl();
		return empdao.getBioIdDao();
	}
}
