<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<link type="text/css" href="menu.css" rel="stylesheet" />
<link type="text/css" href="css/redfin_menu.css" rel="stylesheet" />
<link type="text/css" href="view.css" rel="stylesheet" />
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="menu.js"></script>
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
<script type="text/javascript"src="JQUERY/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>


</head>
<body>

<input type="hidden" id="userRole" value='<logic:present  name="roleCode" scope="session"> <bean:write name="roleCode" scope="session"/></logic:present>'/>
	<center>
		<font color="#00000" size="4"><img src="images/surin.jpg"
			align="left" height="70px" width="100px" /> <img
			src="images/bioHeader.jpg" align="left" height="80px" width="650px"
			style="padding-left: 200px" /> </font>
	</center>
	<br></br>
	<br></br>


	<div class="mains">
	
	 <logic:present name="roleName" scope="session">
	
	
	<c:set var="user" value="Super Admin" />
	
	<c:if test="${ roleName== user}"> 

		<ul class="menu">
			<li><html:link page="/GetDetails.do?parameter=home"
					style="text-decoration:none">
					<span><img src="images/home.png" height="22" width="22" />Home</span>
				</html:link></li>

			<li><a href="#" class="parent"><span><img
						src="images/emplo.png" height="22" width="22" />Employee</span></a>
				<ul>
					<li><html:link page="/GetDetails.do?parameter=addEmployee"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" align="left"
								width="22" />Creation</span>
						</html:link></li>
					<li><html:link page="/GetDetails.do?parameter=modifyEmployee"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="20"
								align="left" width="20" />Amendment</span>
						</html:link></li>
					<li><html:link
							page="/GetDetails.do?parameter=removeSelectName"
							style="text-decoration:none">
							<span><img src="images/remove.png" height="22"
								align="left" width="22" />De-Activation</span>
						</html:link></li>
					<li><html:link page="/weekoff.do?parameter=showWeekOff"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Week Off settings</span>
					<li><html:link page="/uploadEmpXSL.do?parameter=uploadEmpXSL"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />Upload Employee File</span>
						</html:link></li>
						</html:link></li>
					<li><html:link page="/GetDetails.do?parameter=listofEmployee"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />All Employee</span>
						</html:link></li>
						<li><html:link page="/GetDetails.do?parameter=shiftAmendment"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />Shift Amendment</span>
						</html:link></li>
				</ul></li>

			<li><a href="#" class="parent"><span><img
						src="images/attendance.png" height="22" width="22" />Attendance</span></a>
				<ul>
					<li><html:link page="/GetDetails.do?parameter=todayAttendence"
							style="text-decoration:none">
							<span><img src="images/today.png" height="22" align="left"
								width="22" />Today's Attendance</span>
						</html:link></li>
					<%-- <li><html:link
							page="/GetDetails.do?parameter=modifyAttendence"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />Amendment</span>
						</html:link></li> --%>
				</ul></li>


			<li><a href="#" class="parent"><span><img
						src="images/shift.png" height="22" width="22" /> Master </span></a>
				<ul>
					<li><html:link page="/GetDetails.do?parameter=shift"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" width="22"
								align="left" />Shift Creation</span>
						</html:link></li>
					<li><html:link
							page="/departmentMaster.do?parameter=getDepRecords"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" width="22"
								align="left" />Add Department </span>
						</html:link></li>
					<li><html:link page="/holidayMaster.do?parameter=getDetails"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Holiday Master</span>
						</html:link></li>
				<%-- 	<li><html:link page="/groupMaster.do?method=getGroupDetails"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" width="22"
								align="left" />Add Group </span>
						</html:link></li> --%>
					<li><html:link
							page="/groupDepartment.do?method=getGroupDetails"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Group-Department Mapping</span>
						</html:link></li>
						<li><html:link page="/adddesignation.do?parameter=addDesignation"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Add Designation</span>
						</html:link></li>
						
					<%-- 	<li><html:link page="/GetDetails.do?parameter=getBreakupMasters"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Breakup Master</span>
						</html:link></li> --%>
						<li><html:link page="/location.do?parameter=addlocation"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Location</span>
						</html:link></li>
						<li><html:link page="/GetDetails.do?parameter=getUsers"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />User</span>
						</html:link></li>
						<li><html:link page="/GetDetails.do?parameter=getRoles"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Role</span>
						</html:link></li>
							<li><html:link page="/GetDetails.do?parameter=getUserRolePermission"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />User Role Permission</span>
						</html:link></li>
						
				</ul></li>
			<li><a href="#" class="parent"><span><img
						src="images/attendance.png" height="22" width="22" />Re-conciliation</span></a>
				<ul>
					<li><html:link
							page="/offreportreconcil.do?parameter=offshoreReportReconcil"
							style="text-decoration:none">
							<span>Report Re-conciliation</span>
						</html:link></li>
					<li><html:link
							page="/attendaceReconcil.do?parameter=attendanceReconcilation"
							style="text-decoration:none">
							<span>Attedndance ReConcilation</span>
						</html:link></li>
					<li><html:link
							page="/timesheetreport.do?parameter=timeSheetReport"
							style="text-decoration:none">
							<span>TimeSheet Report Audit</span>
						</html:link></li>
				</ul></li>
			<li><a href="#" class="parent"><span><img
						src="images/bio.jpg" height="22" width="22" />Bio Report</span></a>
				<ul>
					<li><a href="#" class="parent"><span>Attendance
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<b>--></b>
						</span></a>
						<ul>
							<li><html:link page="/GetInfo.do?parameter=dayreport"
									style="text-decoration:none">
									<span>Day Report</span>
								</html:link></li>
							<li><html:link page="/GetInfo.do?parameter=monthreport"
									style="text-decoration:none">
									<span>Month Report</span>
								</html:link></li>
							<li><html:link page="/GetInfo.do?parameter=overtimereport"
									style="text-decoration:none">
									<span>OverTime Report</span>
								</html:link></li>

						</ul></li>

					<li><html:link page="/GetDetails.do?parameter=todayReport"
							style="text-decoration:none">
							<span>Todays Report</span>
						</html:link></li>

					<li><html:link
							page="/monthlyReport.do?method=employeeMonthlyReport"
							style="text-decoration:none">
							<span>Monthly-Legend Report</span>
						</html:link></li>

					<li><html:link
							page="/employeeProductivityReport.do?parameter=getAllShiftsDepts"
							style="text-decoration:none">
							<span>Productivity Report</span>
						</html:link></li>
					<li><html:link
							page="/latecomers.do?parameter=getLateComersDetails"
							style="text-decoration:none">
							<span>Late Comers Report</span>
						</html:link></li>
					<li><html:link
							page="/earlytimereport.do?parameter=getLateComersDetails"
							style="text-decoration:none">
							<span>Early Goers Report</span>
						</html:link></li>
					<li><html:link
							page="/lessthen8hrs.do?parameter=getWorkingLessThan8hrsEmpDetails"
							style="text-decoration:none">
							<span>Working lessthan 8hrs</span>
						</html:link></li>
					<li><html:link
							page="/auditreport.do?parameter=getAllShiftsDepts"
							style="text-decoration:none">
							<span>Audit Report</span>
						</html:link></li>
					<li><html:link
							page="/auditreport.do?parameter=getAuditReconciliationReport"
							style="text-decoration:none">
							<span>Audit Reconciliation Report</span>
						</html:link></li>
					<li><html:link
							page="/groupmonthreport.do?parameter=groupMonthlyReport"
							style="text-decoration:none">
							<span>Group Month Report</span>
						</html:link></li>
				</ul></li>

			<li><html:link page="/GetDetails.do?parameter=changePassword"
					style="text-decoration:none">
					<span><img src="images/help.png" height="22" width="22" />
						Change Password</span>
				</html:link></li>
			<li><a href="http://www.centrisinfotech.com/"><span>Contact
						us</span></a>
						<ul>
							<li><html:link
							page="/GetDetails.do?parameter=sendMailToCustomerSupport"
							style="text-decoration:none">
							<span>Send Mail</span>
						</html:link></li>
						</ul>
						
						</li>

			<li class="last"><a href="/CENTRIS-HRMS/"><span><img
						src="images/exit.png" height="22" width="22" />Logout</span></a></li>


		</ul>
		
 		</c:if>
 		
 		<c:set var="user" value="Admin" />
	
	<c:if test="${ roleName== user}"> 
	
	<ul class="menu">
			<li><html:link page="/GetDetails.do?parameter=home"
					style="text-decoration:none">
					<span><img src="images/home.png" height="22" width="22" />Home</span>
				</html:link></li>

			<li><a href="#" class="parent"><span><img
						src="images/emplo.png" height="22" width="22" />Employee</span></a>
				<ul>
					<li><html:link page="/GetDetails.do?parameter=addEmployee"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" align="left"
								width="22" />Creation</span>
						</html:link></li>
					<li><html:link page="/GetDetails.do?parameter=modifyEmployee"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="20"
								align="left" width="20" />Amendment</span>
						</html:link></li>
					<li><html:link
							page="/GetDetails.do?parameter=removeSelectName"
							style="text-decoration:none">
							<span><img src="images/remove.png" height="22"
								align="left" width="22" />De-Activation</span>
						</html:link></li>
					<li><html:link page="/weekoff.do?parameter=showWeekOff"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Week Off settings</span>
					<li><html:link page="/uploadEmpXSL.do?parameter=uploadEmpXSL"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />Upload Employee File</span>
						</html:link></li>
						</html:link></li>
					<li><html:link page="/GetDetails.do?parameter=listofEmployee"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />All Employee</span>
						</html:link></li>
						<li><html:link page="/GetDetails.do?parameter=shiftAmendment"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />Shift Amendment</span>
						</html:link></li>
				</ul></li>

			<li><a href="#" class="parent"><span><img
						src="images/attendance.png" height="22" width="22" />Attendance</span></a>
				<ul>
					<li><html:link page="/GetDetails.do?parameter=todayAttendence"
							style="text-decoration:none">
							<span><img src="images/today.png" height="22" align="left"
								width="22" />Today's Attendance</span>
						</html:link></li>
					<%-- <li><html:link
							page="/GetDetails.do?parameter=modifyAttendence"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />Amendment</span>
						</html:link></li> --%>
				</ul></li>


			<li><a href="#" class="parent"><span><img
						src="images/shift.png" height="22" width="22" /> Master </span></a>
				<ul>
					<li><html:link page="/GetDetails.do?parameter=shift"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" width="22"
								align="left" />Shift Creation</span>
						</html:link></li>
					<li><html:link
							page="/departmentMaster.do?parameter=getDepRecords"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" width="22"
								align="left" />Add Department </span>
						</html:link></li>
					<li><html:link page="/holidayMaster.do?parameter=getDetails"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Holiday Master</span>
						</html:link></li>
					<%-- <li><html:link page="/groupMaster.do?method=getGroupDetails"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" width="22"
								align="left" />Add Group </span>
						</html:link></li> --%>
					<li><html:link
							page="/groupDepartment.do?method=getGroupDetails"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Group-Department Mapping</span>
						</html:link></li>
						<li><html:link page="/adddesignation.do?parameter=addDesignation"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Add Designation</span>
						</html:link></li>
						
					<%-- 	<li><html:link page="/GetDetails.do?parameter=getBreakupMasters"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Breakup Master</span>
						</html:link></li> --%>
						<li><html:link page="/location.do?parameter=addlocation"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Location</span>
						</html:link></li>
						<li><html:link page="/GetDetails.do?parameter=getUsers"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />User</span>
						</html:link></li>
						<li><html:link page="/GetDetails.do?parameter=getRoles"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Role</span>
						</html:link></li>
						
				</ul></li>
			<li><a href="#" class="parent"><span><img
						src="images/attendance.png" height="22" width="22" />Re-conciliation</span></a>
				<ul>
					<li><html:link
							page="/offreportreconcil.do?parameter=offshoreReportReconcil"
							style="text-decoration:none">
							<span>Report Re-conciliation</span>
						</html:link></li>
					<li><html:link
							page="/attendaceReconcil.do?parameter=attendanceReconcilation"
							style="text-decoration:none">
							<span>Attedndance ReConcilation</span>
						</html:link></li>
					<li><html:link
							page="/timesheetreport.do?parameter=timeSheetReport"
							style="text-decoration:none">
							<span>TimeSheet Report Audit</span>
						</html:link></li>
				</ul></li>
			<li><a href="#" class="parent"><span><img
						src="images/bio.jpg" height="22" width="22" />Bio Report</span></a>
				<ul>
					<li><a href="#" class="parent"><span>Attendance
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<b>--></b>
						</span></a>
						<ul>
							<li><html:link page="/GetInfo.do?parameter=dayreport"
									style="text-decoration:none">
									<span>Day Report</span>
								</html:link></li>
							<li><html:link page="/GetInfo.do?parameter=monthreport"
									style="text-decoration:none">
									<span>Month Report</span>
								</html:link></li>
							<li><html:link page="/GetInfo.do?parameter=overtimereport"
									style="text-decoration:none">
									<span>OverTime Report</span>
								</html:link></li>

						</ul></li>

					<li><html:link page="/GetDetails.do?parameter=todayReport"
							style="text-decoration:none">
							<span>Todays Report</span>
						</html:link></li>

					<li><html:link
							page="/monthlyReport.do?method=employeeMonthlyReport"
							style="text-decoration:none">
							<span>Monthly-Legend Report</span>
						</html:link></li>

					<li><html:link
							page="/employeeProductivityReport.do?parameter=getAllShiftsDepts"
							style="text-decoration:none">
							<span>Productivity Report</span>
						</html:link></li>
					<li><html:link
							page="/latecomers.do?parameter=getLateComersDetails"
							style="text-decoration:none">
							<span>Late Comers Report</span>
						</html:link></li>
					<li><html:link
							page="/earlytimereport.do?parameter=getLateComersDetails"
							style="text-decoration:none">
							<span>Early Goers Report</span>
						</html:link></li>
					<li><html:link
							page="/lessthen8hrs.do?parameter=getWorkingLessThan8hrsEmpDetails"
							style="text-decoration:none">
							<span>Working lessthan 8hrs</span>
						</html:link></li>
					<li><html:link
							page="/auditreport.do?parameter=getAllShiftsDepts"
							style="text-decoration:none">
							<span>Audit Report</span>
						</html:link></li>
					<li><html:link
							page="/auditreport.do?parameter=getAuditReconciliationReport"
							style="text-decoration:none">
							<span>Audit Reconciliation Report</span>
						</html:link></li>
					<li><html:link
							page="/groupmonthreport.do?parameter=groupMonthlyReport"
							style="text-decoration:none">
							<span>Group Month Report</span>
						</html:link></li>
				</ul></li>

			<li><html:link page="/GetDetails.do?parameter=changePassword"
					style="text-decoration:none">
					<span><img src="images/help.png" height="22" width="22" />
						Change Password</span>
				</html:link></li>
				<li><a href="http://www.centrisinfotech.com/"><span>Contact
						us</span></a>
						<ul>
							<li><html:link
							page="/GetDetails.do?parameter=sendMailToCustomerSupport"
							style="text-decoration:none">
							<span>Send Mail</span>
						</html:link></li>
						</ul>
						
						</li>
			<li class="last"><a href="/CENTRIS-HRMS/"><span><img
						src="images/exit.png" height="22" width="22" />Logout</span></a></li>


		</ul>
	
	
 	</c:if>	
 	
 	<c:set var="user" value="HR-1" />
	
	<c:if test="${ roleName== user}"> 
	
	<ul class="menu">
			<li><html:link page="/GetDetails.do?parameter=home"
					style="text-decoration:none">
					<span><img src="images/home.png" height="22" width="22" />Home</span>
				</html:link></li>

			<li><a href="#" class="parent"><span><img
						src="images/emplo.png" height="22" width="22" />Employee</span></a>
				<ul>
					<li><html:link page="/GetDetails.do?parameter=addEmployee"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" align="left"
								width="22" />Creation</span>
						</html:link></li>
					<li><html:link page="/GetDetails.do?parameter=modifyEmployee"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="20"
								align="left" width="20" />Amendment</span>
						</html:link></li>
					<li><html:link
							page="/GetDetails.do?parameter=removeSelectName"
							style="text-decoration:none">
							<span><img src="images/remove.png" height="22"
								align="left" width="22" />De-Activation</span>
						</html:link></li>
					<li><html:link page="/weekoff.do?parameter=showWeekOff"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Week Off settings</span>
					<%-- <li><html:link page="/uploadEmpXSL.do?parameter=uploadEmpXSL"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />Upload Employee File</span>
						</html:link></li> --%>
						</html:link></li>
					<li><html:link page="/GetDetails.do?parameter=listofEmployee"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />All Employee</span>
						</html:link></li>
						<li><html:link page="/GetDetails.do?parameter=shiftAmendment"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />Shift Amendment</span>
						</html:link></li>
				</ul></li>

			<li><a href="#" class="parent"><span><img
						src="images/attendance.png" height="22" width="22" />Attendance</span></a>
				<ul>
					<li><html:link page="/GetDetails.do?parameter=todayAttendence"
							style="text-decoration:none">
							<span><img src="images/today.png" height="22" align="left"
								width="22" />Today's Attendance</span>
						</html:link></li>
					<%-- <li><html:link
							page="/GetDetails.do?parameter=modifyAttendence"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />Amendment</span>
						</html:link></li> --%>
				</ul></li>


			<li><a href="#" class="parent"><span><img
						src="images/shift.png" height="22" width="22" /> Master </span></a>
				<ul>
					<li><html:link page="/GetDetails.do?parameter=shift"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" width="22"
								align="left" />Shift Creation</span>
						</html:link></li>
					<li><html:link
							page="/departmentMaster.do?parameter=getDepRecords"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" width="22"
								align="left" />Add Department </span>
						</html:link></li>
					<li><html:link page="/holidayMaster.do?parameter=getDetails"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Holiday Master</span>
						</html:link></li>
					<%-- <li><html:link page="/groupMaster.do?method=getGroupDetails"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" width="22"
								align="left" />Add Group </span>
						</html:link></li>
					<li><html:link
							page="/groupDepartment.do?method=getGroupDetails"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Group-Department Mapping</span>
						</html:link></li> --%>
						<li><html:link page="/adddesignation.do?parameter=addDesignation"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Add Designation</span>
						</html:link></li>
						
						<%-- <li><html:link page="/GetDetails.do?parameter=getBreakupMasters"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Breakup Master</span>
						</html:link></li>
						<li><html:link page="/location.do?parameter=addlocation"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Location</span>
						</html:link></li>
						<li><html:link page="/GetDetails.do?parameter=getUsers"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />User</span>
						</html:link></li>
						<li><html:link page="/GetDetails.do?parameter=getRoles"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Role</span>
						</html:link></li> --%>
						
				</ul></li>
			<li><a href="#" class="parent"><span><img
						src="images/attendance.png" height="22" width="22" />Re-conciliation</span></a>
				<ul>
					<li><html:link
							page="/offreportreconcil.do?parameter=offshoreReportReconcil"
							style="text-decoration:none">
							<span>Report Re-conciliation</span>
						</html:link></li>
					<li><html:link
							page="/attendaceReconcil.do?parameter=attendanceReconcilation"
							style="text-decoration:none">
							<span>Attedndance ReConcilation</span>
						</html:link></li>
					<li><html:link
							page="/timesheetreport.do?parameter=timeSheetReport"
							style="text-decoration:none">
							<span>TimeSheet Report Audit</span>
						</html:link></li>
				</ul></li>
			<li><a href="#" class="parent"><span><img
						src="images/bio.jpg" height="22" width="22" />Bio Report</span></a>
				<ul>
					<li><a href="#" class="parent"><span>Attendance
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<b>--></b>
						</span></a>
						<ul>
							<li><html:link page="/GetInfo.do?parameter=dayreport"
									style="text-decoration:none">
									<span>Day Report</span>
								</html:link></li>
							<li><html:link page="/GetInfo.do?parameter=monthreport"
									style="text-decoration:none">
									<span>Month Report</span>
								</html:link></li>
							<li><html:link page="/GetInfo.do?parameter=overtimereport"
									style="text-decoration:none">
									<span>OverTime Report</span>
								</html:link></li>

						</ul></li>

					<li><html:link page="/GetDetails.do?parameter=todayReport"
							style="text-decoration:none">
							<span>Todays Report</span>
						</html:link></li>

					<li><html:link
							page="/monthlyReport.do?method=employeeMonthlyReport"
							style="text-decoration:none">
							<span>Monthly-Legend Report</span>
						</html:link></li>

					<li><html:link
							page="/employeeProductivityReport.do?parameter=getAllShiftsDepts"
							style="text-decoration:none">
							<span>Productivity Report</span>
						</html:link></li>
					<li><html:link
							page="/latecomers.do?parameter=getLateComersDetails"
							style="text-decoration:none">
							<span>Late Comers Report</span>
						</html:link></li>
					<li><html:link
							page="/earlytimereport.do?parameter=getLateComersDetails"
							style="text-decoration:none">
							<span>Early Goers Report</span>
						</html:link></li>
					<li><html:link
							page="/lessthen8hrs.do?parameter=getWorkingLessThan8hrsEmpDetails"
							style="text-decoration:none">
							<span>Working lessthan 8hrs</span>
						</html:link></li>
					<li><html:link
							page="/auditreport.do?parameter=getAllShiftsDepts"
							style="text-decoration:none">
							<span>Audit Report</span>
						</html:link></li>
					<li><html:link
							page="/auditreport.do?parameter=getAuditReconciliationReport"
							style="text-decoration:none">
							<span>Audit Reconciliation Report</span>
						</html:link></li>
					<li><html:link
							page="/groupmonthreport.do?parameter=groupMonthlyReport"
							style="text-decoration:none">
							<span>Group Month Report</span>
						</html:link></li>
				</ul></li>

			<li><html:link page="/GetDetails.do?parameter=changePassword"
					style="text-decoration:none">
					<span><img src="images/help.png" height="22" width="22" />
						Change Password</span>
				</html:link></li>
			<li><a href="http://www.centrisinfotech.com/"><span>Contact
						us</span></a>
						<ul>
							<li><html:link
							page="/GetDetails.do?parameter=sendMailToCustomerSupport"
							style="text-decoration:none">
							<span>Send Mail</span>
						</html:link></li>
						</ul>
						
						</li>

			<li class="last"><a href="/CENTRIS-HRMS/"><span><img
						src="images/exit.png" height="22" width="22" />Logout</span></a></li>


		</ul>
	
	
	
 	</c:if>	
 	
 	
 	<c:set var="user" value="HR-2" />
	
	<c:if test="${ roleName== user}"> 
	
	<ul class="menu">
			<li><html:link page="/GetDetails.do?parameter=home"
					style="text-decoration:none">
					<span><img src="images/home.png" height="22" width="22" />Home</span>
				</html:link></li>

			<li><a href="#" class="parent"><span><img
						src="images/emplo.png" height="22" width="22" />Employee</span></a>
				<ul>
					<li><html:link page="/GetDetails.do?parameter=addEmployee"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" align="left"
								width="22" />Creation</span>
						</html:link></li>
					<li><html:link page="/GetDetails.do?parameter=modifyEmployee"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="20"
								align="left" width="20" />Amendment</span>
						</html:link></li>
					<%-- <li><html:link
							page="/GetDetails.do?parameter=removeSelectName"
							style="text-decoration:none">
							<span><img src="images/remove.png" height="22"
								align="left" width="22" />De-Activation</span>
						</html:link></li>
					<li><html:link page="/weekoff.do?parameter=showWeekOff"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Week Off settings</span>
					<li><html:link page="/uploadEmpXSL.do?parameter=uploadEmpXSL"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />Upload Employee File</span>
						</html:link></li>
						</html:link></li> --%>
					<li><html:link page="/GetDetails.do?parameter=listofEmployee"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />All Employee</span>
						</html:link></li>
						<li><html:link page="/GetDetails.do?parameter=shiftAmendment"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />Shift Amendment</span>
						</html:link></li>
				</ul></li>

			<li><a href="#" class="parent"><span><img
						src="images/attendance.png" height="22" width="22" />Attendance</span></a>
				<ul>
					<li><html:link page="/GetDetails.do?parameter=todayAttendence"
							style="text-decoration:none">
							<span><img src="images/today.png" height="22" align="left"
								width="22" />Today's Attendance</span>
						</html:link></li>
					<%-- <li><html:link
							page="/GetDetails.do?parameter=modifyAttendence"
							style="text-decoration:none">
							<span><img src="images/modify.png" height="22"
								align="left" width="22" />Amendment</span>
						</html:link></li> --%>
				</ul></li>


			<li><a href="#" class="parent"><span><img
						src="images/shift.png" height="22" width="22" /> Master </span></a>
				<ul>
					<li><html:link page="/GetDetails.do?parameter=shift"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" width="22"
								align="left" />Shift Creation</span>
						</html:link></li>
					<li><html:link
							page="/departmentMaster.do?parameter=getDepRecords"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" width="22"
								align="left" />Add Department </span>
						</html:link></li>
					<li><html:link page="/holidayMaster.do?parameter=getDetails"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Holiday Master</span>
						</html:link></li>
					<%-- <li><html:link page="/groupMaster.do?method=getGroupDetails"
							style="text-decoration:none">
							<span><img src="images/add.png" height="22" width="22"
								align="left" />Add Group </span>
						</html:link></li>
					<li><html:link
							page="/groupDepartment.do?method=getGroupDetails"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Group-Department Mapping</span>
						</html:link></li> --%>
						<li><html:link page="/adddesignation.do?parameter=addDesignation"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Add Designation</span>
						</html:link></li>
						
						<%-- <li><html:link page="/GetDetails.do?parameter=getBreakupMasters"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Breakup Master</span>
						</html:link></li>
						<li><html:link page="/location.do?parameter=addlocation"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Location</span>
						</html:link></li>
						<li><html:link page="/GetDetails.do?parameter=getUsers"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />User</span>
						</html:link></li>
						<li><html:link page="/GetDetails.do?parameter=getRoles"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Role</span>
						</html:link></li> --%>
						
				</ul></li>
			<%-- <li><a href="#" class="parent"><span><img
						src="images/attendance.png" height="22" width="22" />Re-conciliation</span></a>
				<ul>
					<li><html:link
							page="/offreportreconcil.do?parameter=offshoreReportReconcil"
							style="text-decoration:none">
							<span>Report Re-conciliation</span>
						</html:link></li>
					<li><html:link
							page="/attendaceReconcil.do?parameter=attendanceReconcilation"
							style="text-decoration:none">
							<span>Attedndance ReConcilation</span>
						</html:link></li>
					<li><html:link
							page="/timesheetreport.do?parameter=timeSheetReport"
							style="text-decoration:none">
							<span>TimeSheet Report Audit</span>
						</html:link></li>
				</ul></li> --%>
			<li><a href="#" class="parent"><span><img
						src="images/bio.jpg" height="22" width="22" />Bio Report</span></a>
				<ul>
					<li><a href="#" class="parent"><span>Attendance
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<b>--></b>
						</span></a>
						<ul>
							<li><html:link page="/GetInfo.do?parameter=dayreport"
									style="text-decoration:none">
									<span>Day Report</span>
								</html:link></li>
							<li><html:link page="/GetInfo.do?parameter=monthreport"
									style="text-decoration:none">
									<span>Month Report</span>
								</html:link></li>
							<li><html:link page="/GetInfo.do?parameter=overtimereport"
									style="text-decoration:none">
									<span>OverTime Report</span>
								</html:link></li>

						</ul></li>

					<li><html:link page="/GetDetails.do?parameter=todayReport"
							style="text-decoration:none">
							<span>Todays Report</span>
						</html:link></li>

					<li><html:link
							page="/monthlyReport.do?method=employeeMonthlyReport"
							style="text-decoration:none">
							<span>Monthly-Legend Report</span>
						</html:link></li>

					<li><html:link
							page="/employeeProductivityReport.do?parameter=getAllShiftsDepts"
							style="text-decoration:none">
							<span>Productivity Report</span>
						</html:link></li>
					<li><html:link
							page="/latecomers.do?parameter=getLateComersDetails"
							style="text-decoration:none">
							<span>Late Comers Report</span>
						</html:link></li>
					<li><html:link
							page="/earlytimereport.do?parameter=getLateComersDetails"
							style="text-decoration:none">
							<span>Early Goers Report</span>
						</html:link></li>
					<li><html:link
							page="/lessthen8hrs.do?parameter=getWorkingLessThan8hrsEmpDetails"
							style="text-decoration:none">
							<span>Working lessthan 8hrs</span>
						</html:link></li>
				<%-- 	<li><html:link
							page="/auditreport.do?parameter=getAllShiftsDepts"
							style="text-decoration:none">
							<span>Audit Report</span>
						</html:link></li> --%>
				<%-- 	<li><html:link
							page="/auditreport.do?parameter=getAuditReconciliationReport"
							style="text-decoration:none">
							<span>Audit Reconciliation Report</span>
						</html:link></li> --%>
					<li><html:link
							page="/groupmonthreport.do?parameter=groupMonthlyReport"
							style="text-decoration:none">
							<span>Group Month Report</span>
						</html:link></li>
				</ul></li>

			<li><html:link page="/GetDetails.do?parameter=changePassword"
					style="text-decoration:none">
					<span><img src="images/help.png" height="22" width="22" />
						Change Password</span>
				</html:link></li>
				<li><a href="http://www.centrisinfotech.com/"><span>Contact
						us</span></a>
						<ul>
							<li><html:link
							page="/GetDetails.do?parameter=sendMailToCustomerSupport"
							style="text-decoration:none">
							<span>Send Mail</span>
						</html:link></li>
						</ul>
						
						</li>

			<li class="last"><a href="/CENTRIS-HRMS/"><span><img
						src="images/exit.png" height="22" width="22" />Logout</span></a></li>


		</ul>
	
 	</c:if>	
 		
 		
 		
 		
 		
</logic:present>
	</div>

</body>
</html>