package com.centris.delegate;

import java.util.ArrayList;

import com.centris.DAO.DAOIMPL.MonthlyLagendReportDaoImpl;
import com.centris.VO.MonthlyLagendReportVo;
import com.centris.form.MonthlyLagendReportForm;
import com.centris.service.serviceImpl.MonthlyLagendReportServiceImpl;

public class MonthlyLagendReportBD {
	
	public ArrayList<MonthlyLagendReportVo> getShiftBasedLocation(String locId,String groupid){
		
		return new MonthlyLagendReportServiceImpl().getShiftBasedLocation(locId,groupid);
	}
	
	public ArrayList<MonthlyLagendReportVo> getDeptBasedLocation() {
		
		return new MonthlyLagendReportServiceImpl().getDeptBasedLocation();
	}
	
	public ArrayList<MonthlyLagendReportVo> getLocationbyGroup(String groupid) {
		return new MonthlyLagendReportServiceImpl().getLocationbyGroup(groupid);
	}

	public ArrayList<MonthlyLagendReportVo> internalMonthlyLagendReport(MonthlyLagendReportForm mform) {
		return	new MonthlyLagendReportServiceImpl().internalMonthlyLagendReport(mform);	
		
	}
   public ArrayList<MonthlyLagendReportVo> externalMonthlyLagendReport(
			MonthlyLagendReportForm mform) {
		
		return new MonthlyLagendReportServiceImpl().externalMonthlyLagendReport(mform);	
	}

	

}
