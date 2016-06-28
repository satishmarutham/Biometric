<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.centris.DAO.*"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>


<!--

//-->
</script>
<%
	String username = (String) session.getAttribute("username");
	String basePath = null;
	if (username == null) {
%>

<jsp:forward page="login.jsp"></jsp:forward>

<%
	} else {
		basePath = request.getContextPath();

	}
%>




<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Upload Employee</title>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/addemployee.js"></script>
<script type="text/javascript" src="js/employeeRegistration.js"></script>
<script type="text/javascript" src="js/UploadEmpXSL.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link href="css/latecomersreport.css" rel="stylesheet" type="text/css" />
</head>

<body bgcolor="#FFFFFF">
	<jsp:include page="header_menu.jsp"></jsp:include>
	<br />
	<br />
	<br />
	<br />
	<center>

		<form action="uploadEmpXSL.do?parameter=insertEmpXSL" name="AddEmployeeForm" method="post"
		  enctype="multipart/form-data">
                  

			<div class="backgroungDIV" id="backgroung">

				<font
					style="font-family: sans-serif; font-weight: bolder; color: #000000; font-size: 17px;">Upload Employee</font>
				<br />
			<%-- 	<p class="validateTips" id="error"
					style="font-size: 13px; color: red; font-family: Segoe UI;"></p>
				<html:errors /> --%>

				<logic:present name="Failure" scope="request">
					<p class="validateTipss"
						style="font-size: 15px; color: green; font-family: Segoe UI;">
						<bean:write name="Failure" />

					</p>
				</logic:present>
				<table cellpadding="8" cellspacing="3" id="biometric">

					<tr class="trc">
					<td><input type="file"  name="empfile" id="empfile"></input></td>
				</tr>
				</table>
				<center>

					<table>
						<tr class="odd">

							<td colspan="3"><center>
									<input type="submit" value="Upload" class="button1"
										id="register" onclick="return validate()"/> &nbsp;&nbsp;&nbsp; <input type="reset"
										value="Clear"  class="button1" id="clear" />
								</center></td>

						</tr>

					</table>
					<br/>
						<center>
		<table id="validateTable">
			<tr>
				<td colspan="3">
					<div class="alert-box error">
						<span class="fontweight">Validation failed : </span> <span
							class="validateTips"></span>

					</div>
				</td>
			</tr>
		</table>
	</center>
				</center>
				</center>
	<div class="" align="center">

		<logic:present name="RESULT" scope="request">

			<display:table id="timesheet" name="RESULT" class="displayTableClass" 
				requestURI="/uploadEmpXSL.do?parameter=insertEmpXSL" pagesize="5">
				
				<display:column property="empid" title="Employee_Id" sortable="true" class="cellintag" />
				<display:column property="empname" title="Employee_Name" sortable="true" class="cellintag" />
				<display:column property="phoneno" title="Phone_NO"	sortable="true" />
				<display:column property="empmail" title="Email_Id"	sortable="true" />
				<display:column property="dateofbirth" title="Date_OF_Birth" sortable="true" />
				<display:column property="dateofjoin" title="Date_OF_Join" sortable="true" />
				<display:column property="empaddresss" title="Address" sortable="true" />
                <display:column property="empdesignation" title="Designation" sortable="true" />
                <display:column property="empdepartment" title="Department_Name" sortable="true" />
                <display:column property="empshift" title="Shift_Name" sortable="true" />
                <display:column property="reason" title="Reason" sortable="true" />
            <%--  <display:column property="fathername" title="Father_Name" sortable="true" /> --%>
          
          
          	</display:table>

		</logic:present>
 
				
				
				
				
				
				
				
			</div>

			<br />
		</form>

	</center>
	<br></br>
	<hr></hr>
	
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>



</html>
