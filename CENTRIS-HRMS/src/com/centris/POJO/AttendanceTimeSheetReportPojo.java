package com.centris.POJO;

import java.util.ArrayList;

public class AttendanceTimeSheetReportPojo {
	
	private String mgr_check;
	private String pjt_check;
	private String dept_ceck;
	private String des_check;
	private String month;
	private String year;
	private ArrayList<ManagerReportPojo> mgr_list;
	private ArrayList<ProjectReportPojo> pjt_list;
	private ArrayList<DepartMentReportPojo> dept_list;
	private ArrayList<DesignationReportPojo> des_list;
	
	public String getMgr_check() {
		return mgr_check;
	}
	public void setMgr_check(String mgr_check) {
		this.mgr_check = mgr_check;
	}
	public String getPjt_check() {
		return pjt_check;
	}
	public void setPjt_check(String pjt_check) {
		this.pjt_check = pjt_check;
	}
	public String getDept_ceck() {
		return dept_ceck;
	}
	public void setDept_ceck(String dept_ceck) {
		this.dept_ceck = dept_ceck;
	}
	public String getDes_check() {
		return des_check;
	}
	public void setDes_check(String des_check) {
		this.des_check = des_check;
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
	public ArrayList<ManagerReportPojo> getMgr_list() {
		return mgr_list;
	}
	public void setMgr_list(ArrayList<ManagerReportPojo> mgr_list) {
		this.mgr_list = mgr_list;
	}
	public ArrayList<ProjectReportPojo> getPjt_list() {
		return pjt_list;
	}
	public void setPjt_list(ArrayList<ProjectReportPojo> pjt_list) {
		this.pjt_list = pjt_list;
	}
	public ArrayList<DepartMentReportPojo> getDept_list() {
		return dept_list;
	}
	public void setDept_list(ArrayList<DepartMentReportPojo> dept_list) {
		this.dept_list = dept_list;
	}
	public ArrayList<DesignationReportPojo> getDes_list() {
		return des_list;
	}
	public void setDes_list(ArrayList<DesignationReportPojo> des_list) {
		this.des_list = des_list;
	}

	
	
	
	

}
