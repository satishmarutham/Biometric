package com.centris.DAO;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.TimesheetReconcilationPojo;
import com.centris.VO.DepartmentFilterVO;
import com.centris.VO.EmployeeFilterVO;
import com.centris.VO.ManagerFilterVO;
import com.centris.VO.TimesheetReconciliationVO;
import com.centris.form.TimesheetReconciliationForm;

public interface TimesheetReconciliationDAO {
	public List<TimesheetReconciliationVO> getTimesheetData(TimesheetReconcilationPojo timesheetReconcilationPojo,String[] empArray);
	public String updateTimeSheet(TimesheetReconcilationPojo timesheetPojo);

	public ArrayList<DepartmentFilterVO> getAllDepartments();
	public ArrayList<ManagerFilterVO> getManagersByDept(String depts);
	public ArrayList<EmployeeFilterVO> getEmployeesByMang(String manager);

}

