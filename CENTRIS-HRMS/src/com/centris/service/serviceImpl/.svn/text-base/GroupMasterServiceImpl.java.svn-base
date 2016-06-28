package com.centris.service.serviceImpl;

import java.util.ArrayList;

import com.centris.DAO.DAOIMPL.GroupMasterDaoImpl;
import com.centris.POJO.GroupMasterPOJO;
import com.centris.VO.GroupMasterVO;
import com.centris.service.GroupMasterService;

public class GroupMasterServiceImpl implements GroupMasterService{

	public int addGroupDetails(GroupMasterPOJO groupMasterPOJO) {
		return new GroupMasterDaoImpl().addGroupDetails(groupMasterPOJO);
	}

	public ArrayList<GroupMasterVO> getGroupDetails() {
		return new GroupMasterDaoImpl().getGroupDetails();
	}

	public ArrayList<GroupMasterVO> editGroupDetails(String groupID) {
		return new GroupMasterDaoImpl().editGroupDetails(groupID);
	}

	public String updateGroupDetailsVal(GroupMasterPOJO groupMasterPOJO) {
     	return new GroupMasterDaoImpl().updateGroupDetailsVal(groupMasterPOJO);
	}
	public String deleteGroupDetailsVal(String[] groupIdval) {
		return new GroupMasterDaoImpl().deleteGroupDetailsVal(groupIdval);
	}

	public String validateGroupDetailsVal(GroupMasterPOJO groupMasterPOJO) {
		return new GroupMasterDaoImpl().validateGroupDetailsVal(groupMasterPOJO);
	}

	@Override
	public ArrayList<GroupMasterVO> getGroupDetailsbyCurrentUser(
			String currentUserId) {
		// TODO Auto-generated method stub
		return new GroupMasterDaoImpl().getGroupDetailsbyCurrentUser(currentUserId) ;
	}

}
