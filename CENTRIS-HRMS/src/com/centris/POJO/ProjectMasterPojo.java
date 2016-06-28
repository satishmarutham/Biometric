package com.centris.POJO;

import java.sql.Date;
import java.sql.Timestamp;

public class ProjectMasterPojo {

	private String projectcode;
	private String projectname;
	private String projectRefCode;
	private String createdby;
	private Timestamp createdate;
	private String projectlocation;
	
	private String clientname;
	private String projecttype;
	private String endcustomer;
	
	private String userType;
	
	private String projectHighLevelActivity;
	private String forFuturExpan;
	private String projectActivityCat;
	private String linkfinancialyear;
	
	private String reportingto;
	private String userFirstName;
	
	private String checkboxval;
	private String ponumber;
	
	
	
	
	
	
	public String getPonumber() {
		return ponumber;
	}
	public void setPonumber(String ponumber) {
		this.ponumber = ponumber;
	}
	public String getCheckboxval() {
		return checkboxval;
	}
	public void setCheckboxval(String checkboxval) {
		this.checkboxval = checkboxval;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	
	public String getReportingto() {
		return reportingto;
	}
	public void setReportingto(String reportingto) {
		this.reportingto = reportingto;
	}
	public String getProjectHighLevelActivity() {
		return projectHighLevelActivity;
	}
	public void setProjectHighLevelActivity(String projectHighLevelActivity) {
		this.projectHighLevelActivity = projectHighLevelActivity;
	}
	public String getForFuturExpan() {
		return forFuturExpan;
	}
	public void setForFuturExpan(String forFuturExpan) {
		this.forFuturExpan = forFuturExpan;
	}
	public String getProjectActivityCat() {
		return projectActivityCat;
	}
	public void setProjectActivityCat(String projectActivityCat) {
		this.projectActivityCat = projectActivityCat;
	}
	public String getLinkfinancialyear() {
		return linkfinancialyear;
	}
	public void setLinkfinancialyear(String linkfinancialyear) {
		this.linkfinancialyear = linkfinancialyear;
	}
	
	
	
	
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getProjectlocation() {
		return projectlocation;
	}
	public void setProjectlocation(String projectlocation) {
		this.projectlocation = projectlocation;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Timestamp getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}
	public String getProjectcode() {
		return projectcode;
	}
	public void setProjectcode(String projectcode) {
		this.projectcode = projectcode;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getProjectRefCode() {
		return projectRefCode;
	}
	public void setProjectRefCode(String projectRefCode) {
		this.projectRefCode = projectRefCode;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public String getProjecttype() {
		return projecttype;
	}
	public void setProjecttype(String projecttype) {
		this.projecttype = projecttype;
	}
	public String getEndcustomer() {
		return endcustomer;
	}
	public void setEndcustomer(String endcustomer) {
		this.endcustomer = endcustomer;
	}
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub

		System.out.println(" ---------  Project POJO Object ---------------");
		System.out.println( clientname);
		System.out.println( projecttype);
		System.out.println( projectHighLevelActivity);
		System.out.println( endcustomer);
		System.out.println( forFuturExpan);
		System.out.println( projectActivityCat);
		System.out.println( linkfinancialyear);
		
		
		System.out.println( projectname);
		System.out.println( projectlocation);
		System.out.println(" ---------  Project POJO Object ---------------");
		return super.toString();
	}

	
	
}
