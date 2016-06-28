package com.centris.form;

import org.apache.struts.action.ActionForm;

public class ManagerExpenseDetailsForm extends ActionForm {

	private String year;
	private String month;
	private String manager;

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

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
}
