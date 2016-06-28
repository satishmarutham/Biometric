package com.centris.DAO;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

import com.centris.DAO.DAOIMPL.AddDesignationDaoImpl;
import com.centris.POJO.TravelAllowancesReportPojo;
import com.centris.VO.TravelAllowancesReportVo;

public interface TravelAllowancesReportDao {

		
	Map<String, ArrayList<TravelAllowancesReportVo>> getTravelAllowancesManagerWiseDao(
			TravelAllowancesReportPojo travelAllowanceReportPojo);

	Map<String, ArrayList<TravelAllowancesReportVo>> getTravelAllowancesProjectWiseDao(
			TravelAllowancesReportPojo travelAllowanceReportPojo);

	ArrayList<TravelAllowancesReportVo> getTravelAllowancesfordownloadDao(
			TravelAllowancesReportPojo travelAllowanceReportPojo);

}
