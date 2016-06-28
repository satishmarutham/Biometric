<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
 <script language="JavaScript">
  javascript:window.history.forward(1);
</script>
</head>
 
 
 
<body >


<%
     String username = (String)session.getAttribute("username");
	if(username== null){
	%>
		
		<jsp:forward page="login.jsp"></jsp:forward>
			
		 <%
	}else{
		
		session.setAttribute("username", null);
		session.invalidate();
		

	}

	
%>
</body>
</html>