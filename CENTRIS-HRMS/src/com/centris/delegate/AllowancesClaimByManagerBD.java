package com.centris.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.AllowancesClaimByManagerPOJO;
import com.centris.VO.AllowancesBioIdSearch;
import com.centris.VO.AllowancesClaimByManagerVO;
import com.centris.service.AllowancesClaimByManagerService;
import com.centris.service.serviceImpl.AllowancesClaimByManagerServiceImpl;

public class AllowancesClaimByManagerBD {

	public AllowancesClaimByManagerVO getEmployeeDetails(String bioId, String selecteddate, String userCode) {

       AllowancesClaimByManagerService allowancesClaimByManagerService=new AllowancesClaimByManagerServiceImpl();
		
       return allowancesClaimByManagerService.getEmployeeDetails(bioId,selecteddate,userCode);
	}

	public String saveAllowances(ArrayList<AllowancesClaimByManagerPOJO> allowanceslist) {
		
		  AllowancesClaimByManagerService allowancesClaimByManagerService=new AllowancesClaimByManagerServiceImpl();
			
	       return allowancesClaimByManagerService.saveAllowances(allowanceslist);
	}

	public List<AllowancesBioIdSearch> getBioIdBySearch(String searchTerm) {
		 
		AllowancesClaimByManagerService allowancesClaimByManagerService=new AllowancesClaimByManagerServiceImpl();
			
	       return allowancesClaimByManagerService.getBioIdBySearch(searchTerm);
	}

	public String getClient(String projectcode) {
	
		AllowancesClaimByManagerService allowancesClaimByManagerService=new AllowancesClaimByManagerServiceImpl();
		
	       return allowancesClaimByManagerService.getClient(projectcode);
	}

	public int getAlreadyClaimedCount(String selecteddate, String currentuser) {

		AllowancesClaimByManagerService allowancesClaimByManagerService=new AllowancesClaimByManagerServiceImpl();
		
	       return allowancesClaimByManagerService.getAlreadyClaimedCount(selecteddate,currentuser);
	}

	public ArrayList<AllowancesClaimByManagerVO> getClaimedAllowanceDetails(String selecteddate, String currentuser) {
	
		AllowancesClaimByManagerService allowancesClaimByManagerService=new AllowancesClaimByManagerServiceImpl();
		
	       return allowancesClaimByManagerService.getClaimedAllowanceDetails(selecteddate,currentuser);
	}

	public ArrayList<AllowancesClaimByManagerVO> getmoreAllowanceDeatails(String startdate, String enddate, String usercode) {
		
		AllowancesClaimByManagerService allowancesClaimByManagerService=new AllowancesClaimByManagerServiceImpl();
		
	       return allowancesClaimByManagerService.getmoreAllowanceDeatails(startdate,enddate,usercode);
	}

}
