/**
 * 
 */
package com.centris.service.serviceImpl;

import java.util.List;

import com.centris.DAO.DAOIMPL.LateCommersReportDaoImpl;
import com.centris.POJO.LateCommersReportPojo;
import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.form.LateCommersReportForm;
import com.centris.service.LateCommersReportService;

/**
 * @author sathish
 *
 */
public class LateCommersReportServiceImpl implements LateCommersReportService {

	@Override
	public List<LateCommersReportPojo> getLateCommersReport(LateCommersReportForm lateCommersReportForm) throws Exception {
		LateCommersReportPojo lateCommersReportPojo=new LateCommersReportPojo();
		lateCommersReportPojo.setEmployeeId(lateCommersReportForm.getEmployee());
		lateCommersReportPojo.setStartDate(lateCommersReportForm.getStartDate());
		lateCommersReportPojo.setEndDate(lateCommersReportForm.getEndDate());
		// TODO Auto-generated method stub
		return new  LateCommersReportDaoImpl().getLateCommersReport(lateCommersReportPojo);
	}

	@Override
	public List<LateCommersReportPojo> getEarlyTimeReport(
			LateCommersReportForm earlyTimeReportForm) throws Exception {
		LateCommersReportPojo earlyTimeReportPojo=new LateCommersReportPojo();
		earlyTimeReportPojo.setEmployeeId(earlyTimeReportForm.getEmployee());
		earlyTimeReportPojo.setStartDate(earlyTimeReportForm.getStartDate());
		earlyTimeReportPojo.setEndDate(earlyTimeReportForm.getEndDate());
		// TODO Auto-generated method stub
		return new LateCommersReportDaoImpl().getEarlyTimeReport(earlyTimeReportPojo);
	}

	@Override
	public List<ConsolidateDetailedMonthReportVO> getEmpDetailsByShift(
			String shift, String group, String location) throws Exception {
		// TODO Auto-generated method stub
		return new LateCommersReportDaoImpl().getEmpDetailsByShift(shift, group, location);
	}
	
}
