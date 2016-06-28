<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Modify Employee</title>
		<!-- <script type="text/javascript">
			function select(){
				f1.action="retrieveData.do";
				f1.submit();
			}
		</script>	 -->
		<link rel="stylesheet" type="text/css" href="view.css" />
	</head>
	<body>
         <jsp:include page="header_menu.jsp"></jsp:include>               
    	 <br/>     <br/>
  		<center>
        	<font style="font-family: sans-serif; font-weight:bolder; color:#000000;  font-size: 17px;">MODIFY-EMPLOYEE</font>
        </center> 
     	<center>
			<form action="" name="f1">
				<%-- <html:form action="/retrieveData" >	 --%>
				<br/>		
					<table id="biometric" >
						<tr>
							<td >Select Employee</td>
							  			
  						</tr>
 	
						<tr> 
							<td >						
								<select name="selectEmployee" onchange="select()" >
									<option>Select</option>
										<%for(int i =0; i<empname.size(); i++){%>
									<option value="<%= empid.get(i) %>"><%= empname.get(i)+"-"+empid.get(i) %></option>
									<%} %>
								</select>						
							</td>							
					
						</tr>
					</table>
			<%-- 	</html:form> --%>
			</form>
		</center>
       	<br/>	<br/>	<br/>	<br/>	<br/>	<br/>
		<hr></hr>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>

 