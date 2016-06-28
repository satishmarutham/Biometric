package com.centris.delegate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.centris.POJO.GroupLogReportPojo;
import com.centris.VO.EmployeeVO;
import com.centris.VO.GroupLogReportVo;
import com.centris.VO.LogReportVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.form.LogReportForm;
import com.centris.service.serviceImpl.LogReportServiceImpl;
import com.centris.service.serviceImpl.MonthReportServiceImpl;

public class LogReportBD {

	public List<EmployeeVO> getEmployeeByDesignation(String designationId){
		return new LogReportServiceImpl().getEmployeeByDesignation(designationId);
	}
	
	public List<LogReportVO> getLogReport(LogReportForm logReportForm){
		return new LogReportServiceImpl().getLogReport(logReportForm);
	}
	public List<EmployeeVO> getMangerInfo(){
		return new LogReportServiceImpl().getMangerInfo();
	}
	public List<EmployeeVO> getEmpDetailsByLocation(LogReportForm logReportForm){
		return new LogReportServiceImpl().getEmpDetailsByLocation(logReportForm);
	}
	
	public Map<String, Map<String, List<GroupLogReportVo>>> getGroupLogReportDetails(
			GroupLogReportPojo groupLogReportPojo) {
		return new LogReportServiceImpl()
				.getGroupLogReportDetails(groupLogReportPojo);
	}
	
	public List<GroupLogReportVo> getLogDetailsForThisDate(GroupLogReportPojo pojoObj){
		return new LogReportServiceImpl().getLogDetailsForThisDate(pojoObj);
	}
	
public  ArrayList<ManagerFilterVO> getManagersByDepartment(String[] departmentid ,String userType,String userCode){
		
		return new LogReportServiceImpl().getManagersByDepartment(departmentid,userType,userCode);
		
	}

public ArrayList<EmployeeVO> getEmployees(String managerid_array,
		String[] departmentid_array) {
		
	return new LogReportServiceImpl().getEmployees(managerid_array,departmentid_array);
}
}
