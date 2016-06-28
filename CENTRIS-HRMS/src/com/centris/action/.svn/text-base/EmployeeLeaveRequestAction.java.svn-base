package com.centris.action;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import org.json.JSONObject;

import com.centris.DAO.DAOIMPL.EmployeeLeaveStatusDaoImpl;
import com.centris.POJO.EmployeeLeaveStatusPojo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.EmployeeLeaveRequestBD;
import com.centris.form.EmployeeLeaveRequestForm;
import com.centris.util.HelperClass;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class EmployeeLeaveRequestAction extends DispatchAction{

	private static 	Logger logger = Logger.getLogger(EmployeeLeaveRequestAction.class);
	public ActionForward leaveRequestHome(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveRequestAction : leaveRequestHome Starting");
		
		
		try{
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String usercode=userDetailVO.getUserCode();
					
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveRequestAction : leaveRequestHome Ending");
	
		return mapping.findForward(MessageConstants.EMPLOYEE_LEAVE_REQUEST);
	}

	public ActionForward AddLeaveRequest(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveRequestAction : AddLeaveRequest Starting");
		
	
		try{
			
			UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String usercode=userDetailVO.getUserCode();
			
			HashMap<String,String> privilegesMap=(HashMap<String, String>)request.getSession(false).getAttribute("privileges");
			
			String imagepath = null;
			String realPath = null;
		
			EmployeeLeaveRequestForm leavereqestForm=(EmployeeLeaveRequestForm)form;
		
			FileOutputStream outputStream1 = null;
			FormFile Path = leavereqestForm.getFileupload();
			
			String timestamp = new Timestamp(new Date().getTime()).toString()
					.replace(" ", "-").replace(":", "-").replace(".", "-");
			try
			{
		
			if (!Path.getFileName().equals("")) {
				imagepath = getServlet().getServletContext().getRealPath("")
						+ "/" + Path.getFileName();

				imagepath = getServlet().getServletContext().getRealPath("")
						+ "\\LeaveFileUploads" + "/" + timestamp + usercode+ "." + "docx";
				realPath = imagepath.substring(imagepath.indexOf("LeaveFileUploads/"));
				outputStream1 = new FileOutputStream(new File(imagepath));
				outputStream1.write(Path.getFileData());
			}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (outputStream1 != null) {
					outputStream1.close();
				}
			}	
		
			leavereqestForm.setFilepath(realPath);
			leavereqestForm.setUsercode(usercode);
		
			String status=new EmployeeLeaveRequestBD().AddLeaveRequestBD(leavereqestForm,privilegesMap);
		
		
			if(status.equalsIgnoreCase(MessageConstants.TRUE)){
				
				request.setAttribute("successmessage", MessageConstants.LEAVE_REQUEST_SUCCESS);
		
			}else if(status.equalsIgnoreCase(MessageConstants.MAIL_NOT_SENT)){
				
				request.setAttribute("errormessage", MessageConstants.LEAVE_REQUEST_FAILURE_MAIL_NOT_SEND);
			
			}else{
				
				request.setAttribute("errormessage", MessageConstants.LEAVE_REQUEST_FAILURE);
			}
			
		
		
	
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveRequestAction : AddLeaveRequestr Ending");
	
		return mapping.findForward(MessageConstants.EMPLOYEE_LEAVE_REQUEST);
	}
	
	public ActionForward validateDuplicateLeave(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveRequestAction : validateDuplicateLeave Starting");

		String startdate = (String) request.getParameter("startdate");
		String enddate = (String) request.getParameter("enddate");
		
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String usercode=userDetailVO.getUserCode();
		
		//String requestedto = (String) request.getParameter("leaverequestto");
		
		boolean statuscheck = new EmployeeLeaveRequestBD().validateDuplicateLeave(usercode, startdate, enddate);

		JSONObject object = new JSONObject();
		object.put("statuscheck", statuscheck);
		response.getWriter().print(object);
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveRequestAction : validateDuplicateLeave  Ending");
		return null;
	}
	
	
	public ActionForward updateLeaveRequest(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveRequestAction : updateLeaveRequest Starting");
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String usercode=userDetailVO.getUserCode();
		
		EmployeeLeaveStatusPojo employeeLeaveStatusPojo=new EmployeeLeaveStatusPojo();
		HashMap<String,String> map= (HashMap<String, String>)request.getSession(false).getAttribute("privileges");
		
		String imagepath = null;
		String realPath = null;
	
		EmployeeLeaveRequestForm leavereqestForm=(EmployeeLeaveRequestForm)form;
	
		FileOutputStream outputStream1 = null;
		FormFile Path = leavereqestForm.getFileupload();
	
		String timestamp = new Timestamp(new Date().getTime()).toString()
				.replace(" ", "-").replace(":", "-").replace(".", "-");
		try
		{
	   if(Path!=null){
		if (!(Path.getFileName()==null)) {
			imagepath = getServlet().getServletContext().getRealPath("")
					+ "/" + Path.getFileName();

			imagepath = getServlet().getServletContext().getRealPath("")
					+ "\\LeaveFileUploads" + "/" + timestamp + usercode+ "." + "docx";
		
			realPath = imagepath.substring(imagepath.indexOf("LeaveFileUploads/"));
			outputStream1 = new FileOutputStream(new File(imagepath));
			outputStream1.write(Path.getFileData());
		}
	}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (outputStream1 != null) {
				outputStream1.close();
			}
		}	
		leavereqestForm.setFilepath(realPath);
		String sno=request.getParameter("Sno");
		
		int serialNo=Integer.parseInt(sno);
		
		
		employeeLeaveStatusPojo.setNoofLeaves(Double.parseDouble(leavereqestForm.getNoofleaves()));
		employeeLeaveStatusPojo.setEndDate(leavereqestForm.getEnddate());
		employeeLeaveStatusPojo.setStartDate(leavereqestForm.getStartdate());
		employeeLeaveStatusPojo.setReasonforLeave(leavereqestForm.getReasonforleaves());
		employeeLeaveStatusPojo.setSno(serialNo);
		
		
		
		employeeLeaveStatusPojo.setRequestedTo(leavereqestForm.getLeaverequestto());
		employeeLeaveStatusPojo.setRequestedBy(usercode);
		employeeLeaveStatusPojo.setFilepaath(realPath);
		employeeLeaveStatusPojo.setLeavetype(leavereqestForm.getLeavetype());
		
EmployeeLeaveStatusDaoImpl daoImpl=new EmployeeLeaveStatusDaoImpl();

		String successMessage=daoImpl.updateEmployeeLeaveRequest(employeeLeaveStatusPojo,map);
	
	
		String userCode = userDetailVO.getUserCode();
		List<EmployeeLeaveStatusPojo> employeeLeaveStatusPojos = daoImpl
				.getLeaveStatus(userCode);
	

		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("employeeLeaveStatusPojos",
				employeeLeaveStatusPojos);
		request.setAttribute("employeeLeaveStatusPojos",
				employeeLeaveStatusPojos);
		if(successMessage.equalsIgnoreCase(MessageConstants.TRUE)){
			
			request.setAttribute("successMessage", MessageConstants.LEAVE_REQUEST_UPDATE_SUCCESS);

		}else if(successMessage.equalsIgnoreCase(MessageConstants.MAIL_NOT_SENT)){
			
			request.setAttribute("errorMessage", MessageConstants.LEAVE_REQUEST_UPDATE_FAILURE_MAIL_NOT_SEND);

		}else{
			
			request.setAttribute("errorMessage", MessageConstants.LEAVE_REQUEST_UPDATE_FAILURE);
		}
		
		
		

JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveRequestAction : updateLeaveRequest  Ending");
	
		
		return mapping.findForward(StringUtils.EMPLOYEE_LEAVE_STATUS);
	}
	
	public ActionForward checkUpdateDuplicateLeave(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveRequestAction : validateDuplicateLeave Starting");

		String startdate = (String) request.getParameter("startdate");
		String enddate = (String) request.getParameter("enddate");
		
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
		String usercode=userDetailVO.getUserCode();
		int sno=Integer.parseInt(request.getParameter("sno"));
		//String requestedto = (String) request.getParameter("leaverequestto");
		EmployeeLeaveStatusDaoImpl daoImpl=new EmployeeLeaveStatusDaoImpl();
		boolean statuscheck = daoImpl.validateUpdateDuplicateLeaveDao(usercode,startdate,enddate,sno);

		JSONObject object = new JSONObject();
		object.put("statuscheck", statuscheck);
		response.getWriter().print(object);
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeLeaveRequestAction : validateDuplicateLeave Ending");
		return null;
	}
	
	
}
