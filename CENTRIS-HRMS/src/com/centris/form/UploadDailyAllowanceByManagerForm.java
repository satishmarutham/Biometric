package com.centris.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class UploadDailyAllowanceByManagerForm extends ActionForm{

	private FormFile dailyAllowanceFile;

	public FormFile getDailyAllowanceFile() {
		return dailyAllowanceFile;
	}

	public void setDailyAllowanceFile(FormFile dailyAllowanceFile) {
		this.dailyAllowanceFile = dailyAllowanceFile;
	}
}
