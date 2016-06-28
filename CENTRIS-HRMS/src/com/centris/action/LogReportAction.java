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
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.POJO.GroupLogReportPojo;
import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.VO.EmployeeVO;
import com.centris.VO.GroupLogReportVo;
import com.centris.VO.LogReportVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.ProjectMasterVo;
import com.centris.delegate.AddDesignationBD;
import com.centris.delegate.ConsolidateDetailedMonthReportBD;
import com.centris.delegate.DepartmentMasterBD;
import com.centris.delegate.LogReportBD;
import com.centris.delegate.ManagerMasterBD;
import com.centris.delegate.MonthReportBD;
import com.centris.delegate.ProjectMasterDelegate;
import com.centris.delegate.TimeSheetReportBD;
import com.centris.exception.AITrackerException;
import com.centris.form.ConsolidateDetailedMonthReportForm;
import com.centris.form.LogReportForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class LogReportAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(LogReportAction.class);

	public synchronized ActionForward getLogReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction: Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {
			LogReportForm logReportForm = (LogReportForm) form;
			
			request.setAttribute("DEPARTMENT_LIST",new DepartmentMasterBD().getDepartmentRecordsBD());
			List<LogReportVO> logReportVOList = new LogReportBD().getLogReport(logReportForm);
			request.setAttribute("logList", logReportVOList);
			
			String empArray=null;
			
			for(int i=0;i<logReportForm.getEmployee().length;i++){
				
				if(empArray==null){
					
					empArray=logReportForm.getEmployee()[i];
				}else{
					
					empArray=empArray+","+logReportForm.getEmployee()[i];
					
				}
			}
			request.setAttribute("empId", empArray);
			request.setAttribute("currentSearch", logReportForm);

		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction: Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.ADMIN_LOG_REPORT;
		} else {
			forward = Director.DIRECTOR_LOG_REPORT;
		}
		return mapping.findForward(forward);
	}

	public  ActionForward getEmpDetailsByLocation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction: Starting");
		try {
			LogReportForm logReportForm = (LogReportForm) form;
			List<EmployeeVO> employeeVOList = new LogReportBD()
					.getEmpDetailsByLocation(logReportForm);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("empList", employeeVOList);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction: Ending");
		return null;
	}

	public synchronized ActionForward downloadLog(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction:downloadLog Starting");
		try {
			LogReportForm logReportForm = (LogReportForm) form;
			
			String[] empId=request.getParameter("employee").split(",");
				logReportForm.setEmployee(empId);
			
			String sourceFileName = request
					.getRealPath("Reports/LogReportPDF.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			List<LogReportVO> dataList = new LogReportBD().getLogReport(logReportForm);
			
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					dataList);
			String imageFilePath = getServlet().getServletContext()
					.getRealPath("") + "\\images\\teleLogo.png";
			Map parameters = new HashMap();
			parameters.put("TeleIndiaImage", imageFilePath);

			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanColDataSource);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "LogReport-" + logReportForm.getStartDate() + "-"
					+ logReportForm.getStartDate() + ".pdf\"");
			ServletOutputStream outstream = response.getOutputStream();
			outstream.write(bytes, 0, bytes.length);

		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction:downloadLog Ending");
		return null;
	}

	public synchronized ActionForward getGroupLogReportDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction : getGroupLogReportDetails Starting");

		GroupLogReportPojo pojoObj = new GroupLogReportPojo();
		pojoObj.setEmployeeName(request.getParameter("employee"));
		pojoObj.setGroupName(request.getParameter("group"));
		pojoObj.setLocationName(request.getParameter("location"));
		pojoObj.setDesignation(request.getParameter("designation"));
		pojoObj.setMonthName(request.getParameter("month"));
		pojoObj.setYearName(request.getParameter("year"));
		request.setAttribute("currentSearch", pojoObj);

		Map<String, Map<String, List<GroupLogReportVo>>> groupLogReportList = new LogReportBD()
				.getGroupLogReportDetails(pojoObj);

		request.setAttribute("groupLogReportList", groupLogReportList);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction : getGroupLogReportDetails Ending");

		return mapping.findForward("groupLogReportListDetails");
	}

	public synchronized ActionForward getLogDetailsForThisDate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction : getLogDetailsForThisDate Starting");

		GroupLogReportPojo pojoObj = new GroupLogReportPojo();
		pojoObj.setEmployeeName(request.getParameter("employee").trim());
		pojoObj.setGroupName(request.getParameter("group").trim());
		pojoObj.setLocationName(request.getParameter("location").trim());
		pojoObj.setDesignation(request.getParameter("designation").trim());
		pojoObj.setMonthName(request.getParameter("month").trim());
		pojoObj.setYearName(request.getParameter("year").trim());
		pojoObj.setSelectedDate(request.getParameter("selectedLocationDate").trim());
		pojoObj.setSelectedLocation(request
				.getParameter("selectedLocationCode").trim());
		request.setAttribute("currentSearch", pojoObj);

		
		List<GroupLogReportVo> selectedDateDetails = new ArrayList<GroupLogReportVo>();
		selectedDateDetails = new LogReportBD()
				.getLogDetailsForThisDate(pojoObj);

		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("selectedDateLogReportList", selectedDateDetails);
		response.getWriter().print(jsonObject);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction : getLogDetailsForThisDate Ending");

		return null;
	}
	
	public ActionForward getManagers(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction : getManagers Starting");
		try {

			String departmentid = request.getParameter("departmentid");

			String[] departmentid_array = departmentid.split(",");
			String userType=HelperClass.getCurrentUserIDType(request);
 			String dirctorCode=HelperClass.getCurrentUserID(request);

			ArrayList<ManagerFilterVO> managerlist = new LogReportBD().getManagersByDepartment(departmentid_array,userType,dirctorCode);

			JSONObject object = new JSONObject();
			object.put("managerlist", managerlist);

			response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction : getManagers Ending");

		return null;

	}
	

	
	public ActionForward getEmployees(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction : getEmployees Starting");

		try {

			String managerid = request.getParameter("managerid");
			
			String departmentid = request.getParameter("departmentid");

			String[] managerid_array = managerid.split(",");
			
			String[] departmentid_array = departmentid.split(",");

			ArrayList<EmployeeVO> employeelist = new LogReportBD()
					.getEmployees(managerid, departmentid_array);

			JSONObject object = new JSONObject();
			object.put("employeeList", employeelist);

			response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction : getEmployees Ending");

		return null;

	}
	
	public synchronized ActionForward downloadLogExl(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction: downloadLogExl Starting");

		try {

			String sourceFileName = request
					.getRealPath("Reports/ManagerLogReportXLS.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);

			List<LogReportVO> dataList = (List<LogReportVO>) request
					.getSession(false).getAttribute("logList");
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					dataList);

			Map parameters = new HashMap();

			ServletOutputStream stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);

			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/LogReport.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "Log Report" };
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

			File pdfxls = new File(request.getRealPath("Reports/LogReport.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=LogReport.xls");
			response.setContentLength((int) pdfxls.length());
			FileInputStream input = new FileInputStream(pdfxls);
			BufferedInputStream buf = new BufferedInputStream(input);
			int readBytes = 0;
			stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LogReportAction : downloadLogExl Ending");
		return null;
	}
	
	

}