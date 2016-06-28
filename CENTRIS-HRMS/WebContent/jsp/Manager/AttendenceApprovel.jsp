<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance approval</title>

<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript"
	src="JQUERY/js/bootstrap-datetimepicker.min.js"></script>

<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link href="css/Home/bootstrap-combined.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/Home/bootstrap-datetimepicker.min.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="css/common.css"></link>
<script type="text/javascript" src="js/Manager/AttendenceApprovel.js"></script>
<link rel="stylesheet" href="css/Manager/AttendanceApproval.css"></link>
<link rel="stylesheet" href="css/login/common.css">
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

</head>
<body>
	<div id="main">
	<div id="loader" style="position: absolute;top:350px;left:650px;display: none;"><img  src="images/loaderimage2.GIF"/></div>
		<div class="background" id="backgroung">
			</br>
			<center>
				<div class="backgroundDiv" id="backgroung" style="width: 100%">Employee
					Attendence</div>
				<div id="errordiv" class="error-box" style="width: 19%">

					<logic:present name="message" scope="request">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="message" />
						</span>
					</logic:present>
					<logic:present name="errorMessage" scope="request">
							<span style="color: red; font-family: Segoe UI;"> <bean:write
									name="errorMessage" />
							</span>
						</logic:present>
				</div>
			</center>


	<fieldset style="width: 95%;">

			<form action="attendenceaprrovel.do?parameter=getEmployeeAttendence"
				name="AttendenceApproval" method="post">

				<br />
				<center>
				
						<table id="biometric" align="center">
							<tr>
							<tr class="trc">
							<tr>
							<tr class="trc">
								<td  class="left">Select Month<font color="red">*</font><br />

									<select name="month" id="month">
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
								<td  class="left">Select Year<font color="red">*</font><br />

									<select name="year" id="year">
										<option value="">-----Select---------</option>
										<option value="2014">2014</option>
										<option value="2015">2015</option>
										<option value="2016">2016</option>
										<option value="2017">2017</option>
										<option value="2018">2018</option>
										<option value="2019">2019</option>
								</select>
								</td>
								<td  class="left">Select Employee<font
									color="red">*</font><br /> <select name="emplyeeid"
									id="employee">
										<option value="">-----Select-----------</option>
										<logic:present name="emp_list" scope="session">
											<logic:iterate id="employee" name="emp_list">

												<option
													value='<bean:write name="employee" property="empid"/>'>
													<bean:write name="employee" property="empname" />
												</option>

											</logic:iterate>
										</logic:present>

								</select>
								</td>

							</tr>

						</table><br/>
					

					<input type="submit" value="View Attendence" class="submitbutton"
						id="viewDayReportId" onclick="return validations()" /><br></br>
				</center>


			</form>
			<center>
				<div>

					<logic:present name="Nothing" scope="request">

						<span style="color: black; font-family: Segoe UI;"> <bean:write
								name="Nothing" /></span>

					</logic:present>

					<logic:present name="current_search_list" scope="request">

						<logic:iterate id="currentsearch" name="current_search_list">

							<input type="hidden" id="currentempid"
								value="<bean:write name="currentsearch" property="employeeid"/>,<bean:write name="currentsearch" property="monthnumber"/>,<bean:write name="currentsearch" property="year"/>" />
							<input type="hidden" id="currentstatus"
								value="<bean:write name="currentsearch" property="status"/>" />

						</logic:iterate>

					</logic:present>

				</div>
				</br>
			</center>

			<center>

				<div class="" align="center" style="width: 95%">

					<logic:present name="attendence_list" scope="request">
						<%-- <logic:notEmpty name="attendence_list" scope="request"> --%>

						<div align="left"
							style="background: #D9D9D9 !important; height: 40px; width: 100%; vertical-align: center !important">

							<span
								style="color: black; line-height: 40px; font-family: Segoe UI; font-size: 15px important; margin-left: 10px"><label
								style="font-family: Segoe UI !important; font-size: 14px;color: black;font-weight: 600;">Employee
									Name: </label>
							<bean:write name="currentsearch" property="employeename" /></span>&nbsp;&nbsp;
							<span style="color: black;"><label
								style="font-family: Segoe UI !important; font-size: 14px;color: black;font-weight: 600;">Month:
							</label>
							<bean:write name="currentsearch" property="month" /></span>&nbsp;&nbsp;
							<span style="color: black;"><label
								style="color: black;font-weight: 600; font-family: Segoe UI !important; font-size: 14px">Year:
							</label>
							<bean:write name="currentsearch" property="year" /></span>&nbsp;&nbsp; <span><label
								style="color: black;font-weight: 600; font-family: Segoe UI !important; font-size: 14px; color: black; margin-left: 10%;">Select
									Attendance :</label>&nbsp;&nbsp;</span> <span> <select
								style="width: 120px !important;" name="selectattendance"
								id="selectattendance" onchange="getAttendanceSelectType()">
									<option value="all">All</option>
									<option value="Y">Approved</option>
									<option value="N">Not Approved</option>
							</select>
							</span> <input type="button" value="Approve All" class="submitbutton"
								id="viewDayReportId" onclick="updateAll()"
								style="height: 40px; width: 9%; background-color: #D9D9D9; margin-left: 10%;color: black;font-weight: 600" />



						</div>

						<%-- 	</logic:notEmpty> --%>


						<display:table id="attendance" name="attendence_list"
							export="false" class="view"
							requestURI="/attendenceaprrovel.do?parameter=getEmployeeAttendence"
							decorator="com.centris.decorator.AttendanceApprovelDecorator"
							pagesize="31">



							<display:column property="sno" title="SNO"
								class='sno' />

							<display:column title="Attendance Date">
								<input type='text' name='attendancedate'
									value='${attendance.attendencedate}'
									id="${attendance.attendencedate}date" readonly="readonly"
									style="width: 60% !important" class="attendanceDate"/>
							</display:column>

							<display:column property="inTime" title="In Time"
								style="text-align:center;" sortable="false" />
							<display:column property="outTime" title="Out Time"
								style="text-align:center;" sortable="false" />

							<display:column title="Location">
								<input type='text' name='attendancedate'
									value='${attendance.location}'
									id="${attendance.attendencedate}location" readonly="readonly"
									style="width: 60% !important" class="location" />
							</display:column>

							<display:column title="Status">
								<select name="status" id="${attendance.attendencedate}status"
									disabled style="width: 110px !important" class="status">
									<option value="${attendance.attendancestatus}">${attendance.attendancestatus}</option>
								</select>

							</display:column>

							<display:column title="Status type">
								<select name="statustype"
									id="${attendance.attendencedate}statustype" disabled
									style="width: 110px !important" class="statusType">
									<option value="${attendance.attendencetypecode}">${attendance.attendancetype}</option>
								</select>

							</display:column>

							<display:column title="Project Name">
								<select name="projectname"
									id="${attendance.attendencedate}projectname" disabled
									style="width: 110px !important" class="projectName">
									<option value="${attendance.projectcode}">${attendance.projectname}</option>
								</select>

							</display:column>


							<display:column title=" Edit">
								<input type='button' name='edit' value='  Edit  '
									id="${attendance.attendencedate}" class="editfunction"
									style="width: 80px !important" />
							</display:column>

							<display:column title="Approve">
								<span class='${attendance.approvedstatus}'> <input
									type='button' name='update'
									value='${attendance.approvedstatus}'
									id="${attendance.attendencedate}=${attendance.empid}"
									class="updatefunction" style="width: 80px !important" /></span>
							</display:column>



						</display:table>

					</logic:present>

				</div>
			</center>
			
			</fieldset>

			<!-- onClick='editattendence(this)' -->
		</div>
	</div>

</body>
</html>