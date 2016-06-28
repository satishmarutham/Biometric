<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib prefix="logic" uri="/WEB-INF/struts-logic.tld"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>Letter Head</title>
<link rel="stylesheet" type="text/css" href="style.css" />
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
<link rel="stylesheet" href="JQUERY/css/jquery-ui.css"></link>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/Employee/LetterHead.js"></script>
<link rel="stylesheet" href="css/common.css"></link>
<link rel="stylesheet" href="css/login/style.css"></link>
<link rel="stylesheet" href="css/login/common.css"></link>


</head>

<body>
	<br></br>

	<div id="main">

		<center>

			<div class="background" id="backgroung">

				<div class="backgroundDiv" id="backgroung">Letter Head</div>
			


				<center>

					<div id="errordiv" class="error-box" align="center">

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

				<div class="backgroungDIV" id="backgroung">
				
				<form action="letterHead.do">
				<input type="hidden" name="method" value="insertLetterHead" ></input>
					
					
						<table cellpadding="8" cellspacing="5" id="biometric" width="50%">

							<tr class="trc">
								<td class="left">Letter Type<font color="red">*</font></td>
								<td class="right"><input type="text" name="lettertype" id="lettertype" /></td>

                             </tr>
                             <tr class="trc">
								<td class="left" >Purpose<font color="red">*</font> </td>
								<td class="right"><input type="text" name="purpose" id="purpose" /></td>
							 </tr>
							<tr class="trc">
								<td class="left" >Description<font color="red"></font></td>
								<td class="right"> <textarea name="description"	id="description" ></textarea></td>
                           </tr>
                          
						</table>
					
			
					<table>
						<tr>

							<td colspan="3"><center>
									<input type="submit" class="submitbutton" value="Submit" onclick="return validation()"  />
									&nbsp;&nbsp;&nbsp; <input type="reset" value="Clear"	 class="submitbutton" />
								</center></td>

						</tr>

					</table>
					</form>
				</div>
				
				<logic:present name="AllLetterHeads" scope="request">
						<display:table id="LEAVE" 
							name="requestScope.AllLetterHeads"
							class="view" style="width:80%;"
							requestURI="/letterHead.do?method=letterHeadHome"
							pagesize="10">
						
							<display:column property="lettertype" title="Letter Type" />
							<display:column property="purpose"	title="Purpose" />
							<display:column property="description" title="Description" />
							<%-- <display:column property="status" title="Status" /> --%>
							<display:column property="createtime" title="Create Time" />
								</display:table>
					</logic:present>
		<br/>

</div>
			</div>
		</center>
	</div>


</body>
</html>