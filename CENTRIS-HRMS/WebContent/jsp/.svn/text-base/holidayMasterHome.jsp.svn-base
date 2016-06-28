
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Holiday Master</title>
<link rel="stylesheet" type="text/css" href="view.css" />

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<!-- <script type="text/javascript" src="js/jquery.ui.core.js"></script> -->
<script type="text/javascript"
	src="/BIOTRACKER_SPECTRUM/JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="js/jquery.ui.position.js"></script>
<script type="text/javascript" src="js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="js/holidayMaster.js"></script>
<!-- <script type="text/javascript" src="js/employeeRegistration.js"></script> -->
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<!-- <link rel="stylesheet" href="css/weekoff.css"> -->
<link rel="stylesheet" type="text/css" href="view.css" />
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/HolidayMaster.css"></link>
</head>

<body >

	<center>
<div id="main">
	<br></br><br/> <br/>

<div class="background" id="backgroung">

		<div class="backgroundDiv" id="backgroung">Holiday Master</div></br>
		

		<form action="holidayMaster.do" name="HolidayMaster">
			<center>
						<div id="errordiv" class="error-box">
							
							<logic:present name="message" scope="request">
								<span style="color: green; font-family: Segoe UI;">
									<bean:write name="message"/>
								</span>
							</logic:present>
						</div>
						
						 <div  id="successmsg1" >
							<span id="success"></span>
						</div>	
			</center>

			<table id="biometric" width="15%">
				<tr>
					<td  >Department<font color="red">*</font>
							<br />
						<select id="department">
							<option value="">--Select--</option>
								
							<logic:present name="departmentlist" scope="session">
							
							<option value="all">All</option>
								
								<logic:iterate id="department" name="departmentlist" scope="session">
										<option
											value='<bean:write name="department" property="depId"  />'>
											<bean:write name="department" property="depName" />
										</option>
									</logic:iterate>
									</logic:present>

					</select></td>
					<td  >Year<font color="red">*</font></br>
						<select id="holidayyear">
							<option value="">--Select--</option>
							<logic:present name="yearlist" scope="request">
								
								<logic:iterate id="acdyear" name="yearlist" scope="request">
										<option
											value='<bean:write name="acdyear" property="year"  />'>
											<bean:write name="acdyear" property="year" />
										</option>
									</logic:iterate>
									</logic:present>
					</select><br /></td>
					
					<td><input type="button" id="searchholiday" class="submitbutton" value="Search" /></td>
						</tr>
			</table></br>
			
		
			 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="HOLCREATE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
			<%-- <input type="button" id="NewHoliday" class="submitbutton" value="NewHoliday" />
				<html:submit property="parameter"  styleClass="submitbutton">AddGroupHoliday</html:submit> --%>
				<input type="button" id="NewHoliday" class="submitbutton" value="Create Holiday" />
				<%-- <html:submit property="parameter"  styleClass="submitbutton" value="AddGroupHoliday">AddGroupHoliday</html:submit>  --%>
			 <input type="button" id="groupHolidayId" class="submitbutton" value="Create Group of Holidays"  onclick="return createGroupofHolidays()"/> 
				 </logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>

			


		</form>
		
		<div  class="tablecss" style="width:80%;margin:40px;">
	
		<center >

		

			<logic:present name="holidayMasterVOList" scope="request">
					<display:table id="data" name="requestScope.holidayMasterVOList"
						requestURI="holidayMasterdetails.do?method=deleteHolidayData"
						pagesize="20" cellpadding="5" cellspacing="5" size="20"
						style="bgcolor: RED;"
						decorator="com.centris.decorator.HolidayMasterDecorator">
						
						<display:column property="date" title="Date " 
							 />
							
						<display:column property="weekDay"
							></display:column>
						
						<display:column property="depName" title="Department"
							 />
							
						<display:column property="holidaysName" title="Holiday Reason"
						 />
							
						
							
							 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="HOLUPDATE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
							
						<display:column property="update" />
					
						
				 </logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>	
						
						 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="HOLDELETE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
						<display:column property="delete"
						 />
						 
						 	
				 </logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
							
					</display:table>
				</logic:present>

		</center>
		
		</div>
		
			</div>
		</div>

		<div id="update-dialog" title="Holiday Master">

			<form action="" name="ProjectRegistrationForm" id="ProjectRegistrationForm">

				<center>

					<br />

					<table id="parentReg" cellspacing="2" cellpadding="2">

						<tr>
							<td>Department</td>
							<td><select name="departmentval" id="departmentval">
								<option value="">--Select--</option>
								<logic:present name="departmentlist" scope="session">
								<option value="all">All</option>
								<logic:iterate id="department" name="departmentlist" scope="session">
										<option
											value='<bean:write name="department" property="depId"  />'>
											<bean:write name="department" property="depName" />
										</option>
									</logic:iterate>
									</logic:present>
							</select></td>
							<td>Year</td>
							<td><select id="holidayyearval">
									<option value="">--Select--</option>
									<logic:present name="yearlist" scope="request">
								
								<logic:iterate id="acdyear" name="yearlist" scope="request">
										<option
											value='<bean:write name="acdyear" property="year"  />'>
											<bean:write name="acdyear" property="year" />
										</option>
									</logic:iterate>
									</logic:present>
							</select><br /></td>
						</tr>
					</table>


					<table id="parentRegSecond">
						<tr>
							<td>Date</td>
							<td>Weekday</td>
							<td>Holiday Reason</td>
						</tr>

						<tr>
							<td><input type="text" name="date" id="date" value="" readonly="readonly" placeholder="Click here"/></td>
							<td><input type="text" name="weekday" id="weekday"readonly="readonly" value="" /></td>
							<td><input type="text" name="holiday" id="holiday" value="" /></td>
						</tr>
					</table>

			
						<center>
						
						 <div  id="successmsg" >
							<span id="fail"></span>
						</div>	
						
						
					   
						</center>
					</center>
			
			</form>
		</div>
	</center>

	<center>

		<div id="update-dialog1" title="Holiday Master"
			style="display: none; font-size: 10px;">

			<form action="" name="HolidayForm" id="holidayForm" action="">

				<br />
				<center>
					<table id="parentRegSecond">
						<tr>

							<td>Date</td>
							<td>Weekday</td>
							<td>Holiday Reason</td>
							
						</tr>

						<tr>

							<td><input type="text" name="date" id="date1" readonly="readonly" value="" /></td>

							<td><input type="text" name="weekday" id="weekday1" readonly="readonly" class="textBoxInDialog" value="" /></td>

							<td><input type="text" name="holiday" id="holiday1" value="" /></td>
						</tr>
					</table>
					
					<input type="hidden" id="deptidhidden" name="deptidhidden"/>
					
						<center>
						
						 <div  id="updatefail" >
							<span id="spanupdatefail"></span>
						</div>	
						</center>

					<br></br>
					
				</center>

			</form>
		</div>
	</center>

</body>
<br></br>

</html>