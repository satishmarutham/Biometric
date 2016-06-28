$(document).ready(function(){
	
	
	$('#successmessge').hide();
	$('#fulldata').hide();
	$("#fulldataXLS").hide();
	$('#createpayslip').hide();
	
	var Thead = $('#depRecords thead').find('tr');
	$(
			'<tr><th  rowspan="2">SL No</th><th  rowspan="2">PF A/c</th><th  rowspan="2">Esi Code</th><th  rowspan="2">Emp Id</th><th rowspan="2">EmployeeName</th><th rowspan="2">Designation</th><th rowspan="2">Department</th><th colspan="10">ACTUAL</th><th colspan="10">EARNED</th><th colspan="8">DEDUCTIONS</th><th  rowspan="2">TakeHome</th><th  rowspan="2">SalaryPending</th><th  rowspan="2">Advance Salary</th><th  rowspan="2">NET PAY</th></tr>')
			.insertBefore(Thead);
	
	$('#depRecords thead').find('tr:nth-child(2)').find('th:lt(7)').remove();
	$('#depRecords thead')
	.find('tr:nth-child(2),tr:nth-child(3)')
	.find(
			'th:nth-last-child(1),th:nth-last-child(2),th:nth-last-child(3),th:nth-last-child(4)')
	.remove();
	
	
	$('#salaryDetails #depRecords')
	.delegate(
			'.advanceTakenClass',
			'change',
			function() {
				

				
				var textvalue = $(this).val();
				
				
				if (!isNaN(parseFloat(textvalue)) && parseFloat(textvalue) >= 0) {
					
					var netSalary = parseInt($(this).parent().next().next('td').text())-parseInt($("#totvalues_onfocus").val()) + parseInt(textvalue);
					var flag=true;
					
					if (netSalary < 0) {
						
						$(this).val($("#totvalues_onfocus").val());
						
						flag=false;
						
						$('.error-box').css({'visibility': 'visible'});
						$("#errordiv").text("NetSalary shold not be -ve values");
						
						$('#alertMessage')
								.text(
										"NetSalary shold not be -ve values");
					}
					
					if(flag){
					$(this).parent().next().next('td').text(netSalary);
					}
					
					}
				else {
				
					$('.error-box').css({'visibility': 'visible'});
					$("#errordiv").text("Please enter correct value for Salary advance");
					
					$(this).val("0");
				}
			
				
				});


	$('#salaryDetails #depRecords')
	.delegate(
			'.salaryadvanceTakenClass',
			'change',
			function() {
				
				var textvalue = $(this).val();
				var flag=true;
				
				if (!isNaN(parseFloat(textvalue)) && parseFloat(textvalue) >= 0) {
					
					var netSalary = parseInt($(this).parent().next('td').text())+parseInt($("#totvalues_onfocus").val()) - parseInt(textvalue);
					
					
					if (netSalary < 0) {
						
						$(this).val($("#totvalues_onfocus").val());
						
						flag=false;
						
						$('.error-box').css({'visibility': 'visible'});
						$("#errordiv").text("NetSalary shold not be -ve values");
						
						$('#alertMessage')
								.text(
										"NetSalary shold not be -ve values");
					}
					
					if(flag){
					$(this).parent().next('td').text(netSalary);
					}
					
					}
				else {
				
					$('.error-box').css({'visibility': 'visible'});
					$("#errordiv").text("Please enter correct value for Salary advance");
					
					$(this).val("0");
				}
			});
	
	

	$('#salaryDetails #depRecords')
	.delegate(
			'.salaryadvanceTakenClass',
			'focus',
			function() {
				
				$("#totvalues_onfocus").val($(this).val());
				
			});

	$('#salaryDetails #depRecords')
	.delegate(
			'.advanceTakenClass',
			'focus',
			function() {
				
				$("#totvalues_onfocus").val($(this).val());
				
			});
	
	
	$('.reportClass').click(function(){
		
		var month= $('#searchinfo').find('input.searchmonthint').val();
		var year=$('#searchinfo').find('td#searchedyear').text();
		var department=$('#searchinfo').find('input.searchdept').val();
		
		
			window.location.href="generatepayroll.do?parameter=getEmployeeSalarydetails&reportType="+$(this).attr('name')+"&month="+month+"&year="+year+"&department="+department;
		
	});





	$("#createpayslip").click(function(){
		
		window.location.href="generatepayroll.do?parameter=createPayslipFilter";
		
		
	});
	
	
	
});




function saveSalarydetails() {
	
	$('#errordiv').hide();
	
	var empId = [];
	var salaryadvance = [];
	var pendingsalary = [];
	var empNetSalary = [];

	$('#salaryDetails #depRecords').find('tr:gt(1)').map(
			function() {
				
				empId.push($(this).find('td:nth-child(4)').text());
				pendingsalary.push($(this).find('td:nth-child(37)').find('input.advanceTakenClass').val());
				empNetSalary.push($(this).find('td:nth-child(39)').text());
				salaryadvance.push($(this).find('td:nth-child(38)').find('input.salaryadvanceTakenClass').val());
			
			});

	var monthName = $('#searchinfo').find('input.searchmonthint').val();
	var year = $('#searchinfo').find('td#searchedyear').text();
	
	var dataArray = {
			
		'empId' : empId.join(),
		'salaryadvance' : salaryadvance.join(),
		'pendingsalary' : pendingsalary.join(),
		'empNetSalary' : empNetSalary.join(),
		'monthName' : monthName,
		'year' : year,
	};
	
	var answer = confirm("Are you sure to Confirm Payment");
	
	if (answer) {
		
		$('#depRecords input').attr('readonly', 'readonly');
	
	$.ajax({
		type : "POST",
		url : "generatepayroll.do?parameter=updatePayroll",
		data : dataArray,
		async : false,
		success : function(response) {

			var result = $.parseJSON(response);
			
			$('#successmessge').show();
			$("#successmessge").text(result.status);
			
				$('#createPaySlipId').hide();
				$('#fulldata').show();
				$("#fulldataXLS").show();
				$('#createpayslip').show();
			

		}
	});
	
	} else {
	}
	
}


function validate(){
	
	
	var dept=$("#department").val().trim();
	var month=$("#month").val().trim();
	var year=$("#year").val().trim();
	
	
	if(dept==""){
		
		$('.error-box').css({'visibility': 'visible'});
		$("#errordiv").text("Please select department");
		return false;
		
	}else 
		if(month==""){
			
			$('.error-box').css({'visibility': 'visible'});
			$("#errordiv").text("Please select month");
			return false;
			
		}else 
			if(year==""){
				
				$('.error-box').css({'visibility': 'visible'});
				$("#errordiv").text("Please select year");
				return false;
				
			}else{
				
				
				return true;
			}
	
	
	
	
}
