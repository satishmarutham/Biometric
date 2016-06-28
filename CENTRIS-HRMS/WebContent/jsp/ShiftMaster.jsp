<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Shift Master</title>
<script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script>
<script language="javascript" src="js/shiftMaster.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>



</head>
<body>

	<div id="main">

		<div>
			<form name="frm_usercreation" method="post">
				<input type="hidden" name='ai_shift_start_time' value="" /> <input
					type="hidden" name='ai_shift_end_time' value='' /> <input
					type="hidden" name='ai_shift_ltoc' value='' /> <input
					type="hidden" name='ai_shift_etog' value='' /> <input
					type="hidden" name='ai_shift_ltoc_gc' value='' /> <input
					type="hidden" name='ai_shift_etog_gc' value='' /> <input
					type="hidden" name='ai_shift_ltoc_no_exec' value='' /> <input
					type="hidden" name='ai_shift_etog_no_exec' value='' /> <input
					type="hidden" name='ai_shift_ltoc_ld' value='' /> <input
					type="hidden" name='ai_shift_etog_ld' value='' /> <input
					type="hidden" name='ai_shift_mm' value='00' /><input type="hidden"
					name="ai_shift_id" value='' />

				<center></center>
				<br /> <br /> <br />
				<center>


            

					



				</center>
				<div class="background" id="backgroung">
					<center>
						<div class="backgroundDiv" id="backgroung">Shift Master</div>
						<div id="errordiv" class="error-box">
						<logic:present name="SHIFT_MESSAGE" scope="request">
							<span style="color: green; font-family: Segoe UI;"> <bean:write
									name="SHIFT_MESSAGE" />
							</span>
						
					</logic:present>
						
						</div>
					</center>
					<br />
					<center>
						<table cellpadding="1" cellspacing="1" id="biometric" width="100%">

							<tr>

								<td align="left" class="trd">Shift Name<font color="red">*</font>
									<br /> <input type="text" name="ai_shift_name" value=""
									size="15" maxlength='15' id="shiftname" /></td>
								<td align="left" class="trd">Start Time<font color="red">*</font>
									<br /> <select name="ai_shift_start_t" class="shift_select">
										<option value="00" selected="selected">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<%
											for (int i = 10; i <= 23; i++) {
										%>
										<option value="<%=i%>"><%=i%></option>
										<%
											}
										%>
								</select>Hrs <select name="ai_shift_start_m" class="shift_select">
										<option value="00" selected="selected">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<%
											for (long k = 10; k <= 59; k++) {
										%>
										<option value="<%=k%>"><%=k%></option>

										<%
											}
										%>
								</select>Min <!-- seconds creation --> <!--  --></td>
								<td align="left" class="trd">End Time<font color="red">*</font>
									<br /> <select name="ai_shift_end_t" class="shift_select">
										<option value="00" selected="selected">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<%
											for (int i = 10; i <= 23; i++) {
										%>
										<option value="<%=i%>"><%=i%></option>
										<%
											}
										%>
								</select>Hrs <select name="ai_shift_end_m" class="shift_select">
										<option value="00" selected="selected">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<%
											for (long k = 10; k <= 59; k++) {
										%>
										<option value="<%=k%>"><%=k%></option>
										<%
											}
										%>
								</select>Min
								</td>


								<td align="left" class="trd">Late to Come <br /> <select
									name="ai_shift_ltoc_time" id="ai_shift_ltoc_time"
									class="shift_select">
										<option value="00" selected="selected">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<%
											for (long k = 10; k <= 23; k++) {
										%>
										<option value="<%=k%>"><%=k%></option>
										<%
											}
										%>
								</select>Hrs <select name="ai_shift_ltoc_Min" id="ai_shift_ltoc_Min"
									class="shift_select">
										<option value="00" selected="selected">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<%
											for (long k = 10; k <= 59; k++) {
										%>
										<option value="<%=k%>"><%=k%></option>
										<%
											}
										%>
								</select>Min
								</td>
								<td align="left" class="trd">Early to Go <br /> <select
									name="ai_shift_etog_time" class="shift_select">
										<option value="00" selected="selected">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<%
											for (long k = 10; k <= 23; k++) {
										%>
										<option value="<%=k%>"><%=k%></option>
										<%
											}
										%>
								</select>Hrs <select name=ai_shift_etog_Min id="ai_shift_etog_min"
									class="shift_select">
										<option value="00" selected="selected">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<%
											for (long k = 10; k <= 59; k++) {
										%>
										<option value="<%=k%>"><%=k%></option>
										<%
											}
										%>
								</select>Min
								</td>
								<td align="left" class="trd">Late to Come Grace <br /> <select
									name="ai_shift_ltoc_g" class="shift_select">
										<option value="00" selected="selected">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<%
											for (long k = 10; k <= 59; k++) {
										%>
										<option value="<%=k%>"><%=k%></option>
										<%
											}
										%>
								</select>Min
								</td>
							</tr>


							<tr>
								<td align="left" class="trd">Early to Go Grace<br /> <select
									name="ai_shift_etog_g" class="shift_select">
										<option value="00" selected="selected">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<%
											for (long k = 10; k <= 59; k++) {
										%>
										<option value="<%=k%>"><%=k%></option>
										<%
											}
										%>
								</select>Min
								</td>
								<td align="left" class="trd">Late to Come Excuse<br /> <select
									name="ai_shift_ltoc_no_e" class="shift_select">
										<option value="0" selected="selected">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>


								</select>Excuses
								</td>

								<td align="left" class="trd">Early to Go Excuse<br /> <select
									name="ai_shift_etog_no_e" class="shift_select">
										<option value="0" selected="selected">0</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
								</select>Excuses
								</td>
								<td align="left" class="trd">Late to Come Days Deduct<br />
									<select name="ai_shift_ltoc_dd" class="shift_select">
										<option value="0" selected="selected">0</option>
										<option value="0.5">0.5</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
								</select>Days
								</td>
								<td align="left" class="trd">Early to Go Days Deduct<br />
									<select name="ai_shift_etog_dd" class="shift_select">
										<option value="0" selected="selected">0</option>
										<option value="0.5">0.5</option>
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
										<option value="6">6</option>
										<option value="7">7</option>
										<option value="8">8</option>
										<option value="9">9</option>
										<option value="10">10</option>
								</select>Days
								</td>
								<td align="left" class="trd">Location<font color="red">*</font>
									<br /> <select name="location" id="locationId">
										<option value="">-------Select------</option>

										<logic:present name="location" scope="request">
											<logic:iterate id="locationID" name="location"
												scope="request">
												<option
													value='<bean:write name="locationID" property="locationid"></bean:write>'>
													<bean:write name="locationID" property="locationname"></bean:write>
												</option>
											</logic:iterate>
										</logic:present>
								</select></td>
							</tr>
							<tr>


							</tr>
						</table>
						<br />
						<table align="center">
							<tr>



								<td><input type="hidden" name='flag' value='insert' /><input
									type="hidden" name='statusEnable' value='disable' /> <logic:present
										name="UserDetails" scope="session">
										<logic:iterate id="map" name="UserDetails"
											property="permissionmap" scope="session">
											<logic:equal value="SFTINSERT" name="map" property="key">
												<logic:equal value="true" name="map" property="value">

													<input type="Button" class="submitbutton" name="insert"
														value="Insert" id="addbutton"
														onclick="return insertShift()" />

												</logic:equal>
											</logic:equal>
										</logic:iterate>
									</logic:present> <logic:present name="UserDetails" scope="session">
										<logic:iterate id="map" name="UserDetails"
											property="permissionmap" scope="session">
											<logic:equal value="SFTUPDATE" name="map" property="key">
												<logic:equal value="true" name="map" property="value">

													<input type="Button" name="modify" class="submitbutton"
														value="Update" onclick="updateShift()" disabled='disabled'
														id="modifybutton" />
												</logic:equal>
											</logic:equal>
										</logic:iterate>
									</logic:present> <logic:present name="UserDetails" scope="session">
										<logic:iterate id="map" name="UserDetails"
											property="permissionmap" scope="session">
											<logic:equal value="SFTDELETE" name="map" property="key">
												<logic:equal value="true" name="map" property="value">

													<input type="Button" class="submitbutton" name="delete"
														value="Delete" id="deletebutton" onclick="deleteShift()" />

												</logic:equal>
											</logic:equal>
										</logic:iterate>
									</logic:present> <input type="reset" class="submitbutton" name="clear"
									value="Clear" /></td>
							</tr>
						</table>
					</center>
				</div>
				<br></br>
				
 	<div class="tablecss" style="margin: 15px; text-align: center" id="tableId">
		<logic:present name="shiftList" scope="request">
				<display:table name="requestScope.shiftList"
					requestURI="/GetDetails.do?parameter=shiftHome"
					pagesize="20" export="false" class="tablecss">
					<display:column property="ai_shift_id" sortable="false" title="Shift Id" style="display:none;" />
					<display:column property="ai_shift_name" sortable="false" title="Shift Name" />
					<display:column property="ai_shift_start_time" sortable="false" title="Start Time" />
					<display:column property="ai_shift_end_time" sortable="false" title="End Time" />
					<display:column property="ai_shift_ltoc" sortable="false" title="Late to Come" />
					<display:column property="ai_shift_etog" sortable="false" title="Early to Go" />
					<display:column property="ai_shift_ltoc_gc" sortable="false" title="Late to Come Grace" />
					<display:column property="ai_shift_etog_gc" sortable="false" title="Early to Go Grace" />
					<display:column property="ai_shift_ltoc_no_exec" sortable="false" title="Late to Come Excuses" />
					<display:column property="ai_shift_ltoc_no_exec" sortable="false" title="Early to Go Excuses" />
					<display:column property="ai_shift_ltoc_ld" sortable="false"   title="LateToComeDaysDeduct"  style="display:none;"/>
					<display:column property="ai_shift_etog_ld" sortable="false"  title="EarlyToGoDaysDeduct"  style="display:none;"/> 
					<display:column property="locationId" sortable="false"  title="Location Id"  style="display:none;"/> 
					<display:column property="location" sortable="false" title="Location" /> 
					
				</display:table>
			</logic:present>
