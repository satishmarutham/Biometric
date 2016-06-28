<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<link type="text/css" rel="stylesheet" href="./style/main.css"></link>

<script type="text/javascript" src="./script/jquery.js"></script>

<LINK REL=StyleSheet HREF="menu.css" TYPE="text/css" />

<title>SHIFT ROASTER</title>
<link rel="shortcut icon" href="images/favicon.ico">
<script language="javascript" src="js/datetimepicker.js"></script>
<script language="javascript" src="js/globals.js"></script>
<script type="text/javascript" src="js/popupconstants.js"></script>
<script language="javascript" src="js/shift.js"></script>
<script language="javascript" src="js/messageconstant.js"></script>
<script language="javascript" src="js/Validation.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
</HEAD>
<BODY bgcolor="" class="windowMargin">
	<jsp:include page="header_menu.jsp"></jsp:include>
	<br/> <br/>
	<div id="main">

		<div style="position: absolute; top: 150px; left: 100px">
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
					type="hidden" name='ai_shift_mm' value='00' />

				<%
					String username = (String) session.getAttribute("username");
					if (username == null) {
						
				%>

				<jsp:forward page="login.jsp"></jsp:forward>

				<%
					} else {
						

					}
				%>
				<br></br>
				
				
					
        	<font style="font-family: sans-serif; font-weight:bolder; color:#000000;  font-size: 18px; padding-left: 450px;">SHIFT ROASTER</font>
       
	<br></br>
	<logic:present name="roleName" scope="session">					
	<c:set var="user" value="HR-2" />

	<c:if test="${ roleName!= user}"> 
	<center>
			

				<table id="biometricshift" bgcolor="#FFFFFF" cellspacing="12" frame="box" bordercolor="black">
		
					<tr>
						<th >Shift Id</th>
						<th >Shift Name</th>
						<th >Start Time</th>
						<th >End Time</th>

					</tr>
					<tr>
						<td><input type="text" name="ai_shift_id" value=""
							readonly="readonly" size="12" maxlength='13' /></td>
						<td><input type="text" name="ai_shift_name" value=""
							size="15" maxlength='15' /></td>
						<td align="left"><select name="ai_shift_start_t">
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
						</select>HRS <select name="ai_shift_start_m">
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
						</select>MIN <!-- seconds creation --> <!--  --> </td>
						<td align="left"><select name="ai_shift_end_t">
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
						</select>HRS <select name="ai_shift_end_m">
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
						</select>MIN </td>
					</tr>

				



					<tr>
						<th >Late To Come</th >
						<th >Early To Go</th >
						<th >Late To Come Grace</th >
						<th >Early To Go Grace</th >



					</tr>
					<!-- <input type="password" name="txt_password" size="20" value="" maxlength='15' onkeypress='return validateData(event)'/> -->

					<tr>

						<td align="left"><select name="ai_shift_ltoc_time">
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
						</select>HRS <select name="ai_shift_ltoc_min">
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
						</select>MIN</td>
						<td align="left"><select name="ai_shift_etog_time">
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
						</select>HRS <select name=ai_shift_etog_min>
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
						</select>MIN</td>
						<td><select name="ai_shift_ltoc_g">
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
						</select>MIN</td>

						<td><select name="ai_shift_etog_g">
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
						</select>MIN</td>
					</tr>

					<tr>
						<th >Late To Come Execuse</th >
						<th >Early To Go Execuse</th >
						<th >Late To Come Days Deduct</th >
						<th >Early To Go Days Deduct</th >
					</tr>
					<tr>

						<td><select name="ai_shift_ltoc_no_e">
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


						</select>Excuses</td>



						<td><select name="ai_shift_etog_no_e">
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
						</select>Excuses</td>




						<td><select name="ai_shift_ltoc_dd">
								<option value="0" selected="selected">0</option>
								<option value="0.5">0.5</option> 
								<option value="1.0">1</option>
								<option value="2.0">2</option>
								<option value="3.0">3</option>
								<option value="4.0">4</option>
								<option value="5.0">5</option>
								<option value="6.0">6</option>
								<option value="7.0">7</option>
								<option value="8.0">8</option>
								<option value="9.0">9</option>
								<option value="10.0">10</option>
						</select>DAYS</td>




						<td><select name="ai_shift_etog_dd">
								<option value="0" selected="selected">0</option>
								<option value="0.5">0.5</option> 
								<option value="1.0">1</option>
								<option value="2.0">2</option>
								<option value="3.0">3</option>
								<option value="4.0">4</option>
								<option value="5.0">5</option>
								<option value="6.0">6</option>
								<option value="7.0">7</option>
								<option value="8.0">8</option>
								<option value="9.0">9</option>
								<option value="10.0">10</option>
						</select>DAYS</td>
				
					</tr>
					<tr id="location" class="USER_LOCATION">
						<th class="trd">Location</th>
						
					</tr>
					<tr  id="location" class="USER_LOCATION">
					<td>
						<logic:present name="locationList" scope="session">
								<select name="Location" id="locationId">
									<option value="">-----Select-----</option>
									<logic:iterate id="location" name="locationList" scope="session">
										<option value='<bean:write name="location" property="locationCode"  />'>
											<bean:write name="location" property="locationName" />
										</option>
									</logic:iterate>
								</select>
							</logic:present>
							</td>
					</tr>
					<tr height="20">
						<td colspan="4" align="center"><input type="hidden" 
							name='flag' value='insert' /><input type="hidden"
							name='statusEnable' value='disable' />  <input type="Button" name="modify"
							class="button1" value="Update" onclick="upd()" disabled='disabled' id="modifybutton"/>
							
		
	
	<input type="Button"
							class="button1" name="insert" value="Insert" id="addbutton"
							onclick="return ins()" />
							
							<input type="Button" class="button1" name="delete" value="Delete" id="deletebutton"
							onclick="del()" /> 
							
									
							<input type="Button" class="button1"
							name="clear" value="Clear" onclick="clear12()" /></td>
					</tr>
				</table>
				</center>
				
	
								</c:if>
