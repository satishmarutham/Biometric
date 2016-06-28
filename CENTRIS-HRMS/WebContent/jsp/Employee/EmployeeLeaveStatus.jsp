 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Department Master</title>

<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="js/Employee/EmployeeLeaveStatus.js"></script>
<link rel="stylesheet" href="css/weekoff.css">
<link rel="stylesheet" href="JQUERY/css/jquery.ui.all.css" />
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>

</head>


<body>
	<br>
	<div align="center" id="main">
			<div class="background" id="backgroung">
				<div class="backgroundDiv" id="backgroung">Leave Status</div>
				<br /> <span
					style="padding-left: 80%; text-decoration: underline; cursor: pointer;font-size:12px; "
					id="getLeaveRequestDetails">Apply Leave Request</span>
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
						
						<logic:present name="fileNotFound" scope="request">
							<span style="color: red; font-family: Segoe UI;"> <bean:write
									name="fileNotFound" />
							</span>
						
						</logic:present>
						
						
						
						
							</div>
						</center>
			
		
					<logic:present name="employeeLeaveStatusPojos" scope="request">
						<display:table id="LEAVE" 
							name="requestScope.employeeLeaveStatusPojos"
							class="view" style="width:80%;"
							requestURI="/employeeMenu.do?parameter=employeeLeaveStatus"
							pagesize="10"
							decorator="com.centris.decorator.EmployeeLeaveStatusDecorator">
							 <%-- <display:column property="sno" title="S.No" />  --%>
							<display:column property="noofLeaves" title="No Of Leaves" />
							<display:column property="reasonforLeave"
								title="Reason For Leave" />
							<display:column property="startDate" title="Start Date" />
							<display:column property="endDate" title="End Date" />
						    <display:column property="leavetype" title="Leave Type" />						
							<display:column property="requestedDate" title="Requested Date" />
							<display:column property="approvedStatus" title="LeaveStatus" />
							<display:column property="viewButton" title="View" />
						</display:table>
					</logic:present>
            <br/>  <br/>
			</div>
		
	</div>
	<div id="LeaveConfirm" style="align: center;background-color: #F2F0E7;" title="Leave Status">
		<br>
		<center>
			<table id="biometric" cellpadding="7" cellspacing="0" class="dialogclass">
				<tr>
					<td class="leftindialog">Requested To</td>
					<td class="rightindialog"><input type="text" name="requestedBy" id="requestedby" readonly="readonly" /></td>
					<td class="leftindialog">Start Date</td>
					<td class="rightindialog"><input	type="text" name="startDate" id="startdate" readonly="readonly"  /></td>
           
                </tr><tr>
					<td class="leftindialog">End Date</td>
					<td class="rightindialog"><input type="text" name="endDate" id="enddate" readonly="readonly"  /></td>
			        <td class="leftindialog">No Of leaves</td>
			        <td class="rightindialog"><input type="text" name="noofLeaves" class="noofleavesId" readonly="readonly"  /></td>
			
				</tr><tr>
					<td class="leftindialog">Requested Date</td>
					<td class="rightindialog"><input type="text" name="requestedDate" id="requesteddate" readonly="readonly"  /></td>
					<td class="leftindialog">Reason For Leave</td>
					<td class="rightindialog"><textarea	class="Textarea" rows="2" cols="25" resize="none"
							id="reasonforleave" readonly="readonly"	></textarea></td>
				</tr><tr>
					<td  class="leftindialog">Total Leaves Approved</td>
					<td class="rightindialog"><input	type="text" name="totalleavesApproved" id="totalleavesapproved"
						                   readonly="readonly" /></td>
					<td  class="leftindialog">Approved Start Date</td>
					<td class="rightindialog"><input type="text" name="approvedStartDate" id="approvedstartdate"
					                        readonly="readonly" /></td>
				</tr><tr>	                        
					<td  class="leftindialog">Approved End Date</td>
					<td class="rightindialog"><input type="text" name="approvedEndDate" id="approvedenddate" 
						                          readonly="readonly" /></td>
	                <td class="leftindialog">Comments</td>
	                 <td class="rightindialog"><textarea	class="Textarea" rows="2" cols="25" resize="none" id="comments"
							readonly="readonly"></textarea></td>
				</tr>

				
			</table>

		</center>
		<br>
		<center>
			<table id="validateTable">
				<tr>
					<td colspan="3">
						<div class="alert-box error">
							<span style="color: red; font-size: 13px;" class="validateTips"></span>

						</div>
					</td>
				</tr>
			</table>
		</center>
	</div>

	
	
	<div id="LeaveConfirmNotApproved" style="align: center;background-color: #F2F0E7;" title="Leave Status">
	
	<div id="loading" style="position: absolute;top:16px;left:270px;display: none;"><img  src="images/loaderimage2.GIF"/></div>
		<br><br><br><br>
		<form id="modalform"  method="post" enctype="multipart/form-data">
		<center>
		<div id="errordivUpdate" class="error-box" align="center">
