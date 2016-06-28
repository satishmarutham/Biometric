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
<script type="text/javascript" src="js/Employee/MoreAttendanceDetails.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/login/style.css">
<link rel="stylesheet" href="css/login/common.css">

</head>
<body>



<div id="main" class="background">

		<center>

			<div class="backgroundDiv" id="backgroung">Attendance Details</div>
		
	<center>
					<div id="errordiv" class="error-box" align="center">

						<logic:present name="successMessage" scope="request">
							<span style="color: green; font-family: Segoe UI;"> <bean:write
									name="successMessage" />
							</span>
						</logic:present>
						<logic:present name="errorMessage" scope="request">
							<span style="color: red; font-family: Segoe UI;"> <bean:write
									name="errorMessage" />
							</span>
						</logic:present>
						
						<span style="color: green; font-family: Segoe UI;" id="successmessge"> 
							</span>
						
					</div>
				</center>
		
		  <form action="viewAttendanceDetails.do">
		    <input type="hidden" value="getMoreAttendanceDetails" name="parameter"  ></input>
		      
		       <fieldset style="width: 75%;"><br/>											
					<table cellpadding="5" cellspacing="2" id="biometric" width="60%">
		
					<tr>
						<td class="left">Start Date <font color="red">*</font></td>
						<td class="right" ><input type="text" style="text-align: center;" name="startdate" id="startdate"  readonly="readonly" placeholder="Click here" 
						value="" /></td>
						<td class="left">End Date <font color="red">*</font></td>
						<td class="right"><input type="text" name="enddate" id="enddate" style="text-align: center;" readonly="readonly" placeholder="Click here"
						value="" /></td>
					   <%--   <logic:present name="employeeId" scope="request">
					     <input type="hidden" name="employeeId" value='<bean:write name="employeeId"   scope="request" /> ' />
					     </logic:present> --%>
						   
					</tr>	
					<tr>
					
					</tr>
			</table>
			
			</fieldset>
			
			
			<input type="hidden" id="hstartdate" value="<logic:present name="currentsearch" scope="request"><bean:write name="currentsearch" property="startdate"/></logic:present>"/>
			<input type="hidden" id="henddate" value="<logic:present name="currentsearch" scope="request"><bean:write name="currentsearch" property="enddate"/></logic:present>"/>
		
			
			<center>
						<table>
								<tr class="odd">

									<td colspan="3"><center>
											<input type="submit" class="submitbutton" value="Get Attendance"
												  onclick="return validate()" /> 
										</center></td>

								</tr>

							</table>
				</center>
				
				
				</form>
				
					
	
					
	<br/>
	<center>
			<logic:present  name="MoreAttendanceDetails" scope="request">
				<logic:notEmpty name="MoreAttendanceDetails" scope="request" >
			
					<display:table id="ACCLT" style="width:90%;" class="view"
						name="requestScope.MoreAttendanceDetails"
				     	requestURI="/viewAttendanceDetails.do?parameter=getMoreAttendanceDetails" 
						pagesize="10" decorator="">
				
						<display:column property="sno" title="S.No" />
						<display:column property="attendanceDate" title="Attendance Date" />
						<display:column property="intime" title="InTime" />
						<display:column property="outtime" title="OutTime" />
						<display:column property="totaltime" title="TotalTime" />
						<display:column property="projectname" title="Client Name" />
						<display:column property="reportingto" title="Reporting To" />
						<display:column property="attendancestatustype" title="AttandanceStatusType" />
						<display:column property="attendancestatus" title="AttandanceStatus" />
				        <display:column property="location" title="Location" />	
				        <display:column property="postedstatus" title="PostedStatus" />
				        <display:column property="approvedstatus" title="ApprovedStatus" />		
				        
					</display:table>
		
				
    </logic:notEmpty>
	</logic:present>
	</center>
		<br/><br/>		
					
					
				
				
				

			
		</center>
</div><br/><br/>
<%-- <logic:present name="goBackToManager" scope="request"><span id="dashboard_goBack" onclick="gobackToManagerHome('<logic:present name="empId" scope="request"><bean:write name="empId" scope="request"></bean:write></logic:present>','<logic:present name="empName" scope="request"><bean:write name="empName" scope="request"></bean:write></logic:present>')" style="margin-left:90%;text-decoration: underline;
                                             cursor: pointer;">go back</span>
                                        
                                             </logic:present> --%>

<logic:empty name="goBackToManager" scope="request"> <span id="dashboard_goBack" onclick="goback()" style="margin-left:90%;text-decoration: underline;
                                             cursor: pointer;">go back</span>
                                          
                                             </logic:empty>


</body>
</html>