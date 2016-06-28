<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Modify Employee</title>




<script src="JQUERY/development-bundle/jquery-1.8.3.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.core.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.widget.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.position.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.menu.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>

<script type="text/javascript" src="js/modifyEmployee.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/modifyemployee.css"></link>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/addemployee.css"/>


</head>

 
<body >
<br/>
<br/>
	
<div id="main">
	<center>
		
		<div class="background" id="backgroung">
		
		<div class="backgroundDiv" id="backgroung">Modify-Employee</div><br/>
	
												

		<form action="modifyEmployee.do?parameter=ModifyEmployee" method="post">
		
		
							<center>
					
						<div id="errordiv" class="error-box" align="center">
							
							<logic:present name="message" scope="request">
								<span style="color: green; font-family: Segoe UI;">
									<bean:write name="message"/>
								</span>
							</logic:present>
						</div>
					</center>
					
		<table cellpadding="4" cellspacing="3" id="biometric" width="100%"> 
			
				<tr align="center">
					<td colspan="6" align="center"  id="searchbox" height="10%">Select Employee&nbsp;&nbsp;&nbsp; 
					<input class="input" id="emp" name="selectEmployee"
						value="<logic:present name="employeeDetails" property="empname"><bean:write name="employeeDetails" property="empname" />
													</logic:present>"  /></td>
				</tr>
				<tr>
					<td>Employee ID <font color="red">*</font><br /> <input type="text" id="empid"
						 name="empid" readonly="readonly"
						value="<logic:present name="employeeDetails" property="empid"><bean:write name="employeeDetails" property="empid" />
													</logic:present>"></input></td>
						<td align="left" class="trd">Employee Reg/Roll Number<font color="red">*</font>
							<br /> <input type="text" name="empregnumber" id="empregnumber" onblur="empregnumbercheckupdate()" value="<logic:present name="employeeDetails" property="empregnumber"><bean:write name="employeeDetails" property="empregnumber" />
													</logic:present>"/></td>
					
					<td>Employee Name<font color="red">*</font> <br /> <input type="text" id="empname"
						class="spanValues" name="empname"
						value="<logic:present name="employeeDetails" property="empname"><bean:write name="employeeDetails" property="empname" />
													</logic:present>"></input></td>
					<td>Father Name <font color="red">*</font><br /> <input type="text" name="father"
						id="father" class="spanValues"
						value="<logic:present name="employeeDetails" property="fathername"><bean:write name="employeeDetails" property="fathername" />
													</logic:present>"></input></td>

					<td>Phone Number<font color="red">*</font><br /> <input type="text" id="empphone"
						class="spanValues" name="empphone" maxlength="10"
						value="<logic:present name="employeeDetails" property="phone"><bean:write name="employeeDetails" property="phone" />
													</logic:present>"></input></td>
													<td>Email ID<br /> <input type="text" id="empmail"
						class="spanValues" name="empmail"
						value="<logic:present name="employeeDetails" property="email"><bean:write name="employeeDetails" property="email" />
													</logic:present>" onblur="emailcheck()"></input></td>
					
				</tr>
				<tr>
				
					
					<td>Date of Birth<font color="red">*</font><br /> <input type="text" name="dob"
						id="dob" class="spanValues" readonly="readonly"
						value="<logic:present name="employeeDetails" property="dob"><bean:write name="employeeDetails" property="dob" />
													</logic:present>"></input></td>
				
				<td>Date of Join<font color="red">*</font><br /> <input type="text" name="doj" id="doj"
						class="spanValues" readonly="readonly"
						value="<logic:present name="employeeDetails" property="doj"><bean:write name="employeeDetails" property="doj" />
													</logic:present>"></input></td>
				
						
				<td>Designation <font color="red">*</font><br /> 
				
				         
							<select name="empdesignation" id="empdesignation" onchange="checkDseCount()">
							
								<logic:present name="employeeDetails" scope="request">
							<option value="<bean:write name="employeeDetails" property="desid"  />"><bean:write name="employeeDetails" property="designation"  /></option>
							
							</logic:present>
							
								<option value="">-----Select-----</option>
								<logic:present name="DESIGNATIONLIST" scope="session">
								<logic:iterate id="designation" name="DESIGNATIONLIST"
									scope="session">
									<option
										value='<bean:write name="designation" property="desgid"  />'>
										<bean:write name="designation" property="desgname" />
									</option>
								</logic:iterate>
								</logic:present>
							</select>
						

				</td>
				
				<td>Department Name<font color="red">*</font><br /> 
					
					<select id="empdepartment" class="spanValues" name="empdepartment">
					
					<logic:present name="employeeDetails" scope="request">
							<option value="<bean:write name="employeeDetails" property="deptid"  />"><bean:write name="employeeDetails" property="deptname"  /></option>
							
							</logic:present>
					
							<option value="">-----Select-----</option>
									<logic:iterate id="department" name="DEPARTMENTLIST"
										scope="session">
										<option
											value='<bean:write name="department" property="depId"  />'>
											<bean:write name="department" property="depName" />
										</option>
									</logic:iterate>

					</select></td>
					
					<td class="USER_LOCATION">Select Location<font color="red">*</font><br/>
						<select id="locationId" class="userLocationId" name="empLocation" onchange="getshift()">
						
						<logic:present name="employeeDetails" scope="request">
							<option value="<bean:write name="employeeDetails" property="locationid"  />"><bean:write name="employeeDetails" property="emplocation"  /></option>
							
							</logic:present>
						<option value="">-----Select-----</option>
								 <logic:present name="LOCATIONLIST" scope="session">
									
									<logic:iterate id="location" name="LOCATIONLIST"
										scope="session">
										<option
											value='<bean:write name="location" property="locationid"  />'>
											<bean:write name="location" property="locationname" />
											<!-- locationname -->
										</option>
									</logic:iterate>
									</logic:present>
						</select>
							</td>
					<td>Shift Name <font color="red">*</font><br /> <select id="empshift" class="shiftClassForAdmin"
						 name="empshift" >
						 
						 <logic:present name="employeeDetails" scope="request">
							<option value="<bean:write name="employeeDetails" property="shiftid"  />"><bean:write name="employeeDetails" property="shiftname"  /></option>
							
							</logic:present>
						 
						 <option value="">-----Select-----</option>
									 <logic:present name="SHIFTLIST" scope="session">
								 	<logic:iterate id="shift" name="SHIFTLIST"
										scope="session">
										<option
											value='<bean:write name="shift" property="ai_shift_id"  />'>
											<bean:write name="shift" property="ai_shift_name" />
										</option>
									</logic:iterate>
									</logic:present>
				
					</select></td>
				
									
				</tr>
				<tr>
				
				<td>Address <font color="red">*</font><br /> <textarea rows="2" cols="25" id="empaddresss"
						class="spanValues" name="empaddresss" style="resize:none"><logic:present name="employeeDetails" property="address"><bean:write name="employeeDetails" property="address" />
						
											</logic:present></textarea></td>
		 		<logic:notPresent name="employeeDetails" property="isempreginmultilocations">						
				<td><input type="checkbox" name="isemployeeregusteredinmultilocations" value="1" id='checknox' onchange="locationEmployeemapping()"/><span>Is Employee Registered in Multi-locations ?</span></td>
				</logic:notPresent>
			<c:if test="${ employeeDetails.isempreginmultilocations== 'Y'}"> 
				<td><input type="checkbox" name="isemployeeregusteredinmultilocations" value="1" id='checknox' checked="checked" onchange="locationEmployeemapping()"/><span>Is Employee Registered in Multi-locations ?</span></td>
				
				</c:if>
				
				<c:if test="${ employeeDetails.isempreginmultilocations== 'N'}"> 
				<td><input type="checkbox" name="isemployeeregusteredinmultilocations" value="1" id='checknox' onchange="locationEmployeemapping()"/><span>Is Employee Registered in Multi-locations ?</span></td>
				
				</c:if>
				
				<!-- <td class="selectedlocations" colspan="2"><label >Selected Locations : </label><input type="button" value="Edit Locations" class="submitbutton" id="editlocations" onclick="maplocations()"/></br><textarea rows="5" cols="50"  class="locations"></textarea></td> -->
				<td class="selectedlocations" colspan="2"><label >Selected Locations : </label>&nbsp;<a  name="edit locations" onclick="maplocations()" style="cursor: pointer;"><b><u><font color="#000080">edit locations</font></u></b></a><br/><textarea rows="5" cols="50"  class="locations" id="textarea"><logic:present name="MAPPEDLOCATIONSLIST" scope="session"><bean:write name="MAPPEDLOCATIONSLIST" scope="session"/></logic:present></textarea></td>
				</tr>

			</table>
				
				
			<input type="hidden" <logic:present name="MAPPEDLOCATIONSIDLIST" scope="session">value="<bean:write name="MAPPEDLOCATIONSIDLIST"/>"</logic:present> id="hiddenlocationsid"/>
			
		<center>
	<input type="submit" value="Update" id="modifyemployee" class="submitbutton" name="modifyemployee" onclick="return validateEmpForm()"/>
