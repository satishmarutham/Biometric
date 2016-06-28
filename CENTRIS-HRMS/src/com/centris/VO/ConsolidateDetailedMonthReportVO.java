package com.centris.VO;

import java.util.Comparator;

public class ConsolidateDetailedMonthReportVO implements Comparator {
	private String empid;
	private String empname;
	private String locationName;
	private String date;
	private String attendenceStatus;
	private String inTime;
	private String outTime;
	private String lateTime;
	private String earlyTime;
	private String totalHours;
	private String totalWorkingHours;
	private String totalPresent;
	private String designationName;
	private String shiftName;


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


	public String getLocationName() {
		return locationName;
	}


	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getAttendenceStatus() {
		return attendenceStatus;
	}


	public void setAttendenceStatus(String attendenceStatus) {
		this.attendenceStatus = attendenceStatus;
	}


	public String getInTime() {
		return inTime;
	}


	public void setInTime(String inTime) {
		this.inTime = inTime;
	}


	public String getOutTime() {
		return outTime;
	}


	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}


	public String getLateTime() {
		return lateTime;
	}


	public void setLateTime(String lateTime) {
		this.lateTime = lateTime;
	}


	public String getEarlyTime() {
		return earlyTime;
	}


	public void setEarlyTime(String earlyTime) {
		this.earlyTime = earlyTime;
	}


	public String getTotalHours() {
		return totalHours;
	}


	public void setTotalHours(String totalHours) {
		this.totalHours = totalHours;
	}


	public String getTotalWorkingHours() {
		return totalWorkingHours;
	}


	public void setTotalWorkingHours(String totalWorkingHours) {
		this.totalWorkingHours = totalWorkingHours;
	}


	public String getTotalPresent() {
		return totalPresent;
	}


	public void setTotalPresent(String totalPresent) {
		this.totalPresent = totalPresent;
	}


	public String getDesignationName() {
		return designationName;
	}


	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}


	@Override
	public int compare(Object o1, Object o2) {

		ConsolidateDetailedMonthReportVO vo1 = (ConsolidateDetailedMonthReportVO) o1;
		ConsolidateDetailedMonthReportVO vo2 = (ConsolidateDetailedMonthReportVO) o2;

		return vo1.getDate().compareTo(vo2.getDate());
	}


	public String getShiftName() {
		return shiftName;
	}


	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}
}