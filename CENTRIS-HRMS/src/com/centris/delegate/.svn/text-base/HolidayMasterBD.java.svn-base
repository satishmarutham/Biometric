package com.centris.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.HolidayMasterPojo;
import com.centris.VO.HolidayMasterVO;
import com.centris.form.HolidayMasterForm;
import com.centris.service.serviceImpl.HolidayMasterServiceImpl;

/**
 * @author seshuma
 *
 */
public class HolidayMasterBD {
	
public String addSingleHoliday(HolidayMasterPojo hpojo){
		
		return new HolidayMasterServiceImpl().addSingleHoliday(hpojo);
	}
public ArrayList<HolidayMasterVO>  getYear(){
	
	return new HolidayMasterServiceImpl().getYear();
}

public ArrayList<HolidayMasterVO> getHolidayList(String holidayyear,String clientCode) {
	
	return new HolidayMasterServiceImpl().getHolidayList(holidayyear,clientCode);
}

public List<HolidayMasterVO> editHolidayDetail(String holidaydate,String clientCode){
	
	return new HolidayMasterServiceImpl().editHolidayDetail(holidaydate,clientCode);
}

public boolean deleteSingleHoliday(String depdate, String clientcode){
	
	return new HolidayMasterServiceImpl().deleteSingleHoliday(depdate,clientcode);
}

public String dateValidate(String dateval,String clientCode){
	
	return new HolidayMasterServiceImpl().dateValidate(dateval,clientCode);
}

public ArrayList<HolidayMasterVO> getDistinctHolidayList(String clientcode, String year){
	
	return new HolidayMasterServiceImpl().getDistinctHolidayList(clientcode,year);
}

public String updateHoliday(HolidayMasterPojo hpojo) {
	
	return new HolidayMasterServiceImpl().updateHoliday(hpojo);
}

public String addHoliday(HolidayMasterForm holidayMasterForm,String username) {
	
	return new HolidayMasterServiceImpl().addHoliday(holidayMasterForm, username);
}
public String getAcadamicYear(String acadamicyear) {

	return new HolidayMasterServiceImpl().getAcadamicYear(acadamicyear);
}


}
