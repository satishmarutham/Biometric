package com.centris.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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

import com.centris.VO.ProjectHeadVo;
import com.centris.VO.ProjectManagerMappingVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.ProjectManagerMappingBD;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class ProjectManagerMappingAction extends DispatchAction {

	/**
	 * @author Swathi
	 * 
	 */

	private static Logger logger = Logger
			.getLogger(ProjectManagerMappingAction.class);

	public synchronized ActionForward ProjectManagerMappingHome(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingAction:ProjectManagerMappingHome Starting");

		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingAction:ProjectManagerMappingHome Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = ApplicationConstants.PROJECT_MANAGER_MAP;
		} else {
			forward = Director.DIRECTOR_PROJECT_MAPPING;
		}
		return mapping.findForward(forward);
	}

	public ActionForward getManager(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingAction:getManager Starting");

		try {
			
			ArrayList<ProjectManagerMappingVO> managerList=null;
				
				 managerList = new ProjectManagerMappingBD().getManager();
			
			JSONObject jsonobject = new JSONObject();
			jsonobject.accumulate("managerList", managerList);
			response.getWriter().print(jsonobject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingAction:getManager Ending");
		return null;
	}

	public ActionForward getProject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingAction:getProject Starting");
		try {
			ArrayList<ProjectManagerMappingVO> projectList = new ProjectManagerMappingBD()
					.getProject();
			JSONObject jsonobject = new JSONObject();
			jsonobject.accumulate("ProjectList", projectList);
			response.getWriter().print(jsonobject);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ProjectManagerMappingAction:getProject Ending");
		return null;
	}

	public ActionForward saveProjectManagerMapping(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingAction:saveProjectManagerMapping Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String username = userDetailVO.getUserCode();

			String managerId = request.getParameter("managerId");
			String projectID = request.getParameter("projectDetails");
			JSONArray jsonproject = null;
			if (projectID != null) {
				jsonproject = new JSONArray(projectID);
			}

			String result = new ProjectManagerMappingBD()
					.saveProjectManagerMapping(managerId, jsonproject, username);
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
				+ " Control in ProjectManagerMappingAction:saveProjectManagerMapping Ending");

		return null;
	}

	public ActionForward getMappedProject(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingAction:getMappedProject Starting");

		try {
			String managerId = request.getParameter("ManagerVal");
			
			String usertype=HelperClass.getCurrentUserIDType(request);
			ArrayList<ProjectManagerMappingVO> mappedprojectList=null;
			
			if(usertype.equalsIgnoreCase(LoginDetails.EMPLOYEE_ID_TYPE)){
			HashMap<String, String> previlagesMap=(HashMap<String, String>)request.getSession(false).getAttribute("privileges");
			
		
			ProjectManagerMappingBD pjtBd=new ProjectManagerMappingBD();
			
			if(previlagesMap.get(MessageConstants.MANAGER).equalsIgnoreCase("Y")){
				
				String managerID=pjtBd.getManagerIdByEmp(HelperClass.getCurrentUserID(request));
				
				mappedprojectList = pjtBd.getMappedProject(managerID);
				
			}else{
			
				mappedprojectList = new ProjectManagerMappingBD()
					.getMappedProject(managerId);
			}
			}else{
				
				mappedprojectList = new ProjectManagerMappingBD()
				.getMappedProject(managerId);
			}
			
			
			
			
			
			JSONObject jsonobject = new JSONObject();
			jsonobject.accumulate("mappedprojectlist", mappedprojectList);
			response.getWriter().print(jsonobject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingAction:getMappedProject Ending");
		return null;
	}

	public ActionForward getProjectHead(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingAction : getProjectHead Starting");
		try {
			ArrayList<ProjectHeadVo> projectHeadList = new ProjectManagerMappingBD()
					.getProjectHead();
			JSONObject jsonobject = new JSONObject();
			jsonobject.accumulate("ProjectHeadList", projectHeadList);
			response.getWriter().print(jsonobject);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ProjectManagerMappingAction : getProjectHead Ending");
		return null;
	}
	
	
	
	public ActionForward getManagerByPrevillages(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingAction:getManager Starting");

		try {
			
			HashMap<String,String> privilegesMap=(HashMap<String, String>)request.getSession(false).getAttribute("privileges");
			
			ArrayList<ProjectManagerMappingVO> managerList=null;
			
			if(privilegesMap.get(MessageConstants.MANAGER).equalsIgnoreCase("Y")){
				
				managerList = new ProjectManagerMappingBD().getDirector();
				
			}else{
				
				 managerList = new ProjectManagerMappingBD().getManager();
				
			}
			
			JSONObject jsonobject = new JSONObject();
			jsonobject.accumulate("managerList", managerList);
			response.getWriter().print(jsonobject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingAction:getManager Ending");
		return null;
	}

	public ActionForward getAllProjects(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectManagerMappingAction: getAllProjects Starting");
		try {
			ArrayList<ProjectManagerMappingVO> projectList = new ProjectManagerMappingBD()
					.getAllProjects();
			JSONObject jsonobject = new JSONObject();
			jsonobject.accumulate("ProjectList", projectList);
			response.getWriter().print(jsonobject);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  ProjectManagerMappingAction: getAllProjects Ending");
		return null;
	}

}

