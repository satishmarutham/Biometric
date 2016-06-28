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
import com.centris.DAO.EmployeeAllowanceReportDao;
import com.centris.POJO.EmployeeAllowanceReportPojo;
import com.centris.VO.EmployeeAllowanceReportVO;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.EmployeeAllowanceReportSqlUtil;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;


public class EmployeeAllowanceReportDaoImpl extends DBService implements EmployeeAllowanceReportDao{

	private static Logger logger = Logger.getLogger(EmployeeAllowanceReportDaoImpl.class);
	
	public Map<String, ArrayList<EmployeeAllowanceReportVO>> getAllowancesByManagerDao(EmployeeAllowanceReportPojo employeeAllowanceReportPojo) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())	+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in EmployeeAllowanceReportDaoImpl : getAllowancesByManagerDao : Starting");
		
		Connection connection=null;
		PreparedStatement allowance_pstmt=null;
		ResultSet allowance_rs=null;
		int count=0;
		
		
		
		Map<String, ArrayList<EmployeeAllowanceReportVO>> allowncesmap=new LinkedHashMap<String, ArrayList<EmployeeAllowanceReportVO>>();
		ArrayList<EmployeeAllowanceReportVO> alownaceslist=new ArrayList<EmployeeAllowanceReportVO>();
			
		try{
			connection=getConnection();
			
		allowance_pstmt=connection.prepareStatement(EmployeeAllowanceReportSqlUtil.GET_ALLOWANCES_MANAGER_WISE);
			
			allowance_pstmt.setString(1, employeeAllowanceReportPojo.getCurrusercode());
			allowance_pstmt.setDate(2,HelperClass.getSqlDate(employeeAllowanceReportPojo.getFromdate()));
			allowance_pstmt.setDate(3,HelperClass.getSqlDate(employeeAllowanceReportPojo.getTodate()));
		
			if(MessageConstants.STATUS_ALL.equalsIgnoreCase(employeeAllowanceReportPojo.getStatus())){
				allowance_pstmt.setString(4,"%%");
			}else{
				allowance_pstmt.setString(4,"%"+employeeAllowanceReportPojo.getStatus()+"%");
			}
			
			allowance_rs =	allowance_pstmt.executeQuery();
			
			
		
			
			while(allowance_rs.next()){
				EmployeeAllowanceReportVO allowanceReportVO=new EmployeeAllowanceReportVO();
				
                if(alownaceslist.size()!=0){
					
					if(!(alownaceslist.get(alownaceslist.size()-1).getPostedby().equalsIgnoreCase(allowance_rs.getString("Posted_By")))){
						
						allowncesmap.put(alownaceslist.get(alownaceslist.size()-1).getPostedbyname()+"-"+alownaceslist.get(alownaceslist.size()-1).getMngBioId(), alownaceslist);
						
						count=0;
						alownaceslist=new ArrayList<EmployeeAllowanceReportVO>();
					}
						
					}
				count++;
		 
				allowanceReportVO.setSno(count);
				allowanceReportVO.setAllowancedate(HelperClass.convertDatabaseToUI(allowance_rs.getString("Allowance_Date")));
				allowanceReportVO.setBiocode(allowance_rs.getString("BioCode"));
				allowanceReportVO.setEmpname(allowance_rs.getString("empname"));
				allowanceReportVO.setLocation(allowance_rs.getString("Location"));
				allowanceReportVO.setNoofdaymonth(allowance_rs.getInt("No_Of_days_Month"));
				allowanceReportVO.setSingleteamgh(allowance_rs.getString("Single_team_GH"));
				allowanceReportVO.setDatype(allowance_rs.getString("DAType"));
				allowanceReportVO.setPost_amount(allowance_rs.getDouble("Amount"));
				allowanceReportVO.setPosteddate(HelperClass.convertDatabaseToUI(allowance_rs.getString("posteddate")));
				allowanceReportVO.setPostedby(allowance_rs.getString("Posted_By"));
				allowanceReportVO.setPostedbyname(allowance_rs.getString("postedbyname"));
				allowanceReportVO.setMngBioId(getMangBioId(allowance_rs.getString("Posted_By"),connection));
				
				
				if(allowance_rs.getString("Posted_By").equalsIgnoreCase(allowance_rs.getString("Project_Manager"))){
				
					allowanceReportVO.setProjectmang(allowance_rs.getString("postedbyname"));
					
					
				}else{
					    
				       allowanceReportVO.setProjectmang(getEmpName(allowance_rs.getString("Posted_By"),connection,LoginDetails.MANAGER_ID_TYPE));
				      
				}
				
				allowanceReportVO.setProjectrefcode(allowance_rs.getString("ProjectRefCode"));
				allowanceReportVO.setClientname(allowance_rs.getString("ClientName"));
				allowanceReportVO.setMang_remarks(allowance_rs.getString("Remarks"));
				
				if(MessageConstants.YES.equalsIgnoreCase(allowance_rs.getString("isApprovedByDirector"))){
					
					allowanceReportVO.setIsdircapproved(MessageConstants.APPROVED);
					
					
					allowanceReportVO.setApproveDire(getEmpName(allowance_rs.getString("ApprovedDirectorCode"),connection,LoginDetails.DIRECTOR_ID_TYPE));
					allowanceReportVO.setApproveDiredate(HelperClass.convertDatabaseToUI(allowance_rs.getString("direapprovetime")));
					allowanceReportVO.setApprovedamount(allowance_rs.getDouble("ApprovedAmount"));
				
				}else{
					allowanceReportVO.setIsdircapproved(MessageConstants.NOT_APPROVED);
					allowanceReportVO.setApproveDire("-");
					allowanceReportVO.setApproveDiredate("-");
					
				}
				
			
				if(MessageConstants.YES.equalsIgnoreCase(allowance_rs.getString("isApprovedByAccounts"))){
				
					allowanceReportVO.setIsAccapproved(MessageConstants.APPROVED);
					allowanceReportVO.setApproveAccnt(getEmpName(allowance_rs.getString("ApprovedAccountsCode"),connection,LoginDetails.ADMIN_ID_TYPE));
					allowanceReportVO.setApproveAccntdate(HelperClass.convertDatabaseToUI(allowance_rs.getString("accntappvdate")));
				}else{
					
					allowanceReportVO.setIsAccapproved(MessageConstants.NOT_APPROVED);
					allowanceReportVO.setApproveAccnt("-");
					allowanceReportVO.setApproveAccntdate("-");
				}
				
				if(MessageConstants.YES.equalsIgnoreCase(allowance_rs.getString("isConflict"))){
					
					allowanceReportVO.setConfilct(MessageConstants.CONFLICT_YES);
					
				}else{
					allowanceReportVO.setConfilct(MessageConstants.CONFLICT_NO);
				}
				
				alownaceslist.add(allowanceReportVO);
	       }
			
			
			if(alownaceslist.size()!=0){
				allowncesmap.put(alownaceslist.get(alownaceslist.size()-1).getPostedbyname()+"-"+alownaceslist.get(alownaceslist.size()-1).getMngBioId(), alownaceslist);
			}	
			
	
	
			
			} catch (SQLException sqle) {

				logger.error(sqle.getMessage(),sqle);
				sqle.printStackTrace();

			} catch (Exception e) {
				logger.error(e.getMessage(),e);
				e.printStackTrace();
				
			} finally {

				try {
					
					if(allowance_rs != null && (!allowance_rs.isClosed())){
						
						allowance_rs.close();
					}
					if(allowance_pstmt != null && (!allowance_pstmt.isClosed())){
						
						allowance_pstmt.close();
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
					+ " Control in EmployeeAllowanceReportDaoImpl : getAllowancesByManagerDao : Ending");
		
		return allowncesmap;
	}
	
	
	
	
	
	public String getMangBioId(String mangid, Connection connection) {
		
		PreparedStatement emp_pstmt=null;
		ResultSet emp_rs=null;
		String bioId="";
		
		try{
			 
					
				 emp_pstmt=connection.prepareStatement(EmployeeAllowanceReportSqlUtil.GET_MANAGER_NAME);	
				 emp_pstmt.setString(1,mangid);
				 emp_rs =	emp_pstmt.executeQuery();
					while (emp_rs.next()) {
						bioId=emp_rs.getString("bioid");
							 
					}
					
				
			if(bioId==""){
				
				bioId="-";
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
		
		return bioId;
	}





	public String getEmpName(String empCode, Connection connection,String usertype) {

		PreparedStatement emp_pstmt=null;
		ResultSet emp_rs=null;
		String empName="";
		
		try{
			 if (usertype.equalsIgnoreCase(LoginDetails.MANAGER_ID_TYPE)) {
					
				 emp_pstmt=connection.prepareStatement(EmployeeAllowanceReportSqlUtil.GET_MANAGER_NAME);	
				 emp_pstmt.setString(1,empCode);
				 emp_rs =	emp_pstmt.executeQuery();
					while (emp_rs.next()) {
						empName=emp_rs.getString("mangName");
							 
					}
					
				}else if((usertype.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE))) {
					
					emp_pstmt=connection.prepareStatement(EmployeeAllowanceReportSqlUtil.GET_DIRECTOR_NAME);	
					emp_pstmt.setString(1,empCode);
					emp_rs =	emp_pstmt.executeQuery();
						while (emp_rs.next()) {
							empName=emp_rs.getString("direname");
							
						}
					
					
				}else{
					
					emp_pstmt=connection.prepareStatement(EmployeeAllowanceReportSqlUtil.GET_ADMIN_NAME);	
					emp_pstmt.setString(1,empCode);
					emp_rs =	emp_pstmt.executeQuery();
						while (emp_rs.next()) {
							empName=emp_rs.getString("adminName");
							
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
		
		return empName;
	}


	public Map<String, ArrayList<EmployeeAllowanceReportVO>> getAllowancesByProjectDao(EmployeeAllowanceReportPojo employeeAllowanceReportPojo) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())	+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in EmployeeAllowanceReportDaoImpl : getAllowancesByProjectDao : Starting");
		
		Connection connection=null;
		PreparedStatement allowance_pstmt=null;
		ResultSet allowance_rs=null;
		int count=0;
				
		
		Map<String, ArrayList<EmployeeAllowanceReportVO>> allowncesmap=new LinkedHashMap<String, ArrayList<EmployeeAllowanceReportVO>>();
		ArrayList<EmployeeAllowanceReportVO> alownaceslist=new ArrayList<EmployeeAllowanceReportVO>();
			
		try{
			
			connection=getConnection();
			
		 allowance_pstmt=connection.prepareStatement(EmployeeAllowanceReportSqlUtil.GET_ALLOWANCES_PROJECT_WISE);
		
		allowance_pstmt.setString(1, employeeAllowanceReportPojo.getCurrusercode());
		allowance_pstmt.setDate(2,HelperClass.getSqlDate(employeeAllowanceReportPojo.getFromdate()));
		allowance_pstmt.setDate(3,HelperClass.getSqlDate(employeeAllowanceReportPojo.getTodate()));
		if(MessageConstants.STATUS_ALL.equalsIgnoreCase(employeeAllowanceReportPojo.getStatus())){
			allowance_pstmt.setString(4,"%%");
		}else{
			allowance_pstmt.setString(4,"%"+employeeAllowanceReportPojo.getStatus()+"%");
		}
		
		allowance_rs =	allowance_pstmt.executeQuery();
	
		while(allowance_rs.next()){
			EmployeeAllowanceReportVO allowanceReportVO=new EmployeeAllowanceReportVO();
			
            if(alownaceslist.size()!=0){
				
				if(!(alownaceslist.get(alownaceslist.size()-1).getProjectrefcode().equalsIgnoreCase(allowance_rs.getString("ProjectRefCode")))){
					
					allowncesmap.put(alownaceslist.get(alownaceslist.size()-1).getProjectname()+"             "+alownaceslist.get(alownaceslist.size()-1).getProjectrefcode(), alownaceslist);
					
					count=0;
					alownaceslist=new ArrayList<EmployeeAllowanceReportVO>();
				}
					
				}
			count++;
	 
			allowanceReportVO.setSno(count);
			allowanceReportVO.setAllowancedate(HelperClass.convertDatabaseToUI(allowance_rs.getString("Allowance_Date")));
			allowanceReportVO.setBiocode(allowance_rs.getString("BioCode"));
			allowanceReportVO.setEmpname(allowance_rs.getString("empname"));
			allowanceReportVO.setLocation(allowance_rs.getString("Location"));
			allowanceReportVO.setNoofdaymonth(allowance_rs.getInt("No_Of_days_Month"));
			allowanceReportVO.setSingleteamgh(allowance_rs.getString("Single_team_GH"));
			allowanceReportVO.setDatype(allowance_rs.getString("DAType"));
			allowanceReportVO.setPost_amount(allowance_rs.getDouble("Amount"));
			allowanceReportVO.setPosteddate(HelperClass.convertDatabaseToUI(allowance_rs.getString("posteddate")));
			allowanceReportVO.setPostedby(allowance_rs.getString("Posted_By"));
			allowanceReportVO.setPostedbyname(allowance_rs.getString("postedbyname"));
			
		
		
			if(allowance_rs.getString("Posted_By").equalsIgnoreCase(allowance_rs.getString("Project_Manager"))){
			
				allowanceReportVO.setProjectmang(allowance_rs.getString("postedbyname"));
				
				
			}else{
				
				   allowanceReportVO.setProjectmang(getEmpName(allowance_rs.getString("Project_Manager"),connection,LoginDetails.MANAGER_ID_TYPE));
			   
			      
			}
			
			allowanceReportVO.setProjectrefcode(allowance_rs.getString("ProjectRefCode"));
			allowanceReportVO.setClientname(allowance_rs.getString("ClientName"));
			allowanceReportVO.setMang_remarks(allowance_rs.getString("Remarks"));
			
			if(MessageConstants.YES.equalsIgnoreCase(allowance_rs.getString("isApprovedByDirector"))){
				
				allowanceReportVO.setIsdircapproved(MessageConstants.APPROVED);
				
				
				allowanceReportVO.setApproveDire(getEmpName(allowance_rs.getString("ApprovedDirectorCode"),connection,LoginDetails.DIRECTOR_ID_TYPE));
				allowanceReportVO.setApproveDiredate(HelperClass.convertDatabaseToUI(allowance_rs.getString("direapprovetime")));
				allowanceReportVO.setApprovedamount(allowance_rs.getDouble("ApprovedAmount"));
			
			}else{
				allowanceReportVO.setIsdircapproved(MessageConstants.NOT_APPROVED);
				allowanceReportVO.setApproveDire("-");
				allowanceReportVO.setApproveDiredate("-");
				
			}
			
		
			if(MessageConstants.YES.equalsIgnoreCase(allowance_rs.getString("isApprovedByAccounts"))){
			
				allowanceReportVO.setIsAccapproved(MessageConstants.APPROVED);
				allowanceReportVO.setApproveAccnt(getEmpName(allowance_rs.getString("ApprovedAccountsCode"),connection,LoginDetails.ADMIN_ID_TYPE));
				allowanceReportVO.setApproveAccntdate(HelperClass.convertDatabaseToUI(allowance_rs.getString("accntappvdate")));
			}else{
				
				allowanceReportVO.setIsAccapproved(MessageConstants.NOT_APPROVED);
				allowanceReportVO.setApproveAccnt("-");
				allowanceReportVO.setApproveAccntdate("-");
			}
			
			if(MessageConstants.YES.equalsIgnoreCase(allowance_rs.getString("isConflict"))){
				allowanceReportVO.setConfilct(MessageConstants.CONFLICT_YES);
				
			}else{
				allowanceReportVO.setConfilct(MessageConstants.CONFLICT_NO);
			}
			
			allowanceReportVO.setProjectname(allowance_rs.getString("Project_Name"));
			
			
			
			
			alownaceslist.add(allowanceReportVO);
       }
		
		
		if(alownaceslist.size()!=0){
			allowncesmap.put(alownaceslist.get(alownaceslist.size()-1).getProjectname()+"                 "+alownaceslist.get(alownaceslist.size()-1).getProjectrefcode(), alownaceslist);
		}	
		
		
		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);
			sqle.printStackTrace();

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
			
		} finally {

			try {
				
				if(allowance_rs != null && (!allowance_rs.isClosed())){
					
					allowance_rs.close();
				}
				if(allowance_pstmt != null && (!allowance_pstmt.isClosed())){
					
					allowance_pstmt.close();
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
				+ " Control in EmployeeAllowanceReportDaoImpl : getAllowancesByProjectDao : Ending");
		
		return allowncesmap;
	}


	public ArrayList<EmployeeAllowanceReportVO> getAllowancesfordownload(
			EmployeeAllowanceReportPojo employeeAllowanceReportPojo) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())	+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())	+ " Control in EmployeeAllowanceReportDaoImpl : getAllowancesfordownload : Starting");
		
		Connection connection=null;
		PreparedStatement allowance_pstmt=null;
		ResultSet allowance_rs=null;
		int count=0;
		String projectmang="";
		String mangBioId="";
		
		
		ArrayList<EmployeeAllowanceReportVO> alownaceslist=new ArrayList<EmployeeAllowanceReportVO>();
		try{
		
			connection=getConnection();
			
			if(MessageConstants.GROUP_BY_MANAGER.equalsIgnoreCase(employeeAllowanceReportPojo.getGroupby())){
            
				 allowance_pstmt=connection.prepareStatement(EmployeeAllowanceReportSqlUtil.GET_ALLOWANCES_FOR_DOWNLOAD_MANAGER_WISE);
			 }else{
				 allowance_pstmt=connection.prepareStatement(EmployeeAllowanceReportSqlUtil.GET_ALLOWANCES_FOR_DOWNLOAD_PROJECT_WISE);
			 }
			
			
			allowance_pstmt.setString(1, employeeAllowanceReportPojo.getCurrusercode());
			allowance_pstmt.setDate(2,HelperClass.getSqlDate(employeeAllowanceReportPojo.getFromdate()));
			allowance_pstmt.setDate(3,HelperClass.getSqlDate(employeeAllowanceReportPojo.getTodate()));
		
			if(MessageConstants.STATUS_ALL.equalsIgnoreCase(employeeAllowanceReportPojo.getStatus())){
				allowance_pstmt.setString(4,"%%");
			}else{
				allowance_pstmt.setString(4,"%"+employeeAllowanceReportPojo.getStatus()+"%");
			}
			
			
			
			
			allowance_rs =	allowance_pstmt.executeQuery();
					
			while(allowance_rs.next()){
				EmployeeAllowanceReportVO allowanceReportVO=new EmployeeAllowanceReportVO();
			
				count++;
				 
				allowanceReportVO.setSno(count);
				allowanceReportVO.setAllowancedate(HelperClass.convertDatabaseToUI(allowance_rs.getString("Allowance_Date")));
				allowanceReportVO.setBiocode(allowance_rs.getString("BioCode"));
				allowanceReportVO.setEmpname(allowance_rs.getString("empname"));
				allowanceReportVO.setLocation(allowance_rs.getString("Location"));
				allowanceReportVO.setNoofdaymonth(allowance_rs.getInt("No_Of_days_Month"));
				allowanceReportVO.setSingleteamgh(allowance_rs.getString("Single_team_GH"));
				allowanceReportVO.setDatype(allowance_rs.getString("DAType"));
				allowanceReportVO.setPost_amount(allowance_rs.getDouble("Amount"));
				allowanceReportVO.setPosteddate(HelperClass.convertDatabaseToUI(allowance_rs.getString("posteddate")));
				allowanceReportVO.setPostedby(allowance_rs.getString("Posted_By"));
				allowanceReportVO.setPostedbyname(allowance_rs.getString("postedbyname"));
				allowanceReportVO.setMngBioId(getMangBioId(allowance_rs.getString("Posted_By"),connection));
						
				if(allowance_rs.getString("Posted_By").equalsIgnoreCase(allowance_rs.getString("Project_Manager"))){
				
					allowanceReportVO.setProjectmang(allowance_rs.getString("postedbyname"));
				
					
				}else{
					
					   allowanceReportVO.setProjectmang(getEmpName(allowance_rs.getString("Project_Manager"),connection,LoginDetails.MANAGER_ID_TYPE));
					  
				 }
				      
			
				
				allowanceReportVO.setProjectrefcode(allowance_rs.getString("ProjectRefCode"));
				allowanceReportVO.setClientname(allowance_rs.getString("ClientName"));
				allowanceReportVO.setMang_remarks(allowance_rs.getString("Remarks"));
				
				if(MessageConstants.YES.equalsIgnoreCase(allowance_rs.getString("isApprovedByDirector"))){
					
					allowanceReportVO.setIsdircapproved(MessageConstants.APPROVED);
					
					
					allowanceReportVO.setApproveDire(getEmpName(allowance_rs.getString("ApprovedDirectorCode"),connection,LoginDetails.DIRECTOR_ID_TYPE));
					allowanceReportVO.setApproveDiredate(HelperClass.convertDatabaseToUI(allowance_rs.getString("direapprovetime")));
					allowanceReportVO.setApprovedamount(allowance_rs.getDouble("ApprovedAmount"));
				
				}else{
					allowanceReportVO.setIsdircapproved(MessageConstants.NOT_APPROVED);
					allowanceReportVO.setApproveDire("-");
					allowanceReportVO.setApproveDiredate("-");
					
				}
				
			
				if(MessageConstants.YES.equalsIgnoreCase(allowance_rs.getString("isApprovedByAccounts"))){
				
					allowanceReportVO.setIsAccapproved(MessageConstants.APPROVED);
					allowanceReportVO.setApproveAccnt(getEmpName(allowance_rs.getString("ApprovedAccountsCode"),connection,LoginDetails.ADMIN_ID_TYPE));
					allowanceReportVO.setApproveAccntdate(HelperClass.convertDatabaseToUI(allowance_rs.getString("accntappvdate")));
				}else{
					
					allowanceReportVO.setIsAccapproved(MessageConstants.NOT_APPROVED);
					allowanceReportVO.setApproveAccnt("-");
					allowanceReportVO.setApproveAccntdate("-");
				}
				
				if(MessageConstants.YES.equalsIgnoreCase(allowance_rs.getString("isConflict"))){
					allowanceReportVO.setConfilct(MessageConstants.CONFLICT_YES);
					
				}else{
					allowanceReportVO.setConfilct(MessageConstants.CONFLICT_NO);
				}
				
				allowanceReportVO.setProjectname(allowance_rs.getString("Project_Name"));
				allowanceReportVO.setProjectcode(allowance_rs.getString("ProjectCode"));
				
				
				
				alownaceslist.add(allowanceReportVO);
			}
			
						
			} catch (SQLException sqle) {

				logger.error(sqle.getMessage(),sqle);
				sqle.printStackTrace();

			} catch (Exception e) {
				logger.error(e.getMessage(),e);
				e.printStackTrace();
				
			} finally {

				try {
					
					if(allowance_rs != null && (!allowance_rs.isClosed())){
						
						allowance_rs.close();
					}
					if(allowance_pstmt != null && (!allowance_pstmt.isClosed())){
						
						allowance_pstmt.close();
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
					+ " Control in EmployeeAllowanceReportDaoImpl : getAllowancesfordownload : Ending");
			
		
		return alownaceslist;
	}
	
}
