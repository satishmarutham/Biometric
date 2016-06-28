package com.centris.service;

import java.util.ArrayList;
import java.util.Map;

import com.centris.POJO.TravelBookedDetailsPOJO;
import com.centris.VO.EmployeeSearchInTravelBookedVO;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.TravelBookedDetailsVo;

public interface TravelBookedDetailsService {

	ArrayList<EmployeeSearchInTravelBookedVO> getSearchEmployee(String searchTerm);

	ArrayList<ProjectMasterVo> getAllprojects();

	String saveTravelBookedDetails(TravelBookedDetailsPOJO travelBookedDetailsPOJO);

	boolean checkManager(String projectRefCode);

	ArrayList<TravelBookedDetailsVo> getBookedDetails(String userCode);

	TravelBookedDetailsVo checkvalidateTravelDate(String travellingDate,String whoisontravelempid, String postedby);

}
