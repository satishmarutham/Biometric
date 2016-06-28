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

<title>Insert title here</title>
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
<script type="text/javascript" src="js/Admin/ApproveTravelBooking.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/login/style.css">
<link rel="stylesheet" href="css/login/common.css">

</head>
<body>

<div id="loader" style="position: absolute;top:350px;left:650px;display: none;"><img  src="images/loaderimage2.GIF"/></div>

<div id="main" class="background">

		<center>

			<div class="backgroundDiv" id="backgroung">Travel Booking Details</div>
	
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
												
		<form name="travelbookingApprove" id="travelbookingApprove" action="approveTravelBooked.do">
			<input type="hidden" id="getTktBookingDetailsAction" value="getTktBookingDetailsAction" name="method"  />
			
			<input type="hidden" id="htodate" value="<logic:present name="todate"><bean:write name="todate"  /> </logic:present>"/>
			<input type="hidden" id="hfromdate" value="<logic:present name="fromdate"><bean:write name="fromdate"  /></logic:present>"/>
			
		
				<table cellpadding="5" cellspacing="2" id="biometric" width="60%">
		
					<tr>
						<td class="left">Start Date <font color="red">*</font></td>
						<td class="right" ><input type="text" style="text-align: center;" name="todate" id="todate"  readonly="readonly" placeholder="Click here" 
						value="" /></td>
						<td class="left">End Date <font color="red">*</font></td>
						<td class="right"><input type="text" name="fromdate" id="fromdate" style="text-align: center;" readonly="readonly" placeholder="Click here"
						value="" /></td>
					
						
					</tr>	
					<tr>
					
					</tr>
			</table>
			<br/>
			
				
			<center>
							<table>
								<tr class="odd">

									<td colspan="3"><center>
											<input type="submit" class="submitbutton" value="Get Allowances"
												class="button1" id="register" onclick="return validate()" /> 
										</center></td>

								</tr>

							</table>
				</center>
				
				
				</form>
				
				
				
				
				<logic:present name="ApproveTktBookingMap" scope="request">
				<logic:notEmpty name="ApproveTktBookingMap">
				
				<input type="hidden" id="normalTktPresnt" value="Y"/>
				
								<logic:iterate id="calMap" name="ApproveTktBookingMap"
									scope="request">
									<h3 class="accordHead" id="accordian" style="width: 100%">
										
										<bean:write name="calMap" property="key" />
									</h3>

									<div class="accBody" style="display: none;">
										<table class="view" id="approveRecords">
											<tr>
												<th>Sno</th>
												<th>Travel Booked BY</th>
												<th>Who is on Travel</th>
												<th>Mode of Travel</th>
												<th>Travel From</th>
												<th>Travel To</th>
												<th>Booking Date</th>
												<th>Amount</th>
												<th>Director Approved Amount</th>
												<th>Director Remarks</th>
												<th>Approved Amount</th>
												<th>Approve Status</th>
												<th>Reject Status</th>
												<th>View</th>
											</tr>
											<logic:iterate name="calMap" property="value" id="dateVO">
												<tr class="accordHead">
												<input type="hidden" class="hbookingId" value="<bean:write name="dateVO" property="tkt_book_code" />"/>
													<td><bean:write name="dateVO" property="sno" /></td>
													<td><bean:write name="dateVO" property="booked_by_empname" /></td>
													<td><bean:write name="dateVO" property="who_on_travel_empname" /></td>
													<td><bean:write name="dateVO" property="travel_mode" /></td>
													<td><bean:write name="dateVO" property="travel_from" /></td>
													<td><bean:write name="dateVO" property="travel_to" /></td>
													<td><bean:write name="dateVO" property="booked_date" /></td>
													<td><bean:write name="dateVO" property="amount" /></td>
													<td><bean:write name="dateVO" property="approveAmount" /></td>
													
													<td>
													<textarea rows="3" cols="25" class="adminComments"><bean:write name="dateVO" property="diretorremarks" />
													</textarea>
													</td>
													
													<td><input type="text"  value="<bean:write name="dateVO" property="approveAmount" />" class="approvedamount" /></td>
													
													
													<td><input type="button" value="<bean:write name="dateVO" property="status" />"
													 id="Approve_<bean:write name="dateVO" property="tkt_book_code"/>" class="approveAllowance"></td>
													 
													 <td><input type="button" value="<bean:write name="dateVO" property="isRejectedStatus" />"
													 id="Reject_<bean:write name="dateVO" property="tkt_book_code"/>" class="rejectAllowance"></td>
													 
													<td><input type="button" value="View" id="<bean:write name="dateVO" property="tkt_book_code"  />" class="viewDeatails"></td>
												
												
												</tr>
												
											</logic:iterate>
										</table>
									</div>
								</logic:iterate><br/>
					<input type="button" value="Download Travel Booking Details"  id="downloadBookingDetails"  class="submitbutton"/>
					
					</logic:notEmpty>
					</logic:present>
					
					
					<logic:present name="conflictEmployees">
					<logic:notEmpty name="conflictEmployees">
					
					<input type="hidden" id="conflictTktPresnt" value="Y"/>
					
									<div >
										<table class="view" id="approveRecords">
										
										<tr>
										
										 <td colspan="14" class="head11"  style="background-color: #E6E6E6">	<span class="head11"   style="background-color: #E6E6E6"><b>Conflict Employees</b> </span> </td>
										
										</tr>
										
											<tr>
												<th>Sno</th>
												<th>Travel Booked BY</th>
												<th>Who is on Travel</th>
												<th>Mode of Travel</th>
												<th>Travel From</th>
												<th>Travel To</th>
												<th>Booking Date</th>
												<th>Amount</th>
												<th>Director Approved Amount</th>
												<th>Remarks</th>
												<th>Approved Amount</th>
												<th>Approve Status</th>
												<th>Reject Status</th>
												<th>View</th>
											</tr>
											<logic:iterate name="conflictEmployees"  id="employees">
												<tr class="accordHead">
												
												<input type="hidden" class="hbookingId" value="<bean:write name="employees" property="tkt_book_code" />"/>
													<td><bean:write name="employees" property="sno" /></td>
													<td><bean:write name="employees" property="booked_by_empname" /></td>
													<td><bean:write name="employees" property="who_on_travel_empname" /></td>
													<td><bean:write name="employees" property="travel_mode" /></td>
													<td><bean:write name="employees" property="travel_from" /></td>
													<td><bean:write name="employees" property="travel_to" /></td>
													<td><bean:write name="employees" property="booked_date" /></td>
													<td><bean:write name="employees" property="amount" /></td>
													<td><bean:write name="dateVO" property="approveAmount" /></td>
													
													<td>
													<textarea rows="3" cols="25" class="adminComments"><bean:write name="employees" property="diretorremarks" />
													</textarea>
													</td>
													
													<td><input type="text"  value="<bean:write name="employees" property="approveAmount" />" class="approvedamount" /></td>
													
													<td><input type="button" value="<bean:write name="employees" property="status" />"
													 id="Approve_<bean:write name="employees" property="tkt_book_code"/>" class="approveAllowance"></td>
													 
													 <td><input type="button" value="<bean:write name="employees" property="isRejectedStatus" />"
													 id="Reject_<bean:write name="employees" property="tkt_book_code"/>" class="rejectAllowance"></td>
													 
													<td><input type="button" value="View" id="<bean:write name="employees" property="tkt_book_code"  />" class="viewDeatails"></td>
												
												
												</tr>
												
											</logic:iterate>
										</table>
									</div><br/>
									
										
					<input type="button" value="Download Conflict TravelBooking Details"  id="downloadConflictBookingDetails"  class="submitbutton"/>
			
									
									</logic:notEmpty>
							</logic:present>
							
			<input type="button" value="Approve All Booking Details"  id="approveAll"  class="submitbutton conflict"/>
						
					
					<div id="view-dialog" title="Employee Allowance Details" style="display: none; font-size: 10px;background-color: #F2F0E7" align="center"><br/>
						<table cellpadding="5" cellspacing="0" id="biometric" width="100%" class="dialogclass">
							
							<tr>
							
							
							<td class="leftindialog" >Posted By</td>
								<td class="rightindialog"  id="postedby">
									
								</td>

								<td class="leftindialog" >Posted Date</td>
								<td class="rightindialog"  id="posteddate">
									
								</td>

							

                            </tr><tr></tr>
                            
                            <tr>
                            
                            	<td class="leftindialog" >Debit/Credit Card Used</td>
								<td class="rightindialog"  id="debicreditcard" >
								
								</td>
								<td class="leftindialog">Project</td>
								<td class="rightindialog" id="project" >
								</td>


							
								
							</tr><tr></tr>
							
							 <tr>
							  <td class="leftindialog">ProjectRefCode</td>
								<td class="rightindialog" id="projectrefcode" >
								</td>
							 	<td class="leftindialog">Travelling Date</td>
								<td class="rightindialog" id="travellingdate"></td>
								


								
							
							</tr><tr></tr>
							
							  <tr>
							  
								<td class="leftindialog">Approved By</td>
								<td class="rightindialog" id="approvedby" ></td>
								<td class="leftindialog">Approved Date</td>
								<td class="rightindialog" id="approveddate"></td>

							</tr>
							<tr>
							
							<td class="leftindialog">Posted By Remarks</td>
								<td  class="rightindialog" id="postedbyremarks" style="height: 50px"></td>
							
							<td class="leftindialog">Director Remarks</td>
								<td  class="rightindialog" id="directorremarks" style="height: 50px"></td>
							
							</tr>
							
							<!--  <tr>
							  
								<td style="background-color: #D9D9D9" height="50px !important">M Remarks</td>
								<td colspan="3" style="background-color: #FFF" height="50px !important" id="managerremarks" ></td>
							

							</tr> -->

						</table>
						
						</div>
						
				
				
				

			
		</center>
</div>
			
								

</body>
</html>