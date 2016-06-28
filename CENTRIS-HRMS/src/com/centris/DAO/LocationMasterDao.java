package com.centris.DAO;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.LocationMasterPojo;
import com.centris.VO.LocationMasterVo;

public interface LocationMasterDao {
	
	public String storelocation(LocationMasterPojo lpojo);
	public ArrayList<LocationMasterVo> getLocation(String groupid);
	public ArrayList<LocationMasterVo> getSingleLocation(String locId);
	public String updateLocation(LocationMasterPojo lpojo);
	public String deleteLocation(String[] locid,String currentuser);
	public int validateLocationName(String locationname);
	public List<LocationMasterVo> getLocationByGroup(String group) ;
	//public int validateLocationNameUpdate(String locationname,String locationId);
//	public List<RoleMasterPojo> getLocationDetails() throws Exception;
}
