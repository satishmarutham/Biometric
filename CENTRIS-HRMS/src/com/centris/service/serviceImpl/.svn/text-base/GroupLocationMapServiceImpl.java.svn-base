package com.centris.service.serviceImpl;

import java.util.List;

import org.json.JSONArray;

import com.centris.DAO.DAOIMPL.GroupLocationMapDaoImpl;
import com.centris.VO.GroupLocationMapVO;
import com.centris.service.GroupLocationMapService;

public class GroupLocationMapServiceImpl implements GroupLocationMapService{

	public List<GroupLocationMapVO> getGroup() {
		return new GroupLocationMapDaoImpl().getGroup();
	}

	public List<GroupLocationMapVO> getLocation() {
		// TODO Auto-generated method stub
		return new GroupLocationMapDaoImpl().getLocation();
	}

	public String saveGroupLocationMapping(String groupId, JSONArray jsonloc) {
		// TODO Auto-generated method stub
		return new GroupLocationMapDaoImpl().saveGroupLocationMapping(groupId,jsonloc);
	}

	public List<GroupLocationMapVO> getMappedLoc(String groupId) {
		// TODO Auto-generated method stub
		return new GroupLocationMapDaoImpl().getMappedLoc(groupId);
	}

}
