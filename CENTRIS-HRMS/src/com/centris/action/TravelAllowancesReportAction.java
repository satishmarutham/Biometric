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
import com.centris.POJO.TravelAllowancesReportPojo;
import com.centris.VO.EmployeeAllowanceReportVO;
import com.centris.VO.TravelAllowancesReportVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.EmployeeAllowanceReportBD;
import com.centris.delegate.TravelAllowancesReportBD;
import com.centris.form.EmployeeAllowanceReportForm;
import com.centris.form.TravelAllowancesReportForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class TravelAllowancesReportAction extends DispatchAction{

	private static Logger logger = Logger.getLogger(TravelAllowancesReportAction.class);
	
	public ActionForward getTravelAllowanceReportHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelAllowancesReportAction : getTravelAllowanceReportHome Starting");
		
			
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelAllowancesReportAction : getTravelAllowanceReportHome Ending");
	
		return mapping.findForward(ApplicationConstants.TRAVEL_ALLOWANCES_REPORT);
	}
	public ActionForward getTravelAllowances(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelAllowancesReportAction : getTravelAllowances Starting");
		
		try{
	
			TravelAllowancesReportForm travelAllowanceReportform=(TravelAllowancesReportForm)form;
			
			TravelAllowancesReportPojo travelAllowanceReportPojo=new TravelAllowancesReportPojo();
			
			travelAllowanceReportPojo.setFromdate(travelAllowanceReportform.getStartdate().trim());
			travelAllowanceReportPojo.setTodate(travelAllowanceReportform.getEnddate().trim());
			
		
			
			if(MessageConstants.STATUS_ALL.equalsIgnoreCase(travelAllowanceReportform.getStatus().trim())){
				
				travelAllowanceReportPojo.setStatus("%%");
			}else{
				travelAllowanceReportPojo.setStatus("%"+travelAllowanceReportform.getStatus().trim()+"%");
			}
			
			
			travelAllowanceReportPojo.setGroupby(travelAllowanceReportform.getGroupby().trim());
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			travelAllowanceReportPojo.setCurrusercode(userDetailVO.getUserCode());
	
			
			
			if(MessageConstants.GROUP_BY_MANAGER.equalsIgnoreCase(travelAllowanceReportform.getGroupby().trim())){
				
				Map<String,ArrayList<TravelAllowancesReportVo>> travelallowanceslist=  new TravelAllowancesReportBD().getTravelAllowancesBD(travelAllowanceReportPojo);
				request.setAttribute("TravelAllowancesListByMang", travelallowanceslist);
				if(travelallowanceslist.isEmpty()){
					request.setAttribute("nodata",MessageConstants.NO_DATA_FOUND);
				}
			}else{
				
				Map<String,ArrayList<TravelAllowancesReportVo>> travelallowanceslist=  new TravelAllowancesReportBD().getTravelAllowancesBD(travelAllowanceReportPojo);
				request.setAttribute("TravelAllowancesListByProject", travelallowanceslist);
				if(travelallowanceslist.isEmpty()){
					request.setAttribute("nodata",MessageConstants.NO_DATA_FOUND);
				}
			}
				
			
			request.setAttribute("startdate", travelAllowanceReportform.getStartdate().trim());
			request.setAttribute("enddate", travelAllowanceReportform.getEnddate().trim());
			request.setAttribute("status", travelAllowanceReportform.getStatus().trim());
			request.setAttribute("groupby", travelAllowanceReportform.getGroupby().trim());
			
			
		    }catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
	
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelAllowancesReportAction : getTravelAllowances Ending");
	
		return mapping.findForward(ApplicationConstants.TRAVEL_ALLOWANCES_REPORT);
	}
	
	public ActionForward downloadTravelAllowanceDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TravelAllowancesReportAction :downloadTravelAllowanceDetails starting");
		
		try {
			
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;
	
			String startDate=request.getParameter("fromdate");
			String enddate = request.getParameter("todate");
			String status = request.getParameter("Status");
			String groupby = request.getParameter("Groupby");
			
			TravelAllowancesReportPojo travelAllowanceReportPojo=new TravelAllowancesReportPojo();
			
			travelAllowanceReportPojo.setFromdate(startDate.trim());
			travelAllowanceReportPojo.setTodate(enddate.trim());
			if(MessageConstants.STATUS_ALL.equalsIgnoreCase(status.trim())){
				travelAllowanceReportPojo.setStatus("%%");
			}else{
				travelAllowanceReportPojo.setStatus("%"+status.trim()+"%");
			}
			travelAllowanceReportPojo.setGroupby(groupby.trim());
			
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			travelAllowanceReportPojo.setCurrusercode(userDetailVO.getUserCode());
	
			String sourceFileName =null;
			
			ArrayList<TravelAllowancesReportVo> travelallowanceslist=  new TravelAllowancesReportBD().getTravelAllowancesfordownloadBD(travelAllowanceReportPojo);

			Map parameters = new HashMap();
			parameters.put("BookedDate",startDate);
			parameters.put("endDate", enddate);
		
					
			if(status.trim().equalsIgnoreCase(MessageConstants.STATUS_ALL)){
				parameters.put("status", MessageConstants.ALL);
			}else if(MessageConstants.YES.equalsIgnoreCase(status.trim())){
				parameters.put("status", MessageConstants.APPROVED);
			}else{
				
				parameters.put("status", MessageConstants.NOT_APPROVED);
			}
			
			
			
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(travelallowanceslist);
			if(MessageConstants.GROUP_BY_MANAGER.equalsIgnoreCase(groupby.trim())){
				
				sourceFileName = request.getRealPath("Reports/TravelAllowancesManagerWiseXLSReport.jrxml");
				JasperDesign design = JRXmlLoader.load(sourceFileName);
				JasperReport jasperreport = JasperCompileManager.compileReport(design);
					
				stream = response.getOutputStream();
				JasperPrint print = JasperFillManager.fillReport(jasperreport,
						parameters, beanColDataSource);
				JRXlsExporter exporter = new JRXlsExporter();
				File outputFile = new File(
						request.getRealPath("Reports/TravelAllowancesManagerWiseXLSReport.xls"));
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
						request.getRealPath("Reports/TravelAllowancesManagerWiseXLSReport.xls"));
				response.setContentType("application/octet-stream");
				response.addHeader("Content-Disposition",
						"attachment; filename=TravelAllowanceReportManagerWise.xls");
				response.setContentLength((int) pdfxls.length());
				input = new FileInputStream(pdfxls);
				buf = new BufferedInputStream(input);
				int readBytes = 0;
				stream = response.getOutputStream();
				while ((readBytes = buf.read()) != -1) {
					stream.write(readBytes);
				}
			
			
			}else{
				
			sourceFileName = request.getRealPath("Reports/TravelAllowancesProjectWiseXLSReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager.compileReport(design);
		
			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/TravelAllowancesProjectWiseXLSReport.xls"));
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
					request.getRealPath("Reports/TravelAllowancesProjectWiseXLSReport.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=TravelAllowanceReportProjectWise.xls");
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
				+ " Control in TravelAllowancesReportAction : downloadTravelAllowanceDetails Ending");

		return null;

	}
	
	

	
	
}
