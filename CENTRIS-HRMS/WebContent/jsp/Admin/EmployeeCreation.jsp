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
<title>Employee</title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="js/Admin/Employee.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

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
		style="position: absolute; top: 180%; left: 45%; display: none; ">
		<img src="images/loaderimage2.GIF" width="150px" height="150px" />
	</div>

		<center>
		
		

			<div class="backgroundDiv" id="backgroung">Employee Details</div>
		

			<form action="employee.do?parameter=registerEmployee"
				name="AddEmployeeForm" method="post" enctype="multipart/form-data"
				onsubmit="return validateEmployeeDetails()">

				<center>
				
				<input type="hidden" name="hbioId" id="hbioId"
			value="<logic:present name="BioId"><bean:write name="BioId" /></logic:present>" />

					<div id="errordiv" class="error-box" align="center">

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
					
						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
<!-- 								<h3 colspan="5" class="head">Personal Details</h3> -->
							 <td colspan="5" class="head11" >	<span class="head11" > Personal Details</span> </td>
							</tr>

							<tr class="trc">

								<td class="left">Employee First Name<font color="red">*</font></td>
								<td class="right"><input type="text" name="empFirstName" id="empFirstName" maxlength="50" /></td>
									<td class="left">Base Location<font color="red">*</font></td>
								<td class="right"><input type="text" name="baseLocation" id="baseLocation" maxlength="30" /></td>
								
							<tr>
								<td class="left">Designation<font color="red">*</font></td>
								<td class="right">
								<select name="designation" id="designation">
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
		                        <td class="left">Pan Card No</td>
								<td class="right"><input type="text" id="panCardNo" name="panCardNo" onblur="checkPanCardUnique(this.value)" maxlength="20" /></td>
								
								</tr>
								<tr>
								<td class="left">Gender <font color="red">*</font></td>
								<td class="right">
								<select name="gender" id="gender">
										<option value="">-----Select-----</option>
										<option value="Male">Male</option>
										<option value="Female">Female</option>
								</select>
								</td>

								<td class="left">Blood Group <font color="red">*</font></td>
								<td class="right">
								<select name="bloodGroup" id="bloodGroup" class="userLocationId">
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
							<tr>
							<td class="left">Marital Status<font color="red">*</font></td>
							<td class="right">
							<select id="maritalStatus" name="maritalStatus">
										<option value="">---Select Option---</option>
										<option value="Bachelor">Bachelor</option>
										<option value="Married">Married</option>
								</select>
								</td>
								<td class="left">Date Of Birth <font color="red">*</font></td>
								<td class="right"><input type="text" name="dateOfBirth" id="dateOfBirth" class="datePicker"
									readonly="readonly" placeholder="Click here" /></td>
								<tr>	
								<td class="left">Present Address<font color="red">*</font></td>
								<td class="right">
								<textarea id="presentAddress" name="presentAddress" maxlength="250"></textarea></td>
								<td class="left">Permanent Address<font color="red">*</font></td>
								<td class="right"><textarea id="permanentAddress" name="permanentAddress"  maxlength="250"></textarea></td>
								</tr>
								<tr>
								
								<td class="left">Date Of Joining <font color="red">*</font></td>
								<td class="right">
								<input type="text" name="dateOfJoining" id="dateOfJoining" class="dateofjoin" readonly="readonly" placeholder="Click here" /></td>
								 <td class="left">Mobile No<font color="red">*</font></td>
								<td class="right"><input type="text" id="mobileNo" name="mobileNo" maxlength="10" /></td>
							</tr>

							<tr>                        
                             
						
								<tr>
								<td class="left">Voter Id No</td>
								<td class="right"><input type="text" id="voterIdNo" name="voterIdNo" onblur="checkVoterIdUnique(this.value)" maxlength="20" /></td>
								<td class="left">Addhar Card No</td>
								<td class="right">
								<input type="text" id="addharCardNo" name="addharCardNo" onblur="checkAddharCardUnique(this.value)" maxlength="20" /></td>
							</tr>

							<tr>
							<td class="left">DL No</td>
							<td class="right"><input type="text" id="drivingLicenceNo" name="drivingLicenceNo" onblur="checkDLNoUnique(this.value)" maxlength="20" /></td>
							<td class="left">Personal Email Id</td>
							<td class="right"><input type="text" id="personalEmailId" name="personalEmailId" maxlength="80" /></td>
							<tr>
								<td class="left">Official Email Id<font color="red">*</font></td>
								<td class="right"><input type="text" id="officialEmailId" name="officialEmailId" onblur="checkDuplicateEmailId(this.value)" maxlength="80" /></td>
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
								
							<tr id="biometricId_td">
							
							<td class="left">Employee Type<font color="red">*</font></td>
							<td class="right">
							 <select name="empType"
									id="empType">
										<option value="">-----Select-----</option>
										<option value="OnSite">On Site</option>
										<option value="OffShore">Off Shore</option>
							 </select>
							</td>
								<td class="left">Biometric Id <font color="red">*</font></td>
								<td class="right">
								
								<input type="text" style="width: 60%;height: 80%; vertical-align: top;"  id="biometricId" name="biometricId" onblur="checkDuplicateBiometricId(this.value)" maxlength="8" />
								<img src="images/refresh1.png" style="width: 20%;"  class="refresh" id="refreshBioId" name="refreshBioId" onclick="getBioId()"></img>
								
								
								</td>
							</tr>
							<tr>
								<td class="left">Date Of Leaving </td>
								<td class="right">
								<input type="text"
									name="dateOfLeaving" id="dateOfLeaving" 
									readonly="readonly" placeholder="Click here"
									style="z-index: -1;" />
								</td>
								
							</tr>
						</table>
                         <br>
						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
