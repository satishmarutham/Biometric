package com.centris.action;

import java.util.ArrayList;
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
import com.centris.VO.AllEmployeesViewDialogVo;
import com.centris.VO.EmployVO;
import com.centris.VO.GetAllEmployeeVO;
import com.centris.delegate.AddDesignationBD;
import com.centris.delegate.AdminForgotPasswordBD;
import com.centris.delegate.DepartmentMasterBD;
import com.centris.delegate.DirectorForgotPasswordBD;
import com.centris.delegate.EmployeeForgotPassBD;
import com.centris.delegate.GetAllEmployeeBD;
import com.centris.delegate.ManagerForgotPasswordBD;
import com.centris.delegate.ProjectManagerMappingBD;
import com.centris.form.GetEmployeeForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class GetAllEmployeeAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(GetAllEmployeeAction.class);

	public ActionForward autosearchemployee(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeAction:autosearch_Employee Starting");
		try {
			String term = request.getParameter("searchTerm");
			ArrayList<GetAllEmployeeVO> autolist = new ArrayList<GetAllEmployeeVO>();
			autolist = new GetAllEmployeeBD().autosearchemployee(term);

			JSONObject json = new JSONObject();
			json.accumulate("jsonResponse", autolist);
			response.getWriter().print(json);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeAction :autosearch_Employee Ending");
		return null;
	}

	public ActionForward searchEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeAction:search_Employee Starting");
		GetEmployeeForm frm = (GetEmployeeForm) form;
		String forward = null;
		String usertype = HelperClass.getCurrentUserIDType(request);
		try {
			String searchterm = frm.getEmpName();
			ArrayList<GetAllEmployeeVO> srchlist = new ArrayList<GetAllEmployeeVO>();
			srchlist = new GetAllEmployeeBD().searchemployee(searchterm);

			request.setAttribute("emplist", srchlist);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeAction : search_Employee Ending");
		
		
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.GET_ALL_EMPLOYEES;
		} else {
			forward = Director.DIRECTOR_GET_ALL_EMPLOYEES;
		}
		
		return mapping.findForward(forward);
	}

	public ActionForward modifyEmployee(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeAction:getdata_to_modify_Employee Starting");
		try {
			String empid = request.getParameter("selectEmployee");

			ArrayList<EmployVO> modifylist = new ArrayList<EmployVO>();
			modifylist = new GetAllEmployeeBD().modifyemployee(empid);
			if(modifylist.size()!=0){
			EmployVO voObject = modifylist.get(0);
			request.setAttribute("employeeDetails", voObject);
			}

			request.getSession(false).setAttribute("designationDetails",
					new AddDesignationBD().getDesignationDetails());
			request.getSession(false).setAttribute("departmentDetails",
					new DepartmentMasterBD().getDepartmentRecordsBD());
			request.getSession(false).setAttribute("managerDetails",
					new ProjectManagerMappingBD().getManager());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeAction :getdata_to_modify_Employee Ending");
		return mapping.findForward(MessageConstants.MODIFY_EMPLOYEE);
	}
	
	
	public ActionForward getEmpDetailsForView(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeAction:getEmpDetailsForView Starting");
		try {
			String empid = request.getParameter("empid");

			ArrayList<AllEmployeesViewDialogVo> dialogVoList =new GetAllEmployeeBD().getEmpDetailsForViewBD(empid);
 
			JSONObject object=new JSONObject();
			object.put("dialogVoList", dialogVoList);
			
			response.getWriter().print(object);
	
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeAction :getEmpDetailsForView Ending");
		return null;
	}
	

	public ActionForward sendManagerPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendManagerPassword Starting");

		try {
			String username = request.getParameter("username");
			String email = request.getParameter("email");

			ManagerForgotPasswordBD forgotPasswordBD = new ManagerForgotPasswordBD();

			int result = forgotPasswordBD.resetManagerPassword(username, email);

			JSONObject jsonObject = new JSONObject();
			
			String message = null;
			if (result == 1) {
				message = "successMessage";
			} else if(result == 2){
				message = "errorMessage";
			}
			jsonObject.put("message", message);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendManagerPassword Ending");

		return null;
	}

	public ActionForward sendEmployeePassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendEmployeePassword Starting");

		try {
			String dateofbirth = request.getParameter("dateofbirth");
			String emp_official_emailid = request
					.getParameter("emp_official_emailid");
			 int result =  new EmployeeForgotPassBD().checkEmployeeBD(dateofbirth, emp_official_emailid);
			
			 JSONObject jsonObject = new JSONObject();
				
				String message = null;
				if (result == 1) {
					message = "successMessage";
				} else if(result == 2){
					message = "errorMessage";
				}
				jsonObject.put("message", message);
				response.getWriter().print(jsonObject);
				
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendEmployeePassword Ending");

		return null;
	}

	public ActionForward sendAdminPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendAdminPassword Starting");

		try {
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			
			AdminForgotPasswordBD forgotPasswordBD = new AdminForgotPasswordBD();

			int result = forgotPasswordBD.resetAdminPassword(username, email);
			
			System.out.println("result in action ::: "+result);

			 JSONObject jsonObject = new JSONObject();
				
				String message = null;
				if (result == 1) {
					message = "successMessage";
				} else if(result == 2){
					message = "errorMessage";
				}
				jsonObject.put("message", message);
				response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendAdminPassword Ending");

		return null;
	}
	
	public ActionForward sendDirectorPassword(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendDirectorPassword Starting");

		try {
			String username = request.getParameter("username");
			String email = request.getParameter("email");

			DirectorForgotPasswordBD forgotPasswordBD = new DirectorForgotPasswordBD();

			int result = forgotPasswordBD.resetDirectorPassword(username, email);

			JSONObject jsonObject = new JSONObject();
			
			String message = null;
			if (result == 1) {
				message = "successMessage";
			} else if(result == 2){
				message = "errorMessage";
			}
			jsonObject.put("message", message);
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in LoginCheckAction : sendDirectorPassword Ending");

		return null;
	}
	
	
	
}