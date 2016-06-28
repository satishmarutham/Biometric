package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.Map;

import com.centris.DAO.TravelBookedDetailsDao;
import com.centris.DAO.DAOIMPL.TravelBookedDetailsDaoImpl;
import com.centris.POJO.TravelBookedDetailsPOJO;
import com.centris.VO.EmployeeSearchInTravelBookedVO;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.TravelBookedDetailsVo;
import com.centris.service.TravelBookedDetailsService;

public class TravelBookedDetailsServiceImpl implements TravelBookedDetailsService{

	
	public ArrayList<EmployeeSearchInTravelBookedVO> getSearchEmployee(String searchTerm) {

		TravelBookedDetailsDao travelBookedDetailsDao=new TravelBookedDetailsDaoImpl();
		
		return travelBookedDetailsDao.getSearchEmployee(searchTerm);
	}

	public ArrayList<ProjectMasterVo> getAllprojects() {

		TravelBookedDetailsDao travelBookedDetailsDao=new TravelBookedDetailsDaoImpl();
		
		return travelBookedDetailsDao.getAllprojects();
	}

	public String saveTravelBookedDetails(TravelBookedDetailsPOJO travelBookedDetailsPOJO) {

		TravelBookedDetailsDao travelBookedDetailsDao=new TravelBookedDetailsDaoImpl();
		
		return travelBookedDetailsDao.saveTravelBookedDetails(travelBookedDetailsPOJO);
	}

	public boolean checkManager(String projectRefCode) {

		TravelBookedDetailsDao travelBookedDetailsDao=new TravelBookedDetailsDaoImpl();
		
		return travelBookedDetailsDao.checkManager(projectRefCode);
	}

	public 	ArrayList<TravelBookedDetailsVo> getBookedDetails(String userCode) {
		
	TravelBookedDetailsDao travelBookedDetailsDao=new TravelBookedDetailsDaoImpl();
		
		return travelBookedDetailsDao.getBookedDetails(userCode);
	}


	public TravelBookedDetailsVo checkvalidateTravelDate(String travellingDate,String whoisontravelempid,String postedby) {

	TravelBookedDetailsDao travelBookedDetailsDao=new TravelBookedDetailsDaoImpl();
		
		return travelBookedDetailsDao.checkvalidateTravelDate(travellingDate,whoisontravelempid,postedby);
	}
	
	

}
