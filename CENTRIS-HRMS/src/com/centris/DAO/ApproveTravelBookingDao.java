package com.centris.DAO;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.centris.POJO.ApproveTravekBookingPojo;
import com.centris.VO.ApproveTravelBookingVo;
import com.centris.VO.SingleTravelBookingDetailsVo;
import com.centris.form.ApproveTravelBookingForm;

public interface ApproveTravelBookingDao {
	
	public LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>> getTktBookingDetailsDao(
			ApproveTravelBookingForm form, String currenuserId,String userType);
	
	public SingleTravelBookingDetailsVo getTktBookingDetailsDao(String tktCode);
	public String approveSingleTicketDao(ApproveTravekBookingPojo pojo);
	public ArrayList<ApproveTravelBookingVo> getConflictEmployeesDao(
			String startDate,String endDate,String userType,String userCode);
	public ArrayList<ApproveTravelBookingVo> getTktBkngDetailsForDounloadDao(
			String startDate, String endDate, String currenuserId,
			String userType);
	public String approveAllTravelBookingDetailsDao(ApproveTravekBookingPojo pojo);
	public String rejectSingleTicketDao(ApproveTravekBookingPojo pojo);
	
}
