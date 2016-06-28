package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.DAO.EmployeeDailyAllowanceDAO;
import com.centris.VO.DailyEmployeeAllowanceVO;
import com.centris.VO.ManagerMasterVO;
import com.centris.form.EmployeeDailyAllowanceForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class EmployeeDailyAllowanceDAOImpl extends DBService implements EmployeeDailyAllowanceDAO{

	private static 	Logger logger = Logger.getLogger(EmployeeDailyAllowanceDAOImpl.class);
	@Override
	public List<DailyEmployeeAllowanceVO> viewEmployeeDailyAllowance(EmployeeDailyAllowanceForm employeeDailyAllowanceform) {
		List<DailyEmployeeAllowanceVO>  dailyEmployeeAllowanceVOList = new ArrayList<DailyEmployeeAllowanceVO>();
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeDailyAllowanceDAOImpl: viewEmployeeDailyAllowance Starting");
		Connection conn = null;
		PreparedStatement pstmt=null;
		DailyEmployeeAllowanceVO dailyEmployeeAllowanceVO=null;
	try{
		conn= getConnection();
		pstmt=conn.prepareStatement(SQLutilConstants.GET_EMPLOYEE_DAILY_ALLOWANCE);
		pstmt.setString(1, HelperClass.convertUIToDatabase(employeeDailyAllowanceform.getDailyAllowanceDate().trim()));
		ResultSet rs= pstmt.executeQuery();
		int slNo=1;
		while(rs.next()){
			
			dailyEmployeeAllowanceVO= new DailyEmployeeAllowanceVO();
			dailyEmployeeAllowanceVO.setSlNo(slNo+"");
			String code=rs.getString("Code");
			if(code==null){
				code="";
			}
			dailyEmployeeAllowanceVO.setCode(code);
			String Names=rs.getString("Names");
			if(Names==null){
				Names="";
			}
			dailyEmployeeAllowanceVO.setNames(Names);
			String HDFC_AC_No=rs.getString("HDFC_AC_No");
			if(HDFC_AC_No==null){
				HDFC_AC_No="";
			}
			dailyEmployeeAllowanceVO.setHdfcNo(HDFC_AC_No);
			String Amount=rs.getString("Amount");
			if(Amount==null){
				Amount="";
			}
			
			String postedby=rs.getString("Posted_By");
			if(postedby==null){
				postedby="";
			}
			dailyEmployeeAllowanceVO.setPostedby(postedby);
			
			dailyEmployeeAllowanceVO.setAmount(Amount);
			String Project_Manager=rs.getString("Project_Manager");
			if(Project_Manager==null){
				Project_Manager="";
			}
			dailyEmployeeAllowanceVO.setProjectManager(postedby+"-"+Project_Manager);
			String Client=rs.getString("Client");
			if(Client==null){
				Client="";
			}
			dailyEmployeeAllowanceVO.setClient(Client);
			String Project=rs.getString("Project");
			if(Project==null){
				Project="";
			}
			dailyEmployeeAllowanceVO.setProject(Project);
			String Team_Lead=rs.getString("Team_Lead");
			if(Team_Lead==null){
				Team_Lead="";
			}
			dailyEmployeeAllowanceVO.setTeamLead(Team_Lead);
			String Location=rs.getString("Location");
			if(Location==null){
				Location="";
			}
			dailyEmployeeAllowanceVO.setLocation(Location);
			String Remarks=rs.getString("Remarks");
			if(Remarks==null){
				Remarks="";
			}
			dailyEmployeeAllowanceVO.setRemarks(Remarks);
			
			
			
			dailyEmployeeAllowanceVO.setDate(HelperClass.convertDatabaseToTitle(HelperClass.convertUIToDatabase(employeeDailyAllowanceform.getDailyAllowanceDate())));
			
			dailyEmployeeAllowanceVOList.add(dailyEmployeeAllowanceVO);
			slNo++;
		}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (!conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in  EmployeeDailyAllowanceDAOImpl:viewEmployeeDailyAllowance Ending");

		return dailyEmployeeAllowanceVOList;
	}
	
	
	public Map<String, List<DailyEmployeeAllowanceVO>> viewEmployeeDailyAllowanceByManger(EmployeeDailyAllowanceForm employeeDailyAllowanceform) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeDailyAllowanceDAOImpl: viewEmployeeDailyAllowance Starting");
		Connection conn = null;
		PreparedStatement pstmt=null;
		PreparedStatement pstmt1=null;
		DailyEmployeeAllowanceVO dailyEmployeeAllowanceVO=null;
		ArrayList<ManagerMasterVO> managerlist=new ArrayList<ManagerMasterVO>();
		Map<String, List<DailyEmployeeAllowanceVO>> managermap=new HashMap<String, List<DailyEmployeeAllowanceVO>>();
		ResultSet rs1=null;
	try{
		conn= getConnection();
		
		
		pstmt1=conn.prepareStatement(SQLutilConstants.GET_MANAGERNAME_FOR_EMP_DAILY_ALLOWANCE);
		pstmt1.setString(1, HelperClass.convertUIToDatabase(employeeDailyAllowanceform.getDailyAllowanceDate().trim()));
		
		System.out.println("string query ::: "+pstmt1.toString());
		
		 rs1= pstmt1.executeQuery();
		 
		 while(rs1.next()){
			 
			 ManagerMasterVO managervo=new ManagerMasterVO();
			 if(rs1.getString("Project_Manager")!=null){
				 
				 managervo.setManagerid(rs1.getString("Posted_By"));
				 managervo.setFirstname(rs1.getString("Project_Manager"));
				 
			 managerlist.add(managervo);
			 }
			 
		 }
		
		pstmt=conn.prepareStatement(SQLutilConstants.GET_EMPLOYEE_DAILY_ALLOWANCE_BYMANAGER);
		
		
		for(int i=0;i<managerlist.size();i++){
			
			List<DailyEmployeeAllowanceVO>  dailyEmployeeAllowanceVOList = new ArrayList<DailyEmployeeAllowanceVO>();
			
		pstmt.setString(1, HelperClass.convertUIToDatabase(employeeDailyAllowanceform.getDailyAllowanceDate().trim()));
		pstmt.setString(2, managerlist.get(i).getManagerid());
		
		System.out.println("string queryi ::: "+pstmt.toString());
		
		ResultSet rs= pstmt.executeQuery();
		int slNo=1;
		
		while(rs.next()){
			
			dailyEmployeeAllowanceVO= new DailyEmployeeAllowanceVO();
			dailyEmployeeAllowanceVO.setSlNo(slNo+"");
			String code=rs.getString("Code");
			if(code==null){
				code="";
			}
			dailyEmployeeAllowanceVO.setCode(code);
			String Names=rs.getString("Names");
			if(Names==null){
				Names="";
			}
			dailyEmployeeAllowanceVO.setNames(Names);
			String HDFC_AC_No=rs.getString("HDFC_AC_No");
			if(HDFC_AC_No==null){
				HDFC_AC_No="";
			}
			dailyEmployeeAllowanceVO.setHdfcNo(HDFC_AC_No);
			String Amount=rs.getString("Amount");
			if(Amount==null){
				Amount="";
			}
			dailyEmployeeAllowanceVO.setAmount(Amount);
			String Project_Manager=rs.getString("Project_Manager");
			if(Project_Manager==null){
				Project_Manager="";
			}
			dailyEmployeeAllowanceVO.setProjectManager(Project_Manager);
			String Client=rs.getString("Client");
			if(Client==null){
				Client="";
			}
			dailyEmployeeAllowanceVO.setClient(Client);
			String Project=rs.getString("Project");
			if(Project==null){
				Project="";
			}
			dailyEmployeeAllowanceVO.setProject(Project);
			String Team_Lead=rs.getString("Team_Lead");
			if(Team_Lead==null){
				Team_Lead="";
			}
			dailyEmployeeAllowanceVO.setTeamLead(Team_Lead);
			String Location=rs.getString("Location");
			if(Location==null){
				Location="";
			}
			dailyEmployeeAllowanceVO.setLocation(Location);
			String Remarks=rs.getString("Remarks");
			if(Remarks==null){
				Remarks="";
			}
			dailyEmployeeAllowanceVO.setRemarks(Remarks);
			dailyEmployeeAllowanceVO.setDate(HelperClass.convertDatabaseToTitle(HelperClass.convertUIToDatabase(employeeDailyAllowanceform.getDailyAllowanceDate())));
			
			
			dailyEmployeeAllowanceVOList.add(dailyEmployeeAllowanceVO);
			slNo++;
		}
		
		managermap.put(managerlist.get(i).getManagerid()+"-"+managerlist.get(i).getFirstname(), dailyEmployeeAllowanceVOList);
		
		}
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (!conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in  EmployeeDailyAllowanceDAOImpl:viewEmployeeDailyAllowance Ending");

		
		return managermap;
	}
	
	
	
public boolean chcekRecords(String date) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeDailyAllowanceDAOImpl: chcekRecords Starting");
		Connection conn = null;
		PreparedStatement pstmt=null;
		boolean status=false;
		int count=0;
	try{
		conn= getConnection();
		
		
		pstmt=conn.prepareStatement(SQLutilConstants.CHECK_RECORDS);
		pstmt.setString(1, HelperClass.convertUIToDatabase(date));
		
		
		ResultSet rs= pstmt.executeQuery();
		
		while(rs.next()){
			
			count=rs.getInt(1);
			
		}
		
		if(count>0){
			
			status=true;
			
		}
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (!conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e.getMessage(), e);
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in  EmployeeDailyAllowanceDAOImpl:chcekRecords Ending");

		
		return status;
	}
	
	



}
