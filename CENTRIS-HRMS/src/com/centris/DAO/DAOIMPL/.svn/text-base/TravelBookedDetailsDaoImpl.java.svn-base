package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.DAO.TravelBookedDetailsDao;
import com.centris.POJO.TravelBookedDetailsPOJO;
import com.centris.VO.EmployeeSearchInTravelBookedVO;
import com.centris.VO.ProjectMasterVo;
import com.centris.VO.TravelBookedDetailsVo;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AllowancesClaimByManagerSqlUtil;
import com.centris.util.SQLUtils.TravelBookedDetailsSqlUtil;
import com.centris.util.constants.MessageConstants;

public class TravelBookedDetailsDaoImpl extends DBService implements TravelBookedDetailsDao{

	private static Logger logger = Logger.getLogger(TravelBookedDetailsDaoImpl.class);
	
	public ArrayList<EmployeeSearchInTravelBookedVO> getSearchEmployee(
			String searchTerm) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl:getSearchEmployee Starting");
	
		Connection connection = null;
		PreparedStatement ps_searchemployee = null;
		ResultSet rs_searchemployee=null;
		
		 ArrayList<EmployeeSearchInTravelBookedVO> employeesearchList=new  ArrayList<EmployeeSearchInTravelBookedVO>();
		try{
			connection= getConnection();
			ps_searchemployee=connection.prepareStatement(TravelBookedDetailsSqlUtil.GET_SEARCH_EMPLOYEE);
			ps_searchemployee.setString(1,searchTerm+"%");
		
			rs_searchemployee=ps_searchemployee.executeQuery();
			while(rs_searchemployee.next()){
				EmployeeSearchInTravelBookedVO employeeSearchInTravelBookedVO=new EmployeeSearchInTravelBookedVO();
				employeeSearchInTravelBookedVO.setEmployee(rs_searchemployee.getString("employeename"));
				employeeSearchInTravelBookedVO.setEmployeeId(rs_searchemployee.getString("EMPID"));
				employeesearchList.add(employeeSearchInTravelBookedVO);
			}
		}catch(SQLException se)
		{
			logger.error(se);
		}catch(Exception e)
		{
			logger.error(e);
		}finally{
			try{
				if(rs_searchemployee !=null && (!rs_searchemployee.isClosed()))
				{
					rs_searchemployee.close();
				}
				if(ps_searchemployee !=null && (!ps_searchemployee.isClosed()))
				{
					ps_searchemployee.close();
				}
				if(connection !=null && (!connection.isClosed()))
				{
					connection.close();
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
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl:getSearchEmployee Ending");
		
		return employeesearchList;
	}


	public ArrayList<ProjectMasterVo> getAllprojects() {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl:getSearchEmployee Starting");
	
		Connection connection = null;
		PreparedStatement ps_project = null;
		ResultSet rs_project=null;
		
		ArrayList<ProjectMasterVo> projectlist=new  ArrayList<ProjectMasterVo>();
		try{
			connection= getConnection();
			ps_project=connection.prepareStatement(TravelBookedDetailsSqlUtil.GET_ALL_PROJECTS);
			rs_project=ps_project.executeQuery();
			while(rs_project.next()){
				ProjectMasterVo projectMasterVo=new ProjectMasterVo();
				projectMasterVo.setProjectcode(rs_project.getString("ProjectCode"));
				projectMasterVo.setProjectRefCode(rs_project.getString("ProjectRefCode"));
				projectlist.add(projectMasterVo);
			}
		}catch(SQLException se)	{
			se.printStackTrace();
			logger.error(se);
		}catch(Exception e)	{
			e.printStackTrace();
			logger.error(e);
		}finally{
			try{
				if(rs_project !=null && (!rs_project.isClosed()))
				{
					rs_project.close();
				}
				if(ps_project !=null && (!ps_project.isClosed()))
				{
					ps_project.close();
				}
				if(connection !=null && (!connection.isClosed()))
				{
					connection.close();
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
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl:getSearchEmployee Ending");
		
		return projectlist;	
	
	}



	public String saveTravelBookedDetails(TravelBookedDetailsPOJO travelBookedDetailsPOJO) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl:saveTravelBookedDetails Starting");
	
		Connection connection = null;
		PreparedStatement ps_travelBooked = null;
		String result=null;
		
		
		try{
			connection= getConnection();
			
			
			String projectmanger=getProjectManagerAndClient(travelBookedDetailsPOJO.getProjectcode(),connection);
						
			ps_travelBooked=connection.prepareStatement(TravelBookedDetailsSqlUtil.SAVE_BOOKED_TICKET);
			
			ps_travelBooked.setString(1,travelBookedDetailsPOJO.getTkt_book_code());
			ps_travelBooked.setString(2,travelBookedDetailsPOJO.getBooked_by_bioid());
			ps_travelBooked.setString(3,travelBookedDetailsPOJO.getBooked_by_empid());
			ps_travelBooked.setDouble(4,travelBookedDetailsPOJO.getAmount());
			ps_travelBooked.setString(5,travelBookedDetailsPOJO.getWho_on_travel_bioid());
			ps_travelBooked.setString(6,travelBookedDetailsPOJO.getWho_on_travel_empid());
			ps_travelBooked.setString(7,travelBookedDetailsPOJO.getTravel_mode());
			ps_travelBooked.setString(8,projectmanger);
			ps_travelBooked.setString(9,travelBookedDetailsPOJO.getProjectcode());
			ps_travelBooked.setString(10,travelBookedDetailsPOJO.getProject_Ref_code());
			ps_travelBooked.setString(11,travelBookedDetailsPOJO.getTravel_from());
			ps_travelBooked.setString(12,travelBookedDetailsPOJO.getTravel_to());
			ps_travelBooked.setString(13,travelBookedDetailsPOJO.getRemarks());
			ps_travelBooked.setDate(14,HelperClass.getSqlDate(travelBookedDetailsPOJO.getTravelling_date()));
			ps_travelBooked.setDate(15,HelperClass.getSqlDate(travelBookedDetailsPOJO.getBooked_date()));
			ps_travelBooked.setString(16,travelBookedDetailsPOJO.getDebit_card_used_by_bioid());
			ps_travelBooked.setString(17,travelBookedDetailsPOJO.getDebit_card_used_by_empid());
			ps_travelBooked.setString(18,travelBookedDetailsPOJO.getPosted_by());
			ps_travelBooked.setString(19,travelBookedDetailsPOJO.getIsConflict());
			ps_travelBooked.setString(20,travelBookedDetailsPOJO.getFilepath());
		    int value=ps_travelBooked.executeUpdate();
		    
 
		    if(value>0){
	  	
		    	Map<String,String> reportingDirector=getDirectorDeatils(travelBookedDetailsPOJO.getPosted_by(),connection);
		    	String direusername=reportingDirector.get("Username");
		    	String direName=reportingDirector.get("First_Name");
		    	
		     	
		    	String success=sendTravelConfirmationEmail(direusername,direName,travelBookedDetailsPOJO.getPosted_by(),
		  				  			travelBookedDetailsPOJO.getAmount(),travelBookedDetailsPOJO.getTravelling_date(),
		  			                     travelBookedDetailsPOJO.getBooked_by_empid(),
		  			                              travelBookedDetailsPOJO.getWho_on_travel_empid(),connection);
		 
		   
		    	
		    	if(MessageConstants.TRUE.equalsIgnoreCase(success)){
		    		
		    		result=MessageConstants.TRUE;
		    	
		    	}else{
		    		
		    		result=MessageConstants.MAIL_NOT_SENT;
		    	}
		    	
			  			  
		    
		    }else{
		    	
		    	result=MessageConstants.FALSE;
		    }
		    
		    
		}catch(SQLException se)	{
			logger.error(se);
			se.printStackTrace();
		}catch(Exception e)	{
			logger.error(e);
			e.printStackTrace();
		}finally{
			try{
				
				if(ps_travelBooked !=null && (!ps_travelBooked.isClosed()))
				{
					ps_travelBooked.close();
				}
				if(connection !=null && (!connection.isClosed()))
				{
					connection.close();
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
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl:saveTravelBookedDetails Ending");
		
		return result;
	}



	public String sendTravelConfirmationEmail(String direusername,String direname, String posted_by, Double amount,
			String travelling_date, String booked_by_empid,
			String who_on_travel_empid, Connection connection) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl: sendTravelConfirmationEmail Starting");
	
		
		String status=null;
		
		try{
			
			Map<String,String> managerMap= new EmployeeLeaveRequesDaoImpl().getManagerDetailsById(posted_by,connection);
			String url = new  EmployeeDAOImpl().getServerUrlFromBD(connection);
			EmailContent em = new EmailContent();
			String postedByName=managerMap.get("FirstName");
					
			String[] mails={direusername};
				
				em.setMailids(mails);
				em.setSubject("Travel Booked Details");
				
				em.setMessage("Dear "+direname+", \n"
						+ "Greetings from TeleIndia. \n\n"
						+ "Manager "+postedByName+" Claimed Booking Details. \n\n"
						+ "For more Details Login URL : " + url + "\n"
						+ "Approve the Travelling Allowances Details \n\n"
						+ "Have a nice day \n\n"
						+ "E-ATTENDANCE PRO  \n"
						+ "-------------------------------------------------------------- \n"
						+ "This is system generated mail,Please do not reply");
				
										
				status =	new SendMailWithMultipleAttachment().sendReportToMail(em);
		}
		catch(Exception e){
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl: sendTravelConfirmationEmail Ending");
		
		return status;
	}
		
	
	
	
	
public 	Map<String,String> getDirectorDeatils(String posted_by,Connection connection) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl:getDirectors Starting");
	
		
		PreparedStatement ps_directors = null;
		ResultSet rs_directors=null;
		Map<String,String> directormap=new HashMap<String, String>();
		try{
			
			ps_directors=connection.prepareStatement(TravelBookedDetailsSqlUtil.GET_DIRECTOR_MAILID);
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
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl:getDirectors Ending");
		
	
		return directormap;
		
	}


	private String getProjectManagerAndClient(String projectcode,Connection connection) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl:getProjectManagerAndClient Starting");
	
		PreparedStatement ps_project = null;
		ResultSet rs_project=null;
		String projectmanger=null;
		try{
		
			ps_project=connection.prepareStatement(TravelBookedDetailsSqlUtil.GET_PROJECT_MANAGER);
			ps_project.setString(1,projectcode);
			rs_project=ps_project.executeQuery();
			
			while(rs_project.next()){
		
				
				if(rs_project.getString("ManagerCode")!=null){
					projectmanger	=rs_project.getString("ManagerCode");
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
				if(rs_project !=null && (!rs_project.isClosed()))
				{
					rs_project.close();
				}
				if(ps_project !=null && (!ps_project.isClosed()))
				{
					ps_project.close();
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
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl:getProjectManagerAndClient Ending");
		
	
		return projectmanger;
	}


	public boolean checkManager(String projectcode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl:checkManager Starting");
	
		PreparedStatement ps_project = null;
		ResultSet rs_project=null;
		boolean flag=false;
		Connection connection=null;
		int count=0;
		try{
			connection= getConnection();
			ps_project=connection.prepareStatement(TravelBookedDetailsSqlUtil.GET_PROJECT_MANAGER);
			ps_project.setString(1,projectcode);
			rs_project=ps_project.executeQuery();
	
			while(rs_project.next()){
				count++;
			}
			if(count==0){
				return true;
			}
			
		}catch(SQLException se)	{
			se.printStackTrace();
			logger.error(se);
		}catch(Exception e)	{
			e.printStackTrace();
			logger.error(e);
		}finally{
			try{
				if(rs_project !=null && (!rs_project.isClosed()))
				{
					rs_project.close();
				}
				if(ps_project !=null && (!ps_project.isClosed()))
				{
					ps_project.close();
				}
				if(connection !=null && (!connection.isClosed()))
				{
					connection.close();
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
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl:checkManager Ending");
		
	
		return flag;
	}


	public 	ArrayList<TravelBookedDetailsVo> getBookedDetails(String userCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl: getBookedDetails Starting");
		
	
		ArrayList<TravelBookedDetailsVo> dbookedlist=new ArrayList<TravelBookedDetailsVo>();
	
		Connection connection = null;
		PreparedStatement ps_not_approved_Booked = null;
	    ResultSet rs_not_approved_Boked=null;
	    
	    PreparedStatement ps_approved_Booked = null;
	    ResultSet rs_approved_Boked=null;
	
	    try{
			connection= getConnection();
			ps_not_approved_Booked=connection.prepareStatement(TravelBookedDetailsSqlUtil.GET_NOT_APPROVED_BOOKING_DETAILS);
			ps_not_approved_Booked.setString(1, userCode);
			
			rs_not_approved_Boked=ps_not_approved_Booked.executeQuery();
			
			System.out.println("ps_not_approved_Booked"+ps_not_approved_Booked);
			
		
			while(rs_not_approved_Boked.next()){
				
				TravelBookedDetailsVo travelBookedDetailsVo=new TravelBookedDetailsVo();
				
				travelBookedDetailsVo.setTkt_book_code(rs_not_approved_Boked.getString("TKTBookCode"));
				travelBookedDetailsVo.setBooked_by_empid(rs_not_approved_Boked.getString("Tkt_Booked_by_empcode"));
				
				String booked_by=getEmployee(rs_not_approved_Boked.getString("Tkt_Booked_by_empcode"),connection);
				travelBookedDetailsVo.setTravel_mode(rs_not_approved_Boked.getString("mode"));
				
			
				travelBookedDetailsVo.setBooked_by_empname(booked_by);
				travelBookedDetailsVo.setWho_on_travel_empid(rs_not_approved_Boked.getString("resource_who_on_travel_empcode"));
				
				String who_is_on_travel=getEmployee(rs_not_approved_Boked.getString("resource_who_on_travel_empcode"),connection);
				travelBookedDetailsVo.setWho_on_travel_empname(who_is_on_travel);
				travelBookedDetailsVo.setAmount(rs_not_approved_Boked.getDouble("Amount"));
				
				travelBookedDetailsVo.setProject_Ref_code(rs_not_approved_Boked.getString("ProjectRefCode"));
				travelBookedDetailsVo.setProject(rs_not_approved_Boked.getString("Project_Name"));
				travelBookedDetailsVo.setTravel_from(rs_not_approved_Boked.getString("Traveling_From"));
				travelBookedDetailsVo.setTravel_to(rs_not_approved_Boked.getString("Traveling_To"));
				travelBookedDetailsVo.setBooked_date(HelperClass.convertDatabaseToUI(rs_not_approved_Boked.getString("Booked_date").toString()));
				travelBookedDetailsVo.setTravelling_date(HelperClass.convertDatabaseToUI(rs_not_approved_Boked.getString("Travelling_Date").toString()));
			
				travelBookedDetailsVo.setDebit_card_used_by_empid(rs_not_approved_Boked.getString("Debit_crdit_card_usedBy_empcode"));
				String debitcardby=getEmployee(rs_not_approved_Boked.getString("Debit_crdit_card_usedBy_empcode"),connection);
				
				travelBookedDetailsVo.setDebit_card_used_by_empname(debitcardby);
				travelBookedDetailsVo.setPosteddate(rs_not_approved_Boked.getString("posteddate"));
				travelBookedDetailsVo.setApprovedtime(rs_not_approved_Boked.getString("approveddate"));
				travelBookedDetailsVo.setStatus(MessageConstants.Not_Approved_Status);
				travelBookedDetailsVo.setApprovedamount(rs_not_approved_Boked.getDouble("AccountApprovedAmount"));
				
				
				dbookedlist.add(travelBookedDetailsVo);
			}
						
			ps_approved_Booked=connection.prepareStatement(TravelBookedDetailsSqlUtil.GET_APPROVED_BOOKING_DETAILS);
		
			ps_approved_Booked.setString(1, userCode);
		
			rs_approved_Boked=ps_approved_Booked.executeQuery();
			
			while(rs_approved_Boked.next()){
				
				TravelBookedDetailsVo travelBookedDetailsVo=new TravelBookedDetailsVo();
				
				travelBookedDetailsVo.setTkt_book_code(rs_approved_Boked.getString("TKTBookCode"));
				travelBookedDetailsVo.setBooked_by_empid(rs_approved_Boked.getString("Tkt_Booked_by_empcode"));
				
				String booked_by=getEmployee(rs_approved_Boked.getString("Tkt_Booked_by_empcode"),connection);
			
				travelBookedDetailsVo.setBooked_by_empname(booked_by);
				travelBookedDetailsVo.setTravel_mode(rs_approved_Boked.getString("mode"));
				travelBookedDetailsVo.setWho_on_travel_empid(rs_approved_Boked.getString("resource_who_on_travel_empcode"));
				
				String who_is_on_travel=getEmployee(rs_approved_Boked.getString("resource_who_on_travel_empcode"),connection);
				travelBookedDetailsVo.setWho_on_travel_empname(who_is_on_travel);
				travelBookedDetailsVo.setAmount(rs_approved_Boked.getDouble("Amount"));
				
				travelBookedDetailsVo.setProject_Ref_code(rs_approved_Boked.getString("ProjectRefCode"));
				travelBookedDetailsVo.setProject(rs_approved_Boked.getString("Project_Name"));
				travelBookedDetailsVo.setTravel_from(rs_approved_Boked.getString("Traveling_From"));
				travelBookedDetailsVo.setTravel_to(rs_approved_Boked.getString("Traveling_To"));
				travelBookedDetailsVo.setBooked_date(HelperClass.convertDatabaseToUI(rs_approved_Boked.getString("Booked_date").toString()));
				travelBookedDetailsVo.setTravelling_date(HelperClass.convertDatabaseToUI(rs_approved_Boked.getString("Travelling_Date").toString()));
			
				travelBookedDetailsVo.setDebit_card_used_by_empid(rs_approved_Boked.getString("Debit_crdit_card_usedBy_empcode"));
				String debitcardby=getEmployee(rs_approved_Boked.getString("Debit_crdit_card_usedBy_empcode"),connection);
				travelBookedDetailsVo.setDebit_card_used_by_empname(debitcardby);
				
				travelBookedDetailsVo.setPosteddate(rs_approved_Boked.getString("posteddate"));
				travelBookedDetailsVo.setApprovedby(getEmployee(rs_approved_Boked.getString("approvedby"),connection));
				travelBookedDetailsVo.setApprovedtime(rs_approved_Boked.getString("approveddate"));
				
				if("Y".equalsIgnoreCase(rs_approved_Boked.getString("isApprovedByAccounts"))){
					
				    travelBookedDetailsVo.setStatus(MessageConstants.Approved_Status);
				}else{
					travelBookedDetailsVo.setStatus(MessageConstants.REJECTED);
				}
				travelBookedDetailsVo.setApprovedamount(rs_approved_Boked.getDouble("AccountApprovedAmount"));
				
				dbookedlist.add(travelBookedDetailsVo);
			}
					
		}catch(SQLException se)	{
			se.printStackTrace();
			logger.error(se);
		}catch(Exception e)	{
			e.printStackTrace();
			logger.error(e);
		}finally{
			try{
				if(rs_approved_Boked !=null && (!rs_approved_Boked.isClosed()))
				{
					rs_approved_Boked.close();
				}
				if(rs_not_approved_Boked !=null && (!rs_not_approved_Boked.isClosed()))
				{
					rs_not_approved_Boked.close();
				}
				if(ps_approved_Booked !=null && (!ps_approved_Booked.isClosed()))
				{
					ps_approved_Booked.close();
				}
				
				if(ps_not_approved_Booked !=null && (!ps_not_approved_Booked.isClosed()))
				{
					ps_not_approved_Booked.close();
				}
				
				
				if(connection !=null && (!connection.isClosed()))
				{
					connection.close();
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
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl: getBookedDetails Ending");
		return dbookedlist;
	}


	private String getEmployee(String empcode, Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl: getEmployee  Starting");
	
		PreparedStatement ps_employee = null;
		ResultSet rs_employee=null;
		String employee=null;
		
		try{
			ps_employee=connection.prepareStatement(TravelBookedDetailsSqlUtil.GET_EMPLOYEE_BY_EMPCODE);
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
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl:getEmployee Ending");
		
	
		return employee;
	}


	public TravelBookedDetailsVo checkvalidateTravelDate(String travellingDate,
			String whoisontravelempid,String postedby) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl : checkvalidateTravelDate Starting");
	
		PreparedStatement ps_traveldate = null;
		ResultSet rs_traveldate=null;
		String  result=null;
		Connection connection=null;
		int count=0;
	    int count1=0;
	    String mangName="";
	    String filepath="";
	    
	    
	    TravelBookedDetailsVo travelBookedDetailsVo=new TravelBookedDetailsVo();
		try{
			connection= getConnection();
			ps_traveldate=connection.prepareStatement(TravelBookedDetailsSqlUtil.CHECK_VALID_TRAVELLING_DATE_BY_POSTED_BY);
			ps_traveldate.setDate(1,HelperClass.getSqlDate(travellingDate));
			ps_traveldate.setString(2,whoisontravelempid);
			ps_traveldate.setString(3,postedby);
			
			rs_traveldate=ps_traveldate.executeQuery();
			
			while(rs_traveldate.next()){
				count=rs_traveldate.getInt(1);
				filepath=rs_traveldate.getString("FilePath");
			}
			if(rs_traveldate !=null && (!rs_traveldate.isClosed()))
			{
				rs_traveldate.close();
			}
			if(ps_traveldate !=null && (!ps_traveldate.isClosed()))
			{
				ps_traveldate.close();
			}
			
			if(count>0){
				travelBookedDetailsVo.setStatus(MessageConstants.TREVEL_BOOKING_DETAILS_CLAIMED_POSTED_BY);
				travelBookedDetailsVo.setFilepath(filepath);
				
			}else{
				
				ps_traveldate=connection.prepareStatement(TravelBookedDetailsSqlUtil.CHECK_VALID_TRAVELLING_DATE);
				ps_traveldate.setDate(1,HelperClass.getSqlDate(travellingDate));
				ps_traveldate.setString(2,whoisontravelempid);
							
				rs_traveldate=ps_traveldate.executeQuery();
				
					
				while(rs_traveldate.next()){
					
					count1=Integer.parseInt(rs_traveldate.getString("count"));
					String manPosted_By=rs_traveldate.getString("Posted_By");
					filepath=rs_traveldate.getString("FilePath");
					mangName =	getManagerName(manPosted_By,connection);
				}
				
				if(count1>0){
					
					travelBookedDetailsVo.setStatus("Manager "+mangName+ MessageConstants.TREVEL_BOOKING_DETAILS_CLAIMED);
					travelBookedDetailsVo.setFilepath(filepath);
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
				if(rs_traveldate !=null && (!rs_traveldate.isClosed()))
				{
					rs_traveldate.close();
				}
				if(ps_traveldate !=null && (!ps_traveldate.isClosed()))
				{
					ps_traveldate.close();
				}
				if(connection !=null && (!connection.isClosed()))
				{
					connection.close();
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
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelBookedDetailsDaoImpl: checkvalidateTravelDate Ending");
		
	
		return travelBookedDetailsVo;
	}
	
  public String getManagerName(String postedby, Connection connection) {
		
		PreparedStatement postedmanagerpstmt = null;
		ResultSet postedmanagerrs =null;
		String managername=null;
		try{
		
    		postedmanagerpstmt=connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_POSTED_BY_MANAGER);
			postedmanagerpstmt.setString(1,postedby);
	    	postedmanagerrs=postedmanagerpstmt.executeQuery();
	    	
	    	
			while(postedmanagerrs.next()){
				managername=postedmanagerrs.getString("FirstName");
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


	

}
