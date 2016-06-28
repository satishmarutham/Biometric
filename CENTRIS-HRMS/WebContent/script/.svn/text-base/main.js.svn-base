function getModule(u_name)
{
var xmlhttp;
/*if (p_id=="")
  {
  document.getElementById("statediv").innerHTML="";
  return;
  }*/
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("modulediv").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","getmodule.do?username="+u_name,true);
xmlhttp.send();
}
function getMenu(module_name)
{
var xmlhttp;
/*if (p_id=="")
  {
  document.getElementById("statediv").innerHTML="";
  return;
  }*/
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("menudiv").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","getmenu.do?modulename="+module_name,true);
xmlhttp.send();
}
function CheckAll()
{

//We then use an if statement to say that if the first checkbox (Select All) is checked then all checkboxes in the for loop must be checked.

if(document.xmlform.chkall.checked== true)
{
for(var i=0; i < document.xmlform.menuC.length; i++)
{
	
document.xmlform.menuC[i].checked=true;
}
for(var i=0; i < document.xmlform.menuP.length; i++)
{
	
document.xmlform.menuP[i].checked=true;
}


} 
}
function UnCheckAll()
{

//We then use an if statement to say that if the first checkbox (Select All) is checked then all checkboxes in the for loop must be checked.

if(document.xmlform.chkall.checked== false)
{
for(var i=0; i < document.xmlform.menuP.length; i++)
{
document.xmlform.menuP[i].checked=false;
}
for(var i=0; i < document.xmlform.menuC.length; i++)
{
document.xmlform.menuC[i].checked=false;
}

} 
}