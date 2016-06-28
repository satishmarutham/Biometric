<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Working Less Then 8 Hours</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/common.css"></link>
<script language="javascript" src="js/common.js"></script>
<script type="text/javascript" src="/JQUERY/js/jquery.ui.datepicker.js"></script>
<script language="javascript" src="js/EmpWorkingLessthan8hrsReport.js"></script>



</head>
<body>
<div id="main">
<form name="EmpWorkingLessThan8hrsReportForm" action="" id ="WorkingLess8HoursFormId" style=" width: 100%; margin: 0 auto;">
   <input type="hidden" name="parameter" id="methodNameId">
 
   				<div class="background" id="backgroung">
					<center>
						<div class="backgroundDiv" id="backgroung" style="width:106%">Working Less Then 8 Hours</div>
						<div id="errordiv" class="error-box" style="width: 19%">
							
							<logic:present name="message" scope="session">
								<span style="color: green; font-family: Segoe UI;">
									<bean:write name="message"/>
								</span>
							</logic:present>
						</div>
					</center>
<br />
<center>
	<table  id="biometric" align="center">
			<tr>

					<tr class="trc">
			
			<tr>
				<tr class="trc">
					<td align="left" class="trd">Select Group<font color="red">*</font><br />

						<select name="group" id="groupId">
				<option value="">---Select Option---</option>
						<logic:present name="groupDetails" scope="session">
						<logic:iterate id="groupDetailId" name="groupDetails" scope="session">
						<option value="<bean:write name="groupDetailId" property="groupId"/>"><bean:write name="groupDetailId" property="groupName"/></option>
						</logic:iterate>
						</logic:present>
						
						</select>
					</td>


					<td align="left" class="trd">Select Location<font color="red">*</font><br />

						<select name="location" id="locationId">
				<option value="">---Select Option---</option>
						
						</select>
					</td>
					<td align="left" class="trd">Select Shift<font color="red">*</font><br />

						<select name="shift" id="shiftId">
							<option value="">---Select Option---</option>
							</select>
					</td>
					<td align="left" class="trd">Select Employee<font color="red">*</font><br />
							<select id="employeeId" name="employee">
						<option value="">---Select Option---</option>
							</select>
					</td>
				
					<td align="left" class="trd">Start Date<font color="red">*</font><br />
					 <input type="text" id="startdateId" name="startDate" readonly="readonly" />
				</td>
				
				
				
				
				<td align="left" class="trd">End Date<font color="red">*</font><br />
					 <input type="text" id="enddateId" name="endDate" readonly="readonly"/>
				</td>
			</tr>

</table>

	
		<br>
		<table align="center">
		
		
		
		<tr>
		
			<td><input type="button" value="View Report" class="submitbutton" id="LessThen8hrsId"/></td>
				  
				

	<logic:present name="reportsData" scope="request">

		<tr>	<td><input id="hiddenemployeeId" type="hidden" value='<bean:write name="reportsData" property="employee"/>'/></td>
		<td><input id="hiddenstartDateId"   type="hidden" value='<bean:write name="reportsData" property="startDate"/>'/></td>
				<td><input id="hiddenendDateId" type="hidden" value='<bean:write name="reportsData" property="endDate"/>'/></td></tr>
	</logic:present>  
	</tr>
		
		
		</table>
	
</center>

	<br>

	
		<br>
	
<center>

  <div class="tablecss" style="margin:40px;" id="tableId">

		
	 	<display:table name="requestScope.workingLessThen8hrsList" requestURI="/lessthen8hrsinfo.do" pagesize="20" export="false" class="tablecss">
	 	
 					<display:column  property="employeeId" sortable="false" title="EmployeeId"/>
           	   		<display:column property="employeeName" sortable="false"  title="EmployeeName" />
               		<display:column  property="locationName" sortable="false" title="Location"/>
           	   		<display:column property="shiftName" sortable="false"  title="Shift" />
       <display:column  property="attendenceDate" sortable="false" title="AttendenceDate"/>
         <display:column  property="attendenceStatus" sortable="false" title="AttendenceStatus"/>
           	   		<display:column property="inTime" sortable="false"  title="Intime" />
               		<display:column  property="outTime" sortable="false" title="OutTime"/>
           	   		<display:column property="lateTime" sortable="false"  title="LateTime" />
					<display:column property="earlyTime" sortable="false"  title="EarlyTime" /> 
					 <display:column property="totalWorkinghours" sortable="false"  title="TotalWorkingHours" /> 
               		 
    
				</display:table>	
		</div> 
		<table><tr>
		 <logic:present name="workingLessThen8hrsList" scope="request"> 
			<td><input type="button" value="DownloadPdf" class="submitbutton" id="downloadPdflessThen8hrs" name="workingLessThen8hrsList" /></td>
			
			</logic:present>
			
			
			</tr>	
		</table>
		
		
				</center>   
		</div>
   </form>
</body>

</html>
