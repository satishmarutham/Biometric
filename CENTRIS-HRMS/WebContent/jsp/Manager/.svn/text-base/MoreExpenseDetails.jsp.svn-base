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
<title>Expense Details</title>

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
<script type="text/javascript"	src="js/Manager/MoreExpenseDetails.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
</head>
<body>
	<div id="main">
	
	<div id="loader"
		style="position: absolute; top: 20%; left: 60%; display: none; ">
		<img src="images/loaderimage2.GIF" width="150px" height="150px" />
	</div>

		<div class="background" id="backgroung">
			<center>
				<div class="backgroundDiv" id="backgroung" style="width: 100%">
					Expense Details</div>
				<div id="errordiv" class="error-box" style="width: 19%">
					<span style="color: red; font-family: Segoe UI;"
						id="successMessage"> </span> 
						
						<logic:present name="successMessage" scope="request">
							<span style="color: green; font-family: Segoe UI;"> <bean:write
									name="successMessage" />
							</span>
						</logic:present>
						<logic:present name="errorMessage" scope="request">
							<span style="color: red; font-family: Segoe UI;"> <bean:write
									name="errorMessage" />
							</span>
						</logic:present>
						
				</div>
				<div id="successdiv" class="success-box" style="width: 20%">
					<span style="color: green; font-family: Segoe UI;"
						id="successMessage"> </span> 
				</div>
			</center>
           <form action="EmpDashBoardInManager.do" method="post">
              <input type="hidden" value="moreExpenseDeatails" name="method"/>
           
				<center>
					<fieldset style="width: 80%;"><br/>
							<table cellpadding="5" cellspacing="0" id="biometric" align="center" >
							
							<tr class="trc">
								<td  class="left">Select Month<font color="red">*</font></td>
									<td class="right">
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
								<td class="left">Select Year<font color="red">*</font></td>
								<td class="right">
									<select name="year" id="year" class="year_val"><option
											value="">-----Select---------</option>
										<logic:present name="ACC_YEAR" scope="request">
											<logic:iterate id="year" name="ACC_YEAR">
												<option value='<bean:write name="year" />'>
													<bean:write name="year" />
												</option>
											</logic:iterate>
										</logic:present></select>
								</td>
								<input type="hidden" value='<logic:present name="empId" scope="request"><bean:write name="empId" scope="request"/></logic:present>' name="employeeId"></input>
							</tr>
							
						</table><br/>
						
					<input type="submit" value="View Expense Details"
									class="submitbutton" id="viewExpenseDetailsId" onclick="return validation()" />
						
					</fieldset>
				</center>
		</form>		
		
				<logic:present name="month" scope="request">

					<input type="hidden" id="currentstartdate" value="<bean:write name="month" />" />
					<input type="hidden" id="currentenddate" value="<bean:write name="yearVal"/>" />
					

					</logic:present>

	
				
		
			
			</fieldset>

			<center>

				<logic:present name="employeeClaimesList" scope="request">
		
						<display:table id="employeeClaimes" name="employeeClaimesList"
							export="false" class="view"
							requestURI="/employeeDashboard.do?method=moreExpensesDeatailsHome"
							decorator="com.centris.decorator.AttendanceApprovelDecorator"
							pagesize="31">

							<display:column property="sno" title="SNO" />
							<display:column property="year" title="Year" />
							<display:column property="month" title="Month" />
							<display:column property="approvedManger" title="Requested To"></display:column>
							<display:column property="localconveyance" title="Local Conveyance" />
							<display:column property="travelexpenses" title="Travel Expenses" />
							<display:column property="staffwelfare" title="Staff Welfare" />
							<display:column property="telephoneexp" title="Telephone Expenses" />
							<display:column property="purchases" title="Purchases" />
							<display:column property="otherworkexp" title="OtherWork Expenses" />
							<display:column property="mislanious" title="Mislanious" />
							<display:column property="claimedamount" title="Claimed Amount" />
							<display:column property="approvedamount" title="Approved Amount" />
							<display:column property="managerapprovedDate" title="Approved Date" />
							<display:column property="status" title="Approved Status"></display:column>
							<display:column property="approvedDirector" title="ApprovedBy (Director)" />
							<display:column property="directorapproveddate" title="Approved Date" />
							<display:column property="direbalamount" title="Approved Amount" />
							<display:column property="isdirectorApproved" title="Approved Status" />
							<display:column property="approvedAdmin" title="ApprovedBy (Accountant)" />
							<display:column property="adminapproveddate" title="Approved Date" />
								<display:column property="accounttantbalamount" title="Approved Amount" />
							<display:column property="isadminapproved" title="Approved Status" />
							


						</display:table>
								
					

					</logic:present>
			
			</center><br/><br/>
			</div>
		<br/>
	</div>
		
</body>
</html>