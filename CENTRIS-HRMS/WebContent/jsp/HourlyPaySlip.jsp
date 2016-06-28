<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="view.css" />
<link rel="stylesheet" type="text/css" href="css/payslip.css" />

<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#address').html($('#payslipAddress').val());
	if($('#mailMessage').val()!=""){
		alert($('#mailMessage').val());
		$('#mailMessage').val("");
	}
});
function createPaySlip(){
	window.location.href="payRollProcess.do?method=getHourlyPaySlip";
}
function downloadPayslip(){
	window.location.href="payRollProcess.do?method=downloadPaySlip&paymentType=Hourly&EmpId="+$('#empId').text()+"&TimePeriod="+$('#month').text();
}
function sendPayslip(){
	window.location.href="payRollProcess.do?method=sendPaySlipToEmpMail&paymentType=Hourly&EmpId="+$('#empId').text()+"&TimePeriod="+$('#month').text()+"&EmailId="+$('#emailId').text();
}

</script>
</head>
<body>
<input type="hidden" id="payslipAddress" value='<bean:write name="EmployeePayData" property="payslipAddress"/>'/>
<input type="hidden" id="mailMessage" value='<logic:present name="sendMessage" scope="request"> <bean:write name="sendMessage"/></logic:present>'/>
<table style="border:none;"><tr><td>
<div><img src="<bean:write name="EmployeePayData" property="payslipImage"/>" align="left" height="200px" width="300px"></div></td></tr>
<tr><td>
<div id="address" style="color:blue;"></div>
</td></tr></table>
<table style="margin-top:10px;height:100px;">
<tr><td class="lblClass">Employee Id</td><td id="empId" class="valueClass"><bean:write name="EmployeePayData" property="empid"/></td><td  class="lblClass">PF No</td><td  id="empPF"  class="valueClass"><bean:write name="EmployeePayData" property="pfNo"/></td></tr>
<tr><td  class="lblClass">Name</td><td  id="empName"  class="valueClass"><bean:write name="EmployeePayData" property="empname"/></td> <td  class="lblClass">Time Period</td><td  id="month"  class="valueClass"><bean:write name="payRollSearch" property="startDate"/> - <bean:write name="payRollSearch" property="endDate"/></td></tr>
<tr><td  class="lblClass">Designation</td><td  id="empDesignation"  class="valueClass"><bean:write name="EmployeePayData" property="empdesignation"/></td> <td  class="lblClass">Email Id</td><td id="emailId"  class="valueClass"><bean:write name="EmployeePayData" property="empmail"/></td></tr>
<tr><td  class="lblClass">N.W.D</td><td  id="empWorkingDays"  class="valueClass"><bean:write  name="EmployeePayData" property="totalPresent"/></td><td  class="lblClass">N.H.P.D</td><td  id="empWorkingHour"  class="valueClass"><bean:write  name="EmployeePayData" property="hoursPerDay"/></td></tr>
<tr><td  class="lblClass">Hourly Pay Rate</td><td id="hourPayRate"  class="valueClass"><bean:write name="EmployeePayData" property="hourlyPayRate"/>   </td><td colspan="2"></td></tr>
</table>
<table style="margin-top:10px;height:50px;">
<tr><td  class="netSalaryClass" >Net Salary</td><td id="netSalary" align="right"><bean:write name="EmployeePayData" property="netSalary"/></td></tr>
</table>
<table style="font-size: 15px;color: blue;font-weight: bold;border: none;height: 100px;"><tr><td>
Note:<br/>
N.W.D means No. Of Working Days<br/>
N.H.P.D means No. Of Hours Per Day
</td></tr></table>

<table style="border:none;height: 30px;"> <tr><td align="center">
<input type="button" id="sendMail" class="button1" value="Send Mail" onclick="sendPayslip()"/><input type="button" id="saveEmployee" class="button1" value="Save" onclick="downloadPayslip()"/><input type="button" class="button1" id="nextEmployee" value="Next Employee" onclick="createPaySlip()" <logic:present name="disabledbutton"  scope="request"> <bean:write name="disabledbutton"/></logic:present>/></td>

</tr></table>
</body>
</html>