package com.centris.util.SQLUtils;

public class LoginDetails {

	public static final String ADMIN_LOGINCHECK = "SELECT userCode,UserName, PassWord as Password  from hrms_user  WHERE  UserName= ? AND password= ?";
	public static final String MANAGER_LOGINCHECK = "SELECT ManagerCode as userCode,UserName,password as Password from hrms_manager where Username=? and password=? and isActive='Y'";
	public static final String EMPLOYEE_LOGINCHECK = "select em.EMPID as userCode,emo.Username as UserName,emo.password as Password from hrms_employee em join hrms_online_users emo on em.EMPID=emo.EMPID where emo.Username=? and emo.password=? and em.isActive='Y'";
	public static final String ADMIN_DETAILSCHECK = "SELECT u.userCode,u.UserName, u.PassWord ,u.roleCode,r.RoleName roleName,u.Location from hrms_user u,hrmsi_role r WHERE u.RoleCode=r.RoleCode and UserName=? AND password=? and u.isActive='Y'";
	public static final String GET_ADMIN_DETAILS = "select e.First_Name,au.userCode,au.username,au.Location LocationCode,au.Location LocationName,au.roleCode,ar.RoleName,au.UserType,au.empId,e.Employee_image from hrms_user au,hrmsi_role ar left outer join hrms_role_permissions_mapping rpm on ar.RoleCode=rpm.roleCode left outer join hrms_permissions bp on rpm.permissionCode=bp.PermissionCode,hrms_employee e where e.EMPID=au.empId and  au.roleCode=ar.RoleCode and au.username=? and au.password=? group by au.userCode,au.username,au.Location,au.Location,au.roleCode,ar.RoleName";
	public static final String GET_EMPLOYEE_DETAILS = "select em.EMPID as userCode,em.Employee_image,emo.Username as UserName,em.First_Name as EmployeeName from hrms_employee em join hrms_online_users emo on em.EMPID=emo.EMPID where emo.Username=? and emo.password=? and em.isActive='Y'";
	public static final String GET_MANAGER_DETAILS = "SELECT ManagerCode as userCode,FirstName as ManagerName,UserName from hrms_manager where Username=? and password=? and isActive='Y'";

	public static final String DIRECTOR_LOGINCHECK = "SELECT DirectorCode as userCode,Username as UserName, U_password as Password  from hrms_director  WHERE  Username= ? AND U_password= ? and isActive='Y'";
	/*
	 * public static final String GET_DIRECTOR_DETAILS =
	 * "SELECT hd.DirectorCode as userCode,hd.Username as DirectorName,he.First_Name as UserName from hrms_director hd,hrms_employee he where hd.Username=? and hd.U_password=? and hd.isActive='Y' and he.Official_Email_ID=hd.Username"
	 * ;
	 */
	public static final String GET_DIRECTOR_DETAILS = "select hd.DirectorCode as userCode,hd.Username as UserName,hd.roleCode,ar.RoleName,he.First_Name as DirectorName, group_concat(rpm.permissionCode order by rpm.permissionCode) userPermissionCode,group_concat(rpm.shortName order by rpm.permissionCode) userPermissionShortName,group_concat(bp.permission order by rpm.permissionCode) userPermissionName,group_concat(rpm.isApplicable order by rpm.permissionCode) isapplicablestatus  from hrms_director hd,hrmsi_role ar,hrms_role_permissions_mapping rpm ,hrms_permissions bp,hrms_employee he where  hd.roleCode=ar.RoleCode and ar.RoleCode=rpm.RoleCode  and rpm.permissionCode=bp.PermissionCode and he.Official_Email_ID=hd.Username and he.EMPID=hd.EMPID  and hd.Username=? and hd.U_password=? group by hd.DirectorCode,hd.Username,hd.roleCode,ar.RoleName";

	public static final String ADMIN_ID_TYPE = "USR";
	public static final String DIRECTOR_ID_TYPE = "DIR";
	public static final String MANAGER_ID_TYPE = "MAN";
	public static final String EMPLOYEE_ID_TYPE = "EMP";
	
	public static final String GET_EMPLOYEE_PREVILLEGES = "select case when (select count(*) from hrms_director where EMPID=e.EMPID and isActive='Y')>0 then 'D' else '' end director,case when (select count(*) from hrms_manager where EMPID=e.EMPID and isActive='Y')>0 then 'M' else '' end manager,case when (select count(*) from hrms_user where empId=e.EMPID and isActive='Y')>0 then 'A' else '' end admin from hrms_employee e join hrms_designation d on e.DesignationCode=d.DesignationCode  and e.EMPID=?";

	public static final String GET_MANAGER_PREVILLEGES ="select case when (select count(*) from hrms_director where EMPID=e.EMPID and isActive='Y')>0 then 'D' else '' end director,case when (select count(*) from hrms_manager where EMPID=e.EMPID and isActive='Y')>0 then 'M' else '' end manager,case when (select count(*) from hrms_user where empId=e.EMPID and isActive='Y')>0 then 'A' else '' end admin from hrms_employee e join hrms_designation d on e.DesignationCode=d.DesignationCode  and e.EMPID in (select EMPID from hrms_manager where ManagerCode=?)";
	
	public static final String GET_DIRECTOR_PREVILLEGES ="select case when (select count(*) from hrms_director where EMPID=e.EMPID and isActive='Y')>0 then 'D' else '' end director,case when (select count(*) from hrms_manager where EMPID=e.EMPID and isActive='Y')>0 then 'M' else '' end manager,case when (select count(*) from hrms_user where empId=e.EMPID and isActive='Y')>0 then 'A' else '' end admin from hrms_employee e join hrms_designation d on e.DesignationCode=d.DesignationCode  and e.EMPID in (select EMPID from hrms_director where DirectorCode=?)";
	
	public static final String GET_ADMIN_PREVILLEGES ="select case when (select count(*) from hrms_director where EMPID=e.EMPID and isActive='Y')>0 then 'D' else '' end director,case when (select count(*) from hrms_manager where EMPID=e.EMPID and isActive='Y')>0 then 'M' else '' end manager,case when (select count(*) from hrms_user where empId=e.EMPID and isActive='Y')>0 then 'A' else '' end admin from hrms_employee e join hrms_designation d on e.DesignationCode=d.DesignationCode  and e.EMPID in (select empId from hrms_user where userCode=?)";

//GET PERMISSIONS DETAILS
	
	public static final String GET_PERMISSIONS="select PermissionCode,permission,shortName,isApplicable from hrms_role_permissions_mapping where RoleCode=?";
	
}