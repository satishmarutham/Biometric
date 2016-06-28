/**
 * 
 */
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

import com.centris.POJO.ClientMasterPojo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.ClientMasterBD;
import com.centris.form.ClientMasterForm;
import com.centris.util.HelperClass;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

/**
 * @author satish
 * 
 */
public class ClientMasterAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(ClientMasterAction.class);

	public ActionForward Add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClientMasterAction:Add Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String createdBy = HelperClass.getCurrentUserID(request);
System.out.println();
			ClientMasterForm clientMasterForm = (ClientMasterForm) form;

			clientMasterForm.setCreatedBy(createdBy);

			ClientMasterBD clientMasterBD = new ClientMasterBD();
			String message = clientMasterBD
					.insertClientDetails(clientMasterForm);

			request.setAttribute("message", message);
			ArrayList<ClientMasterPojo> clientDetails = clientMasterBD
					.getClientDetails();

			request.setAttribute("clientDetails", clientDetails);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClientMasterAction: Add Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = StringUtils.CLIENT_MASTER;
		} else {
			forward = Director.DIRECTOR_CLIENT_MASTER;
		}

		return mapping.findForward(forward);
	}

	public ActionForward checkClientName(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClientMasterAction:checkClientName Starting");

		try {

			String clientName = request.getParameter("clientName");

			ClientMasterBD clientMasterBD = new ClientMasterBD();

			boolean status = clientMasterBD.checkClientName(clientName);

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("status", status);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:checkClientName Ending");

		return null;
	}

	public ActionForward editClientDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClientMasterAction:checkClientName Starting");

		try {

			String clientcode = request.getParameter("clientCode");

			ClientMasterBD clientMasterBD = new ClientMasterBD();
			List<ClientMasterPojo> getEditDetails = getEditDetails = clientMasterBD
					.editClientDetails(clientcode);

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("editDetailsList", getEditDetails);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:checkClientName Ending");

		return null;
	}

	public ActionForward Update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClientMasterAction:Add Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String createdBy = HelperClass.getCurrentUserID(request);

			ClientMasterForm clientMasterForm = (ClientMasterForm) form;

			clientMasterForm.setCreatedBy(createdBy);

			ClientMasterBD clientMasterBD = new ClientMasterBD();
			String message = clientMasterBD
					.updateClientDetails(clientMasterForm);

			request.setAttribute("message", message);
			ArrayList<ClientMasterPojo> clientDetails = clientMasterBD
					.getClientDetails();

			request.setAttribute("clientDetails", clientDetails);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control inClientMasterAction:Add: Ending");

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = StringUtils.CLIENT_MASTER;
		} else {
			forward = Director.DIRECTOR_CLIENT_MASTER;
		}

		return mapping.findForward(forward);
	}

	public ActionForward deleteClientDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClientMasterAction:deleteClientDetails Starting");
		try {

			String[] clientCodeArray = request
					.getParameterValues("clientCode[]");

			String status = new ClientMasterBD()
					.deleteClientDetails(clientCodeArray);

			JSONObject object = new JSONObject();
			object.put("status", status);
			response.getWriter().print(object);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClientMasterAction:deleteClientDetails Ending");

		return null;
	}

	public ActionForward checkUpdateClientName(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ClientMasterAction:checkUpdateClientName Starting");

		try {

			String clientName = request.getParameter("clientName");
String clientCode=request.getParameter("clientCode");

			ClientMasterBD clientMasterBD = new ClientMasterBD();

			boolean status = clientMasterBD.checkUpdateClientName(clientName,clientCode);

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("status", status);
			response.getWriter().print(jsonObject);
		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMasterAction:checkUpdateClientName Ending");

		return null;
	}

}
