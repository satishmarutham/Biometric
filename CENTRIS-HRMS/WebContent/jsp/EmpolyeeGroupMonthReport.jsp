<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page import="java.util.*"%>

<%@page import="com.centris.DAO.*"%>
<%@page import="java.sql.*"%>
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
<%
	ArrayList<String> empname = (ArrayList) request
			.getAttribute("empname");
	List<String> empid = (ArrayList) request.getAttribute("empid");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>GROUP MONTH REPORT</title>
<link rel="shortcut icon" href="images/favicon.ico">
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>

<link rel="stylesheet" href="JQUERY/css/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="./style/main.css"></link>
<link rel=StyleSheet href="menu.css" type="text/css" />
<script src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script src="JQUERY/js/jquery.ui.mouse.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.core.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.widget.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.mouse.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.button.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.draggable.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.position.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.resizable.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.dialog.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.effect.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.datepicker.js"></script>

<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.button.js"></script>
<script type="text/javascript" src="js/GroupMonthReport.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<style type="text/css">
.even {
	background-color: #72B0E4;
	font-size: 12px;
	font-color: #FFF;
	text-align: center;
	font-family: Arial, Helvetica, sans-serif;
	padding: 5px;
}

.odd {
	background-color: #BCD1E1;
	color: #FFFFFF;
	font-size: 12px;
	font-color: #FFF;
	text-align: center;
	font-family: Arial, Helvetica, sans-serif;
	padding: 5px;
}
</style>
</head>
<body>

	<jsp:include page="header_menu.jsp"></jsp:include>


	<br></br><br/> <br/>

	<center>
		<font
			style="font-family: sans-serif; font-weight: bolder; color: #000000; font-size: 17px;">GROUP MONTH REPORT</font>
	</center>
	<br>
	<center>
		<span id="error"
			style="font-family: sans-serif; font-weight: bolder; color: red; font-size: 14px;"></span>
			</br>
	</center>
	<center>
		<form action="groupmonthreport.do" name="AddEmployeeForm"
			onsubmit="return validateForm()">

			<table id="biometric">
				<tr>
					<td>GroupName</td>
					<td>DepartmentName</td>
					<td>FromDate</td>
					<td>ToDate</td>


				</tr>

				<tr>
					<td><select id="group" name="group">
							<option value="">--select--</option>


					</select></td>
					<td><select id="department" name="department">
							<option value="all">All</option>
					</select></td>
					<td><input name="date1" id="date" readonly="readonly"
						style="cursor: text" value="" /><br /></td>
					<td><input name="date2" id="date1" readonly="readonly"
						style="cursor: text" value="" /><br /></td>
				</tr>
			</table>
			<br></br>
			<table>
				<tr>

					<td colspan="6" align="center"><html:submit property="parameter"
							styleId="viewReport" styleClass="button1">ViewReport</html:submit></td>
				</tr>
			</table>
		</form>
	</center>
	<center>

		<table align="center" cellpadding="2" cellspacing="2">
			<display:table export="true" id="data" name="requestScope.listvalemp"
				frame="yes" requestURI="groupmonthreport.do" cellpadding="5"
				cellspacing="6" size="20" pagesize="20">
				<display:column property="date" title="DATE" sortable="true"
					style="color:black" />
				<display:column property="empId" title="EMPID" sortable="true"
					style="color:black" />
				<display:column property="ename" title="EMPNAME" sortable="true"
					style="color:black" />
				<display:column property="deptName" title="DEPARTMENTNAME"
					sortable="true" style="color:black" />
				<display:column property="inTime" title="INTIME" sortable="true"
					style="color:black" />
				<display:column property="outTime" title="OUTTIME"   sortable="true" 
				style="color:black" />
			<display:column property="attendence" title="ATTENDANCESTATUS"
						sortable="true" style="color:black" />

				<display:setProperty name="export.pdf.filename"
					value="GROUPMONTHREPORT.pdf" />
				<display:setProperty name="export.pdf" value="true" />

				<display:setProperty name="export.excel.filename"
					value="GROUPMONTHREPORT.xls" />
				<display:setProperty name="export.excel" value="true" />

				<display:setProperty name="export.csv.filename"
					value="GROUPMONTHREPORT.csv" />
				<display:setProperty name="export.csv" value="true" />

				<display:setProperty name="export.xml.filename"
					value="GROUPMONTHREPORT.xml" />
				<display:setProperty name="export.xml" value="true" />

			</display:table>
		</table>

	</center>
	<br></br>
	<br></br>
	<hr></hr>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>