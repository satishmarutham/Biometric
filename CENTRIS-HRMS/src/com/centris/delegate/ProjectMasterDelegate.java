package com.centris.delegate;

import java.util.ArrayList;

import com.centris.VO.ProjectApprovedByVO;
import com.centris.VO.ProjectFilterVo;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.ProjectRefCodeGeneration;
import com.centris.form.ProjectMasterForm;
import com.centris.service.serviceImpl.ProjectMasterServiceImpl;

public class ProjectMasterDelegate {
	
	public  String addProject(ProjectMasterForm pjtform,String userid, String userName){
		
		return new ProjectMasterServiceImpl().addProject(pjtform, userid,userName);
	}
	
	public  ArrayList<ProjectMasterVo> getAllProjects(String userid ){
		
		return new ProjectMasterServiceImpl().getAllProjects(userid);
		
	}
	
	public  ArrayList<ProjectMasterVo> getAllProjectsByMgr(String empId ){
		
		return new ProjectMasterServiceImpl().getAllProjectsByMgr(empId);
		
	}
	
	
	
	public  ArrayList<ProjectMasterVo> getProjectsByManager(String[] managerid){
		
		return new ProjectMasterServiceImpl().getProjectsByManager(managerid);
		
	}
	
	
	public  ArrayList<ProjectMasterVo> editProjectDetails(String projectId){
		
		return new ProjectMasterServiceImpl().editProjectDetails(projectId);
		
	}

	public  String UpdateProject(ProjectMasterForm pjtform,String userid){
	
	return new ProjectMasterServiceImpl().UpdateProject(pjtform, userid);
	}
	
	public String deleteProject(String[] projectId){
		
		return new ProjectMasterServiceImpl().deleteProject(projectId);
		
	}
	
	public  boolean checkProjectCount(String projectname){
		
		return new ProjectMasterServiceImpl().checkProjectCount(projectname);
	}
	
	public  boolean checkProjectCountUpdate(String projectname,String projectid){
		
		return new ProjectMasterServiceImpl().checkProjectCountUpdate(projectname,projectid);
	}
	
	
	public  boolean checkProjectCode(String ProjectRefCode,String projectid){
		
		return new ProjectMasterServiceImpl().checkProjectCode(ProjectRefCode,projectid);
	}
	
	
	
	
    public  ArrayList<String> genereateNewRefCodeBD(ProjectRefCodeGeneration refCode){
		return new ProjectMasterServiceImpl().genereateNewRefCodeSeriviceImpl(refCode);
	}

	public ArrayList<ProjectApprovedByVO> getApproveUsers() {
		
		return new ProjectMasterServiceImpl().getApproveUsers();
	}

	public String approvedProject(String projectcode, String approvedby) {
		
		return new ProjectMasterServiceImpl().approvedProject(projectcode,approvedby);
	}

	


	public ArrayList<ProjectMasterVo> getProjectSearchDetails(String projectId,
			String userid) {
		
		return new ProjectMasterServiceImpl().getProjectSearchDetails(projectId,userid);
	}

	public String rejectedProject(String projectcode, String rejectedby) {
	
		return new ProjectMasterServiceImpl().rejectedProject(projectcode,rejectedby);
	}
	
	public  ArrayList<ProjectMasterVo> getAllProjectsByDir(String empId,String dirId ){
		
		return new ProjectMasterServiceImpl().getAllProjectsByDir(empId,dirId);
		
	}

	public ArrayList<ProjectMasterVo> getdownloadAllProjectsDetails(String usertype, String userCode) {
		
		
		return new ProjectMasterServiceImpl().getdownloadAllProjectsDetails(usertype,userCode);
		
	}

}
