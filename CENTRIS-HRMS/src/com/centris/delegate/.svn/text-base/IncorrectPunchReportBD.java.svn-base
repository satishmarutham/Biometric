package com.centris.delegate;

import java.util.List;

import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.VO.IncorrectPunchReportVO;
import com.centris.form.IncorrectPunchReportForm;
import com.centris.service.serviceImpl.IncorrectPunchReportServiceImpl;

public class IncorrectPunchReportBD {

	public List<IncorrectPunchReportVO> getIncorrectPunchReport(IncorrectPunchReportForm incorrectPunchReportForm) {
		return new IncorrectPunchReportServiceImpl().getIncorrectPunchReport(incorrectPunchReportForm);
	}


	
	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByShiftWithMultipleLocation(String shift, String group, String location) {
		return new IncorrectPunchReportServiceImpl().getEmpDetailsByShiftWithMultipleLocation(shift, group, location);
	}

	
}
