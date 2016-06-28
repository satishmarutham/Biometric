package com.centris.service.serviceImpl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import com.centris.DAO.DAOIMPL.IDGenerator;
import com.centris.DAO.DAOIMPL.LocationMasterDaoImpl;
import com.centris.POJO.LocationMasterPojo;
import com.centris.VO.LocationMasterVo;
import com.centris.form.LocationMasterForm;
import com.centris.service.LocationMasterService;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;


/**
 * @author seshuma
 *
 */
public class LocationMasterServiceImpl implements LocationMasterService {
	
	private static 	Logger logger = Logger.getLogger(LocationMasterServiceImpl.class);
	
	public String storelocation(LocationMasterForm lform,String user){
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: storelocation : Starting");
		
		LocationMasterPojo lpojo=new LocationMasterPojo();
		
		IDGenerator id=new IDGenerator();
		
		try {
			
			lpojo.setLocationid(id.getPrimaryKeyID("ai_emp_location"));
			lpojo.setLocationname(lform.getLocationname());
			lpojo.setLocationnomber(lform.getLocationnomber());
			lpojo.setMachinenumber(lform.getMachinenumber());
			lpojo.setPropritername(lform.getPropritername());
			lpojo.setPropriteraddresss(lform.getPropriteraddresss());
			lpojo.setMobilenumber(lform.getMobilenumber());
			lpojo.setCompanyname(lform.getCompanyname());
			lpojo.setCreateuser(user);
			lpojo.setCreatedate(HelperClass.getCurrentTimestamp());
			lpojo.setTsmname(lform.getTsmname());
			lpojo.setBioidindexnumber(lform.getBioidindexnumber());
			lpojo.setContactnumber(lform.getContactnumber());
			lpojo.setEmployeestrength(lform.getEmpstrength());
			lpojo.setDsecount(lform.getDsecount());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
			
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT );
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: storelocation : Ending");
		
		return new LocationMasterDaoImpl().storelocation(lpojo);
	}
	
public String updateLocation(LocationMasterForm lform,String user){
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: updateLocation : Starting");
		
		LocationMasterPojo lpojo=new LocationMasterPojo();
		
		try {
			
			lpojo.setLocationid(lform.getLocationid());
			lpojo.setLocationname(lform.getLocationname());
			lpojo.setLocationnomber(lform.getLocationnomber());
			lpojo.setMachinenumber(lform.getMachinenumber());
			lpojo.setPropritername(lform.getPropritername());
			lpojo.setPropriteraddresss(lform.getPropriteraddresss());
			lpojo.setMobilenumber(lform.getMobilenumber());
			lpojo.setCompanyname(lform.getCompanyname());
			lpojo.setCreateuser(user);
			lpojo.setCreatedate(HelperClass.getCurrentTimestamp());
			lpojo.setTsmname(lform.getTsmname());
			lpojo.setBioidindexnumber(lform.getBioidindexnumber());
			lpojo.setContactnumber(lform.getContactnumber());
			lpojo.setEmployeestrength(lform.getEmpstrength());
			lpojo.setDsecount(lform.getDsecount());
		
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
			
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT );
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: updateLocation : Ending");
		
		return new LocationMasterDaoImpl().updateLocation(lpojo);
	}
	
	public ArrayList<LocationMasterVo> getLocation(String groupcode) {
		
		return new LocationMasterDaoImpl().getLocation(groupcode);
	}
	
	public ArrayList<LocationMasterVo> getAllLocation() {
		
		return new LocationMasterDaoImpl().getALLLocation();
	}
	
	public ArrayList<LocationMasterVo> getSingleLocation(String locId){
		
		return new LocationMasterDaoImpl().getSingleLocation(locId);
		
	}
	
	public String updateLocation(LocationMasterPojo lpojo){
		
		return new LocationMasterDaoImpl().updateLocation(lpojo);
	}
	
	public String deleteLocation(String[] locid,String currentuser){
		
		return new LocationMasterDaoImpl().deleteLocation(locid,currentuser);
	}
	
	public int validateLocationName(String locationname){
		
		return new LocationMasterDaoImpl().validateLocationName(locationname);
	}
	
public int validateLocationNameUpdate(String locationname,String locationid){
		
		return new LocationMasterDaoImpl().validateLocationNameUpdate(locationname, locationid);
	}
	
	public List<LocationMasterVo> getLocationByGroup(String group) {
		return new LocationMasterDaoImpl().getLocationByGroup( group);
	}
	
	public int validateLocationNumberUpdate(String locationnumber,String locationid){
		
		return new LocationMasterDaoImpl().validateLocationNumberUpdate(locationnumber,locationid);
	}
	public int validateLocationNumber(String locationnumber){
		
		return new LocationMasterDaoImpl().validateLocationNumber(locationnumber);
	}
	
	public int validateMachineNumberUpdate(String machinenumber,String locationid){
		
		return new LocationMasterDaoImpl().validateMachineNumberUpdate(machinenumber,locationid);
	}
	
public int validateMachineNumber(String machinenumber){
		
		return new LocationMasterDaoImpl().validateMachineNumber(machinenumber);
	}

public int validateBioIdIndex(String bioidindex){
	
	return new LocationMasterDaoImpl().validateBioIdIndex(bioidindex);
}

public int validateBioIdIndexUpdate(String bioidindex,String locationid){
	
	return new LocationMasterDaoImpl().validateBioIdIndexUpdate(bioidindex,locationid);
}

public ArrayList<LocationMasterVo> getDeactivelocations(){
	
	return new LocationMasterDaoImpl().getDeactivelocations();
}

public String activatelocation(String locationname,String currentuser){
	
	return new LocationMasterDaoImpl().activatelocation(locationname,currentuser);
}

public ArrayList<LocationMasterVo> getSearchLocations(String groupcode,	String searchLocation) {
	
	return new LocationMasterDaoImpl(). getSearchLocations( groupcode, searchLocation);
}

}
