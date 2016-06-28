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
						onSelect : function() {
							$(this).change();
						}
					});

					$("#employee_submit")
							.click(
									function() {
										
										var dateofbirth = $("#dateofBirthId")
												.val().trim();

										var emp_official_emailid = $(
												"#employeeofficialemailid")
												.val().trim();

										if (dateofbirth == '') {
											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv").text(
													"Select Date of Birth");

											return false;
										} else if (emp_official_emailid == '') {

											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv").text(
													"Enter Official E-mail ID");
											return false;

										} else if (!emp_official_emailid
												.match(/^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)) {

											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv")
													.text(
															"Enter the valid E-mail ID");
											return false;

										} else {

											var employeedetails = {
												"dateofbirth" : dateofbirth,
												"emp_official_emailid" : emp_official_emailid
											};

											if (dateofbirth != ''
													&& emp_official_emailid != '') {
												$("#hidecontent").show();
												$("#loader").show();
												$
														.ajax({
															type : "GET",
															url : "logincheck.do?method=sendEmployeePassword",
															data : employeedetails,
															async : false,
															success : function(
																	data) {
																var result = $
																		.parseJSON(data);
															

																if (result.message === "successMessage") {
																	$(
																			"#hidecontent")
																			.hide();
																	$("#loader")
																			.hide();
																	$(
																			'.error-box')
																			.css(
																					{
																						'visibility' : 'visible'
																					});
																	$(
																			"#errordiv")
																			.html(
																					"<font color='green' >We sent You an Email with password , Please check</font>");

																	$(
																			"#dateofBirthId")
																			.val(
																					"");
																	$(
																			"#employeeofficialemailid")
																			.val(
																					"");

																} else  if(result.message === "errorMessage"){
																	$("#hidecontent").hide();
																	$("#loader").hide();
																	$(
																			'.error-box')
																			.css(
																					{
																						'visibility' : 'visible'
																					});
																	$(
																			"#errordiv")
																			.text(
																					"Password changed successfully,Unable to send mail try agian");

																	$(
																			"#dateofBirthId")
																			.val(
																					"");
																	$(
																			"#employeeofficialemailid")
																			.val(
																					"");
																}
																else
																	{

																	$("#hidecontent").hide();
																	$("#loader").hide();
																$('.error-box')
																		.css(
																				{
																					'visibility' : 'visible'
																				});
																$(".error-box")
																		.text(
																				"Entered Username and Email-ID Combination is wrong");
																
																	}
															}
														});
											}
										}
									});

					// for Manager

					$("#manager_submit")
							.click(
									function() {
										
										var username = $("#usernameId").val();
										var email = $("#emailId").val();
										var emailCheck = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

										if (username == '') {

											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv").text(
													"Enter Username");

											return false;
										}
										if (email == '') {

											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv").text("Enter Email");

											return false;
										}
										if (!emailCheck.test(email)) {

											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv").text(
													"Enter Valid Email");

											return false;
										}

										$("#usernameId").val('');
										$("#emailId").val('');
										var dataList = {
											"username" : username,
											"email" : email
										};
										$("#hidecontent").show();
										$("#loader").show();
										$
												.ajax({
													type : 'POST',
													url : "logincheck.do?method=sendManagerPassword",
													data : dataList,
													success : function(data) {
														var result = $
																.parseJSON(data);
														

														if (result.message === "errorMessage") {
															$("#hidecontent")
															.hide();
															$("#loader").hide();
															$('.error-box')
																	.css(
																			{
																				'visibility' : 'visible'
																			});
															$(".error-box")
																	.text(
																			"Password changed successfully,Unable to send mail try agian");
															$(".error-box")
															.css(
																	{
																		'color' : 'red'
																	});
														} else if(result.message === "successMessage" ) {
															$("#hidecontent")
																	.hide();
															$("#loader").hide();
															$('.error-box')
																	.css(
																			{
																				'visibility' : 'visible'
																			});
															$(".error-box")
																	.text(
																			"We sent You an Email with password , Please check");
															$(".error-box")
																	.css(
																			{
																				'color' : 'green'
																			});
														}
														else {
															$("#hidecontent")
															.hide();
														$("#loader").hide();
														$('.error-box')
																.css(
																		{
																			'visibility' : 'visible'
																		});
														$(".error-box")
																.text(
																		"Entered Username and Email-ID Combination is wrong");
														$(".error-box")
														.css(
																{
																	'color' : 'red'
																});
														}
													}
												});
										return true;
									});
					
					//for admin
					
					$("#admin_submit")
					.click(
							function() {
							
								var username = $("#adminusernameId").val();
								var email = $("#adminemailId").val();
								var emailCheck = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

								if (username == '') {

									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text(
											"Enter Username");

									return false;
								}
								if (email == '') {

									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text("Enter Email");

									return false;
								}
								if (!emailCheck.test(email)) {

									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text(
											"Enter Valid Email");

									return false;
								}

								$("#adminusernameId").val('');
								$("#adminemailId").val('');
								var dataList = {
									"username" : username,
									"email" : email
								};
								$("#hidecontent").show();
								$("#loader").show();
								$
										.ajax({
											type : 'POST',
											url : "logincheck.do?method=sendAdminPassword",
											data : dataList,
											success : function(data) {
												var result = $
														.parseJSON(data);

											

												if (result.message === "errorMessage") {
													$("#hidecontent")
													.hide();
													$("#loader").hide();
													$('.error-box')
															.css(
																	{
																		'visibility' : 'visible'
																	});
													$(".error-box")
															.text(
																	"Password changed successfully,Unable to send mail try agian");
													$(".error-box")
													.css(
															{
																'color' : 'green'
															});
												} else if(result.message === "successMessage" ) {
													$("#hidecontent")
															.hide();
													$("#loader").hide();
													$('.error-box')
															.css(
																	{
																		'visibility' : 'visible'
																	});
													$(".error-box")
															.text(
																	"We sent You an Email with password , Please check");
													$(".error-box")
															.css(
																	{
																		'color' : 'green'
																	});
												}
												else {
													$("#hidecontent")
													.hide();
												$("#loader").hide();
												$('.error-box')
														.css(
																{
																	'visibility' : 'visible'
																});
												$(".error-box")
														.text(
																"Entered Username and Email-ID Combination is wrong");
												$(".error-box")
												.css(
														{
															'color' : 'green'
														});
												}
											}
										});
								return true;
							});
					
					//for director
					
					$("#director_submit")
					.click(
							function() {
								
								var username = $("#directorusernameId").val();
								var email = $("#directormailId").val();
								var emailCheck = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

								if (username == '') {

									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text(
											"Enter Username");

									return false;
								}
								if (email == '') {

									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text("Enter Email");

									return false;
								}
								if (!emailCheck.test(email)) {

									$('.error-box').css({
										'visibility' : 'visible'
									});
									$("#errordiv").text(
											"Enter Valid Email");

									return false;
								}

								$("#directorusernameId").val('');
								$("#directormailId").val('');
								var dataList = {
									"username" : username,
									"email" : email
								};
								$("#hidecontent").show();
								$("#loader").show();
								$
										.ajax({
											type : 'POST',
											url : "logincheck.do?method=sendDirectorPassword",
											data : dataList,
											success : function(data) {
												var result = $
														.parseJSON(data);
												

												if (result.message === "errorMessage") {
													$("#hidecontent")
													.hide();
													$("#loader").hide();
													$('.error-box')
															.css(
																	{
																		'visibility' : 'visible'
																	});
													$(".error-box")
															.text(
																	"Password changed successfully,Unable to send mail try agian");
													$(".error-box")
													.css(
															{
																'color' : 'red'
															});
												} else if(result.message === "successMessage") {
													$("#hidecontent")
															.hide();
													$("#loader").hide();
													$('.error-box')
															.css(
																	{
																		'visibility' : 'visible'
																	});
													$(".error-box")
															.text(
																	"We sent You an Email with password , Please check");
													$(".error-box")
															.css(
																	{
																		'color' : 'green'
																	});
												}
												else
													{
													$("#hidecontent")
													.hide();
													$("#loader").hide();
													$('.error-box')
															.css(
																	{
																		'visibility' : 'visible'
																	});
													$(".error-box")
															.text(
																	"Entered Username and Email-ID Combination is wrong");
													$(".error-box")
													.css(
															{
																'color' : 'red'
															});
													}
											}
										});
								return true;
							});
				});

// for forwarding to home page

function gotoHome() {
	var currentUrl=document.URL;
	var res = currentUrl.substring(0, 31);
	window.location.href =res;
}
