package com.centris.service.serviceImpl;

import java.util.List;

import com.centris.DAO.DAOIMPL.LocationUpdateReportDAOImpl;
import com.centris.VO.LocationUpdateReportVO;
import com.centris.form.LocationUpdateReportForm;
import com.centris.service.LocationUpdateReportService;

public class LocationUpdateReportServiceImpl implements LocationUpdateReportService {
	public List<LocationUpdateReportVO> getLocationUpdateReport(LocationUpdateReportForm locationUpdateReportForm){
		return new LocationUpdateReportDAOImpl().getLocationUpdateReport(locationUpdateReportForm);
		
	}
}
