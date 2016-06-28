/**
 * 
 */
package com.centris.service;

import java.util.List;

import com.centris.POJO.ManagerLeaveConfirmationPojo;

/**
 * @author sathish
 *
 */
public interface ManagerLeaveConfirmationService {
	public String confirm(ManagerLeaveConfirmationPojo confirmationPojo);
	public String reject(ManagerLeaveConfirmationPojo confirmationPojo);
	public String hold(ManagerLeaveConfirmationPojo confirmationPojo);
	public List<ManagerLeaveConfirmationPojo> getLeaveDetailsBySno(int sno);
	
	
}
