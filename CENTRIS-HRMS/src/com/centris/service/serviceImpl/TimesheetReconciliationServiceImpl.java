package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.centris.DAO.TimesheetReconciliationDAO;
import com.centris.DAO.DAOIMPL.TimesheetReconciliationDAOImpl;
import com.centris.POJO.TimesheetReconcilationPojo;
import com.centris.VO.DepartmentFilterVO;
import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.TimesheetReconciliationVO;
import com.centris.form.TimesheetReconciliationForm;
import com.centris.service.TimesheetReconciliationService;
import com.centris.util.EmpDetails;

public class TimesheetReconciliationServiceImpl implements TimesheetReconciliationService {
	
	public List<TimesheetReconciliationVO> getTimesheetData(TimesheetReconcilationPojo timesheetReconcilationPojo,String[] empArray){
	
		TimesheetReconciliationDAO  timesheetReconciliationDAO =new TimesheetReconciliationDAOImpl();
		
		return timesheetReconciliationDAO.getTimesheetData(timesheetReconcilationPojo,empArray);
	
	}
	
	
	
	public String updateTimeSheet(TimesheetReconcilationPojo timeSheetPojo){
		return new TimesheetReconciliationDAOImpl().updateTimeSheet(timeSheetPojo);
	}
	public ArrayList<EmpDetails> getAllEmpNames() {
			return new TimesheetReconciliationDAOImpl().getAllEmpNames();
	}
	
	
	
	public ArrayList<ManagerFilterVO> getManagersByDept(String depts) {
		
		TimesheetReconciliationDAO  timesheetReconciliationDAO =new TimesheetReconciliationDAOImpl();
	
		return timesheetReconciliationDAO.getManagersByDept(depts);
	}

	
	public ArrayList<EmployeeFilterVO> getEmployeesByMang(String manager) {
		
		TimesheetReconciliationDAO  timesheetReconciliationDAO =new TimesheetReconciliationDAOImpl();
		
		return timesheetReconciliationDAO.getEmployeesByMang(manager);
	}

	
	public ArrayList<DepartmentFilterVO> getAllDepartments() {

		TimesheetReconciliationDAO  timesheetReconciliationDAO =new TimesheetReconciliationDAOImpl();
		
		return timesheetReconciliationDAO.getAllDepartments();
	}
}
