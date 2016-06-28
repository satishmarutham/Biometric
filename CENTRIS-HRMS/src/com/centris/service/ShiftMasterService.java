package com.centris.service;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.ShiftMasterPOJO;
import com.centris.VO.ShiftMasterVO;

public interface ShiftMasterService {

	public ArrayList<ShiftMasterVO> getAllShifts(String groupid);
    public String shiftCreation(ShiftMasterPOJO shiftMasterPOJO);
	public String shiftUpdate(ShiftMasterPOJO shiftMasterPOJO);
	public String shiftDelete(ShiftMasterPOJO shiftMasterPOJO);
	public int checkShiftName(String shiftname,String locationcode);
	public int checkShiftNameUpdate(String shiftname,String locationcode,String shiftid);
	

	public List<ShiftMasterVO> getShiftByLocation(String location,String group);
	public List<ShiftMasterVO> getShiftByMultipleLocation(String location,String group);
	
	
	

}
