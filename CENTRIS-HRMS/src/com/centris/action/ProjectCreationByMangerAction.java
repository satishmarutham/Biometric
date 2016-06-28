package com.centris.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;

import com.centris.VO.ProjectApprovedByVO;
import com.centris.VO.ProjectFilterVo;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.ProjectRefCodeGeneration;
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
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class ProjectCreationByMangerAction extends DispatchAction{
	
	
	private static Logger logger = Logger.getLogger(ProjectCreationByMangerAction.class);
	private static String ProductRefCodePath = JPropertyReader.getProperty("ProductRefCodeDocPath");
	
	//Adding project
	public ActionForward Add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectCreationByMangerAction : Add Starting");
		
		String usertype = HelperClass.getCurrentUserIDType(request);
		
		try {
			
			ProjectMasterForm pform=(ProjectMasterForm)form;
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String userid=userDetailVO.getUserCode();
			String userName=userDetailVO.getUserFirstName();
			
			  String status =new ProjectMasterDelegate().addProject(pform, userid,userName);
			  
			if(status!=null){
			
			  if(MessageConstants.MAIL_NOT_SENT.equalsIgnoreCase(status)){
				  
				  request.setAttribute("errorMessage", MessageConstants.PROJECT_ADD_SUCCESS_MAIL_NOT_SENT);
			  }else if(MessageConstants.FALSE.equalsIgnoreCase(status)) {
				 
				  request.setAttribute("errorMessage",   MessageConstants.PROJECT_ADD_FAILED);
			  }else{
			
				  request.setAttribute("message", MessageConstants.PROJECT_ADD_SUCCESS);
			  }
			
			  
			}
			
			  
			  ArrayList<ProjectMasterVo> pjt_list=new ProjectMasterDelegate().getAllProjects(userid);
				
				request.setAttribute("PROJECTLIST", pjt_list);


		} catch (Exception exception) {
			logger.error(exception.getMessage(),exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectCreationByMangerAction : Add Ending");
		
	
		
		if (usertype.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)) {
			
			return mapping.findForward(ApplicationConstants.PROJECT_CREATION_BY_MANAGER);
			
		} else if((usertype.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE))) {
			
			return mapping.findForward(Director.DIRECTOR_PROJECT);
		}else{
			
			return mapping.findForward("projectmaster");
		}
		
		

	}
	
	//get project details for edit project
	public ActionForward editProjectDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectCreationByMangerAction : editProjectDetails Starting");
		try {
			
			
			String projectId=request.getParameter("project_id");
			
			
			  ArrayList<ProjectMasterVo> projectlist =new ProjectMasterDelegate().editProjectDetails(projectId);
			  
			  JSONObject object=new JSONObject();
			  object.put("projectlist", projectlist);
			  
			  response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(),exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectCreationByMangerAction : editProjectDetails Ending");
		
		return null;

	}
	
	//update project details
	public ActionForward Update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		String usertype = HelperClass.getCurrentUserIDType(request);
		
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectCreationByMangerAction : Update Starting");
		try {
			
			
			ProjectMasterForm pform=(ProjectMasterForm)form;
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String userid=userDetailVO.getUserCode();
			
			  String status =new ProjectMasterDelegate().UpdateProject(pform, userid);
			  
			  ArrayList<ProjectMasterVo> pjt_list=new ProjectMasterDelegate().getAllProjects(userid);
				
				request.setAttribute("PROJECTLIST", pjt_list);
				  
				if(status!=null){
				
			      if(MessageConstants.PROJECT_UPDATE_FAILED .equalsIgnoreCase(status)) {
					 
					  request.setAttribute("errorMessage", MessageConstants.PROJECT_UPDATE_FAILED);
				  }else if(MessageConstants.PROJECT_UPDATE_SUCCESS_MAIL_NOT_SENT .equalsIgnoreCase(status)){
					  
					  request.setAttribute("errorMessage",MessageConstants.PROJECT_UPDATE_SUCCESS_MAIL_NOT_SENT);
				  }else{
				
					  request.setAttribute("message",MessageConstants.PROJECT_UPDATE_SUCCESS);
				  }
				
				  
				}
				

		} catch (Exception exception) {
			logger.error(exception.getMessage(),exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction : Update Ending");
		
//		return mapping.findForward(ApplicationConstants.PROJECT_CREATION_BY_MANAGER);
		
     if (usertype.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)) {
			
			return mapping.findForward(ApplicationConstants.PROJECT_CREATION_BY_MANAGER);
			
		} else if((usertype.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE))) {
			
			return mapping.findForward(Director.DIRECTOR_PROJECT);
		}else{
			
			return mapping.findForward("projectmaster");
		}

	}
	
	//delete project
	public ActionForward deleteProject(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction : deleteProject Starting");
		try {
			
			
			
			String[] projectId=request.getParameterValues("project_id[]");
			
			 String status =new ProjectMasterDelegate().deleteProject(projectId);
			 
			  
			  JSONObject object=new JSONObject();
			  object.put("status", status);
			  
			  response.getWriter().print(object);


		} catch (Exception exception) {
			
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction : deleteProject Ending");
		
		return null;

	}
	
	// checking exist project  for avoid duplicate while adding time
	public ActionForward checkProjectCount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction : checkProjectCount Starting");
		try {
			
			
			String projectname=request.getParameter("project_name");
			
			
			 boolean status =new ProjectMasterDelegate().checkProjectCount(projectname);
			 
			  
			  JSONObject object=new JSONObject();
			  object.put("status", status);
			  
			  response.getWriter().print(object);


		} catch (Exception exception) {
			
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction : checkProjectCount Ending");
		
		return null;

	}
	
	//checking exist project  for avoid duplicate while update time
	
	public ActionForward checkProjectCountUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction : checkProjectCountUpdate Starting");
		try {
			
			
			String projectname=request.getParameter("project_name");
			String projectid=request.getParameter("project_id");
			
			 boolean status =new ProjectMasterDelegate().checkProjectCountUpdate(projectname,projectid);
			 
			  
			  JSONObject object=new JSONObject();
			  object.put("status", status);
			  
			  response.getWriter().print(object);


		} catch (Exception exception) {
			
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction : checkProjectCountUpdate Ending");
		
		return null;

	}

	
	//checking exist projectRefCode duplicate 
	
		public ActionForward checkProjectCode(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws AITrackerException, Exception {
			
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction : checkProjectCode Starting");
			try {
				
				
				String ProjectRefCode=request.getParameter("projectcode");
				String projectid=request.getParameter("project_id");
				
				 boolean status =new ProjectMasterDelegate().checkProjectCode(ProjectRefCode,projectid);
				 
				  
				  JSONObject object=new JSONObject();
				  object.put("status", status);
				  
				  response.getWriter().print(object);


			} catch (Exception exception) {
				
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
			JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction : checkProjectCode Ending");
			
			return null;

		}

	
	
	
	public synchronized ActionForward downloadDocument(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction: downloadDocument Starting");
		
		try{
	
			String docPath=ProductRefCodePath;	
			int index=docPath.lastIndexOf("/")+1;
			
			String fileName=docPath.substring(index,docPath.length());
			
			response.addHeader("Content-Disposition","attachment; filename="+fileName);
			File docFile=new File(/*request.getRealPath("/")+*/docPath);
			response.setContentLength((int) docFile.length());
		
			FileInputStream input = new FileInputStream(docFile);
			BufferedInputStream buf = new BufferedInputStream(input);
			int readBytes = 0;
			ServletOutputStream stream= response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}	
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterAction: downloadDocument Ending");
	
	return null;
	}
	
	
	

	public ActionForward reGenereteProjectCode(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectCreationByMangerAction : Update Starting");
		
		String usertype = HelperClass.getCurrentUserIDType(request);
		try {
			
			
			System.out.println(" Calling AJAX");
			ProjectRefCodeGeneration refCode = new ProjectRefCodeGeneration();
			
			refCode.setProjectId((String)request.getParameter("project_id").trim());
			refCode.setNewRefCode((String)request.getParameter("newrefcode").trim());
			refCode.setOldRefCode((String)request.getParameter("oldrefcode").trim());
			
			 UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
				String userid =userDetailVO.getUserCode();
				
		  	refCode.setUserID(userid);
			
			
			System.out.println("-----------------------");
			System.out.println(""+refCode.getNewRefCode());
			System.out.println(""+refCode.getOldRefCode());
			System.out.println(""+refCode.getProjectId());
			System.out.println(""+refCode.getUserID());
			
		   
		    ArrayList<String> status =new ProjectMasterDelegate().genereateNewRefCodeBD(refCode);
		    status.add(usertype);
		
			System.out.println("----------RE GENERATE-------------");
			System.out.println("-----------------------");
			
			
			  JSONObject object=new JSONObject();
			  object.put("status", status);
			  
			   response.getWriter().print(object);
			
			   request.setAttribute("message", status.get(1));
			   System.out.println(status.get(1));
//			  
//			  
//			  ArrayList<ProjectMasterVo> pjt_list=new ProjectMasterDelegate().getAllProjects();
//				
//			  System.out.println(pjt_list.size());
//		      request.setAttribute("PROJECTLIST", pjt_list);


		} catch (Exception exception) {
			logger.error(exception.getMessage(),exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectCreationByMangerAction : Update Ending");
		
		return null;
	}

	
	public ActionForward getProjectSearchDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectCreationByMangerAction : getProjectSearchDetails Starting");
	
		String usertype = HelperClass.getCurrentUserIDType(request);
		try {
			
			
			String projectId=request.getParameter("projectId");
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String userid=userDetailVO.getUserCode();
			
		   ArrayList<ProjectMasterVo> pjt_list=new ProjectMasterDelegate().getProjectSearchDetails(projectId,userid);
		   request.setAttribute("PROJECTLIST", pjt_list);

	
		
		} catch (Exception exception) {
			
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectCreationByMangerAction : getProjectSearchDetails Ending");
		
	
		
		if (usertype.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)) {
			
			return mapping.findForward(ApplicationConstants.PROJECT_CREATION_BY_MANAGER);
			
		} else if((usertype.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE))) {
			
			return mapping.findForward(Director.DIRECTOR_PROJECT);
		}else{
			
			return mapping.findForward("projectmaster");
		}
		
	}		
	
	
	public ActionForward downloadAllProjects(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectCreationByMangerAction : downloadAllProjects Starting");
	
		try {
			
			String usertype = HelperClass.getCurrentUserIDType(request);
				
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String userCode=userDetailVO.getUserCode();
			
		   ArrayList<ProjectMasterVo> pjt_list=new ProjectMasterDelegate().getdownloadAllProjectsDetails(usertype,userCode);
		
		    File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;
		   
			String	 sourceFileName = request.getRealPath("Reports/ProjectDetailsXLSReport.jrxml");
			
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager.compileReport(design);
			
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(pjt_list);
			
			Map parameters = new HashMap();
		
			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/ProjectDetailsXLSReport.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "ProjectDetails" };
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
			exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
					Boolean.FALSE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
					Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.SHEET_NAMES,
					sheetNames);
			exporter.setParameter(
					JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
					Boolean.TRUE);
			exporter.setParameter(
					JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND,
					Boolean.FALSE);
			exporter.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS,
					Boolean.TRUE);
			exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,
					Boolean.FALSE);

			exporter.exportReport();

			pdfxls = new File(
					request.getRealPath("Reports/ProjectDetailsXLSReport.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=ProjectDetailsExcelReport.xls");
			response.setContentLength((int) pdfxls.length());
			input = new FileInputStream(pdfxls);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}
			
			
		} catch (Exception exception) {
			
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectCreationByMangerAction : downloadAllProjects Ending");
		
	
	  return null;
	}		
	
	
}
