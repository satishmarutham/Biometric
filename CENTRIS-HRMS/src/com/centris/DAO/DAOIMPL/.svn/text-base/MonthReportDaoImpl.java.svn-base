package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.DAO.MonthReportDao;
import com.centris.POJO.DepartMentReportPojo;
import com.centris.POJO.DesignationReportPojo;
import com.centris.POJO.EmployeeReportPojo;
import com.centris.POJO.ManagerReportPojo;
import com.centris.POJO.ProjectReportPojo;
import com.centris.VO.EmployeeVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.MonthReportVO;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.ReportsAjaxVo;
import com.centris.action.AdminMonthReportAction;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AjaxReportsUtil;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.SQLUtils.MonthReportSqlUtil;
import com.centris.util.SQLUtils.ProjectDetails;
import com.centris.util.constants.MessageConstants;

public class MonthReportDaoImpl extends DBService implements MonthReportDao {

	private static Logger logger = Logger
			.getLogger(AdminMonthReportAction.class);

	public ArrayList<EmployeeVO> getEmployees(String managerid_array) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthReportDaoImpl : getEmployees Starting");

		Connection connection = null;
		PreparedStatement ps_emp_get = null;
		ResultSet rs_emp_get = null;

		ArrayList<EmployeeVO> employeelist = new ArrayList<EmployeeVO>();

