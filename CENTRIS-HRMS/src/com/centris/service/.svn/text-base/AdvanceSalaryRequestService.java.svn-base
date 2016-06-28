/**
 * 
 */
package com.centris.service;

import java.util.List;
import java.util.Map;

import com.centris.VO.AdvanceSalaryConsolidateReportVo;
import com.centris.VO.AdvanceSalaryRequestVo;

/**
 * @author satish
 *
 */
public interface AdvanceSalaryRequestService   {
	public String saveAdvancedSalaryRequest(List<AdvanceSalaryRequestVo> saveRequestSalary);
	public List<AdvanceSalaryRequestVo> getEmployeeDetailsById(String employeeId,String managerCode);
	public List<AdvanceSalaryRequestVo> getAdvanceSalaryRequest();
	
	public int approveAdvanceSalary(AdvanceSalaryRequestVo advanceSalaryRequestVo);
	
	public int rejectAdvanceSalary(AdvanceSalaryRequestVo advanceSalaryRequestVo);
	
	public int holdAdvanceSalary(AdvanceSalaryRequestVo advanceSalaryRequestVo);
	public List<AdvanceSalaryRequestVo> getProjectCodeRefernceByManager(String managerCode);
	
	public List<AdvanceSalaryRequestVo> getAdvanceSalaryRequestByDirector(String userCode);
	
public Map<String,List<AdvanceSalaryConsolidateReportVo>> advanceSalaryConsolidateReport(AdvanceSalaryConsolidateReportVo advanceSalaryReport);

}
