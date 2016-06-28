package com.centris.service.serviceImpl;

import java.util.List;

import com.centris.DAO.RoleMasterDao;
import com.centris.DAO.DAOIMPL.IDGenerator;
import com.centris.DAO.DAOIMPL.RoleMasterDaoImpl;
import com.centris.POJO.RoleMasterPojo;
import com.centris.VO.RoleMasterVo;
import com.centris.form.RoleMasterForm;
import com.centris.service.RoleMasterService;

public class RoleMasterServiceImpl implements RoleMasterService{

	@Override
	public  String addRole(RoleMasterForm roleMasterForm,String usercode) throws Exception {
		RoleMasterPojo roleMasterPojo=new RoleMasterPojo();
		IDGenerator idGenerator=new IDGenerator();
		
		
		roleMasterPojo.setRoleCode(idGenerator.getPrimaryKeyID("hrmsi_role"));
		System.out.println("role code -- "+roleMasterPojo.getRoleCode());
		roleMasterPojo.setRoleName(roleMasterForm.getRoleName());
		roleMasterPojo.setRoleDescription(roleMasterForm.getRoleDescription());

		roleMasterPojo.setSuccessMessage(roleMasterForm.getSuccessMessage());
		roleMasterPojo.setCreatedBy(usercode);
		// TODO Auto-generated method stub
		return new RoleMasterDaoImpl().addRole(roleMasterPojo);
	}
	
	public  String updateRole(RoleMasterForm roleMasterForm,String usercode) throws Exception {
		RoleMasterPojo roleMasterPojo=new RoleMasterPojo();
		
		roleMasterPojo.setRoleCode(roleMasterForm.getRoleCode());
		roleMasterPojo.setRoleName(roleMasterForm.getRoleName());
		roleMasterPojo.setRoleDescription(roleMasterForm.getRoleDescription());

		roleMasterPojo.setSuccessMessage(roleMasterForm.getSuccessMessage());
		roleMasterPojo.setModifiedBy(usercode);
		// TODO Auto-generated method stub
		return new RoleMasterDaoImpl().updateRole(roleMasterPojo);
	}

	@Override
	public List<RoleMasterPojo> getRoles()
			throws Exception {
		// TODO Auto-generated method stub
		return new RoleMasterDaoImpl().getRoles();
	}

	public String deleteRole(RoleMasterPojo roleMasterPojo) throws Exception {
		// TODO Auto-generated method stub
		return new RoleMasterDaoImpl().deleteRole(roleMasterPojo);
	}

	@Override
	public List<RoleMasterPojo> updateRoles(String roleCodeId) throws Exception {
		// TODO Auto-generated method stub
		return new RoleMasterDaoImpl().updateRoles(roleCodeId);
	}

	@Override
	public boolean validateRoleName(String roleNameValidate) throws Exception {
		// TODO Auto-generated method stub
		return new RoleMasterDaoImpl().validateRoleName(roleNameValidate);
	}
	
	public boolean validateRoleNameUpdate(String roleNameValidate,String roleid) throws Exception {
		// TODO Auto-generated method stub
		return new RoleMasterDaoImpl().validateRoleNameUpdate(roleNameValidate,roleid);
	}

	@Override
	public List<RoleMasterVo> getAllNRoles() {
		RoleMasterDao roleMasterDao = new RoleMasterDaoImpl();
		
		return roleMasterDao.getAllNRolesDao();
	}

	

}
