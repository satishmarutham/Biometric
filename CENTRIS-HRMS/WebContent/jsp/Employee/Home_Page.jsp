<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%
	String username = (String) session.getAttribute("username");
	if (username == null) {
%>

<jsp:forward page="login.jsp"></jsp:forward>

<%
	} else {

	}
%>

<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<title>Welcome to Tel India Attendance</title>

<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/Employee/Employee.js"></script>
<style type="text/css">
#box1 {
	float: left;
	min-height: 150px;
	max-height: 100%;
	width: 14%;
	padding: 0 15px 0 15px;
	background: #E6E6E6;
	margin: 7px 20px 9px 20px;
	-webkit-box-shadow: 7px 7px 5px rgba(50, 50, 50, 0.75);
	-moz-box-shadow: 7px 7px 5px rgba(50, 50, 50, 0.75);
	box-shadow: 7px 7px 5px rgba(50, 50, 50, 0.75);
}

#box1:hover {
	transform: rotate(0deg) scale(0.99) skew(1deg) translate(0px);
	-webkit-transform: rotate(0deg) scale(0.99) skew(1deg) translate(0px);
	-moz-transform: rotate(0deg) scale(0.99) skew(1deg) translate(0px);
	-o-transform: rotate(0deg) scale(0.99) skew(1deg) translate(0px);
	-ms-transform: rotate(0deg) scale(0.99) skew(1deg) translate(0px);
}

p {
	font-family: Segoe UI !important;
	font-size: 13px;
}

.custom h4 {
	font-family: Segoe UI;
}
</style>

</head>
<body>
	<br>
	<br>
	<br>

	<center>
		<div id="box1" style="margin-left: 10%;">

			<div class="custom">
				<h4>Personal Information</h4>
				<p>Add and Update your Personal Details
				<p>
					<input type="button" value="Details" class="linkButton"
						id="getPersonalDetails"> <br>
				</p>
				</p>
			</div>
		</div>
		<div id="box1">

			<div class="custom">
				<h4>Attendance Posting</h4>
				<p>
					For Attendance & Attendance Posting <br /> <br /> <input
						type="button" value="Details" class="linkButton"
						id="getAttendancePosting"> <br>
					
				</p>
			</div>
		</div>
		<div id="box1">

			<div class="custom">
				<h4>Leave Details</h4>
				<p>
					To Apply and View Leave Request Details <br /> <br>
						<input type="button" value="Details" class="linkButton"  
						id="getLeaveDetails"> <br>
					
				</p>
			</div>
		</div>
		<div id="box1">

			<div class="custom">
				<h4>Change Password</h4>
				<p>
					Here you change your password Credentials <br /><br> 
						<input type="button" value="Details" class="linkButton"
						id="getPasswordDetails"> <br>
				</p>
			</div>
		</div>
		<br/>
		<div id="box1" style="margin-left: 10%;">

			<div class="custom">
				<h4>Expense Details</h4>
				<p>
					Here you update your Expense Details <br /><br> 
						<input type="button" value="Details" class="linkButton"
						id="getExpenseDetails"> <br>
				</p>
			</div>
		</div>
	</center>

</body>
</html>