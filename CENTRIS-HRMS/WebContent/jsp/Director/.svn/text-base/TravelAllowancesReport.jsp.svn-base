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
<script type="text/javascript" src="js/Director/TravelAllowancesReport.js"></script>
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
		
	

			<div class="backgroundDiv" id="backgroung">Travel  Allowances Report</div>
		 <center>
					<div id="errordiv" class="error-box" align="center">

					</div>
				</center>
										
		<form   action="travelAllowanceReport.do">
			<input type="hidden"  value="getTravelAllowances" name="method"  />
			
			<input type="hidden" id="hstartdate" value="<logic:present name="startdate"><bean:write name="startdate"  /> </logic:present>"/>
			<input type="hidden" id="henddate" value="<logic:present name="enddate"><bean:write name="enddate"  /></logic:present>"/>
			<input type="hidden" id="hstatus" value="<logic:present name="status"><bean:write name="status"  /></logic:present>"/>
			<input type="hidden" id="hgroupby" value="<logic:present name="groupby"><bean:write name="groupby"  /></logic:present>"/>
		
				<table cellpadding="5" cellspacing="2" id="biometric" width="60%">
		
					<tr>
						<td class="left">Start Date <font color="red">*</font></td>
						<td class="right" ><input type="text" style="text-align: center;" name="startdate" id="startdate"  readonly="readonly" placeholder="Click here" 
						value="" /></td>
						<td class="left">End Date <font color="red">*</font></td>
						<td class="right"><input type="text" name="enddate" id="enddate" style="text-align: center;" readonly="readonly" placeholder="Click here"
						value="" /></td>
					
						
					</tr>	
					<tr>
						<td  class="left" >Status <font color="red">*</font></td>
						<td class="right" ><select  name="status" id="status" >
						                  <option value="">---Select---</option>
						                     <option value="all">All</option>
						                  <option value="Y">Approved</option>
						                  <option value="N">Not Approved</option></select> </td>
						<td class="left">Group By <font color="red">*</font></td>
						<td class="right"><select  name="groupby" id="groupby" >
						                  <option value="">---Select---</option>
						                  <option value="manager">Manager</option>
						                  <option value="project">Project</option></select> </td>
					
						
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
				
					
				
				
				<logic:present name="TravelAllowancesListByMang" scope="request">
				      <logic:notEmpty name="TravelAllowancesListByMang" scope="request">
								<logic:iterate id="calMap" name="TravelAllowancesListByMang"
									scope="request">
									<h3 class="accordHead" id="accordian" style="width: 100%;cursor: pointer;">
										
										<bean:write name="calMap" property="key" />
									</h3>

									<div class="accBody" style="display: none;">
										<table class="view">
											<tr>
												<th>Sno</th>
												<th>Booked Date</th>
												<th>Ticket Booked By</th>
												<th>Who is on Travel</th>
												<th>Travelling Date</th>
												<th>Travel Mode</th>
												<th>Travel From</th>
												<th>Travel To</th>
												<th>Actual Amount</th>
												<th>Posted Date</th>
												<th>Project Ref Code</th>
												<th>Project Manager</th>
												<th>Debit Card Used By</th>
												<th>DirectorApproval Status</th>
												<th>Approved Director</th>
												<th>DirApproved Date</th>
												<th>Approved Amount</th>
												<th>AdminApproval Status</th>
												<th>Approved Admin </th>
												<th>AdminApproved Date </th>
											   	<th>Confilct</th>
											</tr>
											<logic:iterate name="calMap" property="value" id="dateVO">
												<tr class="accordHead">
													<td><bean:write name="dateVO" property="sno" /></td>
													<td><bean:write name="dateVO" property="bookingdate" /></td>
													<td><bean:write name="dateVO" property="ticketbokedby" /></td>
													<td><bean:write name="dateVO" property="whoisontravel" /></td>
													<td><bean:write name="dateVO" property="travellingdate" /></td>
													<td><bean:write name="dateVO" property="mode" /></td>
													<td><bean:write name="dateVO" property="travelfrom" /></td>
													<td><bean:write name="dateVO" property="travelto" /></td>
													<td><bean:write name="dateVO" property="postedamount" /></td>
													<td><bean:write name="dateVO" property="posteddate" /></td>
											<td><bean:write name="dateVO" property="projectrefcode" /></td>
											<td><bean:write name="dateVO" property="projectmanager" /></td>
											<td><bean:write name="dateVO" property="debitcardusedby" /></td>
											
											<td><bean:write name="dateVO" property="isDireApproved" /></td>
											<td><bean:write name="dateVO" property="approvedDirname" /></td>
											<td><bean:write name="dateVO" property="dirApproveddate" /></td>	
											<td><bean:write name="dateVO" property="approvedamount" /></td>	
										
											<td><bean:write name="dateVO" property="isAccntApproved" /></td>	
											<td><bean:write name="dateVO" property="approvedAccntname" /></td>	
											<td><bean:write name="dateVO" property="accntApproveddate" /></td>
													
											<td><bean:write name="dateVO" property="isconflict" /></td>		
												</tr>
												
						
												
											</logic:iterate>
										</table>
									</div>
								</logic:iterate><br/>
								
				<center>
					<input type="button" value="Download Travel Allowance Details"  id="downloadTravelAllowanceDetails"  class="submitbutton"/>
				</center>
			</logic:notEmpty>
		    	<logic:empty name="TravelAllowancesListByMang" scope="request">
				   <span style="color: black; font-family: Segoe UI;font-size: 12px;"><bean:write name="nodata" scope="request" /> </span>
			    
				</logic:empty>			
					</logic:present>
					
					
					
			<logic:present name="TravelAllowancesListByProject" scope="request">
			 <logic:notEmpty name="TravelAllowancesListByProject" scope="request">
								<logic:iterate id="calMap" name="TravelAllowancesListByProject"
									scope="request">
									<h3 class="accordHead" id="accordian" style="width: 100%;cursor: pointer;">
										
										<bean:write name="calMap" property="key" />
									</h3>

									<div class="accBody" style="display: none;">
										<table class="view" id="approveRecords">
											<tr>
												<th>Sno</th>
												<th>Booked Date</th>
												<th>Ticket Booked By</th>
												<th>Who is on Travel</th>
												<th>Travelling Date</th>
												<th>Travel Mode</th>
												<th>Travel From</th>
												<th>Travel To</th>
												<th>Actual Amount</th>
												<th>Posted By</th>
												<th>Posted Date</th>
												<th>Project Manager</th>
												<th>Debit Card Used By</th>
												<th>DirectorApproval Status</th>
												<th>Approved Director</th>
												<th>DirApproved Date</th>
												<th>Approved Amount</th>
												<th>AdminApproval Status</th>
												<th>Approved Admin </th>
												<th>AdminApproved Date </th>
											   	<th>Confilct</th>
												
											</tr>
											<logic:iterate name="calMap" property="value" id="dateVO">
												<tr class="accordHead">
													<td><bean:write name="dateVO" property="sno" /></td>
													<td><bean:write name="dateVO" property="bookingdate" /></td>
													<td><bean:write name="dateVO" property="ticketbokedby" /></td>
													<td><bean:write name="dateVO" property="whoisontravel" /></td>
													<td><bean:write name="dateVO" property="travellingdate" /></td>
													<td><bean:write name="dateVO" property="mode" /></td>
													<td><bean:write name="dateVO" property="travelfrom" /></td>
													<td><bean:write name="dateVO" property="travelto" /></td>
													<td><bean:write name="dateVO" property="postedamount" /></td>
													<td><bean:write name="dateVO" property="postedbyname" /></td>
													<td><bean:write name="dateVO" property="posteddate" /></td>
											<td><bean:write name="dateVO" property="projectmanager" /></td>
											<td><bean:write name="dateVO" property="debitcardusedby" /></td>
											
											<td><bean:write name="dateVO" property="isDireApproved" /></td>
											<td><bean:write name="dateVO" property="approvedDirname" /></td>
											<td><bean:write name="dateVO" property="dirApproveddate" /></td>	
											<td><bean:write name="dateVO" property="approvedamount" /></td>	
										
											<td><bean:write name="dateVO" property="isAccntApproved" /></td>	
											<td><bean:write name="dateVO" property="approvedAccntname" /></td>	
											<td><bean:write name="dateVO" property="accntApproveddate" /></td>
													
											<td><bean:write name="dateVO" property="isconflict" /></td>		
												</tr>
												
						
												
											</logic:iterate>
										</table>
									</div>
								</logic:iterate><br/>
								
				<center>
					<input type="button" value="Download Travel Allowance Details"  id="downloadTravelAllowanceDetails"  class="submitbutton"/>
				</center>
			
				</logic:notEmpty>	
					<logic:empty name="TravelAllowancesListByProject" scope="request">
				   <span style="color: black; font-family: Segoe UI;font-size: 12px;"><bean:write name="nodata" scope="request" /> </span>
			    
				</logic:empty>				
					</logic:present>
					<br></br>
					
			</center>		
					
</div>
			
								

</body>
</html>