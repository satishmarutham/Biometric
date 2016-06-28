package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.centris.DAO.EmpAllowAprroveByDirectorDao;
import com.centris.DAO.DAOIMPL.EmpAllowAprroveByDirectorDaoImpl;
import com.centris.POJO.EmpAllowAprroveByDirectorPojo;
import com.centris.VO.EmpAllowAprroveByDirectorVo;
import com.centris.service.EmpAllowAprroveByDirectorService;

public class EmpAllowAprroveByDirectorServiceImpl implements EmpAllowAprroveByDirectorService{
	
	
	EmpAllowAprroveByDirectorDao allowanceDao=new EmpAllowAprroveByDirectorDaoImpl();
	
	public LinkedHashMap<String, ArrayList<EmpAllowAprroveByDirectorVo>> getAllowancesNotApproved(String startdate,String endDate,String userType,String usercode){
		
		return allowanceDao.getAllowancesNotApproved( startdate, endDate,userType,usercode);
	}
	
	public ArrayList<EmpAllowAprroveByDirectorVo> getsingleAllowances(String allowanceCode){
		
		return allowanceDao.getsingleAllowances(allowanceCode);
	}

	@Override
	public String approveSingleAllowance(EmpAllowAprroveByDirectorPojo allowancePojo) {
		// TODO Auto-generated method stub
		return allowanceDao.approveSingleAllowance(allowancePojo);
	}

	@Override
	public ArrayList<EmpAllowAprroveByDirectorVo> getConflictEmployees(
			String startdate, String endDate,String usertype,String usercode) {
		// TODO Auto-generated method stub
		return allowanceDao.getConflictEmployees(startdate,endDate,usertype,usercode);
	}

	@Override
	public ArrayList<EmpAllowAprroveByDirectorVo> getAllowancesForDownload(
			String startdate, String endDate, String userType, String usercode) {
		// TODO Auto-generated method stub
		 return allowanceDao.getAllowancesForDownload( startdate, endDate,userType,usercode);
	}

	@Override
	public String approveAllAllowansesService(
			EmpAllowAprroveByDirectorPojo allowancePojo) {
		// TODO Auto-generated method stub
		return allowanceDao.approveAllAllowansesDao(allowancePojo);
	}
	
	public String rejectSingleAllowance(EmpAllowAprroveByDirectorPojo allowancePojo){
		
		return allowanceDao.rejectSingleAllowance(allowancePojo);
	}
	
	
	
	@Override
	public ArrayList<EmpAllowAprroveByDirectorVo> getConflictEmployeesForDownLoad(
			String startdate, String endDate,String usertype,String usercode) {
		// TODO Auto-generated method stub
		return allowanceDao.getConflictEmployeesForDownLoad(startdate,endDate,usertype,usercode);
	}

}
