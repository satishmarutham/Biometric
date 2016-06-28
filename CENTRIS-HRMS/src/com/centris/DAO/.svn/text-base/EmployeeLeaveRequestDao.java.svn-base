package com.centris.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import com.centris.VO.LeaveViewDetailsVo;
import com.centris.VO.ManagerMasterVO;
import com.centris.form.EmployeeLeaveRequestForm;

public interface EmployeeLeaveRequestDao {

	public ArrayList<ManagerMasterVO> getManagersDao(String usercode);
	public String AddLeaveRequestDao(EmployeeLeaveRequestForm leavereqestForm,HashMap<String,String> mapPrevileges);
	public boolean validateDuplicateLeaveDao(String requestedto,String startdate, String enddate);
	public ArrayList<LeaveViewDetailsVo> getviewLeaveDetails(String userCode);
}
