package com.centris.service.serviceImpl;

import java.util.ArrayList;

import com.centris.DAO.UserManagementDao;
import com.centris.DAO.DAOIMPL.UserManagementDaoImpl;
import com.centris.VO.UsermanagementEmployeeVo;
import com.centris.form.UserManagementForm;
import com.centris.service.UserManagementService;

public class UserManagementServiceImpl implements UserManagementService{

	UserManagementDao userDao=new UserManagementDaoImpl();
	
	@Override
	public ArrayList<UsermanagementEmployeeVo> getEmpIdNameBySerachTerm(String startwith, String designation) {
		// TODO Auto-generated method stub
		return userDao.getEmpIdNameBySerachTerm(startwith, designation);
	}
	
	public ArrayList<String> getUserMangementRoles(String empId){
		
		return userDao.getUserMangementRoles(empId);
	}

	@Override
	public String saveEmployeeRole(UserManagementForm form, String currentuser) {
		// TODO Auto-generated method stub
		return userDao.saveEmployeeRole(form,currentuser);
	}

}
