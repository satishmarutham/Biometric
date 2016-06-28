package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.ApproveTravelBookingDao;
import com.centris.DAO.DBService;
import com.centris.POJO.ApproveTravekBookingPojo;
import com.centris.VO.AllowancesClaimByManagerVO;
import com.centris.VO.ApproveTravelBookingMailDetailsVo;
import com.centris.VO.ApproveTravelBookingVo;
import com.centris.VO.SingleTravelBookingDetailsVo;
import com.centris.form.ApproveTravelBookingForm;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.TravelAllowanceInAdmin;
import com.centris.util.TravelAllowanceUtil;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AllowancesClaimByManagerSqlUtil;
import com.centris.util.SQLUtils.ApproveTravelBookingSqlUtil;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.SQLUtils.TravelBookedDetailsSqlUtil;
import com.centris.util.constants.MessageConstants;

	public class ApproveTravelBookingDaoImpl extends DBService implements ApproveTravelBookingDao{

	
	private static Logger logger = Logger.getLogger(ApproveTravelBookingDaoImpl.class);
	
	
	@Override
	public LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>> getTktBookingDetailsDao(
			ApproveTravelBookingForm form, String currenuserId,String userType) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingDaoImpl: getTktBookingDetailsDao Starting");
		
	
		LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>> tktDetailsMap=new LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>>();
		ArrayList<ApproveTravelBookingVo> tktList=new ArrayList<ApproveTravelBookingVo>();
		
		Connection connection = null;
		PreparedStatement ps_not_approved_Booked = null;
	    ResultSet rs_not_approved_Boked=null;
	    int count=0;
	    
	    PreparedStatement getDatesPstmt=null;
	    ResultSet getDatesPstmtrs=null;
	    
	   
	
	    try{
			connection= getConnection();
			
			if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
			ps_not_approved_Booked=connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_TKT_BOOKED_DETAILS);
			ps_not_approved_Booked.setString(1, currenuserId);
			ps_not_approved_Booked.setString(2, currenuserId);
			ps_not_approved_Booked.setString(3, HelperClass.convertUIToDatabase(form.getTodate()));
			ps_not_approved_Booked.setString(4, HelperClass.convertUIToDatabase(form.getFromdate()));
			
			rs_not_approved_Boked=ps_not_approved_Booked.executeQuery();
		
			while(rs_not_approved_Boked.next()){
				
				
				
				if(tktList.size()!=0){
					
					
					if(!((tktList.get(tktList.size()-1).getPosted_by_id().trim())+"-"+(tktList.get(tktList.size()-1).getPosted_by().trim())).equalsIgnoreCase(rs_not_approved_Boked.getString("Posted_By").trim()+"-"+rs_not_approved_Boked.getString("postedbyName").trim())){
						
						getDatesPstmt = connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_MAX_DATES);
						getDatesPstmt.setString(1, tktList.get(tktList.size()-1).getPosted_by_id());
						getDatesPstmt.setString(2, HelperClass.convertUIToDatabase(form.getTodate()));
						getDatesPstmt.setString(3, HelperClass.convertUIToDatabase(form.getFromdate()));
						
						getDatesPstmtrs=getDatesPstmt.executeQuery();
						
						String mindate=null;
						String maxDate=null;
						double amount=0.0;
						
						while(getDatesPstmtrs.next()){
							
							mindate=HelperClass.convertDatabaseToUI(getDatesPstmtrs.getString("mindate"));
							maxDate=HelperClass.convertDatabaseToUI(getDatesPstmtrs.getString("maxdate"));
							if(getDatesPstmtrs.getString("amount")!=null){
							amount=Double.parseDouble(getDatesPstmtrs.getString("amount"));
							}
						}
						
						tktDetailsMap.put((tktList.get(tktList.size()-1).getPosted_by().trim())+"-"+(tktList.get(tktList.size()-1).getPostedByBioCode().trim())+".  From  "+mindate+".   To  "+maxDate+".   Total Amount  -  "+amount, tktList);
						
						count=0;
						tktList =new ArrayList<ApproveTravelBookingVo>();
						
					}
					
					}
				
				
				count++;
				ApproveTravelBookingVo travelBookedDetailsVo=new ApproveTravelBookingVo();
				
				travelBookedDetailsVo.setSno(count);
				
				travelBookedDetailsVo.setPostedByBioCode(rs_not_approved_Boked.getString("postedByBioId"));
				travelBookedDetailsVo.setTkt_book_code(rs_not_approved_Boked.getString("TKTBookCode"));
				
				travelBookedDetailsVo.setBooked_by_empid(rs_not_approved_Boked.getString("Tkt_Booked_by_empcode"));
				String booked_by=getEmployee(rs_not_approved_Boked.getString("Tkt_Booked_by_empcode"),connection);
				travelBookedDetailsVo.setBooked_by_empname(booked_by);
				
				travelBookedDetailsVo.setTravel_mode(rs_not_approved_Boked.getString("mode"));
				
		
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
				travelBookedDetailsVo.setPosted_by(rs_not_approved_Boked.getString("postedbyName"));
				travelBookedDetailsVo.setPosted_by_id(rs_not_approved_Boked.getString("Posted_By"));
				travelBookedDetailsVo.setRemarks(rs_not_approved_Boked.getString("Remarks"));
				
				travelBookedDetailsVo.setApprovedby(rs_not_approved_Boked.getString("directorName"));
				travelBookedDetailsVo.setApprovedtime(rs_not_approved_Boked.getString("approveddate"));
				travelBookedDetailsVo.setDiretorremarks(rs_not_approved_Boked.getString("DirectorRemarks"));
				
				if(rs_not_approved_Boked.getString("isApprovedByDirector").equalsIgnoreCase("Y")){
				
				travelBookedDetailsVo.setStatus(MessageConstants.TRAVEL_BOOKING_APPROVED);
				
				}else if(rs_not_approved_Boked.getString("isApprovedByDirector").equalsIgnoreCase("R")){
					
					travelBookedDetailsVo.setIsRejectedStatus(MessageConstants.TRAVEL_BOOKING_REJECTED);
					
				}else{
					
					travelBookedDetailsVo.setStatus(MessageConstants.TRAVEL_BOOKING_NOTAPPROVED);
					travelBookedDetailsVo.setIsRejectedStatus(MessageConstants.TRAVEL_BOOKING_REJECT);
				}
				
				if(rs_not_approved_Boked.getString("ApprovedAmount")!=null){
				travelBookedDetailsVo.setApproveAmount(rs_not_approved_Boked.getDouble("ApprovedAmount"));
				}else{
					
					travelBookedDetailsVo.setApproveAmount(rs_not_approved_Boked.getDouble("Amount"));
				}
				
				travelBookedDetailsVo.setFilepath(rs_not_approved_Boked.getString("FilePath"));
				
				
				tktList.add(travelBookedDetailsVo);
			}
			
			
			if(tktList.size()!=0){
				
				getDatesPstmt = connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_MAX_DATES);
				getDatesPstmt.setString(1, tktList.get(tktList.size()-1).getPosted_by_id());
				getDatesPstmt.setString(2, HelperClass.convertUIToDatabase(form.getTodate()));
				getDatesPstmt.setString(3, HelperClass.convertUIToDatabase(form.getFromdate()));
				
				
				
				getDatesPstmtrs=getDatesPstmt.executeQuery();
				
				String mindate=null;
				String maxDate=null;
				double amount=0.0;
				
				while(getDatesPstmtrs.next()){
					
					mindate=HelperClass.convertDatabaseToUI(getDatesPstmtrs.getString("mindate"));
					maxDate=HelperClass.convertDatabaseToUI(getDatesPstmtrs.getString("maxdate"));
					if(getDatesPstmtrs.getString("amount")!=null){
					amount=Double.parseDouble(getDatesPstmtrs.getString("amount"));
					}
				}
				
				tktDetailsMap.put((tktList.get(tktList.size()-1).getPosted_by().trim())+"-"+(tktList.get(tktList.size()-1).getPostedByBioCode().trim())+".  From  "+mindate+".   To  "+maxDate+".   Total Amount  -  "+amount, tktList);
				
				}
						
			}else{
				

				ps_not_approved_Booked=connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_NOT_APPROVEDTKT_BY_ADMIN);
				ps_not_approved_Booked.setString(1, HelperClass.convertUIToDatabase(form.getTodate()));
				ps_not_approved_Booked.setString(2, HelperClass.convertUIToDatabase(form.getFromdate()));
				
				rs_not_approved_Boked=ps_not_approved_Booked.executeQuery();
			
				while(rs_not_approved_Boked.next()){
					
					if(tktList.size()!=0){
						
						
						if(!((tktList.get(tktList.size()-1).getApprovedby().trim())+"-"+(tktList.get(tktList.size()-1).getApprovedByName().trim())).equalsIgnoreCase(rs_not_approved_Boked.getString("ApprovedDirectorCode").trim()+"-"+rs_not_approved_Boked.getString("directorName").trim())){
							
							
							getDatesPstmt = connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_CONSOLIDATED_BY_DIRECTOR);
							getDatesPstmt.setString(1, tktList.get(tktList.size()-1).getApprovedby());
							getDatesPstmt.setString(2, HelperClass.convertUIToDatabase(form.getTodate()));
							getDatesPstmt.setString(3, HelperClass.convertUIToDatabase(form.getFromdate()));
							
							
							
							getDatesPstmtrs=getDatesPstmt.executeQuery();
							
							String mindate=null;
							String maxDate=null;
							double amount=0.0;
							
							while(getDatesPstmtrs.next()){
								
								mindate=getDatesPstmtrs.getString("mindate");
								maxDate=getDatesPstmtrs.getString("maxdate");
								if(getDatesPstmtrs.getString("amount")!=null){
								amount=Double.parseDouble(getDatesPstmtrs.getString("amount"));
								}
							}
							
							tktDetailsMap.put((tktList.get(tktList.size()-1).getApprovedByName().trim())+"-"+(tktList.get(tktList.size()-1).getApprovedByBiocode().trim())+".   From  "+mindate+".   To"+maxDate+".  Total Amount  -  "+amount, tktList);
							
							count=0;
							tktList =new ArrayList<ApproveTravelBookingVo>();
							
						}
						
						}
					
					
					count++;
					
					ApproveTravelBookingVo travelBookedDetailsVo=new ApproveTravelBookingVo();
					
					travelBookedDetailsVo.setSno(count);
					
					travelBookedDetailsVo.setApprovedByBiocode(rs_not_approved_Boked.getString("directorBiocode"));
					
					travelBookedDetailsVo.setTkt_book_code(rs_not_approved_Boked.getString("TKTBookCode"));
					
					travelBookedDetailsVo.setBooked_by_empid(rs_not_approved_Boked.getString("Tkt_Booked_by_empcode"));
					String booked_by=getEmployee(rs_not_approved_Boked.getString("Tkt_Booked_by_empcode"),connection);
					travelBookedDetailsVo.setBooked_by_empname(booked_by);
					
					travelBookedDetailsVo.setTravel_mode(rs_not_approved_Boked.getString("mode"));
					
			
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
					travelBookedDetailsVo.setPosted_by(rs_not_approved_Boked.getString("postedbyName"));
					travelBookedDetailsVo.setPosted_by_id(rs_not_approved_Boked.getString("Posted_By"));
					travelBookedDetailsVo.setRemarks(rs_not_approved_Boked.getString("Remarks"));
					
					travelBookedDetailsVo.setApprovedby(rs_not_approved_Boked.getString("ApprovedDirectorCode"));
					travelBookedDetailsVo.setApprovedByName(rs_not_approved_Boked.getString("directorName"));
					
					travelBookedDetailsVo.setApprovedtime(rs_not_approved_Boked.getString("approveddate"));
					
					
					if(rs_not_approved_Boked.getString("isApprovedByAccounts").equalsIgnoreCase("Y")){
					
					travelBookedDetailsVo.setStatus(MessageConstants.TRAVEL_BOOKING_APPROVED);
					travelBookedDetailsVo.setDiretorremarks(rs_not_approved_Boked.getString("DirectorRemarks"));
					
					}else if(rs_not_approved_Boked.getString("isApprovedByAccounts").equalsIgnoreCase("R")){
						
						travelBookedDetailsVo.setIsRejectedStatus(MessageConstants.TRAVEL_BOOKING_REJECTED);
						travelBookedDetailsVo.setDiretorremarks(rs_not_approved_Boked.getString("DirectorRemarks"));
						
					}else{
						
						travelBookedDetailsVo.setStatus(MessageConstants.TRAVEL_BOOKING_NOTAPPROVED);
						travelBookedDetailsVo.setIsRejectedStatus(MessageConstants.TRAVEL_BOOKING_REJECT);
						travelBookedDetailsVo.setDiretorremarks("");
					}
					
					
					travelBookedDetailsVo.setApproveAmount(rs_not_approved_Boked.getDouble("ApprovedAmount"));
					
					travelBookedDetailsVo.setFilepath(rs_not_approved_Boked.getString("FilePath"));
					
					tktList.add(travelBookedDetailsVo);
				}
				
				
				if(tktList.size()!=0){
					
					getDatesPstmt = connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_CONSOLIDATED_BY_DIRECTOR);
					getDatesPstmt.setString(1, tktList.get(tktList.size()-1).getApprovedby());
					getDatesPstmt.setString(2, HelperClass.convertUIToDatabase(form.getTodate()));
					getDatesPstmt.setString(3, HelperClass.convertUIToDatabase(form.getFromdate()));
					
					
					getDatesPstmtrs=getDatesPstmt.executeQuery();
					
					String mindate=null;
					String maxDate=null;
					double amount=0.0;
					
					while(getDatesPstmtrs.next()){
						
						mindate=getDatesPstmtrs.getString("mindate");
						maxDate=getDatesPstmtrs.getString("maxdate");
						if(getDatesPstmtrs.getString("amount")!=null){
						amount=Double.parseDouble(getDatesPstmtrs.getString("amount"));
						}
					}
					
					tktDetailsMap.put((tktList.get(tktList.size()-1).getApprovedByName().trim())+"-"+(tktList.get(tktList.size()-1).getApprovedByBiocode().trim())+".   From  "+mindate+".   To"+maxDate+".  Total Amount  -  "+amount, tktList);
					
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
				
				if(rs_not_approved_Boked !=null && (!rs_not_approved_Boked.isClosed()))
				{
					rs_not_approved_Boked.close();
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
		logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingDaoImpl: getTktBookingDetailsDao Ending");
	
		
		return tktDetailsMap;
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
	

	@Override
	public SingleTravelBookingDetailsVo getTktBookingDetailsDao(String tktCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingDaoImpl: getTktBookingDetailsDao Starting");
		
	
		Connection connection = null;
		PreparedStatement ps_not_approved_Booked = null;
	    ResultSet rs_not_approved_Boked=null;
	    
	    SingleTravelBookingDetailsVo travelBookedDetailsVo=new SingleTravelBookingDetailsVo();
	   
	
	    try{
			connection= getConnection();
			
			ps_not_approved_Booked=connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_SINGLE_TKT_DETAILS);
			ps_not_approved_Booked.setString(1, tktCode);
			
			rs_not_approved_Boked=ps_not_approved_Booked.executeQuery();
		
			while(rs_not_approved_Boked.next()){
				
				travelBookedDetailsVo.setProject(rs_not_approved_Boked.getString("Project_Name"));
				travelBookedDetailsVo.setProjectrefcode(rs_not_approved_Boked.getString("ProjectRefCode"));
				travelBookedDetailsVo.setTravelling_date(HelperClass.convertDatabaseToUI(rs_not_approved_Boked.getString("Travelling_Date").toString()));

				String debitcardby=getEmployee(rs_not_approved_Boked.getString("Debit_crdit_card_usedBy_empcode"),connection);
				travelBookedDetailsVo.setCreditcardused(debitcardby);
				
				travelBookedDetailsVo.setPosteddate(rs_not_approved_Boked.getString("posteddate"));
				travelBookedDetailsVo.setPostedby(rs_not_approved_Boked.getString("postedbyName"));
				travelBookedDetailsVo.setRemarks(rs_not_approved_Boked.getString("Remarks"));
				
				
				
				if(rs_not_approved_Boked.getString("isApprovedByDirector").equalsIgnoreCase("Y") || rs_not_approved_Boked.getString("isApprovedByDirector").equalsIgnoreCase("R")){
				
				travelBookedDetailsVo.setApprovedby(rs_not_approved_Boked.getString("directorName"));
				
				travelBookedDetailsVo.setApprovedtime(rs_not_approved_Boked.getString("approveddate"));
				travelBookedDetailsVo.setDirectorremarks(rs_not_approved_Boked.getString("DirectorRemarks"));
				
				}else{
					
					travelBookedDetailsVo.setApprovedby("");
					travelBookedDetailsVo.setApprovedtime("");
					travelBookedDetailsVo.setDirectorremarks("");
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
				
				if(rs_not_approved_Boked !=null && (!rs_not_approved_Boked.isClosed()))
				{
					rs_not_approved_Boked.close();
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
		logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingDaoImpl: getTktBookingDetailsDao Ending");
	
	
		
		return travelBookedDetailsVo;
	}

	
	@Override
	public String approveSingleTicketDao(ApproveTravekBookingPojo pojo) {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : approveSingleTicketDao : Starting");

		PreparedStatement approveTktPstmt = null;
		int count=0;
		String status=null;
	
		PreparedStatement allowancesPstmt1=null;
		int mailUpdateCount=0;
		
		Connection connection=null;
		
		try {
			
			connection =getConnection();
			
			if(pojo.getUsertype().equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				
			approveTktPstmt = connection.prepareStatement(ApproveTravelBookingSqlUtil.APPROVE_SINGLE_TKT);
			approveTktPstmt.setString(1, pojo.getApprovedamount().trim());
			approveTktPstmt.setString(2, pojo.getRemarks().trim());
			approveTktPstmt.setString(3, pojo.getApprovedby().trim());
			approveTktPstmt.setTimestamp(4, HelperClass.getCurrentTimestamp());
			approveTktPstmt.setString(5, pojo.getApproveTktBookingCode().trim());
			
			count = approveTktPstmt.executeUpdate();
			
			if(count>0){
				
				status=MessageConstants.TRUE;
				
				String url = getServerUrlFromBD(connection);
				String mailStatus = sendEmailToAccounts(pojo.getApproveTktBookingCode().trim(),pojo.getApprovedbyName(),url,"single");
				
				if(mailStatus.equalsIgnoreCase(MessageConstants.TRUE)){
					
					status=MessageConstants.MAIL_SENT;
				}
			}
			
			}else{
				
				approveTktPstmt = connection.prepareStatement(ApproveTravelBookingSqlUtil.APPROVE_TKTBY_ADMIN);
				approveTktPstmt.setString(1, pojo.getApprovedby().trim());
				approveTktPstmt.setTimestamp(2, HelperClass.getCurrentTimestamp());
				approveTktPstmt.setString(3, pojo.getApprovedamount().trim());
				approveTktPstmt.setString(4, pojo.getRemarks().trim());
				approveTktPstmt.setString(5, pojo.getApproveTktBookingCode().trim());
				
				
				count = approveTktPstmt.executeUpdate();
				
				if(count>0){
					
					status=MessageConstants.TRUE;
					
					String url = getServerUrlFromBD(connection);
					String mailStatus = sendEmailToManagerAndDirector(pojo.getApproveTktBookingCode().trim(),pojo.getApprovedbyName(),url);
					

					if(mailStatus.equalsIgnoreCase(MessageConstants.TRUE)){
						
						allowancesPstmt1 = connection.prepareStatement(ApproveTravelBookingSqlUtil.UPDATE_MAILSENT);
						allowancesPstmt1.setTimestamp(1, HelperClass.getCurrentTimestamp());
						allowancesPstmt1.setString(2, pojo.getApproveTktBookingCode());
						
						mailUpdateCount=allowancesPstmt1.executeUpdate();
						
						if(mailUpdateCount>0){
						
						status=MessageConstants.MAIL_SENT;
						
						}
					}
					
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
				
				if(approveTktPstmt != null && (!approveTktPstmt.isClosed())){
					
					approveTktPstmt.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
				}
				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : approveSingleTicketDao : Ending");

		return status;

	}

	
	@Override
	public ArrayList<ApproveTravelBookingVo> getConflictEmployeesDao(
			String startDate,String endDate,String userType,String userId) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingDaoImpl: getTktBookingDetailsDao Starting");
		
	
		ArrayList<ApproveTravelBookingVo> tktList=new ArrayList<ApproveTravelBookingVo>();
		
		Connection connection = null;
		PreparedStatement ps_not_approved_Booked = null;
	    ResultSet rs_not_approved_Boked=null;
	    int count=0;
	   
	
	    try{
	    	
			connection= getConnection();
			
			if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
			
			ps_not_approved_Booked=connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_CONFLICT_EMPLOYEES);
			ps_not_approved_Booked.setString(1,userId);
			ps_not_approved_Booked.setString(2,userId);
			ps_not_approved_Booked.setString(3, HelperClass.convertUIToDatabase(startDate));
			ps_not_approved_Booked.setString(4, HelperClass.convertUIToDatabase(endDate));
			
			
			
			rs_not_approved_Boked=ps_not_approved_Booked.executeQuery();
		
			while(rs_not_approved_Boked.next()){
				
				count++;
				ApproveTravelBookingVo travelBookedDetailsVo=new ApproveTravelBookingVo();
				
				travelBookedDetailsVo.setSno(count);
				
				travelBookedDetailsVo.setTkt_book_code(rs_not_approved_Boked.getString("TKTBookCode"));
				
				travelBookedDetailsVo.setBooked_by_empid(rs_not_approved_Boked.getString("Tkt_Booked_by_empcode"));
				String booked_by=getEmployee(rs_not_approved_Boked.getString("Tkt_Booked_by_empcode"),connection);
				travelBookedDetailsVo.setBooked_by_empname(booked_by);
				
				travelBookedDetailsVo.setTravel_mode(rs_not_approved_Boked.getString("mode"));
				
		
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
				travelBookedDetailsVo.setPosted_by(rs_not_approved_Boked.getString("postedbyName"));
				travelBookedDetailsVo.setPosted_by_id(rs_not_approved_Boked.getString("Posted_By"));
				if(rs_not_approved_Boked.getString("Remarks")==null){
					
					travelBookedDetailsVo.setRemarks("-");
				}else{
					
					travelBookedDetailsVo.setRemarks(rs_not_approved_Boked.getString("Remarks"));
				}
				
				
				travelBookedDetailsVo.setApprovedby(rs_not_approved_Boked.getString("directorName"));
				if(rs_not_approved_Boked.getString("approveddate")==null){
					
					travelBookedDetailsVo.setApprovedtime("-");
					
				}else{
				
					travelBookedDetailsVo.setApprovedtime(rs_not_approved_Boked.getString("approveddate"));
				}
				
				if(rs_not_approved_Boked.getString("DirectorRemarks")==null){
					
					travelBookedDetailsVo.setDiretorremarks("-");
					
				}else{
				
					travelBookedDetailsVo.setDiretorremarks(rs_not_approved_Boked.getString("DirectorRemarks"));
				}
				
				
				if(rs_not_approved_Boked.getString("isApprovedByDirector").equalsIgnoreCase("Y")){
				
				travelBookedDetailsVo.setStatus(MessageConstants.TRAVEL_BOOKING_APPROVED);
				travelBookedDetailsVo.setDounloadstatus(MessageConstants.TRAVEL_BOOKING_APPROVED);
				
				}else if(rs_not_approved_Boked.getString("isApprovedByDirector").equalsIgnoreCase("R")){
					
					travelBookedDetailsVo.setIsRejectedStatus(MessageConstants.TRAVEL_BOOKING_REJECTED);
					travelBookedDetailsVo.setDounloadstatus(MessageConstants.TRAVEL_BOOKING_REJECTED);
					
				}else{
					
					travelBookedDetailsVo.setStatus(MessageConstants.TRAVEL_BOOKING_NOTAPPROVED);
					travelBookedDetailsVo.setIsRejectedStatus(MessageConstants.TRAVEL_BOOKING_REJECT);
					travelBookedDetailsVo.setDounloadstatus("Not Approved");
				}
				
				if(rs_not_approved_Boked.getString("ApprovedAmount")!=null){
				travelBookedDetailsVo.setApproveAmount(rs_not_approved_Boked.getDouble("ApprovedAmount"));
				}else{
					
					travelBookedDetailsVo.setApproveAmount(rs_not_approved_Boked.getDouble("Amount"));
				}
				
				travelBookedDetailsVo.setFilepath(rs_not_approved_Boked.getString("FilePath"));
			
				tktList.add(travelBookedDetailsVo);
			}
			
			}else{
				

				
				ps_not_approved_Booked=connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_CONFLICTNOT_APPROVEDTKT_BY_ADMIN);
				ps_not_approved_Booked.setString(1, HelperClass.convertUIToDatabase(startDate));
				ps_not_approved_Booked.setString(2, HelperClass.convertUIToDatabase(endDate));
				
				rs_not_approved_Boked=ps_not_approved_Booked.executeQuery();
			
				while(rs_not_approved_Boked.next()){
					
					count++;
					
					ApproveTravelBookingVo travelBookedDetailsVo=new ApproveTravelBookingVo();
					
					travelBookedDetailsVo.setSno(count);
					
					travelBookedDetailsVo.setTkt_book_code(rs_not_approved_Boked.getString("TKTBookCode"));
					
					travelBookedDetailsVo.setBooked_by_empid(rs_not_approved_Boked.getString("Tkt_Booked_by_empcode"));
					String booked_by=getEmployee(rs_not_approved_Boked.getString("Tkt_Booked_by_empcode"),connection);
					travelBookedDetailsVo.setBooked_by_empname(booked_by);
					
					travelBookedDetailsVo.setTravel_mode(rs_not_approved_Boked.getString("mode"));
					
			
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
					travelBookedDetailsVo.setPosted_by(rs_not_approved_Boked.getString("postedbyName"));
					travelBookedDetailsVo.setPosted_by_id(rs_not_approved_Boked.getString("Posted_By"));
					if(rs_not_approved_Boked.getString("Remarks")==null){
						
						travelBookedDetailsVo.setRemarks("-");
					}else{
						
						travelBookedDetailsVo.setRemarks(rs_not_approved_Boked.getString("Remarks"));
					}
					
					travelBookedDetailsVo.setApprovedby(rs_not_approved_Boked.getString("ApprovedDirectorCode"));
					travelBookedDetailsVo.setApprovedByName(rs_not_approved_Boked.getString("directorName"));
					
					travelBookedDetailsVo.setApprovedtime(rs_not_approved_Boked.getString("approveddate"));
					travelBookedDetailsVo.setDiretorremarks(rs_not_approved_Boked.getString("DirectorRemarks"));
					
					if(rs_not_approved_Boked.getString("isApprovedByAccounts").equalsIgnoreCase("Y")){
					
					travelBookedDetailsVo.setStatus(MessageConstants.TRAVEL_BOOKING_APPROVED);
					travelBookedDetailsVo.setDounloadstatus(MessageConstants.TRAVEL_BOOKING_APPROVED);
					
					}else if(rs_not_approved_Boked.getString("isApprovedByAccounts").equalsIgnoreCase("R")){
						
						travelBookedDetailsVo.setIsRejectedStatus(MessageConstants.TRAVEL_BOOKING_REJECTED);
						travelBookedDetailsVo.setDounloadstatus(MessageConstants.TRAVEL_BOOKING_REJECTED);
						
					}else{
						
						travelBookedDetailsVo.setDounloadstatus("Not Approved");
						travelBookedDetailsVo.setIsRejectedStatus(MessageConstants.TRAVEL_BOOKING_REJECT);
						travelBookedDetailsVo.setStatus(MessageConstants.TRAVEL_BOOKING_NOTAPPROVED);
					}
					
					
					travelBookedDetailsVo.setApproveAmount(rs_not_approved_Boked.getDouble("ApprovedAmount"));
					
					travelBookedDetailsVo.setFilepath(rs_not_approved_Boked.getString("FilePath"));
					
					tktList.add(travelBookedDetailsVo);
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
				
				if(rs_not_approved_Boked !=null && (!rs_not_approved_Boked.isClosed()))
				{
					rs_not_approved_Boked.close();
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
		logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingDaoImpl: getTktBookingDetailsDao Ending");
	
		
		return tktList;
	}
	
	
	public String getServerUrlFromBD(Connection connection) {
		String url = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = connection.prepareStatement(Employee.GET_SERVER_URL);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				url = rs.getString("URL");
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return url;
	}
	
	
	public ApproveTravelBookingMailDetailsVo getTktBkMailDetails(String bookedcode,String approvedname) {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : getTktBkMailDetails : Starting");

		PreparedStatement allowancesPstmt = null;
		ResultSet allowancesRs = null;
	
		
		Connection connection=null;
		
		ApproveTravelBookingMailDetailsVo vo=new ApproveTravelBookingMailDetailsVo();
		
		try {
			
			connection =getConnection();
			allowancesPstmt = connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_MAIL_DETAILS);
			allowancesPstmt.setString(1, bookedcode);
			
			
			allowancesRs = allowancesPstmt.executeQuery();
			
			while (allowancesRs.next()) {
				
				vo.setEmpname(allowancesRs.getString("First_Name"));
				vo.setDate(allowancesRs.getString("Booked_date"));
				vo.setAmount(allowancesRs.getString("ApprovedAmount"));
				vo.setManagerMail(allowancesRs.getString("email"));
				vo.setCliamedAmount(allowancesRs.getString("Amount"));
				vo.setDirectMail(allowancesRs.getString("directorMail"));
				vo.setApprovedName(approvedname);
				
			}
			
		
		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);
			sqle.printStackTrace();

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
			
		} finally {

			try {
				
				if(allowancesRs != null && (!allowancesRs.isClosed())){
					
					allowancesRs.close();
				}
				if(allowancesPstmt != null && (!allowancesPstmt.isClosed())){
					
					allowancesPstmt.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
				}
				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : getTktBkMailDetails : Ending");

		return vo;

	}

	
	@Override
	public ArrayList<ApproveTravelBookingVo> getTktBkngDetailsForDounloadDao(
			String startDate, String endDate, String currenuserId,
			String userType) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingDaoImpl: getTktBkngDetailsForDounloadDao Starting");
		
	
		ArrayList<ApproveTravelBookingVo> tktList=new ArrayList<ApproveTravelBookingVo>();
		
		Connection connection = null;
		PreparedStatement ps_not_approved_Booked = null;
	    ResultSet rs_not_approved_Boked=null;
	    int count=0;
	    
	   
	
	    try{
			connection= getConnection();
			
			if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
			ps_not_approved_Booked=connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_TKT_BOOKED_DETAILS);
			ps_not_approved_Booked.setString(1, currenuserId);
			ps_not_approved_Booked.setString(2, currenuserId);
			ps_not_approved_Booked.setString(3, HelperClass.convertUIToDatabase(startDate));
			ps_not_approved_Booked.setString(4, HelperClass.convertUIToDatabase(endDate));
			
			rs_not_approved_Boked=ps_not_approved_Booked.executeQuery();
		
			while(rs_not_approved_Boked.next()){
				
				count++;
				ApproveTravelBookingVo travelBookedDetailsVo=new ApproveTravelBookingVo();
				
				travelBookedDetailsVo.setSno(count);
				
				travelBookedDetailsVo.setPostedByBioCode(rs_not_approved_Boked.getString("postedByBioId"));
				travelBookedDetailsVo.setTkt_book_code(rs_not_approved_Boked.getString("TKTBookCode"));
				
				travelBookedDetailsVo.setBooked_by_empid(rs_not_approved_Boked.getString("Tkt_Booked_by_empcode"));
				String booked_by=getEmployee(rs_not_approved_Boked.getString("Tkt_Booked_by_empcode"),connection);
				travelBookedDetailsVo.setBooked_by_empname(booked_by);
				
				travelBookedDetailsVo.setTravel_mode(rs_not_approved_Boked.getString("mode"));
				
		
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
				travelBookedDetailsVo.setPosted_by(rs_not_approved_Boked.getString("postedbyName"));
				travelBookedDetailsVo.setPosted_by_id(rs_not_approved_Boked.getString("Posted_By"));
				if(rs_not_approved_Boked.getString("Remarks")==null){
					travelBookedDetailsVo.setRemarks("-");
					
				}else{
					
					travelBookedDetailsVo.setRemarks(rs_not_approved_Boked.getString("Remarks"));
				}
				
				if(rs_not_approved_Boked.getString("DirectorRemarks")==null){
					
					travelBookedDetailsVo.setDiretorremarks("-");
					
				}else{
					
					travelBookedDetailsVo.setDiretorremarks(rs_not_approved_Boked.getString("DirectorRemarks"));
				}
				
				
				if(rs_not_approved_Boked.getString("isApprovedByDirector").equalsIgnoreCase("Y")){
				
				travelBookedDetailsVo.setStatus(MessageConstants.TRAVEL_BOOKING_APPROVED);
				travelBookedDetailsVo.setApprovedby(rs_not_approved_Boked.getString("directorName"));
				travelBookedDetailsVo.setApprovedtime(rs_not_approved_Boked.getString("approveddate"));
				
				}else if(rs_not_approved_Boked.getString("isApprovedByDirector").equalsIgnoreCase("R")){
					
					travelBookedDetailsVo.setStatus(MessageConstants.TRAVEL_BOOKING_REJECTED);
					travelBookedDetailsVo.setApprovedby(rs_not_approved_Boked.getString("directorName"));
					travelBookedDetailsVo.setApprovedtime(rs_not_approved_Boked.getString("approveddate"));
					
				}else{
					
					travelBookedDetailsVo.setStatus("Not Approved");
					travelBookedDetailsVo.setApprovedby("-");
					travelBookedDetailsVo.setApprovedtime("-");
				}
				
				if(rs_not_approved_Boked.getString("ApprovedAmount")!=null){
				travelBookedDetailsVo.setApproveAmount(rs_not_approved_Boked.getDouble("ApprovedAmount"));
				}
				
				tktList.add(travelBookedDetailsVo);
			}
			
				
			}else{
				
				

				ps_not_approved_Booked=connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_NOT_APPROVEDTKT_BY_ADMIN);
				ps_not_approved_Booked.setString(1, HelperClass.convertUIToDatabase(startDate));
				ps_not_approved_Booked.setString(2, HelperClass.convertUIToDatabase(endDate));
				
				rs_not_approved_Boked=ps_not_approved_Booked.executeQuery();
			
				while(rs_not_approved_Boked.next()){
					
					count++;
					
					ApproveTravelBookingVo travelBookedDetailsVo=new ApproveTravelBookingVo();
					
					travelBookedDetailsVo.setSno(count);
					
					travelBookedDetailsVo.setApprovedByBiocode(rs_not_approved_Boked.getString("directorBiocode"));
					travelBookedDetailsVo.setTkt_book_code(rs_not_approved_Boked.getString("TKTBookCode"));
					
					travelBookedDetailsVo.setBooked_by_empid(rs_not_approved_Boked.getString("Tkt_Booked_by_empcode"));
					String booked_by=getEmployee(rs_not_approved_Boked.getString("Tkt_Booked_by_empcode"),connection);
					travelBookedDetailsVo.setBooked_by_empname(booked_by);
					
					travelBookedDetailsVo.setTravel_mode(rs_not_approved_Boked.getString("mode"));
					
			
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
					travelBookedDetailsVo.setPosted_by(rs_not_approved_Boked.getString("postedbyName"));
					travelBookedDetailsVo.setPosted_by_id(rs_not_approved_Boked.getString("Posted_By"));
					travelBookedDetailsVo.setRemarks(rs_not_approved_Boked.getString("Remarks"));
					
					travelBookedDetailsVo.setApprovedby(rs_not_approved_Boked.getString("ApprovedDirectorCode"));
					travelBookedDetailsVo.setApprovedByName(rs_not_approved_Boked.getString("directorName"));
					
					travelBookedDetailsVo.setApprovedtime(rs_not_approved_Boked.getString("approveddate"));
					travelBookedDetailsVo.setDiretorremarks(rs_not_approved_Boked.getString("DirectorRemarks"));
					
					if(rs_not_approved_Boked.getString("isApprovedByAccounts").equalsIgnoreCase("Y")){
					
					travelBookedDetailsVo.setStatus(MessageConstants.TRAVEL_BOOKING_APPROVED);
					
					}else if(rs_not_approved_Boked.getString("isApprovedByAccounts").equalsIgnoreCase("R")){
						
						travelBookedDetailsVo.setStatus(MessageConstants.TRAVEL_BOOKING_REJECTED);
						
					}else{
						
						travelBookedDetailsVo.setStatus("Not Approved");
					}
					
					
					travelBookedDetailsVo.setApproveAmount(rs_not_approved_Boked.getDouble("ApprovedAmount"));
					
					tktList.add(travelBookedDetailsVo);
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
				
				if(rs_not_approved_Boked !=null && (!rs_not_approved_Boked.isClosed()))
				{
					rs_not_approved_Boked.close();
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
		logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingDaoImpl: getTktBkngDetailsForDounloadDao Ending");
	
		
		return tktList;
	}

	
	@Override
	public String approveAllTravelBookingDetailsDao(
			ApproveTravekBookingPojo pojo) {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : approveAllTravelBookingDetailsDao : Starting");

		PreparedStatement approveTktPstmt = null;
		int count=0;
		String status=null;
		
		Connection connection=null;
		
		PreparedStatement allowancesPstmt1=null;
		int mailUpdateCount=0;
		
		
		String[] bookingCode=	pojo.getApproveTktBookingCode().split(",");	
		try {
			
			connection =getConnection();
			
			if(pojo.getUsertype().equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				
				String[] approvedAmount=pojo.getApprovedamount().split(",");
				String[] directorRemarks=pojo.getRemarks().split("\\|");
				
			approveTktPstmt = connection.prepareStatement(ApproveTravelBookingSqlUtil.APPROVE_SINGLE_TKT);
			
			for(int i=0;i<bookingCode.length;i++){
				
			approveTktPstmt.setString(1, approvedAmount[i]);
			if("null".equalsIgnoreCase(directorRemarks[i])){
				
				approveTktPstmt.setString(2, "");
			}else{
			approveTktPstmt.setString(2, directorRemarks[i]);
			}
			approveTktPstmt.setString(3, pojo.getApprovedby().trim());
			approveTktPstmt.setTimestamp(4, HelperClass.getCurrentTimestamp());
			approveTktPstmt.setString(5, bookingCode[i]);
			
			
			count = approveTktPstmt.executeUpdate();
			
			}
			
			if(count>0){
				
				status=MessageConstants.TRUE;
				
				String url = getServerUrlFromBD(connection);
				String mailStatus = sendEmailToAccounts(pojo.getApproveTktBookingCode().trim(),pojo.getApprovedbyName(),url,"All");
				
				if(mailStatus.equalsIgnoreCase(MessageConstants.TRUE)){
					
					status=MessageConstants.MAIL_SENT;
				}
				
			}
			
			}else{
				
				
				String[] approvedAmount=pojo.getApprovedamount().split(",");
				String[] directorRemarks=pojo.getRemarks().split("\\|");
				
			approveTktPstmt = connection.prepareStatement(ApproveTravelBookingSqlUtil.APPROVE_TKTBY_ADMIN);
			
			for(int i=0;i<bookingCode.length;i++){
		
			approveTktPstmt.setString(1, pojo.getApprovedby().trim());
			approveTktPstmt.setTimestamp(2, HelperClass.getCurrentTimestamp());
			
			approveTktPstmt.setString(3, approvedAmount[i]);
			if("null".equalsIgnoreCase(directorRemarks[i])){
				
				approveTktPstmt.setString(4, "");
			}else{
			approveTktPstmt.setString(4, directorRemarks[i]);
			}
			approveTktPstmt.setString(5, bookingCode[i]);
			
			
			
			
			count = approveTktPstmt.executeUpdate();
			
			}
				
				if(count>0){
					
					status=MessageConstants.TRUE;
					
					String url = getServerUrlFromBD(connection);
					String mailStatus = sendEmailToAll(pojo.getApproveTktBookingCode().trim(),pojo.getApprovedbyName(),url);
					

					if(mailStatus.equalsIgnoreCase(MessageConstants.TRUE)){
						
						allowancesPstmt1 = connection.prepareStatement(ApproveTravelBookingSqlUtil.UPDATE_MAILSENT);
					
						for(int j=0;j<bookingCode.length;j++){
							
							allowancesPstmt1.setTimestamp(1, HelperClass.getCurrentTimestamp());
							allowancesPstmt1.setString(2, bookingCode[j]);
							
							
							mailUpdateCount=allowancesPstmt1.executeUpdate();
							
						}
						
						if(mailUpdateCount>0){
						status=MessageConstants.MAIL_SENT;
						}
					}
					
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
				
				
				if(approveTktPstmt != null && (!approveTktPstmt.isClosed())){
					
					approveTktPstmt.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
				}
				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : approveAllTravelBookingDetailsDao : Ending");

		return status;

	}
	
	
	public String sendEmailToManagerAndDirector(String allowanceCode, String approvedbyName,String url) {
		
		String mailStatus=null;
		try {
			
			ApproveTravelBookingMailDetailsVo vo=getTktBkMailDetails(allowanceCode, approvedbyName); 
			
			EmailContent em = new EmailContent();
			String[] mails = { vo.getManagerMail(),vo.getDirectMail()};

			em.setMailids(mails);
			em.setSubject("Allowance Approvel Details");

			em.setMessage("Greetings from TeleIndia. \n\n"
					+ "Travel Booking approved successfully. \n\n"
					+ "Booked By : "+vo.getEmpname()+"\n"
					+ "Booked Date : "+HelperClass.convertDatabaseToUI(vo.getDate())+"\n"
					+ "Claimed Amount : "+vo.getCliamedAmount()+"\n"
					+ "Approved Amount : "+vo.getAmount().trim()+". \n\n"
					+ "Travel Booking Approved  By :  \n"
					+ "Name : "+vo.getApprovedName().trim()+". \n"
					+ "Designation : Admin. \n\n"
					+ "For more Details Login URL : " + url + "\n\n"
					+ "Have a nice day \n\n"
					+ "E-ATTENDANCE PRO  \n"
					+ "----------------------------------------------------------\n"
					+ "This is system generated mail,Please do not reply");
			
			mailStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return mailStatus;
	}
	
	
	public String sendEmailToAll(String allowanceCode, String approvedbyName,String url) {
	
		Connection connection=null;
		String mailStatus=null;
		try {
				
			connection = getConnection() ;
			//send mail to directors

			LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>> diremap=getDirewiseEmptravelDetails(allowanceCode,connection,"director");
			
			 Set<String>  keys =  diremap.keySet();
			 
			 for (String direcode : keys) {
				 
				 String direEmailId =getDirectorEmailId(direcode,connection);
				 
				 final StringBuilder sb = new TravelAllowanceInAdmin().getEmpFormatTable(diremap.get(direcode));
				 
					EmailContent em = new EmailContent();
					
					String[] diremail = {direEmailId};
					
					em.setMailids(diremail);
					em.setSubject("Travel Booking Approvel Details");

					em.setMessage("Greetings from TeleIndia "+"<html><br/><br/></html>"
							+ "All your Travel Booking Details Approved Successfully "+"<html><br/><br/></html>"
							+ "Travel Booking Approved  By :  "+"<html><br/></html>"
							+ "Name : "+approvedbyName.trim()+" "+"<html><br/></html>"
							+ "Designation : Accountant. "+"<html><br/><br/></html>"
							+ "For more Details Please find the below Table or  Login URL : " + url +"<html><br/><br/></html>"
							+ sb.toString() +"<html><br/><br/></html>"
							+ "Have a nice day "+"<html><br/><br/></html>"
							+ "E-ATTENDANCE PRO  "+"<html><br/></html>"
							+ "----------------------------------------------------------"+"<html><br/></html>"
							+ "This is system generated mail,Please do not reply");
					
					mailStatus=new SendMailWithMultipleAttachment().sendReportToMailAllowances(em);
				
			}
			
			 //send mail to managers
			 if(mailStatus.equals("true")){
				 
				 
					LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>> mangmaptraveldetails = getDirewiseEmptravelDetails(allowanceCode,connection,"manager");
					
					 Set<String>  mangkeys =  mangmaptraveldetails.keySet();
				 
					 for (String postedby : mangkeys) {
						 
						Map<String,String>  mangmap = getManagerDetailsById(postedby, connection);
						
						String mangEmailid = mangmap.get("email");
						 
						 final StringBuilder sb1 = new TravelAllowanceInAdmin().getEmpFormatTable(mangmaptraveldetails.get(postedby));
					 
							EmailContent em = new EmailContent();
							
							String[] mangmail = {mangEmailid};
							
							em.setMailids(mangmail);
							em.setSubject("Travel Booking Approvel Details");

							em.setMessage("Greetings from TeleIndia "+"<html><br/><br/></html>"
									+ "All your Travel Booking Details Approved Successfully "+"<html><br/><br/></html>"
									+ "Travel Booking Approved  By :  "+"<html><br/></html>"
									+ "Name : "+approvedbyName.trim()+" "+"<html><br/></html>"
									+ "Designation : Accountant. "+"<html><br/><br/></html>"
									+ "For more Details Please find the below Table or  Login URL : " + url +"<html><br/><br/></html>"
									+ sb1.toString() +"<html><br/><br/></html>"
									+ "Have a nice day "+"<html><br/><br/></html>"
									+ "E-ATTENDANCE PRO  "+"<html><br/></html>"
									+ "----------------------------------------------------------"+"<html><br/></html>"
									+ "This is system generated mail,Please do not reply");
							
							mailStatus=new SendMailWithMultipleAttachment().sendReportToMailAllowances(em);
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
				
						
				if(connection != null && (!connection.isClosed())){

					connection.close();
				}
				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

		return mailStatus;
	}

	
	private LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>> getDirewiseEmptravelDetails(String allowanceCode, Connection connection, String mailto) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : getEmpTravelInfoByAdmin : Starting");

		PreparedStatement ps_getemptrvel = null;
	
		ResultSet rs_getemptrvel=null;
		int count=0;
		ArrayList<ApproveTravelBookingVo> emptravellist=new ArrayList<ApproveTravelBookingVo>();
		
		LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>> diremap = new LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>>();
		try {
			
					
			String[] tktcode=allowanceCode.split(",");
			
		for (int j = 0; j < tktcode.length; j++) {
				
			if(mailto.equalsIgnoreCase("director")){
				
				ps_getemptrvel = connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_DIRE_WISE_EMP_INFO_FROM_TEVAL_BOOKING);
				
				ps_getemptrvel.setString(1, tktcode[j]);
				
				rs_getemptrvel=ps_getemptrvel.executeQuery();
				
				while(rs_getemptrvel.next()){
					
				if(emptravellist.size()!=0){	
					
					if( !(emptravellist.get(emptravellist.size()-1).getApproveDireCode().equalsIgnoreCase(rs_getemptrvel.getString("ApprovedDirectorCode")))){
						
						count =0;
						
						emptravellist=new ArrayList<ApproveTravelBookingVo>();
						
					}
				}
					count++;
					ApproveTravelBookingVo approveTktbookingVo = new ApproveTravelBookingVo();
					
					approveTktbookingVo.setSno(count);
					approveTktbookingVo.setWho_on_travel_bioid(rs_getemptrvel.getString("resource_who_on_travel_bioid"));
					approveTktbookingVo.setWho_on_travel_empname(rs_getemptrvel.getString("First_Name"));
					approveTktbookingVo.setProject_Ref_code(rs_getemptrvel.getString("ProjectRefCode"));
					approveTktbookingVo.setAmount(rs_getemptrvel.getDouble("Amount"));
					approveTktbookingVo.setPosted_by(rs_getemptrvel.getString("FirstName"));
					
					approveTktbookingVo.setApproveAmount(rs_getemptrvel.getDouble("ApprovedAmount"));
					approveTktbookingVo.setApproveDireCode(rs_getemptrvel.getString("ApprovedDirectorCode"));
					approveTktbookingVo.setAccountApproveAmt(rs_getemptrvel.getDouble("AccountApprovedAmount"));
					approveTktbookingVo.setBooked_date(HelperClass.convertDatabaseToUI(rs_getemptrvel.getString("Booked_date")));
					
					emptravellist.add(approveTktbookingVo);
				}
				
				diremap.put(emptravellist.get(emptravellist.size()-1).getApproveDireCode(), emptravellist);
				
				
			}else{
				
				ps_getemptrvel = connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_ADMIN_APPROVED_MANG_WISE_EMP_TEVAL_BOOKING_);
				
	             ps_getemptrvel.setString(1, tktcode[j]);
				
				rs_getemptrvel=ps_getemptrvel.executeQuery();
				
				while(rs_getemptrvel.next()){
					
				if(emptravellist.size()!=0){	
							
					if(!(emptravellist.get(emptravellist.size()-1).getPosted_by_id().equalsIgnoreCase(rs_getemptrvel.getString("Posted_By")))){
						
						count =0;
						
						emptravellist=new ArrayList<ApproveTravelBookingVo>();
						
					}
				}
					count++;
					ApproveTravelBookingVo approveTktbookingVo = new ApproveTravelBookingVo();
					
					approveTktbookingVo.setSno(count);
					approveTktbookingVo.setWho_on_travel_bioid(rs_getemptrvel.getString("resource_who_on_travel_bioid"));
					approveTktbookingVo.setWho_on_travel_empname(rs_getemptrvel.getString("First_Name"));
					approveTktbookingVo.setProject_Ref_code(rs_getemptrvel.getString("ProjectRefCode"));
					approveTktbookingVo.setAmount(rs_getemptrvel.getDouble("Amount"));
					approveTktbookingVo.setPosted_by(rs_getemptrvel.getString("FirstName"));
					approveTktbookingVo.setApproveAmount(rs_getemptrvel.getDouble("ApprovedAmount"));
					approveTktbookingVo.setPosted_by_id(rs_getemptrvel.getString("Posted_By"));
					approveTktbookingVo.setAccountApproveAmt(rs_getemptrvel.getDouble("AccountApprovedAmount"));
					approveTktbookingVo.setBooked_date(HelperClass.convertDatabaseToUI(rs_getemptrvel.getString("Booked_date")));
					
					emptravellist.add(approveTktbookingVo);
				}
				
				diremap.put(emptravellist.get(emptravellist.size()-1).getPosted_by_id(), emptravellist);
				
				
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
				
				if(rs_getemptrvel != null && (!rs_getemptrvel.isClosed())){
					
					rs_getemptrvel.close();
				}
              
				if(ps_getemptrvel != null && (!ps_getemptrvel.isClosed())){
					
            	   ps_getemptrvel.close();
				}
			
				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : getEmpTravelInfoByAdmin : Ending");

		
		return diremap;
	}


	public String sendEmailToAccounts(String allowanceCode, String approvedbyName,String url,String mailto) {
	
	String mailStatus=null;
	
	Connection connection = null;
	
	try {
		
		connection = getConnection();
		EmailContent em = new EmailContent();
		
		ApproveTravelBookingMailDetailsVo managervo=getTktBkMailDetails(allowanceCode, approvedbyName); 
		
		//String[] mails = { vo.getManagerMail(),vo.getDirectMail()};
		
		ArrayList<String> mailList=getAdminMailDetails();
		
	
		
		if(mailto.equalsIgnoreCase("single")){
			
			String[] mails =new String[mailList.size()+1];
			
			for(int i=0;i<mailList.size();i++){
				
				mails[i]=mailList.get(i);
			}
			

			for(int j=0;j<mails.length;j++){
				
				if(!(mails[j].equalsIgnoreCase(managervo.getManagerMail()))){
					
					mails[mailList.size()]=managervo.getManagerMail();
				}
			}

		
	
			ApproveTravelBookingMailDetailsVo vo=getTktBkMailDetails(allowanceCode, approvedbyName);

			em.setMailids(mails);
			
			em.setSubject("Travel Booking Approvel Details");
			
		    em.setMessage("Greetings from TeleIndia. \n\n"
				+ "Travel Booking approved successfully. \n\n"
				+ "Booked By : "+vo.getEmpname()+"\n"
				+ "Booked Date : "+HelperClass.convertDatabaseToUI(vo.getDate())+"\n"
				+ "Claimed Amount : "+vo.getCliamedAmount()+"\n"
				+ "Approved Amount : "+vo.getAmount().trim()+". \n\n"
				+ "Travel Booking Approved  By :  \n"
				+ "Name : "+vo.getApprovedName().trim()+". \n"
				+ "Designation : Director. \n\n"
				+ "For more Details Login URL : " + url + "\n"
				+ "Approve the  Ticket Booking Details \n\n"
				+ "Have a nice day \n\n"
				+ "E-ATTENDANCE PRO  \n"
				+ "----------------------------------------------------------\n"
				+ "This is system generated mail,Please do not reply");
		
		mailStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
	
		}else{
			//send mail to admin
			ArrayList<ApproveTravelBookingVo> emptravellist = getEmpTravelInfo(allowanceCode);
			
			final StringBuilder sb = new TravelAllowanceUtil().getEmpFormatTable(emptravellist);
		
			String[] mails =new String[mailList.size()];
			
	        for(int i=0;i<mailList.size();i++){
				
				  mails[i]=mailList.get(i);
			}
		
		        em.setMailids(mails);
				em.setSubject("Travel Booking Approvel Details");
			
		        em.setMessage("Greetings from TeleIndia "+"<html><br/><br/></html>"
				+ "All Travel Booking Details Approved Successfully "+"<html><br/><br/></html>"
				+ "Travel Booking Approved  By :  "+"<html><br/></html>"
				+ "Name : "+approvedbyName.trim()+"<html><br/></html>"
				+ "Designation : Director. "+"<html><br/><br/></html>"
				+ "For more Details Please find the below Table or Login URL : " + url + "<html><br/></html>"
				+  sb.toString() +"<html><br/><br/></html>"
				+ "Approve the  Ticket Booking Details "+"<html><br/><br/></html>"
				+ "Have a nice day "+"<html><br/><br/></html>"
				+ "E-ATTENDANCE PRO  "+"<html><br/></html>"
				+ "----------------------------------------------------------"+"<html><br/></html>"
				+ "This is system generated mail,Please do not reply");
		
		
		
		   mailStatus=new SendMailWithMultipleAttachment().sendReportToMailAllowances(em);
		
		   //send mail to managers
		   if(mailStatus.equals("true")){
			   
				LinkedHashMap<String,ArrayList<ApproveTravelBookingVo>> mangwiseempallowance = getMangmapEmptraveldetails(allowanceCode,connection);
				
			   Set<String>   keys =	mangwiseempallowance.keySet();
			
			  for (String postedby : keys) {
				   
				Map<String,String> mangmap=getManagerDetailsById(postedby, connection) ;  
				   
				String mangEmailId=mangmap.get("email");
				 
				final StringBuilder sb1 = new TravelAllowanceUtil().getEmpFormatTable(mangwiseempallowance.get(postedby));
				
				String[] mangMail={mangEmailId};
			
			        em.setMailids(mangMail);
					em.setSubject("Travel Booking Approvel Details");
				
			        em.setMessage("Greetings from TeleIndia "+"<html><br/><br/></html>"
					+ "All Travel Booking Details Approved Successfully "+"<html><br/><br/></html>"
					+ "Travel Booking Approved  By :  "+"<html><br/></html>"
					+ "Name : "+approvedbyName.trim()+"<html><br/></html>"
					+ "Designation : Director. "+"<html><br/><br/></html>"
					+ "For more Details Please find the below Table or Login URL : " + url + "<html><br/></html>"
					+  sb1.toString() +"<html><br/><br/></html>"
					+ "Verify the Ticket Booking Details "+"<html><br/><br/></html>"
					+ "Have a nice day "+"<html><br/><br/></html>"
					+ "E-ATTENDANCE PRO  "+"<html><br/></html>"
					+ "----------------------------------------------------------"+"<html><br/></html>"
					+ "This is system generated mail,Please do not reply");
			
			   mailStatus=new SendMailWithMultipleAttachment().sendReportToMailAllowances(em);
				   
			}
	   }

		}
		
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	
	
	
	return mailStatus;
}

	
	public LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>> getMangmapEmptraveldetails(
			String allowanceCode, Connection connection) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : getMangmapEmptraveldetails : Starting");

		PreparedStatement ps_getemptrvel = null;
	
		ResultSet rs_getemptrvel=null;
		int count=0;
		ArrayList<ApproveTravelBookingVo> emptravellist=new ArrayList<ApproveTravelBookingVo>();
		LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>> maplist = new LinkedHashMap<String, ArrayList<ApproveTravelBookingVo>>();
		try {
			
						
			String[] tktcode=allowanceCode.split(",");
			
			for (int j = 0; j < tktcode.length; j++) {
				
				ps_getemptrvel = connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_MANG_WISE_EMP_INFO_FROM_TEVAL_BOOKING);
				
				ps_getemptrvel.setString(1, tktcode[j]);
				
				rs_getemptrvel=ps_getemptrvel.executeQuery();
				
				
				while(rs_getemptrvel.next()){
					
					if(emptravellist.size()!=0){
					
					if( !(emptravellist.get(emptravellist.size()-1).getPosted_by_id().equalsIgnoreCase(rs_getemptrvel.getString("Posted_By")))){
						
						count=0;
						emptravellist=new ArrayList<ApproveTravelBookingVo>();
					}
					}
					count++;
					ApproveTravelBookingVo approveTktbookingVo = new ApproveTravelBookingVo();
					
					approveTktbookingVo.setSno(count);
					approveTktbookingVo.setWho_on_travel_bioid(rs_getemptrvel.getString("resource_who_on_travel_bioid"));
					approveTktbookingVo.setWho_on_travel_empname(rs_getemptrvel.getString("First_Name"));
					approveTktbookingVo.setProject_Ref_code(rs_getemptrvel.getString("ProjectRefCode"));
					approveTktbookingVo.setAmount(rs_getemptrvel.getDouble("Amount"));
					approveTktbookingVo.setApproveAmount(rs_getemptrvel.getDouble("ApprovedAmount"));
					approveTktbookingVo.setBooked_date(HelperClass.convertDatabaseToUI(rs_getemptrvel.getString("Booked_date")));
					approveTktbookingVo.setPosted_by_id(rs_getemptrvel.getString("Posted_By"));
					
					emptravellist.add(approveTktbookingVo);
				}
				
				maplist.put(emptravellist.get(emptravellist.size()-1).getPosted_by_id(), emptravellist);
				
			}
			
		
			
		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);
			sqle.printStackTrace();

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
			
		} finally {

			try {
				
				if(rs_getemptrvel != null && (!rs_getemptrvel.isClosed())){
					
					rs_getemptrvel.close();
				}
              
				if(ps_getemptrvel != null && (!ps_getemptrvel.isClosed())){
					
            	   ps_getemptrvel.close();
				}
		
				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

	
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : getMangmapEmptraveldetails : Ending");

		
		return maplist;
	}


	public ArrayList<ApproveTravelBookingVo> getEmpTravelInfo(String allowanceCode) {


		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : getEmpTravelInfo : Starting");

		PreparedStatement ps_getemptrvel = null;
		Connection connection=null;
		ResultSet rs_getemptrvel=null;
		int count=0;
		ArrayList<ApproveTravelBookingVo> emptravellist=new ArrayList<ApproveTravelBookingVo>();
		try {
			
			connection=getConnection();
			
			String[] tktcode=allowanceCode.split(",");
			
			for (int j = 0; j < tktcode.length; j++) {
				
				ps_getemptrvel = connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_EMP_INFO_FROM_TEVAL_BOOKING);
				
				ps_getemptrvel.setString(1, tktcode[j]);
				
				rs_getemptrvel=ps_getemptrvel.executeQuery();
				
				while(rs_getemptrvel.next()){
					count++;
					ApproveTravelBookingVo approveTktbookingVo = new ApproveTravelBookingVo();
					
					approveTktbookingVo.setSno(count);
					approveTktbookingVo.setWho_on_travel_bioid(rs_getemptrvel.getString("resource_who_on_travel_bioid"));
					approveTktbookingVo.setWho_on_travel_empname(rs_getemptrvel.getString("First_Name"));
					approveTktbookingVo.setProject_Ref_code(rs_getemptrvel.getString("ProjectRefCode"));
					approveTktbookingVo.setAmount(rs_getemptrvel.getDouble("Amount"));
					approveTktbookingVo.setApproveAmount(rs_getemptrvel.getDouble("ApprovedAmount"));
					approveTktbookingVo.setBooked_date(HelperClass.convertDatabaseToUI(rs_getemptrvel.getString("Booked_date")));
					
					emptravellist.add(approveTktbookingVo);
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
				
				if(rs_getemptrvel != null && (!rs_getemptrvel.isClosed())){
					
					rs_getemptrvel.close();
				}
              
				if(ps_getemptrvel != null && (!ps_getemptrvel.isClosed())){
					
            	   ps_getemptrvel.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
				}
				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : getEmpTravelInfo : Ending");

		
		return emptravellist;
	}


	public ArrayList<String> getAllMailIds(String allowanceCode){
	

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ApproveTravelBookingDaoImpl : getAllMailIds : Starting");

	PreparedStatement approveTktPstmt = null;
	Connection connection=null;
	ResultSet rs=null;
	ArrayList<String> mailId=new ArrayList<String>();
	try {
		
		connection=getConnection();
		approveTktPstmt = connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_ALL_MAIL_IDS);
		if(allowanceCode!=null){
			String[] codeArray=allowanceCode.split((","));
			
		for(int i=0;i<codeArray.length;i++){
			
		approveTktPstmt.setString(1, codeArray[i]);
		
		
		rs=approveTktPstmt.executeQuery();
		
		while(rs.next()){
			
			if(mailId.size()!=0){
				
				if(!(mailId.contains(rs.getString("Username")))){
					
					mailId.add(rs.getString("Username"));
					
				}
				
				if(!(mailId.contains(rs.getString("email")))){
					
					mailId.add(rs.getString("email"));
					
				}
			}else{
				
					
					mailId.add(rs.getString("Username"));
				
					mailId.add(rs.getString("email"));
			}
		}
		
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
			
			
			if(approveTktPstmt != null && (!approveTktPstmt.isClosed())){
				
				approveTktPstmt.close();
			}
			if(connection != null && (!connection.isClosed())){

				connection.close();
			}
			
		} catch (SQLException e) {

			logger.error(e.getMessage(),e);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ApproveTravelBookingDaoImpl : getAllMailIds : Ending");

	
	return mailId;
	
}

	
	public ArrayList<String> getAdminMailDetails(){
	

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ApproveTravelBookingDaoImpl : getAdminMailDetails : Starting");

	PreparedStatement approveTktPstmt = null;
	Connection connection=null;
	ResultSet rs=null;
	ArrayList<String> mailId=new ArrayList<String>();
	try {
		
		connection=getConnection();
		approveTktPstmt = connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_ADMIN_MAIL_DETAILS);
		
		rs=approveTktPstmt.executeQuery();
		
		while(rs.next()){
			
			mailId.add(rs.getString("AccMailId"));
			
		}
		
	} catch (SQLException sqle) {

		logger.error(sqle.getMessage(),sqle);
		sqle.printStackTrace();

	} catch (Exception e) {
		logger.error(e.getMessage(),e);
		e.printStackTrace();
		
	} finally {

		try {
			
			
			if(approveTktPstmt != null && (!approveTktPstmt.isClosed())){
				
				approveTktPstmt.close();
			}
			if(connection != null && (!connection.isClosed())){

				connection.close();
			}
			
		} catch (SQLException e) {

			logger.error(e.getMessage(),e);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in ApproveTravelBookingDaoImpl : getAdminMailDetails : Ending");

	
	return mailId;
	
}


	@Override
	public String rejectSingleTicketDao(ApproveTravekBookingPojo pojo) {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : rejectSingleTicketDao : Starting");

		PreparedStatement approveTktPstmt = null;
		int count=0;
		String status=null;
		
		PreparedStatement allowancesPstmt1=null;
		int mailUpdateCount=0;
	
		
		Connection connection=null;
		
		try {
			
			connection =getConnection();
			
			if(pojo.getUsertype().equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				
			approveTktPstmt = connection.prepareStatement(ApproveTravelBookingSqlUtil.REJECTTKTBK_BY_DIRECTOR);
			approveTktPstmt.setString(1, pojo.getApprovedamount().trim());
			approveTktPstmt.setString(2, pojo.getRemarks().trim());
			approveTktPstmt.setString(3, pojo.getApprovedby().trim());
			approveTktPstmt.setTimestamp(4, HelperClass.getCurrentTimestamp());
			approveTktPstmt.setString(5, pojo.getApproveTktBookingCode().trim());
			
			count = approveTktPstmt.executeUpdate();
			
			if(count>0){
				
				status=MessageConstants.TRUE;
				
				String url = getServerUrlFromBD(connection);
				String mailStatus = sendEmailToAccountsReject(pojo.getApproveTktBookingCode().trim(),pojo.getApprovedbyName(),url,"single");
				
				if(mailStatus.equalsIgnoreCase(MessageConstants.TRUE)){
					
					allowancesPstmt1 = connection.prepareStatement(ApproveTravelBookingSqlUtil.UPDATE_MAILSENT);
					allowancesPstmt1.setTimestamp(1, HelperClass.getCurrentTimestamp());
					allowancesPstmt1.setString(2, pojo.getApproveTktBookingCode());
					
					mailUpdateCount=allowancesPstmt1.executeUpdate();
					if(mailUpdateCount>0){
						
						status=MessageConstants.MAIL_SENT;
					}
					
					
				}
			}
			
			}else{
				
				approveTktPstmt = connection.prepareStatement(ApproveTravelBookingSqlUtil.REJECTTKTBK_BY_ADMIN);
				approveTktPstmt.setString(1, pojo.getApprovedby().trim());
				approveTktPstmt.setTimestamp(2, HelperClass.getCurrentTimestamp());
				approveTktPstmt.setString(3, pojo.getApproveTktBookingCode().trim());
				
				count = approveTktPstmt.executeUpdate();
				
				if(count>0){
					
					status=MessageConstants.TRUE;
					
					String url = getServerUrlFromBD(connection);
					String mailStatus = sendRejectEmailToManagerAndDirector(pojo.getApproveTktBookingCode().trim(),pojo.getApprovedbyName(),url);
					

					if(mailStatus.equalsIgnoreCase(MessageConstants.TRUE)){
						
						allowancesPstmt1 = connection.prepareStatement(ApproveTravelBookingSqlUtil.UPDATE_MAILSENT);
						allowancesPstmt1.setTimestamp(1, HelperClass.getCurrentTimestamp());
						allowancesPstmt1.setString(2, pojo.getApproveTktBookingCode());
						
						mailUpdateCount=allowancesPstmt1.executeUpdate();
						if(mailUpdateCount>0){
							
							status=MessageConstants.MAIL_SENT;
						}
						
						
					}
					
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
				
				if(approveTktPstmt != null && (!approveTktPstmt.isClosed())){
					
					approveTktPstmt.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
				}
				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : rejectSingleTicketDao : Ending");

		return status;

	}
	
	
	
	public String sendEmailToAccountsReject(String allowanceCode, String approvedbyName,String url,String mailto) {
		
	String mailStatus=null;
	try {
		
		EmailContent em = new EmailContent();
		
		ApproveTravelBookingMailDetailsVo managervo=getTktBkMailDetails(allowanceCode, approvedbyName); 
		
		ArrayList<String> mailList=getAdminMailDetails();
		
		em.setSubject("Travel Booking Reject Details");
		
			String[] mails =new String[mailList.size()+1];
			
			for(int i=0;i<mailList.size();i++){
				
				mails[i]=mailList.get(i);
			}
			
			for(int j=0;j<mails.length;j++){
				
				if(!(mails[j].equalsIgnoreCase(managervo.getManagerMail()))){
					
					mails[mailList.size()]=managervo.getManagerMail();
				}
			}
			
		
			
			em.setMailids(mails);
			
			ApproveTravelBookingMailDetailsVo vo=getTktBkMailDetails(allowanceCode, approvedbyName);

		
		em.setMessage("Greetings from TeleIndia. \n\n"
				+ "Travel Booking Details rejected By: \n"
				+ "Name : "+vo.getApprovedName().trim()+". \n"
				+ "Designation : Director. \n\n"
				+ "Travel Booking Details :"
				+ "Booked By : "+vo.getEmpname()+"\n"
				+ "Booked Date : "+HelperClass.convertDatabaseToUI(vo.getDate())+"\n"
				+ "Claimed Amount : "+vo.getCliamedAmount()+"\n"
				+ "For more Details Login URL : " + url + "\n\n"
				+ "Have a nice day \n\n"
				+ "E-ATTENDANCE PRO  \n"
				+ "----------------------------------------------------------\n"
				+ "This is system generated mail,Please do not reply");
		
		
		
		mailStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
		
		
	} catch (Exception e) {
		logger.error(e.getMessage(), e);
		e.printStackTrace();
	}
	return mailStatus;
}
	

	public ArrayList<String> getMgrMailForAllApprove(String allowanceCode){
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : getMgrMailForAllApprove : Starting");

		PreparedStatement approveTktPstmt = null;
		Connection connection=null;
		ResultSet rs=null;
		ArrayList<String> mailId=new ArrayList<String>();
		try {
			
			connection=getConnection();
			approveTktPstmt = connection.prepareStatement(ApproveTravelBookingSqlUtil.GET_MGRMAIL_ALLAPRROVE);
			if(allowanceCode!=null){
				String[] codeArray=allowanceCode.split((","));
				
			for(int i=0;i<codeArray.length;i++){
				
			approveTktPstmt.setString(1, codeArray[i]);
			
			
			rs=approveTktPstmt.executeQuery();
			
			while(rs.next()){
				
				if(mailId.size()!=0){
					
					
					if(!(mailId.contains(rs.getString("email")))){
						
						mailId.add(rs.getString("email"));
						
					}
				}else{
					
					if(!(mailId.contains(rs.getString("email")))){
						
						mailId.add(rs.getString("email"));
						
					}
				}
			}
			
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
				
				
				if(approveTktPstmt != null && (!approveTktPstmt.isClosed())){
					
					approveTktPstmt.close();
				}
				if(connection != null && (!connection.isClosed())){

					connection.close();
				}
				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in ApproveTravelBookingDaoImpl : getMgrMailForAllApprove : Ending");

		
		return mailId;
		
	}
	
	public String sendRejectEmailToManagerAndDirector(String allowanceCode, String approvedbyName,String url) {
		
		String mailStatus=null;
		try {
			
			ApproveTravelBookingMailDetailsVo vo=getTktBkMailDetails(allowanceCode, approvedbyName); 
			
			EmailContent em = new EmailContent();
			String[] mails = { vo.getManagerMail(),vo.getDirectMail()};

			em.setMailids(mails);
			em.setSubject("Travel Booking Rejected Details");

			
			em.setMessage("Greetings from TeleIndia. \n\n"
					+ "Travel Booking Details rejected By: \n"
					+ "Name : "+vo.getApprovedName().trim()+". \n"
					+ "Designation : Admin. \n\n"
					+ "Travel Booking Details :"
					+ "Booked By : "+vo.getEmpname()+"\n"
					+ "Booked Date : "+HelperClass.convertDatabaseToUI(vo.getDate())+"\n"
					+ "Claimed Amount : "+vo.getCliamedAmount()+"\n"
					+ "For more Details Login URL : " + url + "\n\n"
					+ "Have a nice day \n\n"
					+ "E-ATTENDANCE PRO  \n"
					+ "----------------------------------------------------------\n"
					+ "This is system generated mail,Please do not reply");
			
			mailStatus=new SendMailWithMultipleAttachment().sendReportToMail(em);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return mailStatus;
	}
	
	 public  Map<String,String> getManagerDetailsById(String managerId,Connection connection) {

			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingDaoImpl: getManagerDetailsById : Starting");
			
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			Map<String,String> managerMap= new HashMap<String, String>();
			try {
				
				ps = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_MANAGER);
				ps.setString(1, managerId.trim());
				
				rs = ps.executeQuery();

					while(rs.next()){
						managerMap.put("FirstName", rs.getString("FirstName").trim());
						managerMap.put("LastName", rs.getString("LastName"));
						managerMap.put("email", rs.getString("email").trim());
						managerMap.put("phoneno", rs.getString("phoneno").trim());
						managerMap.put("Username", rs.getString("Username").trim());
						managerMap.put("Password", rs.getString("password").trim());
						
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
			logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingDaoImpl: getManagerDetailsById : Ending");
			
			return managerMap;
			
	  }
	  

		public  String getDirectorEmailId(String directorcode, Connection connection) {
			
			logger.setLevel(Level.DEBUG);
			JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
			logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingDaoImpl: getDirectorEmailId  Starting");
		
			PreparedStatement ps_employee = null;
			ResultSet rs_employee=null;
			String direEmailId=null;
			
			try{
				ps_employee=connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_DIRECTOR_EMAIL_ID);
				ps_employee.setString(1,directorcode);
				rs_employee=ps_employee.executeQuery();
				
				while(rs_employee.next()){
				
					direEmailId=rs_employee.getString("Username");
					
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
			logger.info(JDate.getTimeString(new Date())+ " Control in ApproveTravelBookingDaoImpl : getDirectorEmailId Ending");
			
		
			return direEmailId;
		}
		
		
	public static void main(String[] args){
			
			String s="TBK1,TBK2,TBK3,TBK4,TBK5";
			
			
			Connection connection=null;
			 try {
				connection=getConnection();
				
				String url = new ApproveTravelBookingDaoImpl().getServerUrlFromBD(connection);
				
			         new ApproveTravelBookingDaoImpl().getDirewiseEmptravelDetails(s,connection,"director");
			         
			         new ApproveTravelBookingDaoImpl().getDirewiseEmptravelDetails(s,connection,"all");
			//	new ApproveTravelBookingDaoImpl().getMangmapEmptraveldetails(s,connection);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		}
		
	 
}
