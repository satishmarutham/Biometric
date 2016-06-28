package com.centris.delegate;

import java.util.ArrayList;

import org.json.JSONArray;

import com.centris.VO.AddDesignationVO;
import com.centris.VO.DepartmentMappingVo;
import com.centris.service.DepartmentMappingService;
import com.centris.service.serviceImpl.DepartmentMappingServiceImpl;

public class DepartmentMappingBD {

	public ArrayList<DepartmentMappingVo> getAllUsersUnderDesignation(String designation) {
	
		DepartmentMappingService departmentMappingService=new DepartmentMappingServiceImpl();
		
		return departmentMappingService.getAllUsersUnderDesignation(designation);
	}

	public ArrayList<DepartmentMappingVo> getAvailableDepartments(String usercode) {
	
		DepartmentMappingService departmentMappingService=new DepartmentMappingServiceImpl();
		
		return departmentMappingService.getAvailableDepartments(usercode);
	}

	public ArrayList<DepartmentMappingVo> getMappedDepartments(String usercode) {

		DepartmentMappingService departmentMappingService=new DepartmentMappingServiceImpl();
		
		return departmentMappingService.getMappedDepartments(usercode);
	}

	public String saveDepartmentMapping(String userId, JSONArray jsonArray,String currentuser) {
	
		DepartmentMappingService departmentMappingService=new DepartmentMappingServiceImpl();
		
		return departmentMappingService.saveDepartmentMapping(userId,jsonArray,currentuser);
	}

	public ArrayList<AddDesignationVO> getDesignationDetails() {
	
		DepartmentMappingService departmentMappingService=new DepartmentMappingServiceImpl();
		
		return departmentMappingService.getDesignationDetails();
	}

}
