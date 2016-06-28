/**
 * 
 */
package com.centris.VO;

import java.io.Serializable;

/**
 * @author satish
 *
 */
public class ReportsAjaxVo implements Serializable{
/**
	 * 
	 */
	
private String managerName;
private String managerCode;
private String projectCode;
private String projectName;
private String projectRefName;
private String projectRefCode;
private String managerid;
private String firstname;

public String getManagerid() {
	return managerid;
}
public void setManagerid(String managerid) {
	this.managerid = managerid;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getProjectRefName() {
	return projectRefName;
}
public void setProjectRefName(String projectRefName) {
	this.projectRefName = projectRefName;
}
public String getProjectRefCode() {
	return projectRefCode;
}
public void setProjectRefCode(String projectRefCode) {
	this.projectRefCode = projectRefCode;
}

public String getManagerName() {
	return managerName;
}
public void setManagerName(String managerName) {
	this.managerName = managerName;
}
public String getManagerCode() {
	return managerCode;
}
public void setManagerCode(String managerCode) {
	this.managerCode = managerCode;
}
public String getProjectCode() {
	return projectCode;
}
public void setProjectCode(String projectCode) {
	this.projectCode = projectCode;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}


}
