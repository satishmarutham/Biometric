<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Project Master</title>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<script type="text/javascript" src="js/Admin/ManagerMaster.js"></script>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
</head>

<BODY>
	<br />
	<div class="background" id="backgroung">
		<br />
		<center>
			<div class="backgroundDiv" id="backgroung">Manager Details</div>
		</center>
		<form action="managerMaster.do">
			<center>
			<div id="errordiv" class="error-box" align="center">
					<logic:present name="message" scope="request">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="message" />
						</span>
					</logic:present>
				</div>

				<fieldset style="width:75%;">
				<br/>
					<table cellpadding="5" cellspacing="0" id="biometric" width="75%">

						<tr class="trc">
							<td class="left">First Name<font color="red">*</font></td>
							<td class="right"><input type="text" name="firstname" id="firstName" /></td>
							<td class="left">Last Name<font color="red">*</font></td>
							<td class="right"><input type="text" name="lastname" id="lastName" /></td>
						</tr>
						<tr class="trc">
							<td class="left">Phone No<font color="red">*</font></td>
							<td class="right"><input type="text" maxlength="10" name="mobileno"
								id="mobileNO" /></td>
     						<td class="left">User Name<font color="red">*</font></td>
     						<td class="right"><input type="text" name="username" id="userName" /></td>
     					</tr>	
     					<tr class="trc">
							<td class="left">Email<font color="red">*</font></td>
							<td class="right"><input type="text" name="manageremail" id="managerEmail" /></td>
							<td class="left">Department<font color="red">*</font></td>
							<td class="right"><select 
									name="department" id="department" style="width:100%;">
										<option value="">-----Select-----</option>
										<logic:present name="departmentDetails" scope="session">
											<logic:iterate id="department" name="departmentDetails"
												scope="session">
												<option
													value='<bean:write name="department" property="depId"  />'>
													<bean:write name="department" property="depName"/>
												</option>
											</logic:iterate>
										</logic:present>
								</select>
		           			</td>
						</tr>
					</table>
						<br/>
				</fieldset>
				<input type="hidden" id="managerId" name="managerid" /> <br/>


				<html:submit value="Add" styleClass="submitbutton" styleId="addbtn"
					property="parameter" onclick="return validations()" />
				<input type="reset" value=" Clear " class="submitbutton"
					onclick="cleardata()" /> <input type="button" value="  Edit  "
					class="submitbutton" onclick="editManager()" />
				<html:submit value="Update" styleClass="submitbutton"
					property="parameter" onclick="return validationsUpdate()" />


				<input type="button" value=" Delete " class="submitbutton"
					onclick="deleteManager()" />


			</center>

		</form>

		<center>

			<div class="tablecss" align="center"
				style="width: 40%; margin: 40px;">

				<logic:present name="ManagerList" scope="request">
					<display:table id="manager" name="ManagerList" export="false"
						requestURI="/managerMaster.do?parameter=managerMasterHome"
						pagesize="25">

						<display:column
							title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />">
							<input type="checkbox" name="selectBox" id="selectBox"
								value="${manager.managerid}" />
						</display:column>

						<display:column property="firstname" title="First Name"
							class="cellintag" />
						<display:column property="lastname" title="Last Name" />
						<display:column property="mobileno" title="Phone No" />
						<display:column property="username" title="User Name" />
						<display:column property="manageremail" title="Email" />
					<display:column property="departmentName" title="Department" /> 

					</display:table>

				</logic:present>

			</div>
		</center>

	</div>

</BODY>



</html>
