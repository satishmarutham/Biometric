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
							
							if(selectedDate!=""){
						         $("#startdate").datepicker("option", "maxDate", selectedDate);
							}
								
							}

					});
					
					var hstartdate=$("#hstartdate").val();
					var henddate=$("#henddate").val();
			
				if(hstartdate!=""){
					
					$("#startdate").val(hstartdate);
					$("#enddate").val(henddate);
				}
					
					
					
					
					
					
				});



function goback(){
	
	document.location.href="employeeMenu.do?parameter=home";
}
function gobacktoManager(empId,empName){
	
	document.location.href="EmpDashBoardInManager.do?method=employeeDashboardHome&empId="+empId+"&empName="+empName;
}

function validate(){
	
	var startdate = $("#startdate").val();
	var enddate = $("#enddate").val();
	
		
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

