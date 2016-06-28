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

import com.centris.VO.EmployeeSalarydetailsVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.EmployeeBD;
import com.centris.delegate.EmployeeSalaryDetailsBD;
import com.centris.form.EmployeeSalaryDetailsForm;
import com.centris.util.CalculateEmpSalary;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Director;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class EmployeeSalaryDetailsAction extends DispatchAction {
	
	private static Logger logger = Logger.getLogger(GetDetailsAction.class);

	public ActionForward calculateEmpSalaryDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsAction: calculateEmpSalaryDetails : Starting");
		try {

			
			/*String salary=request.getParameter("salary");
			String name=request.getParameter("name");
			ArrayList<EmployeeSalarydetailsVo> salary_list=new ArrayList<EmployeeSalarydetailsVo>();
			
			EmployeeSalarydetailsVo salaryVo=null;
			if(name.equalsIgnoreCase("ctc")){
				
				 salaryVo=new EmployeeSalarydetailsVo();
				salaryVo.setBasic_da(CalculateEmpSalary.calculateBasicDa(Double.parseDouble(salary)));
				salaryVo.setHra(CalculateEmpSalary.calculateHra(salaryVo.getBasic_da()));
				salaryVo.setPf_empr(CalculateEmpSalary.calculatePfEmpr(salaryVo.getBasic_da()));
				salaryVo.setPf_empy(CalculateEmpSalary.calculatePfEmpy(salaryVo.getBasic_da()));
				salaryVo.setPt(CalculateEmpSalary.calculatePt(salaryVo.getBasic_da()));
				
			}else{
				
				 salaryVo=new EmployeeSalarydetailsVo();
				salaryVo.setEsi_empr(CalculateEmpSalary.calculateEsiEmpr(Double.parseDouble(salary)));
				salaryVo.setEsi_empy(CalculateEmpSalary.calculateEsiEmpy(Double.parseDouble(salary)));
				
			}
			
			salary_list.add(salaryVo);
			
			JSONObject object=new JSONObject();
			object.put("salarylist", salary_list);
			
			response.getWriter().print(object);*/
			
			ArrayList<EmployeeSalarydetailsVo> salary_list=new ArrayList<EmployeeSalarydetailsVo>();
			EmployeeSalarydetailsVo salaryVo=new EmployeeSalarydetailsVo();
			
			String basicDa=request.getParameter("basicDa");
			String ctc=request.getParameter("ctc");
			String grossSalary=request.getParameter("grossSalary");
			
			
			double basicDa_Double=0.0;
			
			if(basicDa!=null){
				
				basicDa_Double=Double.parseDouble(basicDa);
				
			}
			
			double ctc_double=0.0;
			if(ctc!=null){
				
				ctc_double=Double.parseDouble(ctc);
			}
			
			double gross_double=0.0;
			
			if(grossSalary!=null){
				
				gross_double=Double.parseDouble(grossSalary);
			}
			
			salaryVo.setHra(CalculateEmpSalary.calculateHra(Double.parseDouble(basicDa),Employee.HRA));
			salaryVo.setPf_empr(CalculateEmpSalary.calculatePfEmpr(basicDa_Double,Employee.PF_EMPR));
			salaryVo.setPf_empy(CalculateEmpSalary.calculatePfEmpy(basicDa_Double,Employee.PF_EMPY));
			salaryVo.setEsi_empr(CalculateEmpSalary.calculateEsiEmpr(gross_double,Employee.ESI_EMPR,ctc_double));
			salaryVo.setEsi_empy(CalculateEmpSalary.calculateEsiEmpy(gross_double,Employee.ESI_EMPY,ctc_double));
			
			salaryVo.setPt(CalculateEmpSalary.calculatePt(basicDa_Double));
			
			salary_list.add(salaryVo);
			
			JSONObject object=new JSONObject();
			object.put("salarylist", salary_list);
			
			response.getWriter().print(object);
			
			

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsAction: calculateEmpSalaryDetails : Ending");
		return null;
	}
	
	
	public ActionForward storeEmpSalaryDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsAction: storeEmpSalaryDetails : Starting");
		String usertype = HelperClass.getCurrentUserIDType(request);
		String forward = null;
		try {
			
			EmployeeSalaryDetailsForm salaryform=(EmployeeSalaryDetailsForm)form;
			UserDetailVO userDetailVO= (UserDetailVO)request.getSession(false).getAttribute("UserDetails");
			String usercode=userDetailVO.getUserCode();
			
			String status=new EmployeeSalaryDetailsBD().storeEmployeeSalaryDetails(salaryform,usercode);
			
			request.setAttribute("successMessage", status);
			
			String BioId=new EmployeeBD().getBioIdBD(); 
			if(BioId!=null){
				
				request.setAttribute("BioId", BioId);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsAction: storeEmpSalaryDetails : Ending");
		
		if (usertype.equalsIgnoreCase(LoginDetails.ADMIN_ID_TYPE)) {
			forward = Employee.EMPLOYEE;
		} else {
			forward = Director.DIRECTOR_EMPLOYEE_ADD;
		}
		
		return mapping.findForward(forward);
	}
	
	public ActionForward validateBankAccNumber(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsAction: validateBankAccNumber : Starting");
		try {
			
			String bankaccnumber=request.getParameter("bankaccnumber");
			String empid=request.getParameter("empid");
			
			boolean status=new EmployeeSalaryDetailsBD().validateBankAccNumber(bankaccnumber, empid);
			
			JSONObject object =new JSONObject();
			object.put("status", status);
			
			response.getWriter().print(object);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsAction: validateBankAccNumber : Ending");
		return null;
	}
	
	
	
	public ActionForward validatePfNumber(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsAction: validatePfNumber : Starting");
		try {
			
			String pfcode=request.getParameter("epfcode");
			String empid=request.getParameter("empid");
			
			boolean status=new EmployeeSalaryDetailsBD().validatePfNumber(pfcode, empid);
			
			
			JSONObject object =new JSONObject();
			object.put("status", status);
			
			response.getWriter().print(object);
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsAction: validatePfNumber : Ending");
		return null;
	}
	
	
	public ActionForward validateEsiNumber(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsAction: validateEsiNumber : Starting");
		try {
			
			String esicode=request.getParameter("esicode");
			String empid=request.getParameter("empid");
			
			boolean status=new EmployeeSalaryDetailsBD().validateEsiCode(esicode, empid);
			
			JSONObject object =new JSONObject();
			object.put("status", status);
			
			response.getWriter().print(object);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();

		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeSalaryDetailsAction: validateEsiNumber : Ending");
		return null;
	}

}
