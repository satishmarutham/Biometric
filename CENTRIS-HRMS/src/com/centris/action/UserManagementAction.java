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

import com.centris.delegate.AddDesignationBD;
import com.centris.delegate.RoleMasterBD;
import com.centris.delegate.UserManagementBD;
import com.centris.form.UserManagementForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class UserManagementAction extends DispatchAction {

	private static Logger logger = Logger.getLogger(UserManagementAction.class);

	public synchronized ActionForward getEmpIdNameBySerachTerm(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserManagementAction:"
				+ " getEmpIdNameBySerachTerm Starting");

		try {

			String name_startsWith = request.getParameter("name_startsWith");
			String designation = request.getParameter("designation");

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response", new UserManagementBD()
					.getEmpIdNameBySerachTerm(name_startsWith, designation));
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserManagementAction: "
				+ "getEmpIdNameBySerachTerm Ending");

		return null;
	}

	public synchronized ActionForward getUserMangementRoles(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserManagementAction:"
				+ " getUserMangementRoles Starting");

		try {

			String empId = request.getParameter("EmpId");

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response",
					new UserManagementBD().getUserMangementRoles(empId));
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserManagementAction: "
				+ "getUserMangementRoles Ending");

		return null;
	}

	public synchronized ActionForward saveEmployeeRole(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserManagementAction:"
				+ " saveEmployeeRole Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			UserManagementForm userForm = (UserManagementForm) form;
			String userId = HelperClass.getCurrentUserID(request);

			String status = new UserManagementBD().saveEmployeeRole(userForm,
					userId);

			if (status.equalsIgnoreCase("true")) {

				request.setAttribute("errorMessage",
						"Role permissions saved successfully,Mail not sent ");
				
			} else if(status.equalsIgnoreCase("mailSent")){
				
				request.setAttribute("message",
						"Role permissions saved successfully");
				
			}else{

				request.setAttribute("errorMessage",
						"Role permissions not saved successfully");
			}

			request.setAttribute("DESIGNATIONLIST",
					new AddDesignationBD().getDesignationDetails());

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in saveEmployeeRole: "
				+ "getUserMangementRoles Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.USER_MANGEMENT;
		} else {
			forward = Director.DIRECTOR_USER_MANGEMENT;
		}
		return mapping.findForward(forward);
	}
	
	public synchronized ActionForward getAllNRoles(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserManagementAction: getAllNRoles Starting");

		try {

				
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("RolesList", new RoleMasterBD().getAllNRoles());
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserManagementAction: getAllNRoles Ending");

		return null;
	}

}