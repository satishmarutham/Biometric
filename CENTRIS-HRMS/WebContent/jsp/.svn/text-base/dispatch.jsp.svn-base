<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<% String username = (String)session.getAttribute("username");
	if(username== null){
		 %>
		
		<jsp:forward page="login.jsp"></jsp:forward>
			
		 <%
	}else{
		

	}

%>

<html>
<head>
    <title>INTERVIEW TRACKER </title>
</head>
<body>
    <h2>INTERVIEW TRACKER</h2>
 
    <html:link page="dispatch.do?parameter=newuser">New User</html:link>
   
    <html:link page="dispatch.do?parameter=modifyuser">Modify User</html:link>
    
   
    
    <html:link page="dispatch.do?parameter=viewuser">View Details</html:link>
   
    <html:link page="dispatch.do?parameter=tracker">Interview tracker entry</html:link>
    
     <html:link page="dispatch.do?parameter=trackermodify">Modify tracker</html:link>
           
    <html:link page="dispatch.do?parameter=reports">Interview tracker reports</html:link>
 	
</body>
</html>