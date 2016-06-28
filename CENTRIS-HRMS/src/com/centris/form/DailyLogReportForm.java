package com.centris.form;

import org.apache.struts.action.ActionForm;

public class DailyLogReportForm extends ActionForm{
	
	
	
	public DailyLogReportForm() {
		super();
	System.out.println(" DailyLogReportForm IS cALLED");
	}
	
	
	private String group;
	private String location;
	private String designation;
	private String employee;
	private String startDate;
	private String endDate;
	
	private String hgroup;
	private String hlocation;
	private String hshift;
	private String hemployee;
	private String hstartdate;
	private String henddate;
	
	
	
	public String getHgroup() {
		return hgroup;
	}
	public void setHgroup(String hgroup) {
		this.hgroup = hgroup;
	}
	public String getHlocation() {
		return hlocation;
	}
	public void setHlocation(String hlocation) {
		this.hlocation = hlocation;
	}
	public String getHshift() {
		return hshift;
	}
	public void setHshift(String hshift) {
		this.hshift = hshift;
	}
	public String getHemployee() {
		return hemployee;
	}
	public void setHemployee(String hemployee) {
		this.hemployee = hemployee;
	}
	public String getHstartdate() {
		return hstartdate;
	}
	public void setHstartdate(String hstartdate) {
		this.hstartdate = hstartdate;
	}
	public String getHenddate() {
		return henddate;
	}
	public void setHenddate(String henddate) {
		this.henddate = henddate;
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
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	
	
	
	
	
	
	
}
