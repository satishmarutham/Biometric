package com.centris.DAO;

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

public interface EmployeeExpenseDetailsDao {

	public List<EmployeeExpenseDetailsVo> getEmployeeDetails(
			EmployeeExpenseDetailsPojo obj);

	public String saveEmployeeTotalExpenseDetails(
			EmployeeExpenseDetailsForm formObj, String Id);

	public String checkEmployeeExpenseDetails(String userId, String year,
			String month,String userprevstatus);

	public List<EmployeeExpenseDetailsVo> getEmployeeProjectDetails(
			String managerId);
	
	public String getProjectRefCodeDao(String projectId);

	public ArrayList<LocalConveyanceExpensesVO> getlocalconveyanceExpense(
			String expensecode);

	public ArrayList<StaffExpensesVO> getStaffExpenses(String expensecode);

	public ArrayList<TravelExpensesVO> getTravelExpenses(String expensecode);

	public ArrayList<TelephoneExpensesVO> getTelephoneExpenses(String expensecode);

	public ArrayList<PurchaseExpensesVO> getPurchaseExpenses(String expensecode);

	public ArrayList<OtherWorkExpensesVo> getOtherWorkExpenses(
			String expensecode);

	public ArrayList<MiscellaneousExpensesVo> getMiscellaneousExpenses(
			String expensecode);

	public MonthlyExpenseDisplayVO getMonthlyExpenses(String expensecode);

	public Map<String, String> getManagerDireDetails(String empId);
	
}
