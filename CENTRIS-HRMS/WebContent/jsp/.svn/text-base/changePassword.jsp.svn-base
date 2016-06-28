<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Change Password</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="shortcut icon" href="images/favicon.ico" />
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/changepassword.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

</head>

<body>
	
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
					<fieldset style="width: 75%;">
						<table cellpadding="5" cellspacing="0" id="biometric" width="50%">
							<tr class="trc">
								<td class="left">Current Password<font
									color="red">*</font></td><td class="right"><input type="password"
									name="admin_Oldpassword" id="oldpassword"
									onblur="currentPasswordCkeck()" value="" size="32" style="  width: 96%;border-radius: 4px;" /></td>


							</tr>
							<tr class="trc">
								<td class="left" >New Password<font color="red">*</font></td>
									 <td class="right"><input type="password" name="admin__Newpassword"
									id="newpassword" value="" style="  width: 96%;border-radius: 4px;" /></td>
							</tr>
							<tr class="trc">
								<td class="left">Confirm Password<font
									color="red">*</font> </td><td class="right"><input type="password"
									name="admin__Confirmpassword" id="password-check" value=""
									style="  width: 96%;border-radius: 4px;"/></td>
							</tr>
						</table>
						</fieldset>
					
					<center>
					<table>
						<tr>

							<td colspan="3"><center>
									<input type="submit" class="submitbutton"
										value="ChangePassword" class="button1" id="submit" />
									&nbsp;&nbsp;&nbsp; <input type="button" value="Clear"
										class="submitbutton" onclick="clearContent()" />
								</center></td>

						</tr>

					</table>
					</center>
				
				</div>

			</div>
		</center>
	</div>
	</div>
	</center>
	


</body>
</html>