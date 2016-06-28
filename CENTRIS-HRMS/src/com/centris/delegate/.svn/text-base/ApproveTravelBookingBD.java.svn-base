package com.centris.delegate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.centris.POJO.ApproveTravekBookingPojo;
import com.centris.VO.ApproveTravelBookingVo;
import com.centris.VO.SingleTravelBookingDetailsVo;
import com.centris.form.ApproveTravelBookingForm;
import com.centris.service.ApproveTravelBookingService;
import com.centris.service.serviceImpl.ApproveTravelBookingServiceImpl;

public class ApproveTravelBookingBD {
	
	ApproveTravelBookingService approveTktService=new ApproveTravelBookingServiceImpl();
	
	public LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>> getTktBookingDetailsBD(ApproveTravelBookingForm form,String currenuserId,String userType){
		
		return approveTktService.getTktBookingDetailsService(form,currenuserId,userType);
	}
	
public ArrayList<ApproveTravelBookingVo> getTktBkngDetailsForDounloadBD(String startDate,String endDate,String currenuserId,String userType){
		
		return approveTktService.getTktBkngDetailsForDounloadService(startDate,endDate,currenuserId,userType);
	}
	
	
	public SingleTravelBookingDetailsVo getsingleTicketDetailsBD(String tktCode){
	
		return approveTktService.getsingleTicketDetailsService(tktCode);
	}
	
	public String approveSingleTicketBD(ApproveTravekBookingPojo pojo) {
		
		return approveTktService.approveSingleTicketService(pojo);
	}
	
	public ArrayList<ApproveTravelBookingVo> getConflictEmployeesBD(String startDate,String endDate,String userType,String userCode){
		
		return approveTktService.getConflictEmployeesService(startDate,endDate,userType,userCode);
	}
	
	public String approveAllTravelBookingDetailsBD(ApproveTravekBookingPojo pojo) {
		
		return approveTktService.approveAllTravelBookingDetailsService(pojo);
	}
	
	public String rejectSingleTicketBD(ApproveTravekBookingPojo pojo) {
		
		return approveTktService.rejectSingleTicketService(pojo);
	}

	
}
