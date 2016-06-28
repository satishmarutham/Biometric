package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.transaction.Transaction;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.AllowancesClaimByManagerDao;
import com.centris.DAO.DBService;
import com.centris.POJO.AllowancesClaimByManagerPOJO;
import com.centris.VO.AllowancesBioIdSearch;
import com.centris.VO.AllowancesClaimByManagerVO;
import com.centris.VO.EmployeeDashboardVO;
import com.centris.util.AllowanceClaimByManager;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AllowancesClaimByManagerSqlUtil;
import com.centris.util.SQLUtils.EmployeeDashboard;
import com.centris.util.SQLUtils.TravelBookedDetailsSqlUtil;
import com.centris.util.constants.MessageConstants;

public class AllowancesClaimByManagerDaoImpl extends DBService implements AllowancesClaimByManagerDao {

	private static Logger logger = Logger.getLogger(AllowancesClaimByManagerDaoImpl.class);
	
	public AllowancesClaimByManagerVO getEmployeeDetails(String bioId,String selecteddate,String userCode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl :getEmployeeDetails starting");
	
		Connection connection=null;
		PreparedStatement pstmt_allowance = null;
		ResultSet rs_allowance =null;
		int count=0;
		
		AllowancesClaimByManagerVO allowancesClaimByManagerVO=new AllowancesClaimByManagerVO();
		
		try {
			
			connection=getConnection();
			//checking allowances if already claimed
			pstmt_allowance = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.CHECK_BIOID);
			pstmt_allowance.setString(1,bioId);
			pstmt_allowance.setDate(2,HelperClass.getSqlDate(selecteddate));
			
			rs_allowance = pstmt_allowance.executeQuery();
			
			
			while(rs_allowance.next()){
				count++;
				if(count>0){
					
					allowancesClaimByManagerVO.setAmount(rs_allowance.getDouble("Amount"));
					allowancesClaimByManagerVO.setEmpid(rs_allowance.getString("EMPID"));
					allowancesClaimByManagerVO.setEmpname(rs_allowance.getString("First_Name"));
					allowancesClaimByManagerVO.setHdfcacno(rs_allowance.getString("HDFC_AC"));
					allowancesClaimByManagerVO.setNoofdayormonthallowance(rs_allowance.getInt("No_Of_days_Month"));
					allowancesClaimByManagerVO.setSingleteamgh(rs_allowance.getString("Single_team_GH"));
					allowancesClaimByManagerVO.setDatype(rs_allowance.getString("DAType"));
					allowancesClaimByManagerVO.setProjectmanagercode(rs_allowance.getString("Project_Manager"));
							
					 allowancesClaimByManagerVO.setProjectmanagername(getManagerName(rs_allowance.getString("Project_Manager"),connection));
					
					allowancesClaimByManagerVO.setClientcode(rs_allowance.getString("ClientCode"));
					allowancesClaimByManagerVO.setProject(rs_allowance.getString("ProjectRefCode"));
					allowancesClaimByManagerVO.setTeamlead(rs_allowance.getString("Team_Lead"));
					allowancesClaimByManagerVO.setLocation(rs_allowance.getString("Location"));
					if(rs_allowance.getString("Remarks")!=null){
						allowancesClaimByManagerVO.setRemarks(rs_allowance.getString("Remarks"));
					}	
						
			        if(userCode.equalsIgnoreCase(rs_allowance.getString("Posted_By"))){
							allowancesClaimByManagerVO.setFlag(true);
			    	}else{
					    allowancesClaimByManagerVO.setFlag(false);
				  }
	
			        allowancesClaimByManagerVO.setProjectcode(rs_allowance.getString("ProjectCode"));
			        
					
			        allowancesClaimByManagerVO.setPostedBy(getManagerName(rs_allowance.getString("Posted_By"),connection));
				
					
					
					
				}
			
			}
			
			
			
             //otherwise get the Employee Details
		    if(count==0){
		    	
		    	allowancesClaimByManagerVO=getEmpInfoInAllownaces(bioId,connection);
		    	
		    	  if(allowancesClaimByManagerVO.getTeamlead()==null){
		    	
		    	        	allowancesClaimByManagerVO=getEmployeeInfo(bioId,connection);
		    	}

			}
				
					

		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(),sqle);
			sqle.printStackTrace();
	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		} finally {

			try {

				if (rs_allowance != null && (!rs_allowance.isClosed())) {

					rs_allowance.close();
				}
				if (pstmt_allowance != null && (!pstmt_allowance.isClosed())) {

					pstmt_allowance.close();
				}
				if(connection != null && (!connection.isClosed())){
					
					connection.close();
				}

			} catch (SQLException e) {
               e.printStackTrace();
				logger.error(e.getMessage(),e);
			} catch (Exception e1) {
				 e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl  : getEmployeeDetails : Ending");

			
		return allowancesClaimByManagerVO;
	}

	public AllowancesClaimByManagerVO getEmpInfoInAllownaces(String bioId,
			Connection connection) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl :getEmpInfoInAllownaces starting");
		
		PreparedStatement pstmt_allowance1 = null;
		ResultSet rs_allowance =null;
		
	  AllowancesClaimByManagerVO allowancesClaimByManagerVO=new AllowancesClaimByManagerVO();
		
		try {
		
			pstmt_allowance1 = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_EMPLOYEE_DETAILS_FORM_ALLOWANCES);
			pstmt_allowance1.setString(1,bioId);
			
			rs_allowance = pstmt_allowance1.executeQuery();
			while(rs_allowance.next()){
						
				allowancesClaimByManagerVO.setEmpid(rs_allowance.getString("EMPID"));
				allowancesClaimByManagerVO.setEmpname(rs_allowance.getString("First_Name"));
				allowancesClaimByManagerVO.setHdfcacno(rs_allowance.getString("HDFC_AC"));
				
				allowancesClaimByManagerVO.setProjectmanagercode(rs_allowance.getString("Project_Manager"));
						
				 allowancesClaimByManagerVO.setProjectmanagername(getManagerName(rs_allowance.getString("Project_Manager"),connection));
				
				allowancesClaimByManagerVO.setClientcode(rs_allowance.getString("ClientCode"));
				allowancesClaimByManagerVO.setProject(rs_allowance.getString("ProjectRefCode"));
				allowancesClaimByManagerVO.setTeamlead(rs_allowance.getString("Team_Lead"));
				allowancesClaimByManagerVO.setLocation(rs_allowance.getString("Location"));
				if(rs_allowance.getString("Remarks")!=null){
					allowancesClaimByManagerVO.setRemarks(rs_allowance.getString("Remarks"));
				}	
					
		        allowancesClaimByManagerVO.setProjectcode(rs_allowance.getString("ProjectCode"));
					
		  
			
				
				
					
					
			}
			
			
			
		
		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(),sqle);
			sqle.printStackTrace();
	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		} finally {

			try {

				if (rs_allowance != null && (!rs_allowance.isClosed())) {

					rs_allowance.close();
				}
				if (pstmt_allowance1 != null && (!pstmt_allowance1.isClosed())) {

					pstmt_allowance1.close();
				}
				

			} catch (SQLException e) {
               e.printStackTrace();
				logger.error(e.getMessage(),e);
			} catch (Exception e1) {
				 e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl  : getEmpInfoInAllownaces : Ending");
		
		return allowancesClaimByManagerVO;
	}

	public String getManagerName(String postedby, Connection connection) {
		
		PreparedStatement postedmanagerpstmt = null;
		ResultSet postedmanagerrs =null;
		String managername=null;
		try{
		
    		postedmanagerpstmt=connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_POSTED_MANAGER);
			postedmanagerpstmt.setString(1,postedby);
	    	postedmanagerrs=postedmanagerpstmt.executeQuery();
	    	
	    	
			while(postedmanagerrs.next()){
				managername=postedmanagerrs.getString("First_Name");
			}
	} catch (SQLException sqle) {
		logger.error(sqle.getMessage(),sqle);
		sqle.printStackTrace();

	} catch (Exception e) {
		logger.error(e.getMessage(),e);
		e.printStackTrace();
	} finally {

		try {

			if (postedmanagerrs != null && (!postedmanagerrs.isClosed())) {

				postedmanagerrs.close();
			}
			if (postedmanagerpstmt != null && (!postedmanagerpstmt.isClosed())) {

				postedmanagerpstmt.close();
			}
			
		} catch (SQLException e) {
           e.printStackTrace();
			logger.error(e.getMessage(),e);
		} catch (Exception e1) {
			 e1.printStackTrace();
			logger.error(e1.getMessage(),e1);
		}
	}
		return managername;
	}

	public AllowancesClaimByManagerVO getEmployeeInfo(String bioId,
			Connection connection) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl :getEmployeeInfo starting");
		
		PreparedStatement pstmt_allowance1 = null;
		ResultSet rs_allowance1 =null;
		
	  AllowancesClaimByManagerVO allowancesClaimByManagerVO=new AllowancesClaimByManagerVO();
		
		try {
		
		
			pstmt_allowance1 = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_EMPLOYEE_DETAILS_BY_BIOID);
			pstmt_allowance1.setString(1,bioId);
			
			rs_allowance1 = pstmt_allowance1.executeQuery();
			while(rs_allowance1.next()){
						
					allowancesClaimByManagerVO.setEmpid(rs_allowance1.getString("EMPID"));
					allowancesClaimByManagerVO.setEmpname(rs_allowance1.getString("empname"));
					allowancesClaimByManagerVO.setHdfcacno(rs_allowance1.getString("HDFC_AC"));
					allowancesClaimByManagerVO.setProjectmanagercode(rs_allowance1.getString("ManagerCode"));
					allowancesClaimByManagerVO.setProjectmanagername(rs_allowance1.getString("managername"));
					
					
			}
			
			
			
		
		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(),sqle);
			sqle.printStackTrace();
	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		} finally {

			try {

				if (rs_allowance1 != null && (!rs_allowance1.isClosed())) {

					rs_allowance1.close();
				}
				if (pstmt_allowance1 != null && (!pstmt_allowance1.isClosed())) {

					pstmt_allowance1.close();
				}
				

			} catch (SQLException e) {
               e.printStackTrace();
				logger.error(e.getMessage(),e);
			} catch (Exception e1) {
				 e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl  : getEmployeeInfo : Ending");
		
		return allowancesClaimByManagerVO;
	}

	public String saveAllowances(ArrayList<AllowancesClaimByManagerPOJO> allowanceslist) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl :saveAllowances starting");
		
		Connection connection=null;
		PreparedStatement pstmt_allowance = null;
		int count=0;
		String posted_by=null;
		String status=null;
		ArrayList<AllowancesClaimByManagerPOJO> copylist =new ArrayList<AllowancesClaimByManagerPOJO>();
		copylist.addAll(allowanceslist);

		try {
			
			connection=getConnection();
		
			for (AllowancesClaimByManagerPOJO allowancesClaimByManagerPOJO : allowanceslist) {
					
				pstmt_allowance = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.SAVE_DAILY_ALLOWANCES);
				
				pstmt_allowance.setString(1,new IDGenerator().getPrimaryKeyID("hrms_employee_daily_allowance"));
				pstmt_allowance.setString(2,allowancesClaimByManagerPOJO.getBioid());
				pstmt_allowance.setString(3,allowancesClaimByManagerPOJO.getEmpid());
				pstmt_allowance.setDouble(4,allowancesClaimByManagerPOJO.getAmount());
				pstmt_allowance.setInt(5,Integer.parseInt(allowancesClaimByManagerPOJO.getNoofdayormonthallowance()));
				pstmt_allowance.setString(6,allowancesClaimByManagerPOJO.getSingleteamgh());
				pstmt_allowance.setString(7,allowancesClaimByManagerPOJO.getDatype());
				pstmt_allowance.setString(8,allowancesClaimByManagerPOJO.getProjectmanagercode());
				pstmt_allowance.setString(9,allowancesClaimByManagerPOJO.getClientcode());
				pstmt_allowance.setString(10,allowancesClaimByManagerPOJO.getProjectcode());
				pstmt_allowance.setString(11,allowancesClaimByManagerPOJO.getProject());
				pstmt_allowance.setString(12,allowancesClaimByManagerPOJO.getTeamlead());
				pstmt_allowance.setString(13,allowancesClaimByManagerPOJO.getLocation());
				pstmt_allowance.setString(14,allowancesClaimByManagerPOJO.getRemarks());
				pstmt_allowance.setString(15,allowancesClaimByManagerPOJO.getSelecteddate());
			
				posted_by=allowancesClaimByManagerPOJO.getPostedby();
			
				pstmt_allowance.setString(16,allowancesClaimByManagerPOJO.getPostedby());
				pstmt_allowance.setString(17,allowancesClaimByManagerPOJO.getIsconflict());
			
				count = pstmt_allowance.executeUpdate();
				
	}
			if(count>0){
				
				Map<String,String> reportingDirector= new  AllowancesClaimByManagerDaoImpl().getDirectorDeatils(posted_by,connection);
		    	String direusername=reportingDirector.get("Username");
		    	String direname=reportingDirector.get("First_Name");
				   
			    	String success=sendEmployeeAllowancesClaimEmail(direusername,direname,posted_by,connection,copylist);
			
			    	if(MessageConstants.TRUE.equalsIgnoreCase(success)){
			    		
			    		status=MessageConstants.TRUE;
			    	
			    	}else{
			    		
			    		status=MessageConstants.MAIL_NOT_SENT;
			    	}
			    	
			    
			
				}else{
					
					status=MessageConstants.FALSE;
				}
		
			
		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(),sqle);
		
				status=MessageConstants.FALSE;
		        sqle.printStackTrace();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		
				status=MessageConstants.FALSE;
				e.printStackTrace();
		
		} finally {

			try {

				if (pstmt_allowance != null && (!pstmt_allowance.isClosed())) {

					pstmt_allowance.close();
				}
				if(connection != null && (!connection.isClosed())){
					
					connection.close();
				}

			} catch (SQLException e) {
               e.printStackTrace();
				logger.error(e.getMessage(),e);
			} catch (Exception e1) {
				 e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl  : saveAllowances : Ending");

			
		return status;
}

	private String sendEmployeeAllowancesClaimEmail(String direusername,String direname, String posted_by,
			Connection connection, ArrayList<AllowancesClaimByManagerPOJO> copylist) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl :sendEmployeeAllowancesClaimEmail starting");
		
		String status=null;
		
		try{
			 String prefix = "<html><body><table style='border:1px solid gray;margin: 5px 0 0 0;width: 100%;font-family: Segoe UI Semibold;font-size: 12px;' cellpadding='0' cellspacing='0'>\n";
			
			 final	StringBuilder sb = new StringBuilder(prefix);
			
	          sb.append("<tr style='border:1px solid gray;height;150%;'>");
	          sb.append("<th style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;background: #C8C8C8'>");
	          sb.append("S.No");
	          sb.append("</th>");
	          sb.append("<th style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;background: #C8C8C8'>");
	          sb.append("BioId");
	          sb.append("</th>");
	          sb.append("<th style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;background: #C8C8C8'>");
	          sb.append("EmpName");
	          sb.append("</th>");
	          sb.append("<th style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;background: #C8C8C8'>");
	          sb.append("Amount");
	          sb.append("</th>");
	          sb.append("<th style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;background: #C8C8C8'>");
	          sb.append("ProjectRefCode");
	          sb.append("</th>");
	          sb.append("</tr>\n");
	      
	          int count=0;
	          
	     	 for (int i = 0; i < copylist.size(); i++) {
	     		 
	     		 String empname=getEmployee(copylist.get(i).getEmpid(),connection);
	     		 
	     		count++;
	        		 sb.append("<tr>");
	         
	                    sb.append("<td style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;'>");
	                    sb.append("" +count);
	                    sb.append("</td>");
	             
	                    sb.append("<td style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;'>");
	                    sb.append("" +copylist.get(i).getBioid());
	                    sb.append("</td>");
	                    
	                    sb.append("<td style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;'>");
	                    sb.append("" +empname);
	                    sb.append("</td>");
	                    
	                    sb.append("<td style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;'>");
	                    sb.append("" +copylist.get(i).getAmount());
	                    sb.append("</td>");
	                    
	                    sb.append("<td style='border:1px solid gray;text-align:center;font-family:Segoe UI;font-size:12px;'>");
	                    sb.append("" +copylist.get(i).getProject());
	                    sb.append("</td>");
	                          
	               sb.append("</tr>\n");
		    
		
			}
			  
	     	      sb.append("</table>");
		          sb.append("</body>");
		          sb.append("</html>");  
	      
			
			Map<String,String> managerMap= new EmployeeLeaveRequesDaoImpl().getManagerDetailsById(posted_by,connection);
		
			String url = new  EmployeeDAOImpl().getServerUrlFromBD(connection);
		
			EmailContent em = new EmailContent();
			String postedByName=managerMap.get("FirstName");
							
			String[] mails={direusername};
				
				em.setMailids(mails);
				em.setSubject("Employee Allowances");
				
				em.setMessage("Dear "+direname+", "+"<html><br/></html>"
						+ "Greetings from TeleIndia."+"<html><br/><br/></html>"
						+ "Manager "+postedByName+" Claimed Employee Allowances. "+"<html><br/><br/></html>"
						+ "For more Details Please find the below Table or Login URL : "+ url + "<html><br/></html>"
						+ "Approve the Employee Allowances "+"<html><br/><br/></html>"
						+  sb.toString()+ "<html><br/><br/></html>"
						+ "Have a nice day  "+"<html><br/><br/></html>"
						+ "E-ATTENDANCE PRO "+"<html><br/></html>"
						+ "-------------------------------------------------------------- "+"<html><br/><br/></html>"
						+ "This is system generated mail,Please do not reply " );
				
				em.setContent(sb.toString());
													
				status=new SendMailWithMultipleAttachment().sendReportToMailAllowances(em);
		}
		catch(Exception e){
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
  
      logger.setLevel(Level.DEBUG);
	  JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	  logger.info(JDate.getTimeString(new Date())
			+ " Control in AllowancesClaimByManagerDaoImpl  : sendEmployeeAllowancesClaimEmail : Ending");

	  return status;
	}
	

	public List<AllowancesBioIdSearch> getBioIdBySearch(String searchTerm) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl :getBioIdBySearch starting");

		Connection connection=null;
		PreparedStatement pstmt_allowance = null;
		ResultSet rs_allowance =null;
		List<AllowancesBioIdSearch> searchterms=new ArrayList<AllowancesBioIdSearch>();
		try {
			connection=getConnection();
			pstmt_allowance = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.SEARCH_BIOID_TERM);
			pstmt_allowance.setString(1,searchTerm+"%");
	    	rs_allowance = pstmt_allowance.executeQuery();
	   	    	
			while(rs_allowance.next()){
			
				AllowancesBioIdSearch allowancesBioIdSearch=new AllowancesBioIdSearch();
				allowancesBioIdSearch.setBioid(rs_allowance.getString("BioId").split("-")[1]);
				allowancesBioIdSearch.setBioidlabel(rs_allowance.getString("BioId"));
				
				   searchterms.add(allowancesBioIdSearch);		
			}
		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(),sqle);
			sqle.printStackTrace();
	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		} finally {

			try {

				if (rs_allowance != null && (!rs_allowance.isClosed())) {

					rs_allowance.close();
				}
				if (pstmt_allowance != null && (!pstmt_allowance.isClosed())) {

					pstmt_allowance.close();
				}
				if(connection != null && (!connection.isClosed())){
					
					connection.close();
				}

			} catch (SQLException e) {
               e.printStackTrace();
				logger.error(e.getMessage(),e);
			} catch (Exception e1) {
				 e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl  : getBioIdBySearch : Ending");

	
		return searchterms;
	}

	public String getClient(String projectcode) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl :getClient starting");

		Connection connection=null;
		PreparedStatement pstmt_allowance = null;
		ResultSet rs_allowance =null;
	    String clientcode=null;
		try {
			connection=getConnection();
			pstmt_allowance = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_CLIENT_BY_PROJECT);
			pstmt_allowance.setString(1,projectcode);
	    	rs_allowance = pstmt_allowance.executeQuery();
	    	
			while(rs_allowance.next()){
					clientcode=rs_allowance.getString("ClientName");
			
			}
	

		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(),sqle);
			sqle.printStackTrace();
	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		} finally {

			try {

				if (rs_allowance != null && (!rs_allowance.isClosed())) {

					rs_allowance.close();
				}
				if (pstmt_allowance != null && (!pstmt_allowance.isClosed())) {

					pstmt_allowance.close();
				}
				if(connection != null && (!connection.isClosed())){
					
					connection.close();
				}

			} catch (SQLException e) {
               e.printStackTrace();
				logger.error(e.getMessage(),e);
			} catch (Exception e1) {
				 e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl  : getClient : Ending");
		
		return clientcode;
	}

	public int getAlreadyClaimedCount(String selecteddate, String currentuser) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl :getAlreadyClaimedCount starting");

		Connection connection=null;
		PreparedStatement pstmt_allowance = null;
		ResultSet rs_allowance =null;
	    int claimedcount=0;
		try {
			connection=getConnection();
			pstmt_allowance = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_CLAIMED_ALLOWANCES_BY_MANAGER_COUNT);
			pstmt_allowance.setString(1,currentuser);
			pstmt_allowance.setDate(2,HelperClass.getSqlDate(selecteddate));
	    	rs_allowance = pstmt_allowance.executeQuery();
	    	
			while(rs_allowance.next()){
				
				claimedcount=rs_allowance.getInt(1);
			
			}
	

		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(),sqle);
			sqle.printStackTrace();
	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		} finally {

			try {

				if (rs_allowance != null && (!rs_allowance.isClosed())) {

					rs_allowance.close();
				}
				if (pstmt_allowance != null && (!pstmt_allowance.isClosed())) {

					pstmt_allowance.close();
				}
				if(connection != null && (!connection.isClosed())){
					
					connection.close();
				}

			} catch (SQLException e) {
               e.printStackTrace();
				logger.error(e.getMessage(),e);
			} catch (Exception e1) {
				 e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl  : getAlreadyClaimedCount : Ending");
		
		return claimedcount;
	}

	public ArrayList<AllowancesClaimByManagerVO> getClaimedAllowanceDetails(String selecteddate, String currentuser) {
	
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl :getClaimedAllowanceDetails starting");

		Connection connection=null;
		PreparedStatement pstmt_allowance = null;
		ResultSet rs_allowance =null;
	    
	    ArrayList<AllowancesClaimByManagerVO> claimedallowanceslist=new ArrayList<AllowancesClaimByManagerVO>();
	    
		try {
			connection=getConnection();
			pstmt_allowance = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_CLIMED_ALOOWANCES_BY_MANAGER);
			pstmt_allowance.setString(1,currentuser);
			pstmt_allowance.setDate(2,HelperClass.getSqlDate(selecteddate));
		
			rs_allowance = pstmt_allowance.executeQuery();
	    	
			while(rs_allowance.next()){
			
				AllowancesClaimByManagerVO allowancesVO=new AllowancesClaimByManagerVO();
					
				allowancesVO.setBioid(rs_allowance.getString("BioCode").trim());	
				allowancesVO.setEmpid(rs_allowance.getString("EMPCODE").trim());
				allowancesVO.setEmpname(rs_allowance.getString("First_Name").trim());
				allowancesVO.setAmount(rs_allowance.getDouble("Amount"));
				allowancesVO.setNoofdayormonthallowance(rs_allowance.getInt("No_Of_days_Month"));
				allowancesVO.setSingleteamgh(rs_allowance.getString("Single_team_GH").trim());
				allowancesVO.setDatype(rs_allowance.getString("DAType").trim());
				allowancesVO.setProject(rs_allowance.getString("ProjectRefCode").trim());
				allowancesVO.setTeamlead(rs_allowance.getString("Team_Lead").trim());
				allowancesVO.setLocation(rs_allowance.getString("Location").trim());
				
				if(rs_allowance.getString("Remarks")!=null){
				allowancesVO.setRemarks(rs_allowance.getString("Remarks").trim());
				}
				allowancesVO.setAllowancedate(HelperClass.convertDatabaseToUI(rs_allowance.getDate("Allowance_Date").toString().trim()));
				allowancesVO.setPosteddatetime(rs_allowance.getString("posteddate").trim());
				allowancesVO.setProjectmanagername(rs_allowance.getString("projectmanager").trim());
				allowancesVO.setClientname(rs_allowance.getString("ClientName").trim());
				
				claimedallowanceslist.add(allowancesVO);
			}
			

		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(),sqle);
			sqle.printStackTrace();
	
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		} finally {

			try {

				if (rs_allowance != null && (!rs_allowance.isClosed())) {

					rs_allowance.close();
				}
				if (pstmt_allowance != null && (!pstmt_allowance.isClosed())) {

					pstmt_allowance.close();
				}
				if(connection != null && (!connection.isClosed())){
					
					connection.close();
				}

			} catch (SQLException e) {
               e.printStackTrace();
				logger.error(e.getMessage(),e);
			} catch (Exception e1) {
				 e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in AllowancesClaimByManagerDaoImpl  : getClaimedAllowanceDetails : Ending");
		
		return claimedallowanceslist;
	}

	
public 	Map<String,String> getDirectorDeatils(String posted_by,Connection connection) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AllowancesClaimByManagerDaoImpl :getDirectors Starting");
	
		
		PreparedStatement ps_directors = null;
		ResultSet rs_directors=null;
		Map<String,String> directormap=new HashMap<String, String>();
		try{
			
			ps_directors=connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_DIRECTOR_MAILID);
				ps_directors.setString(1,posted_by);
				rs_directors=ps_directors.executeQuery();
			
				while(rs_directors.next()){
					directormap.put("Username", rs_directors.getString("Username"));
					directormap.put("First_Name", rs_directors.getString("First_Name"));
					
				}
	   
		}catch(SQLException se)	{
			se.printStackTrace();
			logger.error(se);
		}catch(Exception e)	{
			e.printStackTrace();
			logger.error(e);
		}finally{
			try{
				if(rs_directors !=null && (!rs_directors.isClosed()))
				{
					rs_directors.close();
				}
				
				
				if(ps_directors !=null && (!ps_directors.isClosed()))
				{
					ps_directors.close();
				}
				
				
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1);
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in AllowancesClaimByManagerDaoImpl :getDirectors Ending");
		
	
		return directormap;
		
	}

	
	
