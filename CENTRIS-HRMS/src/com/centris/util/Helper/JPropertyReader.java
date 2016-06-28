package com.centris.util.Helper;

import java.util.ResourceBundle;

import com.centris.util.constants.MessageConstants;
public class JPropertyReader {
	public static String getProperty(String key) {
		@SuppressWarnings("unused")
		String PROPERTY_FILE=MessageConstants.prop_dir;
		ResourceBundle rb = ResourceBundle.getBundle(PROPERTY_FILE);
		String propvalue=rb.getString(key);
		return propvalue;
	}
	public static String  readlog4JProperty(String strKey) 
	{	String PROPERTY_NAME=MessageConstants.log4J_dir;
		ResourceBundle rb=ResourceBundle.getBundle(PROPERTY_NAME);
		String strPropertyValue=rb.getString(strKey);
		return strPropertyValue;
	}
}
