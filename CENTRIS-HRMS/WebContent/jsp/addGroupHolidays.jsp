<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Holiday Master</title>
<link rel="stylesheet" type="text/css" href="view.css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<!-- <script type="text/javascript" src="/JQUERY/js/jquery.ui.core.js"></script> -->
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="js/addGroupHoliday.js"></script>
<!-- <script type="text/javascript" src="js/employeeRegistration.js"></script> -->
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

</head>
<body >

<br/> 
<br/>
<br />
	
<div align="center" id="main">
	<center>
	
	<div class="background" id="backgroung"><br></br>

		<div class="backgroundDiv" id="backgroung">Add Group Holiday</div><br></br>

			<form action="holidayMaster.do" name="HolidayMaster">
			<input type="hidden" value="addgroupHoliday" name="parameter" />


					<table id="parentReg" cellspacing="2" cellpadding="2">
						<tr>
							<td>Department</td>
							<td><select name="department" id="department">
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
							<td><select name="year" id="holidayyear">
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
					</table><br></br>
					
					<input type="button"value="Add" id="Add" class="submitbutton"></input>
					 <input type="button" id="RemoveHoliday" value="Remove" class="submitbutton"></input><br></br>
				

					<table id="parentRegSecond" bgcolor="#B2C5CB">
						<tr>
							<th><input type="checkbox" name="selectall" id="chk" /></th>
							<th>Date</th>
							<th>Weekday</th>
							<th>Holiday Reason</th>
						</tr>

						<tr>
							<td><input type="checkbox" name='selectcheckbox' id="chk"/></td>
							<td><input type="text" name="date"  class="groupDate" value="" placeholder="Click here"/></td>
							<td><input type="text" name="weekday" id="alternate"readonly="readonly" value=""/></td>
							<td><input type="text" name="holiday" id="holiday"value="" /></td>
							
						</tr>
					</table>

				<br></br>
				
				<center>
						<div id="errordiv" class="error-box">
							
							<logic:present name="message" scope="request">
								<span style="color: green; font-family: Segoe UI;">
									<bean:write name="message"/>
								</span>
							</logic:present>
						</div>
			</center>
					
							<input type="submit" value="Create Group Holidays" Id="CreateHolidayList" Class="submitbutton" /> 
							<input type="reset" value="Clear" class="submitbutton"></input>
							<input type="button" value="Go Back"  class="submitbutton" onclick="goBack()"></input>
					
						<br></br>

			</form>
		</div>
	</center>
	
	</div>


	
</body>
</html>