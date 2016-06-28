package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.centris.DAO.DAOIMPL.HolidayMasterDAOImpl;
import com.centris.POJO.HolidayMasterPojo;
import com.centris.VO.HolidayMasterVO;
import com.centris.form.HolidayMasterForm;


/**
 * @author seshuma
 *
 */
public class HolidayMasterServiceImpl {
	
	public String addSingleHoliday(HolidayMasterPojo hpojo){
		
		return new HolidayMasterDAOImpl().addSingleHolidayDetailDaoImpl(hpojo);
	}
	public ArrayList<HolidayMasterVO>  getYear(){
		
		return new HolidayMasterDAOImpl().getYearDAO();
	}
	
	public ArrayList<HolidayMasterVO> getHolidayList(String holidayyear,String clientCode) {
		
		return new HolidayMasterDAOImpl().getHolidayDetailDaoImpl(holidayyear,clientCode);
	}
	
	public List<HolidayMasterVO> editHolidayDetail(String holidaydate,String clientCode){
		
		return new HolidayMasterDAOImpl().editHolidayDetailDaoImpl(holidaydate,clientCode);
	}
	
	public boolean deleteSingleHoliday(String depdate, String clientcode){
		
		return new HolidayMasterDAOImpl().deleteSingleHoliday(depdate,clientcode);
	}
	
	public String dateValidate(String dateval,String clientCode){
		
		return new HolidayMasterDAOImpl().dateValidate(dateval,clientCode);
	}
	
	public ArrayList<HolidayMasterVO> getDistinctHolidayList(String clientcode, String year){
		
		return new HolidayMasterDAOImpl().getDistinctHolidayList(clientcode,year);
	}
	
	public String updateHoliday(HolidayMasterPojo hpojo) {
		
		return new HolidayMasterDAOImpl().updateHolidayDaoImpl(hpojo);
	}
	
	public String addHoliday(HolidayMasterForm holidayMasterForm,String username) {
		
		return new HolidayMasterDAOImpl().addHolidayDaoImpl(holidayMasterForm, username);
	}
	public String getAcadamicYear(String acadamicyear) {
		
		return new HolidayMasterDAOImpl().getAcadamicYear(acadamicyear);
	}

}
