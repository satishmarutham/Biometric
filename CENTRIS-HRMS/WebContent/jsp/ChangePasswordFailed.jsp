<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<title>Entered Old Password is Incorrect</title>
<style type="text/css">
.form1 {
	position: absolute;
	top: 87px;
	left: 221px;
	width: auto;
	height: auto;
	padding: 10px;
	border: 2px solid gray;
	margin: 5px;
	background-color: #C3C3C3;
}

input {
	background-color: #FFF;
	color: #333;
	border: 1px solid #CED8F6
}

texta {
	background-color: #FFF;
	color: #FFF;
	border: 1px solid #CED8F6
}

.button1 {
	-webkit-box-shadow: rgba(0, 0, 0, 0.0976562) 0px 1px 0px 0px;
	background-color: #313839;
	border: 1px solid #999;
	color: #CCC;
	font-family: 'Lucida Grande', Tahoma, Verdana, Arial, Sans-serif;
	font-size: 11px;
	font-weight: bold;
	padding: 2px 6px;
	height: 28px;
}

}
fieldset {
	border: 1px solid #000000;
	width: 20em
}

label {
	font-family: Tahoma, Geneva, sans-serif;
	font-size: 11px;
	width: auto;
	float: left;
	text-align: right;
	margin-right: 0.5em;
	display: block
}

.buttonstyle {
	-moz-box-shadow: inset 0px 1px 0px 0px #f29c93;
	-webkit-box-shadow: inset 0px 1px 0px 0px #f29c93;
	box-shadow: inset 0px 1px 0px 0px #f29c93;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #fe1a00
		), color-stop(1, #ce0100) );
	background: -moz-linear-gradient(center top, #fe1a00 5%, #ce0100 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#fe1a00',
		endColorstr='#ce0100' );
	background-color: #fe1a00;
	-moz-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
	border: 1px solid #d83526;
	display: inline-block;
	color: #ffffff;
	font-family: arial;
	font-size: 15px;
	font-weight: bold;
	padding: 6px 24px;
	text-decoration: none;
	text-shadow: 1px 1px 0px #b23e35;
}

.buttonstyle:hover {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ce0100
		), color-stop(1, #fe1a00) );
	background: -moz-linear-gradient(center top, #ce0100 5%, #fe1a00 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ce0100',
		endColorstr='#fe1a00' );
	background-color: #ce0100;
}

.buttonstyle:active {
	position: relative;
	top: 1px;
}

body,td,th {
	color: #1B1717;
}

body {
	background-color:;
}
</style>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/changepassword.js"></script>
</head>
<body>
	<jsp:include page="header_menu.jsp"></jsp:include>
	<br></br>
	<center>



		<font color="red" size="4">Entered Old Password is Incorrect</font>

<br></br>

		<html:form action="/ChangePassword">
			<table id="biometric">
				<tr>
					<td colspan="1">OldPassword</td>
					<td colspan="1"><input type="password" name="Oldpassword"
						id="oldpassword" value="" size="32" /></td>
				</tr>
				<tr>
					<td>NewPassword</td>
					<td><input type="password" name="Newpassword" id="newpassword"
						value="" size="32" /></td>
				</tr>
				<tr>
					<td>ConfirmPassword</td>
					<td><input type="password" name="Confirmpassword"
						id="password-check" value="" size="32" /></td>
				</tr>
			</table>

			<br>
			<br>
			<table>
				<tr>
					<td colspan="1" align="center"><input type="submit"
						id="submit" value="Submit" class="button1"></input></td>
					<td><input type="button" value="Go back "
						onclick="history.go(-1);" class="button1" /></td>
				</tr>
			</table>
		</html:form>
	</center>
</body>
<br>
<br>
<br>
<br>
<br>
<br>
<hr></hr>
<jsp:include page="footer.jsp"></jsp:include>
</html>