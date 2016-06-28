package com.centris.service;

import java.util.List;

import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.VO.DetailedMonthVo_Report;
import com.centris.form.ConsolidateDetailedMonthReportForm;

public interface ConsolidateDetailedMonthReportService {
	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByShift(String shift,String group,String location);
	public List<ConsolidateDetailedMonthReportVO> getConsolidatedMonthReport(ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm);
	public List<ConsolidateDetailedMonthReportVO> getDetailedMonthReport(ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm);
	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByDesiWithMultipleLocation(String designation, String group, String location);
	public List<DetailedMonthVo_Report> getDetailedReport(ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm);

}
