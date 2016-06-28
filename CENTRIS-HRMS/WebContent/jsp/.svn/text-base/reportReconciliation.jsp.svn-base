<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<jsp:include page="/jsp/header_menu.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REPORT RECONCILIATION</title>
<script type="text/javascript" src="js/NreportReconcil.js"></script>
<link rel="stylesheet"
	href="JQUERY/development-bundle/themes/base/jquery.ui.all.css">
<script src="JQUERY/development-bundle/jquery-1.8.3.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.core.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.widget.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.position.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.menu.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.draggable.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.resizable.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.dialog.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.effect.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.datepicker.js"></script>

<script type="text/javascript"
	src="JQUERY/development-bundle/ui/jquery.ui.button.js"></script>
<link rel="stylesheet" href="../demos.css">
<link rel="stylesheet" href="css/weekoff.css">
<script type="text/javascript">
	function formCheck() {

		var selectEmployee = document.getElementById('selectEmployee').value;

		var employeeDate = document.getElementById('employeeDate').value;

		if (selectEmployee == "" && employeeDate == "") {
			document.getElementById('error').innerHTML = 'Please Select the Employee and Date';
			return false;
		}
		if (selectEmployee == "") {

			document.getElementById('error').innerHTML = 'Select Employee';

			return false;
		}
		if (employeeDate == "") {
			document.getElementById('error').innerHTML = 'Select Date';
			return false;
		}

		return true;
	}
</script>
<style>
.ui-autocomplete-loading {
	background: white url('images/ui-anim_basic_16x16.gif') right center
		no-repeat;
}

#city {
	width: 25em;
}
</style>
</head>
<body>
	<center>
		<br> <br> <br><br/> <br/><font
			style="font-family: sans-serif; font-weight: bolder; color: #000000; font-size: 17px;">
			REPORT RECONCILIATION</font> <br> <br> <span
			class="WeekOFFErrorMsg" style="color: red;" id="error"> </span>
		<logic:present name="weekoffsuccess" scope="request">
			<span class="WeekOFFErrorMsg" style="color: green;" id="error1">
				<bean:write name="weekoffsuccess" scope="request" />
			</span>
		</logic:present>

		<br> <br>
		<html:form action="/offreportreconcil">
			<table cellpadding="3" cellspacing="2" id="biometric">

				<tr align="center">
					<td colspan="3"><b>Select Employee </b><br> <input
						id="emp" name="employeeName" class="search"></td>
					<td colspan="3"><b>Select Date </b> <br> <input id="date"
						name="employeeDate" class="search"></td>
					<td colspan="2" align="center"><html:submit
							property="parameter" onclick="return validateForm()"
							styleClass="button1">Getdata</html:submit></td>
				</tr>

			</table>
			<div>
				<center></center>
			</div>
		</html:form>
	</center>
	<br></br>
	<br></br>
	<br></br>
	<br></br><br></br></br>
	<hr></hr>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>