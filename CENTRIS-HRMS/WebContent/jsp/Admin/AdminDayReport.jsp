<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Admin Month Report</title>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/Admin/AdminDayReport.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

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
	<br />
	<div class="background" id="backgroung">

     <div class="backgroundDiv" id="backgroung">Day Report</div><br/>
					
		<form action="adminDayReport.do" name="AdminDayReportForm" method="post">

			<input type="hidden" value="getDayReport" name="method" />
			<center>


			<div id="errordiv" class="error-box" align="center">

				<%-- 	<logic:present name="message" scope="request">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="message" />
						</span>
					</logic:present> --%>
				</div>
			

<input type="hidden" id="hManager" value='<logic:present name="ReportFormData" scope="request"><bean:write name="ReportFormData" property="manager"/></logic:present>'/>


<input type="hidden" id="hDepartment" value='<logic:present name="ReportFormData" scope="request"><bean:write name="ReportFormData" property="department"/></logic:present>'/>
<input type="hidden" id="hEmployee" value='<logic:present name="ReportFormData" scope="request"><bean:write name="ReportFormData" property="employee"/></logic:present>'/>
<input type="hidden" id="hstartDate" value='<logic:present name="ReportFormData" scope="request"><bean:write name="ReportFormData" property="startDate"/></logic:present>'/>
<input type="hidden" id="hendDate" value='<logic:present name="ReportFormData" scope="request"><bean:write name="ReportFormData" property="endDate"/></logic:present>'/>
			

    
				<table cellpadding="8" cellspacing="5" id="biometric" >

					<tr class="trc">
					
						<%-- <td align="left" class="trd">Manager<font color="red">*</font>
						<input type="checkbox" id="managercheckbox" name="managercheckbox" value="all" onclick="selectAllManagers()">select all</input><br />
							
							<select name="manager" id="manager" multiple="multiple">
								<logic:present name="MANAGER_LIST" scope="request">
								
								<logic:iterate id="manager" name="MANAGER_LIST">
								
								<option value='<bean:write name="manager" property="managerid"/>'><bean:write name="manager" property="firstname"/></option>
								
								
								</logic:iterate>
								
								</logic:present>
							</select>
							
						</td> --%>
						
						
					
						<%-- <td align="left" class="trd">Designation<font color="red">*</font>
							<input type="checkbox" id="designationcheckbox" name="designationcheckbox" value="all" onclick="selectAllDesignations()">select all</input><br />	
							<select name="designation" id="designation" multiple="multiple" >
								<logic:present name="DESIGNATION_LIST" scope="request">
								
								<logic:iterate id="designation" name="DESIGNATION_LIST">
								
								<option value='<bean:write name="designation" property="desgid"  />'><bean:write name="designation" property="desgname"/></option>
								
								
								</logic:iterate>
								
								</logic:present>
							</select>
							
						</td> --%>
						
						<td class="left">Department<font color="red">*</font>
				
				       <input type="checkbox" id="departmentcheckbox" name="departmentcheckbox" value="all" onclick="selectAllDepartments()">Select All</input><br />	
							
							<select name="department" id="department" multiple="multiple" style="width: 170px !important;">
								<logic:present name="DEPARTMENT_LIST" scope="session">
								
								<logic:iterate id="department" name="DEPARTMENT_LIST">
								
								<option value='<bean:write name="department" property="depId"  />'><bean:write name="department" property="depName"/></option>
								
								
								</logic:iterate>
								
								</logic:present>
							</select>
							
						</td>
						
						
						<td class="left">Manager<font color="red">*</font>
						<input type="checkbox" id="managercheckbox" name="managercheckbox" value="all" onclick="selectAllManagers()">Select All</input><br />
							
							<select name="manager" id="manager" multiple="multiple" style="width: 170px !important;">
								
								<option value=""></option>
							</select>
							
						</td> 
						
						
					
						
							<td class="left">Employee<font color="red">*</font>
				
				        <input type="checkbox" id="employeecheckbox" name="employeecheckbox" value="all" onclick="selectAllEmployees()">Select All</input><br />	
							
							<select name="employee" id="employee" multiple="multiple" style="width: 170px !important;">
							</select>
							</td>
					
							
							
							<td class="left">Start Date<font color="red">*</font><br />
								<input type="text" id="startdateId" name="startDate"
								readonly="readonly" placeholder="Click here" />
							</td>




							<td class="left">End Date<font color="red">*</font><br />
								<input type="text" id="enddateId" name="endDate"
								readonly="readonly" placeholder="Click here" />
							</td>
					</tr>

				</table>
				
				
				
				<br></br>


				<input type="submit" value="Submit" class="submitbutton" onclick="return validations();"/>


			</center>
			
			
			<center >

		<div  class="tablecss" style="width:90%;margin:40px;">
			<logic:present name="DayReportList" scope="request" >
			<div class='displayTableFrame'>
					<display:table id="data" name="requestScope.DayReportList"
						requestURI="adminDayReport.do?method=getDayReport"
						 cellpadding="5" cellspacing="5" size="20"
						style="bgcolor: RED;"	decorator="">
						
							<display:column property="sno" title="SNO" />
						<display:column property="empid" title="EmployeeBioId" />
						<display:column property="empname" title="EmployeeName"/>
						<display:column property="attendancedate" title="AttendanceDate" />
				    	<display:column property="status" title="Status"/>
				    	<display:column property="type" title="StatusType"/>
			           <display:column property="isposted" title="Is_Posted"/>
						<display:column property="isapproved" title="Is_Approved"/>
							
						
			</display:table>
			</div>
			<logic:notEmpty name="DayReportList" scope="request">
			<div style="margin: 10px;">
				<input type="button" value="Download PDF" id="pdf"  class="downloadDayReport submitbutton"/><input type="button" value="Download XLS" id="xls" class="downloadDayReport submitbutton"/>
			</div>
			</logic:notEmpty>
			
			</logic:present>
			</div>
			</center>

		
		
		
		</form>
		
		

	</div>

</body>



</html>
