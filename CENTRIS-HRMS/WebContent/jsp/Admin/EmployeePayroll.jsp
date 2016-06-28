<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Payroll</title>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<script type="text/javascript" src="js/Admin/EmployeePayroll.js"></script>

</head>

<body>
	<br />
	<div class="background" id="backgroung">


<center>

<div id="successmessge" style="color: #000000;border-radius: 13px;font-family: Segoe UI;font-size: 14px;padding: 4px 13px;margin: 5px;color: green;background: white;border: 1px solid #f5aca6;width: 20%;height: 18px">
	
	</div>
	
</center>

		<form name="leave" id="leave" action="generatepayroll.do">
			<input type="hidden" value="generatePayroll" name="parameter"/>

			<center>
				<div class="backgroundDiv" id="backgroung">Payroll</div>
				<div id="errordiv" class="error-box" align="center">

					<logic:present name="addstatus" scope="request">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="addstatus" />
						</span>
					</logic:present>
					
						
					
				</div>
				
				
					<table cellpadding="5" cellspacing="2" id="biometric">

						<tr>

							<td class="left">Department<font color="red">*</font></td>
							<td class="right"><select id="department" name="department" style="width: 100%">

									<option value=" ">----select----</option>

									<logic:present name="departmentlist" scope="request">
									<option value="%%">All</option>
										<logic:iterate id="dept" name="departmentlist" scope="request">
											<option
												value='<bean:write name="dept" property="depId"/>'>
												<bean:write name="dept" property="depName" />
											</option>

										</logic:iterate>

									</logic:present>
							</select></td>
								<td class="left">Month<font color="red">*</font></td>
						<td class="right"><select id="month" name="month" style="width: 100%">
						<option value="">---Select---</option>
						<option value="01,January">January</option>
						<option value="02,February">February</option>
						<option value="03,March">March</option>
						<option value="04,April">April</option>
						<option value="05,May">May</option>
						<option value="06,June">June</option>
						<option value="07,July">July</option>
						<option value="08,August">August</option>
						<option value="09,September">September</option>
						<option value="10,October">October</option>
						<option value="11,November">November</option>
						<option value="12,December">December</option>
							</select></td>
							
						<td class="left">Year<font color="red">*</font></td>
						<td class="right"><select id="year" name="year">
						<option value="">---Select---</option>
						<option value="2014">2014</option>
						<option value="2015">2015</option>
						<option value="2016">2016</option>
						<option value="2017">2017</option>
						<option value="2018">2018</option>
						<option value="2019">2019</option>
						<option value="2020">2020</option>
							</select></td>
							
						</tr>
					</table>
				
				
				<input type="submit" value="Submit" class="submitbutton" onclick="return validate()" />


			</center>

		</form></br>
		
		<center>
			<logic:present name="payRollCurrentSearch"  scope="request">
				<fieldset style="width: 30%">
	 
	 <table id="searchinfo" style="width:80%; margin:0 auto; height:30px;border-spacing:0px; ">
	 
	  <tr style="background-color: #D1D9DF;height: 40px;font-weight: bold;">
	  
	  <td align="center" valign="top" colspan="12">Current Search</td></tr>
	  
	 <tr style="background-color: #D1D9DF;"> 
	 
	  <th align="right">Month: </th>
	  
	  
	  <td id="searchedmonth" colspan="5" name='<bean:write name="payRollCurrentSearch" property="monthName"/>'><bean:write name="payRollCurrentSearch" property="monthName"/></td> 
	  
	  <th align="right">Year: </th>
	  <td id="searchedyear" colspan="5" name='<bean:write name="payRollCurrentSearch" property="year"/>'> <bean:write name="payRollCurrentSearch" property="year"/>
	<input type="hidden" id="searchmonthint" class="searchmonthint" value="<bean:write name="payRollCurrentSearch" property="month"/>" />
	<input type="hidden" id="searchdept" class="searchdept" value="<bean:write name="payRollCurrentSearch" property="department"/>"/>
	
	
	  </td>   
	 
	 
	 
	  </tr>
	  </table>
	  </fieldset>
	
	</logic:present>
	</center>
		
		<input type="hidden" id="totvalues_onfocus" value="" />
		
		<div style="overflow:auto;width:1274px;padding-left: 23px" id="salaryDetails" class="tablecss" >
		
		<!--  <div  style="width:100%;"> -->
		<center>
		 
		 <logic:present name="EmployeePayroll" scope="request">
		
	 
		<display:table export="false" id="depRecords"  style="font-family: Segoe UI;width:100%;"  name="requestScope.EmployeePayroll" decorator="com.centris.decorator.GeneratePayrollDecorator">
			
			<display:column property="sno" title="SL No"  style="text-align:center;" sortable="false"  />
			<display:column property="epfNo" title="PF A/c" style="text-align:center;" sortable="false"  />
			<display:column property="esicode" title="Esi Code" style="text-align:center;" sortable="false"  />
			<display:column property="empId" title="Emp Id"        style="text-align:center;" sortable="false"  />
			<display:column property="empName"  title="Name"    style="text-align:left;width:750px;" sortable="false"/>
			<display:column property="emp_des" title="Designation" style="text-align:center;" sortable="false"/>
			<display:column property="emp_dept" title="Department" style="text-align:center;" sortable="false"/>
			
			 <display:column property="no_of_actual_days"   title="No Of Days"          style="text-align:center;" sortable="false"/>
			<display:column property="basicda_actual"     title="Basic+ DA"            style="text-align:center;" sortable="false"/>
			<display:column property="hra_actual"     title="HRA"            style="text-align:center;" sortable="false"/>
			<display:column property="convinience_actual" title="Convey" style="text-align:center;" sortable="false"/>
			<display:column property="medical_actual" title="Medical" style="text-align:center;" sortable="false"/>
			<display:column property="cca_actual" title="CCA" style="text-align:center;" sortable="false"/>
			<display:column property="special_allowances_actual"   title="Spl Allowences"          style="text-align:center;" sortable="false"/>
			<display:column property="variablepay_actual"   title="Variable Pay"          style="text-align:center;" sortable="false"/>
			<display:column property="totEarned_actual"  title="Total" style="text-align:center;" sortable="false"/>
			<display:column property="gross_actual"     title="Gross Salary"            style="text-align:center;" sortable="false"/>
			
			
			<display:column property="payable_days"     title="No Of Days"            style="text-align:center;" sortable="false"/>
			<display:column property="basicda_earned" title="Basic+ DA" style="text-align:center;" sortable="false"/>
			<display:column property="hra_earned" title="HRA" style="text-align:center;" sortable="false"/>
			<display:column property="convinience_earned"   title="Convey"          style="text-align:center;" sortable="false"/>
			<display:column property="medical_earned"   title="Medical"          style="text-align:center;" sortable="false"/>
			<display:column property="cca_earned"   title="CCA"          style="text-align:center;" sortable="false"/>
			<display:column property="special_allowances_earned"     title="Spl Allowences"            style="text-align:center;" sortable="false"/>
			<display:column property="variablepay_earned"     title="Variable Pay"            style="text-align:center;" sortable="false"/>
			<display:column property="totEarned_earned"     title="Total"            style="text-align:center;" sortable="false"/>
			<display:column property="gross_earned" title="Gross Salary" style="text-align:center;" sortable="false"/>
			
			<display:column property="pfempr_earned" title="EmprPf" style="text-align:center;" sortable="false"/>
			<display:column property="pfempy_earned"   title="EmpyPf"          style="text-align:center;" sortable="false"/>
			<display:column property="esiempr_earned"     title="EmprEsi"            style="text-align:center;" sortable="false"/>
			<display:column property="esiempy_earned"     title="EmpyEsi"            style="text-align:center;" sortable="false"/>
			<display:column property="ptax_earned"     title="Ptax"            style="text-align:center;" sortable="false"/>
			<display:column property="incometax_earned"     title="IncomeTax"            style="text-align:center;" sortable="false"/>
			<display:column property="advance_earned"     title="Advance"            style="text-align:center;" sortable="false"/>
			<%-- <display:column property="salaryAdvance"     title="Salary Advance"            style="text-align:center;" sortable="false"/>
			<display:column property="pendingSalary"     title="PendingSalary"            style="text-align:center;" /> --%>
			<display:column property="totdeduction_earned"     title="Total Deductions"            style="text-align:center;" sortable="false"/>
			<display:column property="takehome"     title="TakeHome"  style="text-align:center;" sortable="false"/>
			
			<display:column property="pendingSalary"     title="SalaryPending"  style="text-align:center;" sortable="false"/>
			<display:column property="salaryAdvance"     title="Advance Salary"  style="text-align:center;" sortable="false"/>
			
			<display:column property="netamount"     title="Net Pay"            style="text-align:center;" sortable="false"/>
			
			
		</display:table>
		
		</logic:present>
		</center>
	<!-- </div> -->
</div>

<div style="width:100%;text-align: center;margin-top:25px;">

	<logic:present name="EmployeePayroll" scope="request">
	<logic:notEmpty name="EmployeePayroll" scope="request">
	
		<input type="button" id="createPaySlipId" style="width:200px;height:50px;font-size: 15px;" class="button1" value="Save Data" onclick="saveSalarydetails()"/>
		<input type="button" id="fulldata" onclick="getPayrollReport()" value="Download Pdf" name="pdf" style="width:150px;height:30px;font-size: 13px;" class="button1 reportClass"></input>
		<input type="button" id="fulldataXLS" onclick="generatexls()" value="Download XLS" name="xls" style="width:150px;height:30px;font-size: 13px;" class="button1 reportClass"></input>
		<input type="button" id="createpayslip" value="Create Payslip" style="width:150px;height:30px;font-size: 13px;"></input>
	</logic:notEmpty>
		</logic:present>
	
</div>
</br>
	</div>

</body>



</html>
