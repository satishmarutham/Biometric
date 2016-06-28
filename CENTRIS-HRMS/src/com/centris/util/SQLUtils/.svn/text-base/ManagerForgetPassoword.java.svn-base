/**
 * 
 */
package com.centris.util.SQLUtils;

/**
 * @author sathish
 * 
 */
public class ManagerForgetPassoword {
	public static final String MANAGER_FORGET_PASSWORD = "select count(*) from hrms_manager where Username=? and email=?";
	public static final String GET_MANAGER_DETAILS = "select e.First_Name,e.Mobile_Number,e.bioid,e.Official_Email_ID from hrms_employee e ,hrms_manager u where e.EMPID= u.empId and u.Username=? and u.email=?";
    public static final String UPDATE_MANAGER_PASSWORD="update hrms_manager set password=? where Username=? and email=?";
}
