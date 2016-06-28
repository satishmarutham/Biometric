package com.centris.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.centris.POJO.EmpAllowAprroveByDirectorPojo;
import com.centris.VO.EmpAllowAprroveByDirectorVo;

public interface EmpAllowAprroveByDirectorDao {
	
	public LinkedHashMap<String, ArrayList<EmpAllowAprroveByDirectorVo>> getAllowancesNotApproved(String startdate,String endDate,String userType,String usercode);
	public ArrayList<EmpAllowAprroveByDirectorVo> getsingleAllowances(String allowanceCode);
	public String approveSingleAllowance(EmpAllowAprroveByDirectorPojo allowancePojo);
	public ArrayList<EmpAllowAprroveByDirectorVo> getConflictEmployees(String startdate,String endDate,String usertype,String usercode);
	public ArrayList<EmpAllowAprroveByDirectorVo> getAllowancesForDownload(
			String startdate, String endDate, String userType, String usercode);
	public String approveAllAllowansesDao(EmpAllowAprroveByDirectorPojo allowancePojo);
	public String rejectSingleAllowance(EmpAllowAprroveByDirectorPojo allowancePojo);
	public ArrayList<EmpAllowAprroveByDirectorVo> getConflictEmployeesForDownLoad(String startdate,String endDate,String userType,String usercode); 
}

