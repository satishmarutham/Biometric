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
<title>Attendance approval</title>

<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
</head>
<body>
	<div id="main">

		<div class="background" id="backgroung"></br>
			<center>
				<div class="backgroundDiv" id="backgroung" style="width: 100%">Employee Attendance Not Approved</div>
				<div id="errordiv" class="error-box" style="width: 19%">

					<logic:present name="message" scope="session">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="message" />
						</span>
					</logic:present>
				</div>
			</center>
			

	<div  class="tablecss" style="width:50%;margin:40px auto;">

	

			<display:table id="employeeNotApproved" name="EmployeeNotApproved"
				 export="false" decorator="com.centris.decorator.AttendenceNotApprovedDecorator"
				requestURI="/managerMenu.do?parameter=getAttendanceNotApprovedByManager" pagesize="25">

				<display:column property="sno" title="Sl No" />
				<display:column property="empName" title="Employee Name"/>
				<display:column property="postedDate" title="Last Posted Date and Time"/>
				<display:column property="startDate" title="Attendance Start Date"/>
				<display:column property="endDate" title="Attendance End Date"/>
				<display:column property="view" title=""/>
				

			</display:table>



	</div>
	


		</div>
	</div>

</body>
</html>