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

<title>Yearly Report</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<script type="text/javascript" src="/JQUERY/js/jquery.ui.datepicker.js"></script>
<script language="javascript" src="js/YearlyReport.js"></script>
<link rel="stylesheet" href="css/common.css"></link>


</head>
<body>
<br/>
<div id="main">
<form name="YearlyReportForm" action="" id ="YearlyReport" style=" width: 100%; margin: 0 auto;">
   <input type="hidden" name="parameter" id="methodNameId">
 
   				<div class="background" id="backgroung">
					<center>
						<div class="backgroundDiv" id="backgroung" style="width:100%">Yearly Report</div>
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
				
				
					 <td>Start Month<br /> <select id="startmonthId" name="startmonth">
							<option value="">---Select Option---</option>
							<option value="01">January</option>
							<option value="02">February</option>
							<option value="03">March</option>
							<option value="04">April</option>
							<option value="05">May</option>
							<option value="06">June</option>
							<option value="07">July</option>
							<option value="08">August</option>
							<option value="09">September</option>
							<option value="10">October</option>
							<option value="11">November</option>
							<option value="12">December</option>

					</select>
					</td>
				
				
				
				
				 <td>End Month<br /> <select id="endmonthId" name="endmonth">
							<option value="">---Select Option---</option>
							<option value="01">January</option>
							<option value="02">February</option>
							<option value="03">March</option>
							<option value="04">April</option>
							<option value="05">May</option>
							<option value="06">June</option>
							<option value="07">July</option>
							<option value="08">August</option>
							<option value="09">September</option>
							<option value="10">October</option>
							<option value="11">November</option>
							<option value="12">December</option>

					</select>
					</td>
					<td>Year<br /> <select id="yearId" name="year">
							<option value="">---Select Option---</option>
							<option value="2013">2013</option>
							<option value="2014">2014</option>
							<option value="2015">2015</option>
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
					</select>
					</td>
			</tr>

</table>

	
		<br>
		
					
		<table align="center">
		
		
		
		<tr>
		
			<td><input type="button" value="View Report" class="submitbutton" id="viewYearlyReportId"/></td>
				  
				

 <logic:present name="yearlyReportFormList" scope="request">

		<tr><td><input id="hiddenemployeeId" type="hidden" value='<bean:write name="yearlyReportFormList" property="employee"/>'/></td>
		<td><input id="hiddenstartmonthId"   type="hidden" value='<bean:write name="yearlyReportFormList" property="startmonth"/>'/></td>
		<td><input id="hiddenendmonthId" type="hidden" value='<bean:write name="yearlyReportFormList" property="endmonth"/>'/></td>
		<td><input id="hiddenyearId" type="hidden" value='<bean:write name="yearlyReportFormList" property="year"/>'/></td></tr>
	</logic:present>  
	</tr>
		
		
		</table>
	
</center>





<%-- 
<div class="tablecss" style="margin:40px;" id="tableId"> -->



	 	<display:table name="requestScope.yearlyReportPojos" requestURI="/yearlyReportinfo.do" pagesize="20" export="false" class="tablecss">

	 	<display:column  property="monthName" sortable="false" title="Month"/>
	 		
			  			
 					<display:column  property="employeeId"  sortable="false" title="Employee ID"/>
 					
 					
           	   		<display:column property="employeeName" sortable="false"  title="Employee Name" />
               		<display:column  property="locationName" sortable="false" title="Location"/>
           	   		<display:column property="presents" sortable="false"  title="Present" />
           	   		  <display:column  property="absents" sortable="false" title="Absents"/>
               		<display:column  property="holidays" sortable="false" title="Holidays"/>

               		<display:column property="holidayPayable" sortable="false"  title="HolidayPayable" />
               		<display:column  property="weekOffs" sortable="false" title="WeekOff"/>
               		<display:column property="weekoffPayable" sortable="false"  title="WeekoffPayable" />
           	   		<display:column property="casualLeaves" sortable="false"  title="CasualLeaves" />
					 
				
               		 <display:column  property="payableLeaves" sortable="false" title="PayableLeaves"/>
<display:column property="sickLeaves" sortable="false"  title="SickLeaves" /> 

          		 <display:column  property="otherLeaves" sortable="false" title="OtherLeaves"/>
         <display:column property="totalLeaves" sortable="false"  title="TotalLeaves" />   
  		
				</display:table>
				
	
					</div>  --%>
		
	
		
				
			 
				<logic:present name="yearlyReportPojos" scope="request">
		
		<logic:iterate id="yearlyReportPojosId" name="yearlyReportPojos" scope="request">
				
		<!-- <table  class="biometric" align="center" style="width: 100%;height: 50%"> -->
		<div class="tablecss" style="margin:40px;" id="tableId">
		<table><tr><td>
		

			<span style="color:#299DFF;font-weight: bold;">Employee Id:</span><bean:write name="yearlyReportPojosId" property="key"/></td>
		 <logic:notEmpty name="yearlyReportPojosId" property="value">
				<logic:iterate name="yearlyReportPojosId" property="value" id="dataList" length="1">
<td> <span style="color:#299DFF;font-weight: bold;">EmployeeName:</span><bean:write name="dataList" property="employeeName" /></td>
				
					</logic:iterate>
					</logic:notEmpty>
				
				<logic:notEmpty name="yearlyReportPojosId" property="value">
				<logic:iterate name="yearlyReportPojosId" property="value" id="dataList" length="1">
<td><span style="color:#299DFF;font-weight: bold;">Location:</span><bean:write name="dataList" property="locationName" /></td></tr>
				
					</logic:iterate>
					</logic:notEmpty>
				
						<tr class="trc">
						<th>Month</th>
						
							
							<th>Present</th>
							<th>Absent</th>
								<th>Holidays</th>
								<th>HolidayPayable</th>
								<th>WeekOff</th>
								<th>WeekoffPayable</th>
								<th>CasualLeaves</th>
								<th>PayableLeaves</th>
								<th>SickLeaves</th>
								<th>TotalLeaves</th>

							</tr>
					<logic:empty name="yearlyReportPojosId" property="value">
						      <span style="color: green">No data Found</span>
						</logic:empty>
						 <logic:notEmpty name="yearlyReportPojosId" property="value">
			
						<logic:iterate name="yearlyReportPojosId" property="value" id="dataList">
					
					 <tr ><td><bean:write name="dataList" property="monthName" /></td>
								
								
								 <td><bean:write name="dataList" property="presents" /></td>
								 <td><bean:write name="dataList" property="absents" /></td>
								 <td><bean:write name="dataList" property="holidays" /></td>
								 <td><bean:write name="dataList" property="holidayPayable" /></td>
								 <td><bean:write name="dataList" property="weekOffs" /></td>
								 <td><bean:write name="dataList" property="weekoffPayable" /></td>
								 <td><bean:write name="dataList" property="casualLeaves" /></td>
								 <td><bean:write name="dataList" property="weekoffPayable" /></td>
								 <td><bean:write name="dataList" property="otherLeaves" /></td>
								 <td><bean:write name="dataList" property="totalLeaves" /></td>
								</tr> 
						</logic:iterate>
				</logic:notEmpty> 
				</table>
					</div>
	 	</logic:iterate>
	 		<table><tr>

<!-- <td><input type="button" value="Download PDF" class="submitbutton" id="downloadPdf"/></td>  -->
		
		 	
			 
			</tr>
			
			
				
		</table> 
					</logic:present>
					  
				</div>  
				 </form>
				<!--  <input type="button" value="Download PDF" class="submitbutton"/> -->
		</div>
		
  
</body>

</html>
