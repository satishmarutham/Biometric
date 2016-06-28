<!-- Written By Ratna -->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd ">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
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


<link rel="stylesheet" href="css/Menu/layout.css" type="text/css"
	media="all" />
</head>
<body oncontextmenu="return false;">
	<div>
		<center>
			<table id="layout">
				<tr class="header">
					<td height="10px;"><tiles:insert attribute="header" /></td>
				</tr>
				<tr class="menu">
					<td><tiles:insert attribute="menu" /></td>
				</tr>
				<tr>
					<td valign="top" id="bodycontent"
						style="height: 500px; width: 900px;"><tiles:insert
							attribute="body" /></td>
				</tr>
				<tr>
					<td><tiles:insert attribute="footer" /></td>
				</tr>
			</table>
		</center>
	</div>
</body>
</html>
