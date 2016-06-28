package com.centris.delegate;

import java.util.List;

import com.centris.POJO.RoleMasterPojo;
import com.centris.VO.RoleMasterVo;
import com.centris.form.RoleMasterForm;
import com.centris.service.RoleMasterService;
import com.centris.service.serviceImpl.RoleMasterServiceImpl;

public class RoleMasterBD {
public String addRole(RoleMasterForm masterForm,String usercode) throws Exception{
	return new RoleMasterServiceImpl().addRole(masterForm,usercode);
}

public String updateRole(RoleMasterForm masterForm,String usercode) throws Exception{
	return new RoleMasterServiceImpl().updateRole(masterForm,usercode);
}
public List<RoleMasterPojo> getRoles() throws Exception{
	return new RoleMasterServiceImpl().getRoles();
}

public String deleteRole(RoleMasterPojo roleMasterPojo) throws Exception{
	return new RoleMasterServiceImpl().deleteRole(roleMasterPojo);
}
public List<RoleMasterPojo> updateRole(String roleCodeId) throws Exception{
	return new RoleMasterServiceImpl().updateRoles(roleCodeId);
}

public boolean validateRoleName(String roleNameValidate) throws Exception
{
	return new  RoleMasterServiceImpl().validateRoleName(roleNameValidate);
}

public boolean validateRoleNameUpdate(String roleNameValidate,String roleid) throws Exception
{
	return new  RoleMasterServiceImpl().validateRoleNameUpdate(roleNameValidate,roleid);
}

public List<RoleMasterVo> getAllNRoles() {
	
	RoleMasterService roleMasterService = new RoleMasterServiceImpl();
	
	return roleMasterService.getAllNRoles();
}

}
