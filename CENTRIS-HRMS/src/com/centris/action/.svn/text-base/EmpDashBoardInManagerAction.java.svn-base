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

import com.centris.DAO.DAOIMPL.EmployeeLeaveRequesDaoImpl;
import com.centris.VO.AdvanceSalByMgrInEmpDashBoardVo;
import com.centris.VO.ClaimesByManagerInEmpDashBoardVo;
import com.centris.VO.EmpDashBoardInManagerVO;
import com.centris.VO.EmpVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.EmpDashBoardInManagerBD;
import com.centris.delegate.EmployeeDashboardBD;
import com.centris.delegate.TimeSheetReportBD;
import com.centris.form.EmployeeDashBoardForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.ApplicationConstants;
import com.centris.util.constants.MessageConstants;

public class EmpDashBoardInManagerAction extends DispatchAction {
	
	
	private static 	Logger logger = Logger.getLogger(EmpDashBoardInManagerAction.class);
	
	public ActionForward employeeDashboardHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpDashBoardInManagerAction : employeeDashboardHome: Starting");
		  try{
			  
			  UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String currentuser=userDetailVO.getUserCode();
				
			String  empname=  request.getParameter("empName");
			String empId= request.getParameter("empId");
			request.setAttribute("EmployeeName", empname);
			request.setAttribute("empId", empId);
			
			EmpDashBoardInManagerBD managerbd=new EmpDashBoardInManagerBD();
			
			
			ArrayList<EmpDashBoardInManagerVO> currentmonthattendance=new ArrayList<EmpDashBoardInManagerVO>();
			currentmonthattendance.add(managerbd.getAttendanceDetails(empId));
				
			
			request.setAttribute("PersonalDetails",managerbd.getPersonalDetails(empId));
			request.setAttribute("AttendanceDetails",currentmonthattendance);
			request.setAttribute("LeaveDeatils",managerbd.getLeaveDetails(empId,currentuser));
			request.setAttribute("NotAprrovedAttendance",managerbd.getNotAprrovedAttendance(empId));
			request.setAttribute("DailyAllowances",managerbd.getManagerDailyAllowances(empId,currentuser));
			request.setAttribute("ExpensesDetails", managerbd.getClaimsByManagerBD(empId));
			request.setAttribute("ADVANCESALARYDETAILS", managerbd.getAdvanceSalDetailsBD(empId));
			request.setAttribute("TravelDetails", managerbd.getTravelAllowanceBD(empId,currentuser));
			
	        request.setAttribute("employeeId", empId);
	        
	        
	        request.getSession(false).setAttribute("DashboardEmployeeName", empname);
	
		  }catch (Exception e) {
				logger.error(e.getMessage(),e);
			
		}
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in EmpDashBoardInManagerAction :employeeDashboardHome: Ending");

			return mapping.findForward(ApplicationConstants.EMPLOYEE_DASHBOARD_IN_MGR);
	}
	
	
	public ActionForward getSearchEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpDashBoardInManagerAction : getSearchEmployee: Starting");
		  try{
			
			  UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
				String currentuser=userDetailVO.getUserCode();
				
				String searchTerm=request.getParameter("searchTerm");
				
			 ArrayList<EmpVO> employeelist=new EmpDashBoardInManagerBD().getSearchEmployee(currentuser,searchTerm);
		     request.setAttribute("EmployeeDetails", employeelist);	
		
		    }catch (Exception e) {
				logger.error(e.getMessage(),e);
			
			}
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in EmpDashBoardInManagerAction  : getSearchEmployee: Ending");

			return mapping.findForward(ApplicationConstants.ALL_EMPLOYEES_UNDER_MANAGER);
	}
	
	
	public ActionForward moreAdavanceSalaryDeatailsHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpDashBoardInManagerAction : moreAdavanceSalaryDeatailsHome: Starting");
		
		String userType=null;
		ArrayList<AdvanceSalByMgrInEmpDashBoardVo> employeelist=null;
		String forward=null;
		try{
			  
			  userType=HelperClass.getCurrentUserIDType(request);
			  
			  
			
				EmployeeDashBoardForm empForm=(EmployeeDashBoardForm)form;
				String month=null;
				if(empForm.getMonth().equalsIgnoreCase("all")){
					
					month="%%";
				}else{
					
					month=empForm.getMonth();
				}
				
				if(userType.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)){			
			
					
				String empId=null;
				
				if(empForm.getEmployeeId().equalsIgnoreCase("all")){
					
					empId="%%";
				}else{
					
					empId=empForm.getEmployeeId();
				}
				
			  employeelist=new EmpDashBoardInManagerBD().getAdvanceSalCompleteDetailsBD(empId, month, empForm.getYear());
			  request.setAttribute("empId", empForm.getEmployeeId());
				}else{
					
					employeelist=new EmpDashBoardInManagerBD().getAdvanceSalCompleteDetailsBD(HelperClass.getCurrentUserID(request), month, empForm.getYear());
				}
			 request.setAttribute("EmployeeDetails", employeelist);	
		     
		     request.setAttribute("month", empForm.getMonth());
		     request.setAttribute("year", empForm.getYear());
		
		    }catch (Exception e) {
				logger.error(e.getMessage(),e);
				e.printStackTrace();
			
			}
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in EmpDashBoardInManagerAction  : moreAdavanceSalaryDeatailsHome: Ending");

			if(userType.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)){
				
				forward=ApplicationConstants.EMPLOYEE_ADVANCE_SALARY_DETAILS;
			
			
			}else{
				forward=ApplicationConstants.EMPLOYEEDASHBOARD_ADVANCE_SALARY_DETAILS;
			}
			
			return mapping.findForward(forward);
	}
	
	public ActionForward moreExpenseDeatails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpDashBoardInManagerAction : moreExpenseDeatails: Starting");
		
		EmployeeDashBoardForm empForm=(EmployeeDashBoardForm)form;
		
		String month= empForm.getMonth();
		String year= empForm.getYear();
		String empid= empForm.getEmployeeId();
		
		 UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String currentuser=userDetailVO.getUserCode();
		
		  ArrayList<ClaimesByManagerInEmpDashBoardVo> employeeClaimesList=new EmpDashBoardInManagerBD().moreExpensesDeatailsHomeBD(empid, month, year,currentuser);
	    
			
			   request.setAttribute("employeeClaimesList", employeeClaimesList);
	    	    request.setAttribute("month", empForm.getMonth());
			   request.setAttribute("yearVal", empForm.getYear());
			   request.setAttribute("empId", empid);
				
			   
			   
			   request.setAttribute("ACC_YEAR",new TimeSheetReportBD().getAccYear());
				  
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in EmpDashBoardInManagerAction :moreExpenseDeatails: Ending");

			return mapping.findForward(MessageConstants.MORE_EXPENSE_DETAILS_IN_MANAGER);
	}
	
}
