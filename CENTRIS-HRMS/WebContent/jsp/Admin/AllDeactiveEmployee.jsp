<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <jsp:include page="header_menu.jsp"></jsp:include> --%>
<html>
<head>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Employee</title>
<script type="text/javascript" src="js/Admin/GetAllDeactiveEmployees.js"></script>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.position.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.menu.js"></script>
<script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script>

<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>


<style type="text/css">
.linkButton {
	
	min-height: 15px;
	max-height: 10%;
	margin: 5px 5px 5px 5px;
	background-color: #aaaaaa;
	color: black;

}

.linkButton:hover {
	text-shadow: 0 0 1px rgba(255, 255, 255, 0.7);
	cursor: pointer;
}


</style>

</head>

<body>

	
	<div align="center" id="main">
		<center>
			<div class="background" id="backgroung">
			

				<div class="backgroundDiv" id="backgroung">All DeActive Employees</div>
				
				
				<center>

					<div id="errordiv" class="error-box" align="center" style="width:55%;">

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
				
				

						<div class="tablecss" style="width: 80%; " id="tableId" >
							<logic:present name="emplist" scope="request">
                      

								<display:table id="emplist" name="emplist" export="false"
									requestURI="/employee.do?parameter=getAllDeactiveEmployees"
									pagesize="50" >
									
								<display:column property="sno" title="Sno"></display:column>
								<display:column title="Employee ID">
								
								<a href="displayDeactiveEmployees.do?parameter=getDeactiveEmployeeDetails&selectEmployee=${emplist.empid}">
								${emplist.bioid}
								</a>
								
								</display:column>
								
								
									<display:column property="empname" title="EmployeeName " />
									<display:column property="designationname" title="Designation" />
									<display:column property="permissions" title="Permissions" />
									<display:column property="officialMailId" title="OfficialMailid" />
									<display:column property="phonenumber" title="PhoneNo" />

									
													
													<%-- <display:column title="Delete Employee">
														<input type="button" name="delete"
															onClick='deleteEmployee(this)' value="Delete"
															id="${emplist.empid}"> </>
									
													</display:column> --%>
													
														<display:column title="Activate">
														<input type="button" name="view"
															onClick='viewDetils(this)' value="Activate"
															id="${emplist.empid}"> </>
									
													</display:column>
													
											<display:column title="View">
														<input type="button" name="viewDetails"
															onClick='viewMoreDetils(this)' value="ViewMoreDetails"
															id="${emplist.empid}"> </>
									
													</display:column>
										
								


								</display:table>
							
								
								<br/>
								<br/>
								<logic:iterate id="employee" name="emplist" scope="request">
								<input type="hidden" id="hiddenemployee" name="hiddenemployee" value='<bean:write name="employee"  property="empid" />'></input>
								
								</logic:iterate>
								
								
								

							</logic:present>
							 
						</div>

               
			
			


				
				
			
			
		
					

<!-- form division ending here    -->
				
				
				
			</div>
		</center>
	</div>
	<br/>	<br/>
	<a href="GetDetails.do?parameter=getAllEmployeePage"  style="margin-left:90%; color: #000;">Go Back</a>
	<br>
	<br>


</body>
</html>


