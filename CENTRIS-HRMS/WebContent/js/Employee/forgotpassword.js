var currentPass = false;
$(document)
		.ready(
				function() {
					
					$("#dateofBirthId").datepicker({
						dateFormat : "dd-mm-yy",
						defaultDate : "+1w",
						maxDate : 0,
						changeYear : true,
						changeMonth : true,
						numberOfMonths : 1,
						 onSelect: function() {
							    $(this).change();	
						
						
						
						 }
					});
							
					$("#submit")
							.click(
									function() {

										var dateofbirth = $("#dateofBirthId").val().trim();
									
									var emp_official_emailid = $("#employeeofficialemailid").val().trim();

										if (dateofbirth == '') {
											$('.error-box').css({'visibility' : 'visible'});
											$("#errordiv").text("Select DateofBirth");

											return false;
										}else if (emp_official_emailid == '') {
											
											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv").text("Enter Official-EmailId");
											return false;
										
										}else if (!emp_official_emailid.match(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)) {

											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv").text("Please enter the valid mail ending with .com.");
											return false;
											
											
										}else{
															
											var employeedetails={"dateofbirth":dateofbirth,"emp_official_emailid":emp_official_emailid};
										
											
										if(dateofbirth!='' && emp_official_emailid !='' ){
											
											$.ajax({
												type : "GET",
												url : "employeeforgotPassword.do?parameter=checkEmployee",
												data : employeedetails,
												async : false,
											   success : function(data) {
													var result = $.parseJSON(data);
													
													if (result.status) {
													
														$('.error-box').css({'visibility' : 'visible'});
														$("#errordiv").html("<font color='green' >Password is send to your Emailid</font>");
														
														$("#dateofBirthId").val("");
														$("#employeeofficialemailid").val("");
													
												

													} else{
														$('.error-box').css({'visibility' : 'visible'});
														$("#errordiv").text("UserName Not Exist,Please try again");
														
														$("#dateofBirthId").val("");
														$("#employeeofficialemailid").val("");
													}

												}

											});
											
											
											}
											
										}
										
									});
					
			
					
					});





