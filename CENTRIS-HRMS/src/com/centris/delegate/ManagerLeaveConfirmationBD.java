/**
 * 
 */
package com.centris.delegate;

import java.util.List;

import com.centris.POJO.ManagerLeaveConfirmationPojo;
import com.centris.service.serviceImpl.ManagerLeaveConfirmationServiceImpl;

/**
 * @author sathish
 *
 */
public class ManagerLeaveConfirmationBD {
public String confirm(ManagerLeaveConfirmationPojo confirmationPojo){
	return new ManagerLeaveConfirmationServiceImpl().confirm(confirmationPojo);
}
public String reject(ManagerLeaveConfirmationPojo confirmationPojo){
	return new ManagerLeaveConfirmationServiceImpl().reject(confirmationPojo);
}
public String hold(ManagerLeaveConfirmationPojo confirmationPojo){
	return new ManagerLeaveConfirmationServiceImpl().hold(confirmationPojo);
}
public List<ManagerLeaveConfirmationPojo> getLeaveDetailsBySno(int sno){
	return new ManagerLeaveConfirmationServiceImpl().getLeaveDetailsBySno(sno);
}



}
