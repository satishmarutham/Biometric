<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<%--<link rel="stylesheet" type="text/css" href="style.css" /> --%>
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
<script type="text/javascript" src="js/Login/login.js"></script>
<script type="text/javascript" src="js/Login/forgetPasswordRequest.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
</head>
<body>
	<br></br>
	<div id="hidecontent"
		style="background: tranparent; width: 100%; min-height: 500px; left: 0px; top: 0px; display: none; z-index: 2; position: absolute;"></div>
	<div id="loader"
		style="position: absolute; top: 250px; left: 650px; display: none;">
		<img src="images/loaderimage2.GIF" width="150px" height="150px" />
	</div>
	
		<center>
			<div class="background" id="backgroung">
				<!-- <div class="backgroundDiv" id="backgroung">Forgot Password</div> -->
				<br />

				<form>
					<center>

						<div id="errordiv" class="error-box" align="center"
							style="padding-top: 0px;">

							<logic:present name="message" scope="request">
								<span style="color: green; font-family: Segoe UI;"> <bean:write
										name="message" />
								</span>
							</logic:present>
						</div>
					</center>
					</form>
					<br />
					<logic:present name="employee">
				    <center>
					<div class="backgroundDiv" id="backgroung">Employee Forgot Password</div> 
					<br/>
					
				  	
						<table cellpadding="2" cellspacing="2" id="biometric" width="50%"><br/>
							<tr >
								<td class="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DOB<font color="red">*</font>
									</td><td class="right"><input type="text" name="dateofBirth"
									id="dateofBirthId" readonly="readonly" value="" /></td>
                             </tr>
                             <tr class="trc">
								<td class="left" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Official Email Id<font
									color="red">*</font> </td><td class="right"> <input type="text"
									name="employee__officialemailid" id="employeeofficialemailid"
									value="" size="32" /></td>
							</tr>
						</table>
						
						
						<table>
							<tr>

								<td colspan="3"><center>
								<input type="button" class="submitbutton" value="Home"
										class="button1" id="home" /> &nbsp;&nbsp;&nbsp;
										<input type="button" class="submitbutton"
											value="Send Password" class="button1" id="employee_submit" />
										&nbsp;&nbsp;&nbsp; <input type="reset" value="Clear"
											class="submitbutton" />
									</center></td>

							</tr>

						</table>
						</center>
						
					
						
					</logic:present>
				

				<logic:present name="manager">
				<center>
					<div class="backgroundDiv" id="backgroung">Manager Forgot Password</div> 
				   <br/>
			     <fieldset style="width: 75%; border: 1px solid #000;">
					<table cellpadding="8" cellspacing="4" id="biometric" width="35%"><br/>
						<tr class="trc">


							<td class="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Username<font color="red">*</font>
									</td><td class="right"><input type="text" name="username" id="usernameId"
								value="" size="32" /></td>
								</tr>
								<tr>
							<td class="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Official Email Id<font color="red">*</font>
									</td><td class="right"> <input type="text" name="email" id="emailId" value=""
								size="32" /></td>
						</tr>
						

					</table>
					</fieldset>
					
					<table>
						<tr>
							<td colspan="3"><center>
							<input type="button" class="submitbutton" value="Home"
										class="button1" id="home" /> &nbsp;&nbsp;&nbsp;
									<input type="button" class="submitbutton" value="Send Password"
										class="button1" id="manager_submit" /> &nbsp;&nbsp;&nbsp; <input
										type="reset" value="Clear" class="submitbutton" />
								</center></td>
						</tr>

					</table>
					</center>
				</logic:present>
				<br/>
				<logic:present name="admin">
				<center>
				<div class="backgroundDiv" id="backgroung">Admin Forgot Password</div> 
				<br/>
				 <fieldset style="width: 75%; border: 1px solid #000;">
					<table cellpadding="8" cellspacing="4" id="biometric" width="35%"><br/>
						<tr class="trc">


							<td class="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Username<font color="red">*</font>
								</td><td class="right"> <input type="text" name="username" id="adminusernameId"
								value="" size="32" /></td>
								</tr>
								<tr class="trc">
							<td class="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Official Email Id<font color="red">*</font>
								</td><td class="right"><input type="text" name="email" id="adminemailId" value=""
								size="32" /></td>
						</tr>

					</table>
					</fieldset>
				
					<table>
						<tr>
							<td colspan="3"><center>
							<input type="button" class="submitbutton" value="Home"
										class="button1" id="home" /> &nbsp;&nbsp;&nbsp;
									<input type="button" class="submitbutton" value="Send Password"
										class="button1" id="admin_submit" /> &nbsp;&nbsp;&nbsp; <input
										type="reset" value="Clear" class="submitbutton" />
								</center></td>
						</tr>

					</table>
					</center>
				</logic:present>
				
				<br/>
				<logic:present name="director">
				<center>
				<div class="backgroundDiv" id="backgroung" style="margin-top:-25px;">Director Forgot Password</div> 
			  <fieldset style="width: 75%; border: 1px solid #000;">
					<table cellpadding="8" cellspacing="4" id="biometric" width="35%"><br/>
						<tr class="trc">


							<td class="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Username<font color="red">*</font>
								</td><td class="right"> <input type="text" name="username" id="directorusernameId"
								value="" size="32" /></td>
								</tr>
								<tr class="trc">
							<td class="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Official Email Id<font color="red">*</font>
								</td><td class="right"><input type="text" name="email" id="directormailId" value=""
								size="32" /></td>
						</tr>

					</table>
					</fieldset>
					
					<table>
						<tr>
							<td colspan="3"><center>
							<input type="button" class="submitbutton" value="Home"
										class="button1" id="home" /> &nbsp;&nbsp;&nbsp;
									<input type="button" class="submitbutton" value="Send Password"
										class="button1" id="director_submit" /> &nbsp;&nbsp;&nbsp; <input
										type="reset" value="Clear" class="submitbutton" />
								</center></td>
						</tr>

					</table>
					<br/>
					</center>
				</logic:present>
				
				
				
			</div>
		</center>
	
</body>
</html>