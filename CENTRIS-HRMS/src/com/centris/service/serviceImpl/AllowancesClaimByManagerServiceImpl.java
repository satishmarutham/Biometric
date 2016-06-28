package com.centris.service.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import com.centris.DAO.AllowancesClaimByManagerDao;
import com.centris.DAO.DAOIMPL.AllowancesClaimByManagerDaoImpl;
import com.centris.POJO.AllowancesClaimByManagerPOJO;
import com.centris.VO.AllowancesBioIdSearch;
import com.centris.VO.AllowancesClaimByManagerVO;
import com.centris.service.AllowancesClaimByManagerService;

public class AllowancesClaimByManagerServiceImpl implements AllowancesClaimByManagerService {

	public AllowancesClaimByManagerVO getEmployeeDetails(String bioId,String selecteddate,String userCode) {

       AllowancesClaimByManagerDao  allowancesClaimByManagerDao =new  AllowancesClaimByManagerDaoImpl();
		 
		return allowancesClaimByManagerDao.getEmployeeDetails(bioId,selecteddate,userCode);
	}

	public String saveAllowances(ArrayList<AllowancesClaimByManagerPOJO> allowanceslist) {
		 
		AllowancesClaimByManagerDao  allowancesClaimByManagerDao =new  AllowancesClaimByManagerDaoImpl();
			 
			return allowancesClaimByManagerDao.saveAllowances(allowanceslist);
	}

	public List<AllowancesBioIdSearch> getBioIdBySearch(String searchTerm) {
		 
		AllowancesClaimByManagerDao  allowancesClaimByManagerDao =new  AllowancesClaimByManagerDaoImpl();
			 
			return allowancesClaimByManagerDao.getBioIdBySearch(searchTerm);
	}

	public String getClient(String projectcode) {
	
		AllowancesClaimByManagerDao  allowancesClaimByManagerDao =new  AllowancesClaimByManagerDaoImpl();
		 
		return allowancesClaimByManagerDao.getClient(projectcode);
	}

	public int getAlreadyClaimedCount(String selecteddate, String currentuser) {
	
		AllowancesClaimByManagerDao  allowancesClaimByManagerDao =new  AllowancesClaimByManagerDaoImpl();
		 
		return allowancesClaimByManagerDao.getAlreadyClaimedCount(selecteddate,currentuser);
	}

	public ArrayList<AllowancesClaimByManagerVO> getClaimedAllowanceDetails(String selecteddate, String currentuser) {
	
		AllowancesClaimByManagerDao  allowancesClaimByManagerDao =new  AllowancesClaimByManagerDaoImpl();
		 
		return allowancesClaimByManagerDao.getClaimedAllowanceDetails(selecteddate,currentuser);
	}


	public ArrayList<AllowancesClaimByManagerVO> getmoreAllowanceDeatails(String startdate, String enddate, String usercode) {
	
		AllowancesClaimByManagerDao  allowancesClaimByManagerDao =new  AllowancesClaimByManagerDaoImpl();
		 
		return allowancesClaimByManagerDao.getmoreAllowanceDeatails(startdate,enddate,usercode);
	}

}
