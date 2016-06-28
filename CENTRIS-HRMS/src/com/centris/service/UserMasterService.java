package com.centris.service;

import java.util.ArrayList;
import java.util.List;
import com.centris.POJO.UserMasterPojo;


/**
 * @author seshuma
 *
 */
public interface UserMasterService {
	public List<UserMasterPojo> getUserDetails()throws Exception;
	public String addUser(UserMasterPojo userMasterPojo) throws Exception;
	public String editUser(UserMasterPojo userMasterPojo) throws Exception;
	public ArrayList<UserMasterPojo> getGroupDetails() throws Exception;
	public boolean CurrentUserNameCkeck(String username);
}
