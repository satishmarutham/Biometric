package com.centris.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
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
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.DAO.DAOIMPL.AllowancesClaimByManagerDaoImpl;
import com.centris.POJO.AllowancesClaimByManagerPOJO;
import com.centris.POJO.ClientMasterPojo;
import com.centris.VO.AllowancesBioIdSearch;
import com.centris.VO.AllowancesClaimByManagerVO;
import com.centris.VO.ApproveTravelBookingVo;
import com.centris.VO.ProjectManagerMappingVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AllowancesClaimByManagerBD;
import com.centris.delegate.ApproveTravelBookingBD;
import com.centris.delegate.ClientMasterBD;
import com.centris.delegate.ProjectManagerMappingBD;
import com.centris.util.AllowanceClaimByManager;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class AllowancesClaimByManagerAction extends DispatchAction{

	private static Logger logger = Logger.getLogger(AllowancesClaimByManagerAction.class);
	
	public ActionForward employeeDailyAllowanceHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :employeeDailyAllowanceHome starting");
		try{
		String result=request.getParameter("status");
		if(result!=null){
		
			if(MessageConstants.TRUE.equalsIgnoreCase(result)){
			 
			        request.setAttribute("successmessage", MessageConstants.EMPLOYEE_ALLOWANCES_SUCCESS);
		  
			 }else if(MessageConstants.MAIL_NOT_SENT.equalsIgnoreCase(result)){
				 
				   request.setAttribute("errormessage", MessageConstants.EMPLOYEE_ALLOWANCES_SUCCESS_MAIL_NOT_SENT);
				 
			 }else{
		
			       request.setAttribute("errormessage", MessageConstants.EMPLOYEE_ALLOWANCES_FAILURE);
    	 
			 }
		
		}
		
		
		
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :employeeDailyAllowanceHome : Ending");
		return mapping.findForward(ApplicationConstants.ALLOWANCES_CLAIM_BY_MANAGER);
	}
	
	
	public ActionForward getAllClients(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :getAllClients starting");
		
		try{
			
	    ArrayList<ClientMasterPojo> clientDetails=new ClientMasterBD().getClientDetails();

	    JSONObject jsonobject=new JSONObject();
	    jsonobject.accumulate("clientDetails", clientDetails);
	    response.getWriter().print(jsonobject);
		
		} catch (Exception e1) {
			 e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :getAllClients : Ending");
		return null;
	}
	
	
	
	public ActionForward getSerchTermDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :getSerchTermDetails starting");
		
		try{
			
		String bioId=request.getParameter("BioId");
	    String selecteddate=request.getParameter("selecteddate");
	    
	    UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String userCode=userDetailVO.getUserCode();
	    
	    
	
		AllowancesClaimByManagerVO employeedetails=new AllowancesClaimByManagerBD().getEmployeeDetails(bioId,selecteddate,userCode);
		     
		ArrayList<AllowancesClaimByManagerVO>  employeelist=new ArrayList<AllowancesClaimByManagerVO>();
		employeelist.add(employeedetails);
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.accumulate("EmployeeList", employeelist);
		response.getWriter().print(jsonObject);
		
		} catch (Exception e1) {
			 e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :getSerchTermDetails : Ending");
		return null;
	
	}
	
	
	
	public ActionForward getBioIdBySearch(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :getBioIdBySearch starting");
		
		try{
		String searchTerm=request.getParameter("name_startsWith");
		
			
		List<AllowancesBioIdSearch> searchBioIds=new AllowancesClaimByManagerBD().getBioIdBySearch(searchTerm);
				
		JSONObject jsonObject=new JSONObject();
		jsonObject.accumulate("response", searchBioIds);
		response.getWriter().print(jsonObject);
			
		} catch (Exception e1) {
			 e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :getBioIdBySearch : Ending");
		return null;
	
	}
	public ActionForward getClient(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :getClient starting");
		
		try{
		String projectcode=request.getParameter("projectVal");
			
		String clientcode=new AllowancesClaimByManagerBD().getClient(projectcode);
				
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("clientcode", clientcode);
		response.getWriter().print(jsonObject);
		
		} catch (Exception e1) {
			 e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :getClient : Ending");
		return null;
	
	}
	public ActionForward saveAllowances(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :saveAllowances starting");
		
		try{
		Enumeration<String> paramnames =request.getParameterNames();
		while (paramnames.hasMoreElements()) {
			String string = (String) paramnames.nextElement();
			System.out.println(string);
		}
	   
		String selecteddate=request.getParameter("selectdate");
				
		String bioId =(String)request.getParameter("BioId");
		String[] Bioid_array = bioId.split(",");
		
		String EmployeeId=(String)request.getParameter("EmployeeId");
		String[] EmpId_array = EmployeeId.split(",");
		
		String noofdaysormonthallowance=(String)request.getParameter("noofdaysormonthallowance");
		String[] noofdaysormonthallowance_array = noofdaysormonthallowance.split(",");
		
		String datype=(String)request.getParameter("datype");
		String[] datype_array = datype.split(",");
		
		String singleteamgh=(String)request.getParameter("singleteamgh");
		String[] singleteamgh_array = singleteamgh.split(",");
		
		String projectmanager=(String)request.getParameter("projectmanager");
		String[] projectmanager_array = projectmanager.split(",");
		
		String clientVal=request.getParameter("clientVal");
		String[] clientVal_array = clientVal.split(",");
		
		String projectrefcode=(String)request.getParameter("projectrefcode");
		String[] projectref_array = projectrefcode.split(",");
		
		String teamlead=(String)request.getParameter("teamlead");
		String[] teamlead_array = teamlead.split(",");
		
		String location=(String)request.getParameter("location");
		String[] location_array = location.split(",");
		

		String remarksVal=(String)request.getParameter("remarksVal");
		String[] remarksVal_array = remarksVal.split("\\|");
		
		  		
		String projectcode=(String)request.getParameter("projectcode");
		String[] projectcode_array = projectcode.split(",");
		
		
		
		String amount=(String)request.getParameter("Amount");
		String amount_values[] = amount.split(",");
		

		Double[] doubleamount= new Double[amount_values.length];
		for (int i = 0; i < amount_values.length; i++) {
			doubleamount[i] = Double.parseDouble(amount_values[i]);
		}
		
		String conflict_rows=(String)request.getParameter("conflict_rows");
		String conflict_rows_array[] = conflict_rows.split(",");
		
		
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String currentuser=userDetailVO.getUserCode();
		
		ArrayList<AllowancesClaimByManagerPOJO> allowanceslist = new ArrayList<AllowancesClaimByManagerPOJO>();
		allowanceslist.clear();
		for (int i = 0; i < Bioid_array.length; i++) {
			
			AllowancesClaimByManagerPOJO allowancesClaimByManagerPOJO=new AllowancesClaimByManagerPOJO();
			
			allowancesClaimByManagerPOJO.setSelecteddate(HelperClass.convertUIToDatabase(selecteddate.trim()));
			allowancesClaimByManagerPOJO.setBioid(Bioid_array[i].trim());
			allowancesClaimByManagerPOJO.setEmpid(EmpId_array[i].trim());
			allowancesClaimByManagerPOJO.setAmount(doubleamount[i]);
			allowancesClaimByManagerPOJO.setNoofdayormonthallowance(noofdaysormonthallowance_array[i]);
			allowancesClaimByManagerPOJO.setDatype(datype_array[i].trim());
			allowancesClaimByManagerPOJO.setSingleteamgh(singleteamgh_array[i].trim());
			allowancesClaimByManagerPOJO.setProjectmanagercode(projectmanager_array[i].trim());
			allowancesClaimByManagerPOJO.setClientcode(clientVal_array[i].trim());
			allowancesClaimByManagerPOJO.setProject(projectref_array[i].trim());
			allowancesClaimByManagerPOJO.setTeamlead(teamlead_array[i].trim());
			allowancesClaimByManagerPOJO.setLocation(location_array[i].trim());
			allowancesClaimByManagerPOJO.setProjectcode(projectcode_array[i].trim());
		
				
			if("null".equalsIgnoreCase(remarksVal_array[i])){
				  allowancesClaimByManagerPOJO.setRemarks("");
			
			}else{
				
		           	  allowancesClaimByManagerPOJO.setRemarks(remarksVal_array[i].trim());
			
			}     
		
			
							
			allowancesClaimByManagerPOJO.setPostedby(currentuser);
		 
			boolean flag=new AllowanceClaimByManager().getisConflict(conflict_rows_array,Bioid_array[i]);
	 		if(flag){
				allowancesClaimByManagerPOJO.setIsconflict(MessageConstants.DAILY_ALLOWANCE_IS_CONFLICT_YES);
			}else{
				allowancesClaimByManagerPOJO.setIsconflict(MessageConstants.DAILY_ALLOWANCE_IS_CONFLICT_NO);
			}
				allowanceslist.add(allowancesClaimByManagerPOJO);
		}
		
				
		String result =new AllowancesClaimByManagerBD().saveAllowances(allowanceslist);
	
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("status", result);
		response.getWriter().print(jsonObject);
	
		
		} catch (Exception e1) {
			 e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :saveAllowances : Ending");
		
		return null;
	
	}
	
	public ActionForward getAlreadyClaimedCount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :getAlreadyClaimedCount starting");
		
		try{
		String selecteddate=request.getParameter("selecteddate");
			
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String currentuser=userDetailVO.getUserCode();
		
		int count =new AllowancesClaimByManagerBD().getAlreadyClaimedCount(selecteddate,currentuser);
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("count", count);
		response.getWriter().print(jsonObject);
		
		} catch (Exception e1) {
			 e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :getAlreadyClaimedCount : Ending");
		
		return null;
	
	}
	public ActionForward getClaimedAllowanceDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :getClaimedAllowanceDetails starting");
		
		try{
		String selecteddate=request.getParameter("selecteddate");
			
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String currentuser=userDetailVO.getUserCode();
		
		ArrayList<AllowancesClaimByManagerVO> allowanceslist =new AllowancesClaimByManagerBD().getClaimedAllowanceDetails(selecteddate,currentuser);
		
		request.setAttribute("ClaimedAllowances", allowanceslist);
		
		} catch (Exception e1) {
			 e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :getClaimedAllowanceDetails : Ending");
		
		return mapping.findForward(ApplicationConstants.CLAIMED_ALLOWANCES_VIEW);
	
	}
	
	public ActionForward getMappedProject(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction : getMappedProject Starting");

		try {
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String managerId=userDetailVO.getUserCode();
			
			ArrayList<ProjectManagerMappingVO> mappedprojectList = new ProjectManagerMappingBD()
					.getMappedProject(managerId);

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
				+ " Control in AllowancesClaimByManagerAction : getMappedProject Ending");
		return null;
	}

	public ActionForward getViewMoreAllowances(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :getViewMoreAllowances starting");
		
		try{
		String selecteddate=request.getParameter("selecteddate");
			
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String currentuser=userDetailVO.getUserCode();
		
		ArrayList<AllowancesClaimByManagerVO> allowanceslist =new AllowancesClaimByManagerBD().getClaimedAllowanceDetails(selecteddate,currentuser);
		
		request.setAttribute("ClaimedAllowances", allowanceslist);
		
		} catch (Exception e1) {
			 e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :getViewMoreAllowances : Ending");
		
		return mapping.findForward(ApplicationConstants.VIEW_MORE_ALLOWANCES);
	
	}
	
	public ActionForward moreAllowanceDeatails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :moreAllowanceDeatails starting");
		
		try{
		String startdate=request.getParameter("startdate");
		String enddate=request.getParameter("enddate");
	
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String usercode=userDetailVO.getUserCode();
		
		ArrayList<AllowancesClaimByManagerVO> allowanceslist =new AllowancesClaimByManagerBD().getmoreAllowanceDeatails(startdate,enddate,usercode);
		
		request.setAttribute("MoreAllowanceDetails", allowanceslist);
		request.setAttribute("startdate", startdate);
		request.setAttribute("enddate", enddate);
		
		
		} catch (Exception e1) {
			 e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :moreAllowanceDeatails : Ending");
		
		return mapping.findForward(ApplicationConstants.VIEW_MORE_ALLOWANCES);
	
	}
	
	
	public ActionForward downloadViewMoreAllowances(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :downloadViewMoreAllowances starting");
			
		try {
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;
			
			String startdate=request.getParameter("startdate");
			String enddate=request.getParameter("enddate");
				
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String usercode=userDetailVO.getUserCode();
			
			String	 sourceFileName = request.getRealPath("Reports/MoreAllowancesByManager.jrxml");
				
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager.compileReport(design);
			
			ArrayList<AllowancesClaimByManagerVO> allowanceslist =new AllowancesClaimByManagerBD().getmoreAllowanceDeatails(startdate,enddate,usercode);
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(allowanceslist);
			
			Map parameters = new HashMap();
			parameters.put("AllowanceDate",startdate);
			parameters.put("endDate", enddate);

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(request.getRealPath("Reports/MoreAllowancesByManager.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "EmployeeMoreAllowance" };
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
					request.getRealPath("Reports/MoreAllowancesByManager.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=MoreAllowanceDetails.xls");
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
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerAction :downloadViewMoreAllowances : Ending");
		
		return null;
	
	}
	
	
	
}
