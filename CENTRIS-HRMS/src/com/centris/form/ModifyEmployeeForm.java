package com.centris.form;

import org.apache.struts.action.ActionForm;


/**
 * @author seshuma
 *
 */
public class ModifyEmployeeForm extends ActionForm {

	public ModifyEmployeeForm(){
		
		
	}
	private static final long serialVersionUID = 1L;
	
	private String selectEmployee;
	
	public String getSelectEmployee() {
		return selectEmployee;
	}
	public void setSelectEmployee(String selectEmployee) {
		this.selectEmployee = selectEmployee;
	}
	
	private String employeeName;
	private String employeeID;
	private String employeePhone;
	private String employeeEmailID;
	private String employeeAddress;
	private String employeeDesignation;
	private String employeeDepartment;
	private String employeeshiftID;
	private String employeeType;
	private String dob;
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}

	private String doj;
	private String father;
	public String getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeeEmailID() {
		return employeeEmailID;
	}
	public void setEmployeeEmailID(String employeeEmailID) {
		this.employeeEmailID = employeeEmailID;
	}
	
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	public String getEmployeeshiftID() {
		return employeeshiftID;
	}
	public void setEmployeeshiftID(String employeeshiftID) {
		this.employeeshiftID = employeeshiftID;
	}
}
