package com.centris.delegate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.centris.DAO.DAOIMPL.AddEmployeeDaoImpl;
import com.centris.VO.AllEmployeeVo;
import com.centris.VO.RemoveEmployeeVo;
import com.centris.form.AddEmployeeForm;
import com.centris.service.serviceImpl.AddEmployeeServiceImpl;


public class AddEmployeeBD {
	
public String addEmployee(AddEmployeeForm addEmployee,String username ){
		
		return new AddEmployeeServiceImpl().addEmployee(addEmployee,username);
	}
	
public boolean checkEmail(String email){
		
		return new AddEmployeeServiceImpl().checkEmail(email);
	}
public boolean checkEmpRegNo(String empregno){
	
	return new AddEmployeeServiceImpl().checkEmpRegNo(empregno);
}

public String activateEmployee(String empid,String modifiedby){
	
	return new AddEmployeeServiceImpl().activateEmployee(empid,modifiedby);
}

public boolean checkEmpId(String empid){
	
	return new AddEmployeeServiceImpl().checkEmpId(empid);
}

public ArrayList<RemoveEmployeeVo> getAllEmployeesBD(String searchemp,String maxrows,String groupcode)
		throws Exception {

	return new AddEmployeeServiceImpl().getAllEmployeesServiceImpl(searchemp,maxrows,groupcode);
}

public String removeEmployee(String empid,String modifiedby,Timestamp modifieddate) throws Exception{
	
	return new AddEmployeeServiceImpl().removeEmployee(empid,modifiedby,modifieddate);
}

public List<AllEmployeeVo> getAllDisplayEmployee(String groupid){
	
	List<AllEmployeeVo> list=null;
	
	try {
		 list=new AddEmployeeServiceImpl().getAllDisplayEmployee(groupid);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
}

public List<AllEmployeeVo> getAllDeactiveEmployee(String groupid){
	
	List<AllEmployeeVo> list=null;
	
	try {
		 list=new AddEmployeeServiceImpl().getAllDeactiveEmployee(groupid);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
}

public List<AllEmployeeVo> getSerachofAllEmployee(String reqname){
	
	return new AddEmployeeDaoImpl().getSerachofAllEmployee(reqname);
}

public ArrayList<String> getlocationnames(String[] locationsid){
	
	return new AddEmployeeServiceImpl().getlocationnames(locationsid);
}

public String chechkemployeeidformat(String empid,String location){
	
	return new AddEmployeeServiceImpl().chechkemployeeidformat(empid,location);
}

public String checkDseCount(String locationid,String desid){
	
	return new AddEmployeeServiceImpl().checkDseCount(locationid,desid);
}


}
