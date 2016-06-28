package com.centris.service.serviceImpl;

import java.util.ArrayList;

import org.json.JSONArray;

import com.centris.DAO.DepartmentMappingDao;
import com.centris.DAO.DAOIMPL.DepartmentMappingDaoImpl;
import com.centris.VO.AddDesignationVO;
import com.centris.VO.DepartmentMappingVo;
import com.centris.service.DepartmentMappingService;

public class DepartmentMappingServiceImpl implements DepartmentMappingService{

	
	public ArrayList<DepartmentMappingVo> getAllUsersUnderDesignation(String designation) {
		
		DepartmentMappingDao  departmentMappingDao=new DepartmentMappingDaoImpl();
		
		return departmentMappingDao.getAllUsersUnderDesignation(designation);
	}

	
	public ArrayList<DepartmentMappingVo> getAvailableDepartments(String usercode) {

		DepartmentMappingDao  departmentMappingDao=new DepartmentMappingDaoImpl();
		
		return departmentMappingDao.getAvailableDepartments(usercode);
	}


	public ArrayList<DepartmentMappingVo> getMappedDepartments(String usercode) {

		DepartmentMappingDao  departmentMappingDao=new DepartmentMappingDaoImpl();
		
		return departmentMappingDao.getMappedDepartments(usercode);
	}


	public String saveDepartmentMapping(String userId, JSONArray jsonArray,String currentuser) {

		DepartmentMappingDao  departmentMappingDao=new DepartmentMappingDaoImpl();
		
		return departmentMappingDao.saveDepartmentMapping(userId,jsonArray,currentuser);
	}


	public ArrayList<AddDesignationVO> getDesignationDetails() {
	
		DepartmentMappingDao  departmentMappingDao=new DepartmentMappingDaoImpl();
		
		return departmentMappingDao.getDesignationDetails();
	}

}
