package com.centris.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.TimesheetReconcilationPojo;
import com.centris.VO.DepartmentFilterVO;
import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.TimesheetReconciliationVO;
import com.centris.form.TimesheetReconciliationForm;
import com.centris.service.TimesheetReconciliationService;
import com.centris.service.serviceImpl.TimesheetReconciliationServiceImpl;
import com.centris.util.EmpDetails;


public class TimesheetReconciliationBD {

	public List<TimesheetReconciliationVO> getTimesheetData(TimesheetReconcilationPojo timesheetReconcilationPojo,String[] empArray){
	
		TimesheetReconciliationService timesheetReconciliationservice =new TimesheetReconciliationServiceImpl();

		return timesheetReconciliationservice.getTimesheetData(timesheetReconcilationPojo,empArray);
	}
	
	
	public String updateTimeSheet(TimesheetReconcilationPojo timeSheetPojo){
		return new TimesheetReconciliationServiceImpl().updateTimeSheet(timeSheetPojo);
	}
	public ArrayList<EmpDetails> getAllEmpNames() {
		
		return new TimesheetReconciliationServiceImpl().getAllEmpNames();
	}

	
	public ArrayList<ManagerFilterVO> getManagersByDept(String depts) {
		
		TimesheetReconciliationService timesheetReconciliationservice =new TimesheetReconciliationServiceImpl();

		return timesheetReconciliationservice.getManagersByDept(depts);
	}
	
	
	public ArrayList<EmployeeFilterVO> getEmployeesByMang(String manager) {
		
		TimesheetReconciliationService timesheetReconciliationservice =new TimesheetReconciliationServiceImpl();

		return timesheetReconciliationservice.getEmployeesByMang(manager);
	}
	
	
	public ArrayList<DepartmentFilterVO> getAllDepartments() {
		
		TimesheetReconciliationService timesheetReconciliationservice =new TimesheetReconciliationServiceImpl();

		return timesheetReconciliationservice.getAllDepartments();
	}

}
