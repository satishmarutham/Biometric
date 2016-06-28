package com.centris.service.serviceImpl;

import java.util.List;

import com.centris.DAO.DAOIMPL.IncorrectPunchReportDAOImpl;
import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.VO.IncorrectPunchReportVO;
import com.centris.form.IncorrectPunchReportForm;
import com.centris.service.IncorrectPunchReportService;

public class IncorrectPunchReportServiceImpl implements
		IncorrectPunchReportService {
	
	@Override
	public List<IncorrectPunchReportVO> getIncorrectPunchReport(IncorrectPunchReportForm incorrectPunchReportForm) {
		return new IncorrectPunchReportDAOImpl().getIncorrectPunchReport(incorrectPunchReportForm);
	}

	
	@Override
	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByShiftWithMultipleLocation(String shift, String group, String location) {
		return new IncorrectPunchReportDAOImpl().getEmpDetailsByShiftWithMultipleLocation(shift, group, location);
	}

	
	
	
}
