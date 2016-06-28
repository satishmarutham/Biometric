package com.centris.delegate;

import java.util.ArrayList;
import java.util.List;
import com.centris.POJO.UserMasterPojo;
import com.centris.service.serviceImpl.UserMasterServiceImpl;

public class UserMasterBD {
	public List<UserMasterPojo> getUserDetails() throws Exception
	{
		return new UserMasterServiceImpl().getUserDetails();
	}
	public String addUser(UserMasterPojo userMasterPojo) throws Exception{
		return new UserMasterServiceImpl().addUser(userMasterPojo);
	}
	public String editUser(UserMasterPojo userMasterPojo) throws Exception
	{
		return new UserMasterServiceImpl().editUser(userMasterPojo);
	}
	public String deleteUser(UserMasterPojo userMasterPojo) throws Exception{
		return new UserMasterServiceImpl().deleteUser(userMasterPojo);
	}
	
	public ArrayList<UserMasterPojo> getGroupDetails() throws Exception{
		return new UserMasterServiceImpl().getGroupDetails();
	}
	public boolean CurrentUserNameCkeck(String username) {

		return new UserMasterServiceImpl().CurrentUserNameCkeck(username);
	}
}
