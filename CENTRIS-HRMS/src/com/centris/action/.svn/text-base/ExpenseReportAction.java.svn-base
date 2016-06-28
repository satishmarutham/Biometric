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

import com.centris.POJO.ExpenseReportPojo;
import com.centris.POJO.TravelAllowancesReportPojo;
import com.centris.VO.ExpenseReportVO;
import com.centris.VO.TravelAllowancesReportVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.ExpenseReportBD;
import com.centris.delegate.TravelAllowancesReportBD;
import com.centris.form.ExpenseReportForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

 public class ExpenseReportAction extends DispatchAction{
	
		private static Logger logger = Logger.getLogger(TravelAllowancesReportAction.class);
		
		public ActionForward getExpensesReportHome(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())	+ " Control in ExpenseReportAction : getExpensesReportHome Starting");
			
				
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())	+ " Control in ExpenseReportAction : getExpensesReportHome Ending");
		
			return mapping.findForward(ApplicationConstants.EXPENSE_REPORT);
		}
		
		
		
		
		public ActionForward getAllAcadamicYears(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())	+ " Control in ExpenseReportAction : getAllAcadamicYears Starting");
			
			try{
				
			  ArrayList<ExpenseReportVO>	acadamicyearlist=new ExpenseReportBD().getAllAcadamicYearsBD();
				
			   JSONObject jsonobject=new JSONObject();
			   jsonobject.accumulate("acadamicYearlist", acadamicyearlist);
			   response.getWriter().print(jsonobject);
				
			}catch(Exception e){
				e.printStackTrace();
				logger.error(e.getMessage(),e);
			}
			
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())	+ " Control in ExpenseReportAction : getAllAcadamicYears Ending");
		
			return null;
		}
		
		
		
		public ActionForward getExpenses(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception {
			
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())	+ " Control in ExpenseReportAction : getExpenses Starting");
			
			try{
				ExpenseReportForm expenseReportForm=(ExpenseReportForm)form;
				ExpenseReportPojo expenseReportPojo=new ExpenseReportPojo();
			
				if(MessageConstants.STATUS_ALL.equalsIgnoreCase(expenseReportForm.getMonth().trim())){
					expenseReportPojo.setMonth("%%");
			    }else{
				   expenseReportPojo.setMonth("%"+expenseReportForm.getMonth().trim()+"%");
			    }
				
				expenseReportPojo.setYear(expenseReportForm.getYear().trim());
				
				if(MessageConstants.STATUS_ALL.equalsIgnoreCase(expenseReportForm.getStatus().trim())){
						expenseReportPojo.setStatus("%%");
				}else{
					expenseReportPojo.setStatus("%"+expenseReportForm.getStatus().trim()+"%");
				}
				
				expenseReportPojo.setGroupby(expenseReportForm.getGroupby().trim());
				UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
				expenseReportPojo.setCurusercode(userDetailVO.getUserCode());
				
				
				if(MessageConstants.GROUP_BY_MANAGER.equalsIgnoreCase(expenseReportForm.getGroupby().trim())){
					
					Map<String,ArrayList<ExpenseReportVO>> expensesmap=  new ExpenseReportBD().getExpensesBD(expenseReportPojo);
					request.setAttribute("ExpensesListByMang", expensesmap);
					if(expensesmap.isEmpty()){
						request.setAttribute("nodata",MessageConstants.NO_DATA_FOUND);
					}
				}else{
					
					Map<String,ArrayList<ExpenseReportVO>> expensesmap=  new ExpenseReportBD().getExpensesBD(expenseReportPojo);
					request.setAttribute("ExpensesListByProject", expensesmap);
					if(expensesmap.isEmpty()){
						request.setAttribute("nodata",MessageConstants.NO_DATA_FOUND);
					}
				}
					
						
				request.setAttribute("month", expenseReportForm.getMonth().trim());
				request.setAttribute("year", expenseReportForm.getYear().trim());
				request.setAttribute("status", expenseReportForm.getStatus().trim());
				request.setAttribute("groupby", expenseReportForm.getGroupby().trim());
				
			}catch(Exception e){
				e.printStackTrace();
				logger.error(e.getMessage(),e);
			}
			
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())	+ " Control in ExpenseReportAction : getExpenses Ending");
		
			return mapping.findForward(ApplicationConstants.EXPENSE_REPORT);
		}
		
		
		
		public ActionForward getExpensesfordownload(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)   throws Exception {
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in ExpenseReportAction :getExpensesfordownload starting");
			
			try {
				
				File pdfxls = null;
				FileInputStream input = null;
				BufferedInputStream buf = null;
				ServletOutputStream stream = null;
		
				String month=request.getParameter("month");
				String year = request.getParameter("year");
				String status = request.getParameter("Status");
				String groupby = request.getParameter("Groupby");
				
				
				ExpenseReportPojo expenseReportPojo=new ExpenseReportPojo();
				
				if(MessageConstants.STATUS_ALL.equalsIgnoreCase(month.trim())){
					expenseReportPojo.setMonth("%%");
			    }else{
				   expenseReportPojo.setMonth("%"+month.trim()+"%");
			    }
				
				expenseReportPojo.setYear(year.trim());
				
				if(MessageConstants.STATUS_ALL.equalsIgnoreCase(status.trim())){
						expenseReportPojo.setStatus("%%");
				}else{
					expenseReportPojo.setStatus("%"+status.trim()+"%");
				}
				
				expenseReportPojo.setGroupby(groupby.trim());
				UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
				expenseReportPojo.setCurusercode(userDetailVO.getUserCode());
				
		
				String sourceFileName =null;
				
				ArrayList<ExpenseReportVO> expenseslist=  new ExpenseReportBD().getExpensesfordownload(expenseReportPojo);

				Map parameters = new HashMap();
				parameters.put("month",month);
				parameters.put("year", year);
			
						
				if(status.trim().equalsIgnoreCase(MessageConstants.STATUS_ALL)){
					parameters.put("status", MessageConstants.ALL);
				}else if(MessageConstants.YES.equalsIgnoreCase(status.trim())){
					parameters.put("status", MessageConstants.APPROVED);
				}else{
					
					parameters.put("status", MessageConstants.NOT_APPROVED);
				}
				
				
				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(expenseslist);
			
				if(MessageConstants.GROUP_BY_MANAGER.equalsIgnoreCase(groupby.trim())){
					
					sourceFileName = request.getRealPath("Reports/ExpenseReportManagerWiseXLS.jrxml");
					JasperDesign design = JRXmlLoader.load(sourceFileName);
					JasperReport jasperreport = JasperCompileManager.compileReport(design);
						
					stream = response.getOutputStream();
					JasperPrint print = JasperFillManager.fillReport(jasperreport,
							parameters, beanColDataSource);
					JRXlsExporter exporter = new JRXlsExporter();
					File outputFile = new File(
							request.getRealPath("Reports/ExpenseReportManagerWiseXLS.xls"));
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
							request.getRealPath("Reports/ExpenseReportManagerWiseXLS.xls"));
					response.setContentType("application/octet-stream");
					response.addHeader("Content-Disposition",
							"attachment; filename=ExpenseReportManagerWise.xls");
					response.setContentLength((int) pdfxls.length());
					input = new FileInputStream(pdfxls);
					buf = new BufferedInputStream(input);
					int readBytes = 0;
					stream = response.getOutputStream();
					while ((readBytes = buf.read()) != -1) {
						stream.write(readBytes);
					}
				
				
				}else{
					
				sourceFileName = request.getRealPath("Reports/ExpenseReportProjectWiseXLS.jrxml");
				JasperDesign design = JRXmlLoader.load(sourceFileName);
				JasperReport jasperreport = JasperCompileManager.compileReport(design);
			
				stream = response.getOutputStream();
				JasperPrint print = JasperFillManager.fillReport(jasperreport,
						parameters, beanColDataSource);
				JRXlsExporter exporter = new JRXlsExporter();
				File outputFile = new File(
						request.getRealPath("Reports/ExpenseReportProjectWiseXLS.xls"));
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
						request.getRealPath("Reports/ExpenseReportProjectWiseXLS.xls"));
				response.setContentType("application/octet-stream");
				response.addHeader("Content-Disposition",
						"attachment; filename=ExpenseReportProjectWise.xls");
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
					+ " Control in ExpenseReportAction :getExpensesfordownload Ending");

			return null;

		}
		
			
		
}
