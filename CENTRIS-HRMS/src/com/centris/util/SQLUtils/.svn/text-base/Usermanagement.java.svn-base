package com.centris.util.SQLUtils;

public class Usermanagement {
	
	public static final String GETEMPLOYEE_DETAILS="select e.EMPID,e.First_Name,e.bioid,d.designationName from hrms_employee e,hrms_designation d where e.DesignationCode=d.DesignationCode and e.isActive='Y' and First_Name like ? and e.DesignationCode like ?";
	public static final String GET_OFFICIAL_MAILID="select Official_Email_ID from hrms_employee where EMPID=?";
	public static final String CHECK_DIRECTOR="select Username from hrms_director where Username=? and isActive='Y'";
	public static final String CHECK_MANAGER="select ManagerCode from hrms_manager where Username=? and isActive='Y'";
	public static final String CHECK_USER="select UserOption from hrms_user_options where EmployeeId=?";
	
	public static final String GET_EMPLOYEE_DETAILS="select EMPID,First_Name,DOB,Mobile_Number,Official_Email_ID,bioid from  hrms_employee where EMPID=?";
	public static final String INSERT_MANAGER_DETAILS="insert into hrms_manager(ManagerCode,FirstName,phoneno,password,Username,email,createdby,createtime,isActive,EMPID) values(?,?,?,?,?,?,?,?,?,?)";
	public static final String INSERT_DIRECTOR_DETAILS="insert into hrms_director(Username,U_password,EMPID,isActive,CreatedBy,CreateDate,DirectorCode,roleCode) values(?,?,?,?,?,?,?,?)";
	public static final String INSERT_USER_DETAILS="insert into hrms_user(userCode,username,password,createuser,createdate,roleCode,mob_no,email_id,empId) values(?,?,?,?,?,?,?,?,?)";
	
	
	public static final String CHECK_MANAGER_COUNT="select count(*) from hrms_manager where Username=?";
	public static final String CHECK_DIRECTORCOUNT_COUNT="select count(*) from hrms_director where Username=?";
	public static final String CHECK_USER_COUNT="select count(*) from hrms_user where username=?";
	
	public static final String UPDATE_MANAGER="update hrms_manager set isActive=?,password=? where Username=?";
	public static final String UPDATE_DIRECTOR="update hrms_director set isActive=?,U_password=? where Username=?";
	public static final String UPDATE_USER="update hrms_user set isActive=?,roleCode=?,password=? where username=?";
	public static final String UPDATE_USER_NOROLE="update hrms_user set isActive=?,password=? where username=?";
	public static final String INACTIVE_USER="update hrms_user set isActive=?,password=? where username=?";
	
	public static final String INSERT_USEROPTIONS="insert into hrms_user_options(EmployeeId,UserOption,CreatedBy) values(?,?,?)";
	public static final String DELETR_USEROPTIONS="delete from hrms_user_options where EmployeeId=?";
	
}
