package com.centris.action;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;

import com.centris.VO.LeaveBankVo;
import com.centris.VO.UserDetailVO;
import com.centris.VO.getAccYearVO;
import com.centris.delegate.LeaveBankBD;
import com.centris.form.GetLeavesform;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class LeaveBankAction extends DispatchAction {

	private static Logger logger = Logger.getLogger(LeaveBankAction.class);

	public synchronized ActionForward getLeave(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank Action:LeaveBank Home Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			ArrayList<getAccYearVO> arr = new ArrayList<getAccYearVO>();
			arr = new LeaveBankBD().getYear();
			request.setAttribute("accyear", arr);

			ArrayList<LeaveBankVo> leavelist = new ArrayList<LeaveBankVo>();
			leavelist = new LeaveBankBD().getAllLeaves();
			request.setAttribute("leavelist", leavelist);

			String deletestatus = request.getParameter("deletekey");
			request.setAttribute("deletestatus", deletestatus);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBankAction:LeaveBankHome Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "GetLeaves";
		} else {
			forward = Director.DIRECTOR_LEAVE_MASTER;
		}

		return mapping.findForward(forward);
	}

	public synchronized ActionForward addLeave(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank Action:addLeave Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			ArrayList<getAccYearVO> arr = new ArrayList<getAccYearVO>();
			arr = new LeaveBankBD().getYear();
			request.setAttribute("accyear", arr);

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String user = userDetailVO.getUserCode();

			GetLeavesform frm = (GetLeavesform) form;
			String addstatus = new LeaveBankBD().addLeave(frm, user);

			ArrayList<LeaveBankVo> leavelist = new ArrayList<LeaveBankVo>();
			leavelist = new LeaveBankBD().getAllLeaves();
			request.setAttribute("leavelist", leavelist);

			request.setAttribute("addstatus", addstatus);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBankAction:addLeave Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "GetLeaves";
		} else {
			forward = Director.DIRECTOR_LEAVE_MASTER;
		}

		return mapping.findForward(forward);
	}

	public synchronized ActionForward editLeave(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank Action:editLeave Starting");
		try {

			String sno = request.getParameter("sno");

			GetLeavesform frm = (GetLeavesform) form;

			ArrayList<LeaveBankVo> editleave = new ArrayList<LeaveBankVo>();
			editleave = new LeaveBankBD().editLeave(frm, sno);

			JSONObject json = new JSONObject();
			json.accumulate("editleave", editleave);
			response.getWriter().print(json);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBankAction:editLeave Ending");
		return null;
	}

	public synchronized ActionForward updateLeave(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank Action:updateLeave Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			ArrayList<getAccYearVO> arr = new ArrayList<getAccYearVO>();
			arr = new LeaveBankBD().getYear();
			request.setAttribute("accyear", arr);

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String user = userDetailVO.getUserCode();

			GetLeavesform frm = (GetLeavesform) form;
			String updatestatus = new LeaveBankBD().updateLeave(frm, user);

			ArrayList<LeaveBankVo> leavelist = new ArrayList<LeaveBankVo>();
			leavelist = new LeaveBankBD().getAllLeaves();
			request.setAttribute("leavelist", leavelist);

			request.setAttribute("updatestatus", updatestatus);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBankAction:updateLeave Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "GetLeaves";
		} else {
			forward = Director.DIRECTOR_LEAVE_MASTER;
		}

		return mapping.findForward(forward);
	}

	public synchronized ActionForward validAddLeave(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank Action:validate add Leave Starting");
		try {
			String year = request.getParameter("year");

			Boolean validate = new LeaveBankBD().validAddLeave(year);

			JSONObject json = new JSONObject();
			json.accumulate("validate", validate);
			response.getWriter().print(json);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return null;
	}

	public synchronized ActionForward validUpdateLeave(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank Action:validate add Leave Starting");
		try {
			String year = request.getParameter("year");
			String sno = request.getParameter("sno");
			Boolean validate = new LeaveBankBD().validUpdateLeave(year, sno);

			JSONObject json = new JSONObject();
			json.accumulate("validate", validate);
			response.getWriter().print(json);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return null;
	}

	public synchronized ActionForward deleteLeave(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LeaveBank Action: delete Leave Starting");
		try {

			String[] deletelist = request.getParameterValues("year[]");

			Boolean deletestatus = new LeaveBankBD().deleteLeave(deletelist);
			JSONObject json = new JSONObject();
			json.accumulate("deletestatus", deletestatus);
			response.getWriter().print(json);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		}
		return null;
	}
}