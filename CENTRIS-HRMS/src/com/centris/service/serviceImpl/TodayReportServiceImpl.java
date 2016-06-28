package com.centris.service.serviceImpl;

import java.util.List;

import com.centris.DAO.DAOIMPL.TodayReportDAOImpl;
import com.centris.VO.TodayReportVO;
import com.centris.form.TodayReportForm;
import com.centris.service.TodayReportService;

public class TodayReportServiceImpl implements TodayReportService{
	public List<TodayReportVO> getEmpDetailsByLocation(String group,String location){
		return new TodayReportDAOImpl().getEmpDetailsByLocation(group,location);
	}
	@Override
	public List<TodayReportVO> getTodayReport(TodayReportForm todayReportForm) {
		return new TodayReportDAOImpl().getTodayReport(todayReportForm);
	}
}
