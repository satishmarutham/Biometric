$(document)
		.ready(
				function() {
					
					$(".advancePaid").attr('readonly', 'true'); 
					$("#successdiv").hide();
					
					$(".hidden").css("display", "none");
					

					if (($('#sel_year').val() != '')
							&& ($('#sel_year').val() != undefined)) {
						$(
								'#year option[value='
										+ $('#sel_year').val().trim() + ']')
								.attr('selected', 'selected');
						$(
								'#month option[value='
										+ $('#sel_month').val().trim() + ']')
								.attr('selected', 'selected');
					}
					$('#year,#month').change(function() {
						if ((month != '') && (year != '')) {
							$("#errordiv").hide();
						}
					});

					$('#viewExpenseDetailsId').click(function() {
						var flag = true;

						var year = $('#year').val().trim();
						var month = $('#month').val().trim();

						if (month == '') {
							$("#errordiv").show();
							$("#errordiv").text("Select Month");
							$('.error-box').css({
								'visibility' : 'visible'
							});
							return false;
							flag = false;
						}
						if (year == '') {
							$("#errordiv").show();
							$("#errordiv").text("Select Year");
							$('.error-box').css({
								'visibility' : 'visible'
							});
							return false;
							flag = false;
						}
						if (flag) {
							$("#errordiv").hide();
						}
						return flag;
					});
					
					$('table#emp_Expence #empExpenseApprove')
							.click(
									function() {

										
										var flag = true;

										var mang_Id = $(this).parents(
												'tr:first').find(
												'td:nth-child(22)').find(
												'input').val();
										var emp_Id = $(this)
												.parents('tr:first').find(
														'td:nth-child(2)')
												.text();
										var totexpVal = $(this).parents(
												'tr:first').find(
												'td:nth-child(15)').text();
										var approvedVal = $(this).parents(
												'tr:first').find(
												'td:nth-child(16)').find(
												'input').val().trim();
										var advpaidVal = $(this).parents(
												'tr:first').find(
												'td:nth-child(17)').find(
												'input').val().trim();
										
										
										if (approvedVal=='' || isNaN(approvedVal)) {
											$("#errordiv").show();
											$("#errordiv")
													.text(
															"Total Approved accept only Numeric");
											$('.error-box').css({
												'visibility' : 'visible'
											});
											return false;
											flag = false;
										}
										if (advpaidVal=='' || isNaN(advpaidVal)) {
											$("#errordiv").show();
											$("#errordiv").text("Advance Paid accept only Numeric");
											$('.error-box').css({
												'visibility' : 'visible'
											});
											return false;
											flag = false;
										}
										if ((parseFloat(totexpVal)) < (parseFloat(approvedVal))) {
											$("#errordiv").show();
											$("#errordiv")
													.text(
															"Total Approved should be less than Total Expense");
											$('.error-box').css({
												'visibility' : 'visible'
											});
											return false;
											flag = false;
										}

										if ((parseFloat(approvedVal)) < (parseFloat(advpaidVal))) {
											$("#errordiv").show();
											$("#errordiv")
													.text(
															"Advance Paid should be less than Total Approved");
											$('.error-box').css({
												'visibility' : 'visible'
											});
											return false;
											flag = false;
										}
										if (flag) {
											$("#errordiv").hide();
											$("#errordiv").text("");
											$('.error-box').css({
												'visibility' : 'none'
											});
											$(this)
													.parents('tr:first')
													.find('td:nth-child(18)')
													.find('input')
													.val(
															parseFloat(approvedVal)
																	- parseFloat(advpaidVal));
											flag = true;
										}

										var balanceVal = $(this).parents(
												'tr:first').find(
												'td:nth-child(18)').find(
												'input').val().trim();
										if ((approvedVal == 0)
												&& (advpaidVal == 0)) {
											$("#errordiv").show();
											$("#errordiv")
													.text(
															"Enter Total Approved to Approve");
											$('.error-box').css({
												'visibility' : 'visible'
											});
											return false;
											flag = false;
										}

										if (flag) {

										
											var x = confirm("Are you sure you want to approve expense");
											if (x) {

												var jsonObject = {
													'expense_empId' : emp_Id,
													'expense_MangId' : mang_Id,
													'expense_totApproved' : approvedVal,
													'expense_Advancepaid' : advpaidVal,
													'expense_Balance' : balanceVal,
													'expense_month' : $(
															"#sel_month").val()
															.trim(),
													'expense_year' : $(
															"#sel_year").val()
															.trim()
												};
												
												
												$
														.ajax({
															method : 'POST',
															url : 'managerExpenseDetails.do?method=approveExpenseDetails',
															data : jsonObject,
															beforeSend : function() {

																$('#loader')
																		.show();

															},
															success : function(
																	data) {
																var result = $
																		.parseJSON(data);
																$('#loader')
																		.hide();
																if (result.approve_Result == "success") {

																	$(
																			"#successdiv")
																			.show();
																	$(
																			"#successdiv")
																			.text(
																					"Expense Details Approved Successfully");
																	$(
																			'.success-box')
																			.css(
																					{
																						'visibility' : 'visible'
																					});
																	setTimeout(
																			function() {
																				window.location.href = "managerMenu.do?parameter=getExpenseConsolidatedDetail";
																			},
																			3000);

																} else if (result.approve_Result == "MialNotSent") {

																	$(
																			"#errordiv")
																			.show();
																	$(
																			"#errordiv")
																			.text(
																					"Expense Details Approved Successfully,Mail not Sent");
																	$(
																			'.error-box')
																			.css(
																					{
																						'visibility' : 'visible'
																					});
																	setTimeout(
																			function() {
																				window.location.href = "managerMenu.do?parameter=getExpenseConsolidatedDetail";
																			},
																			3000);

																} else {
																	$(
																			"#errordiv")
																			.show();
																	$(
																			"#errordiv")
																			.text(
																					"Please try again, after some time");
																	$(
																			'.error-box')
																			.css(
																					{
																						'visibility' : 'visible'
																					});
																}
															}
														});
											}

										}

									});
					
					
					$('table#emp_Expence #empExpenseReject')
					.click(
							function() {

								
								var flag = true;

							
								var mang_Id = $(this).parents(
										'tr:first').find(
										'td:nth-child(22)').find(
										'input').val();
								var emp_Id = $(this)
										.parents('tr:first').find(
												'td:nth-child(2)')
										.text();
								var totexpVal = $(this).parents(
										'tr:first').find(
										'td:nth-child(15)').text();
								var approvedVal = $(this).parents(
										'tr:first').find(
										'td:nth-child(16)').find(
										'input').val().trim();
								var advpaidVal = $(this).parents(
										'tr:first').find(
										'td:nth-child(17)').find(
										'input').val().trim();
								
								if (approvedVal=='' || isNaN(approvedVal)) {
									$("#errordiv").show();
									$("#errordiv")
											.text(
													"Total Approved accept only Numeric");
									$('.error-box').css({
										'visibility' : 'visible'
									});
									return false;
									flag = false;
								}
								if (advpaidVal=='' || isNaN(advpaidVal)) {
									$("#errordiv").show();
									$("#errordiv").text("Advance Paid accept only Numeric");
									$('.error-box').css({
										'visibility' : 'visible'
									});
									return false;
									flag = false;
								}
								if ((parseFloat(totexpVal)) < (parseFloat(approvedVal))) {
									$("#errordiv").show();
									$("#errordiv")
											.text(
													"Total Approved should be less than Total Expense");
									$('.error-box').css({
										'visibility' : 'visible'
									});
									return false;
									flag = false;
								}

								if ((parseFloat(approvedVal)) < (parseFloat(advpaidVal))) {
									$("#errordiv").show();
									$("#errordiv")
											.text(
													"Advance Paid should be less than Total Approved");
									$('.error-box').css({
										'visibility' : 'visible'
									});
									return false;
									flag = false;
								}
								if (flag) {
									$("#errordiv").hide();
									$("#errordiv").text("");
									$('.error-box').css({
										'visibility' : 'none'
									});
									$(this)
											.parents('tr:first')
											.find('td:nth-child(18)')
											.find('input')
											.val(
													parseFloat(approvedVal)
															- parseFloat(advpaidVal));
									flag = true;
								}

								var balanceVal = $(this).parents(
										'tr:first').find(
										'td:nth-child(18)').find(
										'input').val().trim();
								if ((approvedVal == 0)
										&& (advpaidVal == 0)) {
									$("#errordiv").show();
									$("#errordiv")
											.text(
													"Enter Total Approved to Approve");
									$('.error-box').css({
										'visibility' : 'visible'
									});
									return false;
									flag = false;
								}

								if (flag) {

								
									var x = confirm("Are you sure you want to reject expense");
									if (x) {

										var jsonObject = {
											'expense_empId' : emp_Id,
										    'expense_MangId' : mang_Id,
											'expense_totApproved' : approvedVal,
											'expense_Advancepaid' : advpaidVal,
											'expense_Balance' : balanceVal,
											'expense_month' : $(
													"#sel_month").val()
													.trim(),
											'expense_year' : $(
													"#sel_year").val()
													.trim()
										};
										
										

										$
												.ajax({
													method : 'POST',
													url : 'managerExpenseDetails.do?method=rejectExpenseDetails',
													data : jsonObject,
													beforeSend : function() {

														$('#loader')
																.show();

													},
													success : function(
															data) {
														var result = $
																.parseJSON(data);
														$('#loader')
																.hide();
														if (result.approve_Result == "success") {

															$(
																	"#successdiv")
																	.show();
															$(
																	"#successdiv")
																	.text(
																			"Expense Details Approved Successfully");
															$(
																	'.success-box')
																	.css(
																			{
																				'visibility' : 'visible'
																			});
															setTimeout(
																	function() {
																		window.location.href = "managerMenu.do?parameter=getExpenseConsolidatedDetail";
																	},
																	3000);

														} else if (result.approve_Result == "MialNotSent") {

															$(
																	"#errordiv")
																	.show();
															$(
																	"#errordiv")
																	.text(
																			"Expense Details Approved Successfully,Mail not Sent");
															$(
																	'.error-box')
																	.css(
																			{
																				'visibility' : 'visible'
																			});
															setTimeout(
																	function() {
																		window.location.href = "managerMenu.do?parameter=getExpenseConsolidatedDetail";
																	},
																	3000);

														} else {
															$(
																	"#errordiv")
																	.show();
															$(
																	"#errordiv")
																	.text(
																			"Please try again, after some time");
															$(
																	'.error-box')
																	.css(
																			{
																				'visibility' : 'visible'
																			});
														}
													}
												});
									}

								}

							});
					
					
					$('table#emp_Expence #totApproved')
					.blur(
							function() {
								
								var flag = true;
								var approvedVal = $(this).parents(
										'tr:first').find(
										'td:nth-child(16)').find(
										'input').val().trim();
								var advpaidVal = $(this).parents(
										'tr:first').find(
										'td:nth-child(17)').find(
										'input').val().trim();
								var expenseAmount = $(this).parents(
								'tr:first').find(
								'td:nth-child(15)').find(
								'input').val().trim();

								if (isNaN(approvedVal)) {
									$("#errordiv").show();
									$("#errordiv")
											.text(
													"Total Approved accept only Numeric");
									$('.error-box').css({
										'visibility' : 'visible'
									});
									return false;
									flag = false;
								}
								if (isNaN(advpaidVal)) {
									$("#errordiv").show();
									$("#errordiv")
											.text(
													"Advance Paid accept only Numeric");
									$('.error-box').css({
										'visibility' : 'visible'
									});
									return false;
									flag = false;
								}
								if ((parseFloat(approvedVal)) > (parseFloat(expenseAmount))) {
									$("#errordiv").show();
									$("#errordiv")
											.text(
													"Approved amount should not greater than expenses amount");
									$('.error-box').css({
										'visibility' : 'visible'
									});
									return false;
									flag = false;
								} else {
									$("#errordiv").hide();
									$("#errordiv").text("");
									$('.error-box').css({
										'visibility' : 'none'
									});
								
								}
								if ((parseFloat(approvedVal)) < (parseFloat(advpaidVal))) {
									$("#errordiv").show();
									$("#errordiv")
											.text(
													"Advance Paid should be less than Total Approved");
									$('.error-box').css({
										'visibility' : 'visible'
									});
									return false;
									flag = false;
								} else {
									$("#errordiv").hide();
									$("#errordiv").text("");
									$('.error-box').css({
										'visibility' : 'none'
									});
									$(this)
											.parents('tr:first')
											.find('td:nth-child(18)')
											.find('input')
											.val(
													parseFloat(approvedVal)
															- parseFloat(advpaidVal));
									flag = true;
								}
							});
			$('table#emp_Expence #advPaid')
					.blur(
							function() {
							
								var flag = true;
								var approvedVal = $(this).parents(
										'tr:first').find(
										'td:nth-child(16)').find(
										'input').val().trim();
								var advpaidVal = $(this).parents(
										'tr:first').find(
										'td:nth-child(17)').find(
										'input').val().trim();
							

								if (isNaN(approvedVal)) {
									$("#errordiv").show();
									$("#errordiv")
											.text(
													"Total Approved accept only Numeric");
									$('.error-box').css({
										'visibility' : 'visible'
									});
									return false;
									flag = false;
								}
								if (isNaN(advpaidVal)) {
									$("#errordiv").show();
									$("#errordiv")
											.text(
													"Advance Paid accept only Numeric");
									$('.error-box').css({
										'visibility' : 'visible'
									});
									return false;
									flag = false;
								}
								if ((parseFloat(approvedVal)) < (parseFloat(advpaidVal))) {
									$("#errordiv").show();
									$("#errordiv")
											.text(
													"Advance Paid should be less than Total Approved");
									$('.error-box').css({
										'visibility' : 'visible'
									});
									return false;
									flag = false;
								} else {
									$("#errordiv").hide();
									$("#errordiv").text("");
									$('.error-box').css({
										'visibility' : 'none'
									});
									$(this)
											.parents('tr:first')
											.find('td:nth-child(18)')
											.find('input')
											.val(
													parseFloat(approvedVal)
															- parseFloat(advpaidVal));
									flag = true;
								}
							});
					
					
					
					$('#downloadExpenseDetails')
							.click(
									function() {
										window.location.href = 'managerExpenseDetails.do?method=downloadConsolidateExpenseDetails&year='
												+ $("#year").val()
												+ ' &month='
												+ $("#month").val();
									});
					
					
		
					
					$("#approveAll").click(function(){
						
						
						var expensesCode=[];
						var totApprovedAmount=[];
						var advancePaid=[];
						var balance=[];
						var totExpenses=[];
						
						 $("#emp_Expence tr").each(function(){
							 
							/* var expenceCodeVal=$(this).find('.hexpenceCode').val();
								  
							    if(expenceCodeVal!=undefined && expenceCodeVal!=""){
							    	
							    	expensesCode.push(expenceCodeVal.trim());
							    	
								}*/
							 
							 
							 
							 var expenceCodeVal=$(this).find('.hexpenceCode').val();
								  
							    if(expenceCodeVal!=undefined && expenceCodeVal!=""){
							    	
							    	expensesCode.push(expenceCodeVal.trim());
							    	
								}
							    
							    var approvedAmtVal=$(this).find('.totApproved').val();
								  
							    if(approvedAmtVal!=undefined && approvedAmtVal!=""){
							    	
							    	totApprovedAmount.push(parseFloat(approvedAmtVal.trim()).toFixed(2));
							    	
								}
							    
							    
							    var advancePaidVal=$(this).find('.advancePaid').val();
							    
							    if(advancePaidVal!=undefined && advancePaidVal!=""){
							    	
							    	advancePaid.push(parseFloat(advancePaidVal.trim()).toFixed(2));
							    	
								}
							    
								  var balanceVal=$(this).find('.balance').val();
														    
										if(balanceVal!=undefined && balanceVal!=""){
														    	
											balance.push(balanceVal.trim());
														    	
									}
										
								  var expenseVal=$(this).find('.totExpenses').text();
										   
									if(expenseVal!=undefined && expenseVal!=""){
															    	
										totExpenses.push(parseFloat(expenseVal.trim()).toFixed(2));
															    	
									}
										
										
							    
						});
						 
						 
						 for (var i = 0; i < expensesCode.length; i++) {
							    
						  		
					  		 var re_for_double = '^[0-9]*\.[0-9]*$';
							 var int_regex=/^\d+$/;
								
								
								if(totApprovedAmount[i]==""){
									$("#errordiv").show();
									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text("Approved amount should not empty");
									$(this).closest('td').prev().addClass("ui-state-error");
									$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
									return false;
									
								}else if(!((int_regex.test(totApprovedAmount[i])) || (totApprovedAmount[i].match(re_for_double)))){
									
									$("#errordiv").show();
									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text("Enter valid approved amount");
									$(this).closest('td').prev().addClass("ui-state-error");
									$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
									return false;
								
									
								}/*else if(parseFloat(totApprovedAmount[i])>parseFloat(totExpenses[i])){
									$("#errordiv").show();
									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text("Approved amount should not greater than Expense amount");
									$(this).closest('td').prev().addClass("ui-state-error");
									$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
									return false;
								
									
								}*/else if(advancePaid[i]==""){
									$("#errordiv").show();
									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text("Approved amount should not empty");
									$(this).closest('td').prev().addClass("ui-state-error");
									$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
									return false;
									
								}else if(!((int_regex.test(advancePaid[i])) || (advancePaid[i].match(re_for_double)))){
									
									$("#errordiv").show();
									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text("Enter valid advance paid");
									$(this).closest('td').prev().addClass("ui-state-error");
									$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
									return false;
								
									
								}else if(parseFloat(totApprovedAmount[i])<parseFloat(advancePaid[i])){
									
									$("#errordiv").show();
									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text("Advance Paid should less than Approved Amount");
									$(this).closest('td').prev().addClass("ui-state-error");
									$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
									return false;
								
									
								}else{
									
								}
								
					 }	
						 
							var x = confirm("Are you sure you want approve Expenses Details?");
							if (x) {	
								
								
								var allowanceData={
										"expensesCode":expensesCode.join(","),
										"totApprovedAmount":totApprovedAmount.join(","),
										"advancePaid":advancePaid.join(","),
										"balance":balance.join(","),
										'expense_month' : $("#sel_month").val().trim(),
										'expense_year' : $("#sel_year").val().trim()
										};
									
									$
									.ajax({
										type : 'POST',
										url : "managerExpenseDetails.do?method=approveAllExpenseDetails",
										data : allowanceData,
										  beforeSend: function() {
										       
											  $('#loader').show();
											  
										    },
										success : function(
												response) {

											var result = $.parseJSON(response);
											$('#loader').hide();
											
											if(result.approve_Result=="true" || result.approve_Result=="MialSent"){
												
												window.location.href="managerMenu.do?parameter=getExpenseConsolidatedDetail&status="+result.approve_Result;
												
												
											}else{
													
													$('.error-box').css({
														'visibility' : 'visible'
													});
													
													$("#errordiv").text("Allowanses not approved,Try again");
													$(this).closest('td').prev().addClass("ui-state-error");
													$('html, body').animate({ scrollTop: $('#errordiv').offset().top }, 'fast');
												}
											
											
											
										}

									});
									
									}
									
						
					});

				
				});

function downloadFullExpenseDetails(empid) {
	

	window.location.href = 'managerExpenseDetails.do?method=downloadDetailedExpenseDetails&year='
			+ $("#year").val()
			+ ' &month='
			+ $("#month").val()
			+ ' &empid='
			+ empid;
}