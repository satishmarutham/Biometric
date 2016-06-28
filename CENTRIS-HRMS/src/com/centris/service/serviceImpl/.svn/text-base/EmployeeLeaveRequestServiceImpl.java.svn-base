package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import com.centris.DAO.EmployeeLeaveRequestDao;
import com.centris.DAO.DAOIMPL.EmployeeLeaveRequesDaoImpl;
import com.centris.VO.LeaveViewDetailsVo;
import com.centris.VO.ManagerMasterVO;
import com.centris.form.EmployeeLeaveRequestForm;
import com.centris.service.EmployeeLeaveRequestService;

public class EmployeeLeaveRequestServiceImpl implements EmployeeLeaveRequestService{

	
	public String AddLeaveRequestService(EmployeeLeaveRequestForm leavereqestForm,HashMap<String,String> mapPrevileges) {
		
		return new EmployeeLeaveRequesDaoImpl().AddLeaveRequestDao(leavereqestForm,mapPrevileges);
	}

	public boolean validateDuplicateLeaveService(String requestedby,String startdate, String enddate) {
		
		return  new EmployeeLeaveRequesDaoImpl().validateDuplicateLeaveDao(requestedby,startdate,enddate);
	}

	public ArrayList<ManagerMasterVO> getManagerService(String usercode) {
	
		return new EmployeeLeaveRequesDaoImpl().getManagersDao(usercode);
	}

	
	public ArrayList<LeaveViewDetailsVo> getviewLeaveDetails(String userCode) {
		
		EmployeeLeaveRequestDao employeeLeaveRequestDao=new EmployeeLeaveRequesDaoImpl();
		
		return employeeLeaveRequestDao.getviewLeaveDetails(userCode);
	}

}
