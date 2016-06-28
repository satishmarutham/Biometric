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
import org.json.JSONObject;

import com.centris.POJO.DepartMentReportPojo;
import com.centris.POJO.DesignationReportPojo;
import com.centris.POJO.EmployeeReportPojo;
import com.centris.POJO.ManagerReportPojo;
import com.centris.POJO.ProjectReportPojo;
import com.centris.VO.EmployeeVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.MonthReportVO;
import com.centris.VO.ProjectMasterVo;
import com.centris.delegate.AddDesignationBD;
import com.centris.delegate.DepartmentMasterBD;
import com.centris.delegate.ManagerMasterBD;
import com.centris.delegate.MonthReportBD;
import com.centris.delegate.ProjectMasterDelegate;
import com.centris.delegate.TimeSheetReportBD;
import com.centris.exception.AITrackerException;
import com.centris.form.AdminMonthReportForm;
import com.centris.form.ReportFormData;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class AdminMonthReportAction extends DispatchAction {

	private static Logger logger = Logger
			.getLogger(AdminMonthReportAction.class);

	public ActionForward getMonthReportHome(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : getMonthReportHome Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {

			/*
			 * request.setAttribute("MANAGER_LIST", new
			 * ManagerMasterBD().getAllManagersBD());
			 * request.setAttribute("DESIGNATION_LIST", new
			 * AddDesignationBD().getDesignationDetails());
			 */
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
			forward = MessageConstants.ADMIN_MONTH_REPORT;
		} else {
			forward = Director.DIRECTOR_GET_MONTH_REPORT;
		}
		return mapping.findForward(forward);
	}

	public ActionForward getManagers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : getManagers Starting");
		try {

			String departmentid = request.getParameter("departmentid");
			System.out.println("department ids after department onchange  function "
							+ departmentid);
			String userType=HelperClass.getCurrentUserIDType(request);
 			String dirctorCode=HelperClass.getCurrentUserID(request);
			String[] departmentid_array = departmentid.split(",");

			ArrayList<ManagerFilterVO> managerlist = new MonthReportBD()
					.getManagersByDepartment(departmentid_array,userType,dirctorCode);

			JSONObject object = new JSONObject();
			object.put("managerlist", managerlist);

			response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : getManagers Ending");

		return null;

	}

	public ActionForward getProjects(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : getProjects Starting");
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
				+ " Control in AdminMonthReportAction : getProjects Ending");

		return null;

	}

	public ActionForward getEmployees(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : getEmployees Starting");

		try {

			System.out.println("get employees ");

			String managerid = request.getParameter("managerid");

			//String[] managerid_array = managerid.split(",");

			ArrayList<EmployeeVO> employeelist = new MonthReportBD()
					.getEmployees(managerid);

			JSONObject object = new JSONObject();
			object.put("employeeList", employeelist);

			response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : getEmployees Ending");

		return null;

	}

	public ActionForward getmonthReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : getProjects Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {

			AdminMonthReportForm monthreportform = (AdminMonthReportForm) form;

			String minDate = monthreportform.getYear().trim() + "-"
					+ monthreportform.getMonth() + "-01";

			String maxDay = HelperClass.lastDayOftheMonth(monthreportform
					.getYear().trim(), monthreportform.getMonth().trim());

			String maxDate = monthreportform.getYear().trim() + "-"
					+ monthreportform.getMonth() + "-" + maxDay;

			List<String> allDates = HelperClass.getDateListBetweenDates(
					minDate, maxDate);

			ArrayList<EmployeeReportPojo> employeelist = new ArrayList<EmployeeReportPojo>();

			String[] employee_array = request.getParameterValues("employee");

			for (int i = 0; i < employee_array.length; i++) {

				EmployeeReportPojo employeepojo = new EmployeeReportPojo();
				employeepojo.setEmpid(employee_array[i]);
				employeelist.add(employeepojo);

			}
			ArrayList<MonthReportVO> monthreportlist = new MonthReportBD()
					.getMonthReport(employeelist, allDates);

			request.setAttribute("MonthReportList", monthreportlist);

			request.getSession(false).setAttribute("downloadMonthReportList",
					monthreportlist);
			/*
			 * request.setAttribute("MANAGER_LIST", new
			 * ManagerMasterBD().getAllManagersBD());
			 * request.setAttribute("DESIGNATION_LIST", new
			 * AddDesignationBD().getDesignationDetails());
			 request.setAttribute("DEPARTMENT_LIST", new
			 * DepartmentMasterBD().getDepartmentRecordsBD());
			 * request.setAttribute("ACC_YEAR", new
			 * TimeSheetReportBD().getAccYear());
			 */
			
			request.setAttribute("DEPARTMENT_LIST", new
					 DepartmentMasterBD().getDepartmentRecordsBD());
			request.setAttribute("ACC_YEAR", new
					TimeSheetReportBD().getAccYear());

			ReportFormData ReportFormData = new ReportFormData();
			ReportFormData.setEmployee(Arrays.toString(employee_array));
			ReportFormData.setMonth(monthreportform.getMonth());
			ReportFormData.setYear(monthreportform.getYear());

			request.setAttribute("ReportFormData", ReportFormData);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : getProjects Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.ADMIN_MONTH_REPORT;
		} else {
			forward = Director.DIRECTOR_GET_MONTH_REPORT;
		}
		return mapping.findForward(forward);
	}
}