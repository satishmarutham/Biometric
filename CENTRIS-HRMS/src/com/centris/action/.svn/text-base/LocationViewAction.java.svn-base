package com.centris.action;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.VO.LocationMasterVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.LocationMasterBD;
import com.centris.form.LocationMasterForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class LocationViewAction extends DispatchAction{

	
	public synchronized ActionForward locationView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
	try{
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String groupcode=userDetailVO.getGroupCode();
			
			ArrayList<LocationMasterVo> location=new  LocationMasterBD().getLocation(groupcode);
			
			String status=(String)request.getParameter(MessageConstants.LOCATION_STATUS);
	
			request.setAttribute("location", location);
			request.setAttribute("message", status);
			
	
	
	}catch(Exception e){
			
			e.printStackTrace();
			
			
		}
		return mapping.findForward(ApplicationConstants.LOCATION_VIEW);
	}
	
	public synchronized ActionForward Search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			
	try{
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String groupcode=userDetailVO.getGroupCode();
			
			String searchLocation=request.getParameter("searchLocation");
			ArrayList<LocationMasterVo> location=new  LocationMasterBD().getSearchLocations(groupcode,searchLocation);
			
			String status=(String)request.getParameter(MessageConstants.LOCATION_STATUS);
	
			request.setAttribute("location", location);
			request.setAttribute("message", status);
			
	
	
	}catch(Exception e){
			
			e.printStackTrace();
			
			
		}
		return mapping.findForward(ApplicationConstants.LOCATION_VIEW);
	}
	

	
	
	public synchronized ActionForward editLocation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
			
		try{
			
		String locId=(String)request.getParameter("locId");
		
		ArrayList<LocationMasterVo> location=new LocationMasterBD().getSingleLocation(locId);
		
		for (LocationMasterVo locationMasterVo : location) {
			request.setAttribute("locationlist", locationMasterVo);
		}
		
	
		
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return mapping.findForward(ApplicationConstants.LOCATION_VIEW_EDIT);
	}
	public synchronized ActionForward Update(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
	
		try{
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String groupcode=userDetailVO.getGroupCode();
			
		LocationMasterForm lform=(LocationMasterForm)form;
		
		
		String currentuser=request.getSession(false).getAttribute("username").toString();
		
		String status=new LocationMasterBD().storelocation(lform,currentuser);
		
		ArrayList<LocationMasterVo> location=new  LocationMasterBD().getLocation(groupcode);
		request.setAttribute("location", location);
		request.setAttribute("message", status);
	//	request.getSession(false).setAttribute("message", status);
		
		}catch(Exception e){
			e.printStackTrace();
			
			
		}
		
		
		
		return mapping.findForward(ApplicationConstants.LOCATION_VIEW);
	}
	
}
