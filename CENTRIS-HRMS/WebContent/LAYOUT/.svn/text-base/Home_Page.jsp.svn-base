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
<!-- Meta Tags -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap CSS -->
<link type="text/css" rel="stylesheet"
	href="css/login/bootstrap.min.css">
<link rel="stylesheet" href="css/login/register_style.css">
<link type="text/css" rel="stylesheet" href="css/login/nav_tabs.css">
<style type="text/css">
.ui-x .ui-header .ui-menu {
	height: 45px !important;
}
</style>
<link rel="stylesheet" href="css/login/dashboard.css">
<!-- Bootstrap Theme CSS -->
<link type="text/css" rel="stylesheet"
	href="css/login/bootstrap-theme.min.css">
<!-- Bootstrap JS -->
<script src="js/Login/jquery.min.js"></script>
<!-- Bootstrap JS -->
<script src="js/Login/bootstrap.min.js"></script>
<!-- Bootstrap Hover Dropdown JS -->
<script src="js/Login/bootstrap-hover-dropdown.min.js"></script>
<!-- Font Awesome CSS -->
<link rel="stylesheet" href="css/login/font-awesome.min.css">
<!-- Style CSS -->
<link rel="stylesheet" href="css/login/style.css">
<link rel="stylesheet" href="css/login/common.css">
<script type="text/javascript" src="js/Employee/EmployeeDashboard.js"></script>
<script type="text/javascript" src="js/Employee/EmployeeResumeCreation.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
</head>
<body>
<br/>
<br/>
<br/>
<!-- UI - X Starts -->
	<div class="ui-x">
		<div class="container">
			
			<div class="col-md-4">
				<!-- Item -->
				<div class="ui-item">
					<!-- Collapse -->
					<div class="ui-collapse">
						<!-- Panel Title -->
						<div class="ui-title clearfix">
							<i class="fa fa-bars"></i> <a data-toggle="collapse"
								href="#collapseOne" class="ui-heading">Attendance Details </a> <a
								href="#" class="ui-close"><span></span></a> <a
								data-toggle="collapse" href="#collapseOne" class="ui-angle"><span></span></a>
							<a href="#" class="ui-referesh"><span></span></a>
						</div>
						<!-- Collapse Content -->
						<div id="collapseOne" class="panel-collapse collapse">
						  <br/>
				<logic:present name="threemonthsAttendanceDetails" scope="request">
						 <span style="background-color: gainsboro;margin-left:25%;padding-top:1%;padding-bottom:1%">Last Attendance Posted On :&nbsp;<bean:write name="AttendanceDetails" property="lastposteddate"/> </span><br/><br/>
				         <span style="margin-left:26%;">(Three Months Attendance Details)</span>
				        
				           <table class="view">
				              <tr>
				              <th>Month</th>
				              <th>Total Days
                                 <th>Working Days</th>
                                 <th>Present</th>
                                  <th>Absent</th>
                                   <th>Leave</th>
                                   <th>Holiday</th>
				              </tr>
				               <logic:iterate id="threemonthsAttendance" name="threemonthsAttendanceDetails">
				             <tr>
				             <td><bean:write name="threemonthsAttendance" property="month"/></td>
                              <td><bean:write name="threemonthsAttendance" property="totaldaysinmonth"/>
                              <td><bean:write name="threemonthsAttendance" property="workingdays"/></td>
                              <td><bean:write name="threemonthsAttendance" property="totPresent"/></td>
                              <td><bean:write name="threemonthsAttendance" property="totAbsent"/></td>
                              <td><bean:write name="threemonthsAttendance" property="totLeave"/></td>
				              <td><bean:write name="threemonthsAttendance" property="totHoliday"/></td>
				             </tr> 
				             </logic:iterate> 
						</table>
						
				    <br/>
					 <span id="dashboard_goBack" onclick="moreAttendanceDeatails()" style="left : 90%;">View More Details</span>
		
			 		<br/>
					  <span style="margin-left:26%;">(Post Attendance Pending)</span>
					 <table class="view">
			   	      <tr><th>S.No
			   	       <th>PostAttendance Pending Days </th>
                         <th>Start Date</th>
                         <th>End Date</th>
                     </tr>
				   <tr>
                        <td>1
                       <td><bean:write name="AttendanceDetails" property="pendingdays"/> </td>
                       <td><bean:write name="AttendanceDetails" property="startdate"/> </td>
                        <td><bean:write name="AttendanceDetails" property="enddate"/> </td>				
				</tr>  
				</table>
					 </logic:present>
				<br/>
					 <span id="dashboard_goBack" onclick="postAttendance()" style="left : 90%;">Post Attendance</span>
						</div>
					</div>
				</div>
			</div>
			
			
			
			<div class="col-md-4">
				<!-- Item -->
				<div class="ui-item">
					<!-- Collapse -->
					<div class="ui-collapse">
						<!-- Panel Title -->
						<div class="ui-title clearfix">
							<i class="fa fa-bars"></i> <a data-toggle="collapse"
								href="#collapseTwo" class="ui-heading">Allowances </a> <a
								href="#" class="ui-close"><span></span></a> <a
								data-toggle="collapse" href="#collapseTwo" class="ui-angle"><span></span></a>
							<a href="#" class="ui-referesh"><span></span></a>
						</div>
						<!-- Collapse Content -->
						<div id="collapseTwo" class="panel-collapse collapse">

					<logic:present name="DailyAllowances" scope="request">
						<logic:notEmpty name="DailyAllowances" scope="request">
				         <span style="margin-left:26%;">(Current Month Allowance Details)</span>
				           <table class="view">
				              <tr><th>S.No
                                 <th>Year</th>
                                 <th>Month</th>
                                  <th>Reporting Manager</th>
                                   <th>Claimed Amount</th>
                                   <th>Approved Amount</th>
				              </tr>
				            <logic:iterate id="iterateid" name="DailyAllowances" scope="request">
				             <tr>
                              <td><bean:write name="iterateid" property="sno"/>
                              <td><bean:write name="iterateid" property="year"/></td>
                              <td><bean:write name="iterateid" property="month"/></td>
                              <td><bean:write name="iterateid" property="postedby"/></td>
                              <td><bean:write name="iterateid" property="amount"/></td>
				              <td><bean:write name="iterateid" property="approvedamount"/></td>
				              
				             </tr>  
				               </logic:iterate>
						</table>
				    <br/>
					 <span id="dashboard_goBack" onclick="moreAllowanceDeatails()" style="left : 90%;">View More Details</span>
					 </logic:notEmpty>
					 <logic:empty name="DailyAllowances" scope="request">
					  <span>Nothing found to display</span>
					 </logic:empty>
			 </logic:present>
							
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="col-md-4">
				<!-- Item -->
				<div class="ui-item">
					<!-- Collapse -->
					<div class="ui-collapse">
						<!-- Panel Title -->
						<div class="ui-title clearfix">
							<i class="fa fa-bars"></i> <a data-toggle="collapse"
								href="#collapseThree" class="ui-heading">Leave Details
							</a> <a href="#" class="ui-close"><span></span></a> <a
								data-toggle="collapse" href="#collapseThree" class="ui-angle"><span></span></a>
							<a href="#" class="ui-referesh"><span></span></a>
						</div>
						<!-- Collapse Content -->
						<div id="collapseThree" class="panel-collapse collapse">
						<br/>
								
								  <logic:present name="ViewLeaveDetails" scope="request">
		   
		        <table class="view">
				              <tr>
                                 <th>Year</th>
                                 <th>Leave Type</th>
                                 <th>Opening Balance</th>
                                  <th>Leaves Consumed</th>
                                   <th>Closing Balance</th>
				              </tr>
				            <logic:iterate id="iterateid" name="ViewLeaveDetails"> 
				             <tr>
                              <td><bean:write name="iterateid" property="accyear"/>
                              <td><bean:write name="iterateid" property="leavetype"/></td>
                              <td><bean:write name="iterateid" property="openingbal"/></td>
                              <td><bean:write name="iterateid" property="consumebal"/></td>
                              <td><bean:write name="iterateid" property="closingbal"/></td>
				              
				             </tr>  
				           </logic:iterate>   
						</table>
		       
		       
		    </logic:present>
						
						
						
						<br/>
						 <span id="dashboard_goBack" class="decorator" onclick="leaveDetails()" style="margin-left:30%; ">Go to Leave Details</span>
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="col-md-4">
				<!-- Item -->
				<div class="ui-item">
					<!-- Collapse -->
					<div class="ui-collapse">
						<!-- Panel Title -->
						<div class="ui-title clearfix">
							<i class="fa fa-bars"></i> <a data-toggle="collapse"
								href="#collapseFour" class="ui-heading"> Personal Details </a> <a
								href="#" class="ui-close"><span></span></a> <a
								data-toggle="collapse" href="#collapseFour" class="ui-angle"><span></span></a>
							<a href="#" class="ui-referesh"><span></span></a>
						</div>
						<!-- Collapse Content -->
						<div id="collapseFour" class="panel-collapse collapse">
						<br/>
						<logic:present name="PersonalDetails" scope="request">

								<table cellpadding="5" cellspacing="2" id="biometric" width="100%" >
							<tr>
							<td class="left1">Employee Image</td>
								<td class="right1"><img src="<bean:write name="PersonalDetails" property="employeeImage" />" width="100px"
									height="100px" id="empImagePreview" /></td>
							
                            </tr>
                            <tr >

								<td  class="left1" >Contact Number</td>
								<td class="right1" ><bean:write name="PersonalDetails" property="mobilenumber" /></td>

                            </tr>
                     
                            
                             <tr >

								<td  class="left1" >Official MailId</td>
								<td class="right1" ><bean:write name="PersonalDetails" property="officialMailId" /></td>

                            </tr>
                            
                              
                             <tr >

								<td  class="left1" >Present Address</td>
								<td class="right1" ><bean:write name="PersonalDetails" property="presentaddress" /></td>

                            </tr>
                            
                             <tr >

								<td  class="left1" >Base Location</td>
								<td class="right1" ><bean:write name="PersonalDetails" property="baselocation" /></td>

                            </tr>
                            
                              <tr >

								<td  class="left1" >Department</td>
								<td class="right1" ><bean:write name="PersonalDetails" property="dept_name" /></td>

                            </tr>
                            
                              <tr >

								<td  class="left1" >Designation</td>
								<td class="right1" ><bean:write name="PersonalDetails" property="designation" /></td>

                            </tr>
                            
                             <tr >

								<td  class="left1" >Dob</td>
								<td class="right1" ><bean:write name="PersonalDetails" property="dob" /></td>

                            </tr>
                             <tr >

								<td  class="left1" >Doj</td>
								<td class="right1" ><bean:write name="PersonalDetails" property="doj" /></td>

                            </tr>
                            
                            <tr >

								<td  class="left1" >Emploee Type</td>
								<td class="right1" ><bean:write name="PersonalDetails" property="employee_type" /></td>

                            </tr>
                      	<input type="hidden" id="dashboard_goBack" value="<bean:write name="PersonalDetails" property="employee_id"/>"></input>
								</table>
								<br/>
								 <span id="dashboard_goBack" onclick="editEmployeeDetails()" style="left : 80%;">EDIT</span>
							</logic:present>
						</div>
					</div>
				</div>
			</div>
			
			
			
			<div class="col-md-4" style="width: 50%;">
				<!-- Item -->
				<div class="ui-item">
					<!-- Collapse -->
					<div class="ui-collapse">
						<!-- Panel Title -->
						<div class="ui-title clearfix">
							<i class="fa fa-bars"></i> <a data-toggle="collapse"
								href="#collapsethree" class="ui-heading">Claims</a>
							<a href="#" class="ui-close"><span></span></a> <a
								data-toggle="collapse" href="#collapsethree" class="ui-angle"><span></span></a>
							<a href="#" class="ui-referesh"><span></span></a>
						</div>
						<!-- Collapse Content -->
						<div id="collapsethree" class="panel-collapse collapse"><br/>
						
                        
                        <span class="rigth1"><b>Current Month Expense Details</b></span>
                        
                        
                     <center>   
                        <logic:present name="ExpensesDetails" scope="request">
					
					
					 <table class="view">
				              <tr>
                                 <th>Year</th>
                                 <th>Month</th>
                             
                                  <th>Claimed Amt</th>
                                   <th>Approved Amt</th>
                                   <th>Status</th>
				              </tr>
				            
				             <tr>
                              <td><bean:write name="ExpensesDetails" property="year"/>
                              <td><bean:write name="ExpensesDetails" property="month"/></td>
                              <td><bean:write name="ExpensesDetails" property="claimedamount"/></td>
                              <td><bean:write name="ExpensesDetails" property="approvedamount"/></td>
				              <td><bean:write name="ExpensesDetails" property="status"/></td>
				              
				             </tr>  
				              
						</table>
					
                        
				     	<br/>

						
						<table cellpadding="5" cellspacing="2" id="biometric" width="100%">
                        <tr>
                        
                        <td  class="left1" >Local Conveyance</td>
                 	 <td class="right1"><bean:write name="ExpensesDetails" property="localconveyance" /></td>
                        
                        </tr>
                           <tr >

								<td  class="left1" >Travel Expenses</td>
								<td class="right1" ><bean:write name="ExpensesDetails" property="travelexpenses" /></td>

                            </tr>
                             <tr >

								<td  class="left1" >Staff Welfare</td>
								<td class="right1" id="startdate"><bean:write name="ExpensesDetails" property="staffwelfare" /></td>

                            </tr>
                            
                            <tr >

								<td  class="left1" >Telephone Expenses</td>
								<td class="right1" id="enddate" ><bean:write name="ExpensesDetails" property="telephoneexp" /></td>

                            </tr>
                            
                                <tr >

								<td  class="left1" >Purchases</td>
								<td class="right1" id="enddate" ><bean:write name="ExpensesDetails" property="purchases" /></td>

                            </tr>
                            
                                <tr >

								<td  class="left1" >OtherWork Expenses</td>
								<td class="right1" id="enddate" ><bean:write name="ExpensesDetails" property="otherworkexp" /></td>

                            </tr>
                            
                                <tr >

								<td  class="left1" >Miscellaneous</td>
								<td class="right1" id="enddate" ><bean:write name="ExpensesDetails" property="mislanious" /></td>

                            </tr>
             
						</table><br/>
						
						</logic:present>
						 </center>
						
						<table width="100%">

							<tr>

								<td><span id="dashboard_goBack" onclick="claimesDetails()" >View more Details</span></td>

							</tr>

						</table>

					</div>
					</div>
				</div>
			</div>
			
			
			
		<div class="col-md-4">
				<!-- Item -->
				<div class="ui-item">
					<!-- Collapse -->
					<div class="ui-collapse">
						<!-- Panel Title -->
						<div class="ui-title clearfix">
							<i class="fa fa-bars"></i> <a data-toggle="collapse"
								href="#collapsefive" class="ui-heading">Advance Salary Details</a> <a
								href="#" class="ui-close"><span></span></a> <a
								data-toggle="collapse" href="#collapsefive" class="ui-angle"><span></span></a>
							<a href="#" class="ui-referesh"><span></span></a>
						</div>
						<!-- Collapse Content -->
						<div id="collapsefive" class="panel-collapse collapse">

						<logic:present name="ADVANCESALARYDETAILS" scope="request">
						<logic:notEmpty name="ADVANCESALARYDETAILS" scope="request">
				         <span class="rigth1"><b>Current Month Advance Salary Details</b></span>
				           <table class="view">
				              <tr><th>S.No</th>
				              <th>Year</th>
                                  <th>Month</th>
                                 <th>Project</th>
                                  <th>Claimed Amt</th>
                                  <th>Approved Amt</th>
                        <!--           <th>Status</th> -->
				              </tr>
				            <logic:iterate id="iterateid" name="ADVANCESALARYDETAILS" scope="request">
				             <tr>
                              <td><bean:write name="iterateid" property="sno"/>
                              <td><bean:write name="iterateid" property="year"/></td>
                              <td><bean:write name="iterateid" property="month"/></td>
                              <td><bean:write name="iterateid" property="project"/></td>
                              <td><bean:write name="iterateid" property="claimedAmount"/></td>
                              <td><bean:write name="iterateid" property="aprovedAmount"/></td>
				              <td><bean:write name="iterateid" property="status"/></td>
				              
				              
				              
				             </tr>  
				               </logic:iterate>
						</table>
				    <br/>
					
					 </logic:notEmpty>
					  <span id="dashboard_goBack" onclick="moreAdvanceSalaryDeatails()" style="left : 90%;">View More Details</span>
			 </logic:present>
							
						</div>
					</div>
				</div>
			</div>
			
			
			
           <div class="col-md-4">
				<!-- Item -->
				<div class="ui-item">
					<!-- Collapse -->
					<div class="ui-collapse">
						<!-- Panel Title -->
						<div class="ui-title clearfix">
							<i class="fa fa-bars"></i> <a data-toggle="collapse"
								href="#collapsesix" class="ui-heading">Travel Allowances </a> <a
								href="#" class="ui-close"><span></span></a> <a
								data-toggle="collapse" href="#collapsesix" class="ui-angle"><span></span></a>
							<a href="#" class="ui-referesh"><span></span></a>
						</div>
						<!-- Collapse Content -->
						<div id="collapsesix" class="panel-collapse collapse">

					<logic:present name="TravelDetails" scope="request">
						<logic:notEmpty name="TravelDetails" scope="request">
				         <span style="margin-left:26%;">(Current Month Travel Allowance Details)</span>
				           <table class="view">
				               <tr><th>S.No
                                 <th>Year</th>
                                 <th>Month</th>
                                  <th>Reporting Manager</th>
                                   <th>Claimed Amount</th>
                                   <th>Approved Amount</th>
				              </tr>
				            <logic:iterate id="iterateid" name="TravelDetails" scope="request">
				             <tr>
                              <td><bean:write name="iterateid" property="sno"/>
                              <td><bean:write name="iterateid" property="year"/></td>
                              <td><bean:write name="iterateid" property="month"/></td>
                              <td><bean:write name="iterateid" property="posted_by"/></td>
                              <td><bean:write name="iterateid" property="amount"/></td>
				              <td><bean:write name="iterateid" property="approvedamount"/></td>
				              
				             </tr>   
				             
				               </logic:iterate>
				               
						</table>
				    <br/>
					 <span id="dashboard_goBack" onclick="moreTravelAllowanceDeatails()" style="left : 90%;">View More Details</span>
					 </logic:notEmpty>
					 <logic:empty name="TravelDetails" scope="request">
					  <span>Nothing found to display</span>
					 </logic:empty>
			 </logic:present>
							
						</div>
					</div>
				</div>
			</div>
			

			<div class="col-md-4" style="width: 100%;">
				<!-- Item -->
				<div class="ui-item">
					<!-- Collapse -->
					<div class="ui-collapse">
						<!-- Panel Title -->
						<div class="ui-title clearfix">
							<i class="fa fa-bars"></i> <a data-toggle="collapse"
								href="#collapseTen" class="ui-heading">Resume </a>
							<a href="#" class="ui-close"><span></span></a> <a
								data-toggle="collapse" href="#collapseTen" class="ui-angle"><span></span></a>
							<a href="#" class="ui-referesh"><span></span></a>
						</div>
						<!-- Collapse Content -->
								<div id="collapseTen" class="panel-collapse collapse">
							
							
							&nbsp;&nbsp;
							
					 <logic:present name="EmployeeDetails" scope="request">
	<logic:iterate id="EmpDetails" name="EmployeeDetails">
	<table>
				<tr><td style=""><bean:write name="EmpDetails" property="employeeName"/></td></tr>
				
				<tr><td style=""><bean:write name="EmpDetails" property="presentAddress"/></td></tr>
				
				</table>
	</logic:iterate></logic:present>		
							
							
							
							
							
							<fieldset>
 <legend align="left" style="font-size: 12px;font-weight: bold;">Career Objective</legend>
 <logic:present name="CareerObjective" scope="request">
					<logic:iterate id="careerObjectiveDetails" name="CareerObjective">
			<input type="hidden" id="employeeCodeId" value="<bean:write name="careerObjectiveDetails" property="employeeId"/>"/>		
					
 <bean:write name="careerObjectiveDetails" property="carrerObjective" /> 
 
 
 
 </logic:iterate></logic:present>
 
  </fieldset> 
  
   <fieldset>
				<legend align="left" style="font-size: 12px;font-weight: bold;">Pursuit</legend>
				<logic:present name="PursuitsList" scope="request">
			<logic:iterate id="pursuitList" name="PursuitsList">
					<bean:write name="pursuitList" property="pursuitSno"/>
				
				
				<bean:write name="pursuitList" property="pursuits"/><br/>
				
				</logic:iterate></logic:present>
				</fieldset>
  
						<fieldset>
			 <legend align="left" style="font-size: 12px;font-weight: bold;">Hobbies/Sports</legend>
			 
		
									
							<logic:present name="Hobbies" scope="request">
					<logic:iterate id="hobbiesDetails" name="Hobbies" >
					<bean:write name="hobbiesDetails" property="hobbiesSno"/>
					
					
					
					<bean:write name="hobbiesDetails" property="hobbies"/><br/>
					</logic:iterate></logic:present>		
										 </fieldset>
										 
										 
							
						
						
						
						
						
					 <logic:present name="EmployeeDetails" scope="request">
	<logic:iterate id="EmpDetails" name="EmployeeDetails" >
			 <fieldset>
			 <legend align="left" style="font-size: 12px;font-weight: bold;">Education Details</legend>
			 
			 
								
								<table cellpadding="5" cellspacing="2" id="biometric" width="100%" >
							
							
							<tr>
						<td  class="left1" style="font-size: 12px;" >Qualification</td>
								<td class="right1" ><bean:write name="EmpDetails" property="majorQualification"/></td>

                            </tr>	
						<tr>
						<td  class="left1" style="font-size: 12px;">University Board</td>
								<td class="right1" ><bean:write name="EmpDetails" property="university"/></td>

                            </tr>	
						
						<tr>
						<td  class="left1" style="font-size: 12px;" >College/Institute</td>
								<td class="right1" ><bean:write name="EmpDetails" property="collageInStitute"/></td>

                            </tr>	
						
						
						</table></fieldset></logic:iterate></logic:present>
						
						
					<fieldset>	
						
			 <legend align="left" style="font-size: 12px;font-weight: bold;">Technical Skills</legend>			 
							<logic:present name="TechnicalSkills" scope="request">
					<logic:iterate id="technicalSkillsDetails" name="TechnicalSkills" >	
					<bean:write name="technicalSkillsDetails" property="technicalSkillsSno"/>
				 			 	<bean:write name="technicalSkillsDetails" property="technicalSkills"/><br/>
									</logic:iterate></logic:present>
								</fieldset>
								
								
								<fieldset>
			 <legend align="left" style="font-size: 12px;font-weight: bold;">Responsibilities</legend>
			 <logic:present name="Responsibilities" scope="request">
					<logic:iterate id="ResDetails" name="Responsibilities" >
					
			<bean:write name="ResDetails" property="responsibilitiesSno"/>
			 <bean:write name="ResDetails" property="responsibilities"/><br/>
			 </logic:iterate></logic:present>
			 </fieldset>
			 
			 
			 <fieldset>
			 <legend align="left" style="font-size: 12px;font-weight: bold;">Experience</legend>
			 <logic:present name="Experience" scope="request">
					<logic:iterate id="ExpDetails" name="Experience" >
					
			<bean:write name="ExpDetails" property="experienceSno"/>
			 <bean:write name="ExpDetails" property="experience"/><br/>
			 </logic:iterate></logic:present>
			 </fieldset>
			 
			 
			 
			 
			 
			 
			 <logic:present name="EmployeeDetails" scope="request">
	<logic:iterate id="EmpDetails" name="EmployeeDetails" >
			 <fieldset>
			 <legend align="left" style="font-size: 12px;font-weight: bold;">Personal Details</legend>
			 
			 
								
								<table cellpadding="5" cellspacing="2" id="biometric" width="100%" >
							
							
							<tr>
						<td  class="left1" >Date of Birth</td>
								<td class="right1" ><bean:write name="EmpDetails" property="dob"/></td>

                            </tr>
							<tr>
						<td  class="left1" >Contact Number</td>
								<td class="right1" ><bean:write name="EmpDetails" property="phoneNo"/></td>

                            </tr>
						
								<tr>
						<td  class="left1" >Marital Status</td>
								<td class="right1" ><bean:write name="EmpDetails" property="martialStatus"/></td>

                            </tr>
						
						
						<tr>
						<td  class="left1" >Gender</td>
								<td class="right1" ><bean:write name="EmpDetails" property="gender"/></td>

                            </tr>
						</table>
							
				</fieldset>
				<table>
				<tr><td style="font-weight:bold;">Date:</td></tr>
				
				<tr><td style="font-weight:bold;">Place:<bean:write name="EmpDetails" property="baseLocation"/></td><td align="right" style="width: 91%;">
				
				
				<bean:write name="EmpDetails" property="employeeName"/>
				
				</td></tr>
				</table>
			
				
				
			</logic:iterate>
							
							</logic:present>
							<br>
							
							<table align="right"><tr><td>
							
				<input type="button" class="submitbutton" id="pdfDownloadBtn" value="Pdf"/>
				</td>
				<td>	<input type="button" class="submitbutton" id="wordDownloadBtn" value="Word"/></td>
				</tr>
				</table>
						</div>
					</div>
				</div>
			</div>
			
			


		</div>
	</div>

	<!-- <span id="goBack" onclick="goBack()">Go back</span>
	UI - X Ends

	<script type="text/javascript">
		function goBack() {
			window.location.href = "adminMenu.html?method=allTeacherDetails";
		} -->
	</script>
</body>
</html>