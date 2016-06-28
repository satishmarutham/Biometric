

function editManager() {
	
	var count = 0;
	var managerId = null;

	$('input[name="selectBox"]:checked').each(function() {
		count = count + 1;
		managerId = this.value;

	});

	if (count > 1 || count == 0) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select any one Manger Row ");

	} else {

		var managerdetails = {
			"managerID" : managerId
		};

		$.ajax({
			type : "GET",
			url : "managerMaster.do?parameter=editManagerDetails",
			data : managerdetails,
			async : false,

			success : function(data) {
				var result = $.parseJSON(data);
		
				
				$("#firstName").val(result.ManagerList[0].firstname);
				$("#lastName").val(result.ManagerList[0].lastname);
				$("#mobileNO").val(result.ManagerList[0].mobileno);
				$("#userName").val(result.ManagerList[0].username);
				$("#managerEmail").val(result.ManagerList[0].manageremail);
				$("#managerId").val(result.ManagerList[0].managerid);
				
				$('#department option[value=' +result.ManagerList[0].department + ']').attr(
						'selected', 'selected');
				
			
				
				
	
				
				

			}
		});

	}
}

function deleteManager() {

	var checkboxArray = document.getElementsByName('selectBox');
	var updaterowsArray = new Array();

	for ( var i = 0; i < checkboxArray.length; i++) {
		if (checkboxArray[i].checked == true) {
			updaterowsArray.push(checkboxArray[i].value);
		}
	}
	if (updaterowsArray.length <= 0) {
		$("#errordiv").show();
		$("#errordiv").text(" Select any Manager to delete");
		$('.error-box').css({'visibility' : 'visible'});
		return false;
	} else {

		var x = confirm("Are you sure you want to delete this Manager");
		if (x) {

			var managerdetails = {'managerID':updaterowsArray};
			


			$
					.ajax({
						type : "GET",
						url : "managerMaster.do?parameter=deleteManager",
						data : managerdetails,
						async : false,

						success : function(data) {
							var result = $.parseJSON(data);
							
							window.location = "managerMaster.do?parameter=managerMasterHome&status="
									+ result.status;

						}
					});

		}
	}
}

function selectAll() {

	var selectall = document.getElementsByName("selectall");
	var checkboxArray = document.getElementsByName('selectBox');
	if (selectall[0].checked == true) {
		for ( var i = 0; i < checkboxArray.length; i++) {
			checkboxArray[i].checked = true;

		}
	} else {
		for ( var i = 0; i < checkboxArray.length; i++) {
			checkboxArray[i].checked = false;
		}
	}
}

