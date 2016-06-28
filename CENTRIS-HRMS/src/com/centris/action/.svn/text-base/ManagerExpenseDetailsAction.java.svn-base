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
import net.sf.jasperreports.engine.JasperRunManager;
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

import com.centris.DAO.DBService;
import com.centris.VO.ManagerExpenseDetailsVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.ManagerExpenseDetailsBD;
import com.centris.delegate.TimeSheetReportBD;
import com.centris.exception.AITrackerException;
import com.centris.form.ManagerExpenseDetailsForm;
import com.centris.util.HelperClass;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class ManagerExpenseDetailsAction extends DispatchAction {
	private static Logger logger = Logger
			.getLogger(ManagerExpenseDetailsAction.class);

	public ActionForward getEmployeeExpenseDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsAction : getEmployeeExpenseDetails Starting");
		
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		ManagerExpenseDetailsForm formObj = (ManagerExpenseDetailsForm) form;
		ArrayList<ManagerExpenseDetailsVo> expenseDetails = new ArrayList<ManagerExpenseDetailsVo>();
		ManagerExpenseDetailsBD delegateObj = new ManagerExpenseDetailsBD();
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
				.getAttribute("UserDetails");
		String managerCode = userDetailVO.getUserCode();
		try {
			formObj.setManager(managerCode.trim());
			formObj.setMonth(formObj.getMonth().trim());
			formObj.setYear(formObj.getYear().trim());

			expenseDetails = delegateObj.getexpenseDetails(formObj,usertype);

			if (expenseDetails.size() > 0) {
				request.setAttribute("consolidated_ExpenseDetails",
						expenseDetails);
				request.setAttribute("download", expenseDetails);
			} else {
				request.setAttribute("message",
						"Expense Details is not there for this Month");
			}
			request.setAttribute("sel_year", formObj.getYear().trim());
			request.setAttribute("sel_month", formObj.getMonth().trim());
			request.setAttribute("ACC_YEAR",
					new TimeSheetReportBD().getAccYear());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsAction : getEmployeeExpenseDetails Ending");
		
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			
			forward=StringUtils.ADMIN_EMPLOYEE_EXPENSE_CONSOLIDATED;
			
		}else if(usertype.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
			
			forward=StringUtils.DIRECTOR_EMPLOYEE_EXPENSE_CONSOLIDATED;
			
		}else{
			
			forward=StringUtils.MANAGER_EMPLOYEE_EXPENSE_CONSOLIDATED;
		}
		return mapping.findForward(forward);
		
	}

	public synchronized ActionForward downloadConsolidateExpenseDetails(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsAction : downloadConsolidateExpenseDetails Starting");
		File pdfxls = null;
		FileInputStream input = null;
		BufferedInputStream buf = null;
		ServletOutputStream stream = null;
		String userType=HelperClass.getCurrentUserIDType(request);
		try {

			
			
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String managerCode = userDetailVO.getUserCode();

			String year = request.getParameter("year");
			String month = request.getParameter("month");
			
			
			System.out.println("month"+month);
			System.out.println("year"+year);
			System.out.println("managerCode"+managerCode);
			
			
			String sourceFileName=null;

			if(userType.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)){
			 sourceFileName = request
					.getRealPath("Reports/ManagerExpenseConcolidated.jrxml");
			}else if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				
				 sourceFileName = request
							.getRealPath("Reports/DirectorExpenseConcolidated.jrxml");
			}else{
				
				 sourceFileName = request
							.getRealPath("Reports/AdminExpenseConcolidated.jrxml");
				
			}
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			String imageFilePath = getServlet().getServletContext()
					.getRealPath("") + "\\images\\IdeaLogo.png";

			Map parameters = new HashMap();
			parameters.put("managerCode", managerCode.trim());
			parameters.put("month", month.trim());
			parameters.put("year", year.trim());

			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, DBService.getConnection());

			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/Employee_Daily_Allowance.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "ExpenseDetails " + month + " - " + year };
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
					request.getRealPath("Reports/Employee_Daily_Allowance.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition", "attachment; filename=\""
					+ "ExpenseDetails - " + month + " - " + year + ".xls\"");

			response.setContentLength((int) pdfxls.length());
			input = new FileInputStream(pdfxls);
			buf = new BufferedInputStream(input);
			int readBytes = 0;
			stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}

		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsAction : downloadConsolidateExpenseDetails Ending");
		return null;
	}

	public synchronized ActionForward downloadDetailedExpenseDetails(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsAction : downloadDetailedExpenseDetails Starting");
		
		String userType=HelperClass.getCurrentUserIDType(request);
		String 	sourceFileName="";
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String managerCode = userDetailVO.getUserCode();
			
			String imageFilePath = getServlet().getServletContext()
					.getRealPath("") + "\\images\\centris.png";
			String year = request.getParameter("year");
			String month = request.getParameter("month");
			String empDetails = request.getParameter("empid");
			
			String[] emp_Details=empDetails.split(",");
		
			if(managerCode.trim().substring(0, 3).equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)){
				
				sourceFileName= request
						.getRealPath("Reports/ExpenseDetailsApproveByAdmin.jrxml");
				
				JasperDesign design = JRXmlLoader.load(sourceFileName);
				JasperReport jasperreport = JasperCompileManager
						.compileReport(design);
				Map parameters = new HashMap();
				parameters.put("managerCode", emp_Details[1].trim());
				parameters.put("month", month.trim());
				parameters
						.put("monthn", HelperClass.getMonthFullName(month.trim()));
				parameters.put("year", year.trim());
				parameters.put("empCode", emp_Details[0].trim());
				parameters.put("LOGO_DIR", imageFilePath);

				byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
						parameters, DBService.getConnection());
				response.setContentType("application/pdf");
				response.setContentLength(bytes.length);
				response.setHeader("Content-Disposition", "outline; filename=\""
						+ "ExpenseDetails - " + emp_Details[0].trim() + ".pdf\"");
				ServletOutputStream outstream = response.getOutputStream();
				outstream.write(bytes, 0, bytes.length);
				
				
			}else{
				
				 	sourceFileName= request
						.getRealPath("Reports/ManagerExpenseDetailed.jrxml");
				 	
				 	JasperDesign design = JRXmlLoader.load(sourceFileName);
					JasperReport jasperreport = JasperCompileManager
							.compileReport(design);
					Map parameters = new HashMap();
					parameters.put("managerCode", emp_Details[1].trim());
					parameters.put("month", month.trim());
					parameters
							.put("monthn", HelperClass.getMonthFullName(month.trim()));
					parameters.put("year", year.trim());
					parameters.put("empCode", emp_Details[0].trim());
					parameters.put("LOGO_DIR", imageFilePath);

					byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
							parameters, DBService.getConnection());
					response.setContentType("application/pdf");
					response.setContentLength(bytes.length);
					response.setHeader("Content-Disposition", "outline; filename=\""
							+ "ExpenseDetails - " + emp_Details[0].trim() + ".pdf\"");
					ServletOutputStream outstream = response.getOutputStream();
					outstream.write(bytes, 0, bytes.length);
			}
			
					
			

		}

		catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsAction : downloadDetailedExpenseDetails Ending");
		return null;

	}

	public ActionForward approveExpenseDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsAction : approveExpenseDetails Starting");

		String empid = request.getParameter("expense_empId").trim();
		String mangId = request.getParameter("expense_MangId").trim();

		String totalApproved = request.getParameter("expense_totApproved")
				.trim();
		String advancepaid = request.getParameter("expense_Advancepaid");

		String balance = request.getParameter("expense_Balance").trim();
		String year = request.getParameter("expense_year").trim();
		String month = request.getParameter("expense_month").trim();
		
		String usertype = HelperClass.getCurrentUserIDType(request);
		
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		

		ManagerExpenseDetailsVo voObj = new ManagerExpenseDetailsVo();

		voObj.setEmp_Id(empid);
		voObj.setEmp_mangCode(mangId);
		voObj.setEmp_year(year);
		voObj.setEmp_month(month);
		voObj.setEmp_advpaid(advancepaid);
		voObj.setEmp_balance(balance);
		voObj.setEmp_totapproved(totalApproved);
		voObj.setUser_Type(usertype);
		voObj.setAcc_code(userDetailVO.getUserCode());
		

		ManagerExpenseDetailsBD delegateObj = new ManagerExpenseDetailsBD();

		String result = delegateObj.approveExpenseDetails(voObj);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("approve_Result", result);
		response.getWriter().print(jsonObject);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsAction : approveExpenseDetails Ending");
		return null;
	}
	
	
	
	public ActionForward approveAllExpenseDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsAction : approveAllExpenseDetails Starting");

		String expenseCode = request.getParameter("expensesCode").trim();
		String totalApproved = request.getParameter("totApprovedAmount").trim();
		String advancepaid = request.getParameter("advancePaid");
		String balance = request.getParameter("balance").trim();
		String month=request.getParameter("expense_month").trim();
		String year=request.getParameter("expense_year").trim();
		
		String usertype = HelperClass.getCurrentUserIDType(request);
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		
		
		ManagerExpenseDetailsVo voObj = new ManagerExpenseDetailsVo();

		voObj.setEmp_advpaid(advancepaid);
		voObj.setEmp_balance(balance);
		voObj.setEmp_totapproved(totalApproved);
		voObj.setUser_Type(usertype);
		voObj.setUsercode(userDetailVO.getUserCode());
		voObj.setEmp_expCode(expenseCode);
		voObj.setEmp_month(month);
		voObj.setEmp_year(year);
		voObj.setUsername(userDetailVO.getUserFirstName());

		ManagerExpenseDetailsBD delegateObj = new ManagerExpenseDetailsBD();

		String result = delegateObj.approveAllExpenseDetailsBD(voObj);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("approve_Result", result);
		response.getWriter().print(jsonObject);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsAction : approveAllExpenseDetails Ending");
		return null;
	}
	
	
	public ActionForward rejectExpenseDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsAction : approveExpenseDetails Starting");

		String empid = request.getParameter("expense_empId").trim();
		String mangId = request.getParameter("expense_MangId").trim();

		String totalApproved = request.getParameter("expense_totApproved").trim();
		String advancepaid = request.getParameter("expense_Advancepaid");

		String balance = request.getParameter("expense_Balance").trim();
		String year = request.getParameter("expense_year").trim();
		String month = request.getParameter("expense_month").trim();
		
		String usertype = HelperClass.getCurrentUserIDType(request);
		
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		

		ManagerExpenseDetailsVo voObj = new ManagerExpenseDetailsVo();

		voObj.setEmp_Id(empid);
		voObj.setEmp_mangCode(mangId);
		voObj.setEmp_year(year);
		voObj.setEmp_month(month);
		voObj.setEmp_advpaid(advancepaid);
		voObj.setEmp_balance(balance);
		voObj.setEmp_totapproved(totalApproved);
		voObj.setUser_Type(usertype);
		voObj.setAcc_code(userDetailVO.getUserCode());
		

		ManagerExpenseDetailsBD delegateObj = new ManagerExpenseDetailsBD();

		String result = delegateObj.rejectExpenseDetails(voObj);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("approve_Result", result);
		response.getWriter().print(jsonObject);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerExpenseDetailsAction : approveExpenseDetails Ending");
		return null;
	}
	
}