package com.centris.delegate;

import java.util.ArrayList;
import java.util.HashMap;

import com.centris.VO.LeaveViewDetailsVo;
import com.centris.VO.ManagerMasterVO;
import com.centris.form.EmployeeLeaveRequestForm;
import com.centris.service.EmployeeLeaveRequestService;
import com.centris.service.serviceImpl.EmployeeLeaveRequestServiceImpl;



public class EmployeeLeaveRequestBD {

		public String AddLeaveRequestBD(EmployeeLeaveRequestForm leavereqestForm,HashMap<String,String> mapPrevileges) {
	
		return new EmployeeLeaveRequestServiceImpl().AddLeaveRequestService(leavereqestForm,mapPrevileges);
	}

	public boolean validateDuplicateLeave(String requestedby, String startdate,	String enddate) {
	
		return new EmployeeLeaveRequestServiceImpl().validateDuplicateLeaveService(requestedby,startdate,enddate);
	}

	public ArrayList<ManagerMasterVO> getManagerBD(String usercode) {
		
		return new EmployeeLeaveRequestServiceImpl().getManagerService(usercode);
	}

	public ArrayList<LeaveViewDetailsVo> getviewLeaveDetails(String userCode) {
		
		EmployeeLeaveRequestService employeeLeaveRequestService=new EmployeeLeaveRequestServiceImpl();
		
		return employeeLeaveRequestService.getviewLeaveDetails(userCode);
	}

	

}
