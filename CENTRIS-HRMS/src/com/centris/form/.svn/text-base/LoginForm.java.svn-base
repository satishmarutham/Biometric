package com.centris.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.validator.ValidatorForm;

import com.centris.util.StringUtils;

public class LoginForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;

	private String password;

	

	public LoginForm() {
		super();
	}



	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (userName == null || userName.length() < 1) {
			errors.add(StringUtils.UNAME, new ActionMessage(
					StringUtils.UNAME_REQ));
		}
		if (password == null || password.length() < 1) {
			errors.add(StringUtils.PWD, new ActionMessage(StringUtils.PWD_REQ));
		}
		return errors;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.userName = null;
		this.password = null;
		
	}
}
