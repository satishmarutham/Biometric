<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String username = (String)session.getAttribute("username");
String basePath = null;
	if(username== null){
		%>
		
		<jsp:forward page="login.jsp"></jsp:forward>
			
		 <%
	}else{
		basePath=request.getContextPath();
		
	}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>error page</title>
<link rel="stylesheet" type="text/css" href="style.css" />
		
</head>
<body>
<jsp:include page="header_menu.jsp"></jsp:include>       
<img src="images/construction.jpg" height="100" width="100"/>
<b>Under Processing</b>
<jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>