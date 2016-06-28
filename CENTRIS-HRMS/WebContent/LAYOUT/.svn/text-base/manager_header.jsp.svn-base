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
<link type="text/css" href="css/Manager/Notification.css"
	rel="stylesheet" />
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script language="javascript" src="js/Manager/Notification.js"></script>

</head>
<body>
	 <div style=" background-image: url(images/ADMINbg.jpg);">
	<div class="mains">
	<img src="images/centris.png" align="left" height="50px"
			width="200px" style="padding-top: 10px; padding-left:10px;padding-bottom:10px"/>

	</div>
	<div class='notification'
		style="width: 35px; height: 35px; position: absolute; top: 38px; left: 600px;"
		data-count=''>
		<img id="imgNotification" src="images/notify1.png" width="30px"
			height="30px" style="cursor: pointer;"
			title="Employee Attendance Not Approved" />
	</div>
	<table>
		<tr>
			<td nowrap="nowrap" style="padding-left: 725px;"><logic:present
					name="UserDetails" scope="session">
					<b><font color="blue">&nbsp;&nbsp;Welcome - <span
							style="color: green;"> <bean:write name="UserDetails"
									property="userFirstName" />
						</span>
					</font></b>
				</logic:present></td>

			<td style="padding-left: 25px; white-space: nowrap;"><logic:present
					name="UserDetails" scope="session">
					<p style="padding-left: 40%;">
						<html:link action="/GetDetails.do?parameter=logout"
							style="  color: red;text-decoration: none;font-size:14px; font-family:Segoe ui ;">
							<img src="images/logout.png" align="left" height="27px"
								name="logout" width="27px" />&nbsp; Logout 
			</html:link>
					</p>
				</logic:present></td>

		</tr>

	</table>
	</div>
</body>
</html>