</div> 



<%-- 				<center>
					<div id="tbl-container" class="tablecss">
						<table id="tblData">
							<tr>
								<!-- <th>ShiftId</th> -->
								<th>Shift Name</th>
								<th>Start Time</th>
								<th>End Time</th>
								<th>Late to Come</th>
								<th>Early to Go</th>
								<th>Late to Come Grace</th>
								<th>Early to Go Grace</th>
								<th>Late to Come Excuses</th>
								<th>Early to Go Excuses</th>
								<th>Location</th>
								<!-- <th >LateToComeDaysDeduct</th>
										<th >EarlyToGoDaysDeduct</th> -->
							</tr>

							<logic:iterate name="shiftList" id="shift" scope="request">
								<tr class="altLineTwo"
									onclick="this.className='selectLine';return PopulateData('<bean:write name="shift" property="ai_shift_id"/>','<bean:write name="shift" property="ai_shift_name"/>','<bean:write name="shift" property="ai_shift_start_time"/>', '<bean:write name="shift" property="ai_shift_end_time"/>',
	   '<bean:write name="shift" property="ai_shift_ltoc"/>','<bean:write name="shift" property="ai_shift_etog"/>','<bean:write name="shift" property="ai_shift_ltoc_gc"/>','<bean:write name="shift" property="ai_shift_etog_gc"/>',
	   '<bean:write name="shift" property="ai_shift_ltoc_no_exec"/>','<bean:write name="shift" property="ai_shift_etog_no_exec"/>','<bean:write name="shift" property="ai_shift_ltoc_ld"/>','<bean:write name="shift" property="ai_shift_etog_ld"/>','<bean:write name="shift" property="locationId"/>')"
									class='clickable'>
									<TD align="center"><bean:write name="shift"
												property="ai_shift_id" /></TD>
									<TD align="center"><bean:write name="shift"
											property="ai_shift_name" /></TD>
									<TD align="center"><bean:write name="shift"
											property="ai_shift_start_time" /></TD>
									<TD align="center"><bean:write name="shift"
											property="ai_shift_end_time" /></TD>
									<TD align="center"><bean:write name="shift"
											property="ai_shift_ltoc" /></TD>
									<TD align="center"><bean:write name="shift"
											property="ai_shift_etog" /></TD>
									<TD align="center"><bean:write name="shift"
											property="ai_shift_ltoc_gc" /></TD>
									<TD align="center"><bean:write name="shift"
											property="ai_shift_etog_gc" /></TD>
									<TD align="center"><bean:write name="shift"
											property="ai_shift_ltoc_no_exec" /></TD>
									<TD align="center"><bean:write name="shift"
											property="ai_shift_etog_no_exec" /></TD>
									<TD align="center"><bean:write name="shift"
											property="location" /></TD>
										<TD align="center"><bean:write name="shift"
													property="ai_shift_ltoc_ld" /></TD>
											<TD align="center"><bean:write name="shift"
													property="ai_shift_etog_ld" /></TD>
								</tr>
							</logic:iterate>

							<tr class="altLineOne"
								onClick="javascript:ChangeColor();this.className='selectLine';makeDisable('1','2');return PopulateData('3','4', '5', '6')"
								class='clickable'>
							<tr class="altLineOne"
								onClick="javascript:ChangeColor();this.className='selectLine';makeDisable('mod1','mod2');return PopulateData('mod3','mod4', 'mod5', 'mod6')"
								class='clickable'>
						</table>

					</div>
				</center> --%>
			</form>
		</div>
	</div>
</body>
</html>