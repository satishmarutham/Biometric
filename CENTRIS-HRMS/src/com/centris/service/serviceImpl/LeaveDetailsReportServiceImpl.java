package com.centris.service.serviceImpl;

import java.util.ArrayList;

import com.centris.DAO.DAOIMPL.LeaveDetailsReportDaoImpl;
import com.centris.POJO.DepartMentReportPojo;
import com.centris.POJO.DesignationReportPojo;
import com.centris.POJO.EmployeeReportPojo;
import com.centris.POJO.ManagerReportPojo;
import com.centris.POJO.ProjectReportPojo;
import com.centris.VO.LeaveDetailsReportVo;

public class LeaveDetailsReportServiceImpl {
	
public  ArrayList<EmployeeReportPojo> getEmployees(ArrayList<ManagerReportPojo> mgr_list,ArrayList<ProjectReportPojo> pjt_list,ArrayList<DepartMentReportPojo> dept_list,ArrayList<DesignationReportPojo> des_list) {
		
		return new LeaveDetailsReportDaoImpl().getEmployees(mgr_list,pjt_list,dept_list,des_list);
	}

public  ArrayList<LeaveDetailsReportVo> getLeaveDetails(String[] emp_array) {
	
	return new LeaveDetailsReportDaoImpl().getLeaveDetails(emp_array);
}

}
