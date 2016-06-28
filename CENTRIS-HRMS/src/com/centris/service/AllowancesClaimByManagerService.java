package com.centris.service;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.AllowancesClaimByManagerPOJO;
import com.centris.VO.AllowancesBioIdSearch;
import com.centris.VO.AllowancesClaimByManagerVO;

public interface AllowancesClaimByManagerService {

	AllowancesClaimByManagerVO getEmployeeDetails(String bioId, String selecteddate, String userCode);

	String saveAllowances(ArrayList<AllowancesClaimByManagerPOJO> allowanceslist);

	List<AllowancesBioIdSearch> getBioIdBySearch(String searchTerm);

	String getClient(String projectcode);

	int getAlreadyClaimedCount(String selecteddate, String currentuser);

	ArrayList<AllowancesClaimByManagerVO> getClaimedAllowanceDetails(String selecteddate, String currentuser);

	ArrayList<AllowancesClaimByManagerVO> getmoreAllowanceDeatails(String startdate, String enddate, String usercode);

}
