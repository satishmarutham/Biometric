<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<link type="text/css" href="css/Menu/redfin_menu.css" rel="stylesheet" />
<link type="text/css" href="css/Menu/redfin_menu.css" rel="stylesheet" />
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
</head>
<body>
	<div class="mains">



		<ul class="menu">
			<li><html:link page="/GetDetails.do?parameter=home"
					style="text-decoration:none">
					<span><img src="images/home.png" height="22" width="22" />Home</span>
				</html:link></li>

			<li><a href="#" class="parent"><span><img
						src="images/emplo.png" height="22" width="22" />Employee</span></a>
				<ul>

					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="EMPINSERT" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">

									<li><html:link page="/GetDetails.do?parameter=getEmployeePage"
											style="text-decoration:none">
											<span><img src="images/add.png" height="22"
												align="left" width="22" />Register Employee </span>
										</html:link></li>

								</logic:equal>

							</logic:equal>

						</logic:iterate>

					</logic:present>

					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="EMPUPDATE" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">

									<li><html:link
											page="/GetDetails.do?parameter=modifyEmployee"
											style="text-decoration:none">
											<span><img src="images/modify.png" height="20"
												align="left" width="20" />Amendment</span>
										</html:link></li>

								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>

					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="EMPDELETE" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">
									<li><html:link
											page="/GetDetails.do?parameter=removeEmployee"
											style="text-decoration:none">
											<span><img src="images/remove.png" height="22"
												align="left" width="22" />De-Activation</span>
										</html:link></li>
								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>

					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="WEEKOFF" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">
									<li><html:link
											page="/GetDetails.do?parameter=getEmployeeWeekOff"
											style="text-decoration:none">
											<span><img src="images/add.png" height="20"
												align="left" width="20" />Week Off settings</span>
										</html:link></li>
								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>
					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="EMPVIEW" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">
									<li><html:link
											page="/GetDetails.do?parameter=listofEmployee"
											style="text-decoration:none">
											<span><img src="images/modify.png" height="22"
												align="left" width="22" />All Employees</span>
										</html:link></li>
								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>
					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="EMPACTIVE" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">
									<li><html:link
											page="/GetDetails.do?parameter=listofDeactiveEmployee"
											style="text-decoration:none">
											<span><img src="images/modify.png" height="22"
												align="left" width="22" />Employee Activation</span>
										</html:link></li>
								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>
					<li><html:link page="/locationView.do?parameter=locationView"
							style="text-decoration:none">
							<span>Location Index Numbers</span>
						</html:link></li>
					<li><html:link
							page="/GetDetails.do?parameter=getManualAttendance"
							style="text-decoration:none">
							<span>Manual Attendance</span>
						</html:link></li>

				</ul></li>
			<li><center>
					<a href="#" class="parent"><span><img
							src="images/shift.png" height="22" width="22" /> Master </span></a>
				</center>
				<ul>

					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="SFTVIEW" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">
									<li><html:link page="/GetDetails.do?parameter=shiftHome"
											style="text-decoration:none">
											<span><img src="images/add.png" height="22" width="22"
												align="left" />Shift Details</span>
										</html:link></li>
								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>

					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="DEPTVIEW" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">
									<li><html:link
											page="/departmentMaster.do?parameter=getDepRecords"
											style="text-decoration:none">
											<span><img src="images/add.png" height="22" width="22"
												align="left" />Department Details</span>
										</html:link></li>

								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>


					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="HOLVIEW" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">

									<li><html:link
											page="/holidayMaster.do?parameter=getDetails"
											style="text-decoration:none">
											<span><img src="images/add.png" height="20"
												align="left" width="20" />Holiday Details</span>
										</html:link></li>


								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>

					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="DESVIEW" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">

									<li><html:link
											page="/adddesignation.do?parameter=addDesignation"
											style="text-decoration:none">
											<span><img src="images/add.png" height="20"
												align="left" width="20" />Designation Details</span>
										</html:link></li>


								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>

					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="LOCVIEW" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">

									<li><html:link page="/location.do?parameter=addlocation"
											style="text-decoration:none">
											<span><img src="images/add.png" height="20"
												align="left" width="20" />Location Details</span>
										</html:link></li>

								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>

					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="GRPVIEW" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">

									<li><html:link
											page="/groupMaster.do?method=groupMasterHome"
											style="text-decoration:none">
											<span><img src="images/add.png" height="20"
												align="left" width="20" />Group Details</span>
										</html:link></li>

								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>



					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="GRPLOCMAP" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">

									<li><html:link
											page="/grouplocationmap.do?parameter=groupLocationHome"
											style="text-decoration:none">
											<span><img src="images/add.png" height="20"
												align="left" width="20" />Group-Locations Mapping</span>
										</html:link></li>

								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>
					
				
		<%-- 		<!-- CENTRIS-HRMS Project-Manager  Mapping  start created by swathi-->
				
					<li><html:link
								page="/projectManagerMapping.do?parameter=ProjectManagerMappingHome"
											style="text-decoration:none">
											<span><img src="images/add.png" height="20"
												align="left" width="20" />Project-Manager Mapping</span>
										</html:link></li>
					
				<!-- CENTRIS-HRMS Project-Manager  Mapping  end -->
					
 --%>					

					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="USRVIEW" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">

									<li><html:link page="/GetDetails.do?parameter=getUsers"
											style="text-decoration:none">
											<span><img src="images/add.png" height="20"
												align="left" width="20" />User Details</span>
										</html:link></li>

								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>

					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="RLEVIEW" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">

									<li><html:link page="/GetDetails.do?parameter=getRoles"
											style="text-decoration:none">
											<span><img src="images/add.png" height="20"
												align="left" width="20" />Role Details</span>
										</html:link></li>

								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>



					<li><html:link
							page="/GetDetails.do?parameter=getUserRolePermission"
							style="text-decoration:none">
							<span><img src="images/add.png" height="20" align="left"
								width="20" />Role-Permissions Mapping</span>
						</html:link></li>






				</ul></li>
			<%-- <li><a href="#" class="parent"><span><img
						src="images/attendance.png" height="22" width="22" />Re-conciliation</span></a>
				<ul>
					<li><html:link
							page="/reportreconcil.do?parameter=reportReconcilHome"
							style="text-decoration:none">
							<span>Report Re-conciliation</span>
						</html:link></li>
						
				<logic:present name="UserDetails" scope="session">
			     <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="ATTRECONCIL" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >
					<li><html:link
							page="/attendaceReconcil.do?parameter=attendanceReconcilationHome"
							style="text-decoration:none">
							<span>Attedndance ReConcilation</span>
						</html:link></li>

					<li><html:link
						
					 </logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present>
	 			 
					<li><html:link
							page="/timesheetReconcil.do?method=timesheetReconciliation"
							style="text-decoration:none">
							<span>TimeSheet Re-conciliation</span>
						</html:link></li>
						
						
					<li><html:link
							page="/timesheetreport.do?parameter=timeSheetReport"
							style="text-decoration:none">
							<span>TimeSheet Report Audit</span>
						</html:link></li>
				</ul></li> --%>

			<li><a href="#" class="parent"><span><img
						src="images/bio.jpg" height="22" width="22" />Bio Report</span></a>
				<ul>
					<li><a href="#" class="parent"><span>Attendance
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-->
								<b></b>
						</span></a>
						<ul>

							<logic:present name="UserDetails" scope="session">
								<logic:iterate id="daymap" name="UserDetails"
									property="permissionmap" scope="session">
									<logic:equal value="VEWDAYREPORT" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">

											<li><html:link
													page="/GetDetails.do?parameter=getDayReport"
													style="text-decoration:none">
													<span>Day Report</span>
												</html:link></li>

										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>

							<logic:present name="UserDetails" scope="session">
								<logic:iterate id="daymap" name="UserDetails"
									property="permissionmap" scope="session">
									<logic:equal value="VEWMNTHREPORT" name="daymap" property="key">
										<logic:equal value="true" name="daymap" property="value">

											<li><html:link
													page="/GetDetails.do?parameter=getConsolidateDetailedMonthReport"
													style="text-decoration:none">
													<span>Month Report</span>
												</html:link></li>

										</logic:equal>
									</logic:equal>
								</logic:iterate>
							</logic:present>
							<li><html:link
									page="/GetDetails.do?parameter=getYearlyReport"
									style="text-decoration:none">
									<span>Yearly Report</span>
								</html:link></li>
							<%-- <li><html:link page=""
									style="text-decoration:none">
									<span>OverTime Report</span>
								</html:link></li> --%>

						</ul></li>

					<logic:present name="UserDetails" scope="session">
						<logic:iterate id="daymap" name="UserDetails"
							property="permissionmap" scope="session">
							<logic:equal value="VEWTODAYREPORT" name="daymap" property="key">
								<logic:equal value="true" name="daymap" property="value">
									<li><html:link
											page="/GetDetails.do?parameter=getTodayReport"
											style="text-decoration:none">
											<span>Today Report</span>
										</html:link></li>

								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>

					<li><html:link
							page="/GetDetails.do?parameter=mothlyLagendReport"
							style="text-decoration:none">
							<span>Monthly-Legend Report</span>
						</html:link></li>
					<%-- <li><html:link
							page="/GetDetails.do?parameter=getEarlyTimeReport" style="text-decoration:none">
							<span>Early Time Report</span>
						</html:link></li> --%>

					<%--  <logic:present name="UserDetails" scope="session">
			     <logic:iterate id="daymap" name="UserDetails" property="permissionmap" scope="session">
				 <logic:equal value="VEWLATEREPORT" name="daymap" property="key">
				 <logic:equal value="true" name="daymap" property="value" >	
						
					<li><html:link
							page="/GetDetails.do?parameter=getLatecommers"
							style="text-decoration:none">
							<span>Latecomers Report</span>
						</html:link></li>
						
						</logic:equal>
				 </logic:equal>
				 </logic:iterate>
	 			 </logic:present> --%>

					<%-- <li><html:link
							page="/GetDetails.do?parameter=getworkingLessThen8hours"
							style="text-decoration:none">
							<span>working lessthan 8hrs</span>
						</html:link></li> --%></li>

			<logic:present name="UserDetails" scope="session">
				<logic:iterate id="daymap" name="UserDetails"
					property="permissionmap" scope="session">
					<logic:equal value="VEWLOGREPORT" name="daymap" property="key">
						<logic:equal value="true" name="daymap" property="value">
							<li><html:link page="/GetDetails.do?parameter=getLogReport"
									style="text-decoration:none">
									<span>Log Report</span>
								</html:link></li>
						</logic:equal>
					</logic:equal>
				</logic:iterate>
			</logic:present>


			<li><html:link page="/GetDetails.do?parameter=getDailyLogReport"
					style="text-decoration:none">
					<span>Daily Log Report</span>
				</html:link></li>

			<li><html:link page="/GetDetails.do?parameter=getLocationUpdate"
					style="text-decoration:none">
					<span>Location Updated Report</span>
				</html:link></li>

			<li><html:link page="/GetDetails.do?parameter=getGroupLogReport"
					style="text-decoration:none">
					<span>Group Log Report</span>
				</html:link></li>
			<li><html:link
					page="/GetDetails.do?parameter=getIncorrectPunchReport"
					style="text-decoration:none">
					<span>Incorrect Punch Report</span>
				</html:link></li>
			<li><html:link
					page="/GetDetails.do?parameter=getLastThreeAbsentReport"
					style="text-decoration:none">
					<span>Last Three Absent Report</span>
				</html:link></li>
			<li><html:link
					page="/GetDetails.do?parameter=getRegistrationTimeReport"
					style="text-decoration:none">
					<span>Registration Details Report</span>
				</html:link></li>
				<li><html:link
					page="/GetDetails.do?parameter=getMachineStatusReport"
					style="text-decoration:none">
					<span>Machine Status Report</span>
				</html:link></li>
		</ul>
		<%-- <li><a href="#" class="parent"><span><img
						src="images/bio.jpg" height="22" width="22" />Bio Process</span></a>
				<ul>
					

					<li><html:link page="/GetDetails.do?parameter=generatePayRoll"
							style="text-decoration:none">
							<span>Generate PayRoll</span>
						</html:link></li>
				</ul></li> --%>

		<li class="parent"><a href="http://www.centrisinfotech.com/"><span><img
					src="images/help.png" height="22" width="22" />Contact us</span></a>

			<ul>
				<li><html:link
						page="/GetDetails.do?parameter=sendMailToCustomerSupport"
						style="text-decoration:none">
						<span>Send Mail</span>
					</html:link></li>
			</ul></li>
		<li class="parent"><html:link
				page="/GetDetails.do?parameter=changePassword"
				style="text-decoration:none">
				<span><img src="images/help.png" height="22" width="22" />Change
					Password</span>
			</html:link></li>
		<li class="last"><html:link
				page="/GetDetails.do?parameter=logout" style="text-decoration:none">
				<span>Logout</span>
			</html:link></li>


		</ul>





	</div>

</body>
</html>