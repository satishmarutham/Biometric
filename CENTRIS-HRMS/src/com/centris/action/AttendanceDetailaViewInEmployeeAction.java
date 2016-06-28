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
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AttendanceDetailaViewInEmployeeBd;
import com.centris.form.AttendanceDetailaViewInEmployeeForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class AttendanceDetailaViewInEmployeeAction extends DispatchAction {
	
	private static 	Logger logger = Logger.getLogger(AttendanceDetailaViewInEmployeeAction.class);

	public ActionForward getMoreAttendanceDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AttendanceDetailaViewInEmployee : getMoreAttendanceDetails: Starting");
		
		AttendanceDetailaViewInEmployeeForm attForm=(AttendanceDetailaViewInEmployeeForm)form;
		
	    UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String userId=userDetailVO.getUserCode();
		String username=userDetailVO.getUserFirstName();
		
		 request.setAttribute("MoreAttendanceDetails", new AttendanceDetailaViewInEmployeeBd().getMoreAttendanceDetailsBd(attForm,userId) );
		
		 request.setAttribute("currentsearch", attForm);
		 
		 request.setAttribute("employeeId", userId);
		 request.setAttribute("empName", username);
		 
		 
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in AttendanceDetailaViewInEmployee :getMoreAttendanceDetails: Ending");

			return mapping.findForward(MessageConstants.MOREATTENDANCE);
	}

}
