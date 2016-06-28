package com.centris.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import org.json.JSONArray;
import org.json.JSONObject;
import com.centris.POJO.ApproveTravekBookingPojo;
import com.centris.VO.ApproveTravelBookingVo;
import com.centris.VO.SingleTravelBookingDetailsVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.ApproveTravelBookingBD;
import com.centris.exception.AITrackerException;
import com.centris.form.ApproveTravelBookingForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class ApproveTravelBookingAction extends DispatchAction {
	

	
private static Logger logger = Logger.getLogger(ApproveTravelBookingAction.class);


	public ActionForward getTktBookingDetailsAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingAction :"
				+ " getEmployeeAttendence Starting");
		
		String userType=HelperClass.getCurrentUserIDType(request);
		String forward = null;
		
		try {
			
			
			ApproveTravelBookingBD bookingBd=new ApproveTravelBookingBD();
			
			ApproveTravelBookingForm tktApproveform=(ApproveTravelBookingForm) form;
			String userCode=HelperClass.getCurrentUserID(request);
			
			LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>> map=bookingBd.getTktBookingDetailsBD(tktApproveform,userCode,userType);
			
		   request.setAttribute("ApproveTktBookingMap", map);
		   request.setAttribute("conflictEmployees", bookingBd.getConflictEmployeesBD(tktApproveform.getTodate(),tktApproveform.getFromdate(),userType,userCode));
		   request.setAttribute("todate", tktApproveform.getTodate().trim());
			request.setAttribute("fromdate", tktApproveform.getFromdate().trim());

		} catch (Exception exception) {
			logger.error(exception.getMessage(),exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingAction : getEmployeeAttendence Ending");
		if (userType.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.GET_TRAVEL_BOOKING;
		} else {
			forward = Director.DIRECTOR_TRAVEL_BOOKING;
		}
		return mapping.findForward(forward);
		

	}
	
	public ActionForward getsingleTicketDetailsAction(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingAction :"
				+ " getsingleTicketDetails Starting");
		try {
			
		String bookingCode=request.getParameter("tktBookingCode");
			
			
		SingleTravelBookingDetailsVo vo=new ApproveTravelBookingBD().getsingleTicketDetailsBD(bookingCode);
		
		ArrayList<SingleTravelBookingDetailsVo> list=new ArrayList<SingleTravelBookingDetailsVo>();
		list.add(vo);
			
		   JSONObject object=new JSONObject();
		   object.put("tktVO", list);
		   response.getWriter().print(object);

		} catch (Exception exception) {
			logger.error(exception.getMessage(),exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingAction : getsingleTicketDetails Ending");
		
		return null;

	}
	
	
	public synchronized ActionForward approveSingleTicketAction(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingAction: approveSingleTicket Starting");
		
		try {
			
			String userType=HelperClass.getCurrentUserIDType(request);
			
			String tktBookingCOde=request.getParameter("tktBookingCOde");
			String approvedAmount=request.getParameter("approvedAmount");
			String comments=request.getParameter("comments");
			
			UserDetailVO userDetailVO= (UserDetailVO)request.getSession(false).getAttribute("UserDetails");
			String currentUser=userDetailVO.getUserCode();
			
			ApproveTravekBookingPojo tktBokingPojo=new ApproveTravekBookingPojo();
			
			tktBokingPojo.setApproveTktBookingCode(tktBookingCOde);
			tktBokingPojo.setApprovedamount(approvedAmount);
			tktBokingPojo.setRemarks(comments);
			tktBokingPojo.setApprovedby(currentUser);
			tktBokingPojo.setApprovedbyName(userDetailVO.getUserFirstName());
			tktBokingPojo.setUsertype(userType);
			
			String status=new ApproveTravelBookingBD().approveSingleTicketBD(tktBokingPojo);
			
			JSONObject object=new JSONObject();
			object.put("status", status);
			
			response.getWriter().print(object);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingAction: approveSingleTicket Ending");
		return null;
	}
	
	
	
	public synchronized ActionForward downloadTravelBookingDetails(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingAction : downloadTravelBookingDetails Starting");

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
			 sourceFileName = request.getRealPath("Reports/TktBookingByDirector.jrxml");
			}else{
				 sourceFileName = request.getRealPath("Reports/TktBookingByAdmin.jrxml");
			}
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager.compileReport(design);
			
			ArrayList<ApproveTravelBookingVo> travelList=new ApproveTravelBookingBD().getTktBkngDetailsForDounloadBD(startDate,enddate,usercode,userType);
			
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					travelList);
			
			Map parameters = new HashMap();
			parameters.put("AllowanceDate",startDate);
			parameters.put("endDate", enddate);

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/EmployeeTravelBookingDetails.xls"));
			FileOutputStream fos = new FileOutputStream(outputFile);
			String[] sheetNames = { "EmployeeTravelBookingDetails" };
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
					request.getRealPath("Reports/EmployeeTravelBookingDetails.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=EmployeeTravelBookingDetails.xls");
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
				+ "Control in ApproveTravelBookingAction : downloadTravelBookingDetails Ending");

		return null;

	}
	
	public synchronized ActionForward downloadConflictTravelBookingDetails(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingAction : downloadConflictTravelBookingDetails Starting");

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
				
			 sourceFileName = request.getRealPath("Reports/ConflictTktBookingByDirector.jrxml");
			 
			}else{
				
				 sourceFileName = request.getRealPath("Reports/ConflictTktBookingByAdmin.jrxml");
			}
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager.compileReport(design);
			
			ArrayList<ApproveTravelBookingVo> conflictTktBookingDetails = new ApproveTravelBookingBD().getConflictEmployeesBD(startDate,enddate,userType,usercode);
			
			
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					conflictTktBookingDetails);
			
			Map parameters = new HashMap();
			parameters.put("AllowanceDate",startDate);
			parameters.put("endDate", enddate);

			stream = response.getOutputStream();
			JasperPrint print = JasperFillManager.fillReport(jasperreport,
					parameters, beanColDataSource);
			JRXlsExporter exporter = new JRXlsExporter();
			File outputFile = new File(
					request.getRealPath("Reports/ConflictEmployeeTravelBookingDetails.xls"));
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
					request.getRealPath("Reports/ConflictEmployeeTravelBookingDetails.xls"));
			response.setContentType("application/octet-stream");
			response.addHeader("Content-Disposition",
					"attachment; filename=ConflictEmployeeTravelBookingDetails.xls");
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
				+ " Control in  ApproveTravelBookingAction : downloadConflictTravelBookingDetails Ending");

		return null;

	}
	
	
	public synchronized ActionForward approveAllTravelBookingDetails(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingAction: approveAllTravelBookingDetails Starting");
		
		try {
			
			String userType=HelperClass.getCurrentUserIDType(request);
			
			String tktBookingCOde=request.getParameter("tktBookingCOde");
			String approvedAmount=request.getParameter("approvedAmount");
			String comments=request.getParameter("comments");
			
			UserDetailVO userDetailVO= (UserDetailVO)request.getSession(false).getAttribute("UserDetails");
			String currentUser=userDetailVO.getUserCode();
			
			ApproveTravekBookingPojo tktBokingPojo=new ApproveTravekBookingPojo();
			
			tktBokingPojo.setApproveTktBookingCode(tktBookingCOde);
			tktBokingPojo.setApprovedamount(approvedAmount);
			tktBokingPojo.setRemarks(comments);
			tktBokingPojo.setApprovedby(currentUser);
			tktBokingPojo.setApprovedbyName(userDetailVO.getUserFirstName());
			tktBokingPojo.setUsertype(userType);
			
			String status=new ApproveTravelBookingBD().approveAllTravelBookingDetailsBD(tktBokingPojo);
			
			JSONObject object=new JSONObject();
			object.put("status", status);
			
			response.getWriter().print(object);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingAction: approveAllTravelBookingDetails Ending");
		return null;
	}
	
	
	public synchronized ActionForward rejectSingleTicketAction(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingAction: rejectSingleTicketAction Starting");
		
		try {
			
			String userType=HelperClass.getCurrentUserIDType(request);
			
			String tktBookingCOde=request.getParameter("tktBookingCOde");
			String approvedAmount=request.getParameter("approvedAmount");
			String comments=request.getParameter("comments");
			
			UserDetailVO userDetailVO= (UserDetailVO)request.getSession(false).getAttribute("UserDetails");
			String currentUser=userDetailVO.getUserCode();
			
			ApproveTravekBookingPojo tktBokingPojo=new ApproveTravekBookingPojo();
			
			tktBokingPojo.setApproveTktBookingCode(tktBookingCOde);
			tktBokingPojo.setApprovedamount(approvedAmount);
			tktBokingPojo.setRemarks(comments);
			tktBokingPojo.setApprovedby(currentUser);
			tktBokingPojo.setApprovedbyName(userDetailVO.getUserFirstName());
			tktBokingPojo.setUsertype(userType);
			
			String status=new ApproveTravelBookingBD().rejectSingleTicketBD(tktBokingPojo);
			
			JSONObject object=new JSONObject();
			object.put("status", status);
			
			response.getWriter().print(object);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingAction: rejectSingleTicketAction Ending");
		return null;
	}
	

}
