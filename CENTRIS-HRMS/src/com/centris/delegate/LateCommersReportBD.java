/**
 * 
 */
package com.centris.delegate;

import java.util.List;

import com.centris.POJO.LateCommersReportPojo;
import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.form.LateCommersReportForm;
import com.centris.service.serviceImpl.ConsolidateDetailedMonthReportServiceImpl;
import com.centris.service.serviceImpl.LateCommersReportServiceImpl;

/**
 * @author sathish
 *
 */
public class LateCommersReportBD {
	public List<LateCommersReportPojo> getLateCommersReport(LateCommersReportForm lateCommersReportForm)throws Exception{
		return new LateCommersReportServiceImpl().getLateCommersReport(lateCommersReportForm);
	}
	public List<LateCommersReportPojo> getEarlyTimeReport(LateCommersReportForm earlyTimeReportForm)throws Exception{
		return new LateCommersReportServiceImpl().getEarlyTimeReport(earlyTimeReportForm);
	}
	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByShift(String shift,String group,String location) throws Exception{
		return new LateCommersReportServiceImpl().getEmpDetailsByShift(shift,group,location);
	}
}
