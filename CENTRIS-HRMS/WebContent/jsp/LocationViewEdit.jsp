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
<script type="text/javascript" src="js/LocationView.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/LocationMaster.css"></link>

</head>
<body>

</br>
</br>
</br>


	

	<div align="center" id="main">
	

		
		<div class="background" id="backgroung"></br>

		<div class="backgroundDiv" id="backgroung">Modify Location </div></br>	
		
		<div align="right" style="width: 80%">
			
		
			
		</div>

	<form action="locationView.do" >

					<center>
					
					
						<div id="errordiv" class="error-box" align="center">
							
							
							
						
						</div>
	          
	     
						<table cellpadding="8" cellspacing="5" id="biometric" width="80%">

					<tr class="trc">
						<td align="left" class="trd">Bio Machine Number<font color="red">*</font><br /> <input
							type="text" name="machinenumber" id="machinenumber" 
   value="<logic:present name="locationlist"  scope="request"><bean:write name="locationlist" property="machinenumber"/></logic:present>"
 
 	></td>
					
					
					
					
																	
						<td align="left" class="trd">SCD Code<font color="red">*</font>
							<br /> <input type="text" name="locationnomber" id="locationnomber" maxlength="50"
							 value="<logic:present name="locationlist"  scope="request"><bean:write name="locationlist" property="locationnomber"/></logic:present>"/></td>
						<td align="left" class="trd">Bio ID Index Number<font color="red">*</font>
							<br /> <input type="text" name="bioidindexnumber" id="bioidindexnumber" 
														 value="<logic:present name="locationlist"  scope="request"><bean:write name="locationlist" property="bioindexnumber"/></logic:present>"/>
							 </td>
						<td align="left" class="trd">Location Name<font color="red">*</font>
							<br /> <input type="text" name="locationname" id="locationname" maxlength="50" onchange="setdistrubutorname()"
							 value="<logic:present name="locationlist"  scope="request"><bean:write name="locationlist" property="locationname"/></logic:present>"/></td>
					
						
						
						
					
					</tr>
					<tr>
						<td align="left" class="trd">TSM/TSE Name<font color="red">*</font>
							<br /> <input type="text" name="tsmname" id="tsmname" 
							 value="<logic:present name="locationlist"  scope="request"><bean:write name="locationlist" property="asmname"/></logic:present>"/></td>
					<td align="left" class="trd">Propriter/Distributer Name <font color="red">*</font><br />
							<input type="text" name="propritername" id="propritername" maxlength="50" readonly="readonly"
							 value="<logic:present name="locationlist"  scope="request"><bean:write name="locationlist" property="propritername"/></logic:present>"/></td>
					<td align="left" class="trd">Distributer Number<font color="red">*</font>
							<br /> <input type="text" name="mobilenumber" id="mobilenumber" maxlength="10"
							 value="<logic:present name="locationlist"  scope="request"><bean:write name="locationlist" property="mobilenumber"/></logic:present>"/></td>
					
						<td align="left" class="trd">Contact Person<font color="red">*</font>
							<br /> <input type="text" name="companyname" id="companyname" maxlength="50"
							 value="<logic:present name="locationlist"  scope="request"><bean:write name="locationlist" property="companyname"/></logic:present>"/>
						
					</tr>
					
					<tr>
					
				
						</td>
						<td align="left" class="trd">Contact Number<font color="red">*</font>
							<br /> <input type="text" name="contactnumber" id="contactnumber" maxlength="10"
							 value="<logic:present name="locationlist"  scope="request"><bean:write name="locationlist" property="contactnumber"/></logic:present>"/>
						</td>
							<td align="left" class="trd">Employee Strength<font color="red">*</font>
							<br /> <input type="text" name="empstrength" id="empstrength" maxlength="4"
							 value="<logic:present name="locationlist"  scope="request"><bean:write name="locationlist" property="employeestrength"/></logic:present>"/>
						</td>
					
					<td align="left" class="trd">Propriter/Distributer Address<font color="red">*</font>
							<br /> <textarea id="propriteraddresss" name="propriteraddresss" rows="3"cols="25" style="resize: none"><logic:present name="locationlist"  scope="request"><bean:write name="locationlist" property="propriteraddresss"/></logic:present></textarea></td>
						
					
					</tr>
               <input type="hidden" name="locationid" id="locationid" 
                  value="<logic:present name="locationlist"  scope="request"><bean:write name="locationlist" property="locationid"/></logic:present>" />
				</table>
	
                
				  
				
				 <html:submit value="Update" styleClass="submitbutton"  property="parameter" onclick="return validationUpdate()"/>



</center>
</form>
</div>
</div>
</body>
</html>