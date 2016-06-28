/**
 * 
 */
package com.centris.DAO;

import java.util.List;
import java.util.Map;

import com.centris.VO.AdvanceSalaryConsolidateReportVo;
import com.centris.VO.AdvanceSalaryRequestVo;

/**
 * @author satish
 *
 */
public interface AdvanceSalaryRequestDao {
	public String saveAdvancedSalaryRequest(List<AdvanceSalaryRequestVo> saveRequestSalary);
	public List<AdvanceSalaryRequestVo> getEmployeeDetailsById(String employeeId,String managerCode);
	public List<AdvanceSalaryRequestVo> getAdvanceSalaryRequest();
	
	public int approveAdvanceSalary(AdvanceSalaryRequestVo advanceSalaryRequestVo);
	
	public int rejectAdvanceSalary(AdvanceSalaryRequestVo advanceSalaryRequestVo);
	
	public int holdAdvanceSalary(AdvanceSalaryRequestVo advanceSalaryRequestVo);
	public List<AdvanceSalaryRequestVo> getProjectCodeRefernceByManager(String managerCode);
	public List<AdvanceSalaryRequestVo> getAdvanceSalaryRequestByDirector(String userCode);
public int approveAdvanceSalaryByAdmin(AdvanceSalaryRequestVo advanceSalaryRequestVo);
public Map<String,List<AdvanceSalaryConsolidateReportVo>> advanceSalaryConsolidateReport(AdvanceSalaryConsolidateReportVo advanceSalaryReport);	
public Map<String,List<AdvanceSalaryConsolidateReportVo>> advanceSalaryConsolidateReportByProject(AdvanceSalaryConsolidateReportVo advanceSalaryReport);	


}
