<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Change Password</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="images/favicon.ico" />
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/Manager/changepassword.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<!-- <link rel="stylesheet" href="css/common.css"></link> -->
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>

</head>

<body>
	<br></br>

	<div id="main">

		<center>

			<div class="background" id="backgroung">

				<div class="backgroundDiv" id="backgroung">Change password</div>
			

				<%-- <html:form action="/ChangePassword.do?parameter=updateManagerPassword"
					method="post"> --%>

				<center>

					<div id="errordiv" class="error-box" align="center">

						<logic:present name="successMessage" scope="request">
							<span id="successId" style="color: green; font-family: Segoe UI;">
								<bean:write name="successMessage" />
							</span>
						</logic:present>
					</div>
				</center>

				<div class="backgroungDIV" id="backgroung">
					<fieldset style="width: 75%;">
						<table cellpadding="5" cellspacing="0" id="biometric" width="75%">
							<tr class="trc">
								<td class="left">Official Email ID<font color="red">*</font></td>
								 <td class="right"><input type="text" name="manager_EmailID"
									id="email-check" value="" /></td>
								<td class="left">Current Password<font
									color="red">*</font> </td> <td class="right"><input type="password"
									name="manager_Oldpassword" id="oldpassword" value=""  style="  width: 96%;border-radius: 4px;"/></td>

							</tr>
							<tr class="trc">
								<td class="left">New Password<font color="red">*</font></td>
									 <td class="right"><input type="password" name="manager_Newpassword"
									id="newpassword" value="" style="  width: 96%;border-radius: 4px;" /></td>

								<td class="left">Confirm Password<font
									color="red">*</font></td> <td class="right"> <input type="password"
									name="manager_Confirmpassword" id="password-check" value="" style="  width: 96%;border-radius: 4px;"
								 /></td>
							</tr>
						</table>
					</fieldset>
					<!-- <br /> -->
					<table>
						<tr>
							<td colspan="3"><center>
									<input type="button" class="submitbutton"
										value="ChangePassword" class="button1" id="submit" />
									&nbsp;&nbsp;&nbsp; <input type="button" value="Clear"
										onclick="contentClear()" class="submitbutton" />
								</center></td>

						</tr>

					</table>
				</div>
				<%-- </html:form> --%>
			</div>
		</center>
	</div>


</body>
</html>