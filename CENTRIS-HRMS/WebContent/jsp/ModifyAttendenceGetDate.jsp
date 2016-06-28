<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>

<%
	String username = (String) session.getAttribute("username");
	String basePath = null;
	if (username == null) {
%>

<jsp:forward page="login.jsp"></jsp:forward>

<%
	} else {
		basePath = request.getContextPath();

	}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>MODIFY ATTENDANCE</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/employeeRegistration.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>


<script type="text/javascript">
	$(function() {
		$("#datepicker").datepicker({
			dateFormat : "yy-mm-dd",
			yearRange : 'c-65:c+65',
			maxDate : 0,
			changeMonth : "true",
			changeYear : "true",
			buttonImageOnly : false
		}
		);
	});

	function formCheck() {

		var employeeDate = document.getElementById('datepicker').value;

		if (employeeDate == "" || employeeDate == "Click here") {
			document.getElementById('error').innerHTML = 'Please Select Date';
			return false;
		}
		return true;
	}
</script>
</head>
<body>

	<jsp:include page="header_menu.jsp"></jsp:include>
	<br/><br/><br/><br/>
	<center>
		<font
			style="font-family: sans-serif; font-weight: bolder; color: #000000; font-size: 17px;">MODIFY ATTENDANCE</font>
	</center>
	<br></br>
	<center>
		<form action="<%=basePath%>/ModifyGetDate.do" name="AddEmployeeForm">

			<table id="biometric">
				<tr>
					<th>Select Date</th>
					<td><input type="text" id="datepicker" name="datum1"
						style="cursor: pointer;" value="Click here" readonly="readonly"></td>
				</tr>

			</table>
			<br>
			<div id="error" style="color: red">
				<html:errors />
				<logic:present name="RESULT" scope="request">
					<p class="validateTipss"
						style="font-size: 13px; color: green; font-family: Segoe UI;">
						<bean:write name="RESULT" />
					</p>
				</logic:present>
			</div>
			</br>
			<table>
				<tr>
					<td align="center"><input type="submit" class="button1"
						value="submit" onclick="return formCheck();"></input></td>
				</tr>
			</table>

		</form>
	</center>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
	<br></br>
	<hr></hr>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>