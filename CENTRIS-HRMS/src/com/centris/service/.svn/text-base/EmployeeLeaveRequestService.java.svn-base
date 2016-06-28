package com.centris.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.centris.VO.LeaveViewDetailsVo;
import com.centris.VO.ManagerMasterVO;
import com.centris.form.EmployeeLeaveRequestForm;

public interface EmployeeLeaveRequestService {
	
	public String AddLeaveRequestService(EmployeeLeaveRequestForm leavereqestForm,HashMap<String,String> mapPrevileges);
	public boolean validateDuplicateLeaveService(String requestedto,String startdate, String enddate);
	public ArrayList<ManagerMasterVO> getManagerService(String usercode);
	public ArrayList<LeaveViewDetailsVo> getviewLeaveDetails(String userCode);
}
