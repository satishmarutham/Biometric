package com.centris.form;

import org.apache.struts.action.ActionForm;

public class LetterHeadForm extends ActionForm {

	
	private String lettertype;
	private String purpose;
	private String description;
	
	
	public String getLettertype() {
		return lettertype;
	}
	public void setLettertype(String lettertype) {
		this.lettertype = lettertype;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
	
	
	
	
}
