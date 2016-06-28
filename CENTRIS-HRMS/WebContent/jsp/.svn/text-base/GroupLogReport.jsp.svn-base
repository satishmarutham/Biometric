<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Group Log Report</title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.menu.js"></script>
<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect-blind.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script language="javascript" src="js/common.js"></script>
<script language="javascript" src="js/GroupLogReport.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
</head>
<body>
	<br />
	<div class="background" id="backgroung">
		<center>
			<div class="backgroundDiv" id="backgroung" style="width: 100%">Group
				Log Report</div>
			<br />
			<div id="errordiv" class="error-box">
				<logic:present name="message" scope="session">
					<span style="color: green; font-family: Segoe UI;"> <bean:write
							name="message" />
					</span>
				</logic:present>
			</div>
		</center>
		<input id="hgroupId" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="groupName"/> </logic:present>' />
		<input id="hlocationId" type="hidden"
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
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="designation"/> </logic:present>' />

		<form action=" " id="MonthReport" name="monthReport" method="post">
			<input type="hidden" name="parameter" id="methodNameId" />
			<table id="biometric" align="center">
				<tr>
				<tr class="trc">
					<td align="left" class="trd">Select Group<font color="red">*</font><br />
						<select name="group" id="groupId">
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
					<!-- <td align="left" class="trd">Select Location<font color="red">*</font><br />
						<select name="location" id="locationId">
							<option value="">---Select Option---</option>
					</select>
					</td> -->
					<td align="left" class="trd">Select Location<font color="red">*</font><br />
							<select  id="locationId" multiple="multiple"></select>
					</td>
					<td align="left" class="trd">Select Designation<font
						color="red">*</font><br /> <select name="designation"
						id="designationId">
							<option value="">---Select Option---</option>
					</select>
					</td>
					<td align="left" class="trd">Select Employee<font color="red">*</font><br />
						<select id="employeeId" name="employee">
							<option value="">---Select Option---</option>
					</select>
					</td>
					<td>Month<font color="red">*</font><br /> <select id="month"
						name="month">
							<option value="">---Select Option---</option>
							<option value="01">January</option>
							<option value="02">February</option>
							<option value="03">March</option>
							<option value="04">April</option>
							<option value="05">May</option>
							<option value="06">June</option>
							<option value="07">July</option>
							<option value="08">August</option>
							<option value="09">September</option>
							<option value="10">October</option>
							<option value="11">November</option>
							<option value="12">December</option>

					</select>
					</td>
					<td>Year<font color="red">*</font><br /> <select id="year"
						name="year">
							<option value="">---Select Option---</option>
							<option value="2013">2013</option>
							<option value="2014">2014</option>
							<option value="2015">2015</option>
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
					</select>
					</td>
				</tr>

			</table>
			<br>
			<table align="center">
				<tr>
					<td><input type="button" value="View Log Report"
						class="submitbutton" id="groupLogReportId"
						onclick="return validations()" /> <!-- <input type="button"
						value="Detailed Report" class="submitbutton" id="detailedId"
						onclick="return validations()" /> --></td>

				</tr>
			</table>



		</form>

		<div class="tablecss" style="margin: 15px; text-align: center"
			id="tableId">

			<logic:present name="groupLogReportList" scope="request">
				<logic:iterate id="calMap" name="groupLogReportList" scope="request">
					<logic:notEqual value="" name="calMap" property="key">
						<h3 class="accordHead" id="accordionCss"> <bean:write
								name="calMap" property="key" />
						</h3>
						<div class="accBody">
							<table width="85%" class="tablecss">
								<tr>
									<th>Date</th>
									<th>Total Employees</th>
									<th>Total Present</th>
									<th>Total Absent</th>
									<th></th>
								</tr>
								<logic:notEmpty name="calMap" property="value">
									<logic:iterate name="calMap" property="value" id="dateVO">
										<%-- <span class="accordHead" id="accordionCss"> <bean:write
										name="dateVO" property="key" />
								</span> --%>

										<logic:iterate name="dateVO" property="value" id="datalist">


											<tr class="accordHead">
												<td class="reportDate"><bean:write name="dateVO"
														property="key" /></td>
												<td><bean:write name="datalist"
														property="report_TotalEmployee" /></td>
												<td><bean:write name="datalist"
														property="report_TotalPresent" /></td>
												<td><bean:write name="datalist"
														property="report_TotalAbsent" /></td>

												<td class="clickButton"><input type="button"
													value="View"
													id="<bean:write
										name="calMap" property="key" />"
													class="submitbutton"></td>
												<input type="hidden" class="locCode"
													value="<bean:write name="datalist" property="report_LocationCode" />">
											</tr>
										</logic:iterate>
									</logic:iterate>
								</logic:notEmpty>

							</table>
						</div>
					</logic:notEqual>
				</logic:iterate>

			</logic:present>
		</div>
	</div>
</body>
</html>