<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Department Master</title>

<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="js/Admin/departmentMaster.js"></script>
<link rel="stylesheet" href="css/weekoff.css">
<link rel="stylesheet" href="JQUERY/css/jquery.ui.all.css" />
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>

</head>
<body>


	<div align="center" id="main">
		<center>
		
			<table width="100%">
				<tr>
					<td>
						<div align="center" class="background" id="backgroung">
							

							<div class="backgroundDiv" id="backgroung">Department Master</div>
								<center>
								<div id="errordiv" class="error-box">
								<logic:present name="status" scope="request">
										<span style="color: green; font-family: Segoe UI;"> <bean:write
												name="status" />
										</span>
										</logic:present>
								</div>
							
							</center>
							<logic:present name="UserDetails" scope="session">
								<logic:iterate id="daymap" name="UserDetails"
									property="permissionmap" scope="session">
									<logic:equal value="DEPTINSERT" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">
											<div align="right" style="margin-right: 130px">

												<input type="button" name="insert" class="submitbutton"
													value="Add Department" onclick="insertDepartment()" />

											</div>
										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
							<center>
							<!-- <fieldset style="width: 80%;"> -->
								<!-- 	<div class="tablecss" style="width: 80%; margin: 20px;">
 -->								<display:table class="view" style="width:70%;"
										requestURI="departmentMaster.do?parameter=getDepRecords"
										id="depRecords" name="requestScope.depRecords" pagesize="25">
										<tr>
											<td><display:column property="depId"
													title="Department ID" style="text-align:center;" /></td>
											<td><display:column property="depName"
													title="Department Name" style="text-align:center;" /></td>
											<td><display:column property="desc" title="Description"
													style="text-align:center;" /></td>


											<%-- <td><display:column property="locManagerMail"
													title="LocalManagerMail" style="text-align:center;" /></td>



											<td><display:column property="hrManagerMail"
													title="HrManagerMail" style="text-align:center;" /></td>


											<td><display:column property="onsiteManagerMail"
													title="OnsiteManagerMail" style="text-align:center;" /></td> --%>

											<logic:present name="UserDetails" scope="session">
												<logic:iterate id="daymap" name="UserDetails"
													property="permissionmap" scope="session">
													<logic:equal value="DEPTUPDATE" name="daymap"
														property="key">
														<logic:equal value="true" name="daymap" property="value">

															<td><display:column title="Update">


																	<a href="#" style="color: blue"
																		onclick="updateDepartment('${depRecords.depId}','${depRecords.depName}','${depRecords.desc}','${depRecords.locManagerMail}','${depRecords.hrManagerMail}','${depRecords.onsiteManagerMail}')">Update</a>

																</display:column></td>

														</logic:equal>
													</logic:equal>
												</logic:iterate>
											</logic:present>

											<%-- '${depRecords.depId}','${depRecords.depName}','${depRecords.desc}','${depRecords.locationname}','${depRecords.locationid}' --%>
											<c:set var="user2" value="HR-1" />

											<logic:present name="UserDetails" scope="session">
												<logic:iterate id="daymap" name="UserDetails"
													property="permissionmap" scope="session">
													<logic:equal value="DEPTDELETE" name="daymap"
														property="key">
														<logic:equal value="true" name="daymap" property="value">


															<td><display:column title="Delete"
																	href="departmentMaster.do?parameter=deleteDepartment"
																	paramId="depId" paramProperty="depId"> Delete
          </display:column></td>

														</logic:equal>
													</logic:equal>
												</logic:iterate>
											</logic:present>
											<td></td>
										</tr>
									</display:table>
<br/>
							<!-- 	</div> -->
								<!-- </fieldset> -->
							</center>
					</td>
				</tr>
			</table>
		</center>
	</div>

	<!--  form division starting here   -->

	<div id="view-dialog" align="center" style="display: none; font-size: 10px;background-color: #F2F0E7" 
		title="Department Master">
				<form id="insertDepForm" method="post">
				<br>
				<center><div id="error" class="error-box" style="display: none;width:70%;"></div></center>
				<table cellpadding="5" cellspacing="0" id="biometric" width="90%" class="dialogclass">
				  <tr>
    					<td class="leftindialog">Department<span style="color: red">*</span></td>
						<td class="rightindialog"><input type="text" id="depName" name="depName" value="" maxlength='50'
							onblur="validateDeptName()" /></td>
				  </tr>
				 	  <tr>
				  	<td class="leftindialog" colspan="1">Description<span style="color: red"></span></td>
				  	<td class="rightindialog"><textarea  id="depDesc" name="desc" rows="2" cols="22" style="font-size:12px !important;"></textarea></td>
				</tr>
				</table>		
				<input type="hidden" id="departmentid"></input> <span id="error"style="color: red; font-size: 13px"></span>
			</form>
		</div>

<!-- form division ending here    -->

</body>
</html>


