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

<title>View Attendance Details</title>
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
<script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>
<script type="text/javascript" src="js/Employee/MoreTravelAllowance.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/login/style.css">
<link rel="stylesheet" href="css/login/common.css">

</head>
<body>



<div id="main" class="background">

		<center>

			<div class="backgroundDiv" id="backgroung">Travel Allowance Details</div>
		
	<center>
					<div id="errordiv" class="error-box" align="center">
						
					</div>
				</center>
		
		  <form action="employeeDashboard.do">
		    <input type="hidden" value="getMoreTravelAllowanceDetails" name="method"  ></input>
		      
		       									
					<table cellpadding="5" cellspacing="2" id="biometric" width="60%">
		
					<tr>
						<td class="left">Start Date <font color="red">*</font></td>
						<td class="right" ><input type="text" style="text-align: center;" name="startdate" id="startdate"  readonly="readonly" placeholder="Click here" 
						value="" /></td>
						<td class="left">End Date <font color="red">*</font></td>
						<td class="right"><input type="text" name="enddate" id="enddate" style="text-align: center;" readonly="readonly" placeholder="Click here"
						value="" /></td>
					    <logic:present name="empId" scope="request">
					     <input type="hidden" name="employeeId" value='<bean:write name="empId"   scope="request" /> ' />
					     </logic:present>
						   
					</tr>	
					<tr>
					
					</tr>
			</table>
			
			
			
			
			<input type="hidden" id="hstartdate" value="<logic:present name="selectStartdate" scope="request"><bean:write name="selectStartdate" /></logic:present>"/>
			<input type="hidden" id="henddate" value="<logic:present name="selectEnddate" scope="request"><bean:write name="selectEnddate" /></logic:present>"/>
		
			
			<center>
						<table>
								<tr class="odd">

									<td colspan="3"><center>
											<input type="submit" class="submitbutton" value="Get TravelAllowances"
												  onclick="return validate()" /> 
										</center></td>

								</tr>

							</table>
				</center>
				
				
				</form>
				
					
	
					
	<br/>
	<center>
			<logic:present  name="MoreTravelDetails" scope="request">
				<logic:notEmpty name="MoreTravelDetails" scope="request" >
			
					<display:table id="ACCLT" style="width:90%;" class="view"
						name="requestScope.MoreTravelDetails"
				     	requestURI="/employeeDashboard.do?parameter=getMoreTravelAllowanceDetails" 
						pagesize="10" decorator="">
				
						<display:column property="sno" title="S.No" />
						<display:column property="booked_by_empname" title="Ticket_booked_by" />
						<display:column property="who_on_travel_empname" title="Resource_who_is_on_travel" />
						<display:column property="debit_card_used_by_empname" title="Debit_card_used_by" />
						<display:column property="booked_date" title="Booked_date" />
						<display:column property="travelling_date" title="Travelling_date" />
						<display:column property="travel_from" title="Travel_from" />
						<display:column property="travel_to" title="Travel_to" />
						<display:column property="travel_mode" title="Travel_Mode" />
						
						<display:column property="project_Ref_code" title="Project RefCode" />
				        <display:column property="amount" title="Amount" />	
				        <display:column property="posted_by" title="Posted_by" />
				        <display:column property="posteddate" title="Posteddate" />		
				           <display:column property="status" title="Status" />	
				              <display:column property="approvedby" title="Approvedby" />	
				                  <display:column property="approvedamount" title="Approvedamount" />
				                 <display:column property="approvedtime" title="Approvedtime" />	
				               	
				        
					</display:table>
		
				
    </logic:notEmpty>
	</logic:present>
	</center>
		<br/><br/>		
					
					
				
				
				

			
		</center>
</div><br/><br/>
<logic:present name="goBackToManager" scope="request"><logic:notEmpty name="goBackToManager" scope="request"><span id="dashboard_goBack" onclick="gobacktoManager('<bean:write name="empId" scope="request"></bean:write>','<bean:write name="empName" scope="request"></bean:write>')" style="margin-left:90%;text-decoration: underline;  cursor: pointer;">go back</span></logic:notEmpty></logic:present>


<logic:empty name="goBackToManager" scope="request"><span id="dashboard_goBack" onclick="goback()" style="margin-left:90%;text-decoration: underline;  cursor: pointer;">go back</span></logic:empty>
                                          
                                         


</body>
</html>