<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Leave Bank</title>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/Admin/Leavebank.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>

</head>

<BODY>
	
	<div class="background" id="backgroung">


		<form name="leave" id="leave" action="GetLeaves.do">
			<input type="hidden" id="addLeave" name="parameter" />

			<center>
				<div class="backgroundDiv" id="backgroung">Leave Bank</div>
				
				<div id="errordiv" class="error-box" align="center">

					<logic:present name="addstatus" scope="request">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="addstatus" />
						</span>
					</logic:present>
					<logic:present name="updatestatus" scope="request">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="updatestatus" />
						</span>
					</logic:present>
					<logic:present name="deletestatus" scope="request">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="deletestatus" />
						</span>
					</logic:present>
				</div>

				
				<br/>
					<table cellpadding="5" cellspacing="0" id="biometric" width="80%;">
						<tr>
							<td class="left">Accademic_Year<font color="red">*</font></td>
							<td class="right"><select id="accyear" name="accyear" style="width:100%;">
								<option value=" ">----select----</option>
									<logic:present name="accyear" scope="request">
										<logic:iterate id="accyear" name="accyear" scope="request">
											<option
												value='<bean:write name="accyear" property="accyearcode"/>'>
												<bean:write name="accyear" property="accyear" />
											</option>
										</logic:iterate>
									</logic:present>
							</select></td>
					
					
					        <td class="left">SL<font color="red">*</font></td>
							<td class="right"><input type="text" name="sl" id="sl" onblur="calculateTotalleaves()"/></td>
						
						</tr><tr>		
							
							 <td class="left">PL<font color="red">*</font></td>
							<td class="right"><input type="text" name="pl" id="pl" onblur="calculateTotalleaves()"/></td>
							
							<td class="left">CL<font color="red">*</font></td>
							<td class="right"><input type="text" name="cl" id="cl" onblur="calculateTotalleaves()"/></td>
					
						
						</tr><tr>
						
							<td class="left">Total_Leaves<font color="red">*</font></td>
							<td class="right"><input type="text" name="totalleaves" id="totalleaves" readonly="readonly"/></td>
							<td class="left">Allowed_Per_Month<font color="red">*</font></td>
							<td class="right"><input type="text" name="permonth" id="permonth" /></td>
						</tr>
					</table>
						<br/>
				
				<input type="hidden" id="sno" name="sno" />  
				
				 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="LEAVEBANKINSERT" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				 
				 <input type="button" value="Add"  class="submitbutton" onclick="AddLeave()" />
				 <input type="reset" value=" Clear " class="submitbutton" onclick="cleardata()" />
		
				</logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
	 			 
	 			 
	 			 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="LEAVEBANKUPDATE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				 
				  <input type="button" value="  Edit  " class="submitbutton" onclick="editLeave()" />
				  <input type="button" value=" Update " class="submitbutton" onclick="updateLeave()" />
		
				</logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
				
				 <logic:present name="UserDetails" scope="session">
				 <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="LEAVEBANKDELETE" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
				 
				   <input type="button" value=" Delete " class="submitbutton" onclick="deleteLeave()" />
		
				</logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
				
				
				
				
				

			</center>

		</form>



		<center>
			
				<logic:present name="leavelist" scope="request">


					<display:table id="leavelist" name="leavelist" export="false"  style="width:55%;"
						requestURI="/GetLeaves.do?parameter=getLeave" pagesize="25" class="view">
						<display:column
							title="<input type='checkbox' name='selectall' onClick='selectAll()' />">
							<input type="checkbox" name="selectBox" value="${leavelist.sno}">
								</> 
						</display:column>

						<display:column property="accyear" title="AccademicYear " />
						<display:column property="sl"	title="SL" />
						<display:column property="pl"	title="PL" />
                        <display:column property="cl"	title="CL" />
						<display:column property="total_leaves" title="Total Leaves " />
						<display:column property="allowed_per_month"
							title="Allowed Per Month" />
                      

					</display:table>
					
					

				</logic:present><br/>
			</center>
			</div>






</BODY>



</html>
