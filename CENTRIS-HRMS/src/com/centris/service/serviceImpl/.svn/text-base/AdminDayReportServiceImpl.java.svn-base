package com.centris.service.serviceImpl;

import java.util.ArrayList;

import com.centris.DAO.DAOIMPL.AdminDayReportDaoImpl;
import com.centris.POJO.DepartMentReportPojo;
import com.centris.POJO.DesignationReportPojo;
import com.centris.POJO.EmployeeReportPojo;
import com.centris.POJO.ManagerReportPojo;
import com.centris.POJO.ProjectReportPojo;
import com.centris.VO.AdminDayReportVo;
import com.centris.VO.EmployeeVO;
import com.centris.VO.MonthReportVO;
import com.centris.service.AdminDayReportService;

public class AdminDayReportServiceImpl implements AdminDayReportService {

	@Override
	public ArrayList<EmployeeVO> getEmployees(String[] managerid_array,
			String[] projectid_array, String[] designationid_array,
			String[] departmentid_array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<AdminDayReportVo> getadminDayReport(
			ArrayList<ManagerReportPojo> managerlist,
			ArrayList<ProjectReportPojo> projectlist,
			ArrayList<EmployeeReportPojo> employeelist,
			ArrayList<DepartMentReportPojo> departmentlist,
			ArrayList<DesignationReportPojo> designationlist, String startDate,
			String endDate) {
		// TODO Auto-generated method stub
		return new AdminDayReportDaoImpl().getadminDayReport(managerlist, projectlist, employeelist, departmentlist, designationlist, startDate, endDate);
	}

}
