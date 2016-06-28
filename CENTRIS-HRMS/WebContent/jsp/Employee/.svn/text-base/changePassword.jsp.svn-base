<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Change Password</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>

<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/Employee/changepassword.js"></script>

<!-- <link rel="stylesheet" href="css/common.css"></link>
<link href="css/latecomersreport.css" rel="stylesheet" type="text/css" /> -->
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>

</head>

<body>
	<br></br>

	<div id="main">

		<center>

			<div class="background" id="backgroung">

				<div class="backgroundDiv" id="backgroung">Change Password</div>
			


				<center>

					<div id="errordiv" class="error-box" align="center">

						<logic:present name="message" scope="request">
							<span style="color: green; font-family: Segoe UI;"> <bean:write
									name="message" />
							</span>
						</logic:present>
					</div>
				</center>

				<div class="backgroungDIV" id="backgroung">
					
						<table cellpadding="8" cellspacing="5" id="biometric" width="50%">

							<tr class="trc">
								<td class="left">Official Email ID<font color="red">*</font>
									</td><td class="right"><input type="text" name="employee_EmailID" id="emailId"
									value="" size="32"  /></td>





								<td class="left" >Current Password<font
									color="red">*</font> </td><td class="right"><input type="password"
									name="employee_Oldpassword" id="employeeoldId" value=""
									size="32" style="width: 96%;border-radius: 4px;"/></td>
									</tr>
							<tr class="trc">


								<td class="left" >New Password<font color="red">*</font>
									</td><td class="right"> <input type="password" name="employee__Newpassword"
									id="employeenewId" value="" size="32" style="  width: 96%;border-radius: 4px;" /></td>


								<td class="left">Confirm Password<font
									color="red">*</font> </td><td class="right"> <input type="password"
									name="employee__Confirmpassword" id="employeeconfirmId"
									value="" size="32" style="  width: 96%;border-radius: 4px;"/></td>
							</tr>
						</table>
					
			
					<table>
						<tr>

							<td colspan="3"><center>
									<input type="submit" class="submitbutton"
										value="ChangePassword" class="button1" id="submit" />
									&nbsp;&nbsp;&nbsp; <input type="button" value="Clear"
										onclick="clearContent()" class="submitbutton" />
								</center></td>

						</tr>

					</table>
				</div>
			</div>
		</center>
	</div>


</body>
</html>