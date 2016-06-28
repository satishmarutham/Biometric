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
import org.json.JSONObject;

import com.centris.POJO.EmployeeExpenseDetailsPojo;
import com.centris.VO.EmployeeExpenseDetailsVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.EmployeeExpenseDetailsBD;
import com.centris.delegate.TimeSheetReportBD;
import com.centris.exception.AITrackerException;
import com.centris.form.EmployeeExpenseDetailsForm;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class EmployeeExpenseDetailsAction extends DispatchAction {
	private static Logger logger = Logger
			.getLogger(EmployeeExpenseDetailsAction.class);

	public ActionForward checkEmployeeExpense(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsAction : checkEmployeeExpense Starting");

		String year = request.getParameter("sel_Year");
		String month = request.getParameter("sel_Month");
	
		EmployeeExpenseDetailsBD delegateObj = new EmployeeExpenseDetailsBD();
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String userCode = userDetailVO.getUserCode();
			
			Map<String,String> userpriviliges =(Map<String,String>)request.getSession(false).getAttribute("privileges");
			String userprevstatus = userpriviliges.get(MessageConstants.MANAGER);
			
			String result = delegateObj.checkEmployeeExpenseDetails(userCode,year, month,userprevstatus);
			
			JSONObject object = new JSONObject();
			object.accumulate("expense_Result", result);
			response.getWriter().print(object);
		
		
		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsAction : checkEmployeeExpense Ending");
		return null;
	}

	public ActionForward saveEmployeeExpense(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsAction : saveEmployeeExpense Starting");

		EmployeeExpenseDetailsForm formObj = (EmployeeExpenseDetailsForm) form;
		EmployeeExpenseDetailsBD delegateObj = new EmployeeExpenseDetailsBD();

		String result = null;
		try {
			result = delegateObj.saveEmployeeExpenseDetails(formObj);
			JSONObject object = new JSONObject();
			object.accumulate("expense_Result", result);
			response.getWriter().print(object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsAction : saveEmployeeExpense ");
		return null;
	}
	
	public ActionForward getProjectRefCode(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsAction : getProjectRefCode Starting");


		try {
			
			String projectId=request.getParameter("projectId");
			
			String projectRefCode=new EmployeeExpenseDetailsBD().getProjectRefCodeBD(projectId);
			
			JSONObject object = new JSONObject();
			object.accumulate("projectRefCode", projectRefCode);
			response.getWriter().print(object);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsAction : getProjectRefCode ");
		return null;
	}
	
	public ActionForward getEmployeeExpenses(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsAction : getEmployeeExpenses Starting");
		try {
			
			String expensecode=request.getParameter("expensecode");
	 
			String monthval=request.getParameter("monthval");
			String yearval=request.getParameter("yearval");
		
			
			EmployeeExpenseDetailsBD  expensebd =	new EmployeeExpenseDetailsBD();
            request.setAttribute("localconveyanceList", expensebd.getlocalconveyanceExpense(expensecode));
			request.setAttribute("staffExpenselist", expensebd.getStaffExpenses(expensecode));
			request.setAttribute("travelExpenselist", expensebd.getTravelExpenses(expensecode));
			request.setAttribute("telephoneExpenselist", expensebd.getTelephoneExpenses(expensecode));
			request.setAttribute("purchaseExpenselist", expensebd.getPurchaseExpenses(expensecode));
			request.setAttribute("otherWorkExpenselist", expensebd.getOtherWorkExpenses(expensecode));
			request.setAttribute("miscellaneousExpenselist", expensebd.getMiscellaneousExpenses(expensecode));
			request.setAttribute("monthlyExpensesvo", expensebd.getMonthlyExpenses(expensecode));
				
			EmployeeExpenseDetailsBD delegateObj = new EmployeeExpenseDetailsBD();
			List<EmployeeExpenseDetailsVo> employeeDetails = new ArrayList<EmployeeExpenseDetailsVo>();
			EmployeeExpenseDetailsPojo obj = new EmployeeExpenseDetailsPojo();
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			obj.setUserCode((userDetailVO.getUserCode().trim()));
			obj.setUserName((userDetailVO.getUserName().trim()));

			employeeDetails = delegateObj.getEmployeeDetails(obj);
			String bioId = null;
			String empId = null;
			String Name = null;
			String Email = null;
			String Designation = null;
			String Contact = null;
			String ManagerName = null;
			String ManagerId = null;
			for (EmployeeExpenseDetailsVo kk : employeeDetails) {
				bioId = kk.getEmp_BioId();
				Name = kk.getEmp_Name();
				Email = kk.getEmp_MailId();
				Designation = kk.getEmp_Designation();
				Contact = kk.getEmp_ContactNumber();
				ManagerName = kk.getEmp_ProjectManagerName();
				empId = kk.getEmp_ID();
				ManagerId = kk.getEmp_ManagerId();
			}
		
			request.setAttribute("employee_BioID", bioId);
			request.setAttribute("employee_ID", empId);
			request.setAttribute("employee_Name", Name);
			request.setAttribute("employee_Email", Email);

			request.setAttribute("employee_Desig", Designation);
			request.setAttribute("employee_Contact", Contact);

			Map<String,String> userpriviliges =(Map<String,String>)request.getSession(false).getAttribute("privileges");
			String userprevstatus = userpriviliges.get(MessageConstants.MANAGER);
			Map<String,String> mangdiecormap= delegateObj.getManagerDireDetails(empId);
			
			
			if(MessageConstants.YES.equalsIgnoreCase(userprevstatus)){
					
				request.setAttribute("employee_ManagerName", mangdiecormap.get("DireName"));
				request.setAttribute("employee_MangId", mangdiecormap.get("MangCode"));
				request.setAttribute("LoginUsermangid", mangdiecormap.get("MangCode"));
		
			}else{
				
			request.setAttribute("employee_ManagerName", ManagerName);
			request.setAttribute("employee_MangId", ManagerId);
		
			
			}
			
			request.setAttribute("ACC_YEAR",new TimeSheetReportBD().getAccYear());
			request.setAttribute("monthval", monthval);
			request.setAttribute("yearval", yearval);
			request.setAttribute("ExpenseCode", expensecode);
		
		
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsAction : getEmployeeExpenses Ending ");
	
		return mapping.findForward(StringUtils.EMPLOYEE_EXPENSE_DETAILS);
	}
	
	
	
	
	
}