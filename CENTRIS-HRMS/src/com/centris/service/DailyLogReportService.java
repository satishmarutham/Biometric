package com.centris.service;

import java.util.List;

import com.centris.VO.DailyLogReportVO;
import com.centris.form.DailyLogReportForm;

public interface DailyLogReportService {
	public List<DailyLogReportVO> getDailyLogReport(DailyLogReportForm dailyLogReportform);
}
