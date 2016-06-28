
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@page import="java.util.*"%>
<%
	String username = (String)session.getAttribute("username");
	if(username== null){
		;
%>

<jsp:forward page="login.jsp"></jsp:forward>

<%
	}else{
		

	}
%>


<%
	ArrayList<String> empid = (ArrayList)request.getAttribute("empid");
	  ArrayList<String> empname = (ArrayList)request.getAttribute("empname");
	  ArrayList<String> phone = (ArrayList)request.getAttribute("phone");
	  ArrayList<String> email =(ArrayList)request.getAttribute("email");
	 int size = empname.size();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Today's Attendance</title>
<link rel="stylesheet" type="text/css" href="view.css" />
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/employeeRegistration.js"></script>


</head>
<body>


	<script type="text/javascript">
		function formCheck() {
			var employeeDate = document.getElementById('datepicker').value;

			if (employeeDate == "" || employeeDate == "Click here") {
				document.getElementById('error').innerHTML = 'Please Select Date';
				return false;
			}
			return true;
		}
	</script>
	<script>
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
	</script>
	<jsp:include page="header_menu.jsp"></jsp:include>
	<br></br><br/> <br/>
	<center>
		<center>
			<font
				style="font-family: sans-serif; font-weight: bolder; color: #000000; font-size: 17px;">TODAY'S	ATTENDANCE</font>
		</center>

		<br></br>

		<html:form action="/SaveAttendence">
			<center>
				<table id="biometric">
					<tr>
						<th>Select Date</th>
						<td><input type="text" id="datepicker" name="datum1"
							style="cursor: pointer;" value="Click here" readonly="readonly">
						</td>
					</tr>

				</table>

			</center>
			<br></br>
			<table id="biometric" cellspacing="3" cellpadding="3">
				<thead>
					<tr>
						<th>Employee ID</th>
						<th>Employee Name</th>
						<th>Status</th>
						<th>Phone</th>
						<th>Email</th>
						<th>Remark</th>
					</tr>
				</thead>

				<tbody>
					<%
						for (int i = 0; i < size; i++) {
					%>
					<tr>
						<td><input type="text" size="6" name="empID"
							readonly="readonly" value="<%=empid.get(i)%>" /></td>
						<td><input type="text" size="14" name="empName"
							readonly="readonly" value="<%=empname.get(i)%>"></input></td>
						<td><select name="status" size="1">
								<option value="Present">Present</option>
								<option value="Absent">Absent</option>
								<option value="Sunday">Sunday</option>
								<option value="Holiday">Holiday</option>
								<option value="NA">NA</option>
						</select></td>
						<td><input type="text" size="10" name="phone"
							readonly="readonly" value="<%=phone.get(i)%>"></input></td>
						<td><input type="text" size="14" name="email"
							readonly="readonly" value="<%=email.get(i)%>"></input></td>
						<td><textarea rows="2" cols="15" name="remark"></textarea></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<br><div id="error" style="color: red">
				<html:errors />
			<logic:present name="RESULT" scope="request">
				<p class="validateTipss"
						style="font-size: 13px; color: green; font-family: Segoe UI;">
					<bean:write name="RESULT" />
				</p>
			</logic:present>
		</div></br>
			
			<table>
				<tr>
					<html:submit onclick="return formCheck();" styleClass="button1">Submit</html:submit>
				</tr>
			</table>
		</html:form>
	</center>
	<br></br>
	<hr></hr>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>