<!DOCTYPE html>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<link rel="shortcut icon" href="images/favicon.ico">

<title>Login Page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/Home/jumbotron.css" rel="stylesheet">
<link href="css/Home/carol.css" rel="stylesheet">
<script src="js/Login/bootstrap.min.js"></script>
<script type="text/javascript" src="js/Login/forgetPasswordRequest.js"></script>
<script type="text/javascript" src="js/Login/login.js"></script>
<script type="text/javascript" src="js/Login/jquery.js"></script>
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
<script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/popup.css">

<style type="text/css">
.parentDisable {
	position: fixed;
	top: 0;
	left: 0;
	background: #000;
	opacity: 0.8;
	z-index: 998;
	height: 100%;
	width: 100%;
}

.popup {
	position: aboslute;
	z-index: 999;
}
</style>

</head>

<body>
	<div class="parentDisable" style="display: none;"></div>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation"
		style="background-color: #f4f4f4;">
		<div class="container">
			<div class="navbar-header">
				<img src="images/centris.png" width="140" height="50"
					style="padding-top: 7px; cursor: pointer;" onclick="return gotoHome()">
			</div>
			
			<div style="padding-left: 80%; padding-top: 10px; height: 90px;">
				<table>
					<tr>
					     <td onclick="return myDirector()" class="big-link"
							data-reveal-id="adlogin" data-animation="fade"><img
							src="images/emp.png" class="image"
							style="width: 40px; cursor: pointer;"></td>
							
						<td onclick="return myAdmin()" class="big-link"
							data-reveal-id="adlogin" data-animation="fade"><img
							src="images/emp.png" class="image"
							style="width: 40px; cursor: pointer;"></td>
							
						<td onclick="return myManager()" class="big-link"
							style="padding-left: 20px;" data-animation="fade"><img
							src="images/mng.png" class="image"
							style="width: 40px; cursor: pointer;"></td>
						<td onclick="return myEmployee()" class="big-link"
							style="padding-left: 18px;" data-animation="fade"><img
							src="images/emp1.png" class="image"
							style="width: 40px; cursor: pointer;"></td>
					</tr>
					<tr>
					   <td><span style="padding-right:13px;">Director</span></td>
						<td><span>Admin</span></td>
						<td><span style="padding-left: 13px;">Manager</span></td>
						<td><span style="padding-left: 12px;">Employee</span></td>
					</tr>
				</table>

			</div>

		</div>
		
		
	
		
		<div class="login-wrap" id="directorloginPopup"
			style="display: none; position: absolute; top: 50%; left: 50%; margin-top: 60px; margin-left: -175px; width: 350px; z-index: 2;">
			<h2>Director Login</h2>

			<div class="form">
				<form action="" method="post" id="directorLoginSubmit">
					<div class="form-group">
						<input type="text" placeholder="Username" name="userName"
							id="director_uname">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" name="password"
							id="director_pword">
					</div>

					<button type="submit" id="directorLogin" class="btn btn-success">Sign
						in</button>
					<br> <input type="hidden" name="userType" value="director">
					<span style="margin-left: 25%; color: red; visibility: hidden;"
						class="validateTips" id="directorerror"></span> <br> <span
						style="font-size: 13px; float:left;" class="login-span"
						id="directorforgetPassword">Forgot Password</span> <!-- <a href="#">
						<span style="font-size: 13px; padding-left: 75%;"
						onclick="return Close()">Close</span>
					</a> -->
					<span
						style="font-size: 13px; float:left;margin-left:60%;" class="login-span"
						onclick="return Close()">Close</span>
				</form>
			</div>
		</div>
	
		<div class="login-wrap" id="adminloginPopup"
			style="display: none; position: absolute; top: 50%; left: 50%; margin-top: 60px; margin-left: -175px; width: 350px; z-index: 2;">
			<h2>Login</h2>

			<div class="form">
				<form action="" method="post" id="adminLoginSubmit">
					<div class="form-group">
						<input type="text" placeholder="Username" name="userName"
							id="admin_uname">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" name="password"
							id="admin_pword">
					</div>
					<input type="hidden" name="userType" value="admin"> <span
						style="margin-left: 15%; color: red; visibility: hidden;"
						class="validateTips" id="adminerror"></span>
					<button type="submit" id="adminLogin" class="btn btn-success">Sign
						in</button>
					<span style="margin-left: 25%; color: red; visibility: hidden;"
						class="validateTips" id="adminerror"></span> <br> <span
						style="font-size: 13px; float:left;" class="login-span"
						id="adminforgetPassword">Forgot Password</span><!-- <a href="#">
						<span style="font-size: 13px; padding-left: 75%;"
						onclick="return Close()">Close</span>
					</a> -->
					<span
						style="font-size: 13px; float:left;margin-left:60%;" class="login-span"
						onclick="return Close()">Close</span>
				</form>
			</div>
		</div>
		<div class="login-wrap" id="managerloginPopup"
			style="display: none; position: absolute; top: 50%; left: 50%; margin-top: 60px; margin-left: -175px; width: 350px; z-index: 2;">
			<h2>Manager Login</h2>

			<div class="form">

				<form action="" method="post" id="managerLoginSubmit">
					<div class="form-group">
						<input type="text" placeholder="Username" name="userName"
							id="manager_uname">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" name="password"
							id="manager_pword">
					</div>

					<input type="hidden" name="userType" value="manager"> <span
						style="margin-left: 15%; color: red; visibility: hidden;"
						class="validateTips" id="managererror"></span>
					<button type="submit" id="managerLogin" class="btn btn-success">Sign
						in</button>
					<span style="font-size: 13px; padding-left: 0%;" class="login-span"
						id="managerforgetPassword">Forgot Password</span><span
						style="padding-left: 50%;"></span> <span
						style="font-size: 13px; padding-left: 10%;" class="login-span"
						onclick="return Close()">Close</span>
				</form>
			</div>
		</div>
		<div class="login-wrap" id="employeeloginPopup"
			style="display: none; position: absolute; top: 50%; left: 50%; margin-top: 60px; margin-left: -175px; width: 350px; z-index: 2;">
			<h2>Employee Login</h2>

			<div class="form">

				<form action="" method="post" id="employeeLoginSubmit">
					<div class="form-group">
						<input type="text" placeholder="Username" name="userName"
							id="employee_uname">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" name="password"
							id="employee_pword">
					</div>
					<input type="hidden" name="userType" value="employee"> <span
						style="margin-left: 15%; color: red; visibility: hidden;"
						class="validateTips" id="employeererror"></span>
					<button type="submit" id="employeeLogin" class="btn btn-success">Sign
						in</button>
					<span style="font-size: 13px; padding-left: 0%;" class="login-span"
						id="employeeforgetPassword">Forgot Password</span> <span
						style="padding-left: 50%;"></span> <span
						style="font-size: 13px; padding-left: 10%;" class="login-span"
						onclick="return Close()">Close</span>
				</form>
			</div>
		</div>
	</div>
	
	
	
	

	<br />
	<br />

</body>
</html>
