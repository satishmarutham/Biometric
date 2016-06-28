<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript" src="js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="js/Admin/AttendanceStatusType.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
</head>
<body>
	
	<center>
		<div class="background" id="backgroung">
			<div class="backgroundDiv" id="backgroung">Attendance Status
				Type</div>
			

			<div id="errordiv" class="error-box">
				<logic:present name="successmessage" scope="request">
					<span style="color: green; font-family: Segoe UI;"><bean:write
							name="successmessage" /></span>
				</logic:present>

				<logic:present name="faildmessage" scope="request">
					<span style="color: red; font-family: Segoe UI;"><bean:write
							name="faildmessage" /></span>
				</logic:present>

				<logic:present name="deletemeggage" scope="request">
					<span style="color: green; font-family: Segoe UI;"><bean:write
							name="deletemeggage" /></span>
				</logic:present>

				<logic:present name="updateMessage" scope="request">
					<span style="color: green; font-family: Segoe UI;"><bean:write
							name="updateMessage" /></span>
				</logic:present>



			</div>

			<form action="GetAttendanceDetails.do" method="get">
				<input type="hidden" name="parameter" value="AddDetails" />
				<fieldset style="width: 55%;">
				<br>
			<table cellpadding="5" cellspacing="0" id="biometric" width="70%">
<input type="hidden" name="statustypecode" id="statustypecode"> 
						<tr class="trc">
						<td class="left">Status Type<font color="red">*</font></td>
						<td class="right" style="width: -11%;"><input type="text" name="statustypename" id="statustypename" onblur="validationStatusType()" /> </td>
						<td class="left">Short Name<font color="red">*</font></td>
							<td class="right"><input type="text" name="shortname" id="shortname" onblur="validationshortname()" maxlength="2" /></td></tr>
							<tr class="trc">
						<td class="left">Description<font color="red">*</font></td><td class="right" colspan="3">
							<textarea rows="2" cols="90" name="description" id="description"></textarea></td>
					</tr>
				</table>
			
				<br /> 
				
				
				 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="ATTSTATUSTYPECREATION" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				 
				<input type="submit" class="submitbutton" value="Add" onclick="return addAttendanceStatus()" /> 
				<input type="button" class="submitbutton" value="Clear" onclick="clearAttendanceStatus()" /> 
		
				</logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
	 			 
	 			 
	 			 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="ATTSTATUSTYPEUPDATE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				 
				 <input type="button" class="submitbutton" value="Edit" onclick="editAttendanceStatus()" />
				<input type="button" class="submitbutton" value="Update" onclick="UpdateAttendanceStatus()" />
		
				</logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
				
				 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="ATTSTATUSTYPEDELETE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				 
				  	<input type="button" class="submitbutton" value="Delete" onclick="DeleteAttendanceStatus()" /> 
		
				</logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
				
				
				
				
				
				
					
						</fieldset>
			</form>


			
				<logic:present name="attendancestatuslist" scope="request">
					<display:table id="attendancestatus" name="attendancestatuslist" export="false"
						requestURI="/GetDetails.do?parameter=getAttendanceStatusDetails"
						pagesize="20" style="width:57%;" class="view">

						<display:column
							title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />">
							<input type="checkbox" name="selectBox" id="selectBox"
								value="${attendancestatus.statustypecode}"> </>
</display:column>


						<display:column property="statustypename" title="Status Type"></display:column>
						<display:column property="shortname" title="Short Name"></display:column>
						<display:column property="description" title="Description"></display:column>
					</display:table>
					<br>
				</logic:present>
		



		</div>
	</center>
</body>
</html>