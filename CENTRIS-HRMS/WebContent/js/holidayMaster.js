$(document)
		.ready(
				function() {

					$("#successmsg").hide();
					$("#successmsg1").hide();
					$("#updatefail").hide();

					$("#update-dialog")
							.dialog(
									{

										autoOpen : false,
										center : 1,
										dialogtop : top,
										height : 300,
										width : 550,
										modal : true,
										buttons : {

											"Create Holiday" : function() {

												var department = $(
														"#departmentval").val();
												var year = $("#holidayyearval")
														.val();
												var date = $("#date").val();
												var weekday = $("#weekday")
														.val();
												var holiday = $("#holiday")
														.val();

												if (department == "") {

													$("#successmsg").show();
													$("#fail")
															.text(
																	"Select Department");

												} else if (year == "") {

													$("#successmsg").show();
													$("#fail").text(
															"Select Year");

												} else if (date == "") {

													$("#successmsg").show();
													$("#fail").text(
															"Select Date");

												} else if (date.trim().indexOf(
														year) == -1) {

													$("#successmsg").show();
													$("#fail")
															.text(
																	'Holiday Date not match with Selected Year');

												} else if (holiday == "") {

													$("#successmsg").show();
													$("#fail")
															.text(
																	"Enter Holiday Reason");

												} else {

													var datalst1 = {

														"date" : date,
														"department" : department
													};

													$
															.ajax({
																type : "POST",
																url : "holidayMaster.do?parameter=dateValidate",
																data : datalst1,
																success : function(
																		response) {
																	var result = $
																			.parseJSON(response);
																	if (result.dateVal == 'exit') {

																		$(
																				"#successmsg")
																				.show();
																		$(
																				"#fail")
																				.text(
																						"Date Already Exists, Select Another Date ");
																		 $('ul li ul').show();
																	} else {

																		var datalst = {
																			"department" : department,
																			"year" : year,
																			"date" : date,
																			"weekday" : weekday,
																			"holiday" : holiday

																		};

																		$
																				.ajax({
																					type : "GET",
																					url : "holidayMaster.do?parameter=addHolidayDetail",
																					data : datalst,
																					success : function(
																							response) {

																						var result = $
																								.parseJSON(response);

																						if (result.dateVal == 'success') {
																							$(
																									"#successmsg")
																									.hide();

																							$(
																									"#successmsg1")
																									.show();
																							$(
																									"#success")
																									.text(
																											"Holiday added successfully");
																							 $('ul li ul').show();
																							setTimeout(
																									"location.reload(true);",
																									3000);
																						}

																					}

																				});

																		$(
																				'#update-dialog')
																				.dialog(
																						"close");
																		 $('ul li ul').show();
																	}
																}
															});
												}
											},

											Cancel : function() {
												$(this).dialog("close");
												 $('ul li ul').show();

											}
										},

									});
					$("#update-dialog1")
							.dialog(
									{

										autoOpen : false,
										center : 1,
										dialogtop : top,
										height : 250,
										width : 500,
										modal : true,
										buttons : {

											"Update" : function() {

												var date = $("#date1").val();
												var holiday = $("#holiday1")
														.val();
												var weekday = $("#weekday1")
														.val();
												var deptid = $("#deptidhidden")
														.val();

												if (holiday == '') {

													$("#updatefail").show();
													$("#spanupdatefail")
															.text(
																	"Insert the Holiday");

												} else {

													var datalst = {
														"weekday" : weekday,

														"date" : date,

														"holiday" : holiday,

														"deptid" : deptid

													};

													$
															.ajax({
																type : 'POST',
																url : "holidayMaster.do?parameter=updateHoliday",
																data : datalst,
																success : function(
																		response) {

																	var result = $
																			.parseJSON(response);

																	if (result.success == 'success') {

																		$(
																				"#successmsg1")
																				.show();
																		$(
																				"#success")
																				.text(
																						"Holiday Updated Successfully");
																		 $('ul li ul').show();
																	} else {

																		$(
																				"#successmsg1")
																				.show();
																		$(
																				"#success")
																				.text(
																						"Holiday not Updated not Successfully");
																		 $('ul li ul').show();
																	}
																}

															});

													setTimeout(
															"location.reload(true);",
															3000);
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

					$("#NewHoliday")
							.click(
									function() {

										jQuery(
												".ui-dialog-buttonpane button:contains('Add')")
												.attr("disabled", false)
												.removeClass(
														"ui-state-disabled")
												.addClass("ui-state-enabled");
										jQuery(
												".ui-dialog-buttonpane button:contains('Update')")
												.attr("disabled", true)
												.addClass("ui-state-disabled");
										
										$("#errordiv").text("");
										$("a.ui-dialog-titlebar-close").remove();	
										$("span.ui-icon").remove();
										$('ul li ul').hide();
										
										$("#update-dialog").dialog("open");

									});

					$("#searchholiday")
							.click(
									function() {

										var department = $("#department").val();
										var holidayyear = $("#holidayyear")
												.val();

										if (department == ""
												|| holidayyear == null) {

											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv").text(
													"Select Department");
										} else if (holidayyear == ""
												|| holidayyear == null) {

											$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv").text(
													"Select Year");
										} else {

											window.location.href = "holidayMaster.do?parameter=getHolidayMasterDetails&departmentval="
													+ department
													+ "&holidayyearval="
													+ holidayyear;
										}

									});

					$("#date").datepicker({
						dateFormat : "dd-mm-yy",
						altField : "#weekday",
						/* minDate : 0, */
						changeMonth : "true",
						changeYear : "true",
						altFormat : "DD"
					});

				});

function callDialgEdit(holidaydate) {
	var holidaydetails = holidaydate.split(",");

			datalist = {
				"holidaydate" : holidaydetails[0]
			},

			$
					.ajax({
						type : 'POST',
						url : "holidayMaster.do?parameter=editHolidayMaster",
						data : datalist,
						success : function(response) {
							var result = $.parseJSON(response);
							document.forms["HolidayForm"]["date"].value = result.holidayMasterVOList[0].date;
							document.forms["HolidayForm"]["weekday"].value = result.holidayMasterVOList[0].weekDay;
							document.forms["HolidayForm"]["holiday"].value = result.holidayMasterVOList[0].holidaysName;
							document.forms["HolidayForm"]["deptidhidden"].value = holidaydetails[1];

						}
					});

	jQuery(".ui-dialog-buttonpane button:contains('Update')").attr("disabled",
			false).removeClass("ui-state-disabled")
			.addClass("ui-state-enabled");
	jQuery(".ui-dialog-buttonpane button:contains('Add')").attr("disabled",
			true).addClass("ui-state-disabled");
	$("#errordiv").text("");
	$("a.ui-dialog-titlebar-close").remove();	
	$("span.ui-icon").remove();
	$('ul li ul').hide();
	
	$("#update-dialog1").dialog("open");
}
function callDialgDelete(date) {

	var x = confirm("Are you sure you want to delete this Holiday");
	if (x) {
		var datalst = {
			"holidaydate" : date

		};

		$.ajax({
			type : 'POST',
			url : "holidayMaster.do?parameter=deleteHolidayData",
			data : datalst,
			success : function(response) {
				var result = $.parseJSON(response);

				$("#successmsg1").show();
				$("#success").text(result.message);

				setTimeout("location.reload(true);", 3000);

			}

		});
	}

}

function createGroupofHolidays() {

	window.location = "/CENTRIS-HRMS/holidayMaster.do?parameter=AddGroupHoliday";

}
