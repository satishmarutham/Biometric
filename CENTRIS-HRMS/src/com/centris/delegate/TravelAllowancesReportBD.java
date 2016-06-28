package com.centris.delegate;

import java.util.ArrayList;
import java.util.Map;

import com.centris.POJO.TravelAllowancesReportPojo;
import com.centris.VO.TravelAllowancesReportVo;
import com.centris.service.TravelAllowancesReportService;
import com.centris.service.serviceImpl.TravelAllowancesReportServiceImpl;

public class TravelAllowancesReportBD {

	public Map<String, ArrayList<TravelAllowancesReportVo>> getTravelAllowancesBD(TravelAllowancesReportPojo travelAllowanceReportPojo) {

		
		TravelAllowancesReportService  travelAllowancesReportService =new TravelAllowancesReportServiceImpl();
		
		
		return travelAllowancesReportService.getTravelAllowancesService(travelAllowanceReportPojo);
	}

	public ArrayList<TravelAllowancesReportVo> getTravelAllowancesfordownloadBD(
			TravelAllowancesReportPojo travelAllowanceReportPojo) {
	
        TravelAllowancesReportService  travelAllowancesReportService =new TravelAllowancesReportServiceImpl();
		
		
		return travelAllowancesReportService.getTravelAllowancesfordownloadService(travelAllowanceReportPojo);
	}

}
