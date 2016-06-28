package com.centris.delegate;

import java.util.ArrayList;

import org.json.JSONArray;

import com.centris.VO.ManagerDirectorMappingVo;
import com.centris.service.ManagerDirectorMappingService;
import com.centris.service.serviceImpl.ManagerDirectorMappingServiceImpl;

public class ManagerDirectorMappingBD {

	ManagerDirectorMappingService serviceobj = new ManagerDirectorMappingServiceImpl();

	public ArrayList<ManagerDirectorMappingVo> getDirector() {
		return serviceobj.getDirector();

	}

	public ArrayList<ManagerDirectorMappingVo> getAvailableManagers() {
		return serviceobj.getAvailableManagers();

	}

	public String savemanagerDirectorMapping(String directorId,
			JSONArray jsonproject, String username) {

		return serviceobj.savemanagerDirectorMapping(directorId, jsonproject,
				username);
	}
	
	public ArrayList<ManagerDirectorMappingVo> getMappedManagers(String directorId) {
		return serviceobj.getMappedManagers(directorId);

	}

}
