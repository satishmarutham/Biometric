/**
 * 
 */
package com.centris.service;

import java.util.List;

import com.centris.POJO.EmpWorkingLessThan8hrsReportPojo;
import com.centris.form.EmpWorkingLessThan8hrsReportForm;

/**
 * @author sathish
 *
 */
public interface  EmpWorkingLessThan8hrsReportService {
	public List<EmpWorkingLessThan8hrsReportPojo>  getEmpWorkinglessThen8hrs(EmpWorkingLessThan8hrsReportForm form)throws Exception;
}