private String getEmployee(String empcode, Connection connection) {
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in AllowancesClaimByManagerDaoImpl : getEmployee  Starting");

	PreparedStatement ps_employee = null;
	ResultSet rs_employee=null;
	String employee=null;
	
	try{
		ps_employee=connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_EMP_FIRSTNAME);
		ps_employee.setString(1,empcode);
		rs_employee=ps_employee.executeQuery();
		
		while(rs_employee.next()){
		
			if(rs_employee.getString("First_Name")!=null){
				employee=rs_employee.getString("First_Name");
			}
		}
	}catch(SQLException se)	{
		se.printStackTrace();
		logger.error(se);
	}catch(Exception e)	{
		e.printStackTrace();
		logger.error(e);
	}finally{
		try{
			if(rs_employee !=null && (!rs_employee.isClosed()))
			{
				rs_employee.close();
			}
			if(ps_employee !=null && (!ps_employee.isClosed()))
			{
				ps_employee.close();
			}
		
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1);
		}
	}
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in AllowancesClaimByManagerDaoImpl :getEmployee Ending");
	

	return employee;
}
	
	public static void main(String[] args){
		
		Connection connection=null;
		try {
			connection = getConnection();
			AllowancesClaimByManagerVO  allowancesClaimByManagerVO=  new AllowancesClaimByManagerDaoImpl().getEmpInfoInAllownaces("1012", connection);

			System.out.println(allowancesClaimByManagerVO.getTeamlead());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
		
	}


	public ArrayList<AllowancesClaimByManagerVO> getmoreAllowanceDeatails(String startdate, String enddate, String usercode) {
	
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		
		
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		
		
		ArrayList<AllowancesClaimByManagerVO> employeedailyallowances=new ArrayList<AllowancesClaimByManagerVO>();
		int sno=0;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_MORE_DAILY_ALLOWANCES_BY_MANAGER);
			pstmt.setString(1, HelperClass.convertUIToDatabase(startdate));
			pstmt.setString(2, HelperClass.convertUIToDatabase(enddate));
			pstmt.setString(3, usercode);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				AllowancesClaimByManagerVO allowancesVO=new AllowancesClaimByManagerVO();
				sno++;
				allowancesVO.setSno(sno);
				allowancesVO.setEmpname(rs.getString("empname"));	
				allowancesVO.setAllowancedate(HelperClass.convertDatabaseToUI(rs.getString("Allowance_Date")));
				allowancesVO.setAmount(rs.getDouble("Amount"));
			
                if(!(MessageConstants.ALLOWANCES_IS_APPROVED_NO.equalsIgnoreCase(rs.getString("isRejected"))) ){
					
					allowancesVO.setStatus(MessageConstants.IS_REJECT);
				}else{
					
					if(MessageConstants.ALLOWANCES_IS_APPROVED_NO.equalsIgnoreCase(rs.getString("isApprovedByAccounts")))
					{
					   allowancesVO.setStatus(MessageConstants.IS_APPROVED_NO);
					}else{
						allowancesVO.setStatus(MessageConstants.IS_APPROVED_YES);
					}
					
				}

				allowancesVO.setProject(rs.getString("ProjectRefCode"));
				allowancesVO.setPostedBy(rs.getString("postedby"));
				allowancesVO.setNoofdayormonthallowance(rs.getInt("No_Of_days_Month"));
				allowancesVO.setDatype(rs.getString("DAType"));
				allowancesVO.setSingleteamgh(rs.getString("Single_team_GH"));
		
				allowancesVO.setApprovedamount(rs.getDouble("AccountApprovedAmount"));
				allowancesVO.setRemarks(rs.getString("Remarks"));
				allowancesVO.setClientname(rs.getString("ClientName"));
				
				String projectmanager=rs.getString("Project_Manager");
				
				if(projectmanager!=null){
					
					pstmt1=connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_POSTED_MANAGER);
					pstmt1.setString(1, projectmanager);
			    	rs1=pstmt1.executeQuery();
					while(rs1.next()){
						allowancesVO.setProjectmanager(rs1.getString("First_Name"));
					}
				}
				
				
							
				employeedailyallowances.add(allowancesVO);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {
				if (rs1 != null && !rs1.isClosed()) {
					rs1.close();
				}	if (rs != null && !rs.isClosed()) {
					rs.close();
				}	if (pstmt1 != null && !pstmt1.isClosed()) {
					pstmt1.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			}
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardDaoImpl: getmoreAllowanceDeatailsByManagerDao Ending");
		
		
		return employeedailyallowances;
	}
	
	
	
	
}