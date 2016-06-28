$(document).ready(function(){

	$("#dailyAllowanceDate").datepicker(
			{
				dateFormat : "dd-mm-yy",
				yearRange : 'c-65:c+65',
				
				changeMonth : "true",
				changeYear : "true",
				numberOfMonths : 1,
				
			});

	
	$('#downloadDailyAllowance').click(function(){
		
		var date=$("#dailyAllowanceDate").val();
		
		
		if(date==""){
			
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("Please select date");
		
		}else{
			
			var datedetails={"date":date};
			
			$.ajax({
				type : "GET",
				url : "employeeDailyAllowance.do?method=chcekRecords",
				data : datedetails,
				async : false,

				success : function(data) {
					var result = $.parseJSON(data);
					
					if(result.status){
						
						window.location.href="getAllReports.do?method=downloadEmployeeDailyAllowance&date="+$('#dailyAllowanceDate').val().trim();
						
					}else{
						
						$('.error-box').css({
							'visibility' : 'visible'
						});
						$("#errordiv").text("No records found for selected date");
					}
					

				}
			});
			
			
	
	
		}
		
		});
	
	
	$('.accBody').css('display', 'none');
	$('.accBody:first').css('display', 'block');
	
	$('.accordHead').click(function() {
		var displaypro = $(this).next('div').css('display');
		if (displaypro == 'none') {
			$(this).next('div').css({
				'display' : 'block'
			});
		} else {
			$(this).next('div').css({
				'display' : 'none'
			});
		}
		$('div .accordHead:last-child', this).hide();
	});
	
	
	
	$("#viewDailyAllowance").click(function(){
		
		
		var date=$("#dailyAllowanceDate").val();
		
		
		if(date==""){
			
			$('.error-box').css({
				'visibility' : 'visible'
			});
			$("#errordiv").text("Please select date");

			return false;
			
		}else{
			
			var status=false;
			

			
			var datedetails={"date":date};
			
			$.ajax({
				type : "GET",
				url : "employeeDailyAllowance.do?method=chcekRecords",
				data : datedetails,
				async : false,

				success : function(data) {
					var result = $.parseJSON(data);
					
					status=result.status;
				}
			});
			
	
			if(!status){
		
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("No records found for selected date");
		
		return false;		
		
	}else{
			
			return true;
	
	}
		}
		
		
		
	});
	
	
	
	
});
	
	