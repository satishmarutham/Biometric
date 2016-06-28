<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet"
	href="JQUERY/css/jquery-ui.css" />
<script type="text/javascript"
	src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.effect-blind.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<script type="text/javascript"
	src="JQUERY/js/jquery.ui.datepicker.js"></script>

<%-- <script type="text/javascript"
	src="JS/Admin/Admin.js"></script> --%>
<script type="text/javascript"
	src="js/groupDepartmentDetails.js"></script>
<script type="text/javascript"
	src="js/groupDepartmentMapping.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GROUP  DEPARTMENT MAPPING</title>

<style type="text/css">
select[multiple] {
	width: 200px;
}
</style>
</head>
<jsp:include page="header_menu.jsp"></jsp:include>
<body>
<br><br><br/> <br/>
	<center>
	<font
									style="font-family: sans-serif; font-weight: bolder; color: #000000; font-size: 17px;">Group - Department Mapping</font>
	</center>
	<br>
	<center>
		<form name="myform" action="groupDepartment.do">
		<span id="error" style="color: red;"></span>
			<fieldset
				style="width: 40%; border-color: #000000; border-width: 2px;">
				
				<table border="0" cellspacing="0" cellpadding="5">
					<tr>
                        
						<td align="center" colspan="3"><span><b>Select Group</b></span>
						
						<select style="width: 100px;" id="group" name="group">
						<option value="">--select--</option>
						</select></td>
					</tr>
					<tr>
						<td valign="top"><span><b>Available Department</b></span><br />
							<select id="original" multiple="multiple" size="10"
							style="width: 55">
								
						</select></td>
						<td>
							<table border="0">
								<tr>
									<td><input type="button" name="placement" value="&gt;"
										onclick="addIndivudualtext();" width="50px"></td>
								</tr>
								<tr>
									<td><input type="button" name="placement" value="&lt;"
										onclick="deselectIndivivdualData()" width="50px"></input></td>
								</tr>
								<tr>
									<td><input type="button" onclick="deSelectData()"
										value="&lt;&lt;" width="50px"></input></td>
								</tr>
								<tr>
									<td><input type="button" width="50px" value="&gt;&gt;"
										onclick="addtext()"></td>
								</tr>
							</table>
						</td>
						<td><span><b>Select Department</b></span><br /> 
						<select id="copy"  size="10" style="width: 200px" multiple="multiple"  ></select></td>
					</tr>
				</table>
				 <input type="button" value="Save" name="Save" class="button1" onclick="assign()"/>
			</fieldset>
		</form>
	</center>
</body>
<br></br><br>
<hr>
<jsp:include page="footer.jsp"></jsp:include>

</html>