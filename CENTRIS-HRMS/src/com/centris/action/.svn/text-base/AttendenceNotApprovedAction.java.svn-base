/**
 * 
 */
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
import org.json.JSONObject;

import com.centris.VO.AttendenceNotApprovedVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AttendenceNotApprovedBD;
import com.centris.exception.AITrackerException;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

/**
 * @author Mritunjay
 *
 */
public class AttendenceNotApprovedAction extends DispatchAction {
	
private static Logger logger = Logger.getLogger(AttendenceNotApprovedAction.class);
	
	public ActionForward getAttendanceNotApprovedByManager(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AttendenceNotApprovedAction : getAttendanceNotApprovedByManager Starting");
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String managerCode = userDetailVO.getUserCode();
			 request.setAttribute("EmployeeNotApproved", new AttendenceNotApprovedBD().getAttendanceNotApprovedByManager(managerCode));
		} catch (Exception exception) {
			logger.error(exception.getMessage(),exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AttendenceNotApprovedAction : getAttendanceNotApprovedByManager Ending");
		
		return mapping.findForward("attendanceNotApproved");

	}
	
	public ActionForward getNotApprovedEmployeeCount(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AttendenceNotApprovedAction : getNotApprovedEmployeeCount Starting");
		try {
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String managerCode = userDetailVO.getUserCode(); 
			
			int count=new AttendenceNotApprovedBD().getNotApprovedEmployeeCount(managerCode);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response", count);
			response.getWriter().print(jsonObject);
			
		} catch (Exception exception) {
			logger.error(exception.getMessage(),exception);
			exception.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AttendenceNotApprovedAction : getNotApprovedEmployeeCount Ending");
		
		return null;

	}
	
	
	
	
}
