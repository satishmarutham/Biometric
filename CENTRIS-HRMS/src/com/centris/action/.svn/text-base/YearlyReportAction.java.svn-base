/**
 * 
 */
package com.centris.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
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

import com.centris.POJO.DayReportPojo;
import com.centris.POJO.YearlyReportPojo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.DayReportBD;
import com.centris.delegate.YearlyReportBD;
import com.centris.exception.AITrackerException;
import com.centris.form.DayReportForm;
import com.centris.form.YearlyReportForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

/**
 * @author sathish
 *
 */
public class YearlyReportAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(YearlyReportAction.class);

	/**
	 * <p>
	 * This action method is responsible for getting the DayReportDetails.
	 * </p>
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return List of the DayReportDetails in the form DayReportPojo Object.
	 * @throws Exception
	 */
/*
public ActionForward yearlyReportPdfdownload(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in YearlyReport:yearlyReportPdfdownload Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String groupcode = userDetailVO.getGroupCode();
			System.out.println("groupcode"+groupcode);
	
			String employeeId=request.getParameter("employee");
			String startMonth=request.getParameter("startmonth");
			String endMonth=request.getParameter("endmonth");
			String year=request.getParameter("year");
		
		YearlyReportForm yearlyReportForm=(YearlyReportForm)form;
			if(employeeId==null){
				employeeId="%%";
			}
			yearlyReportForm.setEmployee(employeeId.trim());
			yearlyReportForm.setStartmonth(startMonth.trim());
			yearlyReportForm.setEndmonth(endMonth.trim());
			yearlyReportForm.setYear(year.trim());
			yearlyReportForm.setGroup(groupcode);
			String sourceFileName = request.getRealPath("Reports/YearlyReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager.compileReport(design);
			YearlyReportBD reportBD=new YearlyReportBD();
			Map<String,List<YearlyReportPojo>> yearlyReportPojos=reportBD.getYearlyReportDetails(yearlyReportForm);
			List<YearlyReportPojo> yearlyReportPojosList=new ArrayList<YearlyReportPojo>();
	JRBeanCollectionDataSource beanColDataSource=new JRBeanCollectionDataSource(yearlyReportPojosList);
			
			List<YearlyReportPojo> yearlyReportPojos=reportBD.getYearlyReportDetails(yearlyReportForm);
		
JasperPrint jasperPrint=JasperFillManager.fillReport(jasperreport, new HashMap<String, List<YearlyReportPojo>>(),yearlyReportPojosList);
;
			String imageFilePath = getServlet().getServletContext()
					.getRealPath("") + "\\images\\IdeaLogo.png";
			Map parameters = new HashMap();
			
			parameters.put("ideaImage", imageFilePath);

			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,parameters, beanColDataSource);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
		response.setHeader("Content-Disposition", "outline; filename=\""
					+ "YearReportDetails" + ".pdf\"");
			ServletOutputStream outstream = response.getOutputStream();
			outstream.write(bytes, 0, bytes.length);
			outstream.flush();
			outstream.close();
		}

		catch (Exception exception) {
			exception.printStackTrace();
			logger.error(exception);
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  Control in YearlyReport:yearlyReportPdfdownload Ending");
		return mapping.findForward("yearlyReport");

	}
	*/
	public synchronized ActionForward getYearlyReportDetails (ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in YearlyReport:getYearlyReportDetails Starting");

		try {

		
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String groupcode = userDetailVO.getGroupCode();
		
			YearlyReportForm yearlyReportForm=(YearlyReportForm)form;
		

			yearlyReportForm.setGroup(groupcode);
			yearlyReportForm.getLocation();
			yearlyReportForm.getShift();
			yearlyReportForm.getEmployee();
			yearlyReportForm.getStartmonth();
			yearlyReportForm.getEndmonth();
			yearlyReportForm.getYear();
			request.setAttribute("yearlyReportFormList", yearlyReportForm);
		YearlyReportBD reportBD=new YearlyReportBD();
	
		Map<String,List<YearlyReportPojo>> yearlyReportPojos =reportBD.getYearlyReportDetails(yearlyReportForm);
		request.setAttribute("yearlyReportPojos", yearlyReportPojos);
}

		catch (Exception exception) {
			logger.error(exception);
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in  Control in YearlyReport:getYearlyReportDetails Ending");
		return mapping.findForward("yearlyReport");

	}
	
	
	
	
	
	
}
