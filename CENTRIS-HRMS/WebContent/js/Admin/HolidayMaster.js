var datevalidflag;
function dateValidate(date,clientcode){
	var datalst1 = {
			"date" : date,
			"clientCode":clientcode,
			
		};
		$.ajax({
					type : "POST",
					url : "holidayMaster.do?parameter=dateValidate",
					data : datalst1,
					async:false,
					success : function(
							response) {
						var result = $.parseJSON(response);
						
						datevalidflag = result.dateVal;
						
					}
		});
		
   return datevalidflag;
}
$(document)
		.ready(
				function() {

					$("#error").hide();
					$("#successmsg1").hide();
					$("#updatefail").hide();

					$("#update-dialog")
							.dialog(
									{
   									   autoOpen : false,
										center : 1,
										dialogtop : top,
										height : 380,
										width : 550,
										modal : true,
										buttons : {

											"Create Holiday" : function() {
										var yearVal=$("#holidayyearval").val();
												var yearString = $("#holidayyearval option:selected").text();
												var year=parseInt(yearString);
											
												var date = $("#date").val();
												var weekday = $("#weekday")
														.val();
												var holiday = $("#holiday")
														.val();
												var clientCode=$("#clientaddId").val();
											
												if(clientCode=="" || clientCode==null){
													$("#error").show();
													$("#error").text("Select Client Name");
													$(".error-box").css({'visibility':'visible'});
													
												}else if(year == "") {
													$("#error").show();
													$("#error").text("Select Year");
													$(".error-box").css({'visibility':'visible'});
												} else if (date == "") {
													$("#error").show();
													$("#error").text("Select Date");
													$(".error-box").css({'visibility':'visible'});
												} else if (date.trim().indexOf(
														year) == -1) {
													$("#error").show();
													$("#error").text('Holiday Date not match with Selected Year');
													$(".error-box").css({'visibility':'visible'});
												} else if (holiday == "") {

													$("#error").show();
													$("#error").text("Enter Holiday Reason");
													$(".error-box").css({'visibility':'visible'});
												} else {

													var datalst1 = {
														"date" : date,
														"clientCode":clientCode,
														
													};
													$.ajax({
																type : "POST",
																url : "holidayMaster.do?parameter=dateValidate",
																data : datalst1,
																success : function(
																		response) {
																	var result = $
																			.parseJSON(response);
																	
																	if (result.dateVal == 'exit') {
																		$("#error").show();
																		$("#error").text("Date Already Exists, Select Another Date");
																		$(".error-box").css({'visibility':'visible'});
																	   $('ul li ul').show();
																	} else {

																		var datalst = {
																			
																			"year" : yearVal,
																			"date" : date,
																			"weekday" : weekday,
																			"clientCode":clientCode,
																			"holiday" : holiday

																		};

																		$
																				.ajax({
																					type : "GET",
																					url : "holidayMaster.do?parameter=addHolidayDetail",
																					data : datalst,
																					success : function(
																							response) {
																						var result = $.parseJSON(response);
                                                                                       document.location.href="holidayMaster.do?parameter=getDetails&status="+result.dateVal;
																					

																					}

																				});

																		$('#update-dialog').dialog("close");
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
										height : 320,
										width : 550,
										modal : true,
										buttons : {
											"Update" : function() {
												var date = $("#date1").val();
												var holiday = $("#holiday1").val();
												var weekday = $("#weekday1").val();		
												var clientCodeUpdate=$("#clientUpdateId").val();
												var clienthidden=$("#clienthidden").val();
											  if (holiday == '') {
													$("#holidayerrordiv1").show();
													$("#holidayerrordiv1").text('Enter the Holiday');
													$(".holidayerror-box").css({'visibility':'visible'});
											
											   }else if(clientCodeUpdate=='' || clientCodeUpdate==null){
													$("#holidayerrordiv1").show();
													$("#holidayerrordiv1").text('Select Client Name');
													$(".holidayerror-box").css({'visibility':'visible'});
												}											  
											  else {
                                                     
												  if(dateValidate(date,clientCodeUpdate)=='exit')
												  {
														$("#holidayerrordiv1").show();
														$("#holidayerrordiv1").text("Date Already Exists, Select Another Date");
														$(".holidayerror-box").css({'visibility':'visible'});
													 													  
												  }else{
													  $("#holidayerrordiv1").hide();
													  $(".holidayerror-box").css({'visibility':'hidden'});
													var datalst = {
														"weekday" : weekday,
														"date" : date,
                                                          "holiday" : holiday,
                                                           "clientCodeUpdate":clientCodeUpdate,
														    'clienthidden':clienthidden

													};

													$.ajax({
																type : 'POST',
																url : "holidayMaster.do?parameter=updateHoliday",
																data : datalst,
																success : function(
																		response) {

																	var result = $
																			.parseJSON(response);
																       document.location.href="holidayMaster.do?parameter=getDetails&updatestatus="+result.success;
																}

															});

													setTimeout("location.reload(true);",3000);
													 $('ul li ul').show();
													$(this).dialog("close");
												}
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
										
										$("#errordiv").hide();
										$("#error").hide();
										$("#update-dialog").dialog("open");

									});

					$("#searchholiday")
							.click(
									function() {

									
										var holidayyear = $("#holidayyear")
												.val();
										
										var clientCode=$("#clientSelectId").val();
										
                                      
                                       
                                    if(clientCode=="" || clientCode==null)
                                       {
                                    		$('.error-box').css({
												'visibility' : 'visible'
											});
											$("#errordiv").text(
													"Select Client Name");
                                    	   
                                       }
                                       else if (holidayyear == ""
											|| holidayyear == null) {

										$('.error-box').css({
											'visibility' : 'visible'
										});
										$("#errordiv").text(
												"Select Year");
									} 
                                       
                                       
                                       else {

											window.location.href = "holidayMaster.do?parameter=getHolidayMasterDetails&holidayyearval="+holidayyear+"&clientCode="+clientCode;
													
										}

									});

					$("#date").datepicker({
						dateFormat : "dd-mm-yy",
						altField : "#weekday",
						changeMonth : "true",
						changeYear : "true",
						altFormat : "DD"
					});

				});

function callDialgEdit(holidaydate,clientcode) {

	var holidaydetails = holidaydate.split(",");


			datalist = {
				"holidaydate" : holidaydetails[0],
			"clientCode":holidaydetails[1]
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
							$('#clientUpdateId option[value=' + result.holidayMasterVOList[0].clientCode + ']').attr(
									'selected', 'true');
							document.forms["HolidayForm"]["clienthidden"].value = result.holidayMasterVOList[0].clientCode;
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
	$("#errordiv1").hide();
	$("#update-dialog1").dialog("open");
}
function callDialgDelete(date,clientcode) {

	var x = confirm("Are you sure you want to delete this Holiday");
	if (x) {
		var datalst = {
			"holidaydate" : date,
            "clientcode": clientcode
		};

		$.ajax({
			type : 'POST',
			url : "holidayMaster.do?parameter=deleteHolidayData",
			data : datalst,
			success : function(response) {
				var result = $.parseJSON(response);

				window.location.href="holidayMaster.do?parameter=getDetails&deleteMessage="+result.message;

			}

		});
	}

}

function createGroupofHolidays() {

	window.location = "/CENTRIS-HRMS/holidayMaster.do?parameter=AddGroupHoliday";

}

