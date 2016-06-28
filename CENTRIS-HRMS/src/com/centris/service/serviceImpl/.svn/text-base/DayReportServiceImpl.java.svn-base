/**
 * 
 */
package com.centris.service.serviceImpl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DayReportDao;
import com.centris.DAO.DAOIMPL.DayReportDaoImpl;
import com.centris.POJO.DayReportPojo;
import com.centris.form.DayReportForm;
import com.centris.service.DayReportService;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

/**
 * @author sathish
 *
 */
public class DayReportServiceImpl implements DayReportService{
	private static 	Logger logger = Logger.getLogger(DayReportServiceImpl.class);
	
	@Override
	public  List<DayReportPojo> getDayReportDetails(DayReportForm dayReportForm)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DayReportServiceImpl:getDayReportDetails Starting");

	    DayReportPojo dayReportPojo=new DayReportPojo();
	    dayReportPojo.setDesignation(dayReportForm.getDesignation());
	dayReportPojo.setGroupCode(dayReportForm.getGroupId());
		dayReportPojo.setEmployeeId(dayReportForm.getEmployee());
		dayReportPojo.setLocationCode(dayReportForm.getLocation());
		dayReportPojo.setStartDate(dayReportForm.getStartDate());
		dayReportPojo.setEndDate(dayReportForm.getEndDate());
	
		return new DayReportDaoImpl().getDayReportDetails(dayReportPojo);
	
	
}
	}


