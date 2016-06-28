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
<script type="text/javascript" src="js/Director/EmployeeAllowanceReport.js"></script>
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
	            <div class="backgroundDiv" id="backgroung">Employee  Allowances Report</div>
	   <center>
		 <div id="errordiv" class="error-box" align="center">
		 </div>
		</center>
	
											
		<form   action="empAllowanceReport.do">
			<input type="hidden" id="getAllowances" value="getAllowances" name="method"  />
			
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
						<td class="left">Status <font color="red">*</font></td>
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
				
					
				
				
				<logic:present name="AllowancesListByMang" scope="request">
				   <logic:notEmpty name="AllowancesListByMang" scope="request" >
								<logic:iterate id="calMap" name="AllowancesListByMang"
									scope="request">
									<h3 class="accordHead" id="accordian" style="width: 100%;cursor: pointer;">
										
										<bean:write name="calMap" property="key" />
									</h3>

									<div class="accBody" style="display: none;">
										<table class="view" id="approveRecords">
											<tr>
												<th>Sno</th>
												<th>Allowance Date</th>
												<th>Employee Code</th>
												<th>Name</th>
												<th>Location</th>
												<th>NoOf Allowance/Month</th>
												<th>Single/Team/GH</th>
												<th>DA Type</th>
												<th>Posted Amount</th>
												<th>Project RefCode</th>
												<th>Client</th>
												<th>Project Manager</th>
												<th>DirectorApproval Status</th>
												<th>Approved Director</th>
												<th>DirApproved Date</th>
												<th>Approved Amount</th>
												<th>AdminApproval Status</th>
												<th>Approved Admin </th>
												<th>AdminApproved Date </th>
											
											  <!--   <th>Claimed Remarks</th> -->
													<th>Confilct</th>
											</tr>
											<logic:iterate name="calMap" property="value" id="dateVO">
												<tr class="accordHead">
													<td><bean:write name="dateVO" property="sno" /></td>
													<td><bean:write name="dateVO" property="allowancedate" /></td>
													<td><bean:write name="dateVO" property="biocode" /></td>
													<td><bean:write name="dateVO" property="empname" /></td>
													<td><bean:write name="dateVO" property="location" /></td>
													<td><bean:write name="dateVO" property="noofdaymonth" /></td>
													<td><bean:write name="dateVO" property="singleteamgh" /></td>
													<td><bean:write name="dateVO" property="datype" /></td>
													<td><bean:write name="dateVO" property="post_amount" /></td>
											<td><bean:write name="dateVO" property="projectrefcode" /></td>
											<td><bean:write name="dateVO" property="clientname" /></td>
											<td><bean:write name="dateVO" property="projectmang" /></td>
											<td><bean:write name="dateVO" property="isdircapproved" /></td>
											<td><bean:write name="dateVO" property="approveDire" /></td>
											<td><bean:write name="dateVO" property="approveDiredate" /></td>	
											<td><bean:write name="dateVO" property="approvedamount" /></td>	
										
											<td><bean:write name="dateVO" property="isAccapproved" /></td>	
											<td><bean:write name="dateVO" property="approveAccnt" /></td>	
											<td><bean:write name="dateVO" property="approveAccntdate" /></td>
										
										<%-- 	<td>
													<textarea rows="3" cols="25"><bean:write name="dateVO" property="mang_remarks" />
													</textarea>
													</td> --%>
													
												<td><bean:write name="dateVO" property="confilct" /></td>		
												</tr>
												
						
												
											</logic:iterate>
										</table>
									</div>
								</logic:iterate><br/>
								
				<center>
					<input type="button" value="Download Allowance Details"  id="downloadAllowanceDetails"  class="submitbutton"/>
				</center>
			
							</logic:notEmpty>	
							
				<logic:empty name="AllowancesListByMang" scope="request">
					   <span style="color: black; font-family: Segoe UI;font-size: 12px;"><bean:write name="nodata" scope="request" /> </span>
			    
				</logic:empty>			
							
							
					</logic:present>
					
					
					
			<logic:present name="AllowancesListByProject" scope="request">
			
			            <logic:notEmpty name="AllowancesListByProject" scope="request" >
					
								<logic:iterate id="calMap" name="AllowancesListByProject"
									scope="request">
									<h3 class="accordHead" id="accordian" style="width: 100%;cursor: pointer;">
										
										<bean:write name="calMap" property="key" />
									</h3>

									<div class="accBody" style="display: none;">
										<table class="view" id="approveRecords">
											<tr>
												<th>Sno</th>
												<th>Allowance Date</th>
												<th>Employee Code</th>
												<th>Name</th>
												<th>Location</th>
												<th>NoOf  Allowance/Month</th>
												<th>Single/Team/GH</th>
												<th>DA Type</th>
												<th>Posted Amount</th>
												<th>Posted By</th>
												<th>Client</th>
												<th>Project Manager</th>
												<th>DirectorApproval Status</th>
												<th>Approved Director</th>
												<th>DirApproved Date</th>
												<th>Approved Amount</th>
												<th>AdminApproval Status</th>
												<th>Approved Admin </th>
												<th>AdminApproved Date </th>
												<th>Confilct</th>
											  <!--   <th>Claimed Remarks</th> -->
												
											</tr>
											<logic:iterate name="calMap" property="value" id="dateVO">
												<tr class="accordHead">
													<td><bean:write name="dateVO" property="sno" /></td>
													<td><bean:write name="dateVO" property="allowancedate" /></td>
													<td><bean:write name="dateVO" property="biocode" /></td>
													<td><bean:write name="dateVO" property="empname" /></td>
													<td><bean:write name="dateVO" property="location" /></td>
													<td><bean:write name="dateVO" property="noofdaymonth" /></td>
													<td><bean:write name="dateVO" property="singleteamgh" /></td>
													<td><bean:write name="dateVO" property="datype" /></td>
													<td><bean:write name="dateVO" property="post_amount" /></td>
											<td><bean:write name="dateVO" property="postedbyname" /></td>
											<td><bean:write name="dateVO" property="clientname" /></td>
											<td><bean:write name="dateVO" property="projectmang" /></td>
											<td><bean:write name="dateVO" property="isdircapproved" /></td>
											<td><bean:write name="dateVO" property="approveDire" /></td>
											<td><bean:write name="dateVO" property="approveDiredate" /></td>	
											<td><bean:write name="dateVO" property="approvedamount" /></td>	
										
											<td><bean:write name="dateVO" property="isAccapproved" /></td>	
											<td><bean:write name="dateVO" property="approveAccnt" /></td>	
											<td><bean:write name="dateVO" property="approveAccntdate" /></td>
											<td><bean:write name="dateVO" property="confilct" /></td>	
										<%-- 	<td>
													<textarea rows="3" cols="25"><bean:write name="dateVO" property="mang_remarks" />
													</textarea>
													</td>
												
												</tr> --%>
												
						
												
											</logic:iterate>
										</table>
									</div>
								</logic:iterate><br/>
								
				<center>
					<input type="button" value="Download Allowance Details"  id="downloadAllowanceDetails"  class="submitbutton"/>
				</center>
			
							</logic:notEmpty>	
							
				<logic:empty name="AllowancesListByProject" scope="request">
				   <span style="color: black; font-family: Segoe UI;font-size: 12px;"><bean:write name="nodata" scope="request" /> </span>
			    
				</logic:empty>		
								
					</logic:present>
					<br></br>
					
			</center>		
					
</div>
			
								

</body>
</html>