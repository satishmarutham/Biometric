package com.centris.util.SQLUtils;

public class AdminForgotPassword {
	public static final String ADMIN_FORGET_PASSWORD = "select count(*) from hrms_user where username=? and email_id=?";
	public static final String GET_ADMIN_DETAILS = "select e.First_Name,e.Mobile_Number,e.bioid,e.Official_Email_ID from hrms_employee e ,hrms_user u where e.EMPID= u.empId and u.username=? and u.email_id=?";
    public static final String UPDATE_ADMIN_PASSWORD="update hrms_user set password=? where username=? and email_id=?";
}
