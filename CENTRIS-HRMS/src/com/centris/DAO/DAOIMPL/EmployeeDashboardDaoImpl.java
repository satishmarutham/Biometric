package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.DAO.EmployeeDashboardDao;
import com.centris.VO.ClaimesByManagerInEmpDashBoardVo;
import com.centris.VO.EmployeeDashboardVO;
import com.centris.VO.LeaveViewDetailsVo;
import com.centris.VO.TravelBookedDetailsVo;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.AllowancesClaimByManagerSqlUtil;
import com.centris.util.SQLUtils.EmployeeDashboard;
import com.centris.util.SQLUtils.EmployeeLeaveRequest;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.constants.MessageConstants;

public class EmployeeDashboardDaoImpl extends DBService implements EmployeeDashboardDao{

	private static Logger logger = Logger.getLogger(EmployeeDashboardDaoImpl.class);
		
	public ArrayList<EmployeeDashboardVO> getDailyAllowances(String empcode) {
	
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardDaoImpl: getDailyAllowances Starting");
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		ArrayList<EmployeeDashboardVO> employeedailyallowances=new ArrayList<EmployeeDashboardVO>();
		int sno=0;
		try {

			connection = getConnection();
			int currentmount=Integer.parseInt(HelperClass.getCurrentMonth());
			int monthcount=0;
			
			for(int i=currentmount-2;i<=currentmount;i++){
				
			
				String year=HelperClass.getCurrentYear();
				
				EmployeeDashboardVO empdashboardVO=new EmployeeDashboardVO();
			
			if(Integer.parseInt(HelperClass.getCurrentMonth())>=3){
				
				year= HelperClass.getCurrentYear();
				
			}else{
				
				if(Integer.parseInt(HelperClass.getCurrentMonth())==2){
					
					if(monthcount==0){
						
						year= (Integer.parseInt(HelperClass.getCurrentYear())-1)+"";
						
					}else{
						
						year= HelperClass.getCurrentYear();
						
					}
				}else if(Integer.parseInt(HelperClass.getCurrentMonth())==1){
					
					if(monthcount==0 || monthcount==1){
						
						year= (Integer.parseInt(HelperClass.getCurrentYear())-1)+"";
						
					}else{
						
						year= HelperClass.getCurrentYear();
					}
					
				}
				
			}
			
			int daysInonth=HelperClass.getDaysByMonthAndYear(i, Integer.parseInt(year));
			int month=i;
			if(i==0){
				month=12;
			}else if(i==-1){
				month=11;
			}
			
			String startDate=year+"-"+month+"-"+01;
			String endDate=year+"-"+month+"-"+daysInonth;
			
			pstmt = connection.prepareStatement(EmployeeDashboard.GET_DAILY_ALLOWANCES);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setString(3, empcode);
			
			rs = pstmt.executeQuery();
			sno++;
			empdashboardVO.setSno(sno);
			empdashboardVO.setMonth(HelperClass.getMonthFullName(month+""));
			empdashboardVO.setYear(year);
			
			while (rs.next()) {
				
				empdashboardVO.setAmount(rs.getDouble("amount"));
				empdashboardVO.setPostedby(rs.getString("postedby"));
				empdashboardVO.setApprovedamount(rs.getDouble("approvedAmount"));
							
				employeedailyallowances.add(empdashboardVO);
			}
			
			monthcount++;
		
			}
		
			
			} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {
				
				if (rs != null && !rs.isClosed()) {
					rs.close();
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
				+ " Control in EmployeeDashboardDaoImpl: getDailyAllowances Ending");
		
		
		return employeedailyallowances;
	}

	
	public EmployeeDashboardVO getPersonalDetails(String empId) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardDaoImpl: getPersonalDetails Starting");
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		EmployeeDashboardVO empdashboardVO=new EmployeeDashboardVO();
	
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(EmployeeDashboard.GET_PERSONAL_DETAILS);
			pstmt.setString(1, empId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				empdashboardVO.setEmployee_id(rs.getString("EMPID").trim());	
				empdashboardVO.setFirst_name(rs.getString("First_Name").trim());
				empdashboardVO.setDob(HelperClass.convertDatabaseToUI(rs.getDate("DOB").toString()));
				empdashboardVO.setDoj(HelperClass.convertDatabaseToUI(rs.getDate("DOJ").toString()));
			
				if(rs.getString("DEPT_NAME")!=null){
				empdashboardVO.setDept_name(rs.getString("DEPT_NAME").trim());
				}else{
					
					empdashboardVO.setDept_name("HR");
				}
				empdashboardVO.setPermanent_address(rs.getString("Permanent_Address").trim());
				empdashboardVO.setVoter_id_no(rs.getString("Voter_ID_No").trim());
				empdashboardVO.setBlood_group(rs.getString("BloodGroup").trim());
				empdashboardVO.setPersonal_email_id(rs.getString("Personal_Email_ID").trim());
				empdashboardVO.setEmployee_type(rs.getString("EmpType").trim());
				
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {
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
				+ " Control in EmployeeDashboardDaoImpl: getPersonalDetails Ending");
		return empdashboardVO;
	}

	public ArrayList<EmployeeDashboardVO> getLeaveStatus(String userCode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardDaoImpl: getLeaveStatus Starting");
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		ArrayList<EmployeeDashboardVO> employeeleavedetails=new ArrayList<EmployeeDashboardVO>();
		int sno=0;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(EmployeeDashboard.GET_LEAVE_STATUS);
			pstmt.setString(1, userCode);
					
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeDashboardVO empdashboardVO=new EmployeeDashboardVO();
				sno++;
				empdashboardVO.setSno(sno);
				empdashboardVO.setNoof_leaves(rs.getDouble("NoofLeaves"));
				empdashboardVO.setRequested_date(HelperClass.convertDatabaseToUI(rs.getString("requseteddate")));
				empdashboardVO.setLeave_status(rs.getString("LeaveStatus"));
				empdashboardVO.setTotaldays_approved(rs.getDouble("TotalDaysAproved"));
				
				employeeleavedetails.add(empdashboardVO);
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {
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
				+ " Control in EmployeeDashboardDaoImpl: getLeaveStatus Ending");
		
		
		return employeeleavedetails;
	}


	public ArrayList<EmployeeDashboardVO> getAttendanceDetails(String userCode) {
	
    	logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardDaoImpl: getAttendanceDetails Starting");
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		ArrayList<EmployeeDashboardVO> employeeAttendanceList=new ArrayList<EmployeeDashboardVO>();
	
		try {
			connection = getConnection();
			
			int currentmount=Integer.parseInt(HelperClass.getCurrentMonth());
			
			
			for(int i=currentmount-2;i<=currentmount;i++){
				
				EmployeeDashboardVO empdashboardVO=new EmployeeDashboardVO();
			
			String currentyear=HelperClass.getCurrentYear();
			
			
			String startDate=currentyear+"-"+i+"-"+1;
			String endDate=currentyear+"-"+i+"-"+HelperClass.getDaysByMonthAndYear(i,Integer.parseInt(currentyear));
				
			
			
			pstmt = connection.prepareStatement(EmployeeDashboard.GET_ATTENDANCE_DETAILS);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setString(3, userCode);
					
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				empdashboardVO.setTotaldaysinmonth(HelperClass.getDaysByMonthAndYear(i,Integer.parseInt(currentyear)));
				empdashboardVO.setWorkingdays(rs.getInt("workingdays"));
				empdashboardVO.setTotPresent(rs.getDouble("totpresent"));
				empdashboardVO.setTotAbsent(rs.getDouble("totabsent"));
				empdashboardVO.setTotLeave(rs.getDouble("totleave"));
				empdashboardVO.setTotHoliday(rs.getDouble("totholidays"));
				empdashboardVO.setMonth(HelperClass.getMonthFullName(i+""));
				
			}
						
			employeeAttendanceList.add(empdashboardVO);
			
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
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt1 != null && !pstmt1.isClosed()) {
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
				sqle.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			}
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardDaoImpl: getAttendanceDetails Ending");
		
		return employeeAttendanceList;
	
	}

	
	public EmployeeDashboardVO getPendingAttendanceDetails(String userCode) {
		
    	logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardDaoImpl: getPendingAttendanceDetails Starting");
		
		Connection connection = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs= null;
		int sno=0;
		EmployeeDashboardVO empdashboardVO=new EmployeeDashboardVO();
	
		try {
			connection = getConnection();
			
			
			pstmt1 = connection.prepareStatement(EmployeeDashboard.GET_ATTENDANCE_NOT_POSTED_BY_EMPLOYEE);
			pstmt1.setString(1, userCode);
			rs = pstmt1.executeQuery();
				
			while(rs.next()){
				sno++;
				empdashboardVO.setSno(sno);
				
						
				if((rs.getString("startDate")!=null)){
				empdashboardVO.setStartdate(HelperClass.convertDatabaseToUI(rs.getString("startDate")));
				}
				
			
				if((rs.getString("endDate")!=null)){
				empdashboardVO.setEnddate(HelperClass.convertDatabaseToUI(rs.getString("endDate")));
				}
				

				String datetime= rs.getString("PostedTime");
				if(datetime!=null){
					
					
				
					empdashboardVO.setLastposteddate(datetime);
				}		
		
				empdashboardVO.setPendingdays(rs.getString("pendingdays"));
				
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {
				
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt1 != null && !pstmt1.isClosed()) {
					pstmt1.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
				sqle.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			}
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardDaoImpl: getPendingAttendanceDetails Ending");
		
		return empdashboardVO;
	
	}


	public ArrayList<EmployeeDashboardVO> getmoreAllowanceDeatailsDao(
			String startdate, String enddate, String userid) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardDaoImpl: getmoreAllowanceDeatailsDao Starting");
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		
		
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		
		
		ArrayList<EmployeeDashboardVO> employeedailyallowances=new ArrayList<EmployeeDashboardVO>();
		int sno=0;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(EmployeeDashboard.GET_MORE_DAILY_ALLOWANCES);
			pstmt.setString(1, HelperClass.convertUIToDatabase(startdate));
			pstmt.setString(2, HelperClass.convertUIToDatabase(enddate));
			pstmt.setString(3, userid);
			
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				EmployeeDashboardVO empdashboardVO=new EmployeeDashboardVO();
				sno++;
				empdashboardVO.setSno(sno);
				empdashboardVO.setAllowancedate(HelperClass.convertDatabaseToUI(rs.getString("Allowance_Date")));
				empdashboardVO.setAmount(rs.getDouble("Amount"));
			
                if(!(MessageConstants.ALLOWANCES_IS_APPROVED_NO.equalsIgnoreCase(rs.getString("isRejected"))) ){
					
					empdashboardVO.setStatus(MessageConstants.IS_REJECT);
				}else{
					
					if(MessageConstants.ALLOWANCES_IS_APPROVED_NO.equalsIgnoreCase(rs.getString("isApprovedByAccounts")))
					{
					   empdashboardVO.setStatus(MessageConstants.IS_APPROVED_NO);
					}else{
						empdashboardVO.setStatus(MessageConstants.IS_APPROVED_YES);
					}
					
				}


				empdashboardVO.setProject(rs.getString("Project_Name"));
				empdashboardVO.setPostedby(rs.getString("postedby"));
				empdashboardVO.setNoofdayormonth(rs.getInt("No_Of_days_Month"));
				empdashboardVO.setDatype(rs.getString("DAType"));
				empdashboardVO.setSingleteamgh(rs.getString("Single_team_GH"));
		
				empdashboardVO.setApprovedamount(rs.getDouble("AccountApprovedAmount"));
				empdashboardVO.setRemarks(rs.getString("Remarks"));
				empdashboardVO.setClientname(rs.getString("ClientName"));
				
				String projectmanager=rs.getString("Project_Manager");
				
				if(projectmanager!=null){
					
					pstmt1=connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_POSTED_MANAGER);
					pstmt1.setString(1, projectmanager);
			    	rs1=pstmt1.executeQuery();
					while(rs1.next()){
						empdashboardVO.setProjectmanager(rs1.getString("First_Name"));
					}
				}
				
				
							
				employeedailyallowances.add(empdashboardVO);
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
				+ " Control in EmployeeDashboardDaoImpl: getmoreAllowanceDeatailsDao Ending");
		
		
		return employeedailyallowances;
	}


