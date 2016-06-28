<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Timesheet Reconciliation</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<link rel="shortcut icon" href="images/favicon.ico">
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
<script type="text/javascript"	src="JQUERY/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="js/Admin/TimesheetReconciliation.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link href="css/Home/bootstrap-combined.min.css" rel="stylesheet" type="text/css" />
<link href="css/Home/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
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
<br/>	
 	<div class="background" id="backgroung">
		
		<div class="backgroundDiv" id="backgroung">Timesheet Reconcilation</div>
				<center>
				<div id="errordiv" class="error-box" align="center" >
					<logic:present name="successMsg" scope="request">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="successMsg" scope="request" />
						</span>
					</logic:present>
					<logic:present name="failureMsg" scope="request">
						<span style="color: red; font-family: Segoe UI;"> <bean:write
								name="failureMsg" scope="request" />
						</span>
					</logic:present>
				</div></center>
		
	<center>
	 <form action="timesheetReconcil.do" method="post" >
	     	<input type="hidden" name="parameter" value="getTimesheetData"/>
		   <input type="hidden" id="mailMessage" value='<logic:present name="sendMessage" scope="request"> <bean:write name="sendMessage"/></logic:present>'/>
	 
    	<table  id="biometric" cellspacing="5" cellpadding="8">
           <tr class="trc">
                	<td class="left" >Department<font color="red">*</font>
							<input type="checkbox" name="deptcheckbox" id="deptcheckbox" value="all" onclick="selectAllDepartments()"/>select all</br>
							<select name="department" id="department" multiple="multiple" style="width: 100%;">
							<logic:present name="AllDepartments" scope="request">
							<logic:notEmpty name="AllDepartments" scope="request">
							<logic:iterate id="iterateid" name="AllDepartments" scope="request">
							<option value="<bean:write name="iterateid" property="deptid"></bean:write>"><bean:write name="iterateid" property="deptname"></bean:write>
							</option>
							</logic:iterate>
     						</logic:notEmpty>
							</logic:present>
							</select></br>
							
					</td>
					<td class="left" >Manager<font color="red">*</font>
							<input type="checkbox" name="mgrcheckbox" id="mgrcheckbox" value="all" onclick="selectAllManagers()" />select all</br>
							<select name="manager" id="manager" multiple="multiple" style="width: 100%;" >
								</select></br>
							
					</td>
				   
					<td class="left">Employee<font color="red">*</font>
							<input type="checkbox" name="empcheckbox" id="empcheckbox" value="all" onclick="selectAllEmployees()"/>select all</br>
							<select name="employee" id="employee" multiple="multiple" style="width: 100%;">
							</select>
					</td>
				
			       <td class="left"> Start Date<font color="red">*</font><br/>
			             <input type="text"  readonly="readonly" name="sdate" id="sdate" placeholder="Click Here" /></td>
			        <td class="left"> End Date<font color="red">*</font><br/>
			            <input type="text"  readonly="readonly" name="edate" id="edate" placeholder="Click Here"/>
		        	</td>
			 </tr>
			</table>



      	<table align="center">
			<tr>
				<td><input  type="submit"  value="Submit" class="submitbutton" onclick="return validation()"/></td>
			</tr>
		</table>
</form>
 </center>
 
 <input id="hempId" type="hidden" value='<logic:present name="hEmpId" scope="request"><bean:write name="hEmpId"/> </logic:present>' />
  <input id="hdepId" type="hidden" value='<logic:present name="hDepId" scope="request"><bean:write name="hDepId"/> </logic:present>' />
   <input id="hmgrId" type="hidden" value='<logic:present name="hMgrId" scope="request"><bean:write name="hMgrId"/> </logic:present>' />
    <input id="hstartDate" type="hidden" value='<logic:present name="hstartDate" scope="request"><bean:write name="hstartDate"/> </logic:present>' />
    <input id="hEndDate" type="hidden" value='<logic:present name="hEndDate" scope="request"><bean:write name="hEndDate"/> </logic:present>' />
 
		<%-- <input id="hlocationId" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="locationName"/> </logic:present>' />
		<input id="hshiftId" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="shiftName"/> </logic:present>' />
		<input id="hemployeeId" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="employeeName"/> </logic:present>' />
		<input id="hmonth" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="monthName"/> </logic:present>' />
		<input id="hyear" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="yearName"/> </logic:present>' />
		<input id="hdesignation" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="designation"/> </logic:present>' /> --%>
 
 
 
 
 <center>
	<div class='displayTableFrame'>
	<display:table export="false" id="depRecords" class="view" style="font-family: Segoe UI;width:95%;margin:0 auto;"  name="requestScope.timesheetData" decorator="com.centris.decorator.TimesheetReconciliationDecorator" requestURI="/timesheetReconcil.do?parameter=getTimesheetData" >
			<display:column property="attendancedate" title="Date"        style="text-align:center;" sortable="false"/>
			<display:column property="bioid"  title="Emp Id"    style="text-align:center;" sortable="false"/>
			<display:column property="empName"  title="Emp Name"    style="text-align:center;" sortable="false"/>
			<display:column property="inTime" title="In Time" style="text-align:center;" sortable="false"/>
			<display:column property="outTime"   title="Out Time"          style="text-align:center;" sortable="false"/>
			<display:column property="workingHours"     title="Working Hours"            style="text-align:center;" sortable="false"/>
			<display:column property="saveButton"     title=""            style="text-align:center;" sortable="false"/>
		
		</display:table>
		
	</div>
	</center>
	<br></br>
	</div>
<br/><br/><br/><br/><br/><br/>
	</body>
</html>