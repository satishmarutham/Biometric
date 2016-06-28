package com.centris.service.serviceImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.centris.DAO.ConsolidateDetailedMonthReportDAO;
import com.centris.DAO.DBService;
import com.centris.DAO.DAOIMPL.ConsolidateDetailedMonthReportDAOImpl;
import com.centris.VO.ConsolidateDetailedDayReportVO;
import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.VO.DetailedMonthVo_Report;
import com.centris.form.ConsolidateDetailedMonthReportForm;
import com.centris.service.ConsolidateDetailedMonthReportService;
import com.centris.util.HelperClass;

public class ConsolidateDetailedMonthReportServiceImpl implements
		ConsolidateDetailedMonthReportService {
	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByShift(
			String shift, String group, String location) {
		return new ConsolidateDetailedMonthReportDAOImpl()
				.getEmpDetailsByShift(shift, group, location);
	}

	public List<ConsolidateDetailedMonthReportVO> getConsolidatedMonthReport(
			ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm) {
		return new ConsolidateDetailedMonthReportDAOImpl()
				.getConsolidatedMonthReport(consolidateDetailedMonthReportForm);
	}

	@Override
	public List<ConsolidateDetailedMonthReportVO> getDetailedMonthReport(
			ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm) {
		return new ConsolidateDetailedMonthReportDAOImpl()
				.getDetailedMonthReport(consolidateDetailedMonthReportForm);
	}

	/* Consolidated report for Accordian */
	public synchronized Map<String, List<ConsolidateDetailedMonthReportVO>> getConsolidatedMonthReportN(
			ConsolidateDetailedMonthReportForm consolidateform) {

		Map<String, List<ConsolidateDetailedMonthReportVO>> consolidatedMap = new LinkedHashMap<String, List<ConsolidateDetailedMonthReportVO>>();

		try {
			DBService dbService = new DBService();

			Connection conn = dbService.getConnection();

			ConsolidateDetailedMonthReportDAO listDao = new ConsolidateDetailedMonthReportDAOImpl();
			String year = consolidateform.getYear();

			String minDate = consolidateform.getYear().trim() + "-"
					+ consolidateform.getMonth() + "-01";

			String maxDay = HelperClass.lastDayOftheMonth(consolidateform
					.getYear().trim(), consolidateform.getMonth().trim());
			String maxDate = consolidateform.getYear().trim() + "-"
					+ consolidateform.getMonth() + "-" + maxDay;

			List<String> allDates = HelperClass.getDateListBetweenDates(
					minDate, maxDate);

			for (int i = 0; i < allDates.size(); i++) {

				List<ConsolidateDetailedMonthReportVO> voList = new ArrayList<ConsolidateDetailedMonthReportVO>();
				voList = listDao.getConsolidatedMonthReportN(consolidateform,
						allDates.get(i),conn);

				Collections.sort(voList,
						new Comparator<ConsolidateDetailedMonthReportVO>() {

							@Override
							public int compare(
									ConsolidateDetailedMonthReportVO o1,
									ConsolidateDetailedMonthReportVO o2) {
								return o1.getDate().compareTo(o2.getDate());
							}
						});
				if (voList.size() > 0) {
					consolidatedMap.put(
							HelperClass.convertDatabaseToUI(allDates.get(i)),
							voList);
				}
			}
			conn.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}

		return consolidatedMap;
	}

	public List<ConsolidateDetailedDayReportVO> consolidatedMonthReport_forDay(
			ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm) {
		return new ConsolidateDetailedMonthReportDAOImpl()
				.consolidatedMonthReport_forDay(consolidateDetailedMonthReportForm);
	}

	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByDesiWithMultipleLocation(
			String designation, String group, String location) {
		return new ConsolidateDetailedMonthReportDAOImpl()
				.getEmpDetailsByDesiWithMultipleLocation(designation, group,
						location);
	}

	public static void main(String[] args) {
		ConsolidateDetailedMonthReportForm cf = new ConsolidateDetailedMonthReportForm();
		cf.setGroup("GRP4");
		cf.setLocation("%%");
		cf.setMonth("09");
		cf.setYear("2014");
		cf.setDesignation("%%");
		cf.setEmployee("%%");

		ConsolidateDetailedMonthReportServiceImpl kk = new ConsolidateDetailedMonthReportServiceImpl();
		kk.getConsolidatedMonthReportN(cf);
	}

	@Override
	public List<DetailedMonthVo_Report> getDetailedReport(
			ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm) {
		// TODO Auto-generated method stub
		return new ConsolidateDetailedMonthReportDAOImpl().getDetailedReport(consolidateDetailedMonthReportForm);
	}

	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByDesignation(
			String designation, String group, String location) {
		return new ConsolidateDetailedMonthReportDAOImpl()
				.getEmpDetailsByDesignation(designation, group,
						location);
	}
}
