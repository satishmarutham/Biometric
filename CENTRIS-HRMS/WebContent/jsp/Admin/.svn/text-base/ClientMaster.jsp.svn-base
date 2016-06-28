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
<title>Client Master</title>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<script type="text/javascript" src="js/Admin/ClientMaster.js"></script>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
</head>

<body>
	
	<div class="background" id="backgroung">

		<center>
			<div class="backgroundDiv" id="backgroung">Client Details</div>

			<form action="clientMasterPath.do">


				<div id="errordiv" class="error-box" align="center">

					<logic:present name="message" scope="request">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="message" />
						</span>
					</logic:present>
				</div>

				
					<br/>
					<table cellpadding="8" cellspacing="0" id="biometric" width="80%">

						<tr class="trc">

							<td class="left">Client Name<font color="red">*</font></td>
							<td class="right"><input type="text" name="clientName"
								id="clientNameId" /></td>

							<td class="left">Phone No<font color="red">*</font></td>
							<td><input type="text" name="phoneNo" id="phoneNoId"
								maxlength="11" /></td>
						</tr>

						<tr class="trc">
							<td class="left">Country <font color="red">*</font></td>
							<td class="right"><input type="text" name="country"
								id="countryId" /></td>

							<td class="left">State<font color="red">*</font></td>
							<td class="right"><input type="text" name="state"
								id="stateId" /></td>
						</tr>
						<tr class="trc">
							<td class="left">Address<font color="red">*</font></td>
							<td class="right" colspan="3"><textarea rows="2" cols="80"
									name="address" id="addressId"></textarea></td>
						</tr>
					</table>

					<input type="hidden" id="clientCodeId" name="clientCode" /> <br />


					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="CLNTINSERT" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">
									<html:submit value="Add" styleClass="submitbutton"
										styleId="addbtn" property="method"
										onclick="return validations()" />
									<input type="reset" value=" Clear " class="submitbutton"
										onclick="cleardata()" />

								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>


					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="CLNTUPDATE" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">
									<input type="button" value="  Edit  " class="submitbutton"
										onclick="editClientMaster()" />
									<html:submit value="Update" styleClass="submitbutton"
										property="method" onclick="return updateClientDetails()" />

								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>


					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="CLNTDELETE" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">

									<input type="button" value=" Delete " class="submitbutton"
										onclick="deleteClientDetails()" />
								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>

				




			</form>



			<logic:present name="clientDetails" scope="request">


				<display:table id="manager" name="clientDetails" export="false" 
					requestURI="/GetDetails.do" pagesize="25"
					decorator="com.centris.decorator.ClientMasterDecorator"
					class="view" style="width:60%;">

					<display:column
						title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />">
						<input type="checkbox" name="selectBox" id="selectBox"
							value="${manager.clientCode}" />
					</display:column>


					<display:column property="clientName" title="ClientName" />
					<display:column property="country" title="Country" />
					<display:column property="state" title="State" />
					<display:column property="address" title="Address" />
					<display:column property="phoneNo" title="Phone No" />




				</display:table>

			</logic:present>


		</center>
		<br />
	</div>







</body>



</html>
