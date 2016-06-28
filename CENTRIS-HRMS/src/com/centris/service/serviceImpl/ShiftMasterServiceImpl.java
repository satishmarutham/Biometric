package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.centris.DAO.ShiftMasterDao;
import com.centris.DAO.DAOIMPL.ShiftMasterDaoImpl;
import com.centris.POJO.ShiftMasterPOJO;
import com.centris.VO.ShiftMasterVO;
import com.centris.service.ShiftMasterService;

public class ShiftMasterServiceImpl implements ShiftMasterService{

	ShiftMasterDao shiftmasterdao;
	public ArrayList<ShiftMasterVO> getAllShifts(String groupid) {
		shiftmasterdao=new ShiftMasterDaoImpl();
		return shiftmasterdao.getAllShifts(groupid);
	}
	@Override
	public String shiftCreation(ShiftMasterPOJO shiftMasterPOJO) {
		shiftmasterdao=new ShiftMasterDaoImpl();
		return shiftmasterdao.shiftCreation(shiftMasterPOJO);
		
	}
	
	public String shiftUpdate(ShiftMasterPOJO shiftMasterPOJO) {
		shiftmasterdao=new ShiftMasterDaoImpl();
		return shiftmasterdao.shiftUpdate(shiftMasterPOJO);
	}
	@Override
	public String shiftDelete(ShiftMasterPOJO shiftMasterPOJO) {
		shiftmasterdao=new ShiftMasterDaoImpl();
		return shiftmasterdao.shiftDelete(shiftMasterPOJO);
	}
	@Override
	public int checkShiftName(String shiftname,String locationcode) {
		shiftmasterdao=new ShiftMasterDaoImpl();
		return shiftmasterdao.checkShiftName(shiftname,locationcode);
	}
	
	public int checkShiftNameUpdate(String shiftname,String locationcode,String shiftid) {
		shiftmasterdao=new ShiftMasterDaoImpl();
		return shiftmasterdao.checkShiftNameUpdate(shiftname,locationcode,shiftid);
	}
	
	
	public List<ShiftMasterVO> getShiftByLocation(String location,String group) {
		return new ShiftMasterDaoImpl().getShiftByLocation(location,group) ;
	}
	
	public List<ShiftMasterVO> getShiftBasedLocation(String location) {
		return new ShiftMasterDaoImpl().getShiftBasedLocation(location) ;
	}
	
	public List<ShiftMasterVO> getShiftByMultipleLocation(String location,String group) {
		return new ShiftMasterDaoImpl().getShiftByMultipleLocation(location,group) ;
	}
}

