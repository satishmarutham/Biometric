<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Breakup Master</title>
<link rel="stylesheet" type="text/css" href="view.css" />
<style type="text/css">
#EditbreakupMaster label,#addbreakupMaster label{
font-size: 13px;
}

 
</style>

 <link href="css/bootstrap-combined.min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="css/text" href="JQUERY/css/jquery.ui.all.css" />
<link rel="stylesheet" type="css/text" href="css/bootstrap-datetimepicker.min.css" />
<link href="css/latecomersreport.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery-ui.custom.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="JQUERY/development-bundle/ui/jquery.ui.core.js"></script>
 <script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script> 
<script type="text/javascript" src="JQUERY/js/bootstrap-datetimepicker.min.js"></script> 
<script type="text/javascript" src="js/timepicker.js"></script>
 <script type="text/javascript" src="js/employeeRegistration.js"></script>
<script type="text/javascript" src="js/BreakupMaster.js"></script>
<script type="text/javascript">


	$(function() {
		$("#datetimepicker3").datetimepicker({
			pickDate : false
		});
		$('#datetimepicker4').datetimepicker({
			pickDate : false
		});
		$("#datetimepicker6").datetimepicker({
			pickDate : false
		});
		$('#datetimepicker7').datetimepicker({
			pickDate : false
		});
		
	});
</script>

<style type="text/css">
.ui-widget input, .ui-widget select, .ui-widget textarea, .ui-widget button { 
 font-size: 15px;
 }

</style>

</head>
<body>
	<body bgcolor="#FFFFFF">
	  <jsp:include page="header_menu.jsp"></jsp:include> 
	<br></br><br/> <br/>
	
		<center>
			<font
				style="font-family: sans-serif; font-weight: bolder; color: #000000; font-size: 17px;">
				Breakup Master</font>
		</center>
	
			&nbsp;&nbsp;&nbsp;	
		
		
	<table align="center">
	
	<tr><td>
	<logic:present name="SuccessMessage">
				<p class="alertMessage" style="font-size: 15px;  font-family: Segoe UI; color: red; font-weight: bold;"><bean:write name="SuccessMessage"/></p>
				</logic:present>
	</td></tr>
	

		<%-- 		
			<logic:present name="roleName" scope="session">
	
	
	<c:set var="user" value="Super Admin" />
	
	<c:if test="${ roleName!= user}"> 
	
		<tr>
<td>				<input type="button" value="CreateBreak" class="button1"
										id="createBreakId" /> &nbsp;&nbsp;&nbsp; 
										<input type="button"
										value="Update" class="button1" id="editId" />
										
										
										 &nbsp;&nbsp;&nbsp; 
										<input type="button"
										value="Delete" class="button1" id="deleteId" />
								</td>

						</tr>
						
							</c:if>
</logic:present> --%>

					</table>
						&nbsp;&nbsp;&nbsp;	
		<div id= "addbreakupMaster" scrolltop="0" scrollleft="0" style="width: 100%; min-height: 0px; height: 128px;">
						<table>
							<tr bordercolor="white">
	<p id="addalertMessage" style="color: red;font: normal;font-weight:normal;"></p>
							<td><label for="breakupName" class="LblDialog" style="font-size: 13px;font-weight: 600;width:142px;">BreakupName<font color="red">*</font></label></td>
						<td> <input type="text" name="breakupName" id="breakupNameId" 
											style="width: 88px" 
							class="textBoxInDialog" /></td>

							</tr>
							<tr>

								<td><div id="datetimepicker3" class="input-append"><label for="startTime" class="LblDialog" style="font-size: 13px;font-weight: 600;">Start Time<font color="red">*</font></label>
						<input type="text" id="addStartTimeId" name="startTime"  data-format="hh:mm:ss" value="00:00:00" style="width: 88px">
						<span class="add-on"> <img src="./images/time.jpg" width="25" height="10"></span>
					</div>
										
								
								</td>

								<td>
								
										<div id="datetimepicker4" class="input-append"><label for="endTime" class="LblDialog" style="font-size: 13px;font-weight: 600;">End Time<font color="red">*</font></label>
						<input type="text" id="addendTimeId" name="endTime" data-format="hh:mm:ss"  value="00:00:00" style="width: 88px">
						<span class="add-on"><img src="./images/time.jpg" width="25" height="10"></span>
					</div>
								
								</td>
								
								
								
								<td>
							
										<div id="datetimepicker5"><label for="totaltime" class="LblDialog" style="font-size: 13px;font-weight: 600;">TotalTime<font color="red">*</font></label>
					
					 <input type="text" name="totalTime" id="addtotalTimeId" 
										readonly="readonly" data-format="hh:mm:ss"	style="width: 88px" 
							class="textBoxInDialog" onfocus="addtotalTime();"/>
					
						<!-- <input type="text" id="addtotalTimeId" name="totalTime" readonly="readonly" data-format="hh:mm:ss"  style="width: 88px" onfocus="addtotalTime();">
						<span class="add-on"> </span> -->
					</div>
								
								</td>
							</tr>
							
						</table>
					
					</div>
					
					
						<div id= "EditbreakupMaster">
						<table>
							<tr bordercolor="white">
								<p id="editalertMessage" style="color: red;font: normal;font-weight:normal;"></p>
							

							

