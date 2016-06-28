// #########################################
function checkStatus(tableID)
{
	var cbvalue=document.getElementById("select").value;
	if(cbvalue=="all")
	{
		 try {
	            var table = document.getElementById(tableID);
	            
	            var rowCount = table.rows.length;
	            
	            for(var i=0; i<rowCount; i++) 
		            {
	                var row = table.rows[i];
	                var chkbox = row.cells[0].childNodes[0];
	                if (null != chkbox && false == chkbox.checked)
		                 {
	                chkbox.checked=true;
		                 }
	            }
		 }

         catch(e)
	     {
	         alert(e);
	     }
           
	}


	if(cbvalue=="none1")
	{
		 try {
	            var table = document.getElementById(tableID);
	            
	            var rowCount = table.rows.length;
	            					
	            for(var i=0; i<rowCount; i++) 
		            {
	                var row = table.rows[i];
	                var chkbox = row.cells[0].childNodes[0];
	                if (null != chkbox && true == chkbox.checked)
		                 {
	                chkbox.checked=false;
	                
		                 }

		            }
	            
		 }

	            catch(e)
	            {
		            alert(e);
		            }
	            
	}
document.getElementById("select").value="none";
	
}


// #######################################################################
/**/
//############################################
function delRow() {
    
	tabBody=document.getElementById("inputtable");
	row=document.createElement("TR");
    try {
    var table = document.getElementById("inputtable");
    
    var rowCount = table.rows.length;
    if(rowCount>1)
    {	
    var flag=false;
    for(var i=1; i<rowCount; i++) {
        var row = table.rows[i];
        var chkbox = row.cells[0].childNodes[0];
        if (null != chkbox && true == chkbox.checked) {
        	flag=true;
            table.deleteRow(i);
            rowCount--;
            i--;
            if(rowCount==1)
            {
            	$(document).ready(function(){
                    $("button#del").hide();
                       
                }); 
            }
        }
         
    }
    
    if(!flag)
    {
        alert("select the row!");
    }
    }
    }
    catch(e) {
       alert("At least select one row before submit!");
    }
	}

function MeetingvalidateForm()
{
	var tabBody=document.getElementById("inputtable");
	var rowCount = tabBody.rows.length;
	var numpattern=/[0-9]/;
	var charpattern=/[a-zA-Z]/;	
	var validformat=/^\d{1,2}\/\d{1,2}\/\d{4}$/;
    //var flag=false;
    for(var i=1;i<rowCount;i++){
    	var row = tabBody.rows[i];
//##########################
var c=row.cells[0].childNodes[0].checked;
var empid=row.cells[1].childNodes[0].value;
var empname=row.cells[2].childNodes[0].value;
var date=row.cells[3].childNodes[0].value;
var client=row.cells[4].childNodes[0].value;
var interviewmodefirst=row.cells[5].childNodes[0].value;
var firstround=row.cells[6].childNodes[0].value;
var interviewmodesecond=row.cells[7].childNodes[0].value;
var secondround=row.cells[8].childNodes[0].value;
var interviewmodehr=row.cells[9].childNodes[0].value;
var hrround=row.cells[10].childNodes[0].value;
var interviewlocation=row.cells[11].childNodes[0].value;
var projectlocation=row.cells[12].childNodes[0].value;
var status=row.cells[13].childNodes[0].value;
var remarks=row.cells[14].childNodes[0].value;

if(empid==""||empname==""||date=="")
{
	
	alert("Dear User please enter all fields in row("+(i+1)+").....!");
	 	
	flag=false;
	return flag;
}
if (empname==null || empname==""||!empname .match(charpattern))
  {
  alert(" Dear User 'empname'field must be filled out with alphabets(a-z,A-Z)in row("+i+").....!");
  return false;
  }



if (date==null || date=="")
{
alert(" Dear User 'Date'field must be filled out in row("+(i+1)+").....!");
return false;
}
else if(!date.match(validformat)){
	alert("Invalid date,Please provide date in dd/mm/yyyy format in 'Date' field out in row("+(i+1)+").....");
	return false;
}



if (remarks==null || remarks==""||!remarks.match(charpattern))
{
alert(" Dear User 'remarks'field must be filled out with alphabets(a-z,A-Z)in row("+i+").....!");

return false;
}


}
}


//###########

