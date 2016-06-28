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

import com.centris.VO.AddDesignationVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AddDesignationBD;
import com.centris.form.AddDesignation;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class AddDesignationAction extends DispatchAction {

	private static Logger logger = Logger.getLogger(AddDesignationAction.class);

	public synchronized ActionForward addDesignation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction:addDesignation: Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			String status = (String) request.getParameter("status");
			ArrayList<AddDesignationVO> list = new AddDesignationBD()
					.getDesignationDetails();

			request.setAttribute("DesignationDetails", list);

			request.setAttribute("message", status);

		} catch (Exception e) {

			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction:addDesignation: Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "DesignationMaster";
		} else {
			forward = Director.DIRECTOR_DESIGNATION_MASTER;
		}
		
		return mapping.findForward(forward);
	}

	public synchronized ActionForward Add(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction:Add: Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			AddDesignation aform = (AddDesignation) form;

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentuser = userDetailVO.getUserCode();
			String status = new AddDesignationBD().insertDesignationDetails(
					aform, currentuser);

			ArrayList<AddDesignationVO> list = new AddDesignationBD()
					.getDesignationDetails();

			JSONObject jsonObject = new JSONObject();

			request.setAttribute("message", status);

			request.setAttribute("DesignationDetails", list);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction:Add: Ending");
		
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "DesignationMaster";
		} else {
			forward = Director.DIRECTOR_DESIGNATION_MASTER;
		}
		
		return mapping.findForward(forward);
	}

	public ActionForward validateDesignationName(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction:validateDesignationName: Starting");

		try {
			boolean desname_available=false;
			
			String desname = (String) request.getParameter("desname");
			String desid = (String) request.getParameter("desid");
 desname_available = new AddDesignationBD().validateDesName(desname,desid);

			JSONObject object = new JSONObject();
			object.put("des_available",desname_available);

			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction:validateDesignationName: Ending");
		return null;
	}

	public ActionForward editDesignation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction:editDesignation: Starting");

		try {

			String desid = (String) request.getParameter("des_name");

			ArrayList<AddDesignationVO> edit_list = new AddDesignationBD()
					.getEditDesignationDetails(desid);

			JSONObject object = new JSONObject();
			object.accumulate("designationlist", edit_list);
			response.getWriter().print(object);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction:editDesignation: Ending");
		return null;
	}

	public ActionForward deleteDesignation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction:deleteDesignation: Starting");

		try {

			String desid = request.getParameter("des_name");
			String[] des_id_list = desid.split(",");

			String status = new AddDesignationBD()
					.deleteDesignationDetails(des_id_list);

			JSONObject object = new JSONObject();

			object.put("success", status);

			ArrayList<AddDesignationVO> list = new AddDesignationBD()
					.getDesignationDetails();

			response.getWriter().print(object);
			request.setAttribute("DesignationDetails", list);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction:deleteDesignation: Ending");
		return null;
	}

	public synchronized ActionForward Update(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction: Update Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			AddDesignation aform = (AddDesignation) form;

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentuser = userDetailVO.getUserCode();
			String status = new AddDesignationBD().updateDesignationDetails(
					aform, currentuser);

			ArrayList<AddDesignationVO> list = new AddDesignationBD()
					.getDesignationDetails();

			request.setAttribute("message", status);

			request.setAttribute("DesignationDetails", list);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction: Update Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "DesignationMaster";
		} else {
			forward = Director.DIRECTOR_DESIGNATION_MASTER;
		}
		
		return mapping.findForward(forward);
	}

	public ActionForward validateDesNameUpdate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction: validateDesNameUpdate: Starting");

		try {
			String desname = (String) request.getParameter("desname");
			String desid = (String) request.getParameter("desid");

			boolean desname_available = new AddDesignationBD()
					.validateDesNameUpdate(desname, desid);

			JSONObject object = new JSONObject();
			object.put("des_available", desname_available);

			response.getWriter().print(desname_available);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction: validateDesNameUpdate: Ending");
		return null;
	}

	public ActionForward getDesignationDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction:getDesignationDetails Starting");
		try {
			ArrayList<AddDesignationVO> designationlist = new AddDesignationBD()
					.getDesignationDetails();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("designationlist", designationlist);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddDesignationAction:getDesignationDetails Ending");
		return null;
	}
}