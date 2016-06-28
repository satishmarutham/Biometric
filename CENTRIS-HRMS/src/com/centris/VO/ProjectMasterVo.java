package com.centris.VO;

import java.io.Serializable;
import java.sql.Timestamp;

public class ProjectMasterVo implements Serializable{
	
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
	
	private String projectmanager;
	
	private String projectstatus;
	private String reportingto;
	private String userId;
	
	private String approvedby;
	private String closedby;
	
	private String ponumber;
	private String approveddate;
	private String closeddate;
	private int sno;
	
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getApproveddate() {
		return approveddate;
	}
	public void setApproveddate(String approveddate) {
		this.approveddate = approveddate;
	}
	public String getCloseddate() {
		return closeddate;
	}
	public void setCloseddate(String closeddate) {
		this.closeddate = closeddate;
	}
	public String getPonumber() {
		return ponumber;
	}
	public void setPonumber(String ponumber) {
		this.ponumber = ponumber;
	}
	public String getApprovedby() {
		return approvedby;
	}
	public void setApprovedby(String approvedby) {
		this.approvedby = approvedby;
	}
	public String getClosedby() {
		return closedby;
	}
	public void setClosedby(String closedby) {
		this.closedby = closedby;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProjectstatus() {
		return projectstatus;
	}
	public void setProjectstatus(String projectstatus) {
		this.projectstatus = projectstatus;
	}
	public String getReportingto() {
		return reportingto;
	}
	public void setReportingto(String reportingto) {
		this.reportingto = reportingto;
	}
	public String getProjectmanager() {
		return projectmanager;
	}
	public void setProjectmanager(String projectmanager) {
		this.projectmanager = projectmanager;
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
	public String getProjectlocation() {
		return projectlocation;
	}
	public void setProjectlocation(String projectlocation) {
		this.projectlocation = projectlocation;
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
		
		System.out.println(projectRefCode);
		System.out.println( projectname);
		System.out.println( projectlocation);
		System.out.println(" ---------  Project POJO Object ---------------");
		return super.toString();
	}

}
