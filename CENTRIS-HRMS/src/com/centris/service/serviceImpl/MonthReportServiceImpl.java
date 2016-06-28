package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.centris.DAO.DAOIMPL.MonthReportDaoImpl;
import com.centris.DAO.DAOIMPL.ProjectMasterDaoImpl;
import com.centris.POJO.DepartMentReportPojo;
import com.centris.POJO.DesignationReportPojo;
import com.centris.POJO.EmployeeReportPojo;
import com.centris.POJO.ManagerReportPojo;
import com.centris.POJO.ProjectReportPojo;
import com.centris.VO.EmployeeVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.MonthReportVO;
import com.centris.VO.ProjectMasterVo;
import com.centris.service.MonthReportService;

public class MonthReportServiceImpl implements MonthReportService{

	public ArrayList<EmployeeVO> getEmployees(String managerid_array) {
	
		return new MonthReportDaoImpl().getEmployees(managerid_array);
	}

	public ArrayList<MonthReportVO> getMonthReport(
			ArrayList<EmployeeReportPojo> employeelist,
			List<String> dates) {
		
		return new MonthReportDaoImpl().getMonthReport(employeelist,dates);
	}

  public  ArrayList<ManagerFilterVO> getManagersByDepartment(String[] departmentid ,String userType,String directorCode){
		
		return new MonthReportDaoImpl().getManagersByDepartment(departmentid,userType,directorCode);
		
	}
	
	
	
}
