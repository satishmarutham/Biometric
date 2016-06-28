package com.centris.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import net.sf.jasperreports.engine.JasperRunManager;
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

import com.centris.DAO.DBService;
import com.centris.POJO.EmpAllowAprroveByDirectorPojo;
import com.centris.VO.DailyEmployeeAllowanceVO;
import com.centris.VO.EmpAllowAprroveByDirectorVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.EmpAllowAprroveByDirectorBD;
import com.centris.delegate.EmployeeDailyAllowanceBD;
import com.centris.exception.AITrackerException;
import com.centris.form.EmpAllowAprroveByDirectorForm;
import com.centris.form.EmployeeDailyAllowanceForm;
import com.centris.util.HelperClass;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class EmpAllowAprroveByDirectorAction extends DispatchAction {

	private static Logger logger = Logger
			.getLogger(EmpAllowAprroveByDirectorAction.class);

	public synchronized ActionForward getAllowancesNotApproved(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorAction: getAllowancesNotApproved Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {

			EmpAllowAprroveByDirectorForm aform = (EmpAllowAprroveByDirectorForm) form;
			
			String usercode=HelperClass.getCurrentUserID(request);

			String startdate = HelperClass.convertUIToDatabase(aform
					.getTodate());
			String endDate = HelperClass.convertUIToDatabase(aform
					.getFromdate());

			LinkedHashMap<String, ArrayList<EmpAllowAprroveByDirectorVo>> allowanceList = new EmpAllowAprroveByDirectorBD()
					.getAllowancesNotApproved(startdate, endDate,usertype,usercode);

			request.setAttribute("allowanceList", allowanceList);
			request.setAttribute("conflictEmployees",
					new EmpAllowAprroveByDirectorBD().getConflictEmployees(
							startdate, endDate,usertype,usercode));
			request.setAttribute("todate", aform.getTodate().trim());
			request.setAttribute("fromdate", aform.getFromdate().trim());

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorAction: getAllowancesNotApproved Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = StringUtils.GET_DAILY_ALLOWANCES;
		} else {
			forward = Director.DIRECTOR_GET_DAILY_ALLOWANCES;
		}
		return mapping.findForward(forward);
	}

	public synchronized ActionForward getsingleAllowances(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorAction: getsingleAllowances Starting");

		try {

			String allowancecode = request.getParameter("allowanceCode");

			ArrayList<EmpAllowAprroveByDirectorVo> allowanceList = new EmpAllowAprroveByDirectorBD()
					.getsingleAllowances(allowancecode);

			JSONObject object = new JSONObject();
			object.put("allowanceList", allowanceList);

			response.getWriter().print(object);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorAction: getsingleAllowances Ending");
		return null;
	}

	public synchronized ActionForward approveSingleAllowance(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorAction: approveSingleAllowance Starting");

		try {
			
			String usertype = HelperClass.getCurrentUserIDType(request);

			String allowancecode = request.getParameter("allowandcode");
			String approvedAmount = request.getParameter("approvedAmount");
			String comments = request.getParameter("comments");

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentUser = userDetailVO.getUserCode();

			EmpAllowAprroveByDirectorPojo allowancePojo = new EmpAllowAprroveByDirectorPojo();

			allowancePojo.setAllowanceCode(allowancecode);
			allowancePojo.setApprovedamount(approvedAmount);
			allowancePojo.setRemarks(comments);
			allowancePojo.setApprovedby(currentUser);
			allowancePojo.setApprovedbyName(userDetailVO.getUserFirstName());
			allowancePojo.setUserType(usertype);
			allowancePojo.setUserId(userDetailVO.getUserCode());
			
			
			
			

			String status = new EmpAllowAprroveByDirectorBD()
					.approveSingleAllowance(allowancePojo);

			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorAction: approveSingleAllowance Ending");

		return null;
	}
	
	
	public synchronized ActionForward rejectSingleAllowance(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorAction: rejectSingleAllowance Starting");

		try {
			
			String usertype = HelperClass.getCurrentUserIDType(request);

			String allowancecode = request.getParameter("allowandcode");
			String approvedAmount = request.getParameter("approvedAmount");
			String comments = request.getParameter("comments");

			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String currentUser = userDetailVO.getUserCode();

			EmpAllowAprroveByDirectorPojo allowancePojo = new EmpAllowAprroveByDirectorPojo();

			allowancePojo.setAllowanceCode(allowancecode);
			allowancePojo.setApprovedamount(approvedAmount);
			allowancePojo.setRemarks(comments);
			allowancePojo.setApprovedby(currentUser);
			allowancePojo.setApprovedbyName(userDetailVO.getUserFirstName());
			allowancePojo.setUserType(usertype);
			allowancePojo.setUserId(userDetailVO.getUserCode());
			
					

			String status = new EmpAllowAprroveByDirectorBD().rejectSingleAllowance(allowancePojo);

			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorAction: rejectSingleAllowance Ending");

		return null;
	}
	
	public synchronized ActionForward approveAllAllowanses(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorAction: approveAllAllowanses Starting");

		try {
			
			String usertype = HelperClass.getCurrentUserIDType(request);

			String allowancecode = request.getParameter("allowandcode");
			String approvedAmount = request.getParameter("approvedAmount");
			String comments = request.getParameter("comments");
			
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentUser = userDetailVO.getUserCode();

			EmpAllowAprroveByDirectorPojo allowancePojo = new EmpAllowAprroveByDirectorPojo();

			allowancePojo.setAllowanceCode(allowancecode);
			allowancePojo.setApprovedamount(approvedAmount);
			allowancePojo.setRemarks(comments);
			allowancePojo.setApprovedby(currentUser);
			allowancePojo.setApprovedbyName(userDetailVO.getUserFirstName());
			allowancePojo.setUserType(usertype);
			allowancePojo.setUserId(userDetailVO.getUserCode());
			

			String status = new EmpAllowAprroveByDirectorBD()
					.approveAllAllowansesBD(allowancePojo);

			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorAction: approveAllAllowanses Ending");

		return null;
	}
	
	
	public synchronized ActionForward downloadAllowanceDetails(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : downloadEmployeeDailyAllowance Starting");

		try {
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;
			
			String startDate=request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			String userType=HelperClass.getCurrentUserIDType(request);
			String usercode=HelperClass.getCurrentUserID(request);
			String sourceFileName =null;
			if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
			 sourceFileName = request.getRealPath("Reports/AllowancesByDirector.jrxml");
			}else{
				 sourceFileName = request.getRealPath("Reports/AllowancesByAdmin.jrxml");
			}
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager.compileReport(design);
			
			ArrayList<EmpAllowAprroveByDirectorVo> allowanceList = new EmpAllowAprroveByDirectorBD()
			.getAllowancesForDownload(HelperClass.convertUIToDatabase(startDate), HelperClass.convertUIToDatabase(enddate),userType,usercode);
			
		
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					allowanceList);
			
			Map parameters = new HashMap();
			parameters.put("AllowanceDate",startDate);
			parameters.put("endDate", enddate);

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/EmployeeDailyAllowance.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "EmployeeDailyAllowance" };
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
					request.getRealPath("Reports/EmployeeDailyAllowance.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=EmployeeDailyAllowance.xls");
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
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : downloadEmployeeDailyAllowance Ending");

		return null;

	}
	
	public synchronized ActionForward downloadConflictAllowanceDetails(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : downloadConflictAllowanceDetails Starting");

		try {
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;
			
			String startDate=request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			String userType=HelperClass.getCurrentUserIDType(request);
			String usercode=HelperClass.getCurrentUserID(request);
			
				
			String sourceFileName =null;
			if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				
			 sourceFileName = request.getRealPath("Reports/ConflictAllowancesByDirector.jrxml");
			 
			}else{
				
				 sourceFileName = request.getRealPath("Reports/ConflictAllowancesByAdmin.jrxml");
			}
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager.compileReport(design);
			
			ArrayList<EmpAllowAprroveByDirectorVo> allowanceList = new EmpAllowAprroveByDirectorBD().getConflictEmployeesForDownLoad(
					HelperClass.convertUIToDatabase(startDate), HelperClass.convertUIToDatabase(enddate),userType,usercode);
			
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					allowanceList);
			
			Map parameters = new HashMap();
			parameters.put("AllowanceDate",startDate);
			parameters.put("endDate", enddate);

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/ConflictEmployeeDailyAllowance.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "EmployeeDailyAllowance" };
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
					request.getRealPath("Reports/ConflictEmployeeDailyAllowance.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=ConflictEmployeeDailyAllowance.xls");
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
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : downloadConflictAllowanceDetails Ending");

		return null;

	}
	
	
}