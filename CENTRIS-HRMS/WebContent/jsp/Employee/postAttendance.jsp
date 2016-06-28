<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Post Attendance</title>

	<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
		<link href="css/Home/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
		<link href="css/Home/bootstrap-combined.min.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
	<script type="text/javascript"	src="JQUERY/js/bootstrap-datetimepicker.min.js"></script>


<script type="text/javascript" src="js/Employee/postAttendance.js"></script>

<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>


<style type="text/css">
.pagebanner,.pagelinks {
	display: none;
}
</style>
</head>
<body>
	<div>
	<center><div id="loader" style="position: absolute;top:200px;left:650px;display: none;"><img  src="images/loaderimage2.GIF"/></div></center>
		<center>
			<br />
			<div class="background" id="backgroung">
				<div class="backgroundDiv" id="backgroung">Post Atttendance</div>
				<br />
				<div id="errordiv" class="error-box">
				<logic:present name="message" scope="request">
					<span style="color: green">
					<bean:write name="message" scope="request"/>
					</span>
				</logic:present>
				<logic:present name="errorMessage" scope="request">
					<span style="color: red">
					<bean:write name="errorMessage" scope="request"/>
					</span>
				</logic:present>
				
				</div>
			
			<logic:present name="getAttendanceDetails" scope="request">
					<div style="overflow-X:auto; ">
					<display:table export="false" 	class="view" style="width:120%;"
						name="requestScope.getAttendanceDetails"
						requestURI="/employeeMenu.do?parameter=postattendance"
						pagesize="15" cellpadding="1" cellspacing="1" size="20"
						decorator="com.centris.decorator.EmployeeAttendancePostingDecorator">
						<display:column property="get_Sno" title="S.No"
							style="color:#171313;background-color:white;" />
						<display:column property="date" title="Date" style="color:#171313;background-color:white;width:8%;" />
						<display:column property="status" title="Status"
							style="color:#171313;background-color:white;" />
						<display:column property="type" title="Attendance Type"
							style="color:#171313;background-color:white;" />
						<display:column property="intime" title="In - Time"
							style="color:#171313;background-color:white;" />
						<display:column property="outtime" title="Out - Time"
							style="color:#171313;background-color:white;" />
						<display:column property="totaltime" title="Total - Time"
							style="color:#171313;background-color:white;" />
						<display:column property="manager" title="Reporting Manager/Director"
							style="color:#171313;background-color:white;" />
						<display:column property="clients" title="Client"
							style="color:#171313;background-color:white;" />
						<display:column property="description" title="Description"
							style="color:#171313;background-color:white;" />
					</display:table>
					
					<br/>
					</div>
			
	          <br/>
				<table>
					<tr>
						<td align="right"><input type="button" class="submitbutton"
							id="buttonID" value="Post" onclick="validate()"></input></td>
					</tr>
				</table>
				<br />
					</logic:present>
			</div>
		</center>
	
	</div><br/>
	 <span id="dashboard_goBack" onclick="goback()" style="margin-left:90%;text-decoration: underline;font-size:16px;
  cursor: pointer;">go back</span>
</body>
</html>