package com.centris.delegate;

import java.util.ArrayList;

import com.centris.POJO.GroupMasterPOJO;
import com.centris.VO.GroupMasterVO;
import com.centris.service.serviceImpl.GroupMasterServiceImpl;

public class GroupMasterBD {

	public int addGroupDetails(GroupMasterPOJO groupMasterPOJO) {
	
		return new GroupMasterServiceImpl().addGroupDetails(groupMasterPOJO);
	}

	public ArrayList<GroupMasterVO> getGroupDetails() {
	
		return new GroupMasterServiceImpl().getGroupDetails();
	}

	

	public ArrayList<GroupMasterVO> editGroupDetails(String groupID) {
	
		return new GroupMasterServiceImpl().editGroupDetails(groupID);
	}

	public String updateGroupDetailsVal(GroupMasterPOJO groupMasterPOJO) {
		
		return new GroupMasterServiceImpl().updateGroupDetailsVal(groupMasterPOJO);
	}

	public String deleteGroupDetailsVal(String[] groupIdval) {
		
		return new GroupMasterServiceImpl().deleteGroupDetailsVal(groupIdval);
	}

	public String validateGroupDetailsVal(GroupMasterPOJO groupMasterPOJO) {
			return new GroupMasterServiceImpl().validateGroupDetailsVal(groupMasterPOJO);
	}
	public ArrayList<GroupMasterVO> getGroupDetailsbyCurrentUser(String currentUserId) {
		
		return new GroupMasterServiceImpl().getGroupDetailsbyCurrentUser(currentUserId);
	}

	
}
