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
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Designation Master</title>
<link rel="stylesheet" type="text/css" href="style.css" />
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
<script type="text/javascript" src="js/Admin/adddesignation.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link href="css/latecomersreport.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>

</head>

<body>

	<div align="center" id="main">


		<div class="background" id="backgroung">

		<div class="backgroundDiv" id="backgroung">Designation Master</div>

	<form name="adddesignation" action="adddesignation.do">
	
		
			<center>
						<div id="errordiv" class="error-box">
							
							<logic:present name="message" scope="request">
								<span style="color: green; font-family: Segoe UI;">
									<bean:write name="message"/>
								</span>
							</logic:present>
						</div>
			</center>
			
		<table cellpadding="5" cellspacing="0" id="biometric" align="center" width="60%">
		
		
							<tr class="trc">

								<td class="left">Designation Name<font color="red">*</font></td>
								<td class="right"><input type="text" id="designationname" name="designation_name" onblur="validateDesName()"/></td>
								
							</tr>
							<tr>
							
								<td class="left">Designation Description<font color="red"></font></td>
								<td class="right"><input type="text" id="designationdes" name="designation_description"/></td>
								
							
							</tr>
							
							<tr class="trc">

								<td class="left">Reporting To<font color="red">*</font></td>
								<td class="right">
								
								<select name="reportingTo" id="reportingToId">
				
								<logic:present name="DesignationDetails" scope="request">
								<option value="">------Select-----</option>
								<logic:iterate id="reportingToDetails" name="DesignationDetails">
								
								<option value='<bean:write name="reportingToDetails" property="desgid"/>'><bean:write name="reportingToDetails" property="desgname"/></option>
								
								
								</logic:iterate>
								
								</logic:present>
							</select>
								
								</td>
								
							</tr>
		

	</table><br/>
	
		
		
		<table align="center">
		
		
		
		<tr>
		
		 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="DESINSERT" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				 
			<td><html:submit  value="Add" styleClass="submitbutton" styleId="add" onclick="return validations()" property="parameter"/></td>
				 <td><input type="reset" value=" Clear " class="submitbutton"  onclick="cleardata()"/></td> 
			</logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
	 			 
	 			 
	 			  <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="DESUPDATE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >	  
				  
				  <td><input type="button" value="  Edit  " class="submitbutton" onclick="editDesignation()"/></td>
				  
				  <td><html:submit  value="Update" styleClass="submitbutton" onclick="return validationsUpdate()" property="parameter"/></td>
				  
				  </logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
				  
				    <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="DESDELETE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >	 
				 
				 <td><input type="button" value= " Delete " class="submitbutton" onclick="deleteDesignation()"/></td>
				 
				 	  
				  </logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
				 
				<input type="hidden" name="designationid" id="designationid" value="" />
		</tr>
		
		</table>
		
		

	</form>

	<div  class="tablecss" style="width:60%;">

		<logic:present name="DesignationDetails" scope="request">

			<display:table id="designation" name="DesignationDetails"
				 export="false" decorator="com.centris.decorator.AddDesignationDecorator"
				requestURI="/adddesignation.do?parameter=addDesignation" pagesize="25">

			<%-- 	<display:column property="check" title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />"
					 class="cellintag" /> --%>
				<display:column
						title="<input type='checkbox' name='selectall' id='selectall' onClick='selectAll()' />">
						<input type="checkbox" name="selectBox" id="selectBox"
							value="${designation.desgid}"> </>
				</display:column>
				<display:column property="desgname" title="Designation Name"
				class="cellintag" />
				<display:column property="desgdes" title="Designation Description"
				/>
				<display:column property="reportingToName" title="Reporting To"
				/>
				
				
				<display:setProperty name="export.pdf.filename"
					value="Designation.pdf" />
				<display:setProperty name="export.pdf" value="true" />
				<display:setProperty name="export.excel.filename"
					value="Designation.xls" />
				<display:setProperty name="export.excel" value="true" />
				<display:setProperty name="export.csv.filename"
					value="Designation.csv" />
				<display:setProperty name="export.csv" value="true" />
				<display:setProperty name="export.xml.filename"
					value="Designation.xml" />
				<display:setProperty name="export.xml" value="true" />

			</display:table>

		</logic:present><br/>

	</div>
	
	</div>
	</div>
</body>



</html>
