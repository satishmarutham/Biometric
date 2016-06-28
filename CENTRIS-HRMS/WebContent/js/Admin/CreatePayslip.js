
function validatePayRoleProcess(){
	
	var month=$('#month').val();
	var year=$('#year').val();
	var department=$('#dept').val();
	
	if(department==""){
		
	//	$('#alertMessage').text("Please Select Role");
		
		$('.error-box').css({'visibility': 'visible'});
		$("#errordiv").text("Please Select Department");
		
		return false;
		
	}else if(month==""){
		
		$('.error-box').css({'visibility': 'visible'});
		$("#errordiv").text("Please Select Month");
		//$('#alertMessage').text("Please Select Month");
		return false;
		
	}else if(year==""){
		
		//$('#alertMessage').text("Please Select Year");
		$('.error-box').css({'visibility': 'visible'});
		$("#errordiv").text("Please Select Year");
		return false;
		
	}else{
		
		return true;
	}
	
	
}