package com.centris.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONArray;
import org.json.JSONObject;

import com.centris.DAO.DAOIMPL.ManagerLeaveConfirmationDaoImpl;
import com.centris.DAO.DAOIMPL.ProjectMasterDaoImpl;
import com.centris.POJO.ManagerLeaveConfirmationPojo;
import com.centris.VO.AdvanceSalaryRequestVo;
import com.centris.VO.AttendenceApprovelVo;
import com.centris.VO.EmpVO;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AdvanceSalaryRequestBD;
import com.centris.delegate.AttendenceApprovelBD;
import com.centris.delegate.AttendenceNotApprovedBD;
import com.centris.delegate.EmpDashBoardInManagerBD;
import com.centris.delegate.TimeSheetReportBD;
import com.centris.exception.AITrackerException;
import com.centris.util.HelperClass;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class ManagerMenuAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(ManagerMenuAction.class);

	public ActionForward home(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : home Starting");
		
		  UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false).getAttribute("UserDetails");
			String currentuser=userDetailVO.getUserCode();
			
			  ArrayList<EmpVO>	employeelist=new EmpDashBoardInManagerBD().getAllEmployeesUnderManager(currentuser);
			   request.setAttribute("EmployeeDetails", employeelist);
		
		
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : home Ending");
		return mapping.findForward(StringUtils.MANAGER_HOME);
	}

	public ActionForward changePassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : changePassword Starting");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : changePassword Ending");

		return mapping.findForward(StringUtils.MANAGER_CHANGEPASSWORD);
	}

	public ActionForward forgetPassword(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : forgetPassword Starting");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : forgetPassword Ending");

		return mapping.findForward(StringUtils.MANAGER_FORGETPASSWORD);
	}

	public ActionForward getLeaveRequestForApproved(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : getLeaveRequestForApproved Starting");
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
				.getAttribute("UserDetails");
	
		String userType=HelperClass.getCurrentUserIDType(request);
		
		try{
		
		String managerCode = userDetailVO.getUserCode();
		String employeeCOde=request.getParameter("EMPID");
		
		if(employeeCOde==null){
			
			employeeCOde="%%";
		}
		
		ManagerLeaveConfirmationDaoImpl confirmationDaoImpl = new ManagerLeaveConfirmationDaoImpl();
		List<ManagerLeaveConfirmationPojo> getLeaveDetails = confirmationDaoImpl
				.getLeavestoApproved(managerCode,employeeCOde);

		request.setAttribute("LeaveDetailsList", getLeaveDetails);
		
		
		String status=request.getParameter("status");
	
		if(status!=null && MessageConstants.TRUE.equalsIgnoreCase(status) ){
			
			request.setAttribute("success", MessageConstants.LEAVE_APPROVAL_SUCCESS);
		}
		
        if(status!=null && MessageConstants.MAIL_NOT_SENT.equalsIgnoreCase(status) ){
			
			request.setAttribute("failure", MessageConstants.LEAVE_APPROVAL_SUCCESS_MAIL_NOT_SENT);
		}
		
	
		if(status!=null && MessageConstants.FALSE.equalsIgnoreCase(status)){
			
			request.setAttribute("failure", MessageConstants.LEAVE_APPROVAL_FAILURE);
		}
		
	    if(status!=null && status.equalsIgnoreCase("HOLD") ){
			
			request.setAttribute("success", MessageConstants.LEAVE_HOLD_SUCCESS);
		}
		
		if(status!=null && status.equalsIgnoreCase("NOTHOLD")){
			
			request.setAttribute("failure", MessageConstants.LEAVE_HOLD_FAILURE);
		}
		if(status!=null && status.equalsIgnoreCase("REJECT") ){
				
				request.setAttribute("success", MessageConstants.LEAVE_REJECT_SUCCESS);
		}
			
		if(status!=null && status.equalsIgnoreCase("NOTREJECT")){
				
				request.setAttribute("failure", MessageConstants.LEAVE_REJECT_FAILURE);
		}
		
	}catch(Exception e){
		e.printStackTrace();
		logger.error(e.getMessage(), e);
	}
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : getLeaveRequestForApproved Ending");

		
		if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
			
			return mapping.findForward(StringUtils.DIRECTOR_LEAVE_APPROVED);
			
		}else{
			
		return mapping.findForward(StringUtils.MANAGER_LEAVE_APPROVED);
		}
	}

	public ActionForward getAttendanceNotApprovedByManager(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : getAttendanceNotApprovedByManager Starting");
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
				.getAttribute("UserDetails");
		String managerCode = userDetailVO.getUserCode();
		request.setAttribute("EmployeeNotApproved",
				new AttendenceNotApprovedBD()
						.getAttendanceNotApprovedByManager(managerCode));
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : getAttendanceNotApprovedByManager Ending");

		return mapping.findForward("attendanceNotApproved");
	}

	public ActionForward uploadEmployeeDailyAllowance(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : uploadEmployeeDailyAllowance Starting");

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : uploadEmployeeDailyAllowance Ending");

		return mapping.findForward("empDailyAllowance");
	}

	public ActionForward getExpenseConsolidatedDetail(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : getExpenseConsolidatedDetail Starting");
		
		
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		
		
		try{
			
			String status=request.getParameter("status");
			
			if(status!=null){
				
				if(status.equalsIgnoreCase("true")){
					
					request.setAttribute("errorMessage", "Expenses Approved Successfully,Mail not sent");
					
				}else if(status.equalsIgnoreCase("MialSent")){
					
					request.setAttribute("successMessage", "Expenses Approved Successfully");
					
				}else{
					
					request.setAttribute("errorMessage", "Expenses not Approved,Try again");
				}
			}
			
		}catch(Exception e){
			
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		request.setAttribute("ACC_YEAR",new TimeSheetReportBD().getAccYear());
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : getExpenseConsolidatedDetail Ending");
		

		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			
			forward=StringUtils.ADMIN_EMPLOYEE_EXPENSE_CONSOLIDATED;
			
		}else if(usertype.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
			
			forward=StringUtils.DIRECTOR_EMPLOYEE_EXPENSE_CONSOLIDATED;
			
		}else{
			
			forward=StringUtils.MANAGER_EMPLOYEE_EXPENSE_CONSOLIDATED;
		}
		return mapping.findForward(forward);
	}
	public ActionForward advanceSalaryRequest(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : advanceSalaryRequest Starting");
		UserDetailVO userDetailVO = (UserDetailVO) request
				.getSession(false).getAttribute("UserDetails");
		String currentUserId = userDetailVO.getUserCode();
		String userType=HelperClass.getCurrentUserIDType(request);
	
		ArrayList<AttendenceApprovelVo> getEmployees=new ArrayList<AttendenceApprovelVo>();
		
		getEmployees=new AttendenceApprovelBD().getEmployees(currentUserId,userType);
		request.getSession(false).setAttribute("emp_list",getEmployees);
JSONObject jsonObject=new JSONObject();
jsonObject.accumulate("employeeList", getEmployees);
response.getWriter().println(jsonObject);
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : advanceSalaryRequest Ending");

		return mapping.findForward(StringUtils.ADVANCE_SALARY_REQUEST);
	
	}

	public ActionForward advanceSalaryRequestEmployee(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

	
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : advanceSalaryRequestEmployee Starting");
		UserDetailVO userDetailVO = (UserDetailVO) request
				.getSession(false).getAttribute("UserDetails");
		String currentUserId = userDetailVO.getUserCode();
		String usertyString =HelperClass.getCurrentUserIDType(request);
		
		request.getSession(false).setAttribute("emp_list",
				new AttendenceApprovelBD().getEmployees(currentUserId,usertyString));
		ArrayList<AttendenceApprovelVo> getEmployees=new ArrayList<AttendenceApprovelVo>();
		getEmployees=new AttendenceApprovelBD().getEmployees(currentUserId,usertyString);
		request.getSession(false).setAttribute("emp_list",getEmployees);
				
		
		 ArrayList<ProjectMasterVo> project_list = new ProjectMasterDaoImpl().getAllProjects(currentUserId);
		request.getSession(false).setAttribute("PROLIST", project_list);
		JSONObject jsonObject=new JSONObject();
	
		jsonObject.put("employeeList",getEmployees);
		String successMessage=request.getParameter("successMesage");
	/*	if(successMessage.equalsIgnoreCase("true")){
			request.getSession(false).setAttribute("message","Send Request Successfully.Need to Aproove by Admin");
		}
		else
		{
			request.getSession(false).setAttribute("error", "Send Request not");
		}
		*/
		
			response.getWriter().println(jsonObject);
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : advanceSalaryRequestEmployee Ending");

		return null;
	}
	public ActionForward getAllEmployeesResume(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws AITrackerException, Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction : getAllEmployeesResume Starting");
		UserDetailVO userDetailVO = (UserDetailVO) request
				.getSession(false).getAttribute("UserDetails");
		String currentUserId = userDetailVO.getUserCode();
		String usertyString =HelperClass.getCurrentUserIDType(request);
		request.getSession(false).setAttribute("emp_list",
				new AttendenceApprovelBD().getEmployees(currentUserId,usertyString));
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetDetailsAction: getAllEmployeesResume Ending");
		return mapping.findForward(StringUtils.GET_EMPLOYEES_RESUME);
	}
	
	public ActionForward getProjectCodeReferenceByManager(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : getProjectCodeReferenceByManager Starting");
		UserDetailVO userDetailVO = (UserDetailVO) request
				.getSession(false).getAttribute("UserDetails");
		String currentUserId = userDetailVO.getUserCode();
	
		List<AdvanceSalaryRequestVo> getProjectReferenceList=new ArrayList<AdvanceSalaryRequestVo>();
		AdvanceSalaryRequestBD requestBD=new AdvanceSalaryRequestBD();
		getProjectReferenceList=requestBD.getProjectReferenceCodeByManager(currentUserId);
		
	
		request.getSession(false).setAttribute("getProjectReferenceList",new AdvanceSalaryRequestBD().getProjectReferenceCodeByManager(currentUserId));
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ManagerMenuAction : getProjectCodeReferenceByManager Ending");
JSONObject jsonObject=new JSONObject();
jsonObject.accumulate("projectCodeReferenceList",getProjectReferenceList);
response.getWriter().print(jsonObject);
		
		return null;
	}
	public ActionForward getEmployeeDetailsById(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestAction : getEmployeeDetailsById Starting");
		UserDetailVO userDetailVO = (UserDetailVO) request
				.getSession(false).getAttribute("UserDetails");
		String currentUserId = userDetailVO.getUserCode();
		
	
		List<AdvanceSalaryRequestVo> list=new ArrayList<AdvanceSalaryRequestVo>();
		AdvanceSalaryRequestBD advanceSalaryRequestBD=new AdvanceSalaryRequestBD();
		
	String id=request.getParameter("employeeId");
	
		
	list=advanceSalaryRequestBD.getEmployeeDetailsById(id,currentUserId);
		JSONObject jsonObject=new JSONObject();
	
		jsonObject.put("employeeListDetails",list);
	
			response.getWriter().println(jsonObject);
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestAction : getEmployeeDetailsById Ending");

		return null;
	}
	public ActionForward getMoreExpenseDetails(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestAction : getMoreExpenseDetails Starting");
		
		  String empid=request.getParameter("empId");
		  request.setAttribute("empId", empid);
		  request.setAttribute("ACC_YEAR",new TimeSheetReportBD().getAccYear());
		  
		  
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AdvanceSalaryRequestAction : getMoreExpenseDetails Ending");

		return mapping.findForward(MessageConstants.MORE_EXPENSE_DETAILS_IN_MANAGER);
	}
	
	
	
}