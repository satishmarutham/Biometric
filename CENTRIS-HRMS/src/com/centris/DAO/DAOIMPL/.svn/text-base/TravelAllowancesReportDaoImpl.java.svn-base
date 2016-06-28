package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.DAO.TravelAllowancesReportDao;
import com.centris.POJO.TravelAllowancesReportPojo;
import com.centris.VO.EmployeeAllowanceReportVO;
import com.centris.VO.TravelAllowancesReportVo;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.EmployeeAllowanceReportSqlUtil;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.SQLUtils.TravelAllowancesReportSqlUtil;
import com.centris.util.constants.MessageConstants;

public class TravelAllowancesReportDaoImpl extends DBService implements TravelAllowancesReportDao{

	private static Logger logger = Logger.getLogger(TravelAllowancesReportDaoImpl.class);
	
	public Map<String, ArrayList<TravelAllowancesReportVo>> getTravelAllowancesManagerWiseDao(
			TravelAllowancesReportPojo travelAllowanceReportPojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelAllowancesReportDaoImpl: getTravelAllowancesManagerWiseDao Starting");
		
		Connection connection = null;
		PreparedStatement ps_traallownace = null;
		ResultSet rs_traallownace=null;
		int count=0;
		
		Map<String, ArrayList<TravelAllowancesReportVo>> travelallownacesmap=new LinkedHashMap<String, ArrayList<TravelAllowancesReportVo>>();
		ArrayList<TravelAllowancesReportVo> travelallowancelist=new  ArrayList<TravelAllowancesReportVo>();
		
		try{
		
			connection=getConnection();
			ps_traallownace=connection.prepareStatement(TravelAllowancesReportSqlUtil.GET_TRAVEL_ALLOWANCES_MANAGER_WISE);
			
			ps_traallownace.setString(1, travelAllowanceReportPojo.getCurrusercode());
			ps_traallownace.setString(2, travelAllowanceReportPojo.getStatus());
			ps_traallownace.setString(3, HelperClass.convertUIToDatabase(travelAllowanceReportPojo.getFromdate()));
			ps_traallownace.setString(4, HelperClass.convertUIToDatabase(travelAllowanceReportPojo.getTodate()));
			
			rs_traallownace=ps_traallownace.executeQuery();
			
			while (rs_traallownace.next()) {
				
				TravelAllowancesReportVo travelReportVo =new TravelAllowancesReportVo();
				
				if(travelallowancelist.size()!=0){
					
                        if(!(travelallowancelist.get(travelallowancelist.size()-1).getPostedby().equalsIgnoreCase(rs_traallownace.getString("Posted_By")))){
						
                        	travelallownacesmap.put(travelallowancelist.get(travelallowancelist.size()-1).getPostedbyname(), travelallowancelist);
						
						count=0;
						travelallowancelist=new ArrayList<TravelAllowancesReportVo>();
					}
				}
				
				count++;
				
				travelReportVo.setSno(count);
				
				travelReportVo.setTicketbookedbyempcode(rs_traallownace.getString("Tkt_Booked_by_empcode"));
				travelReportVo.setTicketbokedby(rs_traallownace.getString("empname"));
				
		     	if(travelReportVo.getTicketbookedbyempcode().equalsIgnoreCase(rs_traallownace.getString("resource_who_on_travel_empcode"))){
						travelReportVo.setWhoisontravel(travelReportVo.getTicketbokedby());
				}else{
						travelReportVo.setWhoisontravel(getEmpname(connection,rs_traallownace.getString("resource_who_on_travel_empcode"),""));
				}
				
                travelReportVo.setPostedamount(rs_traallownace.getDouble("Amount"));
                travelReportVo.setMode(rs_traallownace.getString("mode"));
                travelReportVo.setPostedby(rs_traallownace.getString("Posted_By"));
                travelReportVo.setPostedbyname(rs_traallownace.getString("postedbyname"));
                
                if(travelReportVo.getPostedby().equalsIgnoreCase(rs_traallownace.getString("Project_Manager"))){
                	
                	travelReportVo.setProjectmanager(travelReportVo.getPostedbyname());
                }else{
                	
                	travelReportVo.setProjectmanager(getEmpname(connection, rs_traallownace.getString("Project_Manager"),LoginDetails.MANAGER_ID_TYPE));
                }
                
                travelReportVo.setProjectrefcode(rs_traallownace.getString("ProjectRefCode"));
                travelReportVo.setTravelfrom(rs_traallownace.getString("Traveling_From"));
                travelReportVo.setTravelto(rs_traallownace.getString("Traveling_To"));
                travelReportVo.setBookingdate(HelperClass.convertDatabaseToUI(rs_traallownace.getString("Booked_date")));
                travelReportVo.setTravellingdate(HelperClass.convertDatabaseToUI(rs_traallownace.getString("Travelling_Date")));
                travelReportVo.setPosteddate(HelperClass.convertDatabaseToUI(rs_traallownace.getString("posteddate")));
				
		           	
                if(travelReportVo.getTicketbookedbyempcode().equalsIgnoreCase(rs_traallownace.getString("Debit_crdit_card_usedBy_empcode"))){
						travelReportVo.setDebitcardusedby(travelReportVo.getTicketbokedby());
				}else{
					travelReportVo.setDebitcardusedby(getEmpname(connection,rs_traallownace.getString("Debit_crdit_card_usedBy_empcode"),""));
				}
                
                
                if(!rs_traallownace.getString("dirappvtime").equalsIgnoreCase("-")){
                         travelReportVo.setDirApproveddate(HelperClass.convertDatabaseToUI(rs_traallownace.getString("dirappvtime")));
                }else{
                	  travelReportVo.setDirApproveddate(rs_traallownace.getString("dirappvtime"));
                }
                
                
                if(!rs_traallownace.getString("adminappvtime").equalsIgnoreCase("-")){
                        travelReportVo.setAccntApproveddate(HelperClass.convertDatabaseToUI(rs_traallownace.getString("adminappvtime")));
                }else{
                	
                	travelReportVo.setAccntApproveddate(rs_traallownace.getString("adminappvtime"));
                }
                
                travelReportVo.setIsDireApproved(rs_traallownace.getString("isappvdire"));
                  
                travelReportVo.setIsAccntApproved(rs_traallownace.getString("isappvaccnt"));
                travelReportVo.setApprovedDirname(rs_traallownace.getString("dirctorname"));
                travelReportVo.setApprovedAccntname(rs_traallownace.getString("appradminname"));
                
                if(!rs_traallownace.getString("dirappvtime").equalsIgnoreCase("-")){
                 
                	travelReportVo.setApprovedamount(rs_traallownace.getDouble("apprvedamt"));
           
                }
                
                
                travelReportVo.setIsconflict(rs_traallownace.getString("isconflict"));
                
                
                travelallowancelist.add(travelReportVo);
			}
			
			if(travelallowancelist.size()!=0){
				
				travelallownacesmap.put(travelallowancelist.get(travelallowancelist.size()-1).getPostedbyname(), travelallowancelist);
			}
			
		
					
		}catch(SQLException se)
		{
			logger.error(se.getMessage(),se);
			se.printStackTrace();
		}catch(Exception e)
		{
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		}finally{
			try{
				if(rs_traallownace !=null && (!rs_traallownace.isClosed()))
				{
					rs_traallownace.close();
				}
				if(ps_traallownace !=null && (!ps_traallownace.isClosed()))
				{
					ps_traallownace.close();
				}
				if(connection !=null && (!connection.isClosed()))
				{
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
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelAllowancesReportDaoImpl: getTravelAllowancesManagerWiseDao Ending");
		
		return travelallownacesmap;
	}

	
	
	
	public String getEmpname(Connection connection, String empcode, String managerIdType) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelAllowancesReportDaoImpl: getEmpname Starting");
		
		PreparedStatement emp_pstmt=null;
		ResultSet emp_rs=null;
		String empName="";
		
		try{
			 if (managerIdType.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)) {
					
				 emp_pstmt=connection.prepareStatement(TravelAllowancesReportSqlUtil.GET_MANAGER_NAME);	
				 emp_pstmt.setString(1,empcode);
				 emp_rs =	emp_pstmt.executeQuery();
					while (emp_rs.next()) {
						empName=emp_rs.getString("mangName");
							 
					}	
			
			 }else{
					
					emp_pstmt=connection.prepareStatement(TravelAllowancesReportSqlUtil.GET_EMP_NAME);	
					emp_pstmt.setString(1,empcode);
					emp_rs =	emp_pstmt.executeQuery();
						while (emp_rs.next()) {
							empName=emp_rs.getString("empName");
							
						}
				}
			
			if(empName==""){
				
				empName="-";
			}
			
		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);
			sqle.printStackTrace();

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
			
		} finally {

			try {
				
				if(emp_rs != null && (!emp_rs.isClosed())){
					
					emp_rs.close();
				}
				if(emp_pstmt != null && (!emp_pstmt.isClosed())){
					
					emp_pstmt.close();
				}
				
				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}
	
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelAllowancesReportDaoImpl: getEmpname Ending");
		
		return empName;
	}


	
	
	
	
	public Map<String, ArrayList<TravelAllowancesReportVo>> getTravelAllowancesProjectWiseDao(TravelAllowancesReportPojo travelAllowanceReportPojo) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelAllowancesReportDaoImpl: getTravelAllowancesProjectWiseDao Starting");
		
		Connection connection = null;
		PreparedStatement ps_traallownace = null;
		ResultSet rs_traallownace=null;
		int count=0;
		
		Map<String, ArrayList<TravelAllowancesReportVo>> travelallownacesmap=new LinkedHashMap<String, ArrayList<TravelAllowancesReportVo>>();
		ArrayList<TravelAllowancesReportVo> travelallowancelist=new  ArrayList<TravelAllowancesReportVo>();
		
		try{
		
			connection=getConnection();
			ps_traallownace=connection.prepareStatement(TravelAllowancesReportSqlUtil.GET_TRAVEL_ALLOWANCES_PROJECT_WISE);
			
			ps_traallownace.setString(1, travelAllowanceReportPojo.getCurrusercode());
			ps_traallownace.setString(2, travelAllowanceReportPojo.getStatus());
			ps_traallownace.setString(3, HelperClass.convertUIToDatabase(travelAllowanceReportPojo.getFromdate()));
			ps_traallownace.setString(4, HelperClass.convertUIToDatabase(travelAllowanceReportPojo.getTodate()));
			
			rs_traallownace=ps_traallownace.executeQuery();
			
			while (rs_traallownace.next()) {
				
				TravelAllowancesReportVo travelReportVo =new TravelAllowancesReportVo();
				
				if(travelallowancelist.size()!=0){
					
                        if(!(travelallowancelist.get(travelallowancelist.size()-1).getProjectcode().equalsIgnoreCase(rs_traallownace.getString("ProjectCode")))){
						
                        	travelallownacesmap.put(travelallowancelist.get(travelallowancelist.size()-1).getProjectname(), travelallowancelist);
						
						count=0;
						travelallowancelist=new ArrayList<TravelAllowancesReportVo>();
					}
				}
				
				count++;
				
				travelReportVo.setSno(count);
				
				travelReportVo.setTicketbookedbyempcode(rs_traallownace.getString("Tkt_Booked_by_empcode"));
				travelReportVo.setTicketbokedby(rs_traallownace.getString("empname"));
				
		     	if(travelReportVo.getTicketbookedbyempcode().equalsIgnoreCase(rs_traallownace.getString("resource_who_on_travel_empcode"))){
						travelReportVo.setWhoisontravel(travelReportVo.getTicketbokedby());
				}else{
						travelReportVo.setWhoisontravel(getEmpname(connection,rs_traallownace.getString("resource_who_on_travel_empcode"),""));
				}
				
                travelReportVo.setPostedamount(rs_traallownace.getDouble("Amount"));
                travelReportVo.setMode(rs_traallownace.getString("mode"));
                travelReportVo.setPostedby(rs_traallownace.getString("Posted_By"));
                travelReportVo.setPostedbyname(rs_traallownace.getString("postedbyname"));
                
                if(travelReportVo.getPostedby().equalsIgnoreCase(rs_traallownace.getString("Project_Manager"))){
                	
                	travelReportVo.setProjectmanager(travelReportVo.getPostedbyname());
                }else{
                	
                	travelReportVo.setProjectmanager(getEmpname(connection, rs_traallownace.getString("Project_Manager"),LoginDetails.MANAGER_ID_TYPE));
                }
                
                travelReportVo.setProjectrefcode(rs_traallownace.getString("ProjectRefCode"));
                travelReportVo.setProjectname(rs_traallownace.getString("projectname"));
                travelReportVo.setProjectcode(rs_traallownace.getString("ProjectCode"));
                
                
                travelReportVo.setTravelfrom(rs_traallownace.getString("Traveling_From"));
                travelReportVo.setTravelto(rs_traallownace.getString("Traveling_To"));
                travelReportVo.setBookingdate(HelperClass.convertDatabaseToUI(rs_traallownace.getString("Booked_date")));
                travelReportVo.setTravellingdate(HelperClass.convertDatabaseToUI(rs_traallownace.getString("Travelling_Date")));
                travelReportVo.setPosteddate(HelperClass.convertDatabaseToUI(rs_traallownace.getString("posteddate")));
				
		           	
                if(travelReportVo.getTicketbookedbyempcode().equalsIgnoreCase(rs_traallownace.getString("Debit_crdit_card_usedBy_empcode"))){
						travelReportVo.setDebitcardusedby(travelReportVo.getTicketbokedby());
				}else{
					travelReportVo.setDebitcardusedby(getEmpname(connection,rs_traallownace.getString("Debit_crdit_card_usedBy_empcode"),""));
				}
                
                
                if(!rs_traallownace.getString("dirappvtime").equalsIgnoreCase("-")){
                         travelReportVo.setDirApproveddate(HelperClass.convertDatabaseToUI(rs_traallownace.getString("dirappvtime")));
                }else{
                	  travelReportVo.setDirApproveddate(rs_traallownace.getString("dirappvtime"));
                }
                
                
                if(!rs_traallownace.getString("adminappvtime").equalsIgnoreCase("-")){
                        travelReportVo.setAccntApproveddate(HelperClass.convertDatabaseToUI(rs_traallownace.getString("adminappvtime")));
                }else{
                	
                	travelReportVo.setAccntApproveddate(rs_traallownace.getString("adminappvtime"));
                }
                
                travelReportVo.setIsDireApproved(rs_traallownace.getString("isappvdire"));
                  
                travelReportVo.setIsAccntApproved(rs_traallownace.getString("isappvaccnt"));
                travelReportVo.setApprovedDirname(rs_traallownace.getString("dirctorname"));
                travelReportVo.setApprovedAccntname(rs_traallownace.getString("appradminname"));
                
                if(!rs_traallownace.getString("dirappvtime").equalsIgnoreCase("-")){
                 
                	travelReportVo.setApprovedamount(rs_traallownace.getDouble("apprvedamt"));
           
                }
                
                
                travelReportVo.setIsconflict(rs_traallownace.getString("isconflict"));
                
                
                travelallowancelist.add(travelReportVo);
			}
			
			if(travelallowancelist.size()!=0){
				
				travelallownacesmap.put(travelallowancelist.get(travelallowancelist.size()-1).getProjectname(), travelallowancelist);
			}
			
		
					
		}catch(SQLException se)
		{
			logger.error(se.getMessage(),se);
			se.printStackTrace();
		}catch(Exception e)
		{
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		}finally{
			try{
				if(rs_traallownace !=null && (!rs_traallownace.isClosed()))
				{
					rs_traallownace.close();
				}
				if(ps_traallownace !=null && (!ps_traallownace.isClosed()))
				{
					ps_traallownace.close();
				}
				if(connection !=null && (!connection.isClosed()))
				{
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
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelAllowancesReportDaoImpl: getTravelAllowancesProjectWiseDao Ending");
		
		return travelallownacesmap;
	}

	
	
	
	
	
	public ArrayList<TravelAllowancesReportVo> getTravelAllowancesfordownloadDao(
			TravelAllowancesReportPojo travelAllowanceReportPojo) {
		
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())	+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in TravelAllowancesReportDaoImpl : getTravelAllowancesfordownloadDao : Starting");
		
		Connection connection = null;
		PreparedStatement ps_traallownace = null;
		ResultSet rs_traallownace=null;
		int count=0;
		
		
		ArrayList<TravelAllowancesReportVo> travelallowancelist=new ArrayList<TravelAllowancesReportVo>();
		try{
		
			connection=getConnection();
			
			if(MessageConstants.GROUP_BY_MANAGER.equalsIgnoreCase(travelAllowanceReportPojo.getGroupby())){
            
				ps_traallownace=connection.prepareStatement(TravelAllowancesReportSqlUtil.GET_TRAVEL_ALLOWANCES_FOR_DOWNLOAD_MANAGER_WISE);
			 }else{
				 ps_traallownace=connection.prepareStatement(TravelAllowancesReportSqlUtil.GET_TRAVEL_ALLOWANCES_PROJECT_WISE);
			 }
			
			
			ps_traallownace.setString(1, travelAllowanceReportPojo.getCurrusercode());
			ps_traallownace.setString(2, travelAllowanceReportPojo.getStatus());
			ps_traallownace.setString(3, HelperClass.convertUIToDatabase(travelAllowanceReportPojo.getFromdate()));
			ps_traallownace.setString(4, HelperClass.convertUIToDatabase(travelAllowanceReportPojo.getTodate()));
			
			rs_traallownace=ps_traallownace.executeQuery();
			
			while (rs_traallownace.next()) {
				
				TravelAllowancesReportVo travelReportVo =new TravelAllowancesReportVo();
				count++;
				travelReportVo.setSno(count);
				
				travelReportVo.setTicketbookedbyempcode(rs_traallownace.getString("Tkt_Booked_by_empcode"));
				travelReportVo.setTicketbokedby(rs_traallownace.getString("empname"));
				
		     	if(travelReportVo.getTicketbookedbyempcode().equalsIgnoreCase(rs_traallownace.getString("resource_who_on_travel_empcode"))){
						travelReportVo.setWhoisontravel(travelReportVo.getTicketbokedby());
				}else{
						travelReportVo.setWhoisontravel(getEmpname(connection,rs_traallownace.getString("resource_who_on_travel_empcode"),""));
				}
				
                travelReportVo.setPostedamount(rs_traallownace.getDouble("Amount"));
                travelReportVo.setMode(rs_traallownace.getString("mode"));
                travelReportVo.setPostedby(rs_traallownace.getString("Posted_By"));
                travelReportVo.setPostedbyname(rs_traallownace.getString("postedbyname"));
                
                if(travelReportVo.getPostedby().equalsIgnoreCase(rs_traallownace.getString("Project_Manager"))){
                	
                	travelReportVo.setProjectmanager(travelReportVo.getPostedbyname());
                }else{
                	
                	travelReportVo.setProjectmanager(getEmpname(connection, rs_traallownace.getString("Project_Manager"),LoginDetails.MANAGER_ID_TYPE));
                }
                
                travelReportVo.setProjectrefcode(rs_traallownace.getString("ProjectRefCode"));
                travelReportVo.setProjectcode(rs_traallownace.getString("ProjectCode"));
                travelReportVo.setProjectname(rs_traallownace.getString("projectname"));
                
                travelReportVo.setTravelfrom(rs_traallownace.getString("Traveling_From"));
                travelReportVo.setTravelto(rs_traallownace.getString("Traveling_To"));
                travelReportVo.setBookingdate(HelperClass.convertDatabaseToUI(rs_traallownace.getString("Booked_date")));
                travelReportVo.setTravellingdate(HelperClass.convertDatabaseToUI(rs_traallownace.getString("Travelling_Date")));
                travelReportVo.setPosteddate(HelperClass.convertDatabaseToUI(rs_traallownace.getString("posteddate")));
				
		           	
                if(travelReportVo.getTicketbookedbyempcode().equalsIgnoreCase(rs_traallownace.getString("Debit_crdit_card_usedBy_empcode"))){
						travelReportVo.setDebitcardusedby(travelReportVo.getTicketbokedby());
				}else{
					travelReportVo.setDebitcardusedby(getEmpname(connection,rs_traallownace.getString("Debit_crdit_card_usedBy_empcode"),""));
				}
                
                
                if(!rs_traallownace.getString("dirappvtime").equalsIgnoreCase("-")){
                         travelReportVo.setDirApproveddate(HelperClass.convertDatabaseToUI(rs_traallownace.getString("dirappvtime")));
                }else{
                	  travelReportVo.setDirApproveddate(rs_traallownace.getString("dirappvtime"));
                }
                
                
                if(!rs_traallownace.getString("adminappvtime").equalsIgnoreCase("-")){
                        travelReportVo.setAccntApproveddate(HelperClass.convertDatabaseToUI(rs_traallownace.getString("adminappvtime")));
                }else{
                	
                	travelReportVo.setAccntApproveddate(rs_traallownace.getString("adminappvtime"));
                }
                
                travelReportVo.setIsDireApproved(rs_traallownace.getString("isappvdire"));
                  
                travelReportVo.setIsAccntApproved(rs_traallownace.getString("isappvaccnt"));
                travelReportVo.setApprovedDirname(rs_traallownace.getString("dirctorname"));
                travelReportVo.setApprovedAccntname(rs_traallownace.getString("appradminname"));
                
                if(!rs_traallownace.getString("dirappvtime").equalsIgnoreCase("-")){
                 
                	travelReportVo.setApprovedamount(rs_traallownace.getDouble("apprvedamt"));
           
                }
                
                
                travelReportVo.setIsconflict(rs_traallownace.getString("isconflict"));
                
                
                travelallowancelist.add(travelReportVo);
			}
			
		
			
		
					
		}catch(SQLException se)
		{
			logger.error(se.getMessage(),se);
			se.printStackTrace();
		}catch(Exception e)
		{
			logger.error(e.getMessage(),e);
			e.printStackTrace();
		}finally{
			try{
				if(rs_traallownace !=null && (!rs_traallownace.isClosed()))
				{
					rs_traallownace.close();
				}
				if(ps_traallownace !=null && (!ps_traallownace.isClosed()))
				{
					ps_traallownace.close();
				}
				if(connection !=null && (!connection.isClosed()))
				{
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
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in TravelAllowancesReportDaoImpl: getTravelAllowancesProjectWiseDao Ending");
		
		return travelallowancelist;
	}

	
	
	
	
	
	
	
	
	
}
