package com.centris.action;

import java.util.ArrayList;
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

import com.centris.POJO.RoleMasterPojo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.RoleMasterBD;
import com.centris.form.RoleMasterForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class RoleMasterAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(RoleMasterAction.class);

	public synchronized ActionForward Add(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in RoleMasterAction:addRole Starting");

			RoleMasterForm masterForm = (RoleMasterForm) form;

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String usercode = userDetailVO.getUserCode();

			RoleMasterBD roleMasterBD = new RoleMasterBD();

			masterForm.setRoleCode(request.getParameter("roleCode"));

			masterForm.getRoleName();
			masterForm.getRoleDescription();
			masterForm.getRoleName();

			String successMessage = roleMasterBD.addRole(masterForm, usercode);
			request.getSession(false).setAttribute("message", successMessage);

			List<RoleMasterPojo> arrayList = new ArrayList<RoleMasterPojo>();
			arrayList = roleMasterBD.getRoles();

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in RoleMasterAction:addRole Ending");

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "roleMaster";
		} else {
			forward = Director.DIRECTOR_ROLE_MASTER;
		}
		return mapping.findForward(forward);
	}

	public ActionForward deleteRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		try {
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in RoleMasterAction:editRole Starting");

			RoleMasterPojo masterPojo = new RoleMasterPojo();
			masterPojo.setRoleCode(request.getParameter("role_Code"));

			RoleMasterBD roleMasterBD = new RoleMasterBD();
			String deleteRole = roleMasterBD.deleteRole(masterPojo);
			List<RoleMasterPojo> arrayList = new ArrayList<RoleMasterPojo>();
			arrayList = roleMasterBD.getRoles();

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("message", deleteRole);
			response.getWriter().println(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RoleMasterAction:editRole Ending");

		return null;
	}

	public ActionForward updateRole(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RoleMasterAction:updateRole Starting");
		try {

			String roleCodeId = request.getParameter("role_id");

			RoleMasterBD roleMasterBD = new RoleMasterBD();
			List<RoleMasterPojo> masterPojos = new ArrayList<RoleMasterPojo>();

			masterPojos = roleMasterBD.updateRole(roleCodeId);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("UpdateList", masterPojos);

			response.getWriter().println(jsonObject);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RoleMasterAction:updateRole Ending");
		return null;
	}

	public synchronized ActionForward validateRoleName(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RoleMasterAction:validateRoleName: Starting");

		try {
			String roleName = (String) request.getParameter("roleName");

			boolean roleName_Available = new RoleMasterBD()
					.validateRoleName(roleName);

			JSONObject object = new JSONObject();
			object.put("roleName_Available", roleName_Available);

			response.getWriter().print(roleName_Available);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RoleMasterAction::validateRoleName: Ending");
		return null;
	}

	public ActionForward validateRoleNameUpdate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RoleMasterAction: validateRoleNameUpdate Starting");

		try {
			String roleName = (String) request.getParameter("roleName");
			String roleid = (String) request.getParameter("roleid");

			boolean roleName_Available = new RoleMasterBD()
					.validateRoleNameUpdate(roleName, roleid);

			JSONObject object = new JSONObject();
			object.put("roleName_Available", roleName_Available);

			response.getWriter().print(roleName_Available);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RoleMasterAction: validateRoleNameUpdate Ending");
		return null;
	}

	public synchronized ActionForward Update(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in RoleMasterAction: Update Starting");

			RoleMasterForm masterForm = (RoleMasterForm) form;

			RoleMasterBD roleMasterBD = new RoleMasterBD();

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String usercode = userDetailVO.getUserCode();

			masterForm.setRoleCode(request.getParameter("roleCode"));

			masterForm.getRoleName();
			masterForm.getRoleDescription();
			masterForm.getRoleName();

			String successMessage = roleMasterBD.updateRole(masterForm,
					usercode);
			request.getSession(false).setAttribute("message", successMessage);

			List<RoleMasterPojo> arrayList = new ArrayList<RoleMasterPojo>();
			arrayList = roleMasterBD.getRoles();

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in RoleMasterAction:addRole Ending");

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RoleMasterAction: Update Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "roleMaster";
		} else {
			forward = Director.DIRECTOR_ROLE_MASTER;
		}
		return mapping.findForward(forward);
	}
}