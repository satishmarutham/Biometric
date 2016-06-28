<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>FORGOT PASSWORD</title>
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
<script type="text/javascript" src="js/Employee/forgotpassword.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link href="css/latecomersreport.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>

</head>

<body>
	<br></br>

	<div id="main">

		<center>

			<div class="background" id="backgroung">

				<div class="backgroundDiv" id="backgroung">FORGOT PASSWORD</div>
				<br />

				<form>
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

						<table cellpadding="2" cellspacing="2" id="biometric">

							<tr>
								<td align="left" class="trd">DOB<font color="red">*</font>
									<br /> <input type="text" name="dateofBirth"
									id="dateofBirthId" readonly="readonly" value="" /></td>

            					<td align="left" class="trd">Official Email Id<font
									color="red">*</font> <br /> <input type="text"
									name="employee__officialemailid" id="employeeofficialemailid"
									value="" size="32" /></td>

							</tr>

						</table>
						<br />
						<table>
							<tr>

								<td colspan="3"><center>
										<input type="button" class="submitbutton" value="Submit"
											class="button1" id="submit" /> &nbsp;&nbsp;&nbsp; <input
											type="reset" value="Clear" class="submitbutton" />
									</center></td>

							</tr>

						</table>
					</div>
				</form>
			</div>
		</center>
	</div>


</body>
</html>