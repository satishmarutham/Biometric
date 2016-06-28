<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Audit Report</title>
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

<script type="text/javascript" src="js/AuditReport.js"></script>

<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
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
		<span class="headingclss">Audit Report</span>
	</center>

	<form name="latecomersreport" action="auditreport.do">
		<input type="hidden" value="getAuditReport" name="parameter">
		<br />
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
						<logic:iterate id="shift" name="ALLSHIFTS" scope="request">
							<option value='<bean:write name="shift" property="shiftId"/>'>
								<bean:write name="shift" property="shiftName" />
							</option>
						</logic:iterate>
				</select></td>

				<td><label>Select Department <span style="color: red">
							*</span></label><br /> <select name="empdepartment" id="empdepartment"
					onchange="empDetails()">
						<option value="">----Select----</option>
						<option value="all">All</option>

						<logic:iterate id="DEPT" name="ALLDEPT" scope="request">
							<option value='<bean:write name="DEPT" property="deptId"/>'>
								<bean:write name="DEPT" property="deptName" />
							</option>
						</logic:iterate>

				</select></td>

				<td><label>Select Employee<span style="color: red">*</span></label><br />
					<select name="empname" id="empidval"  class="empClassForAdmin">
						<option value="">Select</option>
						<!-- <option value="all">All</option> -->
				</select></td>


				<td><label>From Date</label><br /> <input type="text" placeholder="Click here"
					id="datefrom" name="date" value="" readonly="readonly"></td>

				<td><label>To Date</label><br /> <input type="text" placeholder="Click here"
					id="dateto" name="todate" style="cursor: pointer;" value=""
					readonly="readonly"></td>

				<td><label>Filter</label><br /> <select name="filter"
					id="filter">
						<option value="">----Select----</option>
						<option value="ap">Absent to Present</option>
						<option value="pa">Present to Absent</option>

				</select></td>

				<td><input type="submit" value="search" class="button1"
					onclick="return validations()" /></td>



			</tr>
		</table>

	</form>
	<br>
	<br>

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

		<logic:present name="AUDITREPORTLIST" scope="request">

			<logic:present name="roleName" scope="session">


				<c:set var="user" value="Super Admin" />

				<c:if test="${ roleName== user}">
					<display:table id="AUDIT" name="AUDITREPORTLIST"
						class="displayTableClass" export="true"
						requestURI="/auditreport.do?parameter=getAuditReport"
						pagesize="10">
						
						<display:column property="empname" title="Employee Name"
					sortable="true" class="cellintag" />
				<display:column property="previous_status" title="Previous Status"
					sortable="true" />
				<display:column property="current_status" title="Current Status"
					sortable="true" />
				<display:column property="reason" title="Reason" sortable="true" />
				<display:column property="attendence_date" title="Attendence Date"
					sortable="true" />
				<display:column property="modifieddate" title="Modified Date"
					sortable="true" />
				<display:column property="modifiedby" title="Modified by"
					sortable="true" />

				<display:setProperty name="export.pdf.filename"
					value="AuditReport.pdf" />
				<display:setProperty name="export.pdf" value="true" />
				<display:setProperty name="export.excel.filename"
					value="AuditReport.xls" />
				<display:setProperty name="export.excel" value="true" />
				<display:setProperty name="export.csv.filename"
					value="AuditReport.csv" />
				<display:setProperty name="export.csv" value="true" />
				<display:setProperty name="export.xml.filename"
					value="AuditReport.xml" />
				<display:setProperty name="export.xml" value="true" />

			</display:table>
				</c:if>
			</logic:present>
			
			<logic:present name="roleName" scope="session">
				<c:set var="user1" value="Admin" />
				<c:set var="user2" value="HR-1" />
				<c:set var="user3" value="HR-2" />

				<c:if test="${ roleName== user1 || roleName== user2 || roleName== user3}">
					<display:table id="AUDIT" name="AUDITREPORTLIST"
						class="displayTableClass" export="false"
						requestURI="/auditreport.do?parameter=getAuditReport"
						pagesize="10">
						
							<display:column property="empname" title="Employee Name"
					sortable="true" class="cellintag" />
				<display:column property="previous_status" title="Previous Status"
					sortable="true" />
				<display:column property="current_status" title="Current Status"
					sortable="true" />
				<display:column property="reason" title="Reason" sortable="true" />
				<display:column property="attendence_date" title="Attendence Date"
					sortable="true" />
				<display:column property="modifieddate" title="Modified Date"
					sortable="true" />
				<display:column property="modifiedby" title="Modified by"
					sortable="true" />

				<display:setProperty name="export.pdf.filename"
					value="AuditReport.pdf" />
				<display:setProperty name="export.pdf" value="true" />
				<display:setProperty name="export.excel.filename"
					value="AuditReport.xls" />
				<display:setProperty name="export.excel" value="true" />
				<display:setProperty name="export.csv.filename"
					value="AuditReport.csv" />
				<display:setProperty name="export.csv" value="true" />
				<display:setProperty name="export.xml.filename"
					value="AuditReport.xml" />
				<display:setProperty name="export.xml" value="true" />

			</display:table>
			
				</c:if>
			</logic:present>


		
		</logic:present>

	</div>

</body>
<br></br>
<br>
<br>
<br>
<br>
<br>
<br>
<jsp:include page="footer.jsp"></jsp:include>
</html>
