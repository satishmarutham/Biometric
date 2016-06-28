<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Today's Report</title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script language="javascript" src="js/common.js"></script>
<script language="javascript" src="js/TodayReport.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
</head>
<br/>
<body>
			<div class="background" id="backgroung">
			<center>
				<div class="backgroundDiv" id="backgroung" style="width: 100%">Today's Report</div>
				<div id="errordiv" class="error-box">
						<logic:present name="message" scope="session">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="message" />
						</span>
					</logic:present>
				</div>
			</center>
			<br />
			<input id="hgroupId" type="hidden" value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="group"/> </logic:present>'/>
			<input id="hlocationId" type="hidden" value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="location"/> </logic:present>'/>
			<input id="hemployeeId" type="hidden" value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="employee"/> </logic:present>'/>
			
			<form action="todayReport.do"  name="todayReport" method="post">
			<input type="hidden" name="parameter" id="methodNameId" value="getTodayReport"/>
			<table id="biometric" align="center">
				<tr>
				<tr class="trc">
					<td align="left" class="trd">Select Group<br />

						<select name="group" id="groupId">
						<option value="">---Select Option---</option>
						<logic:present name="groupDetails" scope="session">
						<logic:iterate id="groupDetailId" name="groupDetails" scope="session">
						<option value="<bean:write name="groupDetailId" property="groupId"/>"><bean:write name="groupDetailId" property="groupName"/></option>
						</logic:iterate>
						</logic:present>
						
						</select>
					</td>
					<td align="left" class="trd">Select Location<br />
						<select name="location" id="locationId">
							<option value="">---Select Option---</option>
						</select>
					</td>
					<td align="left" class="trd">Select Employee<br />
						<select id="employeeId" name="employee">
								<option value="">---Select Option---</option>
						</select>
					</td>
				</tr>

			</table>
			<br>
			<table align="center">
				<tr>
					<td><input type="submit" value="View Report" class="submitbutton" id="todayReportId" onclick="return validations()" />
				</tr>
			</table>
			
			
			
			</form>
		
 		<div class="tablecss" style="margin:15px;text-align: center" id="tableId">
		<display:table export="false" style="font-family: Segoe UI;width:90%;margin:0 auto;" name="requestScope.todayReportList"
			requestURI="/todayReport.do?parameter=getTodayReport"
			pagesize="20">
			<display:column property="sNo" title="Sl No."
				style="text-align:center;width:100px;" sortable="false" />
			<display:column property="empid" title="Employee ID"
				style="text-align:center;" sortable="false" />
			<display:column property="empname" title="Employee Name"
				style="text-align:left;" sortable="false" />
			<display:column property="location" title="Location"
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
			<display:column property="status" title="Status"
				style="text-align:center;" sortable="false" />
			</display:table>

		</div>
		<center>
		<table><tr>
<logic:present name="todayReportList" scope="request">
<tr>
<td><input type="button" value="Download PDF" class="submitbutton" id="todayPdfId"/>
</td></tr>
 </logic:present>

 </table>
 </center>
		</div>

</body>

</html>
