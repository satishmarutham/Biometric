/**
 * 
 */
package com.centris.delegate;

import java.util.ArrayList;
import java.util.List;

import com.centris.POJO.ClientMasterPojo;
import com.centris.form.ClientMasterForm;
import com.centris.service.ClientMasterService;
import com.centris.service.serviceImpl.ClientMasterServiceImpl;

/**
 * @author satish
 *
 */
public class ClientMasterBD {
public String insertClientDetails(ClientMasterForm  clientMasterForm){
	ClientMasterService clientMasterService=new ClientMasterServiceImpl();
	return clientMasterService.insertClientDetails(clientMasterForm);
}

public boolean checkClientName(String name){
	ClientMasterService clientMasterService=new ClientMasterServiceImpl();
	
	return clientMasterService.checkClientName(name);
}

public String updateClientDetails(ClientMasterForm  clientMasterForm){
	ClientMasterService clientMasterService=new ClientMasterServiceImpl();
	return clientMasterService.updateClientDetails(clientMasterForm);
}

public List<ClientMasterPojo> editClientDetails(String clientCode){
	ClientMasterService clientMasterService=new ClientMasterServiceImpl();
	return clientMasterService.editClientDetails(clientCode);
}
public ArrayList<ClientMasterPojo> getClientDetails(){
	ClientMasterService clientMasterService=new ClientMasterServiceImpl();
	return clientMasterService.getClientDetails();
}

public String deleteClientDetails(String clientCodeArray[]){
	ClientMasterService clientMasterService=new ClientMasterServiceImpl();
	return clientMasterService.deleteClientDetails(clientCodeArray);
}
public boolean checkUpdateClientName(String name,String clientCode){
	ClientMasterService clientMasterService=new ClientMasterServiceImpl();
	
	return clientMasterService.checkUpdateClientName(name,clientCode);
}


}
