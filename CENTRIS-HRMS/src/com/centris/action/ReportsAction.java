package com.centris.action;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
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
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.DAO.AbstractConnectionFactory;
import com.centris.DAO.DAOIMPL.EmployeeResumeCreationDaoImpl;
import com.centris.POJO.EmployeeResumeCreationPojo;
import com.centris.VO.AdminDayReportVo;
import com.centris.VO.AllEmployeeReportVO;
import com.centris.VO.AttendenceApprovelVo;
import com.centris.VO.DailyEmployeeAllowanceVO;
import com.centris.VO.MonthReportVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AttendenceApprovelBD;
import com.centris.delegate.EmployeeDailyAllowanceBD;
import com.centris.delegate.GetAllEmployeeBD;
import com.centris.exception.AITrackerException;
import com.centris.form.EmployeeDailyAllowanceForm;
import com.centris.util.HelperClass;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class ReportsAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(ReportsAction.class);

	public ActionForward downloadEmployeePersonalDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : downloadEmployeePersonalDetails Starting");
		BufferedImage f = null;
		String width = null;
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
				.getAttribute("UserDetails");
		String userCode = userDetailVO.getUserCode();
		String userName = userDetailVO.getUserName();

		String imageFilePath = getServlet().getServletContext().getRealPath("")
				+ "\\images\\centris.png";

		String serverPath = getServlet().getServletContext().getRealPath("")
				+ "/";

		String checkPath = getServlet().getServletContext().getRealPath("")
				+ "/UploadedImage/Employee/emp_image";
		String filepath = null;

		try {
			f = ImageIO.read(new File(checkPath + userCode + ".jpg"));
			width = Integer.toString(f.getWidth());
		} catch (IOException e) {
			logger.error(e);
		}

		Map<String, Object> mapdata = new HashMap<String, Object>();
		mapdata.put("userCode", userCode);
		mapdata.put("userName", userName);
		mapdata.put("LOGO_DIR", imageFilePath);
		mapdata.put("IMG_DIR", serverPath);

		try {
			if (width != null) {
				filepath = request.getRealPath("Reports/PersonalDetails.jrxml");
			} else {
				filepath = request
						.getRealPath("Reports/PersonalDetails_withoutImage.jrxml");
			}
			JasperDesign design = JRXmlLoader.load(filepath);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					mapdata, AbstractConnectionFactory.getConnection());
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);

			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "Personal Details" + ".pdf\"");
			ServletOutputStream outstream = response.getOutputStream();
			outstream.write(bytes, 0, bytes.length);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction: downloadEmployeePersonalDetails Ending");
		return null;
	}

	public synchronized ActionForward downloadMonthPDFReport(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : downloadMonthPDFReport Starting");

		try {
			ServletOutputStream stream = null;
			String sourceFileName = request
					.getRealPath("Reports/AdminMonthPdfReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			List<MonthReportVO> monthReportVOList = (List<MonthReportVO>) request
					.getSession(false).getAttribute("downloadMonthReportList");
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					monthReportVOList);
			String imageFilePath = getServlet().getServletContext()
					.getRealPath("") + "\\images\\centris.png";
			Map parameters = new HashMap();
			parameters.put("TeleIndiaImage", imageFilePath);
			stream = response.getOutputStream();
			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanColDataSource);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "MonthReport.pdf\"");
			stream.write(bytes, 0, bytes.length);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : downloadMonthPDFReport Ending");

		return null;

	}

	public synchronized ActionForward downloadMonthXLSReport(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : downloadMonthXLSReport Starting");

		try {
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/AdminMonthXLSReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			List<MonthReportVO> monthReportVOList = (List<MonthReportVO>) request
					.getSession(false).getAttribute("downloadMonthReportList");
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					monthReportVOList);
			Map parameters = new HashMap();
			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/MonthReport.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Month Report" };
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

			pdfxls = new File(request.getRealPath("Reports/MonthReport.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=MonthReport.xls");
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
				+ " Control in AdminMonthReportAction : downloadMonthXLSReport Ending");

		return null;

	}

	public synchronized ActionForward downloadPDFDayReport(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		System.out.println("adminDayReportList  Action");
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : downloadDayReport Starting");

		try {
			ServletOutputStream stream = null;
			String sourceFileName = request
					.getRealPath("Reports/AdminDayReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			List<AdminDayReportVo> adminDayReportList = (List<AdminDayReportVo>) request
					.getSession(false).getAttribute("downloadDayReportList");

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					adminDayReportList);
			String imageFilePath = getServlet().getServletContext()
					.getRealPath("") + "\\images\\centris.png";

			Map parameters = new HashMap();
			parameters.put("image", imageFilePath);
			stream = response.getOutputStream();
			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanColDataSource);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "DayReport.pdf\"");
			stream.write(bytes, 0, bytes.length);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : downloadMonthPDFReport Ending");

		return null;

	}

	public synchronized ActionForward downloadXLSDayReport(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : downloadXLSDayReport Starting");

		try {
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;

			String sourceFileName = request
					.getRealPath("Reports/AdminDayXLSReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			List<AdminDayReportVo> adminDayReportList = (List<AdminDayReportVo>) request
					.getSession(false).getAttribute("downloadDayReportList");

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					adminDayReportList);

			Map parameters = new HashMap();

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/DayReport.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Day Report" };
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

			pdfxls = new File(request.getRealPath("Reports/DayReport.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=DayReport.xls");
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
				+ " Control in ReportsAction : downloadXLSDayReport Ending");

		return null;

	}

	/*-----------------------------chiru downloadAllEmployees report--------------------*/

	public ActionForward downloadAllEmployees(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : downloadAllEmployees Starting");

		String[] values = request.getParameterValues("Empids");
		String[] empids = values[0].split(",");

		List<AllEmployeeReportVO> employeelist = new GetAllEmployeeBD()
				.getallEmployeeDetails(empids);

		String imagePath = getServlet().getServletContext().getRealPath("")
				+ "\\images\\centris.png";

		Map<String, Object> mapdata = new HashMap<String, Object>();
		mapdata.put("LOGO_DIR", imagePath);

		try {
			String filepath = request
					.getRealPath("Reports/AllEmployeeListTeleindia.jrxml");
			JasperDesign design = JRXmlLoader.load(filepath);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
					employeelist);

			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					mapdata, beanCollectionDataSource);

			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);

			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "All Employees" + ".pdf\"");
			ServletOutputStream outstream = response.getOutputStream();
			outstream.write(bytes, 0, bytes.length);
			outstream.flush();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: downloadAllEmployees Ending");
		return null;
	}

	public ActionForward downloadAllEmployeeDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : downloadAllEmployeeDetails Starting");

		try {
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
					.getAttribute("UserDetails");
			String userCode = userDetailVO.getUserCode();
			String imagePath = getServlet().getServletContext().getRealPath("")
					+ "\\images\\centris.png";

			String imageFilePath = request.getRealPath("/");

			System.out.println(imageFilePath);
			System.out.println(userCode);
			System.out.println(imagePath);
			
			
			
			Map<String, Object> mapdata = new HashMap<String, Object>();
			mapdata.put("usercode", userCode.trim());
			mapdata.put("EMPLOYEE_DIR", imageFilePath.trim());
			mapdata.put("CENTRIS-HRMS_LOG", imagePath.trim());

			String filepath = request
					.getRealPath("Reports/AllEployeePersonalDetailsTele.jrxml");

			JasperDesign design = JRXmlLoader.load(filepath);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					mapdata, AbstractConnectionFactory.getConnection());
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);

			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "All Employees Personal Details" + ".pdf\"");
			ServletOutputStream outstream = response.getOutputStream();
			outstream.write(bytes, 0, bytes.length);
			outstream.flush();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		/*
		 * String[] values=request.getParameterValues("Empids"); String[] empids
		 * = values[0].split(",");
		 * 
		 * List<AllEmployeeReportVO> employeelist=new
		 * GetAllEmployeeBD().getallEmployeeDetails(empids);
		 * 
		 * String imagePath = getServlet().getServletContext().getRealPath("") +
		 * "\\images\\centris.png";
		 * 
		 * String imageFilePath = request.getRealPath("/");
		 * 
		 * Map<String, Object> mapdata = new HashMap<String, Object>();
		 * 
		 * mapdata.put("EMPLOYEE_DIR", imageFilePath);
		 * mapdata.put("CENTRIS-HRMS_LOG", imagePath); try { String filepath =
		 * request .getRealPath("Reports/AllEployeePersonalDetailsTele.jrxml");
		 * 
		 * JasperDesign design = JRXmlLoader.load(filepath); JasperReport
		 * jasperreport = JasperCompileManager.compileReport(design);
		 * 
		 * JRBeanCollectionDataSource beanCollectionDataSource = new
		 * JRBeanCollectionDataSource(employeelist);
		 * 
		 * byte[] bytes = JasperRunManager.runReportToPdf(jasperreport, mapdata,
		 * beanCollectionDataSource);
		 * response.setContentType("application/pdf");
		 * response.setContentLength(bytes.length);
		 * 
		 * response.setHeader("Content-Disposition", "outline; filename=\"" +
		 * "All Employees Details" + ".pdf\""); ServletOutputStream outstream =
		 * response.getOutputStream(); outstream.write(bytes, 0, bytes.length);
		 * outstream.flush();
		 * 
		 * } catch (Exception e) { logger.error(e.getMessage(), e);
		 * e.printStackTrace(); }
		 */
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: downloadAllEmployeeDetails Ending");
		return null;
	}

	/*-----------------------------chiru downloadAllEmployees report--------------------*/

	public synchronized ActionForward downloadEmployeeDailyAllowance(
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
			String date = request.getParameter("date");
			EmployeeDailyAllowanceForm employeeDailyAllowanceForm = new EmployeeDailyAllowanceForm();
			employeeDailyAllowanceForm.setDailyAllowanceDate(date);

			String sourceFileName = request
					.getRealPath("Reports/AdminEmployeeDailyAllowance.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			List<DailyEmployeeAllowanceVO> dailyEmployeeAllowanceVOList = new EmployeeDailyAllowanceBD()
					.viewEmployeeDailyAllowance(employeeDailyAllowanceForm);
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					dailyEmployeeAllowanceVOList);
			Map parameters = new HashMap();
			parameters.put("AllowanceDate", HelperClass
					.convertDatabaseToTitle(HelperClass
							.convertUIToDatabase(date)));

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

	public synchronized ActionForward downloadEmployeeDailyAllowanceFormat(
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
			pdfxls = new File(
					request.getRealPath("Reports/Employee_Daily_Allowance.xls"));
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
	public ActionForward downloadEmployeeResume(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : downloadEmployeeResume Starting");
		BufferedImage f = null;
		String width = null;
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
				.getAttribute("UserDetails");
		String userCode = userDetailVO.getUserCode();
		String userName = userDetailVO.getUserName();

		String imageFilePath = getServlet().getServletContext().getRealPath("")
				+ "\\images\\teleLogo.png";

		String serverPath = getServlet().getServletContext().getRealPath("")
				+ "/";

		String checkPath = getServlet().getServletContext().getRealPath("")
				+ "/UploadedImage/Employee/emp_image";
		String filepath = null;

		try {
			f = ImageIO.read(new File(checkPath + userCode + ".jpg"));
			width = Integer.toString(f.getWidth());
		} catch (IOException e) {
			logger.error(e);
		}

	
		
		try {
		
			
			ServletOutputStream stream = null;
			String sourceFileName = request
					.getRealPath("Reports/EmployeeResumeRepotByGroup.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			
			EmployeeResumeCreationDaoImpl creationDao=new EmployeeResumeCreationDaoImpl();
			List<EmployeeResumeCreationPojo> resumeDetailsList = new ArrayList<EmployeeResumeCreationPojo>();
			
			

			List<EmployeeResumeCreationPojo> detailsList=new ArrayList<EmployeeResumeCreationPojo>();
			String employeeCode=request.getParameter("employeeCode");
			
			String curreUser=HelperClass.getCurrentUserID(request);
			
			EmployeeResumeCreationPojo individualDetails=null;
			
			if(curreUser.toString().trim().substring(0, 3).equalsIgnoreCase("EMP")){
				
				 individualDetails=creationDao.personalDetailsById(curreUser);
				
			}else{
				
				 individualDetails=creationDao.personalDetailsById(employeeCode);
			}
			
			
			
			
			detailsList=creationDao.getResumeDetailsDownload(employeeCode);
			
			
			
			
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(detailsList);
			Map parameters = new HashMap();
			parameters.put("address",individualDetails.getPresentAddress());
			parameters.put("employeeName",individualDetails.getEmployeeName());
			parameters.put("email",individualDetails.getEmail());
			parameters.put("mobileNo",individualDetails.getPhoneNo());
			stream = response.getOutputStream();
			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,parameters,beanColDataSource);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "Resume.pdf\"");
			stream.write(bytes, 0, bytes.length);
		} 
		
		catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction: downloadEmployeeResume Ending");
		return null;
	}
	
	
	
	
	public ActionForward downloadEmployeeResumeWord(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : downloadEmployeeResumeWord Starting");
		BufferedImage f = null;
		String width = null;
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
				.getAttribute("UserDetails");
		String userCode = userDetailVO.getUserCode();
		String userName = userDetailVO.getUserName();

		String imageFilePath = getServlet().getServletContext().getRealPath("")
				+ "\\images\\teleLogo.png";

		String serverPath = getServlet().getServletContext().getRealPath("")
				+ "/";

		String checkPath = getServlet().getServletContext().getRealPath("")
				+ "/UploadedImage/Employee/emp_image";
		String filepath = null;

		try {
			f = ImageIO.read(new File(checkPath + userCode + ".jpg"));
			width = Integer.toString(f.getWidth());
		} catch (IOException e) {
			logger.error(e);
		}

	
		
		try {
		
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;
		
			String sourceFileName = request
					.getRealPath("Reports/EmployeeResumeWord.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager.compileReport(design);
			
			EmployeeResumeCreationDaoImpl creationDao=new EmployeeResumeCreationDaoImpl();
			List<EmployeeResumeCreationPojo> resumeDetailsList = new ArrayList<EmployeeResumeCreationPojo>();
			
			

			List<EmployeeResumeCreationPojo> detailsList=new ArrayList<EmployeeResumeCreationPojo>();
			String employeeCode=request.getParameter("employeeCode");
	String curreUser=HelperClass.getCurrentUserID(request);
			
			EmployeeResumeCreationPojo individualDetails=null;
			
			if(curreUser.toString().trim().substring(0, 3).equalsIgnoreCase("EMP")){
				
				 individualDetails=creationDao.personalDetailsById(curreUser);
				
			}else{
				
				 individualDetails=creationDao.personalDetailsById(employeeCode);
			}
			
			
			detailsList=creationDao.getResumeDetailsDownload(employeeCode);
			
			
			
			
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(detailsList);
			Map parameters = new HashMap();
			parameters.put("address",individualDetails.getPresentAddress());
			parameters.put("employeeName",individualDetails.getEmployeeName());
			parameters.put("email",individualDetails.getEmail());
			parameters.put("mobileNo",individualDetails.getPhoneNo());
			stream = response.getOutputStream();
		
			JasperPrint print = JasperFillManager.fillReport(jasperreport,parameters,beanColDataSource);

			JRDocxExporter exporter = new JRDocxExporter();
			
			File outputFile = new File(
					request.getRealPath("Reports/EmployeeResumeWord.doc"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			
		
			ByteArrayOutputStream baos = new ByteArrayOutputStream();   
			
			
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM,baos);
			exporter.exportReport();
			byte[] bs=baos.toByteArray();
 			
		
			response.setContentLength(bs.length);
			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "Resume.doc\"");
			stream.write(bs, 0, bs.length);
			exporter.exportReport();
		
		} 
		
		catch (Exception e) {
			logger.error(e.getMessage(), e);
		
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction: downloadEmployeeResumeWord Ending");
		return null;
	}
	public ActionForward getAllEmployeesNames(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction : getAllEmployeesNames Starting");
		String searchTerm = request.getParameter("searchTerm");
		
		UserDetailVO userDetailVO = (UserDetailVO) request
				.getSession(false).getAttribute("UserDetails");
		String currentUserId = userDetailVO.getUserCode();
		
		String userType=HelperClass.getCurrentUserIDType(request);
	
		ArrayList<AttendenceApprovelVo> employeeList=new AttendenceApprovelBD().getEmployees(currentUserId,userType);
		
	
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("employeeList", employeeList);

		response.getWriter().print(jsonObject);
logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ReportsAction: getAllEmployeesNames Ending");
		return null;
	}
	
	public synchronized ActionForward downloadAdvanceSalaryConsolidateManager(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdminMonthReportAction : downloadAdvanceSalaryConsolidateManager Starting");

		try {
			File pdfxls = null;
			FileInputStream input = null;
			BufferedInputStream buf = null;
			ServletOutputStream stream = null;
			String toDate = request.getParameter("startdate");
			String fromDate = request.getParameter("enddate");
			String groupBy = request.getParameter("groupby");
			String status = request.getParameter("status");
			if(status==null){
				status="%%";
			}
		
					
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentUserId = userDetailVO.getUserCode();
			String userName=userDetailVO.getUserFirstName();
			System.out.println("toDate"+toDate);
			System.out.println("fromDate"+fromDate);
			System.out.println("groupBy"+groupBy);
			System.out.println("status"+status);
			
			
			System.out.println("currentUserId"+currentUserId);
			System.out.println("userName"+userName);
			String sourceFileName=null;

			if(groupBy.equalsIgnoreCase("PJT")){
				sourceFileName = request
						.getRealPath("Reports/AdvanceSalaryConsolidateReportProject.jrxml");
		
		
			
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			
			Map parameters = new HashMap();
			parameters.put("toDate",HelperClass
					.convertUIToDatabase(toDate));
			parameters.put("fromDate",HelperClass
					.convertUIToDatabase(fromDate));
			parameters.put("status",status);
		parameters.put("directorName",userName);
			parameters.put("directorCode",currentUserId);
			
			

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters,AbstractConnectionFactory.getConnection());
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/AdvanceSalaryConsolidateReportProject.xls"));
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
					request.getRealPath("Reports/AdvanceSalaryConsolidateReportProject.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=AdvanceSalaryConsolidateReport.xls");
			response.setContentLength((int) pdfxls.length());
			input = new FileInputStream(pdfxls);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}
			}
			else
			{

				sourceFileName = request
						.getRealPath("Reports/AdvanceSalaryConsolidateReport.jrxml");
				
				JasperDesign design = JRXmlLoader.load(sourceFileName);
				JasperReport jasperreport = JasperCompileManager
						.compileReport(design);
				
				Map parameters = new HashMap();
				parameters.put("toDate",HelperClass
						.convertUIToDatabase(toDate));
				parameters.put("fromDate",HelperClass
						.convertUIToDatabase(fromDate));
				parameters.put("status",status);
			parameters.put("directorName",userName);
				parameters.put("directorCode",currentUserId);
				
				

				stream = response.getOutputStream();
				JasperPrint print = JasperFillManager.fillReport(jasperreport,
						parameters,AbstractConnectionFactory.getConnection());
				JRXlsExporter exporter = new JRXlsExporter();
				File outputFile = new File(
						request.getRealPath("Reports/AdvanceSalaryConsolidateReport.xls"));
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
						request.getRealPath("Reports/AdvanceSalaryConsolidateReport.xls"));
				response.setContentType("application/octet-stream");
				response.addHeader("Content-Disposition",
						"attachment; filename=AdvanceSalaryConsolidateReport.xls");
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
				+ " Control in AdminMonthReportAction : downloadAdvanceSalaryConsolidateManager Ending");

		return null;

	}

	
	
	
}