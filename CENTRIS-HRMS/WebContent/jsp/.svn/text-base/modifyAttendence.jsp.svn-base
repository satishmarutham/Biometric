<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="java.util.*" %>

<% String username = (String)session.getAttribute("username");
	if(username== null){
		 %>
		
		<jsp:forward page="login.jsp"></jsp:forward>
			
		 <%
	}else{
		

	}

%>

			<%
			  ArrayList<String> empid = (ArrayList)request.getAttribute("empid");
			  ArrayList<String> empname = (ArrayList)request.getAttribute("empname");
			  ArrayList<String> remark = (ArrayList)request.getAttribute("remark");
			  ArrayList<String> status =(ArrayList)request.getAttribute("status");
			  String date =  (String)request.getAttribute("date");
			 int size = empname.size();	
			%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="javax.net.ssl.SSLEngineResult.Status"%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<link rel="shortcut icon" href="images/favicon.ico">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>MODIFY ATTENDANCE</title>
		
		 		<link rel="stylesheet" type="text/css" href="view.css" />
		 		<style type="text/css">
			 .form1

		 {
	position:absolute;
	top:87px;
	left:221px;
	width:auto;
	height:auto;
	padding:10px;
	border:2px solid gray;
	margin:5px;
	background-color: #C3C3C3;
		 }

input

{

background-color:#FFF;

 color:#333;

border: 1px solid #CED8F6

}

texta

{

background-color:#FFF;

 color:#FFF;

border: 1px solid #CED8F6

}



.button1{
-webkit-box-shadow: rgba(0, 0, 0, 0.0976562) 0px 1px 0px 0px;
	background-color:#313839;
	border: 1px solid #999;
	color: #CCC;
	font-family: 'Lucida Grande', Tahoma, Verdana, Arial, Sans-serif;
	font-size: 11px;
	font-weight: bold;
	padding: 2px 6px;
	height: 28px;
}
}



fieldset

{

border: 1px solid #000000;

width: 20em

}



 

label

{

	font-family: Tahoma, Geneva, sans-serif;

	font-size: 11px;

	width: auto;

	float: left;

	text-align: right;

	margin-right: 0.5em;

	display: block

}

