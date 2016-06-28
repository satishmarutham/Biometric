<!DOCTYPE html>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html lang="en">
<head>
<link rel="shortcut icon" href="images/favicon.ico">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/jumbotron.css" rel="stylesheet">
<link href="css/carol.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation"
		style="background-color: #f4f4f4;">
		<div class="container">
			<div class="navbar-header">
				<img src="images/logog.jpg" width="160" height="50">
			</div>

			<div class="navbar-collapse collapse">
				<form action="/CENTRIS-HRMS/Login.do"
					class="navbar-form navbar-right" role="form">
					<div class="form-group">
						<input type="text" placeholder="Username" class="form-control"
							name="userName">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control"
							name="password">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</form>

			</div>
			<p style="margin-left: 65%; color: red;" >Username / Password Combination is Wrong</p>
			<!--/.navbar-collapse -->
		</div>
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
			<p>&copy; 2014 Centris Infotech Services.</p>
		</footer>

	</div>
	<!-- /.container -->




	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

</body>
</html>
