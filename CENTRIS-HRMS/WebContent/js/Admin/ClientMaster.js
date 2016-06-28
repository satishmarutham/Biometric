function validations(){

	var clientName=$('#clientNameId').val();
	var country=$('#countryId').val();
	var state=$('#stateId').val();
	var address=$('#addressId').val();
	var phoneNo=$('#phoneNoId').val();
	

	
	 if(clientName==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Enter Client Name");

		return false;
		
	}else if(!clientName.match(/^[a-zA-Z ]+$/i)){
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Client Name should Be Alphabet");
	
		return false;
	}
	else if(phoneNo==""){
	  	  
	   	   $('.error-box').css({'visibility' : 'visible'});
	 		$("#errordiv").text("Enter Phone No");
	 		return false;
	    }
		 
	      else if(!phoneNo.match(/^[0-9]+$/i)){
	  		$('.error-box').css({'visibility' : 'visible'});
	  		$("#errordiv").text("Phone No should Be integer");

	  		return false;
	  		
	        }
	
	
	else if(country==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Enter Country");

		return false;
		
	}else if(!country.match(/^[a-zA-Z ]+$/i)){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Country Should Be Alphabet");
		return false;
	
	}else if(state==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Enter State");

		return false;
		
	}else if(!state.match(/^[a-zA-Z ]+$/i)){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("State Should Be Alphabet");
		return false;
	
	}else if(address==""){
    	$('.error-box').css({'visibility' : 'visible'});
  		$("#errordiv").text("Enter Address");
  		return false;  
     
      
      }
	else if(checkClientName()){
			
			$('.error-box').css({'visibility' : 'visible'});
			$("#errordiv").text("Client Name Already Exists");
			
			return false;
	 }
	 else{
		 
		 return true;
	 }

}



function checkClientName(){
	
	var status=false;
	
	var clientName=$('#clientNameId').val();
	
	var clientDetails={"clientName":clientName};
	
	$.ajax({

		type : "GET",
		url : "clientMasterPath.do?method=checkClientName",
		data : clientDetails,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);
			
			if (result.status) {
				
				status=true;
			
				$('.error-box').css({'visibility' : 'visible'});
				$("#errordiv").text("Client Name Already Exists");

			} else{
				
				status=false;
			}

		}

	});
	
	return status;
}


function editClientMaster() {
	
	
	var count = 0;
	var clientCode = null;

	$('input[name="selectBox"]:checked').each(function() {
		count = count + 1;
		clientCode = this.value;

	});

	if (count > 1 || count == 0) {

		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select any One Row");

	} else {

		var clientDetails = {
			"clientCode" : clientCode
		};

		$.ajax({
			type : "GET",
			url : "clientMasterPath.do?method=editClientDetails",
			data : clientDetails,
			async : false,

			success : function(data) {
				var result = $.parseJSON(data);
		$("#clientNameId").val(result.editDetailsList[0].clientName);
				$("#countryId").val(result.editDetailsList[0].country);
				$("#stateId").val(result.editDetailsList[0].state);
				$("#addressId").val(result.editDetailsList[0].address);
				$("#phoneNoId").val(result.editDetailsList[0].phoneNo);
				$("#clientCodeId").val(result.editDetailsList[0].clientCode);
			}
		});

	}
}
function deleteClientDetails() {

	var checkboxArray = document.getElementsByName('selectBox');
	var updaterowsArray = new Array();

	for ( var i = 0; i < checkboxArray.length; i++) {
		if (checkboxArray[i].checked == true) {
			updaterowsArray.push(checkboxArray[i].value);
		}
	}
	if (updaterowsArray.length <= 0) {
		$("#errordiv").show();
		$("#errordiv").text(" Select any Client to delete");
		$('.error-box').css({'visibility' : 'visible'});
		return false;
	} else {

		var x = confirm("Are you sure you want to delete this Client");
		if (x) {

			var clientDetails = {'clientCode':updaterowsArray};
			


			$
					.ajax({
						type : "POST",
						url : "clientMasterPath.do?method=deleteClientDetails",
						data : clientDetails,
						async : false,

						success : function(data) {
							var result = $.parseJSON(data);
							
							window.location = "GetDetails.do?parameter=getClientDetails&status="
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



function updateClientDetails(){


	var clientName=$('#clientNameId').val();
	var country=$('#countryId').val();
	var state=$('#stateId').val();
	var address=$('#addressId').val();
	var phoneNo=$('#phoneNoId').val();
	

	
	 if(clientName==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Enter ClientName");

		return false;
		
	}else if(!clientName.match(/^[a-zA-Z ]+$/i)){
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Client Name Should Be Alphabet");
	
		return false;
	}
	else if(phoneNo==""){
	  	  
	   	   $('.error-box').css({'visibility' : 'visible'});
	 		$("#errordiv").text("Enter Phone No");
	 		return false;
	    }
		 
	      else if(!phoneNo.match(/^[0-9]+$/i)){
	  		$('.error-box').css({'visibility' : 'visible'});
	  		$("#errordiv").text("Phone No Should Be Integer");

	  		return false;
	  		
	        }
	else if(country==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Enter Country");

		return false;
		
	}else if(!country.match(/^[a-zA-Z ]+$/i)){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Country Should Be Alphabet");
		return false;
	
	}else if(state==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Enter State");

		return false;
		
	}else if(!state.match(/^[a-zA-Z ]+$/i)){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("State Should Be Alphabet");
		return false;
	
	}else if(address==""){
    	$('.error-box').css({'visibility' : 'visible'});
  		$("#errordiv").text("Enter Address");
  		return false;  
     
      
      }
	else if(checkUpdateClientName()){
			
			$('.error-box').css({'visibility' : 'visible'});
			$("#errordiv").text("Client Name Already Exists");
			
			return false;
	 }
	 else{
		 
		 return true;
	 }

}
function checkUpdateClientName(){

	var status=false;
	
	var clientName=$('#clientNameId').val();
	var clientCode=$("#selectBox").val();
	
	var clientDetails={"clientName":clientName,
			"clientCode":clientCode};
	
	$.ajax({

		type : "GET",
		url : "clientMasterPath.do?method=checkUpdateClientName",
		data : clientDetails,
		async : false,

		success : function(data) {

			var result = $.parseJSON(data);
			
			if (result.status) {
				
				status=true;
			
				$('.error-box').css({'visibility' : 'visible'});
				$("#errordiv").text("Client Name Already Exists");

			} else{
				
				status=false;
			}

		}

	});
	
	return status;
}

