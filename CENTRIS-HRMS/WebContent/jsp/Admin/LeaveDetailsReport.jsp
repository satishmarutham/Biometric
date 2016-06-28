<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page language="java" trimDirectiveWhitespaces="true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave details Report</title>
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
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
<script type="text/javascript" src="js/Admin/LeaveDetails.js"></script>
</head>

<style type="text/css">
.displayTableFrame {
	background-color: white;
	overflow-x: hidden;
	height: 350px;
	width: 100%;
}

.view {
	text-decoration: none;
	border: 1px solid #bbb;
	width: 100%;
}

.view th {
	padding: 1px 2px 1px 2px !important;
	text-align: center;
	border-spacing: 0px;
}

.view td {
	padding: 1px 2px 1px 2px !important;
}

.view thead tr {
	position: relative;
	height: 15px;
	background-color: #C8C8C8;
	color: black;
	font-weight: bold;
}

.view tbody {
	height: 240px;
	overflow-x: hidden;
}

.view tbody tr {
	width: inherit;
	height: auto;
	white-space: nowrap;
	height: auto;
}

.view tbody tr.odd {
	background-color: #eee
}

.view tbody tr.tableRowEven,tr.even {
	background-color: #ddd
}

.view tbody tr td:last-child {
	padding-right: 1px;
}

.view tbody td {
	padding: 1px 2px 1px 2px !important;
}

.view .order1 {
	background-position: right 50%;
	background-repeat: no-repeat
}

.view .order2 {
	background-position: right 50%;
	background-repeat: no-repeat
}
</style>

<body>

	<div class="background" id="backgroung">

		<center>
			<div class="backgroundDiv" id="backgroung">Leave Details</div>
			<br/>
			
				<div id="errordiv" class="error-box" align="center">

					<logic:present name="message" scope="request">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="message" />
						</span>
					</logic:present>
				</div>

			<form action="leavedetailsreport.do" name="leavereport" method="post">
			
			<input type="hidden" value="Submit" name="parameter" />
		
			<fieldset style="width: 85%;">
					<table id="biometric" cellspacing="5" cellpadding="8" width="60%">
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

						
						</tr>
					</table>
				</fieldset>

			<input type="submit" value="Submit" class="submitbutton" id="submitbtn"  onclick="return validations()" /><br/>
			
			<input id="hempId" type="hidden" value='<logic:present name="hEmpId" scope="request"><bean:write name="hEmpId"/> </logic:present>' />
 <input id="hdepId" type="hidden" value='<logic:present name="hDepId" scope="request"><bean:write name="hDepId"/> </logic:present>' />
 <input id="hmgrId" type="hidden" value='<logic:present name="hMgrId" scope="request"><bean:write name="hMgrId"/> </logic:present>' />
				
					
			</form>
	
		<div align="center" id="main" >
	
		<logic:present name="LEAVE_LIST" scope="request">
	<div class='displayTableFrame'>

			<display:table id="leaveid" name="LEAVE_LIST" class="view"
				 export="false" requestURI="leavedetailsreport.do?parameter=Submit"  style="width:90%;">
		
				
				<display:column property="empid" title="Id" class="cellintag" />
				<display:column property="status" title="Status"/>
				<display:column property="empname" title="Employee Name"/>
				<display:column property="doj" title="DOJ"/>
				<display:column property="jan" title="Jan"/>
				<display:column property="feb" title="Feb"/>
				<display:column property="mar" title="Mar"/>
				<display:column property="aprl" title="Aprl"/>
				<display:column property="may" title="May"/>
				<display:column property="june" title="June"/>
				<display:column property="july" title="July"/>
				<display:column property="aug" title="Aug"/>
				<display:column property="sep" title="Sep"/>
				<display:column property="oct" title="Oct"/>
				<display:column property="nov" title="Nov"/>
				<display:column property="dec" title="Dec"/>
				<display:column property="balance" title="Balance as on"/>
				
				
				<display:setProperty name="export.pdf.filename" value="Project.pdf" />
				<display:setProperty name="export.pdf" value="true" />
				<display:setProperty name="export.excel.filename" value="Project.xls" />
				<display:setProperty name="export.excel" value="true" />
				<display:setProperty name="export.csv.filename" value="Project.csv" />
				<display:setProperty name="export.csv" value="true" />
				<display:setProperty name="export.xml.filename" value="Project.xml" />
				<display:setProperty name="export.xml" value="true" />

			</display:table>
			</div>
			
			<logic:notEmpty name="LEAVE_LIST" scope="request">

					<table>
						<tr>
							<td><input type="button" id="downloadPdf" value="DownloadPdf" class="submitbutton"></input></td>
							<td><input type="button" id="downloadExcel" value="DownloadExcel" class="submitbutton"></input></td>
							<%-- <html:submit value="DownloadPdf" property="parameter" styleClass="submitbutton"></html:submit></td>
							<td><html:submit value="DownloadExcel" property="parameter" styleClass="submitbutton"></html:submit></td> --%>

						</tr>
					</table>

				</logic:notEmpty>

		</logic:present>
		<br>
		</div>
			
		
</center>
	</div>
	<!-- </div> -->


</body>
</html>