		try {

			connection = getConnection();
			String temp_manager= "'" + managerid_array.replaceAll(",", "','") + "'";
			ps_emp_get = connection.prepareStatement("select EMPID,First_Name from hrms_employee where isActive='Y' and (EMPID in (select EMPID from hrms_manager where ManagerCode in ("+temp_manager+")) or EMPID in (select EmployeeId from hrms_employee_manager_mapping where ManagerId in ("+temp_manager+") )) ");
			
			
			rs_emp_get = ps_emp_get.executeQuery();

				
				while (rs_emp_get.next()) {

					EmployeeVO employeevo = new EmployeeVO();
					employeevo.setEmpid(rs_emp_get.getString("EMPID"));
					employeevo.setEmpname(rs_emp_get.getString("First_Name"));

					employeelist.add(employeevo);
				}


			System.out.println("employee list size in dao impl "
					+ employeelist.size());

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(exception.getMessage(), exception);
		} finally {

			try {

				if (rs_emp_get != null && (!rs_emp_get.isClosed())) {
					rs_emp_get.close();
				}
				if (ps_emp_get != null && (!ps_emp_get.isClosed())) {
					ps_emp_get.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception exception) {
				exception.printStackTrace();
				logger.error(exception.getMessage(), exception);
			}

		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthReportDaoImpl : getEmployees Ending");

		return employeelist;
	}

	public ArrayList<MonthReportVO> getMonthReport(
			ArrayList<EmployeeReportPojo> employeelist, List<String> dates) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthReportDaoImpl : getMonthReport Starting");

		Connection connection = null;
		PreparedStatement ps_monthreport_get = null;
		ResultSet rs_monthreport_get = null;

		ArrayList<MonthReportVO> monthreportlist = new ArrayList<MonthReportVO>();
		try {

			connection = getConnection();

			String managerid = "";
			String managercondition = "";

			StringBuffer employeebuffer = new StringBuffer();
			String employeecondition = "";

			for (int i = 0; i < employeelist.size(); i++) {

				if (employeelist.get(0).getEmpid() != "") {

					employeebuffer.append("'"
							+ employeelist.get(i).getEmpid()
									.replaceAll(",", "','") + "'");
					employeebuffer = employeebuffer.append(",");

				}
			}

			if (employeelist.get(0).getEmpid() != "all") {
				employeebuffer.replace(employeebuffer.length() - 1,
						employeebuffer.length(), " ");
				employeecondition = "and  att.EMPID in (" + employeebuffer
						+ ")";
			}

			System.out.println("employee condition in dao impl "
					+ employeecondition);
			int count = 0;

			for (int i = 0; i < dates.size(); i++) {
				for (int j = 0; j < employeelist.size(); j++) {
					/*
					 * System.out.println("date inside for  "+dates.get(i));
					 * System
					 * .out.println("employee inside for  "+employeelist.get
					 * (i).getEmpid());
					 */

					System.out.println("date inside for ");
					ps_monthreport_get = connection
							.prepareStatement(MonthReportSqlUtil.GET_MONTH_REPORT);
					ps_monthreport_get.setString(1, employeelist.get(j)
							.getEmpid());
					ps_monthreport_get.setString(2, dates.get(i));
					rs_monthreport_get = ps_monthreport_get.executeQuery();

					while (rs_monthreport_get.next()) {
						count++;
						MonthReportVO monthreportvo = new MonthReportVO();
						monthreportvo.setSno(count);
						monthreportvo.setEmpid(rs_monthreport_get
								.getString("bioid"));
						monthreportvo.setEmpname(rs_monthreport_get
								.getString("First_Name"));
						monthreportvo.setAttendancedate(HelperClass
								.convertDatabaseToUI(rs_monthreport_get
										.getString("Attendence_Date")));
						monthreportvo.setStatus(rs_monthreport_get
								.getString("Attedence_Status"));
						monthreportvo.setType(rs_monthreport_get
								.getString("ShortName"));

						if ("N".equalsIgnoreCase(rs_monthreport_get
								.getString("isPosted"))) {

							monthreportvo
									.setIsposted(MessageConstants.IS_POSTED_NO);
						} else {

							monthreportvo
									.setIsposted(MessageConstants.IS_POSTED_YES);
						}

						if ("N".equalsIgnoreCase(rs_monthreport_get
								.getString("isAproved"))) {

							monthreportvo
									.setIsapproved(MessageConstants.IS_APPROVED_NO);
						} else {

							monthreportvo
									.setIsapproved(MessageConstants.IS_APPROVED_YES);
						}

						monthreportlist.add(monthreportvo);
					}

				}

			}

			System.out.println("month report size in dao impl "
					+ monthreportlist.size());

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(exception.getMessage(), exception);
		} finally {

			try {

				if (rs_monthreport_get != null
						&& (!rs_monthreport_get.isClosed())) {
					rs_monthreport_get.close();
				}
				if (ps_monthreport_get != null
						&& (!ps_monthreport_get.isClosed())) {
					ps_monthreport_get.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception exception) {
				exception.printStackTrace();
				logger.error(exception.getMessage(), exception);
			}

		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthReportDaoImpl : getMonthReport Ending");

		return monthreportlist;
	}

	public static void main(String[] args) {

		ArrayList<ManagerReportPojo> managerlist = new ArrayList<ManagerReportPojo>();

		String monthreportform = "MAN1,MAN2,MAN3";
		String[] managerid = monthreportform.split(",");

		for (int i = 0; i < managerid.length; i++) {

			ManagerReportPojo managerpojo = new ManagerReportPojo();
			managerpojo.setMgr_id(managerid[i]);
			managerlist.add(managerpojo);

		}

		String manageriiid = null;
		StringBuffer managercondition = null;
		String[] string_array = null;
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < managerlist.size(); i++) {

			if (managerlist.get(0).getMgr_id() != "all") {

				buffer.append("'"
						+ managerlist.get(i).getMgr_id().replaceAll(",", "','")
						+ "'");

				buffer = buffer.append(",");

				System.out.println("check" + managercondition);
				string_array = managerlist.get(i).getMgr_id().split("");

			}

		}
		System.out.println(" condition"
				+ buffer.replace(buffer.length() - 1, buffer.length(), " "));

		ArrayList<ProjectReportPojo> projectlist;
		ArrayList<EmployeeReportPojo> employeelist;
		ArrayList<DepartMentReportPojo> departmentlist;
		ArrayList<DesignationReportPojo> designationlist;
		ArrayList<String> dates;

		// new
		// MonthReportDaoImpl().getMonthReport(managerlist,projectlist,employeelist,departmentlist,designationlist,dates);

	}

	public ArrayList<ManagerFilterVO> getManagersByDepartment(
			String[] departmentid,String userType,String directorcode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthReportDaoImpl: getManagersByDepartment : Starting");
    System.out.println("get manager be department ");
		PreparedStatement ps_managerList = null;
		ResultSet rs_managerList = null;
		
		Connection connection = null;
		ArrayList<ManagerFilterVO> manager_list = new ArrayList<ManagerFilterVO>();
   
		System.out.println("director code in dao impl " +directorcode);
		try {
			connection = getConnection();
	    	if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
	    		
	    		ps_managerList=connection.prepareStatement(MonthReportSqlUtil.GET_MANAGER_BY_DEPARTMENT_CODE_DIRECTOR);
	    		for(int i=0;i<departmentid.length;i++){
	    		    ps_managerList.setString(1,departmentid[i]);
	    		    ps_managerList.setString(2,directorcode);
	    		   
	    		    rs_managerList= ps_managerList.executeQuery();	
	    		    
	    		    	while(rs_managerList.next()){
	    		    		ManagerFilterVO managervo=new ManagerFilterVO();
	    		    		managervo.setManagerid(rs_managerList.getString("ManagerCode").trim());
	    		    		managervo.setManagername(rs_managerList.getString("FirstName"));
	    		    		manager_list.add(managervo);
	    		    	}
	    		    	
	    		    }
	    	}
	    	else
	    	{
	    	
	    		ps_managerList=connection.prepareStatement(MonthReportSqlUtil.GET_MANAGER_BY_DEPARTMENT_CODE);
	    		for(int i=0;i<departmentid.length;i++){
	    		    ps_managerList.setString(1,departmentid[i]);
	    		    
	    		   
	    		    rs_managerList= ps_managerList.executeQuery();	
	    		    
	    		    	while(rs_managerList.next()){
	    		    		ManagerFilterVO managervo=new ManagerFilterVO();
	    		    		managervo.setManagerid(rs_managerList.getString("ManagerCode").trim());
	    		    		managervo.setManagername(rs_managerList.getString("FirstName"));
	    		    		manager_list.add(managervo);
	    		    	}
	    		    	
	    		    }
	    		
	    	}
	    
	    
			System.out.println("manager list size in dao impl "
					+ manager_list.size());

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {

				if (ps_managerList != null && (!ps_managerList.isClosed())) {

					ps_managerList.close();
				}
				if (rs_managerList != null && (!rs_managerList.isClosed())) {

					rs_managerList.close();
				}
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthReportDaoImpl: getManagersByDepartment : Ending");

		return manager_list;

	}

}
