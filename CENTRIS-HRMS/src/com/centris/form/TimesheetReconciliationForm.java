package com.centris.form;

import org.apache.struts.action.ActionForm;

public class TimesheetReconciliationForm extends ActionForm{
	private String empId;
	private String date;
	private String sdate;
	private String edate;
	private String id;
	private String inTime;
	private String outTime;
	private String totalhours;
	private String workinghours;
	private String morningLate;
	private String eveningEarly;
	private String[] dateArray;
	private String[] idArray;
	private String[] inTimeArray;
	private String[] outTimeArray;
	private String[] totalhoursArray;
	private String[] workinghoursArray;
	private String[] morningLateArray;
	private String[] eveningEarlyArray;
	
	private String department;
	private String manager;
	private String employee;
	
	
	public String getDepartment() {
		
		
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String[] getDateArray() {
		return dateArray;
	}
	public void setDateArray(String[] dateArray) {
		this.dateArray = dateArray;
	}
	public String[] getIdArray() {
		return idArray;
	}
	public void setIdArray(String[] idArray) {
		this.idArray = idArray;
	}
	public String[] getInTimeArray() {
		return inTimeArray;
	}
	public void setInTimeArray(String[] inTimeArray) {
		this.inTimeArray = inTimeArray;
	}
	public String[] getOutTimeArray() {
		return outTimeArray;
	}
	public void setOutTimeArray(String[] outTimeArray) {
		this.outTimeArray = outTimeArray;
	}
	public String[] getTotalhoursArray() {
		return totalhoursArray;
	}
	public void setTotalhoursArray(String[] totalhoursArray) {
		this.totalhoursArray = totalhoursArray;
	}
	public String[] getWorkinghoursArray() {
		return workinghoursArray;
	}
	public void setWorkinghoursArray(String[] workinghoursArray) {
		this.workinghoursArray = workinghoursArray;
	}
	public String[] getMorningLateArray() {
		return morningLateArray;
	}
	public void setMorningLateArray(String[] morningLateArray) {
		this.morningLateArray = morningLateArray;
	}
	public String[] getEveningEarlyArray() {
		return eveningEarlyArray;
	}
	public void setEveningEarlyArray(String[] eveningEarlyArray) {
		this.eveningEarlyArray = eveningEarlyArray;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getTotalhours() {
		return totalhours;
	}
	public void setTotalhours(String totalhours) {
		this.totalhours = totalhours;
	}
	public String getWorkinghours() {
		return workinghours;
	}
	public void setWorkinghours(String workinghours) {
		this.workinghours = workinghours;
	}
	public String getMorningLate() {
		return morningLate;
	}
	public void setMorningLate(String morningLate) {
		this.morningLate = morningLate;
	}
	public String getEveningEarly() {
		return eveningEarly;
	}
	public void setEveningEarly(String eveningEarly) {
		this.eveningEarly = eveningEarly;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	
	
}
