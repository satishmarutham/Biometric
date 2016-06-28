package com.centris.service;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.LocationMasterPojo;
import com.centris.VO.LocationMasterVo;
import com.centris.form.LocationMasterForm;



/**
 * @author seshuma
 *
 */
public interface LocationMasterService {
	public List<LocationMasterVo> getLocationByGroup(String group);
	public String storelocation(LocationMasterForm lform,String user);
	public ArrayList<LocationMasterVo> getLocation(String groupid);
	public ArrayList<LocationMasterVo> getSingleLocation(String locId);
	public String updateLocation(LocationMasterPojo lpojo);
	public String deleteLocation(String[] locid,String currentuser);
	public int validateLocationName(String locationname);
}
