/**
 * 
 */
package com.centris.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.centris.DAO.ClientMasterDao;
import com.centris.DAO.DAOIMPL.ClientMasterDaoImpl;
import com.centris.DAO.DAOIMPL.IDGenerator;
import com.centris.POJO.ClientMasterPojo;
import com.centris.form.ClientMasterForm;
import com.centris.service.ClientMasterService;
import com.centris.util.HelperClass;

/**
 * @author satish
 *
 */
public class ClientMasterServiceImpl implements ClientMasterService{

	@Override
	public String insertClientDetails(ClientMasterForm clientMasterForm) {
		ClientMasterDao clientMasterDao=new ClientMasterDaoImpl();
		ClientMasterPojo clientMasterPojo=new ClientMasterPojo();
		try{
			
	IDGenerator idGenerator=new IDGenerator();
	String clientCode=idGenerator.getPrimaryKeyID("hrms_client");
		
		clientMasterPojo.setClientCode(clientCode);
		clientMasterPojo.setClientName(clientMasterForm.getClientName());
		clientMasterPojo.setAddress(clientMasterForm.getAddress());
		clientMasterPojo.setCountry(clientMasterForm.getCountry());
		clientMasterPojo.setState(clientMasterForm.getState());
		clientMasterPojo.setPhoneNo(clientMasterForm.getPhoneNo());
		clientMasterPojo.setCreatedBy(clientMasterForm.getCreatedBy());
		clientMasterPojo.setCreateDate(HelperClass.getCurrentTimestamp());
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		// TODO Auto-generated method stub
		return clientMasterDao.insertClientDetails(clientMasterPojo);
	}

	@Override
	public boolean checkClientName(String clientName) {
		ClientMasterDao clientMasterDao=new ClientMasterDaoImpl();
		return clientMasterDao.checkClientName(clientName);
	}

	@Override
	public String updateClientDetails(ClientMasterForm clientMasterForm) {
		
		
		ClientMasterDao clientMasterDao=new ClientMasterDaoImpl();
		ClientMasterPojo clientMasterPojo=new ClientMasterPojo();
		try{
		clientMasterPojo.setClientCode(clientMasterForm.getClientCode());
		clientMasterPojo.setClientName(clientMasterForm.getClientName());
		clientMasterPojo.setAddress(clientMasterForm.getAddress());
		clientMasterPojo.setCountry(clientMasterForm.getCountry());
		clientMasterPojo.setState(clientMasterForm.getState());
		clientMasterPojo.setPhoneNo(clientMasterForm.getPhoneNo());
		clientMasterPojo.setCreateDate(HelperClass.getCurrentTimestamp());
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		return clientMasterDao.updateClientDetails(clientMasterPojo);
		// TODO Auto-generated method stub

}

	@Override
	public String deleteClientDetails(String[] clientCodeArray) {
		ClientMasterDao clientMasterDao=new ClientMasterDaoImpl();
		// TODO Auto-generated method stub
		return clientMasterDao.deleteClientDetails(clientCodeArray);
	}

	@Override
	public List<ClientMasterPojo> editClientDetails(String clientCode) {
		ClientMasterDao clientMasterDao=new ClientMasterDaoImpl();
		
		return clientMasterDao.editClientDetails(clientCode);
	}

	@Override
	public ArrayList<ClientMasterPojo> getClientDetails() {
		ClientMasterDao clientMasterDao=new ClientMasterDaoImpl();
		return clientMasterDao.getClientDetails();
	}

	@Override
	public boolean checkUpdateClientName(String clientName,String clientCode) {
		ClientMasterDao clientMasterDao=new ClientMasterDaoImpl();
		return clientMasterDao.checkUpdateClientName(clientName,clientCode);
	}


}
