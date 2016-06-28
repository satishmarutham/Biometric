package com.centris.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;



import com.centris.DAO.DAOIMPL.EmployeeForgotPassDaoImpl;
import com.centris.delegate.EmployeeForgotPassBD;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class EmployeeForgotPassAction extends DispatchAction{

	private static Logger logger = Logger.getLogger(EmployeeForgotPassAction.class);
	
	public ActionForward employeeForgotPasswordHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeForgotPassAction: employeeForgotPassword : Starting");
		
		
		String status=request.getParameter("status");
		if(status!=null){
			request.setAttribute("message", status);
		}
		
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeForgotPassAction: employeeForgotPassword : Ending");
		return mapping.findForward(MessageConstants.EMPLOYEE_FORGOT_PASSWORD_HOME);
	}

	public ActionForward checkEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeForgotPassAction: checkEmployee : Starting");
		
		try{
		String dateofbirth=request.getParameter("dateofbirth");
		String emp_official_emailid=request.getParameter("emp_official_emailid");
		
		
		int status=new EmployeeForgotPassBD().checkEmployeeBD(dateofbirth,emp_official_emailid);
		
		JSONObject jsonObject = new JSONObject();
		String message = null;
		if (status > 0) {
			message = "successMessage";
		} else {
			message = "errorMessage";
		}
		jsonObject.put("message", message);
		response.getWriter().print(jsonObject);
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeForgotPassAction: checkEmployee : Ending");
		return null;
	}
	
	
	
}
