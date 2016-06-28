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
<title>Travel Booked Details</title>
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
<script type="text/javascript" src="js/Manager/TravelBookedDetails.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/Manager/TravelBooking.css"></link>

</head>
<body>
	<br />
	<div class="background" id="backgroung">
	<center>
		<div class="backgroundDiv" id="backgroung">Travel Booked Details</div>
			</center>
			<center>
			<div id="errordiv" class="error-box" align="center">
					<logic:present name="successmessage" scope="request">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="successmessage" />
						</span>
					</logic:present>
					<logic:present name="errormessage" scope="request">
						<span style="color: red; font-family: Segoe UI;"> <bean:write
								name="errormessage" />
						</span>
					</logic:present>
				</div>
				</center>
<center><div id="loader" style="position: absolute;top:160px;left:610px;display: none;"><img  src="images/loaderimage2.GIF"/></div></center>
		<center>
			  <form action="travelBooked.do?method=saveTravelBookedDetails" enctype="multipart/form-data" method="post">		
			   <fieldset style="width:75%;">
         			<br/>
					<table cellpadding="5" cellspacing="0" id="biometric" width="75%">

						<tr class="trc">
							<td class="left">Ticket booked by<font color="red">*</font></td>
							<td class="right"><input type="text" name="ticketbookedby" id="ticketbookedby" 
							  placeholder="Search Employee Name"/></td>
							<input type="hidden" name="ticketbookedbyempid" id="ticketbookedbyempid"></input>
							
							<td class="left">Resource Who is On Travel<font color="red">*</font></td>
							<td class="right"><input type="text" name="whoisontravel" id="whoisontravel"  placeholder="Search Employee Name"/></td>
								<input type="hidden" name="whoisontravelempid" id="whoisontravelempid"></input>
						</tr>
						<tr class="trc">
							
							<td class="left">Mode<font color="red">*</font></td>
							<td class="right"><select name="travelmode" id="travelmode" style="width:100%;">
							   <option value="">----Select----</option>
							   <option value="Bus">Bus</option>
							   <option value="Train">Train</option>
							   <option value="Flight">Flight</option></select></td>
							 <td class="left">Project<font color="red">*</font></td>
     						<td class="right"><select name="projectcode" id="project" style="width:100%;" onchange="return checkManager(this.value)">
							   <option value="">----Select----</option></select></td>
     					     <input type="hidden" name=projectrefcode id="projectrefcode"></input>
     					</tr>	
     					<tr class="trc">
     						<td class="left">Travel From<font color="red">*</font></td>
     						<td class="right"><input type="text" name="travelfrom" id="travelfrom" /></td>
							<td class="left">Travel To<font color="red">*</font></td>
							<td class="right"><input type="text" name="travelto" id="travelto" /></td>
						
						</tr>
						
						<tr class="trc">
     						<td class="left">Booking Date<font color="red">*</font></td>
     						<td class="right"><input type="text" name="bookingdate" id="bookingdate"  readonly="readonly"
     						           placeholder="Click Here"/></td>
							<td class="left">Travelling Date<font color="red">*</font></td>
							<td class="right"><input type="text" name="travellingdate" id="travellingdate" onchange="checkvalidateTravelDate(this.value);"
								           placeholder="Click Here" readonly="readonly" /></td>
						
						</tr>
						<tr class="trc">
     						
							<td class="left">Amount<font color="red">*</font></td>
							<td class="right"><input type="text" name="amount" id="amount" /></td>
						     <td class="left">Debit/Credit Card Used<font color="red">*</font></td>
     						<td class="right"><input type="text" name="debitorcreditcardused" id="debitorcreditcardused"  placeholder="Search Employee Name"/></td>
     						<input type="hidden" name="debitorcreditcardusedempid" id="debitorcreditcardusedempid"></input>
						</tr>
						
						<tr class="trc">
     						<td class="left">Attachment<font color="red">*</font></td>
							<td class="right"><input type="file" name="file" id="file" style="width:100%; " /></td>
							<td class="left">Remarks</td>
							<td class="right" ><textarea name="remarks" id="remarks" 
							     style="resize:none;"></textarea></td>
							     <input type="hidden" name="conflict" id="conflictRow"></input>
						</tr>
						
						<tr class="trc" style="display: none;" id="downloadtr">
						<td class="left">File download<font color="red">*</font></td>
						<td class="right"><input type="button" name="download" id="download" value="download"   
							 onclick="filedownload()"/></td>
					
						</tr>
					
					</table>
					</fieldset>
					
			<table>
			<tr>
				<td><input type="submit" value="Save Booked Details" class="submitbutton"  onclick="return validations()" /></td>
				<td><input type="reset" value=" Clear " class="submitbutton"	onclick="cleardata()" /></td> 
			</tr>
			</table>
		</form>
		</center>
	<br/>
	<center>
			<logic:present  name="TicketBookedDetails" scope="request">
				<logic:notEmpty name="TicketBookedDetails" scope="request" >
			
					<display:table id="ACCLT" style="width:90%;" class="view"
						name="requestScope.TicketBookedDetails"
				     	requestURI="/travelBooked.do?method=travelBookedDetailsHome" 
						pagesize="10" decorator="">
					
				
						<display:column property="booked_by_empname" title="Travel Booked by" />
						<display:column property="who_on_travel_empname" title="Who is on Travel" />
						<display:column property="travel_mode" title="Mode" />
						<display:column property="project_Ref_code" title="ProjectRef Code" />
						<display:column property="project" title="Project" />
						<display:column property="travel_from" title="Travel From" />
						<display:column property="travel_to" title="Travel To" />
						<display:column property="booked_date" title="Booking Date" />
						<display:column property="travelling_date" title="Travelling Date" />
						<display:column property="amount" title="Amount" />
						<display:column property="debit_card_used_by_empname" title="Debit/Credit Card Used" />
						<display:column property="posteddate" title="Posted Date" />
						<display:column property="status" title="Status" />
						<display:column property="approvedamount" title="Approved/Rejected Amount" />
						<display:column property="approvedby" title="Approved/Rejected By" />
					    <display:column property="approvedtime" title="Approved/Rejected Date" />
					</display:table>
		
				
    </logic:notEmpty>
	</logic:present>
	</center>
		<br/><br/>	
		</div>
<br/>	
</body>
</html>
