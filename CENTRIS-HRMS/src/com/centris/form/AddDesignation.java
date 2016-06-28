package com.centris.form;

import org.apache.struts.action.ActionForm;

/**
 * @author seshuma
 *
 */
public class AddDesignation extends ActionForm {
	
	
	String designationid;
	String designation_name;
	String designation_description;
	String reportingTo;
	
	public String getReportingTo() {
		return reportingTo;
	}
	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}
	public String getDesignationid() {
		return designationid;
	}
	public void setDesignationid(String designationid) {
		this.designationid = designationid;
	}
	public String getDesignation_name() {
		return designation_name;
	}
	public void setDesignation_name(String designation_name) {
		this.designation_name = designation_name;
	}
	public String getDesignation_description() {
		return designation_description;
	}
	public void setDesignation_description(String designation_description) {
		this.designation_description = designation_description;
	}
	
	
}
