<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Employee Allowances</title>
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
<script type="text/javascript"	src="JQUERY/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script type="text/javascript" src="js/Manager/AllowancesClaim.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>

<style type="text/css">
.pagebanner,.pagelinks {
	display: none;
}
</style>
</head>
<body>
<br/>

<div id="main" class="background">

  <div class="backgroundDiv" id="backgroung">Employee  Allowances</div>
          <br/>
          <center>
          <fieldset style="width:50%;">
             <br/>
          <table id="biometric" cellpadding="5" cellspacing="0" width="50%;">	
           <tr class="trc">
            <td class="left"><label>Date<font color="red">*</font></label></td>
	        <td class="right"><input type="text" name="date" id="date" readonly="readonly" onchange="getAlreadyClaimedCount(this.value)"
	         placeholder="Click Here"/></td>
	        </tr>
            </table>
            </fieldset>
         
            </center>
  <a id="viewmoreAllowances" style="font-size:15px;margin-left:85%;text-decoration:underline;cursor: pointer;color:#1267E9;">View More Allowances</a>              
    <a id="edit" style="display:none;font-size:15px;margin-left:48%;text-decoration:underline;cursor: pointer;color:#1267E9;">View</a>
  
 	<center><div id="loader" style="position: absolute;top:280px;left:650px;display: none;"><img  src="images/loaderimage2.GIF"/></div></center>
	      <center>
	        <logic:present name="successmessage" scope="request">
	             <div id="messagediv" class="error-box">
	  	 						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="successmessage" scope="request"/>
						</span>
						</div>
				</logic:present>
					
		    <logic:present name="errormessage" scope="request">
		      <div id="messagediv" class="error-box">
							<span style="color: red; font-family: Segoe UI;"> <bean:write
									name="errormessage" />
							</span>
							</div>
						</logic:present>
			
	       </center>
	       

	          <div align="right"><input type="button" value="Add" id="Add" class="submitbutton"/></div>
	          <fieldset>
	          <br/>
	          <div style="overflow:auto;width:100%;" >
                 <table class="allowances" id="EmployeeAllowances" >
					<tr>
							<th>S.No</th>
		                    <th>EmpName Search<font color="red">*</font></th>
		                    <th>Employee Name</th>
		                    <th>HDFC A/C No</th>
		                    <th>Amount<font color="red">*</font></th>
		                    <th>No.Of Day/Month Allowance<font color="red">*</font></th>
		                    <th>DA Type<font color="red">*</font></th>
		                    <th>Single/Team/GH<font color="red">*</font></th>
		                    <th>Project Manager<font color="red">*</font></th>
		                    <th>project<font color="red">*</font></th>
		                    <th>Client<font color="red">*</font></th>
		                    <th>Team Lead<font color="red">*</font></th>
		                    <th>Location<font color="red">*</font></th>
		                    <th>Remarks<font color="red"></font></th>
		                     <th >Delete</th>
						</tr>

						<tr>
						
						   <td><span id="sno">1</span></td>
							<td><input type="text" name="bioid" id="bioid1" class="BioIdClass"   onkeyup="getEmployeeDetails(this.id,this.value,1)" placeholder="Search Employee Name" /></td>
							<td><input type="text" name="empname" id="empname1" class="EmpnameClass"   readonly="readonly" /></td>
							<td><input type="text" name="hdfcacno" id="hdfcacno1" class="HdfcacnoClass"   readonly="readonly" /></td>
							<td><input type="text" name="amount" id="amount1" class="AmountClass"  /></td>
						   	
						   	<td><select name="noofdayormonthallowance" id="noofdayormonthallowance1" class="NoofdayormonthallowanceClass">
							 <option value="">---Select----</option>	
							 <option value="0">None</option>	
							 <option value="1">1</option>	
							 <option value="2">2</option>	
							 <option value="3">3</option>	
							 <option value="4">4</option>	
							 <option value="5">5</option>	
							 <option value="6">6</option>
							 <option value="7">7</option>
							 <option value="30">MA</option>
							 </select></td>
															
							<td><select name="datype" id="datype1" class="DatypeClass">
							<option value="">---Select----</option>
							<option value="NA">NA</option>
							<option value="Local">Local(Single/Team)</option>
							<option value="Sigle">Single(Out Of Station)</option>
							<option value="Team">Team(Out Of Station)</option>
							<option value="GHNM">GH(Non Metro)</option>
							<option value="GHM">GH(Metro)</option>
								</select></td>
							
							<td><select name="singleteamgh" id="singleteamgh1" class="SingleteamghClass">
							<option value="">---Select----</option>	
							<option value="NA">NA</option>	
							<option value="Single">Single</option>	
							<option value="Team">Team</option>	
						    <option value="CE">CE 5Y/PMs</option>	
							</select></td>
							
							<td><select name="projectmanager" id="projectmanager1" class="ProjectmanagerClass"
							     onchange="getProjects(1);" >
							<option value="">---Select----</option></select></td>
							
							<td><select name="project" id="project1" class="ProjectClass" onchange="getClient(this.value,1)"
							               >
							    <option value="">---Select----</option></select></td>
						      <td><select name="client" id="client1" class="CientClass"
						                  >
						    	<option value="">---Select----</option></select></td>
							
							    
							<td><input type="text" name="teamlead" id="teamlead1" class="TeamleadClass"/></td>
							<td><input type="text" name="location" id="location1" class="LocationClass"/></td>
							<td><textarea name="remarks" id="remarks1"  class="RemarksClass" rows="2" cols="22" style="resize:none;"></textarea></td>
							<td><input type="image" name="delete" id="delete1"	src="images/trash.gif" onclick="deletMethod(this.id);" ></input></td>
							<input type="hidden" id="empid1" class="EmpidClass"></input>			
						</tr>
							<tr>
							<td><span id="sno">2</span></td>
							<td><input type="text" name="bioid" id="bioid2" class="BioIdClass"   onkeyup="getEmployeeDetails(this.id,this.value,2)"  placeholder="Search Employee Name" /></td>
							<td><input type="text" name="empname" id="empname2" class="EmpnameClass"   readonly="readonly" /></td>
							<td><input type="text" name="hdfcacno" id="hdfcacno2" class="HdfcacnoClass"   readonly="readonly" /></td>
							<td><input type="text" name="amount" id="amount2" class="AmountClass"  /></td>
							   	
						   	<td><select name="noofdayormonthallowance" id="noofdayormonthallowance2" class="NoofdayormonthallowanceClass">
							 <option value="">---Select----</option>	
							 <option value="0">None</option>	
							 <option value="1">1</option>	
							 <option value="2">2</option>	
							 <option value="3">3</option>	
							 <option value="4">4</option>	
							 <option value="5">5</option>	
							 <option value="6">6</option>
							 <option value="7">7</option>
							 <option value="30">MA</option>
							 </select></td>
															
							<td><select name="datype" id="datype2" class="DatypeClass">
							<option value="">---Select----</option>	
							<option value="NA">NA</option>
							<option value="Local">Local(Single/Team)</option>
							<option value="Sigle">Single(Out Of Station)</option>
							<option value="Team">Team(Out Of Station)</option>
							<option value="GHNM">GH(Non Metro)</option>
							<option value="GHM">GH(Metro)</option>
								</select></td>
							
							<td><select name="singleteamgh" id="singleteamgh2" class="SingleteamghClass">
							<option value="">---Select----</option>	
							<option value="NA">NA</option>	
							<option value="Single">Single</option>	
							<option value="Team">Team</option>	
						    <option value="CE">CE 5Y/PMs</option>	
							</select></td>
							<td><select name="projectmanager" id="projectmanager2" class="ProjectmanagerClass" onchange="getProjects(2);">
							<option value="">---Select----</option>	</select></td>
						   <td><select name="project" id="project2" class="ProjectClass" onchange="getClient(this.value,2)">
							    <option value="">---Select----</option></select></td>
						   <td><select name="client" id="client2" class="CientClass">
						    	<option value="">---Select----</option></select></td>
							
							<td><input type="text" name="teamlead" id="teamlead2" class="TeamleadClass"/></td>
							<td><input type="text" name="location" id="location2" class="LocationClass"/></td>
							<td><textarea name="remarks" id="remarks2"  class="RemarksClass" rows="2" cols="22" style="resize:none;"></textarea></td>
							<td><input type="image" name="delete" id="delete2"	src="images/trash.gif"  onclick="deletMethod(this.id);" ></input></td>
								<input type="hidden" id="empid2" class="EmpidClass"></input>			
						</tr>
							<tr>
							 <td><span id="sno">3</span></td>
								<td><input type="text" name="bioid" id="bioid3" class="BioIdClass"   onkeyup="getEmployeeDetails(this.id,this.value,3)"  placeholder="Search Employee Name" /></td>
							<td><input type="text" name="empname" id="empname3" class="EmpnameClass"   readonly="readonly" /></td>
							<td><input type="text" name="hdfcacno" id="hdfcacno3" class="HdfcacnoClass"   readonly="readonly" /></td>
							<td><input type="text" name="amount" id="amount3" class="AmountClass"  /></td>
							   	
						  	<td><select name="noofdayormonthallowance" id="noofdayormonthallowance3" class="NoofdayormonthallowanceClass">
							 <option value="">---Select----</option>	
							 <option value="0">None</option>	
							 <option value="1">1</option>	
							 <option value="2">2</option>	
							 <option value="3">3</option>	
							 <option value="4">4</option>	
							 <option value="5">5</option>	
							 <option value="6">6</option>
							 <option value="7">7</option>
							 <option value="30">MA</option>
							 </select></td>
															
							<td><select name="datype" id="datype3" class="DatypeClass">
								<option value="">---Select----</option>	
							<option value="NA">NA</option>
							<option value="Local">Local(Single/Team)</option>
							<option value="Sigle">Single(Out Of Station)</option>
							<option value="Team">Team(Out Of Station)</option>
							<option value="GHNM">GH(Non Metro)</option>
							<option value="GHM">GH(Metro)</option>
								</select></td>
							
							<td><select name="singleteamgh" id="singleteamgh3" class="SingleteamghClass">
							<option value="">---Select----</option>	
							<option value="NA">NA</option>	
							<option value="Single">Single</option>	
							<option value="Team">Team</option>	
						    <option value="CE">CE 5Y/PMs</option>	
							</select></td>
							<td><select name="projectmanager" id="projectmanager3" class="ProjectmanagerClass" onchange="getProjects(3);">
							<option value="">---Select----</option>	</select></td>
						 	 <td><select name="project" id="project3" class="ProjectClass" onchange="getClient(this.value,3)">
							    <option value="">---Select----</option></select></td>
						 	   <td><select name="client" id="client3" class="CientClass">
						    	<option value="">---Select----</option></select></td>
							
							<td><input type="text" name="teamlead" id="teamlead3" class="TeamleadClass"/></td>
							<td><input type="text" name="location" id="location3" class="LocationClass"/></td>
							<td><textarea name="remarks" id="remarks3"  class="RemarksClass" rows="2" cols="22" style="resize:none;"></textarea></td>
							<td><input type="image" name="delete" id="delete3"	src="images/trash.gif"  onclick="deletMethod(this.id);" ></input></td>
							<input type="hidden" id="empid3" class="EmpidClass"></input>
						</tr>
							<tr>
						    <td><span id="sno">4</span></td>
							<td><input type="text" name="bioid" id="bioid4" class="BioIdClass"   onkeyup="getEmployeeDetails(this.id,this.value,4)"  placeholder="Search Employee Name"/></td>
							<td><input type="text" name="empname" id="empname4" class="EmpnameClass"   readonly="readonly" /></td>
							<td><input type="text" name="hdfcacno" id="hdfcacno4" class="HdfcacnoClass"   readonly="readonly" /></td>
							<td><input type="text" name="amount" id="amount4" class="AmountClass"  /></td>
						   	
						 	<td><select name="noofdayormonthallowance" id="noofdayormonthallowance4" class="NoofdayormonthallowanceClass">
							 <option value="">---Select----</option>	
							 <option value="0">None</option>	
							 <option value="1">1</option>	
							 <option value="2">2</option>	
							 <option value="3">3</option>	
							 <option value="4">4</option>	
							 <option value="5">5</option>	
							 <option value="6">6</option>
							 <option value="7">7</option>
							 <option value="30">MA</option>
							 </select></td>
															
							<td><select name="datype" id="datype4" class="DatypeClass">
								<option value="">---Select----</option>	
							<option value="NA">NA</option>
							<option value="Local">Local(Single/Team)</option>
							<option value="Sigle">Single(Out Of Station)</option>
							<option value="Team">Team(Out Of Station)</option>
							<option value="GHNM">GH(Non Metro)</option>
							<option value="GHM">GH(Metro)</option>
								</select></td>
							
							<td><select name="singleteamgh" id="singleteamgh4" class="SingleteamghClass">
							<option value="">---Select----</option>	
							<option value="NA">NA</option>	
							<option value="Single">Single</option>	
							<option value="Team">Team</option>	
						    <option value="CE">CE 5Y/PMs</option>	
							</select></td>
							<td><select name="projectmanager" id="projectmanager4" class="ProjectmanagerClass" onchange="getProjects(4);">
							<option value="">---Select----</option>	</select></td>
						  	 	<td><select name="project" id="project4" class="ProjectClass" onchange="getClient(this.value,4)">
							    <option value="">---Select----</option></select></td>
						  	   <td><select name="client" id="client4" class="CientClass">
						    	<option value="">---Select----</option></select></td>
						
							<td><input type="text" name="teamlead" id="teamlead4" class="TeamleadClass"/></td>
							<td><input type="text" name="location" id="location4" class="LocationClass"/></td>
							<td><textarea name="remarks" id="remarks4"  class="RemarksClass" rows="2" cols="22" style="resize:none;"></textarea></td>
							<td><input type="image" name="delete" id="delete4"	src="images/trash.gif"  onclick="deletMethod(this.id);" ></input></td>
						<input type="hidden" id="empid4" class="EmpidClass"></input>
						</tr>
							<tr>
							 <td><span id="sno">5</span></td>
							<td><input type="text" name="bioid" id="bioid5" class="BioIdClass"   onkeyup="getEmployeeDetails(this.id,this.value,5)"  placeholder="Search Employee Name"/></td>
							<td><input type="text" name="empname" id="empname5" class="EmpnameClass"   readonly="readonly" /></td>
							<td><input type="text" name="hdfcacno" id="hdfcacno5" class="HdfcacnoClass"   readonly="readonly" /></td>
							<td><input type="text" name="amount" id="amount5" class="AmountClass"  /></td>
							   	
						  	<td><select name="noofdayormonthallowance" id="noofdayormonthallowance5" class="NoofdayormonthallowanceClass">
							 <option value="">---Select----</option>	
							 <option value="0">None</option>	
							 <option value="1">1</option>	
							 <option value="2">2</option>	
							 <option value="3">3</option>	
							 <option value="4">4</option>	
							 <option value="5">5</option>	
							 <option value="6">6</option>
							 <option value="7">7</option>
							 <option value="30">MA</option>
							 </select></td>
															
							<td><select name="datype" id="datype5" class="DatypeClass">
								<option value="">---Select----</option>	
							<option value="NA">NA</option>
							<option value="Local">Local(Single/Team)</option>
							<option value="Sigle">Single(Out Of Station)</option>
							<option value="Team">Team(Out Of Station)</option>
							<option value="GHNM">GH(Non Metro)</option>
							<option value="GHM">GH(Metro)</option>
								</select></td>
							
							<td><select name="singleteamgh" id="singleteamgh5" class="SingleteamghClass">
							<option value="">---Select----</option>	
							<option value="NA">NA</option>	
							<option value="Single">Single</option>	
							<option value="Team">Team</option>	
						    <option value="CE">CE 5Y/PMs</option>	
							</select></td>
							<td><select name="projectmanager" id="projectmanager5" class="ProjectmanagerClass" onchange="getProjects(5);">
							<option value="">---Select----</option>	</select></td>
							
							<td><select name="project" id="project5" class="ProjectClass" onchange="getClient(this.value,5)">
							    <option value="">---Select----</option></select></td>
						   	   <td><select name="client" id="client5" class="CientClass">
						    	<option value="">---Select----</option></select></td>
							
							<td><input type="text" name="teamlead" id="teamlead5" class="TeamleadClass"/></td>
							<td><input type="text" name="location" id="location5" class="LocationClass"/></td>
							<td><textarea name="remarks" id="remarks5"  class="RemarksClass" rows="2" cols="22" style="resize:none;"></textarea></td>
						    <td><input type="image" name="delete" id="delete5"	src="images/trash.gif"  onclick="deletMethod(this.id);" ></input></td>
								<input type="hidden" id="empid5" class="EmpidClass"></input>			
						</tr>
					
					</table>
					<br/>
		        	</div>
		        	</fieldset>
                 <br/>
                 <center>
			      <div id="errordiv" class="error-box"></div></center>
                 <table align="center">
                 <tr><td><input type="button" value="Save Allowances" onclick="saveAllowances();" class="submitbutton" id="saveallowances"></input></td></tr>
                 </table>
                 <br/>
                 </div>
<br/>
</body>
</html>