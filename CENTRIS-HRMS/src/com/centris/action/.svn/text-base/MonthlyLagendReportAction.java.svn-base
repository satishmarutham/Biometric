package com.centris.action;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;

import com.centris.VO.MonthlyLagendReportVo;
import com.centris.delegate.MonthlyLagendReportBD;
import com.centris.form.MonthlyLagendReportForm;
import com.centris.util.MonthlyLegendReportExcelFile;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class MonthlyLagendReportAction extends DispatchAction {

	// ArrayList<MonthlyLagendReportVo> location getLocationbyGroup
	private static Logger logger = Logger
			.getLogger(MonthlyLagendReportAction.class);

	public ActionForward getLocationbyGroup(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportAction : getLocationbyGroup : Starting");

		try {

			String groupid = (String) request.getParameter("groupid");

			System.out.println(groupid);

			ArrayList<MonthlyLagendReportVo> locationlist = new MonthlyLagendReportBD()
					.getLocationbyGroup(groupid);

			JSONObject object = new JSONObject();
			object.accumulate("locationlist", locationlist);
			response.getWriter().print(object);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportAction : getLocationbyGroup: Ending");
		return null;
	}

	public ActionForward getShiftAndDept(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportAction : getShiftAndDept : Starting");

		try {

			String location = (String) request.getParameter("locationid");
			String groupid = (String) request.getParameter("groupid");

			ArrayList<MonthlyLagendReportVo> shiftlist = new MonthlyLagendReportBD()
					.getShiftBasedLocation(location, groupid);
			ArrayList<MonthlyLagendReportVo> deptlist = new MonthlyLagendReportBD()
					.getDeptBasedLocation();

			JSONObject object = new JSONObject();
			object.accumulate("shiftlist", shiftlist);
			object.accumulate("deptlist", deptlist);
			response.getWriter().print(object);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportAction : getShiftAndDept: Ending");

		return null;
	}

	public synchronized ActionForward internal(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportAction : internal : Starting");

		try {

			MonthlyLagendReportForm mform = (MonthlyLagendReportForm) form;

			ArrayList<MonthlyLagendReportVo> monthreportlist = new MonthlyLagendReportBD()
					.internalMonthlyLagendReport(mform);

			request.setAttribute("currentSearch", mform);

			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DATE, 1);
			cal.set(Calendar.MONTH, Integer.parseInt(mform.getMonth()));
			cal.set(Calendar.YEAR, Integer.parseInt(mform.getYear()));
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
			int days = cal.get(Calendar.DATE);
			java.util.Date d = new java.util.Date(cal.getTimeInMillis());

			if (monthreportlist
					.get(0)
					.getErrormsg()
					.equals(MessageConstants.MONTHLY_LEGEND_ATTENDANCE_NOT_EXIST_MSG)) {

				request.setAttribute(
						"message",
						MessageConstants.MONTHLY_LEGEND_ATTENDANCE_NOT_EXIST_MSG);
				request.setAttribute("year", mform.getYear());
				request.setAttribute("month",
						new SimpleDateFormat("MMMM").format(d));
			} else {

				String filePath = getServlet().getServletContext().getRealPath(
						"")
						+ "\\MonthReports\\MonthReport.xls";

				HttpSession session = request.getSession(false);
				request.setAttribute("days", days);
				session.setAttribute("year1", mform.getYear());
				System.out.println();
				session.setAttribute("month1",
						new SimpleDateFormat("MMMM").format(d));

				request.setAttribute("internalmonthreportlist", monthreportlist);
				request.setAttribute("year", mform.getYear());
				request.setAttribute("month",
						new SimpleDateFormat("MMMM").format(d));

				MonthlyLegendReportExcelFile excelfile = new MonthlyLegendReportExcelFile();
				excelfile.download(monthreportlist, days, filePath);

			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportAction : internal: Ending");

		return mapping.findForward(MessageConstants.MOONTHLY_LEGEND_REPORT);
	}

	/*
	 * public ActionForward external(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws
	 * Exception {
	 * 
	 * System.out.println("external");
	 * 
	 * 
	 * MonthlyLagendReportForm mform=(MonthlyLagendReportForm)form;
	 * 
	 * System.out.println(mform.getGroup());
	 * System.out.println(mform.getEmpLocation());
	 * System.out.println(mform.getShiftid());
	 * System.out.println(mform.getDepartment());
	 * System.out.println(mform.getYear());
	 * System.out.println(mform.getMonth()); ArrayList<MonthlyLagendReportVo>
	 * monthreportlist=new
	 * MonthlyLagendReportBD().externalMonthlyLagendReport(mform);
	 * 
	 * if(monthreportlist.size()==0){
	 * 
	 * request.setAttribute("message", MessageConstants.MONTHLY_LEGEND_MSG);
	 * 
	 * }
	 * 
	 * Calendar cal = Calendar.getInstance(); cal.set(Calendar.DATE, 1);
	 * cal.set(Calendar.MONTH, Integer.parseInt(mform.getMonth()));
	 * cal.set(Calendar.YEAR, Integer.parseInt(mform.getYear()));
	 * cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1); int days =
	 * cal.get(Calendar.DATE); java.util.Date d = new
	 * java.util.Date(cal.getTimeInMillis());
	 * 
	 * 
	 * String filePath = getServlet().getServletContext().getRealPath("") +
	 * "\\MonthReports\\MonthReport.xls";
	 * 
	 * 
	 * HttpSession session=request.getSession(false);
	 * request.setAttribute("days", days); session.setAttribute("year1",
	 * mform.getMonth()); session.setAttribute("month1", new
	 * SimpleDateFormat("MMMM").format(d));
	 * request.setAttribute("externalmonthreportlist", monthreportlist);
	 * request.setAttribute("year", mform.getYear());
	 * request.setAttribute("month", new SimpleDateFormat("MMMM").format(d));
	 * MonthlyLegendReportExcelFile excelfile=new
	 * MonthlyLegendReportExcelFile(); excelfile.download(monthreportlist, days,
	 * filePath); return
	 * mapping.findForward(MessageConstants.MOONTHLY_LEGEND_REPORT); }
	 */
	public synchronized ActionForward InternalDownload(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportAction : InternalDownload : Starting");

		try {

			String filePath = getServlet().getServletContext().getRealPath("")
					+ "\\MonthReports\\MonthReport.xls";
			ServletOutputStream out = response.getOutputStream();
			FileInputStream in = new FileInputStream(filePath);
			HttpSession ses = request.getSession(false);
			String year1 = (String) ses.getAttribute("year1");
			String month1 = (String) ses.getAttribute("month1");
			response.setContentType("application/vnd.ms-excel");
			response.addHeader("content-disposition", "attachment; filename="
					+ "MonthReport_" + year1 + "_" + month1 + ".xls");

			int octet;
			while ((octet = in.read()) != -1)
				out.write(octet);

			in.close();
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in MonthlyLagendReportAction : InternalDownload: Ending");

		return mapping.findForward(MessageConstants.MOONTHLY_LEGEND_REPORT);
	}

	public synchronized ActionForward ExternalDownload(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		System.out
				.println(" ********    ExternalDownload       ********************* ");

		String filePath = getServlet().getServletContext().getRealPath("")
				+ "\\MonthReports\\MonthReport.xls";
		ServletOutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(filePath);
		HttpSession ses = request.getSession(false);
		String year1 = (String) ses.getAttribute("year1");
		String month1 = (String) ses.getAttribute("month1");
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("content-disposition", "attachment; filename="
				+ "MonthReport_" + year1 + "_" + month1 + ".xls");

		int octet;
		while ((octet = in.read()) != -1)
			out.write(octet);

		in.close();
		out.close();

		return mapping.findForward(MessageConstants.MOONTHLY_LEGEND_REPORT);
	}

}
