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

<title>Day Report</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<script type="text/javascript" src="/JQUERY/js/jquery.ui.datepicker.js"></script>
<script language="javascript" src="js/NewDayReport.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<!-- <style type="text/css">

.present {
    width: 100px;
    height: 100px;
    background-color: #333;
}
.absent {
    width: 100px;
    height: 100px;
    background-color: #555;
}

</style> -->

</head>
<body>
<br/>
<div id="main">


	<logic:present name="dayReportTest"  scope="request">


				<input id="hgroupId" type="hidden" value='<bean:write name="dayReportTest" property="groupId"/>'/>
				<input id="hlocationId"   type="hidden" value='<bean:write name="dayReportTest" property="location"/>'/>
				<input id="hdesignationId" type="hidden" value='<bean:write name="dayReportTest" property="designation"/>'/>
				<input id="hemployeeId" type="hidden" value='<bean:write name="dayReportTest" property="employee"/>'/>
				<input id="hstartDate"   type="hidden" value='<bean:write name="dayReportTest" property="startDate"/>'/>
				<input id="hendDate" type="hidden" value='<bean:write name="dayReportTest" property="endDate"/>'/>
	</logic:present> 

<form name="DayReportForm" action="" id ="DayReport" style=" width: 100%; margin: 0 auto;" method="post">
   <input type="hidden" name="parameter" id="methodNameId">
    <input type="hidden" name="location" id="locId">
 
   				<div class="background" id="backgroung">
					<center>
						<div class="backgroundDiv" id="backgroung" style="width:100%">Attendance Report</div>
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

						<select name="groupId" id="groupId">
				<option value="">---Select Option---</option>
						<logic:present name="groupDetails" scope="session">
						<logic:iterate id="groupDetailId" name="groupDetails" scope="session">
						
						<option value="<bean:write name="groupDetailId" property="groupId"/>"><bean:write name="groupDetailId" property="groupName"/></option>
						</logic:iterate>
						</logic:present>
						
						</select>
					</td>


					<td align="left" class="trd">Select Location<font color="red">*</font><br />
							<select  id="locationId" multiple="multiple"></select>
					</td>
					<td align="left" class="trd">Designation Name<font color="red">*</font><br />

						<select name="designation" id="designationId">
							<option value="">---Select Option---</option>
							</select>
					</td>
					<td align="left" class="trd">Select Employee<font color="red">*</font><br />
							<select id="employeeId" name="employee">
						<option value="">---Select Option---</option>
							</select>
					</td>
				
					<td align="left" class="trd">Start Date<font color="red">*</font><br />
					 <input type="text" id="startdateId" name="startDate" readonly="readonly" placeholder="Click here"/>
				</td>
				
				
				
				
				<td align="left" class="trd">End Date<font color="red">*</font><br />
					 <input type="text" id="enddateId" name="endDate" readonly="readonly" placeholder="Click here"/>
				</td>
			</tr>

</table>

	
		<br>
		<table align="center">
		
		
		
		<tr>
		
			<td><input type="button" value="View Report" class="submitbutton" id="viewDayReportId" onclick="return validations()"/></td>
				  
				

	</tr>
		
		
		</table>
	
</center>


	
<center>

 <div class="tablecss" style="margin:40px;" id="tableId">

		
	 	<display:table name="requestScope.dayReportDetails" requestURI="/dayReportInfo.do" pagesize="50" export="false" class="tablecss">
	 			<display:column  property="locationName" sortable="false" title="Location"/>
	 			  <display:column  property="attendenceDate" sortable="false" title="Date (DD-MM-YYYY)"/>
 					<display:column  property="employeeId" sortable="false" title="Employee ID"/>
           	   		<display:column property="employeeName" sortable="false"  title="Employee Name" />
               		<display:column property="designation" sortable="false"  title="Designation" />
               		
					 <display:column  property="attendenceStatus" sortable="false" title="Status" decorator="com.centris.decorator.DayReportDecorator"/>
					<display:column property="inTime" sortable="false"  title="In-time" />
               		<display:column  property="outTime" sortable="false" title="Out-time"/>
           	   		<display:column property="lateTime" sortable="false"  title="Late-hours" />
					<display:column property="earlyTime" sortable="false"  title="Early-hours" /> 
               		 
    
				</display:table>	
		</div>
		<table><tr>
		<logic:present name="dayReportDetails" scope="request"> 
			<td><input type="button" value="Download PDF" class="submitbutton" id="downloadPdf" name="dayReportDetails" /></td>
			
			</logic:present>
			
			
			
			</tr>
			
			
				
		</table>
		
		
				</center>   
		</div>
   </form>
</body>

</html>
