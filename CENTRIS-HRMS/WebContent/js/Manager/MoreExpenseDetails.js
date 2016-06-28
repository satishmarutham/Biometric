
$(document).ready(function(){
		

	if( ($('#currentstartdate').val()!=undefined) && ($('#currentenddate').val()!="")){
		
		$("#month option[value="+$('#currentstartdate').val().trim()+"]").attr('selected', 'true');
		$("#year option[value="+$('#currentenddate').val().trim()+"]").attr('selected', 'true');
		
	}
	
	
});

function validation(){
	
	var month=$("#month").val();
	var year=$("#year").val();

	
	
	if (month == '') {
		$("#errordiv").show();
		$("#errordiv").text("Select Month");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
		
	}else if (year == '') {
		$("#errordiv").show();
		$("#errordiv").text("Select Year");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		return false;
	
	}else{
	
	return true;

	
	}
	
	
}




