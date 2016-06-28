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

<link href="css/Home/bootstrap.min.css" rel="stylesheet">
<link href="css/Home/jumbotron.css" rel="stylesheet">
<link href="css/Home/carol.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
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
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
</head>
<script type="text/javascript">
	
</script>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation"
		style="background-color: #f4f4f4;">
		<div class="container">
			<div class="navbar-header">
				<img src="images/logog.jpg" width="150" height="60">
			</div>

			<div class="navbar-collapse collapse">
				<form action="/CENTRIS-HRMS/Login.do" method="post"
					class="navbar-form navbar-right" role="form">
					<div class="form-group">
						<input type="text" placeholder="Username" class="form-control"
							name="userName" id="uname">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control"
							name="password" id="pword">
					</div>
					<button type="submit" id="Login" class="btn btn-success"
						onclick="return validations()">Sign in</button>
				</form>

			</div>
			<p style="margin-left: 72%; color: red;" class="validateTips"
				id="error"></p>
			<p style="margin-left: 65%; color: blue;" id="passChangeMessage">
				Your password has been changed successfully <br>Login with new
				Password
			</p>
		</div>
		<%-- 
						<div id="errordiv" class="error-box">
							
							<logic:present name="message" scope="request">
								<span style="color: green; font-family: Segoe UI;">
									<bean:write name="message"/>
								</span>
							</logic:present>
						</div> --%>
	</div>

	<!-- Carousel
    ================================================== -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
			<li data-target="#myCarousel" data-slide-to="4"></li>
			<li data-target="#myCarousel" data-slide-to="5"></li>
		</ol>

		<div class="carousel-inner">
			<div class="item active">

				<img src="images/s.jpg" align="middle">
				<div class="container">
					<div class="carousel-caption">

						<h1>Schools and College</h1>


					</div>
				</div>
			</div>
			<div class="item">

				<img src="images/corpor.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1>Corporates</h1>

					</div>
				</div>
			</div>
			<div class="item">

				<img src="images/sroom.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1>Shopping Mall</h1>

					</div>
				</div>
			</div>
			<div class="item">

				<img src="images/cor.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1>Banks</h1>

					</div>
				</div>
			</div>
			<div class="item">

				<img src="images/h6.jpg" width="400px">
				<div class="container">
					<div class="carousel-caption">
						<h1>Hospital</h1>

					</div>
				</div>
			</div>
			<div class="item">

				<img src="images/i1.jpg">
				<div class="container">
					<div class="carousel-caption">
						<h1>Institutions</h1>

					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span
			class="glyphicon glyphicon-chevron-left"></span></a> <a
			class="right carousel-control" href="#myCarousel" data-slide="next"><span
			class="glyphicon glyphicon-chevron-right"></span></a>

	</div>
	<!-- /.carousel -->

	<div class="container marketing">

		<!-- Three columns of text below the carousel -->
		<div class="row">
			<div class="col-lg-4">

				<img src="images/h.jpg" height="100" width="100"><br> <br>

				<p>Comprehensive web integrated solution with unlimited users
					access(24*7).</p>

			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">

				<img src="images/roster.jpg" height="100" width="100"><br>
				<br>

				<p>Dynamic Shift Roster for capturing Staff Attendance.</p>

			</div>

			<!-- /.col-lg-4 -->
			<div class="col-lg-4">

				<img src="images/ws.jpg" height="100" width="100"><br> <br>

				<p>Easy to store, capture and ready to use UI.</p>

			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">

				<img src="images/sec.jpeg" height="100" width="100"><br>
				<br>

				<p>Secured Employee Web Access.</p>

			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">

				<img src="images/atte.jpg" height="100" width="100"><br>
				<br>

				<p>Reports: (Present/ absent/ daily/ monthly/ Late comers/ Early
					goers.</p>

			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">

				<img src="images/eco.jpg" height="100" width="100"><br> <br>

				<p>Stop usage of paper, Save nature, Go Eco-Friendly.</p>

			</div>
			<!-- /.col-lg-4 -->
		</div>
		<!-- /.row -->

		<br>


		<!-- /END THE FEATURETTES -->


		<!-- FOOTER -->
		<footer>
			<p class="pull-right">
				<a href="#">Back to top</a>
			</p>
			<p style="text-align: center;">&copy; 2014 Centris Infotech
				Services.</p>
		</footer>

	</div>
	<!-- /.container -->




	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

</body>
</html>
