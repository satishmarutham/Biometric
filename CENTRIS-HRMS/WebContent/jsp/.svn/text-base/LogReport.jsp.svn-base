<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Log Report</title>
<link rel="stylesheet" type="text/css"
	href="JQUERY/css/smoothness/jquery-ui-1.9.2.custom.css" />
<link rel="stylesheet" type="text/css" href="css/common.css" />
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>

<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script language="javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/LogReport.js"></script>
</head>
<style type="text/css">
.displayTableFrame {
	background-color: white;
	overflow-x: hidden;
	height: 350px;
	width: 100%;
}

.view {
	text-decoration: none;
	border: 1px solid #bbb;
	width: 100%;
}

.view th {
	padding: 1px 2px 1px 2px !important;
	text-align: center;
	border-spacing: 0px;
}

.view td {
	padding: 1px 2px 1px 2px !important;
}

.view thead tr {
	position: relative;
	height: 15px;
	background-color: #C8C8C8;
	color: black;
	font-weight: bold;
}

.view tbody {
	height: 240px;
	overflow-x: hidden;
}

.view tbody tr {
	width: inherit;
	height: auto;
	white-space: nowrap;
	height: auto;
}

.view tbody tr.odd {
	background-color: #eee
}

.view tbody tr.tableRowEven,tr.even {
	background-color: #ddd
}

.view tbody tr td:last-child {
	padding-right: 1px;
}

.view tbody td {
	padding: 1px 2px 1px 2px !important;
}

.view .order1 {
	background-position: right 50%;
	background-repeat: no-repeat
}

.view .order2 {
	background-position: right 50%;
	background-repeat: no-repeat
}
</style>
<body>
	<div class="background" id="backgroung">
		<center>
			<div class="backgroundDiv" id="backgroung" style="width: 100%">Log
				Report</div>
			<div id="errordiv" class="error-box">
				<logic:present name="message" scope="session">
					<span style="color: green; font-family: Segoe UI;"> <bean:write
							name="message" />
					</span>
				</logic:present>
			</div>
		</center>
		<br />
		<html:form action="/logReport" method="post"
			onsubmit="return validateLog();">
			<input type="hidden" name="method" value="getLogReport" />
			<input id="hdeptId" type="hidden"
				value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="department"/> </logic:present>' />
			<input id="hmanagerId" type="hidden"
				value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="manager"/> </logic:present>' />
			<input id="hemployeeId" type="hidden"
				value='<logic:present name="empId" scope="request"><bean:write name="empId"/> </logic:present>' />
			<input id="hstartDate" type="hidden"
				value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="startDate"/> </logic:present>' />
			<input id="hendDate" type="hidden"
				value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="endDate"/> </logic:present>' />
<center>
				<table cellpadding="8" cellspacing="5" id="biometric" >
				<tr>
				<tr class="trc">

						<td class="left" >Department<font color="red">*</font>
				
				       <input type="checkbox" id="departmentcheckbox" name="departmentcheckbox" value="all" onclick="selectAllDepartments()">select all</input><br />	
							
							<select name="department" id="department" multiple="multiple" style="width: 100%;">
								<logic:present name="DEPARTMENT_LIST" scope="request">
								
								<logic:iterate id="department" name="DEPARTMENT_LIST">
								
								<option value='<bean:write name="department" property="depId"  />'><bean:write name="department" property="depName"/></option>
								
								
								</logic:iterate>
								
								</logic:present>
							</select>
							
						</td>
						
						
						<td class="left">Manager<font color="red">*</font>
						<input type="checkbox" id="managercheckbox" name="managercheckbox" value="all" onclick="selectAllManagers()">select all</input><br />
							
							<select name="manager" id="manager" multiple="multiple" style="width: 100%;">
								
								<option></option>
							</select>
							
						</td> 
						
						
						<!-- 
						   	<td align="left" class="trd">Project<font color="red">*</font>
							<input type="checkbox" id="projectcheckbox" name="projectcheckbox" value="all" onclick="selectAllProjects()">select all</input><br />
						<select name="project" id="project" multiple="multiple" >
								
							</select>
							
						</td> -->
						
							<td class="left">Employee<font color="red">*</font>
				
				        <input type="checkbox" id="employeecheckbox" name="employeecheckbox" value="all" onclick="selectAllEmployees()">select all</input><br />	
							
							<select name="employee" id="employee" multiple="multiple"  style="width: 100%;">
							</select>
							
						</td>
					<td class="left">Start Date<br /> <input type="text" id="sDate"
						name="startDate" readonly="readonly" placeholder="Click here"
						value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="startDate" /> </logic:present>' />
					</td>
					<td class="left">End Date<br /> <input type="text" id="eDate"
						name="endDate" readonly="readonly" placeholder="Click here"
						value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="endDate" /> </logic:present>' />
					</td>
				</tr>

			</table>
				</center>

			<br>
			<table align="center">
				<tr>
					<td colspan="4" align="center"><html:submit
							value="View Report" styleClass="submitbutton" /></td>
				</tr>
			</table>
		</html:form>
		<div id="logDetails" class="tablecss"
			style="margin: 15px; text-align: center;">

			<logic:present name="logList" scope="request">
			<div class='displayTableFrame'>
				<display:table export="false"
					style="font-family: Segoe UI;width:85%;margin:0 auto;"
					name="requestScope.logList"
					decorator="com.centris.decorator.LogReportDecorator"
					requestURI="/logReport.do?method=getLogReport" >
					<display:column property="sNo" title="Sl No."
						style="text-align:center;" sortable="false" />
					<display:column property="empId" title="Employee ID"
						style="text-align:center;" sortable="false" />
					<display:column property="empName" title="Employee Name"
						style="text-align:left;" sortable="false" />
					<display:column property="logDate" title="Date (DD-MM-YYYY)"
						style="text-align:center;" sortable="false" />
				<%-- 	<display:column property="location" title="Location"
						style="text-align:center;" sortable="false" /> --%>
					<display:column property="status" title="Status"
						style="text-align:center;" sortable="false" decorator="com.centris.decorator.DayReportDecorator" />
					<display:column property="inTime" title="In-time"
						style="text-align:center;" sortable="false" />
					<display:column property="outTime" title="Out-time"
						style="text-align:center;" sortable="false" />
					
				</display:table>
				<div style="text-align: center; width: 100%;">
					<input type="button" id="downloadLog" value="Download Log Report"
						class="submitbutton" />
					
				</div>
				</div>
			</logic:present>
		</div>

	</div>

</body>
</html>