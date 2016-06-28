<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<title> Role Permission Mapping</title>
<link type="text/css" rel="stylesheet" href="./style/main.css"></link>

<script type="text/javascript" src="./script/jquery.js"></script>

<LINK REL=StyleSheet HREF="css/common.css" TYPE="text/css" />

<link rel="shortcut icon" href="images/favicon.ico">
<script language="javascript" src="js/datetimepicker.js"></script>
<script language="javascript" src="js/globals.js"></script>
<script type="text/javascript" src="js/popupconstants.js"></script>
<script language="javascript" src="js/UserRolePermission.js"></script>
<script language="javascript" src="js/messageconstant.js"></script>
<script language="javascript" src="js/Validation.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/login/style.css">
<link rel="stylesheet" href="css/login/common.css">
</HEAD>
<BODY>

<div class="background" id="backgroung">
					<center>
						<div class="backgroundDiv" id="backgroung"> Role - Permissions Mapping</div>
						<div id="errordiv" class="error-box"><span style="color: green; font-family: Segoe UI;"><logic:present name="message" scope="session"><bean:write name="message" scope="session"/></logic:present></span></div>
			
		<fieldset style="width: 60%;" >
			
			<center><br/>
			<table cellpadding="5" cellspacing="0" id="biometric" width="50%">
			
			<tr>
			<td class="left">
			Select Role
			
			</td>
			
			<td class="right">
			
			
			<select name="roleName" id="roleId" style="width: 80%">
				<option value="All">---Select Role---</option>
				<logic:present name="RolePermission" scope="session">
				<logic:iterate id="role" name="RolePermission" property="roleList" scope="session">
				<option value='<bean:write name="role" property="roleCode"/>,<bean:write name="role" property="roleName"/>'><bean:write name="role" property="roleName"/></option>
				</logic:iterate>
				
				</logic:present>
				</select>
			
			</td>
			
			</tr>
			
			
			</table><br/>
			<div style="font-size: 13px;color: black;font-weight: 600"><input type="checkbox" id='selectAll' name="" />Select All</div>	
			</center>
	
				
	
	
	<logic:present name="UserDetails1" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="ROLPERMISSIONS" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
	<a class="removePermission" style="cursor: pointer;margin:35px;" href="#">Clear Permissions</a>
	

	
	
		</logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
	 			
	
		</fieldset>
			</center>
			
	
	<div>
	<center>
	
	<div style="width: 100%;overflow-X:auto;">
	
	<table id="biometric1" width="100%" cellspacing="0px"   border-collapse: >
	<tr >
		<th><input type="checkbox" id='employeeall' name=""/>Employee </th>	
