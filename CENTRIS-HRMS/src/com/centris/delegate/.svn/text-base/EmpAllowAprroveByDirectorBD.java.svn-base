package com.centris.delegate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import com.centris.POJO.EmpAllowAprroveByDirectorPojo;
import com.centris.VO.EmpAllowAprroveByDirectorVo;
import com.centris.service.EmpAllowAprroveByDirectorService;
import com.centris.service.serviceImpl.EmpAllowAprroveByDirectorServiceImpl;

public class EmpAllowAprroveByDirectorBD {

	EmpAllowAprroveByDirectorService allowanceService = new EmpAllowAprroveByDirectorServiceImpl();

	public LinkedHashMap<String, ArrayList<EmpAllowAprroveByDirectorVo>> getAllowancesNotApproved(
			String startdate, String endDate, String userType, String usercode) {

		return allowanceService.getAllowancesNotApproved(startdate, endDate,
				userType, usercode);

	}

	public ArrayList<EmpAllowAprroveByDirectorVo> getAllowancesForDownload(
			String startdate, String endDate, String userType, String usercode) {

		return allowanceService.getAllowancesForDownload(startdate, endDate,
				userType, usercode);

	}

	public ArrayList<EmpAllowAprroveByDirectorVo> getsingleAllowances(
			String allowanceCode) {

		return allowanceService.getsingleAllowances(allowanceCode);

	}

	public String approveSingleAllowance(
			EmpAllowAprroveByDirectorPojo allowancePojo) {

		return allowanceService.approveSingleAllowance(allowancePojo);

	}
	
	public String rejectSingleAllowance(EmpAllowAprroveByDirectorPojo allowancePojo) {

		return allowanceService.rejectSingleAllowance(allowancePojo);

	}

	public ArrayList<EmpAllowAprroveByDirectorVo> getConflictEmployees(
			String startdate, String endDate, String usertype, String usercode) {
		// TODO Auto-generated method stub
		return allowanceService.getConflictEmployees(startdate, endDate,
				usertype, usercode);
	}

	public String approveAllAllowansesBD(EmpAllowAprroveByDirectorPojo allowancePojo) {

		return allowanceService.approveAllAllowansesService(allowancePojo);

	}
	
	
	public ArrayList<EmpAllowAprroveByDirectorVo> getConflictEmployeesForDownLoad(
			String startdate, String endDate, String usertype, String usercode) {
		// TODO Auto-generated method stub
		return allowanceService.getConflictEmployeesForDownLoad(startdate, endDate,
				usertype, usercode);
	}
	
	

}
