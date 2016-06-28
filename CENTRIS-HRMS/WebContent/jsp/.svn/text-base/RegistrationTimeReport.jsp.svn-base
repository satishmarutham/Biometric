<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Registration Details Report</title>
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
<script language="javascript" src="js/RegistrationTime.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
</head>
<body>
	<br />
	<div class="background" id="backgroung">
		<center>
			<div class="backgroundDiv" id="backgroung" style="width: 100%">Latest
				Registration Report</div>
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
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="group"/> </logic:present>' />
		<input id="hlocationId" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="location"/> </logic:present>' />
		<input id="hmonth" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="month"/> </logic:present>' />
		<input id="hyear" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="year"/> </logic:present>' />

		<form action=" " id="getRegistrationDetails" name="monthReport"
			method="post">
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
					<td align="left" class="trd">Select Location<font color="red">*</font><br />
						<select multiple="multiple" id="locationId" name="location">

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
					<td><input type="button" value="Get Registration Details"
						class="submitbutton" id="RegistrationDetails"
						onclick="return validations()" /></td>

				</tr>
			</table>



		</form>

		<div class="tablecss" style="margin: 15px; text-align: center"
			id="tableId">

			<logic:present name="validMessage" scope="request">
				<span style="font-weight: bold;"><bean:write
						name="validMessage" property="message" /></span>
			</logic:present>

			<logic:present name="registrationDetails" scope="request">
				<display:table name="requestScope.registrationDetails"
					requestURI="/getRegistrationReportDetails.do?parameter=getRegistrationDetails"
					pagesize="20" export="false" class="tablecss">
					<display:column property="sno" sortable="false" title="Sl no" />
					<display:column property="employeeId" sortable="false"
						title="Employee ID" />
					<display:column property="employeeName" sortable="false"
						title="Employee Name" />
					<display:column property="employeeLocation" sortable="false"
						title="Location" />
					<display:column property="employeeDesignation" sortable="false"
						title="Designation" />
					<display:column property="createdBy" sortable="false"
						title="Registered By" />
					<display:column property="employeeCreatedDate" sortable="false"
						title="Registration Time" />

				</display:table>


				<br />
				<input type="button" value="Download"
					id="downloadRegistrationDetails" class="submitbutton" />
			</logic:present>


		</div>
	</div>
</body>
</html>