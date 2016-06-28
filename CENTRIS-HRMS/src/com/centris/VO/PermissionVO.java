package com.centris.VO;

public class PermissionVO {
private String permissionId;
private String permissionName;
private String permissionShortName;
private String permissionIsApplicable;
private String serverMessage;

public String getPermissionId() {
	return permissionId;
}
public void setPermissionId(String permissionId) {
	this.permissionId = permissionId;
}
public String getPermissionName() {
	return permissionName;
}
public void setPermissionName(String permissionName) {
	this.permissionName = permissionName;
}
public String getPermissionShortName() {
	return permissionShortName;
}
public void setPermissionShortName(String permissionShortName) {
	this.permissionShortName = permissionShortName;
}
public String getPermissionIsApplicable() {
	return permissionIsApplicable;
}
public void setPermissionIsApplicable(String permissionIsApplicable) {
	this.permissionIsApplicable = permissionIsApplicable;
}
public String getServerMessage() {
	return serverMessage;
}
public void setServerMessage(String serverMessage) {
	this.serverMessage = serverMessage;
}
}
