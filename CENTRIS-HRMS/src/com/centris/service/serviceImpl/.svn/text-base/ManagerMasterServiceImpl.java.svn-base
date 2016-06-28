package com.centris.service.serviceImpl;

import java.util.ArrayList;

import com.centris.DAO.DAOIMPL.ManagerMasterDaoImpl;
import com.centris.POJO.ManagerMasterPojo;
import com.centris.VO.ManagerMasterVO;
import com.centris.form.ManagerMasterForm;
import com.centris.service.ManagerMasterService;

public class ManagerMasterServiceImpl implements ManagerMasterService{

	public String addmanagerService(ManagerMasterForm managerform) {

   ManagerMasterPojo managerpPojo=new ManagerMasterPojo();
	
    managerpPojo.setFirstname(managerform.getFirstname());
    managerpPojo.setLastname(managerform.getLastname());
    managerpPojo.setMobileno(managerform.getMobileno());
    managerpPojo.setUsername(managerform.getUsername());
    managerpPojo.setManageremail(managerform.getManageremail());
    managerpPojo.setDepartment(managerform.getDepartment());
    
    managerpPojo.setManagerid(managerform.getManagerid());
    managerpPojo.setCreatedby(managerform.getCreatedby());
	
    return new ManagerMasterDaoImpl().addManagerDao(managerpPojo);
	
	}

	public ArrayList<ManagerMasterVO> getAllManagersService() {
		
		return new ManagerMasterDaoImpl().getmanagerDetailsDao();
	}

	public boolean checkManagerCountService(String username) {
		
		return new ManagerMasterDaoImpl().checkManagerCountDao(username);
	}

	public boolean checkManagerEmailCountService(String emailid) {
	
		return  new ManagerMasterDaoImpl().checkManagerEmailCountDao(emailid);
	}

	public ArrayList<ManagerMasterVO> editManagerDetailsService(String managerid) {
		
		return new ManagerMasterDaoImpl().editManagerDetailsDao(managerid);
	}

	public boolean checkManagerCountUpdateService(String managerid,	String username) {
		
		return new ManagerMasterDaoImpl().checkMangerCountUpdateDao(username,managerid);
	}

	public boolean checkUpdateEmailCountService(String emailid, String managerid) {
		
		return new ManagerMasterDaoImpl().checkManagerEmailUpdateCountDao(emailid,managerid);
	}

	public String updateManagerService(ManagerMasterForm managerform) {
		
		ManagerMasterPojo managerpPojo=new ManagerMasterPojo();
			
		    managerpPojo.setFirstname(managerform.getFirstname());
		    managerpPojo.setLastname(managerform.getLastname());
		    managerpPojo.setMobileno(managerform.getMobileno());
		    managerpPojo.setUsername(managerform.getUsername());
		    managerpPojo.setManageremail(managerform.getManageremail());
		    managerpPojo.setDepartment(managerform.getDepartment());
		    managerpPojo.setManagerid(managerform.getManagerid());
		    managerpPojo.setCreatedby(managerform.getCreatedby());
		    
		return new ManagerMasterDaoImpl().UpdateManagerDao(managerpPojo);
	}

	public String deleteManagerService(String[] managerID) {
		
		return new ManagerMasterDaoImpl().deleteManagerDao(managerID);
	}

	
	
}