</center>



<input type="hidden" id="allselectedlocations"  name="allselectedlocations"/>


			
			</form>
		
			
		
		</div>
	</center>
	
	</div>
	
		
		
			<div id="addLocationsDialogmapping" title="Map Locations" >
	<center>
	
	<form action="" id="formid">
	
<br />
				<fieldset class="fieldset"	style="width: 40%; border-width: 1px;">
					<table>
					
					<tr>
						<td valign="top"><span style="font-size: 16px; font-family: Segoe UI;"><b>Available Location</b></span><br />
							<select id="original" multiple="multiple" 
							style="width: 180px;height: 200px;font-size: 16px; font-family: Segoe UI;" >
						 <logic:present name="LOCATIONLIST" scope="session">
									
									<logic:iterate id="location" name="LOCATIONLIST"
										scope="session">
										<option  id="optionid"
											value='<bean:write name="location" property="locationid"  />'>
											<bean:write name="location" property="locationname" />
										</option>
									</logic:iterate>
									</logic:present>
								
						</select>
						</td>
						<td style="font-size: 16px; font-family: Segoe UI;">
							<table border="0" style="font-size: 16px; font-family: Segoe UI;">
								<tr>
									<td><input type="button" name="placement" value="&gt;" onclick="addtext();" style="width:50px;"/></td>
								</tr>
								<tr>
									<td><input type="button" name="placement" value="&lt;"
										onclick="deSelectData()" style="width:50px;"/></td>
								</tr>
								<tr>
									<td><input type="button" onclick="deSelectAllData()"
										value="&lt;&lt;" style="width:50px;"/></td>
								</tr>
								<tr>
									<td><input type="button" style="width:50px;" value="&gt;&gt;"
										onclick="addAlltext()"/></td>
								</tr>
							</table>
						</td>
						<td><span style="font-size: 16px; font-family: Segoe UI;"><b>Select Location</b></span><br /> 
						<select id="copy" class="copylocations" size="10" style="width: 180px;height: 200px;font-size: 16px; font-family: Segoe UI;" multiple="multiple" ></select></td>
					</tr>
				</table>
				<!--  <input type="button" value="Save" name="Save" class="submitbutton" id="save" onclick="return assign();"/> -->
			</fieldset>
			
			<br />
		</form>
		
	
		
		</center>
	
	</div>

</body>
</html>