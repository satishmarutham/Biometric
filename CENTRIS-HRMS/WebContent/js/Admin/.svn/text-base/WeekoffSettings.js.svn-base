
$(document)
		.ready(
				function() {
					
					
					
					$.ajax({
						type : "POST",
						url : "employeeAllowances.do?method=getAllClients",
						async:false,
						success : function(data) {
						
							var result= $.parseJSON(data);
							for ( var i = 0; i < result.clientDetails.length; i++) {
								$("#holidaycalen").append(
										'<option value="' + result.clientDetails[i].clientCode
												+ '">' + result.clientDetails[i].clientName
												+ '</option>');
							}
						}
					});
					
					
					$("#holidaycalen").change(function(){
						
						$("#mappedcalen").val($("#holidaycalen option:selected").text());
						$("#mappedcalencode").val($("#holidaycalen option:selected").val());
					});
					
					
					
					
                       $("#emp")
							.autocomplete(
									{

										source : function(request, response) {

											$
													.ajax({
														url : "employee.do?parameter=getEmpIdNameBySerachTerm",
														dataType : "json",
														async : false,
														data : {
															featureClass : "P",
															style : "full",
															maxRows : 10,
															name_startsWith : request.term
														},
														success : function(data) {
															response($
																	.map(
																			data.response,
																			function(
																					item) {
																				return {
																					label : item.empFirstName,
																					value : item.empCode,
																				}
																			}));

														}

													});
										},
										minLength : 1,
										select : function(event, ui) {

											var searchTerm = ui.item.value;
											
											
											employeedetails = {
												'EmpId' : searchTerm
											};
											var weekoffDetails = callAjax(
													"weekOffSetting.do?method=searchEmployee",
													employeedetails);

											$('#mappedcalen').val("");
											$('#mappedcalencode').val("");
											$('input:checkbox').removeAttr('checked');
											$('select').prop('selectedIndex',0);
											
											if(weekoffDetails.response!=""){
											        fillWeekoffSetting(weekoffDetails.response);
											}
											$("#emp").val(ui.item.label);
											$("#empCodeId").val(ui.item.value);
											return false;
										},
									});


				});

function fillWeekoffSetting(weekoffDetails) {
	
	$('#empCodeId').val(weekoffDetails[0].empCode);
	$('#sunday').attr('checked', weekoffDetails[0].sunday);
	$('#monday').attr('checked', weekoffDetails[0].monday);
	$('#tuesday').attr('checked', weekoffDetails[0].tuesday);
	$('#wednesday').attr('checked', weekoffDetails[0].wednesday);
	$('#thrusday').attr('checked', weekoffDetails[0].thrusday);
	$('#friday').attr('checked', weekoffDetails[0].friday);
	$('#saturday').attr('checked', weekoffDetails[0].saturday);
	$('#biometricId').val(weekoffDetails[0].biometricId);
	$('#hiddenBioId').val(weekoffDetails[0].biometricId);
	$('#mappedcalencode').val(weekoffDetails[0].clientcode);
	$('#mappedcalen').val(weekoffDetails[0].clientname);
}
function clearALL(){
	$('input:checkbox').removeAttr('checked');
}
var status=false;
function validateEmployeeCode(){
	
	var employeeCode=$("#empCodeId").val();
      var clientcode=$('#mappedcalencode').val();
	if(employeeCode==null || employeeCode==""){
		
	$('.error-box').css({'visibility' : 'visible'});
	$("#errordiv").text("Select Employee Name");
     return false;
	}else if(clientcode ==""){
    	$('.error-box').css({'visibility' : 'visible'});
		$("#errordiv").text("Select Holiday Calendar");
	     return false;
	}
	else
		{
	           status=true;
		}
	
return status;
	
}