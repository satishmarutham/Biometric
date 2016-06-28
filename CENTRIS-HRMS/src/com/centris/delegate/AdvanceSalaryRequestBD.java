/**
 * 
 */
package com.centris.delegate;

import java.util.List;
import java.util.Map;

import com.centris.VO.AdvanceSalaryConsolidateReportVo;
import com.centris.VO.AdvanceSalaryRequestVo;
import com.centris.service.AdvanceSalaryRequestService;
import com.centris.service.serviceImpl.AdvanceSalaryRequestServiceImpl;


/**
 * @author satish
 *
 */
public class AdvanceSalaryRequestBD {
	

	public String saveAdvancedSalaryRequest(List<AdvanceSalaryRequestVo> advanceSalaryRequestVos){
		AdvanceSalaryRequestService advanceSalaryRequestService=new AdvanceSalaryRequestServiceImpl();
		return advanceSalaryRequestService.saveAdvancedSalaryRequest(advanceSalaryRequestVos);
	
}
	
	public List<AdvanceSalaryRequestVo> getEmployeeDetailsById(String employeeId,String managerCode)
	{
		AdvanceSalaryRequestService advanceSalaryRequestService=new AdvanceSalaryRequestServiceImpl();
		return advanceSalaryRequestService.getEmployeeDetailsById(employeeId,managerCode);
	}
	public List<AdvanceSalaryRequestVo> getAdvanceSalaryRequest()
	{
		AdvanceSalaryRequestService advanceSalaryRequestService=new AdvanceSalaryRequestServiceImpl();
		return advanceSalaryRequestService.getAdvanceSalaryRequest();
	}
	public int approveAdvanceSalary(AdvanceSalaryRequestVo advanceSalaryRequestVo)
	{AdvanceSalaryRequestService advanceSalaryRequestService=new AdvanceSalaryRequestServiceImpl();
		return advanceSalaryRequestService.approveAdvanceSalary(advanceSalaryRequestVo);
	}
	public int rejectAdvanceSalary(AdvanceSalaryRequestVo advanceSalaryRequestVo)
	{
		AdvanceSalaryRequestService advanceSalaryRequestService=new AdvanceSalaryRequestServiceImpl();
		return advanceSalaryRequestService.rejectAdvanceSalary(advanceSalaryRequestVo);
	}
	
	public int holdAdvanceSalary(AdvanceSalaryRequestVo advanceSalaryRequestVo)
	{
		AdvanceSalaryRequestService advanceSalaryRequestService=new AdvanceSalaryRequestServiceImpl();
		return advanceSalaryRequestService.holdAdvanceSalary(advanceSalaryRequestVo);
	}
	public List<AdvanceSalaryRequestVo> getProjectReferenceCodeByManager(String managerCode)
	{
		AdvanceSalaryRequestService advanceSalaryRequestService=new AdvanceSalaryRequestServiceImpl();
		return advanceSalaryRequestService.	getProjectCodeRefernceByManager(managerCode);
	}
	
public List<AdvanceSalaryRequestVo> getAdvanceSalaryRequestByDirector(String directorCode)
	{
		AdvanceSalaryRequestService advanceSalaryRequestService=new AdvanceSalaryRequestServiceImpl();
		return advanceSalaryRequestService.getAdvanceSalaryRequestByDirector(directorCode);
	}
	

public Map<String,List<AdvanceSalaryConsolidateReportVo>> advanceSalaryConsolidateReport(AdvanceSalaryConsolidateReportVo advanceSalaryReport)
{
	AdvanceSalaryRequestService advanceSalaryRequestService=new AdvanceSalaryRequestServiceImpl();
	return advanceSalaryRequestService.advanceSalaryConsolidateReport(advanceSalaryReport);
}
}





