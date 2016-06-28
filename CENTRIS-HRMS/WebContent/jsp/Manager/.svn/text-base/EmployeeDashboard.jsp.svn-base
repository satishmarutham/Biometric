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
<script type="text/javascript" src="js/Manager/EmployeeDashboard.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
</head>
</head>
<br/>
<br/>
<br/>
<!-- UI - X Starts -->
	<div class="ui-x">
		<div class="container">
			<h4 class="welcome-message">
				Employee --
				<logic:present name="EmployeeName" scope="request">
					<bean:write name="EmployeeName" scope="request" />
				</logic:present>
				Details
			</h4>
			<logic:present name="empId" scope="request"><input type="hidden" id="hempId" value='<bean:write name="empId"   scope="request"/>'/></logic:present>
			
			
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
                            
                            
                         
                            

						</table>
								
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
								href="#collapseOne" class="ui-heading">Attendance Details </a> <a
								href="#" class="ui-close"><span></span></a> <a
								data-toggle="collapse" href="#collapseOne" class="ui-angle"><span></span></a>
							<a href="#" class="ui-referesh"><span></span></a>
						</div>
						<!-- Collapse Content -->
						<div id="collapseOne" class="panel-collapse collapse"><br/>
						
						
						  <table cellpadding="5" cellspacing="2" id="biometric" width="100%">
                        <tr>
                        
                        <td  class="left1" >Last Approved Date&Time </td>
                 	 <td class="right1"><bean:write name="NotAprrovedAttendance" property="lastupdateddate" /></td>
                        
                        </tr>
                           <tr >

								<td  class="left1" >Last Posted Date&Time</td>
								<td class="right1" ><bean:write name="NotAprrovedAttendance" property="lastposteddate" /></td>

                            </tr>
                             <tr >

								<td  class="left1" >Start Date</td>
								<td class="right1" id="startdate"><bean:write name="NotAprrovedAttendance" property="startdate" /></td>

                            </tr>
                            
                            <tr >

								<td  class="left1" > End Date</td>
								<td class="right1" id="enddate" ><bean:write name="NotAprrovedAttendance" property="endadate" /></td>

                            </tr>
             
						</table><br/>
						
                        
                        <span class="rigth1"><b>Current Month Attendance Details</b></span>
                        
                        
                     <center>   
                        <logic:present name="AttendanceDetails" scope="request">
					
						<display:table  name="requestScope.AttendanceDetails" class="view" pagesize="10">
							
							<display:column property="totaldaysinmonth" title="TotalDays" />
							<display:column property="totalworkingdays" title="Working Days" />
							<display:column property="totalpresents" title="Presents" />
							<display:column property="totalabsents" title="Absents" />
							<display:column property="totalleaves" title="Leaves" />
							<display:column property="totalholidays" title="Holidays" />
							
						</display:table>
					</logic:present>
					
                        
				     	 </center>		<br/>

						<table width="100%">

							<tr>

								<td><span id="dashboard_goBack" onclick="notApprovedAttendance()" style="margin-left: 2% !important">Approve pending Attendance</span></td>

								<!-- <td><span id="dashboard_goBack" onclick="leaveDetails()" style="margin-left: 10% !important">View More</span></td> -->

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
								href="#collapseThree" class="ui-heading">Leave Approval Pending
							</a> <a href="#" class="ui-close"><span></span></a> <a
								data-toggle="collapse" href="#collapseThree" class="ui-angle"><span></span></a>
							<a href="#" class="ui-referesh"><span></span></a>
						</div>
						<!-- Collapse Content -->
						<div id="collapseThree" class="panel-collapse collapse">
							<logic:present name="LeaveDeatils" scope="request">
								<display:table class="view" name="requestScope.LeaveDeatils"
									requestURI="/employeeDashboard.do?method=employeeDashboardHome"
									export="false" pagesize="10">
									<display:column property="sno" title="S.No" />
									<display:column property="noof_leaves" title="No Of Leaves" />
									<display:column property="requested_date" title="Requested Date" />
									<display:column property="reasonfor_leave" title="Reason For Leave" />
								</display:table>
								<br/>
                     <span id="dashboard_goBack" onclick="leaveDetails()" style="left : 80%;">View More</span>
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
								href="#collapseTwo" class="ui-heading"> Allowances </a> <a
								href="#" class="ui-close"><span></span></a> <a
								data-toggle="collapse" href="#collapseTwo" class="ui-angle"><span></span></a>
							<a href="#" class="ui-referesh"><span></span></a>
						</div>
						<!-- Collapse Content -->
						<div id="collapseTwo" class="panel-collapse collapse">

								<logic:present name="DailyAllowances" scope="request">
						<logic:notEmpty name="DailyAllowances" scope="request">
				     <span class="rigth1"><b>Current Month Allowance Details</b></span>
				           <table class="view">
				              <tr><th>S.No
                                 <th>Allowance Date</th>
                                 <th>Project</th>
                                  <th>Posted By</th>
                                   <th>Amount</th>
                                   <th>Status</th>
				              </tr>
				            <logic:iterate id="iterateid" name="DailyAllowances" scope="request">
				             <tr>
                              <td><bean:write name="iterateid" property="sno"/>
                              <td><bean:write name="iterateid" property="allowancedate"/></td>
                              <td><bean:write name="iterateid" property="project"/></td>
                              <td><bean:write name="iterateid" property="postedby"/></td>
                              <td><bean:write name="iterateid" property="amount"/></td>
				              <td><bean:write name="iterateid" property="status"/></td>
				              
				             </tr>  
				               </logic:iterate>
						</table>
				    <br/>
					 <span id="dashboard_goBack" onclick="moreAllowanceDeatails('<logic:present name="employeeId" scope="request"><bean:write name="employeeId" scope="request"></bean:write></logic:present>')" style="left : 90%;">View More Details</span>
					 </logic:notEmpty>
					 <logic:empty name="DailyAllowances" scope="request">
					 <span>Nothing found to display</span>
					 </logic:empty>
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
								href="#collapseTen" class="ui-heading">Claims</a>
							<a href="#" class="ui-close"><span></span></a> <a
								data-toggle="collapse" href="#collapseTen" class="ui-angle"><span></span></a>
							<a href="#" class="ui-referesh"><span></span></a>
						</div>
						<!-- Collapse Content -->
						<div id="collapseTen" class="panel-collapse collapse"><br/>
						
                        
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

								<td><span id="dashboard_goBack" onclick="claimesDetails('<logic:present name="employeeId" scope="request"><bean:write name="employeeId" scope="request"></bean:write></logic:present>')" >View more Details</span></td>

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
                                  <th>Status</th>
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
					  <span id="dashboard_goBack" onclick="moreAdvanceSalaryDeatails('<logic:present name="empId" scope="request"><bean:write name="empId" scope="request"></bean:write></logic:present>')" style="left : 90%;">View More Details</span>
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
                                  <th>Travel Date</th>
                                 <th>Project</th>
                                  <th>Posted By</th>
                                   <th>Amount</th>
                                   <th>Status</th>
				              </tr>
				            <logic:iterate id="iterateid" name="TravelDetails" scope="request">
				             <tr>
                              <td><bean:write name="iterateid" property="sno"/>
                             <td><bean:write name="iterateid" property="travelling_date"/></td>
                              <td><bean:write name="iterateid" property="project"/></td>
                              <td><bean:write name="iterateid" property="posted_by"/></td>
                              <td><bean:write name="iterateid" property="amount"/></td>
				              <td><bean:write name="iterateid" property="status"/></td>
				              
				             </tr>  
				               </logic:iterate>
						</table>
				    <br/>
					 <span id="dashboard_goBack" onclick="moreTravelAllowanceDeatails('<logic:present name="empId" scope="request"><bean:write name="empId" scope="request"></bean:write></logic:present>')" style="left : 90%;">View More Details</span>
					 </logic:notEmpty>
					 <logic:empty name="TravelDetails" scope="request">
					  <span>Nothing found to display</span>
					 </logic:empty>
			 </logic:present>
							
						</div>
					</div>
				</div>
			</div>
			
			


		</div>
	</div>
	
	
		<table width="100%">

							<tr>

								<td><span id="dashboard_goBack" onclick="goBack()"  style="margin-left: 80%">Go Back</span></td>

							</tr>

			</table>

	<!-- <span id="goBack" onclick="goBack()">Go back</span>
	UI - X Ends

	<script type="text/javascript">
		function goBack() {
			window.location.href = "adminMenu.html?method=allTeacherDetails";
		} -->
	</script>
</body>
</html>