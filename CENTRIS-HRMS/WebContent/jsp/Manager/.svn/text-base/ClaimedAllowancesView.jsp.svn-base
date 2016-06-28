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
<link href="css/Home/bootstrap-combined.min.css" rel="stylesheet"
	type="text/css" />
<link href="css/Home/bootstrap-datetimepicker.min.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="css/common.css"></link>
<script type="text/javascript" src="js/Manager/ClaimedAllowancesView.js"></script>

<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
</head>
<body>
<div id="main">

		<div class="background" id="backgroung">
			
			<center>
				<div class="backgroundDiv" id="backgroung">
					Claimed Allowances</div>
					</center>
				<br/>	<br/>
				<logic:present name="ClaimedAllowances" scope="request">
				<!-- 	<div class="tablecss" style="margin:40px;"> -->
					<center>
						<display:table 	name="requestScope.ClaimedAllowances" class="view" style="width:70%;"
						 requestURI="/employeeAllowances.do?method=getClaimedAllowanceDetails"
						 	pagesize="10">
							<display:column property="bioid" title="BioId" />
							<display:column property="empname" title="EmployeeName" />
							<display:column property="allowancedate" title="AllowanceDate" />
							<display:column property="projectmanagername" title="ProjectManager" />
							<display:column property="project" title="ProjectRefCode" />
							<display:column property="clientname" title="Cilent" />
							<display:column property="teamlead" title="Team Lead" />
							<display:column property="location" title="Location" />
							<display:column property="noofdayormonthallowance" title="NoOfDay/MonthAllowance" />
							<display:column property="datype" title="DAType" />
							<display:column property="singleteamgh" title="Single/Team/GH" />
								<display:column property="amount" title="Amount" />
									<display:column property="posteddatetime" title="PostedDate/Time" />
										<%-- <display:column property="remarks" title="Remarks" /> --%>
						</display:table>
						</center>
						
				<!-- 	</div> -->
					</logic:present>
					<br/>
</div>		
</div>
<br/>
	 <span id="dashboard_goBack" onclick="goback()" style="margin-left:90%;text-decoration: underline;
  cursor: pointer;">go Back</span>
</body>
</html>