	@Override
	public ArrayList<EmployeeDashboardVO> getmoreAllowanceDeatailsByManagerDao(
			String startdate, String enddate, String employeeId,
			String currentuser) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardDaoImpl: getmoreAllowanceDeatailsByManagerDao Starting");
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		
		
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		
		
		ArrayList<EmployeeDashboardVO> employeedailyallowances=new ArrayList<EmployeeDashboardVO>();
		int sno=0;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(EmployeeDashboard.GET_MORE_DAILY_ALLOWANCES_BY_MANAGER);
			pstmt.setString(1, HelperClass.convertUIToDatabase(startdate));
			pstmt.setString(2, HelperClass.convertUIToDatabase(enddate));
			pstmt.setString(3, employeeId);
			pstmt.setString(4, currentuser);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				EmployeeDashboardVO empdashboardVO=new EmployeeDashboardVO();
				sno++;
				empdashboardVO.setSno(sno);
				empdashboardVO.setAllowancedate(HelperClass.convertDatabaseToUI(rs.getString("Allowance_Date")));
				empdashboardVO.setAmount(rs.getDouble("Amount"));
			
                if(!(MessageConstants.ALLOWANCES_IS_APPROVED_NO.equalsIgnoreCase(rs.getString("isRejected"))) ){
					
					empdashboardVO.setStatus(MessageConstants.IS_REJECT);
				}else{
					
					if(MessageConstants.ALLOWANCES_IS_APPROVED_NO.equalsIgnoreCase(rs.getString("isApprovedByAccounts")))
					{
					   empdashboardVO.setStatus(MessageConstants.IS_APPROVED_NO);
					}else{
						empdashboardVO.setStatus(MessageConstants.IS_APPROVED_YES);
					}
					
				}

