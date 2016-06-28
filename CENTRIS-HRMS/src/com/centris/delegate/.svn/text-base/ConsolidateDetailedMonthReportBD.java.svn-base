package com.centris.delegate;

import java.util.List;
import java.util.Map;

import com.centris.VO.ConsolidateDetailedDayReportVO;
import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.VO.DetailedMonthVo_Report;
import com.centris.form.ConsolidateDetailedMonthReportForm;
import com.centris.service.serviceImpl.ConsolidateDetailedMonthReportServiceImpl;

public class ConsolidateDetailedMonthReportBD {
	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByShift(
			String shift, String group, String location) {
		return new ConsolidateDetailedMonthReportServiceImpl()
				.getEmpDetailsByShift(shift, group, location);
	}

	public List<ConsolidateDetailedMonthReportVO> getConsolidatedMonthReport(
			ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm) {
		return new ConsolidateDetailedMonthReportServiceImpl()
				.getConsolidatedMonthReport(consolidateDetailedMonthReportForm);
	}

	public List<ConsolidateDetailedMonthReportVO> getDetailedMonthReport(
			ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm) {
		return new ConsolidateDetailedMonthReportServiceImpl()
				.getDetailedMonthReport(consolidateDetailedMonthReportForm);
	}

	public Map<String, List<ConsolidateDetailedMonthReportVO>> getConsolidatedMonthReportN(
			ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm) {
		return new ConsolidateDetailedMonthReportServiceImpl()
				.getConsolidatedMonthReportN(consolidateDetailedMonthReportForm);
	}

	public List<ConsolidateDetailedDayReportVO> consolidatedMonthReport_forDay(
			ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm) {
		return new ConsolidateDetailedMonthReportServiceImpl()
				.consolidatedMonthReport_forDay(consolidateDetailedMonthReportForm);
	}
	
	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByDesiWithMultipleLocation(String designation, String group, String location) {
		return new ConsolidateDetailedMonthReportServiceImpl().getEmpDetailsByDesiWithMultipleLocation(designation, group, location);
	}
	public List<DetailedMonthVo_Report> getDetailedReport(
			ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm) {
		return new ConsolidateDetailedMonthReportServiceImpl()
				.getDetailedReport(consolidateDetailedMonthReportForm);
	}
	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByDesignation(String designation, String group, String location) {
		return new ConsolidateDetailedMonthReportServiceImpl().getEmpDetailsByDesignation(designation, group, location);
	}
}
