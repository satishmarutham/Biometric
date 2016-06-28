<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <jsp:include page="header_menu.jsp"></jsp:include> --%>
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Employee</title>
<script type="text/javascript" src="js/Admin/GetAllEmployee.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.position.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.menu.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>

<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>


<style type="text/css">
.linkButton {
	
	min-height: 15px;
	max-height: 10%;
	margin: 5px 5px 5px 5px;
	background-color: #aaaaaa;
	color: black;

}

.linkButton:hover {
	text-shadow: 0 0 1px rgba(255, 255, 255, 0.7);
	cursor: pointer;
}


</style>

</head>

<body>

	
	<div align="center" id="main">
		<center>
			<div class="background" id="backgroung">
			

				<div class="backgroundDiv" id="backgroung">All Employees</div>
				
				
				<center>

					<div id="errordiv" class="error-box" align="center" style="width:55%;">

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
				
				
				<form name="allemployee" id="allemployee" action="GetAllEmployees.do">
			<input type="hidden" id="searchemp" name="parameter" />

					<table align="center" cellpadding="3" cellspacing="3"
						id="biometric">

						<tr>
							<td><input type="text" name="empName" id="searchempname" ></td>

							<td><input type="button" value="Search" class="submitbutton"
								onclick="search()"></td>

						</tr>

					</table>
					
					<div id="deactiveEmployee" style="float:right;margin-top:-28px;margin-right:140px;">
					<a href="employee.do?parameter=getAllDeactiveEmployees">View All DeActive Employees</a></div>
					<!-- <div id="errordiv" class="error-box" align="center"></div> -->
				

						 <div class="tablecss" style="width: 80%; " id="tableId" >
							<logic:present name="emplist" scope="request">
                      
						<display:table id="emplist" name="emplist" export="false"
									requestURI="/GetDetails.do?parameter=getAllEmployeePage"
									pagesize="50" >
									
								<display:column property="sno" title="Sno"></display:column>
								<display:column title="Employee ID">
								
								<a href="GetAllEmployees.do?parameter=modifyEmployee&selectEmployee=${emplist.empid}">
								${emplist.bioid}
								</a>
								
								</display:column>
								
								
									<display:column property="empname" title="EmployeeName " />
									<display:column property="designationname" title="Designation" />
									<display:column property="permissions" title="Permissions" />
									<display:column property="officialMailId" title="OfficialMailid" />
									<display:column property="phonenumber" title="PhoneNo" />

									<logic:present name="UserDetails" scope="session">
										<logic:iterate id="daymap" name="UserDetails"
											property="permissionmap" scope="session">
											<logic:equal value="EMPSALDETAILS" name="daymap" property="key">
												<logic:equal value="true" name="daymap" property="value">
												
													<display:column title="Salary Details">
														<input type="button" name="getsalary"
															onClick='salaryDeatails(this)' value="Get Salary Details"
															id="${emplist.empid},${emplist.empname},${emplist.salary},${emplist.accountNumber}"> </>
									
													</display:column>
													
													</logic:equal>
											</logic:equal>
										</logic:iterate>
									</logic:present>
													
												
													
														<display:column title="View">
														<input type="button" name="view"
															onClick='viewDetils(this)' value="view"
															id="${emplist.empid}"> </>
									
													</display:column>
													
												


								</display:table>
								
								<logic:iterate id="employee" name="emplist" scope="request">
								<input type="hidden" id="hiddenemployee" name="hiddenemployee" value='<bean:write name="employee"  property="empid" />'></input>
								
								</logic:iterate>
								
								
								

							</logic:present>
						</div> 

			


					<!-- <br /> <input type="button" id="download" value="Download PDF"
						class="submitbutton"> <input type="button" id="allDetails"
						value="Personal Details PDF" class="submitbutton"> -->
				</form>
				
				
				
				<!--  form division starting here   -->
				
			
	<div id="view-dialog" align="center" style="display: none; font-size: 10px;background-color: #F2F0E7" 
		title="View Employee Details">
				<form id="insertDepForm" method="post">
				
					<div id="loader"
		style="position: absolute; top: 70px; left: 250px; display: none; ">
		<img src="images/loaderimage2.GIF" width="150px" height="150px" />
	</div><br/>
			
				<center><div id="error" class="error-box" style="display: none;width:95%;">
				
							<span style="color: green; font-family: Segoe UI;" id="succeesDiv"></span>
			 </div>
							
			
				</center>
				       
                         <input type="hidden" id="dialogempId"/>
                         <input type="hidden" id="dilogmailId"/>
			<table cellpadding="5" cellspacing="0" id="biometric" width="100%" >
							<tr >
							<td style="background-color: #fff" colspan="1" width="30% !important">
								<img src="" width="170px" height="200px" id="empImagePreview" /></td>
                            
                            <td colspan="4">
                            
                            <table width="100% !important">
                            
                            <tr>
                            	
                            	<td  class="left1" >Name</td>
								<td class="right1"  width="70% !important" id="empName"></td>
						
							
							 </tr>
							 
                            
                             <tr>

								<td  class="left1" >Base Location</td>
								<td class="right1" id="baseLocation" ></td>
                            </tr>

 							<tr>
								<td  class="left1" >Qualification</td>
								<td class="right1" id="qualification"></td>
							 </tr>
                          
							<tr>
								<td  class="left1" >Dob</td>
								<td class="right1" id="dob" ></td>

                            </tr>
                            
                            <tr>

								<td  class="left1" >Doj</td>
								<td class="right1" id="doj" ></td>
								</tr>
								
								 <tr>

								<td   height="50px !important"  style="padding-left:30px; background-color: #D9D9D9" >Present Address</td>
									<td  width="70% !important" height="50px !important"  style="padding-left:30px; background-color: #fff;border: 0px"   id="presentAddress">
								
								</td>
								
                            </tr>
                          
                            
                            </table>
                            
                            </td>

								
                            </tr>
                            
						</table><br/>
						
						<input type="button" id="reset_employee_password" value="Reset Employee Password" class="linkButton"/>
						<input type="button" id="reset_director_password" value="Reset Director Password" class="linkButton"/>
						<input type="button" id="reset_manager_password" value="Reset Manager Password" class="linkButton"/>
						<input type="button" id="reset_admin_password" value="Reset Admin Password" class="linkButton"/><br/>
						
					
						<input type="button" id="block_employee" value="Block Employee" class="linkButton" onclick="blockUserDetails('employee')"/>
						<input type="button" id="block_director" value="Block Director" class="linkButton" onclick="blockUserDetails('director')"/>
						<input type="button" id="block_manager" value="Block Manager" class="linkButton" onclick="blockUserDetails('manager')"/>
						<input type="button" id="block_admin" value="Block Admin" class="linkButton" onclick="blockUserDetails('admin')"/><br><br/>
					
			</form>
			
				
						
						<input type="button" id="resetPassword" value="Reset Password" class="submitbutton" onclick="restPassword()"/>
						<input type="button" id="blockuser" value="Block User" class="submitbutton" onclick="blockUser()"/>
						<input type="button" id="resetPassword" value="Delete Emplyee" class="submitbutton" onclick="deleteEmployee()"/>
							
				
		</div>

<!-- form division ending here    -->
				
				
				
			</div>
		</center>
	</div>

	<br>
	<br>
	<hr></hr>

</body>
</html>


