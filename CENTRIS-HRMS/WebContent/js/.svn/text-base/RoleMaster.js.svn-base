
$(document)
		.ready(
				function() {



setTimeout(function(){removeMessage();},5000);
					var errorBoxText = $('.error-box').text().trim();
					if(errorBoxText=="")
					$('.error-box').css({'visibility': 'hidden'});
					$('.error-box1').css({'visibility': 'hidden'});
					
				});

var roleName_validate=0;
var roleName_validate_update=0;
var edit_method=false;
function validateRoleName(){
	

	var roleName=$('#roleNameId').val();
	var roleObject={"roleName":roleName};
	

	
	$.ajax({
		
		type : "GET",
		url  : "role.do?parameter=validateRoleName",
		data : roleObject,
		async: false,
		
		success : function(data){
			
			var result = $.parseJSON(data);
			
			if(result){

				
					
					$("#errordiv").text("Role Name Already Exists");
					$('.error-box').css({'visibility': 'visible'});
					roleName_validate=1;
				
					
			}else{
				roleName_validate=0;
			}
	
		}
		
	});
	
	return roleName_validate;
}


function validateRoleNameUpdate(){
	

	var roleName=$('#roleNameId').val();
	var roleid=$("#roleCodeId").val();
	
	var roleObject={"roleName":roleName,"roleid":roleid};
	

	
	$.ajax({
		
		type : "GET",
		url  : "role.do?parameter=validateRoleNameUpdate",
		data : roleObject,
		async: false,
		
		success : function(data){
			
			var result = $.parseJSON(data);
			
			if(result){

				
					
					$("#errordiv").text("Role Name Already Exists");
					$('.error-box').css({'visibility': 'visible'});
					roleName_validate_update=1;
				
					
			}else{
				roleName_validate_update=0;
			}
	
		}
		
	});
	
	return roleName_validate_update;
	
}



function validations() {

	var roleName = $("#roleNameId").val();
	var roleDescription = $("#roleDescriptionId").val().trim();
	var roleid=$("#roleCodeId").val();
	var rolenamevalidations=/^[a-zA-Z0-9 _&.-]*$/g;
	
	 var regex = /^[A-Za-z][a-zA-Z0-9 _&.-]*$/;


if(roleid!=""){
	
	$("#errordiv").text("Role Already Exist if you want you can update");
	$('.error-box').css({'visibility': 'visible'});

	return false;
	
}else
	if (roleName == "") {

		$("#errordiv").text("Enter Role Name");
		$('.error-box').css({'visibility': 'visible'});

		return false;
	}else if( !( rolenamevalidations.test( roleName.trim() ) ) ){
		
		
		$('.error-box').css({'visibility': 'visible'});
		$("#errordiv").text("Role Name field only allow :0-9,a-z,_,&");
		
		return false;
	}else if( !( regex.test( roleName.trim() ) ) ){
		
		
		$('.error-box').css({'visibility': 'visible'});
		$("#errordiv").text("Role Name should start with alphabets");
		
		return false;
	}
	else if (roleDescription == "") {

		$("#errordiv").text("Enter Role Description");
		$('.error-box').css({'visibility': 'visible'});


		return false;

	} else {
		
		if(validateRoleName()==0){
			
			return true;
			
		}else{
			
			$("#errordiv").text("Role Name Already Exists");
			$('.error-box').css({'visibility': 'visible'});
			return false;
		}

	
	}

}

function validationsUpdate() {

	var roleName = $("#roleNameId").val();
	var roleDescription = $("#roleDescriptionId").val();
	var roleid=$("#roleCodeId").val();
	var rolenamevalidations=/^[a-zA-Z0-9 _&.-]*$/g;
	
	 var regex = /^[A-Za-z][a-zA-Z0-9 _&.-]*$/;
	

	if(roleid==""){
		
		$("#errordiv").text("Select Exist Role to Update");
		$('.error-box').css({'visibility': 'visible'});

		return false;
		
	}else 
	if (roleName == "") {

		$("#errordiv").text("Enter Role Name");
		$('.error-box').css({'visibility': 'visible'});

		return false;
	}else if( !( rolenamevalidations.test( roleName.trim() ) ) ){
		
		
		$('.error-box').css({'visibility': 'visible'});
		$("#errordiv").text("Employee Name field only allow Alphabet : a-z,_,&");
		
		return false;
	}else if( !( regex.test( roleName.trim() ) ) ){
		
		
		$('.error-box').css({'visibility': 'visible'});
		$("#errordiv").text("Role Name Should Start with Alphabets");
		
		return false;
	}	else if (roleDescription == "") {

		$("#errordiv").text("Enter Role Description");
		$('.error-box').css({'visibility': 'visible'});


		return false;

	} else {
		
		if(validateRoleNameUpdate()==0){
			
			return true;
			
		}else{
			
			$("#errordiv").text("Role Name Already Exists");
			$('.error-box').css({'visibility': 'visible'});
			return false;
		}	
	}
}

function editRole(){
	
	edit_method=true;
	
	
	var count=0;
	var role_id=null;
	
	 $('input[name="rolename"]:checked').each(function() {
		   count = count+1;
		   role_id=this.value;
		
		   
		});
	
	 if(count>1 || count==0){
		 
		 $("#errordiv").text("Select Any Role");
			$('.error-box').css({'visibility': 'visible'});
		
	 }else{
		 
		/*	document.getElementById("add").value="Update";*/
		 
		 var role={"role_id":role_id};
	$.ajax({
				type : "POST",
				url  : "role.do?parameter=updateRole",
				data : role,
				
                
				success : function(data) {
					var result = $.parseJSON(data);
				
					$("#roleNameId").val(result.UpdateList[0].roleName);
					$("#roleDescriptionId").val(result.UpdateList[0].roleDescription);
					$("#roleCodeId").val(result.UpdateList[0].roleCode);
					
					
				
							}
			});
		 
	 }
}

function cleardata(){
	
	edit_method=false;
	
	/*document.getElementById("add").value="Add";*/
	
	document.getElementById("roleCodeId").value="";
}

function deleteRole(){

	
	var count=0;
	var role_Code=null;
	
	 $('input[name="rolename"]:checked').each(function() {
		   count = count+1;
		   role_Code=this.value;
		
		   
		});
	 
	
	
	 if(count==0 ){
		 
		 $("#errordiv").text("Select Any Role");
			$('.error-box').css({'visibility': 'visible'});
	 }else{
		 
		  var x = confirm("Are you sure to Delete Role");
		  if (x){
			  
			 
		 var role={"role_Code":role_Code};
		
			$.ajax({
				type : "GET",
				url  : "role.do?parameter=deleteRole",
				data : role,
				async:false,

				success : function(data) {
					var result = $.parseJSON(data);
					
					
					var statusresult=(result.message).split(",,");
					
					if(statusresult[1]=='true'){
						
						$('.error-box').css({'visibility': 'hidden'});
						$("#errordiv1").text(statusresult[0]);
						$('.error-box1').css({'visibility': 'visible'});
						
						
					}else{
						
						$("#errordiv").text(statusresult[0]);
						$('.error-box').css({'visibility': 'visible'});
					}
					
					setTimeout(function(){
						
						  location.reload();
						  
						}, 3000);
		
				
				
							}
			
			});
			
			  
		  } 
		  
	
	}
}
function removeMessage() {
	
	$.ajax({
		type : "GET",
		url : "removeErrorMessage.do?method=removeMessage",
		async : false,
		success : function(data) {
			var errorBoxText = $('.error-box').text().trim();
			if(errorBoxText=="")
			$('.error-box').empty();
		}
	});
}
