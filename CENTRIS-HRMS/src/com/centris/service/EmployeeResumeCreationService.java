/**
 * 
 */
package com.centris.service;

import com.centris.POJO.EmployeeResumeCreationPojo;


/**
 * @author satish
 *
 */
public interface EmployeeResumeCreationService {
	public String deletePursuit(String employeeId,String deletePursuitSno) throws Exception;
		
	public String deleteHobbies(String employeeId,String deleteHobbiesSno)throws Exception;
	
	public String deleteTechnicalSkills(String employeeId,String deleteTechnicalSkillsSno)throws Exception;
	public String deleteExperience(String employeeId,String deleteHobbiesSno) throws Exception;
	public String deleteResponsibilities(String employeeId,String deleteResponsibilitiesSno)throws Exception;
	public String createResumeEmployee(EmployeeResumeCreationPojo creationPojo)throws Exception;
}
