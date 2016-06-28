<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
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
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/Manager/AllEmployeeDetails.js"></script>
<link rel="shortcut icon" href="images/favicon.ico">
<title>Welcome to Tele India Attendance</title>
<link rel="stylesheet" type="text/css" href="view.css" />
<link rel="stylesheet" type="text/css" href="css/Manager/Home_Page.css" />
<link rel="stylesheet" type="text/css" href="css/common.css" />

</head>
<body>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
		<center>
				
			<table>		
			<tr>			<td align="left" valign="middle"><input type="text"
									name="searchTerm" id="searchTermId" value=""
									placeholder="Search for Employee" /></td>
								<td align="center" valign="middle"><input type="submit"
									id="search" class="submitbutton" value="Search"></td>
								<td></td>
							</tr>
						</table>
			<table id="validateTable">
				<tr>
					<td colspan="3">
						<div class="alert-box error">
							<span style="color: red; font-size: 13px;" class="validateTips"></span>

						</div>
					</td>
				</tr>
			</table>
				</center>
	   <br />
					<logic:present name="EmployeeDetails" scope="request">
					<center>
						<display:table 
							name="requestScope.EmployeeDetails"
							class="view"
							requestURI="/managerMenu.do?parameter=home"
							pagesize="30"
							decorator="com.centris.decorator.EmployeeDetailsDecorator">
							<display:column property="sno" title="S.No" />
							<display:column property="empname" title="Employee Name" />
							<display:column property="phone"
								title="Mobile No" />
							<display:column property="designation" title="Designation" />
							<display:column property="email" title="Email Id" />
							<display:column property="address" title="Address" />
							<%-- <display:column property="download" title="Download" /> --%>
							<display:column property="viewButton" title="View" />
						</display:table>
						 </center>
					</logic:present>
                

			

</body>
</html>