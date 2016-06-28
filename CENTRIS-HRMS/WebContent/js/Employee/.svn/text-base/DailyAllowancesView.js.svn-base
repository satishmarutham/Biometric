$(document)
		.ready(
				function() {
					
								
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

function goback(){
	
	document.location.href="employeeMenu.do?parameter=home";
}
function gobackToManagerHome(employeeId,employeename){
	
	document.location.href="EmpDashBoardInManager.do?method=employeeDashboardHome&empId="+employeeId+"&empName="+employeename;
	
}


