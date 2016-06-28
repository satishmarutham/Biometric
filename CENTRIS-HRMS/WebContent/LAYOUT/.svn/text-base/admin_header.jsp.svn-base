<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<link type="text/css" href="css/Menu/redfin_menu.css" rel="stylesheet" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link type="text/css" rel="stylesheet"
	href="css/login/bootstrap.min.css">
<link rel="stylesheet" href="css/login/register_style.css">
<link type="text/css" rel="stylesheet" href="css/login/nav_tabs.css">
<link rel="stylesheet" href="css/login/dashboard.css">
<!-- Bootstrap Theme CSS -->
<link type="text/css" rel="stylesheet"
	href="css/login/bootstrap-theme.min.css">
<!-- Bootstrap JS -->
<script src="js/dropdown/jquery.min.js"></script>
<!-- Bootstrap JS -->
<script src="js/dropdown/bootstrap.min.js"></script>
<!-- Bootstrap Hover Dropdown JS -->
<script src="js/dropdown/bootstrap-hover-dropdown.min.js"></script>
<!-- Font Awesome CSS -->
<link rel="stylesheet" href="css/login/font-awesome.min.css">
<!-- Style CSS -->
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/Login/header.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="JQUERY/js/bootstrap.min.js"></script>
<style type="text/css">
	#hbox{
display:none;
overflow: visible !important;
}


.gb_Wa {
    border-color: transparent;
    border-style: dashed dashed solid;
    border-width: 0 8.5px 8.5px;
    display: block;
    position: absolute;
    left: 167.5px;
    z-index: 1;
    height: 0;
    width: 0;
    -webkit-animation: gb__a .2s;
    animation: gb__a .1s;
    border-bottom-color: #ccc;
    /* border-bottom-color: rgba(0,0,0,.2); */
    top: -9px;
}

.gb_Va {
    border-color: transparent;
    border-bottom-color: #fff;
    border-style: dashed dashed solid;
    border-width: 0 8.5px 8.5px;
    display: block;
    position: absolute;
    left: 167.5px;
    top: -8px;
    z-index: 1;
    height: 0;
    width: 0;
    -webkit-animation: gb__a .1s;
    animation: gb__a .1s;
}

</style>
<script type="text/javascript">
	$(document).ready(function(){		
	// for settings color js
		$(".dropdown2").click(function(){
			$("#hbox").slideToggle("speed");
			
		});
		
});
</script>
		

	
</head>
<body >
  
	<div>
	<img src="images/centris.png" align="left" height="70px"

			width="150px" style="padding-top: 10px; padding-left:10px;padding-bottom:10px;"/>

		
			
	<a href="GetDetails.do?parameter=menu" style="float: left;margin-left: 77%;margin-top: 2%;">
			
			<span class="glyphicon glyphicon-th-list" data-toggle="tooltip" data-placement="bottom" title="Menu" style="    z-index: 999;color: #fff;font-size: 17px;"></span></a>
			
		

	</div>
	
<div class="mains" >
<ul class="nav navbar-nav navbar-right">
								<!-- Change Password and Logout -->
   <li class="dropdown2"><a href="#" data-toggle="dropdown" class="ui-nav" style="color: #fff !important;">
  <logic:present name="UserDetails" scope="session" ><img src="<bean:write name="UserDetails" property="employeeImage" />"
						width="50px" height="50px" id="ImagePreview"><bean:write name="UserDetails" property="userFirstName"/>&nbsp;&nbsp;
						<input id="empIdhidden" type="hidden" 
							value='<bean:write name="UserDetails" property="empId"/>' /><b class="caret"></b></logic:present></a></li></ul>
			
			<div id="hbox" class="col-md-2" style="border:1px solid #D7D8D6;border-radius: 5px;;z-index:99999;position:absolute;float:right; margin:6% 81% 3.9% !important;background:#fff; box-shadow: rgb(214, 209, 209) 1px 0px 1px 1px;" >						
		      <br/>
					   <div class="gb_Wa"></div>
								<div class="gb_Va"></div>
							  <p style="list-style-type:none;font-family: Segoe UI;float:left;font-size: 14px;color: black;">Last Login Time:&nbsp;&nbsp;<span>03:30:00</span></p>	
							  <p style="list-style-type:none;font-family: Segoe UI;float:left;font-size: 14px;color: black;text-align: left;width: 100%;"><a href="#" data-toggle="modal" id="support"data-target="#support">Support</a></p><p>&nbsp;<br/></p>
							   <p style="list-style-type:none;font-family: Segoe UI;float:left;font-size: 14px;color: black;text-align: left;width: 100%;"><a href="#" data-toggle="modal"  id="userlogout"  data-target="#gdgf">Logout</a></p>	
								
								
					          <p style="list-style-type:none;font-family: Segoe UI;float:left;font-size: 14px;color: black;width:100%;">
					          <img src="images/settings2.png"  style="padding-top: 10px; padding-right:10px;padding-bottom:10px;cursor:pointer;float:left;"  height="40px" id="settings"/>
					          <img src="images/edit.png"  id="profile"   style="padding-top: 10px; padding-right:10px;padding-bottom:10px;cursor:pointer;float:left;"  height="40px"/>
					          <img src="images/Key-e.png"  id="changepwd"   style="padding-top: 13px; padding-right:10px;padding-bottom:10px;cursor:pointer;padding-top:13px;float:left;padding-top: 10px;height: 42px;"  height="45px"/></p>	
															
						</div>	
 </div>

</body>
</html>