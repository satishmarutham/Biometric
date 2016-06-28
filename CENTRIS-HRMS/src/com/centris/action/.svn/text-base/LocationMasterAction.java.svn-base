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

import com.centris.VO.LocationMasterVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.LocationMasterBD;
import com.centris.form.LocationMasterForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

/**
 * @author seshuma
 *
 */
public class LocationMasterAction extends DispatchAction {
	
	private static 	Logger logger = Logger.getLogger(LocationMasterAction.class);
	
	public synchronized ActionForward addlocation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction:addlocation: Starting");
		
		try{
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String groupcode=userDetailVO.getGroupCode();
			
			ArrayList<LocationMasterVo> location=new  LocationMasterBD().getAllLocation();
			
			String status=(String)request.getParameter(MessageConstants.LOCATION_STATUS);
	
			request.setAttribute("location", location);
			request.setAttribute("message", status);
			
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
			
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: addlocation : Ending");
		
			return mapping.findForward("locationmaster");
	}
	
	public synchronized ActionForward Add(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: storelocation : Starting");
		try{
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String currentuser=userDetailVO.getUserCode();
			
			
		LocationMasterForm lform=(LocationMasterForm)form;
		
		
		String status=new LocationMasterBD().storelocation(lform,currentuser);
		
		ArrayList<LocationMasterVo> location=new  LocationMasterBD().getAllLocation();
		
		request.setAttribute("location", location);
		request.setAttribute("message", status);

		
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
			
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: storelocation : Ending");
		
		return mapping.findForward("locationmaster");
	}
	
	
	public ActionForward editLocation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: editLocation : Starting");
		
		try{
		String locId=(String)request.getParameter("locId");
		
		ArrayList<LocationMasterVo> location=new LocationMasterBD().getSingleLocation(locId);
		
	
		JSONObject object=new JSONObject();
		object.put("location", location);
		
		response.getWriter().print(object);
		
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: editLocation : Ending");
	
		return null;
	}
	
	public synchronized  ActionForward deleteLocation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: deleteLocation : Starting");
		
		try{
		
		String loc = request.getParameter("loc_name");
		String[] locId = loc.split(",");
		
		
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String currentuser=userDetailVO.getUserCode();
		
		String status=new  LocationMasterBD().deleteLocation(locId,currentuser);
		
		JSONObject object=new JSONObject();
		object.put(MessageConstants.LOCATION_STATUS,status);
		response.getWriter().print(object);
		
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
			
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: deleteLocation : Ending");
		
		return null;
	}
	
	public ActionForward validateLocationName(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateLocationName : Starting");
		
		try{
		String locationname=(String)request.getParameter("locationname");
		
		
	int count=new LocationMasterBD().validateLocationName(locationname);

		JSONObject object=new JSONObject();
		object.put("count", count);
		
		response.getWriter().print(object);
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateLocationName : Ending");
		
		return null;
	}
	
	
	public  ActionForward validateLocationNameUpdate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateLocationName : Starting");
		
		try{
		String locationname=(String)request.getParameter("locationname");
		String locationid=(String)request.getParameter("locationid");
		
		
	int count=new LocationMasterBD().validateLocationNameUpdate(locationname,locationid);

		JSONObject object=new JSONObject();
		object.put("count", count);
		
		response.getWriter().print(object);
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateLocationName : Ending");
		
		return null;
	}
	
	public ActionForward validateLocationNumber(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateLocationNumber : Starting");
		
		try{
		String locationnumber=(String)request.getParameter("locationnumber");
		
	int count=new LocationMasterBD().validateLocationNumber(locationnumber);
	

		JSONObject object=new JSONObject();
		object.put("count", count);
		
		response.getWriter().print(object);
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateLocationNumber : Ending");
		
		return null;
	}
	
	public  ActionForward validateLocationNumberUpdate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateLocationNumber : Starting");
		
		try{
		String locationnumber=(String)request.getParameter("locationnumber");
		String locationid=(String)request.getParameter("locationid");
		
		
	int count=new LocationMasterBD().validateLocationNumberUpdate(locationnumber,locationid);

		JSONObject object=new JSONObject();
		object.put("count", count);
		
		response.getWriter().print(object);
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateLocationNumber : Ending");
		
		return null;
	}
	
	public  ActionForward validateMachineNumber(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateMachineNumber : Starting");
		
		try{
		String machinenumber=(String)request.getParameter("machinenumber");
		//String locationid=(String)request.getParameter("locationid");
		
	int count=new LocationMasterBD().validateMachineNumber(machinenumber);

		JSONObject object=new JSONObject();
		object.put("count", count);
		
		response.getWriter().print(object);
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateMachineNumber : Ending");
		
		return null;
	}
	
	public  ActionForward validateMachineNumberUpdate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateMachineNumber : Starting");
		
		try{
		String machinenumber=(String)request.getParameter("machinenumber");
		String locationid=(String)request.getParameter("locationid");
		
	int count=new LocationMasterBD().validateMachineNumberUpdate(machinenumber,locationid);

		JSONObject object=new JSONObject();
		object.put("count", count);
		
		response.getWriter().print(object);
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateMachineNumber : Ending");
		
		return null;
	}
	
	public  ActionForward validateBioIdIndex(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateMachineNumber : Starting");
		
		try{
		String bioidindexnumber=(String)request.getParameter("bioidindexnumber");
		
	int count=new LocationMasterBD().validateBioIdIndex(bioidindexnumber);

		JSONObject object=new JSONObject();
		object.put("count", count);
		
		response.getWriter().print(object);
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateMachineNumber : Ending");
		
		return null;
	}
	
	public  ActionForward validateBioIdIndexUpdate(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateMachineNumber : Starting");
		
		
		
		try{
		String bioidindexnumber=(String)request.getParameter("bioidindexnumber");
		String locationid=(String)request.getParameter("locationid");
		
		
	int count=new LocationMasterBD().validateBioIdIndexUpdate(bioidindexnumber,locationid);

		JSONObject object=new JSONObject();
		object.put("count", count);
		
		response.getWriter().print(object);
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: validateMachineNumber : Ending");
		
		return null;
	}
	

	public  ActionForward getLocationByGroup(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: getLocationByGroup : Starting");
		String group=request.getParameter("group");
		List<LocationMasterVo> locationList =  new LocationMasterBD().getLocationByGroup( group);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("locationList", locationList);
		response.getWriter().print(jsonObject);
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: getLocationByGroup : Ending");
		return null;
	}
	
	
	public synchronized ActionForward Update(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: storelocation : Starting");
		try{
			
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String currentuser=userDetailVO.getUserCode();
		LocationMasterForm lform=(LocationMasterForm)form;
		
		String status=new LocationMasterBD().updateLocation(lform,currentuser);
		
		ArrayList<LocationMasterVo> location=new  LocationMasterBD().getAllLocation();
		
		request.setAttribute("location", location);
		request.setAttribute("message", status);
		
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
			
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: storelocation : Ending");
		
		return mapping.findForward("locationmaster");
	}
	
	public synchronized ActionForward deactiveLocations(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: deactiveLocations : Starting");
		try{
			String message=(String)request.getParameter("status");
			ArrayList<LocationMasterVo> deactivelocationslist=new LocationMasterBD().getDeactivelocations();
			
			request.setAttribute("deactivelocationslist", deactivelocationslist);
			request.setAttribute("message", message);
		
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
			
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: deactiveLocations : Ending");
		
		return mapping.findForward("deactivelocatios");
	}
	
	public synchronized ActionForward activatelocations(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: deactiveLocations : Starting");
		try{
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String currentuser=userDetailVO.getUserCode();
			
			String locationname=(String)request.getParameter("locationname");
			
			
		String locationstatus=new LocationMasterBD().activatelocation(locationname,currentuser);
		
		JSONObject object=new JSONObject();
		object.put("locationstatus", locationstatus);
		
		response.getWriter().print(object);
		
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e);
			
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LocationMasterAction: deactiveLocations : Ending");
		
		return null;
	}
	
	
	
	

}
