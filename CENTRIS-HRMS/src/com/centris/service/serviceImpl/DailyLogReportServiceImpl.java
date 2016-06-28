package com.centris.service.serviceImpl;

import java.util.List;

import com.centris.DAO.DAOIMPL.DailyLogReportDaoImpl;
import com.centris.VO.DailyLogReportVO;
import com.centris.form.DailyLogReportForm;
import com.centris.service.DailyLogReportService;

public class DailyLogReportServiceImpl implements DailyLogReportService{

	public List<DailyLogReportVO> getDailyLogReport(DailyLogReportForm dailyLogReportform) {
		
		return new DailyLogReportDaoImpl().getDailyLogReport(dailyLogReportform);
	}

	public List<DailyLogReportVO> getEmpDetailsByDesiWithLocation(
			String designation, String group, String location) {
		
		return new DailyLogReportDaoImpl().getEmpDetailsByDesiWithLocation(
				 designation,  group,  location);
	}

}
