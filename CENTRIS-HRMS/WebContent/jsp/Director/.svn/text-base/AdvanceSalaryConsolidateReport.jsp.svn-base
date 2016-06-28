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
<script type="text/javascript"
	src="js/Director/AdvanceSalaryConsolidateReport.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/login/style.css">
<link rel="stylesheet" href="css/login/common.css">

</head>
<body>
<form action="advancedSalaryRequest.do?parameter=advanceSalaryConsolidateReport" method="post">
<input type="hidden" id="htodate" value="<logic:present name="toDate"><bean:write name="toDate"  /> </logic:present>"/>
			<input type="hidden" id="hfromdate" value="<logic:present name="fromDate"><bean:write name="fromDate"  /></logic:present>"/>
			
		<input type="hidden" id="hgroupBy" value="<logic:present name="groupBy"><bean:write name="groupBy"  /> </logic:present>"/>
			<input type="hidden" id="hstatus" value="<logic:present name="status"><bean:write name="status"  /></logic:present>"/>
				
			
			
			
	<div id="main" class="background">
		<div class="backgroundDiv" id="backgroung">Advance Salary
			Consolidate</div>
			<center>
			<div id="errordiv" class="error-box" >
<span style="color: red; font-family: Segoe UI;"> 
							</span>
						</div>
			</center>
			<center>
		
			<br />
			<table cellpadding="5" cellspacing="2" id="biometric" width="100%"
				align="center">

				<tr>
					<td class="left">Start Date <font color="red">*</font></td>
					<td class="right"><input type="text"
						style="text-align: center;" name="toDate" id="todate"
						readonly="readonly" placeholder="Click here" value="" /></td>
					<td class="left">End Date <font color="red">*</font></td>
					<td class="right"><input type="text" name="fromDate"
						id="fromdate" style="text-align: center;" readonly="readonly"
						placeholder="Click here" value="" /></td>
</tr><tr>
					<td class="left" >Group By<font color="red">*</font></td>
					<td class="right"><select name="groupBy" id="groupById">

							<option value="">----Select-----</option>
							<option value="MAN">Manager</option>
							<option value="PJT">Project</option>


					</select></td>



					<td class="left">Status<font color="red">*</font></td>
				
					<td class="right"><select name="status" id="statusId">

							<option value="">----Select-----</option>
							<option value="%%">All</option>
							<option value="Y">Approved</option>
							<option value="N">Not Approved</option>


					</select></td>
				</tr>
				<tr>

				</tr>
			</table>
			<br>
	<table align="center">
								<tr class="odd">

									<td colspan="3"><center>
											<input type="submit" class="submitbutton" value="Get Details"
												class="button1" id="getDetailsId" onclick="return validateForm();"/> &nbsp;&nbsp;&nbsp; <input
												type="reset" value="Clear" class="submitbutton" id="clear" />
										</center></td>

								</tr>

							</table>
		
		</center>
			
				<logic:present name="advancedSalaryConsolidateMap" scope="request">
								<logic:iterate id="calMap" name="advancedSalaryConsolidateMap"
									scope="request">
									<h3 class="accordHead" id="accordian" style="width: 100%;text-align: center;">
										
										<bean:write name="calMap" property="key" />
									</h3>

									<div class="accBody" style="display: none;">
										<table class="view" id="approveRecords">
											<tr>
												<th>Sno</th>
												<th style="width: 8%;">Emp BioId</th>
												<th style="width:18%;">Employee Name</th>
												<th style="width:12%;">Claimed Amount</th>
												<th style="width:11%;">Claimed Date</th>
											<th style="width:13%;">Approved Status
											(Director)</th>
												<th style="width:14%;">Approved Amount</th>
												<th style="width:18%;">Approved By</th>
												<th style="width:13%;">Approved Date</th>
											<!-- 	<th>Comment</th> -->
												<th>Project RefCode</th>
												<th>Approves Status(Admin)</th>
												<th>Approved By(Admin)</th>
											</tr>
											<logic:iterate name="calMap" property="value" id="dateVO">
												<tr class="accordHead">
											 		<td><bean:write name="dateVO" property="sno" /></td> 
													<td><bean:write name="dateVO" property="employeeBioId"/></td>
													<td><bean:write name="dateVO" property="employeeName" /></td>
													<td><bean:write name="dateVO" property="claimedAmount" /></td>
														<td><bean:write name="dateVO" property="claimedDate" /></td>
														<td><bean:write name="dateVO" property="directorStatus" /></td>
														
													<td><bean:write name="dateVO" property="approvedAmount" /></td>
													<td><bean:write name="dateVO" property="approvedByName" /></td>
														<td><bean:write name="dateVO" property="approvedDate" /></td>
													<td><bean:write name="dateVO" property="projectReferenceCode" /></td>
													
													<td><bean:write name="dateVO" property="adminStatus"/></td>
												<td><bean:write name="dateVO" property="accountentApproved"/></td>
												
												
													
													
											
												
												</tr>
												
						
												
											</logic:iterate>
										</table>
									</div>
								</logic:iterate><br/>
								
				<center>
					<input type="button" value="Download Details"  id="downloadAllowanceDetails"  class="submitbutton"/>
				</center>
			
								
					</logic:present><br></br>
					
					
					
					
					
				<logic:present name="advancedSalaryConsolidateMapProject" scope="request">
								<logic:iterate id="calMap" name="advancedSalaryConsolidateMapProject"
									scope="request">
									<h3 class="accordHead" id="accordian" style="width: 100%;text-align: center;">
										
										<bean:write name="calMap" property="key" />
									</h3>

									<div class="accBody" style="display: none;">
										<table class="view" id="approveRecords">
											<tr>
												<th>Sno</th>
												<th>Emp BioId</th>
												<th>Employee Name</th>
												<th>Claimed Amt</th>
												<th>Claimed Date</th>
												<th>Approved Status(Director)</th>
												
											<th>Claimed By</th>
												<th>Approved Amt</th>
												<th>Approved By</th>
												<th>Approved Date</th>
												<th>Approved Status(Admin)</th>
											<th>Approved By(Admin)</th>
												
											
											</tr>
											<logic:iterate name="calMap" property="value" id="dateVO">
												<tr class="accordHead">
											 		<td><bean:write name="dateVO" property="sno" /></td> 
													<td><bean:write name="dateVO" property="employeeBioId"/></td>
													<td><bean:write name="dateVO" property="employeeName" /></td>
													<td><bean:write name="dateVO" property="claimedAmount" /></td>
														<td><bean:write name="dateVO" property="claimedDate" /></td>
															<td><bean:write name="dateVO" property="directorStatus" /></td>
														<td><bean:write name="dateVO" property="claimedByName" /></td>
													
													<td><bean:write name="dateVO" property="approvedAmount" /></td>
													<td><bean:write name="dateVO" property="approvedByName" /></td>
														<td><bean:write name="dateVO" property="approvedDate" /></td>
											<td><bean:write name="dateVO" property="adminStatus"/></td>
											<td><bean:write name="dateVO" property="accountentApproved"/></td>
												
													
												
												
													
													
											
												
												</tr>
												
						
												
											</logic:iterate>
										</table>
									</div>
								</logic:iterate><br/>
								
				<center>
					<input type="button" value="Download Details"  id="downloadAllowanceDetails"  class="submitbutton"/>
				</center>
			
								
					</logic:present><br></br>
					
					
					
					
					
					

	</div>


</form>
</body>
</html>