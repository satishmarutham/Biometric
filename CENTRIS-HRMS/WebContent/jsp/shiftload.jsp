<?xml version="1.0" encoding="ISO-8859-1" ?>
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
	
		<script type="text/javascript">
			function fun() {
				setTimeout('redirectMe()', 1000); //delay 1 seconds
				}
			function redirectMe() {
					document.myform.action='shiftload.do';
					document.myform.submit();
			}
		</script>
		<link type="text/css" href="menu.css" rel="stylesheet" />
		<link type="text/css" href="view.css" rel="stylesheet" />
    	<script type="text/javascript" src="jquery.js"></script>
    	<script type="text/javascript" src="menu.js"></script>
    			<link rel="stylesheet" type="text/css" href="view.css" />
	</head>
	<body onload="fun()" bgcolor="">
	<jsp:include page="header_menu.jsp"></jsp:include>
	<div id="header">

		<form name="myform">
			
		</form>
		<br></br><br></br><br></br><br></br><br></br>
		<center><img src="images/loading.gif" alt="" height="160" width="180"/> </center>
		<br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br><br></br>
		<hr></hr>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
	
</html>
