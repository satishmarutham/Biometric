<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Employee Amendment</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.position.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.menu.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="js/Admin/EmployeeAmendment.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<!-- <link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link> -->

<style >

table#biometric tr {
	padding: 1px;
}

table#biometric_1 td {
	font-family: "Segoe UI Semibold","Segoe UI";
	/* background-color: #BCD1E1; */
	color: black;
	font-size: 12px;
	font-weight: normal;
	text-align: justify;
	margin: 1px;
	padding-top: 1px;
	padding-bottom: 1px;
	border: 1px solid #BDC3C7;
}

table#biometric_1 th {
	font-family: "Segoe UI Semibold","Segoe UI";
	/* background-color: gray; */
	color: #FFFFFF;
}

table#biometric_1 label {
	font-family: "Segoe UI Semibold","Segoe UI";
	color: #003D52;
	font-size: 12px;
	font-weight: bold;
	text-align: center;
	font-family: "Segoe UI Semibold","Segoe UI";
}


</style>

</head>

<body>

	<div id="main" class="background">
	<div id="loader"
		style="position: absolute; top: 200%; left: 45%; display: none; ">
		<img src="images/loaderimage2.GIF" width="150px" height="150px" />
	</div>
		<center>

			<div class="backgroundDiv" id="backgroung">Employee Amendment</div>
	

			<form action="employee.do?parameter=amendEmployee"
				name="AddEmployeeForm" method="post" enctype="multipart/form-data"
				onsubmit="return validateEmployeeDetails()">



				<center>

					<div id="errordiv" class="error-box" align="center" style="width:40%;">

						<logic:present name="successMessage" scope="request">
							<span style="color: green; font-family: Segoe UI;"> <bean:write
									name="successMessage" />
							</span>
						</logic:present>
						<logic:present name="errorMessage" scope="request">
							<span style="color: red; font-family: Segoe UI;"> <bean:write
									name="errorMessage" />
							</span>
						</logic:present>
					</div>
				</center>

				<div class="backgroungDIV" id="backgroung">
					<input type="hidden" id="doubleFormSubmition"
						name="doubleFormSubmition"
						value='<logic:present name="successMessage" scope="session"><bean:write name="doubleFormSubmition" /></logic:present>' />
					
					<input type="hidden" name="hdesignation" id="hdesignation"
						value="<logic:present name="employeeDetails" property="designation"><bean:write name="employeeDetails" property="designation" />
													</logic:present>" />


					<input type="hidden" name="hsupervisor" id="hsupervisor"
						value="<logic:present name="employeeDetails" property="reportingSupervisor"><bean:write name="employeeDetails" property="reportingSupervisor" />
													</logic:present>" />
													
													
													
							<input type="hidden" name="hSecondsupervisor" id="hSecondsupervisor"
						value="<logic:present name="employeeDetails" property="secondreportingSupervisor"><bean:write name="employeeDetails" property="secondreportingSupervisor" />
													</logic:present>" />						
													
													
													
													
													
													
					<input type="hidden" name="hdepartment" id="hdepartment"
						value="<logic:present name="employeeDetails" property="department"><bean:write name="employeeDetails" property="department" />
													</logic:present>" />

					<input type="hidden" name="hprojectname" id="hprojectname"
						value="<logic:present name="employeeDetails" property="project"><bean:write name="employeeDetails" property="project" />
													</logic:present>" />



					<input type="hidden" name="hsunday" id="hsunday"
						value="<logic:present name="employeeDetails" property="sunday"><bean:write name="employeeDetails" property="sunday" />
													</logic:present>" />

					<input type="hidden" name="hmonday" id="hmonday"
						value="<logic:present name="employeeDetails" property="monday"><bean:write name="employeeDetails" property="monday" />
													</logic:present>" />
					<input type="hidden" name="htuesday" id="htuesday"
						value="<logic:present name="employeeDetails" property="tuesday"><bean:write name="employeeDetails" property="tuesday" />
													</logic:present>" />
					<input type="hidden" name="hwednesday" id="hwednesday"
						value="<logic:present name="employeeDetails" property="wednesday"><bean:write name="employeeDetails" property="wednesday" />
													</logic:present>" />
					<input type="hidden" name="hthursday" id="hthursday"
						value="<logic:present name="employeeDetails" property="thursday"><bean:write name="employeeDetails" property="thursday" />
													</logic:present>" />
					<input type="hidden" name="hfriday" id="hfriday"
						value="<logic:present name="employeeDetails" property="friday"><bean:write name="employeeDetails" property="friday" />
													</logic:present>" />
					<input type="hidden" name="hsaturday" id="hsaturday"
						value="<logic:present name="employeeDetails" property="saturday"><bean:write name="employeeDetails" property="saturday" />
													</logic:present>" />

					<input type="hidden" name="hgender" id="hgender"
						value="<logic:present name="employeeDetails" property="gender"><bean:write name="employeeDetails" property="gender" />
													</logic:present>" />
					<input type="hidden" name="hbloodGroup" id="hbloodGroup"
						value="<logic:present name="employeeDetails" property="bloodGroup"><bean:write name="employeeDetails" property="bloodGroup" />
													</logic:present>" />
					<input type="hidden" name="hmaritalStatus" id="hmaritalStatus"
						value="<logic:present name="employeeDetails" property="maritalStatus"><bean:write name="employeeDetails" property="maritalStatus" />
													</logic:present>" />
					<input type="hidden" name="hempStatus" id="hempStatus"
						value="<logic:present name="employeeDetails" property="empStatus"><bean:write name="employeeDetails" property="empStatus" />
													</logic:present>" />
					<input type="hidden" name="hempType" id="hempType"
						value="<logic:present name="employeeDetails" property="empType"><bean:write name="employeeDetails" property="empType" />
													</logic:present>" />
					<input type="hidden" name="hprojectHead" id="hprojectHead"
						value="<logic:present name="employeeDetails" property="projectHead"><bean:write name="employeeDetails" property="projectHead" />
													</logic:present>" />

					<input type="hidden" name="hmajorQualification"
						id="hmajorQualification"
						value="<logic:present name="employeeDetails" property="majorQualification"><bean:write name="employeeDetails" property="majorQualification" />
													</logic:present>" />


					<input type="hidden" name="hdoc1" id="hdoc1"
						value='<logic:present name="employeeDetails" property="document1"><bean:write name="employeeDetails" property="document1" /></logic:present>' />
					<input type="hidden" name="hdoc2" id="hdoc2"
						value='<logic:present name="employeeDetails" property="document2"><bean:write name="employeeDetails" property="document2" /></logic:present>' />
					<input type="hidden" name="hdoc3" id="hdoc3"
						value='<logic:present name="employeeDetails" property="document3"><bean:write name="employeeDetails" property="document3" /></logic:present>' />
					<input type="hidden" name="hdoc4" id="hdoc4"
						value='<logic:present name="employeeDetails" property="document4"><bean:write name="employeeDetails" property="document4" /></logic:present>' />

					<input type="hidden" name="hfile1" id="hfile1"
						value='<logic:present name="employeeDetails" property="file1"><bean:write name="employeeDetails" property="file1" /></logic:present>' />
					<input type="hidden" name="hfile2" id="hfile2"
						value='<logic:present name="employeeDetails" property="file2"><bean:write name="employeeDetails" property="file2" /></logic:present>' />
					<input type="hidden" name="hfile3" id="hfile3"
						value='<logic:present name="employeeDetails" property="file3"><bean:write name="employeeDetails" property="file3" /></logic:present>' />
					<input type="hidden" name="hfile4" id="hfile4"
						value='<logic:present name="employeeDetails" property="file4"><bean:write name="employeeDetails" property="file4" /></logic:present>' />
					<input type="hidden" name="hfile5" id="hfile5"
						value='<logic:present name="employeeDetails" property="file5"><bean:write name="employeeDetails" property="file5" /></logic:present>' />
					
					
					
					
					
					
					
					<fieldset style="width: 85%;"><br/>
					
					<table cellpadding="5" cellspacing="0" id="biometric" width="50%">
						<tr>
							<td id="searchbox" class="left">Search
								Employee </td>
							<td class="right"> <input type="text" class="input"
								id="emp" name="selectEmployee" placeholder="Search Employee"
								value="<logic:present name="employeeDetails" property="empFirstName"><bean:write name="employeeDetails" property="empFirstName" />
													</logic:present>" />
							</td>
						</tr>
					</table><br/>
					
						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
							 <td colspan="5" class="head11" >	<span class="head11" > Personal Details</span> </td>
							</tr>


							<tr class="trc">

								<td class="left">Employee First Name<font color="red">*</font></td>
								<td class="right"><input type="hidden" name="empCode" id="empCode"
									value="<logic:present name="employeeDetails" property="empCode"><bean:write name="employeeDetails" property="empCode" /></logic:present>" />
									<input type="text" name="empFirstName" id="empFirstName" maxlength="50"
									value="<logic:present name="employeeDetails" property="empFirstName"><bean:write name="employeeDetails" property="empFirstName" /></logic:present>" />
								</td>
								
								<td class="left">Base Location<font color="red">*</font></td>
								<td class="right">
									<input type="text" name="baseLocation" id="baseLocation"
									value="<logic:present name="employeeDetails" property="baseLocation"><bean:write name="employeeDetails" property="baseLocation" /></logic:present>" maxlength="30" />
								</td>
								
							</tr>
							
							<tr class="trc">

								<td class="left">Designation<font color="red">*</font></td>
								<td class="right"><select
									name="designation" id="designation">

										<option value="">-----Select-----</option>
										<logic:present name="designationDetails" scope="session">
											<logic:iterate id="designation" name="designationDetails"
												scope="session">
												<option
													value='<bean:write name="designation" property="desgid"  />'>
													<bean:write name="designation" property="desgname" />
												</option>
											</logic:iterate>
										</logic:present>
								</select>
								</td>
								<td class="left">Pan Card No<font color="red"></font></td>
								<td class="right">
									<input
									type="text" id="panCardNo" name="panCardNo"
									onblur="checkPanCardUnique(this.value)"
									value="<logic:present name="employeeDetails" property="panCardNo"><bean:write name="employeeDetails" property="panCardNo" />
													</logic:present>"
									maxlength="20" />
								</td>
							</tr>
							
							<tr class="trc">

								<td class="left">Gender<font color="red">*</font></td>
								<td class="right"><select name="gender" id="gender">
								
										<option value="">-----Select-----</option>
										<option value="Male">Male</option>
										<option value="Female">Female</option>
										
								</select>
								</td>
								
								<td class="left">Blood Group<font color="red">*</font></td>
								<td class="right">
									<select name="bloodGroup"
									id="bloodGroup" class="userLocationId">

										<option value="">-----Select-----</option>
										<option value="A+ve">A+ve</option>
										<option value="B+ve">B+ve</option>
										<option value="A-ve">A-ve</option>
										<option value="B-ve">B-ve</option>
										<option value="AB+ve">AB+ve</option>
										<option value="AB-ve">AB-ve</option>
										<option value="O+ve">O+ve</option>
										<option value="O-ve">O-ve</option>
								</select>
								</td>
							</tr>
							
							
							<tr class="trc">

								<td class="left">Marital Status<font color="red">*</font></td>
								<td class="right"><select
									id="maritalStatus" name="maritalStatus">

										<option value="">---Select Option---</option>
										<option value="Bachelor">Bachelor</option>
										<option value="Married">Married</option>
								</select>
								</td>
								
								<td class="left">Date Of Birth<font color="red">*</font></td>
								<td class="right">
									<input type="text" name="dateOfBirth" id="dateOfBirth"
									value="<logic:present name="employeeDetails" property="dateOfBirth"><bean:write name="employeeDetails" property="dateOfBirth" /></logic:present>"
									class="datePicker" readonly="readonly" placeholder="Click here" />
								</td>
							</tr>
							
							<tr class="trc">
							
							<td class="left">Present Address<font color="red">*</font></td>
								<td class="right">
									<textarea id="presentAddress" name="presentAddress" maxlength="250">
										<logic:present name="employeeDetails" property="presentAddress">
											<bean:write name="employeeDetails" property="presentAddress" />
										</logic:present>
									</textarea>
								</td>

								<td class="left">Permanent Address<font color="red">*</font></td>
								<td class="right">
									<textarea id="permanentAddress" name="permanentAddress" maxlength="250">
									<logic:present name="employeeDetails" property="permanentAddress">
										<bean:write name="employeeDetails" property="permanentAddress" />
									</logic:present>
									</textarea>
								</td>
							</tr>
							
							<tr class="trc">

								<td class="left">Date Of Joining<font color="red">*</font></td>
								<td class="right"><input type="text" name="dateOfJoining" id="dateOfJoining"
									value="<logic:present name="employeeDetails" property="dateOfJoining"><bean:write name="employeeDetails" property="dateOfJoining" /></logic:present>"
									class="dateofjoin" readonly="readonly" placeholder="Click here" />
								</td>
								
								<td class="left">Mobile No<font color="red">*</font></td>
								<td class="right">
									<input type="text" id="mobileNo" name="mobileNo" maxlength="10"
									value="<logic:present name="employeeDetails" property="mobileNo"><bean:write name="employeeDetails" property="mobileNo" /></logic:present>" />
								</td>
							</tr>
							
							
							<tr class="trc">

								<td class="left">Voter Id No<font color="red"></font></td>
								<td class="right">
									<input type="text" id="voterIdNo" name="voterIdNo" onblur="checkVoterIdUnique(this.value)"
									value="<logic:present name="employeeDetails" property="voterIdNo"><bean:write name="employeeDetails" property="voterIdNo" /></logic:present>" maxlength="20" />
								</td>
								
								<td class="left">Addhar Card No<font color="red"></font></td>
								<td class="right">
									<input type="text" id="addharCardNo" name="addharCardNo"
									onblur="checkAddharCardUnique(this.value)"
									value="<logic:present name="employeeDetails" property="addharCardNo"><bean:write name="employeeDetails" property="addharCardNo" />
													</logic:present>"
									maxlength="20" />
								</td>
								
							</tr>
							
							<tr class="trc">

							
								
								<td class="left">DL No<font color="red"></font></td>
								<td class="right">
									<input
									type="text" id="drivingLicenceNo" name="drivingLicenceNo"
									onblur="checkDLNoUnique(this.value)"
									value="<logic:present name="employeeDetails" property="drivingLicenceNo"><bean:write name="employeeDetails" property="drivingLicenceNo" />
													</logic:present>"
									maxlength="20" />
								</td>
								
								<td class="left">Personal Email Id<font color="red"></font></td>
								<td class="right">
									<input
									type="text" id="personalEmailId" name="personalEmailId"
									value="<logic:present name="employeeDetails" property="personalEmailId"><bean:write name="employeeDetails" property="personalEmailId" />
													</logic:present>"
									maxlength="30" />
								</td>
								
							</tr>
							
							<tr class="trc">
								
								<td class="left">Official Email Id<font color="red">*</font></td>
								<td class="right">
									<input
									type="text" id="officialEmailId" name="officialEmailId"
									value="<logic:present name="employeeDetails" property="officialEmailId"><bean:write name="employeeDetails" property="officialEmailId" />
													</logic:present>"
									onblur="checkDuplicateEmailId(this.value)" maxlength="80" />
								</td>
								
								<td class="left">Employee Status<font color="red">*</font></td>
								<td class="right">
									<select name="empStatus"
									id="empStatus">

										<option value="">-----Select-----</option>
										<option value="Left">Left</option>
										<option value="Present">Present</option>
								</select>
								</td>
								
							</tr>
							
							
							<tr class="trc">

								<td class="left">Employee Type<font color="red">*</font></td>
								<td class="right">
									<select name="empType"
									 id="empType">

										<option value="">-----Select-----</option>
										<option value="OnSite">On Site</option>
										<option value="OffShore">Off Shore</option>
								</select>
								</td>
								
								<td class="left">Biometric Id<font color="red">*</font></td>
								<td class="right">
									<input
									type="text" id="biometricId" name="biometricId"
									onblur="checkDuplicateBiometricId(this.value)" maxlength="8" 
									
									value="<logic:present name="employeeDetails" property="biometricId"><bean:write name="employeeDetails" property="biometricId" />
													</logic:present>"
									/>
								</td>
							</tr>
							
							
							<tr class="trc">

								
								
								<td class="left">Date Of Leaving<font color="red"></font></td>
								<td class="right">
									<input type="text"
									name="dateOfLeaving" id="dateOfLeaving"
									value="<logic:present name="employeeDetails" property="dateOfLeaving"><bean:write name="employeeDetails" property="dateOfLeaving" />
													</logic:present>"
									 readonly="readonly" placeholder="Click here"
									style="z-index: -1;" />
								</td>
							</tr>

						</table><br/>
						
						
						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
							
							 <td colspan="5" class="head11" >	<span class="head11" >Family Details</span> </td>
							</tr>
							
							
							<tr class="trc">

								<td class="left">Father's Name<font color="red">*</font></td>
								<td class="right">
									<input type="text" id="fatherName" name="fatherName"
									value="<logic:present name="employeeDetails" property="fatherName"><bean:write name="employeeDetails" property="fatherName" /></logic:present>" maxlength="30" />
								</td>
								
								<td class="left">Father's DOB<font color="red">*</font></td>
								<td class="right">
									<input type="text" id="fatherDOB" name="fatherDOB"
									value="<logic:present name="employeeDetails" property="fatherDOB"><bean:write name="employeeDetails" property="fatherDOB" /></logic:present>"
									class="datePicker" readonly="readonly" placeholder="Click here" />
								</td>
							</tr>
							
							<tr class="trc">

								<td class="left">Mother's Name<font color="red">*</font></td>
								<td class="right">
									<input type="text" id="motherName" name="motherName"
									value="<logic:present name="employeeDetails" property="motherName"><bean:write name="employeeDetails" property="motherName" /></logic:present>"
									maxlength="30" />
								</td>
								
								<td class="left">Mother's DOB<font color="red">*</font></td>
								<td class="right">
									 <input type="text" id="motherDOB" name="motherDOB"
									value="<logic:present name="employeeDetails" property="motherDOB"><bean:write name="employeeDetails" property="motherDOB" />
													</logic:present>"
									class="datePicker" readonly="readonly" placeholder="Click here" />
								</td>
							</tr>
							
							<tr class="trc">

								<td class="left">Date Of Mariage<font color="red"></font></td>
								<td class="right">
									 <input type="text" id="dateOfMariage" name="dateOfMariage"
									value="<logic:present name="employeeDetails" property="dateOfMariage"><bean:write name="employeeDetails" property="dateOfMariage" /></logic:present>"
									class="datePicker" readonly="readonly" placeholder="Click here"
									style="z-index: -1;" />
								</td>
								
								<td class="left">Spouse's Name<font color="red"></font></td>
								<td class="right">
									<input
									type="text" id="spouseName" name="spouseName"
									value="<logic:present name="employeeDetails" property="spouseName"><bean:write name="employeeDetails" property="spouseName" />
													</logic:present>"
									maxlength="30" />
								</td>
							</tr>
							
							<tr class="trc">

								<td class="left">Spouse's DOB<font color="red"></font></td>
								<td class="right">
									<input
									type="text" id="spouseDOB" name="spouseDOB"
									value="<logic:present name="employeeDetails" property="spouseDOB"><bean:write name="employeeDetails" property="spouseDOB" />
													</logic:present>"
									class="datePicker" readonly="readonly" placeholder="Click here"
									style="z-index: -1;" />
								</td>
								
								<td class="left">Child 1<font color="red"></font></td>
								<td class="right">
									<input
									type="text" id="firstChildName" name="firstChildName"
									value="<logic:present name="employeeDetails" property="firstChildName"><bean:write name="employeeDetails" property="firstChildName" />
													</logic:present>"
									maxlength="20" />
								</td>
							</tr>
						
						
							
								<tr class="trc">

								<td class="left">Child 1 DOB <font color="red"></font></td>
								<td class="right">
									 <input
									type="text" id="firstChildDOB" name="firstChildDOB"
									value="<logic:present name="employeeDetails" property="firstChildDOB"><bean:write name="employeeDetails" property="firstChildDOB" />
													</logic:present>"
									class="datePicker" readonly="readonly" placeholder="Click here"
									style="z-index: -1;" />
								</td>
								
								<td class="left">Child 2<font color="red"></font></td>
								<td class="right">
									<input
									type="text" id="secondChildName" name="secondChildName"
									value="<logic:present name="employeeDetails" property="secondChildName"><bean:write name="employeeDetails" property="secondChildName" />
													</logic:present>"
									maxlength="20" />
								</td>
							</tr>
							
							
								<tr class="trc">

								<td class="left">Child 2 DOB <font color="red"></font></td>
								<td class="right">
									<input
									type="text" id="secondChildDOB" name="secondChildDOB"
									value="<logic:present name="employeeDetails" property="secondChildDOB"><bean:write name="employeeDetails" property="secondChildDOB" />
													</logic:present>"
									class="datePicker" readonly="readonly" placeholder="Click here"
									style="z-index: -1;" />
								</td>
								
								<td class="left">Family Phone No<font color="red">*</font></td>
								<td class="right">
									<input
									type="text" id="familyPhoneNo" name="familyPhoneNo"
									value="<logic:present name="employeeDetails" property="familyPhoneNo"><bean:write name="employeeDetails" property="familyPhoneNo" />
													</logic:present>"
									maxlength="12" />
								</td>
							</tr>

						
						</table><br/>

						
						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
							
							 <td colspan="5" class="head11" >	<span class="head11" >Passport Details</span> </td>
								
							</tr>
							
							
							<tr class="trc">

								<td class="left">Passport No <font color="red"></font></td>
								<td class="right">
									 <input
									type="text" id="passportNo" name="passportNo"
									onblur="checkPassportNoUnique(this.value)"
									value="<logic:present name="employeeDetails" property="passportNo"><bean:write name="employeeDetails" property="passportNo" />
													</logic:present>"
									maxlength="20" />
								</td>
								
								<td class="left">Passport Issue Date<font color="red"></font></td>
								<td class="right">
									<input
									type="text" id="passportIssueDate" name="passportIssueDate"
									value="<logic:present name="employeeDetails" property="passportIssueDate"><bean:write name="employeeDetails" property="passportIssueDate" />
													</logic:present>"
									class="datePicker" readonly="readonly" placeholder="Click here" />
								</td>
							</tr>
							
							<tr class="trc">

								<td class="left">Passport Expiry Date<font color="red"></font></td>
								<td class="right">
									<input
									type="text" id="passportExpiryDate" name="passportExpiryDate"
									value="<logic:present name="employeeDetails" property="passportExpiryDate"><bean:write name="employeeDetails" property="passportExpiryDate" />
													</logic:present>"
									class="dateAfterCurrentDate" readonly="readonly"
									placeholder="Click here" />
								</td>
								
								<td class="left">Passport Issue Place<font color="red"></font></td>
								<td class="right">
									<input
									type="text" id="passportIssuePlace" name="passportIssuePlace"
									value="<logic:present name="employeeDetails" property="passportIssuePlace"><bean:write name="employeeDetails" property="passportIssuePlace" />
													</logic:present>"
									maxlength="20" />
								</td>
							</tr>

						</table><br/>

						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
								 <td colspan="5" class="head11" >	<span class="head11" >Bank Details</span> </td>
							</tr>
							
							
							<tr class="trc">

								<td class="left">Account No<font color="red"></font></td>
								<td class="right">
									<input
									type="text" id="hdfcAccountNo" name="hdfcAccountNo"
									onchange="checkAccountNoUnique(this.value)"
									value="<logic:present name="employeeDetails" property="hdfcAccountNo"><bean:write name="employeeDetails" property="hdfcAccountNo" />
													</logic:present>"
									maxlength="20" />
								</td>
								
								<td class="left">Bank Name <font color="red"></font></td>
								<td class="right">
									<input
									type="text" id="bankName" name="bankName"
									value="<logic:present name="employeeDetails" property="bankName"><bean:write name="employeeDetails" property="bankName" />
													</logic:present>"
									maxlength="20" />
								</td>
							</tr>
							
							<tr class="trc">

								<td class="left">Branch Name<font color="red"></font></td>
								<td class="right">
									<input
									type="text" id="bankBranchName" name="bankBranchName"
									value="<logic:present name="employeeDetails" property="bankBranchName"><bean:write name="employeeDetails" property="bankBranchName" />
													</logic:present>"
									maxlength="20" />
								</td>
								
								<td class="left">IFSC Code <font color="red"></font></td>
								<td class="right">
								<input
									type="text" id="bankIfscCode" name="bankIfscCode"
									value="<logic:present name="employeeDetails" property="bankIfscCode"><bean:write name="employeeDetails" property="bankIfscCode" />
													</logic:present>"
									maxlength="11" />
								</td>
							</tr>

						</table><br/>




						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
							 <td colspan="5" class="head11" >	<span class="head11" >Previous Company Details</span> </td>
							</tr>
							
							
							<tr class="trc">

								<td class="left">Previous Company Name<font color="red"></font></td>
								<td class="right">
									<input type="text" id="previousCompanyName"
									name="previousCompanyName"
									value="<logic:present name="employeeDetails" property="previousCompanyName"><bean:write name="employeeDetails" property="previousCompanyName" />
													</logic:present>"
									maxlength="50" />
								</td>
								
								<td class="left">Previous Company Designation<font color="red"></font></td>
								<td class="right">
								<input type="text" id="lastCompanyDesignation"
									name="lastCompanyDesignation"
									value="<logic:present name="employeeDetails" property="lastCompanyDesignation"><bean:write name="employeeDetails" property="lastCompanyDesignation" />
													</logic:present>"
									maxlength="20" />
								</td>
							</tr>
							
							
							<tr class="trc">

								<td class="left">Last Drawn Salary (RS)<font color="red"></font></td>
								<td class="right">
										<input type="text" id="lastDrawnSalaryInRS"
									name="lastDrawnSalaryInRS" value="0"
									value="<logic:present name="employeeDetails" property="lastDrawnSalaryInRS"><bean:write name="employeeDetails" property="lastDrawnSalaryInRS" />
													</logic:present>"
									maxlength="10" />
								</td>
								
								<td class="left">Total Experience <font color="red"></font></td>
								<td class="right">
								<input
									type="text" id="totalExperience" name="totalExperience"
									value="<logic:present name="employeeDetails" property="totalExperience"><bean:write name="employeeDetails" property="totalExperience" />
													</logic:present>"
									maxlength="" />
								</td>
							</tr>
							
						
						</table><br/>
						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
							
							<td colspan="5" class="head11" >	<span class="head11" >Educational Details</span> </td>
							</tr>
							
							<tr class="trc">

								<td class="left">Major Qualification<font color="red">*</font></td>
								<td class="right">
										<select id="majorQualification" name="majorQualification">
										<option value="">---Select Option---</option>
										<option value="X">X</option>
										<option value="XII">XII</option>
										<option value="ITI">ITI</option>
										<option value="Diploma">Diploma</option>
										<option value="BCA">BCA</option>
										<option value="BSC">BSC</option>
										<option value="BCOM">BCOM</option>
										<option value="Graduation">Graduation</option>
										<option value="B-Tech">B-Tech</option>
										<option value="BE">BE</option>
										<option value="MCA">MCA</option>
										<option value="MCOM">MCOM</option>
										<option value="B-Tech">M-Tech</option>
										<option value="Post_Graduation">Post Graduation</option>
								</select>
								</td>
								
								<td class="left">University/Board<font color="red">*</font></td>
								<td class="right">
								<input
									type="text" id="universityOrBoard" name="universityOrBoard"
									value="<logic:present name="employeeDetails" property="universityOrBoard"><bean:write name="employeeDetails" property="universityOrBoard" />
													</logic:present>"
									 maxlength="45" />
								</td>
							</tr>
							
							
							
							<tr class="trc">

								<td class="left">Year Of Passing<font color="red">*</font></td>
								<td class="right">
										<input
									type="text" id="yearOfPassing" name="yearOfPassing"
									value="<logic:present name="employeeDetails" property="yearOfPassing"><bean:write name="employeeDetails" property="yearOfPassing" />
													</logic:present>"
									maxlength="2" class="yearPicker" readonly="readonly"
									placeholder="Click here" />
								</td>
								
								<td class="left">College/Institute<font color="red">*</font></td>
								<td class="right">
								<input
									type="text" id="collegeOrInstituteName"
									name="collegeOrInstituteName"
									value="<logic:present name="employeeDetails" property="collegeOrInstituteName"><bean:write name="employeeDetails" property="collegeOrInstituteName" />
													</logic:present>"
									 maxlength="80" />
								</td>
							</tr>
							
						</table><br/>

						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
							<td colspan="5" class="head11" >	<span class="head11" >Attachments</span> </td>
							</tr>
							
							<tr>
								
								<td class="label">Emp Image<font color="red">*</font></td>
								<td><input type="file" id="empImage" name="empImage" />
									<img src="<logic:present name="employeeDetails" property="empImage"><bean:write name="employeeDetails" property="empImage" /></logic:present>"
									width="100px" height="100px" id="empImagePreview" />
								</td>
								<td class="label">Pan Card  <font color="red"></font></td>
								<td>
									<input type="file" id="securityDocument" name="securityDocument" />
									<img src="<logic:present name="employeeDetails" property="securityDocument"><bean:write name="employeeDetails" property="securityDocument" /></logic:present>"
									width="100px" height="100px" id="securityDocumentPreview" />
									
								</td>
								
							</tr>
							
							<tr>
								<td align="left" width="20%" class="label">Election ID</td>
								<td><logic:present
										name="employeeDetails" property="document1">

										<input type="file" id="document1" name="document1"
											class="docFile" style="display: none;" />
										<logic:notEqual value="" name="employeeDetails"
											property="document1">
											<input type="button" id="document1btn"
												name="<bean:write name="employeeDetails" property="document1" />"
												class="downloadDoc" value="Download" />
										</logic:notEqual>

									</logic:present> <logic:notPresent name="employeeDetails" property="document1">
										<input type="file" id="document1" name="document1"
											class="docFile" />
										<input type="button" id="document1btn" name=""
											class="downloadDoc" value="Download" style="display: none;" />
									</logic:notPresent></td>

								<td align="left" width="20%" class="label">Adhar Card</td>
								<td><logic:present
										name="employeeDetails" property="document2">

										<input type="file" id="document2" name="document2"
											class="docFile" style="display: none;" />
										<logic:notEqual value="" name="employeeDetails"
											property="document2">
											<input type="button" id="document2btn"
												name="<bean:write name="employeeDetails" property="document2" />"
												class="downloadDoc" value="Download" />
										</logic:notEqual>

									</logic:present> <logic:notPresent name="employeeDetails" property="document2">
										<input type="file" id="document2" name="document2"
											class="docFile" />
										<input type="button" id="document2btn" name=""
											class="downloadDoc" value="Download" style="display: none;" />
									</logic:notPresent></td>
								
								
                            </tr>
                            <tr>
								<td align="left" width="20%" class="label">Driving Licence</td>
								<td><logic:present
										name="employeeDetails" property="document3">

										<input type="file" id="document3" name="document3"
											class="docFile" style="display: none;" />
										<logic:notEqual value="" name="employeeDetails"
											property="document3">
											<input type="button" id="document3btn"
												name="<bean:write name="employeeDetails" property="document3" />"
												class="downloadDoc" value="Download" />
										</logic:notEqual>

									</logic:present> <logic:notPresent name="employeeDetails" property="document3">
										<input type="file" id="document3" name="document3"
											class="docFile" />
										<input type="button" id="document3btn" name=""
											class="downloadDoc" value="Download" style="display: none;" />
									</logic:notPresent></td>
                                <td align="left" width="20%" class="label">Other</td>
								<td><logic:present
										name="employeeDetails" property="document4">


										<input type="file" id="document4" name="document4"
											class="docFile" style="display: none;" />

										<logic:notEqual value="" name="employeeDetails"
											property="document4">
											<input type="button" id="document4btn"
												name="<bean:write name="employeeDetails" property="document4" />"
												class="downloadDoc" value="Download" />
										</logic:notEqual>

									</logic:present> <logic:notPresent name="employeeDetails" property="document4">
										<input type="file" id="document4" name="document4"
											class="docFile" />
										<input type="button" id="document4btn" name=""
											class="downloadDoc" value="Download" style="display: none;" />
									</logic:notPresent></td>

							</tr>
						
						</table>
						
                       </br>
                       <table cellpadding="5" cellspacing="0" id="biometric_1"  width="85%">
                   
						</table>

						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
						
						<tr>
								<td colspan="5" class="head11" ><span class="head11" > Remarks </span> </td>
						</tr>
							<tr>
								<td style="text-align: center;"><textarea id="remarks"
										name="remarks" maxlength="200">	<logic:present
											name="employeeDetails" property="remarks">
										<bean:write name="employeeDetails" property="remarks" />
										</logic:present>
										</textarea></td>
							</tr>
						
						
						</table>


						<center>

							<table>
								<tr class="odd">

									<td colspan="3"><center>
											<input type="submit" class="submitbutton" value="Update"
												class="button1" id="register" /> &nbsp;&nbsp;&nbsp; <input
												type="button" value="Clear" class="submitbutton" id="clear"
												onclick="clearALL()" />
										</center></td>
								</tr>
							</table>
						</center>
					</fieldset>
				</div>

				<br />
			</form>
		</center>
	</div>
	<input type="hidden" name="hiddenBioId" id="hiddenBioId" value=""></input>

</body>



</html>
