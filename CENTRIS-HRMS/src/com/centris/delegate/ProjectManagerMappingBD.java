package com.centris.delegate;

import java.util.ArrayList;

import org.json.JSONArray;

import com.centris.VO.ProjectHeadVo;
import com.centris.VO.ProjectManagerMappingVO;
import com.centris.service.ProjectManagerMappingService;
import com.centris.service.serviceImpl.ProjectManagerMappingServiceImpl;

public class ProjectManagerMappingBD {

	public ArrayList<ProjectManagerMappingVO> getManager() {

		return new ProjectManagerMappingServiceImpl().getManager();
	}

	public ArrayList<ProjectManagerMappingVO> getProject() {
		return new ProjectManagerMappingServiceImpl().getProject();
	}

	public String saveProjectManagerMapping(String managerId,
			JSONArray jsonproject, String username) {

		return new ProjectManagerMappingServiceImpl()
				.saveProjectManagerMapping(managerId, jsonproject, username);
	}

	public ArrayList<ProjectManagerMappingVO> getMappedProject(String managerId) {

		return new ProjectManagerMappingServiceImpl()
				.getMappedProject(managerId);
	}

	public ArrayList<ProjectHeadVo> getProjectHead() {

		return new ProjectManagerMappingServiceImpl().getProjectHead();
	}
	
	public String getManagerIdByEmp(String mrgId) {

		return new ProjectManagerMappingServiceImpl().getManagerIdByEmp(mrgId);
	}
	
	
	
	public ArrayList<ProjectManagerMappingVO> getDirector() {

		return new ProjectManagerMappingServiceImpl().getDirector();
	}

	public ArrayList<ProjectManagerMappingVO> getAllProjects() {

		ProjectManagerMappingService projectManagerMappingService =new ProjectManagerMappingServiceImpl();
		
		return projectManagerMappingService.getAllProjects();
	}
	
}
