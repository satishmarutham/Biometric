package com.centris.action;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.json.JSONObject;

import com.centris.DAO.DAOIMPL.EmployeeResumeCreationDaoImpl;
import com.centris.POJO.EmployeeResumeCreationPojo;
import com.centris.VO.AttendenceApprovelVo;
import com.centris.VO.UserDetailVO;
import com.centris.delegate.AttendenceApprovelBD;
import com.centris.delegate.EmployeeResumeCreationBD;
import com.centris.exception.AITrackerException;
import com.centris.util.StringUtils;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class EmployeeResumeCreationAction extends DispatchAction {
	private static Logger logger = Logger
			.getLogger(AdvanceSalaryRequestAction.class);

	public ActionForward createEmployeeResume(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
				.getAttribute("UserDetails");
		String employeeCode = userDetailVO.getUserCode();
		
		String carrierObjective = request.getParameter("carrierObjective");
		String pursuits = (String) request.getParameter("pursuits");

		String hobbies = (String) request.getParameter("hobbies");
		String responsibilities = (String) request
				.getParameter("responsibilities");
		String technicalSkills=(String) request.getParameter("technicalSkills");
	   String experience=(String)request.getParameter("experience");
	
	   String pursuitsSno=(String) request.getParameter("pursutSno");
	   
	   String responsibilitiesSno=(String) request.getParameter("responsibilitiesSno");
	   String technicalSkillsSno=(String) request.getParameter("technicalSkillsSno");
	   String experienceSno=(String) request.getParameter("experienceSno");
	   String hobbiesSno=(String) request.getParameter("hobbiesSno");
	   String carreObjectSno=request.getParameter("carrerObjectSno");
	  
	  EmployeeResumeCreationPojo creationPojo=new EmployeeResumeCreationPojo();
	   creationPojo.setCarrerObjective(carrierObjective);
	   creationPojo.setPursuits(pursuits);
	   creationPojo.setHobbies(hobbies);
	   creationPojo.setResponsibilities(responsibilities);
	   creationPojo.setTechnicalSkills(technicalSkills);
	   creationPojo.setExperience(experience);
	   creationPojo.setEmployeeId(employeeCode);
	   creationPojo.setPursuitSno(pursuitsSno);
	   creationPojo.setResponsibilitiesSno(responsibilitiesSno);
	   creationPojo.setTechnicalSkillsSno(technicalSkillsSno);
	   creationPojo.setExperienceSno(experienceSno);
	   creationPojo.setHobbiesSno(hobbiesSno);
	   creationPojo.setCreatedBy(employeeCode);
	   creationPojo.setCarrerObjectSno(carreObjectSno);
	  /* EmployeeResumeCreationDaoImpl creationDaoImpl=new EmployeeResumeCreationDaoImpl();*/
	   EmployeeResumeCreationBD creResumeCreationBD=new EmployeeResumeCreationBD();
	   String status=creResumeCreationBD.createResumeEmployee(creationPojo);
	 
JSONObject jsonObject=new JSONObject();
jsonObject.accumulate("status",status);


response.getWriter().println(jsonObject);

		return null;
	}
	public ActionForward deletePursuit(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
				.getAttribute("UserDetails");
		String employeeCode = userDetailVO.getUserCode();
		
		String deletePursuitSno = request.getParameter("deletePursuitSno");
	EmployeeResumeCreationBD creationBD=new EmployeeResumeCreationBD();
	String deletePursuit=creationBD.deletePursuit(employeeCode,deletePursuitSno);
	JSONObject jsonObject=new JSONObject();
	jsonObject.accumulate("status",deletePursuit);
	response.getWriter().println(jsonObject);

		return null;
	}
	
	
	public ActionForward deleteHobbies(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
				.getAttribute("UserDetails");
		String employeeCode = userDetailVO.getUserCode();
		
		String deleteHobbiesSno = request.getParameter("deleteHobbiesSno");
		
	
	EmployeeResumeCreationBD creationBD=new EmployeeResumeCreationBD();
	String deleteHobbies=creationBD.deleteHobbies(employeeCode,deleteHobbiesSno);
JSONObject jsonObject=new JSONObject();

	jsonObject.accumulate("status",deleteHobbies);	
response.getWriter().println(jsonObject);

		return null;
	}
	
	
	
	public ActionForward deleteTechnicalSkills(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
				.getAttribute("UserDetails");
		String employeeCode = userDetailVO.getUserCode();
		
		String deleteTechnicalSno = request.getParameter("deleteTechnicalSkillsSno");
		
	  
	EmployeeResumeCreationBD creationBD=new EmployeeResumeCreationBD();
	String deleteTechnicalSkills=creationBD.deleteTechnicalSkills(employeeCode,deleteTechnicalSno);
JSONObject jsonObject=new JSONObject();

	jsonObject.accumulate("status",deleteTechnicalSkills);	
response.getWriter().println(jsonObject);


	

		return null;
	}
	
	
	public ActionForward deleteExperienceSno(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
				.getAttribute("UserDetails");
		String employeeCode = userDetailVO.getUserCode();
		
		String deleteExperienceSno = request.getParameter("deleteExperienceSno");
		
	
	EmployeeResumeCreationBD creationBD=new EmployeeResumeCreationBD();
	String deleteExperience=creationBD.deleteExperience(employeeCode,deleteExperienceSno);
	request.setAttribute("status", deleteExperience);
	JSONObject jsonObject=new JSONObject();
	

		jsonObject.accumulate("status",deleteExperience);	
	

	

		response.getWriter().println(jsonObject);

		return null;
	}
	public ActionForward deleteResponsibilities(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		UserDetailVO userDetailVO = (UserDetailVO) request.getSession(false)
				.getAttribute("UserDetails");
		String employeeCode = userDetailVO.getUserCode();
		
		String deleteResponsibilitiesSno = request.getParameter("deleteResponsibilitiesSno");
		
	
	EmployeeResumeCreationBD creationBD=new EmployeeResumeCreationBD();
	String deleteresponsibilities=creationBD.deleteResponsibilities(employeeCode,deleteResponsibilitiesSno);
JSONObject jsonObject=new JSONObject();
jsonObject.accumulate("status",deleteresponsibilities);
	

		response.getWriter().println(jsonObject);

		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
