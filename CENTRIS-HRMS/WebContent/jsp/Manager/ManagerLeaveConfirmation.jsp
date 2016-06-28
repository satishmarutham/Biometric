<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title></title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.core.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.widget.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.mouse.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.button.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.draggable.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.position.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.resizable.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.dialog.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.effect.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="js/Manager/ManagerLeaveConfirmation.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/common.css"></link>

</head>


<body>
	<br>
	<div align="center" id="main">
		<center>
			<div class="background" id="backgroung">

				<div class="backgroundDiv" id="backgroung">Leave Request
					Confirmation</div>

				<br />

				<center>

					<div id="errordiv" class="error-box" align="center">

						<logic:present name="success" scope="request">
							<span style="color: green; font-family: Segoe UI;"> <bean:write
									name="success" />
							</span>
						</logic:present>
						<logic:present name="failure" scope="request">
							<span style="color: red; font-family: Segoe UI;"> <bean:write
									name="failure" />
							</span>
						</logic:present>
						
						
					</div>
				</center>

		
				<div class="tablecss" style="width: 80%; margin: 15px;">


					<logic:present name="LeaveDetailsList" scope="request">
						<display:table id="LEAVE" name="requestScope.LeaveDetailsList"
							class="displayTableClass"
							requestURI="/managerMenu.do?parameter=getLeaveRequestForApproved"
							pagesize="10"
							decorator="com.centris.decorator.ManagerLeaveConfirmationDecorator">
							<display:column property="requestedBy" title="Requested By" />
							<display:column property="noofLeaves" title="No Of Leaves" />
							<display:column property="reasonforLeave"
								title="Reason For Leave" />
							<display:column property="startDate" title="Start Date" />
							<display:column property="endDate" title="End Date" />
							<display:column property="leavetype" title="Leave Type" />
							<display:column property="approvedStatus" title="Leave Status" />
							<display:column property="requestedDate" title="Requested Date" />
							<display:column property="viewButton" title="View" />
						</display:table>
					</logic:present>


				</div>
			</div>
		</center>
	</div>
<div id="LeaveConfirm" style="align: center;"
		title="Leave Confirmation Details">

		<br>
	<center><div id="loader" style="position: absolute;top:5px;left:350px;display: none;"><img  src="images/loaderimage2.GIF"/></div></center>
		<center>
			<table id="biometric" cellpadding="5" cellspacing="0">
				<tr>
					<td class="left">Requested By</td>
					<td class="right"><input type="text" name="requestedBy" id="requestedby"
						readonly="readonly"  /></td>
						
					<td class="left">Start Date</td>
					<td class="right"><input type="text" name="startDate" id="startdate" value=""
						readonly="readonly"  /></td>
                 </tr>
                 <tr>
					<td class="left">End Date</td>
					<td class="right"><input type="text" name="endDate" id="enddate" value=""
						readonly="readonly"  /></td>
						
					<td align="left" class="left">No Of leaves</td>
					<td class="right"><input type="text" name="noofLeaves" class="noofleavesId" value=""
						readonly="readonly"  /></td>	
				</tr>
				<tr>
					
					<td  class="left">Requested Date</td>
					<td class="right"><input type="text" name="requestedDate" id="requesteddate" value=""
						readonly="readonly"  /></td>
               
					<td class="left">Reason For Leave</td>
					<td class="right"><textarea class="Textarea" rows="2" cols="25"  id="reasonforleave" readonly="readonly"  style="resize:none;"></textarea></td>
				</tr>
				<tr>
					<td class="left">Total Leaves Approved</td>
					<td class="right"><input type="text" name="totalleavesApproved" id="totalleavesapproved" value="" onblur="approvedstartdate()" placeholder="Enter Leaves to Approve" /></td>
					
					<td class="left">Approved start date</td>
					<td class="right"><input type="text" name="approvedStartDate" id="approvedstartdate" value="" readonly="readonly" /></td>
					

				</tr>

				<tr>
				<td class="left">Approved end date</td>
				<td class="right"><input type="text" name="approvedEndDate" id="approvedenddate" value="" readonly="readonly" /></td>
			

					<td class="left">Comments</td>
					<td class="right"><textarea class="Textarea" rows="2" cols="25" style="resize:none;" id="comments"></textarea></td>
					
					
				</tr>
				<tr>
					<td class="left"><label  id="downloadlable">Download Attachment</label></td>
					<td class="right"> <input type="button" name="download" id="download" value="Download" onclick="download()" /></td>
				</tr>
			</table>

		</center>
		
		<br>
		<center>
			<table id="validateTable">
				<tr>
					<td colspan="3">
						<div class="alert-box error">
							<span style="color: red;font-size: 13px;" class="validateTips"></span>

						</div>
					</td>
				</tr>
			</table>
		</center>

	</div>
</body>
</html>