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
<title>Add Employee</title>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/addemployee.js"></script>
<link rel="stylesheet" href="css/addemployee.css"/>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

</head>

<body >

</br>
</br>
</br>
</br>

<div id="main">
	
	<center>

<div class="background" id="backgroung">

		<div class="backgroundDiv" id="backgroung">Create Employee</div></br>
		
		<form action="AddEmployee.do?parameter=addEmployee"  name="AddEmployeeForm" method="post">

			<center>
					
						<div id="errordiv" class="error-box" align="center">
							
							<logic:present name="message" scope="request">
								<span style="color: green; font-family: Segoe UI;">
									<bean:write name="message"/>
								</span>
							</logic:present>
						</div>
					</center>

			<div class="backgroungDIV" id="backgroung">

				<table cellpadding="8" cellspacing="5" id="biometric" width="100%">

					<tr class="trc">
						<td align="left" class="trd">Employee ID<font color="red">*</font>
							<br /> <input type="text" name="empid" id="empid" onblur="empidckeck()"/></td>
						<td align="left" class="trd">Employee Reg/Roll Number<font color="red">*</font>
							<br /> <input type="text" name="empregnumber" id="empregnumber" onblur="empregnumbercheck()"/></td>
						<td align="left" class="trd">Employee Name<font color="red">*</font>
							<br /> <input type="text" name="empname" id="empname"/></td>
						<td align="left" class="trd">Father Name <font color="red">*</font><br />
							<input type="text" name="father" id="father"/></td>
						<td align="left" class="trd">Phone Number<font color="red">*</font>
							<br /> <input type="text" name="empphone" id="empphone" maxlength="10"/></td>
						<td align="left" class="trd">Email ID<br /> <input
							type="text" name="empmail" id="empmail" class="textBoxInDialog" onblur="emailcheck()" /></td>
							
					
					</tr>
					<tr>
					
						<td align="left" class="trd">Date of Birth<font color="red">*</font>
							<br /> <input type="text" name="dob" id="dob" readonly="readonly"/>
						</td>
						<td align="left" class="trd">Date of Join<font color="red" >*</font>
							<br /> <input type="text" name="doj" id="doj" readonly="readonly"/>
						</td>
						
						<td align="left" class="trd">Designation<font color="red">*</font>
							<br /> <logic:present name="DESIGNATIONLIST" scope="session">
								<select name="empdesignation" id="empdesignation" onchange="checkDseCount()">
									<option value="">-----Select-----</option>
									<logic:iterate id="designation" name="DESIGNATIONLIST"
										scope="session">
										<option
											value='<bean:write name="designation" property="desgid"  />'>
											<bean:write name="designation" property="desgname" />
										</option>
									</logic:iterate>
								</select>
							</logic:present>
						</td>

						<td class="trd">Department Name<font color="red">*</font> <br />
							<logic:present name="DEPARTMENTLIST" scope="session">
							<select name="empdepartment" id="empdepartment">
								<option value="">-----Select-----</option>
								<logic:iterate id="department" name="DEPARTMENTLIST"
										scope="session">
										<option
											value='<bean:write name="department" property="depId"  />'>
											<bean:write name="department" property="depName" />
										</option>
									</logic:iterate>
								
						</select>
							</logic:present>
							
							</td>
							
							<%-- 	<td  class="USE_GROUP">Select Group<font color="red">*</font>
							<br />
							<select name="usergroup" id="usergroupid" class="usergroup" onchange="getlocations()">
							<option value="">-----Select-----</option>
							 <logic:present name="GROUPDETAILS" scope="session">
									
									<logic:iterate id="GROUP" name="GROUPDETAILS"
										scope="session">
										<option
											value='<bean:write name="GROUP" property="groupId"  />'>
											<bean:write name="GROUP" property="groupName" />
										</option>
									</logic:iterate>
									</logic:present>
								</select>
							
						</td> --%>
							
								<td  class="USER_LOCATION">Select Location<font color="red">*</font>
							<br />
							<select name="empLocation" id="empLocation" class="userLocationId" onchange="getshift()">
							<option value="">-----Select-----</option>
							 <logic:present name="LOCATIONLIST" scope="session">
									
									<logic:iterate id="location" name="LOCATIONLIST"
										scope="session">
										<option
											value='<bean:write name="location" property="locationid"  />'>
											<bean:write name="location" property="locationname" />
										</option>
									</logic:iterate>
									</logic:present>
								</select>
							
						</td>
						
							
					<td class="trd">Shift Name <font color="red">*</font> <br />
							<select name="empshift" id="empshift" class="shiftClassForAdmin">
								<option value="">-----Select-----</option>
								 <%-- <logic:present name="SHIFTLIST" scope="session">
								 	<logic:iterate id="shift" name="SHIFTLIST"
										scope="session">
										<option
											value='<bean:write name="shift" property="ai_shift_id"  />'>
											<bean:write name="shift" property="ai_shift_name" />
										</option>
									</logic:iterate>
									</logic:present> --%>
						</select></td>
					
						
					</tr>
					
					<tr >
				
					
					<td align="left" class="trd">Address<font color="red" >*</font>
							<br /> <textarea id="empaddresss" name="empaddresss" rows="2"cols="25" style="resize:none"></textarea></td>
					
					
						<td><input type="checkbox" name="isemployeeregusteredinmultilocations" value="1" onchange="ischeckedlocations()" id="chechlocations"/><span>Is Employee Registered in Multi-Locations?</span></td>
					
				<!-- <td class="selectedlocations" colspan="1"><label >Selected Locations : </label><label class="locations"></label></td> --> 
						<td class="selectedlocations" colspan="2"><label >Selected Locations : </label></br><textarea rows="5" cols="50"  class="locations"></textarea></td>
					
					
					
					
					</tr>
					
				

				</table>
				
				
				<center>

					<table>
						<tr class="odd">

							<td colspan="3"><center>
									<input type="submit" class="submitbutton" value="Register" class="button1" id="register" onclick="return validateEmpForm();" /> &nbsp;&nbsp;&nbsp;
										 <input type="reset" value="Clear" onclick="" class="submitbutton" id="clear" />
								</center></td>

						</tr>

					</table>
				</center>
			</div>

			<br />
			<input type="hidden" id="allselectedlocations"  name="allselectedlocations"/>
		</form>
		
	
	

	
	<div id="addLocationsDialog" title="Map Locations" >
	<center>
	
	<form action="" id="formid">
	
	</br>
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
									<td><input type="button" name="placement" value="&gt;"
										onclick="addtext();" style="width:50px;" ></td>
								</tr>
								<tr>
									<td><input type="button" name="placement" value="&lt;"
										onclick="deSelectData()" style="width:50px;" ></input></td>
								</tr>
								<tr>
									<td><input type="button" onclick="deSelectAllData()"
										value="&lt;&lt;" style="width:50px;" ></input></td>
								</tr>
								<tr>
									<td><input type="button" style="width:50px;"  value="&gt;&gt;"
										onclick="addAlltext()"></td>
								</tr>
							</table>
						</td>
						<td><span style="font-size: 16px; font-family: Segoe UI;"><b>Select Location</b></span><br /> 
						<select id="copy"  size="10" style="width: 180px;height: 200px;font-size: 16px; font-family: Segoe UI;" multiple="multiple" >
						 						</select></td>
					</tr>
				</table>
				<!--  <input type="button" value="Save" name="Save" class="submitbutton" id="save" onclick="return assign();"/> -->
			</fieldset>
			
			</br></br>
		</form>
		
	
		
		</center>
	
	</div>
	</div>
	</center>
	
		</div>
	
</body>



</html>
