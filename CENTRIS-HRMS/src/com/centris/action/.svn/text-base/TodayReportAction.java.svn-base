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
import org.json.JSONObject;

import com.centris.DAO.DBService;
import com.centris.VO.LogReportVO;
import com.centris.VO.TodayReportVO;
import com.centris.delegate.LogReportBD;
import com.centris.delegate.TodayReportBD;
import com.centris.form.TodayReportForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class TodayReportAction extends DispatchAction{
	private static Logger logger = Logger.getLogger(TodayReportAction.class);
	public  ActionForward getEmpDetailsByLocation(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TodayReportAction:getEmpDetailsByLocation Starting");

		String location = request.getParameter("location");
		String group=request.getParameter("group");
		
	List<TodayReportVO> empList =  new TodayReportBD().getEmpDetailsByLocation(group,location);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("empList",empList);
		response.getWriter().print(jsonObject);
		
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TodayReportAction:getEmpDetailsByLocation Ending");
		return null;
	}
	

	public synchronized ActionForward getTodayReport(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TodayReportAction:getTodayReport Starting");

		TodayReportForm todayReportForm = (TodayReportForm)form;
		request.setAttribute("currentSearch",todayReportForm);
	List<TodayReportVO> todayReportList =  new TodayReportBD().getTodayReport(todayReportForm);
	request.setAttribute("todayReportList", todayReportList);
		
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TodayReportAction:getTodayReport Ending");
		return mapping.findForward("todayReport");
	}

	public synchronized ActionForward todayReportPdfdownload(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TodayReportAction:todayReportPdfdownload Starting");

		TodayReportForm todayReportForm = (TodayReportForm)form;
	
		String employeeId=todayReportForm.getEmployee();
		if(employeeId==null){
			employeeId="%%";
			todayReportForm.setEmployee(employeeId);
		}
		String groupId=todayReportForm.getGroup();
		if(groupId==null){
			groupId="%%";
			todayReportForm.setGroup(groupId);
		}
		String locationId=todayReportForm.getLocation();
		if(locationId==null){
			locationId="%%";
		}
		String shiftId=todayReportForm.getShift();
		if(shiftId==null){
			shiftId="%%";
			todayReportForm.setLocation(shiftId);
		}

		
		String imageFilePath=getServlet().getServletContext().getRealPath("")+ "\\images\\IdeaLogo.png";
		Map<String,Object> mapData=new HashMap<String, Object>();
		mapData.put("groupId",groupId.trim());
		mapData.put("locationId",locationId.trim());
		mapData.put("shiftId",shiftId.trim());
		mapData.put("empId",employeeId.trim());
		mapData.put("ideaImage",imageFilePath);
		
		String filepath = request.getRealPath("Reports/TodayReport.jrxml");
	
		JasperDesign design = JRXmlLoader.load(filepath);
		JasperReport jasperreport = JasperCompileManager.compileReport(design);
		List<TodayReportVO> todayReportList =  new TodayReportBD().getTodayReport(todayReportForm);
		JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(todayReportList);
		byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,mapData, beanColDataSource);
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		response.setHeader("Content-Disposition", "outline; filename=\""+ "Today Report" + ".pdf\"");
		ServletOutputStream outstream = response.getOutputStream();
		outstream.write(bytes, 0, bytes.length);
		
		
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TodayReportAction:todayReportPdfdownload Ending");
		return null;
	}

	
	
}
