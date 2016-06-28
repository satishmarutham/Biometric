package com.centris.service;

import com.centris.form.ChangePasswordForm;

public interface ChangePasswordService {
	public boolean checkManagerCurrentPassword(String username, String password);
	public String  updateManagerPassword(ChangePasswordForm changePasswordForm);
	public boolean checkAdminCurrentPassword(String username, String password,String Type);
	public String updateAdminPassword(ChangePasswordForm obj);
	public String updateEmployeePassword(ChangePasswordForm obj);
	
}
