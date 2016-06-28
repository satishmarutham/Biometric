package com.centris.service.serviceImpl;

import java.util.List;

import com.centris.DAO.DAOIMPL.UserRolePermissionDAOImpl;
import com.centris.VO.PermissionVO;
import com.centris.VO.UserRolePermissionVO;
import com.centris.form.UserRolePermissionForm;
import com.centris.service.UserRolePermissionService;

public class UserRolePermissionServiceImpl implements UserRolePermissionService {
	public UserRolePermissionVO getUserRolePermission(){
		return new UserRolePermissionDAOImpl().getUserRolePermission();
	}
	public UserRolePermissionVO insertRolePermission(UserRolePermissionForm userRolePermission){
		return new UserRolePermissionDAOImpl().insertRolePermission(userRolePermission);
	}
	public List<PermissionVO>  getPermissionByRole(String roleCode){
		return new UserRolePermissionDAOImpl().getPermissionByRole(roleCode);
	}
	public PermissionVO  removePermission(String roleCode,String roleName){
		return new UserRolePermissionDAOImpl().removePermission(roleCode,roleName);
	}
}
