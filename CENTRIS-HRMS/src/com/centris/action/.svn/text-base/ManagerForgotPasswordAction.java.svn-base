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

import com.centris.DAO.ManagerForgetPasswordDao;
import com.centris.DAO.DAOIMPL.ManagerForgetPasswordDaoImpl;
import com.centris.delegate.ChangePasswordBD;
import com.centris.delegate.ManagerForgotPasswordBD;
import com.centris.delegate.ManagerMasterBD;
import com.centris.exception.AITrackerException;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

/**
 * @author sathish
 * 
 */
public class ManagerForgotPasswordAction extends DispatchAction {
	private static Logger logger = Logger
			.getLogger(ManagerForgotPasswordAction.class);

	public ActionForward resetManagerPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : resetManagerPassword Starting");

		try {
			String username = request.getParameter("username");
			String email = request.getParameter("email");

			System.out.println("Manager Forget " + username + " : " + email);

			ManagerForgotPasswordBD forgotPasswordBD = new ManagerForgotPasswordBD();

			int result = forgotPasswordBD.resetManagerPassword(username, email);
			JSONObject jsonObject = new JSONObject();
			String message = null;
			if (result > 0) {
				message = "successMessage";
			} else {
				message = "errorMessage";
			}
			jsonObject.put("message", message);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);

		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ChangePasswordAction : resetManagerPassword Ending");
		return null;
	}

}
