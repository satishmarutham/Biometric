package com.centris.service;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.HolidayMasterPojo;
import com.centris.VO.HolidayMasterVO;
import com.centris.form.HolidayMasterForm;


/**
 * @author seshuma
 *
 */
public interface HolidayMasterService {
	
	public String addSingleHoliday(HolidayMasterPojo hpojo);
	public ArrayList<HolidayMasterVO>  getYear();
	public ArrayList<HolidayMasterVO> getHolidayList(String holidayyear, String department);
	public List<HolidayMasterVO> editHolidayDetail(String holidaydate);
	public boolean deleteSingleHoliday(String depdate);
	public String dateValidate(String dateval,String clientCode);
	public ArrayList<String> getDistinctHolidayList();
	public String updateHoliday(HolidayMasterPojo hpojo);
	public String addHoliday(HolidayMasterForm holidayMasterForm,String username);

}
