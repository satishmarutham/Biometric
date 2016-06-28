package com.centris.form;

import org.apache.struts.action.ActionForm;

public class AttendenceApprovelForm extends ActionForm {
	
	private String year;
	private String month;
	private String emplyeeid;
	
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getEmplyeeid() {
		return emplyeeid;
	}
	public void setEmplyeeid(String emplyeeid) {
		this.emplyeeid = emplyeeid;
	}
	
	

}
