$(document).ready(function(){
		

		
	if( ($('#currentstartdate').val()!=undefined) && ($('#currentstartdate').val()!="")){
		
		$("#month option[value="+$('#currentstartdate').val().trim()+"]").attr('selected', 'true');
		$("#accyear option[value="+$('#currentenddate').val().trim()+"]").attr('selected', 'true');
		
	}
	
	
});

function validations(){
	
	
	var month=$("#month").val().trim();
	var year=$("#accyear").val().trim();
	
	if(month==""){
		
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