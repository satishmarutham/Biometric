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
<title>Employee</title>
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
<script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="js/Employee/EmployeeResumeCreation.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/Employee/ResumeCreation.css"></link>
</head>

<body><br></br>
	<center><div id="main" class="background">

		<center>

			<div class="backgroundDiv" id="backgroung">My Resume</div>
			<br />
	<div id="errordiv" class="error-box" align="center">

						<logic:present name="status" scope="request">
							<span style="color: green; font-family: Segoe UI;"><bean:write name="status"/>
							</span>
						</logic:present>
					<!-- 	<div id="errordivForEmpty" class="error-box" align="center" style="width: 75%;">

					
							<span style="color: red; font-family: Segoe UI;"> 
							</span>
					
					</div>  -->
				
				<span style="color: red; font-family: Segoe UI;">
							</span>
						
						
					</div>
					
					
					
										</center>
<div class="backgroungDIVResume" id="backgroung">
	 <logic:present name="EmployeePersonalDetails" scope="request">
	<logic:iterate id="EmpDetails" name="EmployeePersonalDetails">
	<table cellpadding="5" cellspacing="0" style="width: 97%;">
		<tr align="right"><td ><bean:write name="EmpDetails" property="employeeName"/></td></tr>
		 <tr align="right"><td><bean:write name="EmpDetails" property="phoneNo"/></td></tr>
		<tr align="right"><td><bean:write name="EmpDetails" property="email"/></td></tr>
	<tr align="left"><td style="font-weight:bold;width: 26%;"><bean:write name="EmpDetails" property="presentAddress"/></td></tr>
				</table>
	</logic:iterate></logic:present>		
							
								
<hr />

 <logic:present name="CareerObjective" scope="request">
<logic:iterate id="careerObjectiveDetails" name="CareerObjective">
<input type="hidden" id="employeeCodeId" value="<bean:write name="careerObjectiveDetails" property="employeeId"/>"/>
<input type="hidden" id="careerSnoId" name="carrerObjectSno" value="<bean:write name="careerObjectiveDetails" property="carrerObjectSno"/>"/>
		</logic:iterate></logic:present>
			
<div class="Rhead11">Career Objective</div>
<br>
<textarea rows="4" cols="150" id="carrerObjective" class="carrierObjectCss">
<logic:present name="CareerObjective" scope="request"><logic:iterate id="careerObjectiveDetails" name="CareerObjective"><bean:write name="careerObjectiveDetails" property="carrerObjective"/></logic:iterate></logic:present></textarea><br></br> 

<div class="Rhead11" class="head11">Pursuit</div> 
				<div align="right"><input type="button" value="Add" id="pursuitButtonId" class="submitbutton"/></div>
		
				<table id="pursuitTableId" class="createResumeTableClass">
				<logic:present name="PursuitsList" scope="request">
			<logic:iterate id="pursuitList" name="PursuitsList">
				<tr>
			<th align="center" style="color: black;font-weight: normal;"></th>

				</tr><tr>
	<td><span id="sno" class="pursuitSnoClass"><bean:write name="pursuitList" property="pursuitSno"/></span></td>
	<td style="width: 499%;font-family:Segoe UI Semibold,Segoe UI;"><input type="text" name="pursuit" id="pursuitId1" class="pursuitClass" value="<bean:write name="pursuitList" property="pursuits"/>"> </input>
	
	
	</td>
