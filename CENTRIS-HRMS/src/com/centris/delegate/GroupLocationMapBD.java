package com.centris.delegate;

import java.util.List;

import org.json.JSONArray;

import com.centris.VO.GroupLocationMapVO;
import com.centris.service.serviceImpl.GroupLocationMapServiceImpl;

public class GroupLocationMapBD {

	public List<GroupLocationMapVO> getGroup() {
	     return new GroupLocationMapServiceImpl().getGroup();
	}
	public List<GroupLocationMapVO> getLocation() {
		return new GroupLocationMapServiceImpl().getLocation();
	}

	public String saveGroupLocationMapping(String groupId, JSONArray jsonloc) {
		return new GroupLocationMapServiceImpl().saveGroupLocationMapping(groupId,jsonloc);
	}

	public List<GroupLocationMapVO> getMappedLoc(String groupId) {
		return new GroupLocationMapServiceImpl().getMappedLoc(groupId);
	}

}
