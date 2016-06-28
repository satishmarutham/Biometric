<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Daily Log Report</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<script type="text/javascript" src="/JQUERY/js/jquery.ui.datepicker.js"></script>
<script language="javascript" src="js/DailyLogReport.js"></script>
<link rel="stylesheet" href="css/common.css"></link>


</head>
<body>
	<br />
	<div id="main">
		<form name="DayReportForm" action="dailylogreport.do" method="post">
			<input type="hidden" name="parameter" id="methodNameId"
				value="getDailylogReport" />

			<div class="background" id="backgroung">
				<center>
					<div class="backgroundDiv" id="backgroung" style="width: 100%">Daily
						Log Report</div>
					<div id="errordiv" class="error-box" style="width: 19%"></div>
				</center>
				<br />
				<center>
					<table id="biometric" align="center">

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


							<td align="left" class="trd">Select Location<font
								color="red">*</font><br /> <select name="location"
								id="locationId">
									<option value="">---Select Option---</option>

							</select>
							</td>
							<td align="left" class="trd">Select Designation<font color="red">*</font><br />

								<select name="designation" id="designationId">
									<option value="">---Select Option---</option>
									
									
							</select>
							</td>
							<td align="left" class="trd">Select Employee<font
								color="red">*</font><br /> <select id="employeeId"
								name="employee">
									<option value="">---Select Option---</option>
							</select>
							</td>

							<td align="left" class="trd">Start Date<font color="red">*</font><br />
								<input type="text" id="startdateId" name="startDate"
								readonly="readonly" placeholder="Click here" />
							</td>




							<td align="left" class="trd">End Date<font color="red">*</font><br />
								<input type="text" id="enddateId" name="endDate"
								readonly="readonly" placeholder="Click here" />
							</td>
						</tr>

					</table>


					<br>
					<table align="center">



						<tr>

							<td><input type="submit" value="View Report"
								class="submitbutton" id="viewDayReportId"
								onclick="return validations()" /></td>



						</tr>
					</table>



					<center>

						<div class="tablecss" style="margin: 15px; text-align: center"
							id="tableId">
							<display:table export="false"
								style="font-family: Segoe UI;width:95%;margin:0 auto;"
								name="requestScope.dailyLogReportList"
								requestURI="/dailylogreport.do?parameter=getDailylogReport"
								pagesize="20">
								<%-- <display:column property="sNo" title="Sl No."
				style="text-align:center;width:100px;" sortable="false" /> --%>
								<display:column property="empid" title="Employee ID"
									style="text-align:center;" sortable="false" />
								<display:column property="empname" title="Employee Name"
									style="text-align:left;" sortable="false" />

								<display:column property="location" title="Location"
									style="text-align:center;" sortable="false" />
								<display:column property="designation" title="Designation"
									style="text-align:center;" sortable="false" />
								<display:column property="date" title="Date (DD-MM-YYYY)"
									style="text-align:center;width:100px;" sortable="false" />
								<display:column property="status" title="Status"
									style="text-align:center;" sortable="false" />
								<display:column property="firstLogInTime" title="IN-1"
									style="text-align:center;" sortable="false" />
								<display:column property="firstLogOutTime" title="OUT-1"
									style="text-align:center;" sortable="false" />
								<display:column property="secondLogInTime" title="IN-2"
									style="text-align:center;" sortable="false" />
								<display:column property="secondLogOutTime" title="OUT-2"
									style="text-align:center;" sortable="false" />
								<display:column property="thirdLogInTime" title="IN-3"
									style="text-align:center;" sortable="false" />
								<display:column property="thirdLogOutTime" title="OUT-3"
									style="text-align:center;" sortable="false" />
								<display:column property="fourthLogInTime" title="IN-4"
									style="text-align:center;" sortable="false" />
								<display:column property="fourthLogOutTime" title="OUT-4"
									style="text-align:center;" sortable="false" />
								<display:column property="fifthLogInTime" title="IN-5"
									style="text-align:center;" sortable="false" />
								<display:column property="fifthLogOutTime" title="OUT-5"
									style="text-align:center;" sortable="false" />

							</display:table>

						</div>
						<table>
							<tr>


								<logic:present name="dailyLogReportList" scope="request">
									<logic:iterate id="dailylogreportlistId"
										name="dailyLogReportList" scope="request" offset="1"
										length="1">

										<input type="hidden" name="hgroup" id="hgroup"
											value='<bean:write name="dailylogreportlistId" property="hgroup"/>'></input>
										<input type="hidden" name="hlocation" id="hlocation"
											value='<bean:write name="dailylogreportlistId" property="hlocation"/>'></input>
										<input type="hidden" name="hdesignation" id="hdesignation"
											value='<bean:write name="dailylogreportlistId" property="hdesignation"/>'></input>
										<input type="hidden" name="hemployee" id="hemployee"
											value='<bean:write name="dailylogreportlistId" property="hemployee"/>'></input>
										<input type="hidden" name="hstartdate" id="hstartdate"
											value='<bean:write name="dailylogreportlistId" property="hstartdate"/>'></input>
										<input type="hidden" name="henddate" id="henddate"
											value='<bean:write name="dailylogreportlistId" property="henddate"/>'></input>


									</logic:iterate>
								</logic:present>


								<td><input type="button" value="Download PDF"
									class="submitbutton" id="downloadPdf" name="dayReportDetails" /></td>




							</tr>



						</table>


					</center>
				</center>
			</div>
		</form>
</body>

</html>
