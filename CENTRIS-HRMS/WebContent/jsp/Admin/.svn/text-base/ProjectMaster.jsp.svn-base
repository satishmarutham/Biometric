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
<script type="text/javascript" src="js/Admin/ProjectMaster.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
</head>

<BODY>
	
	<div class="background" id="backgroung">

		<center>
			<div class="backgroundDiv" id="backgroung">Project Details</div>
		</center>
		<form action="projectmaster.do" enctype="multipart/form-data" method="post">
			<center>
				<div id="errordiv" class="error-box" align="center">
					<logic:present name="message" scope="request">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="message" />
						</span>
					</logic:present>
				</div>
					
		<fieldset style="width: 70%;">
		<br/>
	
				<center>
					 <table   cellpadding="5" cellspacing="0" id="biometric">
			            <tr>
                           <td class="left">Client Name<font color="red">*</font></td>
                           <td class="right"><input type="text" name="clientname" id="clientname" onchange="ceateprojectrefCode()"  maxlength="2"/></td>
                  
						   <td class="left" >Project Type<font color="red">*</font></td>
						   <td class="right"><input type="text" name="projecttype"id="projecttype"  onchange="ceateprojectrefCode()" maxlength="2"/></td>
				  	 </tr><tr>	
						   <td class="left">Project Name<font color="red">*</font></td>
						   <td class="right"><input type="text" name="projectrefname" id="projectrefname" onchange="ceateprojectrefCode()" maxlength="3"/></td>
						   <td class="left">End Customer<font color="red">*</font></td>
						   <td class="right"><input type="text" name="endcustomer" id="endcustomer"  onchange="ceateprojectrefCode()" maxlength="3"/></td>
				     </tr><tr>			 
						   <td class="left">Location Name<font color="red">*</font></td>
						   <td class="right"><input type="text" name="projectreflocation" id="projectreflocation"  onchange="ceateprojectrefCode()" maxlength="2"/></td>
						   <td class="left">Project Date<font color="red">*</font></td>
						   <td class="right"><input type="text" name="projectrefdate" id="projectrefdate" 
								                      readonly="readonly" onchange="ceateprojectrefCode()" /></td>
					 </tr><tr>
					 		<td class="left" >Project Name<font color="red">*</font></td>
							<td class="right" ><input type="text" name="projectname" id="projectname"  /></td>
								
							<td class="left">Location<font color="red">*</font></td>
							<td class="right"><input type="text" name="projectlocation" id="projectlocation" /></td>
								
					 </tr><tr>	
					        <td class="left">Preview<font color="red">*</font></td>
						    <td class="right"><textarea rows="1" cols="20" id="projectrefcode" name="projectrefcode" readonly="readonly"  style="resize: none;background: #D9D9D9"></textarea></td>		
							 <td class="left">Project Guide</td>
							 <td class="right"> <input type="button" name="projectguide"	id="projectguide" value="DownloadProjectGuide" /></td>
					 </tr>
                     </table>
                 </center>
               <br/>
				</fieldset>

				<!-- <fieldset style="width: 85%;">
					<table cellpadding="8" cellspacing="5" id="biometric">

                        <tr>
                        
                           <td align="left" class="trd">Client Name<font color="red">*</font>
                           <br /><input type="text" name="clientname" id="clientname" onchange="ceateprojectrefCode()" maxlength="2" /></td>
						
							<td align="left" class="trd">Project Type<font color="red">*</font>
								<br /> <input type="text" name="projecttype"id="projecttype"  onchange="ceateprojectrefCode()" maxlength="2"/></td>
								
							<td align="left" class="trd">Project Ref Name<font color="red">*</font><br />
								<input type="text" name="projectrefname" id="projectrefname" onchange="ceateprojectrefCode()" maxlength="3"/></td>
						
							<td align="left" class="trd">End Customer<font color="red">*</font><br />
								<input type="text" name="endcustomer" id="endcustomer"  onchange="ceateprojectrefCode()" maxlength="3" /></td>
						
							<td align="left" class="trd">Location Ref Name<font color="red">*</font><br />
								<input type="text" name="projectreflocation" id="projectreflocation"  onchange="ceateprojectrefCode()" maxlength="2" /></td>
						
                        </tr>


						<tr class="trc">
						
						
							
                           					
						     <td align="left" class="trd">Project Ref Date<font color="red">*</font><br />
								<input type="text" name="projectrefdate" id="projectrefdate" 
								readonly="readonly" onchange="ceateprojectrefCode()" /></td>
						
						     					
							<td align="left" class="trd">ProjectRefCode<font color="red">*</font>
								<br /> <input type="text" name="projectrefcode"
								id="projectrefcode" readonly="readonly" style="width:98% !important;" /></td>
								
							<td align="left" class="trd">Project Name<font color="red">*</font><br />
								<input type="text" name="projectname" id="projectname"  /></td>
								
							<td align="left" class="trd">Location<font color="red">*</font><br />
								<input type="text" name="projectlocation" id="projectlocation" /></td>
								
								
							 <td align="left" class="trd">
								<br /> <input type="button" name="projectguide"
								id="projectguide" value="DownloadProjectGuide" /></td>

							


						</tr>
						


					</table>
				</fieldset> -->
				<input type="hidden" id="projectid" name="projectcode" /> <br></br>


				<logic:present name="UserDetails" scope="session">
					<logic:iterate id="daymap" name="UserDetails"
						property="permissionmap" scope="session">
						<logic:equal value="PJTINSERT" name="daymap" property="key">
							<logic:equal value="true" name="daymap" property="value">
							
								<html:submit value="Add" styleClass="submitbutton"
									styleId="addbtn" property="parameter"
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
						<logic:equal value="PJTUPDATE" name="daymap" property="key">
							<logic:equal value="true" name="daymap" property="value">
							
								<input type="button" value="  Edit  " class="submitbutton"
									onclick="editProject()" />
								<html:submit value="Update" styleClass="submitbutton"
									property="parameter" onclick="return validationsUpdate()" />
									
							</logic:equal>
						</logic:equal>
					</logic:iterate>
				</logic:present>


				<logic:present name="UserDetails" scope="session">
					<logic:iterate id="daymap" name="UserDetails"
						property="permissionmap" scope="session">
						<logic:equal value="PJTDELETE" name="daymap" property="key">
							<logic:equal value="true" name="daymap" property="value">
							
								<input type="button" value=" Delete " class="submitbutton"
									onclick="deleteProject()" />
									
							</logic:equal>
						</logic:equal>
					</logic:iterate>
				</logic:present>

			</center>

		</form>

		<center>

		<!-- 	<div class="tablecss" align="center"
				style="width: 40%; margin: 40px;"> -->
<br></br>
				<logic:present name="PROJECTLIST" scope="request">


					<display:table id="project" name="PROJECTLIST" export="false"
						requestURI="/GetDetails.do?parameter=getProjectMaster"
						pagesize="25" class="view" style="width:73%;">

						<display:column
							title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />">
							<input type="checkbox" name="selectBox" id="selectBox"
								value="${project.projectcode}" />
						</display:column>

						<display:column property="projectRefcode" title="ProjectRefCode" />
						<display:column property="projectname" title="Project Name"
							class="cellintag" />
						<display:column property="project_location" title="Location" />
						


						<display:setProperty name="export.pdf.filename"
							value="Project.pdf" />
						<display:setProperty name="export.pdf" value="true" />
						<display:setProperty name="export.excel.filename"
							value="Project.xls" />
						<display:setProperty name="export.excel" value="true" />
						<display:setProperty name="export.csv.filename"
							value="Project.csv" />
						<display:setProperty name="export.csv" value="true" />
						<display:setProperty name="export.xml.filename"
							value="Project.xml" />
						<display:setProperty name="export.xml" value="true" />

					</display:table>

				</logic:present>
<br></br>
			</div>



</BODY>



</html>
