package com.centris.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.centris.VO.LastThreeAbsentReportVO;
import com.centris.delegate.LastThreeAbsentReportBD;
import com.centris.exception.AITrackerException;
import com.centris.form.LastThreeAbsentReportForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class LastThreeAbsentReportAction extends DispatchAction {
	private static Logger logger = Logger
			.getLogger(LastThreeAbsentReportAction.class);

	public synchronized ActionForward getLastThreeAbsentReport(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LastThreeAbsentReportAction:getLastThreeAbsentReport Starting");

		try {

			LastThreeAbsentReportForm lastThreeAbsentReportForm = (LastThreeAbsentReportForm) form;
			lastThreeAbsentReportForm.setLocation(request.getParameter("location"));
			request.setAttribute("currentSearch",lastThreeAbsentReportForm);
			Map<String,List<LastThreeAbsentReportVO>> lastThreeAbsentReportVOMap = new LastThreeAbsentReportBD().getLastThreeAbsentReport(lastThreeAbsentReportForm);
			request.setAttribute("lastThreeAbsentMap", lastThreeAbsentReportVOMap);

		}

		catch (Exception exception) {
			logger.error(exception);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LastThreeAbsentReportAction:getLastThreeAbsentReport Ending");

		return mapping.findForward("lastThreeAbsentReport");

	}
	

}
