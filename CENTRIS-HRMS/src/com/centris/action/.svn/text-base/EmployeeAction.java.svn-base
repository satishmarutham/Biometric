package com.centris.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;

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

import com.centris.DAO.DAOIMPL.IDGenerator;
import com.centris.VO.CheckEmployeeDeletionVO;
import com.centris.VO.GetAllEmployeeVO;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.EmployeeBD;
import com.centris.delegate.GetAllEmployeeBD;
import com.centris.form.EmployeeForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class EmployeeAction extends DispatchAction {
	private static Logger logger = Logger.getLogger(EmployeeAction.class);

	public synchronized ActionForward registerEmployee(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: registerEmployee Starting");

		String forward = null;

		try {
			String usertype = HelperClass.getCurrentUserIDType(request).trim();

			EmployeeForm employeeForm = (EmployeeForm) form;
			
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			employeeForm.setUserCode(userDetailVO.getUserCode());
			employeeForm.setServerPath(request.getRealPath("/"));
			employeeForm.setManagerCode(employeeForm.getReportingSupervisor());
			employeeForm.setEmpCode(new IDGenerator()
					.getPrimaryKeyID(Employee.EMPLOYEE_TABLE));

			request.getSession(false).setAttribute("doubleFormSubmition", "");
			String empStatus = new EmployeeBD().registerEmployee(employeeForm);
			request.setAttribute("employeeForm", employeeForm);
			if ("SAVED".equals(empStatus)) {
				request.setAttribute("successMessage", Employee.EMP_SAVED);

				if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
					forward = Employee.EMPLOYEE_SALARY_DETAILS;
				} else {
					forward = Director.DIRECTOR_EMPLOYEE_SALARY_DETAILS;
				}

				request.setAttribute("EMPID", employeeForm.getEmpCode());
				request.setAttribute("EMPNAME", employeeForm.getEmpFirstName());
				request.setAttribute("EMPSALARY",
						employeeForm.getSalaryOffered());
				request.setAttribute("accountNo",
						employeeForm.getHdfcAccountNo());

			} else if ("EXIST".equals(empStatus)) {
				request.setAttribute("errorMessage", Employee.EMP_EXIST);

				if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
					forward = Employee.EMPLOYEE;
				} else {
					forward = Director.DIRECTOR_EMPLOYEE_ADD;
				}

			} else {
				request.setAttribute("errorMessage", Employee.EMP_NOT_SAVED);
				if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
					forward = Employee.EMPLOYEE;
				} else {
					forward = Director.DIRECTOR_EMPLOYEE_ADD;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: registerEmployee Ending");
		return mapping.findForward(forward);
	}

	public synchronized ActionForward amendEmployee(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: amendEmployee Starting");
		String usertype = null;
		String forward = null;
		try {
			usertype = HelperClass.getCurrentUserIDType(request).trim();

			EmployeeForm employeeForm = (EmployeeForm) form;
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			employeeForm.setUserCode(userDetailVO.getUserCode());
			employeeForm.setManagerCode(employeeForm.getReportingSupervisor());

			employeeForm.setSecondreportingSupervisor(employeeForm
					.getSecondreportingSupervisor());
			employeeForm.setServerPath(request.getRealPath("/"));

			String empStatus = new EmployeeBD().amendEmployee(employeeForm);
			request.setAttribute("employeeForm", employeeForm);
			
			
			
			if ("SAVED".equals(empStatus)){
				
				request.setAttribute("successMessage", Employee.EMP_SAVED);
			}else if(MessageConstants.MANAGER_NOT_UPDATED.equalsIgnoreCase(empStatus)){
			
				request.setAttribute("errorMessage", Employee.MANAGER_NOT_SAVED);
			}else if(MessageConstants.DIRECTOR_NOT_UPDATED.equalsIgnoreCase(empStatus)){
			
				request.setAttribute("errorMessage", Employee.DIRECTOR_NOT_SAVED);
			}else if(MessageConstants.ADMIN_NOT_UPDATED.equalsIgnoreCase(empStatus)){
			
				request.setAttribute("errorMessage", Employee.ADMIN_NOT_SAVED);
			}else if(MessageConstants.MAIL_NOT_SENT.equalsIgnoreCase(empStatus)){
				
				request.setAttribute("errorMessage", Employee.EMP_UPDATED_MAIL_NOT_SENT);
			}else{
				request.setAttribute("errorMessage", Employee.EMP_NOT_SAVED);

			}
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = Employee.EMPLOYEE_AMENDMENT;
		} else {
			forward = Director.DIRECTOR_EMPLOYEE_AMENDMENT;
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: amendEmployee Ending");
		return mapping.findForward(forward);
	}

	public synchronized ActionForward searchEmployee(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: searchEmployee Starting");
		try {

			String empId = request.getParameter("EmpId");
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response", new EmployeeBD().searchEmployee(empId));
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: searchEmployee Ending");
		return null;
	}

	public synchronized ActionForward getEmpIdNameBySerachTerm(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: getEmpIdNameBySerachTerm Starting");
		try {
			String maxRows = request.getParameter("maxRows");
			String name_startsWith = request.getParameter("name_startsWith");
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response", new EmployeeBD()
					.getEmpIdNameBySerachTerm(maxRows, name_startsWith));
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: getEmpIdNameBySerachTerm Ending");
		return null;
	}

	public synchronized ActionForward getProjectDetailsByManager(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: getProjectDetails Starting");
		try {
			String maxRows = request.getParameter("maxRows");
			String name_startsWith = request.getParameter("name_startsWith");
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response", new EmployeeBD()
					.getEmpIdNameBySerachTerm(maxRows, name_startsWith));
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: getProjectDetails Ending");
		return null;
	}

	public synchronized ActionForward checkDuplicateEmailId(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkDuplicateEmailId Starting");
		try {
			String emailId = request.getParameter("EmailId");
			String empCode = request.getParameter("EmpCode");
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response",
					new EmployeeBD().checkDuplicateEmailId(emailId, empCode));
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkDuplicateEmailId Ending");
		return null;
	}

	public synchronized ActionForward checkPassportNoUnique(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkDuplicateEmailId Starting");
		System.out.println("passport uniqueness");
		try {
			String passportNo = request.getParameter("PassportNo");
			String empCode = request.getParameter("EmpCode");
			JSONObject jsonObject = new JSONObject();
			jsonObject
					.put("response", new EmployeeBD().checkPassportNoUnique(
							passportNo, empCode));
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkDuplicateEmailId Ending");
		return null;
	}

	public synchronized ActionForward checkAccountNoUnique(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkDuplicateAccountNo Starting");
		try {
			String accountNo = request.getParameter("AccountNo");
			String empCode = request.getParameter("EmpCode");
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response",
					new EmployeeBD().checkAccountNoUnique(accountNo, empCode));
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkDuplicateAccountNo Ending");
		return null;
	}

	public synchronized ActionForward checkVoterIdUnique(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkVoterIdUnique Starting");
		try {
			String voterId = request.getParameter("VoterId");
			String empCode = request.getParameter("EmpCode");
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response",
					new EmployeeBD().checkVoterIdUnique(voterId, empCode));
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkVoterIdUnique Ending");
		return null;
	}

	public synchronized ActionForward checkPanCardUnique(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkPanCardUnique Starting");
		try {
			String panCardNo = request.getParameter("PanCardNo");
			String empCode = request.getParameter("EmpCode");
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response",
					new EmployeeBD().checkPanCardUnique(panCardNo, empCode));
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkPanCardUnique Ending");
		return null;
	}

	public synchronized ActionForward checkAddharCardUnique(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkAddharCardUnique Starting");
		try {
			String addharCardNo = request.getParameter("AddharCardNo");
			String empCode = request.getParameter("EmpCode");
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response", new EmployeeBD().checkAddharCardUnique(
					addharCardNo, empCode));
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkAddharCardUnique Ending");
		return null;
	}

	public synchronized ActionForward checkDLNoUnique(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkDLNoUnique Starting");
		try {
			String dlNo = request.getParameter("DLNo");
			String empCode = request.getParameter("EmpCode");
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response",
					new EmployeeBD().checkDLNoUnique(dlNo, empCode));
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkDLNoUnique Ending");
		return null;
	}

	public synchronized ActionForward downloadDocument(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: downloadDocument Starting");

		try {
			String docPath = request.getParameter("Path");
			response.setContentType("application/octet-stream");
			String fileName = "FileName";
			if (docPath != null) {
				String[] docPathArray = docPath.split("__");
				fileName = docPathArray[1];
			}
			response.addHeader("Content-Disposition", "attachment; filename="
					+ fileName);
			File docFile = new File(request.getRealPath("/") + docPath);
			response.setContentLength((int) docFile.length());

			FileInputStream input = new FileInputStream(docFile);
			BufferedInputStream buf = new BufferedInputStream(input);
			int readBytes = 0;
			ServletOutputStream stream = response.getOutputStream();
			while ((readBytes = buf.read()) != -1) {
				stream.write(readBytes);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: downloadDocument Ending");

		return null;
	}

	public synchronized ActionForward checkDuplicateBiometricId(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkDuplicateBiometricId Starting");
		try {
			String bioId = request.getParameter("BiometricId").trim();
			String empCode = request.getParameter("EmpCode").trim();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("response",
					new EmployeeBD().checkDuplicateBiometricId(bioId, empCode));
			response.getWriter().print(jsonObject);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkDuplicateBiometricId Ending");
		return null;
	}
	
	public synchronized ActionForward deleteEmployee(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: deleteEmployee Starting");
		
		ArrayList<GetAllEmployeeVO> list = new ArrayList<GetAllEmployeeVO>();
		String forward = null;
		String usertype = HelperClass.getCurrentUserIDType(request);
		try {
			UserDetailVO userDetailVO = (UserDetailVO) request
					.getSession(false).getAttribute("UserDetails");
			
			String usercode=userDetailVO.getUserCode();
			
			String empCode = request.getParameter("empid").trim();
			
				
			String status=new EmployeeBD().deleteEmployee(empCode,usercode);
			
			if(status.equalsIgnoreCase("true")){
				
				request.setAttribute("successMessage", Employee.EMP_DELETED);

			}else if(status.equalsIgnoreCase("false")){
				
				request.setAttribute("errorMessage", Employee.EMP_NOT_DELETED);
				
			}/*else if(status.equalsIgnoreCase("notExist")){
				
				
			}*/
			
			list = new GetAllEmployeeBD().getDetails();
			request.setAttribute("emplist", list);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: deleteEmployee Ending");
		
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = MessageConstants.GET_ALL_EMPLOYEES;
		} else {
			forward = Director.DIRECTOR_GET_ALL_EMPLOYEES;
		}
		return mapping.findForward(forward);
	}
	
	public synchronized ActionForward checkEmployeeMap(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkEmployeeMap Starting");
		
		try {
			
			String empCode = request.getParameter("empid").trim();
			
			CheckEmployeeDeletionVO status=new EmployeeBD().checkEmployeeMap(empCode);
			
			ArrayList<CheckEmployeeDeletionVO> emplist=new ArrayList<CheckEmployeeDeletionVO>();
			emplist.add(status);
			
		     JSONObject jsonObject=new JSONObject();
		     jsonObject.accumulate("Empdeletevo", emplist);
		     response.getWriter().print(jsonObject);
		
	
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: checkEmployeeMap Ending");
		
		
		return null;
	}
	
	public synchronized ActionForward getEmployeePermissions(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: getEmployeePermissions Starting");
		
		try {
			
			String empCode = request.getParameter("empid").trim();
			
			ArrayList<String> permissionsList=new EmployeeBD().getEmployeePermissionsBD(empCode);
			
		     JSONObject jsonObject=new JSONObject();
		     jsonObject.accumulate("pemissionsList", permissionsList);
		     response.getWriter().print(jsonObject);
		
	
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: getEmployeePermissions Ending");
		
		
		return null;
	}
	
	
	public synchronized ActionForward blockUserDetails(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: blockUserDetails Starting");
		
		try {
			
			String empCode = request.getParameter("empid").trim();
			String role = request.getParameter("role").trim();
			
			String status=new EmployeeBD().blockUserDetailsBD(empCode,role);
			
		     JSONObject jsonObject=new JSONObject();
		     jsonObject.accumulate("status", status);
		     response.getWriter().print(jsonObject);
		
	
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: blockUserDetails Ending");
		
		
		return null;
	}
	
	public ActionForward getAllDeactiveEmployees(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: getAllDeactiveEmployees Starting");
		ArrayList<GetAllEmployeeVO> list = new ArrayList<GetAllEmployeeVO>();
		String usertype = HelperClass.getCurrentUserIDType(request);
        String forward=null;
		try {
			list = new GetAllEmployeeBD().getDeactiveEmployeeDetails();
			request.setAttribute("emplist", list);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
       

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: getAllDeactiveEmployees Ending");
		
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "getDeactiveEmployees";
		} else {
			forward = "director_getDeactiveEmployees";
		}
		return mapping.findForward(forward);
	/*return mapping.findForward("getDeactiveEmployees");*/
	}
	
	public ActionForward activateEmployee(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: activateEmployee Starting");
		ArrayList<GetAllEmployeeVO> list = new ArrayList<GetAllEmployeeVO>();
		int status=0;
		String usertype = HelperClass.getCurrentUserIDType(request);
        String forward=null;
		

		try {
			String empid=request.getParameter("empid");
			status = new GetAllEmployeeBD().activateEmployee(empid);
			list = new GetAllEmployeeBD().getDeactiveEmployeeDetails();
			request.setAttribute("emplist", list);
			if(status > 0)
			{
				request.setAttribute("successMessage", "Employee Activated Successfully");
			}
			else
			{
				request.setAttribute("errorMessage", "Employee Activation Failure");
			}
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
       

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: activateEmployee Ending");
		
		
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = "getDeactiveEmployees";
		} else {
			forward = "director_getDeactiveEmployees";
		}
		return mapping.findForward(forward);
	
	}
	
	
	public ActionForward refreshBioId(
			ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: refreshBioId Starting");
		

		try {
			
			String BioId=new EmployeeBD().getBioIdBD(); 
			
			JSONObject object=new JSONObject();
			object.put("BIoId", BioId);
			
			response.getWriter().print(object);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
       

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeAction: refreshBioId Ending");
		
		return null;
	
	}
	
	

	
	
}