package com.centris.action;

import java.util.ArrayList;
import java.util.Date;

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

import com.centris.VO.AddDesignationVO;
import com.centris.VO.DepartmentMappingVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.DepartmentMappingBD;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class DepartmentMappingAction extends DispatchAction {

	private static Logger logger = Logger
			.getLogger(DepartmentMappingAction.class);

	public ActionForward departmentMappingHome(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = ApplicationConstants.DEPARTMENT_MAPPING;
		} else {
			forward = Director.DIRECTOR_DEPARTMENT_MAPPING;
		}
		return mapping.findForward(forward);
	}

	public ActionForward getAllDesignations(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingAction: getAllDesignations: Starting");

		try {

			ArrayList<AddDesignationVO> alldesignationlist = new DepartmentMappingBD()
					.getDesignationDetails();

			JSONObject jsonobject = new JSONObject();
			jsonobject.accumulate("AllDesignationList", alldesignationlist);
			response.getWriter().print(jsonobject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingAction: getAllDesignations: Ending");

		return null;
	}

	public ActionForward getAllUsersUnderDesignation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingAction: getAllUsersUnderDesignation: Starting");
		try {

			String designation = request.getParameter("designation");
			ArrayList<DepartmentMappingVo> alluserslist = new DepartmentMappingBD()
					.getAllUsersUnderDesignation(designation);

			JSONObject jsonobject = new JSONObject();
			jsonobject.accumulate("UsersList", alluserslist);
			response.getWriter().print(jsonobject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingAction: getAllUsersUnderDesignation: Ending");

		return null;
	}

	public ActionForward getAvailableDepartments(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingAction: getAvailableDepartments: Starting");

		try {

			String usercode = request.getParameter("userCode");
			ArrayList<DepartmentMappingVo> availabedepartments = new DepartmentMappingBD()
					.getAvailableDepartments(usercode);

			JSONObject jsonobject = new JSONObject();
			jsonobject.accumulate("AvailableDepartments", availabedepartments);
			response.getWriter().print(jsonobject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingAction: getAvailableDepartments: Ending");

		return null;
	}

	public ActionForward getMappedDepartments(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingAction: getMappedDepartments: Starting");

		try {

			String usercode = request.getParameter("userCode");
			ArrayList<DepartmentMappingVo> mappeddepartments = new DepartmentMappingBD()
					.getMappedDepartments(usercode);

			JSONObject jsonobject = new JSONObject();
			jsonobject.accumulate("MappedDepartments", mappeddepartments);
			response.getWriter().print(jsonobject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingAction: getMappedDepartments: Ending");

		return null;
	}

	public ActionForward saveDepartmentMapping(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingAction: saveDepartmentMapping: Starting");
		try {
			String userId = request.getParameter("userId");
			String deptDetails = request.getParameter("deptDetails");
			JSONArray jsonArray = null;
			if (deptDetails != null) {
				jsonArray = new JSONArray(deptDetails);
			}
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentuser = userDetailVO.getUserCode();

			String status = new DepartmentMappingBD().saveDepartmentMapping(
					userId, jsonArray, currentuser);

			JSONObject jsonobject = new JSONObject();
			jsonobject.put("status", status);
			response.getWriter().print(jsonobject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DepartmentMappingAction: saveDepartmentMapping: Ending");

		return null;
	}

}
