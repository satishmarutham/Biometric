package com.centris.form;

import org.apache.struts.action.ActionForm;

public class ApproveTravelBookingForm extends ActionForm {
	
	
	private String todate;
	private String fromdate;
	
	
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	



}
