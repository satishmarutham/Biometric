package com.centris.delegate;

import com.centris.service.serviceImpl.AdminForgotPasswordServiceImpl;

public class AdminForgotPasswordBD {
	public int resetAdminPassword(String username, String email) {
		return new AdminForgotPasswordServiceImpl().resetAdminPassword(
				username, email);
	}

}
