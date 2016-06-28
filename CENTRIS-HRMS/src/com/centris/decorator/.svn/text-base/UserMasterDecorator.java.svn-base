package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.POJO.UserMasterPojo;

public class UserMasterDecorator extends TableDecorator {
	public String getAllCheckBox() {
UserMasterPojo masterPojo=(UserMasterPojo)getCurrentRowObject();
	
	String allcheckBox = "<input class=\"user_Checkbox_Class\" type=\"checkbox\" name=\"usenname\" id=\"allCheckBox_"+masterPojo.getUserCode()+
			","+masterPojo.getUsername()
			+","
			+masterPojo.getUserCode()
			
			+","
			+masterPojo.getPassword()
			+","
			+masterPojo.getRoleCode()
			+","
			+masterPojo.getRoleName()
			+","
			+masterPojo.getLocationCode()
			+","
			 +masterPojo.getLocationName()
			 +","
			 +masterPojo.getGroupCode()
			 +","
			 +masterPojo.getGroupName()
			 +"\"/>";
	
	return allcheckBox;
}
}