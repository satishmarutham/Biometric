package com.centris.VO;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDetailsForPayrollVo {
	


	private String empid;
	private String empName;
	private String email;
	private String department;
	private String deptid;
	private String location;
	private String designation;
	private String desid;
	private String doj;
	private String totalDaysInMonth;
	private String totalPresent;
	private String totalAbsent;
	private String totalleave;
	private String totalholiday;
	private String totalweekoff;
	private ArrayList<String> absentdates;
	private ArrayList<String> presentdates;
	private ArrayList<String> leavedates;
	private List<String> holidaydates;
	private ArrayList<String> weekoffdates;
	
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getDesid() {
		return desid;
	}
	public void setDesid(String desid) {
		this.desid = desid;
	}
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTotalDaysInMonth() {
		return totalDaysInMonth;
	}
	public void setTotalDaysInMonth(String totalDaysInMonth) {
		this.totalDaysInMonth = totalDaysInMonth;
	}
	public String getTotalPresent() {
		return totalPresent;
	}
	public void setTotalPresent(String totalPresent) {
		this.totalPresent = totalPresent;
	}
	public String getTotalAbsent() {
		return totalAbsent;
	}
	public void setTotalAbsent(String totalAbsent) {
		this.totalAbsent = totalAbsent;
	}
	public String getTotalleave() {
		return totalleave;
	}
	public void setTotalleave(String totalleave) {
		this.totalleave = totalleave;
	}
	public String getTotalholiday() {
		return totalholiday;
	}
	public void setTotalholiday(String totalholiday) {
		this.totalholiday = totalholiday;
	}
	public String getTotalweekoff() {
		return totalweekoff;
	}
	public void setTotalweekoff(String totalweekoff) {
		this.totalweekoff = totalweekoff;
	}
	public ArrayList<String> getAbsentdates() {
		return absentdates;
	}
	public void setAbsentdates(ArrayList<String> absentdates) {
		this.absentdates = absentdates;
	}
	public ArrayList<String> getPresentdates() {
		return presentdates;
	}
	public void setPresentdates(ArrayList<String> presentdates) {
		this.presentdates = presentdates;
	}
	public ArrayList<String> getLeavedates() {
		return leavedates;
	}
	public void setLeavedates(ArrayList<String> leavedates) {
		this.leavedates = leavedates;
	}
	public List<String> getHolidaydates() {
		return holidaydates;
	}
	public void setHolidaydates(List<String> holidaydates) {
		this.holidaydates = holidaydates;
	}
	public ArrayList<String> getWeekoffdates() {
		return weekoffdates;
	}
	public void setWeekoffdates(ArrayList<String> weekoffdates) {
		this.weekoffdates = weekoffdates;
	}
	
	
	
	
	

	
	
	

}
