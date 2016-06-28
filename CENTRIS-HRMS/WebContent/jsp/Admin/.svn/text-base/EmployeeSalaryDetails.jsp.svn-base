<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Employee salary details</title>
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
<script type="text/javascript" src="js/Admin/EmployeeSalaryDetails.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

</head>

<body>



	<div id="main" class="background"><br />

		<center>

			<div class="backgroundDiv" id="backgroung">Employee Salary Details</div>
			

			<form action="employeeSalaryDetailsAction.do?method=storeEmpSalaryDetails"
				name="EmpSalaryDetails" method="post" 
				onsubmit="return validateEmployeeSalaryDetails()">

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
					</div>
				</center>
				
				<input type="hidden" id="empstatus" value="<logic:present name="EMPSTATUS" scope="request"><bean:write name="EMPSTATUS" /></logic:present>"/>






				<div class="backgroungDIV" id="backgroung">
					<input type="hidden" id="doubleFormSubmition"
						name="doubleFormSubmition"
						value='<logic:present name="successMessage" scope="session"><bean:write name="doubleFormSubmition" /></logic:present>' />
					
					<table cellpadding="5" cellspacing="0" id="biometric" width="85%">

							<tr>
							
							<td colspan="5" class="head11" ><span class="head11" >Employee Details</span> </td>
							
							</tr> 
							
							<tr class="trc">
							
								<td class="left">Employee ID<font color="red">*</font></td>
								<td class="right"><input type="text" name="empid" id="empid" <logic:present name="EMPID" scope="request">value="<bean:write name="EMPID"/>"</logic:present> maxlength="20" readonly="readonly" /></td>
								<td class="left">Employee Name<font color="red">*</font></td>
								<td class="right"><input type="text" name="empname" id="empname" <logic:present name="EMPNAME" scope="request">value="<bean:write name="EMPNAME"/>"</logic:present> maxlength="50" readonly="readonly"/></td>
									
							</tr>
								
							<tr class="trc">
							
							 <%-- value=" <logic:present name="BANKNO" scope="request"><bean:write name="BANKNO"/></logic:present><logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="bankaccno" /></logic:present>" --%>
							
								<td class="left">Bank Acc Number<font color="red">*</font></td>
								<td class="right"><input type="text" name="bankaccno" id="bankaccno" maxlength="50" <logic:present name="accountNo" scope="request">value="<bean:write name="accountNo"/>"</logic:present> readonly="readonly"/></td>
								<td class="left">Employee PF Number<font color="red"></font></td>
								<td class="right"><input type="text" name="emppfno" id="emppfno" maxlength="50" value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="emppfno" /></logic:present>"/></td>
									
							</tr>
								
							<tr class="trc">
							
								<td class="left">Employee ESI Number<font color="red"></font></td>
								<td class="right"><input type="text" name="empesino" id="empesino" maxlength="50" value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="empesino" /></logic:present>"/></td>
								<td class="left">Payment Type<font color="red">*</font></td>
								<td class="right"><select id="paymenttype" name="paymenttype">
									<logic:present name="slarydetails" scope="request">
										<option
											value="<bean:write name="slarydetails" property="paymenttype" />"><bean:write
												name="slarydetails" property="paymenttype" /></option>
												
									</logic:present>
										<option value="">---Select Option---</option>
										<option value="Bank">Bank</option>
										<option value="Cash">Cash</option>
								</select></td>
									
							</tr>
								
							<tr class="trc">
							
								<td class="left">CTC per Month<font color="red">*</font></td>
								<td class="right"><input type="text" name="ctc" id="ctc" onchange="calculateEmpSalary()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="ctc" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
								<td class="left">Gross Salary<font color="red">*</font></td>
								<td class="right"><input type="text" name="grosssalary" id="grosssalary" onchange="calculateEmpSalary()"
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="grosssalary" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
									
							</tr>
							
							<tr class="trc">
							
								<td class="left">TotalPayable<font color="red">*</font></td>
								<td class="right"><input type="text" name="totpayable" id="totpayable" readonly="readonly"
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="totpayable" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
								
									
							</tr>
							
						</table>
						
						<br>

						<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
							
								<td colspan="5" class="head11" ><span class="head11" >Earnings</span> </td>
								
							</tr>
							
							<tr class="trc">
							
								<td class="left">Basic&DA<font color="red">*</font></td>
								<td class="right"><input type="text" id="basicda" name="basicda"  onchange="calculateEmpSalary()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="basicda" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
								<td class="left">HRA<font color="red">*</font></td>
								<td class="right"><input type="text" id="hra" name="hra"   onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="hra" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
									
							</tr>
							
							
							<tr class="trc">
							
								<td class="left">Conveyance<font color="red">*</font></td>
								<td class="right"><input type="text" id="conveyance" name="conveyance"  onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="conveyance" /></logic:present><logic:notPresent name="slarydetails" scope="request">800</logic:notPresent>"/>
								</td>
								<td class="left">Medical<font color="red">*</font></td>
								<td class="right"><input type="text" id="medical" name="medical"  onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="medical" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
									
							</tr>
							
							<tr class="trc">
							
								<td class="left">CCA<font color="red">*</font></td>
								<td class="right"><input type="text" id="cca" name="cca"  onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="cca" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
								<td class="left">Fix.Spl Allowances<font color="red">*</font></td>
								<td class="right"><input type="text" id="splallow" name="splallow"  onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="splallow" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
									
							</tr>
							
							<tr>
							
							
								<td class="left">Fix.Variable Pay<font color="red">*</font></td>
								<td><input type="text" id="variablepay" name="variablepay" onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="variablepay" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
								<td class="left">PF Empr<font color="red">*</font></td>
								<td class="right"><input type="text" id="epfempr" name="epfempr"   onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="epfempr" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
								
								
							
							</tr>
							
							<tr>
							
								<td class="left">ESI Empr<font color="red">*</font></td>
								<td><input type="text" id="eesiempr" name="eesiempr"   onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="eesiempr" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
							
								<td class="left">LTA<font color="red"></font></td>
								<td><input type="text" id="lta" name="lta"   onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="lta" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
							
								
							</tr>
							<tr>
							
							<td class="left">Total Earned<font color="red">*</font></td>
								<td class="right"><input type="text" id="totearned" name="totearned"   readonly="readonly"
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="totearned" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
								
							
							</tr>
						
							
						</table>
						
						<br>

					<table cellpadding="5" cellspacing="0" id="biometric" width="85%">
							<tr>
							
								<td colspan="5" class="head11" ><span class="head11" >Deductions</span> </td>
							
							</tr>
							
							
							<tr>
							
								<td class="left">PF Empr<font color="red">*</font></td>
								<td class="right"><input type="text" id="pfempr" name="pfempr"   onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="pfempr" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
							
								<td class="left">PF Empy<font color="red">*</font></td>
								<td class="right"><input type="text" id="pfempy" name="pfempy"   onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="pfempy" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
								
							</tr>
							
							
							<tr>
							
								<td class="left">ESI Empr<font color="red">*</font></td>
								<td class="right"><input type="text" id="esiempr" name="esiempr"   onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="esiempr" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
							
								<td class="left">ESI Empy<font color="red">*</font></td>
								<td class="right"><input type="text" id="esiempy" name="esiempy"  onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="esiempy" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
								
							</tr>
							
							
							
							<tr>
								<td class="left">PT<font color="red">*</font></td>
								<td class="right"><input type="text" id="ptax" name="ptax"   onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="ptax" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
							
								<td class="left">IncomeTax<font color="red">*</font></td>
								<td class="right"><input type="text" id="incometax" name="incometax"  onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="incometax" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
							
								

							</tr>
							
							
							<tr>
								<td class="left">Advance<font color="red">*</font></td>
								<td class="right"><input type="text" id="advance" name="advance"   onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="advance" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
							
							<td class="left">Loan<font color="red"></font></td>
								<td class="right"><input type="text" id="loan" name="loan"   onchange="calTotals()" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="loan" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
								

							</tr>
							
							<tr>
							
							<td class="left">Total Deductions<font color="red">*</font></td>
								<td class="right"><input type="text" id="totdeductions" name="totdeductions" readonly="readonly" 
									value="<logic:present name="slarydetails" scope="request"><bean:write name="slarydetails" property="totdeductions" /></logic:present><logic:notPresent name="slarydetails" scope="request">0.0</logic:notPresent>"/>
								</td>
							
								<td class="left">Is Applicable for Leave<font color="red">*</font></td>
								<td class="right">
								
									<logic:present name="slarydetails" scope="request">
										<logic:match name="slarydetails" property="leavedeductions"
											value="Y">
	
											<input type="radio" name="leavedeductions" id="leavedeductions" value="Y" checked>Yes
												<input type="radio" name="leavedeductions" id="leavedeductions" value="N">No
										
											</logic:match>
	
										<logic:match name="slarydetails" property="leavedeductions"
											value="N">
											<input type="radio" name="leavedeductions" id="leavedeductions" value="Y">Yes
											<input type="radio" name="leavedeductions" id="leavedeductions" value="N" checked>No
										</logic:match>
										
									</logic:present> 
									
									<logic:notPresent name="slarydetails" scope="request">
	
										<input type="radio" name="leavedeductions" id="leavedeductions"
											value="Y" checked>Yes
	                    
					                   <input type="radio" name="leavedeductions"
															id="leavedeductions" value="N"> No
										
										 </logic:notPresent>
								
								</td>
							
								
								
								
							</tr>
							
							<tr>
							<td class="left">Is Applicable for Late<font color="red">*</font></td>
							<td class="right">
										<logic:present
											name="slarydetails" scope="request">
											<logic:match name="slarydetails" property="latedeductions"
												value="Y">
		
												<input type="radio" name="latedeductions" id="latedeductions" value="Y" checked>Yes 
												 <input type="radio" name="latedeductions" id="latedeductions" value="N"> No
												 
											 </logic:match>
		
											<logic:match name="slarydetails" property="latedeductions" value="N">
												<input type="radio" name="latedeductions" id="latedeductions" value="Y">Yes 
												 <input type="radio" name="latedeductions" id="latedeductions" value="N" checked> No
											 </logic:match>
											 
											</logic:present>
											
											 <logic:notPresent name="slarydetails" scope="request">
											 
											<input type="radio" name="latedeductions" id="latedeductions" value="Y" checked>Yes
		                 				   <input type="radio" name="latedeductions" id="latedeductions" value="N">NO
		                   					
		                   					 </logic:notPresent>
								</td>
							
							<td class="left">Is Applicable for OT ?<font color="red">*</font></td>


							<td class="right">
							<logic:present name="slarydetails" scope="request">
										<logic:match name="slarydetails" property="overtime" value="Y">

											<input type="radio" name="overtime" id="overtime" value="Y"
												checked>Yes <input type="radio" name="overtime"
												id="overtime" value="N">No 
										</logic:match>

										<logic:match name="slarydetails" property="overtime" value="N">
											<input type="radio" name="overtime" id="overtime" value="Y">Yes
												<input type="radio" name="overtime" id="overtime" value="N"
												checked>No 
										</logic:match>
									</logic:present> <logic:notPresent name="slarydetails"
										scope="request">
										<input type="radio" name="overtime" id="overtime" value="Y"
											checked>Yes <input type="radio" name="overtime"
											id="overtime" value="N"> No 
									</logic:notPresent>
								</td>
								
							
							</tr>
						
							
						</table>
					
					</br>

						<center>

							<table>
								<tr class="odd">

									<td colspan="3"><center>
											<input type="submit" class="submitbutton" value="Register"
												class="button1" id="register" /> &nbsp;&nbsp;&nbsp; <input
												type="reset" value="Clear" class="submitbutton" id="clear" />
										</center></td>

								</tr>

							</table>
						</center>
					
				</div>

				<br />
			</form>
		</center>
	</div>


</body>



</html>
