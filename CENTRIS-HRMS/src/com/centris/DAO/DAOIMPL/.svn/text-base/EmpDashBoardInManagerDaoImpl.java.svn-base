package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.HierarchyEventListener;
import org.json.JSONArray;

import com.centris.DAO.DBService;
import com.centris.DAO.EmpDashBoardInManagerDao;
import com.centris.VO.AdvanceSalByMgrInEmpDashBoardVo;
import com.centris.VO.ClaimesByManagerInEmpDashBoardVo;
import com.centris.VO.EmpDashBoardInManagerVO;
import com.centris.VO.EmpVO;
import com.centris.VO.EmployeeDashboardVO;
import com.centris.VO.TravelBookedDetailsVo;
import com.centris.action.EmployeeDashboardAction;
import com.centris.action.LoginCheckAction;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.EmployeeDashboard;
import com.centris.util.SQLUtils.LoginDetails;
import com.centris.util.SQLUtils.TravelBookedDetailsSqlUtil;
import com.centris.util.constants.MessageConstants;

public class EmpDashBoardInManagerDaoImpl extends DBService implements EmpDashBoardInManagerDao {
	
	private static 	Logger logger = Logger.getLogger(EmployeeDashboardAction.class);
	
       public EmpDashBoardInManagerVO getPersonalDetails(String empId) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpDashBoardInManagerDaoImpl: getPersonalDetails Starting");
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		EmpDashBoardInManagerVO empdashboardVO=new EmpDashBoardInManagerVO();
	
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(EmployeeDashboard.EMPLOYEE_PERSONAL_dETAILS_IN_MANAGER);
			pstmt.setString(1, empId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
			
			
				empdashboardVO.setEmployee_id(rs.getString("EMPID").trim());	
				empdashboardVO.setFirst_name(rs.getString("First_Name").trim());
				empdashboardVO.setBaselocation(rs.getString("BaseLocation").trim());
				empdashboardVO.setMobilenumber(rs.getString("Mobile_Number").trim());
				empdashboardVO.setPresentaddress(rs.getString("Present_Address").trim());
				empdashboardVO.setDob(HelperClass.convertDatabaseToUI(rs.getDate("DOB").toString()));
				empdashboardVO.setDoj(HelperClass.convertDatabaseToUI(rs.getDate("DOJ").toString()));
				if(rs.getString("DEPT_NAME")!=null){
					empdashboardVO.setDept_name(rs.getString("DEPT_NAME").trim());
					}else{
						
						empdashboardVO.setDept_name("HR Department");
					}
				
				empdashboardVO.setPermanent_address(rs.getString("Permanent_Address").trim());
				empdashboardVO.setVoter_id_no(rs.getString("Voter_ID_No").trim());
				empdashboardVO.setBlood_group(rs.getString("BloodGroup").trim());
				empdashboardVO.setPersonal_email_id(rs.getString("Personal_Email_ID").trim());
				empdashboardVO.setEmployee_type(rs.getString("EmpType").trim());
				empdashboardVO.setOfficialMailId(rs.getString("Official_Email_ID").trim());
				empdashboardVO.setDesignation(rs.getString("designationName").trim());
				empdashboardVO.setEmployeeImage(rs.getString("Employee_image").trim());
				
				
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
				+ " Control in EmpDashBoardInManagerDaoImpl: getPersonalDetails Ending");
		return empdashboardVO;
	}

