package com.centris.DAO.DAOIMPL;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;



import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;





import com.centris.DAO.DBService;
import com.centris.DAO.GetAllEmployeeDao;
import com.centris.VO.AllEmployeeReportVO;
import com.centris.VO.AllEmployeesViewDialogVo;
import com.centris.VO.EmployVO;
import com.centris.VO.GetAllEmployeeVO;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.SQLUtils.SQLutilConstants;
import com.centris.util.constants.MessageConstants;

public class GetAllEmployeeDaoImpl extends DBService implements GetAllEmployeeDao {
	private static Logger logger = Logger.getLogger(GetAllEmployeeDaoImpl.class);

	public ArrayList<GetAllEmployeeVO> getDetails() {

		ArrayList<GetAllEmployeeVO> list = new ArrayList<GetAllEmployeeVO>();
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeDaoImpl:getDetails Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count=0;

		try {

			con = getConnection();
			pstmt = con
					.prepareStatement(Employee.GET_EMPLOYEES_DETAILS);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count++;
				GetAllEmployeeVO vo = new GetAllEmployeeVO();
				vo.setSno(count);
				vo.setEmpid(rs.getString("EMPID"));
				vo.setEmpname(rs.getString("First_Name"));
				vo.setProjectname(rs.getString("BaseLocation"));
				vo.setDesignationname(rs.getString("designationName"));
				vo.setSalary(rs.getDouble("Salary_offered")+"");
				vo.setManagername(rs.getString("FirstName"));
				vo.setBioid(rs.getString("bioid"));
				if(rs.getString("HDFC_AC")==null){
					
					vo.setAccountNumber("");
				}else{
				vo.setAccountNumber(rs.getString("HDFC_AC"));
				}
				vo.setOfficialMailId(rs.getString("Official_Email_ID"));
				vo.setPhonenumber(rs.getString("Mobile_Number"));
				vo.setPermissions(rs.getString("permissions").trim().replace(" ", ","));
				
				/*File f = new File(rs.getString("Employee_image"));
				if(f.exists() && !f.isDirectory()) {
					
					
				}else{
					
					vo.setImage("");
				}*/
				
				list.add(vo);
			}

		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);
			e1.printStackTrace();
		} finally {
			try {

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (con != null && (!con.isClosed())) {
					con.close();

				}

			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
				sqle.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeDaoImpl:getDetails Ending");
		return list;
	}

	public ArrayList<GetAllEmployeeVO> autosearchemployee(String term) {

		ArrayList<GetAllEmployeeVO> autolist = new ArrayList<GetAllEmployeeVO>();
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeDaoImpl:autoSearch Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = getConnection();
			pstmt = con
					.prepareStatement(Employee.AUTO_SEARCH_EMPLOYEES);
			pstmt.setString(1, "%" + term + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GetAllEmployeeVO vo = new GetAllEmployeeVO();
				vo.setEmpid(rs.getString("EMPID"));
				vo.setEmpname(rs.getString("First_Name"));
				autolist.add(vo);
			}

		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);
			e1.printStackTrace();
		} finally {
			try {

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (con != null && (!con.isClosed())) {
					con.close();

				}

			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
				sqle.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in getall GetAllEmployeeDaoImpl:autoSearch Ending");
		return autolist;
	}

	
	public ArrayList<GetAllEmployeeVO> searchemployee(String searchterm) {

		ArrayList<GetAllEmployeeVO> srchlist = new ArrayList<GetAllEmployeeVO>();
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeDaoImpl:Search Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count =0;

		try {

			con = getConnection();
			pstmt = con
					.prepareStatement(Employee.SEARCH_EMPLOYEES);
			pstmt.setString(1,searchterm);
			pstmt.setString(2, searchterm);
			rs=pstmt.executeQuery();
			while(rs.next()){
				count++;
				GetAllEmployeeVO vo = new GetAllEmployeeVO();
				vo.setSno(count);
				vo.setEmpid(rs.getString("EMPID"));
				vo.setEmpname(rs.getString("First_Name"));
				vo.setProjectname(rs.getString("BaseLocation"));
				vo.setDesignationname(rs.getString("designationName"));

				vo.setManagername(rs.getString("FirstName"));
				vo.setBioid(rs.getString("bioid"));
				if(rs.getString("HDFC_AC")==null){
					
					vo.setAccountNumber("");
				}else{
				vo.setAccountNumber(rs.getString("HDFC_AC"));
				}
				vo.setOfficialMailId(rs.getString("Official_Email_ID"));
				vo.setPhonenumber(rs.getString("Mobile_Number"));
				vo.setPermissions(rs.getString("permissions").trim().replace(" ", ","));
				
				srchlist.add(vo);
			}

		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);
			e1.printStackTrace();
		} finally {
			try {

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (con != null && (!con.isClosed())) {
					con.close();

				}

			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
				sqle.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeDaoImpl:Search Ending");
		return srchlist;
	}

	public ArrayList<EmployVO> modifyemployee(String empid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in GetAllEmployeeDaoImpl: modifyemployee Starting");
	
		PreparedStatement pstmt=null;
		Connection connection=null;
		ResultSet rs=null;
		EmployVO employVO=null;
		ArrayList<EmployVO> employVOList= new ArrayList<EmployVO>();
		try{
			connection = getConnection();
			pstmt=connection.prepareStatement(Employee.GET_SPECIFIC_EMPLOYEES);
			pstmt.setString(1, empid);
			
			
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				employVO= new EmployVO();
			
				employVO.setEmpCode(rs.getString("EMPID"));
				employVO.setEmpStatus(rs.getString("Employee_Status"));
				
				employVO.setEmpFirstName(rs.getString("First_Name"));
				employVO.setReportingSupervisor(rs.getString("ManagerCode"));
				
			
				employVO.setProject(rs.getString("ProjectCode"));
				if(rs.getString("Passport_Expir_date")!=null){
					employVO.setPassportExpiryDate(HelperClass.convertDatabaseToUI(rs.getString("Passport_Expir_date")));
				}
				else{
					employVO.setPassportExpiryDate("");
				}
				employVO.setDateOfJoining(HelperClass.convertDatabaseToUI(rs.getString("DOJ")));
				employVO.setBaseLocation(rs.getString("BaseLocation"));
				employVO.setDesignation(rs.getString("DesignationCode"));
				employVO.setDepartment(rs.getString("DEPT_ID"));
				employVO.setGender(rs.getString("gender"));
				employVO.setBloodGroup(rs.getString("BloodGroup"));
				employVO.setDateOfBirth(HelperClass.convertDatabaseToUI(rs.getString("DOB")));
				employVO.setPanCardNo(rs.getString("PAN_Card_No"));
				employVO.setVoterIdNo(rs.getString("Voter_ID_No"));
				employVO.setAddharCardNo(rs.getString("Addhar_Card_No"));
				employVO.setDrivingLicenceNo(rs.getString("DL_NO"));
				employVO.setPermanentAddress(rs.getString("Permanent_Address"));
				employVO.setPresentAddress(rs.getString("Present_Address"));
				employVO.setMobileNo(rs.getString("Mobile_Number"));
				employVO.setPersonalEmailId(rs.getString("Personal_Email_ID"));
				employVO.setOfficialEmailId(rs.getString("Official_Email_ID"));
				employVO.setMaritalStatus(rs.getString("Marital_Status"));
				employVO.setSalaryOffered(rs.getString("Salary_offered"));
				if(rs.getString("DOL")!=null){
					employVO.setDateOfLeaving(HelperClass.convertDatabaseToUI(rs.getString("DOL")));
				}
				else{
					employVO.setDateOfLeaving("");
				}
				employVO.setHdfcAccountNo(rs.getString("HDFC_AC"));
				employVO.setBankName(rs.getString("Bank_Name"));
				employVO.setBankBranchName(rs.getString("Branch_Name"));
				employVO.setBankIfscCode(rs.getString("IFSC_Code"));
				employVO.setPassportNo(rs.getString("Passport_No"));
				if(rs.getString("Passport__Issued_Date")!=null){
					employVO.setPassportIssueDate(HelperClass.convertDatabaseToUI(rs.getString("Passport__Issued_Date")));
				}
				else{
					employVO.setPassportIssueDate("");
				}
				employVO.setPassportIssuePlace(rs.getString("Passport_Issued_Place"));
				employVO.setPreviousCompanyName(rs.getString("Previous_Company"));
				employVO.setLastCompanyDesignation(rs.getString("Designation_in_the_last_company"));
				employVO.setLastDrawnSalaryInRS(rs.getString("Last_Drawn_Salary"));
				employVO.setTotalExperience(rs.getString("Total_experience_before"));
				employVO.setMajorQualification(rs.getString("Major_Qualification"));
				employVO.setUniversityOrBoard(rs.getString("University_Board"));
				employVO.setYearOfPassing(rs.getString("Year_of_passing"));
				employVO.setCollegeOrInstituteName(rs.getString("College_Institute"));
				employVO.setFatherName(rs.getString("Fathers_Name"));
				employVO.setFatherDOB(HelperClass.convertDatabaseToUI(rs.getString("DOB_of_father")));
				employVO.setMotherName(rs.getString("Mother_name"));
				employVO.setMotherDOB(HelperClass.convertDatabaseToUI(rs.getString("DOB_mother")));
				if(rs.getString("DOM")!=null){
					employVO.setDateOfMariage(HelperClass.convertDatabaseToUI(rs.getString("DOM")));
				}
				else{
					employVO.setDateOfMariage("");
				}
				employVO.setSpouseName(rs.getString("Spouse_Name"));
				if(rs.getString("DOB_Spouse")!=null){
					employVO.setSpouseDOB(HelperClass.convertDatabaseToUI(rs.getString("DOB_Spouse")));
				}
				else{
					employVO.setSpouseDOB("");
				}
				employVO.setFirstChildName(rs.getString("Child_1"));
				if(rs.getString("DOB_Child_1")!=null){
					employVO.setFirstChildDOB(HelperClass.convertDatabaseToUI(rs.getString("DOB_Child_1")));
				}
				else{
					employVO.setFirstChildDOB("");
				}
				employVO.setSecondChildName(rs.getString("Child_2"));
				if(rs.getString("DOB_Child_2")!=null){
					employVO.setSecondChildDOB(HelperClass.convertDatabaseToUI(rs.getString("DOB_Child_2")));
				}
				else{
					employVO.setSecondChildDOB("");
				}
				employVO.setFamilyPhoneNo(rs.getString("Family_phone_no"));
				employVO.setSecurityDocument(rs.getString("PanCard"));
				employVO.setEmpImage(rs.getString("Employee_image"));
				employVO.setRemarks(rs.getString("Remarks"));
				employVO.setUserCode(rs.getString("userCode"));
				employVO.setManagerCode(rs.getString("ManagerCode"));
/*//				employVO.setSunday(rs.getBoolean("SUNDAY"));
//				employVO.setMonday(rs.getBoolean("MONDAY"));
//				employVO.setTuesday(rs.getBoolean("TUESDAY"));
//				employVO.setWednesday(rs.getBoolean("WEDNESDAY"));
//				employVO.setThrusday(rs.getBoolean("THURSDAY"));
//				employVO.setFriday(rs.getBoolean("FRIDAY"));
//				employVO.setSaturday(rs.getBoolean("SATURDAY"));
*/				employVO.setEmpType(rs.getString("EmpType"));
				
				employVO.setDocument1(rs.getString("ElectionId"));
				employVO.setDocument2(rs.getString("AdharCard"));
				employVO.setDocument3(rs.getString("DrivingLicence"));
				employVO.setDocument4(rs.getString("Others"));
				employVO.setBiometricId(rs.getString("bioid"));
				
				employVO.setFile1(rs.getString("File1"));
				employVO.setFile2(rs.getString("File2"));
				employVO.setFile3(rs.getString("File3"));
				employVO.setFile4(rs.getString("File4"));
				employVO.setFile5(rs.getString("File5"));
				
				employVOList.add(employVO);
				
			}
			
		
		 } catch (SQLException sqle) {
			 logger.error(sqle.getMessage(),sqle);
			 sqle.printStackTrace();
				
			} catch (Exception e1) {
				logger.error(e1.getMessage(),e1);
				e1.printStackTrace();
			}finally{
				try{
					if (rs != null && !rs.isClosed()) {
						rs.close();
					}
					
					if(pstmt!=null && !pstmt.isClosed()){
						pstmt.close();
					}
					
					if(connection != null && (!connection.isClosed())){
						connection.close();
						
					}
					
				} catch (SQLException sqle) {
					logger.error(sqle.getMessage(),sqle);
					sqle.printStackTrace();
				} catch (Exception e1) {
					logger.error(e1.getMessage(),e1);
					e1.printStackTrace();
				}
			}
	JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.END_POINT);
	logger.info(JDate.getTimeString(new Date())+ " Control in GetAllEmployeeDaoImpl: modifyemployee Ending");
	
	
	
	
		return  employVOList;
	}

	public List<AllEmployeeReportVO> getallEmployeeDetails(String[] empids) {
		
		
		List<AllEmployeeReportVO> allemployeelist = new ArrayList<AllEmployeeReportVO>();
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeDaoImpl:getallEmployeeDetails Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = getConnection();
			pstmt = con
					.prepareStatement(Employee.GET_ALL_EMPLOYEES_DETAILS);
		
			for (int i = 0; i < empids.length; i++) {
				pstmt.setString(1, empids[i]);
				
				rs = pstmt.executeQuery();
			while (rs.next()) {
		
				AllEmployeeReportVO  allemployeeVO = new AllEmployeeReportVO ();
			
				allemployeeVO.setEMPID(rs.getString("EMPID"));
				allemployeeVO.setFirst_Name(rs.getString("First_Name"));
				allemployeeVO.setDOB(rs.getString("DOB"));
				allemployeeVO.setDOJ(rs.getString("DOJ"));
				allemployeeVO.setPersonal_Email_ID(rs.getString("Personal_Email_ID"));
				allemployeeVO.setOfficial_Email_ID(rs.getString("Official_Email_ID"));
				allemployeeVO.setMobile_Number(rs.getString("Mobile_Number"));
				allemployeeVO.setPresent_Address(rs.getString("Present_Address"));
			
				
				
				allemployeeVO.setEmployee_image(rs.getString("Employee_image"));
				allemployeeVO.setProject_Name(rs.getString("Project_Name"));
				allemployeeVO.setLocation(rs.getString("Location"));
				allemployeeVO.setProjectManager(rs.getString("ProjectManager"));
				allemployeeVO.setDesignationName(rs.getString("designationName"));
				allemployeeVO.setDEPT_NAME(rs.getString("DEPT_NAME"));
				allemployeeVO.setEmpType(rs.getString("EmpType"));
						
				allemployeelist.add(allemployeeVO);
					
				
				
				
			}
			}
			
			
		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);
			e1.printStackTrace();
		} finally {
			try {

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (con != null && (!con.isClosed())) {
					con.close();

				}

			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
				sqle.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in getall GetAllEmployeeDaoImpl:getallEmployeeDetails Ending");
			
		return allemployeelist;
	}

	@Override
	public ArrayList<AllEmployeesViewDialogVo> getEmpDetailsForViewDao(
			String empid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeDaoImpl:Search Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<AllEmployeesViewDialogVo> employeevoList=new ArrayList<AllEmployeesViewDialogVo>();
		

		try {

			con = getConnection();
			pstmt = con
					.prepareStatement(Employee.VIEW_EMPLOYEES_DIALOG);
			pstmt.setString(1,empid);
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				
				AllEmployeesViewDialogVo vo = new AllEmployeesViewDialogVo();
				vo.setEmpId(rs.getString("EMPID"));
				vo.setEmpName(rs.getString("First_Name"));
				vo.setPermissions(rs.getString("permissions").trim().replace(" ", ","));
				vo.setLocation(rs.getString("BaseLocation"));
				vo.setQualification(rs.getString("Major_Qualification"));
				vo.setDob(HelperClass.convertDatabaseToUI(rs.getString("DOB")));
				vo.setDoj(HelperClass.convertDatabaseToUI(rs.getString("DOJ")));
				vo.setPresentAddress(rs.getString("Present_Address"));
				vo.setImage(rs.getString("Employee_image"));
				vo.setOfficialMailId(rs.getString("Official_Email_ID"));
				
				employeevoList.add(vo);
			}

		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);
			e1.printStackTrace();
		} finally {
			try {

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (con != null && (!con.isClosed())) {
					con.close();

				}

			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
				sqle.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeDaoImpl:Search Ending");
		return employeevoList;
	}
	
	public ArrayList<GetAllEmployeeVO> getDeactiveEmployeeDetails() {

		ArrayList<GetAllEmployeeVO> list = new ArrayList<GetAllEmployeeVO>();
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeDaoImpl: getDeactiveEmployeeDetails Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count=0;

		try {

			con = getConnection();
			pstmt = con
					.prepareStatement(Employee.GET_ALL_DEACTIVE_EMPLOYEES);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count++;
				GetAllEmployeeVO vo = new GetAllEmployeeVO();
				vo.setSno(count);
				vo.setEmpid(rs.getString("EMPID"));
				vo.setEmpname(rs.getString("First_Name"));
				vo.setDesignationname(rs.getString("designationName"));
			/*	vo.setManagername(rs.getString("FirstName"));*/
				vo.setBioid(rs.getString("bioid"));
				vo.setOfficialMailId(rs.getString("Official_Email_ID"));
				vo.setPhonenumber(rs.getString("Mobile_Number"));
				vo.setPermissions(rs.getString("permissions").trim().replace(" ", ","));
				
				
				
				list.add(vo);
			}

		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);
			e1.printStackTrace();
		} finally {
			try {

				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (con != null && (!con.isClosed())) {
					con.close();

				}

			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
				sqle.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeDaoImpl: getDeactiveEmployeeDetails Ending");
		return list;
	}
	
	
	public int activateEmployee(String empid) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeDaoImpl: activateEmployee Starting");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count=0;

		try {

			con = getConnection();
			pstmt = con
					.prepareStatement(Employee.ACTIVATE_EMPLOYEE);
			pstmt.setString(1,empid);
			int update = pstmt.executeUpdate();
			if(update > 0)
			{
				count=1;
			}
			else
			{
				count=0;
			}

		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);
			e1.printStackTrace();
		} finally {
			try {

				
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}

				if (con != null && (!con.isClosed())) {
					con.close();

				}

			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
				sqle.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
			}
		}

		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in GetAllEmployeeDaoImpl: getDeactiveEmployeeDetails Ending");
		return count;
	}
	
}
