/**
 * 
 */
package com.centris.delegate;

import java.util.List;

import com.centris.POJO.EmpWorkingLessThan8hrsReportPojo;
import com.centris.form.EmpWorkingLessThan8hrsReportForm;
import com.centris.service.serviceImpl.EmpWorkingLessThan8hrsReportServiceImpl;

/**
 * @author sathish
 *
 */
public class EmpWorkingLessThan8hrsReportBD {
public List<EmpWorkingLessThan8hrsReportPojo> getEmpWorkinglessThen8hrs(EmpWorkingLessThan8hrsReportForm form) throws Exception
{
	return new EmpWorkingLessThan8hrsReportServiceImpl().getEmpWorkinglessThen8hrs(form);
}
}
