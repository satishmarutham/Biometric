package com.centris.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
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
import org.json.JSONObject;

import com.centris.VO.DepartmentMasterVO;
import com.centris.VO.GeneratePayrollVo;
import com.centris.VO.PayRollCurrentSearchVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.DepartmentMasterBD;
import com.centris.delegate.GeneratePayrollBD;
import com.centris.form.GeneratePayrollForm;
import com.centris.util.HelperClass;
import com.centris.util.JPropertyReader;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.EmployeePayroll;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class GeneratePayroll extends DispatchAction {

	private static Logger logger = Logger.getLogger(GeneratePayroll.class);

	private static String ClientName = JPropertyReader
			.getProperty("ClientName");
	private static String ClientAddress_l1 = JPropertyReader
			.getProperty("ClientAddress_Line_1");
	private static String ClientAddress_l2 = JPropertyReader
			.getProperty("ClientAddress_Line_2");
	private static String ImageName = JPropertyReader.getProperty("ImageName");

	private static String TeleIndia_Payslip_Dir = JPropertyReader
			.getProperty("TeleIndia_Payslip_Dir");

	public synchronized ActionForward generatePayroll(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GeneratePayroll : generatePayroll: Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String userid = userDetailVO.getUserCode();

			GeneratePayrollForm payrollform = (GeneratePayrollForm) form;
			ArrayList<GeneratePayrollVo> payrollList = new GeneratePayrollBD()
					.getPayroll(payrollform, userid);

			PayRollCurrentSearchVo currentsearch = new PayRollCurrentSearchVo();

			currentsearch.setMonth(payrollform.getMonth().split(",")[0]);
			currentsearch.setYear(payrollform.getYear());
			currentsearch.setMonthName(payrollform.getMonth().split(",")[1]);
			if (payrollform.getDepartment().equalsIgnoreCase("%%")) {
				currentsearch.setDepartment("All");
			} else {
				currentsearch.setDepartment(payrollform.getDepartment());
			}

			request.setAttribute("payRollCurrentSearch", currentsearch);
			request.setAttribute("EmployeePayroll", payrollList);

			List<DepartmentMasterVO> depRecords = new DepartmentMasterBD()
					.getDepartmentRecordsBD();
			request.setAttribute("departmentlist", depRecords);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();

		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GeneratePayroll : generatePayroll: Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = EmployeePayroll.GET_PAYROLL;
		} else {
			forward = Director.DIRECTOR_GET_PAYROLL;
		}
		return mapping.findForward(forward);
	}

	public synchronized ActionForward updatePayroll(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GeneratePayroll : updatePayroll: Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String userid = userDetailVO.getUserCode();

			String empid = request.getParameter("empId");
			String salaryadvance = request.getParameter("salaryadvance");
			String pendingsalary = request.getParameter("pendingsalary");
			String netpay = request.getParameter("empNetSalary");
			String month = request.getParameter("monthName");
			String year = request.getParameter("year");

			String[] emp_array = empid.split(",");
			String[] salaryadvance_array = salaryadvance.split(",");
			String[] pendingsalary_array = pendingsalary.split(",");
			String[] netpay_array = netpay.split(",");

			String status = new GeneratePayrollBD().updateSalarydetails(
					emp_array, salaryadvance_array, pendingsalary_array,
					netpay_array, month, year, userid);

			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GeneratePayroll : updatePayroll: Ending");

		return null;
	}

	public ActionForward getEmployeeSalarydetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GenaratePayroll: getSalarydetails Starting");

		try {

			String month = request.getParameter("month");
			String year = request.getParameter("year");
			String reportType = request.getParameter("reportType");
			String department = request.getParameter("department");

			if (department.equalsIgnoreCase("All")) {

				department = "%%";
			}

			List<GeneratePayrollVo> payrollReportList = new GeneratePayrollBD()
					.getEmpMonthPayrollDetailsDownload(month, year, department);

			if ("pdf".equals(reportType)) {

				String clientImage = request.getRealPath("images/" + ImageName);
				Map parameters = new HashMap();
				parameters.put("ClientName", ClientName);

				if (ClientAddress_l1.equalsIgnoreCase("Nil")) {
					parameters.put("AddressLine1", null);
				} else {
					parameters.put("AddressLine1", ClientAddress_l1);
				}
				if (ClientAddress_l2.equalsIgnoreCase("Nil")) {
					parameters.put("AddressLine2", null);
				} else {
					parameters.put("AddressLine2", ClientAddress_l2);
				}
				parameters.put("Image", clientImage);
				parameters.put("Month", HelperClass.getMonthFullName(month));
				parameters.put("Year", year);

				String sourceFileName = request
						.getRealPath("Reports/emp_payroll_xl.jrxml");

				JasperDesign design = JRXmlLoader.load(sourceFileName);
				JasperReport jasperreport = JasperCompileManager
						.compileReport(design);

				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
						payrollReportList);

				byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
						parameters, beanColDataSource);
				response.setContentType("application/pdf");
				response.setContentLength(bytes.length);
				response.setHeader("Content-Disposition",
						"outline; filename=\"" + "PayrollReport.pdf\"");
				ServletOutputStream outstream = response.getOutputStream();
				outstream.write(bytes, 0, bytes.length);

			} else {

				File pdfxls = null;
				FileInputStream input = null;
				BufferedInputStream buf = null;
				ServletOutputStream stream = null;

				String sourceFileName = request
						.getRealPath("Reports/emp_payroll_excel.jrxml");
				JasperDesign design = JRXmlLoader.load(sourceFileName);
				JasperReport jasperreport = JasperCompileManager
						.compileReport(design);
				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
						payrollReportList);
				Map parameters = new HashMap();

				parameters.put("Month", HelperClass.getMonthFullName(month));
				parameters.put("Year", year);

				stream = response.getOutputStream();
				JasperPrint print = JasperFillManager.fillReport(jasperreport,
						parameters, beanColDataSource);
				JRXlsExporter exporter = new JRXlsExporter();
				File outputFile = new File(
						request.getRealPath("Reports/emp_payroll_excel.xls"));
				FileOutputStream fos = new FileOutputStream(outputFile);
				String[] sheetNames = { "Payroll" };
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, fos);
				exporter.setParameter(
						JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
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
				exporter.setParameter(
						JRXlsExporterParameter.IGNORE_PAGE_MARGINS,
						Boolean.TRUE);
				exporter.setParameter(
						JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN,
						Boolean.FALSE);

				exporter.exportReport();

				pdfxls = new File(
						request.getRealPath("Reports/emp_payroll_excel.xls"));
				response.setContentType("application/octet-stream");
				response.addHeader("Content-Disposition",
						"attachment; filename=PayrollXls.xls");
				response.setContentLength((int) pdfxls.length());
				input = new FileInputStream(pdfxls);
				buf = new BufferedInputStream(input);
				int readBytes = 0;
				stream = response.getOutputStream();
				while ((readBytes = buf.read()) != -1) {
					stream.write(readBytes);
				}
			}

			request.setAttribute("payRollList", payrollReportList);

			PayRollCurrentSearchVo vo = new PayRollCurrentSearchVo();

			vo.setMonth(month);
			vo.setMonthName(HelperClass.getMonthFullName(month));
			vo.setYear(year);

			request.setAttribute("payRollCurrentSearch", vo);

			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in GenaratePayroll:getSalarydetails Ending");
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		}
		return null;
	}

	public ActionForward createPayslipFilter(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GenaratePayroll : createPayslipFilter: Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {

			List<DepartmentMasterVO> deptlist = new DepartmentMasterBD()
					.getDepartmentRecordsBD();
			request.setAttribute("deptlist", deptlist);

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GenaratePayroll : createPayslipFilter: Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "createpayslipfilter";
		} else {
			forward = Director.DIRECTOR_GET_PAYROLL_FILTER;
		}
		return mapping.findForward(forward);
	}
}