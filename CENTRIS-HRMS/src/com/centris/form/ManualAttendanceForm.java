package com.centris.form;

import org.apache.struts.action.ActionForm;

public class ManualAttendanceForm extends ActionForm {

	private String group;
	private String location;
	private String employee;
	private String reportDate;
	private String reportStatus[];
	private String employeeId[];
	private String updatedUser;
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

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String[] getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus[]) {
		this.reportStatus = reportStatus;
	}

	public String[] getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String[] employeeId) {
		this.employeeId = employeeId;
	}

	public String getUpdatedUser() {
		return updatedUser;
	}

	public void setUpdatedUser(String updatedUser) {
		this.updatedUser = updatedUser;
	}
}
