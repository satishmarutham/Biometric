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
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.DAO.EmpAllowAprroveByDirectorDao;
import com.centris.POJO.EmpAllowAprroveByDirectorPojo;
import com.centris.VO.AllowancesClaimByManagerVO;
import com.centris.VO.ApproveAllowByDirectorMailDetailsVo;
import com.centris.VO.EmpAllowAprroveByDirectorVo;
import com.centris.util.AllowancesInAdminUtil;
import com.centris.util.EmailContent;
import com.centris.util.EmpAllowancesUtil;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AllowancesClaimByManagerSqlUtil;
import com.centris.util.SQLUtils.ApproveTravelBookingSqlUtil;
import com.centris.util.SQLUtils.AttendenceDetails;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class EmpAllowAprroveByDirectorDaoImpl extends DBService implements EmpAllowAprroveByDirectorDao{

	private static Logger logger = Logger.getLogger(EmpAllowAprroveByDirectorDaoImpl.class);

	
	@Override
	public  LinkedHashMap<String, ArrayList<EmpAllowAprroveByDirectorVo>> getAllowancesNotApproved(String startdate, String endDate,String userType,String usercode) {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getAllowancesNotApproved : Starting");

		PreparedStatement allowancesPstmt = null;
		ResultSet allowancesRs = null;
		
		PreparedStatement postedmanagerpstmt = null;
		ResultSet postedmanagerrs = null;
		
		PreparedStatement getDatesPstmt = null;
		ResultSet getDatesPstmtrs = null;
		
		PreparedStatement getAmtPstmt = null;
		ResultSet getAmtRs = null;
		
		Connection connection=null;
		int count=0;
		
		LinkedHashMap<String, ArrayList<EmpAllowAprroveByDirectorVo>> allowanceMap=new LinkedHashMap<String, ArrayList<EmpAllowAprroveByDirectorVo>>();
		
		ArrayList<EmpAllowAprroveByDirectorVo> allowanceList=new ArrayList<EmpAllowAprroveByDirectorVo>();
		try {
			
			connection =getConnection();
			
			
			if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				
			allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_ALLOWANCES_NOT_APPROVED);
			allowancesPstmt.setString(1, usercode);
			allowancesPstmt.setString(2, startdate);
			allowancesPstmt.setString(3, endDate);
			
			allowancesRs = allowancesPstmt.executeQuery();
			while (allowancesRs.next()) {
				EmpAllowAprroveByDirectorVo vo=new EmpAllowAprroveByDirectorVo();
				
				if(allowanceList.size()!=0){
				
				if(!(allowanceList.get(allowanceList.size()-1).getPostedbycode().equalsIgnoreCase(allowancesRs.getString("Posted_By")))){
					
					
					getDatesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_MAXMIN_DATES_FOR_MANAGER);
					getDatesPstmt.setString(1, allowanceList.get(allowanceList.size()-1).getPostedbycode());
					getDatesPstmt.setString(2, startdate);
					getDatesPstmt.setString(3, endDate);
					
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
					
					allowanceMap.put(allowanceList.get(allowanceList.size()-1).getPostedbyname()+"-"+allowanceList.get(allowanceList.size()-1).getPostedByBioCode()+".    From  - "+mindate+" To  - "+maxDate+".    Total Amount-"+amount, allowanceList);
					
					count=0;
					allowanceList = new ArrayList<EmpAllowAprroveByDirectorVo>();
				}
				
				}
				
				count++;
				
				vo.setSno(count);
				vo.setAllowanceCode(allowancesRs.getString("DALCode"));
				vo.setAllowancesdate(HelperClass.convertDatabaseToUI(allowancesRs.getString("Allowance_Date")));
				vo.setAmount(allowancesRs.getString("Amount"));
				vo.setBioCode(allowancesRs.getString("BioCode"));
				vo.setClientname(allowancesRs.getString("ClientName"));
				vo.setDatype(allowancesRs.getString("DAType"));
				vo.setEmpcode(allowancesRs.getString("EMPCODE"));
				vo.setEmpname(allowancesRs.getString("employeename"));
				vo.setHdfcaccount(allowancesRs.getString("HDFC_AC"));
				vo.setLocation(allowancesRs.getString("Location"));
				vo.setNoofdays(allowancesRs.getString("No_Of_days_Month"));
				vo.setPostedbycode(allowancesRs.getString("Posted_By"));
				
				
				if(allowancesRs.getString("isApprovedByDirector").equalsIgnoreCase("Y")){
					
					vo.setAprovestatus("Approved");
					
				}else if(allowancesRs.getString("isApprovedByDirector").equalsIgnoreCase("N")){
					
					vo.setAprovestatus("Approve");
					vo.setIsRejectedStatus("Reject");
					
				}else if(allowancesRs.getString("isApprovedByDirector").equalsIgnoreCase("R")){
					
					vo.setIsRejectedStatus("Rejected");
				}
				
					postedmanagerpstmt=connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_POSTED_MANAGER);
					postedmanagerpstmt.setString(1, allowancesRs.getString("Posted_By"));
					
					postedmanagerrs=postedmanagerpstmt.executeQuery();
					
					while(postedmanagerrs.next()){
						
						vo.setPostedbyname(postedmanagerrs.getString("First_Name"));
						vo.setPostedByBioCode(postedmanagerrs.getString("bioid"));
					}
					
		
				
				vo.setProjectmanager(allowancesRs.getString("managername"));
				vo.setProjectmanagercode(allowancesRs.getString("Project_Manager"));
				vo.setProjectRefCode(allowancesRs.getString("ProjectRefCode"));
				vo.setRemarks(allowancesRs.getString("Remarks"));
				vo.setSingleteamgh(allowancesRs.getString("Single_team_GH"));
				vo.setTeaamLead(allowancesRs.getString("Team_Lead"));
				if(allowancesRs.getDouble("ApprovedAmount")==0.0){
					vo.setApproveamount(allowancesRs.getDouble("Amount"));
				}else{
				vo.setApproveamount(allowancesRs.getDouble("ApprovedAmount"));
				}
				if(allowancesRs.getString("DirectorRemarks")==null){
					vo.setApprovecoments("");
				}else{
				vo.setApprovecoments(allowancesRs.getString("DirectorRemarks"));
				}
				
				
				allowanceList.add(vo);
			
			}
			
			if(allowanceList.size()!=0){
				
				getDatesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_MAXMIN_DATES_FOR_MANAGER);
				getDatesPstmt.setString(1, allowanceList.get(allowanceList.size()-1).getPostedbycode());
				getDatesPstmt.setString(2, startdate);
				getDatesPstmt.setString(3, endDate);
				
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
				
				allowanceMap.put(allowanceList.get(allowanceList.size()-1).getPostedbyname()+"-"+allowanceList.get(allowanceList.size()-1).getPostedByBioCode()+".    From  - "+mindate+" To  - "+maxDate+".    Total Amount-"+amount, allowanceList);
				
			}
			
		}else{ 
			
		allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_ALLOW_NOT_APPROVEBY_ADMIN);
		allowancesPstmt.setString(1, startdate);
		allowancesPstmt.setString(2, endDate);
		

		allowancesRs = allowancesPstmt.executeQuery();
		
		while (allowancesRs.next()) {
			EmpAllowAprroveByDirectorVo vo=new EmpAllowAprroveByDirectorVo();
			
			if(allowanceList.size()!=0){
			
			if(!(allowanceList.get(allowanceList.size()-1).getApprovedbyId().equalsIgnoreCase(allowancesRs.getString("ApprovedDirectorCode")))){
				
				getDatesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_MAXMIN_DATES_FOR_DIRECTOR);
				getDatesPstmt.setString(1, allowanceList.get(allowanceList.size()-1).getApprovedbyId());
				getDatesPstmt.setString(2, startdate);
				getDatesPstmt.setString(3, endDate);
				
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
				
				allowanceMap.put(allowanceList.get(allowanceList.size()-1).getApprovedbyName()+"-"+allowanceList.get(allowanceList.size()-1).getApprovedByBioCode()+". From  "+mindate+"    "+".  To  "+maxDate +"   "+".    Total Amount -  "+amount, allowanceList);
				
				count=0;
				allowanceList = new ArrayList<EmpAllowAprroveByDirectorVo>();
			}
			
			}
			
			count++;
			
			vo.setSno(count);
			vo.setAllowanceCode(allowancesRs.getString("DALCode"));
			vo.setBioCode(allowancesRs.getString("BioCode"));
			vo.setEmpcode(allowancesRs.getString("EMPCODE"));
			ArrayList<String> empList=getEmployee(allowancesRs.getString("EMPCODE"), connection);
			vo.setEmpname(empList.get(0));
			vo.setAllowancesdate(HelperClass.convertDatabaseToUI(allowancesRs.getString("Allowance_Date")));
			vo.setProjectRefCode(allowancesRs.getString("ProjectRefCode"));
			vo.setAmount(allowancesRs.getString("Amount"));
			vo.setApproveamount(allowancesRs.getDouble("ApprovedAmount"));
			
			
			boolean flag=true;
			
			if(allowancesRs.getString("isRejected").equalsIgnoreCase("Y")){
				flag=false;
				vo.setAccountsApprovedAmount(allowancesRs.getDouble("AccountApprovedAmount"));
				vo.setIsRejectedStatus("Rejected");
				vo.setAccountsRemarks(allowancesRs.getString("AccountsRemarks"));
			}else{
				
				vo.setIsRejectedStatus("Reject");
			}

			if(allowancesRs.getString("isApprovedByAccounts").equalsIgnoreCase("Y")){
				flag=false;
				vo.setAccountsApprovedAmount(allowancesRs.getDouble("AccountApprovedAmount"));
				vo.setIsaccountsStatus("Approved");
				vo.setAccountsRemarks(allowancesRs.getString("AccountsRemarks"));
				
			}else{
				
				vo.setIsaccountsStatus("Approve");
			}
			
			if(flag){
				
				vo.setAccountsApprovedAmount(allowancesRs.getDouble("ApprovedAmount"));
				vo.setAccountsRemarks("");
				
			}
			
			vo.setApprovedbyId(allowancesRs.getString("ApprovedDirectorCode"));
			vo.setApprovedbyName(allowancesRs.getString("directorName"));
			vo.setApprovedByBioCode(allowancesRs.getString("bioid"));
			
			
			allowanceList.add(vo);
		
		}
		
		if(allowanceList.size()!=0){
			
			getDatesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_MAXMIN_DATES_FOR_DIRECTOR);
			getDatesPstmt.setString(1, allowanceList.get(allowanceList.size()-1).getApprovedbyId());
			getDatesPstmt.setString(2, startdate);
			getDatesPstmt.setString(3, endDate);
			
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
			
			allowanceMap.put(allowanceList.get(allowanceList.size()-1).getApprovedbyName()+"-"+allowanceList.get(allowanceList.size()-1).getApprovedByBioCode()+". From  "+mindate+"    "+".  To  "+maxDate +"   "+".    Total Amount -  "+amount, allowanceList);
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
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getAllowancesNotApproved : Ending");

		return allowanceMap;

	}
	

	@Override
	public ArrayList<EmpAllowAprroveByDirectorVo> getsingleAllowances(
			String allowanceCode) {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getsingleAllowances : Starting");

		PreparedStatement allowancesPstmt = null;
		ResultSet allowancesRs = null;
		
		PreparedStatement postedmanagerpstmt = null;
		ResultSet postedmanagerrs = null;
		
		Connection connection=null;
		
		ArrayList<EmpAllowAprroveByDirectorVo> allowanceList=new ArrayList<EmpAllowAprroveByDirectorVo>();
		try {
			
			connection =getConnection();
			allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_SINGLE_ALLOWANCE);
			allowancesPstmt.setString(1, allowanceCode);
			
			
			allowancesRs = allowancesPstmt.executeQuery();
			while (allowancesRs.next()) {
				EmpAllowAprroveByDirectorVo vo=new EmpAllowAprroveByDirectorVo();
				
				
				
				vo.setPostedbyname(allowancesRs.getString("managername"));
				vo.setPostedTime(allowancesRs.getString("Posted_Date"));
				
				vo.setApprovedTime(allowancesRs.getString("DirectorApprovedTime"));
				vo.setApprovedbyName(allowancesRs.getString("directorName"));
				
				vo.setProjectmanager(allowancesRs.getString("projectManager"));
				vo.setClientname(allowancesRs.getString("ClientName"));
				
				vo.setTeaamLead(allowancesRs.getString("Team_Lead"));
				vo.setSingleteamgh(allowancesRs.getString("Single_team_GH"));
				
				vo.setDatype(allowancesRs.getString("DAType"));
				vo.setNoofdays(allowancesRs.getString("No_Of_days_Month"));
				
				vo.setLocation(allowancesRs.getString("Location"));
				vo.setHdfcaccount(allowancesRs.getString("HDFC_AC"));
				
				vo.setRemarks(allowancesRs.getString("postedByRemarks"));
				vo.setApprovecoments(allowancesRs.getString("directorRemarks"));		
				
			/*	
				vo.setPostedbycode(allowancesRs.getString("Posted_By"));
				
				if(allowancesRs.getString("Posted_By").equalsIgnoreCase(allowancesRs.getString("Project_Manager"))){
					
				}else{
					
					postedmanagerpstmt=connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_POSTED_MANAGER);
					postedmanagerpstmt.setString(1, allowancesRs.getString("Posted_By"));
					
					postedmanagerrs=postedmanagerpstmt.executeQuery();
					
					while(postedmanagerrs.next()){
						
						vo.setPostedbyname(postedmanagerrs.getString("First_Name"));
					}
					
				}
				
				vo.setProjectmanager(allowancesRs.getString("managername"));
				vo.setProjectmanagercode(allowancesRs.getString("Project_Manager"));
				vo.setProjectRefCode(allowancesRs.getString("ProjectRefCode"));
				
				
				if(allowancesRs.getString("HDFC_AC")!=null && !("".equalsIgnoreCase(allowancesRs.getString("HDFC_AC")))){
					vo.setHdfcaccount(allowancesRs.getString("HDFC_AC"));
				}else{
					vo.setHdfcaccount("-");
				}
				*/
				
				
				allowanceList.add(vo);
			
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
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getsingleAllowances : Ending");
		
	
		

		return allowanceList;

	}


	@Override
	public String approveSingleAllowance(
			EmpAllowAprroveByDirectorPojo allowancePojo) {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : approveSingleAllowance : Starting");

		PreparedStatement allowancesPstmt = null;
		int count=0;
		String status=null;
		Connection connection=null;
		PreparedStatement allowancesPstmt1=null;
		int mailcount=0;
		
		try {
			
			
			connection =getConnection();
			
			String url = getServerUrlFromBD(connection);
			
			if(allowancePojo.getUserType().equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				
			allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.APPROVE_SINGLE_ALLOWANCE);
			allowancesPstmt.setString(1, allowancePojo.getApprovedamount().trim());
			allowancesPstmt.setString(2, allowancePojo.getRemarks().trim());
			allowancesPstmt.setString(3, allowancePojo.getApprovedby().trim());
			allowancesPstmt.setTimestamp(4, HelperClass.getCurrentTimestamp());
			allowancesPstmt.setString(5, allowancePojo.getAllowanceCode().trim());
			
			count = allowancesPstmt.executeUpdate();
			
			if(count>0){
				
				status="true";
					
				String mailStatus = sendEmailToAccounts(allowancePojo.getAllowanceCode().trim(),allowancePojo.getApprovedbyName(),url,"single");
				
				if(mailStatus.equalsIgnoreCase("true")){
						
						status=MessageConstants.MAIL_SENT;
					
				}
				
			}
			
			
			}else{
				
				allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.APPROVE_ALLOWANCE_BY_ADMIN);
			
				allowancesPstmt.setString(1, allowancePojo.getApprovedby().trim());
				allowancesPstmt.setTimestamp(2, HelperClass.getCurrentTimestamp());
				allowancesPstmt.setString(3, allowancePojo.getRemarks());
				allowancesPstmt.setString(4, allowancePojo.getApprovedamount());
				allowancesPstmt.setString(5, allowancePojo.getAllowanceCode().trim());
				
				count = allowancesPstmt.executeUpdate();
				
				if(count>0){
					
					status="true";
					
					String mailStatus = sendEmailToManagerAndDirector(allowancePojo.getAllowanceCode().trim(),allowancePojo.getApprovedamount(),allowancePojo.getApprovedbyName(),url);
						
					if(mailStatus.equalsIgnoreCase("true")){
						
						allowancesPstmt1 = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.UPDATE_MAILSTATUS);
						allowancesPstmt1.setTimestamp(1, HelperClass.getCurrentTimestamp());
						allowancesPstmt1.setString(2, allowancePojo.getAllowanceCode().trim());
						
						mailcount=allowancesPstmt1.executeUpdate();
						if(mailcount>0){
							
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
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : approveSingleAllowance : Ending");

		return status;

	}
	

	public ArrayList<EmpAllowAprroveByDirectorVo> getConflictEmployees(String startdate,String endDate,String userType,String usercode) {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getConflictEmployees : Starting");

		PreparedStatement allowancesPstmt = null;
		ResultSet allowancesRs = null;
		
		PreparedStatement postedmanagerpstmt = null;
		ResultSet postedmanagerrs = null;
		
		Connection connection=null;
		
		ArrayList<EmpAllowAprroveByDirectorVo> allowanceList=new ArrayList<EmpAllowAprroveByDirectorVo>();
		try {
			
			connection =getConnection();
			
			if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				
			allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_CONFLICT_EMPLOYEES);
			allowancesPstmt.setString(1, usercode);
			allowancesPstmt.setString(2, startdate);
			allowancesPstmt.setString(3, endDate);
			
			
			int count=0;
			
			
			allowancesRs = allowancesPstmt.executeQuery();
			while (allowancesRs.next()) {
				count++;
				EmpAllowAprroveByDirectorVo vo=new EmpAllowAprroveByDirectorVo();
				
				vo.setSno(count);
				vo.setAllowanceCode(allowancesRs.getString("DALCode"));
				vo.setAllowancesdate(HelperClass.convertDatabaseToUI(allowancesRs.getString("Allowance_Date")));
				vo.setAmount(allowancesRs.getString("Amount"));
				vo.setBioCode(allowancesRs.getString("BioCode"));
				vo.setClientname(allowancesRs.getString("ClientName"));
				vo.setDatype(allowancesRs.getString("DAType"));
				vo.setEmpcode(allowancesRs.getString("EMPCODE"));
				vo.setEmpname(allowancesRs.getString("employeename"));
				
				if(allowancesRs.getString("HDFC_AC")==null){
				vo.setHdfcaccount("");
				}else{
					
					vo.setHdfcaccount(allowancesRs.getString("HDFC_AC"));
				}
				vo.setLocation(allowancesRs.getString("Location"));
				vo.setNoofdays(allowancesRs.getString("No_Of_days_Month"));
				vo.setPostedbycode(allowancesRs.getString("Posted_By"));
				
				if(allowancesRs.getString("isApprovedByDirector").equalsIgnoreCase("Y")){
					
					vo.setAprovestatus("Approved");
					
				}else if(allowancesRs.getString("isApprovedByDirector").equalsIgnoreCase("R")){
					
					vo.setIsRejectedStatus("Rejected");
					
				}else{
					
					vo.setIsRejectedStatus("Reject");
					vo.setAprovestatus("Approve");
				}
				
				if(allowancesRs.getString("Posted_By").equalsIgnoreCase(allowancesRs.getString("Project_Manager"))){
					vo.setPostedbyname(allowancesRs.getString("managername"));
				}else{
					
					postedmanagerpstmt=connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_POSTED_MANAGER);
					postedmanagerpstmt.setString(1, allowancesRs.getString("Posted_By"));
					
					postedmanagerrs=postedmanagerpstmt.executeQuery();
					
					while(postedmanagerrs.next()){
						
						vo.setPostedbyname(postedmanagerrs.getString("First_Name"));
					}
					
				}
				if(allowancesRs.getString("DirectorRemarks")==null ){
					vo.setApprovecoments("");
				}else{
				vo.setApprovecoments(allowancesRs.getString("DirectorRemarks"));
				}
				
				if(allowancesRs.getDouble("ApprovedAmount")==0.0){
					vo.setApproveamount(allowancesRs.getDouble("Amount"));
				}else{
				vo.setApproveamount(allowancesRs.getDouble("ApprovedAmount"));
				}
				
				vo.setProjectmanager(allowancesRs.getString("managername"));
				vo.setProjectmanagercode(allowancesRs.getString("Project_Manager"));
				vo.setProjectRefCode(allowancesRs.getString("ProjectRefCode"));
				vo.setRemarks(allowancesRs.getString("Remarks"));
				vo.setSingleteamgh(allowancesRs.getString("Single_team_GH"));
				vo.setTeaamLead(allowancesRs.getString("Team_Lead"));
				
				
				allowanceList.add(vo);
			
			
			}
			}else{
				

				
				allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_CONFLICTALLOW_NOT_APPROVEBY_ADMIN);
				allowancesPstmt.setString(1, startdate);
				allowancesPstmt.setString(2, endDate);
				int count=0;
				
				allowancesRs = allowancesPstmt.executeQuery();
				while (allowancesRs.next()) {
					
				
					EmpAllowAprroveByDirectorVo vo=new EmpAllowAprroveByDirectorVo();
					
					count++;
					
					vo.setSno(count);
					vo.setAllowanceCode(allowancesRs.getString("DALCode"));
					vo.setBioCode(allowancesRs.getString("BioCode"));
					vo.setEmpcode(allowancesRs.getString("EMPCODE"));
					ArrayList<String> empList=getEmployee(allowancesRs.getString("EMPCODE"), connection);
					vo.setEmpname(empList.get(0));
					vo.setAllowancesdate(HelperClass.convertDatabaseToUI(allowancesRs.getString("Allowance_Date")));
					vo.setProjectRefCode(allowancesRs.getString("ProjectRefCode"));
					vo.setAmount(allowancesRs.getString("Amount"));
					vo.setApproveamount(allowancesRs.getDouble("ApprovedAmount"));
					
					
					boolean flag=true;
					
					if(allowancesRs.getString("isRejected").equalsIgnoreCase("Y")){
						flag=false;
						vo.setAccountsApprovedAmount(allowancesRs.getDouble("AccountApprovedAmount"));
						vo.setIsRejectedStatus("Rejected");
						vo.setAccountsRemarks(allowancesRs.getString("AccountsRemarks"));
					}else{
						
						vo.setIsRejectedStatus("Reject");
					}

					if(allowancesRs.getString("isApprovedByAccounts").equalsIgnoreCase("Y")){
						flag=false;
						vo.setAccountsApprovedAmount(allowancesRs.getDouble("AccountApprovedAmount"));
						vo.setIsaccountsStatus("Approved");
						vo.setAccountsRemarks(allowancesRs.getString("AccountsRemarks"));
						
					}else{
						
						vo.setIsaccountsStatus("Approve");
					}
					
					if(flag){
						
						vo.setAccountsApprovedAmount(allowancesRs.getDouble("ApprovedAmount"));
						vo.setAccountsRemarks("");
						
					}
					
					vo.setApprovedbyId(allowancesRs.getString("ApprovedDirectorCode"));
					vo.setApprovedbyName(allowancesRs.getString("directorName"));
					vo.setApprovedByBioCode(allowancesRs.getString("bioid"));
					
			
					
					
					allowanceList.add(vo);
				
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
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getConflictEmployees : Ending");
		
	
		

		return allowanceList;

	}
	
	
	
	public ArrayList<EmpAllowAprroveByDirectorVo> getConflictEmployeesForDownLoad(String startdate,String endDate,String userType,String usercode) {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getConflictEmployees : Starting");

		PreparedStatement allowancesPstmt = null;
		ResultSet allowancesRs = null;
		
		PreparedStatement postedmanagerpstmt = null;
		ResultSet postedmanagerrs = null;
		
		Connection connection=null;
		
		ArrayList<EmpAllowAprroveByDirectorVo> allowanceList=new ArrayList<EmpAllowAprroveByDirectorVo>();
		try {
			
			connection =getConnection();
			
			if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				
			allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_CONFLICT_EMPLOYEES);
			allowancesPstmt.setString(1, usercode);
			allowancesPstmt.setString(2, startdate);
			allowancesPstmt.setString(3, endDate);
			
			
			int count=0;
			
			
			allowancesRs = allowancesPstmt.executeQuery();
			while (allowancesRs.next()) {
				count++;
				EmpAllowAprroveByDirectorVo vo=new EmpAllowAprroveByDirectorVo();
				
				vo.setSno(count);
				vo.setAllowanceCode(allowancesRs.getString("DALCode"));
				vo.setAllowancesdate(HelperClass.convertDatabaseToUI(allowancesRs.getString("Allowance_Date")));
				vo.setAmount(allowancesRs.getString("Amount"));
				vo.setBioCode(allowancesRs.getString("BioCode"));
				vo.setClientname(allowancesRs.getString("ClientName"));
				vo.setDatype(allowancesRs.getString("DAType"));
				vo.setEmpcode(allowancesRs.getString("EMPCODE"));
				vo.setEmpname(allowancesRs.getString("employeename"));
				
				if(allowancesRs.getString("HDFC_AC")==null){
				vo.setHdfcaccount("");
				}else{
					
					vo.setHdfcaccount(allowancesRs.getString("HDFC_AC"));
				}
				vo.setLocation(allowancesRs.getString("Location"));
				vo.setNoofdays(allowancesRs.getString("No_Of_days_Month"));
				vo.setPostedbycode(allowancesRs.getString("Posted_By"));
				
				if(allowancesRs.getString("isApprovedByDirector").equalsIgnoreCase("Y")){
					
					vo.setAprovestatus("Approved");
					
				}else if(allowancesRs.getString("isApprovedByDirector").equalsIgnoreCase("R")){
					
					vo.setAprovestatus("Rejected");
				}else{
					
					vo.setAprovestatus("Approve");
				}
				
				if(allowancesRs.getString("Posted_By").equalsIgnoreCase(allowancesRs.getString("Project_Manager"))){
					vo.setPostedbyname(allowancesRs.getString("managername"));
				}else{
					
					postedmanagerpstmt=connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_POSTED_MANAGER);
					postedmanagerpstmt.setString(1, allowancesRs.getString("Posted_By"));
					
					postedmanagerrs=postedmanagerpstmt.executeQuery();
					
					while(postedmanagerrs.next()){
						
						vo.setPostedbyname(postedmanagerrs.getString("First_Name"));
					}
					
				}
				if(allowancesRs.getString("DirectorRemarks")==null ){
					vo.setApprovecoments("");
				}else{
				vo.setApprovecoments(allowancesRs.getString("DirectorRemarks"));
				}
				
				if(allowancesRs.getDouble("ApprovedAmount")==0.0){
					vo.setApproveamount(allowancesRs.getDouble("Amount"));
				}else{
				vo.setApproveamount(allowancesRs.getDouble("ApprovedAmount"));
				}
				
				vo.setProjectmanager(allowancesRs.getString("managername"));
				vo.setProjectmanagercode(allowancesRs.getString("Project_Manager"));
				vo.setProjectRefCode(allowancesRs.getString("ProjectRefCode"));
				vo.setRemarks(allowancesRs.getString("Remarks"));
				vo.setSingleteamgh(allowancesRs.getString("Single_team_GH"));
				vo.setTeaamLead(allowancesRs.getString("Team_Lead"));
				
				
				allowanceList.add(vo);
			
			
				
			
			}
			}else{
				

				
				allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_CONFLICTALLOW_NOT_APPROVEBY_ADMIN);
				allowancesPstmt.setString(1, startdate);
				allowancesPstmt.setString(2, endDate);
				int count=0;
				
				allowancesRs = allowancesPstmt.executeQuery();
				while (allowancesRs.next()) {
					
					EmpAllowAprroveByDirectorVo vo=new EmpAllowAprroveByDirectorVo();
					
					count++;
					
					vo.setSno(count);
					vo.setAllowanceCode(allowancesRs.getString("DALCode"));
					
					vo.setEmpcode(allowancesRs.getString("EMPCODE"));
					ArrayList<String> empList=getEmployee(allowancesRs.getString("EMPCODE"), connection);
					vo.setBioCode(empList.get(2));
					vo.setEmpname(empList.get(0));
					vo.setProjectRefCode(allowancesRs.getString("ProjectRefCode"));
					vo.setAllowancesdate(HelperClass.convertDatabaseToUI(allowancesRs.getString("Allowance_Date")));
					vo.setAmount(allowancesRs.getString("Amount"));
					vo.setApproveamount(allowancesRs.getDouble("ApprovedAmount"));
					
					if(allowancesRs.getString("isApprovedByAccounts").equalsIgnoreCase("Y")){
						
						vo.setAccountsApprovedAmount(allowancesRs.getDouble("AccountApprovedAmount"));
						vo.setAccountsRemarks(allowancesRs.getString("AccountsRemarks"));
						vo.setApprovedaccountsName(allowancesRs.getString("approvedAccountantName"));
						vo.setApprovedAccounttime(allowancesRs.getString("AccountsApprovedTime"));
						vo.setIsaccountsStatus("Approved");
						
					}
					
					else if(allowancesRs.getString("isRejected").equalsIgnoreCase("Y")){
						
						vo.setAccountsApprovedAmount(allowancesRs.getDouble("AccountApprovedAmount"));
						vo.setAccountsRemarks(allowancesRs.getString("AccountsRemarks"));
						vo.setApprovedaccountsName(allowancesRs.getString("approvedAccountantName"));
						vo.setApprovedAccounttime(allowancesRs.getString("AccountsApprovedTime"));
						vo.setIsaccountsStatus("Rejected");
				
					}else{
						
						vo.setAccountsApprovedAmount(allowancesRs.getDouble("ApprovedAmount"));
						vo.setAccountsRemarks("-");
						vo.setApprovedaccountsName("-");
						vo.setApprovedAccounttime("-");
						vo.setIsaccountsStatus("Not Approved");
					}
					
					vo.setPostedbycode(allowancesRs.getString("Posted_By"));
					String postedByMgrName=getManager(allowancesRs.getString("Posted_By"), connection);
					vo.setPostedbyname(postedByMgrName);
					
					vo.setProjectmanagercode(allowancesRs.getString("Project_Manager"));
					String ProjectMgr=getManager(allowancesRs.getString("Project_Manager"), connection);
					vo.setProjectmanager(ProjectMgr);
					vo.setClientname(allowancesRs.getString("ClientName"));
					
					vo.setTeaamLead(allowancesRs.getString("Team_Lead"));
					vo.setSingleteamgh(allowancesRs.getString("Single_team_GH"));
					
					vo.setDatype(allowancesRs.getString("DAType"));
					vo.setNoofdays(allowancesRs.getString("No_Of_days_Month"));
					
					vo.setLocation(allowancesRs.getString("Location"));
					vo.setHdfcaccount(empList.get(1));
					
								
					vo.setRemarks(allowancesRs.getString("Remarks"));
					if(allowancesRs.getString("DirectorRemarks")==null){
						vo.setApprovecoments("");
					}else{
					vo.setApprovecoments(allowancesRs.getString("DirectorRemarks"));
					}
					
					
					vo.setApprovedbyId(allowancesRs.getString("ApprovedDirectorCode"));
					vo.setApprovedbyName(allowancesRs.getString("directorName"));
					vo.setApprovedByBioCode(allowancesRs.getString("bioid"));
					
					allowanceList.add(vo);
				
					
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
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getConflictEmployees : Ending");
		
	
		

		return allowanceList;

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
	
	
	public ApproveAllowByDirectorMailDetailsVo getAllowanceMailDetails(String allowanceCode,String approvedname) {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getAllowanceMailDetails : Starting");

		PreparedStatement allowancesPstmt = null;
		ResultSet allowancesRs = null;
	
		
		Connection connection=null;
		
		ApproveAllowByDirectorMailDetailsVo vo=new ApproveAllowByDirectorMailDetailsVo();
		
		try {
			
			connection =getConnection();
			allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_MAIL_DETAILS);
			allowancesPstmt.setString(1, allowanceCode);
			
			
			allowancesRs = allowancesPstmt.executeQuery();
			
			while (allowancesRs.next()) {
				
				vo.setEmpname(allowancesRs.getString("First_Name"));
				vo.setDate(allowancesRs.getString("Allowance_Date"));
				vo.setAmount(allowancesRs.getString("ApprovedAmount"));
				vo.setManagerMail(allowancesRs.getString("email"));
				vo.setDirectorMail(allowancesRs.getString("directorMailID"));
				vo.setApprovedName(approvedname);
				vo.setClimedAmount(allowancesRs.getString("Amount"));
				vo.setManagerName(getManager(allowancesRs.getString("Posted_By"), connection));
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
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getAllowanceMailDetails : Ending");

		return vo;

	}

	
	public ArrayList<String> getEmployee(String empcode, Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmpAllowAprroveByDirectorDaoImpl: getEmployee  Starting");
	
		PreparedStatement ps_employee = null;
		ResultSet rs_employee=null;
		ArrayList<String> emplist=new ArrayList<String>();
		
		try{
			ps_employee=connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_EMPLOYEE_BY_EMPCODE);
			ps_employee.setString(1,empcode);
			rs_employee=ps_employee.executeQuery();
			
			while(rs_employee.next()){
			
					emplist.add(rs_employee.getString("First_Name"));
					if(rs_employee.getString("HDFC_AC")==null){
						emplist.add("-");
					}else{
						emplist.add(rs_employee.getString("HDFC_AC"));
				}
					emplist.add(rs_employee.getString("bioid"));
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
		logger.info(JDate.getTimeString(new Date())+ " Control in EmpAllowAprroveByDirectorDaoImpl : getEmployee Ending");
		
	
		return emplist;
	}
	
	
	public String getManager(String managercode, Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmpAllowAprroveByDirectorDaoImpl: getManager  Starting");
	
		PreparedStatement ps_employee = null;
		ResultSet rs_employee=null;
		String employee=null;
		
		try{
			ps_employee=connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_MANAGER_BY_MGRCODE);
			ps_employee.setString(1,managercode);
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
		logger.info(JDate.getTimeString(new Date())+ " Control in EmpAllowAprroveByDirectorDaoImpl : getManager Ending");
		
	
		return employee;
	}


	@Override
	public ArrayList<EmpAllowAprroveByDirectorVo> getAllowancesForDownload(
			String startdate, String endDate, String userType, String usercode) {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getAllowancesForDownload : Starting");

		PreparedStatement allowancesPstmt = null;
		ResultSet allowancesRs = null;
		
		PreparedStatement postedmanagerpstmt = null;
		ResultSet postedmanagerrs = null;
		
		Connection connection=null;
		int count=0;
		
		ArrayList<EmpAllowAprroveByDirectorVo> allowanceList=new ArrayList<EmpAllowAprroveByDirectorVo>();
		try {
			
			connection =getConnection();
			
			
			if(userType.equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				
			allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_ALLOWANCES_NOT_APPROVED);
			allowancesPstmt.setString(1, usercode);
			allowancesPstmt.setString(2, startdate);
			allowancesPstmt.setString(3, endDate);
			
			allowancesRs = allowancesPstmt.executeQuery();
			while (allowancesRs.next()) {
				EmpAllowAprroveByDirectorVo vo=new EmpAllowAprroveByDirectorVo();
				
				count++;
				
				vo.setSno(count);
				vo.setAllowanceCode(allowancesRs.getString("DALCode"));
				
				vo.setBioCode(allowancesRs.getString("BioCode"));
				vo.setEmpcode(allowancesRs.getString("EMPCODE"));
				vo.setEmpname(allowancesRs.getString("employeename"));
				vo.setProjectRefCode(allowancesRs.getString("ProjectRefCode"));
				vo.setAllowancesdate(HelperClass.convertDatabaseToUI(allowancesRs.getString("Allowance_Date")));
				vo.setAmount(allowancesRs.getString("Amount"));
				vo.setApproveamount(allowancesRs.getDouble("ApprovedAmount"));
				
				vo.setProjectmanager(allowancesRs.getString("managername"));
				vo.setProjectmanagercode(allowancesRs.getString("Project_Manager"));
				vo.setClientname(allowancesRs.getString("ClientName"));
				vo.setDatype(allowancesRs.getString("DAType"));
				vo.setLocation(allowancesRs.getString("Location"));
				vo.setNoofdays(allowancesRs.getString("No_Of_days_Month"));
				if(allowancesRs.getString("HDFC_AC")==null ){
					vo.setHdfcaccount("-");
				}else{
					vo.setHdfcaccount(allowancesRs.getString("HDFC_AC"));
				}
				vo.setSingleteamgh(allowancesRs.getString("Single_team_GH"));
				vo.setTeaamLead(allowancesRs.getString("Team_Lead"));
				

				
				if(allowancesRs.getString("isApprovedByDirector").equalsIgnoreCase("Y")){
					
					vo.setAprovestatus("Approved");
					
				}else if(allowancesRs.getString("isApprovedByDirector").equalsIgnoreCase("R")){
					
					vo.setAprovestatus("Rejected");
				}else{
					
					vo.setAprovestatus("Not Approved");
				}
				
				
				vo.setPostedbycode(allowancesRs.getString("Posted_By"));			
				postedmanagerpstmt=connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_POSTED_MANAGER);
				postedmanagerpstmt.setString(1, allowancesRs.getString("Posted_By"));
					
				postedmanagerrs=postedmanagerpstmt.executeQuery();
					
				while(postedmanagerrs.next()){
						
						vo.setPostedbyname(postedmanagerrs.getString("First_Name"));
						vo.setPostedByBioCode(postedmanagerrs.getString("bioid"));
				}
				
				vo.setRemarks(allowancesRs.getString("Remarks"));
				
				
				if(allowancesRs.getString("DirectorRemarks")==null){
					vo.setApprovecoments("");
				}else{
				vo.setApprovecoments(allowancesRs.getString("DirectorRemarks"));
				}
				
				
				allowanceList.add(vo);
			
			}
			
			
		}else{
			
		allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_ALLOW_NOT_APPROVEBY_ADMIN);
		allowancesPstmt.setString(1, startdate);
		allowancesPstmt.setString(2, endDate);
		

		allowancesRs = allowancesPstmt.executeQuery();
		
		while (allowancesRs.next()) {
			EmpAllowAprroveByDirectorVo vo=new EmpAllowAprroveByDirectorVo();
			
			count++;
			
			vo.setSno(count);
			vo.setAllowanceCode(allowancesRs.getString("DALCode"));
			
			vo.setEmpcode(allowancesRs.getString("EMPCODE"));
			ArrayList<String> empList=getEmployee(allowancesRs.getString("EMPCODE"), connection);
			vo.setBioCode(empList.get(2));
			vo.setEmpname(empList.get(0));
			vo.setProjectRefCode(allowancesRs.getString("ProjectRefCode"));
			vo.setAllowancesdate(HelperClass.convertDatabaseToUI(allowancesRs.getString("Allowance_Date")));
			vo.setAmount(allowancesRs.getString("Amount"));
			vo.setApproveamount(allowancesRs.getDouble("ApprovedAmount"));
			
			if(allowancesRs.getString("isApprovedByAccounts").equalsIgnoreCase("Y")){
				
				vo.setAccountsApprovedAmount(allowancesRs.getDouble("AccountApprovedAmount"));
				vo.setAccountsRemarks(allowancesRs.getString("AccountsRemarks"));
				vo.setApprovedaccountsName(allowancesRs.getString("approvedAccountantName"));
				vo.setApprovedAccounttime(allowancesRs.getString("AccountsApprovedTime"));
				vo.setIsaccountsStatus("Approved");
				
			}
			
			else if(allowancesRs.getString("isRejected").equalsIgnoreCase("Y")){
				
				vo.setAccountsApprovedAmount(allowancesRs.getDouble("AccountApprovedAmount"));
				vo.setAccountsRemarks(allowancesRs.getString("AccountsRemarks"));
				vo.setApprovedaccountsName(allowancesRs.getString("approvedAccountantName"));
				vo.setApprovedAccounttime(allowancesRs.getString("AccountsApprovedTime"));
				vo.setIsaccountsStatus("Rejected");
		
			}else{
				
				vo.setAccountsApprovedAmount(allowancesRs.getDouble("ApprovedAmount"));
				vo.setAccountsRemarks("-");
				vo.setApprovedaccountsName("-");
				vo.setApprovedAccounttime("-");
				vo.setIsaccountsStatus("Not Approved");
			}
			
			vo.setPostedbycode(allowancesRs.getString("Posted_By"));
			String postedByMgrName=getManager(allowancesRs.getString("Posted_By"), connection);
			vo.setPostedbyname(postedByMgrName);
			
			vo.setProjectmanagercode(allowancesRs.getString("Project_Manager"));
			String ProjectMgr=getManager(allowancesRs.getString("Project_Manager"), connection);
			vo.setProjectmanager(ProjectMgr);
			vo.setClientname(allowancesRs.getString("ClientName"));
			
			vo.setTeaamLead(allowancesRs.getString("Team_Lead"));
			vo.setSingleteamgh(allowancesRs.getString("Single_team_GH"));
			
			vo.setDatype(allowancesRs.getString("DAType"));
			vo.setNoofdays(allowancesRs.getString("No_Of_days_Month"));
			
			vo.setLocation(allowancesRs.getString("Location"));
			vo.setHdfcaccount(empList.get(1));
			
						
			vo.setRemarks(allowancesRs.getString("Remarks"));
			if(allowancesRs.getString("DirectorRemarks")==null){
				vo.setApprovecoments("");
			}else{
			vo.setApprovecoments(allowancesRs.getString("DirectorRemarks"));
			}
			
			
			vo.setApprovedbyId(allowancesRs.getString("ApprovedDirectorCode"));
			vo.setApprovedbyName(allowancesRs.getString("directorName"));
			vo.setApprovedByBioCode(allowancesRs.getString("bioid"));
			
			allowanceList.add(vo);
		
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
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getAllowancesForDownload : Ending");

		return allowanceList;

	}


	@Override
	public String approveAllAllowansesDao(
			EmpAllowAprroveByDirectorPojo allowancePojo) {
		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : approveAllAllowansesDao : Starting");

		PreparedStatement allowancesPstmt = null;
		int count=0;
		String status=null;
		PreparedStatement allowancesPstmt1=null;
		int mailcount=0;
		
		
		
		Connection connection=null;
		
		String[] allowanceCode=allowancePojo.getAllowanceCode().split(",");
		String[] approvedAmount=allowancePojo.getApprovedamount().split(",");
		String[] directorcomments=allowancePojo.getRemarks().split("\\|");
		
		
		
		try {
			
			connection =getConnection();
			String url = getServerUrlFromBD(connection);
			
			if(allowancePojo.getUserType().equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
			
			for(int i=0;i<allowanceCode.length;i++){
				
			
			allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.APPROVE_SINGLE_ALLOWANCE);
			allowancesPstmt.setString(1, approvedAmount[i]);
			if("null".equalsIgnoreCase(directorcomments[i])){
				allowancesPstmt.setString(2, "");
			}else{
				allowancesPstmt.setString(2, directorcomments[i]);
			}
			
			allowancesPstmt.setString(3, allowancePojo.getApprovedby().trim());
			allowancesPstmt.setTimestamp(4, HelperClass.getCurrentTimestamp());
			allowancesPstmt.setString(5, allowanceCode[i]);
			
			count = allowancesPstmt.executeUpdate();
			
			
			}
			
			if(count>0){
				
				status="true";
				
				String mailStatus = sendEmailToAccounts(allowancePojo.getAllowanceCode().trim(),allowancePojo.getApprovedbyName(),url,"All");
				
				if(mailStatus.equalsIgnoreCase("true")){
					
					status=MessageConstants.MAIL_SENT;
				}
			}
			
			}else{
				
				for(int i=0;i<allowanceCode.length;i++){
				
				allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.APPROVE_ALLOWANCE_BY_ADMIN);
			
				allowancesPstmt.setString(1, allowancePojo.getApprovedby().trim());
				allowancesPstmt.setTimestamp(2, HelperClass.getCurrentTimestamp());
				if("null".equalsIgnoreCase(directorcomments[i])){
					allowancesPstmt.setString(3, "");
				}else{
					allowancesPstmt.setString(3, directorcomments[i]);
				}
				allowancesPstmt.setString(4, approvedAmount[i]);
				allowancesPstmt.setString(5, allowanceCode[i]);
				
				count = allowancesPstmt.executeUpdate();
				
				}
				
				
				if(count>0){
					
					status="true";
					
					String mailStatus = sendEmailToAll(allowancePojo.getAllowanceCode().trim(),allowancePojo.getApprovedbyName(),url);
					
					if(mailStatus.equalsIgnoreCase("true")){
						
						for(int i=0;i<allowanceCode.length;i++){
						allowancesPstmt1 = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.UPDATE_MAILSTATUS);
						allowancesPstmt1.setTimestamp(1, HelperClass.getCurrentTimestamp());
						allowancesPstmt1.setString(2, allowanceCode[i]);
						
						mailcount=allowancesPstmt1.executeUpdate();
						}
						if(mailcount>0){
							
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
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : approveAllAllowansesDao : Ending");

		return status;

	}
	

	public String sendEmailToAccounts(String allowanceCode, String approvedbyName,String url,String mailto) {
		
		
		Connection connection=null;
		
		String mailSent=null;
		
		try {
			connection =getConnection();
			
			EmailContent em = new EmailContent();
			
			ArrayList<String> mailList=getAdminMailDetails();
			
			
			if(mailto.equalsIgnoreCase("single")){
				
				
				ApproveAllowByDirectorMailDetailsVo vo=getAllowanceMailDetails(allowanceCode, approvedbyName);
				
				String[] mails =new String[mailList.size()+1];
				
				for(int i=0;i<mailList.size();i++){
					
					mails[i]=mailList.get(i);
				}
				
				
				for(int j=0;j<mails.length;j++){
					
					if(!(mails[j].equalsIgnoreCase(vo.getManagerMail()))){
						
						mails[mailList.size()]=vo.getManagerMail();
					}
				}
				
				em.setMailids(mails);
				em.setSubject("Allowance Approvel Details");
				
			em.setMessage("Greetings from TeleIndia. \n\n"
					+ "Allowances approved successfully. \n\n"
					+ "Employee Name : "+vo.getEmpname().trim()+". \n"
					+ "Claimed Amount : "+vo.getClimedAmount()+". \n"
					+ "Approved Amount : "+vo.getAmount().trim()+". \n"
					+ "Allowance Date : "+HelperClass.convertDatabaseToUI(vo.getDate().trim())+". \n\n"
					+ "Allowance Approved  By :  \n"
					+ "Name : "+vo.getApprovedName().trim()+". \n"
					+ "Designation : Director. \n\n"
					+ "For more Details Login URL : " + url + "\n"
					+ "Have a nice day \n\n"
					+ "E-ATTENDANCE PRO  \n"
					+ "----------------------------------------------------------\n"
					+ "This is system generated mail,Please do not reply");
			
		    	mailSent=new SendMailWithMultipleAttachment().sendReportToMail(em);
			
			}else{
				
				String[] mails =new String[mailList.size()];
				
				for(int i=0;i<mailList.size();i++){
							
							mails[i]=mailList.get(i);
						
				}
				
			
			 
				ArrayList<AllowancesClaimByManagerVO> allowanceslist=getEmpAllowanceDetails(allowanceCode);
				
			final StringBuilder  sb = new  EmpAllowancesUtil().getEmpFormatTable(allowanceslist);
	         
			      	em.setMailids(mails);
					em.setSubject("Allowance Approvel Details");
		      
					em.setMessage("Greetings from TeleIndia. "+"<html><br/><br/></html>"
							+ "All Claimed allowances Approved Successfully "+"<html><br/><br/></html>"
							+ "Allowances Approved  By :  "+"<html><br/></html>"
							+ "Name : "+approvedbyName.trim()+"<html><br/></html>"
							+ "Designation : Director "+"<html><br/><br/></html>"
							+ "For more Approved Details Please find the below Table or Login URL : " + url + "<html><br/></html>"
							+ sb.toString() +"<html><br/><br/></html>"
							+ "Have a nice day "+"<html><br/><br/></html>"
							+ "E-ATTENDANCE PRO  "+"<html><br/></html>"
							+ "----------------------------------------------------------"+"<html><br/></html>"
							+ "This is system generated mail,Please do not reply");
					
					
					mailSent=new SendMailWithMultipleAttachment().sendReportToMailAllowances(em);
					
			if(mailSent.equals("true")){
						
					
				LinkedHashMap<String,ArrayList<AllowancesClaimByManagerVO>> mangwiseempallowance = getMangmapEmpallowance(allowanceCode,connection);	
						
				Set<String> keys = mangwiseempallowance.keySet();
					
			for (String postedby : keys) {
				
					Map<String,String> managerMap= new EmpAllowAprroveByDirectorDaoImpl().getManagerDetailsById(postedby,connection);
					
				   String mangemaiId = managerMap.get("email");
				 	
					final StringBuilder  sb1 = new  EmpAllowancesUtil().getEmpFormatTable(mangwiseempallowance.get(postedby));
				   
				   String[] mangmail ={mangemaiId};
				   
					em.setMailids(mangmail);
					em.setSubject("Allowance Approvel Details");
		      
					em.setMessage("Greetings from TeleIndia. "+"<html><br/><br/></html>"
							+ "All Claimed allowances Approved Successfully "+"<html><br/><br/></html>"
							+ "Allowances Approved  By :  "+"<html><br/></html>"
							+ "Name : "+approvedbyName.trim()+"<html><br/></html>"
							+ "Designation : Director "+"<html><br/><br/></html>"
							+ "For more Approved Details Please find the below Table or Login URL : " + url + "<html><br/></html>"
							+ sb1.toString() +"<html><br/><br/></html>"
							+ "Have a nice day "+"<html><br/><br/></html>"
							+ "E-ATTENDANCE PRO  "+"<html><br/></html>"
							+ "----------------------------------------------------------"+"<html><br/></html>"
							+ "This is system generated mail,Please do not reply");
					
					
					mailSent=new SendMailWithMultipleAttachment().sendReportToMailAllowances(em);
				  
					
				
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
				
				if(connection != null && (!connection.isClosed())){

					connection.close();
				}
				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

		
		return mailSent;
	}

	
	


	public ArrayList<AllowancesClaimByManagerVO> getEmpAllowanceDetailsByAdmin(
			String allowanceCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getEmpAllowanceDetailsByAdmin : Starting");

		PreparedStatement ps_getallowance = null;
		Connection connection=null;
		ResultSet rs_getallowance=null;
		int count=0;
		ArrayList<AllowancesClaimByManagerVO> allowancelist=new ArrayList<AllowancesClaimByManagerVO>();
		try {
			
			connection=getConnection();
	
			String[] dalcode=allowanceCode.split(",");
			
			for (int i = 0; i < dalcode.length; i++) {
				
				ps_getallowance = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_EMP_ALLOWANCES_BY_ADMIN);
				ps_getallowance.setString(1, dalcode[i]);
				
				rs_getallowance=ps_getallowance.executeQuery();
				
	
				
				while(rs_getallowance.next()){
					count++;
					AllowancesClaimByManagerVO allowanceVO = new AllowancesClaimByManagerVO();
					
					allowanceVO.setSno(count);
					allowanceVO.setBioid(rs_getallowance.getString("BioCode"));
					allowanceVO.setEmpname(rs_getallowance.getString("First_Name"));
					allowanceVO.setProject(rs_getallowance.getString("ProjectRefCode"));
					allowanceVO.setAmount(rs_getallowance.getDouble("Amount"));
					allowanceVO.setApprovedamount(rs_getallowance.getDouble("AccountApprovedAmount"));
					
					allowancelist.add(allowanceVO);
					
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
				
				
				if(rs_getallowance != null && (!rs_getallowance.isClosed())){
					
					rs_getallowance.close();
				}
				
				if(ps_getallowance != null && (!ps_getallowance.isClosed())){
					
					ps_getallowance.close();
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
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getEmpAllowanceDetailsByAdmin : Ending");

		
		return allowancelist;
	}


	private ArrayList<AllowancesClaimByManagerVO> getEmpAllowanceDetails(
			String allowanceCode) {


		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getEmpAllowanceDetails : Starting");

		PreparedStatement ps_getallowance = null;
		Connection connection=null;
		ResultSet rs_getallowance=null;
		int count=0;
		ArrayList<AllowancesClaimByManagerVO> allowancelist=new ArrayList<AllowancesClaimByManagerVO>();
		try {
			
			connection=getConnection();
	
			String[] dalcode=allowanceCode.split(",");
			
			for (int i = 0; i < dalcode.length; i++) {
				
				ps_getallowance = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_EMP_ALLOWANCES);
				ps_getallowance.setString(1, dalcode[i]);
				
				rs_getallowance=ps_getallowance.executeQuery();
				
				while(rs_getallowance.next()){
					count++;
					AllowancesClaimByManagerVO allowanceVO = new AllowancesClaimByManagerVO();
					
					allowanceVO.setSno(count);
					allowanceVO.setBioid(rs_getallowance.getString("BioCode"));
					allowanceVO.setEmpname(rs_getallowance.getString("First_Name"));
					allowanceVO.setProject(rs_getallowance.getString("ProjectRefCode"));
					allowanceVO.setAmount(rs_getallowance.getDouble("Amount"));
					allowanceVO.setApprovedamount(rs_getallowance.getDouble("ApprovedAmount"));
					allowanceVO.setAllowancedate(HelperClass.convertDatabaseToUI(rs_getallowance.getString("Allowance_Date")));
					allowancelist.add(allowanceVO);
					
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
				
				
				if(rs_getallowance != null && (!rs_getallowance.isClosed())){
					
					rs_getallowance.close();
				}
				
				if(ps_getallowance != null && (!ps_getallowance.isClosed())){
					
					ps_getallowance.close();
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
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : getEmpAllowanceDetails : Ending");

		
		return allowancelist;
		
	}


	public String sendEmailToAll(String allowanceCode, String approvedbyName,String url) {
		
		Connection connection=null;
		String mailStatus=null;
		
		try{
		
			connection = getConnection();
			
		LinkedHashMap<String,ArrayList<AllowancesClaimByManagerVO>> direwiseempallowance = getDiremapEmpallowance(allowanceCode,connection,"director");		
		
		Set<String> apprivedDireCode = direwiseempallowance.keySet();
		
		for (String direcode : apprivedDireCode) {
			
			String direEmilId= getDirectorEmailId(direcode ,connection);
			
          final StringBuilder  sb =	new AllowancesInAdminUtil().getEmpFormatTable(direwiseempallowance.get(direcode));
			
      	EmailContent em = new EmailContent();
          
      	String[] mails ={direEmilId};

		em.setMailids(mails);
		em.setSubject("Allowance Approvel Details");
  
		em.setMessage("Greetings from TeleIndia. "+"<html><br/><br/></html>"
				+ "All your Claimed allowanses Approved Successfully "+"<html><br/><br/></html>"
				+ "Allowances Approved  By :   "+"<html><br/></html>"
				+ "Name : "+approvedbyName.trim()+"<html><br/></html>"
				+ "Designation : Accountant"+"<html><br/><br/></html>"
				+ "For more Approved Details Please find the below Table or Login URL : " + url + "<html><br/></html>"
				+ sb.toString() +"<html><br/><br/></html>"
				+ "Have a nice day "+"<html><br/><br/></html>"
				+ "E-ATTENDANCE PRO  "+"<html><br/></html>"
				+ "----------------------------------------------------------"+"<html><br/></html>"
				+ "This is system generated mail,Please do not reply");
		
		
		   mailStatus=new SendMailWithMultipleAttachment().sendReportToMailAllowances(em);
			
			
		}		
	
	if(mailStatus.equals("true")){
			
			LinkedHashMap<String,ArrayList<AllowancesClaimByManagerVO>> mangwiseempallowance = getDiremapEmpallowance(allowanceCode,connection,"manager");	
			
			Set<String> keys = mangwiseempallowance.keySet();
			
			for (String postedby : keys) {
						
		    	Map<String,String> managerMap= new EmpAllowAprroveByDirectorDaoImpl().getManagerDetailsById(postedby,connection);
				
		          final StringBuilder  sb1 =	new AllowancesInAdminUtil().getEmpFormatTable(mangwiseempallowance.get(postedby));
					
		      	EmailContent em = new EmailContent();
		          
		      	String mangEmaiId = managerMap.get("email");
		      	
		      	String[] mails ={mangEmaiId};

				em.setMailids(mails);
				em.setSubject("Allowance Approvel Details");
		  
				em.setMessage("Greetings from TeleIndia. "+"<html><br/><br/></html>"
						+ "All your Claimed allowanses Approved Successfully "+"<html><br/><br/></html>"
						+ "Allowances Approved  By :   "+"<html><br/></html>"
						+ "Name : "+approvedbyName.trim()+"<html><br/></html>"
						+ "Designation : Accountant"+"<html><br/><br/></html>"
						+ "For more Approved Details Please find the below Table or Login URL : " + url + "<html><br/></html>"
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





	public  String getDirectorEmailId(String directorcode, Connection connection) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmpAllowAprroveByDirectorDaoImpl: getDirectorEmailId  Starting");
	
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
		logger.info(JDate.getTimeString(new Date())+ " Control in EmpAllowAprroveByDirectorDaoImpl : getDirectorEmailId Ending");
		
	
		return direEmailId;
	}


	public String sendEmailToManagerAndDirector(String allowanceCode,String approveamount, String approvedbyName,String url) {
		
		String mailStatus=null;
		try {
			
			ApproveAllowByDirectorMailDetailsVo vo=getAllowanceMailDetails(allowanceCode, approvedbyName); 
			
			EmailContent em = new EmailContent();
			String[] mails = { vo.getManagerMail(),vo.getDirectorMail()};

			em.setMailids(mails);
			em.setSubject("Allowance Approvel Details");

			em.setMessage("Greetings from TeleIndia. \n\n"
					+ "Allowances approved successfully. \n\n"
					+ "Employee Name : "+vo.getEmpname().trim()+". \n"
					+ "Claimed Amount : "+vo.getClimedAmount()+". \n"
					+ "Approved Amount : "+approveamount.trim()+". \n"
					+ "Allowance Date : "+HelperClass.convertDatabaseToUI(vo.getDate().trim())+". \n\n"
					+ "Allowance Approved  By :  \n"
					+ "Name : "+vo.getApprovedName().trim()+". \n"
					+ "Designation : Accountant. \n\n"
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
	
	public String sendEmailToManagerAndDirectorForReject(String allowanceCode, String approvedbyName,String url) {
		
		String mailStatus=null;
		try {
			
			ApproveAllowByDirectorMailDetailsVo vo=getAllowanceMailDetails(allowanceCode, approvedbyName); 
			
			EmailContent em = new EmailContent();
			String[] mails = { vo.getManagerMail(),vo.getDirectorMail()};

			em.setMailids(mails);
			em.setSubject("Allowance Rejected Details");

			em.setMessage("Greetings from TeleIndia. \n\n"
					+ "Your Allowances rejected By: \n"
					+ "Name : "+vo.getApprovedName().trim()+". \n"
					+ "Designation : Accountant. \n\n"
					+ "Allowance Details :"
					+ "Employee Name : "+vo.getEmpname().trim()+". \n"
					+ "Claimed Amount : "+vo.getClimedAmount()+". \n"
					+ "Allowance Date : "+HelperClass.convertDatabaseToUI(vo.getDate().trim())+". \n\n"
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
	
	
	public ArrayList<String> getAllMailIds(String allowanceCode){
	

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmpAllowAprroveByDirectorDaoImpl : getAllMailIds : Starting");

	PreparedStatement approveTktPstmt = null;
	Connection connection=null;
	ResultSet rs=null;
	ArrayList<String> mailId=new ArrayList<String>();
	try {
		
		connection=getConnection();
		approveTktPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_ALL_MAIL_IDS);
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
				
				if(!(mailId.contains(rs.getString("Username")))){
					
					mailId.add(rs.getString("Username"));
					
				}
				
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
			+ " Control in EmpAllowAprroveByDirectorDaoImpl : getAllMailIds : Ending");

	
	return mailId;
	
}
	
	
		
	public ArrayList<String> getAdminMailDetails(){
		

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmpAllowAprroveByDirectorDaoImpl : getAdminMailDetails : Starting");

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
			+ " Control in EmpAllowAprroveByDirectorDaoImpl : getAdminMailDetails : Ending");

	
	return mailId;
	
}

	
	public String rejectSingleAllowance(EmpAllowAprroveByDirectorPojo allowancePojo){

		// TODO Auto-generated method stub

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : rejectSingleAllowance : Starting");

		PreparedStatement allowancesPstmt = null;
		int count=0;
		String status=null;
		Connection connection=null;
		PreparedStatement allowancesPstmt1 = null;
		int mailcount=0;
		
		try {
			
			
			connection =getConnection();
			String url = getServerUrlFromBD(connection);
			
			if(allowancePojo.getUserType().equalsIgnoreCase(LoginDetails.DIRECTOR_ID_TYPE)){
				
				allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.REJECT_ALLOWANCES_BYDIRECTOR);
				
					allowancesPstmt.setString(1, allowancePojo.getRemarks().trim());
					allowancesPstmt.setTimestamp(2, HelperClass.getCurrentTimestamp());
					allowancesPstmt.setString(3, allowancePojo.getUserId());
					allowancesPstmt.setString(4, allowancePojo.getApprovedamount());
					allowancesPstmt.setString(5, allowancePojo.getAllowanceCode().trim());
					
			
					count = allowancesPstmt.executeUpdate();
					
					if(count>0){
						
						status="true";
						
						String mailStatus = sendEmailToManagerForReject(allowancePojo.getAllowanceCode().trim(),allowancePojo.getApprovedbyName(),url);
							
						if(mailStatus.equalsIgnoreCase("true")){
							
							allowancesPstmt1 = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.UPDATE_MAILSTATUS);
							allowancesPstmt1.setTimestamp(1, HelperClass.getCurrentTimestamp());
							allowancesPstmt1.setString(2, allowancePojo.getAllowanceCode().trim());
							
							mailcount=allowancesPstmt1.executeUpdate();
							if(mailcount>0){
								
								status=MessageConstants.MAIL_SENT;
							}
							
							
						}
					}
				
				
			}else{
			
			allowancesPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.UPDATE_REJET_ALLOWANCE_DETAILS);
			
				allowancesPstmt.setString(1, allowancePojo.getRemarks().trim());
				allowancesPstmt.setTimestamp(2, HelperClass.getCurrentTimestamp());
				allowancesPstmt.setString(3, allowancePojo.getUserId());
				allowancesPstmt.setString(4, allowancePojo.getApprovedamount());
				allowancesPstmt.setString(5, allowancePojo.getAllowanceCode().trim());
				
		
				count = allowancesPstmt.executeUpdate();
				
				if(count>0){
					
					status="true";
					
					String mailStatus = sendEmailToManagerAndDirectorForReject(allowancePojo.getAllowanceCode().trim(),allowancePojo.getApprovedbyName(),url);
						
					if(mailStatus.equalsIgnoreCase("true")){
						
						allowancesPstmt1 = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.UPDATE_MAILSTATUS);
						allowancesPstmt1.setTimestamp(1, HelperClass.getCurrentTimestamp());
						allowancesPstmt1.setString(2, allowancePojo.getAllowanceCode().trim());
						
						mailcount=allowancesPstmt1.executeUpdate();
						if(mailcount>0){
							
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
				+ " Control in EmpAllowAprroveByDirectorDaoImpl : rejectSingleAllowance : Ending");

		return status;

	
	}
	
	
	public String sendEmailToManagerForReject(String allowanceCode, String approvedbyName,String url) {
		
		String mailStatus=null;
		try {
			
			ApproveAllowByDirectorMailDetailsVo vo=getAllowanceMailDetails(allowanceCode, approvedbyName); 
			ArrayList<String> mailList=getAdminMailDetails();
			
			String[] mails =new String[mailList.size()+1];
			
			for(int i=0;i<mailList.size();i++){
				
				mails[i]=mailList.get(i);
			}
			
			
			for(int j=0;j<mails.length;j++){
				
				if(!(mails[j].equalsIgnoreCase(vo.getManagerMail()))){
					
					mails[mailList.size()]=vo.getManagerMail();
				}
			}
			
			EmailContent em = new EmailContent();

			em.setMailids(mails);
			
			em.setSubject("Allowance Rejected Details");

			em.setMessage("Greetings from TeleIndia. \n\n"
					+ "Your Allowances rejected By: \n"
					+ "Name : "+vo.getApprovedName().trim()+". \n"
					+ "Designation : Director. \n\n"
					+ "Allowance Details : \n"
					+ "Employee Name : "+vo.getEmpname().trim()+". \n"
					+ "Claimed Amount : "+vo.getClimedAmount()+". \n"
					+ "Allowance Date : "+HelperClass.convertDatabaseToUI(vo.getDate().trim())+". \n\n"
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
			+ " Control in EmpAllowAprroveByDirectorDaoImpl : getMgrMailForAllApprove : Starting");

	PreparedStatement approveTktPstmt = null;
	Connection connection=null;
	ResultSet rs=null;
	ArrayList<String> mailId=new ArrayList<String>();
	try {
		
		connection=getConnection();
		approveTktPstmt = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_MGRMAIL_FORALL_APPROVE);
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
			+ " Control in EmpAllowAprroveByDirectorDaoImpl : getMgrMailForAllApprove : Ending");

	
	return mailId;
	
}
	
	
  public LinkedHashMap<String, ArrayList<AllowancesClaimByManagerVO>> getMangmapEmpallowance(
			String allowanceCode, Connection connection) {
		
		
		PreparedStatement ps_getallowance = null;
		
		ResultSet rs_getallowance=null;
		int count=0;
		ArrayList<AllowancesClaimByManagerVO> allowancelist=new ArrayList<AllowancesClaimByManagerVO>();
		LinkedHashMap<String, ArrayList<AllowancesClaimByManagerVO>> maplist = new LinkedHashMap<String, ArrayList<AllowancesClaimByManagerVO>>();
		try {
			
			
			String[] dalcode=allowanceCode.split(",");
			
			for (int i = 0; i < dalcode.length; i++) {
				
				ps_getallowance = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_MANG_EMP_ALLOWANCES);
				ps_getallowance.setString(1, dalcode[i]);
				
				rs_getallowance=ps_getallowance.executeQuery();
	
				while(rs_getallowance.next()){
					
			   if(allowancelist.size()!=0){		
				
				     if( !(allowancelist.get(allowancelist.size()-1).getPostedBy().equalsIgnoreCase(rs_getallowance.getString("Posted_By")))){
			
					
					      allowancelist=new ArrayList<AllowancesClaimByManagerVO>();
					      count=0;
				    }
			   }			
			
			
					count++;
					AllowancesClaimByManagerVO allowanceVO = new AllowancesClaimByManagerVO();
					
					allowanceVO.setSno(count);
					allowanceVO.setBioid(rs_getallowance.getString("BioCode"));
					allowanceVO.setEmpname(rs_getallowance.getString("First_Name"));
					allowanceVO.setProject(rs_getallowance.getString("ProjectRefCode"));
					allowanceVO.setAmount(rs_getallowance.getDouble("Amount"));
					allowanceVO.setApprovedamount(rs_getallowance.getDouble("ApprovedAmount"));
					allowanceVO.setAllowancedate(HelperClass.convertDatabaseToUI(rs_getallowance.getString("Allowance_Date")));
					allowanceVO.setPostedBy(rs_getallowance.getString("Posted_By"));
				
					
					allowancelist.add(allowanceVO);
					
				
				
				
				}
				
				
				
				maplist.put(allowancelist.get(allowancelist.size()-1).getPostedBy(), allowancelist);
				
				
				
				
				
			}
			
					
			
			
		} catch (SQLException sqle) {

			logger.error(sqle.getMessage(),sqle);
			sqle.printStackTrace();

		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			e.printStackTrace();
			
		} finally {

			try {
				
				
				if(rs_getallowance != null && (!rs_getallowance.isClosed())){
					
					rs_getallowance.close();
				}
				
				if(ps_getallowance != null && (!ps_getallowance.isClosed())){
					
					ps_getallowance.close();
				}
				
				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

	
	
	
		return maplist;
	}
	
  
  
  public  Map<String,String> getManagerDetailsById(String managerId,Connection connection) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmpAllowAprroveByDirectorDaoImpl: getManagerDetailsById : Starting");
		
		
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
		logger.info(JDate.getTimeString(new Date())+ " Control in EmpAllowAprroveByDirectorDaoImpl: getManagerDetailsById : Ending");
		
		return managerMap;
		
  }
  
  
  
  
	private LinkedHashMap<String, ArrayList<AllowancesClaimByManagerVO>> getDiremapEmpallowance(
			String allowanceCode, Connection connection, String previlige) {
		
		PreparedStatement ps_getallowance = null;
	
		ResultSet rs_getallowance=null;
		int count=0;
		ArrayList<AllowancesClaimByManagerVO> allowancelist=new ArrayList<AllowancesClaimByManagerVO>();
		LinkedHashMap<String, ArrayList<AllowancesClaimByManagerVO>> maplist = new LinkedHashMap<String, ArrayList<AllowancesClaimByManagerVO>>();
		try {
			
			connection=getConnection();
	
			String[] dalcode=allowanceCode.split(",");
			
			for (int i = 0; i < dalcode.length; i++) {
				
				if(previlige.equalsIgnoreCase("director")){
				
				    ps_getallowance = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_DIRECTOR_EMP_ALLOWANCES);
				
					ps_getallowance.setString(1, dalcode[i]);
					
					rs_getallowance=ps_getallowance.executeQuery();
		
					while(rs_getallowance.next()){
						
				   if(allowancelist.size()!=0){		
					
					     if( !(allowancelist.get(allowancelist.size()-1).getApprovedirecode().equalsIgnoreCase(rs_getallowance.getString("ApprovedDirectorCode")))){
				
						
						      allowancelist=new ArrayList<AllowancesClaimByManagerVO>();
						      count=0;
					    }
				   }			
						count++;
						AllowancesClaimByManagerVO allowanceVO = new AllowancesClaimByManagerVO();
						
						allowanceVO.setSno(count);
						allowanceVO.setBioid(rs_getallowance.getString("BioCode"));
						allowanceVO.setEmpname(rs_getallowance.getString("First_Name"));
						allowanceVO.setProject(rs_getallowance.getString("ProjectRefCode"));
						allowanceVO.setAmount(rs_getallowance.getDouble("Amount"));
						allowanceVO.setApprovedamount(rs_getallowance.getDouble("ApprovedAmount"));
						allowanceVO.setAllowancedate(HelperClass.convertDatabaseToUI(rs_getallowance.getString("Allowance_Date")));
						allowanceVO.setApprovedirecode(rs_getallowance.getString("ApprovedDirectorCode"));
						allowanceVO.setPostedBy(rs_getallowance.getString("mangname"));
						allowanceVO.setAccountapprovedamount(rs_getallowance.getDouble("AccountApprovedAmount"));
									
						allowancelist.add(allowanceVO);
				
					}
					
					
					
					maplist.put(allowancelist.get(allowancelist.size()-1).getApprovedirecode(), allowancelist);
				
				    
				    
			}else{
					
				   ps_getallowance = connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_DIRECTOR_MANG_EMP_ALLOWANCES);
	    			ps_getallowance.setString(1, dalcode[i]);
					
					rs_getallowance=ps_getallowance.executeQuery();
		
					while(rs_getallowance.next()){
						
				   if(allowancelist.size()!=0){		
					
					     if( !(allowancelist.get(allowancelist.size()-1).getPostedbycode().equalsIgnoreCase(rs_getallowance.getString("Posted_By")))){
				
						      allowancelist=new ArrayList<AllowancesClaimByManagerVO>();
						      count=0;
					    }
				   }			
						
						count++;
						AllowancesClaimByManagerVO allowanceVO = new AllowancesClaimByManagerVO();
						
						allowanceVO.setSno(count);
						allowanceVO.setBioid(rs_getallowance.getString("BioCode"));
						allowanceVO.setEmpname(rs_getallowance.getString("First_Name"));
						allowanceVO.setProject(rs_getallowance.getString("ProjectRefCode"));
						allowanceVO.setAmount(rs_getallowance.getDouble("Amount"));
						allowanceVO.setApprovedamount(rs_getallowance.getDouble("ApprovedAmount"));
						allowanceVO.setAllowancedate(HelperClass.convertDatabaseToUI(rs_getallowance.getString("Allowance_Date")));
						allowanceVO.setPostedbycode(rs_getallowance.getString("Posted_By"));
						allowanceVO.setPostedBy(rs_getallowance.getString("mangname"));
						allowanceVO.setAccountapprovedamount(rs_getallowance.getDouble("AccountApprovedAmount"));
									
						allowancelist.add(allowanceVO);
					
					}
				
					maplist.put(allowancelist.get(allowancelist.size()-1).getPostedbycode(), allowancelist);
		
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
				
				
				if(rs_getallowance != null && (!rs_getallowance.isClosed())){
					
					rs_getallowance.close();
				}
				
				if(ps_getallowance != null && (!ps_getallowance.isClosed())){
					
					ps_getallowance.close();
				}
			
				
			} catch (SQLException e) {

				logger.error(e.getMessage(),e);
			} catch (Exception e) {
				logger.error(e.getMessage(),e);
			}
		}

		
	
		return maplist;
	
		
	}
  
  
  
  
  
	public static void main(String[] args){
		
		String s="DAL19,DAL20,DAL21,DAL22,DAL23,DAL31,DAL32";
		
		Connection connection=null;
		 try {
			connection=getConnection();
			
			new EmpAllowAprroveByDirectorDaoImpl().getDiremapEmpallowance(s,connection,"manager");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
}
