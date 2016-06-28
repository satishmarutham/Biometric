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
<title>In-active Employees</title>
<script type="text/javascript" src="js/ActiveEmployee.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>



</head>

<body>

	<br />
	<br>
	<br/>
	 <br/>
	
	<div align="center" id="main">
	<center>
	<div class="background" id="backgroung"></br>

		<div class="backgroundDiv" id="backgroung">In-Active Employees List</div>
		<center>
						<div id="errordiv" class="error-box">
							
							<logic:present name="message" scope="request">
								<span style="color: green; font-family: Segoe UI;">
									<bean:write name="message"/>
								</span>
							</logic:present>
						</div>
			</center>
		<html:form action="/GetDetails.do?parameter=listofAllEmployeeSearch"
			method="POST">
			
		<div class="tablecss" style="width:80%;margin:20px;">
				<display:table export="false" id="defaulttable"
					name="requestScope.getAllEmployee"
					requestURI="/GetDetails.do?parameter=listofDeactiveEmployee" pagesize="20"
					cellpadding="5" cellspacing="5" size="20" style="bgcolor: RED;"
					>


					<display:column property="empid" title="Employee ID"  style="color:#171313"/>
					<display:column property="empname" title="Employee Name"
						 style="color:#171313" />
					<display:column property="shiftname" title="Shift Name"
						 style="color:#171313" />
					<display:column property="department" title="Department Name" 
						 style="color:#171313" />
						
						 <display:column property="designation" title="Designation name"
						 style="color:#171313" />

					<display:column property="location" title="Location"
						 style="color:#171313" />
						 <display:column
						title="">
						
						<input type="button" name="activebutton" id="${defaulttable.empid},${defaulttable.locationid},${defaulttable.designationid}"
							value="Activate" onclick="activeRecords(this)" class="submitbutton"> </>
				</display:column>
				
				</display:table>
		

</div>


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
