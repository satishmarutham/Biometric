package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.centris.DAO.ExpenseReportDao;
import com.centris.DAO.DAOIMPL.ExpenseReportDaoImpl;
import com.centris.POJO.ExpenseReportPojo;
import com.centris.VO.ExpenseReportVO;
import com.centris.service.ExpenseReportService;
import com.centris.util.constants.MessageConstants;

public class ExpenseReportServiceImpl implements ExpenseReportService {
	
	public ArrayList<ExpenseReportVO> getAllAcadamicYearsService() {
		
		ExpenseReportDao expenseReportDao =new ExpenseReportDaoImpl();
		ArrayList<ExpenseReportVO> allyearslist=new ArrayList<ExpenseReportVO>();
		try{
			allyearslist =	expenseReportDao.getAllAcadamicYearsDao();
	
		}catch(Exception e){
				e.printStackTrace();
		}
		
		return allyearslist;
	}

	public Map<String, ArrayList<ExpenseReportVO>> getExpensesService(
			ExpenseReportPojo expenseReportPojo) {
		
		Map<String, ArrayList<ExpenseReportVO>> expensemap=new LinkedHashMap<String, ArrayList<ExpenseReportVO>>();
		ExpenseReportDao expenseReportDao =new ExpenseReportDaoImpl();
		try{
			if(MessageConstants.GROUP_BY_MANAGER.equalsIgnoreCase(expenseReportPojo.getGroupby())){
				
				expensemap =	expenseReportDao.getExpensesManagerWiseDao(expenseReportPojo);
				
			}else{
				
				expensemap =	expenseReportDao.getExpensesProjectWiseDao(expenseReportPojo);
			}
			
	
		}catch(Exception e){
				e.printStackTrace();
		}
		return expensemap;
	}

	
	
	
	public ArrayList<ExpenseReportVO> getExpensesfordownload(
			ExpenseReportPojo expenseReportPojo) {
		
		ArrayList<ExpenseReportVO> expenselist=new ArrayList<ExpenseReportVO>();
		ExpenseReportDao expenseReportDao =new ExpenseReportDaoImpl();
		
		try{
			expenselist = expenseReportDao.getExpensesfordownload(expenseReportPojo);
	     
		 
		   }catch(Exception e){
			    e.printStackTrace();
	     }
		return expenselist;
	}

}
