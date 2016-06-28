package com.centris.delegate;

import java.util.ArrayList;

import com.centris.VO.ManagerMasterVO;
import com.centris.form.ManagerMasterForm;
import com.centris.service.serviceImpl.ManagerMasterServiceImpl;

public class ManagerMasterBD {

	public String addManagerBD(ManagerMasterForm managerform) {

		return new ManagerMasterServiceImpl().addmanagerService(managerform);
	}

	public ArrayList<ManagerMasterVO> getAllManagersBD() {

		return new ManagerMasterServiceImpl().getAllManagersService();
	}

	public boolean checkManagerCountBD(String username) {

		return new ManagerMasterServiceImpl()
				.checkManagerCountService(username);
	}

	public boolean checkManagerEmailCountBD(String emailid) {

		return new ManagerMasterServiceImpl()
				.checkManagerEmailCountService(emailid);
	}

	public ArrayList<ManagerMasterVO> editManagerDetailsBD(String managerid) {

		return new ManagerMasterServiceImpl()
				.editManagerDetailsService(managerid);
	}

	public boolean checkManagerCountUpdateBD(String username, String managerid) {

		return new ManagerMasterServiceImpl().checkManagerCountUpdateService(
				managerid, username);
	}

	public boolean checkUpdateEmailCountBD(String emailid, String managerid) {

		return new ManagerMasterServiceImpl().checkUpdateEmailCountService(
				emailid, managerid);
	}

	public String updateManagerBD(ManagerMasterForm managerform) {

		return new ManagerMasterServiceImpl().updateManagerService(managerform);
	}

	public String deleteManagerBD(String[] managerID) {

		return new ManagerMasterServiceImpl().deleteManagerService(managerID);
	}

}
