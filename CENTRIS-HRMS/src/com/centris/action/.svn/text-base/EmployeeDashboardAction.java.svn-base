package com.centris.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONArray;

import com.centris.DAO.DAOIMPL.EmployeeResumeCreationDaoImpl;
import com.centris.POJO.EmployeeResumeCreationPojo;
import com.centris.VO.ClaimesByManagerInEmpDashBoardVo;
import com.centris.VO.EmpVO;
import com.centris.VO.EmployeeDashboardVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.EmpDashBoardInManagerBD;
import com.centris.delegate.EmployeeBD;
import com.centris.delegate.EmployeeDashboardBD;
import com.centris.form.EmployeeDashBoardForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class EmployeeDashboardAction extends DispatchAction{

	private static 	Logger logger = Logger.getLogger(EmployeeDashboardAction.class);
	
	
	public ActionForward employeeDashboardHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardAction : employeeDashboardHome: Starting");
		  try{
		 
	        UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String currentuser=userDetailVO.getUserCode();
				
			String  empname=  request.getParameter("empName");
			String empId= request.getParameter("empId");
			request.setAttribute("EmployeeName", empname);
		
			request.setAttribute("PersonalDetails",new  EmployeeDashboardBD().getPersonalDetails(empId));
			EmployeeResumeCreationDaoImpl creationDao=new EmployeeResumeCreationDaoImpl();
			
			Map<String,List<EmployeeResumeCreationPojo>> resumeDetails=creationDao.getResumeDetails(currentuser);
			if(resumeDetails.size()!=0){
			for (Map.Entry<String, List<EmployeeResumeCreationPojo>> entry : resumeDetails.entrySet()) {
				if(entry.getKey()=="Hobbies"){
					request.setAttribute("Hobbies", entry.getValue());
				}
				else if(entry.getKey()=="Responsibilities"){
					
					request.setAttribute("Responsibilities",entry.getValue());
				}
			  
			else if(entry.getKey()=="TechnicalSkills"){
					
					request.setAttribute("TechnicalSkills",entry.getValue());
				}
			else if(entry.getKey()=="PursuitsList"){

				request.setAttribute("PursuitsList",entry.getValue());
			}

			else if(entry.getKey()=="CareerObjective"){

				request.setAttribute("CareerObjective",entry.getValue());
			}
			else if(entry.getKey()=="EmployeeDetails"){

				request.setAttribute("EmployeeDetails",entry.getValue());
			}
				
			else if(entry.getKey()=="Experience"){

				request.setAttribute("Experience",entry.getValue());
			}
			}
			}
			else
			{
				
			}
		  }catch (Exception e) {
				logger.error(e.getMessage(),e);
			
		}
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in EmployeeDashboardAction :employeeDashboardHome: Ending");

			return mapping.findForward(ApplicationConstants.EMPLOYEE_DASHBOARD);
	}
	
	
	public ActionForward moreAllowanceDeatailsHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardAction : moreAllowanceDeatails: Starting");
		
	    	String empId=request.getParameter("empId");
		  
	    	if(empId!=null){
			
		 	   request.setAttribute("employeeId", empId);
		 	  request.setAttribute("goBackToManager", "Manager");
		 	    request.setAttribute("empId", empId);
		 	  
		 	String empname=(String)request.getSession().getAttribute("DashboardEmployeeName");
		 	   request.setAttribute("empName", empname);
		 	   
		 	   
		 	  return mapping.findForward(ApplicationConstants.DAILY_ALLOWANCES_VIEW_IN_MANAGER); 
		 	   
		     }
		
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in EmployeeDashboardAction :moreAllowanceDeatails: Ending");

			return mapping.findForward(ApplicationConstants.DAILY_ALLOWANCES_VIEW);
	}
	
	public ActionForward moreAllowanceDeatails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardAction : moreAllowanceDeatails: Starting");
		
		
	         EmployeeDashBoardForm employeeDashBoardForm=(EmployeeDashBoardForm)form;
	     
	         UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String currentuser=userDetailVO.getUserCode();
			
			
		
						
			if(employeeDashBoardForm.getEmployeeId()!=null){

				
				  ArrayList<EmployeeDashboardVO> employeeallowancelist=new EmployeeDashboardBD()
                .getmoreAllowanceDeatailsByManagerBD(employeeDashBoardForm.getStartdate(),employeeDashBoardForm.getEnddate(),employeeDashBoardForm.getEmployeeId(),currentuser);  

                 request.setAttribute("MoreAllowanceDetails", employeeallowancelist);
                 request.setAttribute("goBackToManager", "Manager");
                 request.setAttribute("empId", employeeDashBoardForm.getEmployeeId());
                 String empname=(String)request.getSession().getAttribute("DashboardEmployeeName");
  		 	   request.setAttribute("empName", empname);
                 return mapping.findForward(ApplicationConstants.DAILY_ALLOWANCES_VIEW_IN_MANAGER);
						
	        
	         
			}else{
				  ArrayList<EmployeeDashboardVO> employeeallowancelist=new EmployeeDashboardBD()
                  .getmoreAllowanceDeatailsBD(employeeDashBoardForm.getStartdate(),employeeDashBoardForm.getEnddate(),currentuser);  

                      request.setAttribute("MoreAllowanceDetails", employeeallowancelist);


                 return mapping.findForward(ApplicationConstants.DAILY_ALLOWANCES_VIEW);
			}
		
			

			
	}

	public ActionForward moreExpensesDeatailsHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardAction : moreExpensesDeatailsHome: Starting");
		
			EmployeeDashBoardForm empForm=(EmployeeDashBoardForm)form;
			String month=null;
			
			String empId=HelperClass.getCurrentUserID(request);
			if(empForm.getMonth().equalsIgnoreCase("all")){
				
				month="%%";
			}else{
				
				month=empForm.getMonth();
			}
			
			ArrayList<ClaimesByManagerInEmpDashBoardVo> employeeClaimesList=new EmployeeDashboardBD().moreExpensesDeatailsHomeBD(empId, month, empForm.getYear());
	    
			
			request.setAttribute("employeeClaimesList", employeeClaimesList);
	    	  request.setAttribute("month", empForm.getMonth());
			   request.setAttribute("year", empForm.getYear());
		
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in EmployeeDashboardAction :moreExpensesDeatailsHome: Ending");

			return mapping.findForward(ApplicationConstants.EXPENSES_VIEW);
	}
	
	public ActionForward getMoreTravelAllowanceDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardAction : getMoreTravelAllowanceDetails: Starting");
		
		
	        EmployeeDashBoardForm employeeDashBoardForm=(EmployeeDashBoardForm)form;
	     
	         UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
	         String currentuser=userDetailVO.getUserCode();
	         
	      	if(employeeDashBoardForm.getEmployeeId()!=null){
				
	     	 request.setAttribute("MoreTravelDetails",new EmpDashBoardInManagerBD().getMoreTravelAllowanceBD(employeeDashBoardForm.getEmployeeId(),currentuser,employeeDashBoardForm.getStartdate(),employeeDashBoardForm.getEnddate()));
       
               request.setAttribute("goBackToManager", "Manager");
               request.setAttribute("empId", employeeDashBoardForm.getEmployeeId());
               String empname=(String)request.getSession().getAttribute("DashboardEmployeeName");
		 	   request.setAttribute("empName", empname);
		 		request.setAttribute("selectStartdate", employeeDashBoardForm.getStartdate());
				request.setAttribute("selectEnddate", employeeDashBoardForm.getStartdate());
				
		 	   return mapping.findForward(MessageConstants.MORETRAVELALLOWANCE_IN_MANAGER);
               
	     }else{
					
			 request.setAttribute("MoreTravelDetails",new EmployeeDashboardBD().getMoreTravelAllowanceBD(currentuser,employeeDashBoardForm.getStartdate(),employeeDashBoardForm.getEnddate()));
		
			request.setAttribute("selectStartdate", employeeDashBoardForm.getStartdate());
			request.setAttribute("selectEnddate", employeeDashBoardForm.getStartdate());
			
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in EmployeeDashboardAction : getMoreTravelAllowanceDetails: Ending");
			
			return mapping.findForward(MessageConstants.MORETRAVELALLOWANCE);
			
	     	}

	
	}

	
}
