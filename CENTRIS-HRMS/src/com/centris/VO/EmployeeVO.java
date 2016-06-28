/**
 * 
 */
package com.centris.VO;

import java.io.Serializable;

/**
 * @author ratnaraju
 *
 */
public class EmployeeVO implements Serializable {

	/**
	 * 
	 */
	public EmployeeVO() {
		// TODO Auto-generated constructor stub
	}

	private String empid;
	private String empname;
	private String phone;
	private String email;
	private String shiftname;
	private String shiftid;
	private String deptname;
	private String deptid;
	private String emplocation;
	private String emplocationid;
	private String groupcode;
	private String usercode;
	private String desId;
	private String pfnumber;
	private String doj;
	
	
	
	
	public String getDoj() {
		return doj;
	}
	public void setDoj(String doj) {
		this.doj = doj;
	}
	public String getPfnumber() {
		return pfnumber;
	}
	public void setPfnumber(String pfnumber) {
		this.pfnumber = pfnumber;
	}
	public String getDesId() {
		return desId;
	}
	public void setDesId(String desId) {
		this.desId = desId;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	private String designation;
	
	
	private int sunday;
	private int monday;
	private int tuesday;
	private int wednesday;
	private int thursday;
	private int friday;
	private int saturday;
	private int accyear;
	
	
	
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getGroupcode() {
		return groupcode;
	}
	public void setGroupcode(String groupcode) {
		this.groupcode = groupcode;
	}
	public String getEmplocationid() {
		return emplocationid;
	}
	public void setEmplocationid(String emplocationid) {
		this.emplocationid = emplocationid;
	}
	/**
	 * @return the sunday
	 */
	public int getSunday() {
		return sunday;
	}
	/**
	 * @param sunday the sunday to set
	 */
	public void setSunday(int sunday) {
		this.sunday = sunday;
	}
	/**
	 * @return the monday
	 */
	public int getMonday() {
		return monday;
	}
	/**
	 * @param monday the monday to set
	 */
	public void setMonday(int monday) {
		this.monday = monday;
	}
	/**
	 * @return the tuesday
	 */
	public int getTuesday() {
		return tuesday;
	}
	/**
	 * @param tuesday the tuesday to set
	 */
	public void setTuesday(int tuesday) {
		this.tuesday = tuesday;
	}
	/**
	 * @return the wednesday
	 */
	public int getWednesday() {
		return wednesday;
	}
	/**
	 * @param wednesday the wednesday to set
	 */
	public void setWednesday(int wednesday) {
		this.wednesday = wednesday;
	}
	/**
	 * @return the thursday
	 */
	public int getThursday() {
		return thursday;
	}
	/**
	 * @param thursday the thursday to set
	 */
	public void setThursday(int thursday) {
		this.thursday = thursday;
	}
	/**
	 * @return the friday
	 */
	public int getFriday() {
		return friday;
	}
	/**
	 * @param friday the friday to set
	 */
	public void setFriday(int friday) {
		this.friday = friday;
	}
	/**
	 * @return the saturday
	 */
	public int getSaturday() {
		return saturday;
	}
	/**
	 * @param saturday the saturday to set
	 */
	public void setSaturday(int saturday) {
		this.saturday = saturday;
	}
	/**
	 * @return the accyear
	 */
	public int getAccyear() {
		return accyear;
	}
	/**
	 * @param accyear the accyear to set
	 */
	public void setAccyear(int accyear) {
		this.accyear = accyear;
	}


	
	
	
	
	/**
	 * @return the emplocation
	 */
	public String getEmplocation() {
		return emplocation;
	}
	/**
	 * @param emplocation the emplocation to set
	 */
	public void setEmplocation(String emplocation) {
		this.emplocation = emplocation;
	}
	public String getShiftid() {
		return shiftid;
	}
	public void setShiftid(String shiftid) {
		this.shiftid = shiftid;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getShiftname() {
		return shiftname;
	}
	public void setShiftname(String shiftname) {
		this.shiftname = shiftname;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	
	
	
}
