package com.centris.form;

import org.apache.struts.action.ActionForm;

public class WeekoffSettingForm extends ActionForm {
	private boolean sunday;
	private boolean monday;
	private boolean tuesday;
	private boolean wednesday;
	private boolean thrusday;
	private boolean friday;
	private boolean saturday;
	private String empCode;
	private String userCode;
	
	private String mappedcalencode;
	private String mappedcalen;
	
	
	public String getMappedcalencode() {
		return mappedcalencode;
	}
	public void setMappedcalencode(String mappedcalencode) {
		this.mappedcalencode = mappedcalencode;
	}
	public String getMappedcalen() {
		return mappedcalen;
	}
	public void setMappedcalen(String mappedcalen) {
		this.mappedcalen = mappedcalen;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public boolean isSunday() {
		return sunday;
	}
	public void setSunday(boolean sunday) {
		this.sunday = sunday;
	}
	public boolean isMonday() {
		return monday;
	}
	public void setMonday(boolean monday) {
		this.monday = monday;
	}
	public boolean isTuesday() {
		return tuesday;
	}
	public void setTuesday(boolean tuesday) {
		this.tuesday = tuesday;
	}
	public boolean isWednesday() {
		return wednesday;
	}
	public void setWednesday(boolean wednesday) {
		this.wednesday = wednesday;
	}
	public boolean isThrusday() {
		return thrusday;
	}
	public void setThrusday(boolean thrusday) {
		this.thrusday = thrusday;
	}
	public boolean isFriday() {
		return friday;
	}
	public void setFriday(boolean friday) {
		this.friday = friday;
	}
	public boolean isSaturday() {
		return saturday;
	}
	public void setSaturday(boolean saturday) {
		this.saturday = saturday;
	}
	
	

}
