package com.centris.DAO;

import java.util.ArrayList;

import org.json.JSONArray;

import com.centris.VO.ManagerDirectorMappingVo;

public interface ManagerDirectorMappingDAO {
	public ArrayList<ManagerDirectorMappingVo> getDirector();

	public ArrayList<ManagerDirectorMappingVo> getAvailableManagers();

	String savemanagerDirectorMapping(String directorId, JSONArray jsonproject,
			String username);
	
	public ArrayList<ManagerDirectorMappingVo> getMappedManagers(String directorId);

}
