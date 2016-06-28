package com.centris.form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import com.centris.VO.MonthlyLagendReportVo;

public class MonthlyLagendReportForm extends ActionForm {
	
	private String group;
	private String empLocation;
	private String shiftid;
	private String department;
	private String year;
	private String month;
	private int days;
	private String designation;
	private ArrayList<MonthlyLagendReportVo> empid;
	
	
	
	
	
	
	
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public ArrayList<MonthlyLagendReportVo> getEmpid() {
		return empid;
	}
	public void setEmpid(ArrayList<MonthlyLagendReportVo> empid) {
		this.empid = empid;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getEmpLocation() {
		return empLocation;
	}
	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}
	public String getShiftid() {
		return shiftid;
	}
	public void setShiftid(String shiftid) {
		this.shiftid = shiftid;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
	
	

}
