<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Month Report</title>
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
<script language="javascript" src="js/ConsolidateDetailedMonthReport.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
</head>
<body>
	<br />
	<div class="background" id="backgroung">
		<center>
			<div class="backgroundDiv" id="backgroung" style="width: 100%">Consolidated
				Report</div>
			<div id="errordiv" class="error-box">
				<logic:present name="message" scope="session">
					<span style="color: green; font-family: Segoe UI;"> <bean:write
							name="message" />
					</span>
				</logic:present>
			</div>
		</center>
		<br /> <input id="hgroupId" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="group"/> </logic:present>' />
		<input id="hlocationId" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="location"/> </logic:present>' />
		<input id="hdesignationId" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="designation"/> </logic:present>' />
		<input id="hemployeeId" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="employee"/> </logic:present>' />
		<input id="hmonth" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="month"/> </logic:present>' />
		<input id="hyear" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="year"/> </logic:present>' />

		<form action=" " id="MonthReport" name="monthReport" method="post">
			<input type="hidden" name="parameter" id="methodNameId" />
			<table id="biometric" align="center">
				<tr>
				<tr class="trc">
					<td align="left" class="trd">Select Group<font color="red">*</font><br/> <select
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
					<td align="left" class="trd">Select Location<font color="red">*</font><br/> <select multiple="multiple"
						 id="locationId">
							
					</select>
					</td>
					<td align="left" class="trd">Select Designation<font color="red">*</font><br/> <select
						name="designation" id="designationId">
							<option value="">---Select Option---</option>
					</select>
					</td>
					<td align="left" class="trd">Select Employee<font color="red">*</font><br/><select
						id="employeeId" name="employee">
							<option value="">---Select Option---</option>
					</select>
					</td>
					<td>Month<font color="red">*</font><br/><select id="month" name="month">
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
					<td>Year<font color="red">*</font><br/> <select id="year" name="year">
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
					<td><input type="button" value="Consolidated Report"
						class="submitbutton" id="consolidatedId"
						onclick="return validations()" /> <input type="button"
						value="Detailed Report" class="submitbutton" id="detailedId"
						onclick="return validations()" /></td>

				</tr>
			</table>



		</form>

	<!-- 	<div class="tablecss" style="margin: 15px; text-align: center"
			id="tableId"> -->

			<logic:present name="detailedMonthReportList" scope="request">
				<display:table name="requestScope.detailedMonthReportList"
					requestURI="/consolidateDetailedMonthReport.do?parameter=getDetailedMonthReport"
					pagesize="20" export="false" class="view" style="width:80%;" id="tableId">
						<display:column property="locationName" sortable="false" title="Location" />
						<display:column property="date" sortable="false" title="Date (DD-MM-YYYY)" />
						<display:column property="empid" sortable="false" title="Employee ID" />
						<display:column property="empname" sortable="false" title="Employee Name" />
						<display:column property="designationName" sortable="false" title="Designation" />
						<display:column property="attendenceStatus" sortable="false" title="Attendence Status" />
						<display:column property="inTime" sortable="false" title="In-Time" />
						<display:column property="outTime" sortable="false" title="Out-Time" />
						<display:column property="lateTime" sortable="false" title="Late-Hours" />
						<display:column property="earlyTime" sortable="false" title="Early-Hours" />
						<display:column property="totalHours" sortable="false" title="Total Hours" />
						<display:column property="totalWorkingHours" sortable="false" title="Working Hours" />
				</display:table>
			</logic:present>

			<%-- <logic:present name="consolidatedMonthReportList" scope="request"> 			
				<display:table name="requestScope.consolidatedMonthReportList" requestURI="/consolidateDetailedMonthReport.do?parameter=getConsolidatedMonthReport" pagesize="20" export="false" class="tablecss">
	 				<display:column  property="empid" sortable="false" title="Employee Id"/>
           	   		<display:column property="empname" sortable="false"  title="Employee Name" />
               		<display:column  property="locationName" sortable="false" title="Location"/>
           	   		<display:column property="shiftName" sortable="false"  title="Shift" />
           	   		<display:column property="totalPresent" sortable="false"  title="Total present" />
           	   		<display:column property="lateTime" sortable="false"  title=" Total LateTime" />
					<display:column property="earlyTime" sortable="false"  title="Total EarlyTime" /> 
					<display:column property="totalWorkingHours" sortable="false"  title="Total Working Hours" /> 
               	</display:table>	
			</logic:present> --%>

			<logic:present name="consolidatedMonthReportList" scope="request">
				<logic:iterate id="calMap" name="consolidatedMonthReportList"
					scope="request">
					<h3 class="accordHead" id="accordionCss"> <bean:write
							name="calMap" property="key" />
					</h3>
					<div class="accBody">
						<table width="95%" class="tablecss">
							<tr>
								<th>Location</th>
								<th>Employee ID</th>
								<th>Employee Name</th>
								<th>Designation Name</th>
								<th>Status</th>
								<th>Late-Hours</th>
								<th>Early-Hours</th>
								<th>Working Hours</th>
							</tr>
							<logic:iterate id="datalist" name="calMap" property="value">
								<tr>
									<td><bean:write name="datalist" property="locationName" /></td>
									<td><bean:write name="datalist" property="empid" /></td>
									<td><bean:write name="datalist" property="empname" /></td>
									<td><bean:write name="datalist" property="designationName" /></td>
									<td><bean:write name="datalist" property="totalPresent" /></td>
									<td><bean:write name="datalist" property="lateTime" /></td>
									<td><bean:write name="datalist" property="earlyTime" /></td>
									<td><bean:write name="datalist"
											property="totalWorkingHours" /></td>
								</tr>
							</logic:iterate>
							<tr>
							</tr>
						</table>
						<table>
							<tr>
								<td style="padding-right: 90%"><input type="button"
									value="Download" class="submitbutton" id="downloadForthisDate"
									onclick="downloadForthisDay('<bean:write
										name="calMap" property="key" />')"></td>

							</tr>
						</table>

					</div>
				</logic:iterate>
			</logic:present>
		</div>
		<center>
			<table>
				<tr>
					<logic:present name="consolidatedMonthReportList" scope="request">
						<tr>
							<td><input type="button" value="Download PDF"
								class="submitbutton" id="consolidatedPdfId"
								name="consolidatedMonthReportList" /></td>
						</tr>
					</logic:present>

					<logic:present name="detailedMonthReportList" scope="request">
						<tr>
							<td><input type="button" value="Download PDF"
								class="submitbutton" id="detailedPdfId"
								name="detailedMonthReportList" /></td>
						</tr>
					</logic:present>
				<tr>
					<td></td>
				</tr>
			</table>
		</center>

</body>
</html>