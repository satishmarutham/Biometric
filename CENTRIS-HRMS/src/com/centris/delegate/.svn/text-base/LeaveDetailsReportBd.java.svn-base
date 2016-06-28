package com.centris.delegate;

import java.util.ArrayList;

import com.centris.POJO.DepartMentReportPojo;
import com.centris.POJO.DesignationReportPojo;
import com.centris.POJO.EmployeeReportPojo;
import com.centris.POJO.ManagerReportPojo;
import com.centris.POJO.ProjectReportPojo;
import com.centris.VO.LeaveDetailsReportVo;
import com.centris.service.serviceImpl.LeaveDetailsReportServiceImpl;

public class LeaveDetailsReportBd {
	
public  ArrayList<EmployeeReportPojo> getEmployees(ArrayList<ManagerReportPojo> mgr_list,ArrayList<ProjectReportPojo> pjt_list,ArrayList<DepartMentReportPojo> dept_list,ArrayList<DesignationReportPojo> des_list) {
		
		return new LeaveDetailsReportServiceImpl().getEmployees(mgr_list,pjt_list,dept_list,des_list);
	}

public  ArrayList<LeaveDetailsReportVo> getLeaveDetails(String[] emp_array) {
	
	return new LeaveDetailsReportServiceImpl().getLeaveDetails(emp_array);
}



}
