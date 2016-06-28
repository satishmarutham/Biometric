package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DAOIMPL.ModifyEmployeeDaoImpl;
import com.centris.POJO.AddEmployeePojo;
import com.centris.VO.EmpVO;
import com.centris.VO.EmployeeVO;
import com.centris.form.AddEmployeeForm;
import com.centris.service.ModifyEmployeeService;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;


/**
 * @author seshuma
 *
 */
public class ModifyEmployeeServiceImpl implements ModifyEmployeeService{
	
	private static 	Logger logger = Logger.getLogger(ModifyEmployeeServiceImpl.class);
	
	public ArrayList<EmpVO> getModifyEmployeeList(String empname){
		
	
		return new ModifyEmployeeDaoImpl().getModifyEmployeeList(empname);
	}
	
	public String ModifyEmployee(AddEmployeeForm modifyEmpForm,String username){
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeServiceImpl: ModifyEmployee : Starting");
		AddEmployeePojo emppojo=new AddEmployeePojo();
		
		try{
		
		emppojo.setEmpid(modifyEmpForm.getEmpid().trim());
		emppojo.setEmpname(modifyEmpForm.getEmpname().trim());
		emppojo.setFathername(modifyEmpForm.getFather().trim());
		emppojo.setPhone(modifyEmpForm.getEmpphone().trim());
		emppojo.setEmail(modifyEmpForm.getEmpmail().trim());
		emppojo.setDob(HelperClass.convertUIToDatabase(modifyEmpForm.getDob()).trim());
		emppojo.setDoj(HelperClass.convertUIToDatabase(modifyEmpForm.getDoj()).trim());
		emppojo.setEmpaddress(modifyEmpForm.getEmpaddresss().trim());
		emppojo.setEmployeedesignation(modifyEmpForm.getEmpdesignation());
		emppojo.setDepartment(modifyEmpForm.getEmpdepartment());
		emppojo.setLocation(modifyEmpForm.getEmpLocation());
		emppojo.setShift(modifyEmpForm.getEmpshift());
		emppojo.setCreateuser(username);
		emppojo.setCreatedate(HelperClass.getCurrentTimestamp());
		if(modifyEmpForm.getIsemployeeregusteredinmultilocations()==null){
		emppojo.setIsemployeereginmultilocations("N");
		}else{
			
			emppojo.setIsemployeereginmultilocations("Y");
		}
		
		String selectedlocations=modifyEmpForm.getAllselectedlocations();
		System.out.println(selectedlocations);
		String[] locations=selectedlocations.split(",");
		System.out.println(locations.length);
		emppojo.setSelectedllocations(locations);
		emppojo.setEmpregnumber(modifyEmpForm.getEmpregnumber().trim());
		
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
			
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ModifyEmployeeServiceImpl: ModifyEmployee : Ending");
		
		return new ModifyEmployeeDaoImpl().updateEmployee(emppojo);
	}
	
public boolean checkEmail(String email,String empid){
		
	
		return new ModifyEmployeeDaoImpl().checkEmail(email,empid);
	}

public boolean checkEmpregNo(String empregno,String empid){
	
	return new ModifyEmployeeDaoImpl().checkEmpregNo(empregno,empid);
}

public List<EmpVO> getModifyEmpDetailsForAllEmp(String empid) {
	
	return new ModifyEmployeeDaoImpl().getModifyEmpDetailsForAllEmp(empid);
}

public ArrayList<EmpVO> getSearchEmployees(String searchname,String maxlimit,String groupid){
	
	int rowslimit=Integer.parseInt(maxlimit);
	
	return new ModifyEmployeeDaoImpl().getSearchEmployees(searchname, rowslimit,groupid);
}
	

}
