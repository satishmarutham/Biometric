$(document).ready(function(){
		

	
	if(($('#hemiid').val()!=undefined) && ($('#hemiid').val()!="")){
		
		$("#employee option[value="+$('#hemiid').val().trim()+"]").attr('selected', 'true');
	}
	
	if( ($('#currentempid').val()!=undefined) && ($('#currentempid').val()!="")){
		
		
		
		$("#employee option[value="+$('#currentempid').val().trim()+"]").attr('selected', 'true');
		$("#month option[value="+$('#currentstartdate').val().trim()+"]").attr('selected', 'true');
		$("#accyear option[value="+$('#currentenddate').val().trim()+"]").attr('selected', 'true');
		
	}
	
	
});

function validations(){
	
	
	var empId=$("#employee").val().trim();
	var month=$("#month").val().trim();
	var year=$("#accyear").val().trim();
	
	if(empId==""){
		
		$("#errordiv").show();
		$("#errordiv").text("Select Employee");
		$('.error-box').css({'visibility': 'visible'});
		
		return false;
		
	}else if(month==""){
		
		$("#errordiv").show();
		$("#errordiv").text("Select Month");
		$('.error-box').css({'visibility': 'visible'});
		
		return false;
		
	}else if(year==""){
		
		$("#errordiv").show();
		$("#errordiv").text("Select Year");
		$('.error-box').css({'visibility': 'visible'});
		
		return false;
		
	}else{
		
		return true;
		
	}
	
}