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
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.VO.GroupLocationMapVO;
import com.centris.delegate.GroupLocationMapBD;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class GroupLocationMapAction extends DispatchAction{

	/**
	 * @Title:Group Location Mapping
	 * @Author:Swathi
	 * @Methods:groupLocationHome
     *         getGroup
     *         getLocation
     *         saveGroupLocationMapping
     *         getMappedLoc
     *   @throws Exception
	 */
	
	private static 	Logger logger = Logger.getLogger(GroupLocationMapAction.class);
	
	public synchronized ActionForward groupLocationHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
					+ " Control in GroupLocationMapAction:groupLocationHome Starting");
		
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupLocationMapAction:groupLocationHome Ending");
		return mapping.findForward(ApplicationConstants.GROUP_LOCATION_MAP);
	}
	
	
	public  ActionForward getGroup(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
					+ " Control in GroupLocationMapAction:getGroup Starting");
		System.out.println("GroupLocationMapAction:getGroup starting ");
		System.out.println("------------------------------------------");
		
		try{
		List<GroupLocationMapVO> grouplist=new GroupLocationMapBD().getGroup();
		JSONObject jsonobject=new JSONObject();
		jsonobject.accumulate("grouplist", grouplist);
		response.getWriter().print(jsonobject);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
		}
		
		
		
			System.out.println("------------------------------------------");
		System.out.println("GroupLocationMapAction:getGroup ending ");
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupLocationMapAction:getGroup Ending");
		return null;
	}
	
	
	public ActionForward getLocation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
					+ " Control in GroupLocationMapAction:getLocation Starting");
		try{
		List<GroupLocationMapVO> locationlist=new GroupLocationMapBD().getLocation();
		JSONObject jsonobject=new JSONObject();
		jsonobject.accumulate("locationlist", locationlist);
		response.getWriter().print(jsonobject);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupLocationMapAction:getLocation Ending");
		return null;
	}
	
	public  ActionForward saveGroupLocationMapping(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
					+ " Control in GroupLocationMapAction:saveGroupLocationMapping Starting");
		
		System.out.println("GroupLocationMapAction:saveGroupLocationMapping starting ");
		System.out.println("------------------------------------------");
		
		try{
		String groupId=request.getParameter("groupId");
		String locID = request.getParameter("locDetails");
		JSONArray jsonloc = null;
		if (locID != null) {
			jsonloc = new JSONArray(locID);
		}
		
		String result=new GroupLocationMapBD().saveGroupLocationMapping(groupId,jsonloc);
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("result",result);
		response.getWriter().print(jsonobject);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
		}
		
		
		
		System.out.println("------------------------------------------");
		System.out.println("GroupLocationMapAction:saveGroupLocationMapping ending ");
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupLocationMapAction:saveGroupLocationMapping Ending");
		
		return null;
	}
	
	
	public  ActionForward getMappedLoc(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
					+ " Control in GroupLocationMapAction:getMappedLoc Starting");
		System.out.println("GroupLocationMapAction:getMappedLoc starting ");
		System.out.println("------------------------------------------");
		
		try{
		String groupId=request.getParameter("groupVal");
		List<GroupLocationMapVO> locationlist=new GroupLocationMapBD().getMappedLoc(groupId);
		JSONObject jsonobject=new JSONObject();
		jsonobject.accumulate("mappedlocationlist", locationlist);
		response.getWriter().print(jsonobject);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
		}
		
		
		
		System.out.println("------------------------------------------");
		System.out.println("GroupLocationMapAction:getMappedLoc ending ");
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GroupLocationMapAction:getMappedLoc Ending");
		return null;
	}

	
}
