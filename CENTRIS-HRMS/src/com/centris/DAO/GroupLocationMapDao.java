package com.centris.DAO;

import java.util.List;

import com.centris.VO.GroupLocationMapVO;

public interface GroupLocationMapDao {
	public List<GroupLocationMapVO> getLocation();
	public List<GroupLocationMapVO> getGroup();
	public List<GroupLocationMapVO> getMappedLoc(String groupId);

}
