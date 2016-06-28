package com.centris.VO;


import java.util.ArrayList;

public class MonthlyLagendReportVo {
	
	private String shiftid;
	private String shiftname;
	private String deptid;
	private String deptname;
	private String locationid;
	private String locationname;
	private String empid;
	private String empname;
	private String days;
	private String totalpresent;
	private String totalabsent;
	private ArrayList<String> status;
	private String totalpaybledays;
	private String totalweekoff;
	private String paybledays;
	private String designation;
	
	private ArrayList<MonthlyLagendReportVo> emplist;
	private int monthdays;
	private String year;
	private String month;
	private String errormsg;
	
	
	
	
	
	
	
	
	
	
	public String getErrormsg() {
		return errormsg;
	}
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getMonthdays() {
		return monthdays;
	}
	public void setMonthdays(int monthdays) {
		this.monthdays = monthdays;
	}
	public ArrayList<MonthlyLagendReportVo> getEmplist() {
		return emplist;
	}
	public void setEmplist(ArrayList<MonthlyLagendReportVo> emplist) {
		this.emplist = emplist;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getTotalweekoff() {
		return totalweekoff;
	}
	public void setTotalweekoff(String totalweekoff) {
		this.totalweekoff = totalweekoff;
	}
	public String getPaybledays() {
		return paybledays;
	}
	public void setPaybledays(String paybledays) {
		this.paybledays = paybledays;
	}
	public String getTotalpaybledays() {
		return totalpaybledays;
	}
	public void setTotalpaybledays(String totalpaybledays) {
		this.totalpaybledays = totalpaybledays;
	}
	public ArrayList<String> getStatus() {
		return status;
	}
	public void setStatus(ArrayList<String> status) {
		this.status = status;
	}
	public String getLocationid() {
		return locationid;
	}
	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}
	public String getLocationname() {
		return locationname;
	}
	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}
	public String getShiftid() {
		return shiftid;
	}
	public void setShiftid(String shiftid) {
		this.shiftid = shiftid;
	}
	public String getShiftname() {
		return shiftname;
	}
	public void setShiftname(String shiftname) {
		this.shiftname = shiftname;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getTotalpresent() {
		return totalpresent;
	}
	public void setTotalpresent(String totalpresent) {
		this.totalpresent = totalpresent;
	}
	public String getTotalabsent() {
		return totalabsent;
	}
	public void setTotalabsent(String totalabsent) {
		this.totalabsent = totalabsent;
	}
	
	

}
