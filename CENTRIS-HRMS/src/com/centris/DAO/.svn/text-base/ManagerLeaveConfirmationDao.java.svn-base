/**
 * 
 */
package com.centris.DAO;

import java.util.List;

import com.centris.POJO.ManagerLeaveConfirmationPojo;

/**
 * @author sathish
 *
 */
public interface ManagerLeaveConfirmationDao {
	public List<ManagerLeaveConfirmationPojo> getLeavestoApproved(String managerCode,String employeeCode);
	public String confirm(ManagerLeaveConfirmationPojo confirmationPojo);
	public String reject(ManagerLeaveConfirmationPojo confirmationPojo);
	public String hold(ManagerLeaveConfirmationPojo confirmationPojo);
	public List<ManagerLeaveConfirmationPojo> getLeaveDetailsBySno(int sno);

}
