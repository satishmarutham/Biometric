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

// can't go back

	/* window.history.forward(0); */

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

<link rel="stylesheet" href="/css/Menu/layout.css" type="text/css"
	media="all" />
</head>
<body >
	<div>
		<center>
			<table id="layout" cellspacing="0" height="100%">
				<tr class="header" height="100%">
					 <td colspan="2"  valign="bottom" align="right"  width="100%" style="background: #336699;">
					 <tiles:insert attribute="header" />
					 </td>
				</tr>
			<%-- 	<tr class="menu">
					<td width="100%"><tiles:insert attribute="menu" /></td>
				</tr> --%>
				<tr  class="header2">
				
					<td  valign="top" width="10%" style="height: 527px; background: #E8E8E8; line-height: 2em;padding-left:5px;">
						 <tiles:insert attribute="leftmenu" />
					</td>
					 <td  class="tblBody" valign="top" align="center" width="90%" style="height:527px;background:#fff;">
						<tiles:insert attribute="body" />
					</td>
							
				
				</tr>
				
				<tr>
					<td><tiles:insert attribute="footer" /></td>
				</tr>
			</table>
		</center>
	</div>
</body>

</html>