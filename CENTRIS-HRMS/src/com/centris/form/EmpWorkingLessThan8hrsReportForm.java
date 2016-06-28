/**
 * 
 */
package com.centris.form;

import org.apache.struts.action.ActionForm;

/**
 * @author sathish
 *
 */
public class EmpWorkingLessThan8hrsReportForm  extends ActionForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String startDate;
	private String endDate;
	private String groupId;
	private String groupName;
	private String location;
	private String shift;
	private String employee;
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
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
}
