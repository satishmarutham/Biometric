package com.centris.DAO;

import java.util.ArrayList;

import org.json.JSONArray;

import com.centris.VO.ProjectManagerMappingVO;

public interface ProjectManagerMappingDao {
	public ArrayList<ProjectManagerMappingVO> getManager();
	public ArrayList<ProjectManagerMappingVO> getProject();
	public String saveProjectManagerMapping(String managerId,JSONArray jsonproject,String username);
	public ArrayList<ProjectManagerMappingVO> getMappedProject(String managerId);
	public ArrayList<ProjectManagerMappingVO> getAllProjects();
}
