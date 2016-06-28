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
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Resume</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.position.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.menu.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="js/Manager/EmployeeResumeDownload.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

</head>




</head>
<body>
<div id="main">

		<div class="background" id="backgroung">
			</br>
			<center>
				<div class="backgroundDiv" id="backgroung" style="width: 100%">Employee Resume</div></center></div></div>
				<center>
					<div id="errordiv" class="error-box" style="width: 19%">

					<logic:present name="message" scope="session">
						<span style="color: red; font-family: Segoe UI;">
						</span>
					</logic:present>
					
				</div>
						<table id="biometric" align="center">
							<tr>
							<tr class="trc">
						 <tr>
							
							
									<%-- <td align="left" class="trd">Select Employee<font
									color="red">*</font><br /></td><td> <select name="emplyeeid"
									id="employee">
										<option value="">-----Select-----------</option>
										<logic:present name="emp_list" scope="session">
											<logic:iterate id="employee" name="emp_list">

												<option
													value='<bean:write name="employee" property="empid"/>'>
													<bean:write name="employee" property="empname" />
												</option>

											</logic:iterate>
										</logic:present>

								</select>
								</td> --%>
								<td align="left" valign="middle"><label for="driverName">Employee Name<font color="red">*</font></label></td>
						  <td align="left" valign="middle"><input type="text"
							name="emplyeeid" id="employee" placeholder="Search Here" /></td>
								
							<input type="hidden"
							id="employeeCode" />
							
							</tr> </table>
							</br>
							<table align="center">		
			<tr>	
								<td align="center" valign="middle"><input type="button"
									id="pdfBtnId" class="submitbutton" value="Download Pdf"></td>
									<td align="center" valign="middle"><input type="button"
									id="docBtnId" class="submitbutton" value="Download Word"></td>
								<td></td>
							</tr>
							</table>
				
				
				
				
				
</body>
</html>