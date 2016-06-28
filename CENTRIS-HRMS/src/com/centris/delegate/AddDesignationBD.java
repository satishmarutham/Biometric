package com.centris.delegate;


import java.util.ArrayList;
import com.centris.VO.AddDesignationVO;
import com.centris.form.AddDesignation;
import com.centris.service.serviceImpl.AddDesignationServiceImpl;


/**
 * @author seshuma
 *
 */

public class AddDesignationBD {
	
	
public String insertDesignationDetails(AddDesignation aform,String currentuser){
		
		return new AddDesignationServiceImpl().insertDesignationDetails(aform,currentuser);
	
}

public String updateDesignationDetails(AddDesignation aform,String currentuser){
	
	return new AddDesignationServiceImpl().updateDesignationDetails(aform,currentuser);

}
	
public ArrayList<AddDesignationVO> getDesignationDetails(){
		
		return new AddDesignationServiceImpl().getDesignationDetails();
	
	}
	
public boolean validateDesName(String desname,String desid){
		
		return new AddDesignationServiceImpl().validateDesName(desname,desid);
	}

public boolean validateDesNameUpdate(String desname,String desid){
	
	return new AddDesignationServiceImpl().validateDesNameUpdate(desname,desid);
}



public ArrayList<AddDesignationVO> getEditDesignationDetails(String desid){
	
	return new AddDesignationServiceImpl().getEditDesignationDetails(desid);
}

public String deleteDesignationDetails(String[] desid){
	
	return new AddDesignationServiceImpl().deleteDesignationDetails(desid);
}



}
