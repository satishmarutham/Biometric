package com.centris.delegate;

import java.util.List;

import com.centris.VO.TodayReportVO;
import com.centris.form.TodayReportForm;
import com.centris.service.serviceImpl.TodayReportServiceImpl;

public class TodayReportBD {
	public List<TodayReportVO> getEmpDetailsByLocation(String group,String location){
		return new TodayReportServiceImpl().getEmpDetailsByLocation(group,location);
	}
	public List<TodayReportVO> getTodayReport(TodayReportForm todayReportForm){
		return new TodayReportServiceImpl().getTodayReport(todayReportForm);
	}
	
	
}
