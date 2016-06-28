package com.centris.delegate;

import java.util.ArrayList;

import com.centris.VO.UsermanagementEmployeeVo;
import com.centris.form.UserManagementForm;
import com.centris.service.UserManagementService;
import com.centris.service.serviceImpl.UserManagementServiceImpl;

public class UserManagementBD {
	
	
	
	UserManagementService userService=new UserManagementServiceImpl();
	
	public ArrayList<UsermanagementEmployeeVo> getEmpIdNameBySerachTerm(String startwith,String designation){
		
		return userService.getEmpIdNameBySerachTerm(startwith,designation);
	}
	
	public ArrayList<String> getUserMangementRoles(String empId){
		
		return userService.getUserMangementRoles(empId);
		
	}
	
	public String saveEmployeeRole(UserManagementForm form,String currentuser){
		
		return userService.saveEmployeeRole(form,currentuser);
		
	}

	
	

}
