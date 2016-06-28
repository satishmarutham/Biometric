<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Employee</title>

<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css">
<script src="JQUERY/development-bundle/jquery-1.8.3.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.core.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.widget.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.position.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.menu.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.draggable.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.resizable.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.dialog.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.effect.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.button.js"></script>
<script type="text/javascript" src="js/RemoveEmployee.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/removeemployee.css"></link>

</head>
<body>

<div id="main">
</br>
</br>
</br>
</br>

	<div class="background" id="backgroung">
	
	<center>
		
		<div class="backgroundDiv" id="backgroung">Remove-Employee</div></br>

				<center>
						<div id="errordiv" class="error-box">
							
							<logic:present name="message" scope="request">
								<span style="color: green; font-family: Segoe UI;">
									<bean:write name="message"/>
								</span>
							</logic:present>
						</div>
			</center>
		<form action="RemoveEmployeeAction.do" method="post" onsubmit="return validateForm()">
		<input type="hidden" value="removeEmployee" name="parameter">
			<table cellpadding="10" cellspacing="3" id="biometric" width="70%">

				<tr align="center">
					<td colspan="3" id="searchbox">Select Employee
						&nbsp;&nbsp;&nbsp;&nbsp;<input class="input" id="emp" name="employeeName"></td>
				</tr>

				<tr>
					<td>Employee Name<br> <input type="text" id="name" name="empname"
						readonly="readonly" /></td>
					<td>Employee Id<br> <input type="text" id="empid"
						name="empid" readonly="readonly" /></td>
					<td>Email Id<br> <input type="text" id="email"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>Shift Name <br> <input type="text" id="shift"
						readonly="readonly" /></td>
					<td>Department <br> <input type="text" id="dept"
						readonly="readonly" /></td>
					<td>Location <br> <input type="text" id="location"
						readonly="readonly" /></td>
				</tr>
			</table>
			
			

			<table>
				<tr>
					<td colspan="3" align="center"><input type="submit" value="Delete" class="submitbutton"/></td>
				</tr>
			</table>
		</form>
		</center>
</div>
</div>
	
</body>
</html>