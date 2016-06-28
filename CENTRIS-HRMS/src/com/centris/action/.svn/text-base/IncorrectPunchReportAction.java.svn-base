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

import com.centris.VO.ConsolidateDetailedMonthReportVO;
import com.centris.VO.IncorrectPunchReportVO;
import com.centris.delegate.IncorrectPunchReportBD;
import com.centris.exception.AITrackerException;
import com.centris.form.IncorrectPunchReportForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class IncorrectPunchReportAction extends DispatchAction {
	private static Logger logger = Logger
			.getLogger(IncorrectPunchReportAction.class);

	public synchronized ActionForward getIncorrectPunchReport(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in IncorrectPunchReportAction:getIncorrectPunchReport Starting");

		try {

			IncorrectPunchReportForm incorrectPunchReportForm = (IncorrectPunchReportForm) form;
			incorrectPunchReportForm.setLocation(request
					.getParameter("location"));
			request.setAttribute("incorrectPunchReportForm",
					incorrectPunchReportForm);
			List<IncorrectPunchReportVO> incorrectPunchReportVO = new IncorrectPunchReportBD()
					.getIncorrectPunchReport(incorrectPunchReportForm);
			request.setAttribute("incorrectPunchList", incorrectPunchReportVO);

		}

		catch (Exception exception) {
			logger.error(exception);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in IncorrectPunchReportAction:getIncorrectPunchReport Ending");

		return mapping.findForward("incorrectPunchReport");

	}

	public synchronized ActionForward downloadIncorrectPunchReport(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in IncorrectPunchReportAction:downloadIncorrectPunchReport Starting");

		try {

			IncorrectPunchReportForm incorrectPunchReportForm = (IncorrectPunchReportForm) form;

			String fullDate = incorrectPunchReportForm.getStartDate() + " - "
					+ incorrectPunchReportForm.getEndDate();

			String sourceFileName = request
					.getRealPath("Reports/IncorrectReport.jrxml");
			JasperDesign design = JRXmlLoader.load(sourceFileName);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			List<IncorrectPunchReportVO> incorrectPunchReportVO = new IncorrectPunchReportBD()
					.getIncorrectPunchReport(incorrectPunchReportForm);
			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(
					incorrectPunchReportVO);
			String imageFilePath = getServlet().getServletContext()
					.getRealPath("") + "\\images\\IdeaLogo.png";
			Map parameters = new HashMap();
			parameters.put("ideaImage", imageFilePath);

			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					parameters, beanColDataSource);
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "IncorrectPunchRport " + fullDate + ".pdf\"");
			ServletOutputStream outstream = response.getOutputStream();
			outstream.write(bytes, 0, bytes.length);
			

		}

		catch (Exception exception) {
			exception.printStackTrace();
			logger.error(exception);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in IncorrectPunchReportAction:downloadIncorrectPunchReport Ending");

		return null;

	}

	public  ActionForward getEmpDetailsByShiftWithMultipleLocation(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in IncorrectPunchReportAction:getEmpDetailsByShiftWithMultipleLocation Starting");

		String shift = request.getParameter("shift");
		String location = request.getParameter("location");
		String group = request.getParameter("group");

		List<ConsolidateDetailedMonthReportVO> empList = new IncorrectPunchReportBD()
				.getEmpDetailsByShiftWithMultipleLocation(shift, group,
						location);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("empList", empList);
		System.out.println("In IncorrectPunchReportAction" + jsonObject);
		response.getWriter().print(jsonObject);

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in IncorrectPunchReportAction:getEmpDetailsByShiftWithMultipleLocation Ending");
		return null;
	}

}
