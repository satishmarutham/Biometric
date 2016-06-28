package com.centris.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;

import com.centris.DAO.DAOIMPL.EmployeeResumeCreationDaoImpl;
import com.centris.POJO.EmployeeResumeCreationPojo;
import com.centris.VO.EmpVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AdminForgotPasswordBD;
import com.centris.delegate.DirectorForgotPasswordBD;
import com.centris.delegate.EmpDashBoardInManagerBD;
import com.centris.delegate.EmployeeDashboardBD;
import com.centris.delegate.EmployeeForgotPassBD;
import com.centris.delegate.LoginBD;
import com.centris.delegate.ManagerForgotPasswordBD;
import com.centris.exception.AITrackerException;
import com.centris.util.HelperClass;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class LoginCheckAction extends DispatchAction {

	private static Logger logger = Logger.getLogger(LoginCheckAction.class);

	public ActionForward checkLoginDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : checkLoginDetails Starting");
		try {

			String username = (String) request.getParameter("uname");
			String password = (String) request.getParameter("pword");
			String type = (String) request.getParameter("type").trim();

			LoginBD login_bd = new LoginBD();
			if (login_bd.isValidUser(username, password, type).equals(
					StringUtils.LOGIN_TRUE)) {

				JSONObject object = new JSONObject();
				object.put("status", true);

				response.getWriter().print(object);
			} else {

				JSONObject object = new JSONObject();
				object.put("status", false);

				response.getWriter().print(object);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : checkLoginDetails: Ending");

		return null;
	}

	public ActionForward userValidCase(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : userValidCase Starting");

		try {

			String username = (String) request.getParameter("uname").trim();
			String password = (String) request.getParameter("pword").trim();
			String type = (String) request.getParameter("type").trim();

			LoginBD login_bd = new LoginBD();
			if (login_bd.userValidCase(username, password, type).equals(
					StringUtils.LOGIN_TRUE)) {

				JSONObject object = new JSONObject();
				object.put("status", true);

				response.getWriter().print(object);
			} else {

				JSONObject object = new JSONObject();
				object.put("status", false);

				response.getWriter().print(object);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : userValidCase: Ending");

		return null;
	}

	public synchronized ActionForward submitLogin(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginAction : submitLogin Starting");

		String username = (String) request.getParameter("userName").trim();
		String password = (String) request.getParameter("password").trim();
	//	String userType = (String) request.getParameter("userType");
		
		

		try {

			LoginBD login_bd = new LoginBD();
					
			UserDetailVO userDetailVO = login_bd.getUserAdminDetails(username, password);
			
			HttpSession session = request.getSession(false);
			
			session.setAttribute(StringUtils.USER_NAME, username);
			
			session.setAttribute(StringUtils.USER_DETAILS,userDetailVO);
			
			return mapping
					.findForward(ApplicationConstants.ADMIN_LOGIN);
			
          
		
			
			
			
			
/*
			if (login_bd.isValidUser(username, password, userType).equals(
					StringUtils.LOGIN_TRUE)) {
				HttpSession session = request.getSession(false);
				session.setAttribute(StringUtils.USERNAME, username);

				if (ApplicationConstants.USER_ADMIN.equalsIgnoreCase(userType)) {

					session.setAttribute(StringUtils.USER_DETAILS, login_bd
							.getUserAdminDetails(username, password, userType));
					
					UserDetailVO userDetailVO = login_bd
							.getUserAdminDetails(username, password,
									userType);
					
					if(userDetailVO!=null){
						
					session.setAttribute("privileges", login_bd.getLoginEmployeePrivilegesBD(userDetailVO.getUserCode()));
				
					}

					JLogger.log(0, JDate.getTimeString(new Date())
							+ MessageConstants.END_POINT);
					logger.info(JDate.getTimeString(new Date())
							+ " Control in LoginCheckAction : submitLogin Ending");

					return mapping
							.findForward(ApplicationConstants.ADMIN_LOGIN);
				}

				else if (ApplicationConstants.USER_MANAGER
						.equalsIgnoreCase(userType)) {

					session.setAttribute(StringUtils.USER_DETAILS,
							login_bd.getUserManagerDetails(username, password,
									userType));

					UserDetailVO userDetailVO = (UserDetailVO) request
							.getSession(false).getAttribute("UserDetails");
					String currentuser = userDetailVO.getUserCode();
					
					if(userDetailVO!=null){
					session.setAttribute("privileges", login_bd.getLoginEmployeePrivilegesBD(userDetailVO.getUserCode()));
					}
					ArrayList<EmpVO> employeelist = new EmpDashBoardInManagerBD()
							.getAllEmployeesUnderManager(currentuser);
					request.setAttribute("EmployeeDetails", employeelist);

					JLogger.log(0, JDate.getTimeString(new Date())
							+ MessageConstants.END_POINT);
					logger.info(JDate.getTimeString(new Date())
							+ " Control in LoginCheckAction : submitLogin Ending");

					return mapping
							.findForward(ApplicationConstants.MANAGER_LOGIN);
				} else

				if (ApplicationConstants.USER_EMPLOYEE
						.equalsIgnoreCase(userType)) {
					UserDetailVO userDetailVO = login_bd
							.getUserEmployeeDetails(username, password,
									userType);
					session.setAttribute(StringUtils.USER_DETAILS, userDetailVO);

					request.setAttribute("AttendanceDetails",
							new EmployeeDashboardBD()
									.getPendingAttendanceDetails(userDetailVO
											.getUserCode()));
					request.setAttribute("threemonthsAttendanceDetails", new EmployeeDashboardBD()
									.getAttendanceDetails(userDetailVO
											.getUserCode()));
					
					request.setAttribute("DailyAllowances",
							new EmployeeDashboardBD()
									.getDailyAllowances(userDetailVO
											.getUserCode()));
					request.setAttribute("PersonalDetails",
							new EmpDashBoardInManagerBD()
									.getPersonalDetails(userDetailVO
											.getUserCode()));
					if(userDetailVO!=null){
					session.setAttribute("privileges", login_bd.getLoginEmployeePrivilegesBD(userDetailVO.getUserCode()));
					}
					EmpDashBoardInManagerBD managerbd=new EmpDashBoardInManagerBD();
					
					request.setAttribute("ExpensesDetails", managerbd.getClaimsByManagerBD(userDetailVO
							.getUserCode()));
					request.setAttribute("ADVANCESALARYDETAILS", managerbd.getAdvanceSalDetailsBD(userDetailVO
							.getUserCode()));
					request.setAttribute("TravelDetails", new EmployeeDashboardBD().getTravelAllowanceBD(userDetailVO.getUserCode()));
					request.setAttribute("ViewLeaveDetails", new EmployeeDashboardBD().getviewLeaveDetails(userDetailVO
							.getUserCode()));
					
					
					EmployeeResumeCreationDaoImpl creationDaoImpl = new EmployeeResumeCreationDaoImpl();

					Map<String, List<EmployeeResumeCreationPojo>> resumeDetails = creationDaoImpl
							.getResumeDetails(userDetailVO.getUserCode());
					if (resumeDetails.size() != 0) {
						for (Map.Entry<String, List<EmployeeResumeCreationPojo>> entry : resumeDetails
								.entrySet()) {
							if (entry.getKey() == "Hobbies") {
								request.setAttribute("Hobbies",
										entry.getValue());
							} else if (entry.getKey() == "Responsibilities") {

								request.setAttribute("Responsibilities",
										entry.getValue());
							}

							else if (entry.getKey() == "TechnicalSkills") {

								request.setAttribute("TechnicalSkills",
										entry.getValue());
							} else if (entry.getKey() == "PursuitsList") {

								request.setAttribute("PursuitsList",
										entry.getValue());
							} else if (entry.getKey() == "CareerObjective") {

								request.setAttribute("CareerObjective",
										entry.getValue());
							} else if (entry.getKey() == "EmployeeDetails") {

								request.setAttribute("EmployeeDetails",
										entry.getValue());
							} else if (entry.getKey() == "Experience") {

								request.setAttribute("Experience",
										entry.getValue());
							}

						}
					} else {

					}

					JLogger.log(0, JDate.getTimeString(new Date())
							+ MessageConstants.END_POINT);
					logger.info(JDate.getTimeString(new Date())
							+ " Control in LoginCheckAction : submitLogin Ending");

					return mapping
							.findForward(ApplicationConstants.EMPLOYEE_LOGIN);
				}

				else if (ApplicationConstants.USER_DIRECTOR
						.equalsIgnoreCase(userType)) {

					session.setAttribute(StringUtils.USER_DETAILS, login_bd
							.getUserDirectorDetails(username, password,
									userType));

					UserDetailVO userDetailVO = login_bd
							.getUserDirectorDetails(username, password,
									userType);
					if(userDetailVO!=null){
					session.setAttribute("privileges", login_bd.getLoginEmployeePrivilegesBD(userDetailVO.getUserCode()));
					}
					JLogger.log(0, JDate.getTimeString(new Date())
							+ MessageConstants.END_POINT);
					logger.info(JDate.getTimeString(new Date())
							+ " Control in LoginCheckAction : submitLogin Ending");

					return mapping
							.findForward(ApplicationConstants.DIRECTOR_LOGIN);
				}

				JLogger.log(0, JDate.getTimeString(new Date())
						+ MessageConstants.END_POINT);
				logger.info(JDate.getTimeString(new Date())
						+ " Control in LoginCheckAction : submitLogin Ending");
				return mapping.findForward(ApplicationConstants.SUCCESS);
			}*/
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : submitLogin Ending");

		return mapping.findForward(ApplicationConstants.FAILURE);
	}

	public ActionForward getForgetPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : getForgetPassword Starting");

		try {
			String userType = request.getParameter("checkType");

			if (ApplicationConstants.USER_MANAGER.equalsIgnoreCase(userType)) {
				request.setAttribute(ApplicationConstants.USER_MANAGER,
						ApplicationConstants.USER_MANAGER);
			}

			else if (ApplicationConstants.USER_EMPLOYEE
					.equalsIgnoreCase(userType)) {
				request.setAttribute(ApplicationConstants.USER_EMPLOYEE,
						ApplicationConstants.USER_EMPLOYEE);
			} else if (ApplicationConstants.USER_ADMIN
					.equalsIgnoreCase(userType)) {
				request.setAttribute(ApplicationConstants.USER_ADMIN,
						ApplicationConstants.USER_ADMIN);
			}
			else if (ApplicationConstants.USER_DIRECTOR
					.equalsIgnoreCase(userType)) {
				request.setAttribute(ApplicationConstants.USER_DIRECTOR,
						ApplicationConstants.USER_DIRECTOR);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : getForgetPassword Ending");

		return mapping
				.findForward(ApplicationConstants.FORGET_PASSWORD_REQUEST);
	}

	public ActionForward sendManagerPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendManagerPassword Starting");

		try {
			String username = request.getParameter("username");
			String email = request.getParameter("email");

			ManagerForgotPasswordBD forgotPasswordBD = new ManagerForgotPasswordBD();

			int result = forgotPasswordBD.resetManagerPassword(username, email);
			
			JSONObject jsonObject = new JSONObject();
			String message = null;
			if (result == 1) {
				message = "successMessage";
			} else if(result==2 ) {
				message = "errorMessage";
			}
			jsonObject.put("message", message);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendManagerPassword Ending");

		return null;
	}

	public ActionForward sendEmployeePassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendEmployeePassword Starting");

		try {
			String dateofbirth = request.getParameter("dateofbirth");
			String emp_official_emailid = request
					.getParameter("emp_official_emailid");
			int result = new EmployeeForgotPassBD().checkEmployeeBD(
					dateofbirth, emp_official_emailid);
				
				JSONObject jsonObject = new JSONObject();
				String message = null;
				if (result == 1) {
					message = "successMessage";
				} else if(result == 2 ) {
					message = "errorMessage";
				}
				jsonObject.put("message", message);
				response.getWriter().print(jsonObject);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendEmployeePassword Ending");

		return null;
	}

	public ActionForward sendAdminPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendAdminPassword Starting");
		try {
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			
			AdminForgotPasswordBD forgotPasswordBD = new AdminForgotPasswordBD();

			int result = forgotPasswordBD.resetAdminPassword(username, email);
			
			JSONObject jsonObject = new JSONObject();
			String message = null;
			if (result == 1) {
				message = "successMessage";
			} else if(result == 2 ) {
				message = "errorMessage";
			}
			jsonObject.put("message", message);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendAdminPassword Ending");

		return null;
	}
	
	public ActionForward sendDirectorPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendDirectorPassword Starting");

		try {
			String username = request.getParameter("username");
			String email = request.getParameter("email");

			DirectorForgotPasswordBD forgotPasswordBD = new DirectorForgotPasswordBD();

			int result = forgotPasswordBD.resetDirectorPassword(username, email);

				JSONObject jsonObject = new JSONObject();
				String message = null;
				if (result == 1) {
					message = "successMessage";
				} else if(result == 2 ) {
					message = "errorMessage";
				}
				jsonObject.put("message", message);
				response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendDirectorPassword Ending");

		return null;
	}
	
	
	public ActionForward loginaction(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : loginaction Starting");

		try {
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : loginaction Ending");

		return mapping.findForward("failure");
	}
}