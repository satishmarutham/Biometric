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
	<div class="mains">
		<img src="images/bioHeadeimage1.png" align="left" height="80px" width="85%" />

	</div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
	 <div align="right">
			<table>
			<tr>
			<td>
			<logic:present name="UserDetails" scope="session">
						<b><font color="blue">&nbsp;&nbsp;Welcome - <span style="color: green;"> <bean:write name="UserDetails" property="userFirstName"/> </span> </font></b>
			</logic:present>
			</td>
			</tr>
			
			<tr>
			<td>
			<logic:present  name="UserDetails" scope="session"><b><font color="blue">&nbsp;&nbsp;Group :<span style="color: green;">  <bean:write name="UserDetails" property="groupName" scope="session"/></span></font></b></logic:present>
			
			</td>
			</tr>
			
			
			</table>
			
			
			</div>

</body>
</html>