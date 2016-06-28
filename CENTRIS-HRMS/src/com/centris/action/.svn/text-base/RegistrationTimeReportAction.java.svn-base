package com.centris.action;

import java.text.DateFormatSymbols;
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
import com.centris.VO.RegistrationTimeReportVo;
import com.centris.delegate.RegistrationTimeReportBD;
import com.centris.form.RegistrationTimeReportForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class RegistrationTimeReportAction extends DispatchAction {
	private static Logger logger = Logger
			.getLogger(RegistrationTimeReportAction.class);

	public synchronized ActionForward getRegistrationDetails(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RegistrationTimeReportAction : getRegistrationDetails Starting");

		try {
			RegistrationTimeReportForm formObj = (RegistrationTimeReportForm) form;

			List<RegistrationTimeReportVo> registrationDetails = new RegistrationTimeReportBD()
					.getRegistrationDetails(formObj);
			if (registrationDetails.size() != 0) {
				request.setAttribute("registrationDetails", registrationDetails);
			} else {
				RegistrationTimeReportVo obj = new RegistrationTimeReportVo();
				obj.setMessage("No Registration is done for this Month");
				request.setAttribute("validMessage", obj);
			}
			request.setAttribute("currentSearch", formObj);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RegistrationTimeReportAction : getRegistrationDetails Ending");

		return mapping.findForward("getRegistrationTime");
	}

	public synchronized ActionForward downloadRegistrationDetails(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RegistrationTimeReportAction : downloadRegistrationDetails Starting");

		try {
			RegistrationTimeReportForm formObj = (RegistrationTimeReportForm) form;

			String monthName = new DateFormatSymbols().getMonths()[Integer
					.parseInt(formObj.getMonth()) - 1]
					+ " - "
					+ formObj.getYear();

			String filepath = request.getRealPath("Reports/RegistrationTimeReport.jrxml");
			JasperDesign design = JRXmlLoader.load(filepath);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			List<RegistrationTimeReportVo> registrationDetails = new RegistrationTimeReportBD()
					.getRegistrationDetails(formObj);
			JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(
					registrationDetails);
			String imageFilePath = getServlet().getServletContext()
					.getRealPath("") + "\\images\\IdeaLogo.png";
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("ideaImage", imageFilePath);
			parameters.put("monthName", monthName);
			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanCollectionDataSource);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "Registration Details Report - " + monthName + ".pdf\"");
			ServletOutputStream outstream = response.getOutputStream();
			outstream.write(bytes, 0, bytes.length);
			outstream.flush();
			outstream.close();
			request.setAttribute("currentSearch", formObj);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in RegistrationTimeReportAction : downloadRegistrationDetails Ending");

		return mapping.findForward("getRegistrationTime");
	}
}
