package com.centris.service;

import java.util.ArrayList;
import java.util.Map;

import com.centris.POJO.TravelAllowancesReportPojo;
import com.centris.VO.TravelAllowancesReportVo;

public interface TravelAllowancesReportService {

	Map<String, ArrayList<TravelAllowancesReportVo>> getTravelAllowancesService(
			TravelAllowancesReportPojo travelAllowanceReportPojo);

	ArrayList<TravelAllowancesReportVo> getTravelAllowancesfordownloadService(
			TravelAllowancesReportPojo travelAllowanceReportPojo);

}
