package com.centris.service.serviceImpl;

import java.util.ArrayList;

import org.json.JSONArray;

import com.centris.DAO.EmployeeManagerMappingDao;
import com.centris.DAO.DAOIMPL.EmployeeManagerMappingDaoImpl;
import com.centris.VO.EmployeeManagerMappingVO;
import com.centris.service.EmployeeManagerMappingService;

public class EmployeeManagerMappingServiceImpl implements EmployeeManagerMappingService{

	
	public ArrayList<EmployeeManagerMappingVO> getAvailableEmployees() {
		
		EmployeeManagerMappingDao employeeManagerMappingDao =new EmployeeManagerMappingDaoImpl();
		
		return employeeManagerMappingDao.getAvailableEmployees();
	}

	public String saveemployeeMangerMapping(String managerId,JSONArray jsonproject, String username) {
		
	EmployeeManagerMappingDao employeeManagerMappingDao =new EmployeeManagerMappingDaoImpl();
		
		return employeeManagerMappingDao.saveemployeeMangerMapping(managerId,jsonproject,username);
	}

	public ArrayList<EmployeeManagerMappingVO> getMappedEmployees(String managerId) {
		
	EmployeeManagerMappingDao employeeManagerMappingDao =new EmployeeManagerMappingDaoImpl();
		
		return employeeManagerMappingDao.getMappedEmployees(managerId);
	}

}
