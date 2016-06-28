/**
 * 
 */
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
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import com.centris.POJO.DayReportPojo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.DayReportBD;
import com.centris.exception.AITrackerException;
import com.centris.form.DayReportForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

/**
 * @author sathish
 * 
 */
public class DayReportAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(DayReportAction.class);

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

	public ActionForward getDayReportDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DayReportAction:getDayReportDetails Starting");

		try {

			DayReportForm dayReportForm = (DayReportForm) form;
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			dayReportForm.setLocation(request.getParameter("location"));

			request.setAttribute("dayReportTest", dayReportForm);
			DayReportBD dayReportBD = new DayReportBD();
			List<DayReportPojo> dayReportPojos = new ArrayList<DayReportPojo>();
			dayReportPojos = dayReportBD.getDayReportDetails(dayReportForm);
			request.setAttribute("dayReportDetails", dayReportPojos);

		}

		catch (Exception exception) {
			logger.error(exception);
		}

		return mapping.findForward("dayReport");

	}

	public synchronized ActionForward dayReportdownloadPdf(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in DayReportAction:getDayReportDetails Starting");

		try {

			DayReportForm dayReportForm = (DayReportForm) form;

			DayReportBD dayReportBD = new DayReportBD();
			System.out.println("Desination in Action:::"
					+ dayReportForm.getDesignation());
			List<DayReportPojo> dayReportPojos = new ArrayList<DayReportPojo>();
			String sourceFileName = request
					.getRealPath("Reports/NewDayReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			dayReportPojos = dayReportBD.getDayReportDetails(dayReportForm);
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					dayReportPojos);
			String imageFilePath = getServlet().getServletContext()
					.getRealPath("") + "\\images\\IdeaLogo.png";
			Map parameters = new HashMap();
			parameters.put("ideaImage", imageFilePath);

			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanColDataSource);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "AttendanceReport - " + dayReportForm.getStartDate()
					+ " to " + dayReportForm.getEndDate() + ".pdf\"");
			ServletOutputStream outstream = response.getOutputStream();
			outstream.write(bytes, 0, bytes.length);

		}

		catch (Exception exception) {
			logger.error(exception);
		}
		return null;

	}
	/*
	 * public synchronized ActionForward
	 * getEmpDetailsByDesiWithMultipleLocation(ActionMapping mapping, ActionForm
	 * form, HttpServletRequest request, HttpServletResponse response) throws
	 * Exception { logger.setLevel(Level.DEBUG); JLogger.log(0,
	 * JDate.getTimeString(new Date()) + MessageConstants.START_POINT);
	 * logger.info(JDate.getTimeString(new Date()) +
	 * " Control in ConsolidateDetailedMonthReportAction:getEmpDetailsByDesiWithMultipleLocation Starting"
	 * );
	 * 
	 * String designation = request.getParameter("designation"); String location
	 * = request.getParameter("location"); String group =
	 * request.getParameter("group");
	 * 
	 * List<ConsolidateDetailedMonthReportVO> empList = new
	 * ConsolidateDetailedMonthReportBD()
	 * .getEmpDetailsByDesiWithMultipleLocation(designation, group, location);
	 * JSONObject jsonObject = new JSONObject(); jsonObject.put("empList",
	 * empList); response.getWriter().print(jsonObject);
	 * 
	 * JLogger.log(0, JDate.getTimeString(new Date()) +
	 * MessageConstants.END_POINT); logger.info(JDate.getTimeString(new Date())
	 * +
	 * " Control in ConsolidateDetailedMonthReportAction:getEmpDetailsByDesiWithMultipleLocation Ending"
	 * ); return null; }
	 */

}
