package com.centris.delegate;

import java.util.ArrayList;
import java.util.Map;

import com.centris.POJO.ExpenseReportPojo;
import com.centris.VO.ExpenseReportVO;
import com.centris.service.ExpenseReportService;
import com.centris.service.serviceImpl.ExpenseReportServiceImpl;

public class ExpenseReportBD {

	public ArrayList<ExpenseReportVO> getAllAcadamicYearsBD() {

     ExpenseReportService expenseReportService =new ExpenseReportServiceImpl();
		
    	return expenseReportService.getAllAcadamicYearsService();
	}

	public Map<String, ArrayList<ExpenseReportVO>> getExpensesBD(
			ExpenseReportPojo expenseReportPojo) {
		
		   ExpenseReportService expenseReportService =new ExpenseReportServiceImpl();
			
	    	return expenseReportService.getExpensesService(expenseReportPojo);
	}

	public ArrayList<ExpenseReportVO> getExpensesfordownload(
			ExpenseReportPojo expenseReportPojo) {		
		
		   ExpenseReportService expenseReportService =new ExpenseReportServiceImpl();
			
	    	return expenseReportService.getExpensesfordownload(expenseReportPojo);
	}

}
