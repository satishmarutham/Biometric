/**
 * 
 */
package com.centris.DAO;

import java.util.List;

import com.centris.POJO.EmpWorkingLessThan8hrsReportPojo;

/**
 * @author sathish
 *
 */
public interface EmpWorkingLessThan8hrsReportDao {
	public List<EmpWorkingLessThan8hrsReportPojo> getEmpWorkinglessThen8hrs(EmpWorkingLessThan8hrsReportPojo pojo)throws Exception;
}
