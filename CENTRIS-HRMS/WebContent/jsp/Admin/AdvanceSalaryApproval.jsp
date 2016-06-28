<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Advance approval</title>

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
<script language="javascript" src="js/common.js"></script>
<link href="css/Home/bootstrap-combined.min.css" rel="stylesheet" type="text/css"/>
<link href="css/Home/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
 <link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
<link rel="stylesheet" href="css/Manager/AdvancedSalaryApproval.css">
<script type="text/javascript" src="js/Admin/AdvanceSalaryApproval.js"></script>
</head>
<body>
<div id="main" class="background">

	
			 
			<center>
				<div class="backgroundDiv" id="backgroung" style="width: 100%">
					Advance Salary Approval</div>
					</center>
					<center>
						
							
							<logic:present name="success" scope="request">
							<div id="errordiv" class="error-box">
								<span style="color: green; font-family: Segoe UI;">
									<bean:write name="success"/>
								</span>
								</div>
							</logic:present>

						
							
							<logic:present name="error" scope="request">
							<div id="errordiv" class="error-box">
								<span style="color: red; font-family: Segoe UI;">
									<bean:write name="error"/>
								</span>
								</div>
							</logic:present>
						
						</center>
						<br>
			
				
				<center>
				<logic:present name="salaryRequestDetails">
						<display:table id="advanceSalaryApprovalId" name="requestScope.salaryRequestDetails" pagesize="25" decorator="com.centris.decorator.AdvanceSalaryApprovalDecorator" requestURI="GetDetails.do" class="view" style="width:73%;">
									<%--  <display:column>
         <input type="hidden" name="advanceSalaryCode"> 
    </display:column>  --%>
										
										
										<tr>
											<td><display:column property="employeeName"
													title="Employee Name" style="text-align:center;" /></td>
											<td><display:column property="bioId"
													title="Employee Id" style="text-align:center;" /></td>
											<td><display:column property="projectReferenceCode" title="Project Reference Code"
													style="text-align:center;" /></td>
													<td><display:column property="salary" title="Salary"
													style="text-align:center;" /></td>
											<td><display:column property="requestedByName" title="Requested By"
													style="text-align:center;" /></td>
											<td><display:column property="comments" title="Comments"
													style="text-align:center;" /></td>
													
													<td><display:column property="approval" title="Approval"
													style="text-align:center;" /></td>
													
													
													
													</tr></display:table>
												</logic:present>
					</center>
				<br>
					</div>
					
<div id="update-dialog" title="Approval Salary" style="display: none; font-size: 10px;background-color: #F2F0E7" align="center"></br>
<div id="loading" style="position: absolute;top:30px;left:270px;display: none;"><img  src="images/loaderimage2.GIF"/></div>
	<center><div id="error" class="error-box" style="display: none;width:70%;"></div></center>
		<div>
			
			
<table cellpadding="5" cellspacing="0" id="biometric" width="100%" class="dialogclass" id="approvalDialogTable" >

					<tr>
					
					<td class="leftindialog" >Employee BioId</td>
				<td class="rightindialog" id="employeeCodeId">
				
				<td class="leftindialog">Salary</td>
								<td class="rightindialog"  id="salaryId">
								</td>
			


					
				    </tr>



<tr>
<td class="leftindialog" >Employee Name</td>
								<td class="rightindialog"  id="employeeNameId">
								</td>
								
	<td class="leftindialog" >Approved Amount</td>
								<td class="rightindialog"><input type="text" id="approvedAmount">
								</td>							
								


				</tr>
<tr>
<td class="leftindialog" >Requested By</td>
				<td class="rightindialog" id="requestedByNameId">	</td>
				
		
	<td class="leftindialog" >Requested Date</td>
				<td class="rightindialog" id="requestedDateId">	</td>
					
		
				



</tr>


<tr>
					<td class="leftindialog">Project Ref Code</td>
								<td class="rightindialog"  id="projectRefCodeId">
								</td>
					<!-- <td  class="leftindialog" >Comment/Remarks</td>
				<td class="rightindialog" id="descriptionId" colspan="3">
					</td> -->


					
				    </tr>





<input type="hidden" id="advanceSalaryCodeId"/>
<input type="hidden" id="employeeCodeValId"/>
				<input type="hidden" id="salaryIdVal"/>
				
			
					
					
					

				</table>
				
		

		</div>
	
	</div>	
					
			
				
</body>
</html>