				empdashboardVO.setProject(rs.getString("Project_Name"));
				empdashboardVO.setPostedby(rs.getString("postedby"));
				empdashboardVO.setNoofdayormonth(rs.getInt("No_Of_days_Month"));
				empdashboardVO.setDatype(rs.getString("DAType"));
				empdashboardVO.setSingleteamgh(rs.getString("Single_team_GH"));
		
				empdashboardVO.setApprovedamount(rs.getDouble("AccountApprovedAmount"));
				empdashboardVO.setRemarks(rs.getString("Remarks"));
				empdashboardVO.setClientname(rs.getString("ClientName"));
				
				String projectmanager=rs.getString("Project_Manager");
				
				if(projectmanager!=null){
					
					pstmt1=connection.prepareStatement(AllowancesClaimByManagerSqlUtil.GET_POSTED_MANAGER);
					pstmt1.setString(1, projectmanager);
			    	rs1=pstmt1.executeQuery();
					while(rs1.next()){
						empdashboardVO.setProjectmanager(rs1.getString("First_Name"));
					}
				}
				
				
							
				employeedailyallowances.add(empdashboardVO);
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
	
	
	public ArrayList<ClaimesByManagerInEmpDashBoardVo> moreExpensesDeatailsHomeDao(String empId,String month,String year) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardDaoImpl: moreExpensesDeatailsHomeDao Starting");
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;

