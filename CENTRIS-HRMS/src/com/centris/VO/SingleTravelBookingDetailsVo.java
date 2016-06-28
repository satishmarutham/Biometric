package com.centris.VO;

import java.io.Serializable;

public class SingleTravelBookingDetailsVo implements Serializable{
	

	private String project;
	private String projectrefcode;
	private String postedby;
	private String posteddate;
	private String creditcardused;
	private String travelling_date;
	private String posted_by_remarks;
	private String approvedby;
	private String approvedtime;
	private String remarks;
	private String directorremarks;
	
	
	
	public String getDirectorremarks() {
		return directorremarks;
	}
	public void setDirectorremarks(String directorremarks) {
		this.directorremarks = directorremarks;
	}
	public String getProjectrefcode() {
		return projectrefcode;
	}
	public void setProjectrefcode(String projectrefcode) {
		this.projectrefcode = projectrefcode;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getPostedby() {
		return postedby;
	}
	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}
	public String getPosteddate() {
		return posteddate;
	}
	public void setPosteddate(String posteddate) {
		this.posteddate = posteddate;
	}
	public String getCreditcardused() {
		return creditcardused;
	}
	public void setCreditcardused(String creditcardused) {
		this.creditcardused = creditcardused;
	}
	public String getTravelling_date() {
		return travelling_date;
	}
	public void setTravelling_date(String travelling_date) {
		this.travelling_date = travelling_date;
	}
	public String getPosted_by_remarks() {
		return posted_by_remarks;
	}
	public void setPosted_by_remarks(String posted_by_remarks) {
		this.posted_by_remarks = posted_by_remarks;
	}
	public String getApprovedby() {
		return approvedby;
	}
	public void setApprovedby(String approvedby) {
		this.approvedby = approvedby;
	}
	public String getApprovedtime() {
		return approvedtime;
	}
	public void setApprovedtime(String approvedtime) {
		this.approvedtime = approvedtime;
	}
	
	
	
	
	

}
