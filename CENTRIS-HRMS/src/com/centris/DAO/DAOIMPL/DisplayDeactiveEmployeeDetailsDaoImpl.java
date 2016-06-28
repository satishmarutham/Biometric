package com.centris.DAO.DAOIMPL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.centris.DAO.DBService;
import com.centris.DAO.DisplayDeactiveEmployeeDetailsDao;
import com.centris.VO.EmployVO;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.constants.MessageConstants;

public class DisplayDeactiveEmployeeDetailsDaoImpl extends DBService implements DisplayDeactiveEmployeeDetailsDao{

	private static Logger logger = Logger.getLogger(DisplayDeactiveEmployeeDetailsDaoImpl.class);

	public ArrayList<EmployVO> getDeactiveEmployeeDetails(String empid) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in DisplayDeactiveEmployeeDetailsDaoImpl: getDeactiveEmployeeDetails Starting");
	
		PreparedStatement pstmt=null;
		Connection connection=null;
		ResultSet rs=null;
		EmployVO employVO=null;
		ArrayList<EmployVO> employVOList= new ArrayList<EmployVO>();
		try{
			connection = getConnection();
			pstmt=connection.prepareStatement(Employee.GET_DEACTIVE_EMP_DETAILS);
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
				employVO.setEmpType(rs.getString("EmpType"));
				
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
	logger.info(JDate.getTimeString(new Date())+ " Control in DisplayDeactiveEmployeeDetailsDaoImpl: getDeactiveEmployeeDetails Ending");
	
	
	
	
		return  employVOList;
	}
	
}
