<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Manager Mapping</title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript"	src="JQUERY/js/jquery.ui.datepicker.js"></script>
<!-- <script type="text/javascript"	src="/js/Admin/EmployeeManagerMappingDetails.js"></script> -->
<script type="text/javascript"	src="js/Admin/ManagerDirectorMapping.js"></script>
<script type="text/javascript"	src="js/Admin/EmployeeManagerMappingDetails.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

</head>
<body>

<div class="background" id="backgroung">
	<center>
	<div class="backgroundDiv" id="backgroung">Manager-Director Mapping</div><br/>
	</center>

	<center>
	 <div id="errordiv" class="error-box">
   </div>
     <div id="successdiv" class="error-box" style="display: none;">
	<span style="color: green; font-family: Segoe UI;" id="spanid"> </span>
   </div>
   </center>
	          
		<center>
		<form name="myform">
				
					<table>
					<tr>
                 
						<td align="center" colspan="3"><span><b>Select Director</b></span>
						
						<select style="width:180px;" id="director" name="director">
						<option value="">------select------</option>
						</select></td>
					</tr>
					<tr>
						<td valign="top"><span><b>Available Managers</b></span><br />
							<select id="original" multiple="multiple" size="10"
							style="width: 250px;height: 200px;font-size: 12px; font-family: Segoe UI;" >
						</select></td>
						<td style="font-size: 16px; font-family: Segoe UI;">
							<table border="0" style="font-size: 12px; font-family: Segoe UI;">
								<tr>
									<td><input type="button" name="placement" value="&gt;"
										onclick="addIndivudualtext();" style="width:50px;"></td>
								</tr>
								<tr>
									<td><input type="button" name="placement" value="&lt;"
										onclick="deselectIndivivdualData()" style="width:50px;"></input></td>
								</tr>
								<tr>
									<td><input type="button" onclick="deSelectData()"
										value="&lt;&lt;" style="width:50px;"></input></td>
								</tr>
								<tr>
									<td><input type="button" style="width:50px;" value="&gt;&gt;"
										onclick="addtext()"></td>
								</tr>
							</table>
						</td>
						<td><span><b>Mapped Managers</b></span><br /> 
						<select id="copy"  size="10" style="width: 250px;height: 200px;font-size: 12px; font-family: Segoe UI;" multiple="multiple" ></select></td>
					</tr>
				</table>
				
				
				
				 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="MGRDIRMAPPING" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				 
				 <input type="button" value="Map" name="Save" class="submitbutton" onclick="return assign();"/>
		
				</logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
				
				
				 
			
		
		</form>
	</center>
	</div>
</body>


</html>