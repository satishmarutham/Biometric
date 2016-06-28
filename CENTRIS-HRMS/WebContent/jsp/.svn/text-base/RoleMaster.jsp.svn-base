<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Role Master</title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script language="javascript" src="js/common.js"></script>
<script language="javascript" src="js/RoleMaster.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
</head>
<body>
	
	<div id="main">
		
			<!--  <input type="hidden" value="addRole" name="parameter"> -->

			<div class="background" id="backgroung">
			
			<form name="roleMasterForm" action="role.do"
			style="width: 100%; margin: 0 auto;">
				<center>
				
				<div id="errordiv1" class="error-box1">
					<span style="color: green; font-family: Segoe UI;" id="success_message"> </span>
					</div>
				
					Role Master
				
					<div id="errordiv" class="error-box">

						<logic:present name="message" scope="session">
							<span style="color: green; font-family: Segoe UI;"> <bean:write
									name="message" />
							</span>
						</logic:present>
						
					</div>
					
					
			
				<br />
					<table id="biometric" cellpadding="5" cellspacing="0" width="80%;">
						<tr>
							<td class="left">Role Name<span style="color: red"> *</span></td>
							<td class="right"><input	type="text" id="roleNameId" name="roleName" /></td>
						
						    <td  class="left">Role Description<span style="color: red"> *</span></td>
							<td class="right"><input type="text" id="roleDescriptionId" name="roleDescription" /></td>
								<input type="hidden" id="roleCodeId" name="roleCode" />
						</tr>
					</table>
					<br />
				
				<table >



					<tr>
						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="map" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="ROLEINSERT" name="map" property="key">
									<logic:equal value="true" name="map" property="value">

										<td><html:submit value="Add" styleClass="submitbutton"
												styleId="add" property="parameter"
												onclick="return validations()" /></td>
										<td><input type="reset" value="Clear"
											class="submitbutton" onclick="cleardata()" /></td>

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>

						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="map" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="ROLEUPDATE" name="map" property="key">
									<logic:equal value="true" name="map" property="value">

										<td><input type="button" value=" Edit"
											class="submitbutton" onclick="editRole()" /></td>
										<td><html:submit value="Update" styleClass="submitbutton"
												styleId="add" property="parameter"
												onclick="return validationsUpdate()" /></td>


									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>

						<logic:present name="UserDetails" scope="session">
							<logic:iterate id="map" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="ROLEDELETE" name="map" property="key">
									<logic:equal value="true" name="map" property="value">

										<td><input type="button" value="Delete"
											class="submitbutton" onclick="deleteRole()" /></td>

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present>




						<td><input type="hidden" name="roleCode" id="roleCodeId"
							value="" /></td>
					</tr>

				</table>
				
			
					</center>
		</form>



		<center>
		
				<display:table name="requestScope.roleMasterList"
					requestURI="/GetDetails.do" pagesize="20" export="false"
					decorator="com.centris.decorator.RoleMasterDecorator"
					class="view" style="width:60%;">


					<display:column property="checkBox" sortable="false" title="Select"
						media="html" />



					<display:column property="roleName" sortable="false"
						title="Role Name" />

					<display:column property="roleDescription" sortable="false"
						title="Description" />

					<display:setProperty name="export.pdf" value="true" />

					<display:setProperty name="export.excel.filename"
						value="RoleMaster.xls" />
					<display:setProperty name="export.excel" value="true" />

					<display:setProperty name="export.csv.filename"
						value="RoleMaster.csv" />
					<display:setProperty name="export.csv" value="true" />

					<display:setProperty name="export.xml.filename"
						value="RoleMaster.xml" />
					<display:setProperty name="export.xml" value="true" />

				</display:table><br/>

		</center>
		</div>
		</div>
		


</body>

</html>
