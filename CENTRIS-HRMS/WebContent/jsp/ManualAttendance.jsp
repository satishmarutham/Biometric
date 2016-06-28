<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Employee Attendance</title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect-blind.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<script language="javascript" src="js/ManualAttendance.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
</head>
<br />
<body>
	<div class="background" id="backgroung">
		<center>
			<div class="backgroundDiv" id="backgroung" style="width: 100%">Manual
				Attendance</div>
			<br />
			<div id="errordiv" class="error-box">
				<div id="successdiv" style="color: green;"></div>
			</div>
		</center>
		<input id="hgroupId" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="group"/> </logic:present>' />
		<input id="hlocationId" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="location"/> </logic:present>' />
		<input id="hemployeeId" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="employee"/> </logic:present>' />
		<input id="hrepDate" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="reportDate"/> </logic:present>' />

		<form action="manualAttendance.do" method="post">
			<input type="hidden" name="parameter" value="getAttendanceDetails" />
			<table id="biometric" align="center">
				<tr>
				<tr class="trc">
					<td align="left" class="trd">Select Group<br /> <select
						name="group" id="groupId">
							<option value="">---Select Option---</option>
							<logic:present name="groupDetails" scope="session">
								<logic:iterate id="groupDetailId" name="groupDetails"
									scope="session">
									<option
										value="<bean:write name="groupDetailId" property="groupId"/>">
										<bean:write name="groupDetailId" property="groupName" />
									</option>
								</logic:iterate>
							</logic:present>

					</select>
					</td>
					<td align="left" class="trd">Select Location<br /> <select
						name="location" id="locationId">
							<option value="">---Select Option---</option>
					</select>
					</td>
					<td align="left" class="trd">Select Employee<br /> <select
						id="employeeId" name="employee">
							<option value="">---Select Option---</option>
					</select>
					</td>
					<td align="left" class="trd">Date<font color="red">*</font><br />
						<input type="text" id="reportDate" name="reportDate"
						readonly="readonly" placeholder="Click here" />
					</td>
				</tr>

			</table>
			<br>
			<table align="center">
				<tr>
					<td><input type="submit" value="Get Attendance"
						class="submitbutton" id="attendanceId"
						onclick="return validations()" />
				</tr>
			</table>
		</form>

		<div class="tablecss" style="margin: 15px; text-align: center"
			id="tableId">

			<logic:present name="validMessage" scope="request">
				<span style="font-weight: bold;"><bean:write
						name="validMessage" property="errMessage" /></span>
			</logic:present>
			<logic:present name="attendanceDetails" scope="request">
				<display:table export="false" id="defaulttable"
					style="font-family: Segoe UI;width:90%;margin:0 auto;"
					name="requestScope.attendanceDetails"
					requestURI="/manualAttendance.do?parameter=getAttendanceDetails"
					pagesize="20"
					decorator="com.centris.decorator.ManualAttendanceDecorator">
					<display:column property="sno" title="Sl No"
						style="text-align:center;width:100px;" sortable="false" />
					<display:column property="employeeId" title="Employee ID"
						class="empid" style="text-align:center;" sortable="false" />
					<display:column property="employeeName" title="Employee Name"
						style="text-align:center;" sortable="false" />
					<display:column property="employeeLocation" title="Location"
						style="text-align:center;" sortable="false" />
					<display:column property="employeeDesignation" title="Designation"
						style="text-align:center;" sortable="false" />
					<display:column property="attDate" title="Date (DD-MM-YYYY)"
						style="text-align:center;" sortable="false" />
					<%-- <display:column property="attStatus" title="Attendance Status"
						style="text-align:center;" sortable="false" /> --%>
					<display:column property="status" title="Attendance Status"
						style="text-align:center;" sortable="false" />
				</display:table>
				<br />
				<center>
					<input type="button" value="Update Attendance" class="submitbutton"
						id="updateAttendance" />
				</center>
			</logic:present>
		</div>

	</div>

</body>

</html>
