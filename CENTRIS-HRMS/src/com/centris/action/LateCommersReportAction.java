package com.centris.action;

import java.util.ArrayList;
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
import com.centris.POJO.LateCommersReportPojo;
import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.delegate.ConsolidateDetailedMonthReportBD;
import com.centris.delegate.LateCommersReportBD;
import com.centris.form.LateCommersReportForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class LateCommersReportAction extends DispatchAction{
	private static 	Logger logger = Logger.getLogger(LateCommersReportAction.class);
	
	public synchronized ActionForward getLatecommersReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in LateCommersReportAction:getLatecommersReport Starting");
	
		
		try{
		LateCommersReportForm lateCommersReportForm=(LateCommersReportForm)form;
		lateCommersReportForm.getEmployee();
		
		lateCommersReportForm.getStartDate();
		lateCommersReportForm.getEndDate();
		request.setAttribute("lateCommers", lateCommersReportForm);
		List<LateCommersReportPojo> lateCommersList=new ArrayList<LateCommersReportPojo>();
		LateCommersReportBD lateCommersReportBD=new LateCommersReportBD();
		lateCommersList=lateCommersReportBD.getLateCommersReport(lateCommersReportForm);
		request.setAttribute("lateCommersDetailsList",lateCommersList);
		
			
			
		}catch (Exception exception) {
			logger.error(exception);
		exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in LateCommersReportAction:getLatecommersReport Ending");	
		return mapping.findForward("latecommersreport");
	}

	
	public synchronized ActionForward downloadLatecommersReportPdf(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in LateCommersReportAction:downloadLatecommersReportPdf Starting");
	
		
		try{
		LateCommersReportForm lateCommersReportForm=(LateCommersReportForm)form;
		
		String employeeId=lateCommersReportForm.getEmployee();
		if(employeeId==null){
			employeeId="%%";
		}
		String startDate=HelperClass.convertUIToDatabase(lateCommersReportForm.getStartDate());
		String endDate=HelperClass.convertUIToDatabase(lateCommersReportForm.getEndDate());
		String imageFilePath=getServlet().getServletContext().getRealPath("")+ "\\images\\IdeaLogo.jpg";
		
			Map<String, Object>mapdata=new HashMap<String,Object>();
			mapdata.put("empId",employeeId.trim());
			mapdata.put("startDate",startDate.trim());
			mapdata.put("endDate",endDate.trim());
		mapdata.put("ideaImage",imageFilePath);
			String filepath = request.getRealPath("Reports/LateCommersReport.jrxml");
			JasperDesign design = JRXmlLoader.load(filepath);
			JasperReport jasperreport = JasperCompileManager.compileReport(design);
			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,mapdata, DBService.getConnection());
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			response.setHeader("Content-Disposition", "outline; filename=\""+ "LateCommersReport" + ".pdf\"");
			ServletOutputStream outstream = response.getOutputStream();
			outstream.write(bytes, 0, bytes.length);
			
			
		}catch (Exception exception) {
			logger.error(exception);
		exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in LateCommersReportAction:downloadLatecommersReportPdf Ending");	
		return null;
	}
	
	public synchronized ActionForward getEmpDetailsByShift(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in LateCommersReportAction:getEmpDetailsByShift Starting");

		String shift=request.getParameter("shift");
		String location = request.getParameter("location");
		String group=request.getParameter("group");
		
	List<ConsolidateDetailedMonthReportVO> empList =  new LateCommersReportBD().getEmpDetailsByShift(shift,group,location);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("empList",empList);
		System.out.println("In ConsolidateDetailedMonthReportAction"+jsonObject);
		response.getWriter().print(jsonObject);
		
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in LateCommersReportAction:getEmpDetailsByShift Ending");
		return null;
	}
	
	
	
	
	
}
