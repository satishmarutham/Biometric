<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Last Three Absent Report</title>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/common.css"></link>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="/JQUERY/js/jquery.ui.datepicker.js"></script>
<script language="javascript" src="js/common.js"></script>
<script language="javascript" src="js/LastThreeAbsentReport.js"></script>
</head>
<body>
	<br />
	<div class="background" id="backgroung">
		<center>
			<div class="backgroundDiv" id="backgroung" style="width: 100%">Last Three Absent Report</div>
			<div id="errordiv" class="error-box">
				<logic:present name="message" scope="session">
					<span style="color: green; font-family: Segoe UI;"> <bean:write
							name="message" />
					</span>
				</logic:present>
			</div>
		</center>
		<br /> <input id="hgroupId" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="group"/> </logic:present>' />
		<input id="hlocationId" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="location"/> </logic:present>' />
		<input id="hdate" type="hidden"
			value='<logic:present name="currentSearch" scope="request"><bean:write name="currentSearch" property="date"/> </logic:present>' />
	

		<form action="lastThreeAbsentReport.do"  method="post" id="lastThreeAbsentReportFormId">
			<input type="hidden" name="parameter" id="methodNameId"  value="getLastThreeAbsentReport"/>
			<input type="hidden" name="location" id="locId"/>
			<table id="biometric" align="center">
				<tr>
				<tr class="trc">
					<td align="left" class="trd">Select Group<font color="red">*</font><br/> <select
						name="group" id="groupId">
							<option value="">---Select Option---</option>
							<logic:present name="groupDetails" scope="session">
								<logic:iterate id="groupDetailId" name="groupDetails"
									scope="session">
									<option
										value="<bean:write name="groupDetailId" property="groupId"/>">
										<bean:write name="groupDetailId" property="groupName" />
									</option>
								</logic:iterate>
							</logic:present>

					</select>
					</td>
					<td align="left" class="trd">Select Location<font color="red">*</font><br/> 
					<select multiple="multiple"  id="locationId"> </select>
					</td>
					<td align="left" class="trd">Select Date<font color="red">*</font><br/> 
					 <input type="text" id="startdateId" name="date" readonly="readonly" placeholder="Click here"/>
					</td>
					
				</tr>

			</table>
			<br>
			<table align="center">
				<tr>
					<td><input type="button" value="Last Three Absent Report"
						class="submitbutton" id="lastThreeAbsentReport"
						onclick="return validations()" /></td>

				</tr>
			</table>



		</form>
			<div class="tablecss" style="margin: 15px; text-align: center"
			id="tableId">
			<logic:present  name="lastThreeAbsentMap" scope="request">
			<logic:iterate id="lastThreeAbsent" name="lastThreeAbsentMap" scope="request">
				<h3 class="accordHead" id="accordionCss">
					<bean:write name="lastThreeAbsent" property="key"  />
				</h3>
				<logic:notEmpty name="lastThreeAbsent" property="value">
				<div class="accBody">
				
					<table id="ACCLT" width="85%" class="tablecss">
				
						<tr class="HometblHeader">
							<th>Employee ID</th>
							<th>Employee Name</th>
							<th>Location</th>
							<th>Date</th>
							<th>Status</th>
						</tr>
					
						<logic:iterate name="lastThreeAbsent" property="value"
							id="lastAbsent">
							<tr>
								<td class="TblHometd"><bean:write
										name="lastAbsent" property="empId"
										 /></td>
										
										<td  class="TblHometd"><bean:write
										name="lastAbsent" property="empName"
										/></td>
										<td  class="TblHometd"><bean:write
										name="lastAbsent" property="location"
										 /></td>
										<td  class="TblHometd"><bean:write
										name="lastAbsent" property="date"
										 /></td>
										<td  class="TblHometd"><bean:write
										name="lastAbsent" property="status"
										 /></td> 
										 	
										
							
							</tr>
						</logic:iterate>
						
						
					</table>
				
				
				</div>
</logic:notEmpty>
			</logic:iterate>
		</logic:present>
		
		</div>
	</div>
</body>
</html>