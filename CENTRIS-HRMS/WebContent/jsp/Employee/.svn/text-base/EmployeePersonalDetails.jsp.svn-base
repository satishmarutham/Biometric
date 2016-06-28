<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script src="JQUERY/development-bundle/ui/jquery.ui.menu.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect-blind.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script language="javascript" src="js/common.js"></script>
<script language="javascript"
	src="js/Employee/EmployeePersonalDetails.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<style type="text/css">
td {
	text-class: left !important;
	/* font-weight: bold !important; */
}
</style>
</head>
<body>
	<div class="background" id="main">
		<center>
			<div class="backgroundDiv" id="backgroung" style="width: 100%;font-size:16px;">My
				Details</div>
		</center>
		<span style="font-size: 12px; padding-left: 44%;">Click
			Edit to update your details</span> <span
			style="padding-left: 94%; text-decoration: underline; cursor: pointer;"
			onclick="return editable()">Edit</span>
		<center>
			<div id="errordiv" class="error-box" class="center">
				<logic:present name="success" scope="request">
					<span style="color: green; font-family: Segoe UI;"> <bean:write
							name="success" />
					</span>
				</logic:present>
				<logic:present name="warning" scope="request">
					<span style="color: red; font-family: Segoe UI;"> <bean:write
							name="success" />
					</span>
				</logic:present>
			</div>
		</center>
		<form action="getEmployeePersonalDetails.do?method=UpdateEmployeeDetails"	method="post" enctype="multipart/form-data">
		<!-- 	<div class="tablecss" style="margin: 15px; text-class: center"
				id="tableId"> -->
     <div class="backgroundDiv" id="backgroung">
  	  <!--   <fieldset style="width:75%;margin-left:10%;"> -->
	
				<logic:present name="employeePersonalDetails" scope="request">
					<logic:iterate id="calMap" name="employeePersonalDetails"
						scope="request">
						<h3 class="head11" style="width:90%;margin-left:4%;cursor: pointer;">
							<span class="head11"><bean:write name="calMap" property="key" /></span>
						</h3>
						<div class="accBody">
							<table cellpadding="5" cellspacing="0" id="biometric" width="90%" style="margin-left:4%;">
                       
								<logic:iterate id="datalist" name="calMap" property="value"
									length="1">
									<logic:equal value="Personal Details" name="calMap"
										property="key">
										<tr class="trc">

											<td class="left">Employee Name<font color="red">*</font> </td>
											<td class="right"><input type="text" name="empFirstName" id="empFirstName"
												maxlength="20"	value="<bean:write name="datalist"	property="employeeName" />"
												readonly="readonly" /></td>
											<td class="left">Location<font color="red">*</font></td>
											<td class="right"><input  type="text" name="baseLocation" id="baseLocation"
												maxlength="20"	value="<bean:write name="datalist"	property="baseLocation" />"
												readonly="readonly" /></td>
									<%-- 			
												
											<td class="left">Reporting Manager</td>
											<td class="right"> <input
												type="text" name="reportingSupervisor"
												id="reportingSupervisor" maxlength="20"
												value="<bean:write name="datalist"
											property="reportingSupervisor" />"
												readonly="readonly" /></td> --%>

                                         </tr>
                                         <tr>
                                         	<td class="left" >Designation<font color="red">*</font></td>
											<td class="right"><input	type="text" name="designation" id="designation"
												maxlength="20"	value="<bean:write name="datalist"	property="designation" />"
												readonly="readonly" /></td>
											<td class="left">Pancard No</td>
											<td class="right"><input	type="text" name="panCardNo" id="panCardNo" maxlength="20"
												value="<bean:write name="datalist"	property="panCardNo" />"
												readonly="readonly" /></td>
											<%-- <td class="left" >Project Name</td>
											<td class="right"> <input
												type="text" name="project" id="project" maxlength="20"
												value="<bean:write name="datalist"
											property="project" />"
												readonly="readonly" /></td>
											<td class="left">Project Head</td>
											<td  class="right"><input	type="text" name="projectHead" id="projectHead"
												maxlength="20"	value="<bean:write name="datalist"	property="projectHead" />"
												readonly="readonly" /></td> --%>
										</tr>
											
										<tr>	
										
                                          <%--   <td class="left">Department</td>
                                            <td><input	type="text" name="department" id="department" maxlength="20"
												value="<bean:write name="datalist"
											property="department" />"	readonly="readonly" /></td> --%>
										<td class="left">Gender<font color="red">*</font></td>
										<td class="right"><select name="gender" id="gender" >
													<option value="">-----Select-----</option>
													<option value="Male">Male</option>
													<option value="Female">Female</option>
											</select></td>
										<td class="left">Blood Group<font color="red">*</font></td>
										<td class="right"><select
												name="bloodGroup" id="bloodGroup">
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
										
											<td class="left">Employee DOB<font color="red">*</font></td>
											<td class="right"> <input type="text" name="employeeDob" id="employeeDob"
												class="datePicker" maxlength="20"	value="<bean:write name="datalist"
											property="employeeDob" />"	readonly="readonly" /></td>
											
											<td class="left" width="20%">Voter ID</td>
											<td class="right"><input type="text" name="voterIdNo" id="voterIdNo" maxlength="20"
												value="<bean:write name="datalist"
											property="voterIdNo" />"readonly="readonly" /></td>
										</tr>
									
									<tr>	
										<td class="left">Date of Joining<font color="red">*</font></td>
										<td class="right"><input	type="text" name="dateOfJoining" id="dateOfJoining"
												class="" maxlength="20"	value="<bean:write name="datalist"
											property="dateOfJoining" />" readonly="readonly" /></td>
										<td class="left" >Mobile No<font color="red">*</font></td>
										<td class="right"><input	type="text" name="mobileNo" id="mobileNo" maxlength="10"
												value="<bean:write name="datalist"	property="mobileNo" />"
												readonly="readonly" /></td>
									</tr>
												
										<input type="hidden" name="hgender" id="hgender"
											value="<logic:present name="datalist" property="gender"><bean:write name="datalist" property="gender" />
													</logic:present>" />
										<input type="hidden" name="hbloodGroup" id="hbloodGroup"
											value="<logic:present name="datalist" property="bloodGroup"><bean:write name="datalist" property="bloodGroup" />
													</logic:present>" />
									
							                            
										<tr>
											<td class="left" >Addhar Card No</td>
											<td class="right"><input	type="text" name="addharCardNo" id="addharCardNo"
												maxlength="20"	value="<bean:write name="datalist"
											property="addharCardNo" />" 	readonly="readonly" /></td>
									
											<td class="left">Driving Licence</td>
											<td class="right">  <input
												type="text" name="drivingLicenceNo" id="drivingLicenceNo"
												maxlength="20"	value="<bean:write name="datalist"
											property="drivingLicenceNo" />"	readonly="readonly" /></td>
									 </tr>
                                     <tr>		
											<td class="left" >Personal Email ID</td>
											<td class="right"><input
												type="text" name="personalEmailId" id="personalEmailId"
												onblur="checkPersonalDuplicateEmailId(this.value)"
												maxlength="80"
												value="<bean:write name="datalist"
											property="personalEmailId" />"
												readonly="readonly" /></td>
                                    
											<td class="left">Official Email ID<font color="red">*</font></td>
											<td class="right"><input	type="text" name="officialEmailId" id="officialEmailId"
												maxlength="80"	value="<bean:write name="datalist"
											property="officialEmailId" />"
												readonly="readonly" /></td>
										</tr>
										<tr>
									
											<td class="left">Employee Status<font color="red">*</font></td>
											<td class="right"><input
												type="text" name="empStatus" id="empStatus" maxlength="20"
												value="<bean:write name="datalist"
											property="empStatus" />"
												readonly="readonly" /></td>

											<td class="left" width="20%">Employee Type<font color="red">*</font></td>
											<td class="right"><input	type="text" name="empType" id="empType" maxlength="20"
												value="<bean:write name="datalist"	property="empType" />"
												readonly="readonly" /></td>
									    </tr>
										<input type="hidden" name="hmaritalStatus" id="hmaritalStatus"
											value="<logic:present name="datalist" property="maritalStatus"><bean:write name="datalist" property="maritalStatus" />
													</logic:present>" />

										<tr>
											<td class="left">Marital Status<font color="red">*</font></td>
											<td class="right"><select
												onchange="return getFamilyDetails()" id="maritalStatus"
												name="maritalStatus">
													<option value="">---Select Option---</option>
													<option value="Bachelor">Bachelor</option>
													<option value="Married">Married</option>
											</select></td>
											<td class="left">Present Address<font color="red">*</font></td>
											<td class="right"> <textarea
													readonly="readonly" rows="2" cols="30" id="presentAddress"
													name="presentAddress"><bean:write name="datalist" property="presentAddress" />
									          </textarea></td>
									     </tr>
									     <tr>    
											<td class="left">Permanent Address<font color="red">*</font></td>
											<td class="right"> <textarea
													readonly="readonly" rows="2" cols="30"
													id="permanentAddress" name="permanentAddress">
										          <bean:write name="datalist" property="permanentAddress" />
									            </textarea></td>
									         <td class="left">Biometric Id<font color="red">*</font></td>
                                             <td class="right"> <input
												type="text" name="empbioEmpId" id="empbioEmpId" maxlength="20"
												value="<bean:write name="datalist"		property="bioEmpId" />"
												readonly="readonly" /></td>  
											
										</tr>
										<tr id="show_bioId">	
										   <td class="left" >Upload New Image<font color="red">*</font></td>
								           <td class="right"><input type="file" id="empImage" name="empImage" /><img src="<bean:write name="datalist" property="preview_empImage" />"
												 width="100px"   height="100px" id="empImagePreview" /></td>
										    <td class="left" ></td>
										    <td class="right"></td>
										   
										  <%--   <td class="left">Upload New Image</td>
											<td class="right"><input
												type="file" id="empImage" name="empImage" /></td>
											 <td class="left">
											 <td class="right"><img
												src="<bean:write name="datalist" property="preview_empImage" />"
												width="70px" height="70px" id="empImagePreview"></td> --%>
                                          
										</tr>
										
										
									</logic:equal>

									<logic:equal value="Family Details" name="calMap"
										property="key">
										<tr>

											<td class="left">Father Name<font color="red">*</font></td>
											<td class="right"><input	type="text" name="fatherName" id="fatherName" maxlength="20"
												value="<bean:write name="datalist"	property="fatherName" />"	readonly="readonly" /></td>
											<td class="left" >Father DOB<font color="red">*</font> </td>
											<td class="right"> <input
												type="text" name="fatherDOB" id="fatherDOB" maxlength="20"
												class="datePicker"			value="<bean:write name="datalist"
											property="fatherDOB" />" readonly="readonly" /></td>
											
										</tr>
										<tr>	
											<td class="left">Mother Name<font color="red">*</font></td>
											<td class="right"><input
												type="text" name="motherName" id="motherName" maxlength="20"
												value="<bean:write name="datalist"	property="motherName" />" readonly="readonly" /></td>
											<td class="left">Mother DOB<font color="red">*</font></td>
											<td class="right"> <input type="text" name="motherDOB" id="motherDOB" maxlength="20"
												class="datePicker"	value="<bean:write name="datalist"	property="motherDOB" />"
												readonly="readonly" /></td>
										</tr>
										<tr id="marriedRow1">		
											<td class="left">Family Phone Number<font color="red">*</font></td>
											<td class="right"><input type="text" name="familyPhoneNo" id="familyPhoneNo"
												maxlength="11"	value="<bean:write name="datalist"
											        property="familyPhoneNo" />"readonly="readonly" /></td>
                                            <td class="left" >Date of Marriage</td>
											<td class="right"><input	type="text" name="dateOfMariage" id="dateOfMariage"
												class="datePicker" maxlength="20"value="<bean:write name="datalist"
											property="dateOfMariage" />" readonly="readonly" /></td>

										</tr>
										<tr>
									
											<td class="left">Spouse Name</td>
											<td class="right"><input
												type="text" name="spouseName" id="spouseName" maxlength="20"
												value="<bean:write name="datalist"
											    property="spouseName" />"	readonly="readonly" /></td>
											<td class="left">Spouse DOB</td>
											<td class="right"><input	type="text" name="spouseDOB" id="spouseDOB" maxlength="20"
												class="datePicker"	value="<bean:write name="datalist"
											   property="spouseDOB" />" readonly="readonly" /></td>
                                        </tr>
                                        <tr>
											<td class="left">First Child Name</td>
											<td class="right"><input
												type="text" name="firstChildName" id="firstChildName"
												maxlength="20"		value="<bean:write name="datalist"
											   property="firstChildName" />" readonly="readonly" /></td>
											<td class="left">First Child DOB</td>
											<td class="right"><input
												type="text" name="firstChildDOB" id="firstChildDOB"
												class="datePicker" maxlength="20"
												value="<bean:write name="datalist"	property="firstChildDOB" />"
												readonly="readonly" /></td>
										</tr>
										<tr id="marriedRow2">
											<td class="left">Second Child Name</td>
											<td class="right"><input
												type="text" name="secondChildName" id="secondChildName"
												maxlength="20"
												value="<bean:write name="datalist"
											property="secondChildName" />"	readonly="readonly" /></td>
											<td class="left">Second Child DOB</td>
											<td class="right"><input
												type="text" name="secondChildDOB" id="secondChildDOB"
												class="datePicker" maxlength="20"
												value="<bean:write name="datalist"
											property="secondChildDOB" />"	readonly="readonly" /></td>
									  </tr>
									</logic:equal>

									<logic:equal value="Passport Details" name="calMap"
										property="key">
										<tr>
											<td class="left">Passport Number </td>
											<td class="right"> <input
												type="text" name="passportNo" id="passportNo" maxlength="20"
												value="<bean:write name="datalist"
											property="passportNo" />"	readonly="readonly" /></td>

											<td class="left">Passport Issue Date</td>
											<td class="right"><input type="text" name="passportIssueDate"
												class="datePicker" id="passportIssueDate" maxlength="20"
												value="<bean:write name="datalist"
											property="passportIssueDate" />"	readonly="readonly" /></td>
                                      </tr>
                                      <tr>
											<td class="left">Passport Expiry Date</td>
											<td class="right"><input type="text" name="passportExpiryDate"
												class="datePicker_1" id="passportExpiryDate" maxlength="20"
												value="<bean:write name="datalist"
											 property="passportExpiryDate" />" readonly="readonly" /></td>
											<td class="left">Passport Issue Place</td>
											<td class="right"><input type="text" name="passportIssuePlace"
												id="passportIssuePlace" maxlength="20"
												value="<bean:write name="datalist"
											 property="passportIssuePlace" />"	readonly="readonly" /></td>
										</tr>
									</logic:equal>


									<logic:equal value="Bank Details" name="calMap" property="key">
										<tr>
											<td class="left">HDFC Account Number</td>
											<td class="right"><input type="text" name="hdfcAccountNo" id="hdfcAccountNo"
												maxlength="20"
												value="<bean:write name="datalist"
											property="hdfcAccountNo" />"readonly="readonly" /></td>
											<td class="left" width="20%">Bank Name</td>
											<td class="right"><input	type="text" name="bankName" id="bankName" maxlength="20"
												value="<bean:write name="datalist"	property="bankName" />"
												readonly="readonly" /></td>
									</tr>
									<tr>			
											<td class="left">Branch Name</td>
											<td class="right"><input
												type="text" name="bankBranchName" id="bankBranchName"
												maxlength="20"	value="<bean:write name="datalist"
											property="bankBranchName" />"	readonly="readonly" /></td>
											<td class="left">IFSC Code</td>
											<td class="right"><input
												type="text" name="bankIfscCode" id="bankIfscCode"
												maxlength="20" value="<bean:write name="datalist"
											property="bankIfscCode" />"		readonly="readonly" /></td>

									</tr>
									</logic:equal>


									<logic:equal value="Previous Company Details" name="calMap"
										property="key">
										<tr>
											<td class="left">Previous Company Name</td>
											<td><input type="text" name="previousCompanyName"
												id="previousCompanyName" maxlength="50"
												value="<bean:write name="datalist"
											     property="previousCompanyName" />"	readonly="readonly" /></td>
											<td class="left">Previous Company	Designation</td> 
											<td class="right"><input type="text"
												name="lastCompanyDesignation" id="lastCompanyDesignation"
												maxlength="20"
												value="<bean:write name="datalist"
											    property="lastCompanyDesignation" />"	readonly="readonly" />
											</td>
									    </tr>
									    <tr>		
											<td class="left">Last Drawn Salary inRs</td>
											<td class="right"><input type="text" name="lastDrawnSalaryInRS"
												id="lastDrawnSalaryInRS" maxlength="20"
												value="<bean:write name="datalist"
											property="lastDrawnSalaryInRS" />"	readonly="readonly" /></td>
											<td class="left" width="20%">Total Experience</td>
											<td class="right"><input	type="text" name="totalExperience" id="totalExperience"
												maxlength="20"	value="<bean:write name="datalist"
										    	property="totalExperience" />"	readonly="readonly" /></td>
										</tr>
									</logic:equal>



									<logic:equal value="Educational Details" name="calMap"
										property="key">
										<tr>
											<td class="left">Major Qualification<font color="red">*</font></td>
											<td class="right"><input type="text" name="majorQualification"
												id="majorQualification" maxlength="20"
												value="<bean:write name="datalist"
											     property="majorQualification" />"	readonly="readonly" /></td>
											<td class="left">University / Board<font color="red">*</font></td>
											<td class="right"><input	type="text" name="universityOrBoard" id="universityOrBoard"
												maxlength="20"	value="<bean:write name="datalist"
											property="universityOrBoard" />" readonly="readonly" /></td>
										</tr>
										<tr>
											<td class="left">Year of Passing<font color="red">*</font></td>
											<td class="right"><input	type="text" name="yearOfPassing" id="yearOfPassing"
												maxlength="20"	value="<bean:write name="datalist"
											        property="yearOfPassing" />"	readonly="readonly" /></td>
											<td class="left">College / Institute<font color="red">*</font></td>
											<td class="right"><input type="text" name="collegeOrInstituteName"
												id="collegeOrInstituteName" maxlength="20"
												value="<bean:write name="datalist"
										    	property="collegeOrInstituteName" />"  readonly="readonly" /></td>
										</tr>
									</logic:equal>
								</logic:iterate>


								<tr>
								</tr>
							</table>
							<%-- <table>
							<tr>
								<td style="padding-right: 90%"><input type="button"
									value="Download" class="submitbutton" id="downloadForthisDate"
									onclick="downloadForthisDay('<bean:write
										name="calMap" property="key" />')"></td>
							</tr>
						</table> --%>
						</div>
					</logic:iterate>
					<br />
					<input type="submit" value="Update" class="submitbutton"
						id="updateEmpDetail">
					<input type="button" value="Download" class="submitbutton"
						id="downloadEmpDetail">
				</logic:present>
   <!--  </fieldset> -->
	</div>
	</form>
	</div>
	<br/>
		 <span id="dashboard_goBack" onclick="goback()" style="margin-left:90%;text-decoration: underline;
  cursor: pointer;">go back</span>
	
</body>
</html>