package com.centris.VO;

import java.util.Comparator;

public class GroupLogReportVo implements Comparator {

	private String report_Date;
	private String report_Group;
	private String report_Location;
	private String report_LocationCode;
	private String report_TotalEmployee;
	private String report_TotalPresent;
	private String report_TotalAbsent;

	public String getReport_Date() {
		return report_Date;
	}

	public void setReport_Date(String report_Date) {
		this.report_Date = report_Date;
	}

	public String getReport_Group() {
		return report_Group;
	}

	public void setReport_Group(String report_Group) {
		this.report_Group = report_Group;
	}

	public String getReport_Location() {
		return report_Location;
	}

	public void setReport_Location(String report_Location) {
		this.report_Location = report_Location;
	}

	public String getReport_TotalEmployee() {
		return report_TotalEmployee;
	}

	public void setReport_TotalEmployee(String report_TotalEmployee) {
		this.report_TotalEmployee = report_TotalEmployee;
	}

	public String getReport_TotalPresent() {
		return report_TotalPresent;
	}

	public void setReport_TotalPresent(String report_TotalPresent) {
		this.report_TotalPresent = report_TotalPresent;
	}

	public String getReport_TotalAbsent() {
		return report_TotalAbsent;
	}

	public void setReport_TotalAbsent(String report_TotalAbsent) {
		this.report_TotalAbsent = report_TotalAbsent;
	}

	public String getReport_LocationCode() {
		return report_LocationCode;
	}

	public void setReport_LocationCode(String report_LocationCode) {
		this.report_LocationCode = report_LocationCode;
	}

	private String rep_EmployeeId;
	private String rep_EmployeeName;
	private String rep_Date;
	private String rep_Intime;
	private String rep_Outtime;
	private String rep_lateHours;
	private String rep_earlyHours;
	private String rep_totalHours;
	private String rep_WorkingHours;
	private String rep_AttStatus;

	@Override
	public int compare(Object o1, Object o2) {

		GroupLogReportVo vo1 = (GroupLogReportVo) o1;
		GroupLogReportVo vo2 = (GroupLogReportVo) o2;

		return vo1.getReport_Date().compareTo(vo2.getReport_Date());
	}

	public String getRep_EmployeeId() {
		return rep_EmployeeId;
	}

	public void setRep_EmployeeId(String rep_EmployeeId) {
		this.rep_EmployeeId = rep_EmployeeId;
	}

	public String getRep_EmployeeName() {
		return rep_EmployeeName;
	}

	public void setRep_EmployeeName(String rep_EmployeeName) {
		this.rep_EmployeeName = rep_EmployeeName;
	}

	public String getRep_Date() {
		return rep_Date;
	}

	public void setRep_Date(String rep_Date) {
		this.rep_Date = rep_Date;
	}

	public String getRep_Intime() {
		return rep_Intime;
	}

	public void setRep_Intime(String rep_Intime) {
		this.rep_Intime = rep_Intime;
	}

	public String getRep_Outtime() {
		return rep_Outtime;
	}

	public void setRep_Outtime(String rep_Outtime) {
		this.rep_Outtime = rep_Outtime;
	}

	public String getRep_WorkingHours() {
		return rep_WorkingHours;
	}

	public void setRep_WorkingHours(String rep_WorkingHours) {
		this.rep_WorkingHours = rep_WorkingHours;
	}

	public String getRep_AttStatus() {
		return rep_AttStatus;
	}

	public void setRep_AttStatus(String rep_AttStatus) {
		this.rep_AttStatus = rep_AttStatus;
	}

	public String getRep_lateHours() {
		return rep_lateHours;
	}

	public void setRep_lateHours(String rep_lateHours) {
		this.rep_lateHours = rep_lateHours;
	}

	public String getRep_earlyHours() {
		return rep_earlyHours;
	}

	public void setRep_earlyHours(String rep_earlyHours) {
		this.rep_earlyHours = rep_earlyHours;
	}

	public String getRep_totalHours() {
		return rep_totalHours;
	}

	public void setRep_totalHours(String rep_totalHours) {
		this.rep_totalHours = rep_totalHours;
	}
}