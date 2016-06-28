package com.centris.decorator;

import org.displaytag.decorator.TableDecorator;

import com.centris.VO.ProjectMasterVo;
import com.centris.util.constants.MessageConstants;

public class ProjectCreationByMangDecorator  extends TableDecorator{
	
	String approval;
	

	public String getApproval() {
		
		ProjectMasterVo projectMasterVo =(ProjectMasterVo)getCurrentRowObject();
		
					
		if(projectMasterVo.getUserId().equalsIgnoreCase(projectMasterVo.getReportingto()) 
				&& projectMasterVo.getProjectstatus().equalsIgnoreCase(MessageConstants.PROJECT_CREATE) 
				&& !(projectMasterVo.getProjectstatus().equalsIgnoreCase(MessageConstants.PROJECT_REJECT)) ){
			
			approval="<input type=\"button\"  value=\"Approve\"  class=\"projectapproval\"  id='"+projectMasterVo.getProjectcode()+"'  "
					+ "onclick=\"approveProject('"+projectMasterVo.getProjectcode()+"','"+projectMasterVo.getReportingto()+"','"+projectMasterVo.getProjectname()+"')\"   "
					+ "></input>";
		}else{
			
			approval="";
		}
		
		return approval;
	}


	
	public String getProjectstatus() {
	
		ProjectMasterVo projectMasterVo =(ProjectMasterVo)getCurrentRowObject();
		
		String projectstatus="<span id=\"status"+projectMasterVo.getProjectcode()+"\">"+projectMasterVo.getProjectstatus()+"</span>";
		
		return projectstatus;
	}


    String reject;


	public String getReject() {
		
		ProjectMasterVo projectMasterVo =(ProjectMasterVo)getCurrentRowObject();
		
		
		if(projectMasterVo.getUserId().equalsIgnoreCase(projectMasterVo.getReportingto()) 
				&& projectMasterVo.getProjectstatus().equalsIgnoreCase(MessageConstants.PROJECT_CREATE) 
				&&  !(projectMasterVo.getProjectstatus().equalsIgnoreCase(MessageConstants.PROJECT_APPROVED)) ){
			
			reject="<input type=\"button\"  value=\"Reject\"  class=\"projectreject\"  id='reject"+projectMasterVo.getProjectcode()+"'  "
					+ "onclick=\"rejectProject('"+projectMasterVo.getProjectcode()+"','"+projectMasterVo.getReportingto()+"','"+projectMasterVo.getProjectname()+"')\"   "
					+ "></input>";
		}else{
			
			reject="";
		}
		
		
		
		return reject;
	}



	

	
	
	

}
