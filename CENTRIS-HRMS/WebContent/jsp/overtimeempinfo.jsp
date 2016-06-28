<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="view.css" />
<title>Emp Info</title>
</head>
<body>
<select name="empname" >
				<option value="00-all">All</option>

				<%
				
				 ArrayList<String> emplist = (ArrayList<String>)request.getAttribute("emplist");
				if(emplist!=null)
				{
				Iterator<String> list = emplist.iterator();
				while(list.hasNext())
				{
					String empName=list.next();
					%>
					<option value="<%=empName%>"><%=empName%></option>
				<%}}
				%>
			
					
					</select>
</body>
</html>