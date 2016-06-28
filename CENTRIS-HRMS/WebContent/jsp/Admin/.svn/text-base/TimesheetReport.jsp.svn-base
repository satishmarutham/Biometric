<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page language="java" trimDirectiveWhitespaces="true"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Time Sheet Report</title>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/Admin/TimeSheet.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>

</head>

<body>
	<br />
	<div class="background" id="backgroung">

 	 <center><div class="backgroundDiv" id="backgroung">Timesheet Report</div></center>
 	 
		<form action="attendancetimesheetreport.do" method="post">

			<center>


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

				<fieldset style="width: 85%;">
					<table id="biometric" cellspacing="5" cellpadding="8">
						<tr class="trc">
							<td class="left">Department<font color="red">*</font> <input
								type="checkbox" name="deptcheckbox" id="deptcheckbox"
								value="all" onclick="selectAllDepartments()" />select all</br> <select
								name="department" id="department" multiple="multiple"
								style="width: 100%;">
									<logic:present name="AllDepartments" scope="request">
										<logic:notEmpty name="AllDepartments" scope="request">
											<logic:iterate id="iterateid" name="AllDepartments"
												scope="request">
												<option
													value="<bean:write name="iterateid" property="deptid"></bean:write>"><bean:write
														name="iterateid" property="deptname"></bean:write>
												</option>
											</logic:iterate>
										</logic:notEmpty>
									</logic:present>
							</select>

							</td>
							<td class="left">Manager<font color="red">*</font> <input
								type="checkbox" name="mgrcheckbox" id="mgrcheckbox" value="all"
								onclick="selectAllManagers()" />select all</br> <select
								name="manager" id="manager" multiple="multiple"
								style="width: 100%;">
							</select>

							</td>

							<td class="left">Employee<font color="red">*</font> <input
								type="checkbox" name="empcheckbox" id="empcheckbox" value="all"
								onclick="selectAllEmployees()" />select all</br> <select
								name="employee" id="employee" multiple="multiple"
								style="width: 100%;">
							</select>
							</td>

							<td class="left">Month<font color="red">*</font><br /> <select
								name="month" id="month">
									<option value="">-----Select---------</option>
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
							</select>
							</td>
							<td class="left">Year<font color="red">*</font><br /> <select
								name="year" id="year">
									<option value="">-----Select---------</option>
									<logic:present name="ACC_YEAR" scope="request">

										<logic:iterate id="year" name="ACC_YEAR">

											<option value='<bean:write name="year" />'><bean:write
													name="year" /></option>


										</logic:iterate>

									</logic:present>
							</select>
							</td>
						</tr>
					</table>
				</fieldset>

				<html:submit value="Submit" styleClass="submitbutton" styleId="submitbtn" property="parameter" onclick="return validations()" /><br></br>
		
			</center>
			
			
 <input id="hempId" type="hidden" value='<logic:present name="hEmpId" scope="request"><bean:write name="hEmpId"/> </logic:present>' />
 <input id="hdepId" type="hidden" value='<logic:present name="hDepId" scope="request"><bean:write name="hDepId"/> </logic:present>' />
 <input id="hmgrId" type="hidden" value='<logic:present name="hMgrId" scope="request"><bean:write name="hMgrId"/> </logic:present>' />
 <input id="hmonth" type="hidden" value='<logic:present name="hmonth" scope="request"><bean:write name="hmonth"/> </logic:present>' />
 <input id="hyear" type="hidden" value='<logic:present name="hyear" scope="request"><bean:write name="hyear"/> </logic:present>' />
			
			
			<center>
			
	<div style="overflow:auto;width:100%;" >
		<logic:notEmpty name="timesheet_list">
		
					<table id="biometric" class="view" >

						<tr style="background: #156AEB !important">
							<th >Employee ID</th>
							<th>Employee Name</th>
							
							<%
								int days = (Integer) request.getAttribute("days");
									for (int i = 1; i <= days; i++) {
							%>



							<th><%=i%></th>

							<%
								}
							%>

							<th>Total days</th>
							<th>working days</th>
							<th>present days</th>
								<th>payable days</th>

						</tr>

						<logic:iterate id="employeeMonthReport"
							name="timesheet_list" scope="request">
							<tr>

								<td align="center"><bean:write name="employeeMonthReport"
										property="bioid" /></td>
								<td align="center"><bean:write name="employeeMonthReport"
										property="empname" /></td>
								<%-- <td align="center"><bean:write name="employeeMonthReport"
										property="designation" /></td> --%>

								<logic:iterate id="employeeMonthReport1"
									name="employeeMonthReport" property="status">
									<td id="<bean:write name="employeeMonthReport1" />"><bean:write
											name="employeeMonthReport1" /></td>
								</logic:iterate>



								<td align="center"><bean:write name="employeeMonthReport"
										property="totaldays" /></td>
								<td align="center"><bean:write name="employeeMonthReport"
										property="workingdays" /></td>
								<td align="center"><bean:write name="employeeMonthReport"
										property="presentdays" /></td>
								<td align="center"><bean:write name="employeeMonthReport"
								property="payabledays" /></td>
							</tr>
						</logic:iterate>




					</table>
					<br></br>
					<table>
						<tr>
							<td><html:submit value="Download" property="parameter"
									styleClass="submitbutton"></html:submit></td>
						
						</tr>
					</table>

				</logic:notEmpty>
				</div>
				</center>

		</form>
		
		
		
		

	</div>

</body>



</html>
