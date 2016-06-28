package com.centris.action;

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

import com.centris.VO.PermissionVO;
import com.centris.VO.UserDetailVO;
import com.centris.VO.UserRolePermissionVO;
import com.centris.delegate.UserRolePermissionBD;
import com.centris.form.UserRolePermissionForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class UserRolePermissionAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(UserRolePermissionAction.class);
	
	public  ActionForward insertRolePermission(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserRolePermissionAction: insertRolePermission Starting");
		
		try {
			UserRolePermissionForm userRolePermissionform = (UserRolePermissionForm) form;
			String roleCode = userRolePermissionform.getRoleCode();
			String roleName = "";
			if (roleCode != null && roleCode.equals("All")) {
				roleCode = "All";
				roleName = "All";
			} else {
				String[] role = roleCode.split(",");
				roleCode = role[0];
				roleName = role[1];
			}
			userRolePermissionform.setRoleCode(roleCode);
			userRolePermissionform.setRoleName(roleName);
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String usercode=userDetailVO.getUserCode();
			userRolePermissionform.setCreatedBy(usercode);
			UserRolePermissionVO userRolePermissionVO = new UserRolePermissionBD()
					.insertRolePermission(userRolePermissionform);
			request.getSession(false).setAttribute("message",
					userRolePermissionVO.getServerMessage());
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserRolePermissionAction: insertRolePermission Ending");
		return null;
	}

	public synchronized ActionForward getPermissionByRole(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserRolePermissionAction: getPermissionByRole Starting");
		
		try {
			String roleCode = request.getParameter("roleCode");
			String roleName = "";
			if (roleCode != null && roleCode.equals("All")) {
				roleCode = "%%";
				roleName = "All";
			} else {
				String[] role = roleCode.split(",");
				roleCode = role[0];
				roleName = role[1];
			}
			List<PermissionVO> permissionVOList = new UserRolePermissionBD()
					.getPermissionByRole(roleCode);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("permission", permissionVOList);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserRolePermissionAction: getPermissionByRole Ending");
		return null;
	}

	public  ActionForward removePermission(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserRolePermissionAction: removePermission Starting");
		
		try {
			String roleCode = request.getParameter("roleCode");
			String roleName = "";
			if (roleCode != null && roleCode.equals("All")) {
				roleCode = "%%";
				roleName = "All";
			} else {
				String[] role = roleCode.split(",");
				roleCode = role[0];
				roleName = role[1];
			}
			PermissionVO permissionVO = new UserRolePermissionBD()
					.removePermission(roleCode, roleName);
			request.getSession(false).setAttribute("message",
					permissionVO.getServerMessage());
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserRolePermissionAction: removePermission Ending");
		return null;
	}
}
