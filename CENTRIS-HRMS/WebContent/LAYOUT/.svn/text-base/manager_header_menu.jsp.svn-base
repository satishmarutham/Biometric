<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<link type="text/css" href="css/Menu/redfin_menu.css" rel="stylesheet" />
<link type="text/css" href="css/Menu/redfin_menu.css" rel="stylesheet" />
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
</head>
<body>
	<div class="mains">
		<ul class="menu">
			<li><html:link page="/managerMenu.do?parameter=home"
					style="text-decoration:none">
					<span><img src="images/home.png" height="22" width="22" />Home</span>
				</html:link></li>


             <li class="parent"><a><span><img
						src="images/help.png" height="22" width="22" />Masters</span></a>

				<ul>
					<li><html:link
							page="/GetDetails.do?parameter=projectCreationByManager"
							style="text-decoration:none">
							<span>Project Master</span>
						</html:link>
						
						
						<li><html:link
							page="/managerMenu.do?parameter=getAllEmployeesResume"
							style="text-decoration:none">
							<span>Employee Resume</span>
						</html:link>
				<%-- 		
						<li><html:link
							page="/travelBooked.do?method=travelBookedDetailsHome"
							style="text-decoration:none">
							<span>Travel Booked Details</span>
						</html:link> --%>
				</ul>
				
				</li>

          <%--   <li class="parent"><a><span><img
						src="images/help.png" height="22" width="22" />View Details</span></a>

				<ul>
					<li><html:link
							page="/employeeDashboard.do?method=getAllEmployeesUnderManager"
							style="text-decoration:none">
							<span>Employee Details</span>
						</html:link>
					
				</ul></li> --%>

			<li class="parent"><a><span><img
						src="images/help.png" height="22" width="22" />Approval</span></a>

				<ul>
				<%-- 	<li><html:link
							page="/GetDetails.do?parameter=getAttendanceApproval"
							style="text-decoration:none">
							<span>Attendance By Month</span>
						</html:link></li> --%>
					<li><html:link
							page="/GetDetails.do?parameter=getAttendanceApprovalByDate"
							style="text-decoration:none">
							<span>Attendance By Date</span>
						</html:link></li>
					<li><html:link
							page="/managerMenu.do?parameter=getLeaveRequestForApproved"
							style="text-decoration:none">
							<span>Leave Approval </span>
						</html:link></li>
					<li><html:link
							page="/managerMenu.do?parameter=getExpenseConsolidatedDetail"
							style="text-decoration:none">
							<span>Expense Approval </span>
						</html:link></li>
				</ul></li>

			<li class="parent"><html:link
					page="/managerMenu.do?parameter=getAttendanceNotApprovedByManager"
					style="text-decoration:none">
					<span><img src="images/help.png" height="22" width="22" />Attendance
						Not Approved</span>
				</html:link></li>

				<li class="parent"><a><span><img
						src="images/help.png" height="22" width="22" />Allowances</span></a>
			      
			        <ul>
			          <%--    <html:link	page="/managerMenu.do?parameter=uploadEmployeeDailyAllowance" 
			                    style="text-decoration:none">
			                  	<span>Upload Employee Daily Allowances</span>
			                 	</html:link> --%>
			              
			                <html:link	page="/employeeAllowances.do?method=employeeDailyAllowanceHome" 
			                    style="text-decoration:none">
			                  	<span>Employee  Allowances</span>
			                 	</html:link>
			                <html:link	page="/travelBooked.do?method=travelBookedDetailsHome" 
			                    style="text-decoration:none">
			                  	<span>Travel  Allowances</span>
			                 	</html:link>
			       </ul></li>


			<%-- 		
				<li class="parent"><a href="#"><span><img
						src="images/help.png" height="22" width="22" />Contact us</span></a>

				<ul>
					<li><html:link
							page="/GetDetails.do?parameter=sendMailToCustomerSupport"
							style="text-decoration:none">
							<span>Send Mail</span>
						</html:link></li>
				</ul></li> --%>


	         <li class="parent"><html:link
					page="/managerMenu.do?parameter=advanceSalaryRequest"
					style="text-decoration:none">
					<span><img src="images/help.png" height="22" width="22" />Advance Salary Request
						</span>
				</html:link></li>

			<li class="parent"><html:link
					page="/managerMenu.do?parameter=changePassword"
					style="text-decoration:none">
					<span><img src="images/help.png" height="22" width="22" />Change
						Password</span>
				</html:link></li>

	       <li class="parent"><a href="http://www.centrisinfotech.com/"><span><img
					src="images/help.png" height="22" width="22" />Contact us</span></a>

			  <ul>
				 <li><html:link
						page="/GetDetails.do?parameter=sendMailToCustomerSupport"
						style="text-decoration:none">
						<span>Send Mail</span>
					</html:link></li>
			</ul></li>

		</ul>





	</div>

</body>
</html>