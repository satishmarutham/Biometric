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

import com.centris.VO.EmployeeManagerMappingVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.EmployeeManagerMappingBD;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class EmployeeManagerMappingAction extends DispatchAction {

	private static Logger logger = Logger
			.getLogger(EmployeeManagerMappingAction.class);

	public ActionForward employeeMangerMappingHome(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeManagerMappingAction : employeeMangerMappingHome Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeManagerMappingAction : employeeMangerMappingHome Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.EMPLOYEE_DEPARTMENT_MAPPING;
		} else {
			forward = Director.DIRECTOR_EMP_MNG_MAPPING;
		}

		return mapping.findForward(forward);
	}

	public ActionForward getAvailableEmployees(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeManagerMappingAction: getAvailableEmployees Starting");
		try {

			ArrayList<EmployeeManagerMappingVO> employeeList = new EmployeeManagerMappingBD()
					.getAvailableEmployees();

			JSONObject jsonobject = new JSONObject();
			jsonobject.accumulate("EmployeeList", employeeList);
			response.getWriter().print(jsonobject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  EmployeeManagerMappingAction: getAvailableEmployees Ending");
		return null;
	}

	public ActionForward saveemployeeMangerMapping(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeManagerMappingAction: saveemployeeMangerMapping Starting");
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String username = userDetailVO.getUserCode();

			String managerId = request.getParameter("managerId");
			String projectID = request.getParameter("employeeDetails");
			JSONArray jsonproject = null;
			if (projectID != null) {
				jsonproject = new JSONArray(projectID);
			}

			String result = new EmployeeManagerMappingBD()
					.saveemployeeMangerMapping(managerId, jsonproject, username);

			JSONObject jsonobject = new JSONObject();
			jsonobject.put("result", result);
			response.getWriter().print(jsonobject);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeManagerMappingAction   : saveemployeeMangerMapping Ending");

		return null;
	}

	public ActionForward getMappedEmployees(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeManagerMappingAction : getMappedEmployees Starting");

		try {
			String managerId = request.getParameter("ManagerVal");
			ArrayList<EmployeeManagerMappingVO> mappedemployeelist = new EmployeeManagerMappingBD()
					.getMappedEmployees(managerId);

			JSONObject jsonobject = new JSONObject();
			jsonobject.accumulate("Mappedemployeelist", mappedemployeelist);
			response.getWriter().print(jsonobject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeManagerMappingAction : getMappedEmployees Ending");
		return null;
	}
}