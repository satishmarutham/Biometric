/**
 * 
 */
package com.centris.delegate;

import java.util.List;

import com.centris.POJO.DayReportPojo;
import com.centris.form.DayReportForm;
import com.centris.service.serviceImpl.DayReportServiceImpl;

/**
 * @author sathish
 *
 */
public class DayReportBD {
	
	public List<DayReportPojo>  getDayReportDetails(DayReportForm dayReportForm)throws Exception
	{
		return new DayReportServiceImpl().getDayReportDetails(dayReportForm);
	}
	
}
