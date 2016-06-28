package com.centris.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class EmployeeLeaveRequestForm extends ActionForm {
	
	private String leaverequestto;
	private String noofleaves;
	private String startdate;
	private String enddate;
	private String reasonforleaves;
	private FormFile fileupload;
	private String filepath;
	private String usercode;
	private String leavetype;

	public String getLeavetype() {
		return leavetype;
	}
	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getLeaverequestto() {
		return leaverequestto;
	}
	public void setLeaverequestto(String leaverequestto) {
		this.leaverequestto = leaverequestto;
	}
	public String getNoofleaves() {
		return noofleaves;
	}
	public void setNoofleaves(String noofleaves) {
		this.noofleaves = noofleaves;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getReasonforleaves() {
		return reasonforleaves;
	}
	public void setReasonforleaves(String reasonforleaves) {
		this.reasonforleaves = reasonforleaves;
	}
	public FormFile getFileupload() {
		return fileupload;
	}
	public void setFileupload(FormFile fileupload) {
		this.fileupload = fileupload;
	}
	
	
	
	
	
	
	
	
	

}
