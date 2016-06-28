package com.centris.delegate;

import java.util.List;

import com.centris.VO.DailyLogReportVO;
import com.centris.VO.TodayReportVO;
import com.centris.form.DailyLogReportForm;
import com.centris.service.serviceImpl.DailyLogReportServiceImpl;

public class DailyLogReportBD {

	public List<DailyLogReportVO> getDailyLogReport(DailyLogReportForm dailyLogReportform) {
			
		return new  DailyLogReportServiceImpl().getDailyLogReport(dailyLogReportform);
	}

	public List<DailyLogReportVO> getEmpDetailsByDesiWithLocation(
			String designation, String group, String location) {
		
		return new DailyLogReportServiceImpl().getEmpDetailsByDesiWithLocation(
				 designation,  group,  location) ;
	}

	
}
