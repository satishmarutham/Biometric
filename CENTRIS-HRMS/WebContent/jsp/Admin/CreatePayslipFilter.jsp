<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
 <%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>create payslip</title>
	

		<link rel="stylesheet" type="text/css" href="JQUERY/css/smoothness/jquery-ui-1.9.2.custom.css" />
		<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
			<script language="javascript" src="js/common.js"></script>
			<link rel="stylesheet" href="css/common.css"></link>
			<script language="javascript" src="js/createpayslip.js"></script>
			
	</head>
	<body>
	<br/>
<br/>
<br/>
	<div id="imageDiv" style="z-index:2;background:transparent;display:none;position:absolute;top:0px;left:0px;"></div>
	     	<div class="background" id="backgroung">
    	<center>
	
		<div class="backgroundDiv" id="backgroung">Create Payslip</div>
		
		
		
				
						<div id="errordiv" class="error-box" align="center">
							
							<logic:present name="serverMessage" scope="request">
								<span style="color: green; font-family: Segoe UI;">
									<bean:write name="serverMessage"/>
								</span>
							</logic:present>
						</div>
						
					</center>
					
					
						<form action="createpayslip.do?parameter=createPayslip"  name="createpayslip" method="post">

	

			<div class="backgroungDIV" id="backgroung">
			<center>

				<table cellpadding="8" cellspacing="5" id="biometric" width="40%" align="center">

					<tr class="left" >
					
				
							<td align="left" class="trd">Select Department<font color="red">*</font><br />

						<select name="dept" id="dept">
						<option value="">---Select Option---</option>
						<option value="%%">All</option>
						<logic:present name="deptlist" scope="request">
						<logic:iterate id="deptlistid" name="deptlist" scope="request">
						<option value="<bean:write name="deptlistid" property="depId"/>"><bean:write name="deptlistid" property="depName"/></option>
						</logic:iterate>
						</logic:present>
						
						</select>
					</td>
							<td align="left" class="trd">Select Month<font color="red">*</font><br />
						<select name="month" id="month">
							<option value="">---Select Option---</option>
						<option value="1,January">January</option>
						<option value="2,February">February</option>
						<option value="3,March">March</option>
						<option value="4,April">April</option>
						<option value="5,May">May</option>
						<option value="6,June">June</option>
						<option value="7,July">July</option>
						<option value="8,August">August</option>
						<option value="9,September">September</option>
						<option value="10,October">October</option>
						<option value="11,November">November</option>
						<option value="12,December">December</option>
						</select>
					</td>	
							<td align="left" class="trd">Select Year<font color="red">*</font><br />
						<select name="year" id="year">
							<option value="">---Select Option---</option>
							<option value="2013">2013</option>
							<option value="2014">2014</option>
							<option value="2015">2015</option>
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
						</select>
					</td>
						</tr>
						
						<tr class="left">
				<td   style="padding-top: 10px;text-align: center;" colspan="4">
				<input type="submit"  value="CreatePayslip" class="submitbutton" onclick="return validatePayRoleProcess()"/>
			</td>
			</tr>
						
		</table>
						
			
			
			</center>		
		
			</div>

		</form>
		
	 </div> 
	 	
</body>
</html>