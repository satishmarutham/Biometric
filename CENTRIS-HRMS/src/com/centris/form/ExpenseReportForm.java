package com.centris.form;

import org.apache.struts.action.ActionForm;

public class ExpenseReportForm extends ActionForm{
	
	private String month;
	private String year;
	private String status;
	private String groupby;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGroupby() {
		return groupby;
	}
	public void setGroupby(String groupby) {
		this.groupby = groupby;
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
