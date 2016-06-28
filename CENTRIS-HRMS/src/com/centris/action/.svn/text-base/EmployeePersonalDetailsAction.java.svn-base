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
import com.centris.POJO.EmployeePersonalDetailsPojo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.EmployeePersonalDetailsBD;
import com.centris.form.EmployeePersonalDetailsForm;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class EmployeePersonalDetailsAction extends DispatchAction {
	private static Logger logger = Logger
			.getLogger(EmployeePersonalDetailsAction.class);

	public ActionForward checkDuplicatePersonalEmailId(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsAction: checkDuplicatePersonalEmailId Starting");
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");

			String emailId = request.getParameter("Emp_EmailId");
			String empCode = userDetailVO.getUserCode().trim();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response", new EmployeePersonalDetailsBD()
					.checkDuplicatePersonalEmailId(emailId, empCode));
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsAction: checkDuplicatePersonalEmailId Ending");
		return null;
	}

	public synchronized ActionForward UpdateEmployeeDetails(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsAction: UpdateEmployeeDetails Starting");
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			EmployeePersonalDetailsForm formObj = (EmployeePersonalDetailsForm) form;
			EmployeePersonalDetailsBD obj = new EmployeePersonalDetailsBD();
			formObj.setEmpCode(userDetailVO.getUserCode().trim());
			formObj.setServerPath(request.getRealPath("/"));

			String message = obj.UpdateEmployeeDetails(formObj);

			EmployeePersonalDetailsPojo employeeDetailsPojo = new EmployeePersonalDetailsPojo();
			employeeDetailsPojo.setUserCode(userDetailVO.getUserCode().trim());
			employeeDetailsPojo.setUserName(userDetailVO.getUserName().trim());

			request.setAttribute("employeePersonalDetails",	obj.getEmployeePersonalDetails(employeeDetailsPojo));

			if (message.equalsIgnoreCase("SAVED")) {
				request.setAttribute("success", "Details Updated Successfully");
			} else {
				request.setAttribute("warning",
						"Please try again, Data not Updated");
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsAction: UpdateEmployeeDetails Ending");
		return mapping.findForward(StringUtils.EMPLOYEE_GETPERSONALDETAILS);
	}
}