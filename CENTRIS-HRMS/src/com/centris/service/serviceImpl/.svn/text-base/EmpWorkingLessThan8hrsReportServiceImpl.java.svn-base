/**
 * 
 */
package com.centris.service.serviceImpl;

import java.util.List;

import com.centris.DAO.DAOIMPL.EmpWorkingLessThan8hrsReportDaoImpl;
import com.centris.POJO.EmpWorkingLessThan8hrsReportPojo;
import com.centris.form.EmpWorkingLessThan8hrsReportForm;
import com.centris.service.EmpWorkingLessThan8hrsReportService;

/**
 * @author sathish
 *
 */
public class EmpWorkingLessThan8hrsReportServiceImpl implements EmpWorkingLessThan8hrsReportService
{


	public List<EmpWorkingLessThan8hrsReportPojo> getEmpWorkinglessThen8hrs(EmpWorkingLessThan8hrsReportForm form) throws Exception {
		EmpWorkingLessThan8hrsReportPojo pojo=new EmpWorkingLessThan8hrsReportPojo();
		pojo.setEmployeeId(form.getEmployee());
		pojo.setStartDate(form.getStartDate());
		pojo.setEndDate(form.getEndDate());
		// TODO Auto-generated method stub
		return new EmpWorkingLessThan8hrsReportDaoImpl().getEmpWorkinglessThen8hrs(pojo);
	}

}
