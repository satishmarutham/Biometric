package com.centris.DAO;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.HolidayMasterPojo;
import com.centris.VO.HolidayMasterVO;
import com.centris.form.HolidayMasterForm;



/**
 * @author seshuma
 *
 */
public interface HolidayMasterDAO {
	
	public ArrayList<HolidayMasterVO>  getYearDAO();
	public String addHolidayDaoImpl(HolidayMasterForm holidayMasterForm,String username);
	public String addSingleHolidayDetailDaoImpl(HolidayMasterPojo hpojo);
	public String updateHolidayDaoImpl(HolidayMasterPojo hpojo)  ;
	public List<HolidayMasterVO> editHolidayDetailDaoImpl(String holidaydate,String clientCode);
	public ArrayList<HolidayMasterVO> getHolidayDetailDaoImpl(String holidayyear,String clientCode);
	public boolean deleteSingleHoliday(String depdate,String clientcode);
	public ArrayList<HolidayMasterVO> getDistinctHolidayList(String clientcode,String year);
	public String dateValidate(String dateval,String clientCode);
	
}
