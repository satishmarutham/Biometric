/**
 * 
 */
package com.centris.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

import com.centris.DAO.DAOIMPL.EmployeeLeaveRequesDaoImpl;
import com.centris.DAO.DAOIMPL.EmployeeLeaveStatusDaoImpl;
import com.centris.POJO.EmployeeLeaveStatusPojo;
import com.centris.VO.UserDetailVO;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

/**
 * @author sathish
 *
 */
public class EmployeeLeaveStatusAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(EmployeeLeaveStatusAction.class);

	public ActionForward employeeLeaveStatusBySno(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveStatusAction : employeeLeaveStatusBySno Starting");

		EmployeeLeaveStatusDaoImpl daoImpl=new EmployeeLeaveStatusDaoImpl();

		int sno=Integer.parseInt(request.getParameter("Sno"));
		System.out.println("sno:::"+sno);

		HashMap<String,String> map= (HashMap<String, String>)request.getSession(false).getAttribute("privileges");

		List<EmployeeLeaveStatusPojo> getLeaveDetailsById=daoImpl.employeeLeaveStatusBySno(sno,map);
				
		JSONObject jsonObject=new JSONObject();
		jsonObject.accumulate("leaveDetailsBySno", getLeaveDetailsById);
		
	
	response.getWriter().println(jsonObject);
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveStatusAction: employeeLeaveStatusBySno Ending");
		return null;
	}
	
	public ActionForward download(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveStatusAction : download Starting");
		
		try {
			String filePath = request.getParameter("filepath");
			
			String EmployeeId = request.getParameter("sno");
		String fullpath=getServlet().getServletContext().getRealPath("")+ "/"+filePath;
		
			if ((new File(fullpath)).exists()) {
			
				ServletOutputStream out = response.getOutputStream();
				FileInputStream in = new FileInputStream(fullpath);
				response.setContentType("APPLICATION/OCTET-STREAM");
				response.addHeader("content-disposition","outline; filename=" + EmployeeId+ "." + "docx");
				int octet;
				while ((octet = in.read())!= -1)
					out.write(octet);
				in.close();
				out.close();
				in = null;
				out = null;
			} else {
				response.getWriter().print("File Not Found");
			}

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveStatusAction: download Ending");
		return null;

	}
	public ActionForward employeeLeaveStatusDownload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveStatusAction : employeeLeaveStatusDownload Starting");
		
		try {
			String filePath = request.getParameter("filepath");
	
		
	String fullpath=getServlet().getServletContext().getRealPath("")+ "/"+filePath;
		
			if ((new File(fullpath)).exists()) {
			
				ServletOutputStream out = response.getOutputStream();
				FileInputStream in = new FileInputStream(fullpath);
				response.setContentType("APPLICATION/OCTET-STREAM");
				response.addHeader("content-disposition","outline; filename=" + "Leave Request File"+ "." + "docx");
				int octet;
				while ((octet = in.read())!= -1)
					out.write(octet);
				in.close();
				out.close();
				in = null;
				out = null;
			} else {
				UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
				EmployeeLeaveStatusDaoImpl daoImpl=new EmployeeLeaveStatusDaoImpl();
				String userCode = userDetailVO.getUserCode();
				List<EmployeeLeaveStatusPojo> employeeLeaveStatusPojos = daoImpl.getLeaveStatus(userCode);
			

				JSONObject jsonObject = new JSONObject();
				jsonObject.accumulate("employeeLeaveStatusPojos",
						employeeLeaveStatusPojos);
				request.setAttribute("employeeLeaveStatusPojos",
						employeeLeaveStatusPojos);
				request.setAttribute("fileNotFound",
						"No File To Download");
				return mapping.findForward(StringUtils.EMPLOYEE_LEAVE_STATUS);
			}

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveStatusAction: employeeLeaveStatusDownload Ending");
		return null;

	}
}
