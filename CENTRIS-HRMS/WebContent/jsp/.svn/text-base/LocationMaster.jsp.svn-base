<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location Master</title>

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
<script type="text/javascript" src="js/LocationMaster.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/LocationMaster.css"></link>

</head>
<body>

<br></br>
<br></br>
<br></br>

	

	<div align="center" id="main">
	

		
		<div class="background" id="backgroung"><br></br>

		<div class="backgroundDiv" id="backgroung">Location Master</div><br></br>
		
		<div align="right" style="width: 80%">
			
		<a href="location.do?parameter=deactiveLocations" >Show All In-Activated Locations</a>
			
		</div>
		
		<form action="location.do" >

					<center>
					
					
						<div id="errordiv" class="error-box" align="center">
							
							<logic:present name="message" scope="request">
								<span style="color: green; font-family: Segoe UI;">
									<bean:write name="message"/>
								</span>
							</logic:present>
						</div>
		
					
						<table cellpadding="8" cellspacing="5" id="biometric" width="80%">

					<tr class="trc">
						<td align="left" class="trd">Bio Machine Number<font color="red">*</font><br /> <input
							type="text" name="machinenumber" id="machinenumber"  /></td>
						<td align="left" class="trd">SCD Code<font color="red">*</font>
							<br /> <input type="text" name="locationnomber" id="locationnomber" maxlength="50"/></td>
						<td align="left" class="trd">Bio ID Index Number<font color="red">*</font>
							<br /> <input type="text" name="bioidindexnumber" id="bioidindexnumber" /></td>
						<td align="left" class="trd">Location Name<font color="red">*</font>
							<br /> <input type="text" name="locationname" id="locationname" maxlength="50" onchange="setdistrubutorname()"/></td>
					
						
						
						
					
					</tr>
					<tr>
						<td align="left" class="trd">TSM/TSE Name<font color="red">*</font>
							<br /> <input type="text" name="tsmname" id="tsmname" /></td>
					<td align="left" class="trd">Propriter/Distributer Name <font color="red">*</font><br />
							<input type="text" name="propritername" id="propritername" maxlength="50" readonly="readonly"/></td>
					<td align="left" class="trd">Distributer Number<font color="red">*</font>
							<br /> <input type="text" name="mobilenumber" id="mobilenumber" maxlength="10"/></td>
					
						<td align="left" class="trd">Contact Person<font color="red">*</font>
							<br /> <input type="text" name="companyname" id="companyname" maxlength="50"/>
						
					</tr>
					
					<tr>
					
				
						
						<td align="left" class="trd">Contact Number<font color="red">*</font>
							<br /> <input type="text" name="contactnumber" id="contactnumber" maxlength="10"/>
						</td>
							<td align="left" class="trd">Employee Strength<font color="red">*</font>
							<br /> <input type="text" name="empstrength" id="empstrength" maxlength="4"/>
						</td>
						
						
							<td align="left" class="trd">DSE-S Count<font color="red">*</font>
							<br /> <input type="text" name="dsecount" id="dsecount" maxlength="4"/>
						</td>
					
					<td align="left" class="trd">Propriter/Distributer Address<font color="red">*</font>
							<br /> <textarea id="propriteraddresss" name="propriteraddresss" rows="3"cols="25" style="resize: none"></textarea></td>
						
					
					</tr>

				</table><br></br>
							
							 
							
						
			      
			              
			              
				 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="LOCINSERT" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				 
				<html:submit value="Add" styleClass="submitbutton"  styleId="addbtn" property="parameter" onclick="return validation()"/>
				<input type="reset" value=" Clear " class="submitbutton"  onclick="cleardata()"/>
				
				 </logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
				  
				
				
				 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="LOCUPDATE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				  
				 <input type="button" value="  Edit  " class="submitbutton"  onclick="editLocation()"/>
				 <html:submit value="Update" styleClass="submitbutton"  property="parameter" onclick="return validationUpdate()"/>
				 
				
				 </logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
	 			 
	 			 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="LOCDELETE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				
				<input type="button" value= " Delete " class="submitbutton"  onclick="deleteLocation()"/>
			
				 </logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
			 
				<input type="hidden" name="locationid" id="locationid" value="" />
			

	
				
		</center>
	
	</form>
	<br></br>
	
	<div  class="tablecss" style="padding: 1%;">

		<logic:present name="location" scope="request">

			<display:table id="loc" name="location"
				 export="false" decorator="com.centris.decorator.LocationMasterDecorator"
				requestURI="/location.do?parameter=addlocation" pagesize="20">
				
				

 
					<display:column
						title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />">
						<input type="checkbox" name="selectBox" id="selectBox"
							value="${loc.locationid}"> </>
				</display:column>
				
				
				<display:column property="locationname" title="Location Name"
			 		 class="cellintag" />
					 
					 	<display:column property="machinenumber" title="Machine Number"
					 />
					 
					  <display:column property="asmname" title="TSM / TSE Name"
					 />
					 
					 	<display:column property="companyname" title="Contact Person"
					 />
					 
					   <display:column property="contactnumber" title="Contact Number"
					 />
					 
					  <display:column property="bioindexnumber" title="Bio ID Index Number"
					 />
					 
					 <display:column property="locationnomber" title="SCD Code"
			 		 class="cellintag" />
			 		 
			 		  <display:column property="dsecount" title="DSE-S Count"
			 		 class="cellintag" /> 
					
			
			 		 
			 		
				
					
					<%--  <display:column property="propritername" title="Propriter/Distributor Name"
					 />
					 <display:column property="mobilenumber" title="Phone No"
					 class="cellintag" /> --%>
			
					
					<%--   <display:column property="employeestrength" title="Employee Strength"
					 />
					 	<display:column property="propriteraddresss" title="Propriter/Distributor Address"
					 /> --%>
					 
					
					
			
				

				<display:setProperty name="export.pdf.filename"
					value="Location.pdf" />
				<display:setProperty name="export.pdf" value="true" />
				<display:setProperty name="export.excel.filename"
					value="Location.xls" />
				<display:setProperty name="export.excel" value="true" />
				<display:setProperty name="export.csv.filename"
					value="Location.csv" />
				<display:setProperty name="export.csv" value="true" />
				<display:setProperty name="export.xml.filename"
					value="Location.xml" />
				<display:setProperty name="export.xml" value="true" />

			</display:table>
			
			

		</logic:present>

	</div>
	</div>
	</div>

</body>

</html>
