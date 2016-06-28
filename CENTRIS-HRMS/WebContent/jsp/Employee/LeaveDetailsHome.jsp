
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect-blind.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script type="text/javascript" src="js/Employee/LeaveDetailsHome.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
<style type="text/css">
#box1 {
	float: left;
	min-height: 150px;
	max-height: 100%;
	width: 14%;
	padding: 0 15px 0 15px;
	background: #E6E6E6;
	margin: 7px 20px 9px 20px;
	-webkit-box-shadow: 7px 7px 5px rgba(50, 50, 50, 0.75);
	-moz-box-shadow: 7px 7px 5px rgba(50, 50, 50, 0.75);
	box-shadow: 7px 7px 5px rgba(50, 50, 50, 0.75);
}

#box1:hover {
	transform: rotate(0deg) scale(0.99) skew(1deg) translate(0px);
	-webkit-transform: rotate(0deg) scale(0.99) skew(1deg) translate(0px);
	-moz-transform: rotate(0deg) scale(0.99) skew(1deg) translate(0px);
	-o-transform: rotate(0deg) scale(0.99) skew(1deg) translate(0px);
	-ms-transform: rotate(0deg) scale(0.99) skew(1deg) translate(0px);
}

p {
	font-family: Segoe UI !important;
	font-size: 13px;
}

.custom h4 {
	font-family: Segoe UI;
}
</style>
</head>
<body>
<br>
	<br>
	<br>
      <center>
		<div id="box1" style="margin-left: 20%;">

			<div class="custom">
				<h4>Leave Request</h4>
		     	<p>
					<input type="button" value="Details" class="linkButton"
						id="getleaveRequest"> <br>
				</p>
				
			</div>
		</div>
		<div id="box1">

			<div class="custom">
				<h4>Leave Request Status</h4>
				<p>	 <input
						type="button" value="Details" class="linkButton"
						id="getleaveRequestStatus"> <br>
					
				</p>
			</div>
		</div>
		<div id="box1">

			<div class="custom">
				<h4>View Leave Details</h4>
				<p>	<input type="button" value="Details" class="linkButton"  
						id="getviewLeaveDetails"> <br>
					
				</p>
			</div>
		</div>
		
	</center>
 <!-- <p align="center"><input type="button" value="Leave Request" class="linkButton"	id="getleaveRequest">&nbsp;&nbsp;<input type="button" value="Leave Request Status" class="linkButton"	id="getleaveRequestStatus">&nbsp;&nbsp;<input type="button" value="View Leave Details" class="linkButton"	id="getviewLeaveDetails">&nbsp;&nbsp;</p> -->
<br></br>
<br></br><br></br><br></br><br></br>

    <logic:present name="ViewLeaveDetails" scope="request">
       <div class="tablecss" align="center"style="width: 60%; margin: 40px;margin-left:20%;">   
       <table>
          <tr>
              <th style="background-color: gray;color:white;font-size:14px;">Year</th>
                <th style="background-color: gray;color:white;font-size:14px;">Leave Type</th>
              <th style="background-color: gray;color:white;font-size:14px;">Opening Balance</th>
               <th style="background-color: gray;color:white;font-size:14px;">Leaves Consumed</th>
               <th style="background-color: gray;color:white;font-size:14px;">Closing Balance</th>
          </tr>
       <logic:iterate id="iterateid" name="ViewLeaveDetails">
           <tr>
              <td><bean:write name="iterateid" property="accyear"/></td>
              <td><bean:write name="iterateid" property="leavetype"/></td>
              <td><bean:write name="iterateid" property="openingbal"/></td>
               <td><bean:write name="iterateid" property="consumebal"/></td>
              <td><bean:write name="iterateid" property="closingbal"/></td>
           </tr>
       </logic:iterate>
       </table>
        </div>
    </logic:present>
<br/>
<span id="goBack" onclick="goBack()" style="margin-left: 90%; text-decoration: underline; cursor: pointer;">Go back to Home</span>
</body>
</html>