<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title></title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/Employee/ExpenseDetails.css"></link>
<script type="text/javascript" src="js/Employee/ExpenseDetails.js"></script>
<script type="text/javascript"
	src="js/Employee/ExpenseDetailsValidate.js"></script>
<script type="text/javascript" src="js/common.js"></script>

</head>

<body>
	<div align="center" id="main">
	
	<div id="loader"
		style="position: absolute; top: 70%; left: 45%; display: none; ">
		<img src="images/loaderimage2.GIF" width="150px" height="150px" />
	</div>
	
		<div class="background" id="backgroung">
			<div class="backgroundDiv" id="backgroung">Monthly Expense
				Details</div>
          

			<div id="errordiv" class="error-box" align="center">
				<logic:present name="success" scope="request">
					<span style="color: green; font-family: Segoe UI;"> <bean:write
							name="success" />
					</span>
				</logic:present>
				
				<span style="color: green; font-family: Segoe UI;" id="sucessmessage"> </span>
				<input type="hidden"  name="loginuserMangPrevId" value="<logic:present name="LoginUsermangid" scope="request"><bean:write name="LoginUsermangid" scope="request"></bean:write></logic:present>" />
			</div>
			<input type="hidden" id="h_Name"
				value="<logic:present name="employee_Name" scope="request">
				<bean:write name="employee_Name" />
			</logic:present>" />
			<input type="hidden" id="h_Id"
				value="<logic:present name="employee_ID" scope="request">
				<bean:write name="employee_ID" />
			</logic:present>" />
			<input type="hidden" id="h_BioId"
				value="<logic:present name="employee_BioID" scope="request">
				<bean:write name="employee_BioID" />
			</logic:present>" />
			<%-- <input type="hidden" id="h_ProjName"
				value="<logic:present name="employee_ProjectName" scope="request">
				<bean:write name="employee_ProjectName" />
			</logic:present>">
			
			<input type="hidden" id="h_ProjId"
				value="<logic:present name="employee_ProjectId" scope="request">
				<bean:write name="employee_ProjectId" /> 
			</logic:present>">--%>
			<input type="hidden" id="h_MangId"
				value="<logic:present name="employee_MangId" scope="request">
				<bean:write name="employee_MangId" />
			</logic:present>">

			<input type="hidden" id="h_Desig"
				value="<logic:present name="employee_Desig" scope="request">
				<bean:write name="employee_Desig" />
			</logic:present>">
			<input type="hidden" id="h_ManagName"
				value="<logic:present name="employee_ManagerName" scope="request">
				<bean:write name="employee_ManagerName" />
			</logic:present>">
			<input type="hidden" id="h_Cont"
				value="<logic:present name="employee_Contact" scope="request">
				<bean:write name="employee_Contact" />
			</logic:present>">
			<input type="hidden" id="h_Email"
				value="<logic:present name="employee_Email" scope="request">
				<bean:write name="employee_Email" />
			</logic:present>">
			
				<div class="div1">
					<table id="biometric_1">
						<tr>
							<td class="name">Employee Name / ID</td>
							<td class="name">:</td>
							<td><label id="emp_Name"></label></td>
						</tr>
						<tr>
							<td class="name">Designation</td>
							<td class="name">:</td>
							<td><label id="emp_DesName"></label></td>
						</tr>
						<tr>
							<td class="name">Contact Number</td>
							<td class="name">:</td>
							<td><label id="emp_Num"></label></td>
						</tr>
						<tr>
							<td class="name">Email Id</td>
							<td class="name">:</td>
							<td><label id="emp_Mail"></label></td>
						</tr>
						<tr>
							<td class="name">Reporting Manager/Director</td>
							<td class="name">:</td>
							<td><label id="emp_ManName"></label></td>
						</tr>
					<!-- 	<tr>
							<td class="name">Project Name</td>
							<td class="name">:</td>
							<td align="left" valign="middle"><select name="projectId"
								id="projectId" class="projectId">
									<option value="">------Select--------</option>
							</select></td>
						</tr> -->
					<!-- 	<tr>
							<td class="name">ProjectRef Code</td>
							<td class="name">:</td>
							<td><label id="projectRefCode" name="projectRefCode"></label></td>
						</tr> -->
						<tr>
							<td class="name">Year</td>
							<td class="name">:</td>
							<td><select name="year" id="year" class="year_val"><option
										value="">-----Select---------</option>
									<logic:present name="ACC_YEAR" scope="request">
										<logic:iterate id="year" name="ACC_YEAR">
											<option value='<bean:write name="year" />'>
												<bean:write name="year" />
											</option>
										</logic:iterate>
									</logic:present></select></td>
						</tr>
						<tr>
							<td class="name">Month</td>
							<td class="name">:</td>
							<td><select name="month" id="month" class="month_val"><option
										value="">-----Select---------</option>
									<option value="01">JAN</option>
									<option value="02">FEB</option>
									<option value="03">MAR</option>
									<option value="04">APR</option>
									<option value="05">MAY</option>
									<option value="06">JUNE</option>
									<option value="07">JULY</option>
									<option value="08">AUG</option>
									<option value="09">SEP</option>
									<option value="10">OCT</option>
									<option value="11">NOV</option>
									<option value="12">DEC</option></select></td>
						</tr>

					</table>
					<br /> <br />
				</div>
				<div class="div11">
					<table id="biometric">
						
					<logic:notPresent name="monthlyExpensesvo" scope="request">
						<logic:empty name="monthlyExpensesvo" scope="request">
						<tr>
							<th style="color: black; font-size: 13px;">Particulars</th>
							<th style="color: black; font-size: 13px;">Sub Total Amount</th>
						</tr>
						<tr>
							<td>Local Conveyance Total (A)</td>
							<td><input type="text" id="local_totalAmount"
								readonly="readonly" value="0.00"></td>
						</tr>
						<tr>
							<td>Travel Expenses Total (B)</td>
							<td><input type="text" id="travel_totalAmount"
								readonly="readonly" value="0.00"></td>
						</tr>
						<tr>
							<td>Staff Welfare Total (C)</td>
							<td><input type="text" id="staff_totalAmount"
								readonly="readonly" value="0.00"></td>
						</tr>
						<tr>
							<td>Telephone (D)</td>
							<td><input type="text" id="telephone_totalAmount"
								readonly="readonly" value="0.00"></td>
						</tr>
						<tr>
							<td>Purchases (E)</td>
							<td><input type="text" id="purchase_totalAmount"
								readonly="readonly" value="0.00"></td>
						</tr>
						<tr>
							<td>Other Work Expenses (F)</td>
							<td><input type="text" id="other_totalAmount"
								readonly="readonly" value="0.00"></td>
						</tr>
						<tr>
							<td>Miscellaneous (G)</td>
							<td><input type="text" id="miscellaneous_totalAmount"
								readonly="readonly" value="0.00"></td>
						</tr>
						</logic:empty>
				</logic:notPresent>
				
					
			<logic:present name="monthlyExpensesvo" scope="request">			
				<logic:notEmpty name="monthlyExpensesvo" scope="request">
				   	<tr>
							<th style="color: black; font-size: 13px;">Particulars</th>
							<th style="color: black; font-size: 13px;">Sub Total Amount</th>
						</tr>
						<tr>
							<td>Local Conveyance Total (A)</td>
							<td><input type="text" id="local_totalAmount"
								readonly="readonly" value="<bean:write name="monthlyExpensesvo" property="localconveyance" ></bean:write>"></td>
						</tr>
						<tr>
							<td>Travel Expenses Total (B)</td>
							<td><input type="text" id="travel_totalAmount"
								readonly="readonly" value="<bean:write name="monthlyExpensesvo" property="travelexpenses" ></bean:write>"></td>
						</tr>
						<tr>
							<td>Staff Welfare Total (C)</td>
							<td><input type="text" id="staff_totalAmount"
								readonly="readonly" value="<bean:write name="monthlyExpensesvo" property="staffexpenses" ></bean:write>"></td>
						</tr>
						<tr>
							<td>Telephone (D)</td>
							<td><input type="text" id="telephone_totalAmount"
								readonly="readonly" value="<bean:write name="monthlyExpensesvo" property="telephoneexpense" ></bean:write>"></td>
						</tr>
						<tr>
							<td>Purchases (E)</td>
							<td><input type="text" id="purchase_totalAmount"
								readonly="readonly" value="<bean:write name="monthlyExpensesvo" property="purchaseexpense" ></bean:write>"></td>
						</tr>
						<tr>
							<td>Other Work Expenses (F)</td>
							<td><input type="text" id="other_totalAmount"
								readonly="readonly"  value="<bean:write name="monthlyExpensesvo" property="otherworkexpenses" ></bean:write>"></td>
						</tr>
						<tr>
							<td>Miscellaneous (G)</td>
							<td><input type="text" id="miscellaneous_totalAmount"
								readonly="readonly" value="<bean:write name="monthlyExpensesvo" property="miscellaneousexpenses" ></bean:write>"></td>
						</tr>
				
				
				</logic:notEmpty>
			</logic:present>			
						
				
						
					</table>
				</div>
				<div class="div2">
					<b>Total Amount</b> <br /> <br /> <input type="text"
						id="finalTotal" readonly="readonly" value="<logic:present name="monthlyExpensesvo" scope="request"><bean:write name="monthlyExpensesvo" property="totalamount" ></bean:write></logic:present>" />
				</div>
			
			<div id="details">
				<h3 class="accordHead" id="expenseCss">Local Conveyance (A)</h3>
				<div class="accBody">

					<table style="background: #fff; margin-right: 2%;" id="local">
					
						<tr>
							<td style="font-size: 13px; text-align: center; width: 13%;">Date</td>
							<td style="font-size: 13px; text-align: center; width: 13%;">Location</td>
							<td style="font-size: 13px; text-align: center; width: 13%;">From</td>
							<td style="font-size: 13px; text-align: center; width: 13%;">To</td>
							<td style="font-size: 13px; text-align: center; width: 13%;">Remarks</td>
							<td style="font-size: 13px; text-align: center; width: 15%;">Mode</td>
							<td style="font-size: 13px; text-align: center; width: 15%;">Amount</td>
							<td><span
								style="font: normal 12px Segoe UI; color: blue; text-decoration: underline; cursor: pointer;"
								onclick="addMoreLocal(this.form);"> Add More </span></td>
						   <td></td>
						</tr>
						
				     	<logic:present name="localconveyanceList" scope="request">
					       <logic:notEmpty name="localconveyanceList" scope="request">
					         <logic:iterate id="localiteratrid" name="localconveyanceList" scope="request">
					  
						<tr id="localId<bean:write name="localiteratrid" property="lcsno"></bean:write><bean:write name="localiteratrid" property="lcexpensecode"></bean:write>"><td><input name="local_con_Date"  onclick="return getDate();" class="mydate"  placeholder="Click here" type="text" readonly="readonly" size="17%"  maxlength="25"  value="<bean:write name="localiteratrid" property="lcdate"></bean:write>" /></td><td><input name="local_location" type="text"  maxlength="25" value="<bean:write name="localiteratrid" property="lc_location"></bean:write>" /></td><td><input name="local_from" type="text" maxlength="25" value="<bean:write name="localiteratrid" property="lc_from"></bean:write>" /></td><td><input name="local_to" type="text" maxlength="25" value="<bean:write name="localiteratrid" property="lc_to"></bean:write>" /></td><td><input name="local_remarks" type="text" maxlength="25" value="<bean:write name="localiteratrid" property="lc_ramrks"></bean:write>" /></td><td><input name="local_mode" type="text" maxlength="25" value="<bean:write name="localiteratrid" property="lc_mode"></bean:write>" /></td><td ><input name="local_amount" type="text" class="local_amount" onkeyup="return getLocalTotal()" maxlength="10" value="<bean:write name="localiteratrid" property="lc_amount"></bean:write>" /></td><td> <a href="javascript:void(0);" style="font: normal 12px Segoe UI;" onclick="removeLocal('<bean:write name="localiteratrid" property="lcsno"></bean:write><bean:write name="localiteratrid" property="lcexpensecode"></bean:write>');">Delete</a></td><td><input type="hidden" name="localsno" value="<bean:write name="localiteratrid" property="lcsno"></bean:write>" /></td></tr>
				        
					</logic:iterate>
					</logic:notEmpty>
					</logic:present>
						
					</table>
				</div>


				<h3 class="accordHead" id="expenseCss">Travel Expense (B)</h3>
				<div class="accBody">

					<table style="background: #fff; margin-right: 2%;" id="travel">
						<tr>
							<td style="font-size: 13px; text-align: center; width: 13%;">Date</td>
							<td style="font-size: 13px; text-align: center; width: 13%;">Location</td>
							<td style="font-size: 13px; text-align: center; width: 13%;">From</td>
							<td style="font-size: 13px; text-align: center; width: 14%;">To</td>
							<td style="font-size: 13px; text-align: center; width: 14%;">Remarks</td>
							<td style="font-size: 13px; text-align: center; width: 14%;">Mode</td>
							<td style="font-size: 13px; text-align: center; width: 14%;">Amount</td>
							<td><span
								style="font: normal 12px Segoe UI; color: blue; text-decoration: underline; cursor: pointer;"
								onclick="addMoreTravel(this.form);"> Add More </span></td>
							<td></td>
						</tr>
						 <logic:present name="travelExpenselist" scope="request">
					       <logic:notEmpty name="travelExpenselist" scope="request">
					         <logic:iterate id="traveliteratrid" name="travelExpenselist" scope="request">
					  
						<tr id="travelId<bean:write name="traveliteratrid" property="travexp_sno"></bean:write><bean:write name="traveliteratrid" property="travexpcode"></bean:write>"><td><input name="travel_con_Date"  onclick="return getDate();" class="mydate"  placeholder="Click here" type="text" readonly="readonly" size="17%"  maxlength="25" value="<bean:write name="traveliteratrid" property="travexp_date"></bean:write>" /></td><td><input name="travel_location" type="text"  maxlength="25" value="<bean:write name="traveliteratrid" property="travexp_location"></bean:write>" /></td><td><input name="travel_from" type="text" maxlength="25" value="<bean:write name="traveliteratrid" property="travexp_from"></bean:write>" /></td><td><input name="travel_to" type="text" maxlength="25" value="<bean:write name="traveliteratrid" property="travexp_to"></bean:write>" /></td><td><input name="travel_remarks" type="text" maxlength="25"  value="<bean:write name="traveliteratrid" property="travexp_ramrks"></bean:write>" /></td><td><input name="travel_mode" type="text" maxlength="25" value="<bean:write name="traveliteratrid" property="travexp_mode"></bean:write>" /></td><td ><input name="travel_amount" type="text" class="travel_amount" onkeyup="return getTravelTotal()" maxlength="10" value="<bean:write name="traveliteratrid" property="travexp_amount"></bean:write>" /></td><td> <a href="javascript:void(0);" style="font: normal 12px Segoe UI;" onclick="removeTravel('<bean:write name="traveliteratrid" property="travexp_sno"></bean:write><bean:write name="traveliteratrid" property="travexpcode"></bean:write>');">Delete</a></td><td><input type="hidden" name="travelsno" value="<bean:write name="traveliteratrid" property="travexp_sno"></bean:write>" /></td></tr>
				     
					</logic:iterate>
					</logic:notEmpty>
					</logic:present>
					</table>
				</div>

				<h3 class="accordHead" id="expenseCss">Staff Welfare (C)</h3>
				<div class="accBody">

					<table style="background: #fff; margin-right: 2%;" id="staff">
						<tr>
							<td style="font-size: 13px; text-align: center; width: 13%;">Location</td>
							<td style="font-size: 13px; text-align: center; width: 13%;">Date
								From</td>
							<td style="font-size: 13px; text-align: center; width: 13%;">Date
								To</td>
							<td style="font-size: 13px; text-align: center; width: 14%;">No.of
								Days</td>
							<td style="font-size: 13px; text-align: center; width: 14%;">As
								Single / Team</td>
							<td style="font-size: 13px; text-align: center;width: 14%;">Type of Activity</td>
							<td style="font-size: 13px; text-align: center;width: 14%;">Amount</td>
							<td><span
								style="font: normal 12px Segoe UI; color: blue; text-decoration: underline; cursor: pointer;"
								onclick="addMoreStaff(this.form);"> Add More </span></td>
							<td></td>
						</tr>
				<logic:present name="staffExpenselist" scope="request">
				<logic:notEmpty name="staffExpenselist" scope="request">
					    <logic:iterate id="staffiterateid" name="staffExpenselist" scope="request">
					  
						<tr id="staffId<bean:write name="staffiterateid" property="staff_sno"></bean:write><bean:write name="staffiterateid" property="staff_expensecode"></bean:write>"><td><input name="staff_location" type="text"  maxlength="25" value="<bean:write name="staffiterateid" property="staff_location"></bean:write>"/></td><td><input name="staff_from_Date"  onclick="return getDate();" class="mydate"  placeholder="Click here" type="text" readonly="readonly" size="17%"  maxlength="25" value="<bean:write name="staffiterateid" property="staff_datefrom"></bean:write>" /></td><td><input name="staff_to_Date"  onclick="return getDate();" class="mydate"  placeholder="Click here" type="text" readonly="readonly" size="17%"  maxlength="25" value="<bean:write name="staffiterateid" property="staff_dateto"></bean:write>" /></td><td><input name="staff_noOfDays" type="text" maxlength="25" value="<bean:write name="staffiterateid" property="staff_noofdays"></bean:write>"/></td><td><input name="staff_singleOrTeam" type="text" maxlength="25" value="<bean:write name="staffiterateid" property="staff_assingleteam"></bean:write>"/></td><td><input name="staff_allowance" type="text" maxlength="25" value="<bean:write name="staffiterateid" property="staff_allowance"></bean:write>"/></td><td ><input name="staff_amount" type="text" class="staff_amount" onkeyup="return getStaffTotal()" maxlength="10" value="<bean:write name="staffiterateid" property="staff_amount"></bean:write>" /></td><td> <a href="javascript:void(0);" style="font: normal 12px Segoe UI;" onclick="removeStaff('<bean:write name="staffiterateid" property="staff_sno"></bean:write><bean:write name="staffiterateid" property="staff_expensecode"></bean:write>');">Delete</a></td><td><input type="hidden" name="staffsno" value="<bean:write name="staffiterateid" property="staff_sno"></bean:write>" /></td></tr>
				
					</logic:iterate>
					</logic:notEmpty>
					</logic:present>
					</table>
				</div>

				<h3 class="accordHead" id="expenseCss">Telephone (D)</h3>
				<div class="accBody">

					<table style="background: #fff; margin-right: 2%;" id="telephone">
						<tr>
							<td style="font-size: 13px; text-align: center;width: 20%;">Date</td>
							<td style="font-size: 13px; text-align: center;width: 25%;">Telephone
								No</td>
							<td style="font-size: 13px; text-align: center;width: 25%;">Location</td>
							<td style="font-size: 13px; text-align: center;width: 25%;">Amount</td>
							<td><span
								style="font: normal 12px Segoe UI; color: blue; text-decoration: underline; cursor: pointer;"
								onclick="addMorePhone(this.form);"> Add More </span></td>
							<td></td>	
						</tr>
						
			<logic:present name="telephoneExpenselist" scope="request">
				<logic:notEmpty name="telephoneExpenselist" scope="request">
					    <logic:iterate id="telephoneiterateid" name="telephoneExpenselist" scope="request">
					  
				<tr id="telephone<bean:write name="telephoneiterateid" property="teleexp_sno"></bean:write><bean:write name="telephoneiterateid" property="teleexpcode"></bean:write>"><td><input name="telephone_Date"  onclick="return getDate();" class="mydate" placeholder="Click here" type="text" readonly="readonly" size="20%"  maxlength="25" value="<bean:write name="telephoneiterateid" property="teleexp_date"></bean:write>" /></td><td><input name="telephone_phone" type="text" maxlength="10" value="<bean:write name="telephoneiterateid" property="teleexp_mobileno"></bean:write>" /></td><td><input name="telephone_location" type="text"  maxlength="25" value="<bean:write name="telephoneiterateid" property="teleexp_location"></bean:write>" /></td><td ><input name="telephone_amount" type="text" class="telephone_amount" onkeyup="return getTelephoneTotal()" maxlength="10" value="<bean:write name="telephoneiterateid" property="teleexp_amount"></bean:write>" /></td><td> <a href="javascript:void(0);" style="font: normal 12px Segoe UI;" onclick="removeTelephone('<bean:write name="telephoneiterateid" property="teleexp_sno"></bean:write><bean:write name="telephoneiterateid" property="teleexpcode"></bean:write>');">Delete</a></td><td><input type="hidden" name="telephonesno" value="<bean:write name="telephoneiterateid" property="teleexp_sno"></bean:write>" /></td></tr>
					</logic:iterate>
					</logic:notEmpty>
					</logic:present>
					</table>
				</div>

				<h3 class="accordHead" id="expenseCss">Purchases (E)</h3>
				<div class="accBody">

					<table style="background: #fff; margin-right: 2%;" id="purchase">
						<tr>
							<td style="font-size: 13px; text-align: center;width: 20%;">Date</td>
							<td style="font-size: 13px; text-align: center;width: 25%;">Bill No</td>
							<td style="font-size: 13px; text-align: center;width: 25%;">Particulars</td>
							<td style="font-size: 13px; text-align: center;width: 25%;">Amount</td>
							<td><span
								style="font: normal 12px Segoe UI; color: blue; text-decoration: underline; cursor: pointer;"
								onclick="addMorePurchases(this.form);"> Add More </span></td>
						    <td></td>			
						</tr>
			<logic:present name="purchaseExpenselist" scope="request">
				<logic:notEmpty name="purchaseExpenselist" scope="request">
					    <logic:iterate id="purchaseiterateid" name="purchaseExpenselist" scope="request">
					  
			<tr id="purchase<bean:write name="purchaseiterateid" property="purchaseexp_sno"></bean:write><bean:write name="purchaseiterateid" property="purchase_expensecode"></bean:write>"><td><input name="purchase_Date"  onclick="return getDate();" class="mydate" placeholder="Click here" type="text" readonly="readonly" size="20%"  maxlength="25" value="<bean:write name="purchaseiterateid" property="purchaseexp_date"></bean:write>"/></td><td><input name="purchase_billno" type="text" maxlength="25" value="<bean:write name="purchaseiterateid" property="purchaseexp_billno"></bean:write>" /></td><td><input name="purchase_particular" type="text"  maxlength="25" value="<bean:write name="purchaseiterateid" property="purchaseexp_particulars"></bean:write>"  /></td><td ><input name="purchase_amount" type="text" class="purchase_amount" onkeyup="return getPurchaseTotal()" maxlength="10" value="<bean:write name="purchaseiterateid" property="purchaseexp_amount"></bean:write>" /></td><td> <a href="javascript:void(0);" style="font: normal 12px Segoe UI;" onclick="removePurchase('<bean:write name="purchaseiterateid" property="purchaseexp_sno"></bean:write><bean:write name="purchaseiterateid" property="purchase_expensecode"></bean:write> ');">Delete</a></td><td><input type="hidden" name="purchasesno" value="<bean:write name="purchaseiterateid" property="purchaseexp_sno"></bean:write>" /></td></tr>
				
					</logic:iterate>
					</logic:notEmpty>
					</logic:present>
					</table>
				</div>

				<h3 class="accordHead" id="expenseCss">Other Work Expenses (F)</h3>
				<div class="accBody">

					<table style="background: #fff; margin-right: 17%;" id="other">
						<tr>
							<td style="font-size: 13px; text-align: center;width: 32%;">Date</td>
							<td style="font-size: 13px; text-align: center;width: 32%;">Description</td>
							<td style="font-size: 13px; text-align: center;width: 30%;">Amount</td>
							<td><span
								style="font: normal 12px Segoe UI; color: blue; text-decoration: underline; cursor: pointer;"
								onclick="addMoreOther(this.form);"> Add More </span></td>
							<td></td>	
						</tr>
				<logic:present name="otherWorkExpenselist" scope="request">
				<logic:notEmpty name="otherWorkExpenselist" scope="request">
					    <logic:iterate id="otherworkiterateid" name="otherWorkExpenselist" scope="request">
					  
			<tr id="other<bean:write name="otherworkiterateid" property="sno"></bean:write><bean:write name="otherworkiterateid" property="other_expensecode"></bean:write>"><td><input name="other_Date"  onclick="return getDate();" class="mydate" placeholder="Click here" type="text" readonly="readonly" size="20%"  maxlength="25" value="<bean:write name="otherworkiterateid" property="date"></bean:write>" /></td><td><input name="other_description" type="text"  maxlength="25" value="<bean:write name="otherworkiterateid" property="description"></bean:write>" /></td><td ><input name="other_amount" type="text" class="other_amount" onkeyup="return getOtherTotal()" maxlength="10" value="<bean:write name="otherworkiterateid" property="amount"></bean:write>" /></td><td> <a href="javascript:void(0);" style="font: normal 12px Segoe UI;" onclick="removeOther('<bean:write name="otherworkiterateid" property="sno"></bean:write><bean:write name="otherworkiterateid" property="other_expensecode"></bean:write> ');">Delete</a></td><td><input type="hidden" name="otherworksno" value="<bean:write name="otherworkiterateid" property="sno"></bean:write>" /></td></tr>
				
					</logic:iterate>
					</logic:notEmpty>
					</logic:present>
					</table>
				</div>
				<h3 class="accordHead" id="expenseCss">Miscellaneous (G)</h3>
				<div class="accBody">

					<table style="background: #fff; margin-right: 17%;"
						id="miscellaneous">
						<tr>
							<td style="font-size: 13px; text-align: center;width: 32%;">Date</td>
							<td style="font-size: 13px; text-align: center;width: 32%;">Description</td>
							<td style="font-size: 13px; text-align: center;width: 30%;">Amount</td>
							<td><span
								style="font: normal 12px Segoe UI; color: blue; text-decoration: underline; cursor: pointer;"
								onclick="addMoreMiscellaneous(this.form);"> Add More </span></td>
							<td></td>		
						</tr>
						
			<logic:present name="miscellaneousExpenselist" scope="request">
				<logic:notEmpty name="miscellaneousExpenselist" scope="request">
					    <logic:iterate id="miscellaneousiterateid" name="miscellaneousExpenselist" scope="request">
					  
			  <tr id="miscellaneous'<bean:write name="miscellaneousiterateid" property="sno"></bean:write><bean:write name="miscellaneousiterateid" property="miscellaneous_expensecode"></bean:write>"><td><input name="miscellaneous_Date"  onclick="return getDate();" class="mydate" placeholder="Click here" type="text" readonly="readonly" size="20%"  maxlength="25" value="<bean:write name="miscellaneousiterateid" property="date"></bean:write>" /></td><td><input name="miscellaneous_description" type="text"  maxlength="25" value="<bean:write name="miscellaneousiterateid" property="description"></bean:write>" /></td><td ><input name="miscellaneous_amount" type="text" class="miscellaneous_amount" onkeyup="return getMiscellaneousTotal()" maxlength="10" value="<bean:write name="miscellaneousiterateid" property="amount"></bean:write>" /></td><td> <a href="javascript:void(0);" style="font: normal 12px Segoe UI;" onclick="removeMiscellaneous('<bean:write name="miscellaneousiterateid" property="sno"></bean:write><bean:write name="miscellaneousiterateid" property="miscellaneous_expensecode"></bean:write> ');">Delete</a></td><td><input type="hidden" name="miscellaneoussno" value="<bean:write name="miscellaneousiterateid" property="sno"></bean:write>" /></td></tr>
				
					</logic:iterate>
					</logic:notEmpty>
					</logic:present>
					</table>
				</div>
				<br /> <br /> <input type="button" value="Upload Expense Details" id="validate"
					class="submitbutton">
			</div>
		</div>
	</div>
	<input type="hidden" id="hiddenproject" value='<logic:present name="projectcode" scope="request"><bean:write name="projectcode" scope="request"></bean:write></logic:present>'></input>
<input type="hidden" id="hiddenmonth" value='<logic:present name="monthval" scope="request"><bean:write name="monthval" scope="request"></bean:write></logic:present>'></input>
<input type="hidden" id="hiddenyear" value='<logic:present name="yearval" scope="request"><bean:write name="yearval" scope="request"></bean:write></logic:present>'></input>
<input type="hidden" id="hiddenprojectRef" value='<logic:present name="projectRefcode" scope="request"><bean:write name="projectRefcode" scope="request"></bean:write></logic:present>'></input>
<input type="hidden" id="hiddenExpenseCode"  name="hiddenexpensecode"  value='<logic:present name="ExpenseCode" scope="request"><bean:write name="ExpenseCode" scope="request"></bean:write></logic:present>'></input>


</body>
</html>