<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
 <%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<title>ATTENDANCE RECONCILATION</title>
	<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>

<link rel="stylesheet" href="JQUERY/css/jquery.ui.all.css" />

<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="js/Admin/AttendanceReconcilation.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<!-- <link rel="stylesheet" href="css/attendanceReconcil.css"></link> -->
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>

	</head>
<body>
	<br />
	<div class="background" id="backgroung">

 	 <center><div class="backgroundDiv" id="backgroung">Attendance Reconcilation</div></center>
 	 
			<center>
				<div id="errordiv" class="error-box" align="center" >
					<logic:present name="successMsg" scope="request">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="successMsg" scope="request" />
						</span>
					</logic:present>
					<logic:present name="failureMsg" scope="request">
						<span style="color: red; font-family: Segoe UI;"> <bean:write
								name="failureMsg" scope="request" />
						</span>
					</logic:present>
				</div></center>
				<center>
		
         
				<table cellpadding="8" cellspacing="5" id="biometric" >

			<tr class="trc">
				
					<td class="left" >Department<font color="red">*</font>
							<input type="checkbox" name="deptcheckbox" id="deptcheckbox" value="all" onclick="selectAllDepartments()"/>select all</br>
							<select name="department" id="department" multiple="multiple" style="width: 100%;">
							<logic:present name="AllDepartments" scope="request">
							<logic:notEmpty name="AllDepartments" scope="request">
							<logic:iterate id="iterateid" name="AllDepartments" scope="request">
							<option value="<bean:write name="iterateid" property="deptid"></bean:write>"><bean:write name="iterateid" property="deptname"></bean:write>
							</option>
							</logic:iterate>
     						</logic:notEmpty>
							</logic:present>
							</select></br>
							
					</td>
					<td class="left" >Manager<font color="red">*</font>
							<input type="checkbox" name="mgrcheckbox" id="mgrcheckbox" value="all" onclick="selectAllManagers()" />select all</br>
							<select name="manager" id="manager" multiple="multiple" style="width: 100%;" >
								</select></br>
							
					</td>
				   
					<td class="left">Employee<font color="red">*</font>
							<input type="checkbox" name="empcheckbox" id="empcheckbox" value="all" onclick="selectAllEmployees()"/>select all</br>
							<select name="employee" id="employee" multiple="multiple" style="width: 100%;">
							</select>
					</td>
	         		<td  class="left">Select Date<font color="red">*</font><br />
								<input  name="date" id="date"  readonly="readonly" placeholder="Click Here"></input>
								
					</td>
						
					</tr>

				</table>
				
					
				<input type="button" value="Get Attendance Reconcil Details" class="submitbutton" id="Search"  />


			</center>
	<center>
	<table id="EmpAttendance" class="view" ></table><br/><br/>
	<span id="uploadbutton"></span> </center>
		
<br/><br/>
	</div>
<br/><br/><br/><br/><br/><br/>
</body>
</html>