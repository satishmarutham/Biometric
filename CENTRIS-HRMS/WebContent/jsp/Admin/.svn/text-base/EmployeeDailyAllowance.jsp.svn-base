<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Employee Daily Allowance</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/Admin/Employee.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<script language="javascript" src="js/Admin/EmployeeDailyAllowance.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

</head>

<body>
	<div id="main" class="background">
		<center>
			<div class="backgroundDiv" id="backgroung">
				Employee Daily Allowance

				<div id="errordiv" class="error-box" align="center">

					<logic:present name="message" scope="request">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="message" />
						</span>
					</logic:present>
				</div>

				<form
					action="employeeDailyAllowance.do?method=viewEmployeeDailyAllowance"
					name="AddEmployeeForm" method="post">
					
					<table id="biometric" width="20%">

						<tr>
							<td>Select Date  <input type="text"
								name="dailyAllowanceDate" id="dailyAllowanceDate"
								class="datePicker" readonly="readonly" placeholder="Click here"
								value='<logic:present name="employeeDailyAllowanceForm" scope="request"> <bean:write name="employeeDailyAllowanceForm" property="dailyAllowanceDate"/> </logic:present>' /></td>
						</tr>
					</table>

					<table>
						<tr class="odd">

							<td><input type="submit" class="submitbutton"
								value="View Daily Allowance" class="button1"
								id="viewDailyAllowance" /></td>
							<td><input type="button" class="submitbutton"
								value="Download Daily Allowance" class="button1"
								id="downloadDailyAllowance" /></td>

						</tr>

					</table>

				</form>




				<div class="tablecss" style="margin: 15px; text-align: center"
					id="tableId">
					<logic:present name="DailyEmployeeAllowanceVOList" scope="request">
						<logic:iterate id="employeedailyalowences"
							name="DailyEmployeeAllowanceVOList" scope="request">
							<h3 class="accordHead" id="accordionCss">
								<span style="color: black;">Project Manager -</span>&nbsp;&nbsp;
								<bean:write name="employeedailyalowences" property="key" />
							</h3>
							<logic:notEmpty name="employeedailyalowences" property="value">
								<div class="accBody">

									<table id="ACCLT" width="85%" class="tablecss">

										<tr class="HometblHeader">
											<th>Sno</th>
											<th>Date</th>
											<th>Code</th>
											<th>Names</th>
											<th>HDFC A/C No</th>
											<th>Amount</th>
											<th>Client</th>
											<th>Project</th>
											<th>TeamLead</th>
											<th>Location</th>
											<th>Remarks</th>
										</tr>

										<logic:iterate name="employeedailyalowences" property="value"
											id="lastAbsent">
											<tr>
												<td class="TblHometd"><bean:write name="lastAbsent"
														property="slNo" /></td>
												<td class="TblHometd"><bean:write name="lastAbsent"
														property="date" /></td>

												<td class="TblHometd"><bean:write name="lastAbsent"
														property="code" /></td>
												<td class="TblHometd"><bean:write name="lastAbsent"
														property="names" /></td>
												<td class="TblHometd"><bean:write name="lastAbsent"
														property="hdfcNo" /></td>
												<td class="TblHometd"><bean:write name="lastAbsent"
														property="amount" /></td>
												<td class="TblHometd"><bean:write name="lastAbsent"
														property="client" /></td>

												<td class="TblHometd"><bean:write name="lastAbsent"
														property="project" /></td>
												<td class="TblHometd"><bean:write name="lastAbsent"
														property="teamLead" /></td>
												<td class="TblHometd"><bean:write name="lastAbsent"
														property="location" /></td>
												<td class="TblHometd"><bean:write name="lastAbsent"
														property="remarks" /></td>

											</tr>
										</logic:iterate>


									</table>


								</div>
							</logic:notEmpty>
						</logic:iterate>
					</logic:present>

				</div>


			</div>

		</center>

	</div>


</body>



</html>
