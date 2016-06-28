<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <jsp:include page="/jsp/header_menu.jsp"></jsp:include> --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Department Master</title>

<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>

<link rel="stylesheet" href="JQUERY/css/jquery.ui.all.css" />

<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script src="JQUERY/js/jquery.ui.mouse.js"></script>
<script src="JQUERY/js/jquery.ui.draggable.js"></script>
<script src="JQUERY/js/jquery.ui.position.js"></script>
<script src="JQUERY/js/jquery.ui.resizable.js"></script>
<script src="JQUERY/js/jquery.ui.effect.js"></script>
<script src="js/departmentMaster.js"></script>
<link rel="stylesheet" href="css/weekoff.css">
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/Department.css"></link>

</head>
<body>


	<div align="center" id="main">
		<center>
			<br>
			<table width="100%">
				<tr>
					<td>
					
						<div align="center" class="background" id="backgroung" ></br>
						
						<div class="backgroundDiv" id="backgroung">Department Master</div></br>	
						
							<center>
						<div id="errordiv" class="error-box">
							
							<logic:present name="status" scope="request">
								<span style="color: green; font-family: Segoe UI;">
									<bean:write name="status"/>
								</span>
							</logic:present>
						</div>
					</center>
 				 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="DEPTINSERT" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
									<div align="right" style="margin-right: 130px">

										<input type="button" name="insert" class="submitbutton"
											value="Add Department" onclick="insertDepartment()" />

									</div>
					 </logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
									<center>
									<div  class="tablecss" style="width:80%;margin:20px;">	
									
									<display:table 
										requestURI="departmentMaster.do?parameter=getDepRecords"
										id="depRecords" name="requestScope.depRecords" pagesize="25">
										<tr>
											<td ><display:column property="depId"
													title="Department ID" style="text-align:center;" /></td>
											<td ><display:column property="depName"
													title="Department Name" style="text-align:center;"/></td>
											<td ><display:column property="desc" title="Description" style="text-align:center;"/>

											</td>
											
											
											<td ><display:column property="locManagerMail" title="LocalManagerMail" style="text-align:center;"/>

											</td>
											
											
											
											<td ><display:column property="hrManagerMail" title="HrManagerMail" style="text-align:center;"/>

											</td>
											
											
											<td ><display:column property="onsiteManagerMail" title="OnsiteManagerMail" style="text-align:center;"/>

											</td>
										
<logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="DEPTUPDATE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
           
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
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="DEPTDELETE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
						

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
									
									</div>
									</center>
						
					</td>
				</tr>
			</table>
		</center>
	</div>

	<!--  form division starting here   -->
	
	<div id="insertDep" align="center" style="display: none;" title="Department Master">
		<div>
			<form id="insertDepForm" method="post">
				<span id="message"></span> <br>
				
					<center>
						
						 <div  id="successmsg" >
							<span id="fail"></span>
						</div>	
						
						
					   
						</center>
				<table id="depMasterTable" align="center">

					<tr>
					
					<td>Department<span style="color: red">*</span>
					<input type="text" id="depName" name="depName" value="" maxlength='50' onblur="validateDeptName()"/>
					</td>
					<td colspan="1">Description<span style="color: red">*</span>
					<input type="text" id="depDesc"name="desc" value="" />
					</td></tr><tr>
					<td>HrManagerMail<span style="color: red">*</span>
					<input type="text" id="hrManagerMailId" name="hrManagerMail" value="" maxlength='50' onblur="validateHrMngrMail()"/>
					</td>
					<td>LocalManagerMail<span style="color: red">*</span>
					<input type="text" id="locManagerMailId"name="locManagerMail" value="" />
					</td>
					<td>OnSiteManagerMail<span style="color: red">*</span>
					<input type="text" id="onsiteManagerMailId"name="onsiteManagerMail" value="" />
					</td>
				</tr>


				</table>
				<input type="hidden" id="departmentid"></input>
				<span id="error" style="color: red; font-size: 13px"></span>


			</form>


		</div>
	</div>



	
	

	<!-- form division ending here    -->

	
</body>

</html>


