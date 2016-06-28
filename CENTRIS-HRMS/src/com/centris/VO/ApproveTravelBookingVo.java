package com.centris.VO;

import java.io.Serializable;

public class ApproveTravelBookingVo implements Serializable{
	
	private String tkt_book_code;
	private String booked_by_bioid;
	private String booked_by_empid;
	private String who_on_travel_bioid;
	private String who_on_travel_empid;
	private Double amount;
	private String travel_mode;
	private String project_Ref_code;
	private String travel_from;
	private String travel_to;
	private String remarks;
	private String travelling_date;
	private String booked_date;
	private String debit_card_used_by_bioid;
	private String  debit_card_used_by_empid;
	private String posted_by;
	private String booked_by_empname;
	private String who_on_travel_empname;
	private String  debit_card_used_by_empname;
	private String posteddate;
	private String project;
	private String status;
	private String posted_by_id;
	private String approvedby;
	private String approvedtime;
	private String diretorremarks;
	private double approveAmount;
	private String approvedByName;
	private int sno;
	private String filepath;
	
	private String isRejectedStatus;
	
	private String dounloadstatus;
	
	private String approveDireCode;
	
	private double accountApproveAmt;
	
	
	
	public double getAccountApproveAmt() {
		return accountApproveAmt;
	}
	public void setAccountApproveAmt(double accountApproveAmt) {
		this.accountApproveAmt = accountApproveAmt;
	}
	public String getApproveDireCode() {
		return approveDireCode;
	}
	public void setApproveDireCode(String approveDireCode) {
		this.approveDireCode = approveDireCode;
	}
	public String getDounloadstatus() {
		return dounloadstatus;
	}
	public void setDounloadstatus(String dounloadstatus) {
		this.dounloadstatus = dounloadstatus;
	}
	public String getIsRejectedStatus() {
		return isRejectedStatus;
	}
	public void setIsRejectedStatus(String isRejectedStatus) {
		this.isRejectedStatus = isRejectedStatus;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	private String postedByBioCode;
	private String approvedByBiocode;
	
	
	
	public String getPostedByBioCode() {
		return postedByBioCode;
	}
	public void setPostedByBioCode(String postedByBioCode) {
		this.postedByBioCode = postedByBioCode;
	}
	public String getApprovedByBiocode() {
		return approvedByBiocode;
	}
	public void setApprovedByBiocode(String approvedByBiocode) {
		this.approvedByBiocode = approvedByBiocode;
	}
	public String getApprovedByName() {
		return approvedByName;
	}
	public void setApprovedByName(String approvedByName) {
		this.approvedByName = approvedByName;
	}
	public double getApproveAmount() {
		return approveAmount;
	}
	public void setApproveAmount(double approveAmount) {
		this.approveAmount = approveAmount;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
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
	public String getDiretorremarks() {
		return diretorremarks;
	}
	public void setDiretorremarks(String diretorremarks) {
		this.diretorremarks = diretorremarks;
	}
	public String getPosted_by_id() {
		return posted_by_id;
	}
	public void setPosted_by_id(String posted_by_id) {
		this.posted_by_id = posted_by_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getBooked_by_empname() {
		return booked_by_empname;
	}
	public void setBooked_by_empname(String booked_by_empname) {
		this.booked_by_empname = booked_by_empname;
	}
	public String getWho_on_travel_empname() {
		return who_on_travel_empname;
	}
	public void setWho_on_travel_empname(String who_on_travel_empname) {
		this.who_on_travel_empname = who_on_travel_empname;
	}
	public String getDebit_card_used_by_empname() {
		return debit_card_used_by_empname;
	}
	public void setDebit_card_used_by_empname(String debit_card_used_by_empname) {
		this.debit_card_used_by_empname = debit_card_used_by_empname;
	}
	public String getPosteddate() {
		return posteddate;
	}
	public void setPosteddate(String posteddate) {
		this.posteddate = posteddate;
	}
	public String getTkt_book_code() {
		return tkt_book_code;
	}
	public void setTkt_book_code(String tkt_book_code) {
		this.tkt_book_code = tkt_book_code;
	}
	public String getBooked_by_bioid() {
		return booked_by_bioid;
	}
	public void setBooked_by_bioid(String booked_by_bioid) {
		this.booked_by_bioid = booked_by_bioid;
	}
	public String getBooked_by_empid() {
		return booked_by_empid;
	}
	public void setBooked_by_empid(String booked_by_empid) {
		this.booked_by_empid = booked_by_empid;
	}
	public String getWho_on_travel_bioid() {
		return who_on_travel_bioid;
	}
	public void setWho_on_travel_bioid(String who_on_travel_bioid) {
		this.who_on_travel_bioid = who_on_travel_bioid;
	}
	public String getWho_on_travel_empid() {
		return who_on_travel_empid;
	}
	public void setWho_on_travel_empid(String who_on_travel_empid) {
		this.who_on_travel_empid = who_on_travel_empid;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTravel_mode() {
		return travel_mode;
	}
	public void setTravel_mode(String travel_mode) {
		this.travel_mode = travel_mode;
	}
	public String getProject_Ref_code() {
		return project_Ref_code;
	}
	public void setProject_Ref_code(String project_Ref_code) {
		this.project_Ref_code = project_Ref_code;
	}
	public String getTravel_from() {
		return travel_from;
	}
	public void setTravel_from(String travel_from) {
		this.travel_from = travel_from;
	}
	public String getTravel_to() {
		return travel_to;
	}
	public void setTravel_to(String travel_to) {
		this.travel_to = travel_to;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getTravelling_date() {
		return travelling_date;
	}
	public void setTravelling_date(String travelling_date) {
		this.travelling_date = travelling_date;
	}
	public String getBooked_date() {
		return booked_date;
	}
	public void setBooked_date(String booked_date) {
		this.booked_date = booked_date;
	}
	public String getDebit_card_used_by_bioid() {
		return debit_card_used_by_bioid;
	}
	public void setDebit_card_used_by_bioid(String debit_card_used_by_bioid) {
		this.debit_card_used_by_bioid = debit_card_used_by_bioid;
	}
	public String getDebit_card_used_by_empid() {
		return debit_card_used_by_empid;
	}
	public void setDebit_card_used_by_empid(String debit_card_used_by_empid) {
		this.debit_card_used_by_empid = debit_card_used_by_empid;
	}
	public String getPosted_by() {
		return posted_by;
	}
	public void setPosted_by(String posted_by) {
		this.posted_by = posted_by;
	}

}
