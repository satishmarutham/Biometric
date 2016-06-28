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
<title>Location Details</title>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/LocationMaster.css"></link>
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


</head>
<body>

	</br>
	</br>
	</br>




	<div align="center" id="main">



		<div class="background" id="backgroung">
			</br>

			<div class="backgroundDiv" id="backgroung">Location View</div>
			<div id="errordiv" class="error-box">
				<logic:present name="message" scope="request">
					<span style="color: green; font-family: Segoe UI;"> <bean:write
							name="message" />
					</span>
				</logic:present>
			</div>
			</br>
			<form action="locationView.do">
				<table id="biometric">
					<tr>

						<td><input type="text" id="searchlocation"
							name="searchLocation" placeholder="Type Location Name" /></td>
						<td><html:submit property="parameter"
								styleClass="submitbutton" value="Search"
								onclick="return validate();" /></td>

					</tr>
				</table>

				</br>

				<div class="tablecss" style="padding: 1%;">

					<logic:present name="location" scope="request">

						<display:table id="loc" name="location" class="highlightRow"
							export="false"
							decorator="com.centris.decorator.LocationMasterDecorator"
							requestURI="/locationView.do?parameter=locationView"
							pagesize="30">



							<display:column property="locationid" title="Location ID"
								paramId="locId"
								href="locationView.do?parameter=editLocation&${loc.locationid}"
								style="font-weight: bold;" />

							<display:column property="locationname" title="Location Name"
								style="font-weight: bold;" />




							<display:column property="bioindexnumber"
								title="Bio Index Number" class="cellintag"
								style="font-weight: bold;" />

							<display:column property="asmname" title="TSM / TSE Name" />

							<display:column property="locationnomber" title="SCD Code" />


							<display:column property="propriteraddresss" title="Address" />
							<display:column property="dsecount" title="Total DSE" />
							<display:column property="noofemployees"
								title=" Total Employees" style="font-weight: bold;" />




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
			</form>
		</div>
	</div>

</body>

</html>
