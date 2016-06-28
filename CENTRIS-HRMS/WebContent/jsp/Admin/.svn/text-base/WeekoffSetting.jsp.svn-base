<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Employee Amendment</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.position.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.menu.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="js/Admin/WeekoffSettings.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>

</head>
<body>
	<div id="main" class="background">

		<center>

			<div class="backgroundDiv" id="backgroung">Week off Settings</div>
		
					<div id="errordiv" class="error-box" align="center">

						<logic:present name="message" scope="session">
							<span style="color: green; font-family: Segoe UI;"> <bean:write
									name="message" />
							</span>
						</logic:present>
						
					</div>
	
			
			<form action="weekOffSetting.do?method=updateWeekoffSetting"
				name="weekoffSettingForm" method="post">
				<fieldset style="width: 80%;">
				<br>
					<table id="biometric" width="30%" cellpadding="3" cellspacing="0">
					<tr class="trc">
					<td id="searchbox" class="left">Search Employee
										</td>
										<td class="right">
										<input type="text" class="datePicker"
										id="emp" name="selectEmployee" placeholder="Search Employee Name" 
										value="<logic:present name="employeeDetails" property="empFirstName"><bean:write name="employeeDetails" property="empFirstName" />
															</logic:present>" />
									</td>
					</tr>
					
			</table>
			
				<br/>
			<table id="biometric"  width="50%" cellspacing="0">
    
						<tr class="trc">
							<td class="right">
							<input type="checkbox"
									id="sunday" name="sunday"/>&nbsp;&nbsp;&nbsp;Sunday</td>

								<td class="right"><input type="checkbox"
									id="monday" name="monday" />&nbsp;&nbsp;&nbsp;Monday</td>
								<td  class="right"><input type="checkbox"
									id="tuesday" name="tuesday"/>&nbsp;&nbsp;&nbsp;Tuesday</td></tr>
							<tr><td  class="right"><input type="checkbox"
									id="wednesday" name="wednesday" />&nbsp;&nbsp;&nbsp;Wednesday</td>
								<td class="right"><input type="checkbox" id="thrusday" name="thrusday" />&nbsp;&nbsp;&nbsp;Thrusday</td>
						<td class="right"><input type="checkbox"
									id="friday" name="friday" />&nbsp;&nbsp;&nbsp;Friday</td>
								
							</tr>
<tr>
<td  class="right"></td>

<td class="right"><input type="checkbox"
									id="saturday" name="saturday" />&nbsp;&nbsp;&nbsp;Saturday</td>
<td  class="right"></td>
</tr>
						</table>
						<br/>
						<input type="hidden" value="" name="empCode" id="empCodeId"/>
						
			<table id="biometric" width="60%" cellpadding="3" cellspacing="0">
					<tr class="trc">
					<td class="left">Holiday Calendar</td>
					<td class="right"><select id="holidaycalen" name="holidaycalen" >
					      <option value="">------Select------ </option></select> </td>
					<td class="left">Mapped Calendar</td>
					<td class="right"><input  type="text"	id="mappedcalen" name="mappedcalen" readonly="readonly" value="No Mapping Calendar"></input></td>
					<input type="hidden" name="mappedcalencode" id="mappedcalencode"></input>
					</tr>
					
				
					
			</table>
			<br/>
			
			<table>
				<tr class="odd">
				<td colspan="3"><center>
						
				 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="WEEKOFFSETTINGS" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				 
				 <input type="submit" class="submitbutton" value="Update" class="button1" id="register" onclick="return validateEmployeeCode();"/> &nbsp;&nbsp;&nbsp; 
				 <input type="button" value="Clear" class="submitbutton" id="clear" onclick="clearALL()" />
		
				 </logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
								
					</center>
				</td>
				</tr>
				
			</table>
							
							</fieldset>
							</form>
							
			</center></div>
			
</body>
</html>