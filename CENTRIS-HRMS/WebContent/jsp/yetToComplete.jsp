<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<% String username = (String)session.getAttribute("username");
	if(username== null){
		 %>
		
		<jsp:forward page="login.jsp"></jsp:forward>
			
		 <%
	}else{

	}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>yet to complete</title>
				<link rel="stylesheet" type="text/css" href="view.css" />
	</head>
	<body>
     	<br></br><br></br>
     		<br/> <br/>
		<center><font  size="4">Documentation is under preparation.....</font></center>
			
		<br></br><hr></hr>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>