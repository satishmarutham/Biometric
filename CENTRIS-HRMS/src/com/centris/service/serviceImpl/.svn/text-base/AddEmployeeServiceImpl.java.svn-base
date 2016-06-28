package com.centris.service.serviceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DAOIMPL.AddEmployeeDaoImpl;
import com.centris.POJO.AddEmployeePojo;
import com.centris.VO.AllEmployeeVo;
import com.centris.VO.RemoveEmployeeVo;
import com.centris.form.AddEmployeeForm;
import com.centris.service.AddEmployeeService;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;


/**
 * @author seshuma
 *
 */
public class AddEmployeeServiceImpl implements AddEmployeeService{
	
	private static 	Logger logger = Logger.getLogger(AddEmployeeServiceImpl.class);
	
	public String addEmployee(AddEmployeeForm addEmployee,String username  ){
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeServiceImpl: addEmployee : Starting");
		AddEmployeePojo emppojo=new AddEmployeePojo();
		
		try{
		emppojo.setEmpid(addEmployee.getEmpid());
		emppojo.setEmpname(addEmployee.getEmpname().trim());
		emppojo.setFathername(addEmployee.getFather().trim());
		emppojo.setPhone(addEmployee.getEmpphone().trim());
		emppojo.setEmail(addEmployee.getEmpmail().trim());
		emppojo.setDob(HelperClass.convertUIToDatabase(addEmployee.getDob()));
		emppojo.setDoj(HelperClass.convertUIToDatabase(addEmployee.getDoj()));
		emppojo.setEmpaddress(addEmployee.getEmpaddresss().trim());
		emppojo.setEmployeedesignation(addEmployee.getEmpdesignation());
		emppojo.setDepartment(addEmployee.getEmpdepartment());
		emppojo.setLocation(addEmployee.getEmpLocation());
		emppojo.setShift(addEmployee.getEmpshift());
		emppojo.setCreateuser(username);
		emppojo.setCreatedate(HelperClass.getCurrentTimestamp());
		emppojo.setIsemployeereginmultilocations(addEmployee.getIsemployeeregusteredinmultilocations());
		emppojo.setEmpregnumber(addEmployee.getEmpregnumber().trim());
	
		
		String selectedlocations=addEmployee.getAllselectedlocations();
		String[] locations=selectedlocations.split(",");
		emppojo.setSelectedllocations(locations);
		
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeServiceImpl: addEmployee : Ending");
		
		return new AddEmployeeDaoImpl().addEmployee(emppojo);
	}
	
	public boolean checkEmail(String email){
		
		return new AddEmployeeDaoImpl().checkEmail(email);
	}
	
	public boolean checkEmpRegNo(String empregno){
		
		return new AddEmployeeDaoImpl().checkEmpRegNo(empregno);
	}
	
public String activateEmployee(String empid,String modifiedby){
		
		return new AddEmployeeDaoImpl().activateEmployee(empid,modifiedby);
	}


	
	public boolean checkEmpId(String empid){
		
		return new AddEmployeeDaoImpl().checkEmpId(empid);
	}
	
	public ArrayList<RemoveEmployeeVo> getAllEmployeesServiceImpl(String searchemp,String maxrows,String groupcode) {

		return new AddEmployeeDaoImpl().getAllEmployees(searchemp,maxrows,groupcode);
	}
	
	public String removeEmployee(String empid,String modifiedby,Timestamp modifieddate){
		
			return new AddEmployeeDaoImpl().removeEmployee(empid,modifiedby,modifieddate);
	}
	
	public List<AllEmployeeVo> getAllDisplayEmployee(String groupid){
		
		return	 new AddEmployeeDaoImpl().getAllDisplayEmployee(groupid);
	
	}
	
public List<AllEmployeeVo> getAllDeactiveEmployee(String groupid){
		
		return	 new AddEmployeeDaoImpl().getAllDeactiveEmployee(groupid);
	
	}
	
	public List<AllEmployeeVo> getSerachofAllEmployee(String reqname){
		
		return new AddEmployeeDaoImpl().getSerachofAllEmployee(reqname);
	}
	
	public ArrayList<String> getlocationnames(String[] locationsid){
		
		return new AddEmployeeDaoImpl().getlocationnames(locationsid);
	}
	
	
	public String chechkemployeeidformat(String empid,String location){
		
		return new AddEmployeeDaoImpl().chechkemployeeidformat(empid,location);
	}
	
public String checkDseCount(String locationid,String desid){
		
		return new AddEmployeeDaoImpl().checkDseCount(locationid,desid);
	}
	
	
	

}
