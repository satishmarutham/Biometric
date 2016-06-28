package com.centris.delegate;

import java.util.ArrayList;
import java.util.Map;

import com.centris.POJO.TravelBookedDetailsPOJO;
import com.centris.VO.EmployeeSearchInTravelBookedVO;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.TravelBookedDetailsVo;
import com.centris.service.TravelBookedDetailsService;
import com.centris.service.serviceImpl.TravelBookedDetailsServiceImpl;

public class TravelBookedDetailsBD {

	public ArrayList<EmployeeSearchInTravelBookedVO> getSearchEmployee(String searchTerm) {
		
		TravelBookedDetailsService travelBookedDetailsService=new TravelBookedDetailsServiceImpl();
	
		return travelBookedDetailsService.getSearchEmployee(searchTerm);
	}

	public ArrayList<ProjectMasterVo> getAllprojects() {
		
		TravelBookedDetailsService travelBookedDetailsService=new TravelBookedDetailsServiceImpl();
		
		return travelBookedDetailsService.getAllprojects();

	}

	public String saveTravelBookedDetails(TravelBookedDetailsPOJO travelBookedDetailsPOJO) {

		TravelBookedDetailsService travelBookedDetailsService=new TravelBookedDetailsServiceImpl();
		
		return travelBookedDetailsService.saveTravelBookedDetails(travelBookedDetailsPOJO);
	}

	public boolean checkManager(String projectRefCode) {
	
		TravelBookedDetailsService travelBookedDetailsService=new TravelBookedDetailsServiceImpl();
		
		return travelBookedDetailsService.checkManager(projectRefCode);
	}

	public 	ArrayList<TravelBookedDetailsVo> getBookedDetails(String userCode) {

		TravelBookedDetailsService travelBookedDetailsService=new TravelBookedDetailsServiceImpl();
		
		return travelBookedDetailsService.getBookedDetails(userCode);
	}

	public TravelBookedDetailsVo checkvalidateTravelDate(String travellingDate,String whoisontravelempid, String postedby) {

		TravelBookedDetailsService travelBookedDetailsService=new TravelBookedDetailsServiceImpl();
		
		return travelBookedDetailsService.checkvalidateTravelDate(travellingDate,whoisontravelempid,postedby);
	}

}
