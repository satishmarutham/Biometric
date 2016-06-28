<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Master</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<script type="text/javascript" src="js/employeeRegistration.js"></script>
<script type="text/javascript" src="js/UserMaster.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>

</head>
<body>

	</br>
	</br>
	</br>


	<div id="main">
		<div class="background" id="backgroung">
			<center>
				<div class="backgroundDiv" id="backgroung" style="width: 100%">User
					Master</div>
				<div id="errordiv" class="error-box" style="width: 20%;">

					<logic:present name="message" scope="session">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="message" />
						</span>
					</logic:present>
				</div>
			</center>
			<br />
			<table align="center">

				<tr>
					<td><logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="USRINSERT" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<input type="button" value="Add" class="submitbutton"
											id="createUserBtnId" /> &nbsp;&nbsp;&nbsp;
					
						 </logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present> <logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="USRUPDATE" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<input type="button" value="Update" class="submitbutton"
											id="editUserBtnId" />&nbsp;&nbsp;&nbsp;
					
				</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present> <logic:present name="UserDetails" scope="session">
							<logic:iterate id="daymap" name="UserDetails"
								property="permissionmap" scope="session">
								<logic:equal value="USRDELETE" name="daymap" property="key">
									<logic:equal value="true" name="daymap" property="value">

										<input type="button" value="Delete" class="submitbutton"
											id="deleteUserBtnId" />

									</logic:equal>
								</logic:equal>
							</logic:iterate>
						</logic:present></td>
				</tr>
			</table>






			<div id="addDialog">
				<center>
					<p id="errordivaddDialog"
						style="font-size: 15px; font-family: Segoe UI; color: red;"></p>
				</center>
				<table cellpadding="8" cellspacing="5" id="biometric" width="100%">



					<tr class="trc">

						<td align="left" class="trd">Select Role<font color="red">*</font><br />
							<select name="roleCode" id="roleCodeId">
								<option value="">------Select----------</option>
						</select>
						</td>


						<td align="left" class="trd">User Location<font color="red">*</font><br />

							<select name="locationCode" id="locationCodeId">
								<option value="">------Select-------</option>
						</select>
						</td>

						<td align="left" class="trd">Select Group<font color="red">*</font><br />

							<select name="groupCode" id="groupCodeId">
								<option value="">------Select-------</option>
						</select>
						</td>
					</tr>


					<tr class="trc">
						<td align="left" class="trd">UserName<font color="red">*</font><br />
							<input type="text" id="adduserId" name="username" value="" onblur="currentUserNameCkeck()"
							maxlength="10" />
						</td>




						<td align="left" class="trd">Password<font color="red">*</font><br />
							<input type="password" id="passwordId" name="password" value=""
							maxlength="10" />
						</td>
						<td align="left" class="trd">Confirm Password<font
							color="red">*</font><br /> <input type="password"
							id="confirmpasswordId" name="password" value="" maxlength="10" />
						</td>
					</tr>

				</table>

			</div>





			<div id="editDialog">
				<center>
					<p id="errordiveditDialog"
						style="font-size: 15px; font-family: Segoe UI; color: red;"></p>
				</center>
				<table cellpadding="8" cellspacing="5" id="biometric" width="100%">
					<tr class="trc">
						<td align="left" class="trd">Select Role<font color="red">*</font><br />
							<select name="roleCode" id="roleCodeEditId">
								<option value="">------Select----------</option>
						</select> <input type="hidden" id="userCodeId" name="userCode" value="" />
						</td>


						<td align="left" class="trd">Select Location<font color="red">*</font><br />

							<select name="locationCode" id="locationEditCodeId">
								<option value="">------Select------</option>
						</select>
						</td>

						<td align="left" class="trd">Select Group<font color="red">*</font><br />

							<select name="groupCode" id="groupEditCodeId">
								<option value="">------Select-------</option>
						</select>
						</td>
					</tr>


					<tr class="trc">
						<td align="left" class="trd">UserName<font color="red">*</font><br />
							<input type="text" id="edituserId" name="username" value=""
							maxlength="10" />
						</td>

						<td align="left" class="trd">Password<font color="red">*</font><br />
							<input type="password" id="editpasswordId" name="password"
							value="" maxlength="10" />
						</td>
						<td align="left" class="trd">Confirm Password<font
							color="red">*</font><br /> <input type="password"
							id="editconfirmpasswordId" name="password" value=""
							maxlength="10" />
						</td>
					</tr>

				</table>



			</div>


			<center>
				<div class="tablecss" style="width: 40%; margin: 15px;">
					<display:table id="data" name="requestScope.usersList"
						class="displayTableClass" requestURI="/GetDetails.do"
						pagesize="25" export="false"
						decorator="com.centris.decorator.UserMasterDecorator">

						<display:column property="allCheckBox" sortable="false"
							media="html" title="Select" />
						<display:column property="username" sortable="false"
							title="User Name" />
						<display:column property="roleName" sortable="false"
							title="Role Name" />
						<display:column property="locationName" sortable="false"
							title="Location" />
						<display:column property="groupName" sortable="false"
							title="Group Name" />



						<br>
						<br>

						<display:setProperty name="export.pdf.filename"
							value="SecondShiftReport.pdf" />

						<display:setProperty name="export.pdf" value="true" />

						<display:setProperty name="export.excel.filename"
							value="UserMaster.xls" />
						<display:setProperty name="export.excel" value="true" />

						<display:setProperty name="export.csv.filename"
							value="UserMaster.csv" />
						<display:setProperty name="export.csv" value="true" />

						<display:setProperty name="export.xml.filename"
							value="UserMaster.xml" />
						<display:setProperty name="export.xml" value="true" />

					</display:table>

				</div>
			</center>
		</div>
</body>
</html>