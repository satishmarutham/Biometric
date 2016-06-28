/**
 * 
 */
package com.centris.service.serviceImpl;

import java.util.List;
import java.util.Map;

import com.centris.DAO.AdvanceSalaryRequestDao;
import com.centris.DAO.DAOIMPL.AdvanceSalaryRequestDaoImpl;
import com.centris.VO.AdvanceSalaryConsolidateReportVo;
import com.centris.VO.AdvanceSalaryRequestVo;
import com.centris.service.AdvanceSalaryRequestService;

/**
 * @author satish
 *
 */
public class AdvanceSalaryRequestServiceImpl implements AdvanceSalaryRequestService {

	@Override
	public String saveAdvancedSalaryRequest(
			List<AdvanceSalaryRequestVo> saveRequestSalary) {
		AdvanceSalaryRequestDao advanceSalaryRequestDao=new AdvanceSalaryRequestDaoImpl();
		// TODO Auto-generated method stub
		return advanceSalaryRequestDao.saveAdvancedSalaryRequest(saveRequestSalary);
	}

	@Override
	public List<AdvanceSalaryRequestVo> getEmployeeDetailsById(String employeeId,String managerCode) {
		// TODO Auto-generated method stub
		AdvanceSalaryRequestDao advanceSalaryRequestDao=new AdvanceSalaryRequestDaoImpl();
		return advanceSalaryRequestDao.getEmployeeDetailsById(employeeId,managerCode);
	}

	@Override
	public List<AdvanceSalaryRequestVo> getAdvanceSalaryRequest() {
		AdvanceSalaryRequestDao advanceSalaryRequestDao=new AdvanceSalaryRequestDaoImpl();
		return advanceSalaryRequestDao.getAdvanceSalaryRequest();
	}

	@Override
	public int approveAdvanceSalary(AdvanceSalaryRequestVo advanceSalaryRequestVo) {
		String userCode=advanceSalaryRequestVo.getCreatedBy();
		
		if(userCode.substring(0,3).equalsIgnoreCase("DIR")){
			AdvanceSalaryRequestDao advanceSalaryRequestDao=new AdvanceSalaryRequestDaoImpl();
		return advanceSalaryRequestDao.approveAdvanceSalary(advanceSalaryRequestVo);
	}
		else
		{
			AdvanceSalaryRequestDao advanceSalaryRequestDao=new AdvanceSalaryRequestDaoImpl();
			return advanceSalaryRequestDao.approveAdvanceSalaryByAdmin(advanceSalaryRequestVo);
		}
	}
	

	@Override
	public int rejectAdvanceSalary(AdvanceSalaryRequestVo advanceSalaryRequestVo) {
	AdvanceSalaryRequestDao advanceSalaryRequestDao=new AdvanceSalaryRequestDaoImpl();
		return advanceSalaryRequestDao.rejectAdvanceSalary(advanceSalaryRequestVo);
	}

	@Override
	public int holdAdvanceSalary(AdvanceSalaryRequestVo advanceSalaryRequestVo) {
		AdvanceSalaryRequestDao advanceSalaryRequestDao=new AdvanceSalaryRequestDaoImpl();
		return advanceSalaryRequestDao.holdAdvanceSalary(advanceSalaryRequestVo);
	}

	@Override
	public List<AdvanceSalaryRequestVo> getProjectCodeRefernceByManager(
			String managerCode) {
		AdvanceSalaryRequestDao advanceSalaryRequestDao=new AdvanceSalaryRequestDaoImpl();
		return advanceSalaryRequestDao.getProjectCodeRefernceByManager(managerCode);
	}

	@Override
	public List<AdvanceSalaryRequestVo> getAdvanceSalaryRequestByDirector(
			String userCode) {
		// TODO Auto-generated method stub
		AdvanceSalaryRequestDao advanceSalaryRequestDao=new AdvanceSalaryRequestDaoImpl();
		return advanceSalaryRequestDao.getAdvanceSalaryRequestByDirector(userCode);
	}

	@Override
	public Map<String, List<AdvanceSalaryConsolidateReportVo>> advanceSalaryConsolidateReport(
			AdvanceSalaryConsolidateReportVo advanceSalaryReport) {
		AdvanceSalaryRequestDao advanceSalaryRequestDao=new AdvanceSalaryRequestDaoImpl();
		if(advanceSalaryReport.getGroupBy().equalsIgnoreCase("MAN")){
		
		return advanceSalaryRequestDao.advanceSalaryConsolidateReport(advanceSalaryReport);
		}
		else
		{
			return advanceSalaryRequestDao.advanceSalaryConsolidateReportByProject(advanceSalaryReport);
		}
	}

}
