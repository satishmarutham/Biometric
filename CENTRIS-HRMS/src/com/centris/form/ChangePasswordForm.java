package com.centris.form;

import org.apache.struts.action.ActionForm;

public class ChangePasswordForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String Oldpassword;
	public String Newpassword;
	public String Confirmpassword;
	public String manager_Oldpassword;
	public String manager_Newpassword;
	public String manager_Confirmpassword;
	public String manager_EmailID;
	public String userName;

	public String admin_Oldpassword;
	public String admin__Newpassword;
	public String admin__Confirmpassword;

	public String employee_Oldpassword;
	public String employee__Newpassword;
	public String employee__Confirmpassword;
	public String employee_EmailID;
	public String currentUserId;

	public String getEmployee_EmailID() {
		return employee_EmailID;
	}

	public void setEmployee_EmailID(String employee_EmailID) {
		this.employee_EmailID = employee_EmailID;
	}

	public String getEmployee_Oldpassword() {
		return employee_Oldpassword;
	}

	public void setEmployee_Oldpassword(String employee_Oldpassword) {
		this.employee_Oldpassword = employee_Oldpassword;
	}

	public String getEmployee__Newpassword() {
		return employee__Newpassword;
	}

	public void setEmployee__Newpassword(String employee__Newpassword) {
		this.employee__Newpassword = employee__Newpassword;
	}

	public String getEmployee__Confirmpassword() {
		return employee__Confirmpassword;
	}

	public void setEmployee__Confirmpassword(String employee__Confirmpassword) {
		this.employee__Confirmpassword = employee__Confirmpassword;
	}

	public String getAdmin_Oldpassword() {
		return admin_Oldpassword;
	}

	public void setAdmin_Oldpassword(String admin_Oldpassword) {
		this.admin_Oldpassword = admin_Oldpassword;
	}

	public String getAdmin__Newpassword() {
		return admin__Newpassword;
	}

	public void setAdmin__Newpassword(String admin__Newpassword) {
		this.admin__Newpassword = admin__Newpassword;
	}

	public String getAdmin__Confirmpassword() {
		return admin__Confirmpassword;
	}

	public void setAdmin__Confirmpassword(String admin__Confirmpassword) {
		this.admin__Confirmpassword = admin__Confirmpassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOldpassword() {
		return Oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		Oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return Newpassword;
	}

	public void setNewpassword(String newpassword) {
		Newpassword = newpassword;
	}

	public String getConfirmpassword() {
		return Confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		Confirmpassword = confirmpassword;
	}

	public String getManager_Oldpassword() {
		return manager_Oldpassword;
	}

	public void setManager_Oldpassword(String manager_Oldpassword) {
		this.manager_Oldpassword = manager_Oldpassword;
	}

	public String getManager_Newpassword() {
		return manager_Newpassword;
	}

	public void setManager_Newpassword(String manager_Newpassword) {
		this.manager_Newpassword = manager_Newpassword;
	}

	public String getManager_Confirmpassword() {
		return manager_Confirmpassword;
	}

	public void setManager_Confirmpassword(String manager_Confirmpassword) {
		this.manager_Confirmpassword = manager_Confirmpassword;
	}

	public String getManager_EmailID() {
		return manager_EmailID;
	}

	public void setManager_EmailID(String manager_EmailID) {
		this.manager_EmailID = manager_EmailID;
	}

	public String getCurrentUserId() {
		return currentUserId;
	}

	public void setCurrentUserId(String currentUserId) {
		this.currentUserId = currentUserId;
	}
}