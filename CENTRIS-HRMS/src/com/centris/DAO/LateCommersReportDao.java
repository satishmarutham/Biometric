/**
 * 
 */
package com.centris.DAO;

import java.util.List;

import com.centris.POJO.LateCommersReportPojo;
import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.form.LateCommersReportForm;

/**
 * @author sathish
 *
 */
public interface LateCommersReportDao {
	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByShift(String shift,String group,String location) throws Exception;
	public List<LateCommersReportPojo> getLateCommersReport(LateCommersReportPojo lateCommersReportPojo) throws Exception;
	public List<LateCommersReportPojo> getEarlyTimeReport(LateCommersReportPojo lateCommersReportPojo) throws Exception;
}
