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

import com.centris.VO.ShiftMasterVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AddEmployeeBD;
import com.centris.delegate.ShiftMasterBD;
import com.centris.exception.AITrackerException;
import com.centris.form.AddEmployeeForm; 
import com.centris.util.JPropertyReader;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class AddEmployeeAction extends DispatchAction {

	private static 	Logger logger = Logger.getLogger(AddEmployeeAction.class);

	public synchronized  ActionForward addEmployee(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws AITrackerException,Exception
	{
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: addEmployee : Starting");
		try{
		
		AddEmployeeForm addEmployee = (AddEmployeeForm) form;
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String username=userDetailVO.getUserCode();
		
		if(addEmployee.getIsemployeeregusteredinmultilocations()==null){
			
			addEmployee.setIsemployeeregusteredinmultilocations("N");
			
		}else{
			
			addEmployee.setIsemployeeregusteredinmultilocations("Y");
			
		}
		
		
		String status=new AddEmployeeBD().addEmployee(addEmployee,username);
		
		request.setAttribute("message", status);
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: addEmployee : Ending");

		return mapping.findForward("addEmployee");	
	}

	public  ActionForward checkEmail(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws AITrackerException,Exception
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: checkEmail : Starting");
		
		try{
		String email=(String)request.getParameter("email");
		
		boolean status=new AddEmployeeBD().checkEmail(email);
		
		
		JSONObject object=new JSONObject();
		object.put("status", status);
		response.getWriter().print(object);
	
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
			
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: checkEmail : Ending");
		return null;	
	}
	
	public  ActionForward checkEmpRegNo(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws AITrackerException,Exception
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: checkEmpRegNo : Starting");
		
		try{
		String empregno=(String)request.getParameter("empregno");
		
		boolean status=new AddEmployeeBD().checkEmpRegNo(empregno);
		
		
		JSONObject object=new JSONObject();
		object.put("status", status);
		response.getWriter().print(object);
	
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
			
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: checkEmpRegNo : Ending");
		return null;	
	}
	
	public  ActionForward checkEmpId(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws AITrackerException,Exception
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: checkEmpId : Starting");
		
		try{
		
		String empid=(String)request.getParameter("empid");
		
		boolean status=new AddEmployeeBD().checkEmpId(empid);
		
		
		JSONObject object=new JSONObject();
		object.put("status", status);
		response.getWriter().print(object);
		
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: checkEmpId : Ending");
		
		return null;	
	}
	
	
	public synchronized  ActionForward activateEmployee(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws AITrackerException,Exception
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: activateEmployee : Starting");
		
		try{
		
		String empid=(String)request.getParameter("id");
		
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		
		String usercode=userDetailVO.getUserCode();
		
		
		String status=new AddEmployeeBD().activateEmployee(empid,usercode);
		
		
		JSONObject object=new JSONObject();
		object.put("status", status);
		response.getWriter().print(object);
		
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: activateEmployee : Ending");
		
		return null;	
	}
	
	public  ActionForward getlocationnames(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws AITrackerException,Exception
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: empLocationMapping : Starting");
		
		try{
			
			String[] studentslist=request.getParameterValues("updaterowsArray[]");
			
			ArrayList<String> status=new AddEmployeeBD().getlocationnames(studentslist);
			
			JSONObject object=new JSONObject();
			object.accumulate("status", status);
			
			response.getWriter().print(object);
	
		
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: empLocationMapping : Ending");
		
		return null;	
	}
	
	
	public  ActionForward getlocationbasedshift(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws AITrackerException,Exception
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: getlocationbasedshift : Starting");
		
		try{
			
			String locid=request.getParameter("locid");
			
			
			List<ShiftMasterVO> status=new ShiftMasterBD().getShiftBasedLocation(locid);
			
			JSONObject object=new JSONObject();
			object.accumulate("status", status);
			
			response.getWriter().print(object);
	
	
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: getlocationbasedshift : Ending");
		
		return null;	
	}
	
	
	public  ActionForward chechkemployeeidformat(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws AITrackerException,Exception
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: chechkemployeeidformat : Starting");
		
		try{
			
			String empid=request.getParameter("empid");
			String location=request.getParameter("location");
			
			String indexid=new AddEmployeeBD().chechkemployeeidformat(empid,location);
			JSONObject object=new JSONObject();
			object.accumulate("status", indexid);
			
			response.getWriter().print(object);
	
	
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: chechkemployeeidformat : Ending");
		
		return null;	
	}
	
	public  ActionForward checkDseCount(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws AITrackerException,Exception
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: checkDseCount : Starting");
		
		try{
			String locationid=request.getParameter("locationid");
			String desid=request.getParameter("desid");
			
			String status="false";
			
			if(desid.equalsIgnoreCase(JPropertyReader.getProperty(ApplicationConstants.DESIGNATION_ID))){
				
				 status=new AddEmployeeBD().checkDseCount(locationid, desid);
				
			}
			
			JSONObject object=new JSONObject();
			object.accumulate("status", status);
			
			response.getWriter().print(object);
			
	
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AddEmployeeAction: checkDseCount : Ending");
		
		return null;	
	}
	
	
	
}
