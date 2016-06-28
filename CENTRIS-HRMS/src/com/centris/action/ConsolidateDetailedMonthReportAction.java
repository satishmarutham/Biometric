package com.centris.action;

import java.text.DateFormatSymbols;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;
import com.centris.VO.ConsolidateDetailedDayReportVO;
import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.VO.DetailedMonthVo_Report;
import com.centris.delegate.ConsolidateDetailedMonthReportBD;
import com.centris.form.ConsolidateDetailedMonthReportForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class ConsolidateDetailedMonthReportAction extends DispatchAction {
	private static Logger logger = Logger
			.getLogger(ConsolidateDetailedMonthReportAction.class);

	public synchronized ActionForward getConsolidatedMonthReport(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportAction:getConsolidatedMonthReport Starting");

		ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm = (ConsolidateDetailedMonthReportForm) form;
		try {
			request.setAttribute("currentSearch",
					consolidateDetailedMonthReportForm);
			/*
			 * List<ConsolidateDetailedMonthReportVO>
			 * consolidatedMonthReportList = new
			 * ConsolidateDetailedMonthReportBD().getConsolidatedMonthReport(
			 * consolidateDetailedMonthReportForm);
			 * request.setAttribute("consolidatedMonthReportList",
			 * consolidatedMonthReportList);
			 */

			Map<String, List<ConsolidateDetailedMonthReportVO>> consolidatedMonthReportList = new ConsolidateDetailedMonthReportBD()
					.getConsolidatedMonthReportN(consolidateDetailedMonthReportForm);
			request.setAttribute("consolidatedMonthReportList",
					consolidatedMonthReportList);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportAction:getConsolidatedMonthReport Ending");
		return mapping.findForward("consolidateDetailedMonthReport");
	}

	public synchronized ActionForward getDetailedMonthReport(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportAction:getDetailedMonthReport Starting");

		ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm = (ConsolidateDetailedMonthReportForm) form;
		try {
			request.setAttribute("currentSearch",
					consolidateDetailedMonthReportForm);
			List<ConsolidateDetailedMonthReportVO> detailedMonthReportList = new ConsolidateDetailedMonthReportBD()
					.getDetailedMonthReport(consolidateDetailedMonthReportForm);
			request.setAttribute("detailedMonthReportList",
					detailedMonthReportList);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportAction:getDetailedMonthReport Ending");
		return mapping.findForward("consolidateDetailedMonthReport");
	}

	public synchronized ActionForward detailedMonthReportPdfdownload(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportAction:detailedMonthReportPdfdownload Starting");

		/*
		 * ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm
		 * = (ConsolidateDetailedMonthReportForm) form;
		 * List<ConsolidateDetailedMonthReportVO> detailedMonthReportList = new
		 * ConsolidateDetailedMonthReportBD
		 * ().getDetailedMonthReport(consolidateDetailedMonthReportForm);
		 * request.setAttribute("detailedMonthReportList",
		 * detailedMonthReportList); String employeeId =
		 * consolidateDetailedMonthReportForm.getEmployee(); if (employeeId ==
		 * null) { employeeId = "%%"; } String groupId =
		 * consolidateDetailedMonthReportForm.getGroup(); if (groupId == null) {
		 * groupId = "%%"; } String locationId =
		 * consolidateDetailedMonthReportForm .getLocation(); if (locationId ==
		 * null) { locationId = "%%"; } String designationId =
		 * consolidateDetailedMonthReportForm.getDesignation(); if
		 * (designationId == null) { designationId = "%%"; } String
		 * attendenceDate = consolidateDetailedMonthReportForm .getYear().trim()
		 * + "-" + consolidateDetailedMonthReportForm.getMonth().trim() + "%";
		 * 
		 * String imageFilePath = getServlet().getServletContext()
		 * .getRealPath("") + "\\images\\IdeaLogo.png"; Map<String, Object>
		 * mapData = new HashMap<String, Object>(); String temp_location = "'" +
		 * locationId.trim().replaceAll(",", "','") + "'";
		 * System.out.println("Location::" + temp_location);
		 * mapData.put("groupId", groupId.trim()); mapData.put("locationId",
		 * temp_location); mapData.put("designationId", designationId.trim());
		 * mapData.put("empId", employeeId.trim());
		 * mapData.put("attendenceDate", attendenceDate);
		 * mapData.put("ideaImage", imageFilePath);
		 * System.out.println("IMage Path::" + imageFilePath);
		 * 
		 * String filepath = request
		 * .getRealPath("Reports/DetailedReports.jrxml");
		 * 
		 * JasperDesign design = JRXmlLoader.load(filepath); JasperReport
		 * jasperreport = JasperCompileManager .compileReport(design); byte[]
		 * bytes = JasperRunManager.runReportToPdf(jasperreport, mapData,
		 * DBService.getConnection());
		 * response.setContentType("application/pdf");
		 * response.setContentLength(bytes.length);
		 * response.setHeader("Content-Disposition", "outline; filename=\"" +
		 * "Detailed Report" + ".pdf\""); ServletOutputStream outstream =
		 * response.getOutputStream(); outstream.write(bytes, 0, bytes.length);
		 * outstream.flush(); outstream.close();
		 */

		try {

			ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm = (ConsolidateDetailedMonthReportForm) form;
			String employeeId = request.getParameter("employee");
			String groupId = request.getParameter("group");
			String locationId = request.getParameter("location");
			String designationId = request.getParameter("designation");
			String month = request.getParameter("month");
			String year = request.getParameter("year");

			if (groupId == null) {
				groupId = "%%";
			}

			if (locationId == null) {
				locationId = "%%";
			}

			if (designationId == null) {
				designationId = "%%";
			}

			if (employeeId == null) {
				employeeId = "%%";
			}
			consolidateDetailedMonthReportForm.setEmployee(employeeId.trim());
			consolidateDetailedMonthReportForm.setGroup(groupId.trim());
			consolidateDetailedMonthReportForm.setLocation(locationId.trim());
			consolidateDetailedMonthReportForm.setYear(year.trim());
			consolidateDetailedMonthReportForm.setMonth(month.trim());
			consolidateDetailedMonthReportForm.setDesignation(designationId
					.trim());

			String monthName = new DateFormatSymbols().getMonths()[Integer
					.parseInt(month) - 1] + " - " + year;

			String filepath = request
					.getRealPath("Reports/DetailedReports.jrxml");
			JasperDesign design = JRXmlLoader.load(filepath);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			List<DetailedMonthVo_Report> detailedMonthReportList = new ConsolidateDetailedMonthReportBD()
					.getDetailedReport(consolidateDetailedMonthReportForm);
			JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
					detailedMonthReportList);
			String imageFilePath = getServlet().getServletContext()
					.getRealPath("") + "\\images\\IdeaLogo.png";
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("ideaImage", imageFilePath);
			parameters.put("monthName", monthName);
			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanCollectionDataSource);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "Detailed Report - " + monthName + ".pdf\"");
			ServletOutputStream outstream = response.getOutputStream();
			outstream.write(bytes, 0, bytes.length);
			
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportAction:detailedMonthReportPdfdownload Ending");
		return null;

	}

	public synchronized ActionForward consolidatedMonthReportPdfdownload(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportAction:consolidatedMonthReportPdfdownload Starting");

		ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm = (ConsolidateDetailedMonthReportForm) form;
		String employeeId = request.getParameter("employee");
		String groupId = request.getParameter("group");
		String locationId = request.getParameter("location");
		String designationId = request.getParameter("designation");
		String month = request.getParameter("month");
		String year = request.getParameter("year");

		String monthName = new DateFormatSymbols().getMonths()[Integer
				.parseInt(month) - 1] + " - " + year;

		if (groupId == null) {
			groupId = "%%";
		}

		if (locationId == null) {
			locationId = "%%";
		}

		if (designationId == null) {
			designationId = "%%";
		}

		if (employeeId == null) {
			employeeId = "%%";
		}
		consolidateDetailedMonthReportForm.setEmployee(employeeId.trim());
		consolidateDetailedMonthReportForm.setGroup(groupId.trim());
		consolidateDetailedMonthReportForm.setLocation(locationId.trim());
		consolidateDetailedMonthReportForm.setYear(year.trim());
		consolidateDetailedMonthReportForm.setMonth(month.trim());
		consolidateDetailedMonthReportForm.setDesignation(designationId.trim());
		try {
			String filepath = request
					.getRealPath("Reports/ConsolidatedReport.jrxml");
			JasperDesign design = JRXmlLoader.load(filepath);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			ConsolidateDetailedMonthReportBD consolidateDetailedMonthReportBD = new ConsolidateDetailedMonthReportBD();

			List<ConsolidateDetailedMonthReportVO> consolidatedMonthReportList = consolidateDetailedMonthReportBD
					.getConsolidatedMonthReport(consolidateDetailedMonthReportForm);
			JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
					consolidatedMonthReportList);
			String imageFilePath = getServlet().getServletContext()
					.getRealPath("") + "\\images\\IdeaLogo.png";
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("ideaImage", imageFilePath);
			parameters.put("monthName", monthName);

			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanCollectionDataSource);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "Consolidated Report - " + monthName + ".pdf\"");
			ServletOutputStream outstream = response.getOutputStream();
			outstream.write(bytes, 0, bytes.length);
			
		} catch (Exception exception) {
			logger.error(exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportAction:consolidatedMonthReportPdfdownload Ending");
		return null;

	}

	public synchronized ActionForward consolidatedMonthReport_forDay(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportAction:consolidatedMonthReportPdfdownload Starting");

		ConsolidateDetailedMonthReportForm consolidateDetailedMonthReportForm = (ConsolidateDetailedMonthReportForm) form;
		try {
			String groupId = consolidateDetailedMonthReportForm.getGroup();
			if (groupId == null) {
				consolidateDetailedMonthReportForm.setGroup("%%");
			}

			String locationId = consolidateDetailedMonthReportForm
					.getLocation();
			if (locationId == null) {
				consolidateDetailedMonthReportForm.setLocation("%%");
			}
			String designationId = consolidateDetailedMonthReportForm
					.getDesignation();
			if (designationId == null) {
				consolidateDetailedMonthReportForm.setDesignation("%%");
			}
			String employeeId = consolidateDetailedMonthReportForm
					.getEmployee();
			if (employeeId == null) {
				consolidateDetailedMonthReportForm.setEmployee("%%");
			}

			String grpName = (String) request.getParameter("groupName");

			List<ConsolidateDetailedDayReportVO> consolidatedMonthReportList = new ConsolidateDetailedMonthReportBD()
					.consolidatedMonthReport_forDay(consolidateDetailedMonthReportForm);

			String filepath = request
					.getRealPath("Reports/ConsolidatedDayReport.jrxml");
			JasperDesign design = JRXmlLoader.load(filepath);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					consolidatedMonthReportList);
			String imageFilePath = getServlet().getServletContext()
					.getRealPath("") + "\\images\\IdeaLogo.png";
			Map parameters = new HashMap();
			parameters.put("ideaImage", imageFilePath);
			parameters.put("groupName", grpName.trim());
			parameters.put("reportDate",
					consolidateDetailedMonthReportForm.getYear());

			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanColDataSource);

			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "Consolidated Day Report - "
					+ consolidateDetailedMonthReportForm.getYear().trim()
					+ ".pdf\"");
			ServletOutputStream outstream = response.getOutputStream();
			outstream.write(bytes, 0, bytes.length);
			
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportAction:consolidatedMonthReportPdfdownload Ending");
		return null;
	}

	public  ActionForward getEmpDetailsByDesiWithMultipleLocation(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportAction:getEmpDetailsByDesiWithMultipleLocation Starting");

		String designation = request.getParameter("designation");
		String location = request.getParameter("location");
		String group = request.getParameter("group");
		try {
			List<ConsolidateDetailedMonthReportVO> empList = new ConsolidateDetailedMonthReportBD()
					.getEmpDetailsByDesiWithMultipleLocation(designation,
							group, location);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("empList", empList);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportAction:getEmpDetailsByDesiWithMultipleLocation Ending");
		return null;
	}

	public  ActionForward getEmpDetailsByDesignation(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportAction:getEmpDetailsByDesignation Starting");

		String designation = request.getParameter("designation");
		String location = request.getParameter("location");
		String group = request.getParameter("group");
		try {
			List<ConsolidateDetailedMonthReportVO> empList = new ConsolidateDetailedMonthReportBD()
					.getEmpDetailsByDesignation(designation, group, location);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("empList", empList);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ConsolidateDetailedMonthReportAction:getEmpDetailsByDesignation Ending");
		return null;
	}

}
