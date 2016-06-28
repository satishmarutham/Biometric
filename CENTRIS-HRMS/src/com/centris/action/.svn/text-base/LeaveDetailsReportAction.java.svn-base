package com.centris.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
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
import com.centris.POJO.DepartMentReportPojo;
import com.centris.POJO.DesignationReportPojo;
import com.centris.POJO.EmployeeReportPojo;
import com.centris.POJO.ManagerReportPojo;
import com.centris.POJO.ProjectReportPojo;
import com.centris.VO.DepartmentFilterVO;
import com.centris.VO.LeaveDetailsReportVo;
import com.centris.delegate.LeaveDetailsReportBd;
import com.centris.delegate.TimesheetReconciliationBD;
import com.centris.exception.AITrackerException;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class LeaveDetailsReportAction extends DispatchAction {

	private static Logger logger = Logger.getLogger(LeaveDetailsReportAction.class);
	
	static ResourceBundle res = ResourceBundle.getBundle("com/centris/properties/CENTRIS-HRMS");
	private static String ClientName = res.getString("ClientName");
	private static String ClientAddress_l1 = res.getString("ClientAddress_Line_1");
	private static String ClientAddress_l2 = res.getString("ClientAddress_Line_2");

	// get employees
	public ActionForward getEmployees(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveDetailsReportAction : getEmployees Starting");

		try {

			String manager = request.getParameter("manager");
			String project = request.getParameter("project");
			String department = request.getParameter("department");
			String designation = request.getParameter("designation");

			String[] mgr_array = manager.split(",");
			String[] pjt_array = project.split(",");
			String[] dep_array = department.split(",");
			String[] des_array = designation.split(",");

			ArrayList<ManagerReportPojo> mgr_list = new ArrayList<ManagerReportPojo>();

			for (int i = 0; i < mgr_array.length; i++) {

				ManagerReportPojo mgr_pojo = new ManagerReportPojo();
				mgr_pojo.setMgr_id(mgr_array[i]);
				mgr_list.add(mgr_pojo);

			}

			ArrayList<ProjectReportPojo> pjt_list = new ArrayList<ProjectReportPojo>();

			for (int i = 0; i < pjt_array.length; i++) {

				ProjectReportPojo pjt_pojo = new ProjectReportPojo();
				pjt_pojo.setProjectid(pjt_array[i]);

				pjt_list.add(pjt_pojo);

			}

			ArrayList<DepartMentReportPojo> dept_list = new ArrayList<DepartMentReportPojo>();

			for (int i = 0; i < dep_array.length; i++) {

				DepartMentReportPojo dept_pojo = new DepartMentReportPojo();
				dept_pojo.setDeptid(dep_array[i]);
				dept_list.add(dept_pojo);

			}

			ArrayList<DesignationReportPojo> des_list = new ArrayList<DesignationReportPojo>();

			for (int i = 0; i < des_array.length; i++) {

				DesignationReportPojo des_pojo = new DesignationReportPojo();
				des_pojo.setDesig_id(des_array[i]);
				;
				des_list.add(des_pojo);

			}

			ArrayList<EmployeeReportPojo> emp_list = new LeaveDetailsReportBd()
					.getEmployees(mgr_list, pjt_list, dept_list, des_list);

			JSONObject object = new JSONObject();
			object.put("EMPLOYEELIST", emp_list);

			response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveDetailsReportAction : getEmployees Ending");

		return null;

	}

	// get leave details
	public ActionForward Submit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveDetailsReportAction : Submit Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {


			String[] empoyeeArray=request.getParameterValues("employee");
			String[] departmentarray=request.getParameterValues("department");
			String[] managerarray=request.getParameterValues("manager");
			
			
			System.out.println("empoyeeArray ::: "+empoyeeArray.length);

			ArrayList<LeaveDetailsReportVo> leavedetails_list = new LeaveDetailsReportBd()
					.getLeaveDetails(empoyeeArray);

			ArrayList< DepartmentFilterVO > deptlist = new TimesheetReconciliationBD().getAllDepartments();
	    	request.setAttribute("AllDepartments", deptlist); 

			request.setAttribute("LEAVE_LIST", leavedetails_list);
			
			
			String empId=null;
			
			for(int i=0;i<empoyeeArray.length;i++){
				
				if(empId==null){
					
					empId=empoyeeArray[i];
				}else{
					
					empId=empId+","+empoyeeArray[i];
					
				}
			}
			
			String depId=null;
						
						for(int i=0;i<departmentarray.length;i++){
							
							if(depId==null){
								
								depId=departmentarray[i];
							}else{
								
								depId=depId+","+departmentarray[i];
								
							}
						}
			
			
				String mgrId=null;
							
							for(int i=0;i<managerarray.length;i++){
								
								if(mgrId==null){
									
									mgrId=managerarray[i];
								}else{
									
									mgrId=mgrId+","+managerarray[i];
									
								}
							}
							
							request.setAttribute("hEmpId", empId);
							request.setAttribute("hDepId", depId);
							request.setAttribute("hMgrId", mgrId);
			
			
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
			exception.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveDetailsReportAction : Submit Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.LEAVE_DETAILS_HOME;
		} else {
			forward = Director.DIRECTOR_LEAVE_DETAILS;
		}
		return mapping.findForward(forward);
	}
	

	
	//downloading leave details Report pdf 
	
	
		public synchronized ActionForward DownloadPdf(
				ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws AITrackerException, Exception {
			System.out.println("adminDayReportList  Action");
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in LeaveDetailsReportAction : DownloadPdf Starting");

			try {
				System.out.println("------------------------------------------------------------------");
				System.out.println("Control in LeaveDetailsReportAction : DownloadPdf Starting");
				
				ServletOutputStream stream = null;
				String sourceFileName = request.getRealPath("Reports/LeaveDetailsReportPdf.jrxml");
				JasperDesign design = JRXmlLoader.load(sourceFileName);
				JasperReport jasperreport = JasperCompileManager.compileReport(design);
				
				String empoyee=request.getParameter("employee");
				
				String[] emp_array=empoyee.split(",");
				
				
			/*	String[] departmentarray=request.getParameterValues("department");
				String[] managerarray=request.getParameterValues("manager");*/
				
				ArrayList<LeaveDetailsReportVo> leavedetails_list = new LeaveDetailsReportBd().getLeaveDetails(emp_array);

				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(leavedetails_list);
				String imageFilePath = getServlet().getServletContext().getRealPath("") + "\\images\\centris.png";

				Map parameters = new HashMap();
				parameters.put("image", imageFilePath);
				parameters.put("ClientName", ClientName);
				parameters.put("Address1", ClientAddress_l1);
				parameters.put("Address2", ClientAddress_l2);
				
				stream = response.getOutputStream();
				
				byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,parameters, beanColDataSource);
				response.setContentType("application/pdf");
				response.setContentLength(bytes.length);
				response.setHeader("Content-Disposition", "outline; filename=\""
						+ "LeaveDetailsReport.pdf\"");
				stream.write(bytes, 0, bytes.length);

			
				System.out.println("Control in LeaveDetailsReportAction : DownloadPdf Ending");
				System.out.println("------------------------------------------------------------------");
				
			} catch (Exception exception) {
				logger.error(exception.getMessage(), exception);
				exception.printStackTrace();
			}
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in LeaveDetailsReportAction : DownloadPdf Ending");

			return null;

		}

		public synchronized ActionForward DownloadExcel(
				ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws AITrackerException, Exception {

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in LeaveDetailsReportAction : DownloadExcel Starting");

			try {
				File pdfxls = null;
				FileInputStream input = null;
				BufferedInputStream buf = null;
				ServletOutputStream stream = null;

				String sourceFileName = request.getRealPath("Reports/LeaveDetailsReportExcel.jrxml");
				JasperDesign design = JRXmlLoader.load(sourceFileName);
				JasperReport jasperreport = JasperCompileManager.compileReport(design);
				
				String employee = request.getParameter("employee");
				
				String[] empoyeeArray=employee.split(",");
		
				
				ArrayList<LeaveDetailsReportVo> leavedetails_list = new LeaveDetailsReportBd().getLeaveDetails(empoyeeArray);

				JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(leavedetails_list);

				Map parameters = new HashMap();

				stream = response.getOutputStream();
				JasperPrint print = JasperFillManager.fillReport(jasperreport,
						parameters, beanColDataSource);
				JRXlsExporter exporter = new JRXlsExporter();
				File outputFile = new File(
						request.getRealPath("Reports/LeaveDetaislReport.xls"));
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

				pdfxls = new File(request.getRealPath("Reports/LeaveDetaislReport.xls"));
				response.setContentType("application/octet-stream");
				response.addHeader("Content-Disposition",
						"attachment; filename=LeaveDetaislReport.xls");
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
					+ " Control in LeaveDetailsReportAction : DownloadExcel Ending");

			return null;

		}



}