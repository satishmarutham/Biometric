package com.centris.service.serviceImpl;

import java.util.ArrayList;

import com.centris.DAO.KendoReportDao;
import com.centris.DAO.DAOIMPL.KendoReportDaoImpl;
import com.centris.VO.KendoReportVo;
import com.centris.service.KendoReportService;

public class KendoReportServiceImpl implements KendoReportService {
	KendoReportDao obj = new KendoReportDaoImpl();

	public ArrayList<KendoReportVo> getReportCountDetails(String todaydate) {
		ArrayList<KendoReportVo> allDetails = new ArrayList<KendoReportVo>();
		try {
			allDetails = obj.getReportCountDetails(todaydate);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return allDetails;
	}
}
