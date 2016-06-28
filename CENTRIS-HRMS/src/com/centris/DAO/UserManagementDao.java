package com.centris.DAO;

import java.util.ArrayList;

import com.centris.VO.UsermanagementEmployeeVo;
import com.centris.form.UserManagementForm;

public interface UserManagementDao {
	
	public ArrayList<UsermanagementEmployeeVo> getEmpIdNameBySerachTerm(String startwith, String designation);
	public ArrayList<String> getUserMangementRoles(String empId);
	public String saveEmployeeRole(UserManagementForm form, String currentuser);

}
