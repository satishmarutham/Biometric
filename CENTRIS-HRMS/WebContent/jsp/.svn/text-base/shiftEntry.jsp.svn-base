<%@ page import="java.util.Vector"%>
<%@ page import="java.util.Enumeration"%>

<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
     
<HTML>
<HEAD>
<link rel="shortcut icon" href="images/favicon.ico">
<title>Shift Creation</title>
<link type="text/css" rel="stylesheet" href="./style/main.css"></link>
 <link type="text/css" rel="stylesheet" href="./style/menu.css"/>
    <script type="text/javascript" src="./script/jquery.js"></script>
    <script type="text/javascript" src="./script/menu.js"></script>
	<link rel="stylesheet" type="text/css" href="js/menu_styles.css">
	<LINK REL=StyleSheet HREF="css/epins.css" TYPE="text/css"/>
	<script language="javascript" src="js/datetimepicker.js"></script>	
	<script language="javascript" src="js/globals.js"></script>
	<script type="text/javascript" src="js/popupconstants.js"></script>
	<script language="javascript" src="js/usercreation.js"></script>
	<script language="javascript" src="js/messageconstant.js"></script>
</HEAD> 
<BODY bgcolor="" class="windowMargin" >
 <jsp:include page="header_menu.jsp"></jsp:include>
 <br/> <br/>
<div id="main">
<div style="position:absolute;top:200px;left:100px">
	<form name="frm_usercreation" method="post" > 
	
	<table class="table" align="center" width="500" border=0 >
	<tr>
		<th class="rowHeader" colspan="2" align="center"><font size="1">Shift Creation</font></th>
	</tr>
	<tr>
	    <td class="reqAttribute">User Id</td>
	 	<td>
	 	<input type="textbox" name="txt_user_id" value="" size="20"  maxlength='15'/></td>
		</tr>
	<tr>
	    <td class="reqAttribute">User Name</td>
	 	<td>
	 	<input type="textbox" name="txt_user_name" value="" size="20"  maxlength='15'/></td>
		<!-- <input type="textbox" name="txt_user_name" value="" size="20"  maxlength='15' onkeypress='return validateData(event)' /> -->
		</tr>
		<tr><td class="reqAttribute">Password</td>
	 	<td><input type="password" name="txt_password" size="20" value="" maxlength='15'/></td>
	 	<!-- <input type="password" name="txt_password" size="20" value="" maxlength='15' onkeypress='return validateData(event)'/> -->
	 </tr>
	 
	 <tr>	
	 	<td class="reqAttribute">Module Name</td>
	 	<td>
	 	<SELECT class="combo" name="cmb_module" size="1" >
	 	<option value="0">-----------Select---------</option>
	 	 
 		 
	 	</SELECT>
		</td>					
	 </tr>
	 <tr>	
	 	<td class="reqAttribute">Status</td>
	 	<td>
	 	<SELECT class="combo" name="cmb_status" size="1" >
	 	<option value="0">-----------Select---------</option>
	 	<option value="Y">Y</option>
	 	<option value="N">N</option>
	    </SELECT>
		</td>					
	 </tr>
	 <!--<tr>
	 	<td  colspan="2" align="center" class="optAttribute">
	 	Active <input type="checkbox" checked="true" name="chk_active" class="optAttribute" onClick="check('true')" disabled='true'>
	 	Inactive<input type="checkbox" name="chk_inactive" onClick="check('false')" disabled='true' >
	 <input type='hidden' name='previous_module'><input type='hidden' name='previous_username'></input>
	
	 	</td>
		
	</tr>
	
	--><tr>
	 	
	 	
	 	<td colspan="2" align="center" class="optAttribute">Show All<input type="checkbox" name="chk_showall" onclick="showAllActive()">
	   
	 	
	 	</td>
	 	</tr>	
	 	<tr height="20">
		<td colspan="2" align="center">
			<input type="hidden" name='flag' value='insert'/><input type="hidden" name='statusEnable' value='disable'/>
			<input type="Button" name="insert" value="Insert" onclick="ins()" class='clickable button blue' style="padding: .05em .05em .10em;"/>
			<input type="Button" name="modify" value="Update" onclick="upd()" disabled='true' style="padding: .05em .05em .10em;" />
			<input type="Button" name="delete" value="Delete" onclick="del()"  class='clickable button blue' style="padding: .05em .05em .10em;"/>
			<input type="Button"  name="clear" value="Clear" onclick="clear12()" class='clickable button blue' style="padding: .05em .05em .10em;"/>
		</td>
		</tr>
	 	</table>
	 	<br></br><br></br>
	 	<table border="1">				
	
	

	</table>	

    <!--The Tabular Grid Starts here -->
<center>
  <div id="tbl-container">
    <table id="tblData" class="table" border=1 cellpadding="2" width="900" align="center" class='clickable'>
	 
	<table id="tblData" class="table" border=1 cellpadding="2" width="900" align="center" class='clickable'>
	<!--<THEAD> --> 
	    <th class="rowHeader">User Id</th>
		<th class="rowHeader">User Name</th>
		<th class="rowHeader">Password</th>
		<th class="rowHeader">Module Name</th>
		<th class="rowHeader">Status</th> 
    <!--   </THEAD>-->
    
       
 
        
	<tr  class="altLineOne" onClick="javascript:ChangeColor();this.className='selectLine';makeDisable('1','2');return PopulateData('3','4', '5', '6')" class='clickable'>
	<tr  class="altLineOne" onClick="javascript:ChangeColor();this.className='selectLine';makeDisable('mod1','mod2');return PopulateData('mod3','mod4', 'mod5', 'mod6')" class='clickable'>


		<!--<tr  class="altLineTwo" onClick="javascript:ChangeColor();this.className='selectLine';makeDisable('mod1','mod1');return PopulateData('mod1','mod1', 'mod1', 'mod1')" class='clickable'>
	
		<TD  align="center">SFDFS1</a></TD>
		<TD  align="center">21</TD>
		<TD  align="center">11</TD>
		<TD  align="center">Inactive</TD>
		</tr>
     
		
	--></TABLE>
	
	
	</table>
	</form>
	</div>
	</div>
</BODY>
</HTML>