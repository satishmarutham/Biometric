package com.centris.DAO;

import java.util.List;

import com.centris.POJO.RoleMasterPojo;
import com.centris.VO.RoleMasterVo;

public interface RoleMasterDao {
	public  String addRole(RoleMasterPojo roleMasterPojo) throws Exception;
	public List<RoleMasterPojo> getRoles() throws Exception;

	public String deleteRole(RoleMasterPojo roleMasterPojo) throws Exception;
	public List<RoleMasterPojo> updateRoles(String roleCodeId) throws Exception;
	public boolean validateRoleName(String roleNameValidate) throws Exception;
	public List<RoleMasterVo> getAllNRolesDao();
	
	
	
}
