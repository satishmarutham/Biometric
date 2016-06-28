package com.centris.delegate;

import com.centris.form.ChangePasswordForm;
import com.centris.service.serviceImpl.ChangePasswordServiceImpl;

public class ChangePasswordBD {
	public boolean checkManagerCurrentPassword(String username, String password) {

		return new ChangePasswordServiceImpl().checkManagerCurrentPassword(
				username, password);
	}

	public String updateManagerPassword(ChangePasswordForm obj) {
		return new ChangePasswordServiceImpl().updateManagerPassword(obj);

	}

	public boolean checkAdminCurrentPassword(String username, String password,
			String Type) {

		return new ChangePasswordServiceImpl().checkAdminCurrentPassword(
				username, password, Type);
	}

	public String updateAdminPassword(ChangePasswordForm obj) {
		return new ChangePasswordServiceImpl().updateAdminPassword(obj);

	}

	public String updateEmployeePassword(ChangePasswordForm obj) {
		return new ChangePasswordServiceImpl().updateEmployeePassword(obj);

	}
}
