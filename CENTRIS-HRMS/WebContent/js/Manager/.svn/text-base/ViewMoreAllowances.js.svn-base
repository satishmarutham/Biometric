$(document)
		.ready(
				function() {
					
								
					var hfromdate=$("#hfromdate").val().trim();
					var htodate=$("#htodate").val().trim();
					if(hfromdate!=""){
						
						$("#startdate").val(hfromdate);
					}
					
					if(htodate!=""){
					
						$("#enddate").val(htodate);
					}
					
					
					$("#startdate").datepicker({
						dateFormat : "dd-mm-yy",
						yearRange : 'c-65:c+65',
						maxDate : 0,
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,
							onClose : function(selectedDate) {
								
								
						         $("#enddate").datepicker("option", "minDate", selectedDate);
								
							}

					});
					
					
					$("#enddate").datepicker({
						dateFormat : "dd-mm-yy",
						yearRange : 'c-65:c+65',
						maxDate : 0,
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,
						
						onClose : function(selectedDate) {
							
						         $("#startdate").datepicker("option", "maxDate", selectedDate);
								
							}

					});
					
					
				
				
					
					
					
					
					
					
				});



function validate(){
	
	
	var startdate=$("#startdate").val();
	var enddate=$("#enddate").val();
	
	
	
	if(startdate==""){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select StartDate");
		
		
		return false;
		
	}else if(enddate==""){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select EndDate");
		
	
		
		return false;
		
	}else{
		
		return true;
	}
	
	
}

function downloadAllowances(){
	
	
	var startdate=$("#startdate").val();
	var enddate=$("#enddate").val();
	

	if(startdate==""){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select StartDate");
		
		
		return false;
		
	}else if(enddate==""){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select EndDate");
		
	
		
		return false;
		
	}else{
		
		document.location.href="employeeAllowances.do?method=downloadViewMoreAllowances&startdate="+startdate+"&enddate="+enddate;
	
	}
	
	
	
	
}








function goback(){
	
	document.location.href="employeeAllowances.do?method=employeeDailyAllowanceHome";
}



