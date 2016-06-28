/**
 * 
 */
package com.centris.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.DAO.DAOIMPL.AdminDayReportDaoImpl;
import com.centris.POJO.DepartMentReportPojo;
import com.centris.POJO.DesignationReportPojo;
import com.centris.POJO.EmployeeReportPojo;
import com.centris.POJO.ManagerReportPojo;
import com.centris.POJO.ProjectReportPojo;
import com.centris.VO.AdminDayReportVo;
import com.centris.VO.EmployeeVO;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.ReportsAjaxVo;
import com.centris.delegate.AddDesignationBD;
import com.centris.delegate.AdminDayReportBD;
import com.centris.delegate.AjaxReportBD;
import com.centris.delegate.DepartmentMasterBD;
import com.centris.delegate.ManagerMasterBD;
import com.centris.delegate.MonthReportBD;
import com.centris.delegate.ProjectMasterDelegate;
import com.centris.delegate.TimeSheetReportBD;
import com.centris.exception.AITrackerException;
import com.centris.form.AdminDayReportForm;
import com.centris.form.ReportFormData;
import com.centris.util.HelperClass;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

/**
 * @author sathish
 * 
 */

public class AdminDayReportAction extends DispatchAction {

	private static Logger logger = Logger.getLogger(AdminDayReportAction.class);

	public ActionForward getProjects(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

	/*	logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminDayReportAction : getProjects Starting");
		try {

			String managerid = request.getParameter("managerid");

			String[] managerid_array = managerid.split(",");

			ArrayList<ProjectMasterVo> projectlist = new ProjectMasterDelegate()
					.getProjectsByManager(managerid_array);

			JSONObject object = new JSONObject();
			object.put("projectlist", projectlist);

			response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminDayReportAction : getProjects Ending");
				
				
				
*/
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : getMonthReportHome Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {

			request.setAttribute("MANAGER_LIST",
					new ManagerMasterBD().getAllManagersBD());
			request.setAttribute("DESIGNATION_LIST",
					new AddDesignationBD().getDesignationDetails());
			request.setAttribute("DEPARTMENT_LIST",
					new DepartmentMasterBD().getDepartmentRecordsBD());
			request.setAttribute("ACC_YEAR",
					new TimeSheetReportBD().getAccYear());

		} catch (Exception exception) {
			logger.error(exception);
			logger.error(exception.getMessage(), exception);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : getMonthReportHome Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.ADMIN_DAY_REPORT;
		} else {
			forward = MessageConstants.DIRECTOR_DAY_REPORT;
		}
		return mapping.findForward(forward);
		
		
		
		
		

	}

