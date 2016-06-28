<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
 <%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>

<% String username = (String)session.getAttribute("username");
	if(username== null){
		%>
		
		<jsp:forward page="login.jsp"></jsp:forward>
			
		 <%
	}else{
		

	}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<link rel="shortcut icon" href="images/favicon.ico">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Shift Amendment</title>
		<link rel="stylesheet" type="text/css" href="css/weekoff.css" />
		<link rel="stylesheet" type="text/css" href="view.css" />
		<link rel="stylesheet" type="text/css" href="JQUERY/css/smoothness/jquery-ui-1.9.2.custom.css" />
		<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
			<script type="text/javascript" src="js/ShiftAmendment.js"></script>
	</head>
	<body>
	<div id="imageDiv" style="z-index:2;background:transparent;display:none;position:absolute;top:0px;left:0px;"></div>
		<jsp:include page="header_menu.jsp"></jsp:include>               
     	<br></br><br/> <br/>
		<center> 
		<font style="font-family: sans-serif; font-weight: bolder; color: #000000; font-size: 17px;">Shift Amendment</font>
		</center><br></br>
		<p id="alertMessage" style="color:red;width:100%;text-align: center;"><logic:present name="serverMessage" scope="request"> <bean:write name="serverMessage"/></logic:present></p>
		 <html:form action="/shiftAmendment" method="post" >
		<html:hidden property="method" value="getShiftAmendment"/>
		<input type="hidden" id="mailMessage" value='<logic:present name="sendMessage" scope="request"> <bean:write name="sendMessage"/></logic:present>'/>
		<table align="center" id="biometric" style="width:400px;">
			<tr>
			<td>Select Department<br/>
			<select name="department" id="empdepartment">
			<option value="All">All</option>
			<logic:present name="empDepartment" scope="session">
			<logic:iterate id="department" name="empDepartment" scope="session">
				<option value='<bean:write name="department" property="empdepartmentid" />,<bean:write name="department"  property="empdepartmentname"/>'><bean:write name="department"  property="empdepartmentname"/></option>
			</logic:iterate>
			</logic:present>
			</select>
			
			</td>
			
				<td class="USER_LOCATION">Select Location<br/>
					<select class="userLocationId" name="Location"></select>
				</td>
			
			<td>Select Current Shift<br/>
			<select id="empShift" name="shift" class="shiftClassForAdmin">
			<option value="All">All</option>
			<logic:present name="empShiftList" scope="session">
			<logic:iterate id="shift" name="empShiftList" scope="session">
				<option value='<bean:write name="shift" property="shiftId" />'><bean:write name="shift"  property="shiftName"/></option>
			</logic:iterate>
			</logic:present>
			
			</select>
			
			</td>
			
		
			
			</tr>
			<tr>
				<td  align="center" style="padding-top: 10px;" colspan="4">
				<html:submit  value="Show Employee - Shift" styleClass="button1" />
			</td>
			</tr>

			</table>
			<br></br>
			
			<div style="width:100%;">
	<display:table export="false" class="displayTableClass"   id="biometric" cellspacing="3" cellpadding="3" style="font-family: Segoe UI;width:70%;margin:0 auto;" name="requestScope.employeeShiftList" decorator="com.centris.decorator.ShiftAmendmentDecorator" requestURI="/shiftAmendment.do?method=getShiftEmployeeDetails" pagesize="20" >
		
			<display:column property="empId" title="Emp Id"        style="text-align:center;" sortable="false"  />
			<display:column property="empName"  title="Emp Name"    style="text-align:center;" sortable="false"/>
			<display:column property="department" title="Department Name" style="text-align:center;" sortable="false"/>
			<display:column property="currentShift" title="Current Shift" style="text-align:center;" sortable="false"/>
			<display:column property="updatedDate"   title="Shift Updated"          style="text-align:center;" sortable="false"/>
			<display:column property="modifyShift"     title="Modify Shift"            style="text-align:center;" sortable="false"/>
			<display:column property="approve"     title="Status"            style="text-align:center;" sortable="false"/>
			
		</display:table>
	</div>
	 </html:form>
	 	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>