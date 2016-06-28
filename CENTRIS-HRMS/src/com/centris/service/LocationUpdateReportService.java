package com.centris.service;

import java.util.List;

import com.centris.VO.LocationUpdateReportVO;
import com.centris.form.LocationUpdateReportForm;

public interface LocationUpdateReportService {
	public List<LocationUpdateReportVO> getLocationUpdateReport(LocationUpdateReportForm locationUpdateReportForm);
}
