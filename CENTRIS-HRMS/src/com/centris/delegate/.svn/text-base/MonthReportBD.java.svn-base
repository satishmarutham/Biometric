package com.centris.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.DepartMentReportPojo;
import com.centris.POJO.DesignationReportPojo;
import com.centris.POJO.EmployeeReportPojo;
import com.centris.POJO.ManagerReportPojo;
import com.centris.POJO.ProjectReportPojo;
import com.centris.VO.EmployeeVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.MonthReportVO;
import com.centris.VO.ProjectMasterVo;
import com.centris.service.serviceImpl.MonthReportServiceImpl;
import com.centris.service.serviceImpl.ProjectMasterServiceImpl;
import com.centris.util.HelperClass;

public class MonthReportBD {

	public ArrayList<EmployeeVO> getEmployees(String managerid_array) {
			
		return new MonthReportServiceImpl().getEmployees(managerid_array);
	}
	public ArrayList<MonthReportVO> getMonthReport(ArrayList<EmployeeReportPojo>  employeelist,List<String> dates){
	
	
	      return new MonthReportServiceImpl().getMonthReport(employeelist,dates);
  }

public  ArrayList<ManagerFilterVO> getManagersByDepartment(String[] departmentid,String userType,String directorcode){
		
		return new MonthReportServiceImpl().getManagersByDepartment(departmentid,userType,directorcode);
		
	}
	

}