		ArrayList<ClaimesByManagerInEmpDashBoardVo> employeeClaimesList=new ArrayList<ClaimesByManagerInEmpDashBoardVo>();
		int count=0;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(EmployeeDashboard.GET_EMPLOYEE_CLIAMES_VIEW);
			pstmt.setString(1, empId);
			pstmt.setString(2, year);
			pstmt.setString(3, month);
			
			
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				
				count++;
				ClaimesByManagerInEmpDashBoardVo employeeClaimes=new ClaimesByManagerInEmpDashBoardVo();
				employeeClaimes.setSno(count);
				employeeClaimes.setYear(rs.getString("year"));
				employeeClaimes.setMonth(HelperClass.getMonthFullName(rs.getString("month")));
				
				employeeClaimes.setClaimedamount(rs.getString("Total_amount_claimed"));
				
				employeeClaimes.setApprovedManger(rs.getString("managerName"));
				
				if(rs.getString("approvedAmount")!=null){
				   employeeClaimes.setApprovedamount(rs.getString("approvedAmount"));
				}else{
					
					employeeClaimes.setApprovedamount("-");
				}
				employeeClaimes.setManagerapprovedDate(rs.getString("managerApprovedDate"));
				
				
				if(MessageConstants.REJECT.equalsIgnoreCase(rs.getString("isManagerApproved"))){
					
					employeeClaimes.setStatus(MessageConstants.REJECTED);
				}else if(MessageConstants.YES.equalsIgnoreCase(rs.getString("isManagerApproved"))){
					employeeClaimes.setStatus(MessageConstants.APPROVED);
				}else{
					employeeClaimes.setStatus(MessageConstants.NOT_APPROVED);
				}
				
				
				
				
				if(MessageConstants.REJECT.equalsIgnoreCase(rs.getString("isDirectorApproved"))){
					 employeeClaimes.setIsdirectorApproved(MessageConstants.REJECTED);
					 employeeClaimes.setDirectorapproveddate(rs.getString("directorApprovedDate"));
					 employeeClaimes.setApprovedDirector(rs.getString("approvedDirector"));
					 employeeClaimes.setDirebalamount("-");
					
				}else if(MessageConstants.YES.equalsIgnoreCase(rs.getString("isDirectorApproved"))){
					
					 employeeClaimes.setIsdirectorApproved(MessageConstants.APPROVED);
					 employeeClaimes.setDirectorapproveddate(rs.getString("directorApprovedDate"));
					 employeeClaimes.setApprovedDirector(rs.getString("approvedDirector"));
					 employeeClaimes.setDirebalamount(rs.getString("Director_Balance_Amt"));
					 
				}else{

					 employeeClaimes.setIsdirectorApproved(MessageConstants.NOT_APPROVED);
					 employeeClaimes.setDirectorapproveddate("-");
					 employeeClaimes.setApprovedDirector("-");
					 employeeClaimes.setDirebalamount("-");
				}
				
				
				if(MessageConstants.YES.equalsIgnoreCase(rs.getString("isAccountApproved"))){
					
					employeeClaimes.setIsadminapproved(MessageConstants.APPROVED);
					employeeClaimes.setApprovedAdmin(rs.getString("approvedbyacnt"));
					employeeClaimes.setAdminapproveddate(rs.getString("accountsApprovedDate"));
					 employeeClaimes.setAccounttantbalamount(rs.getString("Account_Balance_Amt"));
			
				}else if(MessageConstants.REJECT.equalsIgnoreCase(rs.getString("isAccountApproved"))){
					
					employeeClaimes.setIsadminapproved(MessageConstants.REJECTED);
					employeeClaimes.setApprovedAdmin(rs.getString("approvedbyacnt"));
					employeeClaimes.setAdminapproveddate(rs.getString("accountsApprovedDate"));
					 employeeClaimes.setAccounttantbalamount("-");
				}else{
					
    				employeeClaimes.setIsadminapproved(MessageConstants.NOT_APPROVED);
					employeeClaimes.setApprovedAdmin("-");
					employeeClaimes.setAdminapproveddate("-");
					 employeeClaimes.setAccounttantbalamount("-");
				}
				
