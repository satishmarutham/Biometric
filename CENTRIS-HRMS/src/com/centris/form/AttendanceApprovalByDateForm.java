package com.centris.form;

import org.apache.struts.action.ActionForm;

public class AttendanceApprovalByDateForm extends ActionForm {

	private String startdate;
	private String enddate;
	private String employeename;
	
	
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	
	
	
	
}
