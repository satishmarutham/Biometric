package com.centris.VO;
import java.io.Serializable;
import java.util.List;
public class HolidayMasterVO implements Serializable {
	String depId;
	String depName;
	String desc;
	String depLoc;
	String locManagerMail;
	String hrManagerMail;
	String onsiteManagerMail;
	String year;
	String holidaysName;
String clientCode;
String clientName;
	String accademicYearCode;
	
	
	
	public String getAccademicYearCode() {
		return accademicYearCode;
	}
	public void setAccademicYearCode(String accademicYearCode) {
		this.accademicYearCode = accademicYearCode;
	}
	public String getClientCode() {
	return clientCode;
}
public void setClientCode(String clientCode) {
	this.clientCode = clientCode;
}
public String getClientName() {
	return clientName;
}
public void setClientName(String clientName) {
	this.clientName = clientName;
}
	public String getHolidaysName() {
		return holidaysName;
	}
	public void setHolidaysName(String holidaysName) {
		this.holidaysName = holidaysName;
	}                                                           
	public String getDate() {
		return date;                                           
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}
	String date;
	String weekDay;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	List depRecords;
	
	public String getDepId() {
		return depId;
	}
	public void setDepId(String depId) {
		this.depId = depId;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getDepLoc() {
		return depLoc;
	}
	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}
	public String getLocManagerMail() {
		return locManagerMail;
	}
	public void setLocManagerMail(String locManagerMail) {
		this.locManagerMail = locManagerMail;
	}
	public String getHrManagerMail() {
		return hrManagerMail;
	}
	public void setHrManagerMail(String hrManagerMail) {
		this.hrManagerMail = hrManagerMail;
	}
	
	public List getDepRecords() {
		return depRecords;
	}
	public void setDepRecords(List depRecords) {
		this.depRecords = depRecords;
	}
	public String getOnsiteManagerMail() {
		return onsiteManagerMail;
	}
	public void setOnsiteManagerMail(String onsiteManagerMail) {
		this.onsiteManagerMail = onsiteManagerMail;
	}
}


