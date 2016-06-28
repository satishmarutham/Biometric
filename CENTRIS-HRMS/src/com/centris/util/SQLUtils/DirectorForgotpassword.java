package com.centris.util.SQLUtils;

public class DirectorForgotpassword {
	
	public static final String DIRECTOR_FORGET_PASSWORD="select e.First_Name from hrms_employee e,hrms_director d where e.EMPID=d.EMPID and d.Username=? and e.Official_Email_ID=?";
	public static final String GET_DIRECTOR_DETAILS="select e.First_Name,e.Mobile_Number,e.bioid,e.Official_Email_ID from hrms_employee e,hrms_director d where e.EMPID=d.EMPID and d.Username=? and e.Official_Email_ID=?";
    public static final String UPDATE_DIRECTOR_PASSWORD="update hrms_director set U_password=? where Username=?";
}
