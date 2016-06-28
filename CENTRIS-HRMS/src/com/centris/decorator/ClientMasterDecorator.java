/**
 * 
 */
package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.POJO.ClientMasterPojo;

/**
 * @author satish
 *
 */
public class ClientMasterDecorator extends TableDecorator {
String check;
public  String getCheck(){
	String chkbx = "";
	
	 ClientMasterPojo clientMasterPojo=(ClientMasterPojo)getCurrentRowObject();
		String clientClode=clientMasterPojo.getClientCode();
		
		chkbx = "<input type='checkbox' name='desname'  value='"+clientClode+"' id='" + clientClode + "' />";
		
		return chkbx;
	
	
}
}
