<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Employee</title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

<style >

table#biometric tr {
	padding: 1px;
}

table#biometric_1 td {
	font-family: "Segoe UI Semibold","Segoe UI";
	color: black;
	font-size: 12px;
	font-weight: normal;
	text-align: justify;
	margin: 1px;
	width: 20%;
	height: 70px;

	/* border: 1px solid #BDC3C7; */
}

table#biometric_1 th {
	font-family: "Segoe UI Semibold","Segoe UI";
	/* background-color: gray; */
	color: #FFFFFF;
}

table#biometric_1 label {
	font-family: "Segoe UI Semibold","Segoe UI";
	color: #003D52;
	font-size: 12px;
	font-weight: bold;
	text-align: center;
	font-family: "Segoe UI Semibold","Segoe UI";
}

.menuiconimg{

border-radius: 8px;
width: 50%;
height:90px;
}


.menuicontext{

text-align: center;
font-family: Segoe UI ;
color: #787878 ;
font-size: 14px;


}
</style>

</head>

<body>



	<div id="main" class="background">
		<center>
  <br/>
   <br/> <br/>
  
			<table  id="biometric_1" style="border:none !important; " cellpadding="3px" cellspacing="3px" width="80%">

				<tr>
					<td><center><a href="GetDetails.do?parameter=orgStructure"><img src="menuicons/OrgStructure.jpg"  id="empImagePreview" class="menuiconimg" width="80% !important"/> </a><br/><span class="menuicontext">Organization Structure</span></center></td>
					<td><center><a href=""><img src="menuicons/Employee Forums.png" id="empImagePreview" class="menuiconimg"/> </a><br/><span class="menuicontext">Employee Portal</span></center></td>
					<td><center><a href=""><img src="menuicons/hrm_timesheet.jpg" id="empImagePreview" class="menuiconimg"/> </a><br/><span class="menuicontext">Attendance</span></center></td>
					<td><center><a href=""><img src="menuicons/Leave Management.png"  id="empImagePreview" class="menuiconimg"/> </a><br/><span class="menuicontext">Leave Management</span></center></td>
				
				</tr>
				
				<tr>
				
				<td><center><a href=""><img src="menuicons/Timesheets.png"  id="empImagePreview" class="menuiconimg"/> </a><br/><span class="menuicontext">Timesheets Management</span></center></td>
				<td><center><a href=""><img src="menuicons/Calendar.jpg"  id="empImagePreview" class="menuiconimg"/> </a><br/><span class="menuicontext">Calendar</span></center></td>
				<td><center><a href=""><img src="menuicons/Payroll.png"  id="empImagePreview" class="menuiconimg"/> </a><br/><span class="menuicontext">Payroll</span></center></td>
				<td><center><a href=""><img src="menuicons/TravelManagement.png"  id="empImagePreview" class="menuiconimg"/> </a><br/><span class="menuicontext">Travel Management</span></center></td>
				
				</tr>
				
				
				<tr>
				
				<td><center><a href=""><img src="menuicons/Recruitment Process.png"  id="empImagePreview" class="menuiconimg"/> </a><br/><span class="menuicontext">Recruitment Process</span></center></td>
				<td><center><a href=""><img src="menuicons/Employee Apraisals.png"  id="empImagePreview" class="menuiconimg"/> </a><br/><span class="menuicontext">Employee Aprisals</span></center></td>
				<td><center><a href=""><img src="menuicons/Inventory Management.png"  id="empImagePreview" class="menuiconimg"/> </a><br/><span class="menuicontext">Inventory</span></center></td>
				<td><center><a href=""><img src="menuicons/Project Management.png"  id="empImagePreview" class="menuiconimg"/> </a><br/><span class="menuicontext">Project Management</span></center></td>
					
					
				</tr>
				<tr>
				
				<td><center><a href=""><img src="menuicons/Issue Tracking.png"  id="empImagePreview" class="menuiconimg"/> </a><br/><span class="menuicontext">Issue Tracking</span></center></td>
				<td><center><a href=""><img src="menuicons/WebsiteLiveChat.png"  id="empImagePreview" class="menuiconimg"/> </a><br/><span class="menuicontext">Live CHating</span></center></td>
				<td><center><a href=""><img src="menuicons/Accounting and Finance.png"  id="empImagePreview" class="menuiconimg"/> </a><br/><span class="menuicontext">Accounts & Finance</span></center></td>
					
				</tr>
				
			

			</table>

		</center>
	</div>


</body>



</html>
