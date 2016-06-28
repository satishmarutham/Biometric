<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<% String username = (String)session.getAttribute("username");
	if(username== null){
		 %>
		
		<jsp:forward page="login.jsp"></jsp:forward>
			
		 <%
	}else{
		

	}

%>

<jsp:forward page="/UserAction.do"></jsp:forward>