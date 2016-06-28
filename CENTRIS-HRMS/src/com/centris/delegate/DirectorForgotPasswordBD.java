package com.centris.delegate;

import com.centris.service.serviceImpl.AdminForgotPasswordServiceImpl;
import com.centris.service.serviceImpl.DirectorForgotPasswordServiceIMPL;

public class DirectorForgotPasswordBD {
	
	public int resetDirectorPassword(String username, String email) {
		return new DirectorForgotPasswordServiceIMPL().resetDirectorPassword(
				username, email);
	}

}
