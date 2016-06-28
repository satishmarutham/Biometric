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
<script type="text/javascript" src="js/Admin/GetDailyAllowancesNotApproved.js"></script>
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

			<div class="backgroundDiv" id="backgroung">Employee Daily Allowances</div>
	
		<center>

					<div id="errordiv" class="error-box" align="center" style="width: 40%">

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
											
		<form name="allowanceApprove" id="allowanceApprove" action="EmpAllowAprroveByDirectorAction.do">
			<input type="hidden" id="getAllowancesNotApproved" value="getAllowancesNotApproved" name="method"  />
			
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
				
					
				
				
				<logic:present name="allowanceList" scope="request">
				<logic:notEmpty name="allowanceList">
				<input type="hidden" id="normalTktPresnt" value="Y"/>
								<logic:iterate id="calMap" name="allowanceList"
									scope="request">
									<h3 class="accordHead" id="accordian" style="width: 100%">
										
										<bean:write name="calMap" property="key" />
									</h3>

									<div class="accBody" style="display: none;">
										<table class="view" id="approveRecords">
											<tr>
												<th>Sno</th>
												<th>Emp Code</th>
												<th>Name</th>
												<th>Project Ref Code</th>
												<th>Allowance Date</th>
												<th>Posted Amt</th>
												<th>Director Approved Amt</th>
												<th>Account Approved Amt </th>
												<th>Accounts Remarks</th>
												<th>Approve</th>
												<th>Reject</th>
												<th>View</th>
											</tr>
											<logic:iterate name="calMap" property="value" id="dateVO">
												<tr class="accordHead">
												
											
												<input type="hidden" class="hallowancrId" value="<bean:write name="dateVO" property="allowanceCode" />"/>
												
													<td><bean:write name="dateVO" property="sno" /></td>
													<td><bean:write name="dateVO" property="bioCode" /></td>
													<td><bean:write name="dateVO" property="empname" /></td>
													<td><bean:write name="dateVO" property="projectRefCode" /></td>
													<td><bean:write name="dateVO" property="allowancesdate" /></td>
													<td><bean:write name="dateVO" property="amount" /></td>
													<td class="directorApprovedAmt"><bean:write name="dateVO" property="approveamount" /></td>
													<td><input type="text" value="<bean:write name="dateVO" property="accountsApprovedAmount" />" class="approveAmount"></td>
													<td>
													<textarea rows="3" cols="25" class="accountantComments"><bean:write name="dateVO" property="accountsRemarks" /></textarea>
													</td>
													<td><input type="button" value="<bean:write name="dateVO" property="isaccountsStatus" />"
													 id="Approve_<bean:write name="dateVO" property="allowanceCode"/>" class="approveAllowance"></td>
													 
													 <td><input type="button" value="<bean:write name="dateVO" property="isRejectedStatus" />"
													 id="Reject_<bean:write name="dateVO" property="allowanceCode"/>" class="rejectAllowance"></td>
													 
													 
													 
													 
													<td><input type="button" value="View" id="<bean:write name="dateVO" property="allowanceCode"  />" class="viewDeatails"></td>
												
												
												</tr>
												
												
												
												
											</logic:iterate>
										</table>
									</div>
								</logic:iterate><br/>
				
					<input type="button" value="Download Allowance Details"  id="downloadAllowanceDetails"  class="submitbutton"/>
					</logic:notEmpty>
					</logic:present><br/>
					
					
					<logic:present name="conflictEmployees">
					<logic:notEmpty name="conflictEmployees">
					<input type="hidden" id="conflictTktPresnt" value="Y"/>
									<div >
										<table class="view" id="approveRecords">
										
										<tr>
										
										 <td colspan="12" class="head11"  style="background-color: #E6E6E6">	<span class="head11"   style="background-color: #E6E6E6"><b>Conflict Employees</b> </span> </td>
										
										</tr>
										
											<tr>
												<th>Sno</th>
												<th>Emp Code</th>
												<th>Name</th>
												<th>Project Ref Code</th>
												<th>Allowance Date</th>
												<th>Posted Amt</th>
												<th>Director Approve Amt</th>
												<th>Accounts Approve Amt</th>
												<th>Accounts Remarks</th>
												<th>Approve</th>
												<th>Reject</th>
												<th>View</th>
											</tr>
											<logic:iterate name="conflictEmployees"  id="employees">
												<tr >
												
													<input type="hidden" class="hallowancrId" value="<bean:write name="employees" property="allowanceCode" />"/>
													<td><bean:write name="employees" property="sno" /></td>
													<td><bean:write name="employees" property="bioCode" /></td>
													<td><bean:write name="employees" property="empname" /></td>
													<td><bean:write name="employees" property="projectRefCode" /></td>
													<td><bean:write name="employees" property="allowancesdate" /></td>
													<td><bean:write name="employees" property="amount" /></td>
													<td class="directorApprovedAmt"><bean:write name="employees" property="approveamount" /></td>
													<td><input type="text" value="<bean:write name="employees" property="accountsApprovedAmount" />" class="approveAmount"></td>
													<td>
													<textarea rows="3" cols="25" class="accountantComments"><bean:write name="employees" property="accountsRemarks" /></textarea>
													</td>
													
													<td><input type="button" value="<bean:write name="employees" property="isaccountsStatus" />"
													 id="Approve_<bean:write name="employees" property="allowanceCode"/>" class="approveAllowance"></td>
													
												    <td><input type="button" value="<bean:write name="employees" property="isRejectedStatus" />"
													 id="Reject_<bean:write name="employees" property="allowanceCode"/>" class="rejectAllowance"></td>
													 
													<td><input type="button" value="View" id="<bean:write name="employees" property="allowanceCode"  />" class="viewDeatails"></td>
												</tr>
												
											</logic:iterate>
										</table>
									</div><br/>
									
					<input type="button" value="Download Conflict Allowance Details"  id="downloadConflictAllowanceDetails"  class="submitbutton"/>
									
									</logic:notEmpty>
							</logic:present>
							
						<br/>	
					<input type="button" value="Approve All Allowance Details"  id="approveAll"  class="submitbutton conflict"/>
					
					<div id="view-dialog" title="Employee Allowance Details" style="display: none; font-size: 10px;background-color: #F2F0E7" align="center"><br/>
						<table cellpadding="5" cellspacing="0" id="biometric" width="100%" class="dialogclass">
							
							<tr>
							
							
							<td class="leftindialog" >Posted By</td>
								<td class="rightindialog"  id="postedby">
									
								</td>
								
									<td class="leftindialog" >Posted Time</td>
								<td class="rightindialog"  id="postedDate">
									
								</td>


                            </tr>
                            
                            <tr>
                            
                            
                            <td class="leftindialog" >Approved Director</td>
								<td class="rightindialog"  id="approvedby">
									
								</td>
								
									<td class="leftindialog" >Approved Time</td>
								<td class="rightindialog"  id="approveddate">
									
								</td>
                            
                            
                            </tr>
                            
                            <tr>
                            
                            <td class="leftindialog" >Project Manager</td>
							<td class="rightindialog"  id="projrctmgr">
									
							</td>
                            
                            <td class="leftindialog" >Client</td>
								<td class="rightindialog"  id="clicent" >
							</td>
								
							</tr>
							
							 <tr>
							 
							 	<td class="leftindialog">Team Lead</td>
								<td class="rightindialog" id="teamlead"></td>
								<td class="leftindialog">Single/Team/GH </td>
								<td class="rightindialog" id="singleteamgh"></td>

							</tr>
							
							  <tr>
							  
								<td class="leftindialog">DA Type</td>
								<td class="rightindialog" id="datype" ></td>
								<td class="leftindialog">No of Day/Month Allowance</td>
								<td class="rightindialog" id="noofdays"></td>

							</tr>
							<tr>
								<td class="leftindialog">Location</td>
								<td class="rightindialog" id="location" >
								</td>
							
								<td class="leftindialog">Hdfc A/c No</td>
								<td class="rightindialog" id="hdfcaccount" >
								</td>
							
							
							</tr>
							
							 <tr>
							  
								<td style="background-color: #D9D9D9" height="50px !important">Manager Remarks</td>
								<td  style="background-color: #FFF" height="50px !important" id="managerremarks" ></td>
							
								<td style="background-color: #D9D9D9" height="50px !important">Director Remarks</td>
								<td  style="background-color: #FFF" height="50px !important" id="directorremarks" ></td>
							
							

							</tr>

						</table>
						
						</div>
						
			
		</center>
</div>
			
								

</body>
</html>