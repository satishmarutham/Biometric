package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.EmployeeExpenseDetailsDao;
import com.centris.DAO.DAOIMPL.EmployeeExpenseDetailsDaoImpl;
import com.centris.DAO.DAOIMPL.IDGenerator;
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
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class EmployeeExpenseDetailsServiceImpl implements
		EmployeeExpenseDetailsService {
	private static Logger logger = Logger
			.getLogger(EmployeeExpenseDetailsServiceImpl.class);

	@Override
	public List<EmployeeExpenseDetailsVo> getEmployeeDetails(
			EmployeeExpenseDetailsPojo obj) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsServiceImpl : getEmployeeDetails Starting");

		List<EmployeeExpenseDetailsVo> emp_Details = new ArrayList<EmployeeExpenseDetailsVo>();
		EmployeeExpenseDetailsDao daoObj = new EmployeeExpenseDetailsDaoImpl();

		try {
			emp_Details = daoObj.getEmployeeDetails(obj);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsServiceImpl : getEmployeeDetails Ending");
		return emp_Details;
	}

	@Override
	public String saveEmployeeExpenseDetails(EmployeeExpenseDetailsForm formObj) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsServiceImpl : saveEmployeeExpenseDetails Starting");

		String emp_Details = null;
		EmployeeExpenseDetailsDao daoObj = new EmployeeExpenseDetailsDaoImpl();
         String expenseCode=null;
		try {
			String hiddenId=formObj.getHiddenexpensecode();
			
			if(!hiddenId.equalsIgnoreCase("undefined") && !("fail".equalsIgnoreCase(hiddenId))){
			
				expenseCode=hiddenId;
			}else{
				expenseCode = new IDGenerator().getPrimaryKeyID("hrms_monthly_expense");
			}
			
			emp_Details = daoObj.saveEmployeeTotalExpenseDetails(formObj, expenseCode);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsServiceImpl : saveEmployeeExpenseDetails Ending");

		return emp_Details;
	}

	@Override
	public String checkEmployeeExpenseDetails(String userId, String year,
			String month,String userprevstatus) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsServiceImpl : checkEmployeeExpenseDetails Starting");

		String status = null;
		EmployeeExpenseDetailsDao daoObj = new EmployeeExpenseDetailsDaoImpl();

		try {
			status = daoObj.checkEmployeeExpenseDetails(userId, year, month,userprevstatus);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsServiceImpl : checkEmployeeExpenseDetails Ending");

		return status;
	}

	@Override
	public List<EmployeeExpenseDetailsVo> getEmployeeProjectDetails(
			String managerId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsServiceImpl : getEmployeeProjectDetails Starting");

		List<EmployeeExpenseDetailsVo> proj_Details = new ArrayList<EmployeeExpenseDetailsVo>();
		EmployeeExpenseDetailsDao daoObj = new EmployeeExpenseDetailsDaoImpl();

		try {
			proj_Details = daoObj.getEmployeeProjectDetails(managerId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsServiceImpl : getEmployeeProjectDetails Ending");
		return proj_Details;
	}

	@Override
	public String getProjectRefCodeService(String projectId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsServiceImpl : getProjectRefCodeService Starting");
		String projectRefCode=null;
		EmployeeExpenseDetailsDao daoObj = new EmployeeExpenseDetailsDaoImpl();
		try {
			projectRefCode = daoObj.getProjectRefCodeDao(projectId);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeExpenseDetailsServiceImpl : getProjectRefCodeService Ending");
		return projectRefCode;
	}

	
	public ArrayList<LocalConveyanceExpensesVO> getlocalconveyanceExpense(
			String expensecode) {
		
		EmployeeExpenseDetailsDao daoObj = new EmployeeExpenseDetailsDaoImpl();
		
		return daoObj.getlocalconveyanceExpense(expensecode);
	}

	public ArrayList<StaffExpensesVO> getStaffExpenses(String expensecode) {
	
		EmployeeExpenseDetailsDao daoObj = new EmployeeExpenseDetailsDaoImpl();
		
		return daoObj.getStaffExpenses(expensecode);
	}

	
	public ArrayList<TravelExpensesVO> getTravelExpenses(String expensecode) {

		EmployeeExpenseDetailsDao daoObj = new EmployeeExpenseDetailsDaoImpl();
		
		return daoObj.getTravelExpenses(expensecode);
	}

	
	public ArrayList<TelephoneExpensesVO> getTelephoneExpenses(	String expensecode) {
	
		EmployeeExpenseDetailsDao daoObj = new EmployeeExpenseDetailsDaoImpl();
	
		return daoObj.getTelephoneExpenses(expensecode);
	}

	
	public ArrayList<PurchaseExpensesVO> getPurchaseExpenses(String expensecode) {
	
		EmployeeExpenseDetailsDao daoObj = new EmployeeExpenseDetailsDaoImpl();
		
		return daoObj.getPurchaseExpenses(expensecode);
	}

	
	public ArrayList<OtherWorkExpensesVo> getOtherWorkExpenses(
			String expensecode) {
	
		EmployeeExpenseDetailsDao daoObj = new EmployeeExpenseDetailsDaoImpl();
		
		return daoObj.getOtherWorkExpenses(expensecode);
	}


	public ArrayList<MiscellaneousExpensesVo> getMiscellaneousExpenses(
			String expensecode) {
		
		EmployeeExpenseDetailsDao daoObj = new EmployeeExpenseDetailsDaoImpl();
		
		return daoObj.getMiscellaneousExpenses(expensecode);
	}

	
	public MonthlyExpenseDisplayVO getMonthlyExpenses(String expensecode) {
		
		EmployeeExpenseDetailsDao daoObj = new EmployeeExpenseDetailsDaoImpl();
		
		return daoObj.getMonthlyExpenses(expensecode);
	}

	
	public Map<String, String> getManagerDireDetails(String empId) {
		
	 EmployeeExpenseDetailsDao daoObj = new EmployeeExpenseDetailsDaoImpl();
		
		return daoObj.getManagerDireDetails(empId);
	}
}