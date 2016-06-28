<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Group Master</title>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect-blind.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.tabs.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/GroupMaster.js"></script>
<script language="javascript" src="/js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/groupmaster.css"></link>

</head>

<body>
<br><br><br>
	<div class="background" id="backgroung">
		<center>
		<br>
			<div class="backgroundDiv" id="backgroung">Group Master</div>
					<div id="errordiv" class="error-box">
							<span style="color: green; font-family: Segoe UI;" id="spanid"> 
						</span>
							
						</div>
					</center>
<br><br>

	<center>
		<form name="employeeGroup">
		
		  <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="GRPCREATE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				 
				<input type="button" value="Add" class="submitbutton" id="addGroup" /> 
				
				 </logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
				
				  <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="GRPUPDATE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				 
			<input	type="button" value="Edit" class="submitbutton" id="updateGroup" /> 
			
			 </logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
				
				  <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="GRPDELETE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				<input type="button" value="Delete" class="submitbutton" id="deleteGroup" />
				
				 </logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
    
		</form>
		
	</center>
	<center>
	<div class="tablecss" style="width:40%;margin:40px;">
	<logic:present name="grouplist" scope="request">
		<table border="1" id="tbl" align="center" id="biometric">
			<tbody>
				<display:table id="data" name="requestScope.grouplist"
					requestURI="groupMaster.do?method=groupMasterHome" pagesize="10"
					defaultsort="10">
					<display:column
						title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />">
						<input type="checkbox" name="selectBox" id="selectBox"
							value="${data.groupId}"> </>
				</display:column>
					<display:column property="groupId" title="Group ID" />
					<display:column property="groupName" title="Group Name" />
					<display:column property="description" title="Description" />
				</display:table>
			</tbody>
		</table>
		</logic:present>
</div>
	</center>
</div>

	<div id="update-dialog" title="Group Details"  
		style="display: none; font-size: 10px; ">
		
		<p class="validateTips" style="font-size: 13px; color: red;">*
			form fields are required.</p>
              
		<form  style="background-color: #689EE6;">

			<table border="0" cellpadding="1" cellspacing="5" >
				<tr>

					<td><input type="hidden" name="groupId" id="groupId"
						class="text ui-widget-content ui-corner-all textfont"
						style="font-size: 15px;font_family:Segoe UI" /></td>
				</tr>
				<tr>
					<td style="font-size: 12px;font_family:Segoe UI">Group Name<font color="red">*</font></td>
					<td><input type="text" name="groupName" id="groupName"
						class="text ui-widget-content ui-corner-all textfont"
						style="font-size: 15px" /></td>
				</tr>

				<tr>
					<td style="font-size: 12px;font_family:Segoe UI">Description</td>
					<td><textarea rows="4" cols="19" name="description"
							id="description" style="font-size: 15px;"
							class="text ui-widget-content ui-corner-all"></textarea></td>
				</tr>
			</table>
		</form>
		   <p style="font-size: 13px; color: green;" id="successdiv"></p>
		
</div>



	<br></br>
	<br></br>
	<hr></hr>
	</body>
</html>