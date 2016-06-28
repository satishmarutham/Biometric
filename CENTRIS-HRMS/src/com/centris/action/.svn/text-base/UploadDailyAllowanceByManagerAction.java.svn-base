package com.centris.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;

import com.centris.VO.DailyAllownaceDownloadVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.UploadDailyAllowanceByManagerBD;
import com.centris.exception.AITrackerException;
import com.centris.form.UploadDailyAllowanceByManagerForm;
import com.centris.util.HelperClass;
import com.centris.util.UploadEmployeeDailyAllowance;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class UploadDailyAllowanceByManagerAction extends DispatchAction {
	private static Logger logger = Logger
			.getLogger(UploadDailyAllowanceByManagerAction.class);

	public synchronized ActionForward getEmployeeDailyAllowance(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadDailyAllowanceByManager: getEmployeeDailyAllowance Starting");

		try {

			UploadDailyAllowanceByManagerForm uploadDailyAllowanceByManagerForm = (UploadDailyAllowanceByManagerForm) form;
			String status = null;
			Map<String, Object> employeeMap = null;
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String usercode = userDetailVO.getUserCode();
			String projectPath = request.getRealPath("/");
			if (uploadDailyAllowanceByManagerForm.getDailyAllowanceFile() != null) {

				employeeMap = new UploadEmployeeDailyAllowance().getExcelData(
						new File(projectPath + "UploadedImage/DailyAllowance/"
								+ usercode + "_"
								+ HelperClass.getCurrentSqlDate() + ".xls"),
						uploadDailyAllowanceByManagerForm
								.getDailyAllowanceFile());

				if (employeeMap != null) {
					employeeMap.put("ManagerCode", usercode);
					status = new UploadDailyAllowanceByManagerBD()
							.insertDailyAllowance(
									employeeMap,
									"UploadedImage/DailyAllowance/" + usercode
											+ "_"
											+ HelperClass.getCurrentSqlDate()
											+ ".xls");
				} else {
					request.setAttribute("error",
							"File format is incorrect ,Please try again ");
				}
			}
			List<DailyAllownaceDownloadVo> uploadedFileDetails = new ArrayList<DailyAllownaceDownloadVo>();

			uploadedFileDetails = new UploadDailyAllowanceByManagerBD()
					.getUploadedFileDetails(usercode);

			request.setAttribute("uploadedFileDetails", uploadedFileDetails);

			if (status.equalsIgnoreCase("Inserted")) {
				request.setAttribute("message",
						"Allowance details Uploaded Successfully");
			} else {
				request.setAttribute("error",
						"File format is incorrect ,Please try again ");
			}
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("key", employeeMap);
		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadDailyAllowanceByManager:getEmployeeDailyAllowance Ending");

		return mapping.findForward("empDailyAllowance");
	}

	public synchronized ActionForward downloadEmployeeDailyAllowance(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadDailyAllowanceByManager : downloadEmployeeDailyAllowance Ending");
		try {
			String filePath = request.getParameter("downloadFile");

			String projectPath = request.getRealPath("/");

			filePath = projectPath + filePath;

			String extention = filePath.substring(filePath.indexOf("/") + 1,
					(filePath.length()));

			if ((new File(filePath)).exists()) {
				ServletOutputStream out = response.getOutputStream();
				FileInputStream in = new FileInputStream(filePath);
				response.setContentType("APPLICATION/OCTET-STREAM");
				response.addHeader("content-disposition", "outline; filename="
						+ extention);
				int octet;
				while ((octet = in.read()) != -1)
					out.write(octet);
				in.close();
				out.close();
				in = null;
				out = null;
			} else {
				response.getWriter().print("File Not Found");
			}

		} catch (Exception exception) {
			logger.error(exception.getMessage(), exception);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in UploadDailyAllowanceByManager : downloadEmployeeDailyAllowance Ending");
		return null;
	}

}
