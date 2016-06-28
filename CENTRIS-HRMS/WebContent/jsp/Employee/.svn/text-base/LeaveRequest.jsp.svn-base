
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.bgiframe-2.1.2.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect-blind.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect-explode.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script type="text/javascript" src="js/Employee/LeaveRequest.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

</head>
<body>
	<br />
	<div id="main">
	<center>
			<div class="background" id="backgroung">
			<br/>
				<div class="backgroundDiv" id="backgroung">Leave Request</div>
			
				<center>
					<span
						style="padding-left: 80%; text-decoration: underline; cursor: pointer;font-size:12px; "
						id="getLeaveRequestStatusDetails">View Leave Request Status</span>
		
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
						<center><div id="loader" style="position: absolute;top:200px;left:620px;display: none;"><img  src="images/loaderimage2.GIF"/></div></center>
				<form action="leaverequest.do?parameter=AddLeaveRequest"
					method="post" enctype="multipart/form-data">
					<!-- <input type="hidden" value="LeaveRequest" name="parameter">  -->
					<br />
					<div class="middlediv" style="width: 100%;">
						<fieldset style="width: 85%;">
						<br/>
							<table cellpadding="5" cellspacing="0" id="biometric" width="60%;">
								<tr>
									<td class="left">LeaveRequestedTo<font color="red">*</font></td>
									<td class="right"><select	id="leaverequestto"  name="leaverequestto">
									<option value="">-----Select-----</option>
									</select>
									
									</td>
									<td class="left">Total Days of Leave<font color="red">*</font> </td>
									<td class="right"><input type="text"	name="noofleaves" id="noofleaves"  onchange="setEndDate()"
										onblur="validateLeave()" placeholder="Total Days" /></td>
										
	                            </tr><tr>
									<td class="left">From Date<font color="red">*</font></td>
									<td class="right"><input type="text" name="startdate" id="startdate" readonly="readonly"
										onchange="setEndDate()" placeholder="Click here" /></td>
									<td class="left">To Date</td>
									<td class="right"><input type="text" name="enddate" id="enddate" onfocus="setEndDate()"
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
									<td class="right"><input type="file" name="fileupload" id="fileupload" style="width:90%;"/></td>
															
									<input type="hidden" id="managercode" name="leaverequestto"
										value="<logic:present name="ManagerVo" scope="request"><bean:write name="ManagerVo" property="managerid" scope="request"/>
							</logic:present>" />
							
							</tr><tr>
							
							<td class="left">Reason for leave<font
										color="red">*</font></td>
									<td class="right"> <textarea name="reasonforleaves"	id="reasonforleaves" rows="2" cols="25" style="resize: none"
										placeholder="Enter Reason here"></textarea></td>
							
								</tr>
							</table>
							<br/>
						</fieldset>
						<br /> <input type="submit" value="Request" class="submitbutton" id="requestId"
							onclick="return validations()">
					</div>
				</form>
				<br />
			</div>
		</center>
	</div>
	<br/><br/>
	<a href="employeeMenu.do?parameter=leaveDetailsHome" style="color:black; ">
<span id="goBack" style="margin-left: 85%; text-decoration: underline; cursor: pointer;font-size:12px; ">Go back to Home</span></a>
</body>
</html>