<span style="color: red; font-family: Segoe UI;"></span>
						
					</div>
		
<!-- 			<table id="biometric" cellpadding="7" cellspacing="0" class="dialogclass">
				<tr>
					<td class="leftindialog">Request To</td>
					<td class="rightindialog"><input type="text" name="requestedBy" id="requestedbyNotApproved"/></td>
					<td class="leftindialog">Start Date</td>
					<td class="rightindialog"><input	type="text" name="startDate" id="startdateNotApproved"/></td>
           
                </tr><tr>
					<td class="leftindialog">End Date</td>
					<td class="rightindialog"><input type="text" name="endDate" id="enddateNotApproved" /></td>
			        <td class="leftindialog">No of Leaves</td>
			        <td class="rightindialog"><input type="text" name="noofLeaves" class="noofleavesIdNotApproved" /></td>
			
				</tr><tr>
					<td class="leftindialog">Requested Date</td>
					<td class="rightindialog"><input type="text" name="requestedDate" id="requesteddateNotApproved"/></td>
					<td class="leftindialog">Reason For Leave</td>
					<td class="rightindialog"><textarea	class="Textarea" rows="2" cols="25" resize="none"
							id="reasonforleave" ></textarea></td>
				</tr><tr>
					<td  class="leftindialog">Total Leaves Approved</td>
					<td class="rightindialog"><input	type="text" name="totalleavesApproved" id="totalleavesapprovedNotApproved"
						                   /></td>
					<td  class="leftindialog">Approved Start Date</td>
					<td class="rightindialog"><input type="text" name="approvedStartDate" id="approvedstartdateNotApproved"
					                        /></td>
				</tr><tr>	                        
					<td  class="leftindialog">Approved End Date</td>
					<td class="rightindialog"><input type="text" name="approvedEndDate" id="approvedenddateNotApproved" 
						                         /></td>
	                <td class="leftindialog">Comments</td>
	                 <td class="rightindialog"><textarea	class="Textarea" rows="2" cols="25" resize="none" id="commentsNotApproved"
							></textarea></td>
				</tr>

				
			</table> -->
			
					<table cellpadding="5" cellspacing="0" id="biometric" width="90%;">
								<tr>
									<td class="left" style="width: 20% !important;">LeaveRequestedTo<font color="red">*</font></td>
									<td class="right"><select id="requestedbyNotApproved"  name="leaverequestto">
									<option value="">-----Select-----</option>
									</select>
									
									</td>
									<td class="left">Total Days of Leave<font color="red">*</font> </td>
									<td class="right"><input type="text" name="noofleaves" id="noofleavesNotApproved" onchange="setEndDate()"
										onblur="validateLeave()" placeholder="Total Days" /></td>
										
	                            </tr><tr>
									<td class="left">From Date<font color="red">*</font></td>
									<td class="right"><input type="text" name="startdate" id="startdateNotApproved"
										onchange="setEndDate()" placeholder="Click here" /></td>
									<td class="left">To Date</td>
									<td class="right"><input type="text" name="enddate" id="enddateNotApproved" onfocus="setEndDate()"
										readonly="readonly" /></td>
													
	                            </tr><tr>
	                            		
	                            	<td class="left">Leave Type<font color="red">*</font></td>
									<td class="right"><select	id="leavetype"  name="leavetype">
									<option value="">-----Select-----</option>
									<option value="SL">SL</option>
									<option value="PL">PL</option>
									<option value="CL">CL</option>
									</select>
	                            		
	                            		
									<td class="left">File Upload</td>
									<td class="right"><input type="file" name="fileupload" id="fileuploadNotApproved" style="width:90%;font-size: 12px;"/>
									<input type="button" id="downloadId" value="DownLoad"></td>
									<input type="hidden" id="snoId" name="sno" />		
	                            		
								
								
								</tr><tr>
								
										<td class="left">Reason for Leave<font
										color="red">*</font></td>
									<td class="right"> <textarea name="reasonforleaves"	id="reasonforleavesNotApproved" rows="2" cols="25" style="resize: none"
										placeholder="Enter Reason here"></textarea></td>
								
																		
									<input type="hidden" id="managercode" name="leaverequestto"
										value="<logic:present name="ManagerVo" scope="request"><bean:write name="ManagerVo" property="managerid" scope="request"/>
							</logic:present>" />
								</tr>
								
								
								
							</table>
			</form>
			

		</center>
		<br>
		<center>
		
		</center>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<br/><br/>
	<a href="employeeMenu.do?parameter=leaveDetailsHome">
	<span id="goBack" style="margin-left: 90%; text-decoration: underline; cursor: pointer;font-size:12px; ">Go back to Home</span></a>
</body>
</html>