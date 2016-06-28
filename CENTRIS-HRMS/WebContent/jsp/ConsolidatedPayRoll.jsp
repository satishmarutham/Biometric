<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
 <%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display"%>

<% String username = (String)session.getAttribute("username");
	if(username== null){
		%>
		
		<jsp:forward page="login.jsp"></jsp:forward>
			
		 <%
	}else{
		

	}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<link rel="shortcut icon" href="images/favicon.ico">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>PayRole Selection</title>
		<link rel="stylesheet" type="text/css" href="css/weekoff.css" />
		<link rel="stylesheet" type="text/css" href="view.css" />
		<link rel="stylesheet" type="text/css" href="JQUERY/css/smoothness/jquery-ui-1.9.2.custom.css" />
	<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="js/PayRollProcess.js"></script>
	</head>
	<body>
		<jsp:include page="header_menu.jsp"></jsp:include>               
     	<br></br><br/> <br/>
		<center> 
		<font style="font-family: sans-serif; font-weight: bolder; color: #000000; font-size: 17px;">PAY ROLL PROCESS</font>
		</center><br></br>
			 <logic:present name="latestSearch" scope="request">
	 <table id="latestSearch" style="width:80%; margin:0 auto; height:30px;border-spacing:0px; ">
		 <tr style="background-color: #D1D9DF;height: 40px;font-weight: bold;"><td align="center" valign="top" colspan="10">Previous Batch Run</td></tr>
	 <tr style="background-color: #D1D9DF;">  <th align="right">Category Name: </th><td id="category"><bean:write name="latestSearch" property="categoryName"/></td><th align="right">Payment Type: </th><td id="paymentType"><bean:write name="latestSearch" property="paymentType"/></td> <th align="right">Shift Name: </th><td  id="shift"> <bean:write name="latestSearch" property="shiftName"/></td>   <th align="right">Start date: </th><td  id="sDate"><bean:write name="latestSearch" property="startDate"/></td>   
	 <th align="right">End date: </th><td  id="eDate"><bean:write name="latestSearch" property="endDate"/></td>  </tr>
	  </table>
	</logic:present>
		<br/>
		
		<p id="alertMessage" style="color:red;width:100%;text-align: center;"><logic:present name="serverMessage" scope="request"> <bean:write name="serverMessage"/></logic:present></p>
		 <html:form action="/consolidatedpayRoll" method="post"  onsubmit="return validatePayRoleProcess();">
		<html:hidden property="method" value="getFlatpayRollProcess"/>
		<input type="hidden" id="mailMessage" value='<logic:present name="sendMessage" scope="request"> <bean:write name="sendMessage"/></logic:present>'/>
		<table align="center" id="biometric">
			<tr>
			<td>Select Category<br/>
			<select id="empCategory" name="categoryName" style="width: 150px;">
			<option value="Contract">Contract</option>
			<option value="Permanent">Permanent</option>
			</select>
			
			</td>
			<td>Select Payment Type<br/>
			<select id="payment" name="paymentType" style="width: 150px;">
			<option value="Flat">Flat</option>
			<option value="Hourly">Hourly</option>
			</select>
			</td>
				<td class="USER_LOCATION">Select Location<br/>
					<select class="userLocationId" name="Location"></select>
				</td>
			<td>Select Shift<br/>
			<select id="empShift" name="shiftId" class="shiftClassForAdmin">
			<option value="All">All</option>
			<logic:present name="empShiftList" scope="session">
			<logic:iterate id="shift" name="empShiftList" scope="session">
				<option value='<bean:write name="shift" property="shiftId" />,<bean:write name="shift"  property="shiftName"/> '><bean:write name="shift"  property="shiftName"/></option>
			</logic:iterate>
			</logic:present>
			
			</select>
			
			</td>
			
			<td>Start date<br/>
			<input type="text" id="startDate" name="startDate" readonly="readonly"/>
			</td>
			<td>End date<br/>
			<input type="text" id="endDate" name="endDate" readonly="readonly"/>
			</td>
			</tr>

			</table>
			<br></br>
			<table align="center">
			<tr>
				<td colspan="4" align="center">
					<html:submit  value="Submit" styleClass="button1" />
				</td>
			</tr>
		</table>
	 </html:form>
	 <logic:present name="payRollSearch" property="categoryName" scope="session">
	 <table id="searchinfo" style="width:80%; margin:0 auto; height:30px;border-spacing:0px; ">
	   <tr style="background-color: #D1D9DF;height: 40px;font-weight: bold;"><td align="center" valign="top" colspan="10">Current Search</td></tr>
	 <tr style="background-color: #D1D9DF;">  <th align="right">Category Name: </th><td id="serchedCategory"><bean:write name="payRollSearch" property="categoryName"/></td><th align="right">Payment Type: </th><td id="serchedCategory"><bean:write name="payRollSearch" property="paymentType"/></td> <th align="right">Shift Name: </th><td> <bean:write name="payRollSearch" property="shiftName"/></td>   <th align="right">Start date: </th><td><bean:write name="payRollSearch" property="startDate"/></td>   
	 <th align="right">End date: </th><td><bean:write name="payRollSearch" property="endDate"/></td>  </tr>
	  </table>
	
	</logic:present>
	
	<div id="imageDiv" style="z-index:2;background:transparent;display:none;position:absolute;top:0px;left:0px;"></div>
	
	 <div style="width:100%;">
	<display:table export="false" id="depRecords" class="displayTableClass" style="font-family: Segoe UI;width:100%;"  name="requestScope.payRollList" decorator="com.centris.decorator.PaySlipDecorator" requestURI="/consolidatedpayRoll.do?method=getFlatpayRollProcess"   pagesize="20" >
			<display:column property="empid" title="Emp Id"        style="text-align:center;" sortable="false"  />
			<display:column property="empname"  title="Emp Name"    style="text-align:center;" sortable="false"/>
			<display:column property="openPDF" title="View" style="text-align:center;" sortable="false"/>
			<display:column property="sendMail"   title="Email"          style="text-align:center;" sortable="false"/>
			<display:column property="savePDF"     title="Download PaySlip"            style="text-align:center;" sortable="false"/>
			<display:column property="mailStatus"     title="Mail Status"            style="text-align:center;" sortable="false"/>
			<display:column property="externalOpenPDF" title="View" style="text-align:center;" sortable="false"/>
			<display:column property="externalSendMail"   title="EMail"          style="text-align:center;" sortable="false"/>
			<display:column property="externalSavePDF"     title="Download PaySlip"            style="text-align:center;" sortable="false"/>
			<display:column property="externalMailStatus"     title="Mail Status"            style="text-align:center;" sortable="false"/>
		</display:table>
	</div>
		<!-- <br></br><br></br>
		<div style="width:100%;text-align: center;">
		<input type="button" id="createPaySlipId" style="width:300px;height:50px;font-size: 15px;" class="button1" value="Process For PaySlip" onclick="createPaySlip()"/>
		</div> -->
		<br></br><br></br><br></br><hr></hr>
		<jsp:include page="footer.jsp"></jsp:include>
	</body>
</html>