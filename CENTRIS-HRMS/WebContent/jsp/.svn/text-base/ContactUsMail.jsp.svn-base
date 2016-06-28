
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%
	String basePath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send Mail</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<link rel="stylesheet" type="text/css"
	href="JQUERY/css/smoothness/jquery-ui-1.9.2.custom.css" />
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/ContactUsMail.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

</head>
<body>

	<div class="background" id="backgroung">
		<center>
			<font
				style="font-family: sans-serif; font-weight: bolder; color: #000000; font-size: 17px;">Send
				Mail</font> <br> <br>
				<div id="errordiv" class="error-box" ></div>
			<p id="successMessage"
				style="font-size: 13px; color: green; font-family: Segoe UI;">
				<logic:present name="NetworkStatus">
					<bean:write name="NetworkStatus" scope="session" />
				</logic:present>
			</p>
			<p class="validateTips" id="error"
				style="font-size: 13px; color: red; font-family: Segoe UI;">
				<logic:present name="NetworkError">
					<bean:write name="NetworkError" scope="session" />
				</logic:present>
			</p>
<center><div id="loader" style="position: absolute;top:160px;left:620px;display: none;"><img  src="images/loaderimage2.GIF"/></div></center>
			<br />
			<html:form action="ContactUsMail.do?method=sendMail"
				enctype="multipart/form-data" method="post"
				onsubmit="return validate()">
				<input type="hidden" name="method" value="sendMail" />
				<fieldset style="width: 80%;">
				<br/>
					<table id="biometric" align="center" style="width: 40%;">
						<tr class="trc">
							<td class="left" style="text-align: center;">To</td>
							<td class="right"><input type="text" id="mailTo"
								name="mailTo" readonly="readonly"
								value="support@centrisinfotech.com"
								style="width: 95%; height: 100%; border: none; background: #D1D9DF; text-align: center;" /></td>
						</tr>
						<tr>
							<td class="left" style="text-align: center;">Subject<font
								color="red">*</font></td>
							<td class="right"><input type="text" id="mailSub" name="mailSub"
								style="width: 95%; height: 100%;" /></td>
						</tr>
						<tr>
							<td class="left" style="text-align: center;">Content<font
								color="red">*</font></td>
							<td class="right"><textarea id="mailContent" name="mailContent"
									style="width: 95%; height: 30px;resize:none;" ></textarea></td>

						</tr>
						<tr>
							<td class="left" style="text-align: center;">From EmailId<font
								color="red">*</font></td>
							<td class="right"><input type="text" id="mailFrom" name="mailFrom"
								style="width: 95%; height: 100%;" /></td>
						</tr>
						<tr>
							<td class="left" style="text-align: center;">Mobile No<font
								color="red">*</font></td>
							<td class="right"><input type="text" id="cusMobile" name="cusMobile"
								maxlength="10" style="width: 95%; height: 100%;" /></td>
						</tr>
						<tr>
							<td class="left" style="text-align: center;height:30px;">Attach Files</td>
							<td class="right" style="height:30px;"><html:file property="attachFile" styleId="attachFile" ></html:file></td>
						</tr>
					</table>
				<br/><br/>
			<table>
			<tr>
				<td><input type="submit" value="Send Mail" id="sendMail" class="submitbutton"  onclick="return validations()" /></td>
				<td><input type="reset" value=" Clear " class="submitbutton" /></td> 
			</tr>
			</table>
						
					
				</fieldset>
				
			
				
			</html:form>
		</center>
		<br />
		<br />

	</div>

</body>
</html>