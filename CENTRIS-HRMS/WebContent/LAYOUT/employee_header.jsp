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

</head>
<body>
	 <div style=" background-image: url(images/ADMINbg.jpg);">
	<div class="mains">
	<img src="images/centris.png" align="left" height="50px"
			width="200px" style="padding-top: 10px; padding-left:10px;padding-bottom:10px"/>

	</div>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	<table width="80%">
		<tr>
			<td nowrap="nowrap" align="right" style="padding-right:10px;"><logic:present
					name="UserDetails" scope="session">
					<b> <!-- <td align="left" width="20%">Upload New Image <br /> <input
				type="file" id="empImage" name="empImage" /></td> --> <img
						src="<bean:write name="UserDetails" property="employeeImage" />"
						width="50px" height="50px" id="ImagePreview">
					</b>
				</logic:present></td>
			<td style=" white-space: nowrap; width: 250px; padding-right: 10px;"><font
				color="blue">&nbsp;&nbsp;Welcome - <span
					style="color: green;"> <bean:write name="UserDetails"
							property="userFirstName" />
				</span>
			</font></td>
			<td width="100px"><html:link
					action="/GetDetails.do?parameter=logout"
					style="  color: red;text-decoration: none;font-size:14px; font-family:Segoe ui ;">
					<img src="images/logout.png" align="left" height="22px"
						name="logout" width="22px" />&nbsp; Logout 
			</html:link></td>
			
			
	
			
			
			
		</tr>
	</table>
	</div>
</body>
</html>