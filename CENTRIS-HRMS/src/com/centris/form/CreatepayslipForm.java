package com.centris.form;

import org.apache.struts.action.ActionForm;

public class CreatepayslipForm extends ActionForm {
	
	
	private String dept;
	private String month;
	private String year;
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
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
	
	
	
	

}
