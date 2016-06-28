
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/WEB-INF/displaytag.tld" prefix="display" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>


<% String username = (String)session.getAttribute("username");
	if(username== null){
		%>
		
		<jsp:forward page="login.jsp"></jsp:forward>
			
		 <%
	}else{
		

	}

%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Record</title>      
    </head>
    <body>
   		<jsp:include page="header_menu.jsp"></jsp:include>               
     	<br></br><br></br><br/> <br/>
    	<table width="700px" align="center" border="2" >
			<tbody id="inputtable" >
				<tr>
					<td colspan=8 align="center" ><b><h4>Employee Record</h4></b></td>
				</tr>
				<tr>
       				<td>
       					<display:table id="data" name="sessionScope.Displaytagform.list" requestURI="/displaytag.do" pagesize="10" export="true">
       				</td>
          	   			<display:column  property="empid" title="Employee Id"  media="html" group="1" />
           	   			<display:column property="empname" title="Employee Name" sortable="true" style="background-color:yellow"/>
               			<display:column property="date" title="Date" />
              			<display:column property="client" title="Client" style="background-color:yellow"/>
              			<display:column property="interviewmodefirst" title="Mode of interview" />
              			<display:column property="firstround" title="First Round" />
              			<display:column property="interviewmodesecond" title="Mode of interview" />
              			<display:column property="secondround" title="Second Round" />
              			<display:column property="interviewmodehr" title="Mode of interview" />
              			<display:column property="hrround" title="HR Round" />
           	   			<display:column property="interviewlocation" title="Interview Location" />
          	  			<display:column property="projectlocation" title="Project Location" />
              			<display:column property="status" title="Status of interview" style="background-color:yellow"/>
            	 		<display:column property="remarks" title="Remarks" />
            	</tr>
           		<display:setProperty name="export.excel.filename" value="Datasheet.xls"/>
            	<display:setProperty name="export.pdf.filename" value="ActorDetails.pdf"/>
            	<display:setProperty name="export.pdf" value="true"/>
      		</display:table>
        </table>
        <br></br><hr></hr>
		<jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>

