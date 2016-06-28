package com.centris.form;

import org.apache.struts.action.ActionForm;

public class TimeSheetReportForm extends ActionForm{

	private String shiftid;
	private String empdepartment;
	private String empname;
	private String fromdate;
	private String todate;
	
	public String getShiftid() {
		return shiftid;
	}
	public void setShiftid(String shiftid) {
		this.shiftid = shiftid;
	}
	public String getEmpdepartment() {
		return empdepartment;
	}
	public void setEmpdepartment(String empdepartment) {
		this.empdepartment = empdepartment;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
}
