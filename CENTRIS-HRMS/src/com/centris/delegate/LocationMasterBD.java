package com.centris.delegate;


import java.util.ArrayList;
import java.util.List;
import com.centris.POJO.LocationMasterPojo;
import com.centris.VO.LocationMasterVo;
import com.centris.form.LocationMasterForm;
import com.centris.service.serviceImpl.LocationMasterServiceImpl;

public class LocationMasterBD {
	
public String storelocation(LocationMasterForm lform,String user){
		
		return new LocationMasterServiceImpl().storelocation(lform,user);
	}

public String updateLocation(LocationMasterForm lform,String user){
	
	return new LocationMasterServiceImpl().updateLocation(lform,user);
}


public ArrayList<LocationMasterVo> getLocation(String groupcode) {
	
	return new LocationMasterServiceImpl().getLocation(groupcode);
}

public ArrayList<LocationMasterVo> getAllLocation() {
	
	return new LocationMasterServiceImpl().getAllLocation();
}

public ArrayList<LocationMasterVo> getSingleLocation(String locId){
	
	return new LocationMasterServiceImpl().getSingleLocation(locId);
	
}
public String updateLocation(LocationMasterPojo lpojo){
	
	return new LocationMasterServiceImpl().updateLocation(lpojo);
	
	
}

public String deleteLocation(String[] locid,String currentuser){
	
	return new LocationMasterServiceImpl().deleteLocation(locid,currentuser);
}
public int validateLocationNameUpdate(String locationname,String locationid){
	
	return new LocationMasterServiceImpl().validateLocationNameUpdate(locationname,locationid);
}

public int validateLocationName(String locationname){
	
	return new LocationMasterServiceImpl().validateLocationName(locationname);
}

public List<LocationMasterVo> getLocationByGroup(String group) {
	return new LocationMasterServiceImpl().getLocationByGroup( group);
}

public int validateLocationNumberUpdate(String locationnumber,String locationid){
	
	return new LocationMasterServiceImpl().validateLocationNumberUpdate(locationnumber,locationid);
}

public int validateLocationNumber(String locationnumber){
	
	return new LocationMasterServiceImpl().validateLocationNumber(locationnumber);
}

public int validateMachineNumberUpdate(String machinenumber,String locationid){
	
	return new LocationMasterServiceImpl().validateMachineNumberUpdate(machinenumber,locationid);
}
public int validateMachineNumber(String machinenumber){
	
	return new LocationMasterServiceImpl().validateMachineNumber(machinenumber);
}

public int validateBioIdIndex(String bioidindex){
	
	return new LocationMasterServiceImpl().validateBioIdIndex(bioidindex);
}

public int validateBioIdIndexUpdate(String bioidindex,String locationid){
	
	return new LocationMasterServiceImpl().validateBioIdIndexUpdate(bioidindex,locationid);
}

public ArrayList<LocationMasterVo> getDeactivelocations(){
	
	return new LocationMasterServiceImpl().getDeactivelocations();
}

public String activatelocation(String locationname,String currentuser){
	
	return new LocationMasterServiceImpl().activatelocation(locationname,currentuser);
}

public ArrayList<LocationMasterVo> getSearchLocations(String groupcode,	String searchLocation) {
	
	return new LocationMasterServiceImpl(). getSearchLocations(groupcode, searchLocation);
}






}
