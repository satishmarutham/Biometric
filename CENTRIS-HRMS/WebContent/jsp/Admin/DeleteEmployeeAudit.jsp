<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Delete Employee Audit</title>

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>
</head>
<body>
<div class="background" id="backgroung">
	<center>
	<div class="backgroundDiv" id="backgroung">Audit Reports for Employee Delete</div><br/>
		<logic:present name="deleteEmployeeAuditList" scope="request">


					<display:table id="deleteEmployeeAuditId" name="deleteEmployeeAuditList" export="false" pagesize="25" requestURI="/GetDetails.do"
					 class="view" style="width:73%;">

					

						<display:column property="sno" title="Sl.No" />
								<display:column property="bioId" title="Employee BioId" />
						<display:column property="employeeName" title="Employee Name" />
						<display:column property="officialEmailId" title="Official EmailId" />
						<display:column property="deletedBy" title="Deleted By" />
						<display:column property="deletedDate" title="Deleted Date" />
						


					</display:table>

				</logic:present>
	</center>
	</br>
</div>
</body>
</html>