package com.centris.form;

import org.apache.struts.action.ActionForm;

public class AttendanceTimeSheetReportForm extends ActionForm {
	
	private String manager;
	private String department;
	private String month;
	private String year;
	private String employee;
	
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
	
	
	
	

	
	
}
