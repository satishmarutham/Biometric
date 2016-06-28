package com.centris.DAO.DAOIMPL;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

import com.centris.DAO.DBService;
import com.centris.DAO.EmployeePersonalDetailsDao;
import com.centris.POJO.EmployeePersonalDetailsPojo;
import com.centris.VO.EmployeePersonalDetailsVo;
import com.centris.form.EmployeePersonalDetailsForm;
import com.centris.util.HelperClass;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.constants.MessageConstants;

public class EmployeePersonalDetailsDaoImpl extends DBService implements
		EmployeePersonalDetailsDao {
	private static Logger logger = Logger
			.getLogger(EmployeePersonalDetailsDaoImpl.class);

	@Override
	public Map<String, List<EmployeePersonalDetailsVo>> getEmployeePersonalDetails(
			EmployeePersonalDetailsPojo employeeDetails) throws Exception {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsDaoImpl : getEmployeePersonalDetails Starting");

		Map<String, List<EmployeePersonalDetailsVo>> allDetails = new LinkedHashMap<String, List<EmployeePersonalDetailsVo>>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		List<EmployeePersonalDetailsVo> splitEmpDetails = new ArrayList<EmployeePersonalDetailsVo>();
		try {
			con = getConnection();
			pstmt = con.prepareStatement(Employee.GET_EMP_PERSONAL_DETAILS);
			pstmt.setString(1, employeeDetails.getEmpId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EmployeePersonalDetailsVo employVO = new EmployeePersonalDetailsVo();
				employVO.setEmployeeName(rs.getString("First_Name"));
				employVO.setEmployeeDob(HelperClass.convertDatabaseToUI(rs
						.getString("DOB")));
				employVO.setDateOfJoining(HelperClass.convertDatabaseToUI(rs
						.getString("DOJ")));
				employVO.setBaseLocation(rs.getString("BaseLocation"));
				employVO.setEmpType(rs.getString("EmpType"));
				employVO.setPreview_empImage(rs.getString("Employee_image"));

				employVO.setEmpCode(rs.getString("EMPID"));
				employVO.setEmpStatus(rs.getString("Employee_Status"));

			/*	employVO.setReportingSupervisor(rs.getString("ManagerName"));*/

			/*	employVO.setProject(rs.getString("ProjectRefCode"));*/

				employVO.setDesignation(rs.getString("designationName"));
			/*	employVO.setDepartment(rs.getString("DEPT_NAME"));*/
				employVO.setGender(rs.getString("gender"));
				employVO.setBloodGroup(rs.getString("BloodGroup"));
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
				/*employVO.setProjectHead(rs.getString("ProjectHead"));*/
				employVO.setBioEmpId(rs.getString("bioid"));
				splitEmpDetails.add(employVO);
				allDetails.put("Personal Details", splitEmpDetails);

				employVO.setFatherName(rs.getString("Fathers_Name"));
				employVO.setMotherName(rs.getString("Mother_name"));
				employVO.setFatherDOB(HelperClass.convertDatabaseToUI(rs
						.getString("DOB_of_father")));
				employVO.setMotherDOB(HelperClass.convertDatabaseToUI(rs
						.getString("DOB_mother")));
				if (rs.getString("DOM") != null) {
					employVO.setDateOfMariage(HelperClass
							.convertDatabaseToUI(rs.getString("DOM")));
				} else {
					employVO.setDateOfMariage("");
				}
				employVO.setSpouseName(rs.getString("Spouse_Name"));
				if (rs.getString("DOB_Spouse") != null) {
					employVO.setSpouseDOB(HelperClass.convertDatabaseToUI(rs
							.getString("DOB_Spouse")));
				} else {
					employVO.setSpouseDOB("");
				}
				employVO.setFirstChildName(rs.getString("Child_1"));
				if (rs.getString("DOB_Child_1") != null) {
					employVO.setFirstChildDOB(HelperClass
							.convertDatabaseToUI(rs.getString("DOB_Child_1")));
				} else {
					employVO.setFirstChildDOB("");
				}
				employVO.setSecondChildName(rs.getString("Child_2"));
				if (rs.getString("DOB_Child_2") != null) {
					employVO.setSecondChildDOB(HelperClass
							.convertDatabaseToUI(rs.getString("DOB_Child_2")));
				} else {
					employVO.setSecondChildDOB("");
				}
				employVO.setFamilyPhoneNo(rs.getString("Family_phone_no"));
				splitEmpDetails.add(employVO);
				allDetails.put("Family Details", splitEmpDetails);

				
				if (rs.getString("Passport_Expir_date") != null) {
					employVO.setPassportExpiryDate(HelperClass
							.convertDatabaseToUI(rs
									.getString("Passport_Expir_date")));
				} else {
					employVO.setPassportExpiryDate("");
				}
				employVO.setPassportNo(rs.getString("Passport_No"));
				if (rs.getString("Passport__Issued_Date") != null) {
					employVO.setPassportIssueDate(HelperClass
							.convertDatabaseToUI(rs
									.getString("Passport__Issued_Date")));
				} else {
					employVO.setPassportIssueDate("");
				}
				employVO.setPassportIssuePlace(rs
						.getString("Passport_Issued_Place"));
				splitEmpDetails.add(employVO);
				allDetails.put("Passport Details", splitEmpDetails);
				
				
				employVO.setHdfcAccountNo(rs.getString("HDFC_AC"));
				employVO.setBankBranchName(rs.getString("Branch_Name"));
				employVO.setBankName(rs
						.getString("Bank_Name"));
				employVO.setBankIfscCode(rs
						.getString("IFSC_Code"));
				splitEmpDetails.add(employVO);
				allDetails.put("Bank Details", splitEmpDetails);
				
				employVO.setMajorQualification(rs
						.getString("Major_Qualification"));
				employVO.setUniversityOrBoard(rs.getString("University_Board"));
				employVO.setYearOfPassing(rs.getString("Year_of_passing"));
				employVO.setCollegeOrInstituteName(rs
						.getString("College_Institute"));
				splitEmpDetails.add(employVO);
				allDetails.put("Educational Details", splitEmpDetails);

				employVO.setPreviousCompanyName(rs
						.getString("Previous_Company"));
				employVO.setLastCompanyDesignation(rs
						.getString("Designation_in_the_last_company"));
				employVO.setLastDrawnSalaryInRS(rs
						.getString("Last_Drawn_Salary"));
				employVO.setTotalExperience(rs
						.getString("Total_experience_before"));
				splitEmpDetails.add(employVO);
				allDetails.put("Previous Company Details", splitEmpDetails);

				
				
				
				
				

				/*
				 * employVO.setSecurityDocument(rs.getString("Security_doc"));
				 * employVO.setRemarks(rs.getString("Remarks"));
				 * employVO.setUserCode(rs.getString("userCode"));
				 * employVO.setManagerCode(rs.getString("ManagerCode"));
				 * employVO.setSunday(rs.getBoolean("SUNDAY"));
				 * employVO.setMonday(rs.getBoolean("MONDAY"));
				 * employVO.setTuesday(rs.getBoolean("TUESDAY"));
				 * employVO.setWednesday(rs.getBoolean("WEDNESDAY"));
				 * employVO.setThrusday(rs.getBoolean("THURSDAY"));
				 * employVO.setFriday(rs.getBoolean("FRIDAY"));
				 * employVO.setSaturday(rs.getBoolean("SATURDAY"));
				 */

			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsDaoImpl : getEmployeePersonalDetails Ending");
		return allDetails;
	}

	public String checkDuplicatePersonalEmailId(String emailId, String empId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsDaoImpl: checkDuplicatePersonalEmailId Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String message = "";
		try {

			connection = getConnection();
			pstmt = connection
					.prepareStatement(Employee.CHECK_DUPLICATE_PERSONAL_EMAILID);
			pstmt.setString(1, emailId);
			pstmt.setString(2, empId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) > 0) {
					message = Employee.PERSONAL_EMAIL_EXIST;
				}
			}
		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			sqle.printStackTrace();

		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);
			e1.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (connection != null && !connection.isClosed()) {
					connection.close();
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
				+ " Control in EmployeePersonalDetailsDaoImpl: checkDuplicatePersonalEmailId Ending");
		return message;
	}

	@Override
	public String UpdateEmployeeDetails(EmployeePersonalDetailsForm voObj) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsDaoImpl: UpdateEmployeeDetails Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		String empStatus = "NOT_SAVED";
		try {
			connection = getConnection();
			String empImage = uploadImage(voObj.getEmpImage(),
					voObj.getServerPath(), voObj.getEmpCode(), "emp");
			Map<String, String> imageMap = getImagePath(voObj.getEmpCode(),
					connection);

			if (voObj.getEmpImage().getFileSize() > 0) {
				empImage = uploadImage(voObj.getEmpImage(),
						voObj.getServerPath(), voObj.getEmpCode(), "emp");
			} else {
				empImage = imageMap.get("EmpImg");
			}

			pstmt = connection
					.prepareStatement(Employee.UPDATE_EMPLOYEEPERSONAL_DETAILS);

			pstmt.setString(1, voObj.getEmpFirstName().trim());
			pstmt.setString(2, HelperClass.convertUIToDatabase(voObj.getEmployeeDob()));
			pstmt.setString(3, voObj.getMobileNo().trim());
			pstmt.setString(4, voObj.getPersonalEmailId().trim());
			if (voObj.getMaritalStatus() == null) {
				pstmt.setString(5, "Married");
			} else {
				pstmt.setString(5, voObj.getMaritalStatus());
			}

			pstmt.setString(6, voObj.getPresentAddress().trim());
			pstmt.setString(7, voObj.getFatherName());
			pstmt.setString(8,
					HelperClass.convertUIToDatabase(voObj.getFatherDOB()));
			pstmt.setString(9, voObj.getMotherName());
			pstmt.setString(10,
					HelperClass.convertUIToDatabase(voObj.getMotherDOB()));
			pstmt.setString(11, voObj.getFamilyPhoneNo());

			if (voObj.getDateOfMariage() != null) {

				pstmt.setString(12, HelperClass.convertUIToDatabase(voObj
						.getDateOfMariage()));
			} else {
				pstmt.setString(12, "");
			}

			pstmt.setString(13, voObj.getSpouseName());
			if (voObj.getSpouseDOB() != null) {

				pstmt.setString(14,
						HelperClass.convertUIToDatabase(voObj.getSpouseDOB()));
			} else {
				pstmt.setString(14, "");
			}

			pstmt.setString(15, voObj.getFirstChildName());
			if (voObj.getFirstChildDOB() != null) {

				pstmt.setString(16, HelperClass.convertUIToDatabase(voObj
						.getFirstChildDOB()));
			} else {
				pstmt.setString(16, "");
			}

			pstmt.setString(17, voObj.getSecondChildName());

			if (voObj.getSecondChildDOB() != null) {

				pstmt.setString(18, HelperClass.convertUIToDatabase(voObj
						.getSecondChildDOB()));
			} else {
				pstmt.setString(18, "");
			}

			if (voObj.getPassportExpiryDate() != null) {

				pstmt.setString(19, HelperClass.convertUIToDatabase(voObj
						.getPassportExpiryDate()));
			} else {
				pstmt.setString(19, "");
			}

			if (voObj.getPassportIssueDate() != null) {

				pstmt.setString(20, HelperClass.convertUIToDatabase(voObj
						.getPassportIssueDate()));
			} else {
				pstmt.setString(20, "");
			}
			pstmt.setString(21, voObj.getPassportIssuePlace());
			pstmt.setString(22, voObj.getPreviousCompanyName());
			pstmt.setString(23, voObj.getLastCompanyDesignation());
			pstmt.setString(24, voObj.getUniversityOrBoard());
			pstmt.setString(25, voObj.getCollegeOrInstituteName());
			pstmt.setString(26, empImage);
			pstmt.setString(27, voObj.getEmpCode());

			int i = pstmt.executeUpdate();
			System.out.println("update"+pstmt);
			if (i > 0) {
				empStatus = "SAVED";
			} else {
				empStatus = "NOT_SAVED";
			}
		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			sqle.printStackTrace();
		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);
			e1.printStackTrace();
		} finally {
			try {

				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
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
				+ " Control in EmployeePersonalDetailsDaoImpl: UpdateEmployeeDetails Ending");
		return empStatus;
	}

	public String uploadImage(FormFile formFile, String serverPath,
			String employee_Id, String category) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsDaoImpl: uploadImage Starting");

		String imagePath = "UploadedImage/Employee/" + category + "_image"
				+ employee_Id + ".jpg";
		try {
			String filePath = serverPath + "UploadedImage/Employee/" + category
					+ "_image" + employee_Id + ".jpg";
			if (formFile.getFileSize() > 0) {
				byte[] btDataFile = formFile.getFileData();
				File of = new File(filePath);
				FileOutputStream osf = new FileOutputStream(of);
				osf.write(btDataFile);
				osf.flush();
			} else {
				imagePath = "";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsDaoImpl : uploadImage Ending");
		return imagePath;
	}

	public Map<String, String> getImagePath(String empCode,
			Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsDaoImpl : getImagePath Starting");

		PreparedStatement pstmt = null;

		ResultSet rs = null;
		Map<String, String> empImageMap = new HashMap<String, String>();
		try {

			pstmt = connection.prepareStatement(Employee.GET_IMAGE_PATH);
			pstmt.setString(1, empCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				empImageMap.put("EmpImg", rs.getString("Employee_image"));
			}

		} catch (SQLException sqle) {
			logger.error(sqle.getMessage(), sqle);
			sqle.printStackTrace();
		} catch (Exception e1) {
			logger.error(e1.getMessage(), e1);
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException sqle) {
				logger.error(sqle.getMessage(), sqle);
				sqle.printStackTrace();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			}
		}
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeePersonalDetailsDaoImpl : getImagePath Ending");
		return empImageMap;
	}
}