package com.centris.service.serviceImpl;

import java.util.List;
import java.util.Map;

import com.centris.DAO.DAOIMPL.LastThreeAbsentReportDAOImpl;
import com.centris.VO.LastThreeAbsentReportVO;
import com.centris.form.LastThreeAbsentReportForm;
import com.centris.service.LastThreeAbsentReportService;

public class LastThreeAbsentReportServiceImpl implements
		LastThreeAbsentReportService {
	
	@Override
	public Map<String,List<LastThreeAbsentReportVO>> getLastThreeAbsentReport(LastThreeAbsentReportForm lastThreeAbsentReportForm) {
		return new LastThreeAbsentReportDAOImpl().getLastThreeAbsentReport(lastThreeAbsentReportForm);
	}

	
	
	
	
}