function validations(){
	
	var firstname=$('#firstName').val();
	var lastname=$('#lastName').val();
	var mobileno=$('#mobileNO').val();
	var username=$('#userName').val();
	var manageremail=$('#managerEmail').val();
	
	var department=$('#department').val();
	
	 if(firstname==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Enter  First Name ");

		return false;
		
	}else if(!firstname.match(/^[a-zA-Z ]+$/i)){
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("First name field only allow alphabet : a-z");
	
		return false;
	}else if(lastname==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Enter Last Name");

		return false;
		
	}else if(!lastname.match(/^[a-zA-Z ]+$/i)){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Last name field only allow alphabet : a-z");
		return false;
	
	}else if(mobileno==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Enter Mobile Number");

		return false;
		
	}else if(!mobileno.match(/^[0-9]+$/i)){
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Mobile Number Should be Numeric");

		return false;
		
      }else if(username==""){
    	$('.error-box').css({'visibility' : 'visible'});
  		$("#errordiv").text("Enter User Name ");
  		return false;  
     
      
      }else if(!username.match(/^[a-z]([a-zA-Z0-9~@#$^*()_+=[\]{}|\\,.?: -])+$/i)){
    	  
    	  $('.error-box').css({'visibility' : 'visible'});
    		$("#errordiv").text("Username may consist of a-z, 0-9, underscores, begin with a letter ");
    		return false;
    }else if(manageremail==""){
  	  
   	   $('.error-box').css({'visibility' : 'visible'});
 		$("#errordiv").text("Enter Email Id ");
 		return false;
    }else if(!manageremail.match(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)){
    	  
    	 $('.error-box').css({'visibility' : 'visible'});
 		$("#errordiv").text("Please enter the valid mail ending with .com.");  
    
 		return false;
    
    }else if(checkManagerUsername()){
			
			$('.error-box').css({'visibility' : 'visible'});
			$("#errordiv").text("UserName Exist,Select Different UserName");
			
			return false;
	 }else if(checkEmail()){
		
		 $('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Email Exist,Select Different Email Id");
			
		return false;
		}
	 else if(department==""){
		 $('.error-box').css({'visibility' : 'visible'});
			$("#errordiv").text("Select Department");
			return false;
				 
	 }
	 
	 
	 else{
		 
		 return true;
	 }

}


function validationsUpdate(){
	
	
	var firstname=$('#firstName').val();
	var lastname=$('#lastName').val();
	var mobileno=$('#mobileNO').val();
	var username=$('#userName').val();
	var manageremail=$('#managerEmail').val();
	var department=$('#department').val();
	
	 if(firstname==""){
	
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Enter First Name ");

		return false;
		
	}else if(!firstname.match(/^[a-zA-Z ]+$/i)){
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("First name field only allow alphabet : a-z");
	
		return false;
	}else if(lastname==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Enter Last Name");

		return false;
		
	}else if(!lastname.match(/^[a-zA-Z ]+$/i)){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Last name field only allow alphabet : a-z");
		return false;
	
	}else if(mobileno==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Enter Mobile Number");

		return false;
		
	}else if(mobileno.length<10){
	
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Mobile Number Length Should Not be Less Than 10 ");

		return false;
		
	}else if(!mobileno.match(/^[0-9]+$/i)){
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Mobile Number Should be Numeric");

		return false;
		
      }else if(username==""){
    	$('.error-box').css({'visibility' : 'visible'});
  		$("#errordiv").text("Enter User Name ");
  		return false;  
     
      
      }else if(!username.match(/^[a-z]([a-zA-Z0-9~@#$^*()_+=[\]{}|\\,.?: -])+$/i)){
    	  
    	  $('.error-box').css({'visibility' : 'visible'});
    		$("#errordiv").text("Username may consist of a-z, 0-9, underscores, begin with a letter ");
    		return false;
    }else if(manageremail==""){
  	  
   	   $('.error-box').css({'visibility' : 'visible'});
 		$("#errordiv").text("Enter Email Id ");
 		return false;
    }else if(!manageremail.match(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)){
    	  
    	 $('.error-box').css({'visibility' : 'visible'});
 		$("#errordiv").text("Please enter the valid mail ending with .com.");  
    
 		return false;
    
    }else if(checkUpdateUsername()){
			
			$('.error-box').css({'visibility' : 'visible'});
			$("#errordiv").text("UserName Exist,Select Different UserName");
			
			return false;
	 }else if(checkUpdateEmail()){
		
		 $('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Email Exist,Select Different Email Id");
			
		return false;
	}
	 else if(department==""){
		 $('.error-box').css({'visibility' : 'visible'});
			$("#errordiv").text("Select Department");
			return false;
				 
	 }
	 
	 else{
		 
		 return true;
	     }
}


function checkManagerUsername(){
	
	var status=false;
	
	var user_name=$('#userName').val();
	
	var managerdetails={"username":user_name};
	
	$.ajax({

		type : "GET",
		url : "managerMaster.do?parameter=checkManagerCount",
		data : managerdetails,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);
			
			if (result.status) {
				
				status=true;
			
				$('.error-box').css({'visibility' : 'visible'});
				$("#errordiv").text("Manager Exist,Enter Different userName");

			} else{
				
				status=false;
			}

		}

	});
	
	return status;
}

 function checkEmail(){
	
 var status=false;
	
	var managerEmailId=$('#managerEmail').val().trim();
	var managerdetails={"emailid":managerEmailId};
	
	$.ajax({

		type : "GET",
		url : "managerMaster.do?parameter=checkManagerEmailCount",
		data : managerdetails,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);
			
			if (result.status) {
				
				status=true;

				$('.error-box').css({'visibility' : 'visible'});
				$("#errordiv").text("Email Exist,Enter Different Email Id");

			} else{
				
				status=false;
			}

		}

	});
	
	return status;
	
	
}



function checkUpdateUsername(){
	
	var status=false;
	
	var updateusername=$('#userName').val().trim();
	var managerid =$('#managerId').val().trim();
	
	var managerdetails={"managerID":managerid,"username":updateusername};
	
	$.ajax({

		type : "GET",
		url : "managerMaster.do?parameter=checkManagerCountUpdate",
		data : managerdetails,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);
			
			if (result.status) {
				
				status=true;
				$('.error-box').css({'visibility' : 'visible'});
				$("#errordiv").text("Manager already exist");

			} else{
				
				status=false;
			}

		}

	});
	
	return status;
}

function checkUpdateEmail(){
	
var status=false;
	
	var managerEmailId=$('#managerEmail').val().trim();
	var managerid =$('#managerId').val().trim();
	
	
	var managerdetails={"managerID":managerid,"emailid":managerEmailId};
	
	$.ajax({

		type : "GET",
		url : "managerMaster.do?parameter=checkUpdateEmailCount",
		data : managerdetails,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);
			
			if (result.status) {
				
				status=true;

				$('.error-box').css({'visibility' : 'visible'});
				$("#errordiv").text("Email Exist,Enter Different Email Id");

			} else{
				
				status=false;
			}

		}

	});
	
	return status;
	

	
	
	
}



