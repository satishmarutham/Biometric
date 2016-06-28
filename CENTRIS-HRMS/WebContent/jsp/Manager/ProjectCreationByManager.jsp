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
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.menu.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="js/Manager/ProjectCreationByManager.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/Manager/ProjectMaster.css"></link>

</head>

<BODY>
	<br />
	<div id="loader1" style="position: absolute;top:350px;left:650px;display: none;"><img  src="images/loaderimage2.GIF"/></div>
	<div class="background" id="backgroung">

		
		<form action="projeccreationbymanager.do" enctype="multipart/form-data" method="post">

			<center>


				<div id="errordiv" class="error-box" align="center">
					
					<logic:present name="message" scope="request">
							<span style="color: green; font-family: Segoe UI;" > <bean:write
								name="message" />
						</span>
					</logic:present>
					<logic:present name="errorMessage" scope="request">
							<span style="color: red; font-family: Segoe UI;"> <bean:write
								name="errorMessage" />
						</span>
					</logic:present>
					
				
				</div>

				<div id="loader" style="position: absolute; top: 30%; left: 45%; display: none; "><img src="images/loaderimage2.GIF" width="150px" height="150px" /></div>
				
				<center>
				<br />
				<br />
					<table   cellpadding="5" cellspacing="0" id="biometric1" width="90%">
			

                      <tr>
<!-- 								<h3 colspan="5" class="head">Personal Details</h3> -->
							 <td colspan="5" class="head11" >	<span class="head11" > Project Details</span>
							
							  </td>
							</tr>
                        <tr>
                         
                        
                           <td align="left" class="trd"><center>Client Name<font color="red">*</font></center>
                          <center><input type="text" name="clientname" id="clientname" onchange="ceateprojectrefCode()" maxlength="2" style="width: 30px"  onkeyup="convertToUpper(this.id)"/></center>
                          <center><span class="helptext">(Only two Characters)</span></center>
                          </td>
                          
						   <td align="left" class="trd"> <center>Project Type<font color="red">*</font></center>
								<center><input type="text" name="projecttype"id="projecttype"  onchange="ceateprojectrefCode()" maxlength="2" style="width: 30px" onkeyup="convertToUpper(this.id)"/></center>
								<center><span class="helptext">(Only two Characters)</span></center>
								</td>
							
							
						  <td align="left" class="trd" ><center>Project High Level Activity<font color="red">*</font></center>
								<center><input type="text" name="projectHighLevelActivity" id="projectHighLevelActivity" onchange="ceateprojectrefCode()" maxlength="3" style="width: 30px" onkeyup="convertToUpper(this.id)"/></center>
								<center><span class="helptext">(Only Three Characters)</span></center>
								</td>
								
						 <td align="left" class="trd" ><center>End Customer<font color="red">*</font></center>
								<center><input type="text" name="endcustomer" id="endcustomer"  onchange="ceateprojectrefCode()" maxlength="3" style="width: 30px" onkeyup="convertToUpper(this.id)"/></center>
								<center><span class="helptext">(Only Three Characters)</span></center>
								</td>
								
								</tr>
								<tr>
								
								<td align="left" class="trd" ><center>For Future Expansion<font color="red">*</font></center>
								<center><input type="text" name="forFuturExpan" id="forFuturExpan"  onchange="ceateprojectrefCode()" maxlength="2" style="width: 30px" onkeyup="convertToUpper(this.id)"/></center>
						        <center><span class="helptext">(Only Two Characters)</span></center>		
								</td>
								
								
                      		 <td align="left" class="trd" ><center>Project Activity Categorization<font color="red">*</font></center>
                      		 
                      		 <center><input type="text" name="projectActivityCat" id="projectActivityCat" style="text-align: center;" onkeyup="convertToUpper(this.id)"
								 onchange="ceateprojectrefCode()"  maxlength="3"  /></center>
							 <center><span class="helptext">(Only Three Characters)</span></center> 
								 </td>

                        <td align="left" class="trd" ><center>Link Financial Year_PO Master Number<font color="red">*</font></center>
                           <center><input type="text" name="linkfinancialyear" id="linkfinancialyear" style="text-align: center;"  maxlength="6" onchange="ceateprojectrefCode()" onkeyup="convertToUpper(this.id)"
								 /></center>
								 <center><span class="helptext">(Only Six Characters)</span></center>
								 </td>
						     					
							<td align="left" class="trd"><center>Project Code Preview<font color="red">*</font>
								</center><center>  
								
								<textarea rows="1" cols="32" id="projectrefcode" name="projectrefcode" readonly="readonly"  style="resize: none;background: #D9D9D9"></textarea>
								</center>
								
								</td>
                      
                      
                        </tr>
                        
                        <tr class="trc">
						
						    
								
							<td align="left" class="trd" colspan="1">Project Name<font color="red">*</font><br />
								<input type="text" name="projectname" id="projectname"  maxlength="200"/></td>
								
							<td align="left" class="trd" colspan="1">Location<font color="red">*</font><br />
								<input type="text" name="projectlocation" id="projectlocation"  /></td>
								
									
						 	<td align="left" class="trd" colspan="1">PO Number<br />
								<input type="text" name="ponumber" id="ponumber"   maxlength="200"/></td>
						 	
								
						    <td align="center" class="trd" colspan="1">Approval Authority<font color="red">*</font><br />
								<select  name="reportingto" id="reportingto" style="width:100%;" ><option value="">----Select----</option></select></td>		
						
                              <input type="hidden" id="hiddenreportingto" name="hiddenreportingto"></input>  
						</tr>
						 <tr class="trc" >
						 	
						 	  <td align="center" class="trd" colspan="1"  id ="tdclosed"  style="display: none;"><font color="red"></font><br />
								<!-- <input type="text" name="closed" id="closed"  value="Closed" style="width:80%;background: #D9D9D9" readonly="readonly" /> --><input type="checkbox" name="closedcheckbox" id="closedcheckbox"  />Closed</td>
						
						 	 	
						 	<input type="hidden" id="hiddencheck" name="checkboxval"></input>
						 	<input type="hidden" id="hprojectstatus"></input>
						 	
						 	 <td align="left" class="trd" colspan="4" >
								<center> <input type="button" name="projectguide"
								id="projectguide" value="DownloadProjectGuide" style=" cursor: pointer;" /> </center>
								<center>
								 <span class="helptext">( For Any Help , Please Download the Project Creation Guide)</span></center></td>
						  
						  </tr>
						
						</table>
						
						<br />
						<table cellpadding="5" cellspacing="0" width="90%" id="regenerete">
						 <tr>
