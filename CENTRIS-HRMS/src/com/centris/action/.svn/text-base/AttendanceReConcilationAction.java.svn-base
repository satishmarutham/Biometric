package com.centris.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
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

import com.centris.VO.AttendanceReconcilationVO;
import com.centris.VO.DepartmentFilterVO;
import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.EmployeeVO;
import com.centris.VO.GroupMasterVO;
import com.centris.VO.LocationMasterVo;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.ProjectFilterVo;
import com.centris.VO.ShiftMasterVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AttendanceReconcillationBD;
import com.centris.delegate.LocationMasterBD;
import com.centris.delegate.ShiftMasterBD;
import com.centris.util.AttedenceReconcillationUtility;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;




/**
 * @author Swathi
 *
 */
public class AttendanceReConcilationAction extends DispatchAction {


	private static Logger logger = Logger.getLogger(AttendanceReConcilationAction.class);

	public synchronized  ActionForward attendanceReconcilationHome(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceReConcilationAction:attendanceReconcilationHome Starting");
   try{
   
		ArrayList< DepartmentFilterVO > deptlist = new AttendanceReconcillationBD().getAllDepartments();
    	request.setAttribute("AllDepartments", deptlist); 
		
    	String statusval=request.getParameter("status");
		if(statusval!=null) {
			if(statusval.equalsIgnoreCase(MessageConstants.TRUE)){
			
				request.setAttribute("successMsg",MessageConstants.ATTENDANCE_RECONCIL_INSERT_SUCCESS);
			}else{
				
				request.setAttribute("failureMsg",MessageConstants.ATTENDANCE_RECONCIL_INSERT_FAILURE);
			}
	  }
   	
     }catch(Exception e){
	   e.printStackTrace();
	   logger.error(e.getMessage(),e);
     }
   
   JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in AttendanceReConcilationAction:attendanceReconcilationHome Ending");
		return mapping.findForward(MessageConstants.ATTENDANCE_RECONCILATION);
	}
	
	
	
	public synchronized  ActionForward getManagersByDept(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceReConcilationAction: getManagersByDept Starting");
     try{
    
    	 String depts = request.getParameter("dept");
    	 
		ArrayList<ManagerFilterVO> manglist = new AttendanceReconcillationBD().getManagersByDept(depts);
	
		JSONObject jsonobject = new JSONObject();
		jsonobject.accumulate("ManagerList", manglist);
		response.getWriter().print(jsonobject);
			
         }catch(Exception e){
        	 logger.error(e.getMessage(),e);
 		     e.printStackTrace();
 	     }
 	   
 	   JLogger.log(0, JDate.getTimeString(new Date())
 				+ MessageConstants.END_POINT);
 		logger.info(JDate.getTimeString(new Date())
 				+ " Control in AttendanceReConcilationAction : getManagersByDept Ending");
		return null;
	}
	
	
	public synchronized  ActionForward getEmployeeByMang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceReConcilationAction: getEmployeeByMang Starting");
     try{
    
    	 String manager = request.getParameter("manager");
    	 
		ArrayList<EmployeeFilterVO> emplist = new AttendanceReconcillationBD().getEmployeesByMang(manager);
	
		JSONObject jsonobject = new JSONObject();
		jsonobject.accumulate("employeeList", emplist);
		response.getWriter().print(jsonobject);
			
         }catch(Exception e){
        	 logger.error(e.getMessage(),e);
 		     e.printStackTrace();
 	     }
 	   
 	   JLogger.log(0, JDate.getTimeString(new Date())
 				+ MessageConstants.END_POINT);
 		logger.info(JDate.getTimeString(new Date())
 				+ " Control in AttendanceReConcilationAction : getEmployeeByMang Ending");
		return null;
	}
	
	public synchronized  ActionForward getEmployeeAttendance(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceReConcilationAction:  getEmployeeAttendance Starting");
     try{
		String employeeId = request.getParameter("employeeVal");
		String date = request.getParameter("dateVal");
		ArrayList<AttendanceReconcilationVO> employeeinfolist = new AttendanceReconcillationBD().getEmployeeAttendance(employeeId, date);

		JSONObject jsonobject = new JSONObject();
		jsonobject.accumulate("EmployeeInfoList", employeeinfolist);
		response.getWriter().print(jsonobject);
     
     }catch(Exception e){
    	 logger.error(e.getMessage(),e);
    	 e.printStackTrace();
  	     }
  	   
  	   JLogger.log(0, JDate.getTimeString(new Date())
  				+ MessageConstants.END_POINT);
  		logger.info(JDate.getTimeString(new Date())
  				+ " Control in AttendanceReConcilationAction:  getEmployeeAttendance Ending");
		return null;
	}

	public synchronized  ActionForward attendnaceReconcilInsertion(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceReConcilationAction:getEmployeeAttendance Starting");
     try{
		Enumeration<?> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			Object values = e.nextElement();
			System.out.println(values);
		}
		String[] employeeids;
		String[] paybleVal;
		String[] notpaybleVal;
		String result=null;
		
		String[] employeeIdVal = request.getParameterValues("employeeid[]");
		String[] payble = request.getParameterValues("payble[]");
		String[] notpayble = request.getParameterValues("notpayble[]");
		String date = request.getParameter("date");
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String createdby = userDetailVO.getUserCode();


		for (int i = 0; i < employeeIdVal.length; i++) {
			for (int j = i; j <= i; j++) {
				for (int k = j; k <= j; k++) {
					if (payble[j].equalsIgnoreCase("")
							&& notpayble[k].equalsIgnoreCase("")) {

					} else {
						employeeids = employeeIdVal[i].split(",");
						paybleVal = payble[j].split(",");
						notpaybleVal = notpayble[k].split(",");
						
					if (!payble[j].equalsIgnoreCase("")) {
							for (int m = 0; m < paybleVal.length; m++) {
								AttedenceReconcillationUtility utility = new AttedenceReconcillationUtility();
								
								ArrayList<String> al = utility
										.getReasonAndShortName(paybleVal[m]);
								String reason = al.get(0);
								String shortname = al.get(1);
								result = new AttendanceReconcillationBD()
										.attendnaceReconcilInsertion(employeeids,
												paybleVal, notpaybleVal,
												reason, shortname, date,createdby);

							}
						} else {

							for (int m = 0; m < notpaybleVal.length; m++) {
								AttedenceReconcillationUtility utility = new AttedenceReconcillationUtility();
								ArrayList<String> al = utility
										.getReasonAndShortName(notpaybleVal[m]);
								String reason = al.get(0);
								String shortname = al.get(1);
								result = new AttendanceReconcillationBD()
										.attendnaceReconcilInsertion(employeeids,
												paybleVal, notpaybleVal,
												reason, shortname, date,createdby);
							}
						}

					}
				}
			}
		}
		
	
		
		JSONObject jsonobject = new JSONObject();
		jsonobject.put("result", result);
		response.getWriter().print(jsonobject);
   
     }catch(Exception e){
   		e.printStackTrace();
   	     }
   	   
   	   JLogger.log(0, JDate.getTimeString(new Date())
   				+ MessageConstants.END_POINT);
   		logger.info(JDate.getTimeString(new Date())
   				+ " Control in AttendanceReConcilationAction:getEmployeeAttendance Ending");
		return null;
	}

}