	public ActionForward getDayReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminDayReportAction : getDayReport Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {

			AdminDayReportForm adminDayReportForm = (AdminDayReportForm) form;

			ArrayList<ManagerReportPojo> managerlist = new ArrayList<ManagerReportPojo>();
			ArrayList<ProjectReportPojo> projectlist = new ArrayList<ProjectReportPojo>();
			ArrayList<EmployeeReportPojo> employeelist = new ArrayList<EmployeeReportPojo>();
			ArrayList<DepartMentReportPojo> departmentlist = new ArrayList<DepartMentReportPojo>();
			ArrayList<DesignationReportPojo> designationlist = new ArrayList<DesignationReportPojo>();

			String[] manager_array = request.getParameterValues("manager");
	
			String[] department_array = request
					.getParameterValues("department");
			String[] employee_array = request.getParameterValues("employee");

			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");

			for (int i = 0; i < manager_array.length; i++) {

				ManagerReportPojo managerpojo = new ManagerReportPojo();

				if ("all".equalsIgnoreCase(adminDayReportForm
						.getManagercheckbox())) {
					managerpojo.setMgr_id("all");
					managerlist.add(managerpojo);

				} else {

					managerpojo.setMgr_id(manager_array[i]);
					managerlist.add(managerpojo);

				}
			}

		
			for (int i = 0; i < department_array.length; i++) {

				DepartMentReportPojo departmentpojo = new DepartMentReportPojo();

				if ("all".equalsIgnoreCase(adminDayReportForm
						.getDepartmentcheckbox())) {

					departmentpojo.setDeptid("all");
					departmentlist.add(departmentpojo);

				} else {
					departmentpojo.setDeptid(department_array[i]);
					departmentlist.add(departmentpojo);

				}
			}

			for (int i = 0; i < employee_array.length; i++) {

				EmployeeReportPojo employeepojo = new EmployeeReportPojo();
				employeepojo.setEmpid(employee_array[i]);

				employeelist.add(employeepojo);

			
			}

			
			
			ArrayList<AdminDayReportVo> dayReportList = new AdminDayReportDaoImpl().getadminDayReport(managerlist, projectlist, employeelist, departmentlist, designationlist, HelperClass.convertUIToDatabase(startDate),
					HelperClass.convertUIToDatabase(endDate));
			
					
					
			
			request.setAttribute("DayReportList", dayReportList);

			request.getSession(false).setAttribute("downloadDayReportList",
					dayReportList);

			request.setAttribute("MANAGER_LIST",
					new ManagerMasterBD().getAllManagersBD());
			request.setAttribute("DESIGNATION_LIST",
					new AddDesignationBD().getDesignationDetails());
			request.setAttribute("DEPARTMENT_LIST",
					new DepartmentMasterBD().getDepartmentRecordsBD());

			ReportFormData ReportFormData = new ReportFormData();
			ReportFormData.setManager(Arrays.toString(manager_array));
		
			ReportFormData.setDepartment(Arrays.toString(department_array));
			ReportFormData.setEmployee(Arrays.toString(employee_array));
			ReportFormData.setStartDate(adminDayReportForm.getStartDate());
			ReportFormData.setEndDate(adminDayReportForm.getEndDate());

			request.setAttribute("ReportFormData", ReportFormData);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminDayReportAction : getDayReport Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.ADMIN_DAY_REPORT;
		} else {
			forward = Director.DIRECTOR_GET_DAY_REPORT;
		}
		return mapping.findForward(forward);

	}

	public ActionForward getEmployees(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminDayReportAction : getEmployees Starting");

		try {

			String managerid = request.getParameter("managerid");
		
			ArrayList<EmployeeVO> employeelist = new MonthReportBD()
					.getEmployees(managerid);

			JSONObject object = new JSONObject();
			object.put("employeeList",employeelist);

			response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminDayReportAction : getEmployees Ending");

		return null;

	}

	public ActionForward dayReportHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminDayReportAction : dayReportHome Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {
		
			request.getSession(false).setAttribute("DEPARTMENT_LIST",
					new DepartmentMasterBD().getDepartmentRecordsBD());

		} catch (Exception exception) {
			logger.error(exception);
			logger.error(exception.getMessage(), exception);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminDayReportAction : dayReportHome Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.ADMIN_DAY_REPORT;
		} else {
			forward = Director.DIRECTOR_GET_DAY_REPORT;
		}
		return mapping.findForward(forward);

	}
	
	public ActionForward getManagersByDirectorCode(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAjaxAction : getManagersByDirectorCode Starting");
	
		try {
			String departmentCode=(String)request.getParameter("departmentCode");
			String[] departmentCodes=departmentCode.split(",");
			
			String userType=HelperClass.getCurrentUserIDType(request);
 			String dirctorCode=HelperClass.getCurrentUserID(request);
AjaxReportBD ajaxReportBD=new AjaxReportBD();
List<ReportsAjaxVo> getManagersByDirectorCode=ajaxReportBD.getManagersByDirectorCode(departmentCodes,userType,dirctorCode);




JSONObject jsonObject=new JSONObject();
jsonObject.accumulate("ManagerList",getManagersByDirectorCode);

response.getWriter().println(jsonObject);
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAjaxAction : getManagersByDirectorCode Ending");
		
		return null;

	}
	

	
	
	
	
	
	public ActionForward getProjectssByManagerCode(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAjaxAction : getManagersByDirectorCode Starting");
	
		try {
			String managerCode=(String)request.getParameter("managerCode");
			String[] managerCodes=managerCode.split(",");
 			
AjaxReportBD ajaxReportBD=new AjaxReportBD();
List<ReportsAjaxVo> getProjectsByManagerCode=ajaxReportBD.getProjectsByManagerCode(managerCodes);
request.getSession(false).setAttribute("ProjectList",getProjectsByManagerCode);
JSONObject jsonObject=new JSONObject();
jsonObject.accumulate("ProjectList",getProjectsByManagerCode);

JSONArray array=new JSONArray();
array.put(getProjectsByManagerCode);

response.getWriter().println(jsonObject);
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAjaxAction : getProjectssByManagerCode Ending");
		
		return null;

	}
	
	
	
	
}