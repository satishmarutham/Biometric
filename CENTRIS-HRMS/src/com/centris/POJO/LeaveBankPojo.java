package com.centris.POJO;

import java.sql.Date;

public class LeaveBankPojo {
	String sno;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	String AccyearCode;
	Double total_leaves;
	Double allowed_per_month;
	String CreatedBy;
	Date CreateTime;
	String ModifiedBy;
	Date ModifiedTime;
	
	private double sl;
	private double pl;
	private double cl;
	
	
	public String getAccyearCode() {
		return AccyearCode;
	}
	public void setAccyearCode(String accyearCode) {
		AccyearCode = accyearCode;
	}
	public Double getTotal_leaves() {
		return total_leaves;
	}
	public void setTotal_leaves(Double total_leaves) {
		this.total_leaves = total_leaves;
	}
	public Double getAllowed_per_month() {
		return allowed_per_month;
	}
	public void setAllowed_per_month(Double allowed_per_month) {
		this.allowed_per_month = allowed_per_month;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	public String getModifiedBy() {
		return ModifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}
	public Date getModifiedTime() {
		return ModifiedTime;
	}
	public void setModifiedTime(Date modifiedTime) {
		ModifiedTime = modifiedTime;
	}
	public double getSl() {
		return sl;
	}
	public void setSl(double sl) {
		this.sl = sl;
	}
	public double getPl() {
		return pl;
	}
	public void setPl(double pl) {
		this.pl = pl;
	}
	public double getCl() {
		return cl;
	}
	public void setCl(double cl) {
		this.cl = cl;
	}
	
	
	
	
}
