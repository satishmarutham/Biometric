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
<title>EMPLOYEE PRODUCTIVITY REPORT</title>
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

<script type="text/javascript" src="js/ProductivityReport.js"></script>

<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link href="css/latecomersreport.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<jsp:include page="header_menu.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<div align="center"></div>

	<br>
	<center>
		<font
			style="font-family: sans-serif; font-weight: bolder; color: #000000; font-size: 17px;">EMPLOYEE
			PRODUCTIVITY REPORT</font>
	</center>
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

	<form name="latecomersreport" action="employeeProductivityReport.do">
		<input type="hidden" value="getEmployeeProductivityReport"
			name="parameter"> <br />
		<table id="biometric" align="center">
			<tr>
	<td class="USER_LOCATION">Select Location<br/>
					<select class="userLocationId" name="Location"></select>
				</td>
				<td><label>Select Shift</label><br /> <select name="shiftid"
					id="shiftid" onchange="empDetails()" class="shiftClassForAdmin">
						<option value="">----Select----</option>
						<option value="all">All</option>
						<logic:iterate id="shift" name="ALLSHIFTS" scope="request">
							<option value='<bean:write name="shift" property="shiftId"/>'>
								<bean:write name="shift" property="shiftName" />
							</option>
						</logic:iterate>
				</select></td>

				<td><label>Select Department </label><br /> <select
					name="empdepartment" id="empdepartment" onchange="empDetails()">
						<option value="">----Select----</option>
						<option value="all">All</option>

						<logic:iterate id="DEPT" name="ALLDEPT" scope="request">
							<option value='<bean:write name="DEPT" property="deptId"/>'>
								<bean:write name="DEPT" property="deptName" />
							</option>
						</logic:iterate>

				</select></td>

				<td><label>Select Employee</label><br /> <select
					name="empname" id="empidval"  class="empClassForAdmin">
						<option value="">Select</option>
				</select></td>


				<td><label>From Date</label><br /> <input type="text"
					id="datefrom" name="date" value="" readonly="readonly"></td>

				<td><label>To Date</label><br /> <input type="text"
					id="dateto" name="todate" style="cursor: pointer;" value=""
					readonly="readonly"></td>

				<td><input type="submit" value="search" class="button1"
					onclick="return validations()" /></td>

			</tr>
		</table>

	</form>
	<br>
	<br>



	<div class="" align="center">

		<logic:present name="EMPPRODUCTIVITYREPORT" scope="request">

			<display:table id="data" name="EMPPRODUCTIVITYREPORT"
				class="displayTableClass" export="true"
				requestURI="/employeeProductivityReport.do?parameter=getEmployeeProductivityReport"
				pagesize="20">

				<display:column property="attdate" title="Date" sortable="true"
					class="cellintag" />
				<display:column property="empid" title="Employee Id" sortable="true" />
				<display:column property="empname" title="Employee Name"
					sortable="true" />
				<%-- <display:column property="shiftname" title="Shift Name"
					sortable="true" />
				<display:column property="deptname" title="Department Name"
					sortable="true" /> --%>

				<display:column property="intime" title="In Time" sortable="true" />
				<display:column property="outtime" title="Out Time" sortable="true" />
				<display:column property="latetime" title="Late Time"
					sortable="true" />
				<display:column property="earlytime" title="Early Time"
					sortable="true" />

				<display:column property="workedtime" title="Worked Hours"
					sortable="true" />
				<display:setProperty name="export.pdf.filename"
					value="EMPPRODUCTIVITYREPORT.pdf" />
				<display:setProperty name="export.pdf" value="true" />
				<display:setProperty name="export.excel.filename"
					value="EMPPRODUCTIVITYREPORT.xls" />
				<display:setProperty name="export.excel" value="true" />
				<display:setProperty name="export.csv.filename"
					value="EMPPRODUCTIVITYREPORT.csv" />
				<display:setProperty name="export.csv" value="true" />
				<display:setProperty name="export.xml.filename"
					value="EMPPRODUCTIVITYREPORT.xml" />
				<display:setProperty name="export.xml" value="true" />


			</display:table>

		</logic:present>

	</div>

</body>
<br></br>
<br>

<hr></hr>
</html>
<jsp:include page="footer.jsp"></jsp:include>