<!-- 								<h3 colspan="5" class="head">Family Details</h3> -->
								<td colspan="5" class="head11" ><span class="head11" > Family Details</span> </td>
							</tr>
							<tr>
								<td class="left">Father's Name<font color="red">*</font></td>
								<td class="right">
								<input type="text" id="fatherName" name="fatherName" maxlength="30" /></td>
								<td class="left">Father's DOB<font color="red">*</font></td>
								<td class="right">
								<input type="text" id="fatherDOB" name="fatherDOB" class="datePicker"
									readonly="readonly" placeholder="Click here" /></td>
							</tr>		
								<tr>	
                              <td class="left">Mother's Name <font color="red">*</font></td>
							  <td class="right"><input type="text" id="motherName" name="motherName" maxlength="30" /></td>
							  <td class="left">Mother's DOB<font color="red">*</font></td>
							  <td class="right"><input type="text" id="motherDOB" name="motherDOB" class="datePicker" readonly="readonly" placeholder="Click here" /></td>
							 

							</tr>
							<tr>
							 <td class="left">Date Of Mariage</td>
							  <td class="right"><input type="text" id="dateOfMariage" name="dateOfMariage"
									class="datePicker" readonly="readonly" placeholder="Click here"
									style="z-index: -1;" /></td>
							  <td class="left">Spouse's Name</td>
							  <td class="right"><input type="text" id="spouseName" name="spouseName" maxlength="30" /></td>
                            </tr>
                            <tr>
							<td class="left">Spouse's DOB</td>
							<td class="right"><input type="text" id="spouseDOB" name="spouseDOB" class="datePicker" readonly="readonly" placeholder="Click here"
									style="z-index: -1;" /></td>
							<td class="left">Child 1</td>
						    <td class="right">
								<input type="text" id="firstChildName" name="firstChildName"
									maxlength="20" /></td>
                             </tr>
                             <tr>
								<td class="left">Child 1 DOB</td>
								<td class="right">
								<input type="text" id="firstChildDOB" name="firstChildDOB"
									class="datePicker" readonly="readonly" placeholder="Click here"
									style="z-index: -1;" /></td>


								<td class="left">Child 2</td>
								<td class="right">
								<input type="text" id="secondChildName" name="secondChildName"
									maxlength="20" /></td>

							</tr>
							<tr>
								<td class="left">Child 2 DOB</td>
								<td class="right">
								<input type="text" id="secondChildDOB" name="secondChildDOB"
									class="datePicker" readonly="readonly" placeholder="Click here"
									style="z-index: -1;" /></td>
								<td class="left">Family Phone No<font color="red">*</font></td>
								<td class="right">
								<input type="text" id="familyPhoneNo" name="familyPhoneNo" 
									maxlength="12" /></td>
			


							</tr>
						</table>
                       <br>
						
						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
<!-- 								<h3 colspan="5" class="head">Passport Details</h3> -->
								<td colspan="5" class="head11" ><span class="head11" > Passport Details</span> </td>
							</tr>
							<tr>

								<td class="left">Passport No</td>
								<td class="right">
								<input type="text" id="passportNo" name="passportNo"
									onblur="checkPassportNoUnique(this.value)" maxlength="20" /></td>


								<td class="left">Passport Issue Date</td>
								<td class="right">
								
								<input type="text" id="passportIssueDate" name="passportIssueDate"
									class="datePicker" readonly="readonly" placeholder="Click here" /></td>

                            </tr>
                            
                            <tr>
								<td class="left">Passport Expiry Date</td>
								<td class="right">
								<input type="text" id="passportExpiryDate" name="passportExpiryDate"
									class="dateAfterCurrentDate" readonly="readonly"
									placeholder="Click here" /></td>


								<td class="left">Passport Issue Place</td>
								<td class="right">
								<input type="text" id="passportIssuePlace" name="passportIssuePlace"
									maxlength="20" /></td>
							</tr>

						</table>
						<br>
						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
