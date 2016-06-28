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
<title>Attendance approval</title>

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
<script type="text/javascript"
	src="JQUERY/js/bootstrap-datetimepicker.min.js"></script>

<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link href="css/Home/bootstrap-combined.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/Home/bootstrap-datetimepicker.min.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="css/common.css"></link>

<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
<link rel="stylesheet" href="css/Manager/AdvanceSalary.css"></link>
<script type="text/javascript" src="js/Manager/AdvanceSalaryRequest.js"></script>


<link rel="stylesheet" href="css/Manager/AttendanceApproval.css"></link>
</head>
<body>
<div id="loading" style="position: absolute;top:155px;left:650px;display: none;"><img  src="images/loaderimage2.GIF"/></div>
<div id="main">

		<div class="background" id="backgroung">
		<div class="backgroundDiv" id="backgroung" style="width: 100%">Advance Salary Request
					</div>
		
		
		
		<center>
		
	
		
<!-- <div id="errordiv" class="error-box" style="width: 19%">

					
						<span style="color: green; font-family: Segoe UI;"> 
						</span>
					
				</div> -->
			
		<div id="errordiv" class="error-box" style="width: 25%">

					<logic:present name="message" scope="session">
						<span style="color: green; font-family: Segoe UI;"> <bean:write
								name="message" />
						</span>
					</logic:present>
				

					<logic:present name="error" scope="session">
						<span style="color: red; font-family: Segoe UI;"> <bean:write
								name="error" />
						</span>
					</logic:present>
				</div>			
				



    	<div align="right"><input type="button" value="Add" id="Add" class="submitbutton"/></div>
    	
    	 <div style="overflow:auto;width:100%;" >
            <table id="salaryRequest" width="100%" cellpadding="0" cellspacing="1">
						<tr>
							 <th>Sl.No</th>
		                    <th>Employee Name<font color="red">*</font></th>
		                    <th>Employee Id<font color="red">*</font></th>
		                    <th>Project Code<font color="red">*</font></th>
		                    <th>Salary<font color="red">*</font></th>
		                    <th>Comment/Remarks<font color="red">*</font></th>
		                       <th>Delete</th>
						</tr>
						
						<tr>
						
						<td><span id="sno">1</span></td>
							 <td>
                                   <select name="employeename"
									id="employeeIdCode" class="selectClass" onchange="getEmployeedetails(this.value,this.id)" >
										<option value="">-----Select-------</option>
									
								</select>
                
            </td>
							<td ><input type="text" name="employeeCode" id="employeeCodeId1" class="employeeCodeClass" readonly="readonly" style="background-color: #C2C2C2;width: 96%;
  height: 25px;" /></td>

											 <td>
                                   <select name="projectReferenceCode"
									id="projectReferenceCodeId" class="projectReferenceCodeClass">
											<option value="">-----Select------</option>
										
								</select>
                
            </td>
						
			<td ><input type="text" name="salary" id="salaryId1" class="salaryClass" style="width: 96%;"/></td>
							<td ><textarea name="description" id="descriptionId1"  class="descriptionClass" rows="2" cols="22" style="resize:none;" ></textarea></td>
							<td ><input type="hidden" name="projectCode" id="projectCodeId1" class="projectCodeClass" /></td>
								
								</tr>
						
   </table>
   <br/>
   </div>
   
  
   <br>
   
 <input type="button" value="Send Request"class="submitbutton" id="requestId">
    

		</center>
		</div>
		</div>
</body>
</html>