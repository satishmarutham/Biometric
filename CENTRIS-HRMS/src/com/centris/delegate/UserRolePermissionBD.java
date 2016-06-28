package com.centris.delegate;

import java.util.List;

import com.centris.VO.PermissionVO;
import com.centris.VO.UserRolePermissionVO;
import com.centris.form.UserRolePermissionForm;
import com.centris.service.serviceImpl.UserRolePermissionServiceImpl;

public class UserRolePermissionBD {

	public UserRolePermissionVO getUserRolePermission(){
		return new UserRolePermissionServiceImpl().getUserRolePermission();
	}
	public UserRolePermissionVO insertRolePermission(UserRolePermissionForm userRolePermission){
		return new UserRolePermissionServiceImpl().insertRolePermission(userRolePermission);
	}
	public List<PermissionVO>  getPermissionByRole(String roleCode){
		return new UserRolePermissionServiceImpl().getPermissionByRole(roleCode);
	}
	public PermissionVO  removePermission(String roleCode,String roleName){
		return new UserRolePermissionServiceImpl().removePermission(roleCode,roleName);
	}
	
}
