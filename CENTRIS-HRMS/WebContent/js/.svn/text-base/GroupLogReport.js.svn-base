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

function createSelBox(selectboxId, dataForOption) {
	var jsonkey = [];
	for (key in dataForOption[0]) {
		if (key.indexOf("Name") != -1 || key.indexOf("name") != -1) {
			jsonkey[1] = key;
		} else if (key.indexOf("id") != -1 || key.indexOf("code") != -1
				|| key.indexOf("Id") != -1) {

			jsonkey[0] = key;
		}
	}

	$(selectboxId).empty();
	var selectObject = $(selectboxId);
	var anOption = document.createElement("OPTION");
	anOption.setAttribute("value", "");
	anOption.text = "---Select Option---";
	selectObject.append(anOption);
	var anOptionAll = document.createElement("OPTION");
	anOptionAll.setAttribute("value", "%%");
	anOptionAll.text = "All";
	if (dataForOption.length > 0)
		selectObject.append(anOptionAll);
	for ( var i = 0; i < dataForOption.length; i++) {
		if (dataForOption[i][jsonkey[1]] != "") {
			var anOption = document.createElement("OPTION");
			if (selectboxId == ".empClassForAdmin"
					|| selectboxId == ".shiftClassForAdmin") {
				anOption.setAttribute("value", dataForOption[i][jsonkey[0]]);
			} else {
				anOption.setAttribute("value", dataForOption[i][jsonkey[0]]);
			}
			anOption.text = dataForOption[i][jsonkey[1]];
			selectObject.append(anOption);
		}
	}

}

function createSelectBox(selectboxId, dataForOption) {
	var jsonkey = [];
	for (key in dataForOption[0]) {
		if (key.indexOf("Name") != -1 || key.indexOf("name") != -1) {
			jsonkey[1] = key;
		} else if (key.indexOf("id") != -1 || key.indexOf("code") != -1
				|| key.indexOf("Id") != -1) {

			jsonkey[0] = key;
		}
	}

	$(selectboxId).empty();
	var selectObject = $(selectboxId);

	if (selectboxId != "#locationId") {
		var anOption = document.createElement("OPTION");
		anOption.setAttribute("value", "");
		anOption.text = "---Select Option---";
		selectObject.append(anOption);
		var anOptionAll = document.createElement("OPTION");
		anOptionAll.setAttribute("value", "%%");
		anOptionAll.text = "All";
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
			anOption.text = dataForOption[i][jsonkey[1]];
			selectObject.append(anOption);
		}
	}

}

