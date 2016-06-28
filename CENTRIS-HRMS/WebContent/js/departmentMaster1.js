function insertDepartment()
    {  
	$("#depName").val("");
	$("#depDesc").val("");
	$("#depLoc").val("");
	$("#localManMail").val("");
	$("#hrManMail").val("");
	$("#onsiteManMail").val("");
	
        $("#insertDep").dialog({
    	      autoOpen: true,
    	    center : 1,
    		  dialogtop : top,
    		  height : 400,
    		  width : 700,
    		  modal : true,
    		  buttons : {
    		 add:function()
            	 {
    			 var validForm=validateForm();
    			 alert(validForm);
    			if (validForm){
            	  document.getElementById("insertDepForm").action="departmentMaster.do?parameter=addDepartment";
            	  document.getElementById("insertDepForm").submit();
    			}
            	 },
                  cancel : function()
                           {
    				       $(this).dialog("close");
                           }
               }
        });
      }
      

function updateDepartment(depId,depName,desc,depLoc,locManagerMail,hrManagerMail,onsiteManagerMail)
{  
	$("#depName").val(depName);
	$("#depDesc").val(desc);
	$("#depLoc").val(depLoc);
	$("#localManMail").val(locManagerMail);
	$("#hrManMail").val(hrManagerMail);
	$("#onsiteManMail").val(onsiteManagerMail);
	
	$("#updateDep").dialog({
	      autoOpen: true,
	    center : 1,
		  dialogtop : top,
		  height : 400,
		  width : 700,
		  modal : true,
		  buttons : {
		 update:function()
        	 {
			 var validForm=validateForm();
			 alert(validForm);
 			 if (validForm){
 				document.getElementById("updateDepForm").action="departmentMaster.do?parameter=updateDepartment&depId="+depId;
 				 document.getElementById("updateDepForm").submit();
			 }
        	 },
              cancel : function()
                       {
				       $(this).dialog("close");
                       }
           }
    });
  }     

function checkRegexp(mailId, regexp) {
		if (!regexp.test(mailId.val())) {
			
			return false;
		} else {
			return true;
		}
	}

function validateForm(){
	alert(document.getElementById("localManMail"));
	alert(document.getElementById("hrManMail"));
	alert(document.getElementById("onsiteManMail"));
	var hrManMail=$("#hrManMail").val();
	var onsiteManMail=$("#onsiteManMail").val();
	var localManMail=$("#localManMail").val();
	alert("1"+$("#hrManMail"));
	alert("2"+$("#onsiteManMail"));
	alert("3"+$("#localManMail"));
	alert("validateForm() entrance");
	if($("#depName").val()=="" || $("#depLoc").val()=="" ||  $("#locManMail").val()=="" 
			 
		 || $("#hrManMail").val()=="" ||$("#onsiteManMail").val()=="" ||$("#desc").val()=="" )
		{    
		alert("please provide the required data");     
		$("#error").text("please enter all the mandatory fields displayed in *");
			 return false;
		}	 
	if($("#depName")=="" || $("#depLoc")=="" ||  $("#locManMail")=="" 
		 
		 || $("#hrManMail")=="" ||$("#onsiteManMail")=="" ||$("#desc")=="" )
		{    
		alert("please provide the required data");     
		$("#error").text("please enter all the mandatory fields displayed in *");
			 return false;
		}
		 else if( $("#hrManMail")!="")
		 {
			 alert("email validation");
			 var flag;
			
			
			alert($("#hrManMail").val());
			alert($("#onsiteManMail"));
			alert($("#localManMail"));
			flag=checkRegexp($("#hrManMail"),/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i)
			&&checkRegexp($("#onsiteManMail"),/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i)
			&&checkRegexp($("#localManMail"),/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i);
	
			flag=checkRegexp($("#hrManMail").val(),/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/)
			&&checkRegexp($("#onsiteManMail").val(),/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/)
			&&checkRegexp($("#localManMail").val(),/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/);
			alert("after email validation");
			if(flag==false)
				 {
				 $("#error").text("Please enter the correct email format");
				 return flag;
				 }
			 else
				 return true;
			 }
			 
	    }




