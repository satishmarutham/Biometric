/**
 * 
 */
package com.centris.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.impl.AvalonLogger;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.DAO.DAOIMPL.AdvanceSalaryRequestDaoImpl;
import com.centris.VO.AdvanceSalaryConsolidateReportVo;
import com.centris.VO.AdvanceSalaryRequestVo;
import com.centris.VO.AttendenceApprovelVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AdvanceSalaryRequestBD;
import com.centris.delegate.AttendenceApprovelBD;
import com.centris.form.AdvanceSalaryConsolidateReportForm;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

/**
 * @author satish
 *
 */
public class AdvanceSalaryRequestAction extends DispatchAction {
	
	private static Logger logger = Logger.getLogger(AdvanceSalaryRequestAction.class);
	
	
	

	public ActionForward saveAdvanceSalaryRequest(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestAction : saveAdvanceSalaryRequest Starting");
		UserDetailVO userDetailVO = (UserDetailVO) request
				.getSession(false).getAttribute("UserDetails");
		String currentUserId = userDetailVO.getUserCode();
		String employeeCode=(String)request.getParameter("employeeCodes");
		String projectCode=(String)request.getParameter("projectCodes");
		String salary=(String)request.getParameter("salary");
		String description=(String)request.getParameter("description");
	
		String[] employeeCodeArray=employeeCode.split(",");
		String[] projectCodeArray=projectCode.split(",");
		String[] salaryArray=salary.split(",");
		String[] descriptionArray=description.split(",");
		List<AdvanceSalaryRequestVo> advanceSalaryRequestVos=new LinkedList<AdvanceSalaryRequestVo>();
		AdvanceSalaryRequestBD advanceSalaryRequestBD=new AdvanceSalaryRequestBD();
		for(int i=0;i<employeeCodeArray.length;i++){
			AdvanceSalaryRequestVo advanceSalaryRequestVo=new AdvanceSalaryRequestVo();
			advanceSalaryRequestVo.setEmployeeCode(employeeCodeArray[i]);
			advanceSalaryRequestVo.setProjectCode(projectCodeArray[i]);
			advanceSalaryRequestVo.setSalary(salaryArray[i]);
			advanceSalaryRequestVo.setCreatedBy(currentUserId);
			advanceSalaryRequestVo.setComments(descriptionArray[i].trim());
			
			advanceSalaryRequestVos.add(advanceSalaryRequestVo);
		
			
		}
		String status=advanceSalaryRequestBD.saveAdvancedSalaryRequest(advanceSalaryRequestVos);
		
		JSONObject jsonObject=new JSONObject();
		if(status.equalsIgnoreCase(MessageConstants.MAIL_SENT)){
			
			request.getSession(false).setAttribute("message","Send Request Successfully.Need to Approve by Director");
			jsonObject.put("status",true);
		}else if(status.equalsIgnoreCase(MessageConstants.TRUE)){

			jsonObject.put("status",false);
			request.getSession(false).setAttribute("error","Send Request Successfully,Mail not sent");
		}
		else
		{
			jsonObject.put("status",false);
			request.getSession(false).setAttribute("error","Send Request failure");
		}
			response.getWriter().println(jsonObject);
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestAction : saveAdvanceSalaryRequest Ending");

		return null;
	}

	
	
	
	public ActionForward approveAdvancedSalary(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestAction : approveAdvancedSalary Starting");
		UserDetailVO userDetailVO = (UserDetailVO) request
				.getSession(false).getAttribute("UserDetails");
		String currentUserId = userDetailVO.getUserCode();
		String advanceSalaryCode=request.getParameter("advanceSalaryCode");
		String approvedAmount=request.getParameter("approvedAmount");
		AdvanceSalaryRequestVo advanceSalaryRequestVo=new AdvanceSalaryRequestVo();
		advanceSalaryRequestVo.setAdvanceSalaryCode(advanceSalaryCode);
		advanceSalaryRequestVo.setSalary(approvedAmount);
		advanceSalaryRequestVo.setCreatedBy(currentUserId);
		AdvanceSalaryRequestBD advanceSalaryRequestBD=new AdvanceSalaryRequestBD();
		int count=advanceSalaryRequestBD.approveAdvanceSalary(advanceSalaryRequestVo);
		JSONObject jsonObject=new JSONObject();
		jsonObject.accumulate("status", count);
		/*if(count==2){
			jsonObject.accumulate("status", true);
			request.setAttribute("success", "Advance Salary Approved Successfully");
		}else if(count==1){
			
			jsonObject.accumulate("status", false);
			request.setAttribute("error","Advance Salary Approved Successfully,Mail Not Sent");
			
		}
		else
		{
			jsonObject.accumulate("status", false);
			request.getSession(false).setAttribute("error","Please Try Again");
		}
		*/
		response.getWriter().println(jsonObject);
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestAction : approveAdvancedSalary Ending");

		return null;
	}
	
	
	
	
	public ActionForward rejectAdvanceSalary(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestAction : rejectAdvanceSalary Starting");
		UserDetailVO userDetailVO = (UserDetailVO) request
				.getSession(false).getAttribute("UserDetails");
		String currentUserId = userDetailVO.getUserCode();
		String advanceSalaryCode=request.getParameter("advanceSalaryCode");
		
		String approvedAmount=request.getParameter("approvedAmount");
		AdvanceSalaryRequestVo advanceSalaryRequestVo=new AdvanceSalaryRequestVo();
		if(approvedAmount==null || approvedAmount.equals("")){
			advanceSalaryRequestVo.setAprovedAmount(0.00);
		}
		else
		{
		
			advanceSalaryRequestVo.setAprovedAmount(Double.parseDouble(approvedAmount));
		}
		advanceSalaryRequestVo.setSalary(approvedAmount);
		advanceSalaryRequestVo.setAdvanceSalaryCode(advanceSalaryCode);
		advanceSalaryRequestVo.setCreatedBy(currentUserId);
		AdvanceSalaryRequestBD advanceSalaryRequestBD=new AdvanceSalaryRequestBD();
int count=advanceSalaryRequestBD.rejectAdvanceSalary(advanceSalaryRequestVo);
		
		JSONObject jsonObject=new JSONObject();
		if(count==2){
			jsonObject.accumulate("status","rejectSuccess");
			
		}else if(count==1){
			
			jsonObject.accumulate("status", "rejectSuccessMailNotSend");
			
			
		}
		else
		{
			jsonObject.accumulate("status", "rejectTryAgain");
			
		}
		response.getWriter().println(jsonObject);
logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestAction : rejectAdvanceSalary Ending");

		return null;
	}
	
	
	public ActionForward holdAdvanceSalary(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestAction : holdAdvanceSalary Starting");
		UserDetailVO userDetailVO = (UserDetailVO) request
				.getSession(false).getAttribute("UserDetails");
		String currentUserId = userDetailVO.getUserCode();
		String advanceSalaryCode=request.getParameter("advanceSalaryCode");
		String approvedAmount=request.getParameter("approvedAmount");
		
		AdvanceSalaryRequestVo advanceSalaryRequestVo=new AdvanceSalaryRequestVo();
		if(approvedAmount==null || approvedAmount.equals("")){
			advanceSalaryRequestVo.setAprovedAmount(0.00);
		}
		else
		{
		
			advanceSalaryRequestVo.setAprovedAmount(Double.parseDouble(approvedAmount));
		}
		
		
		
		advanceSalaryRequestVo.setAdvanceSalaryCode(advanceSalaryCode);
		advanceSalaryRequestVo.setCreatedBy(currentUserId);
		AdvanceSalaryRequestBD advanceSalaryRequestBD=new AdvanceSalaryRequestBD();
		int count=advanceSalaryRequestBD.holdAdvanceSalary(advanceSalaryRequestVo);
		JSONObject jsonObject=new JSONObject();
		
		if(count>0){
			jsonObject.accumulate("status", "holdSuccess");
		
		}
		else
		{
			jsonObject.accumulate("status", "holdTryAgain");
			
		}
		response.getWriter().println(jsonObject);
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestAction : holdAdvanceSalary Ending");

		return null;
	}
	
	
	public ActionForward removeMessage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestAction:removeMessage Starting");
		try {

			request.getSession().setAttribute("success", null);
			request.getSession().setAttribute("error", null);
			response.getWriter().print("Message Removed");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in AdvanceSalaryRequestAction:removeMessage Ending");
		
		return null;
	}
	
	
	public ActionForward advanceSalaryConsolidateReport(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestAction:advanceSalaryConsolidateReport Starting");
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			String currentUserId = userDetailVO.getUserCode();
			String currentUserName=userDetailVO.getUserFirstName();
		
			AdvanceSalaryConsolidateReportForm consolidateReportForm=(AdvanceSalaryConsolidateReportForm)form;
			
			request.setAttribute("toDate", consolidateReportForm.getToDate());
			request.setAttribute("fromDate",consolidateReportForm.getFromDate());
			request.setAttribute("groupBy",consolidateReportForm.getGroupBy());
			request.setAttribute("status", consolidateReportForm.getStatus());
			
			AdvanceSalaryConsolidateReportVo advanceSalaryReport=new AdvanceSalaryConsolidateReportVo();
			advanceSalaryReport.setDirectorCode(currentUserId);
			advanceSalaryReport.setStartDate(consolidateReportForm.getToDate().trim());
			advanceSalaryReport.setEndDate(consolidateReportForm.getFromDate().trim());
			advanceSalaryReport.setStatus(consolidateReportForm.getStatus());
			advanceSalaryReport.setGroupBy(consolidateReportForm.getGroupBy());
			advanceSalaryReport.setApprovedByName(currentUserName);
			
			
			AdvanceSalaryRequestBD advanceSalaryRequestBD=new AdvanceSalaryRequestBD();
			Map<String, List<AdvanceSalaryConsolidateReportVo>> advancedSalaryConsolidateMap=new HashMap<String, List<AdvanceSalaryConsolidateReportVo>>();
			if(consolidateReportForm.getGroupBy().equalsIgnoreCase("MAN")){
			
				advancedSalaryConsolidateMap=advanceSalaryRequestBD.advanceSalaryConsolidateReport(advanceSalaryReport);
			request.setAttribute("advancedSalaryConsolidateMap",advancedSalaryConsolidateMap);
			}
			else
			{
				advancedSalaryConsolidateMap=advanceSalaryRequestBD.advanceSalaryConsolidateReport(advanceSalaryReport);
				request.setAttribute("advancedSalaryConsolidateMapProject",advancedSalaryConsolidateMap);
	
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in AdvanceSalaryRequestAction:advanceSalaryConsolidateReport Ending");
		
		return mapping.findForward("advanceSalaryConsolidateReport");
			
	}
	
	
	
	

	
}

