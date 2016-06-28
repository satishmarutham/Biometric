function callAjax(urlWithMethod, dataToBeSend) {

	var jsonResult = "";
	try {
		$.ajax({
			type : "GET",
			url : urlWithMethod,
			data : dataToBeSend,
			async : false,
			success : function(data) {
				var result = $.parseJSON(data);
				jsonResult = result;
			}
		});
	} catch (e) {
		jsonResult = "";
	}
	return jsonResult;
}

function createSelectBox(selectboxId, dataForOption) {
	var jsonkey = [];
	for (key in dataForOption[0]) {
		if (key.indexOf("Name") != -1 || key.indexOf("name") != -1) {
			jsonkey[1] = key;
		} else if (/id$/.test(key) || /code$/.test(key) || /Id$/.test(key)) {
			jsonkey[0] = key;
		}
	}
	$(selectboxId).empty();
	var selectObject = $(selectboxId);
	var anOption = document.createElement("OPTION");
	anOption.setAttribute("value", "");
	anOption.innerHTML = "---Select Option---";
	selectObject.append(anOption);
	if (selectboxId != "#locationId") {
		var anOptionAll = document.createElement("OPTION");
		anOptionAll.setAttribute("value", "%%");
		anOptionAll.innerHTML = "All";
		if (dataForOption.length > 0)
			selectObject.append(anOptionAll);
	}

	for ( var i = 0; i < dataForOption.length; i++) {
		if (dataForOption[i][jsonkey[1]] != "") {
			var anOption = document.createElement("OPTION");
			if (selectboxId == ".empClassForAdmin"
					|| selectboxId == ".shiftClassForAdmin") {
				anOption.setAttribute("value", dataForOption[i][jsonkey[0]]);
			} else {
				anOption.setAttribute("value", dataForOption[i][jsonkey[0]]);
			}
			anOption.innerHTML = dataForOption[i][jsonkey[1]];
			selectObject.append(anOption);
		}
	}
}

$(document)
		.ready(
				function() {

					$("#reportDate").datepicker({
						dateFormat : "dd-mm-yy",
						defaultDate : "+1w",
						maxDate : -1,
						changeYear : true,
						changeMonth : true,
						numberOfMonths : 1
					});
					$('#groupId')
							.change(
									function() {
										var sendGroup = {
											'group' : $(this).val()
										};
										var result = callAjax(
												"location.do?parameter=getLocationByGroup",
												sendGroup);
										createSelectBox("#locationId",
												result.locationList);
									});

					$('#locationId')
							.change(
									function() {
										var sendLocation = {
											'location' : $(this).val(),
											'group' : $("#groupId").val()
										};
										var result = callAjax(
												"todayReport.do?parameter=getEmpDetailsByLocation",
												sendLocation);
										createSelectBox("#employeeId",
												result.empList);
									});

					if ($('#hgroupId').val() != "") {
						var sendGroup = {
							'group' : $('#hgroupId').val().trim()
						};
						var result = callAjax(
								"location.do?parameter=getLocationByGroup",
								sendGroup);
						createSelectBox("#locationId", result.locationList);
						if ($('#hlocationId').val() != "") {
							var sendLocation = {
								'location' : $('#hlocationId').val().trim(),
								'group' : $("#hgroupId").val().trim()
							};
							var result = callAjax(
									"todayReport.do?parameter=getEmpDetailsByLocation",
									sendLocation);
							createSelectBox("#employeeId", result.empList);
						}
						$('#groupId [value=' + $('#hgroupId').val() + ']')
								.attr('selected', true);
						$(
								'#locationId [value="'
										+ $('#hlocationId').val().trim() + '"]')
								.attr('selected', true);
						$(
								'#employeeId [value="'
										+ $('#hemployeeId').val().trim() + '"]')
								.attr('selected', true);
						$('#reportDate').val($('#hrepDate').val());
					}

					$('#updateAttendance')
							.click(
									function() {

										var attGroup = $('#hgroupId').val();
										var attLocation = $('#hlocationId')
												.val();
										var attDate = $('#hrepDate').val();
										var var_EmployeeId = [];
										var var_EmployeeStatus = [];
										$('#defaulttable tr:gt(0)')
												.each(
														function() {
															var_EmployeeId
																	.push($(
																			this)
																			.find(
																					'td.empid')
																			.text()
																			.trim());

															var_EmployeeStatus
																	.push($(
																			this)
																			.find(
																					'td')
																			.find(
																					'.empStatus option:Selected')
																			.val()
																			.trim());
														});
										var datalist = {
											"attGroup" : attGroup,
											"attLocation" : attLocation,
											"attDate" : attDate,
											"var_EmployeeId" : var_EmployeeId,
											"var_EmployeeStatus" : var_EmployeeStatus
										};
										$
												.ajax({
													type : 'POST',
													url : "manualAttendance.do?parameter=updateAttendanceDetails",
													data : datalist,
													async : false,
													success : function(response) {
														var result = $
																.parseJSON(response);

														var actualResult = result.jsonResponse;
														if (actualResult == 1) {
															$("#successdiv")
																	.text(
																			"Employee Attendance Updated Successfully");
															$('#errordiv')
																	.css(
																			{
																				'visibility' : 'visible'
																			});
															setTimeout(
																	"location.reload();",
																	2000);
														}
													}
												});

										return false;
									});

				});
function validations() {

	var bvalid = true;
	var groupName = $("#groupId").val();
	var locationName = $("#locationId").val();
	var employeeName = $("#employeeId").val();
	var employeedate = $("#reportDate").val();
	if (groupName == "") {

		$("#errordiv").text("Select Group");
		$('.error-box').css({
			'visibility' : 'visible'
		});

		bvalid = false;
	} else if (locationName == "") {

		$("#errordiv").text("Select Location");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid = false;

	} else if (employeeName == "") {
		$("#errordiv").text("Select Employee");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid = false;
	} else if (employeedate == "") {
		$("#errordiv").text("Select Date");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid = false;
	}

	return bvalid;
}