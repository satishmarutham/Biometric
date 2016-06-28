package com.centris.DAO;

import java.util.List;

import com.centris.VO.LocationUpdateReportVO;
import com.centris.form.LocationUpdateReportForm;

public interface LocationUpdateReportDAO {
	public List<LocationUpdateReportVO> getLocationUpdateReport(LocationUpdateReportForm locationUpdateReportForm);
}
