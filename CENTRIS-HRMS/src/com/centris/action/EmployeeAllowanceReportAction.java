package com.centris.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
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

import com.centris.POJO.EmployeeAllowanceReportPojo;
import com.centris.VO.EmpAllowAprroveByDirectorVo;
import com.centris.VO.EmployeeAllowanceReportVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.EmpAllowAprroveByDirectorBD;
import com.centris.delegate.EmployeeAllowanceReportBD;
import com.centris.form.EmployeeAllowanceReportForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class EmployeeAllowanceReportAction extends DispatchAction{

private static Logger logger = Logger.getLogger(EmployeeAllowanceReportAction.class);
	
	public ActionForward getEmpAllowanceReportHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAllowanceReportAction :getEmpAllowanceReportHome starting");
		try{
	
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAllowanceReportAction :getEmpAllowanceReportHome : Ending");
	
		return mapping.findForward(ApplicationConstants.EMPLOYEE_ALLOWANCE_REPORT);
	}
	
	
	public ActionForward getAllowances(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAllowanceReportAction :getAllowances starting");
		try{
			
			EmployeeAllowanceReportForm employeeAllowanceReportform=(EmployeeAllowanceReportForm)form;
			
			EmployeeAllowanceReportPojo employeeAllowanceReportPojo=new EmployeeAllowanceReportPojo();
			
			employeeAllowanceReportPojo.setFromdate(employeeAllowanceReportform.getStartdate().trim());
			employeeAllowanceReportPojo.setTodate(employeeAllowanceReportform.getEnddate().trim());
			employeeAllowanceReportPojo.setStatus(employeeAllowanceReportform.getStatus().trim());
			employeeAllowanceReportPojo.setGroupby(employeeAllowanceReportform.getGroupby().trim());
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			employeeAllowanceReportPojo.setCurrusercode(userDetailVO.getUserCode());
	
			if(MessageConstants.GROUP_BY_MANAGER.equalsIgnoreCase(employeeAllowanceReportform.getGroupby().trim())){
				
				Map<String,ArrayList<EmployeeAllowanceReportVO>> allowanceslist=  new EmployeeAllowanceReportBD().getAllowances(employeeAllowanceReportPojo);
				request.setAttribute("AllowancesListByMang", allowanceslist);
				if(allowanceslist.isEmpty()){
					request.setAttribute("nodata",MessageConstants.NO_DATA_FOUND);
				}
			}else{
				
				Map<String,ArrayList<EmployeeAllowanceReportVO>> allowanceslist=  new EmployeeAllowanceReportBD().getAllowances(employeeAllowanceReportPojo);
				request.setAttribute("AllowancesListByProject", allowanceslist);
				if(allowanceslist.isEmpty()){
				     request.setAttribute("nodata",MessageConstants.NO_DATA_FOUND);
				}
			}
				
			request.setAttribute("startdate", employeeAllowanceReportform.getStartdate().trim());
			request.setAttribute("enddate", employeeAllowanceReportform.getEnddate().trim());
			request.setAttribute("status", employeeAllowanceReportform.getStatus().trim());
			request.setAttribute("groupby", employeeAllowanceReportform.getGroupby().trim());
			
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAllowanceReportAction :getAllowances : Ending");
	
		return mapping.findForward(ApplicationConstants.EMPLOYEE_ALLOWANCE_REPORT);
	}
	public ActionForward downloadAllowanceDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAllowanceReportAction :downloadAllowanceDetails starting");
		
		System.out.println("Control in EmployeeAllowanceReportAction :downloadAllowanceDetails starting");
		
		try {
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;
			
			Enumeration< String> names=request.getParameterNames();
			while (names.hasMoreElements()) {
				String   string =(String)names.nextElement();
				System.out.println(string);
			}
			
			String startDate=request.getParameter("fromdate");
			String enddate = request.getParameter("todate");
			String status = request.getParameter("Status");
			String groupby = request.getParameter("Groupby");
			
            EmployeeAllowanceReportPojo employeeAllowanceReportPojo=new EmployeeAllowanceReportPojo();
			
			employeeAllowanceReportPojo.setFromdate(startDate.trim());
			employeeAllowanceReportPojo.setTodate(enddate.trim());
			employeeAllowanceReportPojo.setStatus(status.trim());
			employeeAllowanceReportPojo.setGroupby(groupby.trim());
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			employeeAllowanceReportPojo.setCurrusercode(userDetailVO.getUserCode());
	
			String sourceFileName =null;
			
			ArrayList<EmployeeAllowanceReportVO> allowanceslist=  new EmployeeAllowanceReportBD().getAllowancesfordownload(employeeAllowanceReportPojo);

			Map parameters = new HashMap();
			parameters.put("AllowanceDate",startDate);
			parameters.put("endDate", enddate);
			
			if(status.trim().equalsIgnoreCase(MessageConstants.STATUS_ALL)){
				parameters.put("status", MessageConstants.ALL);
			}else if(MessageConstants.YES.equalsIgnoreCase(status.trim())){
				parameters.put("status", MessageConstants.APPROVED);
			}else{
				
				parameters.put("status", MessageConstants.NOT_APPROVED);
			}
			
		
			if(MessageConstants.GROUP_BY_MANAGER.equalsIgnoreCase(groupby.trim())){
				
				sourceFileName = request.getRealPath("Reports/EmpAllowancesManagerWiseXLSReport.jrxml");
				JasperDesign design = JRXmlLoader.load(sourceFileName);
				JasperReport jasperreport = JasperCompileManager.compileReport(design);
			
				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(allowanceslist);
			
				stream = response.getOutputStream();
				JasperPrint print = JasperFillManager.fillReport(jasperreport,
						parameters, beanColDataSource);
				JRXlsExporter exporter = new JRXlsExporter();
				File outputFile = new File(
						request.getRealPath("Reports/EmpAllowancesManagerWiseXLSReport.xls"));
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
						request.getRealPath("Reports/EmpAllowancesManagerWiseXLSReport.xls"));
				response.setContentType("application/octet-stream");
				response.addHeader("Content-Disposition",
						"attachment; filename=EmployeeAllowanceReportManagerWise.xls");
				response.setContentLength((int) pdfxls.length());
				input = new FileInputStream(pdfxls);
				buf = new BufferedInputStream(input);
				int readBytes = 0;
				stream = response.getOutputStream();
				while ((readBytes = buf.read()) != -1) {
					stream.write(readBytes);
				}
			
			
			}else{
				
			sourceFileName = request.getRealPath("Reports/EmpAllowancesProjectWiseXLSReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager.compileReport(design);
		
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(allowanceslist);
		
			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/EmpAllowancesProjectWiseXLSReport.xls"));
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
					request.getRealPath("Reports/EmpAllowancesProjectWiseXLSReport.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=EmployeeAllowanceReportProjectWise.xls");
			response.setContentLength((int) pdfxls.length());
			input = new FileInputStream(pdfxls);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}
			}
		
		
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAllowanceReportAction : downloadAllowanceDetails Ending");

		return null;

	}
	
	
}
