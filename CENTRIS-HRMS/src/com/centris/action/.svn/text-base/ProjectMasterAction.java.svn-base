package com.centris.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;

import com.centris.VO.ProjectApprovedByVO;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.ProjectMasterDelegate;
import com.centris.exception.AITrackerException;
import com.centris.form.ProjectMasterForm;
import com.centris.util.HelperClass;
import com.centris.util.JPropertyReader;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class ProjectMasterAction extends DispatchAction {

	private static Logger logger = Logger.getLogger(ProjectMasterAction.class);
	private static String ProductRefCodePath = JPropertyReader
			.getProperty("ProductRefCodeDocPath");

	/*// Adding project
	public ActionForward Add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : Add Starting");
		String forward = null;
		String usertype = HelperClass.getCurrentUserIDType(request);
		try {

			ProjectMasterForm pform = (ProjectMasterForm) form;

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String userid = userDetailVO.getUserCode();

			String status = new ProjectMasterDelegate().addProject(pform,
					userid);

			request.setAttribute("message", status);

			ArrayList<ProjectMasterVo> pjt_list = new ProjectMasterDelegate()
					.getAllProjects(userid);

			request.setAttribute("PROJECTLIST", pjt_list);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : Add Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "projectmaster";
		} else {
			forward = Director.DIRECTOR_PROJECT;
		}
		return mapping.findForward(forward);

	}*/

	// get project details for edit project
	public ActionForward editProjectDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : editProjectDetails Starting");

		try {

			String projectId = request.getParameter("project_id");

			ArrayList<ProjectMasterVo> projectlist = new ProjectMasterDelegate()
					.editProjectDetails(projectId);

			JSONObject object = new JSONObject();
			object.put("projectlist", projectlist);

			response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : editProjectDetails Ending");

		return null;

	}

	// update project details
	public ActionForward Update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : Update Starting");
		String forward = null;
		String usertype = HelperClass.getCurrentUserIDType(request);
		try {

			ProjectMasterForm pform = (ProjectMasterForm) form;

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String userid = userDetailVO.getUserCode();

			String status = new ProjectMasterDelegate().UpdateProject(pform,
					userid);

			request.setAttribute("message", status);

			ArrayList<ProjectMasterVo> pjt_list = new ProjectMasterDelegate()
					.getAllProjects(userid);

			request.setAttribute("PROJECTLIST", pjt_list);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : Update Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "projectmaster";
		} else {
			forward = Director.DIRECTOR_PROJECT;
		}
		return mapping.findForward(forward);

	}

	// delete project
	public ActionForward deleteProject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : deleteProject Starting");
		try {

			String[] projectId = request.getParameterValues("project_id[]");

			String status = new ProjectMasterDelegate()
					.deleteProject(projectId);

			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);

		} catch (Exception exception) {

			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : deleteProject Ending");

		return null;

	}

	// checking exist project for avoid duplicate while adding time
	public ActionForward checkProjectCount(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : checkProjectCount Starting");
		try {

			String projectname = request.getParameter("project_name");

			boolean status = new ProjectMasterDelegate()
					.checkProjectCount(projectname);

			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);

		} catch (Exception exception) {

			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : checkProjectCount Ending");

		return null;

	}

	// checking exist project for avoid duplicate while update time

	public ActionForward checkProjectCountUpdate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : checkProjectCountUpdate Starting");
		try {

			String projectname = request.getParameter("project_name");
			String projectid = request.getParameter("project_id");

			boolean status = new ProjectMasterDelegate()
					.checkProjectCountUpdate(projectname, projectid);

			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);

		} catch (Exception exception) {

			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : checkProjectCountUpdate Ending");

		return null;

	}

	// checking exist projectRefCode duplicate

	public ActionForward checkProjectCode(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : checkProjectCode Starting");
		try {

			String ProjectRefCode = request.getParameter("projectcode");
			String projectid = request.getParameter("project_id");

			boolean status = new ProjectMasterDelegate().checkProjectCode(
					ProjectRefCode, projectid);

			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);

		} catch (Exception exception) {

			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction : checkProjectCode Ending");

		return null;

	}

	public synchronized ActionForward downloadDocument(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction: downloadDocument Starting");

		try {

			String docPath = ProductRefCodePath;
			int index = docPath.lastIndexOf("/") + 1;

			String fileName = docPath.substring(index, docPath.length());

			response.addHeader("Content-Disposition", "attachment; filename="
					+ fileName);
			File docFile = new File(/* request.getRealPath("/")+ */docPath);
			response.setContentLength((int) docFile.length());

			FileInputStream input = new FileInputStream(docFile);
			BufferedInputStream buf = new BufferedInputStream(input);
			int readBytes = 0;
			ServletOutputStream stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterAction: downloadDocument Ending");

		return null;
	}
	
	public ActionForward getApproveUsers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction : getApproveUsers Starting");
		try {
			
			
			 ArrayList<ProjectApprovedByVO> approveusers =new ProjectMasterDelegate().getApproveUsers();
						  
			  JSONObject object=new JSONObject();
			  object.put("approveusersList", approveusers);
			  response.getWriter().print(object);


		} catch (Exception exception) {
			
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction : getApproveUsers Ending");
		
		return null;

	}
	
	public ActionForward approvedProject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction : approvedProject Starting");
		try {
			
			String projectcode=request.getParameter("projectCode");
			String approvedby=request.getParameter("approvedBy");
			
			String status =new ProjectMasterDelegate().approvedProject(projectcode,approvedby);
						  
			  JSONObject object=new JSONObject();
			  object.put("status", status);
			  response.getWriter().print(object);


		} catch (Exception exception) {
			
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction : approvedProject Ending");
		
		return null;

	}
	
	public ActionForward rejectedProject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction : rejectedProject Starting");
		try {
			
			String projectcode=request.getParameter("projectCode");
			String rejectedby=request.getParameter("rejectedby");
			
			String status =new ProjectMasterDelegate().rejectedProject(projectcode,rejectedby);
						  
			  JSONObject object=new JSONObject();
			  object.put("status", status);
			  response.getWriter().print(object);


		} catch (Exception exception) {
			
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction : rejectedProject Ending");
		
		return null;

	}
	
}
