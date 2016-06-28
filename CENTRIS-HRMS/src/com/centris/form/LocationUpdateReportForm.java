package com.centris.form;

import org.apache.struts.action.ActionForm;

public class LocationUpdateReportForm extends ActionForm {
	private String group;
	private String location;
	
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
}
