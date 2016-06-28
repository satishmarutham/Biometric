package com.centris.util.SQLUtils;

public class UserRolePermission {
	
	
	public static final String GET_ROLES="select RoleCode,RoleName,Description from hrmsi_role";
	public static final String UPDATE_ROLES="select * from hrmsi_role where RoleCode=?";
	public static final String ADD_ROLE = "insert into hrmsi_role(RoleCode,RoleName,Description,createdby,createtime,modifiedtime,modifiedby) values(?,?,?,?,?,?,?)";
	public static final String UPDATE_ROLE="update hrmsi_role set RoleName=?,Description=?,modifiedby=?,modifiedtime=? where RoleCode=?";
	public static final String VALIDATE_ROLE_NAME="select count(*) RoleName from hrmsi_role where RoleName=?";
	 public static final String GET_PERMISSION="select PermissionCode,permission,shortName from hrms_permissions";
	 public static final String GET_PERMISSION_BY_ROLE="select permissionCode,isApplicable from hrms_role_permissions_mapping where roleCode=?";
	 public static final String VALIDATE_ROLE_NAME_UPDATE="select count(*) RoleName from hrmsi_role where RoleName=? and RoleCode!=? ";
	 public static final String INSERT_ROLE_PERMISSION_MAPPING="insert into hrms_role_permissions_mapping(permissionCode,roleCode,shortName,isApplicable,permission,createdby,createtime) values(?,?,?,?,?,?,?)"; 
	 public static final String DELETE_ROLE_PERMISSION_MAPPING="delete from hrms_role_permissions_mapping where roleCode like ?";
	 public static final String CHECK_ROLE_USER_MAPPING="select count(*) from hrms_user where roleCode=?";
	 public static final String DELETE_ROLE="delete from hrmsi_role where RoleCode=? and isDefault='N'";
	public static final String VALIDATE_ROLE_CODE="select count(*) RoleCode from hrmsi_role where RoleCode=?";
	public static final String CHECK_ROLE_PERMISSION_MAPPING="select count(*) from hrms_role_permissions_mapping where roleCode=?";
	
		
		public static final String GET_N_ROLES = "select RoleCode,RoleName  from hrmsi_role where isDefault='N'";
	

}
