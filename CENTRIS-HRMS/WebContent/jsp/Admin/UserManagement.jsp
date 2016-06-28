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
<title>User Management</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.position.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.menu.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="js/Admin/UserManagement.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>

</head>
<body>
	<div id="main" class="background">
	
		<div id="loader"
		style="position: absolute; top: 30%; left: 45%; display: none; ">
		<img src="images/loaderimage2.GIF" width="150px" height="150px" />
	</div>

		<center>

			<div class="backgroundDiv" id="backgroung">User Management</div>

			<form action="usermanagement.do?method=saveEmployeeRole"
				name="saveEmployeeRole" method="post">
				
				
				


					<div id="errordiv" class="error-box" align="center">

						<logic:present name="message" scope="request">
							<span style="color: green; font-family: Segoe UI;"> <bean:write
									name="message" />
							</span>
						</logic:present>
						
						<logic:present name="errorMessage" scope="request">
							<span style="color: red; font-family: Segoe UI;"> <bean:write
									name="errorMessage" />
							</span>
						</logic:present>

					</div>

					<table id="biometric" width="60%" cellpadding="5" cellspacing="1">
						<tr class="trc">

							<td id="searchbox" class="left">Designation</td>
							<td class="right"><select id="designation" name="designation">
									
									<logic:present name="DESIGNATIONLIST" scope="request"> 
									<option value="%%">All</option>
									<logic:iterate id="DESIGNATION" name="DESIGNATIONLIST">
									
									<option value="<bean:write name="DESIGNATION" property="desgid"/>">
									<bean:write name="DESIGNATION" property="desgname"/>
									</option>
									
									
									</logic:iterate>
									
									</logic:present>
							</select></td>
							<td id="searchbox" class="left">Search Employee</td>

							<td class="right"><input type="text" class="datePicker"
								id="emp" name="empname" placeholder="Search Employee"
								value="<logic:present name="employeeDetails" property="empFirstName"><bean:write name="employeeDetails" property="empFirstName" />
													</logic:present>" />
								<input type="hidden" id="selectEmployee" name="selectEmployee"/>
							</td>
						</tr>

					</table>
					<br/>
					
					<table id="biometric" width="60%" cellspacing="2">

						<tr >
							<td class="right" height="35px"><input type="checkbox" id="employee"  disabled 
								name="employee" value="employee" />&nbsp;&nbsp;&nbsp;Employee</td>
						
							<td class="right" height="35px"><input type="checkbox" id="director"
								name="director" value="director" class="notdisabled"/>&nbsp;&nbsp;&nbsp;Director</td>

							<td class="right" height="35px"><input type="checkbox" id="manager"
								name="manager" value="manager" class="notdisabled"/>&nbsp;&nbsp;&nbsp;Manager</td>
						
						</tr>
						<tr>
						
							<td class="right" height="35px"><input type="checkbox" id="ADMIN"
								name="admin" value="ROL1" class="notdisabled" />&nbsp;&nbsp;&nbsp;Admin</td>
								
							<td class="right"  height="35px"><input type="checkbox" id="HR"
								name="hr" value="ROL2" class="notdisabled"/>&nbsp;&nbsp;&nbsp;HR</td>
								
							<td class="right"  height="35px"><input type="checkbox" id="CLERK"
								name="clerk" value="ROL3" class="notdisabled"/>&nbsp;&nbsp;&nbsp;Clerk</td>
								

						</tr>
						<tr>
						
							<td class="right"  height="35px"><input type="checkbox" id="ACCOUNTS"
								name="accounts" value="ROL4" class="notdisabled"/>&nbsp;&nbsp;&nbsp;Accounts</td>
								
							<td class="right"  height="35px"><input type="checkbox" id="customrole" onchange=" getAllroles(this.id,'')"
								name="customrole"  />&nbsp;&nbsp;&nbsp;Custom</td>

						<!-- 	<td class="right"  height="35px"><input type="checkbox" id="ROL6"
								name="hraccounts" value="ROL6" />&nbsp;&nbsp;&nbsp;Hr-Accounts</td>
								 -->
								
						</tr>
						<!-- <tr>
								
								<td class="right"  height="35px"><input type="checkbox" id="ROL7"
								name="clerkaccounts" value="ROL7" />&nbsp;&nbsp;&nbsp;Clerk-Accounts</td>
						
						</tr> -->
					</table>
			
			<br/>
			   <table id="biometric" width="45%" cellpadding="2" cellspacing="1"  class="roleClass" >
						<tr class="trc">
							<td id="searchbox" class="left">Select Role</td>
							<td class="right"><select id="role" name="role" >
							</select></td>
			        </tr>
			     <input type="hidden" name="rolename" id="rolename"  ></input>   
		    	</table>
		
			
	<br/>
				<input type="hidden" value="" name="empCode" id="empCodeId" />
				<table>
					<tr class="odd">

						<td colspan="3"><center>
						
						
						
						 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="USERMANAGEMENT" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				 
				 <input type="submit" class="submitbutton" value="Save Permissions"
									class="button1" id="register" onclick="return validate()" /> 
		
				</logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
								
									
									
									
							</center></td>
					</tr>
				</table>
				
					
			</form>

		</center>
	</div>

</body>
</html>