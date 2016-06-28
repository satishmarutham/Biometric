package com.centris.DAO;

import java.sql.Connection;
import java.util.List;

import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.VO.DetailedMonthVo_Report;
import com.centris.form.ConsolidateDetailedMonthReportForm;

public interface ConsolidateDetailedMonthReportDAO {
	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByShift(String shift,String group,String location);
	public List<ConsolidateDetailedMonthReportVO> getConsolidatedMonthReport(ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm);
	public List<ConsolidateDetailedMonthReportVO> getDetailedMonthReport(ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm);
	public List<ConsolidateDetailedMonthReportVO> getConsolidatedMonthReportN(ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm,String year,Connection dbconn);
	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByDesiWithMultipleLocation(String shift, String group, String location);
	public List<DetailedMonthVo_Report> getDetailedReport(ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm);

}
