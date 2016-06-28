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
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.POJO.TimesheetReconcilationPojo;
import com.centris.VO.DepartmentFilterVO;
import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.delegate.TimesheetReconciliationBD;
import com.centris.exception.AITrackerException;
import com.centris.form.TimesheetReconciliationForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class TimesheetReconciliationAction extends DispatchAction {
	
	private static 	Logger logger = Logger.getLogger(TimesheetReconciliationAction.class);
	
	public synchronized ActionForward timesheetReconciliation(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationAction:timesheetReconciliation Starting");
		try {
			
			ArrayList< DepartmentFilterVO > deptlist = new TimesheetReconciliationBD().getAllDepartments();
	    	request.setAttribute("AllDepartments", deptlist); 
	
		} catch (Exception exception) {
			exception.printStackTrace();
			logger.error(exception.getMessage(),exception);
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationAction : timesheetReconciliation Ending");
		
	    return mapping.findForward(ApplicationConstants.TIME_SHEET_RECONCIL);

	}
	
	public synchronized ActionForward getTimesheetData(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws AITrackerException,Exception
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationAction:getTimesheetData Starting");
		try{
			
			
			TimesheetReconciliationForm timesheetReconciliationform = (TimesheetReconciliationForm)form;
			
			String[] empoyeeArray=request.getParameterValues("employee");
			String[] departmentarray=request.getParameterValues("department");
			String[] managerarray=request.getParameterValues("manager");
			
			
			String empId=null;
			
			for(int i=0;i<empoyeeArray.length;i++){
				
				if(empId==null){
					
					empId=empoyeeArray[i];
				}else{
					
					empId=empId+","+empoyeeArray[i];
					
				}
			}
			
			String depId=null;
						
						for(int i=0;i<departmentarray.length;i++){
							
							if(depId==null){
								
								depId=departmentarray[i];
							}else{
								
								depId=depId+","+departmentarray[i];
								
							}
						}
			
			
				String mgrId=null;
							
							for(int i=0;i<managerarray.length;i++){
								
								if(mgrId==null){
									
									mgrId=managerarray[i];
								}else{
									
									mgrId=mgrId+","+managerarray[i];
									
								}
							}
							
							request.setAttribute("hEmpId", empId);
							request.setAttribute("hDepId", depId);
							request.setAttribute("hMgrId", mgrId);
							request.setAttribute("hstartDate", timesheetReconciliationform.getSdate());
							request.setAttribute("hEndDate",  timesheetReconciliationform.getEdate());
			
			
			TimesheetReconcilationPojo timesheetReconcilationPojo =new TimesheetReconcilationPojo();
			
			timesheetReconcilationPojo.setSdate(HelperClass.convertUIToDatabase(timesheetReconciliationform.getSdate()));
			timesheetReconcilationPojo.setEdate(HelperClass.convertUIToDatabase(timesheetReconciliationform.getEdate()));
			
			request.setAttribute("timesheetData",  new TimesheetReconciliationBD().getTimesheetData(timesheetReconcilationPojo,empoyeeArray));
	
			ArrayList< DepartmentFilterVO > deptlist = new TimesheetReconciliationBD().getAllDepartments();
	    	request.setAttribute("AllDepartments", deptlist);
	    	
		}
		catch(Exception exception){
			exception.printStackTrace();
			logger.error(exception.getMessage(),exception);
		}
		
		System.out.println("Control in TimesheetReconciliationAction:getTimesheetData Ending");
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationAction:getTimesheetData Ending");
		return mapping.findForward(ApplicationConstants.TIME_SHEET_RECONCIL);

	}
	
	public synchronized ActionForward updateTimeSheet(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws AITrackerException,Exception
	{
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationAction:updateTimeSheet Starting");
		try{
			
			System.out.println("timesheet recouncilation calling");
			
			//TimesheetReconciliationForm timesheetReconciliationform = (TimesheetReconciliationForm)form;
			
			//System.out.println("employee id from form ::: "+timesheetReconciliationform.getEmpId());
			
			
			String employeeId=request.getParameter("id");
			String date=request.getParameter("date");
			String inTime=request.getParameter("inTime");
			String outTime=request.getParameter("outTime");
			String totalhours=request.getParameter("workinghours");
			
			System.out.println("employee id  ::: "+employeeId);
			System.out.println("date id  ::: "+date);
			System.out.println("inTime id  ::: "+inTime);
			System.out.println("outTime id  ::: "+outTime);
			System.out.println("totalhours id  ::: "+totalhours);
			
			
			TimesheetReconcilationPojo timeSheetPojo=new TimesheetReconcilationPojo();
			
			timeSheetPojo.setDate(date);
			timeSheetPojo.setIntime(inTime);
			timeSheetPojo.setOuttime(outTime);
			timeSheetPojo.setWorkinghours(totalhours);
			timeSheetPojo.setEmpId(employeeId);
			timeSheetPojo.setCurrentUserCode(HelperClass.getCurrentUserID(request));
			
			String status = new TimesheetReconciliationBD().updateTimeSheet(timeSheetPojo);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("status", status);
			response.getWriter().print(jsonObject);
		}
		catch(Exception exception){
			exception.printStackTrace();
			logger.error(exception);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationAction:updateTimeSheet Ending");
		return null;

	}
	
	public synchronized  ActionForward getManagersByDept(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationAction: getManagersByDept Starting");
     try{
    
    	 String depts = request.getParameter("dept");
    	 
		ArrayList<ManagerFilterVO> manglist = new TimesheetReconciliationBD().getManagersByDept(depts);
	
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
 				+ " Control in TimesheetReconciliationAction : getManagersByDept Ending");
		return null;
	}
	
	public synchronized  ActionForward getEmployeeByMang(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in TimesheetReconciliationAction: getEmployeeByMang Starting");
     try{
    
    	 String manager = request.getParameter("manager");
    	 
		ArrayList<EmployeeFilterVO> emplist = new TimesheetReconciliationBD().getEmployeesByMang(manager);
	
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
 				+ " Control in TimesheetReconciliationAction : getEmployeeByMang Ending");
		return null;
	}
	
	
	
}
