
$(document)
		.ready(
				function() {
					var toDate=$("#htodate").val().trim();
					var fromDate=$("#hfromdate").val().trim();
					
					var groupBy=$("#hgroupBy").val().trim();
					var status=$("#hstatus").val().trim();
					if(toDate!=""){
					$("#todate").val(toDate);
					}
					
					if(status!=""){
						$("#statusId").val(status);
						}
					
					
					if(fromDate!=""){
						$("#fromdate").val(fromDate);
						}
					
					if(groupBy!=""){
						$("#groupById").val(groupBy);
						}
					
					
$("#todate").datepicker({
						dateFormat : "dd-mm-yy",
						yearRange : 'c-65:c+65',
						maxDate : 0,
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,
						
						onClose : function(selectedDate) {
								
								
						         $("#fromdate").datepicker("option", "minDate", selectedDate);
								
							}

					});
					
					
					$("#fromdate").datepicker({
						dateFormat : "dd-mm-yy",
						yearRange : 'c-65:c+65',
						maxDate : 0,
						changeMonth : "true",
						changeYear : "true",
						numberOfMonths : 1,
						
						onClose : function(selectedDate) {
							
						         $("#todate").datepicker("option", "maxDate", selectedDate);
								
							}

					});
					
	/*			$("#getDetailsId").click(function(){
					var startDate=$("#todate").val();
					var endDate=$("#fromdate").val();
					var groupBy=$("#groupById").val();
					var status=$("#statusId").val();
					var details={
							"startDate":startDate,
							"endDate":endDate,
							"groupBy":groupBy,
							"status":status,
					};
					
					$.ajax({
						type : "POST",
						url  : "advancedSalaryRequest.do?parameter=advanceSalaryConsolidateReport",
						data : details,
						async: false,
						
						success : function(data){
							
							var result = $.parseJSON(data);
						location.reload();
							window.location.href="advancedSalaryRequest.do?parameter=advanceSalaryConsolidateReport";
						}
								
				});	
				});*/
					
					$("#downloadAllowanceDetails").click(function(){
						var status=$("#hstatus").val().trim();
					
						
						window.location.href = 'getAllReports.do?method=downloadAdvanceSalaryConsolidateManager&startdate='
											+ $("#todate").val()
											+'&groupby='
											+ $("#groupById").val()
											+'&status='
											+ $("#statusId").val()
											+'&enddate='
											+ $("#fromdate").val();
							
						
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
					
				});
function validateForm(){
	var startDate=$("#todate").val();
	var endDate=$("#fromdate").val();
	var groupBy=$("#groupById").val();
	var status=$("#statusId").val();
	var d1 = Date.parse(dateConverter(startDate));
	var d2 = Date.parse(dateConverter(endDate));
	if(startDate==null || startDate==""){
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Start Date");

return false;
		}	
	
	if(endDate==null || endDate==""){
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select End Date");

return false;
		}	
	if(d1 > d2){
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("End Date Should Less then Start Date");

return false;
		}	
	
	if(groupBy==null || groupBy==""){
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select GroupBy");

return false;
		}	
	if(status==null || status==""){
		$('.error-box').css({
			'visibility' : 'visible'
		});
		$("#errordiv").text("Select Status");

return false;
		}	
	
	
}
function dateConverter(dateString) {
	var dateArray = [];
	var dateStringArray = dateString.split("-");
	dateArray.push(dateStringArray[2]);
	dateArray.push(dateStringArray[1]);
	dateArray.push(dateStringArray[0]);
	var dateString1 = dateArray.join("-");
	return dateString1;

}