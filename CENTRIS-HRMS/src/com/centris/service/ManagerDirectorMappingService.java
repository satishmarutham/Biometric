package com.centris.service;

import java.util.ArrayList;

import org.json.JSONArray;

import com.centris.VO.ManagerDirectorMappingVo;

public interface ManagerDirectorMappingService {
	public ArrayList<ManagerDirectorMappingVo> getDirector();

	public ArrayList<ManagerDirectorMappingVo> getAvailableManagers();

	String savemanagerDirectorMapping(String directorId, JSONArray jsonproject,
			String username);
	public ArrayList<ManagerDirectorMappingVo> getMappedManagers(String directorId);
}
