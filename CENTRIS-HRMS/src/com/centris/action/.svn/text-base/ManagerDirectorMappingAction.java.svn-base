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

import com.centris.VO.ManagerDirectorMappingVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.ManagerDirectorMappingBD;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class ManagerDirectorMappingAction extends DispatchAction {

	private static Logger logger = Logger
			.getLogger(ManagerDirectorMappingAction.class);

	public ActionForward mangerDirectorMappingHome(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingAction : mangerDirectorMappingHome Starting");

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingAction : mangerDirectorMappingHome Ending");

		return mapping.findForward("managerDirectorMapping");
	}

	public ActionForward getDirector(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in mangerDirectorMappingHome : getDirector Starting");

		try {

			ArrayList<ManagerDirectorMappingVo> directorlist = new ManagerDirectorMappingBD()
					.getDirector();

			JSONObject jsonobject = new JSONObject();
			jsonobject.accumulate("directorlist", directorlist);
			response.getWriter().print(jsonobject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingAction : getDirector Ending");

		return null;
	}

	public ActionForward getAvailableManagers(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingAction : getAvailableManagers Starting");

		try {

			ArrayList<ManagerDirectorMappingVo> managerlist = new ManagerDirectorMappingBD()
					.getAvailableManagers();

			JSONObject jsonobject = new JSONObject();
			jsonobject.accumulate("managerlist", managerlist);
			response.getWriter().print(jsonobject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingAction : getAvailableManagers Ending");

		return null;
	}

	public ActionForward savemanagerDirectorMapping(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingAction: savemanagerDirectorMapping Starting");
		try {
			
			
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String username = userDetailVO.getUserCode();

			String managerId = request.getParameter("directorId");
			String projectID = request.getParameter("employeeDetails");
			JSONArray jsonproject = null;
			if (projectID != null) {
				jsonproject = new JSONArray(projectID);
			}

			String result = new ManagerDirectorMappingBD()
					.savemanagerDirectorMapping(managerId, jsonproject,
							username);

		
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
				+ " Control in ManagerDirectorMappingAction   : savemanagerDirectorMapping Ending");

		return null;
	}
	
	
	public ActionForward getMappedManagers(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingAction: getMappedManagers Starting");
		try {

			String directorId = request.getParameter("DirectorVal");
			

			ArrayList<ManagerDirectorMappingVo> mappedmanagers= new ManagerDirectorMappingBD()
					.getMappedManagers(directorId);

			JSONObject jsonobject = new JSONObject();
			jsonobject.put("mappedmanagers", mappedmanagers);
			response.getWriter().print(jsonobject);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerDirectorMappingAction   : getMappedManagers Ending");

		return null;
	}


}
