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
import com.centris.DAO.DAOIMPL.IDGenerator;
import com.centris.POJO.RoleMasterPojo;
import com.centris.POJO.UserMasterPojo;
import com.centris.VO.LocationMasterVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.LocationMasterBD;
import com.centris.delegate.RoleMasterBD;
import com.centris.delegate.UserMasterBD;
import com.centris.exception.AITrackerException;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

/**
 * @author seshuma
 * 
 */
public class UserMasterAction extends DispatchAction {

	private static Logger logger = Logger.getLogger(UserMasterAction.class);

	public  ActionForward addUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: addUser : Starting");

		try {

			UserMasterPojo masterPojo = new UserMasterPojo();
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String currentuser=userDetailVO.getUserCode();
			
			masterPojo.setCreateuser(currentuser);
			masterPojo.setUsername(request.getParameter("username"));
			masterPojo.setPassword(request.getParameter("password"));
			masterPojo.setRoleCode(request.getParameter("roleCode"));
			masterPojo.setLocationCode(request.getParameter("location"));
			masterPojo.setGroupCode(request.getParameter("group"));
			IDGenerator idGenerator = new IDGenerator();

			String userCode = idGenerator.getPrimaryKeyID("ai_user");

			masterPojo.setUserCode(userCode);
			UserMasterBD userMasterBD = new UserMasterBD();
			String addUser = userMasterBD.addUser(masterPojo);
			request.getSession(false).setAttribute("message", addUser);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("message", addUser);

			response.getWriter().println(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: addUser : Ending");

		return null;
	}

	public  ActionForward editUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: editUser : Starting");

		try {

			UserMasterPojo masterPojo = new UserMasterPojo();
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String currentuser=userDetailVO.getUserCode();
			
			masterPojo.setModifyuser(currentuser);
			masterPojo.setUsername(request.getParameter("username"));
			masterPojo.setPassword(request.getParameter("password"));
			masterPojo.setUserCode(request.getParameter("usercode"));
			masterPojo.setRoleCode(request.getParameter("roleCode"));
			masterPojo.setLocationCode(request.getParameter("location"));
			masterPojo.setGroupCode(request.getParameter("group"));

			UserMasterBD userMasterBD = new UserMasterBD();
			String successMessage = userMasterBD.editUser(masterPojo);
			request.getSession(false).setAttribute("message", successMessage);
			JSONObject jsonObject = new JSONObject();

			jsonObject.put("message", successMessage);

			response.getWriter().println(jsonObject);
		} catch (Exception e) {

			logger.error(e);
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: editUser : Ending");
		return null;
	}

	public  ActionForward deleteUser(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: deleteUser : Starting");

		try {

			String userDetails = (String) request.getParameter("user_details");
			String[] userData = userDetails.split(",,");
			List<String> userCodeList = new ArrayList<String>();

			for (int i = 1; i < userData.length; i++) {

				String[] userid = userData[i].split(",");
				userCodeList.add(userid[2]);

			}

			UserMasterPojo masterPojo = new UserMasterPojo();
			masterPojo.setUserCodeList(userCodeList);

			UserMasterBD userMasterBD = new UserMasterBD();
			String deleteUser = userMasterBD.deleteUser(masterPojo);
			request.getSession(false).setAttribute("message", deleteUser);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("message", deleteUser);

			response.getWriter().println(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: deleteUser : Ending");
		return null;
	}

	public  ActionForward getRolesDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: getRolesDetails : Starting");

		try {
			List<RoleMasterPojo> roleMasterList = new ArrayList<RoleMasterPojo>();
			RoleMasterBD masterBD = new RoleMasterBD();
			roleMasterList = masterBD.getRoles();
			request.setAttribute("roleMasterList", roleMasterList);

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("jsonResponse", roleMasterList);
			response.getWriter().println(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: getRolesDetails : Ending");

		return null;
	}

	public  ActionForward getLocationDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: getLocationDetails : Starting");

		try {

			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String groupcode = userDetailVO.getGroupCode();

			List<LocationMasterVo> LocationList = new LocationMasterBD()
					.getLocation(groupcode);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("jsonResponse", LocationList);
			response.getWriter().println(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: getLocationDetails : Ending");
		return null;
	}

	public  ActionForward getGroupDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterAction: getGroupDetails : Starting");

		try {
			UserMasterBD masterBD = new UserMasterBD();
			List<UserMasterPojo> groupDetails = new ArrayList<UserMasterPojo>();
			groupDetails = masterBD.getGroupDetails();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("jsonResponse", groupDetails);
			response.getWriter().println(jsonObject);
		} catch (Exception e) {

			logger.error(e);
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterAction: getGroupDetails : Ending");

		return null;
	}

	public  ActionForward getCurrentUserNameCkeck(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterAction : getCurrentUserNameCkeck Starting");

		try {
			String currentUname = request.getParameter("userNameval");

			boolean status = new UserMasterBD()
					.CurrentUserNameCkeck(currentUname);

			JSONObject object = new JSONObject();
			object.put("status", status);
			response.getWriter().print(object);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);

		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UserMasterAction : getCurrentUserNameCkeck Ending");
		return null;
	}
}
