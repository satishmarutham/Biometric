<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Daily Allowance</title>

<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<script language="javascript"
	src="js/Manager/UploadDailyAllowanceByManager.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
</head>
<body>
	<div id="main">

		<div class="background" id="backgroung">
			<br />
			<center>
				<div class="backgroundDiv" id="backgroung" style="width: 100%">Employee
					Daily Allowance</div>
				<div id="errordiv" class="error-box" style="width: 19%">

					<logic:present name="message" scope="request">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="message" />
						</span>
					</logic:present>
					<logic:present name="error" scope="request">
						<span style="color: red; font-family: Segoe UI;"> <bean:write
								name="error" />
						</span>
					</logic:present>
				</div>
			</center>
			<form action="empDailyAllowance.do" name="empDailyAllowance"
				method="post" enctype="multipart/form-data">
				<input type="hidden" value="getEmployeeDailyAllowance" name="method" />
				<table cellpadding="4" cellspacing="3" id="biometric" width="50%"
					style="margin: 0 auto;">


					<tr>
						<td><input type="file" name="dailyAllowanceFile"
							id="dailyAllowanceFile" /></td>
						<td><input type="submit" value="Upload" class="submitbutton"
							id="uploadAllowance" /> <input type="button"
							id="dailyAllowanceFormat" value="Download Daily Allowance Format"
							class="submitbutton" /></td>
					</tr>
				</table>
			</form>
			<logic:present name="uploadedFileDetails" scope="request">
				<div class="tablecss" style="width: 40%; margin: 20px;  margin-left: 30%;" id="tableId">
					<display:table id="emplist" name="uploadedFileDetails"
						export="false"
						requestURI="/empDailyAllowance.do?method=getEmployeeDailyAllowance"
						pagesize="10" decorator="com.centris.decorator.UploadDailyAllowanceByManager">

						<display:column property="slno" title="Sl no " />
						<display:column property="uploadedDate" title="Uploaded Date" />
						<display:column property="uploadedTime" title="Uploaded Time" />
						<display:column property="download" title="Download" />

					</display:table>
				</div>
			</logic:present>
		</div>
	</div>

</body>
</html>