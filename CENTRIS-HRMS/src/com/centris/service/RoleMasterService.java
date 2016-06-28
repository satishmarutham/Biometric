package com.centris.service;

import java.util.List;

import com.centris.POJO.RoleMasterPojo;
import com.centris.VO.RoleMasterVo;
import com.centris.form.RoleMasterForm;


public interface RoleMasterService {
	public  String addRole(RoleMasterForm roleMasterForm,String usercode) throws Exception;
	public List<RoleMasterPojo> getRoles() throws Exception;

	public String deleteRole(RoleMasterPojo roleMasterPojo) throws Exception;
	public List<RoleMasterPojo> updateRoles(String roleCodeId) throws Exception;
	public boolean validateRoleName(String roleNameValidate) throws Exception;
	public List<RoleMasterVo> getAllNRoles();
	
}
