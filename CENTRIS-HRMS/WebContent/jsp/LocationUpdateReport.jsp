<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Last Update Report</title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script language="javascript" src="js/common.js"></script>
<script language="javascript" src="js/LocationUpdateReport.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
</head>
<body>
	<br />
	<div class="background" id="backgroung">
		<center>
			<div class="backgroundDiv" id="backgroung" style="width: 100%">Location Updated Report</div>
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
	
		<form action="locationUpdateReport.do" id="MonthReport"  method="post">
			<input type="hidden" name="parameter" id="methodNameId"  value="getLocationUpdateReport"/>
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
					<td align="left" class="trd">Select Location<font color="red">*</font><br/> <select
						name="location" id="locationId">
							<option value="">---Select Option---</option>
					</select>
					</td>
					
				</tr>

			</table>
			<br>
				<table align="center">
				<tr>
					<td><input type="submit" value="Location Updated Report"
						class="submitbutton" id="locationUpdateReport"
						onclick="return validations()" /> </td>

				</tr>
			</table>
		</form>


		<div class="tablecss" style="margin: 15px; text-align: center" id="tableId">
			<logic:present name="locationUpdateReportList" scope="request">
				<display:table name="requestScope.locationUpdateReportList" pagesize="20" export="false" requestURI="/locationUpdateReport.do?parameter=getLocationUpdateReport">
					<display:column property="locationId" sortable="false" title="Location ID" />
					<display:column property="locationName" sortable="false" title="Location Name" />
					<display:column property="updateDate" sortable="false" title="Last Updated Date" />
					<display:column property="lastUpdateTime" sortable="false" title="Last Updated Time" />
				</display:table>
			</logic:present>
		</div>	
		</div>	
</body>
</html>