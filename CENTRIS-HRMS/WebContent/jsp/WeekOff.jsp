<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Week off Settings</title>
<script type="text/javascript" src="js/WeekOff.js"></script>
<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css">
<script src="JQUERY/development-bundle/jquery-1.8.3.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.core.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.widget.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.position.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.menu.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/weekoff.css"></link>
</head>
<body>
	<center>
		<html:form action="/weekoff" onsubmit="return validateForm()">
			<br />
			<br />
			<br />

			<div class="background" id="backgroung">




				<div class="backgroundDiv" id="backgroung">Week Off Settings</div>
				<br />
				<!-- <span class="WeekOFFErrorMsg" style="color: red;" id="error"> -->

				<div id="errordiv" class="error-box">
					<logic:present name="message" scope="request">
						<span style="color: green; font-family: Segoe UI;" id="error1">
							<bean:write name="message" scope="request" />
						</span>
					</logic:present>
				</div>

				<!-- <tr align="center">
						<td colspan="3">Select Employee &nbsp;&nbsp;&nbsp;&nbsp; <input
							type="text" id="emp" name="employeeName" class="searchbox"></td>
							
					</tr> -->
				<table id="biometric" width="90%" cellpadding="10" cellspacing="3">
					<tr align="center">
						<td colspan="3" id="searchbox">Select Employee
							&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="emp"
							name="employeeName" class="input">
						</td>
					</tr>
					<tr>
						<td>Employee Name <br> <input type="text" id="name"
							readonly="readonly" /></td>
						<td>Employee ID <br> <input type="text" id="empid1"
							readonly="readonly" />
						</td>
						<td>Email ID<br> <input type="text" id="email"
							readonly="readonly" /></td>
					</tr>
					<tr>
						<td>Department Name <br> <input type="text" id="dept"
							readonly="readonly" /></td>
						<td>Shift Name <br> <input type="text" id="shift"
							readonly="readonly" /></td>
						<td>Location<br> <input type="text" id="location"
							readonly="readonly" />
						</td>
					</tr>

				</table>

				<br />

				<table id="biometric" width="90%">


					<tr>
						<td><input type="checkbox" name="sunday" id="sunday"
							value="1"> &nbsp;Sunday</td>
						<td><input type="checkbox" name="monday" id="monday"
							value="1"> &nbsp;Monday</td>
						<td><input type="checkbox" name="tuesday" id="tuesday"
							value="1">&nbsp;&nbsp;Tuesday</td>
						<td><input type="checkbox" name="wednesday" id="wednesday"
							value="1">&nbsp;&nbsp;Wednesday</td>

						<td><input type="checkbox" name="thursday" id="thursday"
							value="1"> &nbsp;&nbsp;Thursday</td>
						<td><input type="checkbox" name="friday" id="friday"
							value="1"> &nbsp;&nbsp;Friday</td>
						<td><input type="checkbox" name="saturday" id="saturday"
							value="1">&nbsp;&nbsp; Saturday</td>
						<input type="hidden" id="empid" name="empid" />
					</tr>

				</table>
				<br>
				
				<table>
					<tr>
						<td colspan="3" align="center">
						
						
				<logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="WEEKOFFSETTINGS" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				 
				 <html:submit property="parameter" styleClass="submitbutton">Update</html:submit>
				 
				 </logic:equal>
				 </logic:equal>
				 </logic:iterate>
				 </logic:present>
				 
				 </td>
						
					</tr>
				</table>
			</div>

		</html:form>
	</center>
</body>
</html>
