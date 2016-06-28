package com.centris.action;

import java.util.ArrayList;
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

import com.centris.VO.ManualAttendanceVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.ManualAttendanceBD;
import com.centris.form.ManualAttendanceForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class ManualAttendanceAction extends DispatchAction {

	private static Logger logger = Logger
			.getLogger(ManualAttendanceAction.class);

	public synchronized ActionForward getAttendanceDetails(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManualAttendanceAction : getAttendanceDetails Starting");

		try {
			ManualAttendanceForm formObj = (ManualAttendanceForm) form;

			List<ManualAttendanceVO> attendanceDetails = new ArrayList<ManualAttendanceVO>();

			attendanceDetails = new ManualAttendanceBD()
					.getAttendanceDetails(formObj);

			if (attendanceDetails.size() > 0) {
				request.setAttribute("attendanceDetails", attendanceDetails);
			} else {
				ManualAttendanceVO obj = new ManualAttendanceVO();
				obj.setErrMessage("No Attendance available for this Date");
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
				+ " Control in ManualAttendanceAction : getAttendanceDetails Ending");

		return mapping.findForward("getManualAttendance");
	}

	public  ActionForward updateAttendanceDetails(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManualAttendanceAction : updateAttendanceDetails Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String username = userDetailVO.getUserCode();

			ManualAttendanceForm formObj = (ManualAttendanceForm) form;

			formObj.setGroup(request.getParameter("attGroup").trim());
			formObj.setLocation(request.getParameter("attLocation").trim());
			formObj.setReportDate(request.getParameter("attDate").trim());
			formObj.setUpdatedUser(username);
			formObj.setReportStatus(request
					.getParameterValues("var_EmployeeStatus[]"));
			formObj.setEmployeeId(request
					.getParameterValues("var_EmployeeId[]"));

			int status = new ManualAttendanceBD()
					.updateAttendanceDetails(formObj);

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("jsonResponse", status);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManualAttendanceAction : updateAttendanceDetails Ending");

		return null;
	}
}
