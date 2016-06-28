<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Monthly Legend Report</title>
<script language="javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/monthlylagentreport.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/MonlyLegendReport.css"></link>
</head>
<body>
	<br></br>
	<input id="hgroupId" type="hidden"
		value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="group"/> </logic:present>' />
	<input id="hlocationId" type="hidden"
		value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="empLocation"/> </logic:present>' />
	<input id="hdesignationId" type="hidden"
		value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="designation"/> </logic:present>' />
	<input id="hmonth" type="hidden"
		value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="month"/> </logic:present>' />
	<input id="hyear" type="hidden"
		value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="year"/> </logic:present>' />


	<div align="center" id="main">
		<div class="background" id="backgroung">
			<div class="backgroundDiv" id="backgroung">Employee Monthly -
				Legend Report</div>
			<div id="errordiv" class="error-box">
				<center>
					<logic:present name="message" scope="request">
						<span style="color: red; font-family: Segoe UI;"> <bean:write
								name="message" /> <bean:write name="year" scope="request" /> -
							<bean:write name="month" scope="request" />
						</span>
					</logic:present>
				</center>
			</div>
			<form action="monthlylagendreport.do" onsubmit="return validation();"
				method="post">
				<input type="hidden" name="method" value="internal"></input>
				<table id="biometric" align="center">
					<tr>
						<td class="USER_GROUP">Select Group<br /> <select
							class="userGroup" name="group" id="group"
							onchange="getlocations()">
								<option value="">---Select---</option>
								<logic:present name="Groups" scope="session">
									<option
										value='<bean:write name="Groups" property="groupId"></bean:write>'>
										<bean:write name="Groups" property="groupName"></bean:write>
									</option>
								</logic:present>
						</select>
						</td>
						<td class="USER_LOCATION">Select Location<font color="red">*</font>
							<br /> <select name="empLocation" id="empLocation"
							class="userLocationId" onchange="getShiftDept()">
								<option value="">-----Select-----</option>
						</select>

						</td>


						<td>Select Designation<font color="red">*</font><br /> <select
							name="designation" id="designationId" class="designationclass">
								<option value="">---select---</option>
								<option value="all">All</option>
								<logic:present name="designationList" scope="session">
									<logic:iterate id="designation" name="designationList">
										<option
											value='<bean:write name="designation" property="desgid"></bean:write>'>
											<bean:write name="designation" property="desgname"></bean:write>
										</option>
									</logic:iterate>
								</logic:present>

						</select></td>

						<td>Select Year<font color="red">*</font><br />
							<div id="txtHint">
								<select name="year" id="year">
									<option value="">---select---</option>
									<option value="2010">2010</option>
									<option value="2011">2011</option>
									<option value="2012">2012</option>
									<option value="2013">2013</option>
									<option value="2014">2014</option>
									<option value="2015">2015</option>

								</select>
							</div></td>
						<td>Select Month<font color="red">*</font><br /> <select
							name="month" id="month">
								<option value="">---select---</option>
								<option value="01">JAN</option>
								<option value="02">FEB</option>
								<option value="03">MAR</option>
								<option value="04">APR</option>
								<option value="05">MAY</option>
								<option value="06">JUNE</option>
								<option value="07">JULY</option>
								<option value="08">AUG</option>
								<option value="09">SEP</option>
								<option value="10">OCT</option>
								<option value="11">NOV</option>
								<option value="12">DEC</option>
						</select></td>
					</tr>
				</table>
				<br />
				<table>
					<tr>
						<%-- 	<td><html:submit value="internal" property="method"
								styleClass="submitbutton" /></td> --%>
						<td><input type="submit" value="View Report"
							Class="submitbutton"></td>
					</tr>
				</table>
				<%-- <td><html:submit value="external" property="method" styleClass="submitbutton" /></td>
					 --%>


			</form>


			<br />
			<center>
				<logic:notEmpty name="year">

					<h2 id="one">
						<bean:write name="year" scope="request" />
						-
						<bean:write name="month" scope="request" />
					</h2>

				</logic:notEmpty>
			</center>
			<br />

			<form action="monthlylagendreport.do" method="post">
				<input type="hidden" name="method" value="InternalDownload"></input>
				<logic:notEmpty name="internalmonthreportlist">
					<table id="tbl" class="tablecss">

						<tr>
							<th>Employee ID</th>
							<th>Employee Name</th>
							<th>Designation</th>
							<%
								int days = (Integer) request.getAttribute("days");
									for (int i = 1; i <= days; i++) {
							%>



							<th><%=i%></th>

							<%
								}
							%>

							<th>Total Present</th>
							<th>Total Absent</th>
							<th>Total Weekoff</th>
							<!-- 	<th>TotalPayableDay</th> -->

						</tr>

						<logic:iterate id="employeeMonthReport"
							name="internalmonthreportlist" scope="request">
							<tr>

								<td align="center"><bean:write name="employeeMonthReport"
										property="empid" /></td>
								<td align="center"><bean:write name="employeeMonthReport"
										property="empname" /></td>
								<td align="center"><bean:write name="employeeMonthReport"
										property="designation" /></td>

								<logic:iterate id="employeeMonthReport1"
									name="employeeMonthReport" property="status">
									<td id="<bean:write name="employeeMonthReport1" />"><bean:write
											name="employeeMonthReport1" /></td>
								</logic:iterate>



								<td align="center"><bean:write name="employeeMonthReport"
										property="totalpresent" /></td>
								<td align="center"><bean:write name="employeeMonthReport"
										property="totalabsent" /></td>
								<td align="center"><bean:write name="employeeMonthReport"
										property="totalweekoff" /></td>
								<%-- <td align="center"><bean:write name="employeeMonthReport"
								property="paybledays" /></td> --%>
							</tr>
						</logic:iterate>




					</table>
					<br></br>
					<table>
						<tr>
							<%-- <td><html:submit value="InternalDownload" property="method"
									styleClass="submitbutton"></html:submit></td> --%>
							<td><input type="submit" value="Download Report"
								Class="submitbutton"></td>
						</tr>
					</table>

				</logic:notEmpty>





			</form>


			<form action="monthlylagendreport.do">
				<logic:notEmpty name="externalmonthreportlist">
					<table id="tbl" class="tablecss">

						<tr>
							<th>EmployeeID</th>
							<th>EmployeeName</th>
							<%
								int days = (Integer) request.getAttribute("days");
									for (int i = 1; i <= days; i++) {
							%>



							<th><%=i%></th>

							<%
								}
							%>

							<th>Total Present</th>
							<th>Total Absent</th>
							<th>Total Weekoff</th>
							<!-- 	<th>TotalPayableDay</th> -->

						</tr>

						<logic:iterate id="employeeMonthReport"
							name="externalmonthreportlist" scope="request">
							<tr>

								<td align="center"><bean:write name="employeeMonthReport"
										property="empid" /></td>
								<td align="center"><bean:write name="employeeMonthReport"
										property="empname" /></td>


								<logic:iterate id="employeeMonthReport1"
									name="employeeMonthReport" property="status">
									<td id="<bean:write name="employeeMonthReport1" />"><bean:write
											name="employeeMonthReport1" /></td>
								</logic:iterate>



								<td align="center"><bean:write name="employeeMonthReport"
										property="totalpresent" /></td>
								<td align="center"><bean:write name="employeeMonthReport"
										property="totalabsent" /></td>
								<td align="center"><bean:write name="employeeMonthReport"
										property="totalweekoff" /></td>
								<%-- <td align="center"><bean:write name="employeeMonthReport"
								property="paybledays" /></td> --%>
							</tr>
						</logic:iterate>




					</table>
					<br></br>
					<table>
						<tr>
							<td><html:submit value="ExternalDownload" property="method"
									styleClass="submitbutton"></html:submit></td>
						</tr>
					</table>

				</logic:notEmpty>
			</form>
			<br></br>
		</div>
	</div>

</body>
</html>