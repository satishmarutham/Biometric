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
<title>Expense Consolidated Approval</title>

<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<script type="text/javascript"
	src="js/Admin/ExpenseApprovelByAdmin.js"></script>
<style type="text/css">
#emp_Expence th:nth-child(23) {
	display: none;
}

#emp_Expence th:nth-child(24) {
	display: none;
}

#emp_Expence td:nth-child(23) {
	display: none;
}

#emp_Expence td:nth-child(24) {
	display: none;
}
</style>
</head>
<body>


	<div id="main">
	
	<div id="loader"
		style="position: absolute; top: 40%; left: 70%; display: none; ">
		<img src="images/loaderimage2.GIF" width="150px" height="150px" />
	</div>

		<div class="background" id="backgroung">
			<center>
				<div class="backgroundDiv" id="backgroung" style="width: 100%">Monthly
					Consolidated Expense Report</div>
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

			<form
				action="managerExpenseDetails.do?method=getEmployeeExpenseDetails"
				method="post">

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
								
							</tr>
							
						</table><br/>
						
					<input type="submit" value="View Expense Details"
									class="submitbutton" id="viewExpenseDetailsId" />
						
					</fieldset>
				</center>
			</form>
			<logic:present name="consolidated_ExpenseDetails" scope="request">
				<div class="tablecss" style="width: 80%; margin: 5px;">

					<display:table id="emp_Expence"
						name="requestScope.consolidated_ExpenseDetails"
						class="displayTableClass"
						requestURI="/managerExpenseDetails.do?method=getEmployeeExpenseDetails"
						pagesize="10"
						decorator="com.centris.decorator.ManagerExpenseDetailsDecorator">
						<display:column property="emp_slno" title="Sl no" />
						<display:column property="bioid" title="Employee ID" />
						<display:column property="emp_Name" title="Employee Name" />
						<display:column property="emp_designation" title="Designation" />
						<display:column property="emp_contact" title="Contact No" />
						<display:column property="emp_mangName" title="Manager Name" />
						<display:column property="directorName" title="Director Name" />
						<display:column property="emp_local" title="Local Conveyance" />
						<display:column property="emp_travel" title="Travel Expence" />
						<display:column property="emp_staff" title="Staff Welfare" />
						<display:column property="emp_telephone" title="Telephone" />
						<display:column property="emp_purchase" title="Purchase" />
						<display:column property="emp_other" title="Other Work" />
						<display:column property="emp_miscellaneous" title="Miscellaneous" />
						<display:column property="emp_total" title="Total Expence" />
					<%-- 	<display:column property="emp_totapproved" title="Total Approved" />
						<display:column property="emp_advpaid" title="Advance Paid" />
						<display:column property="emp_balance" title="Balance" />
						<display:column property="approve" title="Approve" /> --%>
						<display:column property="totalApproved" title="Total Approved"/>
						<display:column property="advancePaid" title="Advance Paid" />
						<display:column property="balance" title="Balance" />
						<display:column property="approve" title="Approve" />
						<display:column property="reject" title="Reject" />
						<display:column property="download" title="Download" />
						<display:column property="emp_mangCode" title="Manager ID" />
							<display:column class='expenseCode'><input type="hidden" class="hexpenceCode" value="<bean:write name="emp_Expence" property="emp_expCode" />"/></display:column>
					</display:table>

				</div>
			</logic:present>
			<br />
			<logic:present name="download" scope="request">
				<center>
					<input type="submit" value="Download Expense Details"
						class="submitbutton" id="downloadExpenseDetails"
						onclick="return validations()" />
						
					<input type="button" value="Approve All Expenses"  id="approveAll"  class="submitbutton"/>
				</center>
			</logic:present>
		</div>
		<input type="hidden" id="sel_year"
			value="<logic:present name="sel_year" scope="request">
						 <bean:write
								name="sel_year" />
					</logic:present>">
		<input type="hidden" id="sel_month"
			value="<logic:present name="sel_month" scope="request">
						 <bean:write
								name="sel_month" />
					</logic:present>">
	</div>
</body>
</html>