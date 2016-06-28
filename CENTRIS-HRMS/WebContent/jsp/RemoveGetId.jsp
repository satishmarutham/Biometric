<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@page import="java.util.*" %>
<% String username = (String)session.getAttribute("username");
	if(username== null){
		 %>
		
		<jsp:forward page="login.jsp"></jsp:forward>
			
		 <%
	}else{
		

	}

%>

<%
ArrayList<String> empname = (ArrayList)request.getAttribute("empname");
List<String> empid = (ArrayList)request.getAttribute("empid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>REMOVE EMPLOYEE</title>
		<link rel="stylesheet" type="text/css" href="style.css" />
 		
		
	<script type="text/javascript">
			function select()
			{
				
				f1.action="RemoveGetId.do";
				f1.submit();
			}
		
		</script>	
		<link rel="stylesheet" type="text/css" href="view.css" />
	</head>
	<body>
	
	<jsp:include page="header_menu.jsp"></jsp:include>               
     <br></br>   <br/> <br/>
     
      <center>
        	<H4>REMOVE-EMPLOYEE</H4>
        </center>
       <br></br>
    
     <center>
		<form action="" name="f1">
			<html:form action="/RemoveGetId">
				<table id="dataTable" align="center" border="0" bgcolor="#4A5152" frame="box"  bordercolor="black">
				
					<tr>
					<td colspan="1" align="center"><font style="font-family: sans-serif; font-size: 11px; color:#CCC"><bean:message key="AddEmployee.employeeName"/></font></td>
						<td colspan="1">
			<html:select property="employeeName" onchange="select()">
				<html:option value="select"></html:option>
				<%for(int i =0; i<empname.size(); i++){%>
					<option value="<%= empid.get(i) %>"><%= empname.get(i)+"-"+empid.get(i) %></option>
					<%} %>
			</html:select>
			<br></br></td>	
					</tr>
					<tr>
						<td colspan="1" align="center"><font style="font-family: sans-serif; font-size: 11px; color:#CCC"><bean:message key="AddEmployee.employeeID"/></font></td>
						<td colspan="1"><input type="text"></input></td>	
					</tr>
					<tr>
						<td><!--
							<html:submit></html:submit>
						--></td>
					</tr>
				</table>
			</html:form>
			</form>
			</center>
		<br></br>
			<hr></hr>
<jsp:include page="footer.jsp"></jsp:include>
			    	
</body>
</html>