<!-- 		<th><input type="checkbox" id='userAll' name=""/>User </th> -->
		<th><input type="checkbox" id='locationAll' name=""/>Project </th>
		<th><input type="checkbox" id='shiftAll' name=""/>Client </th>
		<th><input type="checkbox" id='departmentall' name=""/>Department</th>
		<th><input type="checkbox" id='designationall' name=""/>Designation</th>
		<th><input type="checkbox" id='holidayall' name=""/>Holiday </th>
		<th><input type="checkbox" id='roleAll' name=""/>Role</th>
		<th><input type="checkbox" id='leavebankall' name=""/>Leave Bank</th>
		<th><input type="checkbox" id='statustypeall' name=""/>Status Type</th>
		<th><input type="checkbox" id='approveall' name=""/>Approvels</th>
		<th><input type="checkbox" id='viewAll' name=""/>Report </th>
		<th><input type="checkbox" id='otherAll' name=""/>Other </th>
	
	
	</tr>
	<tr>
	
	<td valign="top" >
	<table id="biometric1" style="margin: 0 auto;">
	<logic:present name="RolePermission" scope="session">
	<logic:iterate id="creation" name="RolePermission" property="permissionList">
	<logic:match name="creation" value="Employee"  property="permissionName">
	<tr><td style="border: 0px"><input type="checkbox" class="permission permissionEmployee" id='<bean:write name="creation" property="permissionId"/>' name='<bean:write name="creation" property="permissionShortName"/>' data_permission='<bean:write name="creation" property="permissionName"/>' data_permission='<bean:write name="creation" property="permissionName"/>'/><bean:write name="creation" property="permissionName"/></td></tr>
	</logic:match>
	</logic:iterate>
	</logic:present>
	
	</table>
	
	
	</td>
	

	<td valign="top" >
		<table >
	
		<logic:present name="RolePermission" scope="session">
	<logic:iterate id="creation" name="RolePermission" property="permissionList">
		<logic:match name="creation" value="Project"  property="permissionName">
	<tr><td style="border: 0px"><input type="checkbox" class="permission permissionLocation" id='<bean:write name="creation" property="permissionId"/>' name='<bean:write name="creation" property="permissionShortName"/>' data_permission='<bean:write name="creation" property="permissionName"/>'/><bean:write name="creation" property="permissionName"/></td></tr>
	</logic:match>
	</logic:iterate>
	</logic:present>
	
	</table>
	
	
	</td>
	<td valign="top" >
	
		<table >
			<logic:present name="RolePermission" scope="session">
	<logic:iterate id="creation" name="RolePermission" property="permissionList">
		<logic:match name="creation" value="Client"  property="permissionName">
	<tr><td style="border: 0px" ><input type="checkbox" class="permission permissionShift" id='<bean:write name="creation" property="permissionId"/>' name='<bean:write name="creation" property="permissionShortName"/>' data_permission='<bean:write name="creation" property="permissionName"/>'/><bean:write name="creation" property="permissionName"/></td></tr>
	</logic:match>
	</logic:iterate>
	</logic:present>
	
	</table>
	
	</td>
	
	
		<td valign="top" >
	
		<table id="biometric1">
			<logic:present name="RolePermission" scope="session">
	<logic:iterate id="creation" name="RolePermission" property="permissionList">
		<logic:match name="creation" value="Department"  property="permissionName">
	<tr><td style="border: 0px"><input type="checkbox" class="permission permissionDepartment" id='<bean:write name="creation" property="permissionId"/>' name='<bean:write name="creation" property="permissionShortName"/>' data_permission='<bean:write name="creation" property="permissionName"/>'/><bean:write name="creation" property="permissionName"/></td></tr>
	</logic:match>
	</logic:iterate>
	</logic:present>
	
	</table>
	
	</td>
	
	<td valign="top" >
	
		<table id="biometric1">
			<logic:present name="RolePermission" scope="session">
	<logic:iterate id="creation" name="RolePermission" property="permissionList">
		<logic:match name="creation" value="Designation"  property="permissionName">
	<tr><td style="border: 0px"><input type="checkbox" class="permission permissionDesignation" id='<bean:write name="creation" property="permissionId"/>' name='<bean:write name="creation" property="permissionShortName"/>' data_permission='<bean:write name="creation" property="permissionName"/>'/><bean:write name="creation" property="permissionName"/></td></tr>
	</logic:match>
	</logic:iterate>
	</logic:present>
	
	</table>
	
	</td>
	
	<td valign="top" >
	
		<table id="biometric1">
			<logic:present name="RolePermission" scope="session">
	<logic:iterate id="creation" name="RolePermission" property="permissionList">
		<logic:match name="creation" value="Holiday"  property="permissionName">
	<tr><td style="border: 0px"><input type="checkbox" class="permission permissionHoliday" id='<bean:write name="creation" property="permissionId"/>' name='<bean:write name="creation" property="permissionShortName"/>' data_permission='<bean:write name="creation" property="permissionName"/>'/><bean:write name="creation" property="permissionName"/></td></tr>
	</logic:match>
	</logic:iterate>
	</logic:present>
	
	</table>
	
	</td>
		<td valign="top" >
	
		<table id="biometric1">
			<logic:present name="RolePermission" scope="session">
	<logic:iterate id="creation" name="RolePermission" property="permissionList">
		<logic:match name="creation" value="Role"  property="permissionName">
	<tr><td style="border: 0px"><input type="checkbox" class="permission permissionRole" id='<bean:write name="creation" property="permissionId"/>' name='<bean:write name="creation" property="permissionShortName"/>' data_permission='<bean:write name="creation" property="permissionName"/>'/><bean:write name="creation" property="permissionName"/></td></tr>
	</logic:match>
	</logic:iterate>
	</logic:present>
	
	</table>
	
	</td>
	
	
	<td valign="top" >
		<table id="biometric1">
			<logic:present name="RolePermission" scope="session">
	<logic:iterate id="creation" name="RolePermission" property="permissionList">
		<logic:match name="creation" value="LeaveBank"  property="permissionName">
                   
	<tr><td style="border: 0px"><input type="checkbox" class="permission permissionLeave" id='<bean:write name="creation" property="permissionId"/>' name='<bean:write name="creation" property="permissionShortName"/>' data_permission='<bean:write name="creation" property="permissionName"/>'/><bean:write name="creation" property="permissionName"/></td></tr>
	</logic:match>
	</logic:iterate>
	</logic:present>
	
	</table>
	
	</td>
	
		<td valign="top" >
		<table id="biometric1">
			<logic:present name="RolePermission" scope="session">
	<logic:iterate id="creation" name="RolePermission" property="permissionList">
		<logic:match name="creation" value="AttendanceStatusType"  property="permissionName">
                   
	<tr><td style="border: 0px"><input type="checkbox" class="permission permissionStatusType" id='<bean:write name="creation" property="permissionId"/>' name='<bean:write name="creation" property="permissionShortName"/>' data_permission='<bean:write name="creation" property="permissionName"/>'/><bean:write name="creation" property="permissionName"/></td></tr>
	</logic:match>
	</logic:iterate>
	</logic:present>
	
	</table>
	
	</td>
	
		<td valign="top" >
		<table id="biometric1">
			<logic:present name="RolePermission" scope="session">
	<logic:iterate id="creation" name="RolePermission" property="permissionList">
		<logic:match name="creation" value="Approve"  property="permissionName">
                   
	<tr><td style="border: 0px"><input type="checkbox" class="permission permissionApprove" id='<bean:write name="creation" property="permissionId"/>' name='<bean:write name="creation" property="permissionShortName"/>' data_permission='<bean:write name="creation" property="permissionName"/>'/><bean:write name="creation" property="permissionName"/></td></tr>
	</logic:match>
	</logic:iterate>
	</logic:present>
	
	</table>
	
	</td>
	
		<td valign="top" >
		<table id="biometric1">
			<logic:present name="RolePermission" scope="session">
	<logic:iterate id="creation" name="RolePermission" property="permissionList">
		<logic:match name="creation" value="Report"  property="permissionName">
                   
	<tr><td style="border: 0px"><input type="checkbox" class="permission permissionView" id='<bean:write name="creation" property="permissionId"/>' name='<bean:write name="creation" property="permissionShortName"/>' data_permission='<bean:write name="creation" property="permissionName"/>'/><bean:write name="creation" property="permissionName"/></td></tr>
	</logic:match>
	</logic:iterate>
	</logic:present>
	
	</table>
	
	</td>
	
		
		<td valign="top" >
		<table  id="biometric1">
							<logic:present name="RolePermission" scope="session">
								<logic:iterate id="creation" name="RolePermission" property="permissionList">
									<logic:notMatch name="creation" value="Report" property="permissionName">
									<logic:notMatch name="creation" value="Group" property="permissionName">
										<logic:notMatch name="creation" value="Designation" property="permissionName">
											<logic:notMatch name="creation" value="Holiday" property="permissionName">
												<logic:notMatch name="creation" value="Department" property="permissionName">
													<logic:notMatch name="creation" value="Role" property="permissionName">
														<logic:notMatch name="creation" value="Client" property="permissionName">
															<logic:notMatch name="creation" value="Project" property="permissionName">
																<%-- <logic:notMatch name="creation" value="User" property="permissionName"> --%>
																	<logic:notMatch name="creation" value="Employee"  property="permissionName">
																	<logic:notMatch name="creation" value="LeaveBank"  property="permissionName">
																	<logic:notMatch name="creation" value="AttendanceStatusType"  property="permissionName">
																	<logic:notMatch name="creation" value="Approve"  property="permissionName">	
																
																<tr>
															<td style="border: 0px"><input type="checkbox"
																class="permission permissionOther"
																id='<bean:write name="creation" property="permissionId"/>'
																name='<bean:write name="creation" property="permissionShortName"/>' data_permission='<bean:write name="creation" property="permissionName"/>' /><bean:write name="creation" property="permissionName" /></td>
														</tr>
														
														</logic:notMatch>
															</logic:notMatch>
														</logic:notMatch>
													</logic:notMatch>
												</logic:notMatch>
											</logic:notMatch>
										</logic:notMatch>
									</logic:notMatch>
									</logic:notMatch>
									</logic:notMatch>
										</logic:notMatch>
									</logic:notMatch>
									<%-- </logic:notMatch> --%>
								</logic:iterate>
							</logic:present>

						</table>

					</td>
	</tr>
	</table>

	</div>
	</center>
	</div>
	<logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="ROLEPERMISSIONMAPPIN" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				 
	<div style="width:100%;text-align: center;margin: 10px;">
	<input type="button" id="savePermission" value="Save Permissions" class="submitbutton"/>	
	</div>
	
		</logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
	
	</div>

</BODY>
</HTML>