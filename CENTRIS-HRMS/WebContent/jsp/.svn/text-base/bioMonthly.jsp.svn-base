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
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<link rel="shortcut icon" href="images/favicon.ico">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Monthly Report</title>
		
			 		<link rel="stylesheet" type="text/css" href="view.css" />
	</head>
	<body>
	<jsp:include page="header_menu.jsp"></jsp:include>               
     <br></br>    <br/> <br/> 
         <center>
	<center><h4>Monthly Report</h4></center>
         		
         	<html:form action="/monthlyat">
         	
         <table width="AUTO"  align="center" border="0" style="bgcolor: #3B3B3B;" frame="box"  bordercolor="black">
         			
         		<tr>
         			<td colspan="1" align="center"><font style="font-family: sans-serif; font-size: 11px; color:#CCC">SelectName</font></td>
         			<td colspan="1" align="center"><font style="font-family: sans-serif; font-size: 11px; color:#CCC">Year</font></td>
         			<td colspan="1" align="center"><font style="font-family: sans-serif; font-size: 11px; color:#CCC">Month</font></td>
         		</tr>
         		<tr>
         			<td colspan="1">
							<html:select property="employeeName">
								<html:option value="All"/>
								<%for(int i =0; i<empname.size(); i++){%>
								<html:option value="<%= empname.get(i) %>"/>
								<%} %>
							</html:select>
					</td>
         			<td>
         			<select name="year">
         				<option value="">Select</option>
         				 <% for(int i=2012; i<=2020; i++){ %>        				
         				<option value="<%= i %>"><%= i %></option>
         				<% } %>
         			</select>     			
         			</td>
         			<td>
         				<select name="month">
         					<option value="">Select</option>
         					<option value="01">Jan</option>
         					<option value="02">Feb</option>
         					<option value="03">Mar</option>
         					<option value="04">Apr</option>
         					<option value="05">May</option>
         					<option value="06">Jun</option>
         			 		<option value="07">July</option>
         					<option value="08">Aug</option>
         					<option value="09">Sep</option>
         					<option value="10">Oct</option>
         					<option value="11">Nov</option>
          					<option value="12">Dec</option>         				
         				</select>
         				
         			</td>
         		</tr>
         		
         		<tr>
         			<td colspan="3" align="center">
         			<input type="submit" class="button1"  value="submit"> 
         			</td>
         		</tr>
         	</table> 
         	</html:form>
         	 </center>   	
       <br></br><br><br><br><br><br><br>
			<hr></hr>
<jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>