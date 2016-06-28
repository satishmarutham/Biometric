package com.centris.DAO.DAOIMPL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.transaction.Transaction;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.DAO.ProjectMasterDao;
import com.centris.POJO.ProjectMasterPojo;
import com.centris.VO.ProjectApprovedByVO;
import com.centris.VO.ProjectFilterVo;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.ProjectRefCodeGeneration;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AttendenceDetails;
import com.centris.util.SQLUtils.EmployeeLeaveRequest;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.SQLUtils.ProjectDetails;
import com.centris.util.SQLUtils.ProjectManagerMappingSQLutil;
import com.centris.util.constants.MessageConstants;

public class ProjectMasterDaoImpl extends DBService implements ProjectMasterDao{
	
	private static Logger logger = Logger.getLogger(ProjectMasterDaoImpl.class);
	
	
	//adding project
	public  String addProject(ProjectMasterPojo pjtpojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: addProject : Starting");
		
		PreparedStatement ps_projectadd = null;
		ResultSet rs_projectadd = null;
		Connection connection = null;
		int no = 0;
		String status = null;

		try {
			connection = getConnection();

			ps_projectadd = connection.prepareStatement(ProjectDetails.ADD_PROJECT);
			
			if(!new ProjectMasterDaoImpl().checkProjectCount(pjtpojo.getProjectname())){
			
				ps_projectadd.setString(1, pjtpojo.getProjectcode().trim());
				ps_projectadd.setString(2, pjtpojo.getProjectname());
				ps_projectadd.setString(3, pjtpojo.getProjectlocation());
				ps_projectadd.setString(4, pjtpojo.getClientname());
				ps_projectadd.setString(5, pjtpojo.getProjecttype());
				ps_projectadd.setString(6, pjtpojo.getEndcustomer());
				ps_projectadd.setString(7, pjtpojo.getProjectHighLevelActivity());
				ps_projectadd.setString(8, pjtpojo.getForFuturExpan());
				ps_projectadd.setString(9, pjtpojo.getProjectActivityCat());
				ps_projectadd.setString(10, pjtpojo.getLinkfinancialyear());
				ps_projectadd.setString(11, pjtpojo.getProjectRefCode());
				ps_projectadd.setString(12, pjtpojo.getCreatedby());
				ps_projectadd.setTimestamp(13, pjtpojo.getCreatedate());
				ps_projectadd.setString(14, MessageConstants.PROJECT_CREATE);
				ps_projectadd.setString(15, pjtpojo.getReportingto());
				ps_projectadd.setString(16, pjtpojo.getPonumber());
				
				no = ps_projectadd.executeUpdate();
				
				

				if (no > 0) {

					status = "true";
					
				     String	result=sendMailToReportingperson(pjtpojo,connection);
					
					if(result.equalsIgnoreCase("false")){
						
						status=MessageConstants.MAIL_NOT_SENT;
					}
					
			
					if( pjtpojo.getUserType().equalsIgnoreCase("MAN")){
						
						
					 PreparedStatement	pstmtinsert = connection
								.prepareStatement(ProjectManagerMappingSQLutil.INSERT_PROJECT_MANAGER);	
					 
					 pstmtinsert.setString(1, pjtpojo.getCreatedby());
					 pstmtinsert.setString(2, pjtpojo.getProjectcode());
					 pstmtinsert.setString(3, pjtpojo.getCreatedby());
						
					 pstmtinsert.executeUpdate();
						
					}
					
				} else {

					status = "false";
				}
			}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (rs_projectadd != null && (!rs_projectadd.isClosed())) {

					rs_projectadd.close();
				}
				if (ps_projectadd != null && (!ps_projectadd.isClosed())) {

					ps_projectadd.close();
				}
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: addProject : Ending");
		return status;

	}
	
	
	//getting all projects
	public  ArrayList<ProjectMasterVo> getAllProjects(String userid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getAllProjects : Starting");
		
		
		
		PreparedStatement ps_projectget = null;
		ResultSet rs_projectget = null;
		Connection connection = null;
		ArrayList<ProjectMasterVo> pjt_list=new ArrayList<ProjectMasterVo>();

		try {
			connection = getConnection();
			
			
			
			if(userid.toString().trim().substring(0, 3).equalsIgnoreCase("MAN"))
			{
			   ps_projectget = connection.prepareStatement(ProjectDetails.GET_ALL_PROJECT_BYUSER_MAN);
			}
			 else{
				 ps_projectget = connection.prepareStatement(ProjectDetails.GET_ALL_PROJECT_BYUSER);
			   }
			
			
			
			ps_projectget.setString(1, userid);
			ps_projectget.setString(2, userid);
			
			rs_projectget = ps_projectget.executeQuery();

				while(rs_projectget.next()){
					
					ProjectMasterVo pjtvo=new ProjectMasterVo();
					
					pjtvo.setProjectname(rs_projectget.getString("Project_Name"));
					pjtvo.setProjectcode(rs_projectget.getString("ProjectCode"));
					pjtvo.setProjectlocation(rs_projectget.getString("Location"));
					pjtvo.setProjectRefCode(rs_projectget.getString("ProjectRefCode"));
					pjtvo.setProjectstatus(rs_projectget.getString("ProjectStatus"));
					pjtvo.setReportingto(rs_projectget.getString("ReportingTo"));
					pjtvo.setUserId(userid);
					pjtvo.setCreatedby(getName(rs_projectget.getString("CreatedBy"),connection));
					pjtvo.setApprovedby(getName(rs_projectget.getString("ApprovedBy"),connection));
					pjtvo.setClosedby(getName(rs_projectget.getString("ClosedBy"),connection));
					pjtvo.setPonumber(rs_projectget.getString("PoNumber"));
					pjt_list.add(pjtvo);
					
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (ps_projectget != null && (!ps_projectget.isClosed())) {

					ps_projectget.close();
				}
				if (rs_projectget != null && (!rs_projectget.isClosed())) {

					rs_projectget.close();
				}
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getAllProjects : Ending");
		
		return pjt_list;

	}
	
	
	public  ArrayList<ProjectMasterVo> getDirndAdminAllProjects(String userId) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getAllProjects : Starting");
		
		
		PreparedStatement ps_projectget = null;
		ResultSet rs_projectget = null;
		Connection connection = null;
		ArrayList<ProjectMasterVo> pjt_list=new ArrayList<ProjectMasterVo>();

		try {
			connection = getConnection();
			
			ps_projectget = connection.prepareStatement(ProjectDetails.GET_ALL_PROJECT);
			
			rs_projectget = ps_projectget.executeQuery();

				while(rs_projectget.next()){
					
					ProjectMasterVo pjtvo=new ProjectMasterVo();
					
		
					pjtvo.setProjectname(rs_projectget.getString("Project_Name"));
					pjtvo.setProjectcode(rs_projectget.getString("ProjectCode"));
					pjtvo.setProjectlocation(rs_projectget.getString("Location"));
					pjtvo.setProjectRefCode(rs_projectget.getString("ProjectRefCode"));
					pjtvo.setProjectstatus(rs_projectget.getString("ProjectStatus"));
					pjtvo.setReportingto(rs_projectget.getString("ReportingTo"));
					pjtvo.setUserId(userId);
				    pjtvo.setCreatedby(getName(rs_projectget.getString("CreatedBy"), connection));
					pjtvo.setApprovedby(getName(rs_projectget.getString("ApprovedBy"),connection));
					pjtvo.setClosedby(getName(rs_projectget.getString("ClosedBy"),connection));				
					pjtvo.setPonumber(rs_projectget.getString("PoNumber"));
						pjt_list.add(pjtvo);
					
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (ps_projectget != null && (!ps_projectget.isClosed())) {

					ps_projectget.close();
				}
				if (rs_projectget != null && (!rs_projectget.isClosed())) {

					rs_projectget.close();
				}
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getAllProjects : Ending");
		
		return pjt_list;

	}
	
	//getProjectsByManager
	public  ArrayList<ProjectMasterVo> getProjectsByManager(String[] managerid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getProjectsByManager : Starting");
		
		PreparedStatement ps_projectget = null;
		ResultSet rs_projectget = null;
		Connection connection = null;
		ArrayList<ProjectMasterVo> pjt_list=new ArrayList<ProjectMasterVo>();

		try {
			connection = getConnection();
			
			ps_projectget = connection.prepareStatement(ProjectDetails.GET_ALL_PROJECT_BY_MANAGER);
			for(int i=0;i<managerid.length;i++){
			ps_projectget.setString(1, managerid[i]);
			rs_projectget = ps_projectget.executeQuery();

				while(rs_projectget.next()){
					
					ProjectMasterVo pjtvo=new ProjectMasterVo();
					
					pjtvo.setProjectname(rs_projectget.getString("ProjectRefCode"));
					pjtvo.setProjectcode(rs_projectget.getString("ProjectCode"));
					pjtvo.setProjectRefCode(rs_projectget.getString("ProjectRefCode"));
					
					
					pjt_list.add(pjtvo);
					
				}
			}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (ps_projectget != null && (!ps_projectget.isClosed())) {

					ps_projectget.close();
				}
				if (rs_projectget != null && (!rs_projectget.isClosed())) {

					rs_projectget.close();
				}
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getProjectsByManager : Ending");
		
		return pjt_list;

	}
	
	//get project details for edit project
	public  ArrayList<ProjectMasterVo> editProjectDetails(String projectId){

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ProjectMasterDaoImpl: editProjectDetails : Starting");
	
	PreparedStatement ps_projectget = null;
	ResultSet rs_projectget = null;
	Connection connection = null;
	ArrayList<ProjectMasterVo> pjt_list=new ArrayList<ProjectMasterVo>();

	try {
		connection = getConnection();
		
		ps_projectget = connection.prepareStatement(ProjectDetails.GET_SINGLE_PROJECT);
		ps_projectget.setString(1, projectId);
		
		rs_projectget = ps_projectget.executeQuery();

		ProjectMasterVo pjtvo=new ProjectMasterVo();
		
			while(rs_projectget.next()){
				
				pjtvo.setProjectname(rs_projectget.getString("Project_Name"));
				pjtvo.setProjectcode(rs_projectget.getString("ProjectCode"));
				pjtvo.setProjectlocation(rs_projectget.getString("Location"));
				pjtvo.setClientname(rs_projectget.getString("ClientName"));
				pjtvo.setProjecttype(rs_projectget.getString("ProjectType"));
				pjtvo.setEndcustomer(rs_projectget.getString("EndCustomer"));
				pjtvo.setProjectHighLevelActivity(rs_projectget.getString("projectHighLevelActivity"));
				pjtvo.setForFuturExpan(rs_projectget.getString("forFuturExpan"));
				pjtvo.setProjectActivityCat(rs_projectget.getString("projectActivityCat"));
				pjtvo.setLinkfinancialyear(rs_projectget.getString("linkfinancialyear"));
				pjtvo.setProjectRefCode(rs_projectget.getString("ProjectRefCode"));
				pjtvo.setReportingto(rs_projectget.getString("ReportingTo"));
				pjtvo.setProjectstatus(rs_projectget.getString("ProjectStatus"));
				pjtvo.setPonumber(rs_projectget.getString("PoNumber"));
				
				pjt_list.add(pjtvo);
				
				
				
			}

	 
			
			
			
	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			if (ps_projectget != null && (!ps_projectget.isClosed())) {

				ps_projectget.close();
			}
			if (rs_projectget != null && (!rs_projectget.isClosed())) {

				rs_projectget.close();
			}
			if (connection != null && (!connection.isClosed())) {

				connection.close();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ProjectMasterDaoImpl: editProjectDetails : Ending");
	
	return pjt_list;

}

	//updating the project
	public  String UpdateProject(ProjectMasterPojo pjtpojo) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ProjectMasterDaoImpl: UpdateProject : Starting");
	
	PreparedStatement ps_projectupdate = null;
	Connection connection = null;
	int no = 0;
	String status = null;

	try {
		connection = getConnection();
	
        if(pjtpojo.getCheckboxval().equalsIgnoreCase(MessageConstants.PROJECT_CLOSED)){
        	ps_projectupdate = connection.prepareStatement(ProjectDetails.UPDATE_PROJECT_WITH_CLOSED);
	
        	   ps_projectupdate.setString(1,pjtpojo.getProjectname());
		        ps_projectupdate.setString(2,pjtpojo.getProjectlocation());
		        ps_projectupdate.setString(3, pjtpojo.getClientname());
		        ps_projectupdate.setString(4, pjtpojo.getProjecttype());
		        ps_projectupdate.setString(5, pjtpojo.getEndcustomer());
		        ps_projectupdate.setString(6, pjtpojo.getProjectHighLevelActivity());
		        ps_projectupdate.setString(7, pjtpojo.getForFuturExpan());
		        ps_projectupdate.setString(8, pjtpojo.getProjectActivityCat());
		        ps_projectupdate.setString(9, pjtpojo.getLinkfinancialyear());
		        ps_projectupdate.setString(10, pjtpojo.getProjectRefCode());
		        ps_projectupdate.setString(11, pjtpojo.getCreatedby());
		        ps_projectupdate.setTimestamp(12, pjtpojo.getCreatedate());
		        ps_projectupdate.setString(13, pjtpojo.getReportingto());
		        ps_projectupdate.setString(14, pjtpojo.getCreatedby());
		        ps_projectupdate.setTimestamp(15, pjtpojo.getCreatedate());
		        ps_projectupdate.setString(16, MessageConstants.PROJECT_CLOSED);
		        ps_projectupdate.setString(17, pjtpojo.getPonumber());
		        ps_projectupdate.setString(18, pjtpojo.getProjectcode());
		   
		    	no = ps_projectupdate.executeUpdate();

				if (no > 0) {

					status = MessageConstants.PROJECT_UPDATE_SUCCESS;
					
					String result = sendProjectClosedEmail(pjtpojo.getProjectcode(),pjtpojo.getReportingto(),pjtpojo.getCreatedby(), connection);
					if(result.equals("false")){
						
						status = MessageConstants.PROJECT_UPDATE_SUCCESS_MAIL_NOT_SENT;
					}
					
				} else {

					status = MessageConstants.PROJECT_UPDATE_FAILED;
				}
        	
         }else{
		   ps_projectupdate = connection.prepareStatement(ProjectDetails.UPDATE_PROJECT);
		
		
           ps_projectupdate.setString(1,pjtpojo.getProjectname());
		        ps_projectupdate.setString(2,pjtpojo.getProjectlocation());
		        ps_projectupdate.setString(3, pjtpojo.getClientname());
		        ps_projectupdate.setString(4, pjtpojo.getProjecttype());
		        ps_projectupdate.setString(5, pjtpojo.getEndcustomer());
		        ps_projectupdate.setString(6, pjtpojo.getProjectHighLevelActivity());
		        ps_projectupdate.setString(7, pjtpojo.getForFuturExpan());
		        ps_projectupdate.setString(8, pjtpojo.getProjectActivityCat());
		        ps_projectupdate.setString(9, pjtpojo.getLinkfinancialyear());
		        ps_projectupdate.setString(10, pjtpojo.getProjectRefCode());
		        ps_projectupdate.setString(11, pjtpojo.getCreatedby());
		        ps_projectupdate.setTimestamp(12, pjtpojo.getCreatedate());
		        ps_projectupdate.setString(13, pjtpojo.getReportingto());
		        ps_projectupdate.setString(14, pjtpojo.getPonumber());
		        ps_projectupdate.setString(15, pjtpojo.getProjectcode());
		        
		        
		    	no = ps_projectupdate.executeUpdate();

				
				
				if (no > 0) {

					status = MessageConstants.PROJECT_UPDATE_SUCCESS;
				} else {

					status = MessageConstants.PROJECT_UPDATE_FAILED;
				}
		
         }

        
        
		


	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			
			if (ps_projectupdate != null && (!ps_projectupdate.isClosed())) {

				ps_projectupdate.close();
			}
			if (connection != null && (!connection.isClosed())) {

				connection.close();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ProjectMasterDaoImpl: UpdateProject : Ending");
	
	return status;

}

  public String sendProjectClosedEmail(String projectcode,String reporingto, String closedby, Connection connection) {
	 
	        String status=null;
			
	        String cretedbyname=null;
			String cretedbyEmailId=null;
			
			String reportingName=null;
			String reportingEmailId=null;
		
			
			String closedByName=null;
			String closedByEmailid=null;
			
			try {
				
				String reportingtoshort=reporingto.substring(0, 3);
				
				if(LoginDetails.MANAGER_ID_TYPE.equalsIgnoreCase(reportingtoshort)){
					
				     Map<String,String>  magMap = getManagerDetails(reporingto,connection);
				     reportingName   = magMap.get("FirstName");
				     reportingEmailId   = magMap.get("email");
					
				}else{
					   Map<String,String>  direMap = getDirectorDetails(reporingto,connection);
					   reportingName   = direMap.get("FirstName");
					   reportingEmailId   = direMap.get("email");
					
				}
					
			String createdby = getCreatedby(projectcode,connection);
			String createdbyshort=createdby.substring(0, 3);
			
			if(LoginDetails.MANAGER_ID_TYPE.equalsIgnoreCase(createdbyshort)){
				
			     Map<String,String>  magMap = getManagerDetails(createdby,connection);
			     cretedbyname   = magMap.get("FirstName");
			     cretedbyEmailId   = magMap.get("email");
				
			}else if(LoginDetails.ADMIN_ID_TYPE.equalsIgnoreCase(createdbyshort)){
				
				  Map<String,String>  adminMap = getAdminDetails(createdby,connection);
				  cretedbyname   = adminMap.get("FirstName");
				  cretedbyEmailId   = adminMap.get("email");
				
			}else{
				
				   Map<String,String>  direMap = getDirectorDetails(createdby,connection);
				   cretedbyname   = direMap.get("FirstName");
				   cretedbyEmailId   = direMap.get("email");
			}
			
			
		
			String  closedbyshort = closedby.substring(0, 3);
			
			if(LoginDetails.MANAGER_ID_TYPE.equalsIgnoreCase(closedbyshort)){
				
			     Map<String,String>  magMap = getManagerDetails(closedby,connection);
			     closedByName   = magMap.get("FirstName");
			     closedByEmailid   = magMap.get("email");
				
			}else if(LoginDetails.ADMIN_ID_TYPE.equalsIgnoreCase(closedbyshort)){
				
				  Map<String,String>  adminMap = getAdminDetails(closedby,connection);
				  closedByName   = adminMap.get("FirstName");
				  closedByEmailid   = adminMap.get("email");
				
			}else{
				
				   Map<String,String>  direMap = getDirectorDetails(closedby,connection);
				   closedByName   = direMap.get("FirstName");
				   closedByEmailid   = direMap.get("email");
			}
			
			ProjectMasterVo  projectvo = getProjectDetails(projectcode);
		
			String url = new  EmployeeDAOImpl().getServerUrlFromBD(connection);
			
			EmailContent em = new EmailContent();
			String[] mailIds={reportingEmailId};
			em.setMailids(mailIds);
			em.setSubject("Project Closed");
		   		
			em.setMessage("Dear "+reportingName+", \n"
					+ "Greetings from TeleIndia. \n\n"
					+ "Project is Closed \n\n"
					+ "Project Details \n"
					+ "ProjectRefCode : "+projectvo.getProjectRefCode()+" \n"
					+ "ProjectName     : "+projectvo.getProjectname()+" \n"
					+ "ClosedBy          : "+closedByName+" \n\n"
					+ "For more Details Login URL : " + url + "\n"
					+ "Verify the Project Master \n\n"
					+ "Have a nice day \n\n"
					+ "E-ATTENDANCE PRO  \n"
					+ "-------------------------------------------------------------- \n"
					+ "This is system generated mail,Please do not reply");
			
		
				status = new SendMailWithMultipleAttachment().sendReportToMail(em);
				
				if( !(reportingEmailId.equalsIgnoreCase(cretedbyEmailId)) ){
					
					String[] mailIds1={cretedbyEmailId};
				   
					em.setMailids(mailIds1);
					em.setSubject("Project Closed");
				   		
					em.setMessage("Dear "+cretedbyname+", \n"
							+ "Greetings from TeleIndia. \n\n"
							+ "Project is Closed \n\n"
							+ "Project Details \n"
							+ "ProjectRefCode : "+projectvo.getProjectRefCode()+" \n"
							+ "ProjectName     : "+projectvo.getProjectname()+" \n"
							+ "ClosedBy          : "+closedByName+" \n\n"
							+ "For more Details Login URL : " + url + "\n"
							+ "Verify the Project Master \n\n"
							+ "Have a nice day \n\n"
							+ "E-ATTENDANCE PRO  \n"
							+ "-------------------------------------------------------------- \n"
							+ "This is system generated mail,Please do not reply");
					
				
						status = new SendMailWithMultipleAttachment().sendReportToMail(em);
					
					
					
					
				}
				
				
				
				
			} catch (IOException ie) {
			
			     ie.printStackTrace();
			}catch (Exception e) {
				
			     e.printStackTrace();
			}
			
			
			return status;
		   
		   
	}


//deleting project
public  String deleteProject(String[] projectId){

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ProjectMasterDaoImpl: deleteProject : Starting");
	
	PreparedStatement ps_projectget = null;
	PreparedStatement ps_projectdelete = null;
	ResultSet rs_projectget = null;
	Connection connection = null;
	int count=0;
	String status=null;
	int no=0;

	try {
		connection = getConnection();
		
		ps_projectget = connection.prepareStatement(ProjectDetails.PROJECT_MANAGER_MAPPING_COUNT);
		ps_projectdelete=connection.prepareStatement(ProjectDetails.DELETE_PROJECT);
		
		for(int i=0;i<projectId.length;i++){
		
		ps_projectget.setString(1, projectId[i].trim());
		
		rs_projectget = ps_projectget.executeQuery();

			while(rs_projectget.next()){
				
				count=rs_projectget.getInt(1);
				
			}
			
			if(count>0){
				
				 status=MessageConstants.PROJECT_MGR_MAP;
			}else{
				
				ps_projectdelete.setString(1, projectId[i]);
				
				no=ps_projectdelete.executeUpdate();
				
				if(no>0){
					
					status=MessageConstants.PROJECT_DELETE_SUCCESS;
					
				}else{
					
					status=MessageConstants.PROJECT_DELETE_FAILED;
				}
			}
			
		}


	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			
			if (rs_projectget != null && (!rs_projectget.isClosed())) {

				rs_projectget.close();
			}if (ps_projectget != null && (!ps_projectget.isClosed())) {

				ps_projectget.close();
			}if (ps_projectdelete != null && (!ps_projectdelete.isClosed())) {

				ps_projectdelete.close();
			}
			if (connection != null && (!connection.isClosed())) {

				connection.close();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ProjectMasterDaoImpl: deleteProject : Ending");
	
	return status;

}

//checking project duplicates while inserting time
public  boolean checkProjectCount(String projectname) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ProjectMasterDaoImpl: checkProjectCount : Starting");
	
	PreparedStatement ps_projectcount = null;
	Connection connection = null;
	ResultSet rs_projectcount=null;
	int no = 0;
	boolean status=false;
	
	try {
		connection = getConnection();

		ps_projectcount = connection.prepareStatement(ProjectDetails.COUNT_PROJECTNAME);
		
		ps_projectcount.setString(1, projectname.trim());
			

		rs_projectcount = ps_projectcount.executeQuery();

			while(rs_projectcount.next()){
				
				no=rs_projectcount.getInt(1);
			}
			
			if(no>0){
				
				status=true;
			}else{
				
				status=false;
			}


	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	}finally {
		try {

			if (rs_projectcount != null && (!rs_projectcount.isClosed())) {

				rs_projectcount.close();
			}
			if (rs_projectcount != null && (!rs_projectcount.isClosed())) {

				rs_projectcount.close();
			}
			if (connection != null && (!connection.isClosed())) {

				connection.close();
			}

		}catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ProjectMasterDaoImpl: checkProjectCount : Ending");
	
	return status;

}

//checking project duplicates while updating time
public  boolean checkProjectCountUpdate(String projectname,String projectid) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ProjectMasterDaoImpl: checkProjectCountUpdate : Starting");
	
	PreparedStatement ps_projectcount = null;
	Connection connection = null;
	ResultSet rs_projectcount=null;
	int no = 0;
	boolean status=false;
	
	try {
		connection = getConnection();

		ps_projectcount = connection.prepareStatement(ProjectDetails.COUNT_PROJECTNAME_UPDATE);
		
		ps_projectcount.setString(1, projectname.trim());
		ps_projectcount.setString(2, projectid.trim());
			

		rs_projectcount = ps_projectcount.executeQuery();

			while(rs_projectcount.next()){
				
				no=rs_projectcount.getInt(1);
			}
			
			if(no>0){
				
				status=true;
			}else{
				
				status=false;
			}


	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	}finally {
		try {

			if (rs_projectcount != null && (!rs_projectcount.isClosed())) {

				rs_projectcount.close();
			}
			if (rs_projectcount != null && (!rs_projectcount.isClosed())) {

				rs_projectcount.close();
			}
			if (connection != null && (!connection.isClosed())) {

				connection.close();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ProjectMasterDaoImpl: checkProjectCountUpdate : Ending");
	
	return status;

}


//checking projectRefCode duplicates 
public  boolean checkProjectCode(String ProjectRefCode,String projectid) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ProjectMasterDaoImpl: checkProjectCode : Starting");
	
	PreparedStatement ps_projectcount = null;
	Connection connection = null;
	ResultSet rs_projectcount=null;
	int no = 0;
	boolean status=false;
	
	try {
		connection = getConnection();

		ps_projectcount = connection.prepareStatement(ProjectDetails.CHECK_PROJECTREFCODE);
		
		ps_projectcount.setString(1, projectid.trim());
		ps_projectcount.setString(2, ProjectRefCode.trim());
		

		rs_projectcount = ps_projectcount.executeQuery();

			while(rs_projectcount.next()){
				
				no=rs_projectcount.getInt(1);
			}
			
			if(no>0){
				
				status=true;
			}else{
				
				status=false;
			}


	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	}finally {
		try {

			if (rs_projectcount != null && (!rs_projectcount.isClosed())) {

				rs_projectcount.close();
			}
			if (rs_projectcount != null && (!rs_projectcount.isClosed())) {

				rs_projectcount.close();
			}
			if (connection != null && (!connection.isClosed())) {

				connection.close();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ProjectMasterDaoImpl: checkProjectCode : Ending");
	
	return status;

}

 
 public  ArrayList<String> genereateNewRefCodeDAOImpl(ProjectRefCodeGeneration refCode){
	
	 ArrayList<String> result = new ArrayList<String>();
	 
	 result.clear();
	 int count =0;
	 Connection connection=null ;
	 PreparedStatement	getProjRefCode=null;
	 PreparedStatement Update_ProjRefCode =null;
	 PreparedStatement insert_ProjRefCode = null;
	 PreparedStatement check_ProjRefCode = null;
	 
	 
	 
	 try{
		 
		 
	     connection = getConnection();
	    getProjRefCode = connection.prepareStatement(ProjectDetails.GET_PROJECT_REFCODE);
	    getProjRefCode.setString(1, refCode.getProjectId());
	    getProjRefCode.setString(2, refCode.getOldRefCode());
		
	    count =0;
		ResultSet RS_refcode  = getProjRefCode.executeQuery();

			while(RS_refcode.next()){
				
			 count++;
				
			}
	 
	   if(count == 1){
		   
		   check_ProjRefCode = connection.prepareStatement("SELECT COUNT(*) cnt FROM hrms_project_refcodes WHERE ProjectRefName = ? AND ProjectCode = ? ");
			  
		   check_ProjRefCode.setString(1, refCode.getNewRefCode());
		   check_ProjRefCode.setString(2, refCode.getProjectId());
		    
		   ResultSet RS_check_ProjRefCode   =  check_ProjRefCode.executeQuery();
		   
		    int ccount =0;
		   while(RS_check_ProjRefCode.next()){
				
			   ccount = RS_check_ProjRefCode.getInt("cnt");
					
			}
		   
		   if( ccount == 0 )
		   {
		   
		   Update_ProjRefCode =  connection.prepareStatement(" UPDATE hrms_project SET ProjectRefCode= ? WHERE ProjectCode = ? AND ProjectRefCode= ? ");
		   
		   Update_ProjRefCode.setString(1, refCode.getNewRefCode());
		   Update_ProjRefCode.setString(2, refCode.getProjectId());
		   Update_ProjRefCode.setString(3, refCode.getOldRefCode());
		   
		   int res =  Update_ProjRefCode.executeUpdate();
		   
		   if ( res == 1) {
			  
			   insert_ProjRefCode =  connection.prepareStatement(" INSERT INTO hrms_project_refcodes ( ProjectCode,ProjectRefName,isActive,CreatedBy) VALUES ( ?,?,'Y',?); ");
			   
			   insert_ProjRefCode.setString(1, refCode.getProjectId());
			   insert_ProjRefCode.setString(2, refCode.getNewRefCode());
			   insert_ProjRefCode.setString(3, refCode.getUserID());
			  
			   int resl =  insert_ProjRefCode.executeUpdate();   
			   
			   result.add("true");
			   result.add(" New Project Reference code generated Successfully,Please wait..");
			   
			   return result;
			   }
		   else{
				  
			   
			   result.add("flase");
			   result.add(" Ohhh ! Something went wrong, Please wait and try again. ");
			   
			   return result;
			  
		  }
			  
			   
		  }
		   else{
			   
			   result.clear();
			   result.add("flase");
			   result.add(" Project Code is Already Exist, Please wait and try again. "); 
			   
			   return result;
		   }
		 
			   
	   }
	   else{
		   
		   result.add("false");
		   result.add(" Ohhh ! Something went wrong, Please wait and try again. ");
		   return result;
	   }
	 
	   
	 }catch(Exception e){
		 
		 e.printStackTrace();
	 }
	 finally{
		 try {

				if (getProjRefCode != null && (!getProjRefCode.isClosed())) {

					getProjRefCode.close();
				}
				if (Update_ProjRefCode != null && (!Update_ProjRefCode.isClosed())) {

					Update_ProjRefCode.close();
				}
				if (insert_ProjRefCode != null && (!insert_ProjRefCode.isClosed())) {

					insert_ProjRefCode.close();
				}
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
	 }
	 
	 return result;
	
 }


 
 public void getProjects( ) throws SQLException{
		
		PreparedStatement ps_projectadd = null;
		PreparedStatement ps_projectadd1 = null;
		ResultSet rs_projectadd = null;
		Connection connection = null;
		int no = 0;
		String status = null;
		Savepoint sp =null;
		try {
			
			
			connection = getConnection();
//			connection.setAutoCommit(false);
			
//			sp = connection.setSavepoint("RATNA");
			
		
			
			ps_projectadd1 = connection.prepareStatement("INSERT INTO test (tname) VALUES( ?)");
			
			ps_projectadd1.setString(1, "Test");
			
			
			ps_projectadd1.executeUpdate();
			
			
			int a = 10/0;
			
			ps_projectadd = connection.prepareStatement(ProjectDetails.select_project);
			
			
			rs_projectadd = ps_projectadd.executeQuery();
			
			while (rs_projectadd.next()) {
				
				System.out.println(rs_projectadd.getString("PC")+" - "+rs_projectadd.getString("PN"));
				
			}
			
//		connection.commit();	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			
			 
//			connection.rollback(sp);
			e.printStackTrace();
		}

	 
 }
 
 
	public  ArrayList<ProjectMasterVo> getAllProjectsByMgr(String userid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getAllProjectsByMgr : Starting");
		
		
		PreparedStatement ps_projectget = null;
		ResultSet rs_projectget = null;
		Connection connection = null;
		
		ArrayList<ProjectMasterVo> pjt_list=new ArrayList<ProjectMasterVo>();

		try {
			connection = getConnection();
			
				 ps_projectget = connection.prepareStatement(ProjectDetails.GET_PROJECTS_BY_MGR_EMP);
			
			ps_projectget.setString(1, userid);
			
			rs_projectget = ps_projectget.executeQuery();

				while(rs_projectget.next()){
					
					ProjectMasterVo pjtvo=new ProjectMasterVo();
					
					pjtvo.setProjectname(rs_projectget.getString("Project_Name"));
					pjtvo.setProjectcode(rs_projectget.getString("ProjectCode"));
					pjtvo.setProjectlocation(rs_projectget.getString("Location"));
					pjtvo.setProjectRefCode(rs_projectget.getString("ProjectRefCode"));
					   
					pjt_list.add(pjtvo);
					
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (ps_projectget != null && (!ps_projectget.isClosed())) {

					ps_projectget.close();
				}
				if (rs_projectget != null && (!rs_projectget.isClosed())) {

					rs_projectget.close();
				}
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getAllProjectsByMgr : Ending");
		
		return pjt_list;

	}
 
	public ArrayList<ProjectApprovedByVO> getApproveUsers() {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getApproveUsers : Starting");
		
		
		PreparedStatement ps_approveby = null;
		ResultSet rs_approveby = null;
		Connection connection = null;
		
		ArrayList<ProjectApprovedByVO> approvebylist=new ArrayList<ProjectApprovedByVO>();

		try {
		
		connection = getConnection();
			
		ps_approveby = connection.prepareStatement(ProjectDetails.GET_APPROVE_USERS);
			
		   rs_approveby = ps_approveby.executeQuery();
		   
			while(rs_approveby.next()){
					
					ProjectApprovedByVO projectApprovedByVO=new ProjectApprovedByVO();
					
					projectApprovedByVO.setApprovebyId(rs_approveby.getString("Id"));
					projectApprovedByVO.setApproveby(rs_approveby.getString("name"));
					
					   
					approvebylist.add(projectApprovedByVO);
					
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

			
				if (rs_approveby != null && (!rs_approveby.isClosed())) {

					rs_approveby.close();
				}
				
				if (ps_approveby != null && (!ps_approveby.isClosed())) {

					ps_approveby.close();
				}
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getApproveUsers : Ending");
		
		return approvebylist;
	}
	
	
	public String sendMailToReportingperson(ProjectMasterPojo pjtpojo,
			Connection connection) {
		
	   String status=null;
		String name=null;
		String EmailId=null;
		
		try {
		
		String Reportingto=pjtpojo.getReportingto().substring(0, 3);
		
		if(LoginDetails.MANAGER_ID_TYPE.equalsIgnoreCase(Reportingto)){
			
		     Map<String,String>  magMap = getManagerDetails(pjtpojo.getReportingto(),connection);
		     name   = magMap.get("FirstName");
		     EmailId   = magMap.get("email");
			
		}else{
			
			   Map<String,String>  direMap = getDirectorDetails(pjtpojo.getReportingto(),connection);
			   name   = direMap.get("FirstName");
			   EmailId   = direMap.get("email");
		}
			
		String url = new  EmployeeDAOImpl().getServerUrlFromBD(connection);
		EmailContent em = new EmailContent();
		String[] mailIds={EmailId};
		em.setMailids(mailIds);
		em.setSubject("New Project Creation");
	   		
		em.setMessage("Dear "+name+", \n"
				+ "Greetings from TeleIndia. \n\n"
				+ "Approve the Project Details \n\n"
				+ "Project Details \n"
				+ "ProjectRefCode : "+pjtpojo.getProjectRefCode()+" \n"
				+ "ProjectName     : "+pjtpojo.getProjectname()+" \n"
				+ "CreatedBy         : "+pjtpojo.getUserFirstName()+" \n\n"
				+ "For more Details Login URL : " + url + "\n"
				+ "Verify the Project Master \n\n"
				+ "Have a nice day \n\n"
				+ "E-ATTENDANCE PRO  \n"
				+ "-------------------------------------------------------------- \n"
				+ "This is system generated mail,Please do not reply");
		
	
			status = new SendMailWithMultipleAttachment().sendReportToMail(em);
		} catch (IOException ie) {
		
		     ie.printStackTrace();
		}catch (Exception e) {
			
		     e.printStackTrace();
		}
		
		
		return status;
	}

	
	
 public  Map<String, String> getManagerDetails(String managerId,
			Connection connection) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterDaoImpl: getManagerDetails : Starting");
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,String> managerMap= new HashMap<String, String>();
		try {
			
			ps = connection.prepareStatement(ProjectDetails.GET_SINGLE_MANAGER);
			ps.setString(1, managerId);
			
			rs = ps.executeQuery();

				while(rs.next()){
					managerMap.put("FirstName", rs.getString("FirstName"));
					managerMap.put("email", rs.getString("email"));
					
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {

					rs.close();
				}
				if (ps != null && (!ps.isClosed())) {

					ps.close();
				}
				

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterDaoImpl: getManagerDetails : Ending");
		
		return managerMap;
 
		
	}

 public  Map<String,String> getDirectorDetails(String direId,Connection connection) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterDaoImpl: getDirectorDetails : Starting");
		
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Map<String,String> directormap= new HashMap<String, String>();
		try {
			
			ps = connection.prepareStatement(ProjectDetails.GET_SINGLE_DIRECTOR);
			ps.setString(1, direId);
			
			rs = ps.executeQuery();

				while(rs.next()){
					directormap.put("FirstName", rs.getString("First_Name"));
					directormap.put("email", rs.getString("Username"));
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (rs != null && (!rs.isClosed())) {

					rs.close();
				}
				if (ps != null && (!ps.isClosed())) {

					ps.close();
				}
				

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterDaoImpl: getDirectorDetails : Ending");
		
		return directormap;
	}
 
 
   public String approvedProject(String projectcode, String approvedby) {
	   logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterDaoImpl: getDirectorDetails : Starting");
		
		PreparedStatement ps = null;
		Connection connection=null;
		int count=0;
		String flag="false";
		try {
			
			connection=getConnection();
			
			ps = connection.prepareStatement(ProjectDetails.UPDATE_PROJECT_STATUS);
			ps.setString(1, approvedby);
			ps.setString(2, MessageConstants.PROJECT_APPROVED);
			ps.setTimestamp(3, HelperClass.getCurrentTimestamp());
			ps.setString(4, projectcode);
			
			count = ps.executeUpdate();
		
			if(count>0){
				
				flag="true";
				
				String status=sendProjectApprovedEmail(projectcode,approvedby,connection);
			
				 if(status=="false"){
					
						flag=MessageConstants.MAIL_NOT_SENT;
						
				}
					
				
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				
				if (ps != null && (!ps.isClosed())) {

					ps.close();
				}
				
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterDaoImpl: getDirectorDetails : Ending");
		
		return flag;
	}
 
 
 
   public String sendProjectApprovedEmail(String projectcode, String approvedby,
		Connection connection) {

	   
	   String status=null;
		String name=null;
		String EmailId=null;
		
		String approvedbyFirstname=null;
		String approvedbyEmailid=null;
		
		try {
			
		String createdby = getCreatedby(projectcode,connection);
		
		String createdbyshort=createdby.substring(0, 3);
		
		if(LoginDetails.MANAGER_ID_TYPE.equalsIgnoreCase(createdbyshort)){
			
		     Map<String,String>  magMap = getManagerDetails(createdby,connection);
		     name   = magMap.get("FirstName");
		     EmailId   = magMap.get("email");
			
		}else if(LoginDetails.ADMIN_ID_TYPE.equalsIgnoreCase(createdbyshort)){
			
			  Map<String,String>  adminMap = getAdminDetails(createdby,connection);
			     name   = adminMap.get("FirstName");
			     EmailId   = adminMap.get("email");
			
		}else{
			
			   Map<String,String>  direMap = getDirectorDetails(createdby,connection);
			   name   = direMap.get("FirstName");
			   EmailId   = direMap.get("email");
		}
		
		
	
		String  approvedbyshort = approvedby.substring(0, 3);
		
		if(LoginDetails.MANAGER_ID_TYPE.equalsIgnoreCase(approvedbyshort)){
			
		     Map<String,String>  magMap = getManagerDetails(approvedby,connection);
		     approvedbyFirstname   = magMap.get("FirstName");
		     approvedbyEmailid   = magMap.get("email");
			
		}else{
			
			   Map<String,String>  direMap = getDirectorDetails(approvedby,connection);
			   approvedbyFirstname   = direMap.get("FirstName");
			   approvedbyEmailid   = direMap.get("email");
		}
		
		ProjectMasterVo  projectvo = getProjectDetails(projectcode);
	
		String url = new  EmployeeDAOImpl().getServerUrlFromBD(connection);
		EmailContent em = new EmailContent();
		String[] mailIds={EmailId};
		em.setMailids(mailIds);
		em.setSubject("Project Approval");
	   		
		em.setMessage("Dear "+name+", \n"
				+ "Greetings from TeleIndia. \n\n"
				+ "Project is Approved \n\n"
				+ "Project Details \n"
				+ "ProjectRefCode : "+projectvo.getProjectRefCode()+" \n"
				+ "ProjectName     : "+projectvo.getProjectname()+" \n"
				+ "ApprovedBy      : "+approvedbyFirstname+" \n\n"
				+ "For more Details Login URL : " + url + "\n"
				+ "Verify the Project Master \n\n"
				+ "Have a nice day \n\n"
				+ "E-ATTENDANCE PRO  \n"
				+ "-------------------------------------------------------------- \n"
				+ "This is system generated mail,Please do not reply");
		
	
			status = new SendMailWithMultipleAttachment().sendReportToMail(em);
		} catch (IOException ie) {
		
		     ie.printStackTrace();
		}catch (Exception e) {
			
		     e.printStackTrace();
		}
		
		
		return status;
	   
	   
	
}


public  ProjectMasterVo getProjectDetails(String projectcode) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getProjectDetails : Starting");
		
		PreparedStatement ps_projectget = null;
		ResultSet rs_projectget = null;
		Connection connection = null;
	
		ProjectMasterVo pjtvo=new ProjectMasterVo();
		try {
			connection = getConnection();
			
			ps_projectget = connection.prepareStatement(ProjectDetails.GET_SINGLE_PROJECT);
			ps_projectget.setString(1, projectcode);
			
			rs_projectget = ps_projectget.executeQuery();

			
				while(rs_projectget.next()){
					
					pjtvo.setProjectname(rs_projectget.getString("Project_Name"));
					pjtvo.setProjectcode(rs_projectget.getString("ProjectCode"));
					pjtvo.setProjectlocation(rs_projectget.getString("Location"));
					pjtvo.setClientname(rs_projectget.getString("ClientName"));
					pjtvo.setProjecttype(rs_projectget.getString("ProjectType"));
					pjtvo.setEndcustomer(rs_projectget.getString("EndCustomer"));
					pjtvo.setProjectHighLevelActivity(rs_projectget.getString("projectHighLevelActivity"));
					pjtvo.setForFuturExpan(rs_projectget.getString("forFuturExpan"));
					pjtvo.setProjectActivityCat(rs_projectget.getString("projectActivityCat"));
					pjtvo.setLinkfinancialyear(rs_projectget.getString("linkfinancialyear"));
					pjtvo.setProjectRefCode(rs_projectget.getString("ProjectRefCode"));
					pjtvo.setReportingto(rs_projectget.getString("ReportingTo"));
					pjtvo.setProjectstatus(rs_projectget.getString("ProjectStatus"));
					pjtvo.setPonumber(rs_projectget.getString("PoNumber"));
			
					
				}

		 
				
				
				
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (ps_projectget != null && (!ps_projectget.isClosed())) {

					ps_projectget.close();
				}
				if (rs_projectget != null && (!rs_projectget.isClosed())) {

					rs_projectget.close();
				}
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getProjectDetails : Ending");
		
		return pjtvo;

}


public Map<String,String> getAdminDetails(String adminId,	Connection connection) {
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterDaoImpl: getAdminDetails : Starting");
	
	
	PreparedStatement ps = null;
	ResultSet rs = null;
	Map<String,String> adminrmap= new HashMap<String, String>();
	try {
		
		ps = connection.prepareStatement(ProjectDetails.GET_SINGLE_ADMIN);
		ps.setString(1, adminId);
		
		rs = ps.executeQuery();

			while(rs.next()){
				adminrmap.put("FirstName", rs.getString("First_Name"));
				adminrmap.put("email", rs.getString("username"));
			}


	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			if (rs != null && (!rs.isClosed())) {

				rs.close();
			}
			if (ps != null && (!ps.isClosed())) {

				ps.close();
			}
			

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterDaoImpl: getAdminDetails : Ending");
	
	return adminrmap;
}


public  String getCreatedby(String projectcode, Connection connection) {
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterDaoImpl: getCreatedby : Starting");
	
	
	PreparedStatement ps = null;
	ResultSet rs = null;
    String createdby=null;
	try {
		
		ps = connection.prepareStatement(ProjectDetails.GET_CREATED_BY);
		ps.setString(1, projectcode);
		
		rs = ps.executeQuery();

			while(rs.next()){
				createdby =  rs.getString("CreatedBy");
			}


	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			if (rs != null && (!rs.isClosed())) {

				rs.close();
			}
			if (ps != null && (!ps.isClosed())) {

				ps.close();
			}
			

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterDaoImpl: getCreatedby : Ending");
	
	return createdby;
}


public String getName(String Id,Connection connection) {
	   
	   logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterDaoImpl: getName : Starting");
		
		PreparedStatement ps = null;
		ResultSet rs_user=null;
		String name="";
		try {
			
			
			 PreparedStatement getUser = null;
			 
			 String previlige="";
			 
				
		if(Id!=null){
			 
			 if(Id.toString().trim().substring(0, 3).equalsIgnoreCase("MAN"))
				{
					
					getUser = connection.prepareStatement(" SELECT First_Name,bioid FROM hrms_employee WHERE EMPID = ( SELECT EMPID FROM hrms_manager WHERE ManagerCode = ?)");
					getUser.setString(1,Id);
					
					previlige="Manager";
					
				}else if(Id.toString().trim().substring(0, 3).equalsIgnoreCase("DIR")){
					
					getUser = connection.prepareStatement(" SELECT First_Name,bioid FROM hrms_employee WHERE EMPID = ( SELECT EMPID FROM hrms_director WHERE DirectorCode = ?)");
					getUser.setString(1,Id);
					
					previlige="Director";
				}else{
					
					getUser = connection.prepareStatement("SELECT First_Name,bioid FROM hrms_employee WHERE EMPID = ( SELECT empId FROM hrms_user WHERE userCode = ?)");
					getUser.setString(1, Id);
					
					previlige="Admin";
				}
				
			    rs_user = getUser.executeQuery();
			   
			   while (rs_user.next()) {
				
				  name = rs_user.getString(1)+" - "+rs_user.getString(2)+" - "+previlige; 
				   
				   
			    }
			   
		}
			   

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				
				
				if (rs_user != null && (!rs_user.isClosed())) {

					rs_user.close();
				}
				
				
				if (ps != null && (!ps.isClosed())) {

					ps.close();
				}
				
				

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterDaoImpl: getName : Ending");
		
		return name;
	}
 
 
 
 

public ArrayList<ProjectMasterVo> getProjectSearchDetails(String projectId,String userid) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ProjectMasterDaoImpl: getProjectSearchDetails : Starting");
	
	
	PreparedStatement ps_projectget = null;
	ResultSet rs_projectget = null;
	Connection connection = null;
	ArrayList<ProjectMasterVo> pjt_list=new ArrayList<ProjectMasterVo>();

	try {
		connection = getConnection();
		
			
		 if(userid.toString().trim().substring(0, 3).equalsIgnoreCase("MAN")){
				
			 ps_projectget = connection.prepareStatement(ProjectDetails.GET_MANG_SEARCH_PROJECT); 
			
			 ps_projectget.setString(1, userid);
			 ps_projectget.setString(2, userid);   
			 ps_projectget.setString(3, "%"+projectId+"%");
			 ps_projectget.setString(4, "%"+projectId+"%");
			 ps_projectget.setString(5, "%"+projectId+"%");
			 ps_projectget.setString(6, "%"+projectId+"%");
			 
		 }else{
			 
			  ps_projectget = connection.prepareStatement(ProjectDetails.GET_SEARCH_PROJECT_DETAILS);
			   ps_projectget.setString(1, "%"+projectId+"%");
			   ps_projectget.setString(2, "%"+ projectId+"%");
			   ps_projectget.setString(3, "%"+projectId+"%");
				 ps_projectget.setString(4, "%"+projectId+"%");
				 
		 }
		
	 
	
	   
		rs_projectget = ps_projectget.executeQuery();
			while(rs_projectget.next()){
				
				ProjectMasterVo pjtvo=new ProjectMasterVo();
		
				pjtvo.setProjectname(rs_projectget.getString("Project_Name"));
				pjtvo.setProjectcode(rs_projectget.getString("ProjectCode"));
				pjtvo.setProjectlocation(rs_projectget.getString("Location"));
				pjtvo.setProjectRefCode(rs_projectget.getString("ProjectRefCode"));
				pjtvo.setProjectstatus(rs_projectget.getString("ProjectStatus"));
				pjtvo.setReportingto(rs_projectget.getString("ReportingTo"));
				pjtvo.setUserId(userid);
			    pjtvo.setCreatedby(getName(rs_projectget.getString("CreatedBy"), connection));
				pjtvo.setApprovedby(getName(rs_projectget.getString("ApprovedBy"),connection));
				pjtvo.setClosedby(getName(rs_projectget.getString("ClosedBy"),connection));				
				pjtvo.setPonumber(rs_projectget.getString("PoNumber"));
				
					pjt_list.add(pjtvo);
				
			}


	} catch (SQLException sqle) {
		sqle.printStackTrace();
		logger.error(sqle.getMessage(),sqle);
	} catch (Exception e1) {
		e1.printStackTrace();
		logger.error(e1.getMessage(),e1);
	} finally {
		try {

			if (ps_projectget != null && (!ps_projectget.isClosed())) {

				ps_projectget.close();
			}
			if (rs_projectget != null && (!rs_projectget.isClosed())) {

				rs_projectget.close();
			}
			if (connection != null && (!connection.isClosed())) {

				connection.close();
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}

	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ProjectMasterDaoImpl: getProjectSearchDetails : Ending");
	
	return pjt_list;
}
 
 

public String rejectedProject(String projectcode, String rejectedby) {
	
	    logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterDaoImpl: rejectedProject : Starting");
		
		PreparedStatement ps = null;
		Connection connection=null;
		int count=0;
		String flag="false";
		try {
			
			connection=getConnection();
			
			ps = connection.prepareStatement(ProjectDetails.UPDATE_PROJECT_STATUS);
			ps.setString(1, rejectedby);
			ps.setString(2, MessageConstants.PROJECT_REJECT);
			ps.setTimestamp(3, HelperClass.getCurrentTimestamp());
			ps.setString(4, projectcode);
			
			count = ps.executeUpdate();
		
			if(count>0){
				
				flag="true";
				
				String status=sendProjectRejectEmail(projectcode,rejectedby,connection);
			
				 if(status=="false"){
					
						flag=MessageConstants.MAIL_NOT_SENT;
						
				}
					
				
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				
				if (ps != null && (!ps.isClosed())) {

					ps.close();
				}
				
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ProjectMasterDaoImpl: rejectedProject : Ending");
		
		return flag;
} 
 
 
 
  public  String sendProjectRejectEmail(String projectcode, String rejectedby,Connection connection) {
	
	   
	   String status=null;
		String name=null;
		String EmailId=null;
		
		String rejectedbyFirstname=null;
		String  rejectedbyEmailid=null;
		
		try {
			
		String createdby = getCreatedby(projectcode,connection);
		
		String createdbyshort=createdby.substring(0, 3);
		
		if(LoginDetails.MANAGER_ID_TYPE.equalsIgnoreCase(createdbyshort)){
			
		     Map<String,String>  magMap = getManagerDetails(createdby,connection);
		     name   = magMap.get("FirstName");
		     EmailId   = magMap.get("email");
			
		}else if(LoginDetails.ADMIN_ID_TYPE.equalsIgnoreCase(createdbyshort)){
			
			  Map<String,String>  adminMap = getAdminDetails(createdby,connection);
			     name   = adminMap.get("FirstName");
			     EmailId   = adminMap.get("email");
			
		}else{
			
			   Map<String,String>  direMap = getDirectorDetails(createdby,connection);
			   name   = direMap.get("FirstName");
			   EmailId   = direMap.get("email");
		}
		
		
	
		String  rejectedbyshort = rejectedby.substring(0, 3);
		
		if(LoginDetails.MANAGER_ID_TYPE.equalsIgnoreCase(rejectedbyshort)){
			
		     Map<String,String>  magMap = getManagerDetails(rejectedby,connection);
		     rejectedbyFirstname   = magMap.get("FirstName");
		     rejectedbyEmailid   = magMap.get("email");
			
		}else{
			
			   Map<String,String>  direMap = getDirectorDetails(rejectedby,connection);
			   rejectedbyFirstname   = direMap.get("FirstName");
			   rejectedbyEmailid   = direMap.get("email");
		}
		
		ProjectMasterVo  projectvo = getProjectDetails(projectcode);
	
		String url = new  EmployeeDAOImpl().getServerUrlFromBD(connection);
		EmailContent em = new EmailContent();
		String[] mailIds={EmailId};
		em.setMailids(mailIds);
		em.setSubject("Project Reject");
	   		
		em.setMessage("Dear "+name+", \n"
				+ "Greetings from TeleIndia. \n\n"
				+ "Project is Rejected \n\n"
				+ "Project Details \n"
				+ "ProjectRefCode : "+projectvo.getProjectRefCode()+" \n"
				+ "ProjectName     : "+projectvo.getProjectname()+" \n"
				+ "RejectedBy       : "+rejectedbyFirstname+" \n\n"
				+ "For more Details Login URL : " + url + "\n"
				+ "Verify the Project Master \n\n"
				+ "Have a nice day \n\n"
				+ "E-ATTENDANCE PRO  \n"
				+ "-------------------------------------------------------------- \n"
				+ "This is system generated mail,Please do not reply");
		
	
			status = new SendMailWithMultipleAttachment().sendReportToMail(em);
		} catch (IOException ie) {
		
		     ie.printStackTrace();
		}catch (Exception e) {
			
		     e.printStackTrace();
		}
		
		
		return status;
	   
	   
}
  
  
  public  ArrayList<ProjectMasterVo> getAllProjectsByDir(String empId,String dirId ){

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getAllProjectsByDir : Starting");
		
		PreparedStatement ps_projectget = null;
		ResultSet rs_projectget = null;
		Connection connection = null;
		ArrayList<ProjectMasterVo> pjt_list=new ArrayList<ProjectMasterVo>();

		try {
			connection = getConnection();
			
			if(empId.equalsIgnoreCase("all")){
			ps_projectget = connection.prepareStatement(ProjectDetails.GET_PROJECTBY_DIR);
			ps_projectget.setString(1, dirId);
			
			}else{
				
				ps_projectget = connection.prepareStatement(ProjectDetails.GET_PROJECTBY_EMP);
				ps_projectget.setString(1, empId);
			}
			
			
			rs_projectget = ps_projectget.executeQuery();

				while(rs_projectget.next()){
					
					ProjectMasterVo pjtvo=new ProjectMasterVo();
					
					pjtvo.setProjectname(rs_projectget.getString("ProjectRefCode"));
					pjtvo.setProjectcode(rs_projectget.getString("ProjectCode"));
					pjtvo.setProjectRefCode(rs_projectget.getString("ProjectRefCode"));
					
					
					pjt_list.add(pjtvo);
					
				}
			


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (ps_projectget != null && (!ps_projectget.isClosed())) {

					ps_projectget.close();
				}
				if (rs_projectget != null && (!rs_projectget.isClosed())) {

					rs_projectget.close();
				}
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getAllProjectsByDir : Ending");
		
		return pjt_list;

	}




 public ArrayList<ProjectMasterVo> getdownloadAllProjectsDetails(String usertype, String userCode) {

	 logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getdownloadAllProjectsDetails : Starting");
		
		PreparedStatement ps_projectget = null;
		ResultSet rs_projectget = null;
		Connection connection = null;
		ArrayList<ProjectMasterVo> pjt_list=new ArrayList<ProjectMasterVo>();
		int count=0;

		try {
			connection = getConnection();
			
			
			
			if(userCode.toString().trim().substring(0, 3).equalsIgnoreCase("MAN"))
			{
			   ps_projectget = connection.prepareStatement(ProjectDetails.GET_ALL_PROJECT_BYUSER_MAN);
			   ps_projectget.setString(1, userCode);
			   ps_projectget.setString(2, userCode);
				
			}else{
				
			   ps_projectget = connection.prepareStatement(ProjectDetails.GET_ALL_PROJECT);
			
			}
			
			rs_projectget = ps_projectget.executeQuery();

				while(rs_projectget.next()){
					count++;
					ProjectMasterVo pjtvo=new ProjectMasterVo();
					
					pjtvo.setSno(count);
					pjtvo.setProjectname(rs_projectget.getString("Project_Name"));
					pjtvo.setProjectcode(rs_projectget.getString("ProjectCode"));
					pjtvo.setProjectlocation(rs_projectget.getString("Location"));
					pjtvo.setProjectRefCode(rs_projectget.getString("ProjectRefCode"));
					pjtvo.setProjectstatus(rs_projectget.getString("ProjectStatus"));
					pjtvo.setReportingto(rs_projectget.getString("ReportingTo"));
					pjtvo.setCreatedby(getName(rs_projectget.getString("CreatedBy"),connection));
					
					if(rs_projectget.getString("ApprovedBy")!=null){
					    pjtvo.setApprovedby(getName(rs_projectget.getString("ApprovedBy"),connection));
					}else{
						pjtvo.setApprovedby("-");
					}
					
					if(rs_projectget.getString("ClosedBy")!=null){
					   pjtvo.setClosedby(getName(rs_projectget.getString("ClosedBy"),connection));
					}else{
						pjtvo.setClosedby("-");
					}
					
					if(rs_projectget.getString("PoNumber")!=null){
						pjtvo.setPonumber(rs_projectget.getString("PoNumber"));
					}else{
					    pjtvo.setPonumber("-");
					}
					
					pjtvo.setClientname(rs_projectget.getString("ClientName"));
					pjtvo.setProjecttype(rs_projectget.getString("ProjectType"));
					pjtvo.setEndcustomer(rs_projectget.getString("EndCustomer"));
					pjtvo.setProjectHighLevelActivity(rs_projectget.getString("projectHighLevelActivity"));
					pjtvo.setForFuturExpan(rs_projectget.getString("forFuturExpan"));
					pjtvo.setProjectActivityCat(rs_projectget.getString("projectActivityCat"));
					pjtvo.setLinkfinancialyear(rs_projectget.getString("linkfinancialyear"));
					pjtvo.setCreatedate(rs_projectget.getTimestamp("CreateTime"));
					
					
					System.out.println();
					
					if(rs_projectget.getString("ApprovedTime")!=null){
						
						String approvededate =rs_projectget.getString("ApprovedTime").substring(0, 10);
						pjtvo.setApproveddate(approvededate);		
					}else{
					
						pjtvo.setApproveddate("-");
					}
					
					if(rs_projectget.getString("ClosedTime")!=null){
					
						String closeddate =rs_projectget.getString("ClosedTime").substring(0, 10);
						pjtvo.setCloseddate(closeddate);
					
					}else{
						
						pjtvo.setCloseddate("-");
					}
					 
					 
					pjt_list.add(pjtvo);
					
				}


		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(),sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		} finally {
			try {

				if (ps_projectget != null && (!ps_projectget.isClosed())) {

					ps_projectget.close();
				}
				if (rs_projectget != null && (!rs_projectget.isClosed())) {

					rs_projectget.close();
				}
				if (connection != null && (!connection.isClosed())) {

					connection.close();
				}

			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		JSONArray array= new JSONArray(pjt_list);
		System.out.println(array);
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ProjectMasterDaoImpl: getdownloadAllProjectsDetails : Ending");
		
		return pjt_list;

	}
	







public static void main(String[] args) throws SQLException {
	
	 
	 new ProjectMasterDaoImpl().getdownloadAllProjectsDetails("","DIR1"); 
	 
	 
//	 ArrayList<ProjectMasterVo>  Alist = new ProjectMasterDaoImpl().getAllProjects();
	 
	 
	 
}






}
