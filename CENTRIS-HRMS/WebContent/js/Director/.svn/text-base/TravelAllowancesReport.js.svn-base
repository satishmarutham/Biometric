$(document)
		.ready(
				function() {
					
					
					var hfromdate=$("#hstartdate").val().trim();
					var htodate=$("#henddate").val().trim();
					var hstatus=$("#hstatus").val().trim();
					var hgroupby=$("#hgroupby").val().trim();
					
					
					if(hfromdate!=""){
						
						$("#startdate").val(hfromdate);
					}
					
					if(htodate!=""){
					
						$("#enddate").val(htodate);
					}
					
					if(hstatus!=""){
						
						$("#status option[value="+hstatus+"]").attr('selected','true');
					}
					
					if(hgroupby!=""){
						
						$("#groupby option[value="+hgroupby+"]").attr('selected','true');
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
					
					});
					
								
				$("#downloadTravelAllowanceDetails").click(function(){
					
					window.location.href = 'travelAllowanceReport.do?method=downloadTravelAllowanceDetails&fromdate='
										+ $("#startdate").val()
										+ ' &todate='
										+ $("#enddate").val()
					                    + ' &Status='
					                    + $("#status").val()
					                    + ' &Groupby='
					                    + $("#groupby").val();
					                    
					                   
				});
				
			
					
				});




function validate(){
	
	
	var startdate=$("#startdate").val();
	var endate=$("#enddate").val();
	
	var status=$("#status").val();
	var groupby=$("#groupby").val();
	
	if(startdate==""){
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Select StartDate");
		$("#startdate").addClass("ui-state-error");
		
		return false;
		
	}else if(endate==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Select EndDate");
		$("#enddate").addClass("ui-state-error");
			
		return false;
		
	}else if(status==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Select Status");
		$("#status").addClass("ui-state-error");
			
		return false;
		
	}else if(groupby==""){
		
		$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Select Group By");
		$("#groupby").addClass("ui-state-error");
			
		return false;
		
	}else{
		
		$('.error-box').css({'visibility' : 'hidden'});
		return true;
	}
	
	
}