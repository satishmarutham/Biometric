<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
    <%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Day Report</title>
<link rel="shortcut icon" href="images/favicon.ico">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    		<link type="text/css" href="menu.css" rel="stylesheet" />
		<link type="text/css" href="view.css" rel="stylesheet" />
    	<script type="text/javascript" src="jquery.js"></script>
    	<script type="text/javascript" src="menu.js"></script>
 
				  <style>
  .even {background-color:#72B0E4;color: #FFFFF;
				font-size: 13px;
				text-align: center;
				font-family: Arial, Helvetica, sans-serif;
				padding: 5px;}
  .odd {background-color:#BCD1E1;color: #000;
				font-size: 13px;
				text-align: center;
				font-family: Arial, Helvetica, sans-serif;
				padding: 5px;}
  </style>
</head>
 
<body>
<jsp:include page="header_menu.jsp"></jsp:include>	<br />
	<br />
	<br />
 	 <br/> <br/>
				<%List empstatuslist=(List)request.getAttribute("empststuslist");
				List empproductlist=(List)request.getAttribute("empprolist");
				
				List empstatusmnthlist=(List)request.getAttribute("empstatusmnthlist");
				

				if(empstatuslist==null&&empproductlist==null&&empstatusmnthlist==null)
				{
					out.print("<center><h3>Sorry No data Found</h3></center>");
				}
				if(empstatuslist!=null && empproductlist==null)
				{
				%>
					 <center>
<display:table export="true" frame="yes" id="data" name="requestScope.empststuslist" requestURI="/bioreport.do"  pagesize="20" cellpadding="5" cellspacing="6" size="20" style="bgcolor: RED;" >
            <display:column property="empid" title="EMPID" sortable="true" style="color:#171313"/>
            <display:column property="empname" title="EMPNAME" sortable="true"  style="color:#171313"/>
            <display:column property="empstatus" title="STATUS" sortable="true" style="color:#171313" />
            <display:column property="empdate" title="DATE" sortable="true" style="color:#171313" /> 
    		
    		<display:setProperty name="export.pdf.filename" value="AttendanceDayStatus.pdf" />
    		<display:setProperty name="export.pdf" value="true" />
    		
    		<display:setProperty name="export.excel.filename" value="AttendanceDayStatus.xls" />
    		<display:setProperty name="export.excel" value="true" />
    		
    		<display:setProperty name="export.csv.filename" value="AttendanceDayStatus.csv" />
    		<display:setProperty name="export.csv" value="true" />
    		
    		<display:setProperty name="export.xml.filename" value="AttendanceDayStatus.xml" />
    		<display:setProperty name="export.xml" value="true" />
    		
      </display:table>
      </center>	 	 
				 <%
				 }
				
				if(empstatuslist==null && empproductlist!=null)
				{
				%>
			<center>
			
	  <display:table export="true"  id="data" name="requestScope.empprolist" requestURI="/bioreport.do" pagesize="20" >
            <display:column property="date" title="DATE" sortable="true" style="color:#171313"  />
            <display:column property="empid" title="EMPID" sortable="true" style="color:#171313" />
            <display:column property="empname" title="EMPNAME" sortable="true" style="color:#171313" />
            <display:column property="intime" title="INTIME" sortable="true"  style="color:#171313"/> 
            <display:column property="outtime" title="OUTTIME" sortable="true"  style="color:#171313"/>
            <display:column property="totalhours" title="TOTALHOURS" sortable="true"  style="color:#171313"/> 
            <display:column property="workedhours" title="WORKEDHOURS" sortable="true" style="color:#171313" />
            <display:column property="mlate" title="MORNING LATE" sortable="true"  style="color:#171313"/>
            <display:column property="early" title="EVENING EARLY" sortable="true"  style="color:#171313"/>
    		
    		<display:setProperty name="export.pdf.filename" value="PRODUCTIVITYDAYREPORT.pdf" />
    		<display:setProperty name="export.pdf" value="true" /> 
    		 
    		<display:setProperty name="export.excel.filename" value="PRODUCTIVITYDAYREPORT.xls" />
    		<display:setProperty name="export.excel" value="true" />
    		
    		<display:setProperty name="export.csv.filename" value="PRODUCTIVITYDAYREPORT.csv" />
    		<display:setProperty name="export.csv" value="true" />
    		
    		<display:setProperty name="export.xml.filename" value="PRODUCTIVITYDAYREPORT.xml" />
    		<display:setProperty name="export.xml" value="true" />
      </display:table>
	 
			</center>
		 <%
		 }
				 %>
				 
				 
				 <!-- <td><input type="submit" value="Go Back" class="button1" onclick="history.go(-1);"/></td> -->
				 <br><br>
			<hr></hr>	
	<jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>