@Override
		public EmpDashBoardInManagerVO getAttendanceDetails(String empId) {
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmpDashBoardInManagerDaoImpl: getAttendanceDetails Starting");
	
	PreparedStatement pstmt = null;
	Connection connection = null;
	ResultSet rs = null;
	EmpDashBoardInManagerVO empdashboardVO=new EmpDashBoardInManagerVO();

	try {
		connection = getConnection();
		pstmt = connection.prepareStatement(EmployeeDashboard.EMPLOYEE_ATTENDANCE_DETAILS_IN_MANAGER);
		pstmt.setString(1, HelperClass.convertUIToDatabase(HelperClass.currentMonthStartdate()));
		pstmt.setDate(2, HelperClass.getCurrentSqlDate());
		pstmt.setString(3, empId);
		
		rs = pstmt.executeQuery();
		int count=0;
		
		
		while (rs.next()) {
			count++;
			empdashboardVO.setSno(count);
			empdashboardVO.setTotaldaysinmonth(String.valueOf(HelperClass.getDaysofCurrentMonth()));
			empdashboardVO.setTotalworkingdays(rs.getString("workingdays"));
			empdashboardVO.setTotalpresents(rs.getString("totpresent"));
			empdashboardVO.setTotalabsents(rs.getString("totabsent"));
			empdashboardVO.setTotalholidays(rs.getString("totholidays"));
			empdashboardVO.setTotalleaves(rs.getString("totleave"));
			
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
			+ " Control in EmpDashBoardInManagerDaoImpl: getAttendanceDetails Ending");
	
	return empdashboardVO;
}

@Override
		public ArrayList<EmpDashBoardInManagerVO> getLeaveDetails(String empId,
		String currentuser) {
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmpDashBoardInManagerDaoImpl: getLeaveDetails Starting");
	
	PreparedStatement pstmt = null;
	Connection connection = null;
	ResultSet rs = null;
	ArrayList<EmpDashBoardInManagerVO> employeeleavedetails=new ArrayList<EmpDashBoardInManagerVO>();
	int sno=0;
	try {
		connection = getConnection();
		pstmt = connection.prepareStatement(EmployeeDashboard.MANAGER_NOT_APPROVED_LEAVES);
		pstmt.setString(1, empId);
		pstmt.setString(2, currentuser);

		rs = pstmt.executeQuery();
		while (rs.next()) {
			
			EmpDashBoardInManagerVO empdashboardVO=new EmpDashBoardInManagerVO();
			sno++;
			empdashboardVO.setSno(sno);
			empdashboardVO.setNoof_leaves(rs.getDouble("NoofLeaves"));
			empdashboardVO.setRequested_date(HelperClass.convertDatabaseToUI(rs.getString("requestdate")));
			empdashboardVO.setReasonfor_leave(rs.getString("ReasonForLeave"));
										
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
			+ " Control in EmpDashBoardInManagerDaoImpl: getLeaveDetails Ending");
	
	
	return employeeleavedetails;
}

@Override
		public EmpDashBoardInManagerVO getNotAprrovedAttendance(String empId) {
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmpDashBoardInManagerDaoImpl: getNotAprrovedAttendance Starting");
	
	PreparedStatement pstmt = null;
	Connection connection = null;
	ResultSet rs = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs1 = null;
	EmpDashBoardInManagerVO empdashboardVO=new EmpDashBoardInManagerVO();

	try {
		connection = getConnection();
		pstmt = connection.prepareStatement(EmployeeDashboard.MANAGER_NOT_APPROVED_DETAILS_ATTENDANC);
		pstmt.setString(1, empId);
		rs = pstmt.executeQuery();
		
		
		while (rs.next()) {
		
			empdashboardVO.setLastposteddate(rs.getString("PostedTime"));
			if(rs.getString("startDate")!=null){
			empdashboardVO.setStartdate(HelperClass.convertDatabaseToUI(rs.getString("startDate")));
			}
			if(rs.getString("endDate")!=null){
			empdashboardVO.setEndadate(HelperClass.convertDatabaseToUI(rs.getString("endDate")));
			}
			
			
		}
		
		pstmt1=connection.prepareStatement(EmployeeDashboard.GET_LAST_APRROVEDDATE);
		pstmt1.setString(1, empId);
		
		rs1=pstmt1.executeQuery();
		
		while (rs1.next()) {
	
			empdashboardVO.setLastupdateddate(rs1.getString("approvedtime"));
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
			+ " Control in EmpDashBoardInManagerDaoImpl: getNotAprrovedAttendance Ending");
	
	return empdashboardVO;
}

		public ArrayList<EmpVO> getSearchEmployee(String currentuser,String searchTerm) {
	
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmpDashBoardInManagerDaoImpl : getSearchEmployee : Starting");
	PreparedStatement employee_Pstmt = null;
	ResultSet employee_rs = null;
	Connection connection=null;
	int sno=0;
	ArrayList<EmpVO> employeelist=new ArrayList<EmpVO>();
try{
	connection=getConnection();
	employee_Pstmt = connection.prepareStatement(EmployeeDashboard.SEARCH_EMPLOYEE_UNDER_MANAGER);
	employee_Pstmt.setString(1, currentuser);
	employee_Pstmt.setString(2, "%"+searchTerm+"%");
	
	employee_rs = employee_Pstmt.executeQuery();
	
	while (employee_rs.next()) {
		EmpVO empVO=new EmpVO();
		sno++;
		empVO.setSno(sno);
		empVO.setEmpid(employee_rs.getString("EMPID"));
		empVO.setEmpname(employee_rs.getString("First_Name"));
		empVO.setPhone(employee_rs.getString("Mobile_Number"));
		empVO.setEmail(employee_rs.getString("Official_Email_ID"));
		empVO.setAddress(employee_rs.getString("Present_Address"));
		empVO.setDesignation(employee_rs.getString("designationName"));
		
		employeelist.add(empVO);
	}
	
} catch (SQLException sqle) {

	logger.error(sqle.getMessage(),sqle);

} catch (Exception e) {
	logger.error(e.getMessage(),e);
	
} finally {

	try {
		
		if(employee_rs != null && (!employee_rs.isClosed())){
			
			employee_rs.close();
		}
		if(employee_Pstmt != null && (!employee_Pstmt.isClosed())){
			
			employee_Pstmt.close();
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
		+ " Control in EmpDashBoardInManagerDaoImpl : getSearchEmployee : Ending");
	return employeelist;
}

		public ArrayList<EmpVO> getAllEmployeesUnderManager(String userCode) {
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmpDashBoardInManagerDaoImpl: getAllEmployeesByManager Starting");
	

	PreparedStatement pstmt = null;
	Connection connection = null;
	ResultSet rs = null;
	ArrayList<EmpVO> employeelist=new ArrayList<EmpVO>();
	int sno=0;
	try {

		connection = getConnection();
		pstmt = connection.prepareStatement(EmployeeDashboard.All_EMPLOYEES_UNDER_MANAGER);
		pstmt.setString(1, userCode);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			EmpVO empVO=new EmpVO();
			sno++;
			empVO.setSno(sno);
			empVO.setEmpid(rs.getString("EMPID"));
			empVO.setEmpname(rs.getString("First_Name"));
			empVO.setPhone(rs.getString("Mobile_Number"));
			empVO.setEmail(rs.getString("Official_Email_ID"));
			empVO.setAddress(rs.getString("Present_Address"));
			empVO.setDesignation(rs.getString("designationName"));
			
			employeelist.add(empVO);
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
			+ " Control in EmpDashBoardInManagerDaoImpl: getAllEmployeesUnderManager Ending");
	return employeelist;
}


		public ArrayList<EmployeeDashboardVO> getManagerDailyAllowances(String empId, String currentuser) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmpDashBoardInManagerDaoImpl: getManagerDailyAllowances Starting");
	
	PreparedStatement pstmt = null;
	Connection connection = null;
	ResultSet rs = null;
	ArrayList<EmployeeDashboardVO> employeedailyallowances=new ArrayList<EmployeeDashboardVO>();
	int sno=0;
	try {
		connection = getConnection();
		pstmt = connection.prepareStatement(EmployeeDashboard.GET_DAILY_ALLOWANCES_BY_MANAGER);
		pstmt.setString(1, HelperClass.convertUIToDatabase(HelperClass.currentMonthStartdate()));
		pstmt.setString(2, empId);
		pstmt.setString(3, currentuser);
		
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
			+ " Control in EmpDashBoardInManagerDaoImpl: getManagerDailyAllowances Ending");
	
	
	return employeedailyallowances;
}

		public ClaimesByManagerInEmpDashBoardVo getClaimsByManagerDao(String empId) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmpDashBoardInManagerDaoImpl: getClaimsByManagerDao Starting");
	
	PreparedStatement pstmt = null;
	Connection connection = null;
	ResultSet rs = null;
	ClaimesByManagerInEmpDashBoardVo employeeClaimes=new ClaimesByManagerInEmpDashBoardVo();

	try {
		connection = getConnection();
		pstmt = connection.prepareStatement(EmployeeDashboard.GET_CLIAMS_BY_MANAGER);
		pstmt.setString(1, empId);
		pstmt.setString(2, HelperClass.getCurrentYear());
		pstmt.setString(3, HelperClass.getCurrentMonth());
		
		rs = pstmt.executeQuery();
		
		System.out.println(pstmt);
		
		while (rs.next()) {
			
			
			employeeClaimes.setYear(rs.getString("year"));
			
			employeeClaimes.setMonth(HelperClass.getMonthFullName(rs.getString("month")));
			
			employeeClaimes.setClaimedamount(rs.getString("Total_amount_claimed"));
			
			
			if(rs.getString("Total_amount_approved")==null){
				employeeClaimes.setApprovedamount("-");
			}else{
				
				employeeClaimes.setApprovedamount(rs.getString("Total_amount_approved"));
			}
			
			
            if(MessageConstants.REJECT.equalsIgnoreCase(rs.getString("isManagerApproved"))){
				
				employeeClaimes.setStatus(MessageConstants.REJECTED);
				employeeClaimes.setApprovedamount("-");
				
				
			}else if(MessageConstants.REJECT.equalsIgnoreCase(rs.getString("isDirectorApproved"))){
				
				employeeClaimes.setStatus(MessageConstants.REJECTED);
				employeeClaimes.setApprovedamount("-");
				
			}else{
				
				if( MessageConstants.YES.equalsIgnoreCase(rs.getString("isAccountApproved"))){
					
					employeeClaimes.setStatus(MessageConstants.APPROVED);
					employeeClaimes.setApprovedamount(rs.getString("Account_Balance_Amt"));
					
				}else if( MessageConstants.REJECT.equalsIgnoreCase(rs.getString("isAccountApproved"))){
					
					employeeClaimes.setStatus(MessageConstants.REJECTED);
					employeeClaimes.setApprovedamount("-");
					
				}else{
					
					employeeClaimes.setStatus(MessageConstants.NOT_APPROVED);
					employeeClaimes.setApprovedamount("-");
				}
				
			}
		
			employeeClaimes.setLocalconveyance(rs.getString("Local_conveyance"));
			employeeClaimes.setTravelexpenses(rs.getString("Travel_expenses"));
			employeeClaimes.setStaffwelfare(rs.getString("Staff_welfare"));
			employeeClaimes.setTelephoneexp(rs.getString("Telephone_expenses"));
			employeeClaimes.setPurchases(rs.getString("Purchases"));
			employeeClaimes.setOtherworkexp(rs.getString("other_work_expenses"));
			employeeClaimes.setMislanious(rs.getString("Miscellaneous"));
			employeeClaimes.setExpensesCode(rs.getString("MEXP_CODE"));
			
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
			+ " Control in EmpDashBoardInManagerDaoImpl: getClaimsByManagerDao Ending");
	
	
	return employeeClaimes;
}

		public  ArrayList<AdvanceSalByMgrInEmpDashBoardVo> getAdvanceSalDetailsDao(String empId) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmpDashBoardInManagerDaoImpl: getAdvanceSalDetailsDao Starting");
	
	PreparedStatement pstmt = null;
	Connection connection = null;
	ResultSet rs = null;
	int count=0;
	
	ArrayList<AdvanceSalByMgrInEmpDashBoardVo> advanceSalaryList=new ArrayList<AdvanceSalByMgrInEmpDashBoardVo>();
	

	try {
		connection = getConnection();
		int currentmount=Integer.parseInt(HelperClass.getCurrentMonth());
		int monthcount=0;
		
		for(int i=currentmount-2;i<=currentmount;i++){
			
			
			int month=i;
			if(i==0){
				month=12;
			}else if(i==-1){
				month=11;
			}
			
			
			
			AdvanceSalByMgrInEmpDashBoardVo advanceSalaryVo=new AdvanceSalByMgrInEmpDashBoardVo();
		pstmt = connection.prepareStatement(EmployeeDashboard.GET_ADVANCESALARY_BY_MANAGER);
		
		pstmt.setString(1, empId);
		if(Integer.parseInt(HelperClass.getCurrentMonth())>=3){
		pstmt.setString(2, HelperClass.getCurrentYear());
		advanceSalaryVo.setYear(HelperClass.getCurrentYear());
		}else{
			
			if(Integer.parseInt(HelperClass.getCurrentMonth())==2){
				
				if(monthcount==0){
					
					pstmt.setString(2,(Integer.parseInt(HelperClass.getCurrentYear())-1)+"");
					advanceSalaryVo.setYear((Integer.parseInt(HelperClass.getCurrentYear())-1)+"");
					
				}else{
					
					pstmt.setString(2, HelperClass.getCurrentYear());
					advanceSalaryVo.setYear(HelperClass.getCurrentYear());
				}
			}else if(Integer.parseInt(HelperClass.getCurrentMonth())==1){
				
				if(monthcount==0 || monthcount==1){
					
					pstmt.setString(2,(Integer.parseInt(HelperClass.getCurrentYear())-1)+"");
					advanceSalaryVo.setYear((Integer.parseInt(HelperClass.getCurrentYear())-1)+"");
				}else{
					
					pstmt.setString(2, HelperClass.getCurrentYear());
					advanceSalaryVo.setYear(HelperClass.getCurrentYear());
				}
				
			}
			
		}
		pstmt.setInt(3, month);
		
		rs = pstmt.executeQuery();
		
	
		

		
		
		advanceSalaryVo.setMonth(HelperClass.getMonthFullName(month+""));
		
		
		while (rs.next()) {
			
			count++;
			
			if(rs.getString("AdvSalCode")==null){
				
				advanceSalaryVo.setSno(count);
				advanceSalaryVo.setProject("-");
				advanceSalaryVo.setClaimedAmount("0");
				advanceSalaryVo.setAprovedAmount("0");
				advanceSalaryVo.setStatus("-");
				advanceSalaryVo.setAdvanceSalaryCode("-");
	
			}else{
			advanceSalaryVo.setSno(count);
			advanceSalaryVo.setProject(rs.getString("Project_Name"));
			advanceSalaryVo.setClaimedAmount(rs.getString("postedamount"));
			advanceSalaryVo.setAprovedAmount(rs.getString("approvedAmount"));
			advanceSalaryVo.setStatus(rs.getString("status"));
			advanceSalaryVo.setAdvanceSalaryCode(rs.getString("AdvSalCode"));
			}
			
			advanceSalaryList.add(advanceSalaryVo);
			
			
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
			+ " Control in EmpDashBoardInManagerDaoImpl: getAdvanceSalDetailsDao Ending");
	
	
	return advanceSalaryList;
}


		public  ArrayList<AdvanceSalByMgrInEmpDashBoardVo> getAdvanceSalCompleteDetailsDao(String empId,String month,String year) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmpDashBoardInManagerDaoImpl: getAdvanceSalCompleteDetailsDao Starting");
	
	PreparedStatement pstmt = null;
	Connection connection = null;
	ResultSet rs = null;
	int count=0;
	
	ArrayList<AdvanceSalByMgrInEmpDashBoardVo> advanceSalaryList=new ArrayList<AdvanceSalByMgrInEmpDashBoardVo>();
	

	try {
		connection = getConnection();
		pstmt = connection.prepareStatement(EmployeeDashboard.GET_ADVANCESALARY_COMPLETEDETAILS);
		pstmt.setString(1, empId);
		pstmt.setString(2, year);
		pstmt.setString(3, month);
		
		
		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			count++;
			AdvanceSalByMgrInEmpDashBoardVo advanceSalaryVo=new AdvanceSalByMgrInEmpDashBoardVo();
			
			advanceSalaryVo.setSno(count);
			advanceSalaryVo.setYear(rs.getString("AccadamicYear"));
			advanceSalaryVo.setMonth(HelperClass.getMonthFullName(rs.getString("Month")));
			advanceSalaryVo.setProject(rs.getString("Project_Name"));
			
			advanceSalaryVo.setClaimedAmount(rs.getString("salary_amount"));
			advanceSalaryVo.setRequestedDate(HelperClass.convertDatabaseToUI(rs.getString("requestDate")));
			advanceSalaryVo.setComments(rs.getString("Comments"));
			
			advanceSalaryVo.setStatus(rs.getString("status"));
			if(rs.getString("ApprovedAmount")==null){
				
				advanceSalaryVo.setAprovedAmount("-");
				advanceSalaryVo.setDirapprovedDate("-");
				advanceSalaryVo.setApprovedbydirector("-");
				
			}else{
			advanceSalaryVo.setAprovedAmount(rs.getString("ApprovedAmount"));
			advanceSalaryVo.setDirapprovedDate(HelperClass.convertDatabaseToUI(rs.getString("approvedDate")));
			advanceSalaryVo.setApprovedbydirector(rs.getString("directorname"));
			}
			
			
			advanceSalaryVo.setAdminStatus(rs.getString("accountsStatus"));
			
			if(rs.getString("accountsStatus").equalsIgnoreCase("Approved")){
				advanceSalaryVo.setApprovedbyadmin(rs.getString("adminName"));
			advanceSalaryVo.setAdminApprovedDate(HelperClass.convertDatabaseToUI(rs.getString("accountApprovedDate")));
			}else{
				advanceSalaryVo.setApprovedbyadmin("-");
				advanceSalaryVo.setAdminApprovedDate("-");
			}
			
			advanceSalaryVo.setAdvanceSalaryCode(rs.getString("AdvSalCode"));
			advanceSalaryVo.setEmpname(rs.getString("First_Name"));
			
			advanceSalaryList.add(advanceSalaryVo);
			
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
			+ " Control in EmpDashBoardInManagerDaoImpl: getAdvanceSalCompleteDetailsDao Ending");
	
	
	return advanceSalaryList;
}


		public static void main(String[] args) {
	
	
	new EmpDashBoardInManagerDaoImpl().getAdvanceSalDetailsDao("EMP2");
}




public ArrayList<TravelBookedDetailsVo> getTravelAllowanceDao(String empId, String userCode) {

	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())
			+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())
			+ " Control in EmpDashBoardInManagerDaoImpl: getTravelAllowanceBD Starting");
	
	PreparedStatement pstmt = null;
	Connection connection = null;
	ResultSet rs = null;
	int count=0;
	
	ArrayList<TravelBookedDetailsVo> travelDetailsList=new ArrayList<TravelBookedDetailsVo>();
	

	try {
		connection = getConnection();
		pstmt = connection.prepareStatement(EmployeeDashboard.GET_TRAVEL_ALLOWANCES_BY_MANAGER_AND_EMP);
		pstmt.setString(1,HelperClass.convertUIToDatabase(HelperClass.currentMonthStartdate()));
		pstmt.setDate(2, HelperClass.getCurrentSqlDate());
		pstmt.setString(3, empId);
		pstmt.setString(4, userCode);
	
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
			+ " Control in EmpDashBoardInManagerDaoImpl: getTravelAllowanceBD Ending");
	
	
	return travelDetailsList;
}




private String getEmployee(String empcode, Connection connection) {
	logger.setLevel(Level.DEBUG);
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in EmpDashBoardInManagerDaoImpl: getEmployee  Starting");

	PreparedStatement ps_employee = null;
	ResultSet rs_employee=null;
	String employee=null;
	
	try{
		
		if(LoginDetails.ADMIN_ID_TYPE.equalsIgnoreCase(empcode.trim().substring(0,3))){
			
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
	logger.info(JDate.getTimeString(new Date())+ " Control in getEmployee Ending");
	

	return employee;
}


  public ArrayList<TravelBookedDetailsVo> getMoreTravelAllowanceBD(String employeeId, String currentuser, String startdate, String enddate) {
	
	
	
	  logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpDashBoardInManagerDaoImpl: getTravelAllowanceBD Starting");
		
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		int count=0;
		
		ArrayList<TravelBookedDetailsVo> travelDetailsList=new ArrayList<TravelBookedDetailsVo>();
		

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(EmployeeDashboard.GET_TRAVEL_ALLOWANCES_BY_MANAGER_AND_EMP);
			pstmt.setString(1,HelperClass.convertUIToDatabase(startdate));
			pstmt.setDate(2, HelperClass.getSqlDate(enddate));
			pstmt.setString(3, employeeId);
			pstmt.setString(4, currentuser);
		
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
				+ " Control in EmpDashBoardInManagerDaoImpl: getTravelAllowanceBD Ending");
		
		
		return travelDetailsList;

}


 public ArrayList<ClaimesByManagerInEmpDashBoardVo> moreExpensesDeatailsHomeBD(
		String empid, String month, String year, String currentuser) {
	
	 logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmpDashBoardInManagerDaoImpl: moreExpensesDeatailsHomeBD Starting");
		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;

		ArrayList<ClaimesByManagerInEmpDashBoardVo> employeeClaimesList=new ArrayList<ClaimesByManagerInEmpDashBoardVo>();
		int count=0;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(EmployeeDashboard.GET_EMPLOYEE_CLIAMES_VIEW_IN_MANAGER);
			pstmt.setString(1, empid);
			pstmt.setString(2, year);
			pstmt.setString(3, month);
				
			rs = pstmt.executeQuery();
			
			System.out.println("hiiii"+pstmt);
			
			
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
				+ " Control in EmpDashBoardInManagerDaoImpl: moreExpensesDeatailsHomeBD Ending");
		
		
		return employeeClaimesList;
	
	
}

}
