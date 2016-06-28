<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
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
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.tabs.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/employeeGroup.js"></script>
<script type="text/javascript" src="js/employeeRegistration.js"></script>

<style type="text/css">
.button1 {
	-webkit-box-shadow: rgba(0, 0, 0, 0.0976562) 0px 1px 0px 0px;
	background-color: #313839;
	border: 1px solid #999;
	color: #CCC;
	font-family: 'Lucida Grande', Tahoma, Verdana, Arial, Sans-serif;
	font-size: 11px;
	font-weight: bold;
	padding: 2px 6px;
	height: 28px;
}

table#data tr:nth-child(even) {
	background-color: #ADD6FF;
	padding: 2px;
}

table#data tr:nth-child(odd) {
	background-color: #E4EAF0;
	padding: 2px;
}
</style>
<style type="text/css">
.ui-widget {
	font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;
	font-size: 0.6em;
}
</style>
</head>

<body>
	<jsp:include page="header_menu.jsp"></jsp:include>
	<br><br/> <br/>
	<center>
		<h2>Group Master</h2>
	</center>

	<br>

	<center>
		<form name="employeeGroup">
			<!-- <input value="Search..." id="SearchText" style="height:40px;font-size:10pt;  onchange="SearchText" onfocus="javascript:this.value=''" onblur="javascript: if(this.value==''){this.value='Search...';}" /> -->
			<!--  <input id="searchbutton"  type="button"  value="Search" class="send_button" onclick="displayItem()"/>    -->
			<input type="button" value="Add" class="button1" id="addGroup" /> <input
				type="button" value="Edit" class="button1" id="updateGroup" /> <input
				type="button" value="Delete" class="button1" id="deleteGroup" />

		</form>
		<br>
	</center>
	<center>
		<table border="1" id="tbl" align="center">
			<tbody>
				<display:table id="data" name="requestScope.grouplist"
					requestURI="groupMaster.do?method=displayGroup" pagesize="10"
					defaultsort="10">
					<display:column
						title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />">
						<input type="checkbox" name="selectBox" id="selectBox"
							value="${data.groupId}"> </>
				</display:column>

					<display:column property="groupId" title="Group Id" />
					<display:column property="groupName" title="Group Name" />
					<display:column property="description" title="Description" />
				</display:table>
			</tbody>
		</table>

	</center>


	<div id="update-dialog" title="Group details"
		style="display: none; font-size: 10px;">
		<p class="validateTips" style="font-size: 13px; color: red;">*
			form fields are required.</p>

		<form onclick=" validateForm()" style="background-color: #E4EAF0;">

			<table border="0" cellpadding="1" cellspacing="5">
				<tr>

					<td><input type="hidden" name="groupId" id="groupId"
						class="text ui-widget-content ui-corner-all textfont"
						style="font-size: 15px" /></td>
				</tr>
				<tr>
					<td><label for="groupName" class="LblDialog">GroupName
					</label><font color="red">*</font></td>
					<td><input type="text" name="groupName" id="groupName"
						class="text ui-widget-content ui-corner-all textfont"
						style="font-size: 15px" /></td>
				</tr>

				<tr>
					<td><label for="description" class="LblDialog">Description</label></td>
					<td><textarea rows="4" cols="19" name="description"
							id="description" style="font-size: 15px;"
							class="text ui-widget-content ui-corner-all"></textarea></td>
				</tr>

				<!-- <tr>
					<td><label for="empmail" class="LblDialog">HR-1 Email
							ID<font color="red">*</font>
					</label></td>
					<td><input type="text" name="hr1mail" id="hr1mail"
						class="text ui-widget-content ui-corner-all textfont" value=""
						style="font-size: 15px" /></td>
				</tr>


				<tr>
					<td><label for="empmail" class="LblDialog">HR-2 Email
							ID </label></td>
					<td><input type="text" name="hr2mail" id="hr2mail"
						class="text ui-widget-content ui-corner-all textfont" value=""
						style="font-size: 15px" /></td>
				</tr> -->

			</table>
		</form>

	</div>


	<br></br>
	<br></br>
	<hr></hr>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>