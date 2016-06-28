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
<title>Welcome to Tele India Attendance</title>
<link rel="stylesheet" type="text/css" href="view.css" />
</head>
<body>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />

	<center>
		<font color="#013ADF" size="5"><b>Welcome to Tele India
				Attendance Solution - Manager </b></font>
	</center>

</body>
</html>