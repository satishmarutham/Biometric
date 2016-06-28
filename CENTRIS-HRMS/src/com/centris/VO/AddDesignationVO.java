package com.centris.VO;

public class AddDesignationVO {
	
	private String desgid;
	private String desgname;
	private String desgdes;
	private String createdate;
	private String createuser;
	private String reportingTo;
	private String reportingToName;
	
	public String getReportingToName() {
		return reportingToName;
	}
	public void setReportingToName(String reportingToName) {
		this.reportingToName = reportingToName;
	}
	public String getReportingTo() {
		return reportingTo;
	}
	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}
	public String getDesgid() {
		return desgid;
	}
	public void setDesgid(String desgid) {
		this.desgid = desgid;
	}
	public String getDesgname() {
		return desgname;
	}
	public void setDesgname(String desgname) {
		this.desgname = desgname;
	}
	public String getDesgdes() {
		return desgdes;
	}
	public void setDesgdes(String desgdes) {
		this.desgdes = desgdes;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getCreateuser() {
		return createuser;
	}
	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

}
