<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Employee</title>
<!-- <script type="text/javascript" src="JQUERY/js/jquery-1.8.3.js"></script> -->
<!-- <script type="text/javascript" src="JQUERY/js/jquery.ui.button.js"></script> -->
<!-- <script type="text/javascript" src="JQUERY/js/jquery.ui.core.js"></script> -->
<!-- <script type="text/javascript" src="JQUERY/js/jquery.ui.widget.js"></script> -->
<!-- <script type="text/javascript" src="JQUERY/js/jquery.ui.mouse.js"></script> -->
<!-- <script type="text/javascript" src="JQUERY/js/jquery.ui.draggable.js"></script> -->
<!-- <script type="text/javascript" src="JQUERY/js/jquery.ui.position.js"></script> -->
<!-- <script type="text/javascript" src="JQUERY/js/jquery.ui.resizable.js"></script> -->
<!-- <script type="text/javascript" src="JQUERY/js/jquery.ui.dialog.js"></script> -->
<!-- <script type="text/javascript" src="JQUERY/js/jquery.ui.datepicker.js"></script> -->
<!-- <script src="JQUERY/development-bundle/ui/jquery.ui.autocomplete.js"></script> -->
<!-- <link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link> -->
<script language="javascript" src="js/common.js"></script>
<link rel="stylesheet" href="css/common.css"></link>

<style >

table#biometric tr {
	padding: 1px;
}

table#biometric_1 td {
	font-family: "Segoe UI Semibold","Segoe UI";
	color: black;
	font-size: 12px;
	font-weight: normal;
	text-align: justify;
	margin: 1px;
	width: 20%;
	height: 70px;

	/* border: 1px solid #BDC3C7; */
}

table#biometric_1 th {
	font-family: "Segoe UI Semibold","Segoe UI";
	/* background-color: gray; */
	color: #FFFFFF;
}

table#biometric_1 label {
	font-family: "Segoe UI Semibold","Segoe UI";
	color: #003D52;
	font-size: 12px;
	font-weight: bold;
	text-align: center;
	font-family: "Segoe UI Semibold","Segoe UI";
}

.menuiconimg{

border-radius: 8px;
width: 80%;
height:50px;
}


.menuicontext{

text-align: center;
font-family: Segoe UI ;
color: #181818  ;
font-size: 14px;
font-weight: bold;


}

.Submenuicontext{

text-align: top;
font-family: Segoe UI ;
color: #505050   ;
font-size: 12px;


}

.inmenudiv{
border: solid 1px; cursor: pointer; 
border-color: #C0C0C0;
}

.inmenudiv:HOVER{

background-color: #E8E8E8;
}
.textarea{

border-r

}
</style>

</head>

<body>



	<div id="main" class="background">
		<center>
			<br></br> <br></br>
			<table id="ss" style="border: none !important;" cellpadding="3px"
				cellspacing="3px" width="60%">
				<tr>
					<td height="100%">
						<div class="inmenudiv">
							<table width="100%"  >
								<tr>
									<td width="25%">
										<center>
											<a href="departmentMaster.do?parameter=getDepRecords"><img
												src="menuicons/OgrStructureSubIcons/Departments.png"
												height="100%;" width="100%" id="empImagePreview"
												class="menuiconimg" /> </a>
										</center>
									</td >
									<td width="100%" ><span class="menuicontext">Departments<br /> <span
											class="Submenuicontext">You can create number of
												departments <br /> for an organization
										</span></span></td>
								</tr>
							</table>
						</div>
					</td>
                  <td width="15%">
									
				  </td>
					<td>
						<div class="inmenudiv">
							<table width="100%">
								<tr>
									<td width="25%">
										<center>
											<a href="adddesignation.do?parameter=addDesignation"><img
												src="menuicons/OgrStructureSubIcons/designation.jpg"
												id="empImagePreview" class="menuiconimg" /> </a>
										</center>
									</td>
									<td width="100%"><span class="menuicontext">Designation<br />
											<span class="Submenuicontext">You can create number of
												departments <br /> for an organization
										</span></span></td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
				<tr>
				 <td><br></br>              </td>
				
				</tr>
				<tr>
					<td width="40%">
						<div class="inmenudiv">
							<table width="100%">
								<tr>
									<td width="25%">
										<center>
											<a href="holidayMaster.do?parameter=getDetails"><img
												src="menuicons/OgrStructureSubIcons/holiday.jpg"
												id="empImagePreview" class="menuiconimg" /> </a>
										</center>
									</td>
									<td width="100%"><span class="menuicontext">Holiday<br /> <span
											class="Submenuicontext">You can create number of
												departments <br /> for an organization
										</span></span></td>
								</tr>
							</table>
						</div>
					</td>
					 <td width="20%">
									
									</td>
					
					
					<td>
						<div class="inmenudiv">
							<table width="100%">
								<tr>
									<td width="25%">
										<center>
											<a href="GetDetails.do?parameter=employeeWeekofSetting"><img
												src="menuicons/OgrStructureSubIcons/WeekoffSettings.jpg"
												id="empImagePreview" class="menuiconimg" /> </a>
										</center>
									</td>
									<td width="100%"><span class="menuicontext">WeekOff Settings<br />
											<span class="Submenuicontext">You can create number of
												departments <br /> for an organization
										</span>
									</span></td>
								</tr>
							</table>

						</div>
					</td>

				</tr>
			</table>

		</center>
	</div>


</body>



</html>
