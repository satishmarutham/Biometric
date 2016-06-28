<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>De-Active Locations</title>

<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<script type="text/javascript" src="js/DeactiveLocations.js"></script>
</head>


<body>

</br></br></br>

	<div align="center" id="main">
	

		
		<div class="background" id="backgroung"></br>

		<div class="backgroundDiv" id="backgroung">In-Active Location Details</div>
		
			<center>
						<div id="errordiv" class="error-box">
							
							<logic:present name="message" scope="request">
								<span style="color: green; font-family: Segoe UI;">
									<bean:write name="message"/>
								</span>
							</logic:present>
						</div>
			</center>
			<div align="right" style="width: 70%">
			<input type="button" value="Go Back" class="submitbutton" onclick="goback()"/>
			<!-- <a href="location.do?parameter=addlocation">Go Back</a> -->
			</div>
		
		
		<div class="tablecss" style="width:80%;margin:40px;">
		
				<display:table export="false" id="locations"
					name="requestScope.deactivelocationslist"
					requestURI="/location.do?parameter=deactiveLocations" pagesize="20"
					cellpadding="5" cellspacing="5" size="20" style="bgcolor: RED;"
					>


					
						<display:column property="machinenumber" title="Machine Number"
					 />
					 
					 <display:column property="locationnomber" title="Location Number"
			 		 class="cellintag" />
			 		 
			 		  
					 <display:column property="bioindexnumber" title="Bio ID Index Number"
					 />
			
				<display:column property="locationname" title="Location Name"
			 		 class="cellintag" />
			 		 
			 		 <display:column property="asmname" title="TSM / TSE Name"
					 />
					  
					
					<%--  <display:column property="propritername" title="Propriter/Distributor Name"
					 />
					 <display:column property="mobilenumber" title="Phone No"
					 class="cellintag" /> --%>
				<display:column property="companyname" title="Contact Person"
					 />
					  <display:column property="contactnumber" title="Contact Number"
					 />
					<%--   <display:column property="employeestrength" title="Employee Strength"
					 />
					 	<display:column property="propriteraddresss" title="Propriter/Distributor Address"
					 /> --%>
					 <display:column
						title="">
					 <input type="button" name="activebutton" id="${locations.locationname}"
							value="Activate" onclick="activeRecords(this)" class="submitbutton"> </>
				</display:column>

				</display:table>
				
		

</div>
		
		</div>
		</div>	

</body>
</html>