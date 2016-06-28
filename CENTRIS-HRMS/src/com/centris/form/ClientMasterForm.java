/**
 * 
 */
package com.centris.form;

import org.apache.struts.action.ActionForm;

/**
 * @author satish
 *
 */
public class ClientMasterForm  extends ActionForm{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String clientName;
private String country;
private String state;
private String address;
private String phoneNo;
private String clientCode;
private String createdBy;


public String getClientCode() {
	return clientCode;
}
public void setClientCode(String clientCode) {
	this.clientCode = clientCode;
}
public String getCreatedBy() {
	return createdBy;
}
public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public String getClientName() {
	return clientName;
}
public void setClientName(String clientName) {
	this.clientName = clientName;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}





}
