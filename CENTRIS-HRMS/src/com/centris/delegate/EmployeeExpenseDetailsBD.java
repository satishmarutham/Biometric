package com.centris.delegate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.centris.POJO.EmployeeExpenseDetailsPojo;
import com.centris.VO.EmployeeExpenseDetailsVo;
import com.centris.VO.LocalConveyanceExpensesVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.MiscellaneousExpensesVo;
import com.centris.VO.MonthlyExpenseDisplayVO;
import com.centris.VO.OtherWorkExpensesVo;
import com.centris.VO.PurchaseExpensesVO;
import com.centris.VO.StaffExpensesVO;
import com.centris.VO.TelephoneExpensesVO;
import com.centris.VO.TravelExpensesVO;
import com.centris.form.EmployeeExpenseDetailsForm;
import com.centris.service.EmployeeExpenseDetailsService;
import com.centris.service.serviceImpl.EmployeeExpenseDetailsServiceImpl;

public class EmployeeExpenseDetailsBD {
	public List<EmployeeExpenseDetailsVo> getEmployeeDetails(
			EmployeeExpenseDetailsPojo obj) {
		List<EmployeeExpenseDetailsVo> emp_Details = new ArrayList<EmployeeExpenseDetailsVo>();
		EmployeeExpenseDetailsService serviceObj = new EmployeeExpenseDetailsServiceImpl();
		emp_Details = serviceObj.getEmployeeDetails(obj);
		return emp_Details;
	}

	public String saveEmployeeExpenseDetails(EmployeeExpenseDetailsForm formObj) {
		String emp_Details = null;
		EmployeeExpenseDetailsService serviceObj = new EmployeeExpenseDetailsServiceImpl();
		emp_Details = serviceObj.saveEmployeeExpenseDetails(formObj);
		return emp_Details;
	}

	public String checkEmployeeExpenseDetails(String userId, String year,
			String month, String userprevstatus) {
		String emp_Details = null;
		EmployeeExpenseDetailsService serviceObj = new EmployeeExpenseDetailsServiceImpl();
		emp_Details = serviceObj.checkEmployeeExpenseDetails(userId, year,
				month,userprevstatus);
		return emp_Details;
	}

	public List<EmployeeExpenseDetailsVo> getEmployeeProjectDetails(
			String managerId) {
		List<EmployeeExpenseDetailsVo> emp_Details = new ArrayList<EmployeeExpenseDetailsVo>();
		EmployeeExpenseDetailsService serviceObj = new EmployeeExpenseDetailsServiceImpl();
		emp_Details = serviceObj.getEmployeeProjectDetails(managerId);
		return emp_Details;
	}
	
	public String getProjectRefCodeBD(String projectId) {
		
		EmployeeExpenseDetailsService serviceObj = new EmployeeExpenseDetailsServiceImpl();
		
		return  serviceObj.getProjectRefCodeService(projectId);
	}

	public ArrayList<LocalConveyanceExpensesVO> getlocalconveyanceExpense(String expensecode) {

		EmployeeExpenseDetailsService serviceObj = new EmployeeExpenseDetailsServiceImpl();
		
		return serviceObj.getlocalconveyanceExpense(expensecode);
	}

	public ArrayList<StaffExpensesVO> getStaffExpenses(String expensecode) {
	
		EmployeeExpenseDetailsService serviceObj = new EmployeeExpenseDetailsServiceImpl();
		
		return serviceObj.getStaffExpenses(expensecode);
	}

	public ArrayList<TravelExpensesVO> getTravelExpenses(String expensecode) {

	EmployeeExpenseDetailsService serviceObj = new EmployeeExpenseDetailsServiceImpl();
		
		return serviceObj.getTravelExpenses(expensecode);
	}

	public ArrayList<TelephoneExpensesVO>  getTelephoneExpenses(String expensecode) {
		
		EmployeeExpenseDetailsService serviceObj = new EmployeeExpenseDetailsServiceImpl();
		
		return serviceObj.getTelephoneExpenses(expensecode);
	}

	public ArrayList<PurchaseExpensesVO> getPurchaseExpenses(String expensecode) {
		
		EmployeeExpenseDetailsService serviceObj = new EmployeeExpenseDetailsServiceImpl();
		
		return serviceObj.getPurchaseExpenses(expensecode);
	}

	public ArrayList<OtherWorkExpensesVo> getOtherWorkExpenses(String expensecode) {
	
		EmployeeExpenseDetailsService serviceObj = new EmployeeExpenseDetailsServiceImpl();
		
		return serviceObj.getOtherWorkExpenses(expensecode);
	}

	public ArrayList<MiscellaneousExpensesVo> getMiscellaneousExpenses(String expensecode) {

		EmployeeExpenseDetailsService serviceObj = new EmployeeExpenseDetailsServiceImpl();
		
		return serviceObj.getMiscellaneousExpenses(expensecode);
	}

	public MonthlyExpenseDisplayVO getMonthlyExpenses(String expensecode) {
		
		EmployeeExpenseDetailsService serviceObj = new EmployeeExpenseDetailsServiceImpl();
	
		return serviceObj.getMonthlyExpenses(expensecode);
	}

	public Map<String, String> getManagerDireDetails(String empId) {
	
		EmployeeExpenseDetailsService serviceObj = new EmployeeExpenseDetailsServiceImpl();
		
		return serviceObj.getManagerDireDetails(empId);
	}
	
	
	
	
	
}
