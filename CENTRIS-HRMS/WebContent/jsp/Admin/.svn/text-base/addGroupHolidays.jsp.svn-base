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
<!-- <link rel="stylesheet" type="text/css" href="view.css" /> -->
<!-- <script type="text/javascript" src="/JQUERY/js/jquery.ui.core.js"></script> -->
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<script type="text/javascript" src="js/Admin/addGroupHoliday.js"></script>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>

</head>
<body >

<br/> 


	
<div align="center" id="main">
	<center>
	
	<div class="background" id="backgroung">

		<div class="backgroundDiv" id="backgroung">Add Group Holiday</div>

			<form action="holidayMaster.do" name="HolidayMaster">
			<input type="hidden" value="addgroupHoliday" name="parameter" />

      <fieldset style="width: 75%;">
          <br/>
					<table id="biometric" cellspacing="0" cellpadding="5" width="40%;">
						<tr>
							<td class="left">Client Name<font color="red">*</font></td>
							<td class="right"> <select id="clientaddId"  name="client">
										<option value="">--Select--</option>
										<logic:present name="clientList" scope="session">

											<logic:iterate id="clientId" name="clientList" scope="session">
												<option
													value='<bean:write name="clientId" property="clientCode"  />'>
													<bean:write name="clientId" property="clientName"/>
												</option>
											</logic:iterate>
										</logic:present>
								</select><br /></td>
						</tr><tr>	
							<td class="left" >Year</td>
							<td class="right"><select name="year" id="holidayyear"  class="holidayyear" style="width:150px !important;">
									<option value="">--Select--</option>
									<logic:present name="yearlist" scope="request">
								
								<logic:iterate id="acdyear" name="yearlist" scope="request">
										<option
											value='<bean:write name="acdyear" property="accademicYearCode"  />'>
											<bean:write name="acdyear" property="year" />
										</option>
									</logic:iterate>
									</logic:present>
							</select><br /></td>

						</tr>
					</table><br/>
					</fieldset>
					<center>
						<div id="errordiv" class="error-box">
							
							<logic:present name="message" scope="request">
								<span style="color: green; font-family: Segoe UI;">
									<bean:write name="message"/>
								</span>
							</logic:present>
							<logic:present name="errorMessage" scope="request">
								<span style="color: red; font-family: Segoe UI;">
									<bean:write name="errorMessage"/>
								</span>
							</logic:present>
							
						</div>
			</center>
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
							<td><input type="text" name="date" id="groupDate" class="groupDate" value="" placeholder="Click here" style="font-size: 12px !important; padding: 2px !important; width: 157px !important; height: 21px !important;"/></td>
							<td><input type="text" name="weekday" id="alternate" readonly="readonly" value="" style="font-size: 12px !important; padding: 2px !important; width: 157px !important;background-color: #fff !important; height: 21px !important; "/></td>
							<td><input type="text" name="holiday" id="holiday"value=""  style="font-size: 12px !important; padding: 2px !important; width: 157px !important; height: 21px !important;"/></td>
							
						</tr>
					</table>

				<br></br>
				
				
					
							<input type="submit" value="Create Group Holidays" Id="CreateHolidayList" Class="submitbutton"  onclick="return validations();"/> 
							<input type="reset" value="Clear" class="submitbutton"></input>
							<input type="button" value="Go Back"  class="submitbutton" onclick="goBack()"></input>
					
						<br></br>

			</form>
		</div>
	</center>
	
	</div>


	
</body>
</html>