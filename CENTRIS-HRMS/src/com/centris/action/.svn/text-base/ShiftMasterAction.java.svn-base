package com.centris.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.DAO.DAOIMPL.IDGenerator;
import com.centris.POJO.ShiftMasterPOJO;
import com.centris.VO.LocationMasterVo;
import com.centris.VO.ShiftMasterVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.LocationMasterBD;
import com.centris.delegate.ShiftMasterBD;
import com.centris.form.ShiftForm;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class ShiftMasterAction extends DispatchAction {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<ShiftForm> shiftList = new ArrayList<ShiftForm>();
	ShiftMasterPOJO shiftMasterPOJO;
	String result;

	private static Logger logger = Logger.getLogger(ShiftMasterAction.class);

	public synchronized ActionForward shiftCreation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterAction:insertShift Starting");
		
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String groupcode=userDetailVO.getGroupCode();

		shiftMasterPOJO = new ShiftMasterPOJO();

		shiftMasterPOJO.setAi_shift_id(new IDGenerator()
				.getPrimaryKeyID("ai_shift_deatails"));
		shiftMasterPOJO.setAi_shift_name(request
				.getParameter(StringUtils.AI_SHIFT_NAME));
		shiftMasterPOJO.setAi_shift_start_time(request
				.getParameter(StringUtils.AI_SHIFT_START_TIME));
		shiftMasterPOJO.setAi_shift_end_time(request
				.getParameter(StringUtils.AI_SHIFT_END_TIME));
		shiftMasterPOJO.setAi_shift_ltoc(request
				.getParameter(StringUtils.AI_SHIFT_LTOC));
		shiftMasterPOJO.setAi_shift_etog(request
				.getParameter(StringUtils.AI_SHIFT_ETOG));
		shiftMasterPOJO.setAi_shift_ltoc_gc(request
				.getParameter(StringUtils.AI_SHIFT_LTOC_GC));
		shiftMasterPOJO.setAi_shift_etog_gc(request
				.getParameter(StringUtils.AI_SHIFT_ETOG_GC));
		shiftMasterPOJO.setAi_shift_ltoc_no_exec(request
				.getParameter(StringUtils.AI_SHIFT_LTOC_NO_EXEC));
		shiftMasterPOJO.setAi_shift_etog_no_exec(request
				.getParameter(StringUtils.AI_SHIFT_ETOG_NO_EXEC));

		shiftMasterPOJO.setAi_shift_ltoc_ld(request
				.getParameter(StringUtils.AI_SHIFT_LTOC_LD));
		shiftMasterPOJO.setAi_shift_etog_ld(request
				.getParameter(StringUtils.AI_SHIFT_ETOG_LD));
		HttpSession session = request.getSession(false);

		shiftMasterPOJO.setCreateuser(userDetailVO.getUserCode());
		DateFormat dateFormat = new SimpleDateFormat(StringUtils.DATEFORMAT);
		Calendar cal = Calendar.getInstance();

		
    	shiftMasterPOJO.setCreatetime(dateFormat.format(cal.getTime()));
    	shiftMasterPOJO.setLocation(request.getParameter(StringUtils.USER_LOCATION).toString());
      		 result=new ShiftMasterBD().shiftCreation(shiftMasterPOJO);
      		 System.out.println(result);
      		ArrayList<ShiftMasterVO> shiftList=new ShiftMasterBD().getAllShifts(groupcode); 
      		
      		request.setAttribute(StringUtils.SHIFTLIST, shiftList);
      		
      		ArrayList<LocationMasterVo> location=new  LocationMasterBD().getLocation(groupcode);
    		request.setAttribute("location", location);
    	   
      		if(result.equalsIgnoreCase("insert")){
    		System.out.println("*****************************if condition&&&&&&&");
    		request.setAttribute("SHIFT_MESSAGE",MessageConstants.SHIFT_INSERT);
      		}else{
      			
      		}
    		
    		
    		
    		
    		JLogger.log(0, JDate.getTimeString(new Date())
    				+ MessageConstants.END_POINT);
    		logger.info(JDate.getTimeString(new Date())
    				+ " Control in ShiftMasterAction:insertShift Ending");
    		
    		
    		
    		return mapping.findForward(ApplicationConstants.SHIFT_MASTER);
      

	


	}

	public synchronized ActionForward shiftUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterAction:updateShift Starting");
		
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String groupcode=userDetailVO.getGroupCode();

		shiftMasterPOJO = new ShiftMasterPOJO();
		shiftMasterPOJO.setAi_shift_id(request
				.getParameter(StringUtils.AI_SHIFT_ID));
		shiftMasterPOJO.setAi_shift_name(request
				.getParameter(StringUtils.AI_SHIFT_NAME));
		shiftMasterPOJO.setAi_shift_start_time(request
				.getParameter(StringUtils.AI_SHIFT_START_TIME));
		shiftMasterPOJO.setAi_shift_end_time(request
				.getParameter(StringUtils.AI_SHIFT_END_TIME));
		shiftMasterPOJO.setAi_shift_ltoc(request
				.getParameter(StringUtils.AI_SHIFT_LTOC));
		shiftMasterPOJO.setAi_shift_etog(request
				.getParameter(StringUtils.AI_SHIFT_ETOG));
		shiftMasterPOJO.setAi_shift_ltoc_gc(request
				.getParameter(StringUtils.AI_SHIFT_LTOC_GC));
		shiftMasterPOJO.setAi_shift_etog_gc(request
				.getParameter(StringUtils.AI_SHIFT_ETOG_GC));
		shiftMasterPOJO.setAi_shift_ltoc_no_exec(request
				.getParameter(StringUtils.AI_SHIFT_LTOC_NO_EXEC));
		shiftMasterPOJO.setAi_shift_etog_no_exec(request
				.getParameter(StringUtils.AI_SHIFT_ETOG_NO_EXEC));

		shiftMasterPOJO.setAi_shift_ltoc_ld(request
				.getParameter(StringUtils.AI_SHIFT_LTOC_LD));
		shiftMasterPOJO.setAi_shift_etog_ld(request
				.getParameter(StringUtils.AI_SHIFT_ETOG_LD));
		HttpSession session = request.getSession(false);
		shiftMasterPOJO.setCreateuser(userDetailVO.getUserCode());
		DateFormat dateFormat = new SimpleDateFormat(StringUtils.DATEFORMAT);
		Calendar cal = Calendar.getInstance();
		shiftMasterPOJO.setCreatetime(dateFormat.format(cal.getTime()));
		shiftMasterPOJO.setLocation(request.getParameter("location"));

		result = new ShiftMasterBD().shiftUpdate(shiftMasterPOJO);
		ArrayList<ShiftMasterVO> shiftList = new ShiftMasterBD().getAllShifts(groupcode);
		request.setAttribute(StringUtils.SHIFTLIST, shiftList);
		
		ArrayList<LocationMasterVo> location=new  LocationMasterBD().getLocation(groupcode);
		request.setAttribute("location", location);
		if(result.equalsIgnoreCase("update")){
    		  		request.setAttribute("SHIFT_MESSAGE",MessageConstants.SHIFT_UPDATE);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterAction:updateShift Ending");
		return mapping.findForward(ApplicationConstants.SHIFT_MASTER);

	}

	public synchronized ActionForward shiftDelete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterAction:deleteShift Starting");
		
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String groupcode=userDetailVO.getGroupCode();

		shiftMasterPOJO = new ShiftMasterPOJO();
		shiftMasterPOJO.setAi_shift_id(request
				.getParameter(StringUtils.AI_SHIFT_ID));
		result = new ShiftMasterBD().shiftDelete(shiftMasterPOJO);
		ArrayList<ShiftMasterVO> shiftList = new ShiftMasterBD().getAllShifts(groupcode);
		request.setAttribute(StringUtils.SHIFTLIST, shiftList);
		
		ArrayList<LocationMasterVo> location=new  LocationMasterBD().getLocation(groupcode);
		request.setAttribute("location", location);
		
	  		request.setAttribute("SHIFT_MESSAGE",result);


		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterAction:deleteShift Ending");
		return mapping.findForward(ApplicationConstants.SHIFT_MASTER);

	}

	public ActionForward checkShifName(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterAction:checkShifName Starting");

		String shiftname=(String)request.getParameter("shiftname");
		String locationcode=(String)request.getParameter("locationname");
		
		int count = new ShiftMasterBD().checkShiftName(shiftname,locationcode);
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("count", count);
		response.getWriter().print(jsonobject);

		JSONArray array=new JSONArray(shiftList);
		System.out.println(array);
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterAction:checkShifName Ending");
		return null;

	}
	
	
	public ActionForward checkShifNameUpdate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterAction:checkShifNameUpdate Starting");

		String shiftname=(String)request.getParameter("shiftname");
		String locationcode=(String)request.getParameter("locationname");
		String shiftid=(String)request.getParameter("shiftid");
		
		int count = new ShiftMasterBD().checkShiftNameUpdate(shiftname,locationcode,shiftid);
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("count", count);
		response.getWriter().print(jsonobject);

		JSONArray array=new JSONArray(shiftList);
		System.out.println(array);
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterAction:checkShifNameUpdate Ending");
		return null;

	}
	public  ActionForward getShiftByLocation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterAction:getShiftByLocation Starting");

		String location=request.getParameter("location");
		String group=request.getParameter("group");
		
	
		List<ShiftMasterVO> shiftList =  new ShiftMasterBD().getShiftByLocation(location,group);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("shiftList", shiftList);
		response.getWriter().print(jsonObject);
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterAction:getShiftByLocation Ending");
		return null;
	}
	
	public synchronized ActionForward getShiftByMultipleLocation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterAction:getShiftByMultipleLocation Starting");

		String location=request.getParameter("location");
		String group=request.getParameter("group");
		
	
		List<ShiftMasterVO> shiftList =  new ShiftMasterBD().getShiftByMultipleLocation(location,group);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("shiftList", shiftList);
		response.getWriter().print(jsonObject);
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ShiftMasterAction:getShiftByMultipleLocation Ending");
		return null;
	}
	
}