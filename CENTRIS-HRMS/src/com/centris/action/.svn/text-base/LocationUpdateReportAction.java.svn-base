package com.centris.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.centris.VO.LocationUpdateReportVO;
import com.centris.delegate.LocationUpdateReportBD;
import com.centris.form.LocationUpdateReportForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class LocationUpdateReportAction extends DispatchAction{
	private static Logger logger = Logger.getLogger(LocationUpdateReportAction.class);
	public synchronized ActionForward getLocationUpdateReport(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);

		logger.info(JDate.getTimeString(new Date())+ " Control in LocationUpdateReportAction:getLocationUpdateReport Starting");
		try {
			LocationUpdateReportForm locationUpdateReportForm = (LocationUpdateReportForm) form;
			List<LocationUpdateReportVO> locationUpdateReportList = new LocationUpdateReportBD().getLocationUpdateReport(locationUpdateReportForm);
			request.setAttribute("locationUpdateReportList",locationUpdateReportList);
			request.setAttribute("currentSearch",locationUpdateReportForm);
			
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in LocationUpdateReportAction:getLocationUpdateReport Ending");
		return mapping.findForward("locationUpdateReport");
	}

}
