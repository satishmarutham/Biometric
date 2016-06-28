package com.centris.action;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;

import com.centris.VO.EmployeeAttendancePostingVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.EmployeeAttendancePostingBD;
import com.centris.exception.AITrackerException;
import com.centris.form.EmployeeAttendancePostingForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class EmployeeAttendancePostingAction extends DispatchAction {
	private static Logger logger = Logger
			.getLogger(EmployeeAttendancePostingAction.class);

	public ActionForward updateAttendanceDetails(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeAttendancePostingAction : updateAttendanceDetails Starting");

		try {
			EmployeeAttendancePostingForm employeeAttendancePostingForm= (EmployeeAttendancePostingForm)form;
		
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			employeeAttendancePostingForm.setEmpId(userDetailVO.getUserCode());
			
			HashMap<String, String> privilegesMap=(HashMap<String, String>)request.getSession(false).getAttribute("privileges");
			
			EmployeeAttendancePostingVo employeeAttendancePostingVo= new EmployeeAttendancePostingBD().updateAttendanceDetails(employeeAttendancePostingForm,privilegesMap);
			
			
			JSONObject jsonobject=new JSONObject();
			jsonobject.put("message", employeeAttendancePostingVo.getResponse());
			response.getWriter().print(jsonobject);
			
			
			//request.setAttribute("message", employeeAttendancePostingVo.getResponse());
			

			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAttendancePostingAction : updateAttendanceDetails Ending");
		return null;
	}

}
