package com.centris.service;

import java.util.List;

import org.json.JSONArray;

import com.centris.VO.GroupLocationMapVO;

public interface GroupLocationMapService {
	public List<GroupLocationMapVO> getGroup();
	List<GroupLocationMapVO> getLocation();
	public String saveGroupLocationMapping(String groupId, JSONArray jsonloc);
	public List<GroupLocationMapVO> getMappedLoc(String groupId);
}
