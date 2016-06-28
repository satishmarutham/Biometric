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
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.centris.DAO.DBService;
import com.centris.POJO.EmpWorkingLessThan8hrsReportPojo;

import com.centris.delegate.EmpWorkingLessThan8hrsReportBD;
import com.centris.exception.AITrackerException;
import com.centris.form.DayReportForm;
import com.centris.form.EmpWorkingLessThan8hrsReportForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

/**
 * @author sathish
 * 
 */
public class EmpWorkingLessThan8hrsReportAction extends DispatchAction {
	private static Logger logger = Logger
			.getLogger(EmpWorkingLessThan8hrsReportAction.class);

	public synchronized ActionForward getEmpWorkingLessthen8hrsDetails(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpWorkingLessThan8hrsReportAction:getEmpWorkingLessthen8hrsDetails  Starting");

		try {

			EmpWorkingLessThan8hrsReportForm empWorkingLessThan8hrsReportForm = (EmpWorkingLessThan8hrsReportForm) form;
			empWorkingLessThan8hrsReportForm.getEmployee();
			empWorkingLessThan8hrsReportForm.getStartDate();
			empWorkingLessThan8hrsReportForm.getEndDate();
			request.setAttribute("reportsData",
					empWorkingLessThan8hrsReportForm);

			List<EmpWorkingLessThan8hrsReportPojo> lessThen8list = new ArrayList<EmpWorkingLessThan8hrsReportPojo>();

			EmpWorkingLessThan8hrsReportBD lessThen8hrsbd = new EmpWorkingLessThan8hrsReportBD();
			lessThen8list = lessThen8hrsbd
					.getEmpWorkinglessThen8hrs(empWorkingLessThan8hrsReportForm);

			request.setAttribute("workingLessThen8hrsList", lessThen8list);

		} catch (Exception exception) {
			logger.error(exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpWorkingLessThan8hrsReportAction:getEmpWorkingLessthen8hrsDetails  Ending");
		return mapping.findForward("lessthan8hrs");
	}

	public synchronized ActionForward workingLessThen8hrsdownloadPdf(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpWorkingLessThan8hrsReportAction:workingLessThen8hrsdownloadPdf Starting");

		try {

			String employeeId = request.getParameter("employee");

			if (employeeId == null) {
				employeeId = "%%";
			}

			String startDate = HelperClass.convertUIToDatabase(request
					.getParameter("startDate"));
			String endDate = HelperClass.convertUIToDatabase(request
					.getParameter("endDate"));

			String imageFilePath = getServlet().getServletContext()
					.getRealPath("") + "\\images\\IdeaLogo.jpg";

			Map<String, Object> mapData = new HashMap<String, Object>();

			mapData.put("empId", employeeId.trim());
			mapData.put("startDate", startDate.trim());
			mapData.put("endDate", endDate.trim());
			mapData.put("ideaImage", imageFilePath);
			String filepath = request
					.getRealPath("Reports/EmpWorkingLessThen8Hrs.jrxml");

			JasperDesign design = JRXmlLoader.load(filepath);
			JasperReport jasperreport = JasperCompileManager
					.compileReport(design);
			byte[] bytes = JasperRunManager.runReportToPdf(jasperreport,
					mapData, DBService.getConnection());
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			response.setHeader("Content-Disposition", "outline; filename=\""
					+ "WorkingLessThen8Hrs Report" + ".pdf\"");
			ServletOutputStream outstream = response.getOutputStream();
			outstream.write(bytes, 0, bytes.length);
			outstream.flush();
			outstream.close();
		}

		catch (Exception exception) {
			logger.error(exception);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpWorkingLessThan8hrsReportAction:workingLessThen8hrsdownloadPdf  Ending");
		return mapping.findForward("lessthan8hrs");

	}

}
