package com.centris.action;

import java.util.ArrayList;
import java.util.Date;

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

import com.centris.DAO.DAOIMPL.IDGenerator;
import com.centris.POJO.GroupMasterPOJO;
import com.centris.VO.GroupMasterVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.GroupMasterBD;
import com.centris.util.HelperClass;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class GroupMasterAction extends DispatchAction {

	private static Logger logger = Logger.getLogger(GroupMasterAction.class);
	public synchronized ActionForward groupMasterHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterAction:groupMasterHome Starting");
	try{
		ArrayList<GroupMasterVO> grouplist =new GroupMasterBD().getGroupDetails();
		request.setAttribute("grouplist", grouplist);
	}catch(Exception e){
		e.printStackTrace();
		logger.error(e);
	}
		
	JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterAction:groupMasterHome Ending");
		return mapping.findForward(ApplicationConstants.GROUP_MASTER);
	}
	
	
	public  ActionForward addGroupDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterAction:addGroupDetails Starting");
		System.out.println("starting");
		try{
		GroupMasterPOJO groupMasterPOJO = new GroupMasterPOJO();
		HttpSession session = request.getSession(false);

		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String username = userDetailVO.getUserCode();
		String groupName = request.getParameter("groupName");
		String description = request.getParameter("description");
							
		groupMasterPOJO.setUser(username);
		groupMasterPOJO.setGroupName(groupName);
		groupMasterPOJO.setDescription(description);
		groupMasterPOJO.setGroupId( new IDGenerator().getPrimaryKeyID("onsite_group"));
		int result = new GroupMasterBD().addGroupDetails(groupMasterPOJO);
	        System.out.println("----------------------------"+result);
         if(result==1){
        	return null;
         }
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterAction:addGroupDetails Ending");
		return mapping.findForward(ApplicationConstants.GROUP_MASTER);
		}
	public  ActionForward editGroupDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterAction:editGroupDetails Starting");
		try{
		String groupID = request.getParameter("groupId");
		ArrayList<GroupMasterVO> updatelist =new GroupMasterBD().editGroupDetails(groupID);
		JSONObject jsonobject = new JSONObject(updatelist);
		jsonobject.accumulate("updatelist", updatelist);
		response.getWriter().print(jsonobject);
	}catch(Exception e){
		e.printStackTrace();
		logger.error(e);
	}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterAction:editGroupDetails Ending");
		return null;

	}

	public  ActionForward updateGroupDetailsVal(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterAction:updateGroupDetailsVal Starting");
		try{
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String usercode=userDetailVO.getUserCode();
			
		GroupMasterPOJO groupMasterPOJO = new GroupMasterPOJO();
		HttpSession session = request.getSession(false);
		
		
		
		String groupID = request.getParameter("groupId");
		String groupName = request.getParameter("groupName");
		String description = request.getParameter("description");
	
		groupMasterPOJO.setGroupId(groupID);
		groupMasterPOJO.setDescription(description);
		groupMasterPOJO.setGroupName(groupName);
		groupMasterPOJO.setModifiedby(usercode);
		groupMasterPOJO.setModifieddate(HelperClass.getCurrentTimestamp());
		
		String result = new GroupMasterBD().updateGroupDetailsVal(groupMasterPOJO);
		
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
		}
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterAction:updateGroupDetailsVal Ending");
		return null;

	}

	public  ActionForward deleteGroupDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterAction:deleteGroupDetails Starting");
		try{
		String groupId = request.getParameter("groupId");
		String[] groupIdval = groupId.split(",");
		String result= new GroupMasterBD().deleteGroupDetailsVal(groupIdval);
		
		JSONObject object=new JSONObject();
		object.put("result", result);
		
		response.getWriter().print(object);
	
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterAction:deleteGroupDetails Ending");
		return null;

	}

	public  ActionForward checkValidate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterAction: checkValidate Starting");
		try{
		String groupId=request.getParameter("groupId");
		System.out.println("***"+groupId);
		String groupName = request.getParameter("groupName");
		GroupMasterPOJO groupMasterPOJO = new GroupMasterPOJO();
		groupMasterPOJO.setGroupId(groupId);
		groupMasterPOJO.setGroupName(groupName);
    	String result = new GroupMasterBD().validateGroupDetailsVal(groupMasterPOJO);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("groupNameVal", result);
		response.getWriter().print(jsonObject);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupMasterAction: checkValidate Ending");
		return null;
	}
	
	

}
