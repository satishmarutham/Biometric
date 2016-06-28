package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.centris.DAO.TravelAllowancesReportDao;
import com.centris.DAO.DAOIMPL.TravelAllowancesReportDaoImpl;
import com.centris.POJO.TravelAllowancesReportPojo;
import com.centris.VO.TravelAllowancesReportVo;
import com.centris.service.TravelAllowancesReportService;
import com.centris.util.constants.MessageConstants;

public class TravelAllowancesReportServiceImpl implements TravelAllowancesReportService {

	public Map<String, ArrayList<TravelAllowancesReportVo>> getTravelAllowancesService(TravelAllowancesReportPojo travelAllowanceReportPojo) {

		Map<String, ArrayList<TravelAllowancesReportVo>> travelallowancemap=new LinkedHashMap<String, ArrayList<TravelAllowancesReportVo>>();
		TravelAllowancesReportDao travelAllowancesReportDao=new TravelAllowancesReportDaoImpl();
	
	        try{
	        	
	      	   if(MessageConstants.GROUP_BY_MANAGER.equalsIgnoreCase(travelAllowanceReportPojo.getGroupby())){
			
			        travelallowancemap=travelAllowancesReportDao.getTravelAllowancesManagerWiseDao(travelAllowanceReportPojo);
		  
		      }else{
			   
			      travelallowancemap=travelAllowancesReportDao.getTravelAllowancesProjectWiseDao(travelAllowanceReportPojo);
			   
		        }
	
		}catch(Exception e){
			e.printStackTrace();
		}
	
		return travelallowancemap;
	}

	
	
	
	
	public ArrayList<TravelAllowancesReportVo> getTravelAllowancesfordownloadService(
			TravelAllowancesReportPojo travelAllowanceReportPojo) {
	
		ArrayList<TravelAllowancesReportVo> travelallowancelist=new ArrayList<TravelAllowancesReportVo>();
		TravelAllowancesReportDao travelAllowancesReportDao=new TravelAllowancesReportDaoImpl();
		
	     try{
		
	    	 travelallowancelist = travelAllowancesReportDao.getTravelAllowancesfordownloadDao(travelAllowanceReportPojo);
	    	 
	     }catch(Exception e){
				e.printStackTrace();
			}
		return travelallowancelist;
	}

}
