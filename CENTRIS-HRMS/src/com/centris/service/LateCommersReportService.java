/**
 * 
 */
package com.centris.service;

import java.util.List;

import com.centris.POJO.LateCommersReportPojo;
import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.form.LateCommersReportForm;

/**
 * @author sathish
 *
 */
public interface LateCommersReportService {
	public List<LateCommersReportPojo> getLateCommersReport(LateCommersReportForm lateCommersReportForm) throws Exception;
	public List<LateCommersReportPojo> getEarlyTimeReport(LateCommersReportForm lateCommersReportForm) throws Exception;
	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByShift(String shift,String group,String location) throws Exception;
}
