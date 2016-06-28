
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Holiday Master</title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.effect.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script>
<script language="javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/Admin/HolidayMaster.js"></script>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
</head>

<body>

	<center>
		<div id="main">
		
			<div class="background" id="backgroung">

				<div class="backgroundDiv" id="backgroung">Holiday Master</div>
			
				<center>
				
						<div id="errordiv" class="error-box">
						<logic:present name="message" scope="request">	
							<span style="color: green; font-family: Segoe UI;"> <bean:write
										name="message" scope="request"/>
							</span>
							 </logic:present>
						   <logic:present name="errorMessage" scope="request">	
							<span style="color: red; font-family: Segoe UI;"> <bean:write
										name="errorMessage" scope="request"/>
							</span>
							 </logic:present>
						</div>
				
						
							<%-- <div id="errordiv" class="error-box">
								<logic:present name="errorMessage" scope="request">
								<span style="color: red; font-family: Segoe UI;"> <bean:write
										name="errorMessage" />
								</span>
								</logic:present>
								</div> --%>
							
                                 
				</center>
				<form action="holidayMaster.do" name="HolidayMaster">
					<fieldset style="width: 60%;">
					<br/>
						<table id="biometric" width="80%" cellspacing="0" cellpadding="5">
						
							<tr>
								<%-- <td>Department<font color="red">*</font> <br /> <select
									id="department" style="width: 50%">
										<option value="">--Select--</option>

										<logic:present name="departmentlist" scope="session">

											<option value="all">All</option>

											<logic:iterate id="department" name="departmentlist"
												scope="session">
												<option
													value='<bean:write name="department" property="depId"  />'>
													<bean:write name="department" property="depName" />
												</option>
											</logic:iterate>
										</logic:present>

								</select></td> --%>
										<td class="left">ClientName<font color="red">*</font></td>
										<td class="right"> <select id="clientSelectId" style="width:100%;">
										<option value="">---Select---</option>
										<logic:present name="clientList" scope="session">
											<logic:iterate id="clientId" name="clientList" scope="session">
												<option
													value='<bean:write name="clientId" property="clientCode"  />'>
													<bean:write name="clientId" property="clientName"/>
												</option>
											</logic:iterate>
										</logic:present>
								          </select><br /></td>
															
								<td class="left">Year<font color="red">*</font></td>
								<td class="right"><select id="holidayyear" style="width:100%;">
										<option value="">--Select--</option>
										<logic:present name="yearlist" scope="request">

											<logic:iterate id="acdyear" name="yearlist" scope="request">
												<option
													value='<bean:write name="acdyear" property="accademicYearCode" />'>
													<bean:write name="acdyear" property="year"/>
												</option>
											</logic:iterate>
										</logic:present>
								</select><br /></td>
                                 </tr>
                                 </table>
                          <table>
                          <br/>
                            <tr>
								<td><input type="button" id="searchholiday"
									class="submitbutton" value="Search" /></td>
							 </tr>
						</table>
					</fieldset>

					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="HOLINSERT" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">
									<%-- <input type="button" id="NewHoliday" class="submitbutton" value="NewHoliday" />
				                      <html:submit property="parameter"  styleClass="submitbutton">AddGroupHoliday</html:submit> --%>
									<input type="button" id="NewHoliday" class="submitbutton"
										value="Create Holiday" />
									<%-- <html:submit property="parameter"  styleClass="submitbutton" value="AddGroupHoliday">AddGroupHoliday</html:submit>  --%>
									<input type="button" id="groupHolidayId" class="submitbutton"
										value="Create Group of Holidays"
										onclick="return createGroupofHolidays()" />
								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>




				</form>


					<center>
                 		<logic:present name="holidayMasterVOList" scope="request">
							<display:table id="data" name="requestScope.holidayMasterVOList"
								requestURI="holidayMaster.do?method=getDistinctHolidayList"
								pagesize="20" cellpadding="5" cellspacing="5" size="20"
								style="bgcolor: RED;width:55%;"
								decorator="com.centris.decorator.HolidayMasterDecorator" class="view">

								<display:column property="date" title="Date " />
								<display:column property="weekDay"></display:column>
							<%-- 	<display:column property="depName" title="Department" /> --%>
								<display:column property="holidaysName" title="Holiday Reason" />
                                 <display:column property="clientName" title="Client Name" />
							<br><br>
							  <logic:present name="UserDetails" scope="session">
									<logic:iterate id="daymap" name="UserDetails"
										property="permissionmap" scope="session">
										<logic:equal value="HOLUPDATE" name="daymap" property="key">
											<logic:equal value="true" name="daymap" property="value">
												<display:column property="update" />
											</logic:equal>
										</logic:equal>
									</logic:iterate>
								</logic:present>

								<logic:present name="UserDetails" scope="session">
									<logic:iterate id="daymap" name="UserDetails"
										property="permissionmap" scope="session">
										<logic:equal value="HOLDELETE" name="daymap" property="key">
											<logic:equal value="true" name="daymap" property="value">
												<display:column property="delete" />
										</logic:equal>
										</logic:equal>
									</logic:iterate>
								</logic:present>
							</display:table>
						</logic:present>
					</center>
					<br>
				</div>
			</div>
	

		<div id="update-dialog" title="Holiday Master" style="display: none; font-size: 10px;background-color: #F2F0E7;">

			<form action="" name="ProjectRegistrationForm"
				id="ProjectRegistrationForm">
				<center>
					<br />
					<center><div id="error" class="error-box" style="display: none;width:70%;"></div></center>
					<table id="biometric" width="80%" cellpadding="5" cellspacing="0" class="dialogclass">

							<tr>
								<%-- <td>Department</td>
								<td><select name="departmentval" id="departmentval">
										<option value="">--Select--</option>
										<logic:present name="departmentlist" scope="session">
											<option value="all">All</option>
											<logic:iterate id="department" name="departmentlist"
												scope="session">
												<option
													value='<bean:write name="department" property="depId"  />'>
													<bean:write name="department" property="depName" />
												</option>
											</logic:iterate>
										</logic:present>
								</select></td> --%>
						
									<td class="leftindialog">ClientName<font color="red">*</font></td>
									<td class="rightindialog"> <select id="clientaddId" style="width: 101%;">
										<option value="">-----Select-----</option>
										<logic:present name="clientList" scope="session">
											<logic:iterate id="clientId" name="clientList" scope="session">
												<option
													value='<bean:write name="clientId" property="clientCode"  />'>
													<bean:write name="clientId" property="clientName"/>
												</option>
											</logic:iterate>
										</logic:present>
								</select></td>
						</tr><tr>
							    <td class="leftindialog">Year</td>
								<td class="rightindialog"><select id="holidayyearval" style="width: 101%;">
										<option value="">-----Select-----</option>
										<logic:present name="yearlist" scope="request">

											<logic:iterate id="acdyear" name="yearlist" scope="request">
												<option
													value='<bean:write name="acdyear" property="accademicYearCode"  />'>
													<bean:write name="acdyear" property="year" />
												</option>
											</logic:iterate>
										</logic:present>
								</select><br /></td>
						</tr><tr>
						    <td class="leftindialog">Date</td>
						    <td class="rightindialog"><input type="text" name="date" id="date" value=""
								readonly="readonly" placeholder="Click here" /></td>
						</tr><tr>			
							<td class="leftindialog">Weekday</td>
							<td class="rightindialog"><input type="text" name="weekday" id="weekday"
								readonly="readonly" value=""
								style="background-color: #fff !important" /></td>
							
					    </tr><tr>
					         <td class="leftindialog">HolidayReason</td>
							 <td class="rightindialog"><textarea name="holiday" id="holiday" rows="2" cols="22" style="font-size:12px !important;"></textarea></td></tr>
						</table>
				</center>
			</form>
		</div>
	</center>

	<center>
		<div id="update-dialog1" title="Holiday Master"	style="display: none; font-size: 10px;background-color: #F2F0E7;">
			<form action="" name="HolidayForm" id="holidayForm" action="">
			<center>
				<br />
					<center><div id="holidayerrordiv1" class="holidayerror-box" style="width:70%;display:none;"  ></div></center>
					<table  id="biometric" width="80%" cellpadding="5" cellspacing="0" class="dialogclass">
						<tr>
						<td class="leftindialog">ClientName<font color="red">*</font></td>
						<td class="rightindialog"> <select id="clientUpdateId" name="client" style="width:100%;">
										<option value="">----Select----</option>
										<logic:present name="clientList" scope="session">

											<logic:iterate id="clientId" name="clientList" scope="session">
												<option
													value='<bean:write name="clientId" property="clientCode"  />'>
													<bean:write name="clientId" property="clientName"/>
												</option>
											</logic:iterate>
										</logic:present>
								</select><br /></td>
						</tr><tr>			
                            <td  class="leftindialog">Date</td>
							<td class="rightindialog"><input type="text" name="date" id="date1"
								readonly="readonly" value=""
								style="background-color: #fff !important" /></td>
                   	</tr><tr>		
								<td class="leftindialog">Weekday</td>
								<td class="rightindialog"><input type="text" name="weekday" id="weekday1"
								readonly="readonly" class="textBoxInDialog" /></td>
                	</tr><tr>		
								<td class="leftindialog">Holiday Reason</td>
								<td class="rightindialog"><input type="text" name="holiday" id="holiday1" value="" /></td>
						</tr>
					<input type="hidden"  id="clienthidden" name="clienthidden"/>
					</table>

				<br></br>
          </center>
			</form>
			
		</div>
	</center>
<br>
</body>

</html>