				employeeClaimes.setLocalconveyance(rs.getString("Local_conveyance"));
				employeeClaimes.setTravelexpenses(rs.getString("Travel_expenses"));
				employeeClaimes.setStaffwelfare(rs.getString("Staff_welfare"));
				employeeClaimes.setTelephoneexp(rs.getString("Telephone_expenses"));
				employeeClaimes.setPurchases(rs.getString("Purchases"));
				employeeClaimes.setOtherworkexp(rs.getString("other_work_expenses"));
				employeeClaimes.setMislanious(rs.getString("Miscellaneous"));
				
				
				employeeClaimesList.add(employeeClaimes);
				
				
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {
				
				if (rs != null && !rs.isClosed()) {
					rs.close();
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
				+ " Control in EmployeeDashboardDaoImpl: moreExpensesDeatailsHomeDao Ending");
		
		
		return employeeClaimesList;
	}

	
	public ArrayList<TravelBookedDetailsVo> getTravelAllowanceDao(String userCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardDaoImpl: getTravelAllowanceBD Starting");
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		int sno=0;
		
		ArrayList<TravelBookedDetailsVo> travelDetailsList=new ArrayList<TravelBookedDetailsVo>();
		

		try {
			


			connection = getConnection();
			int currentmount=Integer.parseInt(HelperClass.getCurrentMonth());
			int monthcount=0;
			
			for(int i=currentmount-2;i<=currentmount;i++){
				
				String year=HelperClass.getCurrentYear();
				
				TravelBookedDetailsVo empdashboardVO=new TravelBookedDetailsVo();
			
			if(Integer.parseInt(HelperClass.getCurrentMonth())>=3){
				
				year= HelperClass.getCurrentYear();
				
			}else{
				
				if(Integer.parseInt(HelperClass.getCurrentMonth())==2){
					
					if(monthcount==0){
						
						year= (Integer.parseInt(HelperClass.getCurrentYear())-1)+"";
						
					}else{
						
						year= HelperClass.getCurrentYear();
						
					}
				}else if(Integer.parseInt(HelperClass.getCurrentMonth())==1){
					
					if(monthcount==0 || monthcount==1){
						
						year= (Integer.parseInt(HelperClass.getCurrentYear())-1)+"";
						
					}else{
						
						year= HelperClass.getCurrentYear();
					}
					
				}
				
			}
			
			int daysInonth=HelperClass.getDaysByMonthAndYear(i, Integer.parseInt(year));
			
			int month=i;
			if(i==0){
				month=12;
			}else if(i==-1){
				month=11;
			}
			
			String startDate=year+"-"+month+"-"+01;
			String endDate=year+"-"+month+"-"+daysInonth;
			
			pstmt = connection.prepareStatement(EmployeeDashboard.GET_TRAVEL_ALLOWANCES);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
			pstmt.setString(3, userCode);
			
			rs = pstmt.executeQuery();
			sno++;
			empdashboardVO.setSno(sno);
			empdashboardVO.setMonth(HelperClass.getMonthFullName(month+""));
			empdashboardVO.setYear(year);
			
			while (rs.next()) {
				
				empdashboardVO.setAmount(rs.getDouble("amount"));
				empdashboardVO.setPosted_by(rs.getString("postedby"));
				empdashboardVO.setApprovedamount(rs.getDouble("approvedAmount"));
							
				travelDetailsList.add(empdashboardVO);
			}
		
			monthcount++;
			}
		
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {
				
				if (rs != null && !rs.isClosed()) {
					rs.close();
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
				+ " Control in EmployeeDashboardDaoImpl: getTravelAllowanceBD Ending");
		
		
		return travelDetailsList;
	}


	private String getEmployee(String empcode, Connection connection) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeDashboardDaoImpl: getEmployee  Starting");

		PreparedStatement ps_employee = null;
		ResultSet rs_employee=null;
		String employee=null;
		
		try{
			
			if(LoginDetails.ADMIN_ID_TYPE.equalsIgnoreCase(empcode.trim().substring(0, 3))){
				
				ps_employee=connection.prepareStatement(EmployeeDashboard.GET_ADMIN_NAME);
				ps_employee.setString(1,empcode);
			}else{
				
			   ps_employee=connection.prepareStatement(EmployeeDashboard.GET_EMPLOYEE_BY_EMPCODE);
			   ps_employee.setString(1,empcode);
			
			}
			
			rs_employee=ps_employee.executeQuery();
			
			while(rs_employee.next()){
			
				
					employee=rs_employee.getString("EMPNAME");
				
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
		logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeDashboardDaoImpl : getEmployee Ending");
		

		return employee;
	}


	public ArrayList<TravelBookedDetailsVo> getMoreTravelAllowanceDao(	String userCode, String startdate, String enddate) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardDaoImpl: getTravelAllowanceBD Starting");
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		int count=0;
		
		ArrayList<TravelBookedDetailsVo> travelDetailsList=new ArrayList<TravelBookedDetailsVo>();
		

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(EmployeeDashboard.GET_TRAVEL__MORE_ALLOWANCES);
			pstmt.setString(1,HelperClass.convertUIToDatabase(startdate));
			pstmt.setDate(2, HelperClass.getSqlDate(enddate) );
			pstmt.setString(3, userCode);
			
		
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				
				count++;
				TravelBookedDetailsVo travelVO=new TravelBookedDetailsVo();
				
				travelVO.setSno(count);
				travelVO.setProject(rs.getString("Project_Name"));
				travelVO.setBooked_date(HelperClass.convertDatabaseToUI(rs.getString("Booked_date")));
				travelVO.setTravelling_date(HelperClass.convertDatabaseToUI(rs.getString("Travelling_Date")));
				travelVO.setTravel_from(rs.getString("Traveling_From"));
				travelVO.setTravel_to(rs.getString("Traveling_To"));
				travelVO.setAmount(rs.getDouble("Amount"));
				
				travelVO.setTravel_mode(rs.getString("mode"));
	 
				 if(MessageConstants.YES.equalsIgnoreCase(rs.getString("isApprovedByAccounts"))){
					 
					 travelVO.setStatus(MessageConstants.APPROVED);
				 }else if(MessageConstants.NO.equalsIgnoreCase(rs.getString("isApprovedByAccounts"))){
					 
					 travelVO.setStatus(MessageConstants.NOT_APPROVED);
				 }else{
					 
					 travelVO.setStatus(MessageConstants.REJECTED);
				 }
				
				 
				 if(MessageConstants.YES.equalsIgnoreCase(rs.getString("isApprovedByAccounts"))){
					 
					 travelVO.setApprovedamount(rs.getDouble("ApprovedAmount"));
					 
				 }
				 
				 travelVO.setApprovedtime(rs.getString("approvedtime"));
			
				 travelVO.setBooked_by_empname(getEmployee(rs.getString("Tkt_Booked_by_empcode"),connection));
				
				 travelVO.setWho_on_travel_empname(getEmployee(rs.getString("resource_who_on_travel_empcode"),connection));
				 
				 travelVO.setDebit_card_used_by_empname(getEmployee(rs.getString("Debit_crdit_card_usedBy_empcode"),connection));
				 
				 
				 
				 if(MessageConstants.YES.equalsIgnoreCase(rs.getString("isApprovedByAccounts"))){
					 
					 travelVO.setApprovedby(getEmployee(rs.getString("ApprovedAccountsCode"),connection));
					 
				 }else if(MessageConstants.NO.equalsIgnoreCase(rs.getString("isApprovedByAccounts"))){
					 
					 travelVO.setApprovedby("-");
				 }else{
					 
					 travelVO.setApprovedby(getEmployee(rs.getString("ApprovedAccountsCode"),connection));
				 }
				 
				 
				 
				 travelVO.setProject_Ref_code(rs.getString("ProjectRefCode"));
				 
				 travelVO.setProject(rs.getString("Project_Name"));
				 
				 travelVO.setPosted_by(rs.getString("FirstName"));
				 
				 travelVO.setPosteddate(rs.getString("Posted_Date"));
				 
				
				travelDetailsList.add(travelVO);
				
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
			logger.error(sqle.getMessage(), sqle);
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {
				
				if (rs != null && !rs.isClosed()) {
					rs.close();
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
				+ " Control in EmployeeDashboardDaoImpl: getTravelAllowanceBD Ending");
		
		
		return travelDetailsList;
	}


	
	
	
	public static void main(String[] args) {
		
		JSONArray array=new JSONArray();
		array.put(new EmployeeDashboardDaoImpl().getviewLeaveDetails("EMP2"));
		
		System.out.println("att list ::: "+array);
		
	}


	@Override
	public ArrayList<EmployeeDashboardVO> getLeaveDetails(String empcode) {
	
    	logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardDaoImpl: getLeaveDetails Starting");
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		ArrayList<EmployeeDashboardVO> employeeAttendanceList=new ArrayList<EmployeeDashboardVO>();
	
		try {
			connection = getConnection();
			
			int currentmount=Integer.parseInt(HelperClass.getCurrentMonth());
			
			
			for(int i=currentmount-2;i<=currentmount;i++){
				
				EmployeeDashboardVO empdashboardVO=new EmployeeDashboardVO();
			
			String currentyear=HelperClass.getCurrentYear();
			
			
			String startDate=currentyear+"-"+i+"-"+1;
			String endDate=currentyear+"-"+i+"-"+HelperClass.getDaysByMonthAndYear(i,Integer.parseInt(currentyear));
				
			
			
			pstmt = connection.prepareStatement(EmployeeDashboard.GET_ATTENDANCE_DETAILS);
			pstmt.setString(1, startDate);
			pstmt.setString(2, endDate);
		/*	pstmt.setString(3, userCode);*/
					
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				empdashboardVO.setTotaldaysinmonth(HelperClass.getDaysByMonthAndYear(i,Integer.parseInt(currentyear)));
				empdashboardVO.setWorkingdays(rs.getInt("workingdays"));
				empdashboardVO.setTotPresent(rs.getDouble("totpresent"));
				empdashboardVO.setTotAbsent(rs.getDouble("totabsent"));
				empdashboardVO.setTotLeave(rs.getDouble("totleave"));
				empdashboardVO.setTotHoliday(rs.getDouble("totholidays"));
				empdashboardVO.setMonth(HelperClass.getMonthFullName(i+""));
				
			}
						
			employeeAttendanceList.add(empdashboardVO);
			
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
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt1 != null && !pstmt1.isClosed()) {
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
				sqle.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			}
		}
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDashboardDaoImpl: getLeaveDetails Ending");
		
		return employeeAttendanceList;
	
	}
	
	

   public ArrayList<LeaveViewDetailsVo> getviewLeaveDetails(String userCode) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeLeaveRequesDaoImpl: getviewLeaveDetails : Starting");
	
	PreparedStatement ps_leavebank = null;
	ResultSet rs_leavebank = null;
	
	PreparedStatement ps_attendance = null;
	ResultSet rs_attendance= null;
	
	PreparedStatement ps_getemp = null;
	ResultSet rs_getemp= null;
	
	PreparedStatement ps_getcl = null;
	ResultSet rs_getcl= null;
	

	Connection connection=null;
	
	ArrayList<LeaveViewDetailsVo> leaveviewlist = new ArrayList<LeaveViewDetailsVo>();
	
	try{
	
		boolean flag=true;
		connection=getConnection();
		
		ps_getemp=connection.prepareStatement(EmployeeLeaveRequest.GET_EMP_DOJ_YEAR);
		ps_getemp.setString(1,userCode);
		
		int currentYear=Integer.parseInt(HelperClass.getCurrentYear());
		
		rs_getemp = ps_getemp.executeQuery();
		
		while (rs_getemp.next()) {
			
			
		if((rs_getemp.getInt("AccadamicYear")<=currentYear) && ( rs_getemp.getInt("AccadamicYear")>=(currentYear-3))){
			
			String 	empyear= rs_getemp.getString("AccadamicYear");
			String  empyearcode = rs_getemp.getString("AccyearCode");
			String month=rs_getemp.getString("month");
			
			
					ps_leavebank=connection.prepareStatement(EmployeeLeaveRequest.GET_SL_LEAVES);
					ps_leavebank.setString(1, empyearcode);
					ps_leavebank.setString(2, userCode);
					
					rs_leavebank=ps_leavebank.executeQuery();
					
			  	while (rs_leavebank.next()) {
					
			  		LeaveViewDetailsVo leaveViewDetailsVo=new LeaveViewDetailsVo();
					
			  		leaveViewDetailsVo.setAccyear(empyear);
			  		leaveViewDetailsVo.setLeavetype(MessageConstants.LEAVE_TYPE_SL);
			  		
			  		double totopenings=rs_leavebank.getDouble("slopenbal");
			  		double monthopeningd=Math.round(totopenings/12);
			  		
			  		if(flag){
			  			
			  			double afetrdojopenings=monthopeningd *(12-Integer.parseInt(month));
			  			leaveViewDetailsVo.setOpeningbal(afetrdojopenings);
			  			leaveViewDetailsVo.setClosingbal(afetrdojopenings-rs_leavebank.getDouble("slconsumebal"));
			  			
			  		}else{
			  			
			  			leaveViewDetailsVo.setOpeningbal(rs_leavebank.getDouble("slopenbal"));
			  			leaveViewDetailsVo.setClosingbal(rs_leavebank.getDouble("slopenbal")-rs_leavebank.getDouble("slconsumebal"));
			  		}
			  		
			  		leaveViewDetailsVo.setConsumebal(rs_leavebank.getDouble("slconsumebal"));
			  		
			  		
			  		leaveviewlist.add(leaveViewDetailsVo);
			  		
				}
			
			  	ps_attendance=connection.prepareStatement(EmployeeLeaveRequest.GET_PL_LEAVES);
				ps_attendance.setString(1,empyearcode);
				ps_attendance.setString(2,userCode);
		
				rs_attendance=ps_attendance.executeQuery();
			
		       while (rs_attendance.next()) {
		        
		    		LeaveViewDetailsVo leaveViewDetailsVo=new LeaveViewDetailsVo();
		    		
		    		leaveViewDetailsVo.setAccyear("");
		    		leaveViewDetailsVo.setLeavetype(MessageConstants.LEAVE_TYPE_PL);
		    
		    		double totopenings=rs_attendance.getDouble("plopenbal");
			  		double monthopenings=Math.round(totopenings/12);
			  		
			  		if(flag){
		
			  			double afetrdojopenings=monthopenings *(12-Integer.parseInt(month));
			  			leaveViewDetailsVo.setOpeningbal(afetrdojopenings);
			  			leaveViewDetailsVo.setClosingbal(afetrdojopenings-rs_attendance.getDouble("plconsumebal"));
			  			
			  		}else{
			  			
			  			leaveViewDetailsVo.setOpeningbal(rs_attendance.getDouble("plopenbal"));
			  			leaveViewDetailsVo.setClosingbal(rs_attendance.getDouble("plopenbal")-rs_attendance.getDouble("plconsumebal"));
			  		}
		    	
			  		leaveViewDetailsVo.setConsumebal(rs_attendance.getDouble("plconsumebal"));
				
			  		leaveviewlist.add(leaveViewDetailsVo);
				
				}
       
       
       
       
		   	ps_getcl=connection.prepareStatement(EmployeeLeaveRequest.GET_CL_LEAVES);
		   	ps_getcl.setString(1,empyearcode);
		   	ps_getcl.setString(2,userCode);
		
			rs_getcl=ps_getcl.executeQuery();

		   while (rs_getcl.next()) {
		    
				LeaveViewDetailsVo leaveViewDetailsVo=new LeaveViewDetailsVo();
				
				leaveViewDetailsVo.setAccyear("");
				leaveViewDetailsVo.setLeavetype(MessageConstants.LEAVE_TYPE_CL);
		
				double totopenings=rs_getcl.getDouble("clopenbal");
		  		double monthopenings=Math.round(totopenings/12);
		  		
		  		if(flag){
		
		  			double afetrdojopenings=monthopenings *(12-Integer.parseInt(month));
		  			leaveViewDetailsVo.setOpeningbal(afetrdojopenings);
		  			leaveViewDetailsVo.setClosingbal(afetrdojopenings-rs_getcl.getDouble("clconsumebal"));
		  			
		  		}else{
		  			
		  			leaveViewDetailsVo.setOpeningbal(rs_getcl.getDouble("clopenbal"));
		  			leaveViewDetailsVo.setClosingbal(rs_getcl.getDouble("clopenbal")-rs_getcl.getDouble("clconsumebal"));
		  		}
			
		  		leaveViewDetailsVo.setConsumebal(rs_getcl.getDouble("clconsumebal"));
			
		  		leaveviewlist.add(leaveViewDetailsVo);
			
				}
	
     
		}
			
		//	if(firstyear == Integer.parseInt(rs_getemp.getString("AccyearCode"))){
				
				flag=false;
		//	}
	}
   } catch (SQLException sqle) {
	       sqle.printStackTrace();
	        logger.error(sqle.getMessage(),sqle);
           } catch (Exception e1) {
	        e1.printStackTrace();
	         logger.error(e1.getMessage(),e1);
           } finally {
	    try {
 
	    	
	    	
	    	
	    if (rs_attendance != null && (!rs_attendance.isClosed())) {

				rs_attendance.close();
		}
		if (rs_leavebank != null && (!rs_leavebank.isClosed())) {

			rs_leavebank.close();
		}
		if (rs_getemp != null && (!rs_getemp.isClosed())) {

			rs_getemp.close();
		}
	
		if (ps_attendance != null && (!ps_attendance.isClosed())) {

			ps_attendance.close();
		}
		if (ps_leavebank != null && (!ps_leavebank.isClosed())) {

			ps_leavebank.close();
		}
		if (ps_getemp != null && (!ps_getemp.isClosed())) {

			ps_getemp.close();
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
		+ " Control in EmployeeLeaveRequesDaoImpl: getviewLeaveDetails : Ending");

	return leaveviewlist;
}

	
	

}
