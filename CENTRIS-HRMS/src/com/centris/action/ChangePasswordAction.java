package com.centris.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;

import com.centris.DAO.DAOIMPL.ChangePasswordDaoImpl;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.ChangePasswordBD;
import com.centris.exception.AITrackerException;
import com.centris.form.ChangePasswordForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class ChangePasswordAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(ChangePasswordAction.class);

	public ActionForward getManagerCurrentPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : getManagerCurrentPassword Starting");

		try {
			String currentPassword = request.getParameter("oldpasswordval");

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String username = userDetailVO.getUserName();

			boolean status = new ChangePasswordBD()
					.checkManagerCurrentPassword(username, currentPassword);

			JSONObject object = new JSONObject();
			object.put("status", status);
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : getManagerCurrentPassword Ending");
		return null;
	}

	public ActionForward updateManagerPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : updateManagerPassword Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			ChangePasswordForm changePasswordForm = (ChangePasswordForm) form;
			String username = userDetailVO.getUserName();

			String oldPassword = request.getParameter("oldpasswordVal");
			String newpassword = request.getParameter("passwordVal");
			String confirmPassword = request.getParameter("checkVal");
			String email = request.getParameter("mailIdVal");

			changePasswordForm.setManager_Oldpassword(oldPassword);
			changePasswordForm.setManager_Newpassword(newpassword);
			changePasswordForm.setManager_Confirmpassword(confirmPassword);
			changePasswordForm.setManager_EmailID(email);
			changePasswordForm.setUserName(username);
			ChangePasswordBD changePasswordBD = new ChangePasswordBD();
			String updatePassword = changePasswordBD
					.updateManagerPassword(changePasswordForm);

			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("updatePassword", updatePassword);
			response.getWriter().print(jsonObject);

		}

		catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : updateManagerPassword Ending");
		return null;
	}

	/*
	 * public ActionForward ManagerEmailCheck(ActionMapping mapping, ActionForm
	 * form, HttpServletRequest request, HttpServletResponse response) throws
	 * AITrackerException, Exception { logger.setLevel(Level.DEBUG);
	 * JLogger.log(0, JDate.getTimeString(new Date()) +
	 * MessageConstants.START_POINT); logger.info(JDate.getTimeString(new
	 * Date()) +
	 * " Control in ChangePasswordAction : managerEmailIdCheck Starting");
	 * 
	 * try {
	 * 
	 * UserDetailVO userDetailVO = (UserDetailVO) request
	 * .getSession(false).getAttribute("UserDetails");
	 * 
	 * String userName = userDetailVO.getUserName(); String email =
	 * request.getParameter("emailVal"); ChangePasswordDaoImpl
	 * changePasswordDaoImpl = new ChangePasswordDaoImpl(); String status =
	 * changePasswordDaoImpl.checkManagerMail(email, userName); JSONObject
	 * jsonObject = new JSONObject(); jsonObject.accumulate("status", status);
	 * 
	 * response.getWriter().print(jsonObject);
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage(), e);
	 * 
	 * } logger.setLevel(Level.DEBUG); JLogger.log(0, JDate.getTimeString(new
	 * Date()) + MessageConstants.END_POINT);
	 * logger.info(JDate.getTimeString(new Date()) +
	 * " Control in ChangePasswordAction : managerEmailIdCheck Ending"); return
	 * null; }
	 */

	public ActionForward getAdminCurrentPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : getAdminCurrentPassword Starting");

		try {
			String currentPassword = request.getParameter("oldpasswordval");
			String passwordType = HelperClass.getCurrentUserIDType(request);
			String username = (String) request.getSession(false)
					.getAttribute("username").toString();

			boolean status = new ChangePasswordBD().checkAdminCurrentPassword(
					username, currentPassword, passwordType);
			JSONObject object = new JSONObject();
			object.put("status", status);
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : getAdminCurrentPassword Ending");
		return null;
	}

	public ActionForward updateAdminPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : updateAdminPassword Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			ChangePasswordForm changePasswordForm = (ChangePasswordForm) form;

			String oldPassword = request.getParameter("oldpasswordVal");
			String newpassword = request.getParameter("passwordVal");
			String confirmPassword = request.getParameter("checkVal");

			String username = userDetailVO.getUserName();

			changePasswordForm.setAdmin_Oldpassword(oldPassword);
			changePasswordForm.setAdmin__Newpassword(newpassword);
			changePasswordForm.setAdmin__Confirmpassword(confirmPassword);
			changePasswordForm.setUserName(username);
			changePasswordForm.setCurrentUserId(userDetailVO.getUserCode()
					.trim());

			ChangePasswordBD changePasswordBD = new ChangePasswordBD();
			String updatePassword = changePasswordBD
					.updateAdminPassword(changePasswordForm);

			JSONObject jsonObject = new JSONObject();

			jsonObject.accumulate("updatePassword", updatePassword);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);

		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : updateAdminPassword Ending");
		return null;
	}

	public ActionForward updateEmployeePassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : updateEmployeePassword Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			ChangePasswordForm changePasswordForm = (ChangePasswordForm) form;
			String username = userDetailVO.getUserName();
			String oldPassword = request.getParameter("oldpasswordVal");
			String newpassword = request.getParameter("passwordVal");
			String confirmPassword = request.getParameter("checkVal");

			String email = request.getParameter("email");
			changePasswordForm.setEmployee_Oldpassword(oldPassword);
			changePasswordForm.setEmployee__Newpassword(newpassword);
			changePasswordForm.setEmployee__Confirmpassword(confirmPassword);
			changePasswordForm.setEmployee_EmailID(email);
			changePasswordForm.setUserName(username);

			ChangePasswordBD changePasswordBD = new ChangePasswordBD();
			String updatePassword = changePasswordBD
					.updateEmployeePassword(changePasswordForm);
			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("updatePassword", updatePassword);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : updateEmployeePassword Ending");
		return mapping.findForward("employee_home");
	}

	public ActionForward getEmployeeCurrentPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : getEmployeeCurrentPassword Starting");

		try {
			String currentPassword = request.getParameter("oldpasswordval");

			String username = (String) request.getSession(false)
					.getAttribute("username").toString();

			boolean status = new ChangePasswordDaoImpl()
					.checkEmployeeCurrentPassword(username, currentPassword);
			JSONObject object = new JSONObject();
			object.put("status", status);
			// System.out.println("object" + object);
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : getEmployeeCurrentPassword Ending");
		return null;
	}

	public ActionForward getEmployeeDOB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : getEmployeeDOB Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			String empId = userDetailVO.getUserCode();
			String dob = request.getParameter("dob");
			// System.out.println("DOB in Action:::" + dob);
			ChangePasswordDaoImpl changePasswordDaoImpl = new ChangePasswordDaoImpl();
			String status = changePasswordDaoImpl.getEmployeeDOB(empId, dob);
			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("status", status);

			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : getEmployeeDOB Ending");
		return null;
	}

}