<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TimeSheet Report Audit</title>
<link rel="stylesheet" type="text/css" href="style.css" />
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

<script type="text/javascript" src="js/TimeSheetReport.js"></script>

<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link href="css/timesheetreport.css" rel="stylesheet" type="text/css" />
<link href="css/latecomersreport.css" rel="stylesheet" type="text/css" />


</head>
<body>
	<jsp:include page="header_menu.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<br>


	<div align="center"></div>

	<br>
	<center>
		<span class="headingclss">TimeSheet Report Audit</span>
	</center>

	<form name="TimesheetReportForm" action="timesheetreport.do">
		<input type="hidden" value="getEmployeeAttendanceInfo"
			name="parameter"> <br />
		<table id="biometric" align="center">
			<tr>
	<td class="USER_LOCATION">Select Location<br/>
					<select class="userLocationId" name="Location"></select>
				</td>
				<td><label>Select Shift<span style="color: red">
							*</span></label><br /> <select name="shiftid" id="shiftid"
					onchange="empDetails()" class="shiftClassForAdmin">
						<option value="">----Select----</option>
						<option value="all">All</option>
						
						<logic:present name="ALLSHIFTS" scope="request">
						<logic:iterate id="shift" name="ALLSHIFTS" scope="request">
							<option value='<bean:write name="shift" property="shiftId"/>'>
								<bean:write name="shift" property="shiftName" />
							</option>
						</logic:iterate>
						</logic:present>
				</select></td>

				<td><label>Select Department <span style="color: red">
							*</span></label><br /> <select name="empdepartment" id="empdepartment">
						<option value="">----Select----</option>
						<option value="all">All</option>
                         <logic:present name="ALLDEPT" scope="request">
						<logic:iterate id="DEPT" name="ALLDEPT" scope="request">
							<option value='<bean:write name="DEPT" property="depId"/>'>
								<bean:write name="DEPT" property="depName" />
							</option>
						</logic:iterate>
						</logic:present>

				</select></td>

				<td><label>Select Employee<span style="color: red">*</span></label><br />
					<select name="empname" id="employeeId"  class="empClassForAdmin">
					<option value="">------select-----</option>
			         <option value="all">All</option>
						
						<!-- <option value="all">All</option> -->
				</select></td>


				<td><label>From Date<span style="color: red">*</span></label><br /> <input type="text"
					id="datefrom" name="fromdate" value="" style="cursor: pointer;"
					readonly="readonly" placeholder="Select here"></td>

				<td><label>To Date<span style="color: red">*</span></label><br /> <input type="text"
					id="dateto" name="todate" style="cursor: pointer;" value=""
					readonly="readonly" placeholder="Select here"></td>

				<td><input type="submit" value="search" class="button1"
					onclick="return validations()"/></td>
			</tr>
		</table>
	</form>
	<br />
	<center>
		<table id="validateTable">
			<tr>
				<td colspan="3">
					<div class="alert-box error">
						<span class="fontweight">Validation failed : </span> <span
							class="validateTips"></span>
					</div>
				</td>
			</tr>
		</table>
	</center>
	<div class="" align="center">

		<logic:present name="EmployeeList" scope="request">

			<display:table id="timesheet" name="EmployeeList" 	class="displayTableClass" 
				requestURI="/timesheetreport.do?parameter=getEmployeeAttendanceInfo"
				decorator="com.centris.decorator.TimeSheetDecorator" pagesize="20">
				
				<display:column property="empid" title="Employee Id" sortable="true"
					class="cellintag" />
				<display:column property="empname" title="Employee Name"
					sortable="true" class="cellintag" />
				<display:column property="attendancedate" title="Attendence Date"
					sortable="true" />
				<display:column property="modifiedby" title="Modified by"
					sortable="true" />
				<display:column property="modifieddate" title="Modified Date"
					sortable="true" />
				<display:column property="viewbutton" title="View"
					sortable="true" />
				


			</display:table>

		</logic:present>
 
	</div>
		<div id="update-dialog" title="Employee TimeSheet Audit"
			style="font-size: 10px;">
	
			<form action="" name="TimesheetForm" id="TimesheetForm" action=""
				style="background-color: #FFFFFF;">
             <div  style=" text-align:center;font-size:20px; font-family:Segoe UI">Employee TimeSheet Audit</div>
				<br />
				<center>
					<table id="TimeSheetReporttable" >
				<tr>
				
					 <th></th>
					<th>INTIME</th>
					<th>OUTTIME</th>
					<th>TOTAL_HOURS</th>
					<th>WORKING_HOURS</th>
					<th>MOR_LATE</th>
					<th>EVE_EARLY</th>
					<th>LATETIME</th>
					<th>EARLYTIME</th>
					<th>UPDATED_BY</th>
					<th>UPDATED_TIME</th>
				
				</tr>	
				
				
					
			   <tr>
			   
			   <td id="prevoius">Previous</td>
			   <td><span id="prev_intime"></span></td>
			    <td><span id="prev_outtime"></span> </td>
			      <td><span id="prev_totalhours"></span> </td>
			        <td><span id="prev_workinghours"></span> </td>
			          <td><span id="prev_mor_late"></span> </td>
			            <td><span id="prev_eve_early"></span> </td>
			              <td><span id="prev_latetime"></span> </td>
			                <td><span id="prev_earlytime"></span> </td>
			                  <td><span id="prev_updated_by"></span> </td>
			                    <td><span id="prev_updated_time"></span> </td>
			                    
			    </tr>
			    
			    
			     <tr>
			   
			   <td id="current">Current</td>
			   <td><span id="curr_intime"></span></td>
			    <td><span id="curr_outtime"></span> </td>
			      <td><span id="curr_totalhours"></span> </td>
			        <td><span id="curr_workinghours"></span> </td>
			          <td><span id="curr_mor_late"></span> </td>
			            <td><span id="curr_eve_early"></span> </td>
			              <td><span id="curr_latetime"></span> </td>
			                <td><span id="curr_earlytime"></span> </td>
			                  <td><span id="curr_updated_by"></span> </td>
			                    <td><span id="curr_updated_time"></span> </td>
			    </tr>
			    
			    
			                   			   
			  
					
					</table>

					<br></br>
					<table align="center" >
						<tr>
							<td align="center">
								<p class="validateTips"
									style="font-size: 13px; color: red; font-family: Segoe UI;"></p>
								<html:errors />
							</td>
						</tr>
					</table>
				</center>

			</form>
		</div>

	
	
	
	
</body>
<br></br>
<br>
<br>
<br>
<br>
<br>
<br>
<hr>
<jsp:include page="footer.jsp"></jsp:include>
</html>
