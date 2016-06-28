package com.centris.service;

import java.util.List;

import com.centris.POJO.DayReportPojo;
import com.centris.form.DayReportForm;

public interface DayReportService {
	
	public List<DayReportPojo> getDayReportDetails(DayReportForm dayReportForm)throws Exception;
	
}