<!-- 								<h3 colspan="5" class="head" class="label">Bank Details</h3> -->
								<td colspan="5" class="head11" ><span class="head11" > Bank Details </span> </td>
							</tr>
							<tr>

								<td class="left">HDFC Account No</td>
								<td class="right">
								<input type="text" id="hdfcAccountNo" name="hdfcAccountNo" 
									onchange="checkAccountNoUnique(this.value)" maxlength="20" /></td>
								<td class="left">Bank Name</td>
								<td class="right">
								<input type="text" id="bankName" name="bankName" maxlength="20" /></td>
                            </tr>
                              <tr> 
								<td class="left">Branch Name</td>
								<td class="right">
								<input type="text" id="bankBranchName" name="bankBranchName"
									maxlength="20" /></td>


								<td class="left">IFSC Code</td>
								<td class="right">
								<input type="text" id="bankIfscCode" name="bankIfscCode"
									maxlength="11" /></td>
							</tr>

						</table>
						<br>
						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
<!-- 								<h3 colspan="4" class="head" class="label">Previous Company Details</h3> -->
								<td colspan="5" class="head11" ><span class="head11" > Previous Company Details </span> </td>
							</tr>
							<tr>
								<td class="left">Previous Company Name</td>
								<td class="right">
									<input type="text" id="previousCompanyName"
									name="previousCompanyName" maxlength="50" /></td>


								<td class="left">Previous Company Designation</td>
								<td class="right">
									<input type="text" id="lastCompanyDesignation"
									name="lastCompanyDesignation" maxlength="20" /></td>
                             </tr>
                             
                             <tr>

								<td class="left">Last Drawn Salary (RS) </td>
								<td class="right">
									<input type="text" id="lastDrawnSalaryInRS"
									name="lastDrawnSalaryInRS" value="0" maxlength="10" /></td>

								<td class="left">Total Experience </td>
								<td class="right">
								<input type="text" id="totalExperience" name="totalExperience"
									value="0"  /></td>

							</tr>
						</table>
						<br>
						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
<!-- 								<h3 colspan="4" class="head">Educational Details</h3> -->
								<td colspan="5" class="head11" ><span class="head11" > Educational Details </span> </td>
							</tr>
							<tr>
								<td class="left">Major Qualification <font color="red">*</font></td>
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

								<td class="left">University/Board <font color="red">*</font></td>
								<td class="right">
								<input type="text" id="universityOrBoard" name="universityOrBoard"
									maxlength="45" /></td>
                             </tr>
                             
                             <tr>
								<td class="left">Year Of Passing<font color="red">*</font> </td>
								<td class="right">
								<input type="text" id="yearOfPassing" name="yearOfPassing" class="yearPicker" readonly="readonly" placeholder="Click here" /></td>


								<td class="left">College/Institute<font color="red">*</font> </td>
								<td class="right">
								<input type="text" id="collegeOrInstituteName" name="collegeOrInstituteName" maxlength="80" /></td>

							</tr>
						</table>
                        <br>
						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
<!-- 								<h3 colspan="4" class="head">Attachments</h3> -->
								<td colspan="5" class="head11" ><span class="head11" >Attachments </span> </td>
							</tr>
							<tr>
								
								<td class="label">Emp Image<font color="red">*</font></td>
								<td><input type="file" id="empImage" name="empImage" /><img src="" width="100px"
									height="100px" id="empImagePreview" /></td>
									
								<td class="label">Pan Card  <font color="red"></font></td><td>
								<input type="file" id="securityDocument" name="securityDocument" /><img src="" width="100px" height="100px" id="securityDocumentPreview" /></td>
								

							</tr>
							<tr>
								<td align="left" width="20%" class="label">Election ID</td>
								<td><input type="file" id="document1" name="document1" /></td>

								<td align="left" width="20%" class="label">Adhar Card</td>
								<td><input type="file" id="document2" name="document2" /></td>
								
								
                            </tr>
                            <tr>
								<td align="left" width="20%" class="label">Driving Licence</td>
								<td><input type="file" id="document3" name="document3" /></td>
                                <td align="left" width="20%" class="label">Other</td>
								<td><input type="file" id="document4" name="document4" /></td>

							</tr>
						</table>
						
                          <span id="fileUploaddynmic"  style="margin-left:70%;text-decoration: underline;color:blue;cursor: pointer;">Add More Attachements</span>
                       
                       <table cellpadding="5" cellspacing="0" id="biometric_1" width="85%">
                   
						</table>
						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
<!-- 								<h3 colspan="4" class="head">Remarks<font color="red"></font></h3> -->
								<td colspan="5" class="head11" ><span class="head11" > Remarks </span> </td>
							</tr>
							<tr>
								<td style="text-align: center;"><textarea id="remarks"
										name="remarks" maxlength="200"></textarea></td>
							</tr>
						</table>
                        

						<center>

							<table>
								<tr class="odd">

									<td colspan="3"><center>
											<input type="submit" class="submitbutton" value="Register"
												class="button1" id="register" /> &nbsp;&nbsp;&nbsp; <input
												type="reset" value="Clear" class="submitbutton" id="clear" />
										</center></td>

								</tr>

							</table>
						</center>
					
				</div>

				<br />
			</form>
		</center>
	</div>


</body>



</html>
