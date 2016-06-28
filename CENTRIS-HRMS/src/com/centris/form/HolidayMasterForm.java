package com.centris.form;
import org.apache.struts.action.ActionForm;
public class HolidayMasterForm extends ActionForm{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String department; 
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
	public String[] getDate() {
		return date;
	}
	public void setDate(String[] date) {
		this.date = date;
	}
	public String[] getWeekday() {
		return weekday;
	}
	public void setWeekday(String[] weekday) {
		this.weekday = weekday;
	}
	public String[] getHoliday() {
		return holiday;
	}
	public void setHoliday(String[] holiday) {
		this.holiday = holiday;
	}
	String year;
	 String[] date; 
	 String[]weekday; 
	 String[] holiday;
	 String client;
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 

}
