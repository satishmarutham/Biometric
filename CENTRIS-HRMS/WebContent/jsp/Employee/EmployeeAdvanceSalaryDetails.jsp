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
<title>Advance Salary Details</title>

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
<link rel="stylesheet" href="css/login/common.css">
<script language="javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/Employee/EmployeeAdvanceSalaryDetails.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

</head>
<body>
	<div id="main">

		<div class="background" id="backgroung">
			
			<center>
				<div class="backgroundDiv" id="backgroung" style="width: 100%">Advance Salary Details</div>
				<div id="errordiv" class="error-box" style="width: 19%">

					<logic:present name="message" scope="session">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="message" />
						</span>
					</logic:present>
				</div>
			</center>

<center>
	

			<form
				action="EmpDashBoardInManager.do?method=moreAdavanceSalaryDeatailsHome"
				 method="post">

				<center>
				
			<input id="hemiid" type="hidden" value='<logic:present name="hemiid" scope="request"><bean:write name="hemiid" /></logic:present>'/>
					
						<table id="biometric" align="center" width="50%">
							
							<tr class="trc">
							
							
								<td class="left">Select Month<font color="red">*</font><br/>
								
								<select name="month" id="month">
								<option value="">----select----</option>
								<option value="all">All</option>
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
							<td class="left">Select Year<font color="red">*</font><br/>
							<select id="accyear" name="year" style="width:100%;">
								<option value=" ">----select----</option>
									<logic:present name="accyear" scope="session">
										<logic:iterate id="accyear" name="accyear" scope="session">
											<option
												value='<bean:write name="accyear" property="accyearcode"/>'>
												<bean:write name="accyear" property="accyear" />
											</option>
										</logic:iterate>
									</logic:present>
							</select></td>
								

							</tr>

						</table>
			
					<input type="submit" value="Submit" class="submitbutton"
						id="viewDayReportId" onclick="return validations()" />
				</center>


			</form>
			<center>
				<div>


					<logic:present name="month" scope="request">

					<input type="hidden" id="currentstartdate" value="<bean:write name="month" />" />
					<input type="hidden" id="currentenddate" value="<bean:write name="year"/>" />
					

					</logic:present>

				</div>
				
			</center>

			<center>

	`		
				<logic:present name="EmployeeDetails" scope="request">

						<display:table id="employeeAdavanceSal" name="EmployeeDetails"
							export="false" class="view"
							requestURI="/EmpDashBoardInManager.do?method=moreAdavanceSalaryDeatailsHome"
							decorator="com.centris.decorator.AttendanceApprovelDecorator"
							pagesize="31">



							<display:column property="sno" title="SNO" />
							<display:column property="year" title="Year" />
							<display:column property="month" title="Month" />
							<display:column property="project" title="ProjectName" />
							<display:column property="requestedDate" title="Requested Date" />
							<display:column property="claimedAmount" title="Claimed Amount" />
							<display:column title=" CommentsBymanager">
							<textarea cols="25" rows="5" readonly="readonly">${employeeAdavanceSal.comments}
							</textarea>
							</display:column>
							<display:column property="approvedbydirector" title="ApprovedBy(Director)" />
							<display:column property="dirapprovedDate" title="Approved Date" />
							<display:column property="aprovedAmount" title="Approved Amount" />
							<display:column property="status" title="Approved Status" />
							<display:column property="approvedbyadmin" title="ApprovedBy(Accountant)" />
							<display:column property="adminApprovedDate" title="Approved Date" />
							<display:column property="adminStatus" title="Approved Status" />
							


						</display:table>

					</logic:present>
					
					

			</center>

			<!-- onClick='editattendence(this)' -->
			
			</center>
		</div>
		
	</div>

</body>
</html>