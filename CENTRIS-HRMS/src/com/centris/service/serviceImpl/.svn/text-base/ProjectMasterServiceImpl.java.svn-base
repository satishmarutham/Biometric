package com.centris.service.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DAOIMPL.IDGenerator;
import com.centris.DAO.DAOIMPL.ProjectMasterDaoImpl;
import com.centris.POJO.ProjectMasterPojo;
import com.centris.VO.ProjectApprovedByVO;
import com.centris.VO.ProjectFilterVo;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.ProjectRefCodeGeneration;
import com.centris.form.ProjectMasterForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.constants.MessageConstants;

public class ProjectMasterServiceImpl {
	
	
	private static Logger logger = Logger.getLogger(ProjectMasterServiceImpl.class);
	
	public  String addProject(ProjectMasterForm pjtform,String userid, String userName){
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterServiceImpl : addProject Starting");
		
		ProjectMasterPojo pjtpojo=new ProjectMasterPojo();
		String status=null;
		try {
			
			pjtpojo.setProjectcode(new IDGenerator().getPrimaryKeyID("hrms_project"));
			pjtpojo.setProjectname(pjtform.getProjectname().trim());
			pjtpojo.setProjectRefCode(pjtform.getProjectrefcode());
			pjtpojo.setProjectlocation(pjtform.getProjectlocation().trim());
			pjtpojo.setCreatedby(userid);
			pjtpojo.setCreatedate(HelperClass.getCurrentTimestamp());
			pjtpojo.setUserType(userid.toString().trim().substring(0, 3));
			pjtpojo.setProjectRefCode(pjtform.getProjectrefcode());
			pjtpojo.setClientname(pjtform.getClientname());
			pjtpojo.setProjecttype(pjtform.getProjecttype());
			pjtpojo.setEndcustomer(pjtform.getEndcustomer());
			pjtpojo.setForFuturExpan(pjtform.getForFuturExpan());
			pjtpojo.setProjectHighLevelActivity(pjtform.getProjectHighLevelActivity());
			pjtpojo.setLinkfinancialyear(pjtform.getLinkfinancialyear());
			pjtpojo.setProjectActivityCat(pjtform.getProjectActivityCat());
			pjtpojo.setReportingto(pjtform.getReportingto().trim());
			pjtpojo.setUserFirstName(userName.trim());
			pjtpojo.setPonumber(pjtform.getPonumber());
			
			
			status = new ProjectMasterDaoImpl().addProject(pjtpojo);
			
			
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterServiceImpl : addProject Ending");
		
		return status; 
		
	}
	
	
	
	public  ArrayList<ProjectMasterVo> getAllProjects(String userid){
		
		
		if(userid.toString().trim().substring(0, 3).equalsIgnoreCase("MAN")){
			
		   return new ProjectMasterDaoImpl().getAllProjects(userid);
		
		}else{
			
			return new ProjectMasterDaoImpl().getDirndAdminAllProjects(userid);
		}
		
	}
	
	public  ArrayList<ProjectMasterVo> getAllProjectsByMgr(String userid){
		
		
			return new ProjectMasterDaoImpl().getAllProjectsByMgr(userid);
		}
		
	
	
	
	public  ArrayList<ProjectMasterVo> getProjectsByManager(String[] managerid){
		
		return new ProjectMasterDaoImpl().getProjectsByManager(managerid);
		
	}
	
	public  ArrayList<ProjectMasterVo> editProjectDetails(String projectId){
		
		return new ProjectMasterDaoImpl().editProjectDetails(projectId);
		
	}
	
	public  String UpdateProject(ProjectMasterForm pjtform,String userid){
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterServiceImpl : UpdateProject Starting");
		String status = null;
		ProjectMasterPojo pjtpojo=new ProjectMasterPojo();
		
		
		try{
		
			pjtpojo.setProjectcode(pjtform.getProjectcode());
					
			pjtpojo.setProjectname(pjtform.getProjectname().trim());
			pjtpojo.setProjectRefCode(pjtform.getProjectrefcode());
			pjtpojo.setProjectlocation(pjtform.getProjectlocation().trim());
			pjtpojo.setCreatedby(userid);
			pjtpojo.setCreatedate(HelperClass.getCurrentTimestamp());
			pjtpojo.setUserType(userid.toString().trim().substring(0, 3));
			pjtpojo.setProjectRefCode(pjtform.getProjectrefcode());
			pjtpojo.setClientname(pjtform.getClientname());
			pjtpojo.setProjecttype(pjtform.getProjecttype());
			pjtpojo.setEndcustomer(pjtform.getEndcustomer());
			pjtpojo.setForFuturExpan(pjtform.getForFuturExpan());
			pjtpojo.setProjectHighLevelActivity(pjtform.getProjectHighLevelActivity());
			pjtpojo.setLinkfinancialyear(pjtform.getLinkfinancialyear());
			pjtpojo.setProjectActivityCat(pjtform.getProjectActivityCat());
			pjtpojo.setCheckboxval(pjtform.getCheckboxval());
			pjtpojo.setPonumber(pjtform.getPonumber());
		
			if(pjtform.getReportingto()!=null){			
			
				pjtpojo.setReportingto(pjtform.getReportingto());
			}else{
				
				pjtpojo.setReportingto(pjtform.getHiddenreportingto());
			}
			
			status = new ProjectMasterDaoImpl().UpdateProject(pjtpojo);
		
		}catch(Exception e){
			
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterServiceImpl : UpdateProject Ending");
		
		return status;
		
	}
	
	public String deleteProject(String[] projectId){
		
		return new ProjectMasterDaoImpl().deleteProject(projectId);
		
	}
	
	public  boolean checkProjectCount(String projectname){
		
		return new ProjectMasterDaoImpl().checkProjectCount(projectname);
	}
	
	public  boolean checkProjectCountUpdate(String projectname,String projectid){
		
		return new ProjectMasterDaoImpl().checkProjectCountUpdate(projectname,projectid);
	}
	
	
public  boolean checkProjectCode(String projectrefcode,String projectid){
		
		return new ProjectMasterDaoImpl().checkProjectCode(projectrefcode,projectid);
	}


	
 public  ArrayList<String> genereateNewRefCodeSeriviceImpl(ProjectRefCodeGeneration refCode){
	
	return new ProjectMasterDaoImpl().genereateNewRefCodeDAOImpl( refCode );
 }



 public ArrayList<ProjectApprovedByVO> getApproveUsers() {
	
	 return new ProjectMasterDaoImpl().getApproveUsers();
}



  public String approvedProject(String projectcode, String approvedby) {

	return new ProjectMasterDaoImpl().approvedProject(projectcode,approvedby);
 }







 public ArrayList<ProjectMasterVo> getProjectSearchDetails(String projectId,String userid) {

	 return new ProjectMasterDaoImpl().getProjectSearchDetails(projectId,userid);
}



public String rejectedProject(String projectcode, String rejectedby) {

	return new ProjectMasterDaoImpl().rejectedProject(projectcode,rejectedby);
}

public  ArrayList<ProjectMasterVo> getAllProjectsByDir(String empId,String dirId ){
	
	return new ProjectMasterDaoImpl().getAllProjectsByDir(empId,dirId);
	
}



public ArrayList<ProjectMasterVo> getdownloadAllProjectsDetails(String usertype, String userCode) {

	
	return new ProjectMasterDaoImpl().getdownloadAllProjectsDetails(usertype,userCode);
}


 
}
