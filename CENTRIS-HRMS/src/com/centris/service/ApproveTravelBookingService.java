package com.centris.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.centris.POJO.ApproveTravekBookingPojo;
import com.centris.VO.ApproveTravelBookingVo;
import com.centris.VO.SingleTravelBookingDetailsVo;
import com.centris.form.ApproveTravelBookingForm;

public interface ApproveTravelBookingService {
	
	public LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>> getTktBookingDetailsService(ApproveTravelBookingForm form,String currenuserId,String userType);
	public SingleTravelBookingDetailsVo getsingleTicketDetailsService(String tktCode);
	public String approveSingleTicketService(ApproveTravekBookingPojo pojo);
	public ArrayList<ApproveTravelBookingVo> getConflictEmployeesService(String startDate,String endDate,String userType,String userCode);
	public ArrayList<ApproveTravelBookingVo> getTktBkngDetailsForDounloadService(String startDate,String endDate,String currenuserId,String userType);
	public String approveAllTravelBookingDetailsService(ApproveTravekBookingPojo pojo);
	public String rejectSingleTicketService(ApproveTravekBookingPojo pojo);

}