function addOption(theSel){
oc = theSel.options.length;
	if(theSel.selectedIndex==oc-1){
	newOpt = window.prompt("Enter Here","");
	if(newOpt+"">""){
	theSel.options[oc] = new Option(theSel.options[oc-1].text);
	theSel.options[oc-1] = new Option(newOpt, newOpt, true, true);
	}
	}
}


function addRow(tbodyID) {

var table = document.getElementById(tbodyID);

var rowCount = table.rows.length;
var row = table.insertRow(rowCount);

var colCount = table.rows[0].cells.length;

for(var i=0; i<colCount; i++) {

    var newcell = row.insertCell(i);

    newcell.innerHTML = table.rows[0].cells[i].innerHTML;
    //alert(newcell.childNodes);
    switch(newcell.childNodes[0].type) {
        case "checkbox":
                newcell.childNodes[0].checked = false;
                break;
        case "text":
                newcell.childNodes[0].value = "";
                break;
        case "text":
            newcell.childNodes[0].value = "";
            break;
        case "text":
            newcell.childNodes[0].value = "";
            break;
        case "select-one":
                newcell.childNodes[0].selectedIndex = 0;
                break;
        case "select-one":
            newcell.childNodes[0].selectedIndex = 0;
            break;
        case "select-one":
            newcell.childNodes[0].selectedIndex = 0;
            break;
    case "select-one":
        newcell.childNodes[0].selectedIndex = 0;
        break; case "select-one":
            newcell.childNodes[0].selectedIndex = 0;
            break;
   
    }
}
}

function deleteRow(tbodyID) {
try {
var table = document.getElementById(tbodyID);
var rowCount = table.rows.length;

for(var i=0; i<rowCount; i++) {
    var row = table.rows[i];
    var chkbox = row.cells[0].childNodes[0];
    if(null != chkbox && true == chkbox.checked) {
        if(rowCount <= 1) {
            alert("Cannot delete all the rows.");
            break;
        }
        table.deleteRow(i);
        rowCount--;
        i--;
    }

}
}catch(e) {
    alert(e);
}
}


//###########################


function MeetingvalidateFormnew()
{
	var tabBody=document.getElementById("inputtable");
	var rowCount = tabBody.rows.length;
	var numpattern=/[0-6]/;
	var charpattern=/[a-zA-Z]/;	
	var validformat=/^\d{1,2}\/\d{1,2}\/\d{4}$/;
    //var flag=false;
    for(var i=1;i<rowCount;i++){
    	var row = tabBody.rows[i];
//validations for empty textfield& uncheckboxs
var c=row.cells[0].childNodes[0].checked;
var empid=row.cells[1].childNodes[0].value;
var firstname=row.cells[2].childNodes[0].value;
var lastname=row.cells[3].childNodes[0].value;
var gender=row.cells[4].childNodes[0].value;
var email_id=row.cells[5].childNodes[0].value;
var qualification=row.cells[6].childNodes[0].value;
var client=row.cells[7].childNodes[0].value;
var location=row.cells[8].childNodes[0].value;
var skills=row.cells[9].childNodes[0].value;
var comments=row.cells[10].childNodes[0].value;
var remarks=row.cells[11].childNodes[0].value;


if(empid==""||firstname==""||lastname==""||email_id==""||comments==""||remarks=="")
{
	
	alert("Dear User please enter all fields in row("+(i+1)+").....!");
	 	
	flag=false;
	return flag;
}
if (empid==null || empid==""||!empid .match(numpattern))
{
alert(" Dear User 'empid'field must be filled out with numbers of max size 6 in row("+(i)+").....!");
return false;
}

if (firstname==null || firstname==""||!firstname .match(charpattern))
  {
  alert(" Dear User 'firstname'field must be filled out with alphabets(a-z,A-Z)in row("+i+").....!");
  return false;
  }
if (lastname==null || lastname==""||!lastname .match(charpattern))
{
alert(" Dear User 'lastname'field must be filled out with alphabets(a-z,A-Z)in row("+i+").....!");
return false;
}





if (remarks==null || remarks==""||!remarks.match(charpattern))
{
alert(" Dear User 'remarks'field must be filled out with alphabets(a-z,A-Z)in row("+i+").....!");

return false;
}
if(c == false)

{
	alert("Dear User please check row ("+(i)+")before submit,otherwise please delete it");
	return false;
	}

}
}


//####################
