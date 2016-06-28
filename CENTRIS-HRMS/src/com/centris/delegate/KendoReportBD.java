package com.centris.delegate;

import java.util.ArrayList;

import com.centris.VO.KendoReportVo;
import com.centris.service.KendoReportService;
import com.centris.service.serviceImpl.KendoReportServiceImpl;

public class KendoReportBD {
	KendoReportService obj = new KendoReportServiceImpl();

	public ArrayList<KendoReportVo> getReportCountDetails(String todaydate) {
		ArrayList<KendoReportVo> alldetails = new ArrayList<KendoReportVo>();

		alldetails = obj.getReportCountDetails(todaydate);

		return alldetails;
	}
}