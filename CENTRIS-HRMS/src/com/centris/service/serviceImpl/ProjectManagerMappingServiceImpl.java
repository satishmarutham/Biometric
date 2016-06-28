package com.centris.service.serviceImpl;

import java.util.ArrayList;

import org.json.JSONArray;

import com.centris.DAO.ProjectManagerMappingDao;
import com.centris.DAO.DAOIMPL.ProjectManagerMappingDaoImpl;
import com.centris.VO.ProjectHeadVo;
import com.centris.VO.ProjectManagerMappingVO;
import com.centris.service.ProjectManagerMappingService;

 public class ProjectManagerMappingServiceImpl implements ProjectManagerMappingService{

	public ArrayList<ProjectManagerMappingVO> getManager() {
	
		return new ProjectManagerMappingDaoImpl().getManager();
	}

	public ArrayList<ProjectManagerMappingVO> getProject() {
	
		return new ProjectManagerMappingDaoImpl().getProject();
	}

	public String saveProjectManagerMapping(String managerId,JSONArray jsonproject, String username) {
	
		return new ProjectManagerMappingDaoImpl().saveProjectManagerMapping(managerId,jsonproject,username);
	}

	public ArrayList<ProjectManagerMappingVO> getMappedProject(String managerId) {
	
		return new ProjectManagerMappingDaoImpl().getMappedProject(managerId);
	}
	public ArrayList<ProjectHeadVo> getProjectHead() {
		
		return new ProjectManagerMappingDaoImpl().getProjectHead();
	}
	
	public String getManagerIdByEmp(String empId) {
		
		return new ProjectManagerMappingDaoImpl().getManagerIdByEmp(empId);
	}
	
	
	
	public ArrayList<ProjectManagerMappingVO> getDirector() {
		
		return new ProjectManagerMappingDaoImpl().getDirector();
	}


	public ArrayList<ProjectManagerMappingVO> getAllProjects() {

		ProjectManagerMappingDao projectManagerMappingDao = new ProjectManagerMappingDaoImpl();
	
		return projectManagerMappingDao.getAllProjects();
	}
	

}