<!-- 								<h3 colspan="5" class="head">Personal Details</h3> -->
							 <td colspan="4" class="head11" >	<span class="head11" > Project New Code Generation</span> </td>
							</tr>
                        <tr class="trc" >
						
							<td align="left" class="trd" colspan="2"> New Date<font color="red">*</font><br />
								<input type="text" name="projectrerefdate" id="projectrerefdate" 
								readonly="readonly" onchange="createNewProjectRefCode()" /></td>
								
								
							 <td align="left" class="trd">Project New Code Preview<font color="red">*</font>
								<br />  
								
								<textarea rows="1" cols="32" id="projectrerefcode" name="projectrefcode" readonly="readonly"  style="resize: none;background: #D9D9D9"></textarea>
								
								</td>
								
								<td align="left" class="trd" ><input type="button" name="projectguide"
								id="projectcoderegenerate" value="Generate New Project Code" style=" cursor: pointer;" /></td>

						</tr>
						 
                        </table>
                        
                        </center>

				<input type="hidden" id="projectid" name="projectcode" /> 


				<html:submit value="Add" styleClass="submitbutton" styleId="addbtn"
					property="parameter" onclick="return validations()" />
				<input type="reset" value=" Clear " class="submitbutton"
					onclick="cleardata()" /> <input type="button" value="  Edit  "
					class="submitbutton" onclick="editProject()" />
				<html:submit value="Update" styleClass="submitbutton"
					property="parameter" onclick="return validationsUpdate()" />


				<input type="button" value=" Delete " class="submitbutton"
					onclick="deleteProject()" />


			</center>

		</form>

	
				<br />
			
					<center><div id="messagediv" class="error-box" style="display: none;">
							<span style="color: red; font-family: Segoe UI;"></span>
						</div></center>
						
				<input type="hidden" id="searchprojectId" name="parameter" />
					<table align="center" cellpadding="10" cellspacing="10"	id="">

						<tr>
							<td><input type="text" name="projectName" id="searchprojectName" style="width:120%;font-size:12px;"/></td>

							<td><input type="button" value="Search" class="submitbutton"
								onclick="search()"/></td>

						</tr>

					</table>
					        

			<div class="tablecss" 
				style="width: 100%; ">

				<logic:present name="PROJECTLIST" scope="request">

                      
					<display:table id="project" name="PROJECTLIST" export="false"
						requestURI="/GetDetails.do?parameter=getProjectMaster"
						pagesize="25" decorator="com.centris.decorator.ProjectCreationByMangDecorator">
                      
						<display:column
							title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />">
							<input type="checkbox" name="selectBox" id="selectBox"
								value="${project.projectcode}" />
						</display:column>

						<display:column property="projectRefCode" title="ProjectRefCode" />
						<display:column property="projectname" title="Project Name"
							class="cellintag" />
						<display:column property="ponumber" title="PO Number" />
						<display:column property="projectlocation" title="Location" />
						<display:column property="projectstatus" title="Status" />
						<display:column property="createdby" title="Created By" />
                        <display:column property="approvedby" title="Approved/Rejected By" />
                        <display:column property="closedby" title="Closed By" />
                        <display:column property="approval" title=" -" />
                        <display:column property="reject" title="Reject Status" />


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


			</div>
		<br/>		
		<%-- <logic:present name="PROJECTLIST" scope="request">
		 <logic:notEmpty name="PROJECTLIST" scope="request"> --%>
                   <table align="center" cellpadding="10" cellspacing="10"	id="">

						<tr>
						<td><input type="button" value=" Download All " class="submitbutton"
					         onclick="downloadAll()" /></td>
						</tr>

					</table>
	<%-- 	</logic:notEmpty>
		</logic:present> --%>

	</div>

</BODY>



</html>
