package com.centris.form;
import java.util.List;
import org.apache.struts.action.ActionForm;

public class DepartmentMasterForm extends ActionForm{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String depId;
String depName;
String desc;
String depLoc;
String locManagerMail;
String hrManagerMail;
String onsiteManagerMail;
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
