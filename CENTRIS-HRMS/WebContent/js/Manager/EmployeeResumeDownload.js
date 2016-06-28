$(document)
		.ready(
				function() {
				
			$("#pdfBtnId").click(function(){
				var employeeCode=$('#employeeCode').val();
			
				if(employeeCode=="" || employeeCode==null){
					$('#errordiv').text("Select Employee");
					$('#errordiv').css({'visibility': 'visible'});
					return false;
				}
				else
					{
				
				
				window.location.href = "getAllReports.do?method=downloadEmployeeResume&employeeCode="
									+ employeeCode;
					}
				
			});
					
					
				
			$("#docBtnId").click(function(){
				var employeeCode=	$('#employeeCode').val();
				
				if(employeeCode=="" || employeeCode==null){
					$('#errordiv').text("Select Employee");
					$('#errordiv').css({'visibility': 'visible'});
					return false;
				}
				else
					{
				
				
				window.location.href = "getAllReports.do?method=downloadEmployeeResumeWord&employeeCode="
									+ employeeCode;
					}
				
			});
			
			
			
			 $("#employee").autocomplete(
						{
							

							source : function(request, response) {
								

							
								$
										.ajax({

											url : "getAllReports.do?method=getAllEmployeesNames",
											data : {
												searchTerm : request.term
											},
											success : function(data) {
												var result = $
														.parseJSON(data);
											

												response($.map(result.employeeList,
																function(
																		item) {
																	return {
																		label : item.empname,
																		value : item.empid,
																	}
																}));
											}
											
											

										});
							},
							select : function(event, ui) {
							
					
						      $("#employee").val(ui.item.value);
								$("#employee").val(ui.item.label);
								$("#employeeCode").val(ui.item.value);
									return false;
							}
						});
			
			
			
			
					
					
				});