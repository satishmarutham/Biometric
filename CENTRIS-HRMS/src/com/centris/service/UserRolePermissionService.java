package com.centris.service;

import java.util.List;

import com.centris.VO.PermissionVO;
import com.centris.VO.UserRolePermissionVO;
import com.centris.form.UserRolePermissionForm;

public interface UserRolePermissionService {
	public UserRolePermissionVO getUserRolePermission();
	public UserRolePermissionVO insertRolePermission(UserRolePermissionForm userRolePermission);
	public List<PermissionVO>  getPermissionByRole(String roleCode);
	public PermissionVO  removePermission(String roleCode,String roleName);
}
