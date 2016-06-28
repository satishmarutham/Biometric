/**
 * 
 */
package com.centris.util.SQLUtils;

/**
 * @author sathish
 * 
 */
public class ChangePassword {
	public static final String GET_CURRENT_MANAGER_PASSWORD = "select password from hrms_manager where Username=?";
	public static final String UPDATE_CURRENT_MANAGER_PASSWORD = "update hrms_manager set password=? where Username=? and password=? and email=?";
	public static final String GET_CURRENT_ADMIN_PASSWORD = "select password from hrms_user where username=?";

	public static final String UPDATE_CURRENT_ADMIN_PASSWORD = "update hrms_user set password=? where username=? and password=?";
	public static final String MANAGER_MAIL_CHECK = "select  count(*)  from hrms_manager where Username=?  and email=?";
	public static final String UPDATE_CURRENT_EMPLOYEE_PASSWORD = "update hrms_online_users set password=? where password=? and Username=?";

	public static final String GET_CURRENT_EMPLOYEE_PASSWORD = "select count(*) from hrms_online_users where(Username<>'' and Username=?) and (password<>'' and password=?)";
	public static final String GET_EMPLOYEE_DOB = "select count(*) from hrms_employee where(DOB<>''and DOB=?) and (EMPID<>'' and EMPID=?)";
	public static final String GET_EMAIL_ID_BY_USERNAME = "select email from hrms_manager where Username=?";

	public static final String UPDATE_DIRECTOR_PASSWORD = "update hrms_director set U_password=?, MidifiedBy = ?, ModifiedDate=?  where Username=? and U_password=?";
	public static final String GET_CURRENT_DIRECTOR_PASSWORD = "select U_password from hrms_director where Username=?";

}
