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
<script type="text/javascript" src="js/Director/ExpenseReport.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/login/style.css">
<link rel="stylesheet" href="css/login/common.css">

</head>
<body>

<div id="main" class="background">
		<center>
			<div class="backgroundDiv" id="backgroung">Expenses Report</div>
		 <center>
					<div id="errordiv" class="error-box" align="center" style="display: none;">

					</div>
				</center>
												
		<form   action="expensesReport.do">
			<input type="hidden"  value="getExpenses" name="method"  />
			
			<input type="hidden" id="hmonth" value="<logic:present name="month"><bean:write name="month"  /></logic:present>"/>
			<input type="hidden" id="hyear" value="<logic:present name="year"><bean:write name="year"  /></logic:present>"/>
		     <input type="hidden" id="hstatus" value="<logic:present name="status"><bean:write name="status"  /></logic:present>"/>
			<input type="hidden" id="hgroupby" value="<logic:present name="groupby"><bean:write name="groupby"  /></logic:present>"/>
		
				<table cellpadding="5" cellspacing="2" id="biometric" width="60%">
		
					<tr>
						<td  class="left" >Select Month  <font color="red">*</font></td>
						<td class="right" ><select  name="month" id="month" >
						                  <option value="">---Select---</option>
						                   <option value="all">All</option>
						                  <option value="1">JAN</option>
						                  <option value="2">FEB</option>
						                  <option value="3">MAR</option>
						                  <option value="4">APR</option>
						                  <option value="5">MAY</option>
						                  <option value="6">JUNE</option>
						                  <option value="7">JULY</option>
						                  <option value="8">AUG</option>
						                  <option value="9">SEP</option>
						                  <option value="10">OCT</option>
						                  <option value="11">NOV</option>
						                  <option value="12">DEC</option></select></td>
						<td class="left">Select Year <font color="red">*</font></td>
						<td class="right"><select  name="year" id="year" >
						                  <option value="">---Select---</option>
						               </select> </td>
					
						
				</tr><tr>
						<td  class="left" > Status  <font color="red">*</font></td>
						<td class="right" ><select  name="status" id="status" >
						                  <option value="">---Select---</option>
						                  <option value="all">All</option>
						                  <option value="Y">Approved</option>
						                   <option value="N">Not Approved</option></select></td>
						<td class="left"> Group By <font color="red">*</font></td>
						<td class="right"><select  name="groupby" id="groupby" >
						                  <option value="">---Select---</option>
						                    <option value="manager">Manager</option>
						               </select> </td>
					
						
				</tr>
					<tr>
					
					</tr>
			</table>
			<br/>
			
				
			<center>
							<table>
								<tr class="odd">

									<td colspan="3"><center>
											<input type="submit" class="submitbutton" value="Get Expenses"
												class="button1" id="register" onclick="return validate()" /> 
										</center></td>

								</tr>

							</table>
				</center>
				
				
				</form>
				
					
				
				
				<logic:present name="ExpensesListByMang" scope="request">
				  <logic:notEmpty name="ExpensesListByMang" scope="request">
								<logic:iterate id="calMap" name="ExpensesListByMang"
									scope="request">
									<h3 class="accordHead" id="accordian" style="width:100%;cursor: pointer;">
										
										<bean:write name="calMap" property="key" />
									</h3>

									<div class="accBody" style="display: none;">
						
										<table class="view">
											<tr>
												<th>Sno</th>
												<th>Year</th>
												<th>Month</th>
												<th>Emp Name</th>
												<th>Posted Date</th>
												<th>Actual Amount</th>
												<th>Local Conveyance</th>
												<th>Travel Expense</th>
												<th>Staff Welfare</th>
												<th>Telephone</th>
												<th>Purchases</th>
												<th>Other Work Expenses</th>
												<th>Miscellaneous</th>
												<th>ManagerApproval Status</th>
												<th>MangApproved Date</th>
												<th>Approved Amount</th>
												<th>Advance Paid</th>
												<th>Balance</th>
												<th>DirectorApproval Status</th>
												<th>Approved Director</th>
												<th>DirApproved Date</th>
												<th>AdminApproval Status</th>
												<th>Approved Admin </th>
												<th>AdminApproved Date </th>
											  
											</tr>
											<logic:iterate name="calMap" property="value" id="dateVO">
												<tr class="accordHead">
													<td><bean:write name="dateVO" property="sno" /></td>
													<td><bean:write name="dateVO" property="year" /></td>
													<td><bean:write name="dateVO" property="monthname" /></td>
													<td><bean:write name="dateVO" property="empname" /></td>
													<td><bean:write name="dateVO" property="posteddate" /></td>
													<td><bean:write name="dateVO" property="totalamountclaimed" /></td>
													<td><bean:write name="dateVO" property="localconveyance" /></td>
													<td><bean:write name="dateVO" property="travelexpense" /></td>
													<td><bean:write name="dateVO" property="staffwelfare" /></td>
													<td><bean:write name="dateVO" property="telephoneexpense" /></td>
											<td><bean:write name="dateVO" property="purchases" /></td>
											<td><bean:write name="dateVO" property="otherworkexpenses" /></td>
											<td><bean:write name="dateVO" property="misllcellaneous" /></td>
											
											<td><bean:write name="dateVO" property="isMangApproved" /></td>
											<td><bean:write name="dateVO" property="mangApprovedDate" /></td>
											<td><bean:write name="dateVO" property="totalamountapproved" /></td>
											
											<td><bean:write name="dateVO" property="advancepaid" /></td>
											<td><bean:write name="dateVO" property="balance" /></td>
												
											<td><bean:write name="dateVO" property="isDireApproved" /></td>
											<td><bean:write name="dateVO" property="approvedDirename" /></td>
											<td><bean:write name="dateVO" property="direApprovedDate" /></td>	
									
										
											<td><bean:write name="dateVO" property="isAccntApproved" /></td>	
											<td><bean:write name="dateVO" property="approvedAccntsname" /></td>	
											<td><bean:write name="dateVO" property="accntApprovedDate" /></td>
													
											</tr>
												
						
												
											</logic:iterate>
										</table>
									
										
											
									</div>
								</logic:iterate><br/>
								
				<center>
					<input type="button" value="Download Expense Details"  id="downloadExpenseDetails"  class="submitbutton"/>
				</center>
			
			</logic:notEmpty>	
				 <logic:empty name="ExpensesListByMang" scope="request">
				   <span style="color: black; font-family: Segoe UI;font-size: 12px;"><bean:write name="nodata" scope="request" /> </span>
			    
				</logic:empty>
					</logic:present>
					
					
					
			<logic:present name="ExpensesListByProject" scope="request">
			     <logic:notEmpty name="ExpensesListByProject" scope="request">
								<logic:iterate id="calMap" name="ExpensesListByProject"
									scope="request">
									<h3 class="accordHead" id="accordian" style="width: 100%;cursor: pointer;">
										
										<bean:write name="calMap" property="key" />
									</h3>

									<div class="accBody" style="display: none;">
										<table class="view" id="approveRecords">
											<tr>
												<th>Sno</th>
												<th>Year</th>
												<th>Month</th>
												<th>Emp Name</th>
												<th>Approved Manager</th>
												<th>Posted Date</th>
												<th>Actual Amount</th>
												<th>Local Conveyance</th>
												<th>Travel Expense</th>
												<th>Staff Welfare</th>
												<th>Telephone</th>
												<th>Purchases</th>
												<th>Other Work Expenses</th>
												<th>Miscellaneous</th>
												<th>ManagerApproval Status</th>
												<th>MangApproved Date</th>
												<th>Approved Amount</th>
												<th>Advance Paid</th>
												<th>Balance</th>
												<th>DirectorApproval Status</th>
												<th>Approved Director</th>
												<th>DirApproved Date</th>
												<th>AdminApproval Status</th>
												<th>Approved Admin </th>
												<th>AdminApproved Date </th>
											  
											</tr>
											<logic:iterate name="calMap" property="value" id="dateVO">
												<tr class="accordHead">
													<td><bean:write name="dateVO" property="sno" /></td>
													<td><bean:write name="dateVO" property="year" /></td>
													<td><bean:write name="dateVO" property="monthname" /></td>
													<td><bean:write name="dateVO" property="empname" /></td>
													<td><bean:write name="dateVO" property="managername" /></td>
													<td><bean:write name="dateVO" property="posteddate" /></td>
													<td><bean:write name="dateVO" property="totalamountclaimed" /></td>
													<td><bean:write name="dateVO" property="localconveyance" /></td>
													<td><bean:write name="dateVO" property="travelexpense" /></td>
													<td><bean:write name="dateVO" property="staffwelfare" /></td>
													<td><bean:write name="dateVO" property="telephoneexpense" /></td>
											<td><bean:write name="dateVO" property="purchases" /></td>
											<td><bean:write name="dateVO" property="otherworkexpenses" /></td>
											<td><bean:write name="dateVO" property="misllcellaneous" /></td>
											
											<td><bean:write name="dateVO" property="isMangApproved" /></td>
											<td><bean:write name="dateVO" property="mangApprovedDate" /></td>
											<td><bean:write name="dateVO" property="totalamountapproved" /></td>
											
											<td><bean:write name="dateVO" property="advancepaid" /></td>
											<td><bean:write name="dateVO" property="balance" /></td>
												
											<td><bean:write name="dateVO" property="isDireApproved" /></td>
											<td><bean:write name="dateVO" property="approvedDirename" /></td>
											<td><bean:write name="dateVO" property="direApprovedDate" /></td>	
									
										
											<td><bean:write name="dateVO" property="isAccntApproved" /></td>	
											<td><bean:write name="dateVO" property="approvedAccntsname" /></td>	
											<td><bean:write name="dateVO" property="accntApprovedDate" /></td>
													
											</tr>
												
						
												
											</logic:iterate>
										</table>
									</div>
								</logic:iterate><br/>
								
				<center>
					<input type="button" value="Download Expense Details"  id="downloadExpenseDetails"  class="submitbutton"/>
				</center>
			
			</logic:notEmpty>
					<logic:empty name="ExpensesListByProject" scope="request">
				   <span style="color: black; font-family: Segoe UI;font-size: 12px;"><bean:write name="nodata" scope="request" /> </span>
			    
				</logic:empty>
					</logic:present>
					<br></br>
					
			</center>		
					
</div>
			
								

</body>
</html>