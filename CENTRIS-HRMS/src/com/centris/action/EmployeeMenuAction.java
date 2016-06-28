package com.centris.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;

import com.centris.DAO.DAOIMPL.EmployeeLeaveStatusDaoImpl;
import com.centris.DAO.DAOIMPL.EmployeeResumeCreationDaoImpl;
import com.centris.POJO.EmployeeExpenseDetailsPojo;
import com.centris.POJO.EmployeeLeaveStatusPojo;
import com.centris.POJO.EmployeePersonalDetailsPojo;
import com.centris.POJO.EmployeeResumeCreationPojo;
import com.centris.VO.EmployeeAttendancePostingVo;
import com.centris.VO.EmployeeExpenseDetailsVo;
import com.centris.VO.EmployeePersonalDetailsVo;
import com.centris.VO.LeaveViewDetailsVo;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.EmpDashBoardInManagerBD;
import com.centris.delegate.EmployeeAttendancePostingBD;
import com.centris.delegate.EmployeeDashboardBD;
import com.centris.delegate.EmployeeExpenseDetailsBD;
import com.centris.delegate.EmployeeLeaveRequestBD;
import com.centris.delegate.EmployeePersonalDetailsBD;
import com.centris.delegate.TimeSheetReportBD;
import com.centris.exception.AITrackerException;
import com.centris.util.HelperClass;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class EmployeeMenuAction extends DispatchAction {

	private static Logger logger = Logger.getLogger(EmployeeMenuAction.class);

	public ActionForward home(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : home Starting");

		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
				.getAttribute("UserDetails");

		request.setAttribute("DailyAllowances", new EmployeeDashboardBD()
				.getDailyAllowances(userDetailVO.getUserCode()));
		request.setAttribute("PersonalDetails", new EmpDashBoardInManagerBD()
				.getPersonalDetails(userDetailVO.getUserCode()));
		/*request.setAttribute("AttendanceDetails", new EmployeeDashboardBD()
				.getAttendanceDetails(userDetailVO.getUserCode()));*/
		request.setAttribute("AttendanceDetails",
				new EmployeeDashboardBD()
						.getPendingAttendanceDetails(userDetailVO
								.getUserCode()));
		request.setAttribute("threemonthsAttendanceDetails", new EmployeeDashboardBD()
						.getAttendanceDetails(userDetailVO
								.getUserCode()));
		EmpDashBoardInManagerBD managerbd=new EmpDashBoardInManagerBD();
		
		request.setAttribute("ExpensesDetails", managerbd.getClaimsByManagerBD(userDetailVO
				.getUserCode()));
		request.setAttribute("ADVANCESALARYDETAILS", managerbd.getAdvanceSalDetailsBD(userDetailVO
				.getUserCode()));
		
		request.setAttribute("TravelDetails", new EmployeeDashboardBD().getTravelAllowanceBD(userDetailVO.getUserCode()));
		request.setAttribute("ViewLeaveDetails", new EmployeeDashboardBD().getviewLeaveDetails(userDetailVO.getUserCode()));
		
		String employeeCode = userDetailVO.getUserCode();
		EmployeeResumeCreationDaoImpl creationDaoImpl = new EmployeeResumeCreationDaoImpl();
		Map<String, List<EmployeeResumeCreationPojo>> resumeDetails = creationDaoImpl
				.getResumeDetails(employeeCode);

		if (resumeDetails.size() != 0) {
			for (Map.Entry<String, List<EmployeeResumeCreationPojo>> entry : resumeDetails
					.entrySet()) {
				if (entry.getKey() == "Hobbies") {
					request.setAttribute("Hobbies", entry.getValue());
				} else if (entry.getKey() == "Responsibilities") {

					request.setAttribute("Responsibilities", entry.getValue());
				}

				else if (entry.getKey() == "TechnicalSkills") {

					request.setAttribute("TechnicalSkills", entry.getValue());
				} else if (entry.getKey() == "PursuitsList") {

					request.setAttribute("PursuitsList", entry.getValue());
				}

				else if (entry.getKey() == "CareerObjective") {

					request.setAttribute("CareerObjective", entry.getValue());
				} else if (entry.getKey() == "Experience") {

					request.setAttribute("Experience", entry.getValue());
				} else if (entry.getKey() == "EmployeeDetails") {

					request.setAttribute("EmployeeDetails",
							entry.getValue());
				}
			}
		} else {

		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : home Ending");
		return mapping.findForward(StringUtils.EMPLOYEE_HOME);
	}

	public ActionForward changePassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : changePassword Starting");

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : changePassword Ending");

		return mapping.findForward(StringUtils.EMPLOYEE_CHANGEPASSWORD);
	}

	public ActionForward postattendance(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : postattendance Starting");

		EmployeeAttendancePostingBD delegate_Obj = new EmployeeAttendancePostingBD();
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String userCode = userDetailVO.getUserCode();
			String userName = userDetailVO.getUserName();
			
			HashMap<String,String> privilegesMap=(HashMap<String, String>)request.getSession(false).getAttribute("privileges");
			
			EmployeeAttendancePostingVo getAttendance = delegate_Obj
					.getEmployeeAttendance(userName, userCode,privilegesMap);

			request.setAttribute("getAttendanceDetails",
					getAttendance.getGet_AttendanceDetails());

			String result = request.getParameter("message");
		
			if(result!=null){
			if (result.equalsIgnoreCase("Saved")) {
			
				request.setAttribute("message", MessageConstants.ATTENDANCE_POST_SUCCESS);

			}else if(result.equalsIgnoreCase(MessageConstants.MAIL_NOT_SENT)){
			
				request.setAttribute("errorMessage", MessageConstants.ATTENDANCE_POST_MAIL_NOT_SENT);
			}else{
				
				request.setAttribute("errorMessage",  MessageConstants.ATTENDANCE_POST_FAILURE);
			}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : postattendance Ending");
		return mapping.findForward(StringUtils.EMPLOYEE_POSTATTENDANCE);
	}

	public ActionForward employeeLeaveStatus(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : employeeLeaveStatus Starting");

		try {

			EmployeeLeaveStatusDaoImpl daoImpl = new EmployeeLeaveStatusDaoImpl();
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String userCode = userDetailVO.getUserCode();
			List<EmployeeLeaveStatusPojo> employeeLeaveStatusPojos = daoImpl
					.getLeaveStatus(userCode);
		

			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("employeeLeaveStatusPojos",
					employeeLeaveStatusPojos);
			request.setAttribute("employeeLeaveStatusPojos",
					employeeLeaveStatusPojos);
String successMessage=request.getParameter("successMesage");

if(successMessage.equalsIgnoreCase(MessageConstants.TRUE)){
	
	request.setAttribute("successMessage", MessageConstants.LEAVE_REQUEST_UPDATE_SUCCESS);

}else if(successMessage.equalsIgnoreCase(MessageConstants.MAIL_NOT_SENT)){
	
	request.setAttribute("errorMessage", MessageConstants.LEAVE_REQUEST_UPDATE_FAILURE_MAIL_NOT_SEND);

}else{
	
	request.setAttribute("errorMessage", MessageConstants.LEAVE_REQUEST_UPDATE_FAILURE);
}


			
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : employeeLeaveStatus Ending");
		return mapping.findForward(StringUtils.EMPLOYEE_LEAVE_STATUS);
	}

	public ActionForward getEmployeePersonalDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : getEmployeePersonalDetails Starting");
		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			EmployeePersonalDetailsBD obj = new EmployeePersonalDetailsBD();

			EmployeePersonalDetailsPojo employeeDetailsPojo = new EmployeePersonalDetailsPojo();

			employeeDetailsPojo.setEmpId(userDetailVO.getEmpId().trim());
	

			Map<String, List<EmployeePersonalDetailsVo>> getDetails = obj
					.getEmployeePersonalDetails(employeeDetailsPojo);

			request.setAttribute("employeePersonalDetails", getDetails);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : getEmployeePersonalDetails Ending");

		return mapping.findForward(StringUtils.EMPLOYEE_GETPERSONALDETAILS);
	}

	public ActionForward expenseDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : expenseDetails Starting");
		EmployeeExpenseDetailsBD delegateObj = new EmployeeExpenseDetailsBD();
		List<EmployeeExpenseDetailsVo> employeeDetails = new ArrayList<EmployeeExpenseDetailsVo>();

		EmployeeExpenseDetailsPojo obj = new EmployeeExpenseDetailsPojo();
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			obj.setUserCode((userDetailVO.getUserCode().trim()));
			obj.setUserName((userDetailVO.getUserName().trim()));

			employeeDetails = delegateObj.getEmployeeDetails(obj);
			String bioId = null;
			String empId = null;
			String Name = null;
			String Email = null;
			String Designation = null;
			String Contact = null;
			String ManagerName = null;
			String ManagerId = null;
			for (EmployeeExpenseDetailsVo kk : employeeDetails) {
				bioId = kk.getEmp_BioId();
				Name = kk.getEmp_Name();
				Email = kk.getEmp_MailId();
				Designation = kk.getEmp_Designation();
				Contact = kk.getEmp_ContactNumber();
				ManagerName = kk.getEmp_ProjectManagerName();
				empId = kk.getEmp_ID();
				ManagerId = kk.getEmp_ManagerId();
			}
			
		
			request.setAttribute("employee_BioID", bioId);
			request.setAttribute("employee_ID", empId);
			request.setAttribute("employee_Name", Name);
			request.setAttribute("employee_Email", Email);

		
			request.setAttribute("employee_Desig", Designation);
			request.setAttribute("employee_Contact", Contact);
			
			Map<String,String> userpriviliges =(Map<String,String>)request.getSession(false).getAttribute("privileges");
			String userprevstatus = userpriviliges.get(MessageConstants.MANAGER);
		
			if(MessageConstants.YES.equalsIgnoreCase(userprevstatus)){
				
				Map<String,String> mangdiecormap= delegateObj.getManagerDireDetails(empId);
				
				request.setAttribute("employee_ManagerName", mangdiecormap.get("DireName"));
				request.setAttribute("employee_MangId", mangdiecormap.get("MangCode"));
				request.setAttribute("LoginUsermangid", mangdiecormap.get("MangCode"));
		
			}else{
				
			request.setAttribute("employee_ManagerName", ManagerName);
			request.setAttribute("employee_MangId", ManagerId);
					
			}
			
		

			request.setAttribute("ACC_YEAR",
					new TimeSheetReportBD().getAccYear());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : expenseDetails Ending");
		return mapping.findForward(StringUtils.EMPLOYEE_EXPENSE_DETAILS);
	}

	public ActionForward leaveDetailsHome(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : leaveDetailsHome Starting");

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : leaveDetailsHome Ending");

		return mapping.findForward(StringUtils.LEAVE_DETAILS_HOME);
	}

	public ActionForward getviewLeaveDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : getviewLeaveDetails Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");

			ArrayList<LeaveViewDetailsVo> leaveViewDetailsVo = new EmployeeLeaveRequestBD().getviewLeaveDetails(userDetailVO.getUserCode().trim());
			request.setAttribute("ViewLeaveDetails", leaveViewDetailsVo);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeMenuAction : getviewLeaveDetails Ending");

		return mapping.findForward(StringUtils.LEAVE_DETAILS_HOME);
	}

	public ActionForward employeeResumeCreation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : employeeResumeCreation Starting");

		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
				.getAttribute("UserDetails");
		
		String successMessage=request.getParameter("message");
		
		request.setAttribute("status",successMessage);

		String employeeCode = userDetailVO.getUserCode();
		EmployeeResumeCreationDaoImpl creationDaoImpl = new EmployeeResumeCreationDaoImpl();
		Map<String, List<EmployeeResumeCreationPojo>> resumeDetails = creationDaoImpl
				.getResumeDetails(employeeCode);


		if (resumeDetails.size() != 0) {
			for (Map.Entry<String, List<EmployeeResumeCreationPojo>> entry : resumeDetails
					.entrySet()) {
				if (entry.getKey() == "Hobbies") {
					request.setAttribute("Hobbies", entry.getValue());
				} else if (entry.getKey() == "Responsibilities") {

					request.setAttribute("Responsibilities", entry.getValue());
				}

				else if (entry.getKey() == "TechnicalSkills") {

					request.setAttribute("TechnicalSkills", entry.getValue());
				} else if (entry.getKey() == "PursuitsList") {

					request.setAttribute("PursuitsList", entry.getValue());
				}

				else if (entry.getKey() == "CareerObjective") {

					request.setAttribute("CareerObjective", entry.getValue());
				} else if (entry.getKey() == "Experience") {

					request.setAttribute("Experience", entry.getValue());
				} else if (entry.getKey() == "EmployeeDetails") {

					request.setAttribute("EmployeePersonalDetails",
							entry.getValue());
				}
			}
		} else {

		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: employeeResumeCreation Ending");
		return mapping.findForward(StringUtils.EMPLOYEE_RESUME_CREATION);
	}

	public ActionForward getProjectDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getProjectDetails  Starting");

		EmployeeExpenseDetailsBD delegateObj = new EmployeeExpenseDetailsBD();
		List<EmployeeExpenseDetailsVo> employeeDetails = new ArrayList<EmployeeExpenseDetailsVo>();

		try {
			String managerId = request.getParameter("managerIdVal").trim();
			employeeDetails = delegateObj.getEmployeeProjectDetails(managerId);
			JSONObject jsonObject = new JSONObject(employeeDetails);
			jsonObject.accumulate("projectDetails", employeeDetails);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getProjectDetails Ending");
		return null;
	}
}