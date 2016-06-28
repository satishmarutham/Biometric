package com.centris.delegate;

import java.util.ArrayList;

import org.json.JSONArray;

import com.centris.VO.EmployeeManagerMappingVO;
import com.centris.service.EmployeeManagerMappingService;
import com.centris.service.serviceImpl.EmployeeManagerMappingServiceImpl;

public class EmployeeManagerMappingBD {

	public ArrayList<EmployeeManagerMappingVO> getAvailableEmployees() {

		EmployeeManagerMappingService employeeManagerMappingService=new EmployeeManagerMappingServiceImpl();
				
		return employeeManagerMappingService.getAvailableEmployees();
	}

	public String saveemployeeMangerMapping(String managerId,JSONArray jsonproject, String username) {

		EmployeeManagerMappingService employeeManagerMappingService=new EmployeeManagerMappingServiceImpl();
				
		return employeeManagerMappingService.saveemployeeMangerMapping(managerId,jsonproject,username);
	}

	public ArrayList<EmployeeManagerMappingVO> getMappedEmployees(String managerId) {
	
		EmployeeManagerMappingService employeeManagerMappingService=new EmployeeManagerMappingServiceImpl();
		
		return employeeManagerMappingService.getMappedEmployees(managerId);
	}

}
