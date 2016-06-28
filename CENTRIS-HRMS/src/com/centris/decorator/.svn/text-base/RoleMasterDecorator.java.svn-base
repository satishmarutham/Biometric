package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.POJO.RoleMasterPojo;


public class RoleMasterDecorator extends TableDecorator {
String check;
public String getCheckBox(){
	String checkBox="";
	RoleMasterPojo masterPojo=(RoleMasterPojo)getCurrentRowObject();
	String roleCode=masterPojo.getRoleCode();
	checkBox="<input type='checkbox' name='rolename' value='"+roleCode+"' id='"+roleCode+"'/>";
	return checkBox;
}
}
