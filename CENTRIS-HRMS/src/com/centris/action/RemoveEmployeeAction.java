package com.centris.action;

import java.sql.Timestamp;
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
import org.json.JSONObject;

import com.centris.VO.RemoveEmployeeVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AddEmployeeBD;
import com.centris.form.RemoveEmployeeForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;


/**
 * @author seshuma
 *
 */
public class RemoveEmployeeAction extends DispatchAction {
	
	private static 	Logger logger = Logger.getLogger(RemoveEmployeeAction.class);
	
	//Get search employee to remove
	public  ActionForward getSearchEmployeeNames(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		

		 logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in RemoveEmployeeAction: getSearchEmployeeNames : Starting");
		
		try{
			
		String removeempname  = (String)request.getParameter("name_startsWith");
		String maxrows=(String)request.getParameter("maxRows");
		
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String groupcode=userDetailVO.getGroupCode();
		
		 ArrayList<RemoveEmployeeVo> removeemploeevo=new AddEmployeeBD().getAllEmployeesBD(removeempname,maxrows,groupcode);
		
			JSONObject jo = new JSONObject();
			jo.accumulate("list1", removeemploeevo);
			response.getWriter().print(jo);
		
		
			}catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
			}
		
		 logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in RemoveEmployeeAction: getSearchEmployeeNames : Ending");
	
		return null;
	}
	
	//Removing employee
	public synchronized ActionForward removeEmployee(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		

		 logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in RemoveEmployeeAction: removeEmployee : Starting");
		
		try{
			
			RemoveEmployeeForm rform=(RemoveEmployeeForm)form;
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String modifiedby=userDetailVO.getUserCode();
			Timestamp modifieddate=HelperClass.getCurrentTimestamp();
			
			String status=new AddEmployeeBD().removeEmployee(rform.getEmpid(),modifiedby,modifieddate);
			
			request.setAttribute("message", status);
			
		}catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
			}
		

		 logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in RemoveEmployeeAction: removeEmployee : Ending");
		
	  
		return mapping.findForward("removeemployee");
	}

}
