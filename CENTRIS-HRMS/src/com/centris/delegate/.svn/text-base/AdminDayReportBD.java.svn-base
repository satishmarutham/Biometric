/**
 * 
 */
package com.centris.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.AdminDayReportPojo;
import com.centris.POJO.DepartMentReportPojo;
import com.centris.POJO.DesignationReportPojo;
import com.centris.POJO.EmployeeReportPojo;
import com.centris.POJO.ManagerReportPojo;
import com.centris.POJO.ProjectReportPojo;
import com.centris.VO.AdminDayReportVo;
import com.centris.VO.MonthReportVO;
import com.centris.service.serviceImpl.AdminDayReportServiceImpl;
import com.centris.service.serviceImpl.MonthReportServiceImpl;

/**
 * @author sathish
 *
 */
public class AdminDayReportBD {
	public ArrayList<AdminDayReportVo> getAdminDayReport(ArrayList<ManagerReportPojo> managerlist,ArrayList<ProjectReportPojo>  projectlist,ArrayList<EmployeeReportPojo>  employeelist,ArrayList<DepartMentReportPojo>  departmentlist,ArrayList<DesignationReportPojo>  designationlist,String startDate,String endDate){
		
		
	      return new AdminDayReportServiceImpl().getadminDayReport(managerlist,projectlist, employeelist,  departmentlist, designationlist,startDate,endDate);
}
	
	
	

}
