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
<!-- <script type="text/javascript" src="js/Manager/AttendenceApprovel.js"></script> -->
<script type="text/javascript"
	src="js/Manager/AttendanceApprovalByDate.js"></script>
<link rel="stylesheet" href="css/Manager/AttendanceApproval.css"></link>
<!-- <link rel="stylesheet" href="css/login/style.css"> -->
<link rel="stylesheet" href="css/login/common.css">
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

</head>
<style>

.view{
width: 130% !important;
}




</style>
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

<center>
	

			<form
				action="managerLeaveApprovedbydate.do?parameter=getEmployeeAttendence"
				name="AttendenceApproval" method="post">

				<br />
				<center>
				
					
						<table id="biometric" align="center" width="55%">
							
							<tr class="trc">
							
								<td  class="left">Start Date<font color="red">*</font><br />

									<input type="text" name="startdate" id="stratdate"
									readonly="readonly" />
								</td>
								<td class="left">End Date<font color="red">*</font><br />

									<input type="text" name="enddate" id="enddate"
									readonly="readonly" />
								</td>
								<td class="left">Select Employee<font
									color="red">*</font><br /> <select name="employeename"
									id="employee">
										<option value="">-----Select-----------</option>
										<logic:present name="emp_list" scope="session">
										<option value="all">All</option>
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
								value="<bean:write name="currentsearch" property="employeeid"/>,<bean:write name="currentsearch" property="startdate"/>,<bean:write name="currentsearch" property="enddate"/>" />
							<input type="hidden" id="currentstatus"
								value="<bean:write name="currentsearch" property="status"/>" />

						</logic:iterate>

					</logic:present>

				</div>
				<br />
			</center>

			<center>

	`		<logic:present name="attendence_list" scope="request">

					
						<%-- <logic:notEmpty name="attendence_list" scope="request"> --%>

						<div align="left"
							style=" height: 40px; width: 100%; vertical-align: center !important">

							 <span><label
								style="color: black;font-weight: 600; font-family: Segoe UI !important; font-size: 14px; color: black; margin-left: 40%;">Select
									Attendance :</label>&nbsp;&nbsp;</span>
							<select
								style="width: 120px !important;height: 38px !important" name="selectattendance"
								id="selectattendance" onchange="getAttendanceSelectType()">
									<option value="all">All</option>
									<option value="Y">Approved</option>
									<option value="N">Not Approved</option>
									
							</select>
						
							<input type="button" value="Approve All" class="submitbutton"
								id="viewDayReportId" onclick="updateAll()"
								style="height: 30px; width: 9%; background-color: #D9D9D9;margin-left:30%;color: black;font-weight: 600" />



						</div>
						

						<%-- 	</logic:notEmpty> --%>

				
 			 <div style="overflow:auto;width:100%;" >
 			 
						<display:table id="attendance" name="attendence_list" 
							export="false" class="view" 
							requestURI="/managerLeaveApprovedbydate.do?parameter=getEmployeeAttendence"
							decorator="com.centris.decorator.AttApprovedByDateDecorator"
							pagesize="31">



							<display:column property="sno" title="SNO" class='sno'/>
							<display:column property="empname" title="Employee Name" class='employeename'/>	 
							<display:column property="empid" title="EmployeeId" class='employeeId' headerClass="employeeId"/>	 
							

							<display:column title="AttendanceDate">
								<input type='text' name='attendancedate'
									value='${attendance.attendencedate}'
									id="${attendance.attendencedate}--${attendance.empid}date" readonly="readonly"
									style="width: 95% !important;height: 30px" class="attendanceDate" />
							</display:column>
							
							<display:column title="Status">
								<select name="status" id="${attendance.attendencedate}--${attendance.empid}status"
									disabled style="width: 160px !important;height: 30px !important" class="status">
									<option value="${attendance.attendancestatus}">${attendance.attendancestatus}</option>
								</select>

							</display:column>

							<display:column title="Status type">
								<select name="statustype"
									id="${attendance.attendencedate}--${attendance.empid}statustype" disabled
									style="width: 160px !important;height: 30px !important" class="statusType">
									<option value="${attendance.attendencetypecode}">${attendance.attendancetype}</option>
								</select>

							</display:column>

							<display:column property="inTime" title="In Time"
								style="text-align:center;" sortable="false" />
							<display:column property="outTime" title="Out Time"
								style="text-align:center;" sortable="false"/>

							<%-- <display:column title="Location">
								<input type='text' name='attendancedate'
									value='${attendance.location}'
									id="${attendance.attendencedate}--${attendance.empid}location" readonly="readonly"
									style="width: 95% !important;height: 30px" class="location"/>
							</display:column> --%>


							<display:column title="Project Name">
								<select name="projectname"
									id="${attendance.attendencedate}--${attendance.empid}projectname" disabled
									style="width: 250px !important;height: 30px !important" class="projectName">
									<option value="${attendance.projectcode}">${attendance.projectname}</option>
								</select>

							</display:column>


							<display:column title=" Edit">
								<input type='button' name='edit' value='  Edit  '
									id="${attendance.attendencedate}--${attendance.empid}" class="editfunction"
									style="width: 80px !important;" />
							</display:column>

							<display:column title="Approve">
								<span class='${attendance.approvedstatus}'> <input
									type='button' name='update'
									value='${attendance.approvedstatus}'
									id="${attendance.attendencedate}--${attendance.empid}"
									class="updatefunction" style="width: 80px !important;" /></span>
							</display:column>



						</display:table>
						
						</div>

					</logic:present>
					
					

			</center>

			<!-- onClick='editattendence(this)' -->
			
			</center>
		</div>
		
	</div>

</body>
</html>