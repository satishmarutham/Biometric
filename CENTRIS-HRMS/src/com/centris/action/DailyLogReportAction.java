package com.centris.action;

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
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.VO.DailyLogReportVO;
import com.centris.VO.TodayReportVO;
import com.centris.delegate.DailyLogReportBD;
import com.centris.delegate.TodayReportBD;
import com.centris.form.DailyLogReportForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class DailyLogReportAction extends DispatchAction{

	private static 	Logger logger = Logger.getLogger(DailyLogReportAction.class);

	public synchronized ActionForward getDailylogReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DailyLogReportAction : getDailylogReport : Starting");
		
		System.out.println("control in DailyLogReportAction: getDailylogReport method START");
		
		try{
			
			
		DailyLogReportForm dailyLogReportform=(DailyLogReportForm)form;
		request.setAttribute("currentSearch",dailyLogReportform);
		List<DailyLogReportVO> dailyLogReportList =  new DailyLogReportBD().getDailyLogReport(dailyLogReportform);
		request.setAttribute("dailyLogReportList", dailyLogReportList);
		
		
		
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error(e);
		}
		 JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in DailyLogReportAction : getDailylogReport  : Ending");
		System.out.println("control in DailyLogReportAction: getDailylogReport method END");
		return mapping.findForward(ApplicationConstants.DAILY_LOG_REPORT);
	}
	public synchronized ActionForward dailyLogReportPdfDownload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DailyLogReportAction : dailyLogReportPdfDownload : Starting");
		
		System.out.println("control in DailyLogReportAction: dailyLogReportPdfDownload method START");
		
		try{
			
		DailyLogReportForm dailyLogReportform=(DailyLogReportForm)form;
		String employeeId=request.getParameter("hemployee");
		
		if(employeeId==null){
			employeeId="%%";
			dailyLogReportform.setEmployee(employeeId);
		}else{
			
			dailyLogReportform.setEmployee(employeeId);
		}
		
		
		String groupId=request.getParameter("hgroup");
		if(groupId==null){
			groupId="%%";
			dailyLogReportform.setGroup(groupId);
		}else{
			
			dailyLogReportform.setGroup(groupId);
		}
		
		
		
		String locationId=request.getParameter("hlocation");
		if(locationId==null){
			locationId="%%";
			dailyLogReportform.setLocation(locationId);
		}else{
			dailyLogReportform.setLocation(locationId);
			
		}
		
		
		String designationID=request.getParameter("hdesignation");
		if(designationID==null){
			designationID="%%";
			dailyLogReportform.setDesignation(designationID);
		}else{
			dailyLogReportform.setDesignation(designationID);
		}
		
		
		
		String startdate=request.getParameter("hstartdate");
		if(startdate==null){
			startdate="%%";
			dailyLogReportform.setStartDate(startdate);
		}else{
			dailyLogReportform.setStartDate(startdate);
			
		}
		
		
		String enddate=request.getParameter("henddate");
		if(enddate==null){
			enddate="%%";
			dailyLogReportform.setEndDate(enddate);
		}else{
			dailyLogReportform.setEndDate(enddate);
		}
		
			
		
		String imageFilePath=getServlet().getServletContext().getRealPath("")+ "\\images\\IdeaLogo.jpg";
		Map<String,Object> mapData=new HashMap<String, Object>();
		mapData.put("ideaImage",imageFilePath);
		
		String filepath = request.getRealPath("Reports/DailyLogReport1.jrxml");
	
		JasperDesign design = JRXmlLoader.load(filepath);
		JasperReport jasperreport = JasperCompileManager.compileReport(design);
		List<DailyLogReportVO> dailyLogReportList = new DailyLogReportBD().getDailyLogReport(dailyLogReportform);
		
		JSONArray array=new JSONArray(dailyLogReportList);
		System.out.println("array"+array);
		
		
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dailyLogReportList);
		byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,mapData, beanColDataSource);
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		response.setHeader("Content-Disposition", "outline; filename=\""+ "Daily Log Report" + ".pdf\"");
		ServletOutputStream outstream = response.getOutputStream();
		outstream.write(bytes, 0, bytes.length);
		
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error(e);
		}
		 JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in DailyLogReportAction : dailyLogReportPdfDownload  : Ending");
		
		return null;
	}
	
	public  ActionForward getEmpDetailsByDesiWithLocation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DailyLogReportAction : getEmpDetailsByDesiWithLocation : Starting");
		
		
		try{
			
		String designation=	request.getParameter("designation");
		String group=request.getParameter("group");
		String location=request.getParameter("location");
		List<DailyLogReportVO> empList =  new DailyLogReportBD().getEmpDetailsByDesiWithLocation(designation,group,location);
		
		JSONObject jsonobject=new JSONObject();
		jsonobject.accumulate("empList", empList);
		response.getWriter().print(jsonobject);
		
		
		
		}
		catch(Exception e){
			e.printStackTrace();
			logger.error(e);
		}
		 JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in DailyLogReportAction : getEmpDetailsByDesiWithLocation  : Ending");
		return null;
	}
	
}
