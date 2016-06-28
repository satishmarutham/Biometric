<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@page language="java" trimDirectiveWhitespaces="true"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Productivity Report</title>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<!-- <script type="text/javascript" src="js/Admin/TimeSheet.js"></script>
 -->

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
<script type="text/javascript" src="JQUERY/js/bootstrap-datetimepicker.min.js"></script>

<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
<script type="text/javascript" src="js/Director/productivityreport.js"></script>

</head>

<body>
	<br />
	<div class="background" id="backgroung">

		<center>
			<div class="backgroundDiv" id="backgroung">Productivity Report</div>
		</center>

		<form action="productivity.do" method="post">



			<center>


				<center>
					<div id="errordiv" class="error-box" align="center">

						<logic:present name="successMsg" scope="request">
							<span style="color: green; font-family: Segoe UI;"> <bean:write
									name="successMsg" scope="request" />
							</span>
						</logic:present>
						<logic:present name="failureMsg" scope="request">
							<span style="color: red; font-family: Segoe UI;"> <bean:write
									name="failureMsg" scope="request" />
							</span>
						</logic:present>
					</div>
				</center>




				<fieldset style="width: 65%;">
					<table id="biometric" cellspacing="5" cellpadding="8">
						<tr class="trc">

							<td class="left">Type<font color="red">*</font><br /> <select
								name="type" id="type">
									<option id="" value="">-----Select---------</option>
									<option value="day">DAY</option>
									<option value="week">WEEK</option>
									<option value="month">MONTH</option>

							</select>
							</td>




							<td id="div1"><label for="startDate"><b>Start
										Date</b><font color="red">*</font></label> <input type="text"
								name="startdate" id="startdate" readonly="readonly"
								placeholder="Click Here" /></td>


							<td id="div2"><label for="endDate"><b>End Date</b><font
									color="red">*</font></label> <input type="text" name="enddate"
								id="enddate" readonly="readonly" placeholder="Click Here" /></td>





							<td id="div3"><label for="startDate"><b>Month</b><font
									color="red">*</font></label> <input type="text" name="startdate"
								id="startdate" readonly="readonly" placeholder="Click Here" /></td>


							<td id="div4"><label for="endDate"><b>Year</b><font
									color="red">*</font></label> <input type="text" name="enddate"
								id="enddate" readonly="readonly" placeholder="Click Here" /></td>



							<td id="div5"><label for="startDate"><b>Year</b><font
									color="red">*</font></label> <input type="text" name="startdate"
								id="startdate" readonly="readonly" placeholder="Click Here" /></td>







							<td class="left">Department<font color="red">*</font> <input
								type="checkbox" name="deptcheckbox" id="deptcheckbox"
								value="all" onclick="selectAllDepartments()" />select all</br> <select
								name="department" id="departmentid" multiple="multiple"
								style="width: 100%;">
									<logic:present name="AllDepartments" scope="session">
										<logic:notEmpty name="AllDepartments" scope="session">
											<logic:iterate id="iterateid" name="AllDepartments"
												scope="session">
												<option
													value="<bean:write name="iterateid" property="deptid"></bean:write>">
													<bean:write name="iterateid" property="deptname"></bean:write>
												</option>
											</logic:iterate>
										</logic:notEmpty>
									</logic:present>
							</select>

							</td>


							<td class="left">Employee<font color="red">*</font> <input
								type="checkbox" name="empcheckbox" id="empcheckbox" value="all"
								onclick="selectAllEmployees()" />select all</br> <select
								name="employee" id="employee" multiple="multiple"
								style="width: 100%;">
							</select>
							</td>



						</tr>
					</table>
				</fieldset>

				<html:submit value="Submit" styleClass="submitbutton"
					styleId="submitbtn" property="parameter" 
					/>
				<br></br>




			</center>


			<%-- <input id="hempId" type="hidden"
				value='<logic:present name="getemployeelist" scope="request"><bean:write name="hEmpId"/> </logic:present>' />
			<input id="hdepId" type="hidden"
				value='<logic:present name="getemployeelist" scope="request"><bean:write name="hDepId"/> </logic:present>' />
			<input id="hmgrId" type="hidden"
				value='<logic:present name="getemployeelist" scope="request"><bean:write name="hMgrId"/> </logic:present>' />
			<input id="hmonth" type="hidden"
				value='<logic:present name="getemployeelist" scope="request"><bean:write name="hmonth"/> </logic:present>' />
			<input id="hyear" type="hidden"
				value='<logic:present name="getemployeelist" scope="request"><bean:write name="hyear"/> </logic:present>' />

 --%>
			<center>

				<div style="overflow: auto; width: 100%;">
				<logic:present name="getemployeelist">
					<logic:notEmpty name="getemployeelist">
					
					
						<table  class="view">

							<tr style="background: #156AEB !important">
								<th  rowspan="2">Day/Employee Name</th>
								<%
									for (int i = 1; i <= 7; i++) {
								%>
								
								<th ><%out.println( i );
							    out.println( "Day" );%>  </th>							  
							    <%
									}
								%>
							           
                             </tr>
                             <tr>
                             <th>Working Hours </th>
                             <th> Permission Hours </th>
                             <th> Total Hours</th>
                             </tr>

							<logic:iterate id="employeeMonthReport" name="getemployeelist"
								>
								<tr>

									<td align="center"><bean:write name="employeeMonthReport"
											property="empname" /></td>
								
									<logic:iterate id="employeeMonthReport1"
										name="employeeMonthReport" property="statusList">
										
														<td><bean:write name="employeeMonthReport" property="working_hrs"  /></td>
														
												
									</logic:iterate>



									<td align="center"><bean:write name="employeeMonthReport"
											property="empname" /></td>
									<td align="center"><bean:write name="employeeMonthReport"
											property="totaltime" /></td>
									<td align="center"><bean:write name="employeeMonthReport"
											property="working_hours" /></td>
									<td align="center"><bean:write name="employeeMonthReport"
											property="permission_hours" /></td>
								</tr>
							</logic:iterate>




						</table>
						<br></br>
						<table>
							<tr>
								<td><html:submit value="Download" property="parameter"
										styleClass="submitbutton"></html:submit></td>

							</tr>
						</table>

					</logic:notEmpty>
					</logic:present>
				</div>
			</center>

		</form>
	</div>

</body>

	
</html>