<td align="left"  class="dialogText"><label for ="breakupCode" class="LblDialog">Breakup Code<font color="red">*</font></label>
							<br /> <input type="text" name="breakupCode" id="editbreakupCodeId" class="dialogText" readonly="readonly"
											style="width: 120px" 
							class="textBoxInDialog" /></td>
							
							
							<td align="left"  class="dialogText"><label for="startTime" class="LblDialog" style="font-size: 13px;font-weight: 600;">Breakup Name<font color="red">*</font></label>
							<br /> <input type="text" name="breakupName" id="editbreakupNameId" class="dialogText"
											style="width: 120px" 
							class="textBoxInDialog" /></td>
							
							</tr>
						
							<tr>

								<td>
								
									<div id="datetimepicker6" class="input-append"><label for="startTime" class="LblDialog" style="font-size: 13px;font-weight: 600;">Start Time<font color="red">*</font></label>
						<input type="text" id="editstartTimeId" name="startTime" data-format="hh:mm:ss" value="00:00:00" style="width: 88px">
						<span class="add-on"> <img src="./images/time.jpg" width="25" height="10"></span>
					</div></td>

							
								<td>
								
									<div id="datetimepicker7" class="input-append"><label for="endTime" class="LblDialog" style="font-size: 13px;font-weight: 600;">EndTime<font color="red">*</font></label>
						<input type="text" id="editendTimeId" name="endTime" data-format="hh:mm:ss" style="width: 88px" value="00:00:00">
						<span class="add-on"> <img src="./images/time.jpg" width="25" height="10"></span>
					</div></td>
								
					<td>
								
									<div id="datetimepicker8" ><label for="endTime" class="LblDialog" style="font-size: 13px;font-weight: 600;">TotalTime<font color="red">*</font></label>
					
						<input type="text" name="totalTime" id="edittotalTimeId" 
										readonly="readonly" data-format="hh:mm:ss"	style="width: 88px" 
							class="textBoxInDialog" onfocus="edittotalTime();"/>
					
					</div></td>
				
										
										
									
							</tr>
							
						</table>
				<br/>	<br/>	<br/>
					</div>
					
					
					
					
					
		<center>
       			
       					<display:table id="data" name="requestScope.breakupList" class="displayTableClass" requestURI="/GetDetails.do? method=getBreakupMasters" pagesize="10" export="false" decorator="com.centris.decorator.BreakupMasterDecorator">
<logic:present name="roleName" scope="session">
	
	
	<c:set var="user" value="Super Admin" />
	
	<c:if test="${ roleName!= user}"> 
	<display:column property="allCheckBox"  sortable="true"  title="Check"/>
	
		</c:if>
</logic:present>
       				
          	   			<display:column  property="breakupName" sortable="true" title="Breackup Name" />
           	   			<display:column property="startTime" sortable="true"  title="StartTime" />
               			<display:column property="endTime" sortable="true" title="End Time" />
              			<display:column property="totalTime" sortable="true"  title="Total Time" />
              			

      		
				</display:table>	

							 
		</center>			
			 <jsp:include page="footer.jsp"></jsp:include> 		
	
</body>
</html>