<td>
 <input type="image" name="pursuitDeleteName" src="images/trash.gif" onclick="deletePursuitSno(this.value);" class="deletePursuit" value="<bean:write name="pursuitList" property="pursuitSno"/>"></input>


				<td colspan="1"></td>
				
				</tr>
				</logic:iterate></logic:present>
				</table>
			&nbsp;
				<div class="Rhead11">Hobbies/Sports</div>
		
				 <div align="right"><input type="button" value="Add" id="hobbiesButtonId" class="submitbutton"/></div>
				 
			
				
				 
				<table id="hobbiesTableId" class="createResumeTableClass">
					<logic:present name="Hobbies" scope="request">
					<logic:iterate id="hobbiesDetails" name="Hobbies">
				
				
				<tr>	<td class="tableTdClass"><span id="sno1" class="hobbiesSnClass"><bean:write name="hobbiesDetails" property="hobbiesSno"/></span></td>
					<td style="width: 499%;"><input type="text" name="hobbies" id="hobbiesId1" class="hobbiesClass" value="<bean:write name="hobbiesDetails" property="hobbies"/>"/></td>
					<td>
 <input type="image" name="hobbiesDeleteName" src="images/trash.gif" onclick="deleteHobbiesSno(this.value);" class="deleteHobbies" value="<bean:write name="hobbiesDetails" property="hobbiesSno"/>"></input>
					
				<td colspan="1"></td>
				
				</tr>
				</logic:iterate>
		</logic:present>
				
				</table>
				&nbsp;
			<div class="Rhead11">Technical Skills</div>
			 <div align="right"><input type="button" value="Add" id="technicalSkiilsButtonId" class="submitbutton"/></div>
				<table id="technicalTableId" class="createResumeTableClass">
					<logic:present name="TechnicalSkills" scope="request">
					<logic:iterate id="technicalSkillsDetails" name="TechnicalSkills" >	
				 
				
				
	<tr>	<td><span id="sno2" class="technicalSkillsSnoClass"><bean:write name="technicalSkillsDetails" property="technicalSkillsSno"/></span></td>
					<td style="width: 499%;"><input type="text" name="technicalSkills" id="technicalSkillsId1" class="technicalClass" value="<bean:write name="technicalSkillsDetails" property="technicalSkills"/>"/></td>
					<td>
 <input type="image" name="technicallSkillsDeleteName" src="images/trash.gif" onclick="deleteTechnicalSkills(this.value);" class="deleteTechnicalsSkills" value="<bean:write name="technicalSkillsDetails" property="technicalSkillsSno"/>"></input>
					
				<td colspan="1"></td>
				
				</tr>
				</logic:iterate>
			
			</logic:present>
				
				</table>
				&nbsp;
		<div class="Rhead11">Experience</div>
		
				 <div align="right"><input type="button" value="Add" id="experienceButtonId" class="submitbutton"/></div>
			<table id="experienceTableId" class="createResumeTableClass">
				 <logic:present name="Experience" scope="request">
					<logic:iterate id="ExpDetails" name="Experience" >
			
	<tr><td><span id="sno4" class="experienceSnClass">	<bean:write name="ExpDetails" property="experienceSno"/></span></td>
					<td style="width: 499%;"><input type="text" name="experience" id="experienceId1" class="experienceClass" value=" <bean:write name="ExpDetails" property="experience"/>" /></td>
	<td>			
 <input type="image" name="experienceDeleteName" src="images/trash.gif" onclick="deleteExperienceCode(this.value);" class="deleteExperienceClass" value="<bean:write name="ExpDetails" property="experienceSno"/>"></input></td>
				<td colspan="1"></td>
				
				</tr>
			</logic:iterate></logic:present>
				</table>
				&nbsp;
			
			<div class="Rhead11">Responsibilities</div>	
			<div align="right"><input type="button" value="Add" id="responsibilitiesButtonId" class="submitbutton"/></div>
					
				
				<table id="responsibilitiesTableId" class="createResumeTableClass">
				<logic:present name="Responsibilities" scope="request">
					<logic:iterate id="ResDetails" name="Responsibilities" >	
	<tr><td><span id="sno3" class="responsibilitiesSnoClass"><bean:write name="ResDetails" property="responsibilitiesSno"/></span></td>
<td style="width: 499%;"><input type="text" name="responsibilities" id="responsibilitiesId1" class="responsibilitiesClass" value="<bean:write name="ResDetails" property="responsibilities"/>"/></td>


<td>
 <input type="image" name="responsibilitiesDeleteName" src="images/trash.gif" onclick="deleteResponsibilities(this.value);" class="deleteResponsibilities" value="<bean:write name="ResDetails" property="responsibilitiesSno"/>"></input></td>
				
				<td colspan="1"></td>
				</tr>
				</logic:iterate></logic:present>
				</table>
		<center>
		<table>
			
								<tr class="odd">

									<td colspan="3"><center>
											<input type="button" class="submitbutton" value="Save Details"
												class="button1" id="createResumeBtnId" /> &nbsp;&nbsp;&nbsp; <input
												type="reset" value="Cancel" class="submitbutton" id="clear" />
										</center></td>

								</tr>
</table>
							
		</center>
			
	</div>
		
		<br>	
	</div>
	</center>
		
	
			<br />
	
		
</body>
</html>