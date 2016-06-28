package com.centris.service;

import java.util.ArrayList;
import java.util.Map;

import com.centris.POJO.ExpenseReportPojo;
import com.centris.VO.ExpenseReportVO;

public interface ExpenseReportService {

	ArrayList<ExpenseReportVO> getAllAcadamicYearsService();

	Map<String, ArrayList<ExpenseReportVO>> getExpensesService(
			ExpenseReportPojo expenseReportPojo);

	ArrayList<ExpenseReportVO> getExpensesfordownload(
			ExpenseReportPojo expenseReportPojo);

}
