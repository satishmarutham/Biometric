package com.centris.action;

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
import org.json.JSONObject;

import com.centris.VO.DailyEmployeeAllowanceVO;
import com.centris.delegate.EmployeeDailyAllowanceBD;
import com.centris.exception.AITrackerException;
import com.centris.form.EmployeeDailyAllowanceForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class EmployeeDailyAllowanceAction extends DispatchAction {
	private static Logger logger = Logger
			.getLogger(EmployeeDailyAllowanceAction.class);

	public ActionForward viewEmployeeDailyAllowance(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDailyAllowanceAction : viewEmployeeDailyAllowance Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {
			EmployeeDailyAllowanceForm employeeDailyAllowanceForm = (EmployeeDailyAllowanceForm) form;
			// List<DailyEmployeeAllowanceVO> dailyEmployeeAllowanceVOList= new
			// EmployeeDailyAllowanceBD().viewEmployeeDailyAllowance(employeeDailyAllowanceForm);
			Map<String, List<DailyEmployeeAllowanceVO>> dailyEmployeeAllowanceVOList = new EmployeeDailyAllowanceBD()
					.viewEmployeeDailyAllowanceByManger(employeeDailyAllowanceForm);

			if (dailyEmployeeAllowanceVOList.size() != 0) {
				request.setAttribute("DailyEmployeeAllowanceVOList",
						dailyEmployeeAllowanceVOList);
			} else {

				request.setAttribute("message",
						"No records found for selected date");
			}
			request.setAttribute("employeeDailyAllowanceForm",
					employeeDailyAllowanceForm);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDailyAllowanceAction : viewEmployeeDailyAllowance Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.EMPLOYEE_DAILY_ALLOWANCE;
		} else {
			forward = Director.DIRECTOR_EMP_DAILY_ALLOW;
		}
		return mapping.findForward(forward);
	}

	public ActionForward downloadEmployeeDailyAllowance(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDailyAllowanceAction : downloadEmployeeDailyAllowance Starting");

		try {
			String date = request.getParameter("date");
			EmployeeDailyAllowanceForm employeeDailyAllowanceForm = new EmployeeDailyAllowanceForm();
			employeeDailyAllowanceForm.setDailyAllowanceDate(date);
			List<DailyEmployeeAllowanceVO> dailyEmployeeAllowanceVOList = new EmployeeDailyAllowanceBD()
					.viewEmployeeDailyAllowance(employeeDailyAllowanceForm);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDailyAllowanceAction : downloadEmployeeDailyAllowance Ending");
		return null;
	}

	public ActionForward chcekRecords(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDailyAllowanceAction : chcekRecords Starting");

		try {
			String date = request.getParameter("date");

			boolean status = new EmployeeDailyAllowanceBD().chcekRecords(date);

			JSONObject object = new JSONObject();
			object.put("status", status);

			response.getWriter().print(object);
			;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDailyAllowanceAction : chcekRecords Ending");
		return null;
	}
}