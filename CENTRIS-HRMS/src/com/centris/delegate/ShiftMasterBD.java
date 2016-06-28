package com.centris.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.ShiftMasterPOJO;
import com.centris.VO.ShiftMasterVO;
import com.centris.service.ShiftMasterService;
import com.centris.service.serviceImpl.ShiftMasterServiceImpl;

public class ShiftMasterBD {
	ShiftMasterService shiftmasterservice;
	public ArrayList<ShiftMasterVO> getAllShifts(String groupid) {
		 shiftmasterservice=new ShiftMasterServiceImpl();
		return shiftmasterservice.getAllShifts(groupid) ;
	}
	public String shiftCreation(ShiftMasterPOJO shiftMasterPOJO) {
		 shiftmasterservice=new ShiftMasterServiceImpl();
			return shiftmasterservice.shiftCreation(shiftMasterPOJO) ;
	}
	public String shiftUpdate(ShiftMasterPOJO shiftMasterPOJO) {
		shiftmasterservice=new ShiftMasterServiceImpl();
		return shiftmasterservice.shiftUpdate(shiftMasterPOJO) ;
	}
	public String shiftDelete(ShiftMasterPOJO shiftMasterPOJO) {
		shiftmasterservice=new ShiftMasterServiceImpl();
		return shiftmasterservice.shiftDelete(shiftMasterPOJO) ;
	}
	public int checkShiftName(String shiftname,String locationcode) {
		shiftmasterservice=new ShiftMasterServiceImpl();
		return shiftmasterservice.checkShiftName(shiftname,locationcode) ;
	}
	
	public int checkShiftNameUpdate(String shiftname,String locationcode,String shiftid) {
		shiftmasterservice=new ShiftMasterServiceImpl();
		return shiftmasterservice.checkShiftNameUpdate(shiftname,locationcode,shiftid) ;
	}
	
	
	public List<ShiftMasterVO> getShiftByLocation(String location,String group) {
		return new ShiftMasterServiceImpl().getShiftByLocation(location,group) ;
	}
	
	public List<ShiftMasterVO> getShiftBasedLocation(String location) {
		return new ShiftMasterServiceImpl().getShiftBasedLocation(location) ;
	}
	
	public List<ShiftMasterVO> getShiftByMultipleLocation(String location,String group) {
		return new ShiftMasterServiceImpl().getShiftByMultipleLocation(location,group) ;
	}
	
	
	
	

}