.buttonstyle {

	-moz-box-shadow:inset 0px 1px 0px 0px #f29c93;

	-webkit-box-shadow:inset 0px 1px 0px 0px #f29c93;

	box-shadow:inset 0px 1px 0px 0px #f29c93;

	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #fe1a00), color-stop(1, #ce0100) );

	background:-moz-linear-gradient( center top, #fe1a00 5%, #ce0100 100% );

	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#fe1a00', endColorstr='#ce0100');

	background-color:#fe1a00;

	-moz-border-radius:6px;

	-webkit-border-radius:6px;

	border-radius:6px;

	border:1px solid #d83526;

	display:inline-block;

	color:#ffffff;

	font-family:arial;

	font-size:15px;

	font-weight:bold;

	padding:6px 24px;

	text-decoration:none;

	text-shadow:1px 1px 0px #b23e35;

}.buttonstyle:hover {

	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ce0100), color-stop(1, #fe1a00) );

	background:-moz-linear-gradient( center top, #ce0100 5%, #fe1a00 100% );

	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ce0100', endColorstr='#fe1a00');

	background-color:#ce0100;

}.buttonstyle:active {

	position:relative;

	top:1px;

}

 

 		body,td,th {
	color: #999;
}
   		body {
	background-color: ;
}
			
			
			.ds_box {
				background-color: #FFF;
				border: 1px solid #000;
				position: absolute;
				z-index: 32767;
				}

			.ds_tbl {
				background-color: #FFF;
				}

			.ds_head {
				background-color: #333;
				color: #FFF;
				font-family: Arial, Helvetica, sans-serif;
				font-size: 13px;
				font-weight: bold;
				text-align: center;
				letter-spacing: 2px;
				}

			.ds_subhead {
				background-color: #CCC;
				color: #000;
				font-size: 12px;
				font-weight: bold;
				text-align: center;
				font-family: Arial, Helvetica, sans-serif;
				width: 32px;
			}

			.ds_cell {
				background-color: #EEE;
				color: #000;
				font-size: 13px;
				text-align: center;
				font-family: Arial, Helvetica, sans-serif;
				padding: 5px;
				cursor: pointer;
				}

			.ds_cell:hover {
				background-color: #F3F3F3;
				} /* This hover code won't work for IE */

		</style>
	</head>
	<body>
	
	
	<table class="ds_box" cellpadding="0" cellspacing="0" id="ds_conclass" style="display: none;">
			<tr><td id="ds_calclass"></td></tr>
		</table>

		<script type="text/javascript">
			// <!-- <![CDATA[
			// Project: Dynamic Date Selector (DtTvB) - 2006-03-16
			// Script featured on JavaScript Kit- http://www.javascriptkit.com
			// Code begin...
			// Set the initial date.
			var ds_i_date = new Date();
			ds_c_month = ds_i_date.getMonth() + 1;
			ds_c_year = ds_i_date.getFullYear();

			// Get Element By Id
			function ds_getel(id) {
				return document.getElementById(id);
			}

			// Get the left and the top of the element.
			function ds_getleft(el) {
				var tmp = el.offsetLeft;
				el = el.offsetParent
				while(el) {
					tmp += el.offsetLeft;
					el = el.offsetParent;
				}
				return tmp;
				}
			function ds_gettop(el) {
				var tmp = el.offsetTop;
				el = el.offsetParent
				while(el) {
					tmp += el.offsetTop;
					el = el.offsetParent;
				}
				return tmp;
			}


			// Output Element
			var ds_oe = ds_getel('ds_calclass');
			// Container
			var ds_ce = ds_getel('ds_conclass');

			// Output Buffering
			var ds_ob = ''; 
			function ds_ob_clean() {
				ds_ob = '';
			}
			function ds_ob_flush() {
				ds_oe.innerHTML = ds_ob;
				ds_ob_clean();
			}
			function ds_echo(t) {
				ds_ob += t;
			}

			var ds_element; // Text Element...

			var ds_monthnames = [
			'January', 'February', 'March', 'April', 'May', 'June',
			'July', 'August', 'September', 'October', 'November', 'December'
			]; // You can translate it for your language.

			var ds_daynames = [
			'Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'
			]; // You can translate it for your language.

			// Calendar template
			function ds_template_main_above(t) {
				return '<table cellpadding="3" cellspacing="1" class="ds_tbl">'
				     + '<tr>'
					 + '<td class="ds_head" style="cursor: pointer" onclick="ds_py();"><<</td>'
					 + '<td class="ds_head" style="cursor: pointer" onclick="ds_pm();"><</td>'
					 + '<td class="ds_head" style="cursor: pointer" onclick="ds_hi();" colspan="3">[Close]</td>'
					 + '<td class="ds_head" style="cursor: pointer" onclick="ds_nm();">></td>'
					 + '<td class="ds_head" style="cursor: pointer" onclick="ds_ny();">>></td>'
					 + '</tr>'
				     + '<tr>'
					 + '<td colspan="7" class="ds_head">' + t + '</td>'
					 + '</tr>'
					 + '<tr>';
			}

			function ds_template_day_row(t) {
				return '<td class="ds_subhead">' + t + '</td>';
				// Define width in CSS, XHTML 1.0 Strict doesn't have width property for it.
			}

			function ds_template_new_week() {
				return '</tr><tr>';
			}

			function ds_template_blank_cell(colspan) {
				return '<td colspan="' + colspan + '"></td>'
			}

			function ds_template_day(d, m, y) {
				return '<td class="ds_cell" onclick="ds_onclick(' + d + ',' + m + ',' + y + ')">' + d + '</td>';
				// Define width the day row.
			}

			function ds_template_main_below() {
				return '</tr>'
				     + '</table>';
			}

			// This one draws calendar...
			function ds_draw_calendar(m, y) {
				// First clean the output buffer.
				ds_ob_clean();
				// Here we go, do the header
				ds_echo (ds_template_main_above(ds_monthnames[m - 1] + ' ' + y));
				for (i = 0; i < 7; i ++) {
					ds_echo (ds_template_day_row(ds_daynames[i]));
				}
				// Make a date object.
				var ds_dc_date = new Date();
				ds_dc_date.setMonth(m - 1);
				ds_dc_date.setFullYear(y);
				ds_dc_date.setDate(1);
				if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
					days = 31;
				} else if (m == 4 || m == 6 || m == 9 || m == 11) {
					days = 30;
				} else {
					days = (y % 4 == 0) ? 29 : 28;
				}
				var first_day = ds_dc_date.getDay();
				var first_loop = 1;
				// Start the first week
				ds_echo (ds_template_new_week());
				// If sunday is not the first day of the month, make a blank cell...
				if (first_day != 0) {
					ds_echo (ds_template_blank_cell(first_day));
				}
				var j = first_day;
				for (i = 0; i < days; i ++) {
					// Today is sunday, make a new week.
					// If this sunday is the first day of the month,
					// we've made a new row for you already.
					if (j == 0 && !first_loop) {
						// New week!!
						ds_echo (ds_template_new_week());
					}
					// Make a row of that day!
					ds_echo (ds_template_day(i + 1, m, y));
					// This is not first loop anymore...
					first_loop = 0;
					// What is the next day?
					j ++;
					j %= 7;
				}
				// Do the footer
				ds_echo (ds_template_main_below());
				// And let's display..
				ds_ob_flush();
				// Scroll it into view.
				ds_ce.scrollIntoView();
			}

			// A function to show the calendar.
			// When user click on the date, it will set the content of t.
			function ds_sh(t) {
				// Set the element to set...
				ds_element = t;
				// Make a new date, and set the current month and year.
				var ds_sh_date = new Date();
				ds_c_month = ds_sh_date.getMonth() + 1;
				ds_c_year = ds_sh_date.getFullYear();
				// Draw the calendar
				ds_draw_calendar(ds_c_month, ds_c_year);
				// To change the position properly, we must show it first.
				ds_ce.style.display = '';
				// Move the calendar container!
				the_left = ds_getleft(t);
				the_top = ds_gettop(t) + t.offsetHeight;
				ds_ce.style.left = the_left + 'px';
				ds_ce.style.top = the_top + 'px';
				// Scroll it into view.
				ds_ce.scrollIntoView();
			}

			// Hide the calendar.
			function ds_hi() {
				ds_ce.style.display = 'none';
			}

			// Moves to the next month...
			function ds_nm() {
				// Increase the current month.
				ds_c_month ++;
				// We have passed December, let's go to the next year.
				// Increase the current year, and set the current month to January.
				if (ds_c_month > 12) {
					ds_c_month = 1; 
					ds_c_year++;
				}
				// Redraw the calendar.
				ds_draw_calendar(ds_c_month, ds_c_year);
			}

			// Moves to the previous month...
			function ds_pm() {
				ds_c_month = ds_c_month - 1; // Can't use dash-dash here, it will make the page invalid.
				// We have passed January, let's go back to the previous year.
				// Decrease the current year, and set the current month to December.
				if (ds_c_month < 1) {
					ds_c_month = 12; 
					ds_c_year = ds_c_year - 1; // Can't use dash-dash here, it will make the page invalid.
				}
				// Redraw the calendar.
				ds_draw_calendar(ds_c_month, ds_c_year);
			}

			// Moves to the next year...
			function ds_ny() {
				// Increase the current year.
				ds_c_year++;
				// Redraw the calendar.
				ds_draw_calendar(ds_c_month, ds_c_year);
			}

			// Moves to the previous year...
			function ds_py() {
				// Decrease the current year.
				ds_c_year = ds_c_year - 1; // Can't use dash-dash here, it will make the page invalid.
				// Redraw the calendar.
				ds_draw_calendar(ds_c_month, ds_c_year);
			}

			// Format the date to output.
			function ds_format_date(d, m, y) {
				// 2 digits month.
				m2 = '00' + m;
				m2 = m2.substr(m2.length - 2);
				// 2 digits day.
				d2 = '00' + d;
				d2 = d2.substr(d2.length - 2);
				// YYYY-MM-DD
				return y + '-' + m2 + '-' + d2;
			}

			// When the user clicks the day.
			function ds_onclick(d, m, y) {
				// Hide the calendar.
				ds_hi();
				// Set the value of it, if we can.
				if (typeof(ds_element.value) != 'undefined') {
					ds_element.value = ds_format_date(d, m, y);
				// Maybe we want to set the HTML in it.
				} else if (typeof(ds_element.innerHTML) != 'undefined') {
					ds_element.innerHTML = ds_format_date(d, m, y);
				// I don't know how should we display it, just alert it to user.
				} else {
					alert (ds_format_date(d, m, y));
				}
			}

			// And here is the end.

			// ]]> -->
			</script>
	
	<jsp:include page="header_menu.jsp"></jsp:include>               
     <br></br>     <br/> <br/>
     
         <center>
	<center>
			<font
				style="font-family: sans-serif; font-weight: bolder; color: #000000; font-size: 17px;">MODIFY ATTENDANCE</font>
		</center>
             <br>
		<html:form action="/ModifyAttendence">
            <center>
      				<input onclick="" name="datum1" readonly="readonly" style="cursor: text" value="<%= date %>"/><br />
    </center> 
     <br>
<table id="biometric">
    <thead>
	  
    	<tr>
            
          <th align="center"><bean:message key="AddEmployee.employeeID"/></th>   
          <th align="center"><bean:message key="AddEmployee.employeeName"/></th>
           <th align="center">Status</th>
          <th align="center">Remark</th>
            <!--<th width="44" class="rounded" scope="col">Edit</th>
            <th width="48" class="rounded-q4" scope="col">Delete</th>
        --></tr>
    </thead>
        
    <tbody>
    	
    		 <% for(int i=0; i<size; i++)
       		 	{
    		 %>
    		 
    		  
    		  
    	<tr>
            <td><input type="text" size="6" name="empID" value="<%= empid.get(i) %>" readonly="readonly"/></td>
            <td><input type="text" size="10" name="empName" value="<%= empname.get(i) %>" readonly="readonly"></input></td>
            
            <td>
            	<select name="status" size="1">
            	<option value="<%= status.get(i) %>"><%= status.get(i) %></option>
    				<option value="Present">Present</option>
    				<option value="Absent">Absent</option>
    				<option value="Holiday">Holiday</option>
    				<option value="NA">NA</option>
    				
    			</select>
    		</td>
    		
    		<!--
     			max = (a > b) ? a : b;
             -->
            
            <% String rem = ((remark.get(i)== null)||(remark.get(i).equals(" "))||(remark.get(i).equalsIgnoreCase("null")))? "NA" : remark.get(i); %>
            
            <td><input type="text" size="10" name="remark" value=<%= rem %>></input></td>
			
		 
           </tr>
        <%} %>
        
            </tbody>
</table>
<br>
<table>
        <tr>
    				<td colspan="4" align="center">
    					<% if(size!=0){ %>
    					<input type="submit" value="Submit" class="button1"  />
    					<%} %>
    					<input type="button" value="Go back " class="button1" onclick="history.go(-1);" />	
    				</td>
    			
    			</tr>

</table>
 </html:form>
 </center>
 <br></br>
			<hr></hr>
<jsp:include page="footer.jsp"></jsp:include>
 
</body>
</html>