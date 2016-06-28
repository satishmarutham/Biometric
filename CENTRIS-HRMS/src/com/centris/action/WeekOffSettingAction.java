/**
 * 
 */
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

import com.centris.DAO.DAOIMPL.WeekOffSettingDaoImpl;
import com.centris.delegate.EmployeeBD;
import com.centris.delegate.WeekOffSettingBD;
import com.centris.form.WeekoffSettingForm;
import com.centris.util.HelperClass;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

/**
 * @author satish
 * 
 */
public class WeekOffSettingAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(WeekOffSettingAction.class);

	public synchronized ActionForward searchEmployee(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffSettingAction: searchEmployee Starting");
		try {

			String empId = request.getParameter("EmpId");
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response",
					new WeekOffSettingBD().getWeekofDetailsByEmployeeId(empId));
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffSettingAction: searchEmployee Ending");
		return null;
	}

	public synchronized ActionForward updateWeekoffSetting(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffSettingAction: updateWeekoffSetting Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;

		try {

			WeekoffSettingForm weekoffSettingForm = (WeekoffSettingForm) form;
			WeekOffSettingBD offSettingBD = new WeekOffSettingBD();
			String userCode = HelperClass.getCurrentUserID(request);
			weekoffSettingForm.setUserCode(userCode);
			String status = offSettingBD
					.insertWeekOffDetails(weekoffSettingForm);

			request.getSession(false).setAttribute("message", status);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in WeekOffSettingAction: updateWeekoffSetting Ending");
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = StringUtils.WEEK_OFFSETTING;
		} else {
			forward = Director.DIRECTOR_WEEK_OFFSETTING;
		}
		return mapping.findForward(forward);
	}
}