</logic:present>		
				
					<table id="biometric" align="left" class="table" border=1 cellpadding="2" width="600" align="center" class='clickable'>
									<tr>
										<th >ShiftId</th>
										<th >ShiftName</th>
										<th >StartTime</th>
										<th >EndTime</th>
										<th >LateToCome</th>
										<th >EarlyToGo</th>
										<th >LateToComeGrace</th>
										<th >EarlyToGoGrace</th>
										<th >LateToComeExcuses</th>
										<th >EarlyToGoExcuses</th>
										<th >LateToComeDaysDeduct</th>
										<th >EarlyToGoDaysDeduct</th>
									</tr>

									<logic:iterate name="shiftList" id="shift" scope="request">
										<tr class="altLineTwo"
											onClick="this.className='selectLine';return PopulateData('<bean:write name="shift" property="ai_shift_id"/>','<bean:write name="shift" property="ai_shift_name"/>','<bean:write name="shift" property="ai_shift_start_time"/>', '<bean:write name="shift" property="ai_shift_end_time"/>',
	   '<bean:write name="shift" property="ai_shift_ltoc"/>','<bean:write name="shift" property="ai_shift_etog"/>','<bean:write name="shift" property="ai_shift_ltoc_gc"/>','<bean:write name="shift" property="ai_shift_etog_gc"/>',
	   '<bean:write name="shift" property="ai_shift_ltoc_no_exec"/>','<bean:write name="shift" property="ai_shift_etog_no_exec"/>','<bean:write name="shift" property="ai_shift_ltoc_ld"/>','<bean:write name="shift" property="ai_shift_etog_ld"/>')"
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


								</TABLE>
							</div>
			</form>
		<br></br><hr></hr><br></br>
		
		<br></br><hr>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>

</BODY>
</HTML>