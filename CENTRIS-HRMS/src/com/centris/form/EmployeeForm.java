package com.centris.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class EmployeeForm extends ActionForm {

	private String empCode;
	private String empStatus;

	private String empFirstName;
	private String reportingSupervisor;
	
	private String projectHead;
	private String dateOfJoining;
	private String project;
	private String baseLocation;
	private String designation;
	private String department;
	private String gender;
	private String bloodGroup;
	private String dateOfBirth;
	private String panCardNo;
	private String voterIdNo;
	private String addharCardNo;
	private String drivingLicenceNo;
	private String permanentAddress;
	private String presentAddress;
	private String mobileNo;
	private String personalEmailId;
	private String officialEmailId;
	private String maritalStatus;
	private String salaryOffered;
	private String dateOfLeaving;

	private String hdfcAccountNo;
	private String bankName;
	private String bankBranchName;
	private String bankIfscCode;

	private String passportNo;
	private String passportIssueDate;
	private String passportExpiryDate;
	private String passportIssuePlace;

	private String previousCompanyName;
	private String lastCompanyDesignation;
	private String lastDrawnSalaryInRS;
	private String totalExperience;

	private String majorQualification;
	private String universityOrBoard;
	private String yearOfPassing;
	private String collegeOrInstituteName;

	private String fatherName;
	private String fatherDOB;
	private String motherName;
	private String motherDOB;
	private String dateOfMariage;
	private String spouseName;
	private String spouseDOB;
	private String firstChildName;
	private String firstChildDOB;
	private String secondChildName;
	private String secondChildDOB;
	private String familyPhoneNo;

	private FormFile securityDocument;
	private FormFile empImage;

	private String remarks;

	private String userCode;
	private String managerCode;
	private String password;
	private String serverPath;

	private boolean sunday;
	private boolean monday;
	private boolean tuesday;
	private boolean wednesday;
	private boolean thrusday;
	private boolean friday;
	private boolean saturday;

	private String doubleFormSubmition;
	private String empType;

	private FormFile document1;
	private FormFile document2;
	private FormFile document3;
	private FormFile document4;

	private String hdoc1;
	private String hdoc2;
	private String hdoc3;
	private String hdoc4;
	
	
	private String secondreportingSupervisor;
	
	private FormFile testFile1;
	private FormFile testFile2;
	private FormFile testFile3;
	private FormFile testFile4;
	private FormFile testFile5;
	
	private String hfile1;
	private String hfile2;
	private String hfile3;
	private String hfile4;
	private String hfile5;
	

		
	
	public String getHfile1() {
		return hfile1;
	}

	public void setHfile1(String hfile1) {
		this.hfile1 = hfile1;
	}

	public String getHfile2() {
		return hfile2;
	}

	public void setHfile2(String hfile2) {
		this.hfile2 = hfile2;
	}

	public String getHfile3() {
		return hfile3;
	}

	public void setHfile3(String hfile3) {
		this.hfile3 = hfile3;
	}

	public String getHfile4() {
		return hfile4;
	}

	public void setHfile4(String hfile4) {
		this.hfile4 = hfile4;
	}

	public String getHfile5() {
		return hfile5;
	}

	public void setHfile5(String hfile5) {
		this.hfile5 = hfile5;
	}

	public FormFile getTestFile1() {
		return testFile1;
	}

	public void setTestFile1(FormFile testFile1) {
		this.testFile1 = testFile1;
	}

	public FormFile getTestFile2() {
		return testFile2;
	}

	public void setTestFile2(FormFile testFile2) {
		this.testFile2 = testFile2;
	}

	public FormFile getTestFile3() {
		return testFile3;
	}

	public void setTestFile3(FormFile testFile3) {
		this.testFile3 = testFile3;
	}

	public FormFile getTestFile4() {
		return testFile4;
	}

	public void setTestFile4(FormFile testFile4) {
		this.testFile4 = testFile4;
	}

	public FormFile getTestFile5() {
		return testFile5;
	}

	public void setTestFile5(FormFile testFile5) {
		this.testFile5 = testFile5;
	}

	public String getSecondreportingSupervisor() {
		return secondreportingSupervisor;
	}

	public void setSecondreportingSupervisor(String secondreportingSupervisor) {
		this.secondreportingSupervisor = secondreportingSupervisor;
	}

	private String biometricId;

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getReportingSupervisor() {
		return reportingSupervisor;
	}

	public void setReportingSupervisor(String reportingSupervisor) {
		this.reportingSupervisor = reportingSupervisor;
	}

	public String getProjectHead() {
		return projectHead;
	}

	public void setProjectHead(String projectHead) {
		this.projectHead = projectHead;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPanCardNo() {
		return panCardNo;
	}

	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}

	public String getVoterIdNo() {
		return voterIdNo;
	}

	public void setVoterIdNo(String voterIdNo) {
		this.voterIdNo = voterIdNo;
	}

	public String getAddharCardNo() {
		return addharCardNo;
	}

	public void setAddharCardNo(String addharCardNo) {
		this.addharCardNo = addharCardNo;
	}

	public String getDrivingLicenceNo() {
		return drivingLicenceNo;
	}

	public void setDrivingLicenceNo(String drivingLicenceNo) {
		this.drivingLicenceNo = drivingLicenceNo;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPersonalEmailId() {
		return personalEmailId;
	}

	public void setPersonalEmailId(String personalEmailId) {
		this.personalEmailId = personalEmailId;
	}

	public String getOfficialEmailId() {
		return officialEmailId;
	}

	public void setOfficialEmailId(String officialEmailId) {
		this.officialEmailId = officialEmailId;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getSalaryOffered() {
		return salaryOffered;
	}

	public void setSalaryOffered(String salaryOffered) {
		this.salaryOffered = salaryOffered;
	}

	public String getDateOfLeaving() {
		return dateOfLeaving;
	}

	public void setDateOfLeaving(String dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
	}

	public String getHdfcAccountNo() {
		return hdfcAccountNo;
	}

	public void setHdfcAccountNo(String hdfcAccountNo) {
		this.hdfcAccountNo = hdfcAccountNo;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getPassportIssueDate() {
		return passportIssueDate;
	}

	public void setPassportIssueDate(String passportIssueDate) {
		this.passportIssueDate = passportIssueDate;
	}

	public String getPassportExpiryDate() {
		return passportExpiryDate;
	}

	public void setPassportExpiryDate(String passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}

	public String getPassportIssuePlace() {
		return passportIssuePlace;
	}

	public void setPassportIssuePlace(String passportIssuePlace) {
		this.passportIssuePlace = passportIssuePlace;
	}

	public String getPreviousCompanyName() {
		return previousCompanyName;
	}

	public void setPreviousCompanyName(String previousCompanyName) {
		this.previousCompanyName = previousCompanyName;
	}

	public String getLastCompanyDesignation() {
		return lastCompanyDesignation;
	}

	public void setLastCompanyDesignation(String lastCompanyDesignation) {
		this.lastCompanyDesignation = lastCompanyDesignation;
	}

	public String getLastDrawnSalaryInRS() {
		return lastDrawnSalaryInRS;
	}

	public void setLastDrawnSalaryInRS(String lastDrawnSalaryInRS) {
		this.lastDrawnSalaryInRS = lastDrawnSalaryInRS;
	}

	public String getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(String totalExperience) {
		this.totalExperience = totalExperience;
	}

	public String getMajorQualification() {
		return majorQualification;
	}

	public void setMajorQualification(String majorQualification) {
		this.majorQualification = majorQualification;
	}

	public String getUniversityOrBoard() {
		return universityOrBoard;
	}

	public void setUniversityOrBoard(String universityOrBoard) {
		this.universityOrBoard = universityOrBoard;
	}

	public String getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(String yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	public String getCollegeOrInstituteName() {
		return collegeOrInstituteName;
	}

	public void setCollegeOrInstituteName(String collegeOrInstituteName) {
		this.collegeOrInstituteName = collegeOrInstituteName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFatherDOB() {
		return fatherDOB;
	}

	public void setFatherDOB(String fatherDOB) {
		this.fatherDOB = fatherDOB;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getMotherDOB() {
		return motherDOB;
	}

	public void setMotherDOB(String motherDOB) {
		this.motherDOB = motherDOB;
	}

	public String getDateOfMariage() {
		return dateOfMariage;
	}

	public void setDateOfMariage(String dateOfMariage) {
		this.dateOfMariage = dateOfMariage;
	}

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public String getSpouseDOB() {
		return spouseDOB;
	}

	public void setSpouseDOB(String spouseDOB) {
		this.spouseDOB = spouseDOB;
	}

	public String getFirstChildName() {
		return firstChildName;
	}

	public void setFirstChildName(String firstChildName) {
		this.firstChildName = firstChildName;
	}

	public String getFirstChildDOB() {
		return firstChildDOB;
	}

	public void setFirstChildDOB(String firstChildDOB) {
		this.firstChildDOB = firstChildDOB;
	}

	public String getSecondChildName() {
		return secondChildName;
	}

	public void setSecondChildName(String secondChildName) {
		this.secondChildName = secondChildName;
	}

	public String getSecondChildDOB() {
		return secondChildDOB;
	}

	public void setSecondChildDOB(String secondChildDOB) {
		this.secondChildDOB = secondChildDOB;
	}

	public String getFamilyPhoneNo() {
		return familyPhoneNo;
	}

	public void setFamilyPhoneNo(String familyPhoneNo) {
		this.familyPhoneNo = familyPhoneNo;
	}

	public FormFile getSecurityDocument() {
		return securityDocument;
	}

	public void setSecurityDocument(FormFile securityDocument) {
		this.securityDocument = securityDocument;
	}

	public FormFile getEmpImage() {
		return empImage;
	}

	public void setEmpImage(FormFile empImage) {
		this.empImage = empImage;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getManagerCode() {
		return managerCode;
	}

	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServerPath() {
		return serverPath;
	}

	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}

	public boolean isSunday() {
		return sunday;
	}

	public void setSunday(boolean sunday) {
		this.sunday = sunday;
	}

	public boolean isMonday() {
		return monday;
	}

	public void setMonday(boolean monday) {
		this.monday = monday;
	}

	public boolean isTuesday() {
		return tuesday;
	}

	public void setTuesday(boolean tuesday) {
		this.tuesday = tuesday;
	}

	public boolean isWednesday() {
		return wednesday;
	}

	public void setWednesday(boolean wednesday) {
		this.wednesday = wednesday;
	}

	public boolean isThrusday() {
		return thrusday;
	}

	public void setThrusday(boolean thrusday) {
		this.thrusday = thrusday;
	}

	public boolean isFriday() {
		return friday;
	}

	public void setFriday(boolean friday) {
		this.friday = friday;
	}

	public boolean isSaturday() {
		return saturday;
	}

	public void setSaturday(boolean saturday) {
		this.saturday = saturday;
	}

	public void reset() {

	}

	public String getDoubleFormSubmition() {
		return doubleFormSubmition;
	}

	public void setDoubleFormSubmition(String doubleFormSubmition) {
		this.doubleFormSubmition = doubleFormSubmition;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public FormFile getDocument1() {
		return document1;
	}

	public void setDocument1(FormFile document1) {
		this.document1 = document1;
	}

	public FormFile getDocument2() {
		return document2;
	}

	public void setDocument2(FormFile document2) {
		this.document2 = document2;
	}

	public FormFile getDocument3() {
		return document3;
	}

	public void setDocument3(FormFile document3) {
		this.document3 = document3;
	}

	public FormFile getDocument4() {
		return document4;
	}

	public void setDocument4(FormFile document4) {
		this.document4 = document4;
	}

	public String getHdoc1() {
		return hdoc1;
	}

	public void setHdoc1(String hdoc1) {
		this.hdoc1 = hdoc1;
	}

	public String getHdoc2() {
		return hdoc2;
	}

	public void setHdoc2(String hdoc2) {
		this.hdoc2 = hdoc2;
	}

	public String getHdoc3() {
		return hdoc3;
	}

	public void setHdoc3(String hdoc3) {
		this.hdoc3 = hdoc3;
	}

	public String getHdoc4() {
		return hdoc4;
	}

	public void setHdoc4(String hdoc4) {
		this.hdoc4 = hdoc4;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankBranchName() {
		return bankBranchName;
	}

	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}

	public String getBankIfscCode() {
		return bankIfscCode;
	}

	public void setBankIfscCode(String bankIfscCode) {
		this.bankIfscCode = bankIfscCode;
	}

	public String getBiometricId() {
		return biometricId;
	}

	public void setBiometricId(String biometricId) {
		this.biometricId = biometricId;
	}
}