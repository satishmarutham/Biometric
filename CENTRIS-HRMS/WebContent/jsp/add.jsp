<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>    
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@page import="java.util.*" %>


			<%
			  ArrayList<String> empid = (ArrayList)request.getAttribute("empid");
			  ArrayList<String> empname = (ArrayList)request.getAttribute("empname");
			  ArrayList<String> remark = (ArrayList)request.getAttribute("remark");
			  ArrayList<String> status =(ArrayList)request.getAttribute("status");
			  String date =  (String)request.getAttribute("date");
			 int size = empname.size();	
			%>

<% String username = (String)session.getAttribute("username");
	if(username== null){
		%>
		
		<jsp:forward page="login.jsp"></jsp:forward>
			
		 <%
	}else{
		

	}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@page import="javax.net.ssl.SSLEngineResult.Status"%>

<html >
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Modify Attendance</title>
		<link rel="stylesheet" type="text/css" href="style.css" />
 		<script language="javaScript" type="text/javascript" src="js/calender.js"></script>
 		<link href="calender.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	
	<jsp:include page="header_menu.jsp"></jsp:include>               
     <br></br>     <br></br>
     <br/> <br/>
         
	<center><font color="DBD8D8" size="5">Modify Attendance</font></center>
             
		<html:form action="/ModifyAttendence">
            <center>
      <input type="text" name="datum1" value="<%= date %>"><a href="#" onClick="setYears(1947, 2015);
       showCalender(this, 'datum1');">
      <img src="img/calender.png"></a>

	
	 <table id="calenderTable">
        <tbody id="calenderTableHead">
          <tr>
            <td colspan="4" align="center">
	          <select onChange="showCalenderBody(createCalender(document.getElementById('selectYear').value,
	           this.selectedIndex, false));" id="selectMonth">
	              <option value="0">Jan</option>
	              <option value="1">Feb</option>
	              <option value="2">Mar</option>
	              <option value="3">Apr</option>
	              <option value="4">May</option>
	              <option value="5">Jun</option>
	              <option value="6">Jul</option>
	              <option value="7">Aug</option>
	              <option value="8">Sep</option>
	              <option value="9">Oct</option>
	              <option value="10">Nov</option>
	              <option value="11">Dec</option>
	          </select>
            </td>
            <td colspan="2" align="center">
			    <select onChange="showCalenderBody(createCalender(this.value, 
				document.getElementById('selectMonth').selectedIndex, false));" id="selectYear">
				</select>
			</td>
            <td align="center">
			    <a href="#" onClick="closeCalender();"><font color="#003333" size="+1">X</font></a>
			</td>
		  </tr>
       </tbody>
       <tbody id="calenderTableDays">
         <tr style="">
           <td>Sun</td><td>Mon</td><td>Tue</td><td>Wed</td><td>Thu</td><td>Fri</td><td>Sat</td>
         </tr>
       </tbody>
       <tbody id="calender"></tbody>
    </table>
    </center> 
    
 <table width="658"  align="center" border="0" bgcolor="#4A5152" frame="box"  bordercolor="black">
    <thead>
	  SDFDSFSDFSDFDSF
    	<tr>
            
          <th width="70"  scope="col" align="center">Employee ID</th>   
          <th width="69"  scope="col" align="center">Employee Name</th>
           <th width="86"  scope="col" align="center">status</th>
                        
          <th width="86" scope="col" align="center">remark</th>
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
    				<option value="present">present</option>
    				<option value="absent">absent</option>
    			</select>
    		</td>
            <td><input type="text" size="10" name="remark" value="<%= remark.get(i) %>"></input></td>

            <!--<td><a href="#"><img src="images/user_edit.png" alt="" title="" border="0" /></a></td>
            <td><a href="#" class="ask"><img src="images/trash.png" alt="" title="" border="0" /></a></td>
        --></tr>
        <%} %>
        
        <tr>
    				<td colspan="4" align="center">
    					<html:submit value="submit"></html:submit>
    				</td>
    			
    			</tr>
    </tbody>
</table>

 </html:form>
 <br></br>
			<hr></hr>
<jsp:include page="footer.jsp"></jsp:include>
 
</body>
</html>