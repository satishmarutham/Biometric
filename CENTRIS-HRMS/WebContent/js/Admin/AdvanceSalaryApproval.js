$(document)
		.ready(
				function() {
			
					$("#update-dialog")
					.dialog(
							{

								autoOpen : false,
								center : 1,
								dialogtop : top,
								height : 350,
								width : 600,
								resizable: false,
								modal : true,
								buttons : {
									 
									"Confirm" : function() {
										$("#loading").hide();
										
								var advanceSalaryCode = $("#advanceSalaryCodeId").val();
								var requestedByCode=$("#requestedByCodeId").text();		
								var salaryAmount=$("#salaryId").text();
							var employeeCode=$("#employeeCodeValId").val();
						
								var approvedAmount=$("#approvedAmount").val();
								
								var regex_double ='^[0-9]*\.[0-9]*$';
								var int_regex = /^\d+$/;
								var salaryAmountVal=parseInt(salaryAmount);
							
								if (approvedAmount == "") {

									$("#error").show();
									$("#error").text("Enter Approved Amount");
									$(".error-box").css({'visibility':'visible'});
									return false;
								}
								else if(!((int_regex.test(approvedAmount)) || (approvedAmount.match(regex_double)))) {
								
									$("#error").show();
										$("#error").text("Approved Amount should be Integer or Double");
										$('.error-box').css({'visibility' : 'visible'});
										return false;
									}
								else if(approvedAmount > salaryAmountVal){
									$("#error").show();
									$("#error").text("Enter Valid Amount");
									$('.error-box').css({'visibility' : 'visible'});
									return false;
								}
								else
									{
								
											var dataList = {
													"advanceSalaryCode":advanceSalaryCode,
												"requestedByCode":requestedByCode,
												"approvedAmount":approvedAmount,
												"employeeCode":employeeCode,
												

											};
											
										
	$.ajax({
														type : 'POST',
														url : "advancedSalaryRequest.do?parameter=approveAdvancedSalary",
														data : dataList,
														beforeSend:function(){
														
															$("#loading").show();
														
															
															
														},
														complete: function(){
															
														},
													
														success : function(
																response) {
														
													var result = $.parseJSON(response);
															
															var successMessage=result.status;

															window.location.href = "GetDetails.do?parameter=getAdvanceSalaryRequest&successMessage="+successMessage;
														
															
														}

													});
											
											return jsonResult;
											$('ul li ul').show();
											
											
											$(this).dialog("close");
									}

									},
									"Hold" : function() {
										
                                       var advanceSalaryCode = $("#advanceSalaryCodeId").val();
										var requestedByCode=$("#requestedByCodeId").text();		
										var salaryAmount=$("#salaryId").text();
									var employeeCode=$("#employeeCodeValId").val();
								
										var approvedAmount=$("#approvedAmount").val();
										
										var regex_double ='^[0-9]*\.[0-9]*$';
										var int_regex = /^\d+$/;
										var salaryAmountVal=parseInt(salaryAmount);
									
										if (approvedAmount!="") {

										 if(!((int_regex.test(approvedAmount)) || (approvedAmount.match(regex_double)))) {
												
												$("#error").show();
													$("#error").text("Approved Amount should be Integer or Double");
													$('.error-box').css({'visibility' : 'visible'});
													return false;
												}
											else if(approvedAmount > salaryAmountVal){
												$("#error").show();
												$("#error").text("Enter Valid Amount");
												$('.error-box').css({'visibility' : 'visible'});
												return false;
											}
											else
												{
var dataList = {
																"advanceSalaryCode":advanceSalaryCode,
															
																"requestedByCode":requestedByCode,
																"approvedAmount":approvedAmount,
																"employeeCode":employeeCode,

														};

														$
																.ajax({
																	type : 'POST',
																	url : "advancedSalaryRequest.do?parameter=holdAdvanceSalary",
																	data : dataList,
																	success : function(
																			response) {

																		var result = $
																				.parseJSON(response);
																	
																		
																		var successMessage=result.status;

																		window.location.href = "GetDetails.do?parameter=getAdvanceSalaryRequest&successMessage="+successMessage;
																	
																			

													
																	}

																});
												
														

														
														 $('ul li ul').show();
														$(this).dialog("close");
												
											
										
												}
										}
										else
											{

											
													var dataList = {
															"advanceSalaryCode":advanceSalaryCode,
														
															"requestedByCode":requestedByCode,
															"approvedAmount":approvedAmount,
															"employeeCode":employeeCode,

													};

													$
															.ajax({
																type : 'POST',
																url : "advancedSalaryRequest.do?parameter=holdAdvanceSalary",
																data : dataList,
																success : function(
																		response) {

																	var result = $
																			.parseJSON(response);
																
																
																	var successMessage=result.status;

																	window.location.href = "GetDetails.do?parameter=getAdvanceSalaryRequest&successMessage="+successMessage;
																
																		

												
																}

															});
													
											
													

													
													 $('ul li ul').show();
													$(this).dialog("close");
											
										
									}
											},
									
									
											"Reject" : function() {

												var advanceSalaryCode = $("#advanceSalaryCodeId").val();
												var requestedByCode=$("#requestedByCodeId").text();		
												var salaryAmount=$("#salaryId").text();
											var employeeCode=$("#employeeCodeValId").val();
										
												var approvedAmount=$("#approvedAmount").val();
												
												var regex_double ='^[0-9]*\.[0-9]*$';
												var int_regex = /^\d+$/;
												var salaryAmountVal=parseInt(salaryAmount);
											
												if (approvedAmount!="") {

													 if(!((int_regex.test(approvedAmount)) || (approvedAmount.match(regex_double)))) {
															
															$("#error").show();
																$("#error").text("Approved Amount should be Integer or Double");
																$('.error-box').css({'visibility' : 'visible'});
																return false;
															}
														else if(approvedAmount > salaryAmountVal){
															$("#error").show();
															$("#error").text("Enter Valid Amount");
															$('.error-box').css({'visibility' : 'visible'});
															return false;
														}
														else
															{

															
															var dataList = {
																	"advanceSalaryCode":advanceSalaryCode,
																"requestedByCode":requestedByCode,
																"approvedAmount":approvedAmount,
																"employeeCode":employeeCode,
																

															};
															
														
					$.ajax({
																		type : 'POST',
																		url : "advancedSalaryRequest.do?parameter=rejectAdvanceSalary",
																		data : dataList,
																		beforeSend:function(){
																		
																			$("#loading").show();
																		
																			
																			
																		},
																		
																		success : function(
																				response) {
																			$("#loading").hide();
																	
																			
																			var result = $.parseJSON(response);
																			var successMessage=result.status;

																			window.location.href = "GetDetails.do?parameter=getAdvanceSalaryRequest&successMessage="+successMessage;
																		
																			
																		}

																	});
															
														/*	return jsonResult;*/
															$('ul li ul').show();
															
															
															$(this).dialog("close");
													
												
															
															
															}
													 
													
														
												}

												else
													{
												
															var dataList = {
																	"advanceSalaryCode":advanceSalaryCode,
																"requestedByCode":requestedByCode,
																"approvedAmount":approvedAmount,
																"employeeCode":employeeCode,
																

															};
															
														
					$.ajax({
																		type : 'POST',
																		url : "advancedSalaryRequest.do?parameter=rejectAdvanceSalary",
																		data : dataList,
																		beforeSend:function(){
																		
																			$("#loading").show();
																		
																			
																			
																		},
																		
																		success : function(
																				response) {
																		
																	
																			
																			var result = $.parseJSON(response);
																			var successMessage=result.status;

																			window.location.href = "GetDetails.do?parameter=getAdvanceSalaryRequest&successMessage="+successMessage;
																		
																			
																		}

																	});
															
														/*	return jsonResult;*/
															$('ul li ul').show();
															
															
															$(this).dialog("close");
													
												}
													
											},
										
									
									Cancel : function() {
										 $('ul li ul').show();
										$(this).dialog("close");

									}
									
								},
									

							});	
							
				});
				
function callApprovalDialog(bioId,employeeCode,employeeName,projectReferenceCode,requestedByCode,requestedByName,salary,requestedDate,advanceSalaryCode) {

$("#employeeCodeId").text(bioId);
$("#employeeNameId").text(employeeName);
$("#projectRefCodeId").text(projectReferenceCode);
$("#requestedByCodeId").text(requestedByCode);
$("#requestedByNameId").text(requestedByName);
$("#salaryId").text(salary);
/*$("#descriptionId").text(comment);*/
$("#requestedDateId").text(requestedDate);
$("#advanceSalaryCodeId").val(advanceSalaryCode);
$("#employeeCodeValId").val(employeeCode);
$("#update-dialog").dialog("open");

}

function validateApprovedAmount(salaryAmount){

}

