package com.centris.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class YearlyReportForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String group;
	private String location;
	private String shift;
	private String employee;
	private String startmonth;
	private String endmonth;
	private String year;
	private List<String> employeeIdList;
	
	
	
	public List<String> getEmployeeIdList() {
		return employeeIdList;
	}
	public void setEmployeeIdList(List<String> employeeIdList) {
		this.employeeIdList = employeeIdList;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getStartmonth() {
		return startmonth;
	}
	public void setStartmonth(String startmonth) {
		this.startmonth = startmonth;
	}
	public String getEndmonth() {
		return endmonth;
	}
	public void setEndmonth(String endmonth) {
		this.endmonth = endmonth;
	}
	
}
