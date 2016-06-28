package com.centris.DAO.DAOIMPL;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Message;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;

import com.centris.DAO.DBService;
import com.centris.DAO.EmployeeDAO;
import com.centris.VO.CheckEmployeeDeletionVO;
import com.centris.VO.EmployVO;
import com.centris.VO.EmployeeAmmendmentVO;
import com.centris.VO.EmployeeDeleteAuditVo;
import com.centris.VO.UsermanagementEmployeeVo;
import com.centris.form.EmployeeForm;
import com.centris.util.EmailContent;
import com.centris.util.HelperClass;
import com.centris.util.SendMailWithMultipleAttachment;
import com.centris.util.Helper.JDate;
import com.centris.util.Helper.JLogger;
import com.centris.util.SQLUtils.Employee;
import com.centris.util.constants.MessageConstants;

public class EmployeeDAOImpl extends DBService implements EmployeeDAO {

	private static Logger logger = Logger.getLogger(EmployeeDAOImpl.class);

	@Override
	public String registerEmployee(EmployeeForm employeeForm) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: registerEmployee Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		String empStatus = "NOT_SAVED";
		String empdoc1 = "";
		String empdoc2 = "";
		String empdoc3 = "";
		String empdoc4 = "";
		String file1 = "";
		String file2 = "";
		String file3 = "";
		String file4 = "";
		String file5 = "";
		try {
			connection = getConnection();
			String empEntry = checkDuplicateEntryForEmp(employeeForm,
					connection);

			if ("NOT_EXIST".equals(empEntry)) {
				String securityDocument = uploadImage(
						employeeForm.getSecurityDocument(),
						employeeForm.getServerPath(),
						employeeForm.getEmpCode(), "security");
				String empImage = uploadImage(employeeForm.getEmpImage(),
						employeeForm.getServerPath(),
						employeeForm.getEmpCode(), "emp");
				if (employeeForm.getDocument1().getFileSize() > 0) {
					empdoc1 = uploadDocument(employeeForm.getDocument1(),
							employeeForm.getServerPath(),
							employeeForm.getEmpCode());
				}
				if (employeeForm.getDocument2().getFileSize() > 0) {
					empdoc2 = uploadDocument(employeeForm.getDocument2(),
							employeeForm.getServerPath(),
							employeeForm.getEmpCode());
				}
				if (employeeForm.getDocument3().getFileSize() > 0) {
					empdoc3 = uploadDocument(employeeForm.getDocument3(),
							employeeForm.getServerPath(),
							employeeForm.getEmpCode());
				}
				if (employeeForm.getDocument4().getFileSize() > 0) {
					empdoc4 = uploadDocument(employeeForm.getDocument4(),
							employeeForm.getServerPath(),
							employeeForm.getEmpCode());
				}
				if(employeeForm.getTestFile1()!=null){
				if(employeeForm.getTestFile1().getFileSize()>0){
					file1=uploadFile(employeeForm.getTestFile1(),
							employeeForm.getServerPath(),
							employeeForm.getEmpCode(),"File1");
				}
				}
				if(employeeForm.getTestFile2()!=null){
				if(employeeForm.getTestFile2().getFileSize()>0){
					file2=uploadFile(employeeForm.getTestFile2(),
							employeeForm.getServerPath(),
							employeeForm.getEmpCode(),"File2");
				}
				}
				
				if(employeeForm.getTestFile3()!=null){
				if(employeeForm.getTestFile3().getFileSize()>0){
					file3=uploadFile(employeeForm.getTestFile3(),
							employeeForm.getServerPath(),
							employeeForm.getEmpCode(),"File3");
				}
				}
				if(employeeForm.getTestFile4()!=null){
				if(employeeForm.getTestFile4().getFileSize()>0){
					file4=uploadFile(employeeForm.getTestFile4(),
							employeeForm.getServerPath(),
							employeeForm.getEmpCode(),"File4");
				}
				}
				if(employeeForm.getTestFile5()!=null){
				if(employeeForm.getTestFile5().getFileSize()>0){
					file5=uploadFile(employeeForm.getTestFile5(),
							employeeForm.getServerPath(),
							employeeForm.getEmpCode(),"File5");
				}
				}

				pstmt = connection.prepareStatement(Employee.REGISTER_EMPLOYEE);
				pstmt.setString(1, employeeForm.getEmpCode().trim());
				pstmt.setString(2, employeeForm.getEmpStatus().trim());
				pstmt.setString(3, employeeForm.getEmpFirstName().trim());
				pstmt.setString(4, employeeForm.getHdfcAccountNo().trim());
				pstmt.setString(5, HelperClass.convertUIToDatabase(employeeForm
						.getDateOfBirth().trim()));
				pstmt.setString(6, employeeForm.getGender());
				pstmt.setString(7, employeeForm.getAddharCardNo());
				pstmt.setString(8, employeeForm.getPassportNo().trim());
				pstmt.setString(9, employeeForm.getDrivingLicenceNo());
				pstmt.setString(10, employeeForm.getVoterIdNo());

				pstmt.setString(11, employeeForm.getBloodGroup().trim());
				pstmt.setString(12, employeeForm.getPanCardNo());
				pstmt.setString(13, HelperClass
						.convertUIToDatabase(employeeForm
								.getPassportIssueDate()));
				pstmt.setString(14, employeeForm.getPassportIssuePlace().trim());
				pstmt.setString(15, employeeForm.getPresentAddress().trim());
				pstmt.setString(16, employeeForm.getMobileNo().trim());
				pstmt.setString(17, employeeForm.getPersonalEmailId().trim());
				pstmt.setString(18, employeeForm.getOfficialEmailId().trim());
				pstmt.setString(19, employeeForm.getPermanentAddress().trim());
				pstmt.setString(20, employeeForm.getMajorQualification().trim());

				pstmt.setString(21, employeeForm.getUniversityOrBoard().trim());
				pstmt.setString(22, employeeForm.getYearOfPassing().trim());
				pstmt.setString(23, employeeForm.getCollegeOrInstituteName().trim());
				pstmt.setString(24, employeeForm.getPreviousCompanyName().trim());
				pstmt.setString(25, employeeForm.getLastCompanyDesignation().trim());
				pstmt.setString(26, HelperClass
						.convertUIToDatabase(employeeForm.getDateOfJoining()));
				pstmt.setString(27, employeeForm.getBaseLocation().trim());
				pstmt.setString(28, employeeForm.getLastDrawnSalaryInRS());
				pstmt.setString(29, employeeForm.getTotalExperience().trim());
				pstmt.setString(30, employeeForm.getFatherName().trim());

				pstmt.setString(31, HelperClass
						.convertUIToDatabase(employeeForm.getFatherDOB()));
				pstmt.setString(32, employeeForm.getMotherName().trim());
				pstmt.setString(33, HelperClass
						.convertUIToDatabase(employeeForm.getMotherDOB()));
				pstmt.setString(34, employeeForm.getMaritalStatus().trim());
				pstmt.setString(35, HelperClass
						.convertUIToDatabase(employeeForm.getDateOfMariage()));
				pstmt.setString(36, employeeForm.getSpouseName().trim());
				pstmt.setString(37, HelperClass
						.convertUIToDatabase(employeeForm.getSpouseDOB()));
				pstmt.setString(38, employeeForm.getFirstChildName().trim());
				pstmt.setString(39, employeeForm.getSecondChildName().trim());
				pstmt.setString(40, employeeForm.getFamilyPhoneNo().trim());

				pstmt.setString(41, HelperClass
						.convertUIToDatabase(employeeForm.getFirstChildDOB()));
				pstmt.setString(42, HelperClass
						.convertUIToDatabase(employeeForm.getSecondChildDOB()));
				pstmt.setString(43, securityDocument);
				pstmt.setString(44, employeeForm.getSalaryOffered());
				if ("Present".equals(employeeForm.getEmpStatus()))
					pstmt.setString(45, Employee.ACTIVE);
				else
					pstmt.setString(45, Employee.NOT_ACTIVE);
				pstmt.setString(46, HelperClass
						.convertUIToDatabase(employeeForm.getDateOfLeaving()));
				pstmt.setString(47, employeeForm.getRemarks());
				pstmt.setString(48, employeeForm.getManagerCode());
				pstmt.setString(49, employeeForm.getUserCode());
				pstmt.setString(50, employeeForm.getDesignation());
				pstmt.setString(51, employeeForm.getDepartment());
				pstmt.setTimestamp(52, HelperClass.getCurrentTimestamp());
				pstmt.setString(53, employeeForm.getUserCode());
				pstmt.setString(54, empImage);
				pstmt.setString(55, HelperClass
						.convertUIToDatabase(employeeForm
								.getPassportExpiryDate()));
				pstmt.setString(56, employeeForm.getProject());
				pstmt.setString(57, employeeForm.getEmpType());
				pstmt.setString(58, empdoc1);
				pstmt.setString(59, empdoc2);
				pstmt.setString(60, empdoc3);
				pstmt.setString(61, empdoc4);

				pstmt.setString(62, employeeForm.getBankName().trim());
				pstmt.setString(63, employeeForm.getBankBranchName().trim());
				pstmt.setString(64, employeeForm.getBankIfscCode().trim());
				pstmt.setString(65, employeeForm.getProjectHead());
				pstmt.setString(66, employeeForm.getSecondreportingSupervisor());
				if (employeeForm.getBiometricId().isEmpty()) {
					pstmt.setString(67, "0");
				} else {
					pstmt.setString(67, employeeForm.getBiometricId());
				}
				
				pstmt.setString(68, file1);
				pstmt.setString(69, file2);
				pstmt.setString(70, file3);
				pstmt.setString(71, file4);
				pstmt.setString(72, file5);

				int i = pstmt.executeUpdate();
				if (i > 0) {
					empStatus = "SAVED";
				} else {
					empStatus = "NOT_SAVED";
				}
				if ("SAVED".equals(empStatus)) {
					/*empStatus = insertWeekOffDetails(employeeForm, connection);*/
					if (!"Left".equals(employeeForm.getEmpStatus()))
						empStatus = insertUsernamePassword(employeeForm,
								connection);
				}

			} else {
				empStatus = empEntry;
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

				if (connection != null && (!connection.isClosed())) {
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
				+ " Control in EmployeeDAOImpl: registerEmployee Ending");
		return empStatus;
	}

	public String checkDuplicateEntryForEmp(EmployeeForm employeeForm,
			Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: checkDuplicateEntryForEmp Starting");

		PreparedStatement pstmt = null;
		String empStatus = "NOT_EXIST";
		try {

			pstmt = connection.prepareStatement(Employee.CHECK_DUPLICATE_ENTRY);

			pstmt.setString(1, employeeForm.getEmpFirstName());
			pstmt.setString(2, HelperClass.convertUIToDatabase(employeeForm
					.getDateOfBirth()));
			pstmt.setString(3, employeeForm.getMobileNo());
			pstmt.setString(4, employeeForm.getBiometricId());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) > 0) {
					empStatus = "EXIST";
				}
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
				+ " Control in EmployeeDAOImpl: checkDuplicateEntryForEmp Ending");
		return empStatus;
	}

	public String uploadImage(FormFile formFile, String serverPath,
			String employee_Id, String category) {
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
		return imagePath;
	}

	public String uploadDocument(FormFile formFile, String serverPath,
			String employee_Id) {
		String documentPath = "UploadedImage/Employee/Doc_" + employee_Id
				+ "__" + formFile.getFileName();
		try {
			String filePath = serverPath + "UploadedImage/Employee/Doc_"
					+ employee_Id + "__" + formFile.getFileName();
			if (formFile.getFileSize() > 0) {
				byte[] btDataFile = formFile.getFileData();
				File of = new File(filePath);
				FileOutputStream osf = new FileOutputStream(of);
				osf.write(btDataFile);
				osf.flush();
			} else {
				documentPath = "";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return documentPath;
	}
	
	public String uploadFile(FormFile formFile, String serverPath,
			String employee_Id,String filecustumName) {
	
		
		 String extension = "";

		 int i = formFile.getFileName().lastIndexOf('.');
		 if (i >= 0) {
		     extension = formFile.getFileName().substring(i+1);
		 }
		 
		String documentPath = "UploadedImage/Employee/Doc__" + employee_Id
				+ "_" + filecustumName+"."+extension;
		try {
			String filePath = serverPath + "UploadedImage/Employee/Doc__"
					+ employee_Id + "_" + filecustumName+"."+extension;
			if (formFile.getFileSize() > 0) {
				byte[] btDataFile = formFile.getFileData();
				File of = new File(filePath);
				FileOutputStream osf = new FileOutputStream(of);
				osf.write(btDataFile);
				osf.flush();
			} else {
				documentPath = "";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return documentPath;
	}

	@Override
	public String amendEmployee(EmployeeForm employeeForm) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: amendEmployee Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		String empStatus = "NOT_SAVED";
		String securityDocument = "";
		String empImage = "";
		String empdoc1 = "";
		String empdoc2 = "";
		String empdoc3 = "";
		String empdoc4 = "";
		String file1 = "";
		String file2 = "";
		String file3 = "";
		String file4 = "";
		String file5 = "";
		
		
		try {
			connection = getConnection();

			Map<String, String> imageMap = getImagePath(
					employeeForm.getEmpCode(), connection);
			if (employeeForm.getSecurityDocument().getFileSize() > 0) {
				
				securityDocument = uploadImage(employeeForm.getSecurityDocument(),employeeForm.getServerPath(),employeeForm.getEmpCode(),"security");
			} else {
			
				securityDocument = imageMap.get("SecurityImg");
				
			}
			if (employeeForm.getEmpImage().getFileSize() > 0) {
				empImage = uploadImage(employeeForm.getEmpImage(),
						employeeForm.getServerPath(),
						employeeForm.getEmpCode(), "emp");
			} else {
				empImage = imageMap.get("EmpImg");
			}

			if (employeeForm.getDocument1().getFileSize() > 0) {
				empdoc1 = uploadDocument(employeeForm.getDocument1(),
						employeeForm.getServerPath(), employeeForm.getEmpCode());
			} else if (employeeForm.getHdoc1() == null
					|| "".equals(employeeForm.getHdoc1())) {
				empdoc1 = "";
			} else {
				empdoc1 = imageMap.get("EmpDoc1");
			}
			if (employeeForm.getDocument2().getFileSize() > 0) {
				empdoc2 = uploadDocument(employeeForm.getDocument2(),
						employeeForm.getServerPath(), employeeForm.getEmpCode());
			} else if (employeeForm.getHdoc2() == null
					|| "".equals(employeeForm.getHdoc2())) {
				empdoc2 = "";
			} else {
				empdoc2 = imageMap.get("EmpDoc2");
			}
			if (employeeForm.getDocument3().getFileSize() > 0) {
				empdoc3 = uploadDocument(employeeForm.getDocument3(),
						employeeForm.getServerPath(), employeeForm.getEmpCode());
			} else if (employeeForm.getHdoc3() == null
					|| "".equals(employeeForm.getHdoc3())) {
				empdoc3 = "";
			} else {
				empdoc3 = imageMap.get("EmpDoc3");
			}
			if (employeeForm.getDocument4().getFileSize() > 0) {
				empdoc4 = uploadDocument(employeeForm.getDocument4(),
						employeeForm.getServerPath(), employeeForm.getEmpCode());
			} else if (employeeForm.getHdoc4() == null
					|| "".equals(employeeForm.getHdoc4())) {
				empdoc4 = "";
			} else {
				empdoc4 = imageMap.get("EmpDoc4");
			}
			
			if (employeeForm.getTestFile1().getFileSize() > 0) {
				file1 = uploadFile(employeeForm.getTestFile1(),
						employeeForm.getServerPath(), employeeForm.getEmpCode(),"File1");
			} else if (employeeForm.getHfile1() == null
					|| "".equals(employeeForm.getHfile1())) {
				file1 = "";
			} else {
				file1 = imageMap.get("File1");
			}
			
			if (employeeForm.getTestFile2().getFileSize() > 0) {
				file2 = uploadFile(employeeForm.getTestFile2(),
						employeeForm.getServerPath(), employeeForm.getEmpCode(),"File2");
			} else if (employeeForm.getHfile2() == null
					|| "".equals(employeeForm.getHfile2())) {
				file2 = "";
			} else {
				file2 = imageMap.get("File2");
			}
			
			
			if (employeeForm.getTestFile3().getFileSize() > 0) {
				file3 = uploadFile(employeeForm.getTestFile3(),
						employeeForm.getServerPath(), employeeForm.getEmpCode(),"File3");
			} else if (employeeForm.getHfile3() == null
					|| "".equals(employeeForm.getHfile3())) {
				file3 = "";
			} else {
				file3 = imageMap.get("File3");
			}
			
			if (employeeForm.getTestFile4().getFileSize() > 0) {
				file4 = uploadFile(employeeForm.getTestFile4(),
						employeeForm.getServerPath(), employeeForm.getEmpCode(),"File4");
			} else if (employeeForm.getHfile4() == null
					|| "".equals(employeeForm.getHfile4())) {
				file4 = "";
			} else {
				file4 = imageMap.get("File4");
			}
			
			if (employeeForm.getTestFile5().getFileSize() > 0) {
				file5 = uploadFile(employeeForm.getTestFile5(),
						employeeForm.getServerPath(), employeeForm.getEmpCode(),"File5");
			} else if (employeeForm.getHfile5() == null
					|| "".equals(employeeForm.getHfile5())) {
				file5 = "";
			} else {
				file5 = imageMap.get("File5");
			}

			String mailStatus = checkOfficialEmailId(
					employeeForm.getOfficialEmailId(),
					employeeForm.getEmpCode(), connection);

			pstmt = connection.prepareStatement(Employee.UPDATE_EMPLOYEE);

			pstmt.setString(1, employeeForm.getEmpStatus().trim());
			pstmt.setString(2, employeeForm.getEmpFirstName().trim());
			pstmt.setString(3, employeeForm.getHdfcAccountNo().trim());
			pstmt.setString(4, HelperClass.convertUIToDatabase(employeeForm
					.getDateOfBirth()));
			pstmt.setString(5, employeeForm.getGender().trim());
			pstmt.setString(6, employeeForm.getAddharCardNo().trim());
			pstmt.setString(7, employeeForm.getPassportNo().trim());
			pstmt.setString(8, employeeForm.getDrivingLicenceNo().trim());
			pstmt.setString(9, employeeForm.getVoterIdNo().trim());

			pstmt.setString(10, employeeForm.getBloodGroup());
			pstmt.setString(11, employeeForm.getPanCardNo());
			pstmt.setString(12, HelperClass.convertUIToDatabase(employeeForm
					.getPassportIssueDate()));
			pstmt.setString(13, employeeForm.getPassportIssuePlace());
			pstmt.setString(14, employeeForm.getPresentAddress().trim());
			pstmt.setString(15, employeeForm.getMobileNo().trim());
			pstmt.setString(16, employeeForm.getPersonalEmailId());
			pstmt.setString(17, employeeForm.getOfficialEmailId().trim());
			pstmt.setString(18, employeeForm.getPermanentAddress());
			pstmt.setString(19, employeeForm.getMajorQualification().trim());

			pstmt.setString(20, employeeForm.getUniversityOrBoard().trim());
			pstmt.setString(21, employeeForm.getYearOfPassing().trim());
			pstmt.setString(22, employeeForm.getCollegeOrInstituteName().trim());
			pstmt.setString(23, employeeForm.getPreviousCompanyName().trim());
			pstmt.setString(24, employeeForm.getLastCompanyDesignation());
			pstmt.setString(25, HelperClass.convertUIToDatabase(employeeForm
					.getDateOfJoining()));
			pstmt.setString(26, employeeForm.getBaseLocation());
			pstmt.setString(27, employeeForm.getLastDrawnSalaryInRS().trim());
			pstmt.setString(28, employeeForm.getTotalExperience().trim());
			pstmt.setString(29, employeeForm.getFatherName().trim());

			pstmt.setString(30, HelperClass.convertUIToDatabase(employeeForm
					.getFatherDOB()));
			pstmt.setString(31, employeeForm.getMotherName());
			pstmt.setString(32, HelperClass.convertUIToDatabase(employeeForm
					.getMotherDOB()));
			pstmt.setString(33, employeeForm.getMaritalStatus());
			pstmt.setString(34, HelperClass.convertUIToDatabase(employeeForm
					.getDateOfMariage()));
			pstmt.setString(35, employeeForm.getSpouseName());
			pstmt.setString(36, HelperClass.convertUIToDatabase(employeeForm
					.getSpouseDOB()));
			pstmt.setString(37, employeeForm.getFirstChildName().trim());
			pstmt.setString(38, employeeForm.getSecondChildName().trim());
			pstmt.setString(39, employeeForm.getFamilyPhoneNo().trim());

			pstmt.setString(40, HelperClass.convertUIToDatabase(employeeForm
					.getFirstChildDOB()));
			pstmt.setString(41, HelperClass.convertUIToDatabase(employeeForm
					.getSecondChildDOB()));
			pstmt.setString(42, securityDocument);
			pstmt.setString(43, employeeForm.getSalaryOffered());
			if ("Present".equals(employeeForm.getEmpStatus())) {
				pstmt.setString(44, Employee.ACTIVE);
			} else {
				pstmt.setString(44, Employee.NOT_ACTIVE);
			}
			pstmt.setString(45, HelperClass.convertUIToDatabase(employeeForm
					.getDateOfLeaving()));
			pstmt.setString(46, employeeForm.getRemarks().trim());
			pstmt.setString(47, employeeForm.getManagerCode());
			pstmt.setString(48, employeeForm.getUserCode());
			pstmt.setString(49, employeeForm.getDesignation().trim());
			pstmt.setString(50, employeeForm.getDepartment());
			pstmt.setTimestamp(51, HelperClass.getCurrentTimestamp());
			pstmt.setString(52, employeeForm.getUserCode());
			pstmt.setString(53, empImage);
			pstmt.setString(54, HelperClass.convertUIToDatabase(employeeForm
					.getPassportExpiryDate()));
			pstmt.setString(55, employeeForm.getProject());
			pstmt.setString(56, employeeForm.getEmpType());
			pstmt.setString(57, empdoc1);
			pstmt.setString(58, empdoc2);
			pstmt.setString(59, empdoc3);
			pstmt.setString(60, empdoc4);

			pstmt.setString(61, employeeForm.getBankName().trim());
			pstmt.setString(62, employeeForm.getBankBranchName().trim());
			pstmt.setString(63, employeeForm.getBankIfscCode().trim());
			pstmt.setString(64, employeeForm.getProjectHead());
			pstmt.setString(65, employeeForm.getSecondreportingSupervisor());
			
			if (employeeForm.getBiometricId().isEmpty()) {
				pstmt.setString(66, "0");
			} else {
				pstmt.setString(66, employeeForm.getBiometricId());
			}
			pstmt.setString(67, file1);
			pstmt.setString(68, file2);
			pstmt.setString(69, file3);
			pstmt.setString(70, file4);
			pstmt.setString(71, file5);
			pstmt.setString(72, employeeForm.getEmpCode());
			

			int i = pstmt.executeUpdate();
			
			
			if (i > 0) {
				empStatus = "SAVED";
			} else {
				empStatus = "NOT_SAVED";
			}
			EmployeeAmmendmentVO employeeAmmendmentVO=new EmployeeAmmendmentVO();
			if ("SAVED".equals(empStatus)) {
				
			if (!"EXIST".equals(mailStatus)){
					
				empStatus = updateUsernamePassword(employeeForm, connection);
			         if("SAVED".equalsIgnoreCase(empStatus)){
			        	
			        	 employeeAmmendmentVO=updateManagerUsernameEmailId(employeeForm,connection);  
			        	 String mangpassword=employeeAmmendmentVO.getMangpassword();
			           	  if("SAVED".equalsIgnoreCase(employeeAmmendmentVO.getStatus())){
			           	
			           		  employeeAmmendmentVO=updateDirectorUsernameEmailId(employeeForm,connection);
			           		  String direpassword=employeeAmmendmentVO.getDirepassword();
			           		   if("SAVED".equalsIgnoreCase(employeeAmmendmentVO.getStatus())){
			           		
			           			   employeeAmmendmentVO=updateAdminUsernameEmailId(employeeForm,connection);
			           		      if("SAVED".equalsIgnoreCase(employeeAmmendmentVO.getStatus())){
			           		    	   
			           		    	  empStatus = "SAVED";
			           				           		    	
			           		    	employeeAmmendmentVO.setEmppassword(getEmployeePassword(employeeForm.getEmpFirstName(),	employeeForm.getDateOfBirth()));
			           		    	employeeAmmendmentVO.setOfficialEmailId(employeeForm.getOfficialEmailId());
			           		    	employeeAmmendmentVO.setEmpfirstname(employeeForm.getEmpFirstName());	
			           		    	employeeAmmendmentVO.setMangpassword(mangpassword);
			           		    	employeeAmmendmentVO.setDirepassword(direpassword);
			           		    	
			           		    	String status = sendEmpAnmmendmentEmailToEmployee(employeeAmmendmentVO,connection);
			           		    	   
			           		    	  if(status.equals("false")){
			           		    		
			           		    		empStatus =MessageConstants.MAIL_NOT_SENT;
			           		    	   }
			           		    	
			           		    
			           		      }else{
			           		    	  empStatus=MessageConstants.ADMIN_NOT_UPDATED;
			           		      }
			           			   
			           			   
			           		   }else{
			           			 empStatus=MessageConstants.DIRECTOR_NOT_UPDATED;
			           		   }  
			           	   		  
			           	   }else{
			           		     empStatus=MessageConstants.MANAGER_NOT_UPDATED;
			           	   }
			           	  
			           	  
			           	  
			          }
			
			    }
			
			
			
				if ("Left".equals(employeeForm.getEmpStatus())) {
					String deleted = deleteUsernamePassword(employeeForm,
							connection);
					System.out.println(deleted + " Online user Because left");
				}
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

				if (connection != null && (!connection.isClosed())) {
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
		
		
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.END_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: amendEmployee Ending");
		return empStatus;
	}

	

	@Override
	public List<EmployVO> searchEmployee(String empId) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: searchEmployee Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		EmployVO employVO = null;
		List<EmployVO> employVOList = new ArrayList<EmployVO>();
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(Employee.GET_EMPLOYEE_DETAILS);
			pstmt.setString(1, empId);
			
			rs = pstmt.executeQuery();
			
			

			while (rs.next()) {
				employVO = new EmployVO();

				employVO.setEmpCode(rs.getString("EMPID"));
				employVO.setEmpStatus(rs.getString("Employee_Status"));

				employVO.setEmpFirstName(rs.getString("First_Name"));
				employVO.setReportingSupervisor(rs.getString("ManagerCode"));
				employVO.setSecondreportingSupervisor(rs.getString("ReportingManager_2"));
				

				/* employVO.setProjectHead(rs.getString("")); */
				employVO.setProject(rs.getString("ProjectCode"));
				if (rs.getString("Passport_Expir_date") != null) {
					employVO.setPassportExpiryDate(HelperClass
							.convertDatabaseToUI(rs
									.getString("Passport_Expir_date")));
				} else {
					employVO.setPassportExpiryDate("");
				}
				employVO.setDateOfJoining(HelperClass.convertDatabaseToUI(rs
						.getString("DOJ")));
				employVO.setBaseLocation(rs.getString("BaseLocation"));
				employVO.setDesignation(rs.getString("DesignationCode"));
				employVO.setDepartment(rs.getString("DEPT_ID"));
				employVO.setGender(rs.getString("gender"));
				employVO.setBloodGroup(rs.getString("BloodGroup"));
				employVO.setDateOfBirth(HelperClass.convertDatabaseToUI(rs
						.getString("DOB")));
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
				if (rs.getString("DOL") != null) {
					employVO.setDateOfLeaving(HelperClass
							.convertDatabaseToUI(rs.getString("DOL")));
				} else {
					employVO.setDateOfLeaving("");
				}
				employVO.setHdfcAccountNo(rs.getString("HDFC_AC"));
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
				employVO.setPreviousCompanyName(rs
						.getString("Previous_Company"));
				employVO.setLastCompanyDesignation(rs
						.getString("Designation_in_the_last_company"));
				employVO.setLastDrawnSalaryInRS(rs
						.getString("Last_Drawn_Salary"));
				employVO.setTotalExperience(rs
						.getString("Total_experience_before"));
				employVO.setMajorQualification(rs
						.getString("Major_Qualification"));
				employVO.setUniversityOrBoard(rs.getString("University_Board"));
				employVO.setYearOfPassing(rs.getString("Year_of_passing"));
				employVO.setCollegeOrInstituteName(rs
						.getString("College_Institute"));
				employVO.setFatherName(rs.getString("Fathers_Name"));
				employVO.setFatherDOB(HelperClass.convertDatabaseToUI(rs
						.getString("DOB_of_father")));
				employVO.setMotherName(rs.getString("Mother_name"));
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

				employVO.setBankBranchName(rs.getString("Bank_Name"));
				employVO.setBankName(rs.getString("Bank_Name"));
				employVO.setBankIfscCode(rs.getString("IFSC_Code"));
				employVO.setProjectHead(rs.getString("ProjectHeadCode"));

				employVO.setBiometricId(rs.getString("bioid"));
				employVO.setFile1(rs.getString("File1"));
				employVO.setFile2(rs.getString("File2"));
				employVO.setFile3(rs.getString("File3"));
				employVO.setFile4(rs.getString("File4"));
				employVO.setFile5(rs.getString("File5"));

				employVOList.add(employVO);

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
				if (connection != null && (!connection.isClosed())) {
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
				+ " Control in EmployeeDAOImpl: searchEmployee Ending");

		return employVOList;
	}

	@Override
	public List<EmployVO> getEmpIdNameBySerachTerm(String maxRows, String name) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: getEmpIdNameBySerachTerm Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		EmployVO employVO = null;
		List<EmployVO> employVOList = new ArrayList<EmployVO>();
		try {
			connection = getConnection();
			pstmt = connection
					.prepareStatement(Employee.GET_EMPLOYEE_ID_NAME_BY_SEARCH_TERM);
			pstmt.setString(1, name + "%");
			pstmt.setInt(2, Integer.parseInt(maxRows));
			rs = pstmt.executeQuery();

			while (rs.next()) {
				employVO = new EmployVO();

				employVO.setEmpCode(rs.getString("EMPID"));
				employVO.setEmpFirstName(rs.getString("First_Name"));
				employVOList.add(employVO);
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

				if (connection != null && (!connection.isClosed())) {
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
				+ " Control in EmployeeDAOImpl: getEmpIdNameBySerachTerm Ending");

		return employVOList;
	}

	public String insertWeekOffDetails(EmployeeForm employeeForm,
			Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: insertWeekOffDetails Starting");

		PreparedStatement pstmt = null;
		String empStatus = "NOT_SAVED";
		try {

			pstmt = connection
					.prepareStatement(Employee.INSERT_WEEKOFF_DETAILS);
			pstmt.setString(1, employeeForm.getEmpCode());
			pstmt.setString(2, HelperClass.getCurrentYear());
			pstmt.setBoolean(3, employeeForm.isSunday());
			pstmt.setBoolean(4, employeeForm.isMonday());
			pstmt.setBoolean(5, employeeForm.isTuesday());
			pstmt.setBoolean(6, employeeForm.isWednesday());
			pstmt.setBoolean(7, employeeForm.isThrusday());
			pstmt.setBoolean(8, employeeForm.isFriday());
			pstmt.setBoolean(9, employeeForm.isSaturday());
			pstmt.setTimestamp(10, HelperClass.getCurrentTimestamp());
			pstmt.setString(11, employeeForm.getUserCode());
			pstmt.setString(12, employeeForm.getUserCode());
			pstmt.setTimestamp(13, HelperClass.getCurrentTimestamp());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				empStatus = "SAVED";
			} else {
				empStatus = "NOT_SAVED";
			}
			employeeForm.setSunday(false);
			employeeForm.setMonday(false);
			employeeForm.setTuesday(false);
			employeeForm.setWednesday(false);
			employeeForm.setThrusday(false);
			employeeForm.setFriday(false);
			employeeForm.setSaturday(false);
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
				+ " Control in EmployeeDAOImpl: insertWeekOffDetails Ending");
		return empStatus;
	}

	public String updateWeekOffDetails(EmployeeForm employeeForm,
			Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: updateWeekOffDetails Starting");

		PreparedStatement pstmt = null;
		String empStatus = "NOT_SAVED";
		try {

			pstmt = connection
					.prepareStatement(Employee.UPDATE_WEEKOFF_DETAILS);

			pstmt.setString(1, HelperClass.getCurrentYear());
			pstmt.setBoolean(2, employeeForm.isSunday());
			pstmt.setBoolean(3, employeeForm.isMonday());
			pstmt.setBoolean(4, employeeForm.isTuesday());
			pstmt.setBoolean(5, employeeForm.isWednesday());
			pstmt.setBoolean(6, employeeForm.isThrusday());
			pstmt.setBoolean(7, employeeForm.isFriday());
			pstmt.setBoolean(8, employeeForm.isSaturday());
			pstmt.setTimestamp(9, HelperClass.getCurrentTimestamp());
			pstmt.setString(10, employeeForm.getUserCode());
			pstmt.setString(11, employeeForm.getUserCode());
			pstmt.setTimestamp(12, HelperClass.getCurrentTimestamp());
			pstmt.setString(13, employeeForm.getEmpCode());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				empStatus = "SAVED";
			} else {
				empStatus = "NOT_SAVED";
			}
			employeeForm.setSunday(false);
			employeeForm.setMonday(false);
			employeeForm.setTuesday(false);
			employeeForm.setWednesday(false);
			employeeForm.setThrusday(false);
			employeeForm.setFriday(false);
			employeeForm.setSaturday(false);
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
				+ " Control in EmployeeDAOImpl: updateWeekOffDetails Ending");
		return empStatus;
	}

	public String insertUsernamePassword(EmployeeForm employeeForm,
			Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: insertUsernamePassword Starting");

		PreparedStatement pstmt = null;
		String empStatus = "NOT_SAVED";
		try {

			pstmt = connection.prepareStatement(Employee.INSERT_ONLINE_USER);
			pstmt.setString(1, employeeForm.getOfficialEmailId().trim());
			pstmt.setString(2,
					getEmployeePassword(employeeForm.getEmpFirstName(),
							employeeForm.getDateOfBirth()).toString());
			pstmt.setString(3, employeeForm.getEmpCode());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				empStatus = "SAVED";
				String url = getServerUrlFromBD(connection);
				String status = sendEmailToEmployee(
						employeeForm.getOfficialEmailId(),
						getEmployeePassword(employeeForm.getEmpFirstName(),
								employeeForm.getDateOfBirth()), url);

			} else {
				empStatus = "NOT_SAVED";
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
				+ " Control in EmployeeDAOImpl: insertUsernamePassword Ending");
		return empStatus;
	}

	public String updateUsernamePassword(EmployeeForm employeeForm,
			Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: insertUsernamePassword Starting");

		PreparedStatement pstmt = null;
		String empStatus = "NOT_SAVED";
		try {

			pstmt = connection.prepareStatement(Employee.UPDATE_ONLINE_USER);
			pstmt.setString(1, employeeForm.getOfficialEmailId().trim());
			pstmt.setString(
					2,
					getEmployeePassword(employeeForm.getEmpFirstName(),
							employeeForm.getDateOfBirth()).toString());
			pstmt.setString(3, employeeForm.getEmpCode());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				empStatus = "SAVED";
				
			} else {
				empStatus = insertUsernamePassword(employeeForm, connection);
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
				+ " Control in EmployeeDAOImpl: insertUsernamePassword Ending");
		return empStatus;
	}

	public String deleteUsernamePassword(EmployeeForm employeeForm,
			Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: deleteUsernamePassword Starting");

		PreparedStatement pstmt = null;
		String empStatus = "NOT_SAVED";
		try {

			pstmt = connection.prepareStatement(Employee.DELETE_ONLINE_USER);
			pstmt.setString(1, employeeForm.getOfficialEmailId().trim());
			pstmt.setString(2, employeeForm.getEmpCode());

			int i = pstmt.executeUpdate();
			if (i > 0) {
				empStatus = "DELETED";
			} else {
				empStatus = "NOT_DELETED";
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
				+ " Control in EmployeeDAOImpl: deleteUsernamePassword Ending");
		return empStatus;
	}

	public Map<String, String> getImagePath(String empCode,
			Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: getImagePath Starting");

		PreparedStatement pstmt = null;

		ResultSet rs = null;
		Map<String, String> empImageMap = new HashMap<String, String>();
		try {

			pstmt = connection.prepareStatement(Employee.GET_BOTH_IMAGE_PATH);
			pstmt.setString(1, empCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				empImageMap.put("SecurityImg", rs.getString("PanCard"));
				empImageMap.put("EmpImg", rs.getString("Employee_image"));
				empImageMap.put("EmpDoc1", rs.getString("ElectionId"));
				empImageMap.put("EmpDoc2", rs.getString("AdharCard"));
				empImageMap.put("EmpDoc3", rs.getString("DrivingLicence"));
				empImageMap.put("EmpDoc4", rs.getString("Others"));
				empImageMap.put("File1", rs.getString("File1"));
				empImageMap.put("File2", rs.getString("File2"));
				empImageMap.put("File3", rs.getString("File3"));
				empImageMap.put("File4", rs.getString("File4"));
				empImageMap.put("File5", rs.getString("File5"));
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
				+ " Control in EmployeeDAOImpl: getImagePath Ending");
		return empImageMap;
	}

	@Override
	public String checkDuplicateEmailId(String emailId, String empId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: checkDuplicateEmailId Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String message = "";
		try {

			connection = getConnection();
			pstmt = connection
					.prepareStatement(Employee.CHECK_DUPLICATE_EMAILID);
			pstmt.setString(1, emailId);
			pstmt.setString(2, empId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) > 0) {
					message = Employee.OFFICIAL_EMAIL_EXIST;
				}
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
				+ " Control in EmployeeDAOImpl: checkDuplicateEmailId Ending");
		return message;
	}

	public String sendEmailToEmployee(String emailId, String password,
			String url) {
		try {
			EmailContent em = new EmailContent();
			String[] mails = { emailId };

			em.setMailids(mails);
			em.setSubject("Registration Details");

			em.setMessage("Greetings from TeleIndia. \n"
					+ " You have successfully registered in Attendance portal. \n"
					+ "Please use the below credentials for marking the Attendance and other features.\n\n"
					+ "URL		: " + url + "\n" + "UserId		: " + emailId + "\n"
					+ "Password	: " + password + "\n\n");
			new SendMailWithMultipleAttachment().sendReportToMail(em);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return "sent";
	}

	/*
	 * public char[] createEmployeePassword(String firstName,String dob ) {
	 * char[] password=new char[20]; try{ String name=firstName.replaceAll(" ",
	 * ""); String dobirth=dob.replaceAll("-", "");
	 * password=(name+dobirth).toCharArray(); } catch(Exception e){
	 * logger.error(e.getMessage(), e); e.printStackTrace(); } return password;
	 * }
	 */

	public String getEmployeePassword(String firstName, String dob) {
		String password = "";
		try {
			String name = firstName.replaceAll(" ", "");
			String dobirth = dob.replaceAll("-", "");
			password = (name + dobirth).trim();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return password;
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

	public String checkOfficialEmailId(String emailId, String empId,
			Connection connection) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: checkOfficialEmailId Starting");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String message = "NOT_EXIST";
		try {

			pstmt = connection
					.prepareStatement(Employee.CHECK_OFFICIAL_EMAILID);
			pstmt.setString(1, emailId);
			pstmt.setString(2, empId);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) > 0) {
					message = "EXIST";
				}
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
				+ " Control in EmployeeDAOImpl: checkOfficialEmailId Ending");
		return message;
	}

	@Override
	public String checkPassportNoUnique(String PassportNo, String empId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: checkPassportNoUnique Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String message = "";
		try {

			connection = getConnection();
			pstmt = connection
					.prepareStatement(Employee.CHECK_DUPLICATE_PASSPORT);
			pstmt.setString(1, PassportNo);
			pstmt.setString(2, empId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) > 0) {
					message = Employee.PASSPORT_EXIST;
				}
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
				+ " Control in EmployeeDAOImpl: checkPassportNoUnique Ending");
		return message;
	}
	
	@Override
	public String checkAccountNoUnique(String AccountNo,String empId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeDAOImpl: checkAccountNoUnique Starting");
	
		PreparedStatement pstmt=null;
		Connection connection=null;
		ResultSet rs=null;
		String message="";
		try{
	
			connection=getConnection();
			pstmt=connection.prepareStatement(Employee.CHECK_DUPLICATE_ACCOUNT);
			pstmt.setString(1, AccountNo);
			//pstmt.setString(2, empId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)>0){
					message=Employee.ACCOUNT_NO_EXISTS;
				}
			}
			
		 } catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(),sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(),e1);
			}finally{
				try{
					if(pstmt!=null && !pstmt.isClosed()){
						pstmt.close();
					}
					if(connection!=null && !connection.isClosed()){
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
	logger.info(JDate.getTimeString(new Date())+ " Control in EmployeeDAOImpl: checkAccountNoUnique Ending");
		return message;
	}
	
	@Override
	public String checkVoterIdUnique(String voterId, String empId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: checkVoterIdUnique Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String message = "";
		try {

			connection = getConnection();
			pstmt = connection
					.prepareStatement(Employee.CHECK_DUPLICATE_VOTERID);
			pstmt.setString(1, voterId);
			pstmt.setString(2, empId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) > 0) {
					message = Employee.VOTER_ID_EXIST;
				}
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
				+ " Control in EmployeeDAOImpl: checkVoterIdUnique Ending");
		return message;
	}

	@Override
	public String checkPanCardUnique(String panCardNo, String empId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: checkPanCardUnique Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String message = "";
		try {

			connection = getConnection();
			pstmt = connection
					.prepareStatement(Employee.CHECK_DUPLICATE_PANCARD);
			pstmt.setString(1, panCardNo);
			pstmt.setString(2, empId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) > 0) {
					message = Employee.PANCARD_EXIST;
				}
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
				+ " Control in EmployeeDAOImpl: checkPanCardUnique Ending");
		return message;
	}

	@Override
	public String checkAddharCardUnique(String addharCardNo, String empId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: checkAddharCardUnique Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String message = "";
		try {

			connection = getConnection();
			pstmt = connection
					.prepareStatement(Employee.CHECK_DUPLICATE_ADDHAR_CARD);
			pstmt.setString(1, addharCardNo);
			pstmt.setString(2, empId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) > 0) {
					message = Employee.ADDHAR_CARD_EXIST;
				}
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
				+ " Control in EmployeeDAOImpl: checkAddharCardUnique Ending");
		return message;
	}

	@Override
	public String checkDLNoUnique(String dlNo, String empId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: checkDLNoUnique Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String message = "";
		try {

			connection = getConnection();
			pstmt = connection.prepareStatement(Employee.CHECK_DUPLICATE_DL);
			pstmt.setString(1, dlNo);
			pstmt.setString(2, empId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) > 0) {
					message = Employee.DL_EXIST;
				}
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
				+ " Control in EmployeeDAOImpl: checkDLNoUnique Ending");
		return message;
	}

	@Override
	public String checkDuplicateBiometricId(String bioId, String empId) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: checkDuplicateBiometricId Starting");

		PreparedStatement pstmt = null;
		Connection connection = null;
		ResultSet rs = null;
		String message = "";
		try {

			connection = getConnection();
			pstmt = connection.prepareStatement(Employee.CHECK_DUPLICATE_BIOID);
			pstmt.setString(1, bioId);
			pstmt.setString(2, empId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getInt(1) > 0) {
					message = Employee.EMPID_EXIST;
				}
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
				+ " Control in EmployeeDAOImpl: checkDuplicateBiometricId Ending");
		return message;
	}
	
	public String deleteEmployee(String empId,  String usercode){
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: deleteEmployee Starting");

		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Connection connection = null;
		String status = null;
		int count=0;
		int count1=0;
		boolean flag=false;
		String empname=null;
		String officialEmailId=null;
		String bioId=null;
		int mangercount=0;
		int directorcount=0;
		int usercount=0;
		try {

			connection = getConnection();
		     //CHECK_EXIST_EMPLOYEE
			pstmt = connection.prepareStatement(Employee.CHECK_EXIST_EMPLOYEE);
			pstmt.setString(1, empId);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				
				count1=rs.getInt(1);
			}
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			
			if(count1>0){
				
				pstmt = connection.prepareStatement(Employee.EMPID_IN_MANAGER);
				pstmt.setString(1, empId);
							
				rs=pstmt.executeQuery();
				while(rs.next()){
					mangercount=rs.getInt(1);
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if(mangercount>0){
					
					pstmt = connection.prepareStatement(Employee.DELETE_MANAGER);
					pstmt.setString(1, empId);
					
					pstmt.executeUpdate();
					
					if (pstmt != null && !pstmt.isClosed()) {
						pstmt.close();
					}
					
				}

				pstmt = connection.prepareStatement(Employee.EMPID_IN_DIRECTOR);
				pstmt.setString(1, empId);
				rs=pstmt.executeQuery();
				while(rs.next()){
					directorcount=rs.getInt(1);
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				} 
				if (pstmt != null && !pstmt.isClosed()) {
					    pstmt.close();
				  }
				if(directorcount>0){
				
			    	pstmt = connection.prepareStatement(Employee.DELETE_DIRECTOR);
				    pstmt.setString(1, empId);
				
				    pstmt.executeUpdate();
				
				    if (pstmt != null && !pstmt.isClosed()) {
					    pstmt.close();
				   }
			
				}
		
				pstmt = connection.prepareStatement(Employee.EMPID_IN_USER);
				pstmt.setString(1, empId);
				
				rs=pstmt.executeQuery();
				while(rs.next()){
					usercount=rs.getInt(1);
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				} 
				if (pstmt != null && !pstmt.isClosed()) {
					    pstmt.close();
				  }
			   
			   if(usercount>0){
			      pstmt = connection.prepareStatement(Employee.DELETE_USER);
				  pstmt.setString(1, empId);
				
				  pstmt.executeUpdate();
				
				   if (pstmt != null && !pstmt.isClosed()) {
					  pstmt.close();
				 }
			   }
			
		 
		
				pstmt = connection.prepareStatement(Employee.DELETE_EMPLOYEE_ATTENDANCE);
				pstmt.setString(1, empId);
				
				pstmt.executeUpdate();
				
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				
				pstmt = connection.prepareStatement(Employee.DELETE_WEEKOFF_SETTINGS);
				pstmt.setString(1, empId);
				
				pstmt.executeUpdate();
				
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				
				pstmt = connection.prepareStatement(Employee.DELETE_ONLINE_USERS);
				pstmt.setString(1, empId);
				
				pstmt.executeUpdate();
				
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				
				pstmt = connection.prepareStatement(Employee.GET_EMPLOYEE_INFO);
				pstmt.setString(1, empId);
				
				rs=pstmt.executeQuery();
				
				
				while(rs.next()){
					
					 empname =rs.getString("First_Name");
					 officialEmailId =rs.getString("Official_Email_ID");
					 bioId =rs.getString("bioid");				
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				
				pstmt = connection.prepareStatement(Employee.INSERT_DELETE_AUDIT);
				pstmt.setString(1, empId);
				pstmt.setString(2, bioId);
				pstmt.setString(3, empname);
				pstmt.setString(4, officialEmailId);
				pstmt.setString(5, usercode);
			
				pstmt.executeUpdate();
			
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
					
				pstmt = connection.prepareStatement(Employee.DELETE_EMPLOYEE);
				pstmt.setString(1, empId);
				
				count=pstmt.executeUpdate();
				
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			}else{
				
				flag=true;
			}
					
			if(count>0){
				
				status="true";
			}else{
				
				status="false";
			}
			
			if(flag){
				
				status="notExist";
			}

		} catch (SQLException sqle) {
			
			status="false";
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
				+ " Control in EmployeeDAOImpl: deleteEmployee Ending");
		return status;
	}

	public CheckEmployeeDeletionVO checkEmployeeMap(String empCode) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: checkEmployeeMap Starting");

		PreparedStatement pstmt = null;
		ResultSet rs=null;
		Connection connection = null;
		int count1=0;
		String EmployeeDesig="";
		String EmployeeCode=null;
		String managercode="";
		String usercode="";
		String directorcode="";
		String managerdesig="";
		String directordesig="";
		String userdesig="";
		
		CheckEmployeeDeletionVO checkEmployeeDeletionVO=new CheckEmployeeDeletionVO();
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(Employee.CHECK_EXIST_EMPLOYEE);
			pstmt.setString(1, empCode);
			rs=pstmt.executeQuery();
			while(rs.next()){
				
				count1=rs.getInt(1);
				EmployeeDesig=MessageConstants.EMPLOYEE;
			}
			
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			
			
			if(count1>0){
			
				pstmt = connection.prepareStatement(Employee.CHECK_EMPLOYEE_IN_MANAGER);
				pstmt.setString(1, empCode);
				
				rs=pstmt.executeQuery();
				while(rs.next()){
					managercode=rs.getString("ManagerCode");
					managerdesig=MessageConstants.MANAGER;
				}
				
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				
				pstmt = connection.prepareStatement(Employee.CHECK_EMPLOYEE_IN_DIRECTOR);
				pstmt.setString(1, empCode);
				
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					directorcode=rs.getString("DirectorCode");
					directordesig=MessageConstants.DIRECTOR;
				}
				
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			
				pstmt = connection.prepareStatement(Employee.CHECK_EMPLOYEE_IN_USER);
				pstmt.setString(1, empCode);
				
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					usercode=rs.getString("userCode");
					userdesig=MessageConstants.ADMIN;
				}
				
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				
					
				
			}
			
	
			
				if(managercode!=""){	
					
			          checkEmployeeDeletionVO=checkManagerMapping(managercode,connection,empCode);
			      
			       if (!checkEmployeeDeletionVO.isFlag() && directorcode!=""){
						
					 checkEmployeeDeletionVO=checkDirectorMapping(directorcode,connection,empCode);
				
					  if(!checkEmployeeDeletionVO.isFlag() && empCode!=""){
						
						 checkEmployeeDeletionVO=checkEmployeeMapping(empCode,connection);
						
					  }
					
			    }
				}else if(directorcode!=""){
				
				        checkEmployeeDeletionVO=checkDirectorMapping(directorcode,connection,empCode);
						
							if(!checkEmployeeDeletionVO.isFlag() && empCode!=""){
								
								 checkEmployeeDeletionVO=checkEmployeeMapping(empCode,connection);
								
							}
							
				 }else{
					 
					 checkEmployeeDeletionVO=checkEmployeeMapping(empCode,connection);
					 if(!checkEmployeeDeletionVO.isFlag() && MessageConstants.MANAGER.equalsIgnoreCase(managerdesig)){
						 
						 checkEmployeeDeletionVO.setEmployeecode(empCode);
						 checkEmployeeDeletionVO.setEmpdesig(MessageConstants.MANAGER);
						 
					 }else if(!checkEmployeeDeletionVO.isFlag() && MessageConstants.DIRECTOR.equalsIgnoreCase(directordesig)){

						 checkEmployeeDeletionVO.setEmployeecode(empCode);
						 checkEmployeeDeletionVO.setEmpdesig(MessageConstants.DIRECTOR);
						 
					 }else if(!checkEmployeeDeletionVO.isFlag() && MessageConstants.ADMIN.equalsIgnoreCase(userdesig)){
							
							checkEmployeeDeletionVO.setEmployeecode(empCode);
							checkEmployeeDeletionVO.setEmpdesig(MessageConstants.ADMIN);
					
				       }else{
				    	   checkEmployeeDeletionVO.setEmployeecode(empCode);
							checkEmployeeDeletionVO.setEmpdesig(MessageConstants.EMPLOYEE);
				       }
					 
					 
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
				+ " Control in EmployeeDAOImpl: checkEmployeeMap Ending");
		return checkEmployeeDeletionVO;
	}

	

	public  CheckEmployeeDeletionVO checkManagerMapping(String managerCode, Connection connection, String empCode) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: checkEmployeeMap Starting");

		PreparedStatement pstmt = null;
	    ResultSet rs=null;
		int count=0;
		CheckEmployeeDeletionVO checkEmployeeDeletionVO=new CheckEmployeeDeletionVO();
		try {
				
			pstmt = connection.prepareStatement(Employee.MANAGER_IN_DIRECTOR_MANAGER_MAPPING);
			pstmt.setString(1, managerCode);
	
			rs=pstmt.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
              	if(count>0){		
              		 checkEmployeeDeletionVO.setEmpdesig(MessageConstants.MANAGER);
              		 checkEmployeeDeletionVO.setStatus(MessageConstants.MANAGER_MAPPED);
					checkEmployeeDeletionVO.setFlag(true);
              	}
			 }
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			
			if(count==0){
				
				pstmt = connection.prepareStatement(Employee.MANAGER_IN_PROJECT_MANAGER_MAPPING);
				pstmt.setString(1, managerCode);
		
				rs=pstmt.executeQuery();
				while(rs.next()){
					count=rs.getInt(1);
					if(count>0){
						 checkEmployeeDeletionVO.setEmpdesig(MessageConstants.MANAGER);
						 checkEmployeeDeletionVO.setStatus(MessageConstants.MANAGER_MAPPED);
					checkEmployeeDeletionVO.setFlag(true);
					}
				 }
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if(count==0){
					
					pstmt = connection.prepareStatement(Employee.MANAGER_IN_DEPARTMENT_MAPPING);
					pstmt.setString(1, managerCode);
			
					rs=pstmt.executeQuery();
					while(rs.next()){
						count=rs.getInt(1);
						if(count>0){
							 checkEmployeeDeletionVO.setEmpdesig(MessageConstants.MANAGER);
							 checkEmployeeDeletionVO.setStatus(MessageConstants.MANAGER_MAPPED);
						checkEmployeeDeletionVO.setFlag(true);
						}
					 }
					if (pstmt != null && !pstmt.isClosed()) {
						pstmt.close();
					}
					if(count==0){
						
						pstmt = connection.prepareStatement(Employee.MANAGER_IN_EMPLOYEE_MANAGER_MAPPING);
						pstmt.setString(1, managerCode);
				
						rs=pstmt.executeQuery();
						while(rs.next()){
							count=rs.getInt(1);
							if(count>0){
								 checkEmployeeDeletionVO.setEmpdesig(MessageConstants.MANAGER);
								 checkEmployeeDeletionVO.setStatus(MessageConstants.MANAGER_MAPPED);
							checkEmployeeDeletionVO.setFlag(true);
							}
						 }
						if (pstmt != null && !pstmt.isClosed()) {
							pstmt.close();
						}
					
				
					}
				
				
			       }
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
				+ " Control in EmployeeDAOImpl: checkEmployeeMap Ending");
		
		return checkEmployeeDeletionVO;
	}
	
	

	public CheckEmployeeDeletionVO checkDirectorMapping(String directorCode,
			Connection connection, String empCode) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: checkDirectorMapping Starting");

		PreparedStatement pstmt = null;
	    ResultSet rs=null;
		int count=0;
		CheckEmployeeDeletionVO checkEmployeeDeletionVO=new CheckEmployeeDeletionVO();
		try {
				
			pstmt = connection.prepareStatement(Employee.DIRECTOR_IN_DIRECTOR_MANAGER_MAPPING);
			pstmt.setString(1, directorCode);
	
			rs=pstmt.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
				if(count>0){
					 checkEmployeeDeletionVO.setEmpdesig(MessageConstants.DIRECTOR);
					 checkEmployeeDeletionVO.setStatus(MessageConstants.DIRECTOR_MAPPED_WITH_DIRECTOR);
					checkEmployeeDeletionVO.setFlag(true);
				}
			 }
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
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
				+ " Control in EmployeeDAOImpl: checkDirectorMapping Ending");
		
		return checkEmployeeDeletionVO;
	}

	public CheckEmployeeDeletionVO checkEmployeeMapping(String empCode,
			Connection connection) {
		

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: checkEmployeeMapping Starting");

		PreparedStatement pstmt = null;
	    ResultSet rs=null;
	    int count=0;
		CheckEmployeeDeletionVO checkEmployeeDeletionVO=new CheckEmployeeDeletionVO();
		try {
							
				pstmt = connection.prepareStatement(Employee.EMPLOYEE_IN_EMPLOYEE_MANAGER_MAPPING);
				pstmt.setString(1, empCode);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
							count=rs.getInt(1);
						if(count>0){
							 checkEmployeeDeletionVO.setEmpdesig(MessageConstants.EMPLOYEE);
							checkEmployeeDeletionVO.setStatus(MessageConstants.EMPLOYEE_MAPPED_WITH_MANAGER);
							checkEmployeeDeletionVO.setFlag(true);
						}
				
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
				+ " Control in EmployeeDAOImpl: checkEmployeeMapping Ending");
		
		return checkEmployeeDeletionVO;
	}

	@Override
	public List<EmployeeDeleteAuditVo> getDeleteEmployeeAudit(String userCode) {
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: getDeleteEmployeeAudit Starting");

		PreparedStatement pstmt = null;
	    ResultSet rs=null;
	    Connection connection=null;
int sno=1;
		List<EmployeeDeleteAuditVo> getDeleteEmployeesAudit=new ArrayList<EmployeeDeleteAuditVo>();
		try {
	connection=getConnection();	
				pstmt = connection.prepareStatement(Employee.DELETE_EMPLOYEE_AUDIT);
				pstmt.setString(1,userCode);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
					EmployeeDeleteAuditVo auditVo=new EmployeeDeleteAuditVo();	
					auditVo.setEmployeeName(rs.getString("EmployeeName"));
					auditVo.setEmployeeCode(rs.getString("EmpId"));
					auditVo.setOfficialEmailId(rs.getString("OfficialId"));
					auditVo.setDeletedBy(rs.getString("username"));
					auditVo.setSno(sno);
					sno++;
					auditVo.setDeletedDate(	HelperClass.ConvertDBTimestamptoUITimestamp(rs.getString("CreatedDate")));
					auditVo.setBioId(rs.getString("EMP_BIOID"));
					getDeleteEmployeesAudit.add(auditVo);
				
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
				+ " Control in EmployeeDAOImpl: getDeleteEmployeeAudit Ending");
		return getDeleteEmployeesAudit;
	
}

	@Override
	public ArrayList<String> getEmployeePermissionsDao(String userCode) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: getEmployeePermissionsDao Starting");

		PreparedStatement pstmt = null;
	    ResultSet rs=null;
	    Connection connection=null;
	    int sno=1;
		ArrayList<String> getEmployeePermissions=new ArrayList<String>();
		try {
				connection=getConnection();	
				pstmt = connection.prepareStatement(Employee.GET_EMPLOYEE_PERMISSIONS);
				pstmt.setString(1,userCode);
				rs=pstmt.executeQuery();
				
				while(rs.next()){
					
				if(!(rs.getString("director").equalsIgnoreCase(""))){
					
					getEmployeePermissions.add(MessageConstants.DIRECTOR);
				}
				
				if(!(rs.getString("manager").equalsIgnoreCase(""))){
				
					getEmployeePermissions.add(MessageConstants.MANAGER);
				}
				
				if(!(rs.getString("admin").equalsIgnoreCase(""))){
					
					getEmployeePermissions.add(MessageConstants.ADMIN);
				}
					
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
				+ " Control in EmployeeDAOImpl: getEmployeePermissionsDao Ending");
		
		return getEmployeePermissions;
	
}

	@Override
	public String blockUserDetailsDao(String userCode, String role) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: getEmployeePermissionsDao Starting");

		PreparedStatement pstmt = null;
	    ResultSet rs=null;
	    Connection connection=null;
	    int sno=0;
	    String status=null;
		ArrayList<String> getEmployeePermissions=new ArrayList<String>();
		
		try {
				connection=getConnection();	
				
				if(role.equalsIgnoreCase("employee")){
					
					pstmt = connection.prepareStatement(Employee.BLOCK_EMPLOYEE);
					pstmt.setString(1,userCode);
					
					sno=pstmt.executeUpdate();
					
					if(sno>0){
						
						status="Employee login blocked successfully";
					}
					
				}else if(role.equalsIgnoreCase("director")){
					
					pstmt = connection.prepareStatement(Employee.BLOCK_DIRECTOR);
					pstmt.setString(1,userCode);
					
					sno=pstmt.executeUpdate();
					
					if(sno>0){
						
						status="Director login blocked successfully";
					}
					
				}else if(role.equalsIgnoreCase("manager")){
					
					pstmt = connection.prepareStatement(Employee.BLOCK_MANAGER);
					pstmt.setString(1,userCode);
					
					sno=pstmt.executeUpdate();
					
					if(sno>0){
						
						status="Manager login blocked successfully";
					}
					
				}else {
					
					pstmt = connection.prepareStatement(Employee.BLOCK_ADMIN);
					pstmt.setString(1,userCode);
					
					sno=pstmt.executeUpdate();
					
					if(sno>0){
						
						status="Admin login blocked successfully";
					}
					
				}
				
			
				if(status==null){
					
					status="false";
					
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
				+ " Control in EmployeeDAOImpl: getEmployeePermissionsDao Ending");
		
		return status;
	
}
	
	public EmployeeAmmendmentVO updateManagerUsernameEmailId(EmployeeForm employeeForm,Connection connection) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: updateManagerUsernameEmailId Starting");
		
		PreparedStatement ps_manager = null;
		ResultSet rs_manager=null;
		int count=0;
		String status=null;
		EmployeeAmmendmentVO empAmmendmentVO=new EmployeeAmmendmentVO();
		try {

			ps_manager = connection.prepareStatement(Employee.CHECK_MANAGER);
			ps_manager.setString(1, employeeForm.getEmpCode());
			
			rs_manager =ps_manager.executeQuery();
			
	
			while (rs_manager.next()) {
				
				count=rs_manager.getInt("managcount");
				status=rs_manager.getString("isActive");
			}
			
			if (rs_manager != null && !rs_manager.isClosed()) {
				rs_manager.close();
			}
			if (ps_manager != null && !ps_manager.isClosed()) {
				ps_manager.close();
			}
		
			if(count>0){
					
			  count=0;
					
			UsermanagementEmployeeVo usermanagementEmployeeVo=new UsermanagementEmployeeVo();
			
			usermanagementEmployeeVo.setMobilenumber(employeeForm.getMobileNo());
			usermanagementEmployeeVo.setBioid(employeeForm.getBiometricId());
			usermanagementEmployeeVo.setEmpname(employeeForm.getEmpFirstName());
			usermanagementEmployeeVo.setOfficialmailId(employeeForm.getOfficialEmailId());
			
			String password =HelperClass.genaratePasswordForManager(usermanagementEmployeeVo);
				
			
				ps_manager = connection.prepareStatement(Employee.UPDATE_MANAGER);
				
				ps_manager.setString(1, employeeForm.getEmpFirstName());
				ps_manager.setString(2, employeeForm.getOfficialEmailId());
				ps_manager.setString(3, employeeForm.getOfficialEmailId());
				ps_manager.setString(4, password);
				ps_manager.setString(5, employeeForm.getEmpCode());
				
		
			
				count = ps_manager.executeUpdate();
					
				 if(count>0){
					 
				
					 empAmmendmentVO.setStatus(MessageConstants.SAVED);
					 
					          if(status.equalsIgnoreCase(MessageConstants.IS_ACTIVE_YES)){
						 
						                  empAmmendmentVO.setMangpassword(password);
						 
								}
				
					}else{
				 
						empAmmendmentVO.setStatus(MessageConstants.NOT_SAVED);
				       
			       }
			
			}else{
				
				
				empAmmendmentVO.setStatus(MessageConstants.SAVED);
			
				
			}		

			
			
			
			
			
	     } catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			} finally {
				try {
					if (rs_manager != null && !rs_manager.isClosed()) {
						rs_manager.close();
					}
					if (ps_manager != null && !ps_manager.isClosed()) {
						ps_manager.close();
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
				+ " Control in EmployeeDAOImpl: updateManagerUsernameEmailId Ending");

		return empAmmendmentVO;
	}

	


	public EmployeeAmmendmentVO updateDirectorUsernameEmailId(EmployeeForm employeeForm,Connection connection) {
	
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: updateDirectorUsernameEmailId Starting");
		
		PreparedStatement ps_director = null;
		ResultSet rs_director=null;
		int count=0;
		String status=null;
		EmployeeAmmendmentVO employeeAmmendmentVO=new EmployeeAmmendmentVO();
		try {

			ps_director = connection.prepareStatement(Employee.CHECK_DIRECTOR);
			ps_director.setString(1, employeeForm.getEmpCode());
			
			rs_director =ps_director.executeQuery();
			while (rs_director.next()) {
				
				count=rs_director.getInt("direcount");
				status=rs_director.getString("isActive");
			}
			
			if (rs_director != null && !rs_director.isClosed()) {
				rs_director.close();
			}
			if (ps_director != null && !ps_director.isClosed()) {
				ps_director.close();
			}
			
			if(count>0){
					
			count=0;
					
			UsermanagementEmployeeVo usermanagementEmployeeVo=new UsermanagementEmployeeVo();
			
			usermanagementEmployeeVo.setMobilenumber(employeeForm.getMobileNo());
			usermanagementEmployeeVo.setBioid(employeeForm.getBiometricId());
			usermanagementEmployeeVo.setEmpname(employeeForm.getEmpFirstName());
			usermanagementEmployeeVo.setOfficialmailId(employeeForm.getOfficialEmailId());
			
			String password =HelperClass.genaratePasswordForDirector(usermanagementEmployeeVo);
				
			
			ps_director = connection.prepareStatement(Employee.UPDATE_DIRECTOR);
				
			ps_director.setString(1, employeeForm.getOfficialEmailId().trim());
			ps_director.setString(2, password.trim());
			ps_director.setString(3, employeeForm.getEmpCode().trim());
			
				count = ps_director.executeUpdate();
		
				 if(count>0){
					 
				
					 employeeAmmendmentVO.setStatus(MessageConstants.SAVED);
					 
					       if(status.equalsIgnoreCase(MessageConstants.IS_ACTIVE_YES)){
						 					    	   
						                   employeeAmmendmentVO.setDirepassword(password);
							
				               }
				
					}else{
						employeeAmmendmentVO.setStatus(MessageConstants.NOT_SAVED);
			       }
			
			}else{
				
				employeeAmmendmentVO.setStatus(MessageConstants.SAVED);
			}		

			
			
			
			
			
	     } catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			} finally {
				try {
					if (rs_director != null && !rs_director.isClosed()) {
						rs_director.close();
					}
					if (ps_director != null && !ps_director.isClosed()) {
						ps_director.close();
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
				+ " Control in EmployeeDAOImpl: updateDirectorUsernameEmailId Ending");

		return employeeAmmendmentVO;
	}
	
	
	public EmployeeAmmendmentVO updateAdminUsernameEmailId(EmployeeForm employeeForm,
			Connection connection) {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: updateAdminUsernameEmailId Starting");
		
		PreparedStatement ps_admin = null;
		ResultSet rs_admin=null;
		int count=0;
		String status=null;
		EmployeeAmmendmentVO employeeAmmendmentVO=new EmployeeAmmendmentVO();
		try {

			ps_admin = connection.prepareStatement(Employee.CHECK_ADMIN);
			ps_admin.setString(1, employeeForm.getEmpCode());
			
			rs_admin =ps_admin.executeQuery();
			while (rs_admin.next()) {
				
				count=rs_admin.getInt("admincount");
				status=rs_admin.getString("isActive");
			}
			
			if (rs_admin != null && !rs_admin.isClosed()) {
				rs_admin.close();
			}
			if (ps_admin != null && !ps_admin.isClosed()) {
				ps_admin.close();
			}
			
			if(count>0){
					
			count=0;
					
			UsermanagementEmployeeVo usermanagementEmployeeVo=new UsermanagementEmployeeVo();
			
			usermanagementEmployeeVo.setMobilenumber(employeeForm.getMobileNo());
			usermanagementEmployeeVo.setBioid(employeeForm.getBiometricId());
			usermanagementEmployeeVo.setEmpname(employeeForm.getEmpFirstName());
			usermanagementEmployeeVo.setOfficialmailId(employeeForm.getOfficialEmailId());
			
			String password =HelperClass.genaratePasswordForUser(usermanagementEmployeeVo);
				
			
			ps_admin = connection.prepareStatement(Employee.UPDATE_ADMIN);
				
			ps_admin.setString(1, employeeForm.getOfficialEmailId().trim());
			ps_admin.setString(2, password.trim());
			ps_admin.setString(3, employeeForm.getOfficialEmailId().trim());
			ps_admin.setString(4, employeeForm.getEmpCode().trim());
			
				count = ps_admin.executeUpdate();
			
				 if(count>0){
					 
				
						employeeAmmendmentVO.setStatus(MessageConstants.SAVED);
					 
					       if(status.equalsIgnoreCase(MessageConstants.IS_ACTIVE_YES)){
						 
							     employeeAmmendmentVO.setAdminpassword(password);
								
					      }
				
					}else{
				 
						employeeAmmendmentVO.setStatus(MessageConstants.NOT_SAVED);
				         
			       }
			
			}else{
				
				employeeAmmendmentVO.setStatus(MessageConstants.SAVED);
				
				
			}		

			
			
			
			
			
	     } catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			} finally {
				try {
					if (rs_admin != null && !rs_admin.isClosed()) {
						rs_admin.close();
					}
					if (ps_admin != null && !ps_admin.isClosed()) {
						ps_admin.close();
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
				+ " Control in EmployeeDAOImpl: updateAdminUsernameEmailId Ending");

		return employeeAmmendmentVO;
	}

	

	public String sendEmpAnmmendmentEmailToEmployee(
			EmployeeAmmendmentVO employeeAmmendmentVO, Connection connection) {

		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: sendEmpAnmmendmentEmailToEmployee Starting");
		
		String mangcontent="";
		String direcontent="";
		String admincontent="";
		String mailstatus=null;
		
		 try {
			 
				
				if(employeeAmmendmentVO.getMangpassword()!=null){
					
					 mangcontent="Manager login credentials \n\n"
					            + "Username	 :" + employeeAmmendmentVO.getOfficialEmailId().trim() + "\n"
						    	+ "Password	  : " + employeeAmmendmentVO.getMangpassword().trim() + "\n\n";
				}
				
				if(employeeAmmendmentVO.getDirepassword()!=null){
					
					 direcontent ="Director login credentials \n\n"
				            + "Username	 : " + employeeAmmendmentVO.getOfficialEmailId().trim() + "\n"
					    	+ "Password	  :" + employeeAmmendmentVO.getDirepassword().trim() + "\n\n";
				}
				
				if(employeeAmmendmentVO.getAdminpassword()!=null){
					
					 admincontent ="Admin login credentials \n\n"
				            + "Username	 : " + employeeAmmendmentVO.getOfficialEmailId().trim() + "\n"
					    	+ "Password	  : " + employeeAmmendmentVO.getAdminpassword().trim() + "\n\n";
					
				}
				
				
		EmailContent em = new EmailContent();
		String[] mails = { employeeAmmendmentVO.getOfficialEmailId() };
		String url = getServerUrlFromBD(connection);
		em.setMailids(mails);
		em.setSubject("Login  Details");
        
		em.setMessage("Dear "+employeeAmmendmentVO.getEmpfirstname()+", \n"
				+ "Greetings from TeleIndia. \n\n"
				+ "Your OfficialEmaiId is changed. \n\n"
				+ "Employee login credentials \n\n"
				+ "Username	 : " + employeeAmmendmentVO.getOfficialEmailId().trim() + "\n"
				+ "Password	  : " + employeeAmmendmentVO.getEmppassword().trim() + "\n\n"
				+  mangcontent
				+  direcontent
				+  admincontent
				+ "Please use the below link, login to Application.\n\n"
				+ "URL		    : " + url + "\n\n" 
				+ "Have a nice day \n\n"
				+ "E-ATTENDANCE PRO  \n"
				+ "-------------------------------------------------------------- \n"
				+ "This is system generated mail,Please do not reply");
		
		
			mailstatus=	new SendMailWithMultipleAttachment().sendReportToMail(em);
	
			
		 } catch (IOException e) {
			
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		} catch (Exception e1) {
			
			e1.printStackTrace();
			logger.error(e1.getMessage(), e1);
		}
	
			JLogger.log(0, JDate.getTimeString(new Date())
					+ MessageConstants.END_POINT);
			logger.info(JDate.getTimeString(new Date())
					+ " Control in EmployeeDAOImpl: sendEmpAnmmendmentEmailToEmployee Ending");
		
		return mailstatus;
	}

	@Override
	public String getBioIdDao() {
		
		logger.setLevel(Level.DEBUG);
		JLogger.log(0, JDate.getTimeString(new Date())
				+ MessageConstants.START_POINT);
		logger.info(JDate.getTimeString(new Date())
				+ " Control in EmployeeDAOImpl: getBioIdDao Starting");
		
		PreparedStatement ps_admin = null;
		ResultSet rs_admin=null;
		String bioId=null;
		Connection connection=null;
		
		try {
			
			connection=getConnection();
			ps_admin = connection.prepareStatement(Employee.GET_BIOID);
			
			rs_admin =ps_admin.executeQuery();
			while (rs_admin.next()) {
				
				bioId=String.valueOf(rs_admin.getInt("bioID")+1);
				
			}
			
			
	     } catch (SQLException sqle) {
				sqle.printStackTrace();
				logger.error(sqle.getMessage(), sqle);
			} catch (Exception e1) {
				e1.printStackTrace();
				logger.error(e1.getMessage(), e1);
			} finally {
				try {
					if (rs_admin != null && !rs_admin.isClosed()) {
						rs_admin.close();
					}
					if (ps_admin != null && !ps_admin.isClosed()) {
						ps_admin.close();
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
				+ " Control in EmployeeDAOImpl: getBioIdDao Ending");

		return bioId;
	}

	
}