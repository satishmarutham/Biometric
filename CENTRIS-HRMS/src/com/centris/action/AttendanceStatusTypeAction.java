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

import com.centris.POJO.AttendanceStatusTypePojo;
import com.centris.VO.AttendanceStatusTypeVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AttendanceStatusTypeBD;
import com.centris.form.AttendanceStatusTypeForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class AttendanceStatusTypeAction extends DispatchAction {
	private static Logger logger = Logger
			.getLogger(AttendanceStatusTypeAction.class);

	public ActionForward AddDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeAction : AddDetails Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			AttendanceStatusTypeForm attendanceStatusTypeForm = (AttendanceStatusTypeForm) form;

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String usercode = userDetailVO.getUserCode();

			String successmessage = new AttendanceStatusTypeBD().AddDetails(
					attendanceStatusTypeForm, usercode);
			if (successmessage
					.equalsIgnoreCase(MessageConstants.ADD_SUCECCESS_MESSAGE)) {
				request.setAttribute("successmessage", successmessage);
			} else {
				request.setAttribute("faildmessage", successmessage);
			}

			List<AttendanceStatusTypeVO> attendancestatuslist = new AttendanceStatusTypeBD()
					.getAttendanceStatusDetails();
			request.setAttribute("attendancestatuslist", attendancestatuslist);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeAction : AddDetails Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.ADDTENDANCE_STATUS_TPYE_MESSAGE;
		} else {
			forward = Director.DIRECTOR_ATT_STATUS_TYPE;
		}

		return mapping.findForward(forward);
	}

	public ActionForward deleteAttendanceStatus(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeAction : deleteAttendanceStatus Starting");
		try {
			String[] attendancestatuscode = request
					.getParameterValues("AttendanceCode[]");

			boolean status = new AttendanceStatusTypeBD()
					.deleteAttendanceStatus(attendancestatuscode);
			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeAction : deleteAttendanceStatus Ending");

		return null;
	}

	public ActionForward editAttendanceStatus(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeAction : deleteAttendanceStatus Starting");
		try {
			String attendancecode = request.getParameter("attendancecode");

			List<AttendanceStatusTypeVO> editstatuslist = new AttendanceStatusTypeBD()
					.editAttendanceStatus(attendancecode);
			request.setAttribute("editstatuslist", editstatuslist);

			JSONObject object = new JSONObject();
			object.put("editstatuslist", editstatuslist);

			response.getWriter().print(object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeAction : deleteAttendanceStatus Ending");

		return null;
	}

	public ActionForward updateAttendanceStatusDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeAction : updateAttendanceStatusDetails Starting");
		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String usercode = userDetailVO.getUserCode();

			AttendanceStatusTypePojo attendanceStatusTypePojo = new AttendanceStatusTypePojo();

			attendanceStatusTypePojo.setStatustypecode(request
					.getParameter("statustypecode"));
			attendanceStatusTypePojo.setStatustypename(request
					.getParameter("statustypename"));
			attendanceStatusTypePojo.setShortname(request
					.getParameter("shortname"));
			attendanceStatusTypePojo.setDescription(request
					.getParameter("description"));
			attendanceStatusTypePojo.setUpdatedby(usercode);

			boolean status = new AttendanceStatusTypeBD()
					.UpdateAttendanceStatus(attendanceStatusTypePojo);

			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeAction : updateAttendanceStatusDetails Ending");

		return null;
	}

	public ActionForward validationStatusType(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeAction : validationStatusType Starting");
		try {
			String statustypename = request.getParameter("statustypename");

			boolean status = new AttendanceStatusTypeBD()
					.validationStatusType(statustypename);

			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeAction : validationStatusType Ending");

		return null;
	}

	public ActionForward validationshortname(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeAction : validationshortname Starting");
		try {
			String shortname = request.getParameter("shortname");

			boolean status = new AttendanceStatusTypeBD()
					.validationshortname(shortname);

			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceStatusTypeAction : validationshortname Ending");

		return null;
	}
}