$(document)
		.ready(
				function() {
					$('#detailedPdfId').hide();
					if ($('#tableId').find('table').length != 0) {
						$('#detailedPdfId').show();
					}
					$('#consolidatedPdfId').hide();
					if ($('#tableId').find('table').length != 0) {
						$('#consolidatedPdfId').show();
					}

					$('.accBody').css('display', 'none');
					$('.accBody:first').css('display', 'block');

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
					var result = callAjax(
							"adddesignation.do?parameter=getDesignationDetails",
							"");
					createSelectBox("#designationId", result.designationlist);
					/*
					 * $('#locationId') .change( function() { var sendLocation = {
					 * 'location' : $(this).val(), 'group' : $("#groupId").val() };
					 * 
					 * var result = callAjax(
					 * "shiftMaster.do?method=getShiftByLocation",
					 * sendLocation);
					 * 
					 * createSelectBox("#shiftId", result.shiftList); });
					 */

					/*
					 * $('#designationId') .change( function() { var locList =
					 * []; $('#locationId :selected').each(function(i,
					 * selected){ locList[i] = $(selected).val(); });
					 * 
					 * var sendParam = { 'designation' :
					 * $('#designationId').val(), 'group' : $("#groupId").val(),
					 * 'location' : locList.join(",") }; if($('#locationId
					 * :selected').val() != undefined &&
					 * $("#designationId").val()!=""){ var result =
					 * callAjax("consolidateDetailedMonthReport.do?parameter=getEmpDetailsByDesiWithMultipleLocation",sendParam);
					 * createSelectBox("#employeeId",result.empList); }
					 * 
					 * });
					 */
					$('#locationId,#designationId')
							.change(
									function() {
										var locList = [];
										$('#locationId :selected').each(
												function(i, selected) {
													locList[i] = $(selected)
															.val();
												});

										var senddata = {
											'designation' : $('#designationId')
													.val(),
											'group' : $("#groupId").val(),
											'location' : locList.join(",")
										};

										var result = callAjax(
												"consolidateDetailedMonthReport.do?parameter=getEmpDetailsByDesignation",
												senddata);

										createSelectBox("#employeeId",
												result.empList);
									});

					$('#groupLogReportId')
							.click(
									function() {
										var valid = validations();
										if (valid) {
											var locList = []; 
											$('#locationId :selected').each(function(i, selected){ 
												locList[i] = $(selected).val(); 
											});
											$("#MonthReport")
													.attr('action',
															'logReport.do?method=getGroupLogReportDetails&location='+locList.join(","));
											$('#methodNameId').val(
													'getGroupLogReportDetails');
											$("#MonthReport").submit();
										}
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
							/*
							 * var sendLocation = { 'location' :
							 * $('#hlocationId').val().trim(), 'group' :
							 * $("#hgroupId").val().trim() };
							 */
							var result = callAjax(
									"adddesignation.do?parameter=getDesignationDetails",
									"");
							createSelectBox("#designationId",
									result.designationlist);
							if ($('#hdesignation').val() != "") {

								var senddata = {
									'designation' : $("#hdesignation").val(),
									'group' : $("#hgroupId").val(),
									'location' : $('#hlocationId').val()
								};

								var result = callAjax(
										"consolidateDetailedMonthReport.do?parameter=getEmpDetailsByDesignation",
										senddata);
								createSelectBox("#employeeId", result.empList);
							}
						}

						$('#groupId [value=' + $('#hgroupId').val() + ']')
								.attr('selected', true);
						$(
								'#locationId [value="'
										+ $('#hlocationId').val().trim() + '"]')
								.attr('selected', true);
						$(
								'#designationId [value="'
										+ $('#hdesignation').val().trim()
										+ '"]').attr('selected', true);
						$(
								'#employeeId [value="'
										+ $('#hemployeeId').val().trim() + '"]')
								.attr('selected', true);
						$('#month [value=' + $('#hmonth').val() + ']').attr(
								'selected', true);
						$('#year [value=' + $('#hyear').val() + ']').attr(
								'selected', true);

					}

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
						$('div .accordHead:last-child', this).hide();
					});

					/*
					 * $('#downloadForthisDate') .click( function() {
					 * 
					 * var date_Val = $('span.accordHead') .text().trim();
					 * alert(date_Val); window.location.href =
					 * 'consolidateDetailedMonthReport.do?parameter=consolidatedMonthReport_forDay&employee=' +
					 * $("#hemployeeId").val() + ' &group=' +
					 * $("#hgroupId").val() + ' &location=' +
					 * $("#hlocationId").val() + ' &shift=' +
					 * $("#hshiftId").val() + ' &year=' +
					 * $('span.accordHead').text() .trim(); });
					 */

					$('.clickButton')
							.click(
									function() {
										var buttonObject = $(this);

										var trStatus = buttonObject.parents(
												'tr:first').next('tr.childTR')
												.css('display');

										if (trStatus != undefined
												&& trStatus != "none") {
											buttonObject.parents('tr:first')
													.next('tr.childTR').css(
															'display', 'none');
											buttonObject.find('input').val(
													"View");
											buttonObject.find('input').css(
													'background', '#1267E9');
											return false;
										} else {
											/*
											 * buttonObject.style.background =
											 * "#B8D1F8"; $(this).value='Hi';
											 */
											buttonObject.find('input').css(
													'background', '#B8D1F8');
											buttonObject.find('input').val(
													"Hide");
										}

										var loc_Code = $(this).parents(
												'tr:first').find('.locCode')
												.val();
										var loc_Name = $(this).find('input')
												.attr('id');
										var loc_Date = $(this).parents(
												'tr:first').find(
												'td.reportDate').text();

										var dataToSend = {
											"selectedLocationCode" : loc_Code,
											"selectedLocationDate" : loc_Date,
											"employee" : $("#hemployeeId")
													.val(),
											"group" : $("#hgroupId").val(),
											"location" : $("#hlocationId")
													.val(),
											"designation" : $("#hdesignation")
													.val(),
											"year" : $("#hyear").val(),
											"month" : $("#hmonth").val()
										};

										var tr = document.createElement("tr");
										tr.setAttribute("class", "childTR");
										var td = document.createElement("td");
										td.setAttribute("colspan", "5");
										td.setAttribute("width", "80%");
										var tableObject = document
												.createElement("table");

										var trh1 = document.createElement("tr");
										var tdh1 = document.createElement("td");
										tdh1.innerHTML = "Employee ID";
										tdh1.style.fontWeight = "900";
										tdh1.style.background = "#B8D1F8";

										var tdh2 = document.createElement("td");
										tdh2.innerHTML = "Employee Name";
										tdh2.style.fontWeight = "900";
										tdh2.style.background = "#B8D1F8";

										var tdh3 = document.createElement("td");
										tdh3.innerHTML = "In - Time";
										tdh3.style.fontWeight = "900";
										tdh3.style.background = "#B8D1F8";

										var tdh4 = document.createElement("td");
										tdh4.innerHTML = "Out - Time";
										tdh4.style.fontWeight = "900";
										tdh4.style.background = "#B8D1F8";

										var tdh5 = document.createElement("td");
										tdh5.innerHTML = "Total Hours";
										tdh5.style.fontWeight = "900";
										tdh5.style.background = "#B8D1F8";

										var tdh6 = document.createElement("td");
										tdh6.innerHTML = "Working Hours";
										tdh6.style.fontWeight = "900";
										tdh6.style.background = "#B8D1F8";

										var tdh7 = document.createElement("td");
										tdh7.innerHTML = "Late Hours";
										tdh7.style.fontWeight = "900";
										tdh7.style.background = "#B8D1F8";

										var tdh8 = document.createElement("td");
										tdh8.innerHTML = "Early Hours";
										tdh8.style.fontWeight = "900";
										tdh8.style.background = "#B8D1F8";

										var tdh9 = document.createElement("td");
										tdh9.innerHTML = "Status";
										tdh9.style.fontWeight = "900";
										tdh9.style.background = "#B8D1F8";

										trh1.appendChild(tdh1);
										trh1.appendChild(tdh2);
										trh1.appendChild(tdh3);
										trh1.appendChild(tdh4);
										trh1.appendChild(tdh5);
										trh1.appendChild(tdh6);
										trh1.appendChild(tdh7);
										trh1.appendChild(tdh8);
										trh1.appendChild(tdh9);
										tableObject.appendChild(trh1);

										td.appendChild(tableObject);
										tr.appendChild(td);

										buttonObject.parents('tr:first').after(
												tr);

										$
												.ajax({
													type : "POST",
													url : 'logReport.do?method=getLogDetailsForThisDate',
													data : dataToSend,
													async : false,
													success : function(data) {
														var result = $
																.parseJSON(data);
														for ( var j = 0; j < result.selectedDateLogReportList.length; j++) {
															var tr1 = document
																	.createElement("tr");
															var td1 = document
																	.createElement("td");
															td1.innerHTML = result.selectedDateLogReportList[j].rep_EmployeeId;
															var td2 = document
																	.createElement("td");
															td2.innerHTML = result.selectedDateLogReportList[j].rep_EmployeeName;
															var td3 = document
																	.createElement("td");
															td3.innerHTML = result.selectedDateLogReportList[j].rep_Intime;
															var td4 = document
																	.createElement("td");
															td4.innerHTML = result.selectedDateLogReportList[j].rep_Outtime;
															var td5 = document
																	.createElement("td");
															td5.innerHTML = result.selectedDateLogReportList[j].rep_totalHours;
															var td6 = document
																	.createElement("td");
															td6.innerHTML = result.selectedDateLogReportList[j].rep_WorkingHours;
															var td7 = document
																	.createElement("td");
															td7.innerHTML = result.selectedDateLogReportList[j].rep_lateHours;
															var td8 = document
																	.createElement("td");
															td8.innerHTML = result.selectedDateLogReportList[j].rep_earlyHours;
															var td9 = document
																	.createElement("td");
															td9.innerHTML = result.selectedDateLogReportList[j].rep_AttStatus;

															tr1
																	.appendChild(td1);
															tr1
																	.appendChild(td2);
															tr1
																	.appendChild(td3);
															tr1
																	.appendChild(td4);
															tr1
																	.appendChild(td5);
															tr1
																	.appendChild(td6);
															tr1
																	.appendChild(td7);
															tr1
																	.appendChild(td8);
															tr1
																	.appendChild(td9);
															tableObject
																	.appendChild(tr1);

															$('.txt1')
																	.text(
																			result.selectedDateLogReportList[j].rep_EmployeeId);

															$(this)
																	.parents(
																			'tr:first')
																	.closest(
																			"tr")
																	.after(
																			"<tr><td>"
																					+ result.selectedDateLogReportList[j].rep_EmployeeId
																					+ "</td><td>"
																					+ result.selectedDateLogReportList[j].rep_EmployeeId
																					+ "</td></tr>");
														}
													}

												});

										/*
										 * window.location.href =
										 * 'logReport.do?method=getLogDetailsForThisDate&employee=' +
										 * $("#hemployeeId").val() + ' &group=' +
										 * $("#hgroupId").val() + ' &location=' +
										 * $("#hlocationId").val() + ' &shift=' +
										 * $("#hshiftId").val() + ' &year=' +
										 * $("#hyear").val() + ' &month=' +
										 * $("#hmonth").val() + '
										 * &selectedLocation=' + loc_Code.trim() + '
										 * &selectedDate=' + loc_Date.trim();
										 */
									});

				});
function validations() {

	var bvalid = true;
	var groupName = $("#groupId").val();
	var desigName = $("#designationId").val();
	var employeeName = $("#employeeId").val();
	var month = $("#month").val();
	var year = $("#year").val();

	if (groupName == "") {

		$("#errordiv").text("Select Group");
		$('.error-box').css({
			'visibility' : 'visible'
		});

		bvalid = false;
	} else if ($('#locationId :selected').val() == undefined) {

		$("#errordiv").text("Select Location");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid = false;

	} else if (desigName == "") {

		$("#errordiv").text("Select Designation");
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
	}

	else if (month == "") {
		$("#errordiv").text("Select Month");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid = false;
	} else if (year == "") {
		$("#errordiv").text("Select Year");
		$('.error-box').css({
			'visibility' : 'visible'
		});
		bvalid = false;
	}
	return bvalid;
}