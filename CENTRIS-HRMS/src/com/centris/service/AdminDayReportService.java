/**
 * 
 */
package com.centris.service;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.DepartMentReportPojo;
import com.centris.POJO.DesignationReportPojo;
import com.centris.POJO.EmployeeReportPojo;
import com.centris.POJO.ManagerReportPojo;
import com.centris.POJO.ProjectReportPojo;
import com.centris.VO.AdminDayReportVo;
import com.centris.VO.EmployeeVO;
import com.centris.VO.MonthReportVO;

/**
 * @author sathish
 *
 */
public interface AdminDayReportService {
	public ArrayList<EmployeeVO> getEmployees(String[] managerid_array,
			String[] projectid_array, String[] designationid_array,
			String[] departmentid_array);


public ArrayList<AdminDayReportVo> getadminDayReport(	ArrayList<ManagerReportPojo> managerlist,
		ArrayList<ProjectReportPojo> projectlist,
		ArrayList<EmployeeReportPojo> employeelist,
		ArrayList<DepartMentReportPojo> departmentlist,
		ArrayList<DesignationReportPojo> designationlist,
		String startDate,String endDate) ;
}	