<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <jsp:include page="header_menu.jsp"></jsp:include> --%>
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Employee</title>
<script type="text/javascript" src="js/AllEmployee.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

</head>

<body>

	<br />
	<br>
	<br />
	<br />

	<div align="center" id="main">
		<center>
			<div class="background" id="backgroung">
				</br>

				<div class="backgroundDiv" id="backgroung">All Employees</div>
				<center>
					<div id="errordiv" class="error-box">

						<logic:present name="message" scope="session">
							<span style="color: green; font-family: Segoe UI;"> <bean:write
									name="message" />
							</span>
						</logic:present>
					</div>
				</center>
				<input type="hidden" id="employeeSize"
					value="<logic:present name="total_Size" scope="request"><bean:write name="total_Size"/></logic:present>">
				<html:form action="/GetDetails.do?parameter=listofAllEmployeeSearch"
					method="POST">
					<table align="center" cellpadding="3" cellspacing="3"
						id="biometric">

						<tr>
							<td><input type="text" name="empName" id="searchempname"
								placeholder="Type Employee Name"></td>

							<td><input type="submit" value="Search" class="submitbutton"
								onclick="return validate()"></td>

						</tr>

					</table>


					<div class="tablecss" style="width: 80%; margin: 15px;">
						<display:table export="false" id="defaulttable"
							name="requestScope.getAllEmployee"
							requestURI="/GetDetails.do?parameter=listofEmployee"
							pagesize="20" cellpadding="5" cellspacing="5" size="20"
							style="bgcolor: RED;"
							decorator="com.centris.decorator.AllEmployeeDecorator">


							<display:column property="empid" title="Employee ID"
								style="color:#171313" paramId="selectEmployee"
								href="modifyEmployee.do?parameter=ModifyEmployeefromlist&${row.id}" />
							<display:column property="empname" title="Employee Name"
								style="color:#171313" />
							<display:column property="shiftname" title="Shift Name"
								style="color:#171313" />
							<display:column property="department" title="Department Name"
								style="color:#171313" />

							<display:column property="location" title="Location"
								style="color:#171313" />
							<%-- <display:column property="edit" title="Edit" autolink="true" /> --%>

							<display:setProperty name="export.pdf.filename"
								value="AllEmployee.pdf" />
							<display:setProperty name="export.pdf" value="true" />
							<display:setProperty name="export.excel.filename"
								value="AllEmployee.xls" />
							<display:setProperty name="export.excel" value="true" />
							<display:setProperty name="export.csv.filename"
								value="AllEmployee.csv" />
							<display:setProperty name="export.csv" value="true" />
							<display:setProperty name="export.xml.filename"
								value="AllEmployee.xml" />
							<display:setProperty name="export.xml" value="true" />
						</display:table>


					</div>
					<br />
					<input type="button" id="download" value="Download PDF" class="submitbutton">
					<input type="button" id="allDetails" value="All Details PDF" class="submitbutton">
				</html:form>
			</div>
		</center>
	</div>

	<br>
	<br>
	<hr></hr>

</body>
</html>

<%-- <jsp:include page="footer.jsp"></jsp:include> --%>
