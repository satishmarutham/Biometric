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
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<!-- <script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script> -->
<!-- <link href="css/Home/bootstrap.min.css" rel="stylesheet"> -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/Home/jumbotron.css" rel="stylesheet">
<link href="css/Home/carol.css" rel="stylesheet">
<!-- <script src="js/Login/bootstrap.min.js"></script> -->
<script type="text/javascript" src="js/Login/login.js"></script>
<!-- <script type="text/javascript" src="js/Login/jquery.js"></script> -->
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

<script type="text/javascript">
	// can't go back

	/* 	window.history.forward(0); */

	// can't select any text
	function disableselect(e) {
		return false;
	}

	function reEnable() {
		return true;
	}
	//if IE4+  
	document.onselectstart = new Function("return false");
	//if NS6  
	if (window.sidebar) {
		document.onmousedown = disableselect;
		document.onclick = reEnable;
	}
</script>

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
span
{
font-size: 13px;
font-family: Segoe UI;
color: #000000;
}
</style>

</head>

<body oncontextmenu="return false;">
	<div class="parentDisable" style="display: none;"></div>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation"
		style="background-color: #f4f4f4;">
		<div class="container">
			<div class="navbar-header">
				<img src="images/centris.png" width="165" height="65"
					style="padding-top: 10px;">
			</div>
			<div style="padding-left: 97%; padding-top: 10px; height: 90px;">
				<table>
					<tr>
						<!-- <td onclick="return myDirector()" class="big-link"
							data-reveal-id="adlogin" data-animation="fade"><img
							src="images/emp.png" class="image"
							style="width: 35px;   margin-left: 5px;cursor: pointer;"></td> -->
						<td onclick="return myAdmin()" class="big-link"
							data-reveal-id="adlogin" data-animation="fade"><img
							src="images/emp.png" class="image"
							style="width: 35px;   margin-left: 9px;cursor: pointer;"></td>
						<!-- <td onclick="return myManager()" class="big-link"
							style="padding-left: 18px;" data-animation="fade"><img
							src="images/mng.png" class="image"
							style="width: 35px; cursor: pointer;"></td>
						<td onclick="return myEmployee()" class="big-link"
							style="padding-left: 14px;" data-animation="fade"><img
							src="images/emp1.png" class="image"
							style="width: 40px; cursor: pointer;"></td> -->
					</tr>
					<tr>
						<!-- <td><span>Director</span></td> -->
						<td><span style="padding-left: 8px;"><b>Login</b></span></td>
					<!-- 	<td><span style="padding-left: 13px;">Manager</span></td>
						<td><span style="padding-left: 12px;">Employee</span></td> -->
					</tr>
				</table>

			</div>

		</div>
		<div class="login-wrap" id="adminloginPopup"
			style="display: none; position: absolute; top: 50%; left: 50%; margin-top: 60px; margin-left: -175px; width: 350px; z-index: 2;">
			<h2>User Login</h2>

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

					<button type="submit" id="adminLogin" class="btn btn-success">Sign
						in</button>
					<br> <input type="hidden" name="userType" value="admin">
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
					<button type="submit" id="managerLogin" class="btn btn-success">Sign
						in</button>
					<br> <input type="hidden" name="userType" value="manager">
					<span style="margin-left: 15%; color: red; visibility: hidden;"
						class="validateTips" id="managererror"></span> <br> <span
						style="font-size: 13px; padding-left: 0%;" class="login-span"
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

					<button type="submit" id="employeeLogin" class="btn btn-success">Sign
						in</button>
					<br> <input type="hidden" name="userType" value="employee">
					<span style="margin-left: 15%; color: red; visibility: hidden;"
						class="validateTips" id="employeererror"></span> <br> <span
						style="font-size: 13px; padding-left: 0%;" class="login-span"
						id="employeeforgetPassword">Forgot Password</span> <span
						style="padding-left: 50%;"></span> <span
						style="font-size: 13px; padding-left: 10%;" class="login-span"
						onclick="return Close()">Close</span>
				</form>
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
	</div>

	<br />
	<br />

	<!-- Carousel
    ================================================== -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<!-- <ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
			<li data-target="#myCarousel" data-slide-to="4"></li>
			<li data-target="#myCarousel" data-slide-to="5"></li>
		</ol> -->

		<div class="carousel-inner">
			<div class="item active">

				<img src="images/banner1.jpg" align="middle" style="padding-left: 4% !important;min-width: 95% !important;">
				<div class="container">
					<div class="carousel-caption">

					<!-- 	<h1 style="font-family: segoe UI;">Schools and College</h1> -->


					</div>
				</div>
			</div>
			<div class="item">

				<img src="images/banner2.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1 style="font-family: segoe UI;">Corporates</h1>

					</div>
				</div>
			</div>
			<div class="item">

				<img src="images/banner3.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1 style="font-family: segoe UI;">Shopping Mall</h1>

					</div>
				</div>
			</div>
			<!-- <div class="item">

				<img src="images/cor.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1 style="font-family: segoe UI;">Banks</h1>

					</div>
				</div>
			</div>
			<div class="item">

				<img src="images/h6.jpg" width="400px">
				<div class="container">
					<div class="carousel-caption">
						<h1 style="font-family: segoe UI;">Hospital</h1>

					</div>
				</div>
			</div>
			<div class="item">

				<img src="images/i1.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1 style="font-family: segoe UI;">Institutions</h1>

					</div>
				</div>
			</div> -->
		</div>
		<!-- <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span
			class="glyphicon glyphicon-chevron-left"></span></a> <a
			class="right carousel-control" href="#myCarousel" data-slide="next"><span
			class="glyphicon glyphicon-chevron-right"></span></a> -->

	</div>
	<!-- /.carousel -->

	<div class="container marketing">

		<div class="row">
			<div class="col-lg-4">

				<img src="images/web.jpg" height="75" width="100"><br> <br>

				<p class="homeFontStyle">Comprehensive web integrated solution
					with unlimited users access(24*7).</p>

			</div>
			<div class="col-lg-4">

				<img src="images/roster.jpg" height="75" width="100"><br>
				<br>

				<p class="homeFontStyle">Dynamic Shift Roster for capturing
					Staff Attendance.</p>

			</div>
			<div class="col-lg-4">

				<img src="images/up.png" height="75" width="100"><br> <br>

				<p class="homeFontStyle">Easy to store, capture and ready to use
					UI.</p>

			</div>
			<div class="col-lg-4">

				<img src="images/sec.jpeg" height="75" width="100"><br> <br>

				<p class="homeFontStyle">Secured Employee Web Access.</p>

			</div>
			<div class="col-lg-4">

				<img src="images/atte.jpg" height="75" width="100"><br> <br>

				<p class="homeFontStyle">Reports: (Present/ absent/ daily/
					monthly/ Late comers/ Early goers.</p>

			</div>
			<div class="col-lg-4">

				<img src="images/eco.jpg" height="75" width="100"><br> <br>

				<p class="homeFontStyle">Stop usage of paper, Save nature, Go
					Eco-Friendly.</p>
			</div>
		</div>
		<br>
		<footer>
			<p class="pull-right">
				<a href="#">Back to top</a>
			</p>
			<p style="text-align: center; font-family: segoe UI;">
				&copy;
				<script type="text/javascript">
					var mdate = new Date();
					document.write(mdate.getFullYear());
				</script>
				Centris Infotech Services.
			</p>
		</footer>
	</div>
</body>
</html>
